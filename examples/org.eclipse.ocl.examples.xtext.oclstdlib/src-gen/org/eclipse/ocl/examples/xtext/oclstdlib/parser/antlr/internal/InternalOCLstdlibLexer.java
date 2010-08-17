package org.eclipse.ocl.examples.xtext.oclstdlib.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOCLstdlibLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int RULE_DOUBLE_QUOTED_STRING=6;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=39;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=9;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_INT=4;
    public static final int T38=38;
    public static final int T11=11;
    public static final int T37=37;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T34=34;
    public static final int RULE_WS=10;
    public static final int T15=15;
    public static final int T33=33;
    public static final int T16=16;
    public static final int T36=36;
    public static final int T17=17;
    public static final int T35=35;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public static final int T32=32;
    public static final int T31=31;
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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:21:5: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:21:7: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:22:5: ( 'type' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:22:7: 'type'
            {
            match("type"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:23:5: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:23:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:24:5: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:24:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:25:5: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:25:7: ','
            {
            match(','); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:26:5: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:26:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:27:5: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:27:7: '('
            {
            match('('); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:28:5: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:28:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:29:5: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:29:7: '=>'
            {
            match("=>"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:30:5: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:30:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:31:5: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:31:7: '['
            {
            match('['); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:32:5: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:32:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:33:5: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:33:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:34:5: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:34:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:35:5: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:35:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:36:5: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:36:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:37:5: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:37:7: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start RULE_DOUBLE_QUOTED_STRING
    public final void mRULE_DOUBLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_QUOTED_STRING;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2222:27: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2222:29: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2222:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2222:34: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2222:79: ~ ( ( '\\\\' | '\"' ) )
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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2224:27: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2224:29: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2224:34: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2224:35: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2224:80: ~ ( ( '\\\\' | '\\'' ) )
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

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2226:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2226:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2226:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
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
                    new NoViableAltException("2226:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2226:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2226:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2226:70: '_' RULE_SINGLE_QUOTED_STRING
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
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2228:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2228:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2228:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2228:52: .
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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:40: ( ( '\\r' )? '\\n' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\n'||LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:41: ( '\\r' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2230:41: '\\r'
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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2232:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2232:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2232:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2234:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2234:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2234:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2234:13: '0' .. '9'
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
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_INT )
        int alt11=35;
        switch ( input.LA(1) ) {
        case 'l':
            {
            int LA11_1 = input.LA(2);

            if ( (LA11_1=='i') ) {
                int LA11_33 = input.LA(3);

                if ( (LA11_33=='b') ) {
                    int LA11_45 = input.LA(4);

                    if ( (LA11_45=='r') ) {
                        int LA11_55 = input.LA(5);

                        if ( (LA11_55=='a') ) {
                            int LA11_65 = input.LA(6);

                            if ( (LA11_65=='r') ) {
                                int LA11_75 = input.LA(7);

                                if ( (LA11_75=='y') ) {
                                    int LA11_84 = input.LA(8);

                                    if ( ((LA11_84>='0' && LA11_84<='9')||(LA11_84>='A' && LA11_84<='Z')||LA11_84=='_'||(LA11_84>='a' && LA11_84<='z')) ) {
                                        alt11=31;
                                    }
                                    else {
                                        alt11=1;}
                                }
                                else {
                                    alt11=31;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
            }
            else {
                alt11=31;}
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
                    int LA11_46 = input.LA(4);

                    if ( (LA11_46=='f') ) {
                        int LA11_56 = input.LA(5);

                        if ( (LA11_56=='o') ) {
                            int LA11_66 = input.LA(6);

                            if ( (LA11_66=='r') ) {
                                int LA11_76 = input.LA(7);

                                if ( (LA11_76=='m') ) {
                                    int LA11_85 = input.LA(8);

                                    if ( (LA11_85=='s') ) {
                                        int LA11_93 = input.LA(9);

                                        if ( (LA11_93=='T') ) {
                                            int LA11_99 = input.LA(10);

                                            if ( (LA11_99=='o') ) {
                                                int LA11_103 = input.LA(11);

                                                if ( ((LA11_103>='0' && LA11_103<='9')||(LA11_103>='A' && LA11_103<='Z')||LA11_103=='_'||(LA11_103>='a' && LA11_103<='z')) ) {
                                                    alt11=31;
                                                }
                                                else {
                                                    alt11=5;}
                                            }
                                            else {
                                                alt11=31;}
                                        }
                                        else {
                                            alt11=31;}
                                    }
                                    else {
                                        alt11=31;}
                                }
                                else {
                                    alt11=31;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
            }
            else {
                alt11=31;}
            }
            break;
        case 'e':
            {
            int LA11_6 = input.LA(2);

            if ( (LA11_6=='x') ) {
                int LA11_35 = input.LA(3);

                if ( (LA11_35=='t') ) {
                    int LA11_47 = input.LA(4);

                    if ( (LA11_47=='e') ) {
                        int LA11_57 = input.LA(5);

                        if ( (LA11_57=='n') ) {
                            int LA11_67 = input.LA(6);

                            if ( (LA11_67=='d') ) {
                                int LA11_77 = input.LA(7);

                                if ( (LA11_77=='s') ) {
                                    int LA11_86 = input.LA(8);

                                    if ( ((LA11_86>='0' && LA11_86<='9')||(LA11_86>='A' && LA11_86<='Z')||LA11_86=='_'||(LA11_86>='a' && LA11_86<='z')) ) {
                                        alt11=31;
                                    }
                                    else {
                                        alt11=6;}
                                }
                                else {
                                    alt11=31;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
            }
            else {
                alt11=31;}
            }
            break;
        case 'i':
            {
            switch ( input.LA(2) ) {
            case 't':
                {
                int LA11_36 = input.LA(3);

                if ( (LA11_36=='e') ) {
                    int LA11_48 = input.LA(4);

                    if ( (LA11_48=='r') ) {
                        int LA11_58 = input.LA(5);

                        if ( (LA11_58=='a') ) {
                            int LA11_68 = input.LA(6);

                            if ( (LA11_68=='t') ) {
                                int LA11_78 = input.LA(7);

                                if ( (LA11_78=='i') ) {
                                    int LA11_87 = input.LA(8);

                                    if ( (LA11_87=='o') ) {
                                        int LA11_95 = input.LA(9);

                                        if ( (LA11_95=='n') ) {
                                            int LA11_100 = input.LA(10);

                                            if ( ((LA11_100>='0' && LA11_100<='9')||(LA11_100>='A' && LA11_100<='Z')||LA11_100=='_'||(LA11_100>='a' && LA11_100<='z')) ) {
                                                alt11=31;
                                            }
                                            else {
                                                alt11=8;}
                                        }
                                        else {
                                            alt11=31;}
                                    }
                                    else {
                                        alt11=31;}
                                }
                                else {
                                    alt11=31;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
                }
                break;
            case 'm':
                {
                int LA11_37 = input.LA(3);

                if ( (LA11_37=='p') ) {
                    int LA11_49 = input.LA(4);

                    if ( (LA11_49=='o') ) {
                        int LA11_59 = input.LA(5);

                        if ( (LA11_59=='r') ) {
                            int LA11_69 = input.LA(6);

                            if ( (LA11_69=='t') ) {
                                int LA11_79 = input.LA(7);

                                if ( ((LA11_79>='0' && LA11_79<='9')||(LA11_79>='A' && LA11_79<='Z')||LA11_79=='_'||(LA11_79>='a' && LA11_79<='z')) ) {
                                    alt11=31;
                                }
                                else {
                                    alt11=7;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
                }
                break;
            default:
                alt11=31;}

            }
            break;
        case 'o':
            {
            int LA11_8 = input.LA(2);

            if ( (LA11_8=='p') ) {
                int LA11_38 = input.LA(3);

                if ( (LA11_38=='e') ) {
                    int LA11_50 = input.LA(4);

                    if ( (LA11_50=='r') ) {
                        int LA11_60 = input.LA(5);

                        if ( (LA11_60=='a') ) {
                            int LA11_70 = input.LA(6);

                            if ( (LA11_70=='t') ) {
                                int LA11_80 = input.LA(7);

                                if ( (LA11_80=='i') ) {
                                    int LA11_89 = input.LA(8);

                                    if ( (LA11_89=='o') ) {
                                        int LA11_96 = input.LA(9);

                                        if ( (LA11_96=='n') ) {
                                            int LA11_101 = input.LA(10);

                                            if ( ((LA11_101>='0' && LA11_101<='9')||(LA11_101>='A' && LA11_101<='Z')||LA11_101=='_'||(LA11_101>='a' && LA11_101<='z')) ) {
                                                alt11=31;
                                            }
                                            else {
                                                alt11=9;}
                                        }
                                        else {
                                            alt11=31;}
                                    }
                                    else {
                                        alt11=31;}
                                }
                                else {
                                    alt11=31;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
            }
            else {
                alt11=31;}
            }
            break;
        case 'p':
            {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA11_39 = input.LA(3);

                if ( (LA11_39=='o') ) {
                    int LA11_51 = input.LA(4);

                    if ( (LA11_51=='p') ) {
                        int LA11_61 = input.LA(5);

                        if ( (LA11_61=='e') ) {
                            int LA11_71 = input.LA(6);

                            if ( (LA11_71=='r') ) {
                                int LA11_81 = input.LA(7);

                                if ( (LA11_81=='t') ) {
                                    int LA11_90 = input.LA(8);

                                    if ( (LA11_90=='y') ) {
                                        int LA11_97 = input.LA(9);

                                        if ( ((LA11_97>='0' && LA11_97<='9')||(LA11_97>='A' && LA11_97<='Z')||LA11_97=='_'||(LA11_97>='a' && LA11_97<='z')) ) {
                                            alt11=31;
                                        }
                                        else {
                                            alt11=11;}
                                    }
                                    else {
                                        alt11=31;}
                                }
                                else {
                                    alt11=31;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
                }
                break;
            case 'a':
                {
                int LA11_40 = input.LA(3);

                if ( (LA11_40=='c') ) {
                    int LA11_52 = input.LA(4);

                    if ( (LA11_52=='k') ) {
                        int LA11_62 = input.LA(5);

                        if ( (LA11_62=='a') ) {
                            int LA11_72 = input.LA(6);

                            if ( (LA11_72=='g') ) {
                                int LA11_82 = input.LA(7);

                                if ( (LA11_82=='e') ) {
                                    int LA11_91 = input.LA(8);

                                    if ( ((LA11_91>='0' && LA11_91<='9')||(LA11_91>='A' && LA11_91<='Z')||LA11_91=='_'||(LA11_91>='a' && LA11_91<='z')) ) {
                                        alt11=31;
                                    }
                                    else {
                                        alt11=10;}
                                }
                                else {
                                    alt11=31;}
                            }
                            else {
                                alt11=31;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
                }
                break;
            default:
                alt11=31;}

            }
            break;
        case 's':
            {
            int LA11_10 = input.LA(2);

            if ( (LA11_10=='u') ) {
                int LA11_41 = input.LA(3);

                if ( (LA11_41=='p') ) {
                    int LA11_53 = input.LA(4);

                    if ( (LA11_53=='e') ) {
                        int LA11_63 = input.LA(5);

                        if ( (LA11_63=='r') ) {
                            int LA11_73 = input.LA(6);

                            if ( ((LA11_73>='0' && LA11_73<='9')||(LA11_73>='A' && LA11_73<='Z')||LA11_73=='_'||(LA11_73>='a' && LA11_73<='z')) ) {
                                alt11=31;
                            }
                            else {
                                alt11=12;}
                        }
                        else {
                            alt11=31;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
            }
            else {
                alt11=31;}
            }
            break;
        case 't':
            {
            int LA11_11 = input.LA(2);

            if ( (LA11_11=='y') ) {
                int LA11_42 = input.LA(3);

                if ( (LA11_42=='p') ) {
                    int LA11_54 = input.LA(4);

                    if ( (LA11_54=='e') ) {
                        int LA11_64 = input.LA(5);

                        if ( ((LA11_64>='0' && LA11_64<='9')||(LA11_64>='A' && LA11_64<='Z')||LA11_64=='_'||(LA11_64>='a' && LA11_64<='z')) ) {
                            alt11=31;
                        }
                        else {
                            alt11=13;}
                    }
                    else {
                        alt11=31;}
                }
                else {
                    alt11=31;}
            }
            else {
                alt11=31;}
            }
            break;
        case ':':
            {
            int LA11_12 = input.LA(2);

            if ( (LA11_12==':') ) {
                alt11=27;
            }
            else {
                alt11=14;}
            }
            break;
        case '<':
            {
            alt11=15;
            }
            break;
        case ',':
            {
            alt11=16;
            }
            break;
        case '>':
            {
            alt11=17;
            }
            break;
        case '(':
            {
            alt11=18;
            }
            break;
        case ')':
            {
            alt11=19;
            }
            break;
        case '=':
            {
            alt11=20;
            }
            break;
        case ';':
            {
            alt11=21;
            }
            break;
        case '[':
            {
            alt11=22;
            }
            break;
        case '.':
            {
            alt11=23;
            }
            break;
        case '+':
            {
            alt11=24;
            }
            break;
        case '?':
            {
            alt11=25;
            }
            break;
        case ']':
            {
            alt11=26;
            }
            break;
        case '&':
            {
            alt11=28;
            }
            break;
        case '\"':
            {
            alt11=29;
            }
            break;
        case '\'':
            {
            alt11=30;
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
            alt11=31;
            }
            break;
        case '/':
            {
            alt11=32;
            }
            break;
        case '-':
            {
            alt11=33;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt11=34;
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
            alt11=35;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_INT );", 11, 0, input);

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
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:122: RULE_DOUBLE_QUOTED_STRING
                {
                mRULE_DOUBLE_QUOTED_STRING(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:148: RULE_SINGLE_QUOTED_STRING
                {
                mRULE_SINGLE_QUOTED_STRING(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:174: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:182: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:198: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:214: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1:222: RULE_INT
                {
                mRULE_INT(); 

                }
                break;

        }

    }


 

}