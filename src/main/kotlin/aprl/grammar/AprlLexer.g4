lexer grammar AprlLexer;

WS: [\u0020\u0009\u000C] -> skip;

VAR: 'var';
VAL: 'val';

EQUAL: '=';

LPAREN: '(';
RPAREN: ')';
LSQUARE: '[';
RSQUARE: ']';
LCURLY: '{';
RCURLY: '}';

PERIOD: '.';
COMMA: ',';

PLUS: '+';
MINUS: '-';
ASTERISK: '*';
DOUBLE_ASTERISK: '**';
SLASH: '/';
PERCENT: '%';

AND: '&';
OR: '|';
XOR: '^';
SHL: '<<';
SHR: '>>';
USHR: '>>>';

NL: '\r'? '\n';

IntegerLiteral: [-]? [0-9]+;
FloatLiteral: [-]? [0-9]* '.' [0-9]+;
CharLiteral: '\'' . '\'';
StringLiteral: '"' (~["])* '"';

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
