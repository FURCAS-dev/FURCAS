lexer grammar InternalCompleteOCL;
@header {
package org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : 'body' ;
T13 : 'context' ;
T14 : 'def' ;
T15 : 'derive' ;
T16 : 'import' ;
T17 : 'init' ;
T18 : 'inv' ;
T19 : 'Boolean' ;
T20 : 'Integer' ;
T21 : 'Real' ;
T22 : 'String' ;
T23 : 'UnlimitedNatural' ;
T24 : 'OclAny' ;
T25 : 'OclInvalid' ;
T26 : 'OclMessage' ;
T27 : 'OclState' ;
T28 : 'OclVoid' ;
T29 : '.' ;
T30 : '->' ;
T31 : '^^' ;
T32 : '^' ;
T33 : 'e' ;
T34 : 'E' ;
T35 : '+' ;
T36 : '-' ;
T37 : 'Set' ;
T38 : 'Bag' ;
T39 : 'Sequence' ;
T40 : 'Collection' ;
T41 : 'OrderedSet' ;
T42 : '=' ;
T43 : '<>' ;
T44 : '>' ;
T45 : '<' ;
T46 : '>=' ;
T47 : '<=' ;
T48 : '*' ;
T49 : '/' ;
T50 : 'not' ;
T51 : ':' ;
T52 : '(' ;
T53 : ')' ;
T54 : ',' ;
T55 : 'package' ;
T56 : 'endpackage' ;
T57 : 'post' ;
T58 : 'pre' ;
T59 : '::' ;
T60 : '?' ;
T61 : '{' ;
T62 : '}' ;
T63 : '..' ;
T64 : 'Tuple' ;
T65 : 'invalid' ;
T66 : 'null' ;
T67 : '@' ;
T68 : '|' ;
T69 : ';' ;
T70 : '[' ;
T71 : ']' ;
T72 : 'self' ;
T73 : 'if' ;
T74 : 'then' ;
T75 : 'else' ;
T76 : 'endif' ;
T77 : 'let' ;
T78 : 'in' ;
T79 : 'static' ;
T80 : 'true' ;
T81 : 'false' ;
T82 : 'implies' ;
T83 : 'xor' ;
T84 : 'or' ;
T85 : 'and' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15065
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15067
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15069
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15071
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15073
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15075
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15077
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 15079
RULE_ANY_OTHER : .;


