// Generated from C:/Users/erik-/IdeaProjects/APRL/src/main/kotlin/aprl/grammar/AprlLexer.g4 by ANTLR 4.13.1
package aprl.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AprlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, VAR=2, VAL=3, EQUAL=4, LPAREN=5, RPAREN=6, LSQUARE=7, RSQUARE=8, 
		LCURLY=9, RCURLY=10, PERIOD=11, COMMA=12, PLUS=13, MINUS=14, ASTERISK=15, 
		DOUBLE_ASTERISK=16, SLASH=17, PERCENT=18, AND=19, OR=20, XOR=21, SHL=22, 
		SHR=23, USHR=24, NL=25, IntegerLiteral=26, FloatLiteral=27, CharLiteral=28, 
		StringLiteral=29, Identifier=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "VAR", "VAL", "EQUAL", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", 
			"LCURLY", "RCURLY", "PERIOD", "COMMA", "PLUS", "MINUS", "ASTERISK", "DOUBLE_ASTERISK", 
			"SLASH", "PERCENT", "AND", "OR", "XOR", "SHL", "SHR", "USHR", "NL", "IntegerLiteral", 
			"FloatLiteral", "CharLiteral", "StringLiteral", "Identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'var'", "'val'", "'='", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'.'", "','", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'&'", 
			"'|'", "'^'", "'<<'", "'>>'", "'>>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "VAR", "VAL", "EQUAL", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", 
			"LCURLY", "RCURLY", "PERIOD", "COMMA", "PLUS", "MINUS", "ASTERISK", "DOUBLE_ASTERISK", 
			"SLASH", "PERCENT", "AND", "OR", "XOR", "SHL", "SHR", "USHR", "NL", "IntegerLiteral", 
			"FloatLiteral", "CharLiteral", "StringLiteral", "Identifier"
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


	public AprlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AprlLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001e\u00a8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0003\u0018z\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0003\u0019\u007f\b\u0019\u0001\u0019\u0004\u0019"+
		"\u0082\b\u0019\u000b\u0019\f\u0019\u0083\u0001\u001a\u0003\u001a\u0087"+
		"\b\u001a\u0001\u001a\u0005\u001a\u008a\b\u001a\n\u001a\f\u001a\u008d\t"+
		"\u001a\u0001\u001a\u0001\u001a\u0004\u001a\u0091\b\u001a\u000b\u001a\f"+
		"\u001a\u0092\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0005\u001c\u009b\b\u001c\n\u001c\f\u001c\u009e\t\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0005\u001d\u00a4\b\u001d\n"+
		"\u001d\f\u001d\u00a7\t\u001d\u0000\u0000\u001e\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d;\u001e\u0001\u0000\u0006\u0003\u0000\t\t\f\f  \u0001\u0000"+
		"--\u0001\u000009\u0001\u0000\"\"\u0002\u0000AZaz\u0004\u000009AZ__az\u00af"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0001="+
		"\u0001\u0000\u0000\u0000\u0003A\u0001\u0000\u0000\u0000\u0005E\u0001\u0000"+
		"\u0000\u0000\u0007I\u0001\u0000\u0000\u0000\tK\u0001\u0000\u0000\u0000"+
		"\u000bM\u0001\u0000\u0000\u0000\rO\u0001\u0000\u0000\u0000\u000fQ\u0001"+
		"\u0000\u0000\u0000\u0011S\u0001\u0000\u0000\u0000\u0013U\u0001\u0000\u0000"+
		"\u0000\u0015W\u0001\u0000\u0000\u0000\u0017Y\u0001\u0000\u0000\u0000\u0019"+
		"[\u0001\u0000\u0000\u0000\u001b]\u0001\u0000\u0000\u0000\u001d_\u0001"+
		"\u0000\u0000\u0000\u001fa\u0001\u0000\u0000\u0000!d\u0001\u0000\u0000"+
		"\u0000#f\u0001\u0000\u0000\u0000%h\u0001\u0000\u0000\u0000\'j\u0001\u0000"+
		"\u0000\u0000)l\u0001\u0000\u0000\u0000+n\u0001\u0000\u0000\u0000-q\u0001"+
		"\u0000\u0000\u0000/t\u0001\u0000\u0000\u00001y\u0001\u0000\u0000\u0000"+
		"3~\u0001\u0000\u0000\u00005\u0086\u0001\u0000\u0000\u00007\u0094\u0001"+
		"\u0000\u0000\u00009\u0098\u0001\u0000\u0000\u0000;\u00a1\u0001\u0000\u0000"+
		"\u0000=>\u0007\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0006\u0000"+
		"\u0000\u0000@\u0002\u0001\u0000\u0000\u0000AB\u0005v\u0000\u0000BC\u0005"+
		"a\u0000\u0000CD\u0005r\u0000\u0000D\u0004\u0001\u0000\u0000\u0000EF\u0005"+
		"v\u0000\u0000FG\u0005a\u0000\u0000GH\u0005l\u0000\u0000H\u0006\u0001\u0000"+
		"\u0000\u0000IJ\u0005=\u0000\u0000J\b\u0001\u0000\u0000\u0000KL\u0005("+
		"\u0000\u0000L\n\u0001\u0000\u0000\u0000MN\u0005)\u0000\u0000N\f\u0001"+
		"\u0000\u0000\u0000OP\u0005[\u0000\u0000P\u000e\u0001\u0000\u0000\u0000"+
		"QR\u0005]\u0000\u0000R\u0010\u0001\u0000\u0000\u0000ST\u0005{\u0000\u0000"+
		"T\u0012\u0001\u0000\u0000\u0000UV\u0005}\u0000\u0000V\u0014\u0001\u0000"+
		"\u0000\u0000WX\u0005.\u0000\u0000X\u0016\u0001\u0000\u0000\u0000YZ\u0005"+
		",\u0000\u0000Z\u0018\u0001\u0000\u0000\u0000[\\\u0005+\u0000\u0000\\\u001a"+
		"\u0001\u0000\u0000\u0000]^\u0005-\u0000\u0000^\u001c\u0001\u0000\u0000"+
		"\u0000_`\u0005*\u0000\u0000`\u001e\u0001\u0000\u0000\u0000ab\u0005*\u0000"+
		"\u0000bc\u0005*\u0000\u0000c \u0001\u0000\u0000\u0000de\u0005/\u0000\u0000"+
		"e\"\u0001\u0000\u0000\u0000fg\u0005%\u0000\u0000g$\u0001\u0000\u0000\u0000"+
		"hi\u0005&\u0000\u0000i&\u0001\u0000\u0000\u0000jk\u0005|\u0000\u0000k"+
		"(\u0001\u0000\u0000\u0000lm\u0005^\u0000\u0000m*\u0001\u0000\u0000\u0000"+
		"no\u0005<\u0000\u0000op\u0005<\u0000\u0000p,\u0001\u0000\u0000\u0000q"+
		"r\u0005>\u0000\u0000rs\u0005>\u0000\u0000s.\u0001\u0000\u0000\u0000tu"+
		"\u0005>\u0000\u0000uv\u0005>\u0000\u0000vw\u0005>\u0000\u0000w0\u0001"+
		"\u0000\u0000\u0000xz\u0005\r\u0000\u0000yx\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0005\n\u0000\u0000|2\u0001"+
		"\u0000\u0000\u0000}\u007f\u0007\u0001\u0000\u0000~}\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u0007\u0002\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0001\u0000\u0000\u0000\u00844\u0001\u0000\u0000\u0000\u0085"+
		"\u0087\u0007\u0001\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u008b\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0007\u0002\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008e\u0090\u0005.\u0000\u0000\u008f\u0091"+
		"\u0007\u0002\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0001\u0000\u0000\u0000\u00936\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\'\u0000\u0000\u0095\u0096\t\u0000\u0000\u0000\u0096\u0097\u0005\'\u0000"+
		"\u0000\u00978\u0001\u0000\u0000\u0000\u0098\u009c\u0005\"\u0000\u0000"+
		"\u0099\u009b\b\u0003\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\"\u0000\u0000\u00a0:"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a5\u0007\u0004\u0000\u0000\u00a2\u00a4"+
		"\u0007\u0005\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6<\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001"+
		"\u0000\u0000\u0000\t\u0000y~\u0083\u0086\u008b\u0092\u009c\u00a5\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}