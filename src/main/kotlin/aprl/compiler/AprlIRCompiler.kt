package aprl.compiler

import aprl.ir.*
import aprl.grammar.*
import aprl.grammar.AprlParser.*
import aprl.ir.expressions.*
import aprl.ir.operators.*
import org.antlr.v4.runtime.*
import org.antlr.v4.gui.Trees
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.util.*

class AprlIRCompiler(private val settings: AprlCompilerSettings) : AprlParserBaseListener() {
    
    private val ir = AprlFile()
    
    private val currentFunctionDeclarations = Stack<AprlFunctionDeclaration>()
    private val currentValueParameters = Stack<AprlValueParameter>()
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
    private val currentUnaryPrefixedExpressions = Stack<AprlUnaryPrefixedExpression>()
    private val currentExponentialExpressions = Stack<AprlExponentialExpression>()
    private val currentUnaryPostfixedExpressions = Stack<AprlUnaryPostfixedExpression>()
    private val currentAtomicExpressions = Stack<AprlAtomicExpression>()
    
    private val currentValueArguments = Stack<AprlValueArguments>()
    private val currentValueArgumentsArguments = Stack<AprlValueArgument>()
    
    private val currentTypeReferences = Stack<AprlTypeReference>()
    
    private val currentIdentifiers = Stack<AprlIdentifier>()
    
    override fun enterFunctionDeclaration(ctx: FunctionDeclarationContext) {
        currentFunctionDeclarations.add(AprlFunctionDeclaration(null, mutableListOf(), null, null, ctx))
    }
    
    override fun enterValueParameter(ctx: ValueParameterContext) {
        currentValueParameters.add(AprlValueParameter(null, null, ctx))
    }
    
    override fun enterFunctionBody(ctx: FunctionBodyContext) {
        currentFunctionBodies.add(AprlFunctionBody(mutableListOf(), ctx))
    }
    
    override fun enterVariableDeclaration(ctx: VariableDeclarationContext) {
        val variableClassifier = VariableClassifier.fromNode(ctx.variableClassifier())
        currentVariableDeclarations.push(AprlVariableDeclaration(variableClassifier, null, null, null, ctx))
    }
    
    override fun enterVariableAssignment(ctx: VariableAssignmentContext) {
        currentVariableAssignments.push(AprlVariableAssignment(null, null, ctx))
    }
    
    override fun enterReturnStatement(ctx: ReturnStatementContext) {
        currentReturnStatements.push(AprlReturnStatement(null, ctx))
    }
    
    override fun enterExpression(ctx: ExpressionContext) {
        currentExpressions.push(AprlExpression(null, ctx))
    }
    
    override fun enterDisjunctionExpression(ctx: DisjunctionExpressionContext) {
        currentDisjunctionExpressions.push(AprlDisjunctionExpression(null, null, null, ctx))
    }
    
    override fun enterConjunctionExpression(ctx: ConjunctionExpressionContext) {
        currentConjunctionExpressions.push(AprlConjunctionExpression(null, null, null, ctx))
    }
    
    override fun enterComparisonExpression(ctx: ComparisonExpressionContext) {
        currentComparisonExpressions.push(AprlComparisonExpression(null, null, null, ctx))
    }
    
    override fun enterBitwiseExpression(ctx: BitwiseExpressionContext) {
        val bitwiseOperator = ctx.bitwiseOperator()?.let {
            AprlBitwiseOperator.fromNode(it)
        }
        currentBitwiseExpressions.push(AprlBitwiseExpression(null, bitwiseOperator, null, ctx))
    }
    
    override fun enterAdditiveExpression(ctx: AdditiveExpressionContext) {
        val additiveOperator = ctx.additiveOperator()?.let {
            AprlAdditiveOperator.fromNode(it)
        }
        currentAdditiveExpressions.push(AprlAdditiveExpression(null, additiveOperator, null, ctx))
    }
    
    override fun enterMultiplicativeExpression(ctx: MultiplicativeExpressionContext) {
        val multiplicativeOperator = ctx.multiplicativeOperator()?.let {
            AprlMultiplicativeOperator.fromNode(it)
        }
        currentMultiplicativeExpressions.push(AprlMultiplicativeExpression(null, multiplicativeOperator, null, ctx))
    }
    
