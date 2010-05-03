package org.eclipse.ocl.examples.xtext.oclstdlib.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalOCLstdlibLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=8;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID_TERMINAL=5;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T11=11;
    public static final int T36=36;
    public static final int T12=12;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T40=40;
    public static final int T35=35;
    public static final int T13=13;
    public static final int T34=34;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T37=37;
    public static final int T18=18;
    public static final int RULE_WS=10;
    public static final int T26=26;
    public static final int T15=15;
    public static final int RULE_INT=4;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int T17=17;
    public static final int Tokens=41;
    public static final int RULE_SINGLE_QUOTED_STRING=6;
    public static final int T31=31;
    public static final int RULE_DOUBLE_QUOTED_STRING=7;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=9;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T39=39;
    public InternalOCLstdlibLexer() {;} 
    public InternalOCLstdlibLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:10:5: ( 'library' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:10:7: 'library'
            {
            match("library"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:11:5: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:11:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:12:5: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:12:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:13:5: ( '*' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:13:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:14:5: ( 'conformsTo' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:14:7: 'conformsTo'
            {
            match("conformsTo"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:15:5: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:15:7: 'extends'
            {
            match("extends"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:16:5: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:16:7: 'import'
            {
            match("import"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:17:5: ( 'iteration' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:17:7: 'iteration'
            {
            match("iteration"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:18:5: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:18:7: 'operation'
            {
            match("operation"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:19:5: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:19:7: 'package'
            {
            match("package"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:20:5: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:20:7: 'property'
            {
            match("property"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:21:5: ( 'static' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:21:7: 'static'
            {
            match("static"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:22:5: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:22:7: 'super'
            {
            match("super"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:23:5: ( 'type' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:23:7: 'type'
            {
            match("type"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:24:5: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:24:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:25:5: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:25:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:26:5: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:26:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:27:5: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:27:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:28:5: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:28:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:29:5: ( '...' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:29:7: '...'
            {
            match("..."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:30:5: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:30:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:31:5: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:31:7: '=>'
            {
            match("=>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:32:5: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:32:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:33:5: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:33:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:34:5: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:34:7: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:35:5: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:35:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:36:5: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:36:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:37:5: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:37:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:38:5: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:38:7: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:39:5: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:39:7: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start RULE_DOUBLE_QUOTED_STRING
    public final void mRULE_DOUBLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_QUOTED_STRING;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2159:27: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2159:29: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2159:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFE')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2159:34: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2159:75: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_DOUBLE_QUOTED_STRING

    // $ANTLR start RULE_SINGLE_QUOTED_STRING
    public final void mRULE_SINGLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_SINGLE_QUOTED_STRING;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2161:27: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2161:29: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2161:34: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFE')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2161:35: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2161:76: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SINGLE_QUOTED_STRING

    // $ANTLR start RULE_ID_TERMINAL
    public final void mRULE_ID_TERMINAL() throws RecognitionException {
        try {
            int _type = RULE_ID_TERMINAL;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:18: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='_') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\'') ) {
                    alt4=2;
                }
                else {
                    alt4=1;}
            }
            else if ( ((LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')) ) {
                alt4=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2163:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:21: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:45: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:79: '_' RULE_SINGLE_QUOTED_STRING
                    {
                    match('_'); 
                    mRULE_SINGLE_QUOTED_STRING(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID_TERMINAL

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2165:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2165:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2165:24: ( options {greedy=false; } : . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='.')||(LA5_1>='0' && LA5_1<='\uFFFE')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<=')')||(LA5_0>='+' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2165:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:40: ( ( '\\r' )? '\\n' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\n'||LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:41: ( '\\r' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2167:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2169:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2169:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2169:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2171:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2171:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2171:12: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2171:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_INT )
        int alt11=37;
        switch ( input.LA(1) ) {
        case 'l':
            {
            int LA11_1 = input.LA(2);

            if ( (LA11_1=='i') ) {
                int LA11_33 = input.LA(3);

                if ( (LA11_33=='b') ) {
                    int LA11_47 = input.LA(4);

                    if ( (LA11_47=='r') ) {
                        int LA11_60 = input.LA(5);

                        if ( (LA11_60=='a') ) {
                            int LA11_71 = input.LA(6);

                            if ( (LA11_71=='r') ) {
                                int LA11_82 = input.LA(7);

                                if ( (LA11_82=='y') ) {
                                    int LA11_92 = input.LA(8);

                                    if ( ((LA11_92>='0' && LA11_92<='9')||(LA11_92>='A' && LA11_92<='Z')||LA11_92=='_'||(LA11_92>='a' && LA11_92<='z')) ) {
                                        alt11=33;
                                    }
                                    else {
                                        alt11=1;}
                                }
                                else {
                                    alt11=33;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
            }
            else {
                alt11=33;}
            }
            break;
        case '{':
            {
            alt11=2;
            }
            break;
        case '}':
            {
            alt11=3;
            }
            break;
        case '*':
            {
            alt11=4;
            }
            break;
        case 'c':
            {
            int LA11_5 = input.LA(2);

            if ( (LA11_5=='o') ) {
                int LA11_34 = input.LA(3);

                if ( (LA11_34=='n') ) {
                    int LA11_48 = input.LA(4);

                    if ( (LA11_48=='f') ) {
                        int LA11_61 = input.LA(5);

                        if ( (LA11_61=='o') ) {
                            int LA11_72 = input.LA(6);

                            if ( (LA11_72=='r') ) {
                                int LA11_83 = input.LA(7);

                                if ( (LA11_83=='m') ) {
                                    int LA11_93 = input.LA(8);

                                    if ( (LA11_93=='s') ) {
                                        int LA11_102 = input.LA(9);

                                        if ( (LA11_102=='T') ) {
                                            int LA11_108 = input.LA(10);

                                            if ( (LA11_108=='o') ) {
                                                int LA11_112 = input.LA(11);

                                                if ( ((LA11_112>='0' && LA11_112<='9')||(LA11_112>='A' && LA11_112<='Z')||LA11_112=='_'||(LA11_112>='a' && LA11_112<='z')) ) {
                                                    alt11=33;
                                                }
                                                else {
                                                    alt11=5;}
                                            }
                                            else {
                                                alt11=33;}
                                        }
                                        else {
                                            alt11=33;}
                                    }
                                    else {
                                        alt11=33;}
                                }
                                else {
                                    alt11=33;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
            }
            else {
                alt11=33;}
            }
            break;
        case 'e':
            {
            int LA11_6 = input.LA(2);

            if ( (LA11_6=='x') ) {
                int LA11_35 = input.LA(3);

                if ( (LA11_35=='t') ) {
                    int LA11_49 = input.LA(4);

                    if ( (LA11_49=='e') ) {
                        int LA11_62 = input.LA(5);

                        if ( (LA11_62=='n') ) {
                            int LA11_73 = input.LA(6);

                            if ( (LA11_73=='d') ) {
                                int LA11_84 = input.LA(7);

                                if ( (LA11_84=='s') ) {
                                    int LA11_94 = input.LA(8);

                                    if ( ((LA11_94>='0' && LA11_94<='9')||(LA11_94>='A' && LA11_94<='Z')||LA11_94=='_'||(LA11_94>='a' && LA11_94<='z')) ) {
                                        alt11=33;
                                    }
                                    else {
                                        alt11=6;}
                                }
                                else {
                                    alt11=33;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
            }
            else {
                alt11=33;}
            }
            break;
        case 'i':
            {
            switch ( input.LA(2) ) {
            case 't':
                {
                int LA11_36 = input.LA(3);

                if ( (LA11_36=='e') ) {
                    int LA11_50 = input.LA(4);

                    if ( (LA11_50=='r') ) {
                        int LA11_63 = input.LA(5);

                        if ( (LA11_63=='a') ) {
                            int LA11_74 = input.LA(6);

                            if ( (LA11_74=='t') ) {
                                int LA11_85 = input.LA(7);

                                if ( (LA11_85=='i') ) {
                                    int LA11_95 = input.LA(8);

                                    if ( (LA11_95=='o') ) {
                                        int LA11_104 = input.LA(9);

                                        if ( (LA11_104=='n') ) {
                                            int LA11_109 = input.LA(10);

                                            if ( ((LA11_109>='0' && LA11_109<='9')||(LA11_109>='A' && LA11_109<='Z')||LA11_109=='_'||(LA11_109>='a' && LA11_109<='z')) ) {
                                                alt11=33;
                                            }
                                            else {
                                                alt11=8;}
                                        }
                                        else {
                                            alt11=33;}
                                    }
                                    else {
                                        alt11=33;}
                                }
                                else {
                                    alt11=33;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
                }
                break;
            case 'm':
                {
                int LA11_37 = input.LA(3);

                if ( (LA11_37=='p') ) {
                    int LA11_51 = input.LA(4);

                    if ( (LA11_51=='o') ) {
                        int LA11_64 = input.LA(5);

                        if ( (LA11_64=='r') ) {
                            int LA11_75 = input.LA(6);

                            if ( (LA11_75=='t') ) {
                                int LA11_86 = input.LA(7);

                                if ( ((LA11_86>='0' && LA11_86<='9')||(LA11_86>='A' && LA11_86<='Z')||LA11_86=='_'||(LA11_86>='a' && LA11_86<='z')) ) {
                                    alt11=33;
                                }
                                else {
                                    alt11=7;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
                }
                break;
            default:
                alt11=33;}

            }
            break;
        case 'o':
            {
            int LA11_8 = input.LA(2);

            if ( (LA11_8=='p') ) {
                int LA11_38 = input.LA(3);

                if ( (LA11_38=='e') ) {
                    int LA11_52 = input.LA(4);

                    if ( (LA11_52=='r') ) {
                        int LA11_65 = input.LA(5);

                        if ( (LA11_65=='a') ) {
                            int LA11_76 = input.LA(6);

                            if ( (LA11_76=='t') ) {
                                int LA11_87 = input.LA(7);

                                if ( (LA11_87=='i') ) {
                                    int LA11_97 = input.LA(8);

                                    if ( (LA11_97=='o') ) {
                                        int LA11_105 = input.LA(9);

                                        if ( (LA11_105=='n') ) {
                                            int LA11_110 = input.LA(10);

                                            if ( ((LA11_110>='0' && LA11_110<='9')||(LA11_110>='A' && LA11_110<='Z')||LA11_110=='_'||(LA11_110>='a' && LA11_110<='z')) ) {
                                                alt11=33;
                                            }
                                            else {
                                                alt11=9;}
                                        }
                                        else {
                                            alt11=33;}
                                    }
                                    else {
                                        alt11=33;}
                                }
                                else {
                                    alt11=33;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
            }
            else {
                alt11=33;}
            }
            break;
        case 'p':
            {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA11_39 = input.LA(3);

                if ( (LA11_39=='o') ) {
                    int LA11_53 = input.LA(4);

                    if ( (LA11_53=='p') ) {
                        int LA11_66 = input.LA(5);

                        if ( (LA11_66=='e') ) {
                            int LA11_77 = input.LA(6);

                            if ( (LA11_77=='r') ) {
                                int LA11_88 = input.LA(7);

                                if ( (LA11_88=='t') ) {
                                    int LA11_98 = input.LA(8);

                                    if ( (LA11_98=='y') ) {
                                        int LA11_106 = input.LA(9);

                                        if ( ((LA11_106>='0' && LA11_106<='9')||(LA11_106>='A' && LA11_106<='Z')||LA11_106=='_'||(LA11_106>='a' && LA11_106<='z')) ) {
                                            alt11=33;
                                        }
                                        else {
                                            alt11=11;}
                                    }
                                    else {
                                        alt11=33;}
                                }
                                else {
                                    alt11=33;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
                }
                break;
            case 'a':
                {
                int LA11_40 = input.LA(3);

                if ( (LA11_40=='c') ) {
                    int LA11_54 = input.LA(4);

                    if ( (LA11_54=='k') ) {
                        int LA11_67 = input.LA(5);

                        if ( (LA11_67=='a') ) {
                            int LA11_78 = input.LA(6);

                            if ( (LA11_78=='g') ) {
                                int LA11_89 = input.LA(7);

                                if ( (LA11_89=='e') ) {
                                    int LA11_99 = input.LA(8);

                                    if ( ((LA11_99>='0' && LA11_99<='9')||(LA11_99>='A' && LA11_99<='Z')||LA11_99=='_'||(LA11_99>='a' && LA11_99<='z')) ) {
                                        alt11=33;
                                    }
                                    else {
                                        alt11=10;}
                                }
                                else {
                                    alt11=33;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
                }
                break;
            default:
                alt11=33;}

            }
            break;
        case 's':
            {
            switch ( input.LA(2) ) {
            case 't':
                {
                int LA11_41 = input.LA(3);

                if ( (LA11_41=='a') ) {
                    int LA11_55 = input.LA(4);

                    if ( (LA11_55=='t') ) {
                        int LA11_68 = input.LA(5);

                        if ( (LA11_68=='i') ) {
                            int LA11_79 = input.LA(6);

                            if ( (LA11_79=='c') ) {
                                int LA11_90 = input.LA(7);

                                if ( ((LA11_90>='0' && LA11_90<='9')||(LA11_90>='A' && LA11_90<='Z')||LA11_90=='_'||(LA11_90>='a' && LA11_90<='z')) ) {
                                    alt11=33;
                                }
                                else {
                                    alt11=12;}
                            }
                            else {
                                alt11=33;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
                }
                break;
            case 'u':
                {
                int LA11_42 = input.LA(3);

                if ( (LA11_42=='p') ) {
                    int LA11_56 = input.LA(4);

                    if ( (LA11_56=='e') ) {
                        int LA11_69 = input.LA(5);

                        if ( (LA11_69=='r') ) {
                            int LA11_80 = input.LA(6);

                            if ( ((LA11_80>='0' && LA11_80<='9')||(LA11_80>='A' && LA11_80<='Z')||LA11_80=='_'||(LA11_80>='a' && LA11_80<='z')) ) {
                                alt11=33;
                            }
                            else {
                                alt11=13;}
                        }
                        else {
                            alt11=33;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
                }
                break;
            default:
                alt11=33;}

            }
            break;
        case 't':
            {
            int LA11_11 = input.LA(2);

            if ( (LA11_11=='y') ) {
                int LA11_43 = input.LA(3);

                if ( (LA11_43=='p') ) {
                    int LA11_57 = input.LA(4);

                    if ( (LA11_57=='e') ) {
                        int LA11_70 = input.LA(5);

                        if ( ((LA11_70>='0' && LA11_70<='9')||(LA11_70>='A' && LA11_70<='Z')||LA11_70=='_'||(LA11_70>='a' && LA11_70<='z')) ) {
                            alt11=33;
                        }
                        else {
                            alt11=14;}
                    }
                    else {
                        alt11=33;}
                }
                else {
                    alt11=33;}
            }
            else {
                alt11=33;}
            }
            break;
        case ':':
            {
            int LA11_12 = input.LA(2);

            if ( (LA11_12==':') ) {
                alt11=29;
            }
            else {
                alt11=15;}
            }
            break;
        case '<':
            {
            alt11=16;
            }
            break;
        case ',':
            {
            alt11=17;
            }
            break;
        case '>':
            {
            alt11=18;
            }
            break;
        case '(':
            {
            alt11=19;
            }
            break;
        case '.':
            {
            int LA11_17 = input.LA(2);

            if ( (LA11_17=='.') ) {
                int LA11_46 = input.LA(3);

                if ( (LA11_46=='.') ) {
                    alt11=20;
                }
                else {
                    alt11=25;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_INT );", 11, 17, input);

                throw nvae;
            }
            }
            break;
        case ')':
            {
            alt11=21;
            }
            break;
        case '=':
            {
            alt11=22;
            }
            break;
        case ';':
            {
            alt11=23;
            }
            break;
        case '[':
            {
            alt11=24;
            }
            break;
        case '+':
            {
            alt11=26;
            }
            break;
        case '?':
            {
            alt11=27;
            }
            break;
        case ']':
            {
            alt11=28;
            }
            break;
        case '&':
            {
            alt11=30;
            }
            break;
        case '\"':
            {
            alt11=31;
            }
            break;
        case '\'':
            {
            alt11=32;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'd':
        case 'f':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'm':
        case 'n':
        case 'q':
        case 'r':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt11=33;
            }
            break;
        case '/':
            {
            alt11=34;
            }
            break;
        case '-':
            {
            alt11=35;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt11=36;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt11=37;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_INT );", 11, 0, input);

            throw nvae;
        }

        switch (alt11) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:130: RULE_DOUBLE_QUOTED_STRING
                {
                mRULE_DOUBLE_QUOTED_STRING(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:156: RULE_SINGLE_QUOTED_STRING
                {
                mRULE_SINGLE_QUOTED_STRING(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:182: RULE_ID_TERMINAL
                {
                mRULE_ID_TERMINAL(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:199: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:215: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 36 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:231: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 37 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:239: RULE_INT
                {
                mRULE_INT(); 

                }
                break;

        }

    }


 

}