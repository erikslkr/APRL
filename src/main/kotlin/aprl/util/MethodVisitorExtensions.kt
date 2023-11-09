package aprl.util

import aprl.compiler.ERROR
import aprl.ir.*
import aprl.lang.OperatorFunction
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type

/**
 * Returns the next largest integer if the list is complete (i.e. every n < max(list) has an m > n)
 * or the first missing element if it is not.
 *
 * listOf(1,2,3,4,5).nextOrMissing() == 6
 * listOf(1,3,5).nextOrMissing() == 2
 */
fun List<Int>.nextOrMissing(): Int {
    // Find the maximum element in the list
    val max = maxOrNull() ?: return 1 // Empty list => first missing element is 1
    
    for (i in 1..<max) {
        // Check for missing elements
        if (i !in this) {
            // Return first missing element
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
        is AprlIntegerLiteral -> {
            visitTypeInsn(NEW, "aprl/lang/Int")
            visitInsn(DUP)
            visitLdcInsn(node.value.toLong())
            visitMethodInsn(INVOKESPECIAL, "aprl/lang/Int", "<init>", "(J)V", false)
            if (leftType == null) {
                leftType = aprl.lang.Int::class.java
            } else if (rightType == null) {
                rightType = aprl.lang.Int::class.java
            }
        }
        is AprlFloatLiteral -> {
            visitTypeInsn(NEW, "aprl/lang/Float")
            visitInsn(DUP)
            visitLdcInsn(node.value)
            visitMethodInsn(INVOKESPECIAL, "aprl/lang/Float", "<init>", "(D)V", false)
            if (leftType == null) {
                leftType = aprl.lang.Float::class.java
            } else if (rightType == null) {
                rightType = aprl.lang.Float::class.java
            }
        }
        is AprlIdentifier -> {
            val localVariable = localVariables["$node"]
            if (localVariable != null) {
                visitVarInsn(ALOAD, localVariable.index)
                if (leftType == null) {
                    leftType = localVariable.type
                } else if (rightType == null) {
                    rightType = localVariable.type
                }
            } else {
                // TODO: $it could still refer to ...instance variable ...static field (perhaps some other case)
                // If not => ERROR(Unresolved reference '$it')
            }
        }
    }
}

fun MethodVisitor.visitAprlVariableDeclaration(declaration: AprlVariableDeclaration, localVariables: LocalVariables) {
    val assignment = declaration.variableAssignment!!
    val expressionTree = assignment.expression!!.toTree()
    expressionTree.optimize()
    // TODO [IMPORTANT]: $assignment.identifier could also refer to instance variables, global variables, etc.
    expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
        visitExpressionTreeNode(it, localVariables)
    }
    val index: Int
    if (assignment.identifier!! in localVariables.keys) {
        index = localVariables[assignment.identifier]!!.index
        ERROR("Redeclaration of '${assignment.identifier}'")
    } else {
        index = localVariables.values.map { it.index }.nextOrMissing()
        val isMutable = declaration.variableClassifier != VariableClassifier.VAL
        val variableType = leftType ?: Any::class.java
        localVariables[assignment.identifier!!] = LocalVariable(index, isMutable, variableType)
    }
    visitVarInsn(ASTORE, index)
}

fun MethodVisitor.visitAprlVariableAssignment(assignment: AprlVariableAssignment, localVariables: LocalVariables) {
    val expressionTree = assignment.expression!!.toTree()
    expressionTree.optimize()
    // TODO [IMPORTANT]: $assignment.identifier could also refer to instance variables, global variables, etc.
    if (assignment.identifier!! !in localVariables.keys) {
        ERROR("Unresolved reference '${assignment.identifier}'")
    } else {
        if (!localVariables[assignment.identifier]!!.isMutable) {
            // Variable cannot be reassigned
            ERROR("'${assignment.identifier}' is immutable")
        }
        expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
            visitExpressionTreeNode(it, localVariables)
        }
        visitVarInsn(ASTORE, localVariables[assignment.identifier]!!.index)
    }
}