    override fun enterUnaryPrefixedExpression(ctx: UnaryPrefixedExpressionContext) {
        val unaryPrefix = ctx.unaryPrefix()?.let {
            AprlUnaryPrefixOperator.fromNode(it)
        }
        currentUnaryPrefixedExpressions.push(AprlUnaryPrefixedExpression(unaryPrefix, null, ctx))
    }
    
    override fun enterExponentialExpression(ctx: ExponentialExpressionContext) {
        val exponentialOperator = ctx.exponentialOperator()?.let {
            AprlExponentialOperator.fromNode(it)
        }
        currentExponentialExpressions.push(AprlExponentialExpression(null, exponentialOperator, null, ctx))
    }
    
    override fun enterUnaryPostfixedExpression(ctx: UnaryPostfixedExpressionContext) {
        currentUnaryPostfixedExpressions.push(AprlUnaryPostfixedExpression(null, null, null, ctx))
    }
    
    override fun enterValueArguments(ctx: ValueArgumentsContext) {
        currentValueArguments.push(AprlValueArguments(mutableListOf(), ctx))
    }
    
    override fun enterValueArgument(ctx: ValueArgumentContext) {
        currentValueArgumentsArguments.push(AprlValueArgument(null, ctx))
    }
    
    override fun enterAtomicExpression(ctx: AtomicExpressionContext) {
        currentAtomicExpressions.push(AprlAtomicExpression(null, null, null, ctx))
    }
    
    override fun enterType(ctx: TypeContext) {
        currentTypeReferences.push(AprlTypeReference(null, ctx))
    }
    
    override fun enterIdentifier(ctx: IdentifierContext) {
        currentIdentifiers.push(AprlIdentifier(context = ctx))
    }
    
    override fun exitFunctionDeclaration(ctx: FunctionDeclarationContext) {
        ir.globalStatements.add(currentFunctionDeclarations.pop())
    }
    
    override fun exitValueParameter(ctx: ValueParameterContext) {
        val argument = currentValueParameters.pop()
        currentFunctionDeclarations.peek().valueParameters.add(argument)
    }
    
    override fun exitFunctionBody(ctx: FunctionBodyContext) {
        val functionBody = currentFunctionBodies.pop()
        currentFunctionDeclarations.peek().functionBody = functionBody
    }
    
    override fun exitVariableDeclaration(ctx: VariableDeclarationContext) {
        val variableDeclaration = currentVariableDeclarations.pop()
        when (ctx.parent) {
            is LocalStatementContext -> {
                currentFunctionBodies.peek().statements.add(variableDeclaration)
            }
            is AprlFileContext -> {
                ir.globalStatements.add(variableDeclaration)
            }
        }
    }
    
    override fun exitVariableAssignment(ctx: VariableAssignmentContext) {
        val variableAssignment = currentVariableAssignments.pop()
        currentFunctionBodies.peek().statements.add(variableAssignment)
    }
    
    override fun exitReturnStatement(ctx: ReturnStatementContext) {
        val returnStatement = currentReturnStatements.pop()
        currentFunctionBodies.peek().statements.add(returnStatement)
    }
    
    override fun exitExpression(ctx: ExpressionContext) {
        val expression = currentExpressions.pop()
        when (ctx.parent) {
            is ParenthesizedExpressionContext -> {
                currentAtomicExpressions.peek().parenthesizedExpression = expression
            }
            is VariableDeclarationContext -> {
                currentVariableDeclarations.peek().expression = expression
            }
            is VariableAssignmentContext -> {
                currentVariableAssignments.peek().expression = expression
            }
            is ReturnStatementContext -> {
                currentReturnStatements.peek().expression = expression
            }
            is ValueArgumentContext -> {
                currentValueArgumentsArguments.peek().expression = expression
            }
        }
    }
    
