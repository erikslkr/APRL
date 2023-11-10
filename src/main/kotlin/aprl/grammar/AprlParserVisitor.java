// Generated from /Users/erik/Desktop/IntelliJ/APRL/src/main/kotlin/aprl/grammar/AprlParser.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link AprlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AprlParser.StatementContext ctx);
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