lexer grammar InternalCompleteOCL;
@header {
package org.eclipse.ocl.examples.xtext.completeocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '.' ;
T12 : 'import' ;
T13 : 'package' ;
T14 : 'endpackage' ;
T15 : 'context' ;
T16 : ':' ;
T17 : 'init' ;
T18 : 'derive' ;
T19 : 'inv' ;
T20 : 'static' ;
T21 : 'def' ;
T22 : '(' ;
T23 : ',' ;
T24 : ')' ;
T25 : '=' ;
T26 : 'pre' ;
T27 : 'post' ;
T28 : 'body' ;
T29 : '^^' ;
T30 : '^' ;
T31 : '?' ;
T32 : 'e' ;
T33 : 'E' ;
T34 : '+' ;
T35 : '-' ;
T36 : 'Tuple' ;
T37 : 'self' ;
T38 : '::' ;
T39 : 'Boolean' ;
T40 : 'Integer' ;
T41 : 'Real' ;
T42 : 'String' ;
T43 : 'UnlimitedNatural' ;
T44 : 'OclAny' ;
T45 : 'OclInvalid' ;
T46 : 'OclVoid' ;
T47 : 'Set' ;
T48 : 'Bag' ;
T49 : 'Sequence' ;
T50 : 'Collection' ;
T51 : 'OrderedSet' ;
T52 : '{' ;
T53 : '}' ;
T54 : '..' ;
T55 : 'true' ;
T56 : 'false' ;
T57 : '*' ;
T58 : 'invalid' ;
T59 : 'null' ;
T60 : 'implies' ;
T61 : 'xor' ;
T62 : 'or' ;
T63 : 'and' ;
T64 : '<>' ;
T65 : '>' ;
T66 : '<' ;
T67 : '>=' ;
T68 : '<=' ;
T69 : '/' ;
T70 : 'not' ;
T71 : '->' ;
T72 : ';' ;
T73 : '|' ;
T74 : '[' ;
T75 : ']' ;
T76 : '@pre' ;
T77 : 'if' ;
T78 : 'then' ;
T79 : 'else' ;
T80 : 'endif' ;
T81 : 'let' ;
T82 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6549
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6551
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6553
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6555
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6557
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6559
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6561
RULE_ANY_OTHER : .;


