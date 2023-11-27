package aprl.compiler

import aprl.ir.*
import aprl.grammar.*
import aprl.ir.expressions.*
import aprl.ir.operators.*
import org.antlr.v4.runtime.*
import org.antlr.v4.gui.Trees
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.util.*

class AprlIRCompiler(private val settings: AprlCompilerSettings) : AprlParserBaseListener() {
    
    private val ir = AprlIR()
    
    private val currentFunctionDeclarations = Stack<AprlFunctionDeclaration>()
    private val currentFunctionArguments = Stack<AprlFunctionArgument>()
    private val currentFunctionBodies = Stack<AprlFunctionBody>()
    
    private val currentVariableDeclarations = Stack<AprlVariableDeclaration>()
    private val currentVariableAssignments = Stack<AprlVariableAssignment>()
    
    private val currentReturnStatements = Stack<AprlReturnStatement>()
    
    private val currentExpressions = Stack<AprlExpression>()
    private val currentDisjunctionExpressions = Stack<AprlDisjunctionExpression>()
    private val currentConjunctionExpressions = Stack<AprlConjunctionExpression>()
    private val currentComparisonExpressions = Stack<AprlComparisonExpression>()
    private val currentBitwiseExpressions = Stack<AprlBitwiseExpression>()
    private val currentAdditiveExpressions = Stack<AprlAdditiveExpression>()
    private val currentMultiplicativeExpressions = Stack<AprlMultiplicativeExpression>()
    private val currentExponentialExpressions = Stack<AprlExponentialExpression>()
    private val currentAtomicExpressions = Stack<AprlAtomicExpression>()
    
    private val currentTypeReferences = Stack<AprlTypeReference>()
    
    private val currentIdentifiers = Stack<AprlIdentifier>()
    
    override fun enterFunctionDeclaration(ctx: AprlParser.FunctionDeclarationContext) {
        currentFunctionDeclarations.add(AprlFunctionDeclaration(null, mutableListOf(), null, null, ctx))
    }
    
    override fun enterFunctionArgument(ctx: AprlParser.FunctionArgumentContext) {
        currentFunctionArguments.add(AprlFunctionArgument(null, null, ctx))
    }
    
    override fun enterFunctionBody(ctx: AprlParser.FunctionBodyContext) {
        currentFunctionBodies.add(AprlFunctionBody(mutableListOf(), ctx))
    }
    
    override fun enterVariableDeclaration(ctx: AprlParser.VariableDeclarationContext) {
        val variableClassifier = VariableClassifier.fromNode(ctx.variableClassifier())
        currentVariableDeclarations.push(AprlVariableDeclaration(variableClassifier, null, null, null, ctx))
    }
    
    override fun enterVariableAssignment(ctx: AprlParser.VariableAssignmentContext) {
        currentVariableAssignments.push(AprlVariableAssignment(null, null, ctx))
    }
    
    override fun enterReturnStatement(ctx: AprlParser.ReturnStatementContext) {
        currentReturnStatements.push(AprlReturnStatement(null, ctx))
    }
    
    override fun enterExpression(ctx: AprlParser.ExpressionContext) {
        currentExpressions.push(AprlExpression(null, ctx))
    }
    
    override fun enterDisjunctionExpression(ctx: AprlParser.DisjunctionExpressionContext) {
        currentDisjunctionExpressions.push(AprlDisjunctionExpression(null, null, null, ctx))
    }
    
    override fun enterConjunctionExpression(ctx: AprlParser.ConjunctionExpressionContext) {
        currentConjunctionExpressions.push(AprlConjunctionExpression(null, null, null, ctx))
    }
    
    override fun enterComparisonExpression(ctx: AprlParser.ComparisonExpressionContext) {
        currentComparisonExpressions.push(AprlComparisonExpression(null, null, null, ctx))
    }
    
    override fun enterBitwiseExpression(ctx: AprlParser.BitwiseExpressionContext) {
        // Initialize empty bitwise expression, assign corresponding operator if present
        val bitwiseOperator = ctx.bitwiseOperator()?.let {
            AprlBitwiseOperator.fromNode(it)
        }
        currentBitwiseExpressions.push(AprlBitwiseExpression(null, bitwiseOperator, null, ctx))
    }
    
    override fun enterAdditiveExpression(ctx: AprlParser.AdditiveExpressionContext) {
        // Initialize empty additive expression, assign corresponding operator if present
        val additiveOperator = ctx.additiveOperator()?.let {
            AprlAdditiveOperator.fromNode(it)
        }
        currentAdditiveExpressions.push(AprlAdditiveExpression(null, additiveOperator, null, ctx))
    }
    
