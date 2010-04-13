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
T27 : 'import' ;
T28 : 'package' ;
T29 : 'endpackage' ;
T30 : 'context' ;
T31 : ':' ;
T32 : 'init' ;
T33 : 'derive' ;
T34 : 'inv' ;
T35 : 'def' ;
T36 : '(' ;
T37 : ')' ;
T38 : ',' ;
T39 : 'pre' ;
T40 : 'post' ;
T41 : 'body' ;
T42 : '?' ;
T43 : '::' ;
T44 : '{' ;
T45 : '}' ;
T46 : '..' ;
T47 : 'Tuple' ;
T48 : 'invalid' ;
T49 : 'null' ;
T50 : '->' ;
T51 : '|' ;
T52 : ';' ;
T53 : '[' ;
T54 : ']' ;
T55 : 'if' ;
T56 : 'then' ;
T57 : 'else' ;
T58 : 'endif' ;
T59 : 'let' ;
T60 : 'in' ;
T61 : 'static' ;
T62 : 'self' ;
T63 : 'Boolean' ;
T64 : 'Integer' ;
T65 : 'Real' ;
T66 : 'String' ;
T67 : 'UnlimitedNatural' ;
T68 : 'OclAny' ;
T69 : 'OclInvalid' ;
T70 : 'OclVoid' ;
T71 : 'Set' ;
T72 : 'Bag' ;
T73 : 'Sequence' ;
T74 : 'Collection' ;
T75 : 'OrderedSet' ;
T76 : 'true' ;
T77 : 'false' ;
T78 : 'implies' ;
T79 : 'xor' ;
T80 : 'or' ;
T81 : 'and' ;
T82 : '@pre' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10939
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10941
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10943
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10945
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10947
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10949
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g" 10951
RULE_ANY_OTHER : .;