    override fun exitDisjunctionExpression(ctx: DisjunctionExpressionContext) {
        val disjunctionExpression = currentDisjunctionExpressions.pop()
        when (ctx.parent) {
            is DisjunctionExpressionContext -> {
                currentDisjunctionExpressions.peek().disjunctionExpression = disjunctionExpression
            }
            is ExpressionContext -> {
                currentExpressions.peek().disjunctionExpression = disjunctionExpression
            }
        }
    }
    
    override fun exitDisjunctionOperator(ctx: DisjunctionOperatorContext) {
        if (currentDisjunctionExpressions.isNotEmpty()) {
            currentDisjunctionExpressions.peek().disjunctionOperator = AprlDisjunctionOperator(ctx)
        }
    }
    
    override fun exitConjunctionExpression(ctx: ConjunctionExpressionContext) {
        val conjunctionExpression = currentConjunctionExpressions.pop()
        when (ctx.parent) {
            is ConjunctionExpressionContext -> {
                currentConjunctionExpressions.peek().conjunctionExpression = conjunctionExpression
            }
            is DisjunctionExpressionContext -> {
                currentDisjunctionExpressions.peek().conjunctionExpression = conjunctionExpression
            }
        }
    }
    
    override fun exitConjunctionOperator(ctx: ConjunctionOperatorContext) {
        currentConjunctionExpressions.peek().conjunctionOperator = AprlConjunctionOperator(ctx)
    }
    
    override fun exitComparisonExpression(ctx: ComparisonExpressionContext) {
        val comparisonExpression = currentComparisonExpressions.pop()
        when (ctx.parent) {
            is ComparisonExpressionContext -> {
                currentComparisonExpressions.peek().comparisonExpression = comparisonExpression
            }
            is ConjunctionExpressionContext -> {
                currentConjunctionExpressions.peek().comparisonExpression = comparisonExpression
            }
        }
    }
    
    override fun exitComparisonOperator(ctx: ComparisonOperatorContext) {
        currentComparisonExpressions.peek().comparisonOperator = AprlComparisonOperator.fromNode(ctx)
    }
    
    override fun exitBitwiseExpression(ctx: BitwiseExpressionContext) {
        val bitwiseExpression = currentBitwiseExpressions.pop()
        when (ctx.parent) {
            is BitwiseExpressionContext -> {
                currentBitwiseExpressions.peek().bitwiseExpression = bitwiseExpression
            }
            is ComparisonExpressionContext -> {
                currentComparisonExpressions.peek().bitwiseExpression = bitwiseExpression
            }
        }
    }
    
    override fun exitAdditiveExpression(ctx: AdditiveExpressionContext) {
        val additiveExpression = currentAdditiveExpressions.pop()
        when (ctx.parent) {
            is AdditiveExpressionContext -> {
                currentAdditiveExpressions.peek().additiveExpression = additiveExpression
            }
            is BitwiseExpressionContext -> {
                currentBitwiseExpressions.peek().additiveExpression = additiveExpression
            }
        }
    }
    
    override fun exitMultiplicativeExpression(ctx: MultiplicativeExpressionContext) {
        val multiplicativeExpression = currentMultiplicativeExpressions.pop()
        when (ctx.parent) {
            is MultiplicativeExpressionContext -> {
                currentMultiplicativeExpressions.peek().multiplicativeExpression = multiplicativeExpression
            }
            is AdditiveExpressionContext -> {
                currentAdditiveExpressions.peek().multiplicativeExpression = multiplicativeExpression
            }
        }
    }
    
    override fun exitUnaryPrefixedExpression(ctx: UnaryPrefixedExpressionContext) {
        val unaryPrefixedExpression = currentUnaryPrefixedExpressions.pop()
        when (ctx.parent) {
            is MultiplicativeExpressionContext -> {
                currentMultiplicativeExpressions.peek().unaryPrefixedExpression = unaryPrefixedExpression
            }
        }
    }
    
    override fun exitExponentialExpression(ctx: ExponentialExpressionContext) {
        val exponentialExpression = currentExponentialExpressions.pop()
        when (ctx.parent) {
            is ExponentialExpressionContext -> {
                currentExponentialExpressions.peek().exponentialExpression = exponentialExpression
            }
            is UnaryPrefixedExpressionContext -> {
                currentUnaryPrefixedExpressions.peek().exponentialExpression = exponentialExpression
            }
        }
    }
    
