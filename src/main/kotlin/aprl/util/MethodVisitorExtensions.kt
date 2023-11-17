package aprl.util

import aprl.compiler.ERROR
import aprl.compiler.WARNING
import aprl.ir.*
import aprl.lang.OperatorFunction
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import java.lang.reflect.Method

/**
 * Returns the next largest integer if the list is complete (i.e. every n < max(list) has an m > n)
 * or the first missing element if it is not.
 *
 * listOf(1,2,3,4,5).nextOrMissing() == 6
 * listOf(1,3,5).nextOrMissing() == 2
 */
fun List<Int>.nextOrMissing(): Int {
    val max = maxOrNull() ?: return 0 // Empty list => first missing element is 1
    for (i in 1..<max) {
        if (i !in this) {
            // First missing element
            return i
        }
    }
    // If every integer in `i..<max` is present, return next largest integer
    return max + 1
}

private var leftType: Class<*>? = null
private var rightType: Class<*>? = null

private fun MethodVisitor.visitExpressionTreeNode(node: AprlEvaluable, localVariables: LocalVariables) {
    when (node) {
        is AprlOperator -> {
            // TODO: check for #Verbatim annotation, don't replace operators if annotation is present
            var functionExists = false
            for (method in leftType!!.methods.filter { it.name == node.functionName }) {
                // find function that matches given rhs type and is annotated with #OperatorFunction
                if (method.parameterTypes[0] == rightType && OperatorFunction() in method.annotations) {
                    val returnType = Type.getType(method.returnType).descriptor
                    visitMethodInsn(INVOKEVIRTUAL, leftType!!.name.replace(".", "/"), node.functionName, "(${Type.getType(rightType).descriptor})$returnType", false)
                    leftType = method.returnType
                    functionExists = true
                    break
                }
            }
            if (!functionExists) {
                // no operator function found
                ERROR("Operation '${node.operatorSymbol}' is not defined on types '${leftType!!.simpleName}' and '${rightType!!.simpleName}'")
            }
            // rightType must be made available for next expression
            rightType = null
        }
        is AprlLiteral<*> -> {
            visitWrapperInitialization(node.value, node.internalType)
        }
        is AprlIdentifier -> {
            // TODO: check if variable has been initialized
            val localVariable = localVariables["$node"]
            if (localVariable != null) {
                visitVarInsn(ALOAD, localVariable.index)
                if (leftType == null) {
                    leftType = localVariable.type
                } else if (rightType == null) {
                    rightType = localVariable.type
                }
            } else {
                ERROR("Unresolved reference '$node'")
            }
        }
    }
}

fun <T: Any> MethodVisitor.visitWrapperInitialization(value: T?, type: Class<out T>) {
    // Name of the wrapper class, e.g. `aprl/lang/Int`
    val internalName = Type.getType(type).internalName
    visitTypeInsn(NEW, internalName)
    visitInsn(DUP)
    if (value != null) {
        visitLdcInsn(value)
    } else {
        visitInsn(ACONST_NULL)
    }
    val representedType = Type.getType(value?.javaClass ?: Any::class.java).descriptor
    val primitiveType = when (representedType) {
        "Ljava/lang/Boolean;" -> "Z"
        "Ljava/lang/Long;" -> "J"
        "Ljava/lang/Double;" -> "D"
        "Ljava/lang/Character;" -> "C"
        else -> null
    }
    visitMethodInsn(INVOKESPECIAL, internalName, "<init>", "(${primitiveType ?: representedType})V", false)
    if (leftType == null) {
        leftType = type
    } else if (rightType == null) {
        rightType = type
    }
}

fun MethodVisitor.visitAprlVariableDeclaration(declaration: AprlVariableDeclaration, localVariables: LocalVariables) {
    var variableType = declaration.typeAnnotation?.javaType
    val expressionTree = declaration.expression?.toTree()
    if (expressionTree != null) {
        expressionTree.optimize()
        expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
            visitExpressionTreeNode(it, localVariables)
        }
    } else {
        visitWrapperInitialization(variableType?.defaultValue, variableType!!)
    }
    variableType = variableType ?: leftType!!
    val index: Int
    if (declaration.identifier!! in localVariables.keys) {
        index = localVariables[declaration.identifier]!!.index
        ERROR("Redeclaration of '${declaration.identifier}'")
    } else {
        index = localVariables.values.map { it.index }.nextOrMissing()
        val isMutable = declaration.variableClassifier != VariableClassifier.VAL
        localVariables[declaration.identifier!!] = LocalVariable(index, isMutable, variableType)
    }
    if (!variableType.isAssignableFrom(leftType ?: variableType)) {
        // no direct assignment possible => conversion required
        val conversionFunctionName = "to${variableType.simpleName}"
        var bestConversionFunctionMatch: Method? = null
        for (method in leftType!!.methods.filter { it.name == conversionFunctionName }) {
            // find conversion function with no parameters and matching return type
            if (method.parameters.isEmpty() && variableType.isAssignableFrom(method.returnType)) {
                if (bestConversionFunctionMatch?.returnType?.isAssignableFrom(method.returnType) != false) {
                    // current method is better if best match is null or current return type is more precise
                    bestConversionFunctionMatch = method
                }
            }
        }
        if (bestConversionFunctionMatch == null) {
            ERROR("Type '${leftType!!.simpleName}' cannot be implicitly converted to '${variableType.simpleName}' (No function '${leftType!!.simpleName}.${conversionFunctionName}() -> ${variableType.simpleName}')")
        } else {
            visitMethodInsn(INVOKEVIRTUAL, Type.getType(leftType!!).internalName, conversionFunctionName, "()${Type.getType(bestConversionFunctionMatch.returnType).descriptor}", false)
            WARNING("Implicit conversion from '${leftType!!.simpleName}' to '${variableType.simpleName}'")
        }
    }
    visitVarInsn(ASTORE, index)
    leftType = rightType
    rightType = null
}

fun MethodVisitor.visitAprlVariableAssignment(assignment: AprlVariableAssignment, localVariables: LocalVariables) {
    val expressionTree = assignment.expression!!.toTree()
    expressionTree.optimize()
    if (assignment.identifier!! !in localVariables.keys) {
        ERROR("Unresolved reference '${assignment.identifier}'")
    } else {
        val localVariable = localVariables[assignment.identifier]!!
        if (!localVariable.isMutable) {
            // Variable cannot be reassigned
            ERROR("'${assignment.identifier}' is immutable")
        }
        expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
            visitExpressionTreeNode(it, localVariables)
        }
        if (leftType?.let { localVariable.type.isAssignableFrom(it) } != true) {
            ERROR("Type mismatch: Inferred type is '${leftType!!.simpleName}' but '${localVariable.type.simpleName}' was expected")
        }
        visitVarInsn(ASTORE, localVariable.index)
        leftType = rightType
        rightType = null
    }
}
