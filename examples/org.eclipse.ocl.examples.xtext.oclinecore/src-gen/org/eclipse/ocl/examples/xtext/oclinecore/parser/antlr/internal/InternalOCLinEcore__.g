lexer grammar InternalOCLinEcore;
@header {
package org.eclipse.ocl.examples.xtext.oclinecore.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '*' ;
T13 : 'abstract' ;
T14 : 'attribute' ;
T15 : 'body' ;
T16 : 'class' ;
T17 : 'enum' ;
T18 : 'extends' ;
T19 : 'id' ;
T20 : 'import' ;
T21 : 'interface' ;
T22 : 'invariant' ;
T23 : 'operation' ;
T24 : 'ordered' ;
T25 : 'package' ;
T26 : 'property' ;
T27 : 'serializable' ;
T28 : 'transient' ;
T29 : 'unique' ;
T30 : 'volatile' ;
T31 : 'e' ;
T32 : 'E' ;
T33 : ':' ;
T34 : ';' ;
T35 : 'derivation' ;
T36 : 'initial' ;
T37 : 'postcondition' ;
T38 : 'precondition' ;
T39 : 'annotation' ;
T40 : '(' ;
T41 : ',' ;
T42 : ')' ;
T43 : '{' ;
T44 : '}' ;
T45 : '[' ;
T46 : '..' ;
T47 : '+' ;
T48 : '?' ;
T49 : ']' ;
T50 : '=' ;
T51 : 'api' ;
T52 : '!api' ;
T53 : 'derived' ;
T54 : '!derived' ;
T55 : '!id' ;
T56 : '!ordered' ;
T57 : 'readonly' ;
T58 : '!readonly' ;
T59 : '!transient' ;
T60 : '!unique' ;
T61 : 'unsettable' ;
T62 : '!unsettable' ;
T63 : '!volatile' ;
T64 : '<' ;
T65 : '>' ;
T66 : '!abstract' ;
T67 : '!interface' ;
T68 : 'datatype' ;
T69 : '!serializable' ;
T70 : 'documentation' ;
T71 : '::' ;
T72 : 'throws' ;
T73 : '#' ;
T74 : 'composes' ;
T75 : '!composes' ;
T76 : 'resolve' ;
T77 : '!resolve' ;
T78 : '&&' ;
T79 : 'super' ;
T80 : '.' ;
T81 : '-' ;
T82 : 'Tuple' ;
T83 : 'self' ;
T84 : 'Boolean' ;
T85 : 'Integer' ;
T86 : 'Real' ;
T87 : 'String' ;
T88 : 'UnlimitedNatural' ;
T89 : 'OclAny' ;
T90 : 'OclInvalid' ;
T91 : 'OclVoid' ;
T92 : 'Set' ;
T93 : 'Bag' ;
T94 : 'Sequence' ;
T95 : 'Collection' ;
T96 : 'OrderedSet' ;
T97 : 'true' ;
T98 : 'false' ;
T99 : 'invalid' ;
T100 : 'null' ;
T101 : 'implies' ;
T102 : 'xor' ;
T103 : 'or' ;
T104 : 'and' ;
T105 : '<>' ;
T106 : '>=' ;
T107 : '<=' ;
T108 : '/' ;
T109 : 'not' ;
T110 : '->' ;
T111 : '|' ;
T112 : 'if' ;
T113 : 'then' ;
T114 : 'else' ;
T115 : 'endif' ;
T116 : 'let' ;
T117 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11841
RULE_URL : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11843
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11845
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11847
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11849
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11851
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11853
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11855
RULE_ANY_OTHER : .;


