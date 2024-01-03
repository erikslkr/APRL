// Generated from /home/erik/Documents/IdeaProjects/APRL/src/main/kotlin/aprl/grammar/AprlParser.g4 by ANTLR 4.13.1
package aprl.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AprlParser}.
 */
public interface AprlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AprlParser#aprlFile}.
	 * @param ctx the parse tree
	 */
	void enterAprlFile(AprlParser.AprlFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#aprlFile}.
	 * @param ctx the parse tree
	 */
	void exitAprlFile(AprlParser.AprlFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#globalStatement}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStatement(AprlParser.GlobalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#globalStatement}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStatement(AprlParser.GlobalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#localStatements}.
	 * @param ctx the parse tree
	 */
	void enterLocalStatements(AprlParser.LocalStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#localStatements}.
	 * @param ctx the parse tree
	 */
	void exitLocalStatements(AprlParser.LocalStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#localStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalStatement(AprlParser.LocalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#localStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalStatement(AprlParser.LocalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(AprlParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(AprlParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#visibilityModifier}.
	 * @param ctx the parse tree
	 */
	void enterVisibilityModifier(AprlParser.VisibilityModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#visibilityModifier}.
	 * @param ctx the parse tree
	 */
	void exitVisibilityModifier(AprlParser.VisibilityModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(AprlParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(AprlParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#variableClassifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableClassifier(AprlParser.VariableClassifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#variableClassifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableClassifier(AprlParser.VariableClassifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(AprlParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(AprlParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(AprlParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(AprlParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(AprlParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(AprlParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(AprlParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(AprlParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(AprlParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(AprlParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(AprlParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(AprlParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(AprlParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(AprlParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(AprlParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(AprlParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#valueParameters}.
	 * @param ctx the parse tree
	 */
	void enterValueParameters(AprlParser.ValueParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#valueParameters}.
	 * @param ctx the parse tree
	 */
	void exitValueParameters(AprlParser.ValueParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#valueParameter}.
	 * @param ctx the parse tree
	 */
	void enterValueParameter(AprlParser.ValueParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#valueParameter}.
	 * @param ctx the parse tree
	 */
	void exitValueParameter(AprlParser.ValueParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(AprlParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(AprlParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(AprlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(AprlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(AprlParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(AprlParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#disjunctionExpression}.
	 * @param ctx the parse tree
	 */
	void enterDisjunctionExpression(AprlParser.DisjunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#disjunctionExpression}.
	 * @param ctx the parse tree
	 */
	void exitDisjunctionExpression(AprlParser.DisjunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#disjunctionOperator}.
	 * @param ctx the parse tree
	 */
	void enterDisjunctionOperator(AprlParser.DisjunctionOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#disjunctionOperator}.
	 * @param ctx the parse tree
	 */
	void exitDisjunctionOperator(AprlParser.DisjunctionOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#conjunctionExpression}.
	 * @param ctx the parse tree
	 */
	void enterConjunctionExpression(AprlParser.ConjunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#conjunctionExpression}.
	 * @param ctx the parse tree
	 */
	void exitConjunctionExpression(AprlParser.ConjunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#conjunctionOperator}.
	 * @param ctx the parse tree
	 */
	void enterConjunctionOperator(AprlParser.ConjunctionOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#conjunctionOperator}.
	 * @param ctx the parse tree
	 */
	void exitConjunctionOperator(AprlParser.ConjunctionOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(AprlParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(AprlParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(AprlParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(AprlParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#bitwiseExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseExpression(AprlParser.BitwiseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#bitwiseExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseExpression(AprlParser.BitwiseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOperator(AprlParser.BitwiseOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOperator(AprlParser.BitwiseOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(AprlParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(AprlParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOperator(AprlParser.AdditiveOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOperator(AprlParser.AdditiveOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(AprlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(AprlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOperator(AprlParser.MultiplicativeOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOperator(AprlParser.MultiplicativeOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#unaryPrefixedExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPrefixedExpression(AprlParser.UnaryPrefixedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#unaryPrefixedExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPrefixedExpression(AprlParser.UnaryPrefixedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#unaryPrefix}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPrefix(AprlParser.UnaryPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#unaryPrefix}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPrefix(AprlParser.UnaryPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#exponentialExpression}.
	 * @param ctx the parse tree
	 */
	void enterExponentialExpression(AprlParser.ExponentialExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#exponentialExpression}.
	 * @param ctx the parse tree
	 */
	void exitExponentialExpression(AprlParser.ExponentialExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#exponentialOperator}.
	 * @param ctx the parse tree
	 */
	void enterExponentialOperator(AprlParser.ExponentialOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#exponentialOperator}.
	 * @param ctx the parse tree
	 */
	void exitExponentialOperator(AprlParser.ExponentialOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#unaryPostfixedExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPostfixedExpression(AprlParser.UnaryPostfixedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#unaryPostfixedExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPostfixedExpression(AprlParser.UnaryPostfixedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#unaryPostfix}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPostfix(AprlParser.UnaryPostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#unaryPostfix}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPostfix(AprlParser.UnaryPostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#valueArguments}.
	 * @param ctx the parse tree
	 */
	void enterValueArguments(AprlParser.ValueArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#valueArguments}.
	 * @param ctx the parse tree
	 */
	void exitValueArguments(AprlParser.ValueArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#valueArgument}.
	 * @param ctx the parse tree
	 */
	void enterValueArgument(AprlParser.ValueArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#valueArgument}.
	 * @param ctx the parse tree
	 */
	void exitValueArgument(AprlParser.ValueArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpression(AprlParser.AtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpression(AprlParser.AtomicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(AprlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(AprlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(AprlParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(AprlParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#typeReference}.
	 * @param ctx the parse tree
	 */
	void enterTypeReference(AprlParser.TypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#typeReference}.
	 * @param ctx the parse tree
	 */
	void exitTypeReference(AprlParser.TypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#listTypeReference}.
	 * @param ctx the parse tree
	 */
	void enterListTypeReference(AprlParser.ListTypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#listTypeReference}.
	 * @param ctx the parse tree
	 */
	void exitListTypeReference(AprlParser.ListTypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(AprlParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(AprlParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AprlParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleIdentifier(AprlParser.SimpleIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AprlParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleIdentifier(AprlParser.SimpleIdentifierContext ctx);
}