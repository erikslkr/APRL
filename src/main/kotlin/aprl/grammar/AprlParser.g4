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
    | whileStatement
    | returnStatement;

modifier
    : visibilityModifier;

visibilityModifier
    : PRIVATE
    | PROTECTED
    | INTERNAL
    | PUBLIC;

variableDeclaration
    : variableClassifier simpleIdentifier COLON typeReference (EQUAL expression)?
    | variableClassifier simpleIdentifier EQUAL expression;

variableClassifier
    : (VAL | VAR);

variableAssignment
    : simpleIdentifier assignmentOperator expression;

assignmentOperator
    : EQUAL
    | PLUS_EQUAL
    | MINUS_EQUAL
    | ASTERISK_EQUAL
    | DOUBLE_ASTERISK_EQUAL
    | SLASH_EQUAL
    | DOUBLE_SLASH_EQUAL
    | PERCENT_EQUAL
    | AND_EQUAL
    | OR_EQUAL
    | XOR_EQUAL
    | SHL_EQUAL
    | SHR_EQUAL
    | USHR_EQUAL;

conditionalStatement
    : ifStatement NL* (ELSE ifStatement NL*)* elseStatement*;

ifStatement
    : (IF | UNLESS) expression LCURLY localStatements RCURLY;

elseStatement
    : ELSE LCURLY localStatements RCURLY;

whileStatement
    : WHILE expression LCURLY localStatements RCURLY;

returnStatement
    : RETURN expression?;

functionDeclaration
    : modifier* FUNCTION simpleIdentifier valueParameters (RIGHT_ARROW typeReference)? functionBody?;

valueParameters
    : LPAREN valueParameter? (COMMA valueParameter)* RPAREN;

valueParameter
    : simpleIdentifier COLON typeReference;

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

typeReference
    : identifier
    | listTypeReference;

listTypeReference
    : LSQUARE typeReference RSQUARE;

identifier
    : simpleIdentifier (NL* PERIOD NL* simpleIdentifier)*;

simpleIdentifier
    : Identifier;
