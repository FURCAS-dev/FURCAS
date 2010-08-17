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
T29 : ':' ;
T30 : 'static' ;
T31 : '(' ;
T32 : ',' ;
T33 : ')' ;
T34 : '=' ;
T35 : 'package' ;
T36 : 'endpackage' ;
T37 : 'post' ;
T38 : 'pre' ;
T39 : '::' ;
T40 : '.' ;
T41 : '->' ;
T42 : '^^' ;
T43 : '^' ;
T44 : '?' ;
T45 : 'e' ;
T46 : 'E' ;
T47 : '+' ;
T48 : '-' ;
T49 : 'Set' ;
T50 : 'Bag' ;
T51 : 'Sequence' ;
T52 : 'Collection' ;
T53 : 'OrderedSet' ;
T54 : 'Tuple' ;
T55 : '{' ;
T56 : '}' ;
T57 : '..' ;
T58 : 'true' ;
T59 : 'false' ;
T60 : 'invalid' ;
T61 : 'null' ;
T62 : 'implies' ;
T63 : 'xor' ;
T64 : 'or' ;
T65 : 'and' ;
T66 : '<>' ;
T67 : '>' ;
T68 : '<' ;
T69 : '>=' ;
T70 : '<=' ;
T71 : '*' ;
T72 : '/' ;
T73 : 'not' ;
T74 : '@' ;
T75 : ';' ;
T76 : '|' ;
T77 : '[' ;
T78 : ']' ;
T79 : 'self' ;
T80 : 'if' ;
T81 : 'then' ;
T82 : 'else' ;
T83 : 'endif' ;
T84 : 'let' ;
T85 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7065
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7067
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7069
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7071
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7073
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7075
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7077
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g" 7079
RULE_ANY_OTHER : .;


