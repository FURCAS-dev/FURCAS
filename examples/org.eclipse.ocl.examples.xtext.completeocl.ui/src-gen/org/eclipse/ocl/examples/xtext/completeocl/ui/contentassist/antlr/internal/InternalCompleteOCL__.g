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
T19 : '^^' ;
T20 : '^' ;
T21 : 'e' ;
T22 : 'E' ;
T23 : '+' ;
T24 : '-' ;
T25 : 'Boolean' ;
T26 : 'Integer' ;
T27 : 'Real' ;
T28 : 'String' ;
T29 : 'UnlimitedNatural' ;
T30 : 'OclAny' ;
T31 : 'OclInvalid' ;
T32 : 'OclVoid' ;
T33 : 'Set' ;
T34 : 'Bag' ;
T35 : 'Sequence' ;
T36 : 'Collection' ;
T37 : 'OrderedSet' ;
T38 : '=' ;
T39 : '<>' ;
T40 : '>' ;
T41 : '<' ;
T42 : '>=' ;
T43 : '<=' ;
T44 : '*' ;
T45 : '/' ;
T46 : 'not' ;
T47 : ':' ;
T48 : '(' ;
T49 : ')' ;
T50 : ',' ;
T51 : 'package' ;
T52 : 'endpackage' ;
T53 : 'post' ;
T54 : 'pre' ;
T55 : '::' ;
T56 : '.' ;
T57 : '->' ;
T58 : '?' ;
T59 : '{' ;
T60 : '}' ;
T61 : '..' ;
T62 : 'Tuple' ;
T63 : 'invalid' ;
T64 : 'null' ;
T65 : '|' ;
T66 : ';' ;
T67 : '[' ;
T68 : ']' ;
T69 : 'self' ;
T70 : 'if' ;
T71 : 'then' ;
T72 : 'else' ;
T73 : 'endif' ;
T74 : 'let' ;
T75 : 'in' ;
T76 : 'static' ;
T77 : 'true' ;
T78 : 'false' ;
T79 : 'implies' ;
T80 : 'xor' ;
T81 : 'or' ;
T82 : 'and' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14927
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14929
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14931
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14933
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14935
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14937
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14939
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 14941
RULE_ANY_OTHER : .;


