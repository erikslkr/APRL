parser grammar AprlParser;

options { tokenVocab = AprlLexer; }

aprlFile
    : NL* statement (NL+ statement)*;

statement
    : variableDeclaration
    | variableAssignment;

variableDeclaration
    : variableClassifier variableAssignment;

variableClassifier
    : (VAL | VAR);

variableAssignment
    : simpleIdentifier EQUAL expression;

expression
    : parenthesizedExpression
    | bitwiseExpression;

parenthesizedExpression
    : LPAREN expression RPAREN;

bitwiseExpression
    : bitwiseExpression bitwiseOperator additiveExpression
    | additiveExpression;

bitwiseOperator
    : AND
    | OR
    | XOR
    | SHL
    | SHR
    | USHR;

additiveExpression
    : additiveExpression additiveOperator multiplicativeExpression
    | multiplicativeExpression;

additiveOperator
    : PLUS
    | MINUS;

multiplicativeExpression
    : multiplicativeExpression multiplicativeOperator exponentialExpression
    | exponentialExpression;

multiplicativeOperator
    : ASTERISK
    | SLASH
    | BACKSLASH
    | PERCENT;

exponentialExpression
    : exponentialExpression exponentialOperator atomicExpression
    | atomicExpression;

exponentialOperator
    : DOUBLE_ASTERISK;

atomicExpression
    : parenthesizedExpression
    | identifier
    | IntegerLiteral;

identifier
    : simpleIdentifier (NL* PERIOD NL* simpleIdentifier)*;

simpleIdentifier
    : Identifier;
