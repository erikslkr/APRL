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
		LineComment=1, WS=2, NL=3, VAR=4, VAL=5, IF=6, ELSE=7, UNLESS=8, WHILE=9, 
		PRIVATE=10, PROTECTED=11, INTERNAL=12, PUBLIC=13, FUNCTION=14, RETURN=15, 
		EQUAL=16, DOUBLE_EQUAL=17, TRIPLE_EQUAL=18, NOT_EQUAL=19, NOT_DOUBLE_EQUAL=20, 
		LANGLE=21, RANGLE=22, LANGLE_EQUAL=23, RANGLE_EQUAL=24, LPAREN=25, RPAREN=26, 
		LSQUARE=27, RSQUARE=28, LCURLY=29, RCURLY=30, PERIOD=31, COMMA=32, COLON=33, 
		EXCL=34, TILDE=35, RIGHT_ARROW=36, HASH=37, PLUS=38, MINUS=39, ASTERISK=40, 
		DOUBLE_ASTERISK=41, SLASH=42, DOUBLE_SLASH=43, BACKSLASH=44, PERCENT=45, 
		AND=46, DOUBLE_AND=47, OR=48, DOUBLE_OR=49, XOR=50, SHL=51, SHR=52, USHR=53, 
		TRUE=54, FALSE=55, IntegerLiteral=56, FloatLiteral=57, CharLiteral=58, 
		StringLiteral=59, Identifier=60;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LineComment", "WS", "NL", "VAR", "VAL", "IF", "ELSE", "UNLESS", "WHILE", 
			"PRIVATE", "PROTECTED", "INTERNAL", "PUBLIC", "FUNCTION", "RETURN", "EQUAL", 
			"DOUBLE_EQUAL", "TRIPLE_EQUAL", "NOT_EQUAL", "NOT_DOUBLE_EQUAL", "LANGLE", 
			"RANGLE", "LANGLE_EQUAL", "RANGLE_EQUAL", "LPAREN", "RPAREN", "LSQUARE", 
			"RSQUARE", "LCURLY", "RCURLY", "PERIOD", "COMMA", "COLON", "EXCL", "TILDE", 
			"RIGHT_ARROW", "HASH", "PLUS", "MINUS", "ASTERISK", "DOUBLE_ASTERISK", 
			"SLASH", "DOUBLE_SLASH", "BACKSLASH", "PERCENT", "AND", "DOUBLE_AND", 
			"OR", "DOUBLE_OR", "XOR", "SHL", "SHR", "USHR", "TRUE", "FALSE", "IntegerLiteral", 
			"FloatLiteral", "CharLiteral", "StringLiteral", "Identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'var'", "'val'", "'if'", "'else'", "'unless'", 
			"'while'", "'private'", "'protected'", "'internal'", "'public'", "'function'", 
			"'return'", "'='", "'=='", "'==='", "'!='", "'!=='", "'<'", "'>'", "'<='", 
			"'>='", "'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "','", "':'", 
			"'!'", "'~'", "'->'", "'#'", "'+'", "'-'", "'*'", "'**'", "'/'", "'//'", 
			"'\\'", "'%'", "'&'", "'&&'", "'|'", "'||'", "'^'", "'<<'", "'>>'", "'>>>'", 
			"'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LineComment", "WS", "NL", "VAR", "VAL", "IF", "ELSE", "UNLESS", 
			"WHILE", "PRIVATE", "PROTECTED", "INTERNAL", "PUBLIC", "FUNCTION", "RETURN", 
			"EQUAL", "DOUBLE_EQUAL", "TRIPLE_EQUAL", "NOT_EQUAL", "NOT_DOUBLE_EQUAL", 
			"LANGLE", "RANGLE", "LANGLE_EQUAL", "RANGLE_EQUAL", "LPAREN", "RPAREN", 
			"LSQUARE", "RSQUARE", "LCURLY", "RCURLY", "PERIOD", "COMMA", "COLON", 
			"EXCL", "TILDE", "RIGHT_ARROW", "HASH", "PLUS", "MINUS", "ASTERISK", 
			"DOUBLE_ASTERISK", "SLASH", "DOUBLE_SLASH", "BACKSLASH", "PERCENT", "AND", 
			"DOUBLE_AND", "OR", "DOUBLE_OR", "XOR", "SHL", "SHR", "USHR", "TRUE", 
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
		"\u0004\u0000<\u016d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0001\u0000\u0001\u0000\u0005\u0000|\b\u0000\n\u0000\f"+
		"\u0000\u007f\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0003\u0002\u0088\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001"+
		"#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001"+
		"(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001*\u0001+\u0001+\u0001,\u0001"+
		",\u0001-\u0001-\u0001.\u0001.\u0001.\u0001/\u0001/\u00010\u00010\u0001"+
		"0\u00011\u00011\u00012\u00012\u00012\u00013\u00013\u00013\u00014\u0001"+
		"4\u00014\u00014\u00015\u00015\u00015\u00015\u00015\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00017\u00037\u0144\b7\u00017\u00047\u0147\b7\u000b"+
		"7\f7\u0148\u00018\u00038\u014c\b8\u00018\u00058\u014f\b8\n8\f8\u0152\t"+
		"8\u00018\u00018\u00048\u0156\b8\u000b8\f8\u0157\u00019\u00019\u00019\u0001"+
		"9\u0001:\u0001:\u0005:\u0160\b:\n:\f:\u0163\t:\u0001:\u0001:\u0001;\u0001"+
		";\u0005;\u0169\b;\n;\f;\u016c\t;\u0000\u0000<\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e"+
		"3g4i5k6m7o8q9s:u;w<\u0001\u0000\u0007\u0002\u0000\n\n\r\r\u0003\u0000"+
		"\t\t\f\f  \u0001\u0000--\u0001\u000009\u0001\u0000\"\"\u0002\u0000AZa"+
		"z\u0004\u000009AZ__az\u0175\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
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
		"\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000"+
		"\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000"+
		"\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0000s"+
		"\u0001\u0000\u0000\u0000\u0000u\u0001\u0000\u0000\u0000\u0000w\u0001\u0000"+
		"\u0000\u0000\u0001y\u0001\u0000\u0000\u0000\u0003\u0082\u0001\u0000\u0000"+
		"\u0000\u0005\u0087\u0001\u0000\u0000\u0000\u0007\u008b\u0001\u0000\u0000"+
		"\u0000\t\u008f\u0001\u0000\u0000\u0000\u000b\u0093\u0001\u0000\u0000\u0000"+
		"\r\u0096\u0001\u0000\u0000\u0000\u000f\u009b\u0001\u0000\u0000\u0000\u0011"+
		"\u00a2\u0001\u0000\u0000\u0000\u0013\u00a8\u0001\u0000\u0000\u0000\u0015"+
		"\u00b0\u0001\u0000\u0000\u0000\u0017\u00ba\u0001\u0000\u0000\u0000\u0019"+
		"\u00c3\u0001\u0000\u0000\u0000\u001b\u00ca\u0001\u0000\u0000\u0000\u001d"+
		"\u00d3\u0001\u0000\u0000\u0000\u001f\u00da\u0001\u0000\u0000\u0000!\u00dc"+
		"\u0001\u0000\u0000\u0000#\u00df\u0001\u0000\u0000\u0000%\u00e3\u0001\u0000"+
		"\u0000\u0000\'\u00e6\u0001\u0000\u0000\u0000)\u00ea\u0001\u0000\u0000"+
		"\u0000+\u00ec\u0001\u0000\u0000\u0000-\u00ee\u0001\u0000\u0000\u0000/"+
		"\u00f1\u0001\u0000\u0000\u00001\u00f4\u0001\u0000\u0000\u00003\u00f6\u0001"+
		"\u0000\u0000\u00005\u00f8\u0001\u0000\u0000\u00007\u00fa\u0001\u0000\u0000"+
		"\u00009\u00fc\u0001\u0000\u0000\u0000;\u00fe\u0001\u0000\u0000\u0000="+
		"\u0100\u0001\u0000\u0000\u0000?\u0102\u0001\u0000\u0000\u0000A\u0104\u0001"+
		"\u0000\u0000\u0000C\u0106\u0001\u0000\u0000\u0000E\u0108\u0001\u0000\u0000"+
		"\u0000G\u010a\u0001\u0000\u0000\u0000I\u010d\u0001\u0000\u0000\u0000K"+
		"\u010f\u0001\u0000\u0000\u0000M\u0111\u0001\u0000\u0000\u0000O\u0113\u0001"+
		"\u0000\u0000\u0000Q\u0115\u0001\u0000\u0000\u0000S\u0118\u0001\u0000\u0000"+
		"\u0000U\u011a\u0001\u0000\u0000\u0000W\u011d\u0001\u0000\u0000\u0000Y"+
		"\u011f\u0001\u0000\u0000\u0000[\u0121\u0001\u0000\u0000\u0000]\u0123\u0001"+
		"\u0000\u0000\u0000_\u0126\u0001\u0000\u0000\u0000a\u0128\u0001\u0000\u0000"+
		"\u0000c\u012b\u0001\u0000\u0000\u0000e\u012d\u0001\u0000\u0000\u0000g"+
		"\u0130\u0001\u0000\u0000\u0000i\u0133\u0001\u0000\u0000\u0000k\u0137\u0001"+
		"\u0000\u0000\u0000m\u013c\u0001\u0000\u0000\u0000o\u0143\u0001\u0000\u0000"+
		"\u0000q\u014b\u0001\u0000\u0000\u0000s\u0159\u0001\u0000\u0000\u0000u"+
		"\u015d\u0001\u0000\u0000\u0000w\u0166\u0001\u0000\u0000\u0000y}\u0005"+
		"#\u0000\u0000z|\b\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0080\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0006\u0000\u0000\u0000\u0081\u0002\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0007\u0001\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0006\u0001\u0001\u0000\u0085\u0004\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0005\r\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\n\u0000\u0000\u008a\u0006\u0001\u0000\u0000\u0000\u008b\u008c\u0005v"+
		"\u0000\u0000\u008c\u008d\u0005a\u0000\u0000\u008d\u008e\u0005r\u0000\u0000"+
		"\u008e\b\u0001\u0000\u0000\u0000\u008f\u0090\u0005v\u0000\u0000\u0090"+
		"\u0091\u0005a\u0000\u0000\u0091\u0092\u0005l\u0000\u0000\u0092\n\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005i\u0000\u0000\u0094\u0095\u0005f\u0000"+
		"\u0000\u0095\f\u0001\u0000\u0000\u0000\u0096\u0097\u0005e\u0000\u0000"+
		"\u0097\u0098\u0005l\u0000\u0000\u0098\u0099\u0005s\u0000\u0000\u0099\u009a"+
		"\u0005e\u0000\u0000\u009a\u000e\u0001\u0000\u0000\u0000\u009b\u009c\u0005"+
		"u\u0000\u0000\u009c\u009d\u0005n\u0000\u0000\u009d\u009e\u0005l\u0000"+
		"\u0000\u009e\u009f\u0005e\u0000\u0000\u009f\u00a0\u0005s\u0000\u0000\u00a0"+
		"\u00a1\u0005s\u0000\u0000\u00a1\u0010\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0005w\u0000\u0000\u00a3\u00a4\u0005h\u0000\u0000\u00a4\u00a5\u0005i"+
		"\u0000\u0000\u00a5\u00a6\u0005l\u0000\u0000\u00a6\u00a7\u0005e\u0000\u0000"+
		"\u00a7\u0012\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005p\u0000\u0000\u00a9"+
		"\u00aa\u0005r\u0000\u0000\u00aa\u00ab\u0005i\u0000\u0000\u00ab\u00ac\u0005"+
		"v\u0000\u0000\u00ac\u00ad\u0005a\u0000\u0000\u00ad\u00ae\u0005t\u0000"+
		"\u0000\u00ae\u00af\u0005e\u0000\u0000\u00af\u0014\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0005p\u0000\u0000\u00b1\u00b2\u0005r\u0000\u0000\u00b2\u00b3"+
		"\u0005o\u0000\u0000\u00b3\u00b4\u0005t\u0000\u0000\u00b4\u00b5\u0005e"+
		"\u0000\u0000\u00b5\u00b6\u0005c\u0000\u0000\u00b6\u00b7\u0005t\u0000\u0000"+
		"\u00b7\u00b8\u0005e\u0000\u0000\u00b8\u00b9\u0005d\u0000\u0000\u00b9\u0016"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005i\u0000\u0000\u00bb\u00bc\u0005"+
		"n\u0000\u0000\u00bc\u00bd\u0005t\u0000\u0000\u00bd\u00be\u0005e\u0000"+
		"\u0000\u00be\u00bf\u0005r\u0000\u0000\u00bf\u00c0\u0005n\u0000\u0000\u00c0"+
		"\u00c1\u0005a\u0000\u0000\u00c1\u00c2\u0005l\u0000\u0000\u00c2\u0018\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0005p\u0000\u0000\u00c4\u00c5\u0005u\u0000"+
		"\u0000\u00c5\u00c6\u0005b\u0000\u0000\u00c6\u00c7\u0005l\u0000\u0000\u00c7"+
		"\u00c8\u0005i\u0000\u0000\u00c8\u00c9\u0005c\u0000\u0000\u00c9\u001a\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0005f\u0000\u0000\u00cb\u00cc\u0005u\u0000"+
		"\u0000\u00cc\u00cd\u0005n\u0000\u0000\u00cd\u00ce\u0005c\u0000\u0000\u00ce"+
		"\u00cf\u0005t\u0000\u0000\u00cf\u00d0\u0005i\u0000\u0000\u00d0\u00d1\u0005"+
		"o\u0000\u0000\u00d1\u00d2\u0005n\u0000\u0000\u00d2\u001c\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0005r\u0000\u0000\u00d4\u00d5\u0005e\u0000\u0000\u00d5"+
		"\u00d6\u0005t\u0000\u0000\u00d6\u00d7\u0005u\u0000\u0000\u00d7\u00d8\u0005"+
		"r\u0000\u0000\u00d8\u00d9\u0005n\u0000\u0000\u00d9\u001e\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0005=\u0000\u0000\u00db \u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0005=\u0000\u0000\u00dd\u00de\u0005=\u0000\u0000\u00de\"\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0005=\u0000\u0000\u00e0\u00e1\u0005=\u0000"+
		"\u0000\u00e1\u00e2\u0005=\u0000\u0000\u00e2$\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0005!\u0000\u0000\u00e4\u00e5\u0005=\u0000\u0000\u00e5&\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0005!\u0000\u0000\u00e7\u00e8\u0005=\u0000"+
		"\u0000\u00e8\u00e9\u0005=\u0000\u0000\u00e9(\u0001\u0000\u0000\u0000\u00ea"+
		"\u00eb\u0005<\u0000\u0000\u00eb*\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005"+
		">\u0000\u0000\u00ed,\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005<\u0000"+
		"\u0000\u00ef\u00f0\u0005=\u0000\u0000\u00f0.\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f2\u0005>\u0000\u0000\u00f2\u00f3\u0005=\u0000\u0000\u00f30\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0005(\u0000\u0000\u00f52\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0005)\u0000\u0000\u00f74\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0005[\u0000\u0000\u00f96\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005"+
		"]\u0000\u0000\u00fb8\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005{\u0000"+
		"\u0000\u00fd:\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005}\u0000\u0000\u00ff"+
		"<\u0001\u0000\u0000\u0000\u0100\u0101\u0005.\u0000\u0000\u0101>\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0005,\u0000\u0000\u0103@\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0005:\u0000\u0000\u0105B\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0005!\u0000\u0000\u0107D\u0001\u0000\u0000\u0000\u0108\u0109\u0005"+
		"~\u0000\u0000\u0109F\u0001\u0000\u0000\u0000\u010a\u010b\u0005-\u0000"+
		"\u0000\u010b\u010c\u0005>\u0000\u0000\u010cH\u0001\u0000\u0000\u0000\u010d"+
		"\u010e\u0005#\u0000\u0000\u010eJ\u0001\u0000\u0000\u0000\u010f\u0110\u0005"+
		"+\u0000\u0000\u0110L\u0001\u0000\u0000\u0000\u0111\u0112\u0005-\u0000"+
		"\u0000\u0112N\u0001\u0000\u0000\u0000\u0113\u0114\u0005*\u0000\u0000\u0114"+
		"P\u0001\u0000\u0000\u0000\u0115\u0116\u0005*\u0000\u0000\u0116\u0117\u0005"+
		"*\u0000\u0000\u0117R\u0001\u0000\u0000\u0000\u0118\u0119\u0005/\u0000"+
		"\u0000\u0119T\u0001\u0000\u0000\u0000\u011a\u011b\u0005/\u0000\u0000\u011b"+
		"\u011c\u0005/\u0000\u0000\u011cV\u0001\u0000\u0000\u0000\u011d\u011e\u0005"+
		"\\\u0000\u0000\u011eX\u0001\u0000\u0000\u0000\u011f\u0120\u0005%\u0000"+
		"\u0000\u0120Z\u0001\u0000\u0000\u0000\u0121\u0122\u0005&\u0000\u0000\u0122"+
		"\\\u0001\u0000\u0000\u0000\u0123\u0124\u0005&\u0000\u0000\u0124\u0125"+
		"\u0005&\u0000\u0000\u0125^\u0001\u0000\u0000\u0000\u0126\u0127\u0005|"+
		"\u0000\u0000\u0127`\u0001\u0000\u0000\u0000\u0128\u0129\u0005|\u0000\u0000"+
		"\u0129\u012a\u0005|\u0000\u0000\u012ab\u0001\u0000\u0000\u0000\u012b\u012c"+
		"\u0005^\u0000\u0000\u012cd\u0001\u0000\u0000\u0000\u012d\u012e\u0005<"+
		"\u0000\u0000\u012e\u012f\u0005<\u0000\u0000\u012ff\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0005>\u0000\u0000\u0131\u0132\u0005>\u0000\u0000\u0132h"+
		"\u0001\u0000\u0000\u0000\u0133\u0134\u0005>\u0000\u0000\u0134\u0135\u0005"+
		">\u0000\u0000\u0135\u0136\u0005>\u0000\u0000\u0136j\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0005t\u0000\u0000\u0138\u0139\u0005r\u0000\u0000\u0139"+
		"\u013a\u0005u\u0000\u0000\u013a\u013b\u0005e\u0000\u0000\u013bl\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0005f\u0000\u0000\u013d\u013e\u0005a\u0000"+
		"\u0000\u013e\u013f\u0005l\u0000\u0000\u013f\u0140\u0005s\u0000\u0000\u0140"+
		"\u0141\u0005e\u0000\u0000\u0141n\u0001\u0000\u0000\u0000\u0142\u0144\u0007"+
		"\u0002\u0000\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0143\u0144\u0001"+
		"\u0000\u0000\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145\u0147\u0007"+
		"\u0003\u0000\u0000\u0146\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001"+
		"\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001"+
		"\u0000\u0000\u0000\u0149p\u0001\u0000\u0000\u0000\u014a\u014c\u0007\u0002"+
		"\u0000\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000"+
		"\u0000\u0000\u014c\u0150\u0001\u0000\u0000\u0000\u014d\u014f\u0007\u0003"+
		"\u0000\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014f\u0152\u0001\u0000"+
		"\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000"+
		"\u0000\u0000\u0151\u0153\u0001\u0000\u0000\u0000\u0152\u0150\u0001\u0000"+
		"\u0000\u0000\u0153\u0155\u0005.\u0000\u0000\u0154\u0156\u0007\u0003\u0000"+
		"\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000"+
		"\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000"+
		"\u0000\u0158r\u0001\u0000\u0000\u0000\u0159\u015a\u0005\'\u0000\u0000"+
		"\u015a\u015b\t\u0000\u0000\u0000\u015b\u015c\u0005\'\u0000\u0000\u015c"+
		"t\u0001\u0000\u0000\u0000\u015d\u0161\u0005\"\u0000\u0000\u015e\u0160"+
		"\b\u0004\u0000\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u0160\u0163\u0001"+
		"\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0161\u0162\u0001"+
		"\u0000\u0000\u0000\u0162\u0164\u0001\u0000\u0000\u0000\u0163\u0161\u0001"+
		"\u0000\u0000\u0000\u0164\u0165\u0005\"\u0000\u0000\u0165v\u0001\u0000"+
		"\u0000\u0000\u0166\u016a\u0007\u0005\u0000\u0000\u0167\u0169\u0007\u0006"+
		"\u0000\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0169\u016c\u0001\u0000"+
		"\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000"+
		"\u0000\u0000\u016bx\u0001\u0000\u0000\u0000\u016c\u016a\u0001\u0000\u0000"+
		"\u0000\n\u0000}\u0087\u0143\u0148\u014b\u0150\u0157\u0161\u016a\u0002"+
		"\u0000\u0001\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}