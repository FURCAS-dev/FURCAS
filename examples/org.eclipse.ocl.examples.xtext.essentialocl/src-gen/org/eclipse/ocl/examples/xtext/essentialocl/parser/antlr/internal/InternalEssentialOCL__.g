lexer grammar InternalEssentialOCL;
@header {
package org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T14 : 'body' ;
T15 : 'der' ;
T16 : 'init' ;
T17 : 'inv' ;
T18 : 'post' ;
T19 : 'pre' ;
T20 : ':' ;
T21 : ';' ;
T22 : '.' ;
T23 : 'e' ;
T24 : 'E' ;
T25 : '+' ;
T26 : '-' ;
T27 : 'not' ;
T28 : '*' ;
T29 : '/' ;
T30 : '>' ;
T31 : '<' ;
T32 : '>=' ;
T33 : '<=' ;
T34 : '=' ;
T35 : '<>' ;
T36 : 'and' ;
T37 : 'or' ;
T38 : 'xor' ;
T39 : 'implies' ;
T40 : '->' ;
T41 : 'Boolean' ;
T42 : 'Integer' ;
T43 : 'Real' ;
T44 : 'String' ;
T45 : 'UnlimitedNatural' ;
T46 : 'OclAny' ;
T47 : 'OclInvalid' ;
T48 : 'OclVoid' ;
T49 : 'Set' ;
T50 : 'Bag' ;
T51 : 'Sequence' ;
T52 : 'Collection' ;
T53 : 'OrderedSet' ;
T54 : '(' ;
T55 : ')' ;
T56 : 'Tuple' ;
T57 : ',' ;
T58 : '{' ;
T59 : '}' ;
T60 : '..' ;
T61 : 'true' ;
T62 : 'false' ;
T63 : 'invalid' ;
T64 : 'null' ;
T65 : '::' ;
T66 : '[' ;
T67 : ']' ;
T68 : '|' ;
T69 : 'if' ;
T70 : 'then' ;
T71 : 'else' ;
T72 : 'endif' ;
T73 : 'let' ;
T74 : 'in' ;
T75 : 'self' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4381
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4383
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4385
RULE_ML_SINGLE_QUOTED_STRING : '/\'' ( options {greedy=false;} : . )*'\'/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4387
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4389
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4391
RULE_DOCUMENTATION : '/**' ( options {greedy=false;} : . )*'**/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4393
RULE_ML_COMMENT : '/*' ~('*') ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4395
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4397
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g" 4399
RULE_ANY_OTHER : .;


