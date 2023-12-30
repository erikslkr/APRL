parser grammar AprlParser;

options { tokenVocab = AprlLexer; }

aprlFile
    : NL* globalStatement (NL+ globalStatement)* NL* EOF;

globalStatement
    : variableDeclaration
    | functionDeclaration;

localStatements
    : NL* localStatement? (NL+ localStatement)* NL*;

localStatement
    : variableDeclaration
    | variableAssignment
    | conditionalStatement
    | returnStatement;

modifier
    : visibilityModifier;

visibilityModifier
    : PRIVATE
    | PROTECTED
    | INTERNAL
    | PUBLIC;

variableDeclaration
    : variableClassifier simpleIdentifier COLON type (EQUAL expression)?
    | variableClassifier simpleIdentifier EQUAL expression;

variableClassifier
    : (VAL | VAR);

variableAssignment
    : simpleIdentifier EQUAL expression;

conditionalStatement
    : ifStatement NL* (ELSE ifStatement NL*)* elseStatement*;

ifStatement
    : (IF | UNLESS) expression LCURLY localStatements RCURLY;

elseStatement
    : ELSE LCURLY localStatements RCURLY;

returnStatement
    : RETURN expression?;

functionDeclaration
    : modifier* FUNCTION simpleIdentifier valueParameters (RIGHT_ARROW type)? functionBody?;

valueParameters
    : LPAREN valueParameter? (COMMA valueParameter)* RPAREN;

valueParameter
    : simpleIdentifier COLON type;

functionBody
    : LCURLY localStatements RCURLY;

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
    | DOUBLE_SLASH
    | PERCENT;

unaryPrefixedExpression
    : unaryPrefix? exponentialExpression;

unaryPrefix
    : EXCL
    | TILDE
    | MINUS;

exponentialExpression
    : exponentialExpression exponentialOperator unaryPostfixedExpression
    | unaryPostfixedExpression;

exponentialOperator
    : DOUBLE_ASTERISK;

unaryPostfixedExpression
    : unaryPostfixedExpression unaryPostfix
    | atomicExpression;

unaryPostfix
    : valueArguments;

valueArguments
    : LPAREN valueArgument? (COMMA valueArgument)* RPAREN;

valueArgument
    : expression;

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
