// Generated from /home/erik/Documents/IdeaProjects/APRL/src/main/kotlin/aprl/grammar/AprlParser.g4 by ANTLR 4.13.1
package aprl.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AprlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, VAR=2, VAL=3, EQUAL=4, LPAREN=5, RPAREN=6, LSQUARE=7, RSQUARE=8, 
		LCURLY=9, RCURLY=10, PERIOD=11, COMMA=12, COLON=13, PLUS=14, MINUS=15, 
		ASTERISK=16, DOUBLE_ASTERISK=17, SLASH=18, BACKSLASH=19, PERCENT=20, AND=21, 
		OR=22, XOR=23, SHL=24, SHR=25, USHR=26, NL=27, TRUE=28, FALSE=29, IntegerLiteral=30, 
		FloatLiteral=31, CharLiteral=32, StringLiteral=33, Identifier=34;
	public static final int
		RULE_aprlFile = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_variableClassifier = 3, 
		RULE_variableAssignment = 4, RULE_expression = 5, RULE_parenthesizedExpression = 6, 
		RULE_bitwiseExpression = 7, RULE_bitwiseOperator = 8, RULE_additiveExpression = 9, 
		RULE_additiveOperator = 10, RULE_multiplicativeExpression = 11, RULE_multiplicativeOperator = 12, 
		RULE_exponentialExpression = 13, RULE_exponentialOperator = 14, RULE_atomicExpression = 15, 
		RULE_literal = 16, RULE_booleanLiteral = 17, RULE_type = 18, RULE_identifier = 19, 
		RULE_simpleIdentifier = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"aprlFile", "statement", "variableDeclaration", "variableClassifier", 
			"variableAssignment", "expression", "parenthesizedExpression", "bitwiseExpression", 
			"bitwiseOperator", "additiveExpression", "additiveOperator", "multiplicativeExpression", 
			"multiplicativeOperator", "exponentialExpression", "exponentialOperator", 
			"atomicExpression", "literal", "booleanLiteral", "type", "identifier", 
			"simpleIdentifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'var'", "'val'", "'='", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'.'", "','", "':'", "'+'", "'-'", "'*'", "'**'", "'/'", "'\\'", 
			"'%'", "'&'", "'|'", "'^'", "'<<'", "'>>'", "'>>>'", null, "'true'", 
			"'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "VAR", "VAL", "EQUAL", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", 
			"LCURLY", "RCURLY", "PERIOD", "COMMA", "COLON", "PLUS", "MINUS", "ASTERISK", 
			"DOUBLE_ASTERISK", "SLASH", "BACKSLASH", "PERCENT", "AND", "OR", "XOR", 
			"SHL", "SHR", "USHR", "NL", "TRUE", "FALSE", "IntegerLiteral", "FloatLiteral", 
			"CharLiteral", "StringLiteral", "Identifier"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AprlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AprlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AprlFileContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode EOF() { return getToken(AprlParser.EOF, 0); }
		public List<TerminalNode> NL() { return getTokens(AprlParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AprlParser.NL, i);
		}
		public AprlFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aprlFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterAprlFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitAprlFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitAprlFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AprlFileContext aprlFile() throws RecognitionException {
		AprlFileContext _localctx = new AprlFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aprlFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(42);
				match(NL);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			statement();
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(49);
						match(NL);
						}
						}
						setState(52); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(54);
					statement();
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(60);
				match(NL);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				variableDeclaration();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				variableAssignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableClassifierContext variableClassifier() {
			return getRuleContext(VariableClassifierContext.class,0);
		}
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(AprlParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(AprlParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				variableClassifier();
				setState(73);
				simpleIdentifier();
				setState(74);
				match(COLON);
				setState(75);
				type();
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(76);
					match(EQUAL);
					setState(77);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				variableClassifier();
				setState(81);
				simpleIdentifier();
				setState(82);
				match(EQUAL);
				setState(83);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableClassifierContext extends ParserRuleContext {
		public TerminalNode VAL() { return getToken(AprlParser.VAL, 0); }
		public TerminalNode VAR() { return getToken(AprlParser.VAR, 0); }
		public VariableClassifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableClassifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterVariableClassifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitVariableClassifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitVariableClassifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableClassifierContext variableClassifier() throws RecognitionException {
		VariableClassifierContext _localctx = new VariableClassifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableClassifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !(_la==VAR || _la==VAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssignmentContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(AprlParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			simpleIdentifier();
			setState(90);
			match(EQUAL);
			setState(91);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ParenthesizedExpressionContext parenthesizedExpression() {
			return getRuleContext(ParenthesizedExpressionContext.class,0);
		}
		public BitwiseExpressionContext bitwiseExpression() {
			return getRuleContext(BitwiseExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				parenthesizedExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				bitwiseExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(AprlParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AprlParser.RPAREN, 0); }
		public ParenthesizedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedExpressionContext parenthesizedExpression() throws RecognitionException {
		ParenthesizedExpressionContext _localctx = new ParenthesizedExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parenthesizedExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(LPAREN);
			setState(98);
			expression();
			setState(99);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public BitwiseExpressionContext bitwiseExpression() {
			return getRuleContext(BitwiseExpressionContext.class,0);
		}
		public BitwiseOperatorContext bitwiseOperator() {
			return getRuleContext(BitwiseOperatorContext.class,0);
		}
		public BitwiseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterBitwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitBitwiseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitBitwiseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitwiseExpressionContext bitwiseExpression() throws RecognitionException {
		return bitwiseExpression(0);
	}

	private BitwiseExpressionContext bitwiseExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BitwiseExpressionContext _localctx = new BitwiseExpressionContext(_ctx, _parentState);
		BitwiseExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_bitwiseExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(102);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BitwiseExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwiseExpression);
					setState(104);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(105);
					bitwiseOperator();
					setState(106);
					additiveExpression(0);
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseOperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(AprlParser.AND, 0); }
		public TerminalNode OR() { return getToken(AprlParser.OR, 0); }
		public TerminalNode XOR() { return getToken(AprlParser.XOR, 0); }
		public TerminalNode SHL() { return getToken(AprlParser.SHL, 0); }
		public TerminalNode SHR() { return getToken(AprlParser.SHR, 0); }
		public TerminalNode USHR() { return getToken(AprlParser.USHR, 0); }
		public BitwiseOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterBitwiseOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitBitwiseOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitBitwiseOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitwiseOperatorContext bitwiseOperator() throws RecognitionException {
		BitwiseOperatorContext _localctx = new BitwiseOperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bitwiseOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public AdditiveOperatorContext additiveOperator() {
			return getRuleContext(AdditiveOperatorContext.class,0);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(116);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
					setState(118);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(119);
					additiveOperator();
					setState(120);
					multiplicativeExpression(0);
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(AprlParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(AprlParser.MINUS, 0); }
		public AdditiveOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterAdditiveOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitAdditiveOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitAdditiveOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveOperatorContext additiveOperator() throws RecognitionException {
		AdditiveOperatorContext _localctx = new AdditiveOperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_additiveOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public ExponentialExpressionContext exponentialExpression() {
			return getRuleContext(ExponentialExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public MultiplicativeOperatorContext multiplicativeOperator() {
			return getRuleContext(MultiplicativeOperatorContext.class,0);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(130);
			exponentialExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
					setState(132);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(133);
					multiplicativeOperator();
					setState(134);
					exponentialExpression(0);
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeOperatorContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(AprlParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(AprlParser.SLASH, 0); }
		public TerminalNode BACKSLASH() { return getToken(AprlParser.BACKSLASH, 0); }
		public TerminalNode PERCENT() { return getToken(AprlParser.PERCENT, 0); }
		public MultiplicativeOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterMultiplicativeOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitMultiplicativeOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitMultiplicativeOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeOperatorContext multiplicativeOperator() throws RecognitionException {
		MultiplicativeOperatorContext _localctx = new MultiplicativeOperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multiplicativeOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1900544L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExponentialExpressionContext extends ParserRuleContext {
		public AtomicExpressionContext atomicExpression() {
			return getRuleContext(AtomicExpressionContext.class,0);
		}
		public ExponentialExpressionContext exponentialExpression() {
			return getRuleContext(ExponentialExpressionContext.class,0);
		}
		public ExponentialOperatorContext exponentialOperator() {
			return getRuleContext(ExponentialOperatorContext.class,0);
		}
		public ExponentialExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponentialExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterExponentialExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitExponentialExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitExponentialExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExponentialExpressionContext exponentialExpression() throws RecognitionException {
		return exponentialExpression(0);
	}

	private ExponentialExpressionContext exponentialExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExponentialExpressionContext _localctx = new ExponentialExpressionContext(_ctx, _parentState);
		ExponentialExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_exponentialExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(144);
			atomicExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExponentialExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exponentialExpression);
					setState(146);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(147);
					exponentialOperator();
					setState(148);
					atomicExpression();
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExponentialOperatorContext extends ParserRuleContext {
		public TerminalNode DOUBLE_ASTERISK() { return getToken(AprlParser.DOUBLE_ASTERISK, 0); }
		public ExponentialOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponentialOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterExponentialOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitExponentialOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitExponentialOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExponentialOperatorContext exponentialOperator() throws RecognitionException {
		ExponentialOperatorContext _localctx = new ExponentialOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exponentialOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(DOUBLE_ASTERISK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomicExpressionContext extends ParserRuleContext {
		public ParenthesizedExpressionContext parenthesizedExpression() {
			return getRuleContext(ParenthesizedExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public AtomicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterAtomicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitAtomicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitAtomicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicExpressionContext atomicExpression() throws RecognitionException {
		AtomicExpressionContext _localctx = new AtomicExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_atomicExpression);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				parenthesizedExpression();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				identifier();
				}
				break;
			case TRUE:
			case FALSE:
			case IntegerLiteral:
			case FloatLiteral:
			case CharLiteral:
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public TerminalNode IntegerLiteral() { return getToken(AprlParser.IntegerLiteral, 0); }
		public TerminalNode FloatLiteral() { return getToken(AprlParser.FloatLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(AprlParser.StringLiteral, 0); }
		public TerminalNode CharLiteral() { return getToken(AprlParser.CharLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				booleanLiteral();
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(IntegerLiteral);
				}
				break;
			case FloatLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(FloatLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				match(StringLiteral);
				}
				break;
			case CharLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				match(CharLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(AprlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(AprlParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public List<SimpleIdentifierContext> simpleIdentifier() {
			return getRuleContexts(SimpleIdentifierContext.class);
		}
		public SimpleIdentifierContext simpleIdentifier(int i) {
			return getRuleContext(SimpleIdentifierContext.class,i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(AprlParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(AprlParser.PERIOD, i);
		}
		public List<TerminalNode> NL() { return getTokens(AprlParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AprlParser.NL, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_identifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			simpleIdentifier();
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(174);
						match(NL);
						}
						}
						setState(179);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(180);
					match(PERIOD);
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(181);
						match(NL);
						}
						}
						setState(186);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(187);
					simpleIdentifier();
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleIdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AprlParser.Identifier, 0); }
		public SimpleIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterSimpleIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitSimpleIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitSimpleIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleIdentifierContext simpleIdentifier() throws RecognitionException {
		SimpleIdentifierContext _localctx = new SimpleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_simpleIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return bitwiseExpression_sempred((BitwiseExpressionContext)_localctx, predIndex);
		case 9:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 11:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 13:
			return exponentialExpression_sempred((ExponentialExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bitwiseExpression_sempred(BitwiseExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exponentialExpression_sempred(ExponentialExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00c4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0005\u0000"+
		",\b\u0000\n\u0000\f\u0000/\t\u0000\u0001\u0000\u0001\u0000\u0004\u0000"+
		"3\b\u0000\u000b\u0000\f\u00004\u0001\u0000\u0005\u00008\b\u0000\n\u0000"+
		"\f\u0000;\t\u0000\u0001\u0000\u0005\u0000>\b\u0000\n\u0000\f\u0000A\t"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001G\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002O\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002V\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003"+
		"\u0005`\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007m\b\u0007\n\u0007\f\u0007p\t\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t{\b\t\n\t\f"+
		"\t~\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0089\b\u000b\n\u000b"+
		"\f\u000b\u008c\t\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0005\r\u0097\b\r\n\r\f\r\u009a\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00a1\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00a8\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u00b0\b\u0013\n\u0013\f\u0013\u00b3\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00b7\b\u0013\n\u0013\f\u0013\u00ba\t\u0013"+
		"\u0001\u0013\u0005\u0013\u00bd\b\u0013\n\u0013\f\u0013\u00c0\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0000\u0004\u000e\u0012\u0016\u001a\u0015"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(\u0000\u0005\u0001\u0000\u0002\u0003\u0001\u0000\u0015"+
		"\u001a\u0001\u0000\u000e\u000f\u0002\u0000\u0010\u0010\u0012\u0014\u0001"+
		"\u0000\u001c\u001d\u00c3\u0000-\u0001\u0000\u0000\u0000\u0002F\u0001\u0000"+
		"\u0000\u0000\u0004U\u0001\u0000\u0000\u0000\u0006W\u0001\u0000\u0000\u0000"+
		"\bY\u0001\u0000\u0000\u0000\n_\u0001\u0000\u0000\u0000\fa\u0001\u0000"+
		"\u0000\u0000\u000ee\u0001\u0000\u0000\u0000\u0010q\u0001\u0000\u0000\u0000"+
		"\u0012s\u0001\u0000\u0000\u0000\u0014\u007f\u0001\u0000\u0000\u0000\u0016"+
		"\u0081\u0001\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a"+
		"\u008f\u0001\u0000\u0000\u0000\u001c\u009b\u0001\u0000\u0000\u0000\u001e"+
		"\u00a0\u0001\u0000\u0000\u0000 \u00a7\u0001\u0000\u0000\u0000\"\u00a9"+
		"\u0001\u0000\u0000\u0000$\u00ab\u0001\u0000\u0000\u0000&\u00ad\u0001\u0000"+
		"\u0000\u0000(\u00c1\u0001\u0000\u0000\u0000*,\u0005\u001b\u0000\u0000"+
		"+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000"+
		"\u0000\u000009\u0003\u0002\u0001\u000013\u0005\u001b\u0000\u000021\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0003\u0002\u0001"+
		"\u000072\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000"+
		"\u0000\u00009:\u0001\u0000\u0000\u0000:?\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000<>\u0005\u001b\u0000\u0000=<\u0001\u0000\u0000\u0000"+
		">A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u0000"+
		"\u0000\u0001C\u0001\u0001\u0000\u0000\u0000DG\u0003\u0004\u0002\u0000"+
		"EG\u0003\b\u0004\u0000FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"G\u0003\u0001\u0000\u0000\u0000HI\u0003\u0006\u0003\u0000IJ\u0003(\u0014"+
		"\u0000JK\u0005\r\u0000\u0000KN\u0003$\u0012\u0000LM\u0005\u0004\u0000"+
		"\u0000MO\u0003\n\u0005\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000OV\u0001\u0000\u0000\u0000PQ\u0003\u0006\u0003\u0000QR\u0003(\u0014"+
		"\u0000RS\u0005\u0004\u0000\u0000ST\u0003\n\u0005\u0000TV\u0001\u0000\u0000"+
		"\u0000UH\u0001\u0000\u0000\u0000UP\u0001\u0000\u0000\u0000V\u0005\u0001"+
		"\u0000\u0000\u0000WX\u0007\u0000\u0000\u0000X\u0007\u0001\u0000\u0000"+
		"\u0000YZ\u0003(\u0014\u0000Z[\u0005\u0004\u0000\u0000[\\\u0003\n\u0005"+
		"\u0000\\\t\u0001\u0000\u0000\u0000]`\u0003\f\u0006\u0000^`\u0003\u000e"+
		"\u0007\u0000_]\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`\u000b"+
		"\u0001\u0000\u0000\u0000ab\u0005\u0005\u0000\u0000bc\u0003\n\u0005\u0000"+
		"cd\u0005\u0006\u0000\u0000d\r\u0001\u0000\u0000\u0000ef\u0006\u0007\uffff"+
		"\uffff\u0000fg\u0003\u0012\t\u0000gn\u0001\u0000\u0000\u0000hi\n\u0002"+
		"\u0000\u0000ij\u0003\u0010\b\u0000jk\u0003\u0012\t\u0000km\u0001\u0000"+
		"\u0000\u0000lh\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u000f\u0001\u0000\u0000"+
		"\u0000pn\u0001\u0000\u0000\u0000qr\u0007\u0001\u0000\u0000r\u0011\u0001"+
		"\u0000\u0000\u0000st\u0006\t\uffff\uffff\u0000tu\u0003\u0016\u000b\u0000"+
		"u|\u0001\u0000\u0000\u0000vw\n\u0002\u0000\u0000wx\u0003\u0014\n\u0000"+
		"xy\u0003\u0016\u000b\u0000y{\u0001\u0000\u0000\u0000zv\u0001\u0000\u0000"+
		"\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}\u0013\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0007\u0002\u0000\u0000\u0080\u0015\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0006\u000b\uffff\uffff\u0000\u0082\u0083\u0003\u001a\r\u0000"+
		"\u0083\u008a\u0001\u0000\u0000\u0000\u0084\u0085\n\u0002\u0000\u0000\u0085"+
		"\u0086\u0003\u0018\f\u0000\u0086\u0087\u0003\u001a\r\u0000\u0087\u0089"+
		"\u0001\u0000\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0089\u008c"+
		"\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b\u0017\u0001\u0000\u0000\u0000\u008c\u008a"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0007\u0003\u0000\u0000\u008e\u0019"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0006\r\uffff\uffff\u0000\u0090\u0091"+
		"\u0003\u001e\u000f\u0000\u0091\u0098\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\n\u0002\u0000\u0000\u0093\u0094\u0003\u001c\u000e\u0000\u0094\u0095\u0003"+
		"\u001e\u000f\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0092\u0001"+
		"\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u001b\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u0005"+
		"\u0011\u0000\u0000\u009c\u001d\u0001\u0000\u0000\u0000\u009d\u00a1\u0003"+
		"\f\u0006\u0000\u009e\u00a1\u0003&\u0013\u0000\u009f\u00a1\u0003 \u0010"+
		"\u0000\u00a0\u009d\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000"+
		"\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u001f\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a8\u0003\"\u0011\u0000\u00a3\u00a8\u0005\u001e\u0000\u0000"+
		"\u00a4\u00a8\u0005\u001f\u0000\u0000\u00a5\u00a8\u0005!\u0000\u0000\u00a6"+
		"\u00a8\u0005 \u0000\u0000\u00a7\u00a2\u0001\u0000\u0000\u0000\u00a7\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8!\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0007\u0004\u0000\u0000\u00aa#\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0003&\u0013\u0000\u00ac%\u0001\u0000\u0000\u0000"+
		"\u00ad\u00be\u0003(\u0014\u0000\u00ae\u00b0\u0005\u001b\u0000\u0000\u00af"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1"+
		"\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b8\u0005\u000b\u0000\u0000\u00b5\u00b7\u0005\u001b\u0000\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bd\u0003(\u0014\u0000\u00bc\u00b1\u0001\u0000\u0000\u0000\u00bd\u00c0"+
		"\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\'\u0001\u0000\u0000\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0005\"\u0000\u0000\u00c2)\u0001\u0000"+
		"\u0000\u0000\u0011-49?FNU_n|\u008a\u0098\u00a0\u00a7\u00b1\u00b8\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}