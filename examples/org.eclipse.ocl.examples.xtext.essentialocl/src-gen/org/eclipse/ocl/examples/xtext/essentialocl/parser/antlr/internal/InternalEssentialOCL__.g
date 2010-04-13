lexer grammar InternalEssentialOCL;
@header {
package org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '.' ;
T12 : 'e' ;
T13 : 'E' ;
T14 : '+' ;
T15 : '-' ;
T16 : 'Tuple' ;
T17 : 'self' ;
T18 : '::' ;
T19 : 'Boolean' ;
T20 : 'Integer' ;
T21 : 'Real' ;
T22 : 'String' ;
T23 : 'UnlimitedNatural' ;
T24 : 'OclAny' ;
T25 : 'OclInvalid' ;
T26 : 'OclVoid' ;
T27 : 'Set' ;
T28 : 'Bag' ;
T29 : 'Sequence' ;
T30 : 'Collection' ;
T31 : 'OrderedSet' ;
T32 : '(' ;
T33 : ')' ;
T34 : ',' ;
T35 : ':' ;
T36 : '{' ;
T37 : '}' ;
T38 : '..' ;
T39 : '=' ;
T40 : 'true' ;
T41 : 'false' ;
T42 : '*' ;
T43 : 'invalid' ;
T44 : 'null' ;
T45 : 'implies' ;
T46 : 'xor' ;
T47 : 'or' ;
T48 : 'and' ;
T49 : '<>' ;
T50 : '>' ;
T51 : '<' ;
T52 : '>=' ;
T53 : '<=' ;
T54 : '/' ;
T55 : 'not' ;
T56 : '->' ;
T57 : ';' ;
T58 : '|' ;
T59 : '[' ;
T60 : ']' ;
T61 : 'if' ;
T62 : 'then' ;
T63 : 'else' ;
T64 : 'endif' ;
T65 : 'let' ;
T66 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4524
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4526
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4528
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4530
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4532
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4534
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4536
RULE_ANY_OTHER : .;


