lexer grammar InternalOCLinEcore;
@header {
package org.eclipse.ocl.examples.xtext.oclinecore.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T13 : '*' ;
T14 : 'abstract' ;
T15 : 'annotation' ;
T16 : 'attribute' ;
T17 : 'body' ;
T18 : 'class' ;
T19 : 'composes' ;
T20 : 'datatype' ;
T21 : 'derived' ;
T22 : 'documentation' ;
T23 : 'enum' ;
T24 : 'extends' ;
T25 : 'id' ;
T26 : 'import' ;
T27 : 'initial' ;
T28 : 'interface' ;
T29 : 'invariant' ;
T30 : 'library' ;
T31 : 'operation' ;
T32 : 'ordered' ;
T33 : 'package' ;
T34 : 'property' ;
T35 : 'readonly' ;
T36 : 'resolve' ;
T37 : 'serializable' ;
T38 : 'static' ;
T39 : 'super' ;
T40 : 'transient' ;
T41 : 'unique' ;
T42 : 'unsettable' ;
T43 : 'volatile' ;
T44 : ':' ;
T45 : ';' ;
T46 : 'derivation' ;
T47 : 'postcondition' ;
T48 : 'precondition' ;
T49 : '(' ;
T50 : ',' ;
T51 : ')' ;
T52 : '{' ;
T53 : '}' ;
T54 : 'definition' ;
T55 : '[' ;
T56 : '..' ;
T57 : '+' ;
T58 : '?' ;
T59 : ']' ;
T60 : '=' ;
T61 : '!derived' ;
T62 : '!id' ;
T63 : '!ordered' ;
T64 : '!readonly' ;
T65 : '!transient' ;
T66 : '!unique' ;
T67 : '!unsettable' ;
T68 : '!volatile' ;
T69 : '<' ;
T70 : '>' ;
T71 : '!abstract' ;
T72 : '!interface' ;
T73 : '!serializable' ;
T74 : 'throws' ;
T75 : '::' ;
T76 : '#' ;
T77 : '!composes' ;
T78 : '!resolve' ;
T79 : '&&' ;
T80 : '.' ;
T81 : 'e' ;
T82 : 'E' ;
T83 : '-' ;
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
T97 : 'Tuple' ;
T98 : 'true' ;
T99 : 'false' ;
T100 : 'invalid' ;
T101 : 'null' ;
T102 : 'implies' ;
T103 : 'xor' ;
T104 : 'or' ;
T105 : 'and' ;
T106 : '<>' ;
T107 : '>=' ;
T108 : '<=' ;
T109 : '/' ;
T110 : 'not' ;
T111 : '->' ;
T112 : '@' ;
T113 : 'pre' ;
T114 : '|' ;
T115 : 'self' ;
T116 : 'if' ;
T117 : 'then' ;
T118 : 'else' ;
T119 : 'endif' ;
T120 : 'let' ;
T121 : 'in' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11625
RULE_UNQUOTED_STRING : '\u00A3$%^\u00A3$%^';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11627
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11629
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11631
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11633
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11635
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11637
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11639
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g" 11641
RULE_ANY_OTHER : .;


