lexer grammar InternalQuery;
@header {
package org.eclipse.emf.query2.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : ':' ;
T13 : 'select' ;
T14 : ',' ;
T15 : 'from' ;
T16 : 'where' ;
T17 : '.' ;
T18 : 'withoutsubtypes' ;
T19 : 'as' ;
T20 : 'not' ;
T21 : 'in' ;
T22 : 'resources' ;
T23 : '{' ;
T24 : '}' ;
T25 : 'elements' ;
T26 : 'or' ;
T27 : 'and' ;
T28 : '(' ;
T29 : ')' ;
T30 : 'true' ;
T31 : 'false' ;
T32 : 'null' ;
T33 : '=' ;
T34 : '<' ;
T35 : '>' ;
T36 : '<=' ;
T37 : '>=' ;
T38 : '!=' ;
T39 : 'like' ;
T40 : 'notlike' ;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g" 2175
RULE_SINGED_LONG : '-'? ('0'..'9')+;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g" 2177
RULE_SIGNED_DOUBLE : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g" 2179
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g" 2181
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g" 2183
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g" 2185
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g" 2187
RULE_WS : (' '|'\t'|'\r'|'\n')+;


