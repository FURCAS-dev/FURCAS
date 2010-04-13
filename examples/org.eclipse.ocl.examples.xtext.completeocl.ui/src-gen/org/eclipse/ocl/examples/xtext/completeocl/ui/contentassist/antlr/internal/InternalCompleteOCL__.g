lexer grammar InternalCompleteOCL;
@header {
package org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : '^^' ;
T12 : '^' ;
T13 : 'e' ;
T14 : 'E' ;
T15 : '+' ;
T16 : '-' ;
T17 : '=' ;
T18 : '<>' ;
T19 : '>' ;
T20 : '<' ;
T21 : '>=' ;
T22 : '<=' ;
T23 : '*' ;
T24 : '/' ;
T25 : 'not' ;
T26 : '.' ;
T27 : '->' ;
T28 : 'import' ;
T29 : 'package' ;
T30 : 'endpackage' ;
T31 : 'context' ;
T32 : ':' ;
T33 : 'init' ;
T34 : 'derive' ;
T35 : 'inv' ;
T36 : 'def' ;
T37 : '(' ;
T38 : ')' ;
T39 : ',' ;
T40 : 'pre' ;
T41 : 'post' ;
T42 : 'body' ;
T43 : '@' ;
T44 : '?' ;
T45 : '::' ;
T46 : '{' ;
T47 : '}' ;
T48 : '..' ;
T49 : 'Tuple' ;
T50 : 'invalid' ;
T51 : 'null' ;
T52 : '|' ;
T53 : ';' ;
T54 : '[' ;
T55 : ']' ;
T56 : 'if' ;
T57 : 'then' ;
T58 : 'else' ;
T59 : 'endif' ;
T60 : 'let' ;
T61 : 'in' ;
T62 : 'static' ;
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

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10832
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10834
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10836
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10838
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10840
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10842
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10844
RULE_ANY_OTHER : .;


