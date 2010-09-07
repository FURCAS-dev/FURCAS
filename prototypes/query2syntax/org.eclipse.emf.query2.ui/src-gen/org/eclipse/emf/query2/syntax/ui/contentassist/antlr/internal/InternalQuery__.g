lexer grammar InternalQuery;
@header {
package org.eclipse.emf.query2.syntax.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'false' ;
T12 : '<' ;
T13 : '>' ;
T14 : '<=' ;
T15 : '>=' ;
T16 : '=' ;
T17 : '!=' ;
T18 : 'like' ;
T19 : 'not like' ;
T20 : 'not in' ;
T21 : 'in' ;
T22 : 'import' ;
T23 : ':' ;
T24 : 'from' ;
T25 : 'select' ;
T26 : ',' ;
T27 : 'where' ;
T28 : '.' ;
T29 : 'as' ;
T30 : '{' ;
T31 : '}' ;
T32 : 'resources' ;
T33 : 'elements' ;
T34 : 'or' ;
T35 : 'and' ;
T36 : '(' ;
T37 : ')' ;
T38 : 'withoutsubtypes' ;
T39 : 'not' ;
T40 : 'null' ;
T41 : 'true' ;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g" 4097
RULE_SINGED_LONG : '-'? ('0'..'9')+;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g" 4099
RULE_SIGNED_DOUBLE : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g" 4101
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g" 4103
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g" 4105
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g" 4107
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g" 4109
RULE_WS : (' '|'\t'|'\r'|'\n')+;