    override fun exitUnaryPostfixedExpression(ctx: UnaryPostfixedExpressionContext) {
        val unaryPostfixedExpression = currentUnaryPostfixedExpressions.pop()
        when (ctx.parent) {
            is UnaryPostfixedExpressionContext -> {
                currentUnaryPostfixedExpressions.peek().unaryPostfixedExpression = unaryPostfixedExpression
            }
            is ExponentialExpressionContext -> {
                currentExponentialExpressions.peek().unaryPostfixedExpression = unaryPostfixedExpression
            }
        }
    }
    
    override fun exitValueArguments(ctx: ValueArgumentsContext) {
        val valueArguments = currentValueArguments.pop()
        when (ctx.parent.parent) {
            is UnaryPostfixedExpressionContext -> {
                currentUnaryPostfixedExpressions.peek().unaryPostfix = valueArguments
            }
        }
    }
    
    override fun exitValueArgument(ctx: ValueArgumentContext) {
        val valueArgument = currentValueArgumentsArguments.pop()
        when (ctx.parent) {
            is ValueArgumentsContext -> {
                currentValueArguments.peek().valueArguments.add(valueArgument)
            }
        }
    }
    
    override fun exitAtomicExpression(ctx: AtomicExpressionContext) {
        val atomicExpression = currentAtomicExpressions.pop()
        when (ctx.parent) {
            is UnaryPostfixedExpressionContext -> {
                currentUnaryPostfixedExpressions.peek().atomicExpression = atomicExpression
            }
        }
    }
    
    override fun exitType(ctx: TypeContext) {
        val typeReference = currentTypeReferences.pop()
        when (ctx.parent) {
            is ValueParameterContext -> {
                currentValueParameters.peek().type = typeReference
            }
            is FunctionDeclarationContext -> {
                currentFunctionDeclarations.peek().returnType = typeReference
            }
            is VariableDeclarationContext -> {
                currentVariableDeclarations.peek().typeAnnotation = typeReference
            }
        }
    }
    
    override fun exitIdentifier(ctx: IdentifierContext) {
        val identifier = currentIdentifiers.pop()
        when (ctx.parent) {
            is AtomicExpressionContext -> {
                currentAtomicExpressions.peek().identifier = identifier
            }
            is TypeContext -> {
                currentTypeReferences.peek().identifier = identifier
            }
        }
    }
    
    override fun exitSimpleIdentifier(ctx: SimpleIdentifierContext) {
        when (ctx.parent) {
            is IdentifierContext -> {
                currentIdentifiers.peek().identifiers.add(ctx.text)
            }
            is ValueParameterContext -> {
                currentValueParameters.peek().name = ctx.text
            }
            is VariableDeclarationContext -> {
                currentVariableDeclarations.peek().identifier = ctx.text
            }
            is VariableAssignmentContext -> {
                currentVariableAssignments.peek().identifier = ctx.text
            }
            is FunctionDeclarationContext -> {
                currentFunctionDeclarations.peek().name = ctx.text
            }
        }
    }
    
    override fun exitLiteral(ctx: LiteralContext) {
        val literal = ctx.IntegerLiteral()?.text?.toLong()?.let { AprlIntegerLiteral(it, ctx) }
            ?: ctx.FloatLiteral()?.text?.toDouble()?.let { AprlFloatLiteral(it, ctx) }
            ?: ctx.booleanLiteral()?.text?.toBooleanStrictOrNull()?.let { AprlBooleanLiteral(it, ctx) }
            ?: ctx.StringLiteral()?.text?.let { it.substring(1, it.length - 1) }?.let { AprlStringLiteral(it, ctx) }
            ?: ctx.CharLiteral()?.text?.get(1)?.let { AprlCharLiteral(it, ctx) }
        currentAtomicExpressions.peek().literal = literal
    }
    
    fun compile(source: String): AprlFile {
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
