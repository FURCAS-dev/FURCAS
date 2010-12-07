lexer grammar InternalQuery;
@header {
package org.eclipse.emf.query2.syntax.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : ':' ;
T13 : 'from' ;
T14 : ',' ;
T15 : 'select' ;
T16 : 'where' ;
T17 : '.' ;
T18 : 'withoutsubtypes' ;
T19 : '{' ;
T20 : '}' ;
T21 : 'as' ;
T22 : 'not' ;
T23 : 'in' ;
T24 : 'resources' ;
T25 : 'elements' ;
T26 : 'or' ;
T27 : 'and' ;
T28 : '(' ;
T29 : ')' ;
T30 : '?' ;
T31 : 'null' ;
T32 : 'true' ;
T33 : 'false' ;
T34 : '<' ;
T35 : '>' ;
T36 : '<=' ;
T37 : '>=' ;
T38 : '=' ;
T39 : '!=' ;
T40 : 'like' ;
T41 : 'not like' ;
T42 : 'not in' ;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g" 1820
RULE_SINGED_LONG : '-'? ('0'..'9')+;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g" 1822
RULE_SIGNED_DOUBLE : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g" 1824
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g" 1826
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g" 1828
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g" 1830
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g" 1832
RULE_WS : (' '|'\t'|'\r'|'\n')+;