    override fun enterMultiplicativeExpression(ctx: AprlParser.MultiplicativeExpressionContext) {
        // Initialize empty multiplicative expression, assign corresponding operator if present
        val multiplicativeOperator = ctx.multiplicativeOperator()?.let {
            AprlMultiplicativeOperator.fromNode(it)
        }
        currentMultiplicativeExpressions.push(AprlMultiplicativeExpression(null, multiplicativeOperator, null, ctx))
    }
    
    override fun enterExponentialExpression(ctx: AprlParser.ExponentialExpressionContext) {
        // Initialize empty exponential expression, assign corresponding operator if present
        val exponentialOperator = ctx.exponentialOperator()?.let {
            AprlExponentialOperator.fromNode(it)
        }
        currentExponentialExpressions.push(AprlExponentialExpression(null, exponentialOperator, null, ctx))
    }
    
    override fun enterAtomicExpression(ctx: AprlParser.AtomicExpressionContext) {
        // Initialize atomic expression
        currentAtomicExpressions.push(AprlAtomicExpression(null, null, null, ctx))
    }
    
    override fun enterType(ctx: AprlParser.TypeContext) {
        currentTypeReferences.push(AprlTypeReference(null, ctx))
    }
    
    override fun enterIdentifier(ctx: AprlParser.IdentifierContext) {
        currentIdentifiers.push(AprlIdentifier(context = ctx))
    }
    
    override fun exitFunctionDeclaration(ctx: AprlParser.FunctionDeclarationContext) {
        ir.statements.add(currentFunctionDeclarations.pop())
    }
    
    override fun exitFunctionArgument(ctx: AprlParser.FunctionArgumentContext) {
        val argument = currentFunctionArguments.pop()
        if (currentFunctionDeclarations.isNotEmpty()) {
            currentFunctionDeclarations.peek().arguments.add(argument)
        }
    }
    
    override fun exitFunctionBody(ctx: AprlParser.FunctionBodyContext) {
        val functionBody = currentFunctionBodies.pop()
        if (currentFunctionDeclarations.isNotEmpty()) {
            currentFunctionDeclarations.peek().functionBody = functionBody
        }
    }
    
    override fun exitVariableDeclaration(ctx: AprlParser.VariableDeclarationContext) {
        val variableDeclaration = currentVariableDeclarations.pop()
        if (currentFunctionBodies.isNotEmpty()) {
            currentFunctionBodies.peek().statements.add(variableDeclaration)
        } else {
            ir.statements.add(variableDeclaration)
        }
    }
    
    override fun exitVariableAssignment(ctx: AprlParser.VariableAssignmentContext) {
        // Take assignment off stack, it should be initialized and handled by now
        val variableAssignment = currentVariableAssignments.pop()
        if (currentFunctionBodies.isNotEmpty()) {
            currentFunctionBodies.peek().statements.add(variableAssignment)
        }
    }
    
    override fun exitReturnStatement(ctx: AprlParser.ReturnStatementContext) {
        val returnStatement = currentReturnStatements.pop()
        if (currentFunctionBodies.isNotEmpty()) {
            currentFunctionBodies.peek().statements.add(returnStatement)
        }
    }
    
    override fun exitExpression(ctx: AprlParser.ExpressionContext) {
        // Take expression off the stack, it should be initialized and handled by now
        val expression = currentExpressions.pop()
        // Empty expressions stack => expression must be part of variable assignment
        if (currentExpressions.isNotEmpty()) {
            // Non-empty expressions stack => this expression was part of another expression
            if (currentAtomicExpressions.isNotEmpty()) {
                // Non-empty atomic expressions stack => this expression was a parenthesized expression in an atomic expression
                currentAtomicExpressions.peek().parenthesizedExpression = expression
            } else {
                // Empty atomic expressions stack => this expression was a standalone parenthesized expression
                // This means its parent evaluates to itself, therefore the parent expression can be replaced
                currentExpressions.pop()
                currentExpressions.push(expression)
            }
        } else if (currentVariableDeclarations.isNotEmpty()) {
            currentVariableDeclarations.peek().expression = expression
        } else if (currentVariableAssignments.isNotEmpty()) {
            currentVariableAssignments.peek().expression = expression
        } else if (currentReturnStatements.isNotEmpty()) {
            currentReturnStatements.peek().expression = expression
        }
    }
    
