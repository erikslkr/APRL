parser grammar AprlParser;

options { tokenVocab = AprlLexer; }

aprlFile
    : NL* globalStatement (NL+ globalStatement)* NL* EOF;

globalStatement
    : variableDeclaration
    | functionDeclaration;

localStatement
    : variableDeclaration
    | variableAssignment
    | returnStatement;

variableDeclaration
    : variableClassifier simpleIdentifier COLON type (EQUAL expression)?
    | variableClassifier simpleIdentifier EQUAL expression;

variableClassifier
    : (VAL | VAR);

variableAssignment
    : simpleIdentifier EQUAL expression;

returnStatement
    : RETURN expression?;

functionDeclaration
    : FUNCTION simpleIdentifier functionArguments (RIGHT_ARROW type)? functionBody?;

functionArguments
    : LPAREN functionArgument? (COMMA functionArgument)* RPAREN;

functionArgument
    : simpleIdentifier COLON type;

functionBody
    : LCURLY NL* localStatement? (NL+ localStatement)* NL* RCURLY;

expression
    : disjunctionExpression;

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
    : multiplicativeExpression multiplicativeOperator unaryPrefixedExpression
    | unaryPrefixedExpression;

multiplicativeOperator
    : ASTERISK
    | SLASH
    | BACKSLASH
    | PERCENT;

unaryPrefixedExpression
    : unaryPrefix? exponentialExpression;

unaryPrefix
    : EXCL
    | TILDE
    | MINUS;

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
