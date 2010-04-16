lexer grammar InternalOCLinEcore;
@header {
package org.eclipse.ocl.examples.xtext.oclinecore.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
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
T33 : ';' ;
T34 : '+' ;
T35 : '?' ;
T36 : 'api' ;
T37 : '!api' ;
T38 : 'derived' ;
T39 : '!derived' ;
T40 : '!id' ;
T41 : '!ordered' ;
T42 : 'readonly' ;
T43 : '!readonly' ;
T44 : '!transient' ;
T45 : '!unique' ;
T46 : 'unsettable' ;
T47 : '!unsettable' ;
T48 : '!volatile' ;
T49 : '!abstract' ;
T50 : '!interface' ;
T51 : '!serializable' ;
T52 : 'composes' ;
T53 : '!composes' ;
T54 : 'resolve' ;
T55 : '!resolve' ;
T56 : '-' ;
T57 : '=' ;
T58 : '<>' ;
T59 : '>' ;
T60 : '<' ;
T61 : '>=' ;
T62 : '<=' ;
T63 : '/' ;
T64 : 'not' ;
T65 : '.' ;
T66 : '->' ;
T67 : ':' ;
T68 : 'annotation' ;
T69 : '(' ;
T70 : ')' ;
T71 : ',' ;
T72 : '{' ;
T73 : '}' ;
T74 : '[' ;
T75 : ']' ;
T76 : '..' ;
T77 : 'datatype' ;
T78 : 'documentation' ;
T79 : '::' ;
T80 : 'throws' ;
T81 : '#' ;
T82 : '&&' ;
T83 : 'super' ;
T84 : 'Tuple' ;
T85 : 'invalid' ;
T86 : 'null' ;
T87 : '|' ;
T88 : 'if' ;
T89 : 'then' ;
T90 : 'else' ;
T91 : 'endif' ;
T92 : 'let' ;
T93 : 'in' ;
T94 : 'derivation' ;
T95 : 'initial' ;
T96 : 'postcondition' ;
T97 : 'precondition' ;
T98 : 'self' ;
T99 : 'Boolean' ;
T100 : 'Integer' ;
T101 : 'Real' ;
T102 : 'String' ;
T103 : 'UnlimitedNatural' ;
T104 : 'OclAny' ;
T105 : 'OclInvalid' ;
T106 : 'OclVoid' ;
T107 : 'Set' ;
T108 : 'Bag' ;
T109 : 'Sequence' ;
T110 : 'Collection' ;
T111 : 'OrderedSet' ;
T112 : 'true' ;
T113 : 'false' ;
T114 : 'implies' ;
T115 : 'xor' ;
T116 : 'or' ;
T117 : 'and' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19077
RULE_URL : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19079
RULE_STRING_LITERAL : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19081
RULE_ID_TERMINAL : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_STRING_LITERAL);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19083
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19085
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19087
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19089
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 19091
RULE_ANY_OTHER : .;