    override fun exitDisjunctionExpression(ctx: AprlParser.DisjunctionExpressionContext) {
        // Take disjunction expression off the stack, it should be initialized and handled by now
        val disjunctionExpression = currentDisjunctionExpressions.pop()
        if (currentDisjunctionExpressions.isNotEmpty() && currentDisjunctionExpressions.size > currentAtomicExpressions.size) {
            // Parent disjunction expression is present => set this one as its child
            currentDisjunctionExpressions.peek().disjunctionExpression = disjunctionExpression
        } else {
            // No parent disjunction expression => parent is general expression
            currentExpressions.peek().disjunctionExpression = disjunctionExpression
        }
    }
    
    override fun exitDisjunctionOperator(ctx: AprlParser.DisjunctionOperatorContext) {
        if (currentDisjunctionExpressions.isNotEmpty()) {
            currentDisjunctionExpressions.peek().disjunctionOperator = AprlDisjunctionOperator(ctx)
        }
    }
    
    override fun exitConjunctionExpression(ctx: AprlParser.ConjunctionExpressionContext) {
        // Take conjunction expression off the stack, it should be initialized and handled by now
        val conjunctionExpression = currentConjunctionExpressions.pop()
        if (currentConjunctionExpressions.isNotEmpty() && currentConjunctionExpressions.size > currentAtomicExpressions.size) {
            // Parent conjunction expression is present => set this one as its child
            currentConjunctionExpressions.peek().conjunctionExpression = conjunctionExpression
        } else {
            // No parent conjunction expression => parent is disjunction expression
            currentDisjunctionExpressions.peek().conjunctionExpression = conjunctionExpression
        }
    }
    
    override fun exitConjunctionOperator(ctx: AprlParser.ConjunctionOperatorContext) {
        currentConjunctionExpressions.peek().conjunctionOperator = AprlConjunctionOperator(ctx)
    }
    
    override fun exitComparisonExpression(ctx: AprlParser.ComparisonExpressionContext) {
        // Take comparison expression off the stack, it should be initialized and handled by now
        val comparisonExpression = currentComparisonExpressions.pop()
        if (currentComparisonExpressions.isNotEmpty() && currentComparisonExpressions.size > currentAtomicExpressions.size) {
            // Parent comparison expression is present => set this one as its child
            currentComparisonExpressions.peek().comparisonExpression = comparisonExpression
        } else {
            // No parent comparison expression => parent is conjunction expression
            currentConjunctionExpressions.peek().comparisonExpression = comparisonExpression
        }
    }
    
    override fun exitComparisonOperator(ctx: AprlParser.ComparisonOperatorContext) {
        if (currentComparisonExpressions.isNotEmpty()) {
            currentComparisonExpressions.peek().comparisonOperator = AprlComparisonOperator.fromNode(ctx)
        }
    }
    
    override fun exitBitwiseExpression(ctx: AprlParser.BitwiseExpressionContext) {
        // Take bitwise expression off the stack, it should be initialized and handled by now
        val bitwiseExpression = currentBitwiseExpressions.pop()
        if (currentBitwiseExpressions.isNotEmpty() && currentBitwiseExpressions.size > currentAtomicExpressions.size) {
            // Parent bitwise expression is present => set this one as its child
            currentBitwiseExpressions.peek().bitwiseExpression = bitwiseExpression
        } else {
            // No parent bitwise expression => parent is comparison expression
            currentComparisonExpressions.peek().bitwiseExpression = bitwiseExpression
        }
    }
    
    override fun exitAdditiveExpression(ctx: AprlParser.AdditiveExpressionContext) {
        // Take additive expression off the stack, it should be initialized and handled by now
        val additiveExpression = currentAdditiveExpressions.pop()
        if (currentAdditiveExpressions.isNotEmpty() && currentAdditiveExpressions.size > currentAtomicExpressions.size) {
            // Parent additive expression is present => set this one as its child
            currentAdditiveExpressions.peek().additiveExpression = additiveExpression
        } else {
            // No parent additive expression => parent is bitwise expression
            currentBitwiseExpressions.peek().additiveExpression = additiveExpression
        }
    }
    
    override fun exitMultiplicativeExpression(ctx: AprlParser.MultiplicativeExpressionContext) {
        val multiplicativeExpression = currentMultiplicativeExpressions.pop()
        if (currentMultiplicativeExpressions.isNotEmpty() && currentMultiplicativeExpressions.size > currentAtomicExpressions.size) {
            // Parent multiplicative expression is present => set this one as its child
            currentMultiplicativeExpressions.peek().multiplicativeExpression = multiplicativeExpression
        } else {
            // No parent multiplicative expression => parent is additive expression
            currentAdditiveExpressions.peek().multiplicativeExpression = multiplicativeExpression
        }
    }
    
