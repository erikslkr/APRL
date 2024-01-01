// Generated from /home/erik/Documents/IdeaProjects/APRL/src/main/kotlin/aprl/grammar/AprlParser.g4 by ANTLR 4.13.1
package aprl.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AprlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AprlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AprlParser#aprlFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAprlFile(AprlParser.AprlFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#globalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStatement(AprlParser.GlobalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#localStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalStatements(AprlParser.LocalStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#localStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalStatement(AprlParser.LocalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(AprlParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#visibilityModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibilityModifier(AprlParser.VisibilityModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(AprlParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#variableClassifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableClassifier(AprlParser.VariableClassifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(AprlParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(AprlParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(AprlParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(AprlParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(AprlParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(AprlParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(AprlParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(AprlParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#valueParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueParameters(AprlParser.ValueParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#valueParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueParameter(AprlParser.ValueParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(AprlParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AprlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(AprlParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#disjunctionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunctionExpression(AprlParser.DisjunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#disjunctionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunctionOperator(AprlParser.DisjunctionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#conjunctionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctionExpression(AprlParser.ConjunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#conjunctionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctionOperator(AprlParser.ConjunctionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(AprlParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(AprlParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#bitwiseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseExpression(AprlParser.BitwiseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOperator(AprlParser.BitwiseOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(AprlParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#additiveOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperator(AprlParser.AdditiveOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(AprlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOperator(AprlParser.MultiplicativeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#unaryPrefixedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPrefixedExpression(AprlParser.UnaryPrefixedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#unaryPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPrefix(AprlParser.UnaryPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#exponentialExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentialExpression(AprlParser.ExponentialExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#exponentialOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentialOperator(AprlParser.ExponentialOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#unaryPostfixedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPostfixedExpression(AprlParser.UnaryPostfixedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#unaryPostfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPostfix(AprlParser.UnaryPostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#valueArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueArguments(AprlParser.ValueArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#valueArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueArgument(AprlParser.ValueArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpression(AprlParser.AtomicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(AprlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(AprlParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(AprlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(AprlParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AprlParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIdentifier(AprlParser.SimpleIdentifierContext ctx);
}