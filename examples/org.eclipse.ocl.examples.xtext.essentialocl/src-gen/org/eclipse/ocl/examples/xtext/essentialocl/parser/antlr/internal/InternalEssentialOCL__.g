lexer grammar InternalEssentialOCL;
@header {
package org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '.' ;
T13 : 'e' ;
T14 : 'E' ;
T15 : '+' ;
T16 : '-' ;
T17 : 'Boolean' ;
T18 : 'Integer' ;
T19 : 'Real' ;
T20 : 'String' ;
T21 : 'UnlimitedNatural' ;
T22 : 'OclAny' ;
T23 : 'OclInvalid' ;
T24 : 'OclVoid' ;
T25 : 'Set' ;
T26 : 'Bag' ;
T27 : 'Sequence' ;
T28 : 'Collection' ;
T29 : 'OrderedSet' ;
T30 : '(' ;
T31 : ')' ;
T32 : 'Tuple' ;
T33 : ',' ;
T34 : ':' ;
T35 : '{' ;
T36 : '}' ;
T37 : '..' ;
T38 : '=' ;
T39 : 'true' ;
T40 : 'false' ;
T41 : 'invalid' ;
T42 : 'null' ;
T43 : 'implies' ;
T44 : 'xor' ;
T45 : 'or' ;
T46 : 'and' ;
T47 : '<>' ;
T48 : '>' ;
T49 : '<' ;
T50 : '>=' ;
T51 : '<=' ;
T52 : '*' ;
T53 : '/' ;
T54 : 'not' ;
T55 : '->' ;
T56 : ';' ;
T57 : '|' ;
T58 : '[' ;
T59 : ']' ;
T60 : 'self' ;
T61 : '::' ;
T62 : 'if' ;
T63 : 'then' ;
T64 : 'else' ;
T65 : 'endif' ;
T66 : 'let' ;
T67 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4368
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4370
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4372
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4374
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4376
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4378
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4380
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4382
RULE_ANY_OTHER : .;


