lexer grammar InternalQuery;
@header {
package org.eclipse.emf.query2.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'false' ;
T12 : '<' ;
T13 : '>' ;
T14 : '<=' ;
T15 : '>=' ;
T16 : '=' ;
T17 : '!=' ;
T18 : 'like' ;
T19 : 'notlike' ;
T20 : 'import' ;
T21 : ':' ;
T22 : 'select' ;
T23 : 'from' ;
T24 : ',' ;
T25 : 'where' ;
T26 : '.' ;
T27 : 'as' ;
T28 : 'in' ;
T29 : 'resources' ;
T30 : '{' ;
T31 : '}' ;
T32 : 'elements' ;
T33 : 'or' ;
T34 : 'and' ;
T35 : '(' ;
T36 : ')' ;
T37 : 'null' ;
T38 : 'withoutsubtypes' ;
T39 : 'not' ;
T40 : 'true' ;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g" 4363
RULE_SINGED_LONG : '-'? ('0'..'9')+;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g" 4365
RULE_SIGNED_DOUBLE : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g" 4367
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g" 4369
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g" 4371
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g" 4373
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g" 4375
RULE_WS : (' '|'\t'|'\r'|'\n')+;


