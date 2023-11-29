// Generated from /Users/erik/Desktop/IntelliJ/APRL/src/main/kotlin/aprl/grammar/AprlParser.g4 by ANTLR 4.13.1
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
		WS=1, VAR=2, VAL=3, FUNCTION=4, RETURN=5, EQUAL=6, DOUBLE_EQUAL=7, TRIPLE_EQUAL=8, 
		NOT_EQUAL=9, NOT_DOUBLE_EQUAL=10, LANGLE=11, RANGLE=12, LANGLE_EQUAL=13, 
		RANGLE_EQUAL=14, LPAREN=15, RPAREN=16, LSQUARE=17, RSQUARE=18, LCURLY=19, 
		RCURLY=20, PERIOD=21, COMMA=22, COLON=23, PLUS=24, MINUS=25, ASTERISK=26, 
		DOUBLE_ASTERISK=27, SLASH=28, BACKSLASH=29, PERCENT=30, RIGHT_ARROW=31, 
		AND=32, DOUBLE_AND=33, OR=34, DOUBLE_OR=35, XOR=36, SHL=37, SHR=38, USHR=39, 
		NL=40, TRUE=41, FALSE=42, IntegerLiteral=43, FloatLiteral=44, CharLiteral=45, 
		StringLiteral=46, Identifier=47;
	public static final int
		RULE_aprlFile = 0, RULE_globalStatement = 1, RULE_localStatement = 2, 
		RULE_variableDeclaration = 3, RULE_variableClassifier = 4, RULE_variableAssignment = 5, 
		RULE_returnStatement = 6, RULE_functionDeclaration = 7, RULE_functionArguments = 8, 
		RULE_functionArgument = 9, RULE_functionBody = 10, RULE_expression = 11, 
		RULE_parenthesizedExpression = 12, RULE_disjunctionExpression = 13, RULE_disjunctionOperator = 14, 
		RULE_conjunctionExpression = 15, RULE_conjunctionOperator = 16, RULE_comparisonExpression = 17, 
		RULE_comparisonOperator = 18, RULE_bitwiseExpression = 19, RULE_bitwiseOperator = 20, 
		RULE_additiveExpression = 21, RULE_additiveOperator = 22, RULE_multiplicativeExpression = 23, 
		RULE_multiplicativeOperator = 24, RULE_exponentialExpression = 25, RULE_exponentialOperator = 26, 
		RULE_atomicExpression = 27, RULE_literal = 28, RULE_booleanLiteral = 29, 
		RULE_type = 30, RULE_identifier = 31, RULE_simpleIdentifier = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"aprlFile", "globalStatement", "localStatement", "variableDeclaration", 
			"variableClassifier", "variableAssignment", "returnStatement", "functionDeclaration", 
			"functionArguments", "functionArgument", "functionBody", "expression", 
			"parenthesizedExpression", "disjunctionExpression", "disjunctionOperator", 
			"conjunctionExpression", "conjunctionOperator", "comparisonExpression", 
			"comparisonOperator", "bitwiseExpression", "bitwiseOperator", "additiveExpression", 
			"additiveOperator", "multiplicativeExpression", "multiplicativeOperator", 
			"exponentialExpression", "exponentialOperator", "atomicExpression", "literal", 
			"booleanLiteral", "type", "identifier", "simpleIdentifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'var'", "'val'", "'function'", "'return'", "'='", "'=='", 
			"'==='", "'!='", "'!=='", "'<'", "'>'", "'<='", "'>='", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'.'", "','", "':'", "'+'", "'-'", "'*'", 
			"'**'", "'/'", "'\\'", "'%'", "'->'", "'&'", "'&&'", "'|'", "'||'", "'^'", 
			"'<<'", "'>>'", "'>>>'", null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "VAR", "VAL", "FUNCTION", "RETURN", "EQUAL", "DOUBLE_EQUAL", 
			"TRIPLE_EQUAL", "NOT_EQUAL", "NOT_DOUBLE_EQUAL", "LANGLE", "RANGLE", 
			"LANGLE_EQUAL", "RANGLE_EQUAL", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", 
			"LCURLY", "RCURLY", "PERIOD", "COMMA", "COLON", "PLUS", "MINUS", "ASTERISK", 
			"DOUBLE_ASTERISK", "SLASH", "BACKSLASH", "PERCENT", "RIGHT_ARROW", "AND", 
			"DOUBLE_AND", "OR", "DOUBLE_OR", "XOR", "SHL", "SHR", "USHR", "NL", "TRUE", 
			"FALSE", "IntegerLiteral", "FloatLiteral", "CharLiteral", "StringLiteral", 
			"Identifier"
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
		public List<GlobalStatementContext> globalStatement() {
			return getRuleContexts(GlobalStatementContext.class);
		}
		public GlobalStatementContext globalStatement(int i) {
			return getRuleContext(GlobalStatementContext.class,i);
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(66);
				match(NL);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			globalStatement();
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(73);
						match(NL);
						}
						}
						setState(76); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(78);
					globalStatement();
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(84);
				match(NL);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
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
	public static class GlobalStatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public GlobalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterGlobalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitGlobalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitGlobalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalStatementContext globalStatement() throws RecognitionException {
		GlobalStatementContext _localctx = new GlobalStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalStatement);
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				variableDeclaration();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				functionDeclaration();
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
	public static class LocalStatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public LocalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterLocalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitLocalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitLocalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalStatementContext localStatement() throws RecognitionException {
		LocalStatementContext _localctx = new LocalStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_localStatement);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				variableDeclaration();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				variableAssignment();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				returnStatement();
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
		enterRule(_localctx, 6, RULE_variableDeclaration);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				variableClassifier();
				setState(102);
				simpleIdentifier();
				setState(103);
				match(COLON);
				setState(104);
				type();
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(105);
					match(EQUAL);
					setState(106);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				variableClassifier();
				setState(110);
				simpleIdentifier();
				setState(111);
				match(EQUAL);
				setState(112);
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
		enterRule(_localctx, 8, RULE_variableClassifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
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
		enterRule(_localctx, 10, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			simpleIdentifier();
			setState(119);
			match(EQUAL);
			setState(120);
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(AprlParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(RETURN);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279275953487872L) != 0)) {
				{
				setState(123);
				expression();
				}
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
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(AprlParser.FUNCTION, 0); }
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public TerminalNode RIGHT_ARROW() { return getToken(AprlParser.RIGHT_ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(FUNCTION);
			setState(127);
			simpleIdentifier();
			setState(128);
			functionArguments();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RIGHT_ARROW) {
				{
				setState(129);
				match(RIGHT_ARROW);
				setState(130);
				type();
				}
			}

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LCURLY) {
				{
				setState(133);
				functionBody();
				}
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
	public static class FunctionArgumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(AprlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AprlParser.RPAREN, 0); }
		public List<FunctionArgumentContext> functionArgument() {
			return getRuleContexts(FunctionArgumentContext.class);
		}
		public FunctionArgumentContext functionArgument(int i) {
			return getRuleContext(FunctionArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AprlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AprlParser.COMMA, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(LPAREN);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(137);
				functionArgument();
				}
			}

			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(140);
				match(COMMA);
				setState(141);
				functionArgument();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
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
	public static class FunctionArgumentContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(AprlParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterFunctionArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitFunctionArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitFunctionArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentContext functionArgument() throws RecognitionException {
		FunctionArgumentContext _localctx = new FunctionArgumentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			simpleIdentifier();
			setState(150);
			match(COLON);
			setState(151);
			type();
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
	public static class FunctionBodyContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(AprlParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(AprlParser.RCURLY, 0); }
		public List<TerminalNode> NL() { return getTokens(AprlParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AprlParser.NL, i);
		}
		public List<LocalStatementContext> localStatement() {
			return getRuleContexts(LocalStatementContext.class);
		}
		public LocalStatementContext localStatement(int i) {
			return getRuleContext(LocalStatementContext.class,i);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(LCURLY);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(154);
					match(NL);
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140737488355372L) != 0)) {
				{
				setState(160);
				localStatement();
				}
			}

			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(164); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(163);
						match(NL);
						}
						}
						setState(166); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(168);
					localStatement();
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
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
			match(RCURLY);
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
		public DisjunctionExpressionContext disjunctionExpression() {
			return getRuleContext(DisjunctionExpressionContext.class,0);
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
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				parenthesizedExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				disjunctionExpression();
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
		enterRule(_localctx, 24, RULE_parenthesizedExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(LPAREN);
			setState(187);
			expression();
			setState(188);
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
	public static class DisjunctionExpressionContext extends ParserRuleContext {
		public ConjunctionExpressionContext conjunctionExpression() {
			return getRuleContext(ConjunctionExpressionContext.class,0);
		}
		public DisjunctionOperatorContext disjunctionOperator() {
			return getRuleContext(DisjunctionOperatorContext.class,0);
		}
		public DisjunctionExpressionContext disjunctionExpression() {
			return getRuleContext(DisjunctionExpressionContext.class,0);
		}
		public DisjunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterDisjunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitDisjunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitDisjunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionExpressionContext disjunctionExpression() throws RecognitionException {
		DisjunctionExpressionContext _localctx = new DisjunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_disjunctionExpression);
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				conjunctionExpression();
				setState(191);
				disjunctionOperator();
				setState(192);
				disjunctionExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				conjunctionExpression();
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
	public static class DisjunctionOperatorContext extends ParserRuleContext {
		public TerminalNode DOUBLE_OR() { return getToken(AprlParser.DOUBLE_OR, 0); }
		public DisjunctionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctionOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterDisjunctionOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitDisjunctionOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitDisjunctionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionOperatorContext disjunctionOperator() throws RecognitionException {
		DisjunctionOperatorContext _localctx = new DisjunctionOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_disjunctionOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(DOUBLE_OR);
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
	public static class ConjunctionExpressionContext extends ParserRuleContext {
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public ConjunctionOperatorContext conjunctionOperator() {
			return getRuleContext(ConjunctionOperatorContext.class,0);
		}
		public ConjunctionExpressionContext conjunctionExpression() {
			return getRuleContext(ConjunctionExpressionContext.class,0);
		}
		public ConjunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunctionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterConjunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitConjunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitConjunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionExpressionContext conjunctionExpression() throws RecognitionException {
		ConjunctionExpressionContext _localctx = new ConjunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conjunctionExpression);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				comparisonExpression();
				setState(200);
				conjunctionOperator();
				setState(201);
				conjunctionExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				comparisonExpression();
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
	public static class ConjunctionOperatorContext extends ParserRuleContext {
		public TerminalNode DOUBLE_AND() { return getToken(AprlParser.DOUBLE_AND, 0); }
		public ConjunctionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunctionOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterConjunctionOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitConjunctionOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitConjunctionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionOperatorContext conjunctionOperator() throws RecognitionException {
		ConjunctionOperatorContext _localctx = new ConjunctionOperatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_conjunctionOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(DOUBLE_AND);
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
	public static class ComparisonExpressionContext extends ParserRuleContext {
		public BitwiseExpressionContext bitwiseExpression() {
			return getRuleContext(BitwiseExpressionContext.class,0);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comparisonExpression);
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				bitwiseExpression(0);
				setState(209);
				comparisonOperator();
				setState(210);
				comparisonExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
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
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode LANGLE() { return getToken(AprlParser.LANGLE, 0); }
		public TerminalNode RANGLE() { return getToken(AprlParser.RANGLE, 0); }
		public TerminalNode LANGLE_EQUAL() { return getToken(AprlParser.LANGLE_EQUAL, 0); }
		public TerminalNode RANGLE_EQUAL() { return getToken(AprlParser.RANGLE_EQUAL, 0); }
		public TerminalNode DOUBLE_EQUAL() { return getToken(AprlParser.DOUBLE_EQUAL, 0); }
		public TerminalNode TRIPLE_EQUAL() { return getToken(AprlParser.TRIPLE_EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(AprlParser.NOT_EQUAL, 0); }
		public TerminalNode NOT_DOUBLE_EQUAL() { return getToken(AprlParser.NOT_DOUBLE_EQUAL, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AprlParserListener ) ((AprlParserListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AprlParserVisitor ) return ((AprlParserVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32640L) != 0)) ) {
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_bitwiseExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(218);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BitwiseExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwiseExpression);
					setState(220);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(221);
					bitwiseOperator();
					setState(222);
					additiveExpression(0);
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		enterRule(_localctx, 40, RULE_bitwiseOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1052266987520L) != 0)) ) {
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(232);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
					setState(234);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(235);
					additiveOperator();
					setState(236);
					multiplicativeExpression(0);
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 44, RULE_additiveOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(246);
			exponentialExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
					setState(248);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(249);
					multiplicativeOperator();
					setState(250);
					exponentialExpression(0);
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 48, RULE_multiplicativeOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1946157056L) != 0)) ) {
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_exponentialExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(260);
			atomicExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExponentialExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exponentialExpression);
					setState(262);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(263);
					exponentialOperator();
					setState(264);
					atomicExpression();
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 52, RULE_exponentialOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
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
		enterRule(_localctx, 54, RULE_atomicExpression);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				parenthesizedExpression();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
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
				setState(275);
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
		enterRule(_localctx, 56, RULE_literal);
		try {
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				booleanLiteral();
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(IntegerLiteral);
				}
				break;
			case FloatLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				match(FloatLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				match(StringLiteral);
				}
				break;
			case CharLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(282);
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
		enterRule(_localctx, 58, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		enterRule(_localctx, 60, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
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
		enterRule(_localctx, 62, RULE_identifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			simpleIdentifier();
			setState(306);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(290);
						match(NL);
						}
						}
						setState(295);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(296);
					match(PERIOD);
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(297);
						match(NL);
						}
						}
						setState(302);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(303);
					simpleIdentifier();
					}
					} 
				}
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
		enterRule(_localctx, 64, RULE_simpleIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
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
		case 19:
			return bitwiseExpression_sempred((BitwiseExpressionContext)_localctx, predIndex);
		case 21:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 23:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 25:
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
		"\u0004\u0001/\u0138\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0005\u0000D\b\u0000"+
		"\n\u0000\f\u0000G\t\u0000\u0001\u0000\u0001\u0000\u0004\u0000K\b\u0000"+
		"\u000b\u0000\f\u0000L\u0001\u0000\u0005\u0000P\b\u0000\n\u0000\f\u0000"+
		"S\t\u0000\u0001\u0000\u0005\u0000V\b\u0000\n\u0000\f\u0000Y\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001_\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002d\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003l\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003s\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006}\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0084"+
		"\b\u0007\u0001\u0007\u0003\u0007\u0087\b\u0007\u0001\b\u0001\b\u0003\b"+
		"\u008b\b\b\u0001\b\u0001\b\u0005\b\u008f\b\b\n\b\f\b\u0092\t\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n\u009c"+
		"\b\n\n\n\f\n\u009f\t\n\u0001\n\u0003\n\u00a2\b\n\u0001\n\u0004\n\u00a5"+
		"\b\n\u000b\n\f\n\u00a6\u0001\n\u0005\n\u00aa\b\n\n\n\f\n\u00ad\t\n\u0001"+
		"\n\u0005\n\u00b0\b\n\n\n\f\n\u00b3\t\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00b9\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c4\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00cd\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00d6\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00e1\b\u0013\n\u0013\f\u0013\u00e4\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00ef\b\u0015\n\u0015"+
		"\f\u0015\u00f2\t\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u00fd\b\u0017\n\u0017\f\u0017\u0100\t\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u010b\b\u0019\n\u0019\f\u0019\u010e\t\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0115\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u011c\b\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u0124\b\u001f\n\u001f\f\u001f\u0127\t\u001f\u0001"+
		"\u001f\u0001\u001f\u0005\u001f\u012b\b\u001f\n\u001f\f\u001f\u012e\t\u001f"+
		"\u0001\u001f\u0005\u001f\u0131\b\u001f\n\u001f\f\u001f\u0134\t\u001f\u0001"+
		" \u0001 \u0001 \u0000\u0004&*.2!\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@\u0000\u0006"+
		"\u0001\u0000\u0002\u0003\u0001\u0000\u0007\u000e\u0003\u0000  \"\"$\'"+
		"\u0001\u0000\u0018\u0019\u0002\u0000\u001a\u001a\u001c\u001e\u0001\u0000"+
		")*\u013a\u0000E\u0001\u0000\u0000\u0000\u0002^\u0001\u0000\u0000\u0000"+
		"\u0004c\u0001\u0000\u0000\u0000\u0006r\u0001\u0000\u0000\u0000\bt\u0001"+
		"\u0000\u0000\u0000\nv\u0001\u0000\u0000\u0000\fz\u0001\u0000\u0000\u0000"+
		"\u000e~\u0001\u0000\u0000\u0000\u0010\u0088\u0001\u0000\u0000\u0000\u0012"+
		"\u0095\u0001\u0000\u0000\u0000\u0014\u0099\u0001\u0000\u0000\u0000\u0016"+
		"\u00b8\u0001\u0000\u0000\u0000\u0018\u00ba\u0001\u0000\u0000\u0000\u001a"+
		"\u00c3\u0001\u0000\u0000\u0000\u001c\u00c5\u0001\u0000\u0000\u0000\u001e"+
		"\u00cc\u0001\u0000\u0000\u0000 \u00ce\u0001\u0000\u0000\u0000\"\u00d5"+
		"\u0001\u0000\u0000\u0000$\u00d7\u0001\u0000\u0000\u0000&\u00d9\u0001\u0000"+
		"\u0000\u0000(\u00e5\u0001\u0000\u0000\u0000*\u00e7\u0001\u0000\u0000\u0000"+
		",\u00f3\u0001\u0000\u0000\u0000.\u00f5\u0001\u0000\u0000\u00000\u0101"+
		"\u0001\u0000\u0000\u00002\u0103\u0001\u0000\u0000\u00004\u010f\u0001\u0000"+
		"\u0000\u00006\u0114\u0001\u0000\u0000\u00008\u011b\u0001\u0000\u0000\u0000"+
		":\u011d\u0001\u0000\u0000\u0000<\u011f\u0001\u0000\u0000\u0000>\u0121"+
		"\u0001\u0000\u0000\u0000@\u0135\u0001\u0000\u0000\u0000BD\u0005(\u0000"+
		"\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000HQ\u0003\u0002\u0001\u0000IK\u0005(\u0000\u0000JI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0003\u0002\u0001"+
		"\u0000OJ\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RW\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TV\u0005(\u0000\u0000UT\u0001\u0000\u0000\u0000VY\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005\u0000\u0000"+
		"\u0001[\u0001\u0001\u0000\u0000\u0000\\_\u0003\u0006\u0003\u0000]_\u0003"+
		"\u000e\u0007\u0000^\\\u0001\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000"+
		"_\u0003\u0001\u0000\u0000\u0000`d\u0003\u0006\u0003\u0000ad\u0003\n\u0005"+
		"\u0000bd\u0003\f\u0006\u0000c`\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000"+
		"\u0000cb\u0001\u0000\u0000\u0000d\u0005\u0001\u0000\u0000\u0000ef\u0003"+
		"\b\u0004\u0000fg\u0003@ \u0000gh\u0005\u0017\u0000\u0000hk\u0003<\u001e"+
		"\u0000ij\u0005\u0006\u0000\u0000jl\u0003\u0016\u000b\u0000ki\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000ls\u0001\u0000\u0000\u0000mn\u0003"+
		"\b\u0004\u0000no\u0003@ \u0000op\u0005\u0006\u0000\u0000pq\u0003\u0016"+
		"\u000b\u0000qs\u0001\u0000\u0000\u0000re\u0001\u0000\u0000\u0000rm\u0001"+
		"\u0000\u0000\u0000s\u0007\u0001\u0000\u0000\u0000tu\u0007\u0000\u0000"+
		"\u0000u\t\u0001\u0000\u0000\u0000vw\u0003@ \u0000wx\u0005\u0006\u0000"+
		"\u0000xy\u0003\u0016\u000b\u0000y\u000b\u0001\u0000\u0000\u0000z|\u0005"+
		"\u0005\u0000\u0000{}\u0003\u0016\u000b\u0000|{\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}\r\u0001\u0000\u0000\u0000~\u007f\u0005\u0004"+
		"\u0000\u0000\u007f\u0080\u0003@ \u0000\u0080\u0083\u0003\u0010\b\u0000"+
		"\u0081\u0082\u0005\u001f\u0000\u0000\u0082\u0084\u0003<\u001e\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u0086\u0001\u0000\u0000\u0000\u0085\u0087\u0003\u0014\n\u0000\u0086\u0085"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u000f"+
		"\u0001\u0000\u0000\u0000\u0088\u008a\u0005\u000f\u0000\u0000\u0089\u008b"+
		"\u0003\u0012\t\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u0090\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"\u0016\u0000\u0000\u008d\u008f\u0003\u0012\t\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0093\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0010"+
		"\u0000\u0000\u0094\u0011\u0001\u0000\u0000\u0000\u0095\u0096\u0003@ \u0000"+
		"\u0096\u0097\u0005\u0017\u0000\u0000\u0097\u0098\u0003<\u001e\u0000\u0098"+
		"\u0013\u0001\u0000\u0000\u0000\u0099\u009d\u0005\u0013\u0000\u0000\u009a"+
		"\u009c\u0005(\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009f"+
		"\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a2\u0003\u0004\u0002\u0000\u00a1\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00ab"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005(\u0000\u0000\u00a4\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00aa\u0003\u0004\u0002\u0000\u00a9\u00a4\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00b1\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b0\u0005"+
		"(\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0005\u0014\u0000\u0000\u00b5\u0015\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b9\u0003\u0018\f\u0000\u00b7\u00b9\u0003\u001a\r"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b9\u0017\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u000f\u0000"+
		"\u0000\u00bb\u00bc\u0003\u0016\u000b\u0000\u00bc\u00bd\u0005\u0010\u0000"+
		"\u0000\u00bd\u0019\u0001\u0000\u0000\u0000\u00be\u00bf\u0003\u001e\u000f"+
		"\u0000\u00bf\u00c0\u0003\u001c\u000e\u0000\u00c0\u00c1\u0003\u001a\r\u0000"+
		"\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c4\u0003\u001e\u000f\u0000"+
		"\u00c3\u00be\u0001\u0000\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c4\u001b\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005#\u0000\u0000\u00c6"+
		"\u001d\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003\"\u0011\u0000\u00c8\u00c9"+
		"\u0003 \u0010\u0000\u00c9\u00ca\u0003\u001e\u000f\u0000\u00ca\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cd\u0003\"\u0011\u0000\u00cc\u00c7\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u001f\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0005!\u0000\u0000\u00cf!\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0003&\u0013\u0000\u00d1\u00d2\u0003$\u0012\u0000\u00d2\u00d3"+
		"\u0003\"\u0011\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d6\u0003"+
		"&\u0013\u0000\u00d5\u00d0\u0001\u0000\u0000\u0000\u00d5\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d6#\u0001\u0000\u0000\u0000\u00d7\u00d8\u0007\u0001\u0000"+
		"\u0000\u00d8%\u0001\u0000\u0000\u0000\u00d9\u00da\u0006\u0013\uffff\uffff"+
		"\u0000\u00da\u00db\u0003*\u0015\u0000\u00db\u00e2\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\n\u0002\u0000\u0000\u00dd\u00de\u0003(\u0014\u0000\u00de"+
		"\u00df\u0003*\u0015\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00dc"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\'\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0007"+
		"\u0002\u0000\u0000\u00e6)\u0001\u0000\u0000\u0000\u00e7\u00e8\u0006\u0015"+
		"\uffff\uffff\u0000\u00e8\u00e9\u0003.\u0017\u0000\u00e9\u00f0\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\n\u0002\u0000\u0000\u00eb\u00ec\u0003,\u0016"+
		"\u0000\u00ec\u00ed\u0003.\u0017\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ea\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f1+\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0007\u0003\u0000\u0000\u00f4-\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0006\u0017\uffff\uffff\u0000\u00f6\u00f7\u00032\u0019\u0000\u00f7\u00fe"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\n\u0002\u0000\u0000\u00f9\u00fa\u0003"+
		"0\u0018\u0000\u00fa\u00fb\u00032\u0019\u0000\u00fb\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fc\u00f8\u0001\u0000\u0000\u0000\u00fd\u0100\u0001\u0000\u0000"+
		"\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000"+
		"\u0000\u00ff/\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0007\u0004\u0000\u0000\u01021\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0006\u0019\uffff\uffff\u0000\u0104\u0105\u00036\u001b\u0000\u0105"+
		"\u010c\u0001\u0000\u0000\u0000\u0106\u0107\n\u0002\u0000\u0000\u0107\u0108"+
		"\u00034\u001a\u0000\u0108\u0109\u00036\u001b\u0000\u0109\u010b\u0001\u0000"+
		"\u0000\u0000\u010a\u0106\u0001\u0000\u0000\u0000\u010b\u010e\u0001\u0000"+
		"\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d3\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\u0005\u001b\u0000\u0000\u01105\u0001\u0000\u0000\u0000"+
		"\u0111\u0115\u0003\u0018\f\u0000\u0112\u0115\u0003>\u001f\u0000\u0113"+
		"\u0115\u00038\u001c\u0000\u0114\u0111\u0001\u0000\u0000\u0000\u0114\u0112"+
		"\u0001\u0000\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u01157\u0001"+
		"\u0000\u0000\u0000\u0116\u011c\u0003:\u001d\u0000\u0117\u011c\u0005+\u0000"+
		"\u0000\u0118\u011c\u0005,\u0000\u0000\u0119\u011c\u0005.\u0000\u0000\u011a"+
		"\u011c\u0005-\u0000\u0000\u011b\u0116\u0001\u0000\u0000\u0000\u011b\u0117"+
		"\u0001\u0000\u0000\u0000\u011b\u0118\u0001\u0000\u0000\u0000\u011b\u0119"+
		"\u0001\u0000\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c9\u0001"+
		"\u0000\u0000\u0000\u011d\u011e\u0007\u0005\u0000\u0000\u011e;\u0001\u0000"+
		"\u0000\u0000\u011f\u0120\u0003>\u001f\u0000\u0120=\u0001\u0000\u0000\u0000"+
		"\u0121\u0132\u0003@ \u0000\u0122\u0124\u0005(\u0000\u0000\u0123\u0122"+
		"\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123"+
		"\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0128"+
		"\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u012c"+
		"\u0005\u0015\u0000\u0000\u0129\u012b\u0005(\u0000\u0000\u012a\u0129\u0001"+
		"\u0000\u0000\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012f\u0001"+
		"\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0131\u0003"+
		"@ \u0000\u0130\u0125\u0001\u0000\u0000\u0000\u0131\u0134\u0001\u0000\u0000"+
		"\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000"+
		"\u0000\u0133?\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0005/\u0000\u0000\u0136A\u0001\u0000\u0000\u0000\u001fE"+
		"LQW^ckr|\u0083\u0086\u008a\u0090\u009d\u00a1\u00a6\u00ab\u00b1\u00b8\u00c3"+
		"\u00cc\u00d5\u00e2\u00f0\u00fe\u010c\u0114\u011b\u0125\u012c\u0132";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}