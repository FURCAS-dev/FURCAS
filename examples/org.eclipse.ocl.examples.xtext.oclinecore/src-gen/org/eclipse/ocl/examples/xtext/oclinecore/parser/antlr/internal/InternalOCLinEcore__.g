lexer grammar InternalOCLinEcore;
@header {
package org.eclipse.ocl.examples.xtext.oclinecore.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T13 : '.' ;
T14 : '*' ;
T15 : 'body' ;
T16 : ':' ;
T17 : ';' ;
T18 : 'derivation' ;
T19 : 'initial' ;
T20 : 'invariant' ;
T21 : 'postcondition' ;
T22 : 'precondition' ;
T23 : '@' ;
T24 : '(' ;
T25 : ',' ;
T26 : ')' ;
T27 : 'derived' ;
T28 : '!derived' ;
T29 : 'id' ;
T30 : '!id' ;
T31 : 'ordered' ;
T32 : '!ordered' ;
T33 : 'readonly' ;
T34 : '!readonly' ;
T35 : 'transient' ;
T36 : '!transient' ;
T37 : 'unique' ;
T38 : '!unique' ;
T39 : 'unsettable' ;
T40 : '!unsettable' ;
T41 : 'volatile' ;
T42 : '!volatile' ;
T43 : 'attribute' ;
T44 : '[' ;
T45 : '..' ;
T46 : '+' ;
T47 : '?' ;
T48 : ']' ;
T49 : '=' ;
T50 : '{' ;
T51 : '}' ;
T52 : 'abstract' ;
T53 : '!abstract' ;
T54 : 'interface' ;
T55 : '!interface' ;
T56 : 'class' ;
T57 : '<' ;
T58 : '>' ;
T59 : 'extends' ;
T60 : 'datatype' ;
T61 : '::' ;
T62 : 'enum' ;
T63 : 'import' ;
T64 : 'operation' ;
T65 : 'package' ;
T66 : 'resolve' ;
T67 : '!resolve' ;
T68 : 'reference' ;
T69 : 'property' ;
T70 : '#' ;
T71 : '&&' ;
T72 : 'super' ;
T73 : 'e' ;
T74 : 'E' ;
T75 : '-' ;
T76 : 'Tuple' ;
T77 : 'self' ;
T78 : 'Boolean' ;
T79 : 'Integer' ;
T80 : 'Real' ;
T81 : 'String' ;
T82 : 'UnlimitedNatural' ;
T83 : 'OclAny' ;
T84 : 'OclInvalid' ;
T85 : 'OclVoid' ;
T86 : 'Set' ;
T87 : 'Bag' ;
T88 : 'Sequence' ;
T89 : 'Collection' ;
T90 : 'OrderedSet' ;
T91 : 'true' ;
T92 : 'false' ;
T93 : 'invalid' ;
T94 : 'null' ;
T95 : 'implies' ;
T96 : 'xor' ;
T97 : 'or' ;
T98 : 'and' ;
T99 : '<>' ;
T100 : '>=' ;
T101 : '<=' ;
T102 : '/' ;
T103 : 'not' ;
T104 : '->' ;
T105 : '|' ;
T106 : 'if' ;
T107 : 'then' ;
T108 : 'else' ;
T109 : 'endif' ;
T110 : 'let' ;
T111 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10049
RULE_URL : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10051
RULE_OCL : '\u00A3' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '\u00A3';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10053
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10055
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10057
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10059
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10061
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10063
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 10065
RULE_ANY_OTHER : .;