    override fun exitExponentialExpression(ctx: AprlParser.ExponentialExpressionContext) {
        val exponentialExpression = currentExponentialExpressions.pop()
        if (currentExponentialExpressions.isNotEmpty() && currentExponentialExpressions.size > currentAtomicExpressions.size) {
            // Parent exponential expression is present => set this one as its child
            currentExponentialExpressions.peek().exponentialExpression = exponentialExpression
        } else {
            // No parent exponential expression => parent is bitwise expression
            currentMultiplicativeExpressions.peek().exponentialExpression = exponentialExpression
        }
    }
    
    override fun exitAtomicExpression(ctx: AprlParser.AtomicExpressionContext) {
        val atomicExpression = currentAtomicExpressions.pop()
        if (currentExponentialExpressions.isNotEmpty()) {
            currentExponentialExpressions.peek().atomicExpression = atomicExpression
        }
    }
    
    override fun exitType(ctx: AprlParser.TypeContext) {
        val typeReference = currentTypeReferences.pop()
        if (currentFunctionArguments.isNotEmpty()) {
            currentFunctionArguments.peek().type = typeReference
        } else if (currentFunctionDeclarations.isNotEmpty()) {
            currentFunctionDeclarations.peek().returnType = typeReference
        } else if (currentVariableDeclarations.isNotEmpty()) {
            currentVariableDeclarations.peek().typeAnnotation = typeReference
        }
    }
    
    override fun exitIdentifier(ctx: AprlParser.IdentifierContext) {
        val identifier = currentIdentifiers.pop()
        if (currentAtomicExpressions.isNotEmpty()) {
            // Identifier as atomic expression
            currentAtomicExpressions.peek().identifier = identifier
        } else if (currentTypeReferences.isNotEmpty()) {
            // Identifier as type reference
            currentTypeReferences.peek().identifier = identifier
        }
    }
    
    override fun exitSimpleIdentifier(ctx: AprlParser.SimpleIdentifierContext) {
        val sizes = listOf(currentIdentifiers, currentFunctionDeclarations, currentFunctionArguments, currentVariableDeclarations, currentVariableAssignments).map { it.size }
        if (currentIdentifiers.size >= sizes.max()) {
            // Identifier stack not empty => simple identifier is part of parent identifier
            currentIdentifiers.peek().identifiers.add(ctx.text)
        } else if (currentFunctionArguments.size >= sizes.max()) {
            currentFunctionArguments.peek().name = ctx.text
        } else if (currentVariableDeclarations.size >= sizes.max()) {
            currentVariableDeclarations.peek().identifier = ctx.text
        } else if (currentVariableAssignments.size >= sizes.max()) {
            currentVariableAssignments.peek().identifier = ctx.text
        } else if (currentFunctionDeclarations.size >= sizes.max()) {
            currentFunctionDeclarations.peek().name = ctx.text
        }
    }
    
    override fun exitLiteral(ctx: AprlParser.LiteralContext) {
        val literal = ctx.IntegerLiteral()?.text?.toLong()?.let { AprlIntegerLiteral(it, ctx) }
            ?: ctx.FloatLiteral()?.text?.toDouble()?.let { AprlFloatLiteral(it, ctx) }
            ?: ctx.booleanLiteral()?.text?.toBooleanStrictOrNull()?.let { AprlBooleanLiteral(it, ctx) }
            ?: ctx.StringLiteral()?.text?.let { it.substring(1, it.length - 1) }?.let { AprlStringLiteral(it, ctx) }
            ?: ctx.CharLiteral()?.text?.get(1)?.let { AprlCharLiteral(it, ctx) }
        currentAtomicExpressions.peek().literal = literal
    }
    
    fun compile(source: String): AprlIR {
        val lexer = AprlLexer(CharStreams.fromString(source))
        val tokens = CommonTokenStream(lexer)
        val parser = AprlParser(tokens)
        val tree = parser.aprlFile()
        
        val walker = ParseTreeWalker()
        walker.walk(this, tree)
        if (settings.inspectAST) {
            Trees.inspect(tree, parser)
        }
        if (settings.printIR) {
            println(ir)
        }
        return ir
    }
    
}
