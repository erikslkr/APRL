parser grammar AprlParser;

options { tokenVocab = AprlLexer; }

aprlFile
    : NL* statement (NL+ statement)* NL* EOF;

statement
    : variableDeclaration
    | variableAssignment;

variableDeclaration
    : variableClassifier simpleIdentifier COLON type (EQUAL expression)?
    | variableClassifier simpleIdentifier EQUAL expression;

variableClassifier
    : (VAL | VAR);

variableAssignment
    : simpleIdentifier EQUAL expression;

expression
    : parenthesizedExpression
    | disjunctionExpression;

parenthesizedExpression
    : LPAREN expression RPAREN;

disjunctionExpression
    : conjunctionExpression disjunctionOperator disjunctionExpression
    | conjunctionExpression;

disjunctionOperator
    : DOUBLE_OR;

conjunctionExpression
    : comparisonExpression conjunctionOperator conjunctionExpression
    | comparisonExpression;

conjunctionOperator
    : DOUBLE_AND;

comparisonExpression
    : bitwiseExpression comparisonOperator comparisonExpression
    | bitwiseExpression;

comparisonOperator
    : LANGLE
    | RANGLE
    | LANGLE_EQUAL
    | RANGLE_EQUAL
    | DOUBLE_EQUAL
    | TRIPLE_EQUAL
    | NOT_EQUAL
    | NOT_DOUBLE_EQUAL;

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
    | literal;

literal
    : booleanLiteral
    | IntegerLiteral
    | FloatLiteral
    | StringLiteral
    | CharLiteral;

booleanLiteral
    : TRUE
    | FALSE;

type
    : identifier;

identifier
    : simpleIdentifier (NL* PERIOD NL* simpleIdentifier)*;

simpleIdentifier
    : Identifier;
