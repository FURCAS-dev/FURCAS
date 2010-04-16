lexer grammar InternalCompleteOCL;
@header {
package org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'body' ;
T12 : 'context' ;
T13 : 'def' ;
T14 : 'derive' ;
T15 : 'endpackage' ;
T16 : 'import' ;
T17 : 'init' ;
T18 : 'inv' ;
T19 : 'package' ;
T20 : 'post' ;
T21 : 'pre' ;
T22 : 'static' ;
T23 : 'e' ;
T24 : 'E' ;
T25 : '^^' ;
T26 : '^' ;
T27 : '+' ;
T28 : '-' ;
T29 : '=' ;
T30 : '<>' ;
T31 : '>' ;
T32 : '<' ;
T33 : '>=' ;
T34 : '<=' ;
T35 : '*' ;
T36 : '/' ;
T37 : 'not' ;
T38 : '.' ;
T39 : '->' ;
T40 : ':' ;
T41 : '(' ;
T42 : ')' ;
T43 : ',' ;
T44 : '@' ;
T45 : '?' ;
T46 : '::' ;
T47 : '{' ;
T48 : '}' ;
T49 : '..' ;
T50 : 'Tuple' ;
T51 : 'invalid' ;
T52 : 'null' ;
T53 : '|' ;
T54 : ';' ;
T55 : '[' ;
T56 : ']' ;
T57 : 'if' ;
T58 : 'then' ;
T59 : 'else' ;
T60 : 'endif' ;
T61 : 'let' ;
T62 : 'in' ;
T63 : 'self' ;
T64 : 'Boolean' ;
T65 : 'Integer' ;
T66 : 'Real' ;
T67 : 'String' ;
T68 : 'UnlimitedNatural' ;
T69 : 'OclAny' ;
T70 : 'OclInvalid' ;
T71 : 'OclVoid' ;
T72 : 'Set' ;
T73 : 'Bag' ;
T74 : 'Sequence' ;
T75 : 'Collection' ;
T76 : 'OrderedSet' ;
T77 : 'true' ;
T78 : 'false' ;
T79 : 'implies' ;
T80 : 'xor' ;
T81 : 'or' ;
T82 : 'and' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 11032
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 11034
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 11036
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 11038
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 11040
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 11042
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 11044
RULE_ANY_OTHER : .;


