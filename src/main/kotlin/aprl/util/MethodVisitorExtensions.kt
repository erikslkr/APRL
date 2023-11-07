package aprl.util

import aprl.ERROR
import aprl.ir.*
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*

/**
 * Returns the next largest integer if the list is complete (i.e. every n < max(list) has an m > n)
 * or the first missing element if it is not.
 *
 * listOf(1,2,3,4,5).nextOrMissing() == 6
 * listOf(1,3,5).nextOrMissing() == 2
 */
fun List<Int>.nextOrMissing(): Int {
    // Find the maximum element in the list
    val max = maxOrNull() ?: return 0 // Empty list => first missing element is 0
    
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

private fun MethodVisitor.visitExpressionTreeNode(node: AprlEvaluable, localVariables: LocalVariables) {
    when (node) {
        is AprlOperator -> {
            val opcode = when (node) {
                AprlBitwiseOperator.AND -> IAND
                AprlBitwiseOperator.OR -> IOR
                AprlBitwiseOperator.XOR -> IXOR
                AprlBitwiseOperator.SHL -> ISHL
                AprlBitwiseOperator.SHR -> ISHR
                AprlBitwiseOperator.USHR -> IUSHR
                AprlAdditiveOperator.PLUS -> IADD
                AprlAdditiveOperator.MINUS -> ISUB
                AprlMultiplicativeOperator.MULTIPLY -> IMUL
                AprlMultiplicativeOperator.DIVIDE -> IDIV
                AprlMultiplicativeOperator.MODULO -> IREM
                else -> return
            }
            visitInsn(opcode)
        }
        is AprlIntegerLiteral -> {
            visitLdcInsn(node.value)
        }
        is AprlIdentifier -> {
            val localVariableIndex = localVariables["$node"]?.first
            if (localVariableIndex != null) {
                visitVarInsn(ILOAD, localVariableIndex)
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
    
    val index: Int
    if (assignment.identifier!! in localVariables.keys) {
        index = localVariables[assignment.identifier]!!.first
        ERROR("Redeclaration of '${assignment.identifier}'")
    } else {
        index = localVariables.values.map { it.first }.nextOrMissing()
        val isMutable = declaration.variableClassifier != VariableClassifier.VAL
        localVariables[assignment.identifier!!] = Pair(index, isMutable)
    }
    expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
        visitExpressionTreeNode(it, localVariables)
    }
    visitVarInsn(ISTORE, index)
}

fun MethodVisitor.visitAprlVariableAssignment(assignment: AprlVariableAssignment, localVariables: LocalVariables) {
    val expressionTree = assignment.expression!!.toTree()
    expressionTree.optimize()
    // TODO [IMPORTANT]: $assignment.identifier could also refer to instance variables, global variables, etc.
    if (assignment.identifier!! !in localVariables.keys) {
        ERROR("Unresolved reference '${assignment.identifier}'")
    } else {
        if (!localVariables[assignment.identifier]!!.second) {
            // False boolean in pair means that the variable is immutable
            ERROR("'${assignment.identifier}' is immutable")
        }
        expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
            visitExpressionTreeNode(it, localVariables)
        }
        visitVarInsn(ISTORE, localVariables[assignment.identifier]!!.first)
    }
}
