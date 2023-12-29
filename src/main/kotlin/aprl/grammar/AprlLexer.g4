lexer grammar AprlLexer;

LineComment: '#' ~[\r\n]* -> channel(HIDDEN);

WS: [\u0020\u0009\u000C] -> skip;
NL: '\r'? '\n';

VAR: 'var';
VAL: 'val';

IF: 'if';
ELSE: 'else';
UNLESS: 'unless';

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
MINUS: '-';
ASTERISK: '*';
DOUBLE_ASTERISK: '**';
SLASH: '/';
DOUBLE_SLASH: '//';
BACKSLASH: '\\';
PERCENT: '%';

AND: '&';
DOUBLE_AND: '&&';
OR: '|';
DOUBLE_OR: '||';
XOR: '^';
SHL: '<<';
SHR: '>>';
USHR: '>>>';

TRUE: 'true';
FALSE: 'false';

IntegerLiteral: [-]? [0-9]+;
FloatLiteral: [-]? [0-9]* '.' [0-9]+;
CharLiteral: '\'' . '\'';
StringLiteral: '"' (~["])* '"';

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
