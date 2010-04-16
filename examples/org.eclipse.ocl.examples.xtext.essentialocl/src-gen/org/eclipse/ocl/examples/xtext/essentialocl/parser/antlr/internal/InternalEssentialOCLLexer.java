package org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEssentialOCLLexer extends Lexer {
    public static final int T14=14;
    public static final int RULE_ID_TERMINAL=5;
    public static final int T29=29;
    public static final int T36=36;
    public static final int T58=58;
    public static final int T35=35;
    public static final int T61=61;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T64=64;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=4;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T51=51;
    public static final int T46=46;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T62=62;
    public static final int T44=44;
    public static final int T55=55;
    public static final int RULE_ML_COMMENT=7;
    public static final int T33=33;
    public static final int T11=11;
    public static final int T22=22;
    public static final int T50=50;
    public static final int RULE_STRING_LITERAL=6;
    public static final int T43=43;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T66=66;
    public static final int T40=40;
    public static final int T63=63;
    public static final int T57=57;
    public static final int T13=13;
    public static final int T65=65;
    public static final int T56=56;
    public static final int T59=59;
    public static final int RULE_WS=9;
    public static final int T48=48;
    public static final int T15=15;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=67;
    public static final int T53=53;
    public static final int T60=60;
    public static final int RULE_ANY_OTHER=10;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalEssentialOCLLexer() {;} 
    public InternalEssentialOCLLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:10:5: ( '.' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:10:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:11:5: ( 'e' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:11:7: 'e'
            {
            match('e'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:12:5: ( 'E' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:12:7: 'E'
            {
            match('E'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:13:5: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:13:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:14:5: ( '-' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:14:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:15:5: ( 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:15:7: 'Tuple'
            {
            match("Tuple"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:16:5: ( 'self' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:16:7: 'self'
            {
            match("self"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:17:5: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:17:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:18:5: ( 'Boolean' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:18:7: 'Boolean'
            {
            match("Boolean"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:19:5: ( 'Integer' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:19:7: 'Integer'
            {
            match("Integer"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:20:5: ( 'Real' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:20:7: 'Real'
            {
            match("Real"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:21:5: ( 'String' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:21:7: 'String'
            {
            match("String"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:22:5: ( 'UnlimitedNatural' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:22:7: 'UnlimitedNatural'
            {
            match("UnlimitedNatural"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:23:5: ( 'OclAny' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:23:7: 'OclAny'
            {
            match("OclAny"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:24:5: ( 'OclInvalid' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:24:7: 'OclInvalid'
            {
            match("OclInvalid"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:25:5: ( 'OclVoid' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:25:7: 'OclVoid'
            {
            match("OclVoid"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:26:5: ( 'Set' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:26:7: 'Set'
            {
            match("Set"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:27:5: ( 'Bag' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:27:7: 'Bag'
            {
            match("Bag"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:28:5: ( 'Sequence' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:28:7: 'Sequence'
            {
            match("Sequence"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:29:5: ( 'Collection' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:29:7: 'Collection'
            {
            match("Collection"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:30:5: ( 'OrderedSet' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:30:7: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:31:5: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:31:7: '('
            {
            match('('); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:32:5: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:32:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:33:5: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:33:7: ','
            {
            match(','); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:34:5: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:34:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:35:5: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:35:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:36:5: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:36:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:37:5: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:37:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:38:5: ( '=' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:38:7: '='
            {
            match('='); 

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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:39:5: ( 'true' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:39:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:40:5: ( 'false' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:40:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:41:5: ( '*' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:41:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:42:5: ( 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:42:7: 'invalid'
            {
            match("invalid"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:43:5: ( 'null' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:43:7: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:44:5: ( 'implies' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:44:7: 'implies'
            {
            match("implies"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:45:5: ( 'xor' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:45:7: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:46:5: ( 'or' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:46:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:47:5: ( 'and' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:47:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:48:5: ( '<>' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:48:7: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:49:5: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:49:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:50:5: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:50:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:51:5: ( '>=' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:51:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:52:5: ( '<=' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:52:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:53:5: ( '/' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:53:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:54:5: ( 'not' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:54:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:55:5: ( '->' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:55:7: '->'
            {
            match("->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start T57
    public final void mT57() throws RecognitionException {
        try {
            int _type = T57;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:56:5: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:56:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T57

    // $ANTLR start T58
    public final void mT58() throws RecognitionException {
        try {
            int _type = T58;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:57:5: ( '|' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:57:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T58

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:58:5: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:58:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:59:5: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:59:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:60:5: ( 'if' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:60:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:61:5: ( 'then' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:61:7: 'then'
            {
            match("then"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:62:5: ( 'else' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:62:7: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:63:5: ( 'endif' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:63:7: 'endif'
            {
            match("endif"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start T65
    public final void mT65() throws RecognitionException {
        try {
            int _type = T65;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:64:5: ( 'let' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:64:7: 'let'
            {
            match("let"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start T66
    public final void mT66() throws RecognitionException {
        try {
            int _type = T66;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:65:5: ( 'in' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:65:7: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start RULE_STRING_LITERAL
    public final void mRULE_STRING_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_STRING_LITERAL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4568:21: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4568:23: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4568:28: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFE')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4568:29: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4568:70: ~ ( ( '\\\\' | '\\'' ) )
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
            	    break loop1;
                }
            } while (true);

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING_LITERAL

    // $ANTLR start RULE_ID_TERMINAL
    public final void mRULE_ID_TERMINAL() throws RecognitionException {
        try {
            int _type = RULE_ID_TERMINAL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:18: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='_') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\'') ) {
                    alt3=2;
                }
                else {
                    alt3=1;}
            }
            else if ( ((LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                alt3=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4570:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:21: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:45: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:
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
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:79: '_' RULE_STRING_LITERAL
                    {
                    match('_'); 
                    mRULE_STRING_LITERAL(); 

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

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4572:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4572:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4572:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4572:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4574:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4574:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4574:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4574:52: .
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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:40: ( ( '\\r' )? '\\n' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\n'||LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:41: ( '\\r' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:41: '\\r'
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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4578:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4578:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4578:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:
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

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4580:16: ( . )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4580:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | RULE_STRING_LITERAL | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt10=63;
        int LA10_0 = input.LA(1);

        if ( (LA10_0=='.') ) {
            int LA10_1 = input.LA(2);

            if ( (LA10_1=='.') ) {
                alt10=28;
            }
            else {
                alt10=1;}
        }
        else if ( (LA10_0=='e') ) {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA10_46 = input.LA(3);

                if ( (LA10_46=='d') ) {
                    int LA10_102 = input.LA(4);

                    if ( (LA10_102=='i') ) {
                        int LA10_130 = input.LA(5);

                        if ( (LA10_130=='f') ) {
                            int LA10_157 = input.LA(6);

                            if ( ((LA10_157>='0' && LA10_157<='9')||(LA10_157>='A' && LA10_157<='Z')||LA10_157=='_'||(LA10_157>='a' && LA10_157<='z')) ) {
                                alt10=58;
                            }
                            else {
                                alt10=54;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            case 'l':
                {
                int LA10_47 = input.LA(3);

                if ( (LA10_47=='s') ) {
                    int LA10_103 = input.LA(4);

                    if ( (LA10_103=='e') ) {
                        int LA10_131 = input.LA(5);

                        if ( ((LA10_131>='0' && LA10_131<='9')||(LA10_131>='A' && LA10_131<='Z')||LA10_131=='_'||(LA10_131>='a' && LA10_131<='z')) ) {
                            alt10=58;
                        }
                        else {
                            alt10=53;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
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
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'm':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt10=58;
                }
                break;
            default:
                alt10=2;}

        }
        else if ( (LA10_0=='E') ) {
            int LA10_3 = input.LA(2);

            if ( ((LA10_3>='0' && LA10_3<='9')||(LA10_3>='A' && LA10_3<='Z')||LA10_3=='_'||(LA10_3>='a' && LA10_3<='z')) ) {
                alt10=58;
            }
            else {
                alt10=3;}
        }
        else if ( (LA10_0=='+') ) {
            alt10=4;
        }
        else if ( (LA10_0=='-') ) {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt10=46;
                }
                break;
            case '-':
                {
                alt10=61;
                }
                break;
            default:
                alt10=5;}

        }
        else if ( (LA10_0=='T') ) {
            int LA10_6 = input.LA(2);

            if ( (LA10_6=='u') ) {
                int LA10_55 = input.LA(3);

                if ( (LA10_55=='p') ) {
                    int LA10_104 = input.LA(4);

                    if ( (LA10_104=='l') ) {
                        int LA10_132 = input.LA(5);

                        if ( (LA10_132=='e') ) {
                            int LA10_159 = input.LA(6);

                            if ( ((LA10_159>='0' && LA10_159<='9')||(LA10_159>='A' && LA10_159<='Z')||LA10_159=='_'||(LA10_159>='a' && LA10_159<='z')) ) {
                                alt10=58;
                            }
                            else {
                                alt10=6;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='s') ) {
            int LA10_7 = input.LA(2);

            if ( (LA10_7=='e') ) {
                int LA10_56 = input.LA(3);

                if ( (LA10_56=='l') ) {
                    int LA10_105 = input.LA(4);

                    if ( (LA10_105=='f') ) {
                        int LA10_133 = input.LA(5);

                        if ( ((LA10_133>='0' && LA10_133<='9')||(LA10_133>='A' && LA10_133<='Z')||LA10_133=='_'||(LA10_133>='a' && LA10_133<='z')) ) {
                            alt10=58;
                        }
                        else {
                            alt10=7;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0==':') ) {
            int LA10_8 = input.LA(2);

            if ( (LA10_8==':') ) {
                alt10=8;
            }
            else {
                alt10=25;}
        }
        else if ( (LA10_0=='B') ) {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA10_59 = input.LA(3);

                if ( (LA10_59=='g') ) {
                    int LA10_106 = input.LA(4);

                    if ( ((LA10_106>='0' && LA10_106<='9')||(LA10_106>='A' && LA10_106<='Z')||LA10_106=='_'||(LA10_106>='a' && LA10_106<='z')) ) {
                        alt10=58;
                    }
                    else {
                        alt10=18;}
                }
                else {
                    alt10=58;}
                }
                break;
            case 'o':
                {
                int LA10_60 = input.LA(3);

                if ( (LA10_60=='o') ) {
                    int LA10_107 = input.LA(4);

                    if ( (LA10_107=='l') ) {
                        int LA10_135 = input.LA(5);

                        if ( (LA10_135=='e') ) {
                            int LA10_161 = input.LA(6);

                            if ( (LA10_161=='a') ) {
                                int LA10_180 = input.LA(7);

                                if ( (LA10_180=='n') ) {
                                    int LA10_193 = input.LA(8);

                                    if ( ((LA10_193>='0' && LA10_193<='9')||(LA10_193>='A' && LA10_193<='Z')||LA10_193=='_'||(LA10_193>='a' && LA10_193<='z')) ) {
                                        alt10=58;
                                    }
                                    else {
                                        alt10=9;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            default:
                alt10=58;}

        }
        else if ( (LA10_0=='I') ) {
            int LA10_10 = input.LA(2);

            if ( (LA10_10=='n') ) {
                int LA10_61 = input.LA(3);

                if ( (LA10_61=='t') ) {
                    int LA10_108 = input.LA(4);

                    if ( (LA10_108=='e') ) {
                        int LA10_136 = input.LA(5);

                        if ( (LA10_136=='g') ) {
                            int LA10_162 = input.LA(6);

                            if ( (LA10_162=='e') ) {
                                int LA10_181 = input.LA(7);

                                if ( (LA10_181=='r') ) {
                                    int LA10_194 = input.LA(8);

                                    if ( ((LA10_194>='0' && LA10_194<='9')||(LA10_194>='A' && LA10_194<='Z')||LA10_194=='_'||(LA10_194>='a' && LA10_194<='z')) ) {
                                        alt10=58;
                                    }
                                    else {
                                        alt10=10;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='R') ) {
            int LA10_11 = input.LA(2);

            if ( (LA10_11=='e') ) {
                int LA10_62 = input.LA(3);

                if ( (LA10_62=='a') ) {
                    int LA10_109 = input.LA(4);

                    if ( (LA10_109=='l') ) {
                        int LA10_137 = input.LA(5);

                        if ( ((LA10_137>='0' && LA10_137<='9')||(LA10_137>='A' && LA10_137<='Z')||LA10_137=='_'||(LA10_137>='a' && LA10_137<='z')) ) {
                            alt10=58;
                        }
                        else {
                            alt10=11;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='S') ) {
            switch ( input.LA(2) ) {
            case 'e':
                {
                switch ( input.LA(3) ) {
                case 'q':
                    {
                    int LA10_110 = input.LA(4);

                    if ( (LA10_110=='u') ) {
                        int LA10_138 = input.LA(5);

                        if ( (LA10_138=='e') ) {
                            int LA10_164 = input.LA(6);

                            if ( (LA10_164=='n') ) {
                                int LA10_182 = input.LA(7);

                                if ( (LA10_182=='c') ) {
                                    int LA10_195 = input.LA(8);

                                    if ( (LA10_195=='e') ) {
                                        int LA10_207 = input.LA(9);

                                        if ( ((LA10_207>='0' && LA10_207<='9')||(LA10_207>='A' && LA10_207<='Z')||LA10_207=='_'||(LA10_207>='a' && LA10_207<='z')) ) {
                                            alt10=58;
                                        }
                                        else {
                                            alt10=19;}
                                    }
                                    else {
                                        alt10=58;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                    }
                    break;
                case 't':
                    {
                    int LA10_111 = input.LA(4);

                    if ( ((LA10_111>='0' && LA10_111<='9')||(LA10_111>='A' && LA10_111<='Z')||LA10_111=='_'||(LA10_111>='a' && LA10_111<='z')) ) {
                        alt10=58;
                    }
                    else {
                        alt10=17;}
                    }
                    break;
                default:
                    alt10=58;}

                }
                break;
            case 't':
                {
                int LA10_64 = input.LA(3);

                if ( (LA10_64=='r') ) {
                    int LA10_112 = input.LA(4);

                    if ( (LA10_112=='i') ) {
                        int LA10_140 = input.LA(5);

                        if ( (LA10_140=='n') ) {
                            int LA10_165 = input.LA(6);

                            if ( (LA10_165=='g') ) {
                                int LA10_183 = input.LA(7);

                                if ( ((LA10_183>='0' && LA10_183<='9')||(LA10_183>='A' && LA10_183<='Z')||LA10_183=='_'||(LA10_183>='a' && LA10_183<='z')) ) {
                                    alt10=58;
                                }
                                else {
                                    alt10=12;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            default:
                alt10=58;}

        }
        else if ( (LA10_0=='U') ) {
            int LA10_13 = input.LA(2);

            if ( (LA10_13=='n') ) {
                int LA10_65 = input.LA(3);

                if ( (LA10_65=='l') ) {
                    int LA10_113 = input.LA(4);

                    if ( (LA10_113=='i') ) {
                        int LA10_141 = input.LA(5);

                        if ( (LA10_141=='m') ) {
                            int LA10_166 = input.LA(6);

                            if ( (LA10_166=='i') ) {
                                int LA10_184 = input.LA(7);

                                if ( (LA10_184=='t') ) {
                                    int LA10_197 = input.LA(8);

                                    if ( (LA10_197=='e') ) {
                                        int LA10_208 = input.LA(9);

                                        if ( (LA10_208=='d') ) {
                                            int LA10_216 = input.LA(10);

                                            if ( (LA10_216=='N') ) {
                                                int LA10_220 = input.LA(11);

                                                if ( (LA10_220=='a') ) {
                                                    int LA10_224 = input.LA(12);

                                                    if ( (LA10_224=='t') ) {
                                                        int LA10_228 = input.LA(13);

                                                        if ( (LA10_228=='u') ) {
                                                            int LA10_229 = input.LA(14);

                                                            if ( (LA10_229=='r') ) {
                                                                int LA10_230 = input.LA(15);

                                                                if ( (LA10_230=='a') ) {
                                                                    int LA10_231 = input.LA(16);

                                                                    if ( (LA10_231=='l') ) {
                                                                        int LA10_232 = input.LA(17);

                                                                        if ( ((LA10_232>='0' && LA10_232<='9')||(LA10_232>='A' && LA10_232<='Z')||LA10_232=='_'||(LA10_232>='a' && LA10_232<='z')) ) {
                                                                            alt10=58;
                                                                        }
                                                                        else {
                                                                            alt10=13;}
                                                                    }
                                                                    else {
                                                                        alt10=58;}
                                                                }
                                                                else {
                                                                    alt10=58;}
                                                            }
                                                            else {
                                                                alt10=58;}
                                                        }
                                                        else {
                                                            alt10=58;}
                                                    }
                                                    else {
                                                        alt10=58;}
                                                }
                                                else {
                                                    alt10=58;}
                                            }
                                            else {
                                                alt10=58;}
                                        }
                                        else {
                                            alt10=58;}
                                    }
                                    else {
                                        alt10=58;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='O') ) {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA10_66 = input.LA(3);

                if ( (LA10_66=='d') ) {
                    int LA10_114 = input.LA(4);

                    if ( (LA10_114=='e') ) {
                        int LA10_142 = input.LA(5);

                        if ( (LA10_142=='r') ) {
                            int LA10_167 = input.LA(6);

                            if ( (LA10_167=='e') ) {
                                int LA10_185 = input.LA(7);

                                if ( (LA10_185=='d') ) {
                                    int LA10_198 = input.LA(8);

                                    if ( (LA10_198=='S') ) {
                                        int LA10_209 = input.LA(9);

                                        if ( (LA10_209=='e') ) {
                                            int LA10_217 = input.LA(10);

                                            if ( (LA10_217=='t') ) {
                                                int LA10_221 = input.LA(11);

                                                if ( ((LA10_221>='0' && LA10_221<='9')||(LA10_221>='A' && LA10_221<='Z')||LA10_221=='_'||(LA10_221>='a' && LA10_221<='z')) ) {
                                                    alt10=58;
                                                }
                                                else {
                                                    alt10=21;}
                                            }
                                            else {
                                                alt10=58;}
                                        }
                                        else {
                                            alt10=58;}
                                    }
                                    else {
                                        alt10=58;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            case 'c':
                {
                int LA10_67 = input.LA(3);

                if ( (LA10_67=='l') ) {
                    switch ( input.LA(4) ) {
                    case 'V':
                        {
                        int LA10_143 = input.LA(5);

                        if ( (LA10_143=='o') ) {
                            int LA10_168 = input.LA(6);

                            if ( (LA10_168=='i') ) {
                                int LA10_186 = input.LA(7);

                                if ( (LA10_186=='d') ) {
                                    int LA10_199 = input.LA(8);

                                    if ( ((LA10_199>='0' && LA10_199<='9')||(LA10_199>='A' && LA10_199<='Z')||LA10_199=='_'||(LA10_199>='a' && LA10_199<='z')) ) {
                                        alt10=58;
                                    }
                                    else {
                                        alt10=16;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                        }
                        break;
                    case 'I':
                        {
                        int LA10_144 = input.LA(5);

                        if ( (LA10_144=='n') ) {
                            int LA10_169 = input.LA(6);

                            if ( (LA10_169=='v') ) {
                                int LA10_187 = input.LA(7);

                                if ( (LA10_187=='a') ) {
                                    int LA10_200 = input.LA(8);

                                    if ( (LA10_200=='l') ) {
                                        int LA10_211 = input.LA(9);

                                        if ( (LA10_211=='i') ) {
                                            int LA10_218 = input.LA(10);

                                            if ( (LA10_218=='d') ) {
                                                int LA10_222 = input.LA(11);

                                                if ( ((LA10_222>='0' && LA10_222<='9')||(LA10_222>='A' && LA10_222<='Z')||LA10_222=='_'||(LA10_222>='a' && LA10_222<='z')) ) {
                                                    alt10=58;
                                                }
                                                else {
                                                    alt10=15;}
                                            }
                                            else {
                                                alt10=58;}
                                        }
                                        else {
                                            alt10=58;}
                                    }
                                    else {
                                        alt10=58;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                        }
                        break;
                    case 'A':
                        {
                        int LA10_145 = input.LA(5);

                        if ( (LA10_145=='n') ) {
                            int LA10_170 = input.LA(6);

                            if ( (LA10_170=='y') ) {
                                int LA10_188 = input.LA(7);

                                if ( ((LA10_188>='0' && LA10_188<='9')||(LA10_188>='A' && LA10_188<='Z')||LA10_188=='_'||(LA10_188>='a' && LA10_188<='z')) ) {
                                    alt10=58;
                                }
                                else {
                                    alt10=14;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                        }
                        break;
                    default:
                        alt10=58;}

                }
                else {
                    alt10=58;}
                }
                break;
            default:
                alt10=58;}

        }
        else if ( (LA10_0=='C') ) {
            int LA10_15 = input.LA(2);

            if ( (LA10_15=='o') ) {
                int LA10_68 = input.LA(3);

                if ( (LA10_68=='l') ) {
                    int LA10_116 = input.LA(4);

                    if ( (LA10_116=='l') ) {
                        int LA10_146 = input.LA(5);

                        if ( (LA10_146=='e') ) {
                            int LA10_171 = input.LA(6);

                            if ( (LA10_171=='c') ) {
                                int LA10_189 = input.LA(7);

                                if ( (LA10_189=='t') ) {
                                    int LA10_202 = input.LA(8);

                                    if ( (LA10_202=='i') ) {
                                        int LA10_212 = input.LA(9);

                                        if ( (LA10_212=='o') ) {
                                            int LA10_219 = input.LA(10);

                                            if ( (LA10_219=='n') ) {
                                                int LA10_223 = input.LA(11);

                                                if ( ((LA10_223>='0' && LA10_223<='9')||(LA10_223>='A' && LA10_223<='Z')||LA10_223=='_'||(LA10_223>='a' && LA10_223<='z')) ) {
                                                    alt10=58;
                                                }
                                                else {
                                                    alt10=20;}
                                            }
                                            else {
                                                alt10=58;}
                                        }
                                        else {
                                            alt10=58;}
                                    }
                                    else {
                                        alt10=58;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='(') ) {
            alt10=22;
        }
        else if ( (LA10_0==')') ) {
            alt10=23;
        }
        else if ( (LA10_0==',') ) {
            alt10=24;
        }
        else if ( (LA10_0=='{') ) {
            alt10=26;
        }
        else if ( (LA10_0=='}') ) {
            alt10=27;
        }
        else if ( (LA10_0=='=') ) {
            alt10=29;
        }
        else if ( (LA10_0=='t') ) {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA10_75 = input.LA(3);

                if ( (LA10_75=='u') ) {
                    int LA10_117 = input.LA(4);

                    if ( (LA10_117=='e') ) {
                        int LA10_147 = input.LA(5);

                        if ( ((LA10_147>='0' && LA10_147<='9')||(LA10_147>='A' && LA10_147<='Z')||LA10_147=='_'||(LA10_147>='a' && LA10_147<='z')) ) {
                            alt10=58;
                        }
                        else {
                            alt10=30;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            case 'h':
                {
                int LA10_76 = input.LA(3);

                if ( (LA10_76=='e') ) {
                    int LA10_118 = input.LA(4);

                    if ( (LA10_118=='n') ) {
                        int LA10_148 = input.LA(5);

                        if ( ((LA10_148>='0' && LA10_148<='9')||(LA10_148>='A' && LA10_148<='Z')||LA10_148=='_'||(LA10_148>='a' && LA10_148<='z')) ) {
                            alt10=58;
                        }
                        else {
                            alt10=52;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            default:
                alt10=58;}

        }
        else if ( (LA10_0=='f') ) {
            int LA10_23 = input.LA(2);

            if ( (LA10_23=='a') ) {
                int LA10_77 = input.LA(3);

                if ( (LA10_77=='l') ) {
                    int LA10_119 = input.LA(4);

                    if ( (LA10_119=='s') ) {
                        int LA10_149 = input.LA(5);

                        if ( (LA10_149=='e') ) {
                            int LA10_174 = input.LA(6);

                            if ( ((LA10_174>='0' && LA10_174<='9')||(LA10_174>='A' && LA10_174<='Z')||LA10_174=='_'||(LA10_174>='a' && LA10_174<='z')) ) {
                                alt10=58;
                            }
                            else {
                                alt10=31;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='*') ) {
            alt10=32;
        }
        else if ( (LA10_0=='i') ) {
            switch ( input.LA(2) ) {
            case 'n':
                {
                switch ( input.LA(3) ) {
                case 'v':
                    {
                    int LA10_120 = input.LA(4);

                    if ( (LA10_120=='a') ) {
                        int LA10_150 = input.LA(5);

                        if ( (LA10_150=='l') ) {
                            int LA10_175 = input.LA(6);

                            if ( (LA10_175=='i') ) {
                                int LA10_191 = input.LA(7);

                                if ( (LA10_191=='d') ) {
                                    int LA10_203 = input.LA(8);

                                    if ( ((LA10_203>='0' && LA10_203<='9')||(LA10_203>='A' && LA10_203<='Z')||LA10_203=='_'||(LA10_203>='a' && LA10_203<='z')) ) {
                                        alt10=58;
                                    }
                                    else {
                                        alt10=33;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
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
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt10=58;
                    }
                    break;
                default:
                    alt10=56;}

                }
                break;
            case 'm':
                {
                int LA10_80 = input.LA(3);

                if ( (LA10_80=='p') ) {
                    int LA10_122 = input.LA(4);

                    if ( (LA10_122=='l') ) {
                        int LA10_151 = input.LA(5);

                        if ( (LA10_151=='i') ) {
                            int LA10_176 = input.LA(6);

                            if ( (LA10_176=='e') ) {
                                int LA10_192 = input.LA(7);

                                if ( (LA10_192=='s') ) {
                                    int LA10_204 = input.LA(8);

                                    if ( ((LA10_204>='0' && LA10_204<='9')||(LA10_204>='A' && LA10_204<='Z')||LA10_204=='_'||(LA10_204>='a' && LA10_204<='z')) ) {
                                        alt10=58;
                                    }
                                    else {
                                        alt10=35;}
                                }
                                else {
                                    alt10=58;}
                            }
                            else {
                                alt10=58;}
                        }
                        else {
                            alt10=58;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            case 'f':
                {
                int LA10_81 = input.LA(3);

                if ( ((LA10_81>='0' && LA10_81<='9')||(LA10_81>='A' && LA10_81<='Z')||LA10_81=='_'||(LA10_81>='a' && LA10_81<='z')) ) {
                    alt10=58;
                }
                else {
                    alt10=51;}
                }
                break;
            default:
                alt10=58;}

        }
        else if ( (LA10_0=='n') ) {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA10_82 = input.LA(3);

                if ( (LA10_82=='t') ) {
                    int LA10_124 = input.LA(4);

                    if ( ((LA10_124>='0' && LA10_124<='9')||(LA10_124>='A' && LA10_124<='Z')||LA10_124=='_'||(LA10_124>='a' && LA10_124<='z')) ) {
                        alt10=58;
                    }
                    else {
                        alt10=45;}
                }
                else {
                    alt10=58;}
                }
                break;
            case 'u':
                {
                int LA10_83 = input.LA(3);

                if ( (LA10_83=='l') ) {
                    int LA10_125 = input.LA(4);

                    if ( (LA10_125=='l') ) {
                        int LA10_153 = input.LA(5);

                        if ( ((LA10_153>='0' && LA10_153<='9')||(LA10_153>='A' && LA10_153<='Z')||LA10_153=='_'||(LA10_153>='a' && LA10_153<='z')) ) {
                            alt10=58;
                        }
                        else {
                            alt10=34;}
                    }
                    else {
                        alt10=58;}
                }
                else {
                    alt10=58;}
                }
                break;
            default:
                alt10=58;}

        }
        else if ( (LA10_0=='x') ) {
            int LA10_27 = input.LA(2);

            if ( (LA10_27=='o') ) {
                int LA10_84 = input.LA(3);

                if ( (LA10_84=='r') ) {
                    int LA10_126 = input.LA(4);

                    if ( ((LA10_126>='0' && LA10_126<='9')||(LA10_126>='A' && LA10_126<='Z')||LA10_126=='_'||(LA10_126>='a' && LA10_126<='z')) ) {
                        alt10=58;
                    }
                    else {
                        alt10=36;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='o') ) {
            int LA10_28 = input.LA(2);

            if ( (LA10_28=='r') ) {
                int LA10_85 = input.LA(3);

                if ( ((LA10_85>='0' && LA10_85<='9')||(LA10_85>='A' && LA10_85<='Z')||LA10_85=='_'||(LA10_85>='a' && LA10_85<='z')) ) {
                    alt10=58;
                }
                else {
                    alt10=37;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='a') ) {
            int LA10_29 = input.LA(2);

            if ( (LA10_29=='n') ) {
                int LA10_86 = input.LA(3);

                if ( (LA10_86=='d') ) {
                    int LA10_128 = input.LA(4);

                    if ( ((LA10_128>='0' && LA10_128<='9')||(LA10_128>='A' && LA10_128<='Z')||LA10_128=='_'||(LA10_128>='a' && LA10_128<='z')) ) {
                        alt10=58;
                    }
                    else {
                        alt10=38;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='<') ) {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt10=39;
                }
                break;
            case '=':
                {
                alt10=43;
                }
                break;
            default:
                alt10=41;}

        }
        else if ( (LA10_0=='>') ) {
            int LA10_31 = input.LA(2);

            if ( (LA10_31=='=') ) {
                alt10=42;
            }
            else {
                alt10=40;}
        }
        else if ( (LA10_0=='/') ) {
            int LA10_32 = input.LA(2);

            if ( (LA10_32=='*') ) {
                alt10=60;
            }
            else {
                alt10=44;}
        }
        else if ( (LA10_0==';') ) {
            alt10=47;
        }
        else if ( (LA10_0=='|') ) {
            alt10=48;
        }
        else if ( (LA10_0=='[') ) {
            alt10=49;
        }
        else if ( (LA10_0==']') ) {
            alt10=50;
        }
        else if ( (LA10_0=='l') ) {
            int LA10_37 = input.LA(2);

            if ( (LA10_37=='e') ) {
                int LA10_98 = input.LA(3);

                if ( (LA10_98=='t') ) {
                    int LA10_129 = input.LA(4);

                    if ( ((LA10_129>='0' && LA10_129<='9')||(LA10_129>='A' && LA10_129<='Z')||LA10_129=='_'||(LA10_129>='a' && LA10_129<='z')) ) {
                        alt10=58;
                    }
                    else {
                        alt10=55;}
                }
                else {
                    alt10=58;}
            }
            else {
                alt10=58;}
        }
        else if ( (LA10_0=='\'') ) {
            int LA10_38 = input.LA(2);

            if ( ((LA10_38>='\u0000' && LA10_38<='\uFFFE')) ) {
                alt10=57;
            }
            else {
                alt10=63;}
        }
        else if ( (LA10_0=='_') ) {
            alt10=58;
        }
        else if ( (LA10_0=='A'||LA10_0=='D'||(LA10_0>='F' && LA10_0<='H')||(LA10_0>='J' && LA10_0<='N')||(LA10_0>='P' && LA10_0<='Q')||(LA10_0>='V' && LA10_0<='Z')||(LA10_0>='b' && LA10_0<='d')||(LA10_0>='g' && LA10_0<='h')||(LA10_0>='j' && LA10_0<='k')||LA10_0=='m'||(LA10_0>='p' && LA10_0<='r')||(LA10_0>='u' && LA10_0<='w')||(LA10_0>='y' && LA10_0<='z')) ) {
            alt10=58;
        }
        else if ( ((LA10_0>='0' && LA10_0<='9')) ) {
            alt10=59;
        }
        else if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
            alt10=62;
        }
        else if ( ((LA10_0>='\u0000' && LA10_0<='\b')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\u001F')||(LA10_0>='!' && LA10_0<='&')||(LA10_0>='?' && LA10_0<='@')||LA10_0=='\\'||LA10_0=='^'||LA10_0=='`'||(LA10_0>='~' && LA10_0<='\uFFFE')) ) {
            alt10=63;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | RULE_STRING_LITERAL | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 10, 0, input);

            throw nvae;
        }
        switch (alt10) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:130: T41
                {
                mT41(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:134: T42
                {
                mT42(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:138: T43
                {
                mT43(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:142: T44
                {
                mT44(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:146: T45
                {
                mT45(); 

                }
                break;
            case 36 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:150: T46
                {
                mT46(); 

                }
                break;
            case 37 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:154: T47
                {
                mT47(); 

                }
                break;
            case 38 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:158: T48
                {
                mT48(); 

                }
                break;
            case 39 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:162: T49
                {
                mT49(); 

                }
                break;
            case 40 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:166: T50
                {
                mT50(); 

                }
                break;
            case 41 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:170: T51
                {
                mT51(); 

                }
                break;
            case 42 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:174: T52
                {
                mT52(); 

                }
                break;
            case 43 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:178: T53
                {
                mT53(); 

                }
                break;
            case 44 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:182: T54
                {
                mT54(); 

                }
                break;
            case 45 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:186: T55
                {
                mT55(); 

                }
                break;
            case 46 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:190: T56
                {
                mT56(); 

                }
                break;
            case 47 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:194: T57
                {
                mT57(); 

                }
                break;
            case 48 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:198: T58
                {
                mT58(); 

                }
                break;
            case 49 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:202: T59
                {
                mT59(); 

                }
                break;
            case 50 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:206: T60
                {
                mT60(); 

                }
                break;
            case 51 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:210: T61
                {
                mT61(); 

                }
                break;
            case 52 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:214: T62
                {
                mT62(); 

                }
                break;
            case 53 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:218: T63
                {
                mT63(); 

                }
                break;
            case 54 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:222: T64
                {
                mT64(); 

                }
                break;
            case 55 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:226: T65
                {
                mT65(); 

                }
                break;
            case 56 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:230: T66
                {
                mT66(); 

                }
                break;
            case 57 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:234: RULE_STRING_LITERAL
                {
                mRULE_STRING_LITERAL(); 

                }
                break;
            case 58 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:254: RULE_ID_TERMINAL
                {
                mRULE_ID_TERMINAL(); 

                }
                break;
            case 59 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:271: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 60 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:280: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 61 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:296: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 62 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:312: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 63 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1:320: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}