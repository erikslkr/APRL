// Generated from /home/erik/Documents/IdeaProjects/APRL/src/main/kotlin/aprl/grammar/AprlLexer.g4 by ANTLR 4.13.1
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
		LineComment=1, WS=2, NL=3, VAR=4, VAL=5, FUNCTION=6, RETURN=7, EQUAL=8, 
		DOUBLE_EQUAL=9, TRIPLE_EQUAL=10, NOT_EQUAL=11, NOT_DOUBLE_EQUAL=12, LANGLE=13, 
		RANGLE=14, LANGLE_EQUAL=15, RANGLE_EQUAL=16, LPAREN=17, RPAREN=18, LSQUARE=19, 
		RSQUARE=20, LCURLY=21, RCURLY=22, PERIOD=23, COMMA=24, COLON=25, EXCL=26, 
		TILDE=27, RIGHT_ARROW=28, HASH=29, PLUS=30, MINUS=31, ASTERISK=32, DOUBLE_ASTERISK=33, 
		SLASH=34, BACKSLASH=35, PERCENT=36, AND=37, DOUBLE_AND=38, OR=39, DOUBLE_OR=40, 
		XOR=41, SHL=42, SHR=43, USHR=44, TRUE=45, FALSE=46, IntegerLiteral=47, 
		FloatLiteral=48, CharLiteral=49, StringLiteral=50, Identifier=51;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LineComment", "WS", "NL", "VAR", "VAL", "FUNCTION", "RETURN", "EQUAL", 
			"DOUBLE_EQUAL", "TRIPLE_EQUAL", "NOT_EQUAL", "NOT_DOUBLE_EQUAL", "LANGLE", 
			"RANGLE", "LANGLE_EQUAL", "RANGLE_EQUAL", "LPAREN", "RPAREN", "LSQUARE", 
			"RSQUARE", "LCURLY", "RCURLY", "PERIOD", "COMMA", "COLON", "EXCL", "TILDE", 
			"RIGHT_ARROW", "HASH", "PLUS", "MINUS", "ASTERISK", "DOUBLE_ASTERISK", 
			"SLASH", "BACKSLASH", "PERCENT", "AND", "DOUBLE_AND", "OR", "DOUBLE_OR", 
			"XOR", "SHL", "SHR", "USHR", "TRUE", "FALSE", "IntegerLiteral", "FloatLiteral", 
			"CharLiteral", "StringLiteral", "Identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'var'", "'val'", "'function'", "'return'", "'='", 
			"'=='", "'==='", "'!='", "'!=='", "'<'", "'>'", "'<='", "'>='", "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'.'", "','", "':'", "'!'", "'~'", 
			"'->'", "'#'", "'+'", "'-'", "'*'", "'**'", "'/'", "'\\'", "'%'", "'&'", 
			"'&&'", "'|'", "'||'", "'^'", "'<<'", "'>>'", "'>>>'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LineComment", "WS", "NL", "VAR", "VAL", "FUNCTION", "RETURN", 
			"EQUAL", "DOUBLE_EQUAL", "TRIPLE_EQUAL", "NOT_EQUAL", "NOT_DOUBLE_EQUAL", 
			"LANGLE", "RANGLE", "LANGLE_EQUAL", "RANGLE_EQUAL", "LPAREN", "RPAREN", 
			"LSQUARE", "RSQUARE", "LCURLY", "RCURLY", "PERIOD", "COMMA", "COLON", 
			"EXCL", "TILDE", "RIGHT_ARROW", "HASH", "PLUS", "MINUS", "ASTERISK", 
			"DOUBLE_ASTERISK", "SLASH", "BACKSLASH", "PERCENT", "AND", "DOUBLE_AND", 
			"OR", "DOUBLE_OR", "XOR", "SHL", "SHR", "USHR", "TRUE", "FALSE", "IntegerLiteral", 
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
		"\u0004\u00003\u0121\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u0001\u0000\u0001\u0000\u0005\u0000j\b\u0000"+
		"\n\u0000\f\u0000m\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0003\u0002v\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001"+
		"+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001.\u0003.\u00f8\b.\u0001.\u0004.\u00fb"+
		"\b.\u000b.\f.\u00fc\u0001/\u0003/\u0100\b/\u0001/\u0005/\u0103\b/\n/\f"+
		"/\u0106\t/\u0001/\u0001/\u0004/\u010a\b/\u000b/\f/\u010b\u00010\u0001"+
		"0\u00010\u00010\u00011\u00011\u00051\u0114\b1\n1\f1\u0117\t1\u00011\u0001"+
		"1\u00012\u00012\u00052\u011d\b2\n2\f2\u0120\t2\u0000\u00003\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O("+
		"Q)S*U+W,Y-[.]/_0a1c2e3\u0001\u0000\u0007\u0002\u0000\n\n\r\r\u0003\u0000"+
		"\t\t\f\f  \u0001\u0000--\u0001\u000009\u0001\u0000\"\"\u0002\u0000AZa"+
		"z\u0004\u000009AZ__az\u0129\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000"+
		"\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I"+
		"\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000"+
		"\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000"+
		"\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W"+
		"\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000"+
		"\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000"+
		"\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e"+
		"\u0001\u0000\u0000\u0000\u0001g\u0001\u0000\u0000\u0000\u0003p\u0001\u0000"+
		"\u0000\u0000\u0005u\u0001\u0000\u0000\u0000\u0007y\u0001\u0000\u0000\u0000"+
		"\t}\u0001\u0000\u0000\u0000\u000b\u0081\u0001\u0000\u0000\u0000\r\u008a"+
		"\u0001\u0000\u0000\u0000\u000f\u0091\u0001\u0000\u0000\u0000\u0011\u0093"+
		"\u0001\u0000\u0000\u0000\u0013\u0096\u0001\u0000\u0000\u0000\u0015\u009a"+
		"\u0001\u0000\u0000\u0000\u0017\u009d\u0001\u0000\u0000\u0000\u0019\u00a1"+
		"\u0001\u0000\u0000\u0000\u001b\u00a3\u0001\u0000\u0000\u0000\u001d\u00a5"+
		"\u0001\u0000\u0000\u0000\u001f\u00a8\u0001\u0000\u0000\u0000!\u00ab\u0001"+
		"\u0000\u0000\u0000#\u00ad\u0001\u0000\u0000\u0000%\u00af\u0001\u0000\u0000"+
		"\u0000\'\u00b1\u0001\u0000\u0000\u0000)\u00b3\u0001\u0000\u0000\u0000"+
		"+\u00b5\u0001\u0000\u0000\u0000-\u00b7\u0001\u0000\u0000\u0000/\u00b9"+
		"\u0001\u0000\u0000\u00001\u00bb\u0001\u0000\u0000\u00003\u00bd\u0001\u0000"+
		"\u0000\u00005\u00bf\u0001\u0000\u0000\u00007\u00c1\u0001\u0000\u0000\u0000"+
		"9\u00c4\u0001\u0000\u0000\u0000;\u00c6\u0001\u0000\u0000\u0000=\u00c8"+
		"\u0001\u0000\u0000\u0000?\u00ca\u0001\u0000\u0000\u0000A\u00cc\u0001\u0000"+
		"\u0000\u0000C\u00cf\u0001\u0000\u0000\u0000E\u00d1\u0001\u0000\u0000\u0000"+
		"G\u00d3\u0001\u0000\u0000\u0000I\u00d5\u0001\u0000\u0000\u0000K\u00d7"+
		"\u0001\u0000\u0000\u0000M\u00da\u0001\u0000\u0000\u0000O\u00dc\u0001\u0000"+
		"\u0000\u0000Q\u00df\u0001\u0000\u0000\u0000S\u00e1\u0001\u0000\u0000\u0000"+
		"U\u00e4\u0001\u0000\u0000\u0000W\u00e7\u0001\u0000\u0000\u0000Y\u00eb"+
		"\u0001\u0000\u0000\u0000[\u00f0\u0001\u0000\u0000\u0000]\u00f7\u0001\u0000"+
		"\u0000\u0000_\u00ff\u0001\u0000\u0000\u0000a\u010d\u0001\u0000\u0000\u0000"+
		"c\u0111\u0001\u0000\u0000\u0000e\u011a\u0001\u0000\u0000\u0000gk\u0005"+
		"#\u0000\u0000hj\b\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000"+
		"ln\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0006\u0000\u0000"+
		"\u0000o\u0002\u0001\u0000\u0000\u0000pq\u0007\u0001\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rs\u0006\u0001\u0001\u0000s\u0004\u0001\u0000\u0000"+
		"\u0000tv\u0005\r\u0000\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wx\u0005\n\u0000\u0000x\u0006\u0001\u0000"+
		"\u0000\u0000yz\u0005v\u0000\u0000z{\u0005a\u0000\u0000{|\u0005r\u0000"+
		"\u0000|\b\u0001\u0000\u0000\u0000}~\u0005v\u0000\u0000~\u007f\u0005a\u0000"+
		"\u0000\u007f\u0080\u0005l\u0000\u0000\u0080\n\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005f\u0000\u0000\u0082\u0083\u0005u\u0000\u0000\u0083\u0084"+
		"\u0005n\u0000\u0000\u0084\u0085\u0005c\u0000\u0000\u0085\u0086\u0005t"+
		"\u0000\u0000\u0086\u0087\u0005i\u0000\u0000\u0087\u0088\u0005o\u0000\u0000"+
		"\u0088\u0089\u0005n\u0000\u0000\u0089\f\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005r\u0000\u0000\u008b\u008c\u0005e\u0000\u0000\u008c\u008d\u0005"+
		"t\u0000\u0000\u008d\u008e\u0005u\u0000\u0000\u008e\u008f\u0005r\u0000"+
		"\u0000\u008f\u0090\u0005n\u0000\u0000\u0090\u000e\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005=\u0000\u0000\u0092\u0010\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0005=\u0000\u0000\u0094\u0095\u0005=\u0000\u0000\u0095\u0012\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0005=\u0000\u0000\u0097\u0098\u0005=\u0000"+
		"\u0000\u0098\u0099\u0005=\u0000\u0000\u0099\u0014\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0005!\u0000\u0000\u009b\u009c\u0005=\u0000\u0000\u009c\u0016"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0005!\u0000\u0000\u009e\u009f\u0005"+
		"=\u0000\u0000\u009f\u00a0\u0005=\u0000\u0000\u00a0\u0018\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005<\u0000\u0000\u00a2\u001a\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0005>\u0000\u0000\u00a4\u001c\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005<\u0000\u0000\u00a6\u00a7\u0005=\u0000\u0000\u00a7\u001e\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0005>\u0000\u0000\u00a9\u00aa\u0005=\u0000"+
		"\u0000\u00aa \u0001\u0000\u0000\u0000\u00ab\u00ac\u0005(\u0000\u0000\u00ac"+
		"\"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005)\u0000\u0000\u00ae$\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0005[\u0000\u0000\u00b0&\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0005]\u0000\u0000\u00b2(\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0005{\u0000\u0000\u00b4*\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005"+
		"}\u0000\u0000\u00b6,\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005.\u0000"+
		"\u0000\u00b8.\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005,\u0000\u0000\u00ba"+
		"0\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005:\u0000\u0000\u00bc2\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0005!\u0000\u0000\u00be4\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0005~\u0000\u0000\u00c06\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0005-\u0000\u0000\u00c2\u00c3\u0005>\u0000\u0000\u00c38\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0005#\u0000\u0000\u00c5:\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0005+\u0000\u0000\u00c7<\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005-\u0000\u0000\u00c9>\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005"+
		"*\u0000\u0000\u00cb@\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005*\u0000"+
		"\u0000\u00cd\u00ce\u0005*\u0000\u0000\u00ceB\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0005/\u0000\u0000\u00d0D\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005"+
		"\\\u0000\u0000\u00d2F\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005%\u0000"+
		"\u0000\u00d4H\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005&\u0000\u0000\u00d6"+
		"J\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005&\u0000\u0000\u00d8\u00d9\u0005"+
		"&\u0000\u0000\u00d9L\u0001\u0000\u0000\u0000\u00da\u00db\u0005|\u0000"+
		"\u0000\u00dbN\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005|\u0000\u0000\u00dd"+
		"\u00de\u0005|\u0000\u0000\u00deP\u0001\u0000\u0000\u0000\u00df\u00e0\u0005"+
		"^\u0000\u0000\u00e0R\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005<\u0000"+
		"\u0000\u00e2\u00e3\u0005<\u0000\u0000\u00e3T\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0005>\u0000\u0000\u00e5\u00e6\u0005>\u0000\u0000\u00e6V\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0005>\u0000\u0000\u00e8\u00e9\u0005>\u0000"+
		"\u0000\u00e9\u00ea\u0005>\u0000\u0000\u00eaX\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\u0005t\u0000\u0000\u00ec\u00ed\u0005r\u0000\u0000\u00ed\u00ee\u0005"+
		"u\u0000\u0000\u00ee\u00ef\u0005e\u0000\u0000\u00efZ\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0005f\u0000\u0000\u00f1\u00f2\u0005a\u0000\u0000\u00f2"+
		"\u00f3\u0005l\u0000\u0000\u00f3\u00f4\u0005s\u0000\u0000\u00f4\u00f5\u0005"+
		"e\u0000\u0000\u00f5\\\u0001\u0000\u0000\u0000\u00f6\u00f8\u0007\u0002"+
		"\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000\u00f9\u00fb\u0007\u0003"+
		"\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd^\u0001\u0000\u0000\u0000\u00fe\u0100\u0007\u0002\u0000"+
		"\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000"+
		"\u0000\u0100\u0104\u0001\u0000\u0000\u0000\u0101\u0103\u0007\u0003\u0000"+
		"\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000"+
		"\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000"+
		"\u0000\u0105\u0107\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0107\u0109\u0005.\u0000\u0000\u0108\u010a\u0007\u0003\u0000\u0000"+
		"\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000"+
		"\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000"+
		"\u010c`\u0001\u0000\u0000\u0000\u010d\u010e\u0005\'\u0000\u0000\u010e"+
		"\u010f\t\u0000\u0000\u0000\u010f\u0110\u0005\'\u0000\u0000\u0110b\u0001"+
		"\u0000\u0000\u0000\u0111\u0115\u0005\"\u0000\u0000\u0112\u0114\b\u0004"+
		"\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000"+
		"\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000"+
		"\u0000\u0000\u0118\u0119\u0005\"\u0000\u0000\u0119d\u0001\u0000\u0000"+
		"\u0000\u011a\u011e\u0007\u0005\u0000\u0000\u011b\u011d\u0007\u0006\u0000"+
		"\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d\u0120\u0001\u0000\u0000"+
		"\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000"+
		"\u0000\u011ff\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000"+
		"\n\u0000ku\u00f7\u00fc\u00ff\u0104\u010b\u0115\u011e\u0002\u0000\u0001"+
		"\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}