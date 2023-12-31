lexer grammar AprlLexer;

LineComment: '#' ~[\r\n]* -> channel(HIDDEN);

WS: [\u0020\u0009\u000C] -> skip;
NL: '\r'? '\n';

VAR: 'var';
VAL: 'val';

IF: 'if';
ELSE: 'else';
UNLESS: 'unless';

WHILE: 'while';

PRIVATE: 'private';
PROTECTED: 'protected';
INTERNAL: 'internal';
PUBLIC: 'public';

FUNCTION: 'function';
RETURN: 'return';

EQUAL: '=';
DOUBLE_EQUAL: '==';
TRIPLE_EQUAL: '===';
NOT_EQUAL: '!=';
NOT_DOUBLE_EQUAL: '!==';

LANGLE: '<';
RANGLE: '>';
LANGLE_EQUAL: '<=';
RANGLE_EQUAL: '>=';

LPAREN: '(';
RPAREN: ')';
LSQUARE: '[';
RSQUARE: ']';
LCURLY: '{';
RCURLY: '}';

PERIOD: '.';
COMMA: ',';
COLON: ':';

EXCL: '!';
TILDE: '~';

RIGHT_ARROW: '->';

HASH: '#';

PLUS: '+';
PLUS_EQUAL: '+=';
MINUS: '-';
MINUS_EQUAL: '-=';
ASTERISK: '*';
ASTERISK_EQUAL: '*=';
DOUBLE_ASTERISK: '**';
DOUBLE_ASTERISK_EQUAL: '**=';
SLASH: '/';
SLASH_EQUAL: '/=';
DOUBLE_SLASH: '//';
DOUBLE_SLASH_EQUAL: '//=';
PERCENT: '%';
PERCENT_EQUAL: '%=';

BACKSLASH: '\\';

AND: '&';
AND_EQUAL: '&=';
DOUBLE_AND: '&&';
OR: '|';
OR_EQUAL: '|=';
DOUBLE_OR: '||';
XOR: '^';
XOR_EQUAL: '^=';
SHL: '<<';
SHL_EQUAL: '<<=';
SHR: '>>';
SHR_EQUAL: '>>=';
USHR: '>>>';
USHR_EQUAL: '>>>=';

TRUE: 'true';
FALSE: 'false';

IntegerLiteral: [-]? [0-9]+;
FloatLiteral: [-]? [0-9]* '.' [0-9]+;
CharLiteral: '\'' . '\'';
StringLiteral: '"' (~["])* '"';

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
