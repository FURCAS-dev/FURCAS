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
T29 : '@' ;
T30 : '^^' ;
T31 : '^' ;
T32 : '?' ;
T33 : 'e' ;
T34 : 'E' ;
T35 : '+' ;
T36 : '-' ;
T37 : 'Tuple' ;
T38 : 'self' ;
T39 : '::' ;
T40 : 'Boolean' ;
T41 : 'Integer' ;
T42 : 'Real' ;
T43 : 'String' ;
T44 : 'UnlimitedNatural' ;
T45 : 'OclAny' ;
T46 : 'OclInvalid' ;
T47 : 'OclVoid' ;
T48 : 'Set' ;
T49 : 'Bag' ;
T50 : 'Sequence' ;
T51 : 'Collection' ;
T52 : 'OrderedSet' ;
T53 : '{' ;
T54 : '}' ;
T55 : '..' ;
T56 : 'true' ;
T57 : 'false' ;
T58 : '*' ;
T59 : 'invalid' ;
T60 : 'null' ;
T61 : 'implies' ;
T62 : 'xor' ;
T63 : 'or' ;
T64 : 'and' ;
T65 : '<>' ;
T66 : '>' ;
T67 : '<' ;
T68 : '>=' ;
T69 : '<=' ;
T70 : '/' ;
T71 : 'not' ;
T72 : '->' ;
T73 : ';' ;
T74 : '|' ;
T75 : '[' ;
T76 : ']' ;
T77 : 'if' ;
T78 : 'then' ;
T79 : 'else' ;
T80 : 'endif' ;
T81 : 'let' ;
T82 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6482
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6484
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6486
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6488
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6490
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6492
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6494
RULE_ANY_OTHER : .;


