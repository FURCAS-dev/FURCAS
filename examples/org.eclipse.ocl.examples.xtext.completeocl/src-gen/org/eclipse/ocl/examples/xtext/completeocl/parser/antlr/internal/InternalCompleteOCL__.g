lexer grammar InternalCompleteOCL;
@header {
package org.eclipse.ocl.examples.xtext.completeocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'body' ;
T13 : 'context' ;
T14 : 'def' ;
T15 : 'derive' ;
T16 : 'import' ;
T17 : 'init' ;
T18 : 'inv' ;
T19 : ':' ;
T20 : 'static' ;
T21 : '(' ;
T22 : ',' ;
T23 : ')' ;
T24 : '=' ;
T25 : 'package' ;
T26 : 'endpackage' ;
T27 : 'post' ;
T28 : 'pre' ;
T29 : '::' ;
T30 : '.' ;
T31 : '->' ;
T32 : '^^' ;
T33 : '^' ;
T34 : '?' ;
T35 : 'e' ;
T36 : 'E' ;
T37 : '+' ;
T38 : '-' ;
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
T52 : 'Tuple' ;
T53 : '{' ;
T54 : '}' ;
T55 : '..' ;
T56 : 'true' ;
T57 : 'false' ;
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
T69 : '*' ;
T70 : '/' ;
T71 : 'not' ;
T72 : ';' ;
T73 : '|' ;
T74 : '[' ;
T75 : ']' ;
T76 : 'self' ;
T77 : 'if' ;
T78 : 'then' ;
T79 : 'else' ;
T80 : 'endif' ;
T81 : 'let' ;
T82 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6968
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6970
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6972
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6974
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6976
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6978
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6980
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 6982
RULE_ANY_OTHER : .;


