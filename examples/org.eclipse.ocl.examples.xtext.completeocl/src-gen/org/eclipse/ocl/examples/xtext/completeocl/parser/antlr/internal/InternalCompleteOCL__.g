lexer grammar InternalCompleteOCL;
@header {
package org.eclipse.ocl.examples.xtext.completeocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
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
T25 : '.' ;
T26 : ':' ;
T27 : '(' ;
T28 : ',' ;
T29 : ')' ;
T30 : '=' ;
T31 : '@' ;
T32 : '^^' ;
T33 : '^' ;
T34 : '?' ;
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

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6652
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6654
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6656
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6658
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6660
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6662
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6664
RULE_ANY_OTHER : .;


