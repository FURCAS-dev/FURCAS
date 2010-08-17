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
T84 : '.' ;
T85 : '->' ;
T86 : ':' ;
T87 : '(' ;
T88 : ')' ;
T89 : ',' ;
T90 : '{' ;
T91 : '}' ;
T92 : '[' ;
T93 : ']' ;
T94 : '..' ;
T95 : 'throws' ;
T96 : '::' ;
T97 : '#' ;
T98 : '&&' ;
T99 : 'Tuple' ;
T100 : 'invalid' ;
T101 : 'null' ;
T102 : '@' ;
T103 : '|' ;
T104 : 'pre' ;
T105 : 'self' ;
T106 : 'if' ;
T107 : 'then' ;
T108 : 'else' ;
T109 : 'endif' ;
T110 : 'let' ;
T111 : 'in' ;
T112 : 'derivation' ;
T113 : 'postcondition' ;
T114 : 'precondition' ;
T115 : 'definition' ;
T116 : 'true' ;
T117 : 'false' ;
T118 : 'implies' ;
T119 : 'xor' ;
T120 : 'or' ;
T121 : 'and' ;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 24986
RULE_UNQUOTED_STRING : '\u00A3$%^\u00A3$%^';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 24988
RULE_DOUBLE_QUOTED_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 24990
RULE_SINGLE_QUOTED_STRING : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 24992
RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'_' RULE_SINGLE_QUOTED_STRING);

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 24994
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 24996
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 24998
RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 25000
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g" 25002
RULE_ANY_OTHER : .;


