lexer grammar InternalOCLinEcore;
@header {
package org.eclipse.ocl.examples.xtext.oclinecore.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
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
T44 : ';' ;
T45 : '+' ;
T46 : '?' ;
T47 : '!derived' ;
T48 : '!id' ;
T49 : '!ordered' ;
T50 : '!readonly' ;
T51 : '!transient' ;
T52 : '!unique' ;
T53 : '!unsettable' ;
T54 : '!volatile' ;
T55 : '!abstract' ;
T56 : '!interface' ;
T57 : '!serializable' ;
T58 : '!composes' ;
T59 : '!resolve' ;
T60 : 'e' ;
T61 : 'E' ;
T62 : '-' ;
T63 : 'Boolean' ;
T64 : 'Integer' ;
T65 : 'Real' ;
T66 : 'String' ;
T67 : 'UnlimitedNatural' ;
T68 : 'OclAny' ;
T69 : 'OclInvalid' ;
T70 : 'OclVoid' ;
T71 : 'Set' ;
T72 : 'Bag' ;
T73 : 'Sequence' ;
T74 : 'Collection' ;
T75 : 'OrderedSet' ;
T76 : '=' ;
T77 : '<>' ;
T78 : '>' ;
T79 : '<' ;
T80 : '>=' ;
T81 : '<=' ;
T82 : '/' ;
T83 : 'not' ;
T84 : ':' ;
T85 : '(' ;
T86 : ')' ;
T87 : ',' ;
T88 : '{' ;
T89 : '}' ;
T90 : '[' ;
T91 : ']' ;
T92 : '..' ;
T93 : 'throws' ;
T94 : '::' ;
T95 : '#' ;
T96 : '&&' ;
T97 : '.' ;
T98 : 'Tuple' ;
T99 : 'invalid' ;
T100 : 'null' ;
T101 : '->' ;
T102 : '|' ;
T103 : 'self' ;
T104 : 'if' ;
T105 : 'then' ;
T106 : 'else' ;
T107 : 'endif' ;
T108 : 'let' ;
T109 : 'in' ;
T110 : 'derivation' ;
T111 : 'postcondition' ;
T112 : 'precondition' ;
T113 : 'definition' ;
T114 : 'true' ;
T115 : 'false' ;
T116 : 'implies' ;
T117 : 'xor' ;
T118 : 'or' ;
T119 : 'and' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19297
RULE_UNQUOTED_STRING : '\u00A3$%^\u00A3$%^';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19299
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19301
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19303
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19305
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19307
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19309
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19311
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19313
RULE_ANY_OTHER : .;


