package org.eclipse.ocl.examples.xtext.completeocl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCompleteOCLLexer extends Lexer {
    public static final int T75=75;
    public static final int T76=76;
    public static final int T73=73;
    public static final int T74=74;
    public static final int T79=79;
    public static final int T77=77;
    public static final int T78=78;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_DOUBLE_QUOTED_STRING=7;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int EOF=-1;
    public static final int T24=24;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T72=72;
    public static final int T21=21;
    public static final int T71=71;
    public static final int T20=20;
    public static final int T70=70;
    public static final int T62=62;
    public static final int T63=63;
    public static final int T64=64;
    public static final int T65=65;
    public static final int T66=66;
    public static final int T67=67;
    public static final int T68=68;
    public static final int T69=69;
    public static final int RULE_INT=5;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T61=61;
    public static final int T32=32;
    public static final int T60=60;
    public static final int T31=31;
    public static final int RULE_ID_TERMINAL=6;
    public static final int RULE_SINGLE_QUOTED_STRING=4;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T43=43;
    public static final int Tokens=83;
    public static final int RULE_SL_COMMENT=9;
    public static final int T42=42;
    public static final int T41=41;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int T45=45;
    public static final int RULE_ML_COMMENT=8;
    public static final int T44=44;
    public static final int T50=50;
    public static final int T59=59;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T81=81;
    public static final int T52=52;
    public static final int T15=15;
    public static final int RULE_WS=10;
    public static final int T80=80;
    public static final int T51=51;
    public static final int T16=16;
    public static final int T54=54;
    public static final int T17=17;
    public static final int T82=82;
    public static final int T53=53;
    public static final int T18=18;
    public static final int T56=56;
    public static final int T19=19;
    public static final int T55=55;
    public static final int T58=58;
    public static final int T57=57;
    public InternalCompleteOCLLexer() {;} 
    public InternalCompleteOCLLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:10:5: ( 'body' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:10:7: 'body'
            {
            match("body"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:11:5: ( 'context' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:11:7: 'context'
            {
            match("context"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:12:5: ( 'def' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:12:7: 'def'
            {
            match("def"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:13:5: ( 'derive' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:13:7: 'derive'
            {
            match("derive"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:14:5: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:14:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:15:5: ( 'init' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:15:7: 'init'
            {
            match("init"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:16:5: ( 'inv' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:16:7: 'inv'
            {
            match("inv"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:17:5: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:17:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:18:5: ( 'static' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:18:7: 'static'
            {
            match("static"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:19:5: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:19:7: '('
            {
            match('('); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:20:5: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:20:7: ','
            {
            match(','); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:21:5: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:21:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:22:5: ( '=' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:22:7: '='
            {
            match('='); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:23:5: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:23:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:24:5: ( 'endpackage' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:24:7: 'endpackage'
            {
            match("endpackage"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:25:5: ( 'post' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:25:7: 'post'
            {
            match("post"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:26:5: ( 'pre' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:26:7: 'pre'
            {
            match("pre"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:27:5: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:27:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:28:5: ( '.' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:28:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:29:5: ( '->' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:29:7: '->'
            {
            match("->"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:30:5: ( '^^' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:30:7: '^^'
            {
            match("^^"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:31:5: ( '^' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:31:7: '^'
            {
            match('^'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:32:5: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:32:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:33:5: ( 'e' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:33:7: 'e'
            {
            match('e'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:34:5: ( 'E' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:34:7: 'E'
            {
            match('E'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:35:5: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:35:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:36:5: ( '-' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:36:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:37:5: ( 'Boolean' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:37:7: 'Boolean'
            {
            match("Boolean"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:38:5: ( 'Integer' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:38:7: 'Integer'
            {
            match("Integer"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:39:5: ( 'Real' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:39:7: 'Real'
            {
            match("Real"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:40:5: ( 'String' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:40:7: 'String'
            {
            match("String"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:41:5: ( 'UnlimitedNatural' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:41:7: 'UnlimitedNatural'
            {
            match("UnlimitedNatural"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:42:5: ( 'OclAny' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:42:7: 'OclAny'
            {
            match("OclAny"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:43:5: ( 'OclInvalid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:43:7: 'OclInvalid'
            {
            match("OclInvalid"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:44:5: ( 'OclVoid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:44:7: 'OclVoid'
            {
            match("OclVoid"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:45:5: ( 'Set' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:45:7: 'Set'
            {
            match("Set"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:46:5: ( 'Bag' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:46:7: 'Bag'
            {
            match("Bag"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:47:5: ( 'Sequence' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:47:7: 'Sequence'
            {
            match("Sequence"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:48:5: ( 'Collection' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:48:7: 'Collection'
            {
            match("Collection"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:49:5: ( 'OrderedSet' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:49:7: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:50:5: ( 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:50:7: 'Tuple'
            {
            match("Tuple"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:51:5: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:51:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:52:5: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:52:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:53:5: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:53:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:54:5: ( 'true' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:54:7: 'true'
            {
            match("true"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:55:5: ( 'false' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:55:7: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:56:5: ( 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:56:7: 'invalid'
            {
            match("invalid"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:57:5: ( 'null' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:57:7: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:58:5: ( 'implies' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:58:7: 'implies'
            {
            match("implies"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:59:5: ( 'xor' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:59:7: 'xor'
            {
            match("xor"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:60:5: ( 'or' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:60:7: 'or'
            {
            match("or"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:61:5: ( 'and' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:61:7: 'and'
            {
            match("and"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:62:5: ( '<>' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:62:7: '<>'
            {
            match("<>"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:63:5: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:63:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:64:5: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:64:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start T67
    public final void mT67() throws RecognitionException {
        try {
            int _type = T67;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:65:5: ( '>=' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:65:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T67

    // $ANTLR start T68
    public final void mT68() throws RecognitionException {
        try {
            int _type = T68;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:66:5: ( '<=' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:66:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T68

    // $ANTLR start T69
    public final void mT69() throws RecognitionException {
        try {
            int _type = T69;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:67:5: ( '*' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:67:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T69

    // $ANTLR start T70
    public final void mT70() throws RecognitionException {
        try {
            int _type = T70;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:68:5: ( '/' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:68:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T70

    // $ANTLR start T71
    public final void mT71() throws RecognitionException {
        try {
            int _type = T71;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:69:5: ( 'not' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:69:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T71

    // $ANTLR start T72
    public final void mT72() throws RecognitionException {
        try {
            int _type = T72;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:70:5: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:70:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T72

    // $ANTLR start T73
    public final void mT73() throws RecognitionException {
        try {
            int _type = T73;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:71:5: ( '|' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:71:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T73

    // $ANTLR start T74
    public final void mT74() throws RecognitionException {
        try {
            int _type = T74;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:72:5: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:72:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T74

    // $ANTLR start T75
    public final void mT75() throws RecognitionException {
        try {
            int _type = T75;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:73:5: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:73:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T75

    // $ANTLR start T76
    public final void mT76() throws RecognitionException {
        try {
            int _type = T76;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:74:5: ( 'self' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:74:7: 'self'
            {
            match("self"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T76

    // $ANTLR start T77
    public final void mT77() throws RecognitionException {
        try {
            int _type = T77;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:75:5: ( 'if' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:75:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T77

    // $ANTLR start T78
    public final void mT78() throws RecognitionException {
        try {
            int _type = T78;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:76:5: ( 'then' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:76:7: 'then'
            {
            match("then"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T78

    // $ANTLR start T79
    public final void mT79() throws RecognitionException {
        try {
            int _type = T79;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:77:5: ( 'else' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:77:7: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T79

    // $ANTLR start T80
    public final void mT80() throws RecognitionException {
        try {
            int _type = T80;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:78:5: ( 'endif' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:78:7: 'endif'
            {
            match("endif"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T80

    // $ANTLR start T81
    public final void mT81() throws RecognitionException {
        try {
            int _type = T81;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:79:5: ( 'let' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:79:7: 'let'
            {
            match("let"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T81

    // $ANTLR start T82
    public final void mT82() throws RecognitionException {
        try {
            int _type = T82;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:80:5: ( 'in' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:80:7: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T82

    // $ANTLR start RULE_DOUBLE_QUOTED_STRING
    public final void mRULE_DOUBLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_QUOTED_STRING;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6968:27: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6968:29: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6968:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6968:34: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6968:75: ~ ( ( '\\\\' | '\"' ) )
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6970:27: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6970:29: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6970:34: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6970:35: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6970:76: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6972:18: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6972:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6972:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
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
                    new NoViableAltException("6972:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6972:21: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6972:45: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6972:79: '_' RULE_SINGLE_QUOTED_STRING
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

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6974:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6974:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6974:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6974:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6976:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6976:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6976:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFE')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6976:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop7;
                }
            } while (true);

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6978:41: '\\r'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6980:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6980:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6980:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:
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
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6982:16: ( . )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6982:18: .
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
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt11=79;
        int LA11_0 = input.LA(1);

        if ( (LA11_0=='b') ) {
            alt11 = mTokensHelper001();
        }
        else if ( (LA11_0=='c') ) {
            alt11 = mTokensHelper002();
        }
        else if ( (LA11_0=='d') ) {
            alt11 = mTokensHelper003();
        }
        else if ( (LA11_0=='i') ) {
            alt11 = mTokensHelper004();
        }
        else if ( (LA11_0==':') ) {
            alt11 = mTokensHelper005();
        }
        else if ( (LA11_0=='s') ) {
            alt11 = mTokensHelper006();
        }
        else if ( (LA11_0=='(') ) {
            alt11 = mTokensHelper007();
        }
        else if ( (LA11_0==',') ) {
            alt11 = mTokensHelper008();
        }
        else if ( (LA11_0==')') ) {
            alt11 = mTokensHelper009();
        }
        else if ( (LA11_0=='=') ) {
            alt11 = mTokensHelper010();
        }
        else if ( (LA11_0=='p') ) {
            alt11 = mTokensHelper011();
        }
        else if ( (LA11_0=='e') ) {
            alt11 = mTokensHelper012();
        }
        else if ( (LA11_0=='.') ) {
            alt11 = mTokensHelper013();
        }
        else if ( (LA11_0=='-') ) {
            alt11 = mTokensHelper014();
        }
        else if ( (LA11_0=='^') ) {
            alt11 = mTokensHelper015();
        }
        else if ( (LA11_0=='?') ) {
            alt11 = mTokensHelper016();
        }
        else if ( (LA11_0=='E') ) {
            alt11 = mTokensHelper017();
        }
        else if ( (LA11_0=='+') ) {
            alt11 = mTokensHelper018();
        }
        else if ( (LA11_0=='B') ) {
            alt11 = mTokensHelper019();
        }
        else if ( (LA11_0=='I') ) {
            alt11 = mTokensHelper020();
        }
        else if ( (LA11_0=='R') ) {
            alt11 = mTokensHelper021();
        }
        else if ( (LA11_0=='S') ) {
            alt11 = mTokensHelper022();
        }
        else if ( (LA11_0=='U') ) {
            alt11 = mTokensHelper023();
        }
        else if ( (LA11_0=='O') ) {
            alt11 = mTokensHelper024();
        }
        else if ( (LA11_0=='C') ) {
            alt11 = mTokensHelper025();
        }
        else if ( (LA11_0=='T') ) {
            alt11 = mTokensHelper026();
        }
        else if ( (LA11_0=='{') ) {
            alt11 = mTokensHelper027();
        }
        else if ( (LA11_0=='}') ) {
            alt11 = mTokensHelper028();
        }
        else if ( (LA11_0=='t') ) {
            alt11 = mTokensHelper029();
        }
        else if ( (LA11_0=='f') ) {
            alt11 = mTokensHelper030();
        }
        else if ( (LA11_0=='n') ) {
            alt11 = mTokensHelper031();
        }
        else if ( (LA11_0=='x') ) {
            alt11 = mTokensHelper032();
        }
        else if ( (LA11_0=='o') ) {
            alt11 = mTokensHelper033();
        }
        else if ( (LA11_0=='a') ) {
            alt11 = mTokensHelper034();
        }
        else if ( (LA11_0=='<') ) {
            alt11 = mTokensHelper035();
        }
        else if ( (LA11_0=='>') ) {
            alt11 = mTokensHelper036();
        }
        else if ( (LA11_0=='*') ) {
            alt11 = mTokensHelper037();
        }
        else if ( (LA11_0=='/') ) {
            alt11 = mTokensHelper038();
        }
        else if ( (LA11_0==';') ) {
            alt11 = mTokensHelper039();
        }
        else if ( (LA11_0=='|') ) {
            alt11 = mTokensHelper040();
        }
        else if ( (LA11_0=='[') ) {
            alt11 = mTokensHelper041();
        }
        else if ( (LA11_0==']') ) {
            alt11 = mTokensHelper042();
        }
        else if ( (LA11_0=='l') ) {
            alt11 = mTokensHelper043();
        }
        else if ( (LA11_0=='\"') ) {
            alt11 = mTokensHelper044();
        }
        else if ( (LA11_0=='\'') ) {
            alt11 = mTokensHelper045();
        }
        else if ( (LA11_0=='_') ) {
            alt11 = mTokensHelper046();
        }
        else if ( (LA11_0=='A'||LA11_0=='D'||(LA11_0>='F' && LA11_0<='H')||(LA11_0>='J' && LA11_0<='N')||(LA11_0>='P' && LA11_0<='Q')||(LA11_0>='V' && LA11_0<='Z')||(LA11_0>='g' && LA11_0<='h')||(LA11_0>='j' && LA11_0<='k')||LA11_0=='m'||(LA11_0>='q' && LA11_0<='r')||(LA11_0>='u' && LA11_0<='w')||(LA11_0>='y' && LA11_0<='z')) ) {
            alt11 = mTokensHelper047();
        }
        else if ( ((LA11_0>='0' && LA11_0<='9')) ) {
            alt11 = mTokensHelper048();
        }
        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
            alt11 = mTokensHelper049();
        }
        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||LA11_0=='!'||(LA11_0>='#' && LA11_0<='&')||LA11_0=='@'||LA11_0=='\\'||LA11_0=='`'||(LA11_0>='~' && LA11_0<='\uFFFE')) ) {
            alt11 = mTokensHelper050();
        }
        else {
            alt11 = mTokensHelper051();
        }
        switch (alt11) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:66: T26
                {
                mT26(); 

                }
                break;
            case 16 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:70: T27
                {
                mT27(); 

                }
                break;
            case 17 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:74: T28
                {
                mT28(); 

                }
                break;
            case 18 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:78: T29
                {
                mT29(); 

                }
                break;
            case 19 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:82: T30
                {
                mT30(); 

                }
                break;
            case 20 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:86: T31
                {
                mT31(); 

                }
                break;
            case 21 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:90: T32
                {
                mT32(); 

                }
                break;
            case 22 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:94: T33
                {
                mT33(); 

                }
                break;
            case 23 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:98: T34
                {
                mT34(); 

                }
                break;
            case 24 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:102: T35
                {
                mT35(); 

                }
                break;
            case 25 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:106: T36
                {
                mT36(); 

                }
                break;
            case 26 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:110: T37
                {
                mT37(); 

                }
                break;
            case 27 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:114: T38
                {
                mT38(); 

                }
                break;
            case 28 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:118: T39
                {
                mT39(); 

                }
                break;
            case 29 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:122: T40
                {
                mT40(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:126: T41
                {
                mT41(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:130: T42
                {
                mT42(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:134: T43
                {
                mT43(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:138: T44
                {
                mT44(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:142: T45
                {
                mT45(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:146: T46
                {
                mT46(); 

                }
                break;
            case 36 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:150: T47
                {
                mT47(); 

                }
                break;
            case 37 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:154: T48
                {
                mT48(); 

                }
                break;
            case 38 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:158: T49
                {
                mT49(); 

                }
                break;
            case 39 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:162: T50
                {
                mT50(); 

                }
                break;
            case 40 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:166: T51
                {
                mT51(); 

                }
                break;
            case 41 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:170: T52
                {
                mT52(); 

                }
                break;
            case 42 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:174: T53
                {
                mT53(); 

                }
                break;
            case 43 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:178: T54
                {
                mT54(); 

                }
                break;
            case 44 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:182: T55
                {
                mT55(); 

                }
                break;
            case 45 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:186: T56
                {
                mT56(); 

                }
                break;
            case 46 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:190: T57
                {
                mT57(); 

                }
                break;
            case 47 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:194: T58
                {
                mT58(); 

                }
                break;
            case 48 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:198: T59
                {
                mT59(); 

                }
                break;
            case 49 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:202: T60
                {
                mT60(); 

                }
                break;
            case 50 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:206: T61
                {
                mT61(); 

                }
                break;
            case 51 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:210: T62
                {
                mT62(); 

                }
                break;
            case 52 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:214: T63
                {
                mT63(); 

                }
                break;
            case 53 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:218: T64
                {
                mT64(); 

                }
                break;
            case 54 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:222: T65
                {
                mT65(); 

                }
                break;
            case 55 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:226: T66
                {
                mT66(); 

                }
                break;
            case 56 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:230: T67
                {
                mT67(); 

                }
                break;
            case 57 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:234: T68
                {
                mT68(); 

                }
                break;
            case 58 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:238: T69
                {
                mT69(); 

                }
                break;
            case 59 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:242: T70
                {
                mT70(); 

                }
                break;
            case 60 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:246: T71
                {
                mT71(); 

                }
                break;
            case 61 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:250: T72
                {
                mT72(); 

                }
                break;
            case 62 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:254: T73
                {
                mT73(); 

                }
                break;
            case 63 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:258: T74
                {
                mT74(); 

                }
                break;
            case 64 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:262: T75
                {
                mT75(); 

                }
                break;
            case 65 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:266: T76
                {
                mT76(); 

                }
                break;
            case 66 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:270: T77
                {
                mT77(); 

                }
                break;
            case 67 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:274: T78
                {
                mT78(); 

                }
                break;
            case 68 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:278: T79
                {
                mT79(); 

                }
                break;
            case 69 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:282: T80
                {
                mT80(); 

                }
                break;
            case 70 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:286: T81
                {
                mT81(); 

                }
                break;
            case 71 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:290: T82
                {
                mT82(); 

                }
                break;
            case 72 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:294: RULE_DOUBLE_QUOTED_STRING
                {
                mRULE_DOUBLE_QUOTED_STRING(); 

                }
                break;
            case 73 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:320: RULE_SINGLE_QUOTED_STRING
                {
                mRULE_SINGLE_QUOTED_STRING(); 

                }
                break;
            case 74 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:346: RULE_ID_TERMINAL
                {
                mRULE_ID_TERMINAL(); 

                }
                break;
            case 75 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:363: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 76 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:372: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 77 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:388: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 78 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:404: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 79 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1:412: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA11_1 = input.LA(2);

        if ( (LA11_1=='o') ) {
            int LA11_51 = input.LA(3);

            if ( (LA11_51=='d') ) {
                int LA11_120 = input.LA(4);

                if ( (LA11_120=='y') ) {
                    int LA11_157 = input.LA(5);

                    if ( ((LA11_157>='0' && LA11_157<='9')||(LA11_157>='A' && LA11_157<='Z')||LA11_157=='_'||(LA11_157>='a' && LA11_157<='z')) ) {
                        return 74;
                    }
                    else {
                        return 1;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper002() throws RecognitionException {
        int LA11_2 = input.LA(2);

        if ( (LA11_2=='o') ) {
            int LA11_53 = input.LA(3);

            if ( (LA11_53=='n') ) {
                int LA11_121 = input.LA(4);

                if ( (LA11_121=='t') ) {
                    int LA11_158 = input.LA(5);

                    if ( (LA11_158=='e') ) {
                        int LA11_197 = input.LA(6);

                        if ( (LA11_197=='x') ) {
                            int LA11_226 = input.LA(7);

                            if ( (LA11_226=='t') ) {
                                int LA11_247 = input.LA(8);

                                if ( ((LA11_247>='0' && LA11_247<='9')||(LA11_247>='A' && LA11_247<='Z')||LA11_247=='_'||(LA11_247>='a' && LA11_247<='z')) ) {
                                    return 74;
                                }
                                else {
                                    return 2;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper003() throws RecognitionException {
        int LA11_3 = input.LA(2);

        if ( (LA11_3=='e') ) {
            switch ( input.LA(3) ) {
            case 'f':
                {
                int LA11_122 = input.LA(4);

                if ( ((LA11_122>='0' && LA11_122<='9')||(LA11_122>='A' && LA11_122<='Z')||LA11_122=='_'||(LA11_122>='a' && LA11_122<='z')) ) {
                    return 74;
                }
                else {
                    return 3;}
                }
            case 'r':
                {
                int LA11_123 = input.LA(4);

                if ( (LA11_123=='i') ) {
                    int LA11_160 = input.LA(5);

                    if ( (LA11_160=='v') ) {
                        int LA11_198 = input.LA(6);

                        if ( (LA11_198=='e') ) {
                            int LA11_227 = input.LA(7);

                            if ( ((LA11_227>='0' && LA11_227<='9')||(LA11_227>='A' && LA11_227<='Z')||LA11_227=='_'||(LA11_227>='a' && LA11_227<='z')) ) {
                                return 74;
                            }
                            else {
                                return 4;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
                }
            default:
                return 74;}

        }
        else {
            return 74;}
    }

    private int mTokensHelper004() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'n':
            {
            switch ( input.LA(3) ) {
            case 'v':
                {
                switch ( input.LA(4) ) {
                case 'a':
                    {
                    int LA11_161 = input.LA(5);

                    if ( (LA11_161=='l') ) {
                        int LA11_199 = input.LA(6);

                        if ( (LA11_199=='i') ) {
                            int LA11_228 = input.LA(7);

                            if ( (LA11_228=='d') ) {
                                int LA11_249 = input.LA(8);

                                if ( ((LA11_249>='0' && LA11_249<='9')||(LA11_249>='A' && LA11_249<='Z')||LA11_249=='_'||(LA11_249>='a' && LA11_249<='z')) ) {
                                    return 74;
                                }
                                else {
                                    return 47;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                    }
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
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    return 74;
                    }
                default:
                    return 7;}

                }
            case 'i':
                {
                int LA11_125 = input.LA(4);

                if ( (LA11_125=='t') ) {
                    int LA11_163 = input.LA(5);

                    if ( ((LA11_163>='0' && LA11_163<='9')||(LA11_163>='A' && LA11_163<='Z')||LA11_163=='_'||(LA11_163>='a' && LA11_163<='z')) ) {
                        return 74;
                    }
                    else {
                        return 6;}
                }
                else {
                    return 74;}
                }
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
                return 74;
                }
            default:
                return 71;}

            }
        case 'f':
            {
            int LA11_56 = input.LA(3);

            if ( ((LA11_56>='0' && LA11_56<='9')||(LA11_56>='A' && LA11_56<='Z')||LA11_56=='_'||(LA11_56>='a' && LA11_56<='z')) ) {
                return 74;
            }
            else {
                return 66;}
            }
        case 'm':
            {
            int LA11_57 = input.LA(3);

            if ( (LA11_57=='p') ) {
                switch ( input.LA(4) ) {
                case 'o':
                    {
                    int LA11_164 = input.LA(5);

                    if ( (LA11_164=='r') ) {
                        int LA11_201 = input.LA(6);

                        if ( (LA11_201=='t') ) {
                            int LA11_229 = input.LA(7);

                            if ( ((LA11_229>='0' && LA11_229<='9')||(LA11_229>='A' && LA11_229<='Z')||LA11_229=='_'||(LA11_229>='a' && LA11_229<='z')) ) {
                                return 74;
                            }
                            else {
                                return 5;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                    }
                case 'l':
                    {
                    int LA11_165 = input.LA(5);

                    if ( (LA11_165=='i') ) {
                        int LA11_202 = input.LA(6);

                        if ( (LA11_202=='e') ) {
                            int LA11_230 = input.LA(7);

                            if ( (LA11_230=='s') ) {
                                int LA11_251 = input.LA(8);

                                if ( ((LA11_251>='0' && LA11_251<='9')||(LA11_251>='A' && LA11_251<='Z')||LA11_251=='_'||(LA11_251>='a' && LA11_251<='z')) ) {
                                    return 74;
                                }
                                else {
                                    return 49;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                    }
                default:
                    return 74;}

            }
            else {
                return 74;}
            }
        default:
            return 74;}

    }

    private int mTokensHelper005() throws RecognitionException {
        int LA11_5 = input.LA(2);

        if ( (LA11_5==':') ) {
            return 18;
        }
        else {
            return 8;}
    }

    private int mTokensHelper006() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            int LA11_60 = input.LA(3);

            if ( (LA11_60=='l') ) {
                int LA11_129 = input.LA(4);

                if ( (LA11_129=='f') ) {
                    int LA11_166 = input.LA(5);

                    if ( ((LA11_166>='0' && LA11_166<='9')||(LA11_166>='A' && LA11_166<='Z')||LA11_166=='_'||(LA11_166>='a' && LA11_166<='z')) ) {
                        return 74;
                    }
                    else {
                        return 65;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        case 't':
            {
            int LA11_61 = input.LA(3);

            if ( (LA11_61=='a') ) {
                int LA11_130 = input.LA(4);

                if ( (LA11_130=='t') ) {
                    int LA11_167 = input.LA(5);

                    if ( (LA11_167=='i') ) {
                        int LA11_204 = input.LA(6);

                        if ( (LA11_204=='c') ) {
                            int LA11_231 = input.LA(7);

                            if ( ((LA11_231>='0' && LA11_231<='9')||(LA11_231>='A' && LA11_231<='Z')||LA11_231=='_'||(LA11_231>='a' && LA11_231<='z')) ) {
                                return 74;
                            }
                            else {
                                return 9;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        default:
            return 74;}

    }

    private int mTokensHelper007() throws RecognitionException {
        return 10;
    }

    private int mTokensHelper008() throws RecognitionException {
        return 11;
    }

    private int mTokensHelper009() throws RecognitionException {
        return 12;
    }

    private int mTokensHelper010() throws RecognitionException {
        return 13;
    }

    private int mTokensHelper011() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA11_66 = input.LA(3);

            if ( (LA11_66=='c') ) {
                int LA11_131 = input.LA(4);

                if ( (LA11_131=='k') ) {
                    int LA11_168 = input.LA(5);

                    if ( (LA11_168=='a') ) {
                        int LA11_205 = input.LA(6);

                        if ( (LA11_205=='g') ) {
                            int LA11_232 = input.LA(7);

                            if ( (LA11_232=='e') ) {
                                int LA11_253 = input.LA(8);

                                if ( ((LA11_253>='0' && LA11_253<='9')||(LA11_253>='A' && LA11_253<='Z')||LA11_253=='_'||(LA11_253>='a' && LA11_253<='z')) ) {
                                    return 74;
                                }
                                else {
                                    return 14;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        case 'r':
            {
            int LA11_67 = input.LA(3);

            if ( (LA11_67=='e') ) {
                int LA11_132 = input.LA(4);

                if ( ((LA11_132>='0' && LA11_132<='9')||(LA11_132>='A' && LA11_132<='Z')||LA11_132=='_'||(LA11_132>='a' && LA11_132<='z')) ) {
                    return 74;
                }
                else {
                    return 17;}
            }
            else {
                return 74;}
            }
        case 'o':
            {
            int LA11_68 = input.LA(3);

            if ( (LA11_68=='s') ) {
                int LA11_133 = input.LA(4);

                if ( (LA11_133=='t') ) {
                    int LA11_170 = input.LA(5);

                    if ( ((LA11_170>='0' && LA11_170<='9')||(LA11_170>='A' && LA11_170<='Z')||LA11_170=='_'||(LA11_170>='a' && LA11_170<='z')) ) {
                        return 74;
                    }
                    else {
                        return 16;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        default:
            return 74;}

    }

    private int mTokensHelper012() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'n':
            {
            int LA11_69 = input.LA(3);

            if ( (LA11_69=='d') ) {
                switch ( input.LA(4) ) {
                case 'p':
                    {
                    int LA11_171 = input.LA(5);

                    if ( (LA11_171=='a') ) {
                        int LA11_207 = input.LA(6);

                        if ( (LA11_207=='c') ) {
                            int LA11_233 = input.LA(7);

                            if ( (LA11_233=='k') ) {
                                int LA11_254 = input.LA(8);

                                if ( (LA11_254=='a') ) {
                                    int LA11_269 = input.LA(9);

                                    if ( (LA11_269=='g') ) {
                                        int LA11_278 = input.LA(10);

                                        if ( (LA11_278=='e') ) {
                                            int LA11_284 = input.LA(11);

                                            if ( ((LA11_284>='0' && LA11_284<='9')||(LA11_284>='A' && LA11_284<='Z')||LA11_284=='_'||(LA11_284>='a' && LA11_284<='z')) ) {
                                                return 74;
                                            }
                                            else {
                                                return 15;}
                                        }
                                        else {
                                            return 74;}
                                    }
                                    else {
                                        return 74;}
                                }
                                else {
                                    return 74;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                    }
                case 'i':
                    {
                    int LA11_172 = input.LA(5);

                    if ( (LA11_172=='f') ) {
                        int LA11_208 = input.LA(6);

                        if ( ((LA11_208>='0' && LA11_208<='9')||(LA11_208>='A' && LA11_208<='Z')||LA11_208=='_'||(LA11_208>='a' && LA11_208<='z')) ) {
                            return 74;
                        }
                        else {
                            return 69;}
                    }
                    else {
                        return 74;}
                    }
                default:
                    return 74;}

            }
            else {
                return 74;}
            }
        case 'l':
            {
            int LA11_70 = input.LA(3);

            if ( (LA11_70=='s') ) {
                int LA11_135 = input.LA(4);

                if ( (LA11_135=='e') ) {
                    int LA11_173 = input.LA(5);

                    if ( ((LA11_173>='0' && LA11_173<='9')||(LA11_173>='A' && LA11_173<='Z')||LA11_173=='_'||(LA11_173>='a' && LA11_173<='z')) ) {
                        return 74;
                    }
                    else {
                        return 68;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
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
            return 74;
            }
        default:
            return 24;}

    }

    private int mTokensHelper013() throws RecognitionException {
        int LA11_13 = input.LA(2);

        if ( (LA11_13=='.') ) {
            return 44;
        }
        else {
            return 19;}
    }

    private int mTokensHelper014() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '-':
            {
            return 77;
            }
        case '>':
            {
            return 20;
            }
        default:
            return 27;}

    }

    private int mTokensHelper015() throws RecognitionException {
        int LA11_15 = input.LA(2);

        if ( (LA11_15=='^') ) {
            return 21;
        }
        else {
            return 22;}
    }

    private int mTokensHelper016() throws RecognitionException {
        return 23;
    }

    private int mTokensHelper017() throws RecognitionException {
        int LA11_17 = input.LA(2);

        if ( ((LA11_17>='0' && LA11_17<='9')||(LA11_17>='A' && LA11_17<='Z')||LA11_17=='_'||(LA11_17>='a' && LA11_17<='z')) ) {
            return 74;
        }
        else {
            return 25;}
    }

    private int mTokensHelper018() throws RecognitionException {
        return 26;
    }

    private int mTokensHelper019() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'o':
            {
            int LA11_82 = input.LA(3);

            if ( (LA11_82=='o') ) {
                int LA11_136 = input.LA(4);

                if ( (LA11_136=='l') ) {
                    int LA11_174 = input.LA(5);

                    if ( (LA11_174=='e') ) {
                        int LA11_210 = input.LA(6);

                        if ( (LA11_210=='a') ) {
                            int LA11_235 = input.LA(7);

                            if ( (LA11_235=='n') ) {
                                int LA11_255 = input.LA(8);

                                if ( ((LA11_255>='0' && LA11_255<='9')||(LA11_255>='A' && LA11_255<='Z')||LA11_255=='_'||(LA11_255>='a' && LA11_255<='z')) ) {
                                    return 74;
                                }
                                else {
                                    return 28;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        case 'a':
            {
            int LA11_83 = input.LA(3);

            if ( (LA11_83=='g') ) {
                int LA11_137 = input.LA(4);

                if ( ((LA11_137>='0' && LA11_137<='9')||(LA11_137>='A' && LA11_137<='Z')||LA11_137=='_'||(LA11_137>='a' && LA11_137<='z')) ) {
                    return 74;
                }
                else {
                    return 37;}
            }
            else {
                return 74;}
            }
        default:
            return 74;}

    }

    private int mTokensHelper020() throws RecognitionException {
        int LA11_20 = input.LA(2);

        if ( (LA11_20=='n') ) {
            int LA11_84 = input.LA(3);

            if ( (LA11_84=='t') ) {
                int LA11_138 = input.LA(4);

                if ( (LA11_138=='e') ) {
                    int LA11_176 = input.LA(5);

                    if ( (LA11_176=='g') ) {
                        int LA11_211 = input.LA(6);

                        if ( (LA11_211=='e') ) {
                            int LA11_236 = input.LA(7);

                            if ( (LA11_236=='r') ) {
                                int LA11_256 = input.LA(8);

                                if ( ((LA11_256>='0' && LA11_256<='9')||(LA11_256>='A' && LA11_256<='Z')||LA11_256=='_'||(LA11_256>='a' && LA11_256<='z')) ) {
                                    return 74;
                                }
                                else {
                                    return 29;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper021() throws RecognitionException {
        int LA11_21 = input.LA(2);

        if ( (LA11_21=='e') ) {
            int LA11_85 = input.LA(3);

            if ( (LA11_85=='a') ) {
                int LA11_139 = input.LA(4);

                if ( (LA11_139=='l') ) {
                    int LA11_177 = input.LA(5);

                    if ( ((LA11_177>='0' && LA11_177<='9')||(LA11_177>='A' && LA11_177<='Z')||LA11_177=='_'||(LA11_177>='a' && LA11_177<='z')) ) {
                        return 74;
                    }
                    else {
                        return 30;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper022() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 't':
            {
            int LA11_86 = input.LA(3);

            if ( (LA11_86=='r') ) {
                int LA11_140 = input.LA(4);

                if ( (LA11_140=='i') ) {
                    int LA11_178 = input.LA(5);

                    if ( (LA11_178=='n') ) {
                        int LA11_213 = input.LA(6);

                        if ( (LA11_213=='g') ) {
                            int LA11_237 = input.LA(7);

                            if ( ((LA11_237>='0' && LA11_237<='9')||(LA11_237>='A' && LA11_237<='Z')||LA11_237=='_'||(LA11_237>='a' && LA11_237<='z')) ) {
                                return 74;
                            }
                            else {
                                return 31;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        case 'e':
            {
            switch ( input.LA(3) ) {
            case 't':
                {
                int LA11_141 = input.LA(4);

                if ( ((LA11_141>='0' && LA11_141<='9')||(LA11_141>='A' && LA11_141<='Z')||LA11_141=='_'||(LA11_141>='a' && LA11_141<='z')) ) {
                    return 74;
                }
                else {
                    return 36;}
                }
            case 'q':
                {
                int LA11_142 = input.LA(4);

                if ( (LA11_142=='u') ) {
                    int LA11_180 = input.LA(5);

                    if ( (LA11_180=='e') ) {
                        int LA11_214 = input.LA(6);

                        if ( (LA11_214=='n') ) {
                            int LA11_238 = input.LA(7);

                            if ( (LA11_238=='c') ) {
                                int LA11_258 = input.LA(8);

                                if ( (LA11_258=='e') ) {
                                    int LA11_272 = input.LA(9);

                                    if ( ((LA11_272>='0' && LA11_272<='9')||(LA11_272>='A' && LA11_272<='Z')||LA11_272=='_'||(LA11_272>='a' && LA11_272<='z')) ) {
                                        return 74;
                                    }
                                    else {
                                        return 38;}
                                }
                                else {
                                    return 74;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
                }
            default:
                return 74;}

            }
        default:
            return 74;}

    }

    private int mTokensHelper023() throws RecognitionException {
        int LA11_23 = input.LA(2);

        if ( (LA11_23=='n') ) {
            int LA11_88 = input.LA(3);

            if ( (LA11_88=='l') ) {
                int LA11_143 = input.LA(4);

                if ( (LA11_143=='i') ) {
                    int LA11_181 = input.LA(5);

                    if ( (LA11_181=='m') ) {
                        int LA11_215 = input.LA(6);

                        if ( (LA11_215=='i') ) {
                            int LA11_239 = input.LA(7);

                            if ( (LA11_239=='t') ) {
                                int LA11_259 = input.LA(8);

                                if ( (LA11_259=='e') ) {
                                    int LA11_273 = input.LA(9);

                                    if ( (LA11_273=='d') ) {
                                        int LA11_280 = input.LA(10);

                                        if ( (LA11_280=='N') ) {
                                            int LA11_285 = input.LA(11);

                                            if ( (LA11_285=='a') ) {
                                                int LA11_290 = input.LA(12);

                                                if ( (LA11_290=='t') ) {
                                                    int LA11_294 = input.LA(13);

                                                    if ( (LA11_294=='u') ) {
                                                        int LA11_295 = input.LA(14);

                                                        if ( (LA11_295=='r') ) {
                                                            int LA11_296 = input.LA(15);

                                                            if ( (LA11_296=='a') ) {
                                                                int LA11_297 = input.LA(16);

                                                                if ( (LA11_297=='l') ) {
                                                                    int LA11_298 = input.LA(17);

                                                                    if ( ((LA11_298>='0' && LA11_298<='9')||(LA11_298>='A' && LA11_298<='Z')||LA11_298=='_'||(LA11_298>='a' && LA11_298<='z')) ) {
                                                                        return 74;
                                                                    }
                                                                    else {
                                                                        return 32;}
                                                                }
                                                                else {
                                                                    return 74;}
                                                            }
                                                            else {
                                                                return 74;}
                                                        }
                                                        else {
                                                            return 74;}
                                                    }
                                                    else {
                                                        return 74;}
                                                }
                                                else {
                                                    return 74;}
                                            }
                                            else {
                                                return 74;}
                                        }
                                        else {
                                            return 74;}
                                    }
                                    else {
                                        return 74;}
                                }
                                else {
                                    return 74;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper024() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'c':
            {
            int LA11_89 = input.LA(3);

            if ( (LA11_89=='l') ) {
                switch ( input.LA(4) ) {
                case 'A':
                    {
                    int LA11_182 = input.LA(5);

                    if ( (LA11_182=='n') ) {
                        int LA11_216 = input.LA(6);

                        if ( (LA11_216=='y') ) {
                            int LA11_240 = input.LA(7);

                            if ( ((LA11_240>='0' && LA11_240<='9')||(LA11_240>='A' && LA11_240<='Z')||LA11_240=='_'||(LA11_240>='a' && LA11_240<='z')) ) {
                                return 74;
                            }
                            else {
                                return 33;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                    }
                case 'I':
                    {
                    int LA11_183 = input.LA(5);

                    if ( (LA11_183=='n') ) {
                        int LA11_217 = input.LA(6);

                        if ( (LA11_217=='v') ) {
                            int LA11_241 = input.LA(7);

                            if ( (LA11_241=='a') ) {
                                int LA11_261 = input.LA(8);

                                if ( (LA11_261=='l') ) {
                                    int LA11_274 = input.LA(9);

                                    if ( (LA11_274=='i') ) {
                                        int LA11_281 = input.LA(10);

                                        if ( (LA11_281=='d') ) {
                                            int LA11_286 = input.LA(11);

                                            if ( ((LA11_286>='0' && LA11_286<='9')||(LA11_286>='A' && LA11_286<='Z')||LA11_286=='_'||(LA11_286>='a' && LA11_286<='z')) ) {
                                                return 74;
                                            }
                                            else {
                                                return 34;}
                                        }
                                        else {
                                            return 74;}
                                    }
                                    else {
                                        return 74;}
                                }
                                else {
                                    return 74;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                    }
                case 'V':
                    {
                    int LA11_184 = input.LA(5);

                    if ( (LA11_184=='o') ) {
                        int LA11_218 = input.LA(6);

                        if ( (LA11_218=='i') ) {
                            int LA11_242 = input.LA(7);

                            if ( (LA11_242=='d') ) {
                                int LA11_262 = input.LA(8);

                                if ( ((LA11_262>='0' && LA11_262<='9')||(LA11_262>='A' && LA11_262<='Z')||LA11_262=='_'||(LA11_262>='a' && LA11_262<='z')) ) {
                                    return 74;
                                }
                                else {
                                    return 35;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                    }
                default:
                    return 74;}

            }
            else {
                return 74;}
            }
        case 'r':
            {
            int LA11_90 = input.LA(3);

            if ( (LA11_90=='d') ) {
                int LA11_145 = input.LA(4);

                if ( (LA11_145=='e') ) {
                    int LA11_185 = input.LA(5);

                    if ( (LA11_185=='r') ) {
                        int LA11_219 = input.LA(6);

                        if ( (LA11_219=='e') ) {
                            int LA11_243 = input.LA(7);

                            if ( (LA11_243=='d') ) {
                                int LA11_263 = input.LA(8);

                                if ( (LA11_263=='S') ) {
                                    int LA11_276 = input.LA(9);

                                    if ( (LA11_276=='e') ) {
                                        int LA11_282 = input.LA(10);

                                        if ( (LA11_282=='t') ) {
                                            int LA11_287 = input.LA(11);

                                            if ( ((LA11_287>='0' && LA11_287<='9')||(LA11_287>='A' && LA11_287<='Z')||LA11_287=='_'||(LA11_287>='a' && LA11_287<='z')) ) {
                                                return 74;
                                            }
                                            else {
                                                return 40;}
                                        }
                                        else {
                                            return 74;}
                                    }
                                    else {
                                        return 74;}
                                }
                                else {
                                    return 74;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        default:
            return 74;}

    }

    private int mTokensHelper025() throws RecognitionException {
        int LA11_25 = input.LA(2);

        if ( (LA11_25=='o') ) {
            int LA11_91 = input.LA(3);

            if ( (LA11_91=='l') ) {
                int LA11_146 = input.LA(4);

                if ( (LA11_146=='l') ) {
                    int LA11_186 = input.LA(5);

                    if ( (LA11_186=='e') ) {
                        int LA11_220 = input.LA(6);

                        if ( (LA11_220=='c') ) {
                            int LA11_244 = input.LA(7);

                            if ( (LA11_244=='t') ) {
                                int LA11_264 = input.LA(8);

                                if ( (LA11_264=='i') ) {
                                    int LA11_277 = input.LA(9);

                                    if ( (LA11_277=='o') ) {
                                        int LA11_283 = input.LA(10);

                                        if ( (LA11_283=='n') ) {
                                            int LA11_288 = input.LA(11);

                                            if ( ((LA11_288>='0' && LA11_288<='9')||(LA11_288>='A' && LA11_288<='Z')||LA11_288=='_'||(LA11_288>='a' && LA11_288<='z')) ) {
                                                return 74;
                                            }
                                            else {
                                                return 39;}
                                        }
                                        else {
                                            return 74;}
                                    }
                                    else {
                                        return 74;}
                                }
                                else {
                                    return 74;}
                            }
                            else {
                                return 74;}
                        }
                        else {
                            return 74;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper026() throws RecognitionException {
        int LA11_26 = input.LA(2);

        if ( (LA11_26=='u') ) {
            int LA11_92 = input.LA(3);

            if ( (LA11_92=='p') ) {
                int LA11_147 = input.LA(4);

                if ( (LA11_147=='l') ) {
                    int LA11_187 = input.LA(5);

                    if ( (LA11_187=='e') ) {
                        int LA11_221 = input.LA(6);

                        if ( ((LA11_221>='0' && LA11_221<='9')||(LA11_221>='A' && LA11_221<='Z')||LA11_221=='_'||(LA11_221>='a' && LA11_221<='z')) ) {
                            return 74;
                        }
                        else {
                            return 41;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper027() throws RecognitionException {
        return 42;
    }

    private int mTokensHelper028() throws RecognitionException {
        return 43;
    }

    private int mTokensHelper029() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'r':
            {
            int LA11_95 = input.LA(3);

            if ( (LA11_95=='u') ) {
                int LA11_148 = input.LA(4);

                if ( (LA11_148=='e') ) {
                    int LA11_188 = input.LA(5);

                    if ( ((LA11_188>='0' && LA11_188<='9')||(LA11_188>='A' && LA11_188<='Z')||LA11_188=='_'||(LA11_188>='a' && LA11_188<='z')) ) {
                        return 74;
                    }
                    else {
                        return 45;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        case 'h':
            {
            int LA11_96 = input.LA(3);

            if ( (LA11_96=='e') ) {
                int LA11_149 = input.LA(4);

                if ( (LA11_149=='n') ) {
                    int LA11_189 = input.LA(5);

                    if ( ((LA11_189>='0' && LA11_189<='9')||(LA11_189>='A' && LA11_189<='Z')||LA11_189=='_'||(LA11_189>='a' && LA11_189<='z')) ) {
                        return 74;
                    }
                    else {
                        return 67;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        default:
            return 74;}

    }

    private int mTokensHelper030() throws RecognitionException {
        int LA11_30 = input.LA(2);

        if ( (LA11_30=='a') ) {
            int LA11_97 = input.LA(3);

            if ( (LA11_97=='l') ) {
                int LA11_150 = input.LA(4);

                if ( (LA11_150=='s') ) {
                    int LA11_190 = input.LA(5);

                    if ( (LA11_190=='e') ) {
                        int LA11_224 = input.LA(6);

                        if ( ((LA11_224>='0' && LA11_224<='9')||(LA11_224>='A' && LA11_224<='Z')||LA11_224=='_'||(LA11_224>='a' && LA11_224<='z')) ) {
                            return 74;
                        }
                        else {
                            return 46;}
                    }
                    else {
                        return 74;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper031() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'u':
            {
            int LA11_98 = input.LA(3);

            if ( (LA11_98=='l') ) {
                int LA11_151 = input.LA(4);

                if ( (LA11_151=='l') ) {
                    int LA11_191 = input.LA(5);

                    if ( ((LA11_191>='0' && LA11_191<='9')||(LA11_191>='A' && LA11_191<='Z')||LA11_191=='_'||(LA11_191>='a' && LA11_191<='z')) ) {
                        return 74;
                    }
                    else {
                        return 48;}
                }
                else {
                    return 74;}
            }
            else {
                return 74;}
            }
        case 'o':
            {
            int LA11_99 = input.LA(3);

            if ( (LA11_99=='t') ) {
                int LA11_152 = input.LA(4);

                if ( ((LA11_152>='0' && LA11_152<='9')||(LA11_152>='A' && LA11_152<='Z')||LA11_152=='_'||(LA11_152>='a' && LA11_152<='z')) ) {
                    return 74;
                }
                else {
                    return 60;}
            }
            else {
                return 74;}
            }
        default:
            return 74;}

    }

    private int mTokensHelper032() throws RecognitionException {
        int LA11_32 = input.LA(2);

        if ( (LA11_32=='o') ) {
            int LA11_100 = input.LA(3);

            if ( (LA11_100=='r') ) {
                int LA11_153 = input.LA(4);

                if ( ((LA11_153>='0' && LA11_153<='9')||(LA11_153>='A' && LA11_153<='Z')||LA11_153=='_'||(LA11_153>='a' && LA11_153<='z')) ) {
                    return 74;
                }
                else {
                    return 50;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper033() throws RecognitionException {
        int LA11_33 = input.LA(2);

        if ( (LA11_33=='r') ) {
            int LA11_101 = input.LA(3);

            if ( ((LA11_101>='0' && LA11_101<='9')||(LA11_101>='A' && LA11_101<='Z')||LA11_101=='_'||(LA11_101>='a' && LA11_101<='z')) ) {
                return 74;
            }
            else {
                return 51;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper034() throws RecognitionException {
        int LA11_34 = input.LA(2);

        if ( (LA11_34=='n') ) {
            int LA11_102 = input.LA(3);

            if ( (LA11_102=='d') ) {
                int LA11_155 = input.LA(4);

                if ( ((LA11_155>='0' && LA11_155<='9')||(LA11_155>='A' && LA11_155<='Z')||LA11_155=='_'||(LA11_155>='a' && LA11_155<='z')) ) {
                    return 74;
                }
                else {
                    return 52;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper035() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '=':
            {
            return 57;
            }
        case '>':
            {
            return 53;
            }
        default:
            return 55;}

    }

    private int mTokensHelper036() throws RecognitionException {
        int LA11_36 = input.LA(2);

        if ( (LA11_36=='=') ) {
            return 56;
        }
        else {
            return 54;}
    }

    private int mTokensHelper037() throws RecognitionException {
        return 58;
    }

    private int mTokensHelper038() throws RecognitionException {
        int LA11_38 = input.LA(2);

        if ( (LA11_38=='*') ) {
            return 76;
        }
        else {
            return 59;}
    }

    private int mTokensHelper039() throws RecognitionException {
        return 61;
    }

    private int mTokensHelper040() throws RecognitionException {
        return 62;
    }

    private int mTokensHelper041() throws RecognitionException {
        return 63;
    }

    private int mTokensHelper042() throws RecognitionException {
        return 64;
    }

    private int mTokensHelper043() throws RecognitionException {
        int LA11_43 = input.LA(2);

        if ( (LA11_43=='e') ) {
            int LA11_115 = input.LA(3);

            if ( (LA11_115=='t') ) {
                int LA11_156 = input.LA(4);

                if ( ((LA11_156>='0' && LA11_156<='9')||(LA11_156>='A' && LA11_156<='Z')||LA11_156=='_'||(LA11_156>='a' && LA11_156<='z')) ) {
                    return 74;
                }
                else {
                    return 70;}
            }
            else {
                return 74;}
        }
        else {
            return 74;}
    }

    private int mTokensHelper044() throws RecognitionException {
        int LA11_44 = input.LA(2);

        if ( ((LA11_44>='\u0000' && LA11_44<='\uFFFE')) ) {
            return 72;
        }
        else {
            return 79;}
    }

    private int mTokensHelper045() throws RecognitionException {
        int LA11_45 = input.LA(2);

        if ( ((LA11_45>='\u0000' && LA11_45<='\uFFFE')) ) {
            return 73;
        }
        else {
            return 79;}
    }

    private int mTokensHelper046() throws RecognitionException {
        return 74;
    }

    private int mTokensHelper047() throws RecognitionException {
        return 74;
    }

    private int mTokensHelper048() throws RecognitionException {
        return 75;
    }

    private int mTokensHelper049() throws RecognitionException {
        return 78;
    }

    private int mTokensHelper050() throws RecognitionException {
        return 79;
    }

    private int mTokensHelper051() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 0, input);

        throw nvae;
    }



 

}