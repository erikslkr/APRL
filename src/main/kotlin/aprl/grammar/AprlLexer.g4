lexer grammar AprlLexer;

WS: [\u0020\u0009\u000C] -> skip;

VAR: 'var';
VAL: 'val';

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

PLUS: '+';
MINUS: '-';
ASTERISK: '*';
DOUBLE_ASTERISK: '**';
SLASH: '/';
BACKSLASH: '\\';
PERCENT: '%';

RIGHT_ARROW: '->';

AND: '&';
DOUBLE_AND: '&&';
OR: '|';
DOUBLE_OR: '||';
XOR: '^';
SHL: '<<';
SHR: '>>';
USHR: '>>>';

NL: '\r'? '\n';

TRUE: 'true';
FALSE: 'false';

IntegerLiteral: [-]? [0-9]+;
FloatLiteral: [-]? [0-9]* '.' [0-9]+;
CharLiteral: '\'' . '\'';
StringLiteral: '"' (~["])* '"';

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
