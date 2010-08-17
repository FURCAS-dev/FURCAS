package org.eclipse.ocl.examples.xtext.completeocl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCompleteOCLLexer extends Lexer {
    public static final int T75=75;
    public static final int T76=76;
    public static final int T73=73;
    public static final int RULE_ID=5;
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
    public static final int RULE_INT=6;
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
    public static final int RULE_SINGLE_QUOTED_STRING=4;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T43=43;
    public static final int Tokens=86;
    public static final int RULE_SL_COMMENT=9;
    public static final int T42=42;
    public static final int T41=41;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int T45=45;
    public static final int RULE_ML_COMMENT=8;
    public static final int T44=44;
    public static final int T84=84;
    public static final int T85=85;
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
    public static final int T83=83;
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
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:10:5: ( 'body' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:10:7: 'body'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:11:5: ( 'context' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:11:7: 'context'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:12:5: ( 'def' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:12:7: 'def'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:13:5: ( 'derive' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:13:7: 'derive'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:14:5: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:14:7: 'import'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15:5: ( 'init' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15:7: 'init'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:16:5: ( 'inv' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:16:7: 'inv'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:17:5: ( 'Boolean' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:17:7: 'Boolean'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:18:5: ( 'Integer' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:18:7: 'Integer'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:19:5: ( 'Real' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:19:7: 'Real'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:20:5: ( 'String' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:20:7: 'String'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:21:5: ( 'UnlimitedNatural' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:21:7: 'UnlimitedNatural'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:22:5: ( 'OclAny' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:22:7: 'OclAny'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:23:5: ( 'OclInvalid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:23:7: 'OclInvalid'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:24:5: ( 'OclMessage' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:24:7: 'OclMessage'
            {
            match("OclMessage"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:25:5: ( 'OclState' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:25:7: 'OclState'
            {
            match("OclState"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:26:5: ( 'OclVoid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:26:7: 'OclVoid'
            {
            match("OclVoid"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:27:5: ( '.' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:27:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:28:5: ( '->' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:28:7: '->'
            {
            match("->"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:29:5: ( '^^' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:29:7: '^^'
            {
            match("^^"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:30:5: ( '^' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:30:7: '^'
            {
            match('^'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:31:5: ( 'e' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:31:7: 'e'
            {
            match('e'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:32:5: ( 'E' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:32:7: 'E'
            {
            match('E'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:33:5: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:33:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:34:5: ( '-' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:34:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:35:5: ( 'Set' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:35:7: 'Set'
            {
            match("Set"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:36:5: ( 'Bag' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:36:7: 'Bag'
            {
            match("Bag"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:37:5: ( 'Sequence' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:37:7: 'Sequence'
            {
            match("Sequence"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:38:5: ( 'Collection' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:38:7: 'Collection'
            {
            match("Collection"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:39:5: ( 'OrderedSet' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:39:7: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:40:5: ( '=' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:40:7: '='
            {
            match('='); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:41:5: ( '<>' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:41:7: '<>'
            {
            match("<>"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:42:5: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:42:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:43:5: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:43:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:44:5: ( '>=' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:44:7: '>='
            {
            match(">="); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:45:5: ( '<=' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:45:7: '<='
            {
            match("<="); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:46:5: ( '*' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:46:7: '*'
            {
            match('*'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:47:5: ( '/' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:47:7: '/'
            {
            match('/'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:48:5: ( 'not' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:48:7: 'not'
            {
            match("not"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:49:5: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:49:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:50:5: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:50:7: '('
            {
            match('('); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:51:5: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:51:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:52:5: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:52:7: ','
            {
            match(','); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:53:5: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:53:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:54:5: ( 'endpackage' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:54:7: 'endpackage'
            {
            match("endpackage"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:55:5: ( 'post' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:55:7: 'post'
            {
            match("post"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:56:5: ( 'pre' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:56:7: 'pre'
            {
            match("pre"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:57:5: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:57:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:58:5: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:58:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:59:5: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:59:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:60:5: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:60:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:61:5: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:61:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:62:5: ( 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:62:7: 'Tuple'
            {
            match("Tuple"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:63:5: ( 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:63:7: 'invalid'
            {
            match("invalid"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:64:5: ( 'null' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:64:7: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:65:5: ( '@' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:65:7: '@'
            {
            match('@'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:66:5: ( '|' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:66:7: '|'
            {
            match('|'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:67:5: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:67:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:68:5: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:68:7: '['
            {
            match('['); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:69:5: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:69:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:70:5: ( 'self' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:70:7: 'self'
            {
            match("self"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:71:5: ( 'if' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:71:7: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:72:5: ( 'then' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:72:7: 'then'
            {
            match("then"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:73:5: ( 'else' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:73:7: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:74:5: ( 'endif' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:74:7: 'endif'
            {
            match("endif"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:75:5: ( 'let' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:75:7: 'let'
            {
            match("let"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:76:5: ( 'in' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:76:7: 'in'
            {
            match("in"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:77:5: ( 'static' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:77:7: 'static'
            {
            match("static"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:78:5: ( 'true' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:78:7: 'true'
            {
            match("true"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:79:5: ( 'false' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:79:7: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:80:5: ( 'implies' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:80:7: 'implies'
            {
            match("implies"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T82

    // $ANTLR start T83
    public final void mT83() throws RecognitionException {
        try {
            int _type = T83;
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:81:5: ( 'xor' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:81:7: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T83

    // $ANTLR start T84
    public final void mT84() throws RecognitionException {
        try {
            int _type = T84;
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:82:5: ( 'or' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:82:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T84

    // $ANTLR start T85
    public final void mT85() throws RecognitionException {
        try {
            int _type = T85;
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:83:5: ( 'and' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:83:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T85

    // $ANTLR start RULE_DOUBLE_QUOTED_STRING
    public final void mRULE_DOUBLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_QUOTED_STRING;
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15065:27: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15065:29: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15065:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15065:34: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15065:79: ~ ( ( '\\\\' | '\"' ) )
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15067:27: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15067:29: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15067:34: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15067:35: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15067:80: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15069:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15069:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15069:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
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
                    new NoViableAltException("15069:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15069:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15069:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15069:70: '_' RULE_SINGLE_QUOTED_STRING
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

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15071:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15071:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15071:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15071:13: '0' .. '9'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15073:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15073:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15073:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15073:52: .
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15075:41: '\\r'
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15077:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15077:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15077:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:
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
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15079:16: ( . )
            // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:15079:18: .
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
        // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt11=82;
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
        else if ( (LA11_0=='B') ) {
            alt11 = mTokensHelper005();
        }
        else if ( (LA11_0=='I') ) {
            alt11 = mTokensHelper006();
        }
        else if ( (LA11_0=='R') ) {
            alt11 = mTokensHelper007();
        }
        else if ( (LA11_0=='S') ) {
            alt11 = mTokensHelper008();
        }
        else if ( (LA11_0=='U') ) {
            alt11 = mTokensHelper009();
        }
        else if ( (LA11_0=='O') ) {
            alt11 = mTokensHelper010();
        }
        else if ( (LA11_0=='.') ) {
            alt11 = mTokensHelper011();
        }
        else if ( (LA11_0=='-') ) {
            alt11 = mTokensHelper012();
        }
        else if ( (LA11_0=='^') ) {
            alt11 = mTokensHelper013();
        }
        else if ( (LA11_0=='e') ) {
            alt11 = mTokensHelper014();
        }
        else if ( (LA11_0=='E') ) {
            alt11 = mTokensHelper015();
        }
        else if ( (LA11_0=='+') ) {
            alt11 = mTokensHelper016();
        }
        else if ( (LA11_0=='C') ) {
            alt11 = mTokensHelper017();
        }
        else if ( (LA11_0=='=') ) {
            alt11 = mTokensHelper018();
        }
        else if ( (LA11_0=='<') ) {
            alt11 = mTokensHelper019();
        }
        else if ( (LA11_0=='>') ) {
            alt11 = mTokensHelper020();
        }
        else if ( (LA11_0=='*') ) {
            alt11 = mTokensHelper021();
        }
        else if ( (LA11_0=='/') ) {
            alt11 = mTokensHelper022();
        }
        else if ( (LA11_0=='n') ) {
            alt11 = mTokensHelper023();
        }
        else if ( (LA11_0==':') ) {
            alt11 = mTokensHelper024();
        }
        else if ( (LA11_0=='(') ) {
            alt11 = mTokensHelper025();
        }
        else if ( (LA11_0==')') ) {
            alt11 = mTokensHelper026();
        }
        else if ( (LA11_0==',') ) {
            alt11 = mTokensHelper027();
        }
        else if ( (LA11_0=='p') ) {
            alt11 = mTokensHelper028();
        }
        else if ( (LA11_0=='?') ) {
            alt11 = mTokensHelper029();
        }
        else if ( (LA11_0=='{') ) {
            alt11 = mTokensHelper030();
        }
        else if ( (LA11_0=='}') ) {
            alt11 = mTokensHelper031();
        }
        else if ( (LA11_0=='T') ) {
            alt11 = mTokensHelper032();
        }
        else if ( (LA11_0=='@') ) {
            alt11 = mTokensHelper033();
        }
        else if ( (LA11_0=='|') ) {
            alt11 = mTokensHelper034();
        }
        else if ( (LA11_0==';') ) {
            alt11 = mTokensHelper035();
        }
        else if ( (LA11_0=='[') ) {
            alt11 = mTokensHelper036();
        }
        else if ( (LA11_0==']') ) {
            alt11 = mTokensHelper037();
        }
        else if ( (LA11_0=='s') ) {
            alt11 = mTokensHelper038();
        }
        else if ( (LA11_0=='t') ) {
            alt11 = mTokensHelper039();
        }
        else if ( (LA11_0=='l') ) {
            alt11 = mTokensHelper040();
        }
        else if ( (LA11_0=='f') ) {
            alt11 = mTokensHelper041();
        }
        else if ( (LA11_0=='x') ) {
            alt11 = mTokensHelper042();
        }
        else if ( (LA11_0=='o') ) {
            alt11 = mTokensHelper043();
        }
        else if ( (LA11_0=='a') ) {
            alt11 = mTokensHelper044();
        }
        else if ( (LA11_0=='\"') ) {
            alt11 = mTokensHelper045();
        }
        else if ( (LA11_0=='\'') ) {
            alt11 = mTokensHelper046();
        }
        else if ( (LA11_0=='_') ) {
            alt11 = mTokensHelper047();
        }
        else if ( (LA11_0=='A'||LA11_0=='D'||(LA11_0>='F' && LA11_0<='H')||(LA11_0>='J' && LA11_0<='N')||(LA11_0>='P' && LA11_0<='Q')||(LA11_0>='V' && LA11_0<='Z')||(LA11_0>='g' && LA11_0<='h')||(LA11_0>='j' && LA11_0<='k')||LA11_0=='m'||(LA11_0>='q' && LA11_0<='r')||(LA11_0>='u' && LA11_0<='w')||(LA11_0>='y' && LA11_0<='z')) ) {
            alt11 = mTokensHelper048();
        }
        else if ( ((LA11_0>='0' && LA11_0<='9')) ) {
            alt11 = mTokensHelper049();
        }
        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
            alt11 = mTokensHelper050();
        }
        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||LA11_0=='!'||(LA11_0>='#' && LA11_0<='&')||LA11_0=='\\'||LA11_0=='`'||(LA11_0>='~' && LA11_0<='\uFFFE')) ) {
            alt11 = mTokensHelper051();
        }
        else {
            alt11 = mTokensHelper052();
        }
        switch (alt11) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:66: T26
                {
                mT26(); 

                }
                break;
            case 16 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:70: T27
                {
                mT27(); 

                }
                break;
            case 17 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:74: T28
                {
                mT28(); 

                }
                break;
            case 18 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:78: T29
                {
                mT29(); 

                }
                break;
            case 19 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:82: T30
                {
                mT30(); 

                }
                break;
            case 20 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:86: T31
                {
                mT31(); 

                }
                break;
            case 21 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:90: T32
                {
                mT32(); 

                }
                break;
            case 22 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:94: T33
                {
                mT33(); 

                }
                break;
            case 23 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:98: T34
                {
                mT34(); 

                }
                break;
            case 24 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:102: T35
                {
                mT35(); 

                }
                break;
            case 25 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:106: T36
                {
                mT36(); 

                }
                break;
            case 26 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:110: T37
                {
                mT37(); 

                }
                break;
            case 27 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:114: T38
                {
                mT38(); 

                }
                break;
            case 28 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:118: T39
                {
                mT39(); 

                }
                break;
            case 29 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:122: T40
                {
                mT40(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:126: T41
                {
                mT41(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:130: T42
                {
                mT42(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:134: T43
                {
                mT43(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:138: T44
                {
                mT44(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:142: T45
                {
                mT45(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:146: T46
                {
                mT46(); 

                }
                break;
            case 36 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:150: T47
                {
                mT47(); 

                }
                break;
            case 37 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:154: T48
                {
                mT48(); 

                }
                break;
            case 38 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:158: T49
                {
                mT49(); 

                }
                break;
            case 39 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:162: T50
                {
                mT50(); 

                }
                break;
            case 40 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:166: T51
                {
                mT51(); 

                }
                break;
            case 41 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:170: T52
                {
                mT52(); 

                }
                break;
            case 42 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:174: T53
                {
                mT53(); 

                }
                break;
            case 43 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:178: T54
                {
                mT54(); 

                }
                break;
            case 44 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:182: T55
                {
                mT55(); 

                }
                break;
            case 45 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:186: T56
                {
                mT56(); 

                }
                break;
            case 46 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:190: T57
                {
                mT57(); 

                }
                break;
            case 47 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:194: T58
                {
                mT58(); 

                }
                break;
            case 48 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:198: T59
                {
                mT59(); 

                }
                break;
            case 49 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:202: T60
                {
                mT60(); 

                }
                break;
            case 50 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:206: T61
                {
                mT61(); 

                }
                break;
            case 51 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:210: T62
                {
                mT62(); 

                }
                break;
            case 52 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:214: T63
                {
                mT63(); 

                }
                break;
            case 53 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:218: T64
                {
                mT64(); 

                }
                break;
            case 54 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:222: T65
                {
                mT65(); 

                }
                break;
            case 55 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:226: T66
                {
                mT66(); 

                }
                break;
            case 56 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:230: T67
                {
                mT67(); 

                }
                break;
            case 57 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:234: T68
                {
                mT68(); 

                }
                break;
            case 58 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:238: T69
                {
                mT69(); 

                }
                break;
            case 59 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:242: T70
                {
                mT70(); 

                }
                break;
            case 60 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:246: T71
                {
                mT71(); 

                }
                break;
            case 61 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:250: T72
                {
                mT72(); 

                }
                break;
            case 62 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:254: T73
                {
                mT73(); 

                }
                break;
            case 63 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:258: T74
                {
                mT74(); 

                }
                break;
            case 64 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:262: T75
                {
                mT75(); 

                }
                break;
            case 65 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:266: T76
                {
                mT76(); 

                }
                break;
            case 66 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:270: T77
                {
                mT77(); 

                }
                break;
            case 67 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:274: T78
                {
                mT78(); 

                }
                break;
            case 68 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:278: T79
                {
                mT79(); 

                }
                break;
            case 69 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:282: T80
                {
                mT80(); 

                }
                break;
            case 70 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:286: T81
                {
                mT81(); 

                }
                break;
            case 71 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:290: T82
                {
                mT82(); 

                }
                break;
            case 72 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:294: T83
                {
                mT83(); 

                }
                break;
            case 73 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:298: T84
                {
                mT84(); 

                }
                break;
            case 74 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:302: T85
                {
                mT85(); 

                }
                break;
            case 75 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:306: RULE_DOUBLE_QUOTED_STRING
                {
                mRULE_DOUBLE_QUOTED_STRING(); 

                }
                break;
            case 76 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:332: RULE_SINGLE_QUOTED_STRING
                {
                mRULE_SINGLE_QUOTED_STRING(); 

                }
                break;
            case 77 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:358: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 78 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:366: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 79 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:375: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 80 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:391: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 81 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:407: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 82 :
                // ../org.eclipse.ocl.examples.xtext.completeocl.ui/src-gen/org/eclipse/ocl/examples/xtext/completeocl/ui/contentassist/antlr/internal/InternalCompleteOCL.g:1:415: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA11_1 = input.LA(2);

        if ( (LA11_1=='o') ) {
            int LA11_52 = input.LA(3);

            if ( (LA11_52=='d') ) {
                int LA11_122 = input.LA(4);

                if ( (LA11_122=='y') ) {
                    int LA11_159 = input.LA(5);

                    if ( ((LA11_159>='0' && LA11_159<='9')||(LA11_159>='A' && LA11_159<='Z')||LA11_159=='_'||(LA11_159>='a' && LA11_159<='z')) ) {
                        return 77;
                    }
                    else {
                        return 1;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper002() throws RecognitionException {
        int LA11_2 = input.LA(2);

        if ( (LA11_2=='o') ) {
            int LA11_54 = input.LA(3);

            if ( (LA11_54=='n') ) {
                int LA11_123 = input.LA(4);

                if ( (LA11_123=='t') ) {
                    int LA11_160 = input.LA(5);

                    if ( (LA11_160=='e') ) {
                        int LA11_201 = input.LA(6);

                        if ( (LA11_201=='x') ) {
                            int LA11_232 = input.LA(7);

                            if ( (LA11_232=='t') ) {
                                int LA11_255 = input.LA(8);

                                if ( ((LA11_255>='0' && LA11_255<='9')||(LA11_255>='A' && LA11_255<='Z')||LA11_255=='_'||(LA11_255>='a' && LA11_255<='z')) ) {
                                    return 77;
                                }
                                else {
                                    return 2;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper003() throws RecognitionException {
        int LA11_3 = input.LA(2);

        if ( (LA11_3=='e') ) {
            switch ( input.LA(3) ) {
            case 'f':
                {
                int LA11_124 = input.LA(4);

                if ( ((LA11_124>='0' && LA11_124<='9')||(LA11_124>='A' && LA11_124<='Z')||LA11_124=='_'||(LA11_124>='a' && LA11_124<='z')) ) {
                    return 77;
                }
                else {
                    return 3;}
                }
            case 'r':
                {
                int LA11_125 = input.LA(4);

                if ( (LA11_125=='i') ) {
                    int LA11_162 = input.LA(5);

                    if ( (LA11_162=='v') ) {
                        int LA11_202 = input.LA(6);

                        if ( (LA11_202=='e') ) {
                            int LA11_233 = input.LA(7);

                            if ( ((LA11_233>='0' && LA11_233<='9')||(LA11_233>='A' && LA11_233<='Z')||LA11_233=='_'||(LA11_233>='a' && LA11_233<='z')) ) {
                                return 77;
                            }
                            else {
                                return 4;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
                }
            default:
                return 77;}

        }
        else {
            return 77;}
    }

    private int mTokensHelper004() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'n':
            {
            switch ( input.LA(3) ) {
            case 'i':
                {
                int LA11_126 = input.LA(4);

                if ( (LA11_126=='t') ) {
                    int LA11_163 = input.LA(5);

                    if ( ((LA11_163>='0' && LA11_163<='9')||(LA11_163>='A' && LA11_163<='Z')||LA11_163=='_'||(LA11_163>='a' && LA11_163<='z')) ) {
                        return 77;
                    }
                    else {
                        return 6;}
                }
                else {
                    return 77;}
                }
            case 'v':
                {
                switch ( input.LA(4) ) {
                case 'a':
                    {
                    int LA11_164 = input.LA(5);

                    if ( (LA11_164=='l') ) {
                        int LA11_204 = input.LA(6);

                        if ( (LA11_204=='i') ) {
                            int LA11_234 = input.LA(7);

                            if ( (LA11_234=='d') ) {
                                int LA11_257 = input.LA(8);

                                if ( ((LA11_257>='0' && LA11_257<='9')||(LA11_257>='A' && LA11_257<='Z')||LA11_257=='_'||(LA11_257>='a' && LA11_257<='z')) ) {
                                    return 77;
                                }
                                else {
                                    return 54;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
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
                    return 77;
                    }
                default:
                    return 7;}

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
                return 77;
                }
            default:
                return 67;}

            }
        case 'm':
            {
            int LA11_57 = input.LA(3);

            if ( (LA11_57=='p') ) {
                switch ( input.LA(4) ) {
                case 'l':
                    {
                    int LA11_166 = input.LA(5);

                    if ( (LA11_166=='i') ) {
                        int LA11_205 = input.LA(6);

                        if ( (LA11_205=='e') ) {
                            int LA11_235 = input.LA(7);

                            if ( (LA11_235=='s') ) {
                                int LA11_258 = input.LA(8);

                                if ( ((LA11_258>='0' && LA11_258<='9')||(LA11_258>='A' && LA11_258<='Z')||LA11_258=='_'||(LA11_258>='a' && LA11_258<='z')) ) {
                                    return 77;
                                }
                                else {
                                    return 71;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                case 'o':
                    {
                    int LA11_167 = input.LA(5);

                    if ( (LA11_167=='r') ) {
                        int LA11_206 = input.LA(6);

                        if ( (LA11_206=='t') ) {
                            int LA11_236 = input.LA(7);

                            if ( ((LA11_236>='0' && LA11_236<='9')||(LA11_236>='A' && LA11_236<='Z')||LA11_236=='_'||(LA11_236>='a' && LA11_236<='z')) ) {
                                return 77;
                            }
                            else {
                                return 5;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                default:
                    return 77;}

            }
            else {
                return 77;}
            }
        case 'f':
            {
            int LA11_58 = input.LA(3);

            if ( ((LA11_58>='0' && LA11_58<='9')||(LA11_58>='A' && LA11_58<='Z')||LA11_58=='_'||(LA11_58>='a' && LA11_58<='z')) ) {
                return 77;
            }
            else {
                return 62;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper005() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA11_59 = input.LA(3);

            if ( (LA11_59=='g') ) {
                int LA11_131 = input.LA(4);

                if ( ((LA11_131>='0' && LA11_131<='9')||(LA11_131>='A' && LA11_131<='Z')||LA11_131=='_'||(LA11_131>='a' && LA11_131<='z')) ) {
                    return 77;
                }
                else {
                    return 27;}
            }
            else {
                return 77;}
            }
        case 'o':
            {
            int LA11_60 = input.LA(3);

            if ( (LA11_60=='o') ) {
                int LA11_132 = input.LA(4);

                if ( (LA11_132=='l') ) {
                    int LA11_169 = input.LA(5);

                    if ( (LA11_169=='e') ) {
                        int LA11_207 = input.LA(6);

                        if ( (LA11_207=='a') ) {
                            int LA11_237 = input.LA(7);

                            if ( (LA11_237=='n') ) {
                                int LA11_260 = input.LA(8);

                                if ( ((LA11_260>='0' && LA11_260<='9')||(LA11_260>='A' && LA11_260<='Z')||LA11_260=='_'||(LA11_260>='a' && LA11_260<='z')) ) {
                                    return 77;
                                }
                                else {
                                    return 8;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper006() throws RecognitionException {
        int LA11_6 = input.LA(2);

        if ( (LA11_6=='n') ) {
            int LA11_61 = input.LA(3);

            if ( (LA11_61=='t') ) {
                int LA11_133 = input.LA(4);

                if ( (LA11_133=='e') ) {
                    int LA11_170 = input.LA(5);

                    if ( (LA11_170=='g') ) {
                        int LA11_208 = input.LA(6);

                        if ( (LA11_208=='e') ) {
                            int LA11_238 = input.LA(7);

                            if ( (LA11_238=='r') ) {
                                int LA11_261 = input.LA(8);

                                if ( ((LA11_261>='0' && LA11_261<='9')||(LA11_261>='A' && LA11_261<='Z')||LA11_261=='_'||(LA11_261>='a' && LA11_261<='z')) ) {
                                    return 77;
                                }
                                else {
                                    return 9;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper007() throws RecognitionException {
        int LA11_7 = input.LA(2);

        if ( (LA11_7=='e') ) {
            int LA11_62 = input.LA(3);

            if ( (LA11_62=='a') ) {
                int LA11_134 = input.LA(4);

                if ( (LA11_134=='l') ) {
                    int LA11_171 = input.LA(5);

                    if ( ((LA11_171>='0' && LA11_171<='9')||(LA11_171>='A' && LA11_171<='Z')||LA11_171=='_'||(LA11_171>='a' && LA11_171<='z')) ) {
                        return 77;
                    }
                    else {
                        return 10;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper008() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            switch ( input.LA(3) ) {
            case 't':
                {
                int LA11_135 = input.LA(4);

                if ( ((LA11_135>='0' && LA11_135<='9')||(LA11_135>='A' && LA11_135<='Z')||LA11_135=='_'||(LA11_135>='a' && LA11_135<='z')) ) {
                    return 77;
                }
                else {
                    return 26;}
                }
            case 'q':
                {
                int LA11_136 = input.LA(4);

                if ( (LA11_136=='u') ) {
                    int LA11_173 = input.LA(5);

                    if ( (LA11_173=='e') ) {
                        int LA11_210 = input.LA(6);

                        if ( (LA11_210=='n') ) {
                            int LA11_239 = input.LA(7);

                            if ( (LA11_239=='c') ) {
                                int LA11_262 = input.LA(8);

                                if ( (LA11_262=='e') ) {
                                    int LA11_280 = input.LA(9);

                                    if ( ((LA11_280>='0' && LA11_280<='9')||(LA11_280>='A' && LA11_280<='Z')||LA11_280=='_'||(LA11_280>='a' && LA11_280<='z')) ) {
                                        return 77;
                                    }
                                    else {
                                        return 28;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
                }
            default:
                return 77;}

            }
        case 't':
            {
            int LA11_64 = input.LA(3);

            if ( (LA11_64=='r') ) {
                int LA11_137 = input.LA(4);

                if ( (LA11_137=='i') ) {
                    int LA11_174 = input.LA(5);

                    if ( (LA11_174=='n') ) {
                        int LA11_211 = input.LA(6);

                        if ( (LA11_211=='g') ) {
                            int LA11_240 = input.LA(7);

                            if ( ((LA11_240>='0' && LA11_240<='9')||(LA11_240>='A' && LA11_240<='Z')||LA11_240=='_'||(LA11_240>='a' && LA11_240<='z')) ) {
                                return 77;
                            }
                            else {
                                return 11;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper009() throws RecognitionException {
        int LA11_9 = input.LA(2);

        if ( (LA11_9=='n') ) {
            int LA11_65 = input.LA(3);

            if ( (LA11_65=='l') ) {
                int LA11_138 = input.LA(4);

                if ( (LA11_138=='i') ) {
                    int LA11_175 = input.LA(5);

                    if ( (LA11_175=='m') ) {
                        int LA11_212 = input.LA(6);

                        if ( (LA11_212=='i') ) {
                            int LA11_241 = input.LA(7);

                            if ( (LA11_241=='t') ) {
                                int LA11_264 = input.LA(8);

                                if ( (LA11_264=='e') ) {
                                    int LA11_281 = input.LA(9);

                                    if ( (LA11_281=='d') ) {
                                        int LA11_291 = input.LA(10);

                                        if ( (LA11_291=='N') ) {
                                            int LA11_298 = input.LA(11);

                                            if ( (LA11_298=='a') ) {
                                                int LA11_304 = input.LA(12);

                                                if ( (LA11_304=='t') ) {
                                                    int LA11_310 = input.LA(13);

                                                    if ( (LA11_310=='u') ) {
                                                        int LA11_311 = input.LA(14);

                                                        if ( (LA11_311=='r') ) {
                                                            int LA11_312 = input.LA(15);

                                                            if ( (LA11_312=='a') ) {
                                                                int LA11_313 = input.LA(16);

                                                                if ( (LA11_313=='l') ) {
                                                                    int LA11_314 = input.LA(17);

                                                                    if ( ((LA11_314>='0' && LA11_314<='9')||(LA11_314>='A' && LA11_314<='Z')||LA11_314=='_'||(LA11_314>='a' && LA11_314<='z')) ) {
                                                                        return 77;
                                                                    }
                                                                    else {
                                                                        return 12;}
                                                                }
                                                                else {
                                                                    return 77;}
                                                            }
                                                            else {
                                                                return 77;}
                                                        }
                                                        else {
                                                            return 77;}
                                                    }
                                                    else {
                                                        return 77;}
                                                }
                                                else {
                                                    return 77;}
                                            }
                                            else {
                                                return 77;}
                                        }
                                        else {
                                            return 77;}
                                    }
                                    else {
                                        return 77;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper010() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'c':
            {
            int LA11_66 = input.LA(3);

            if ( (LA11_66=='l') ) {
                switch ( input.LA(4) ) {
                case 'M':
                    {
                    int LA11_176 = input.LA(5);

                    if ( (LA11_176=='e') ) {
                        int LA11_213 = input.LA(6);

                        if ( (LA11_213=='s') ) {
                            int LA11_242 = input.LA(7);

                            if ( (LA11_242=='s') ) {
                                int LA11_265 = input.LA(8);

                                if ( (LA11_265=='a') ) {
                                    int LA11_282 = input.LA(9);

                                    if ( (LA11_282=='g') ) {
                                        int LA11_292 = input.LA(10);

                                        if ( (LA11_292=='e') ) {
                                            int LA11_299 = input.LA(11);

                                            if ( ((LA11_299>='0' && LA11_299<='9')||(LA11_299>='A' && LA11_299<='Z')||LA11_299=='_'||(LA11_299>='a' && LA11_299<='z')) ) {
                                                return 77;
                                            }
                                            else {
                                                return 15;}
                                        }
                                        else {
                                            return 77;}
                                    }
                                    else {
                                        return 77;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                case 'I':
                    {
                    int LA11_177 = input.LA(5);

                    if ( (LA11_177=='n') ) {
                        int LA11_214 = input.LA(6);

                        if ( (LA11_214=='v') ) {
                            int LA11_243 = input.LA(7);

                            if ( (LA11_243=='a') ) {
                                int LA11_266 = input.LA(8);

                                if ( (LA11_266=='l') ) {
                                    int LA11_283 = input.LA(9);

                                    if ( (LA11_283=='i') ) {
                                        int LA11_293 = input.LA(10);

                                        if ( (LA11_293=='d') ) {
                                            int LA11_300 = input.LA(11);

                                            if ( ((LA11_300>='0' && LA11_300<='9')||(LA11_300>='A' && LA11_300<='Z')||LA11_300=='_'||(LA11_300>='a' && LA11_300<='z')) ) {
                                                return 77;
                                            }
                                            else {
                                                return 14;}
                                        }
                                        else {
                                            return 77;}
                                    }
                                    else {
                                        return 77;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                case 'A':
                    {
                    int LA11_178 = input.LA(5);

                    if ( (LA11_178=='n') ) {
                        int LA11_215 = input.LA(6);

                        if ( (LA11_215=='y') ) {
                            int LA11_244 = input.LA(7);

                            if ( ((LA11_244>='0' && LA11_244<='9')||(LA11_244>='A' && LA11_244<='Z')||LA11_244=='_'||(LA11_244>='a' && LA11_244<='z')) ) {
                                return 77;
                            }
                            else {
                                return 13;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                case 'V':
                    {
                    int LA11_179 = input.LA(5);

                    if ( (LA11_179=='o') ) {
                        int LA11_216 = input.LA(6);

                        if ( (LA11_216=='i') ) {
                            int LA11_245 = input.LA(7);

                            if ( (LA11_245=='d') ) {
                                int LA11_268 = input.LA(8);

                                if ( ((LA11_268>='0' && LA11_268<='9')||(LA11_268>='A' && LA11_268<='Z')||LA11_268=='_'||(LA11_268>='a' && LA11_268<='z')) ) {
                                    return 77;
                                }
                                else {
                                    return 17;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                case 'S':
                    {
                    int LA11_180 = input.LA(5);

                    if ( (LA11_180=='t') ) {
                        int LA11_217 = input.LA(6);

                        if ( (LA11_217=='a') ) {
                            int LA11_246 = input.LA(7);

                            if ( (LA11_246=='t') ) {
                                int LA11_269 = input.LA(8);

                                if ( (LA11_269=='e') ) {
                                    int LA11_285 = input.LA(9);

                                    if ( ((LA11_285>='0' && LA11_285<='9')||(LA11_285>='A' && LA11_285<='Z')||LA11_285=='_'||(LA11_285>='a' && LA11_285<='z')) ) {
                                        return 77;
                                    }
                                    else {
                                        return 16;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                default:
                    return 77;}

            }
            else {
                return 77;}
            }
        case 'r':
            {
            int LA11_67 = input.LA(3);

            if ( (LA11_67=='d') ) {
                int LA11_140 = input.LA(4);

                if ( (LA11_140=='e') ) {
                    int LA11_181 = input.LA(5);

                    if ( (LA11_181=='r') ) {
                        int LA11_218 = input.LA(6);

                        if ( (LA11_218=='e') ) {
                            int LA11_247 = input.LA(7);

                            if ( (LA11_247=='d') ) {
                                int LA11_270 = input.LA(8);

                                if ( (LA11_270=='S') ) {
                                    int LA11_286 = input.LA(9);

                                    if ( (LA11_286=='e') ) {
                                        int LA11_295 = input.LA(10);

                                        if ( (LA11_295=='t') ) {
                                            int LA11_301 = input.LA(11);

                                            if ( ((LA11_301>='0' && LA11_301<='9')||(LA11_301>='A' && LA11_301<='Z')||LA11_301=='_'||(LA11_301>='a' && LA11_301<='z')) ) {
                                                return 77;
                                            }
                                            else {
                                                return 30;}
                                        }
                                        else {
                                            return 77;}
                                    }
                                    else {
                                        return 77;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper011() throws RecognitionException {
        int LA11_11 = input.LA(2);

        if ( (LA11_11=='.') ) {
            return 52;
        }
        else {
            return 18;}
    }

    private int mTokensHelper012() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '-':
            {
            return 80;
            }
        case '>':
            {
            return 19;
            }
        default:
            return 25;}

    }

    private int mTokensHelper013() throws RecognitionException {
        int LA11_13 = input.LA(2);

        if ( (LA11_13=='^') ) {
            return 20;
        }
        else {
            return 21;}
    }

    private int mTokensHelper014() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'n':
            {
            int LA11_75 = input.LA(3);

            if ( (LA11_75=='d') ) {
                switch ( input.LA(4) ) {
                case 'p':
                    {
                    int LA11_182 = input.LA(5);

                    if ( (LA11_182=='a') ) {
                        int LA11_219 = input.LA(6);

                        if ( (LA11_219=='c') ) {
                            int LA11_248 = input.LA(7);

                            if ( (LA11_248=='k') ) {
                                int LA11_271 = input.LA(8);

                                if ( (LA11_271=='a') ) {
                                    int LA11_287 = input.LA(9);

                                    if ( (LA11_287=='g') ) {
                                        int LA11_296 = input.LA(10);

                                        if ( (LA11_296=='e') ) {
                                            int LA11_302 = input.LA(11);

                                            if ( ((LA11_302>='0' && LA11_302<='9')||(LA11_302>='A' && LA11_302<='Z')||LA11_302=='_'||(LA11_302>='a' && LA11_302<='z')) ) {
                                                return 77;
                                            }
                                            else {
                                                return 45;}
                                        }
                                        else {
                                            return 77;}
                                    }
                                    else {
                                        return 77;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                    }
                case 'i':
                    {
                    int LA11_183 = input.LA(5);

                    if ( (LA11_183=='f') ) {
                        int LA11_220 = input.LA(6);

                        if ( ((LA11_220>='0' && LA11_220<='9')||(LA11_220>='A' && LA11_220<='Z')||LA11_220=='_'||(LA11_220>='a' && LA11_220<='z')) ) {
                            return 77;
                        }
                        else {
                            return 65;}
                    }
                    else {
                        return 77;}
                    }
                default:
                    return 77;}

            }
            else {
                return 77;}
            }
        case 'l':
            {
            int LA11_76 = input.LA(3);

            if ( (LA11_76=='s') ) {
                int LA11_142 = input.LA(4);

                if ( (LA11_142=='e') ) {
                    int LA11_184 = input.LA(5);

                    if ( ((LA11_184>='0' && LA11_184<='9')||(LA11_184>='A' && LA11_184<='Z')||LA11_184=='_'||(LA11_184>='a' && LA11_184<='z')) ) {
                        return 77;
                    }
                    else {
                        return 64;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
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
            return 77;
            }
        default:
            return 22;}

    }

    private int mTokensHelper015() throws RecognitionException {
        int LA11_15 = input.LA(2);

        if ( ((LA11_15>='0' && LA11_15<='9')||(LA11_15>='A' && LA11_15<='Z')||LA11_15=='_'||(LA11_15>='a' && LA11_15<='z')) ) {
            return 77;
        }
        else {
            return 23;}
    }

    private int mTokensHelper016() throws RecognitionException {
        return 24;
    }

    private int mTokensHelper017() throws RecognitionException {
        int LA11_17 = input.LA(2);

        if ( (LA11_17=='o') ) {
            int LA11_80 = input.LA(3);

            if ( (LA11_80=='l') ) {
                int LA11_143 = input.LA(4);

                if ( (LA11_143=='l') ) {
                    int LA11_185 = input.LA(5);

                    if ( (LA11_185=='e') ) {
                        int LA11_222 = input.LA(6);

                        if ( (LA11_222=='c') ) {
                            int LA11_250 = input.LA(7);

                            if ( (LA11_250=='t') ) {
                                int LA11_272 = input.LA(8);

                                if ( (LA11_272=='i') ) {
                                    int LA11_288 = input.LA(9);

                                    if ( (LA11_288=='o') ) {
                                        int LA11_297 = input.LA(10);

                                        if ( (LA11_297=='n') ) {
                                            int LA11_303 = input.LA(11);

                                            if ( ((LA11_303>='0' && LA11_303<='9')||(LA11_303>='A' && LA11_303<='Z')||LA11_303=='_'||(LA11_303>='a' && LA11_303<='z')) ) {
                                                return 77;
                                            }
                                            else {
                                                return 29;}
                                        }
                                        else {
                                            return 77;}
                                    }
                                    else {
                                        return 77;}
                                }
                                else {
                                    return 77;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper018() throws RecognitionException {
        return 31;
    }

    private int mTokensHelper019() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '>':
            {
            return 32;
            }
        case '=':
            {
            return 36;
            }
        default:
            return 34;}

    }

    private int mTokensHelper020() throws RecognitionException {
        int LA11_20 = input.LA(2);

        if ( (LA11_20=='=') ) {
            return 35;
        }
        else {
            return 33;}
    }

    private int mTokensHelper021() throws RecognitionException {
        return 37;
    }

    private int mTokensHelper022() throws RecognitionException {
        int LA11_22 = input.LA(2);

        if ( (LA11_22=='*') ) {
            return 79;
        }
        else {
            return 38;}
    }

    private int mTokensHelper023() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'o':
            {
            int LA11_90 = input.LA(3);

            if ( (LA11_90=='t') ) {
                int LA11_144 = input.LA(4);

                if ( ((LA11_144>='0' && LA11_144<='9')||(LA11_144>='A' && LA11_144<='Z')||LA11_144=='_'||(LA11_144>='a' && LA11_144<='z')) ) {
                    return 77;
                }
                else {
                    return 39;}
            }
            else {
                return 77;}
            }
        case 'u':
            {
            int LA11_91 = input.LA(3);

            if ( (LA11_91=='l') ) {
                int LA11_145 = input.LA(4);

                if ( (LA11_145=='l') ) {
                    int LA11_187 = input.LA(5);

                    if ( ((LA11_187>='0' && LA11_187<='9')||(LA11_187>='A' && LA11_187<='Z')||LA11_187=='_'||(LA11_187>='a' && LA11_187<='z')) ) {
                        return 77;
                    }
                    else {
                        return 55;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper024() throws RecognitionException {
        int LA11_24 = input.LA(2);

        if ( (LA11_24==':') ) {
            return 48;
        }
        else {
            return 40;}
    }

    private int mTokensHelper025() throws RecognitionException {
        return 41;
    }

    private int mTokensHelper026() throws RecognitionException {
        return 42;
    }

    private int mTokensHelper027() throws RecognitionException {
        return 43;
    }

    private int mTokensHelper028() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA11_97 = input.LA(3);

            if ( (LA11_97=='c') ) {
                int LA11_146 = input.LA(4);

                if ( (LA11_146=='k') ) {
                    int LA11_188 = input.LA(5);

                    if ( (LA11_188=='a') ) {
                        int LA11_224 = input.LA(6);

                        if ( (LA11_224=='g') ) {
                            int LA11_251 = input.LA(7);

                            if ( (LA11_251=='e') ) {
                                int LA11_273 = input.LA(8);

                                if ( ((LA11_273>='0' && LA11_273<='9')||(LA11_273>='A' && LA11_273<='Z')||LA11_273=='_'||(LA11_273>='a' && LA11_273<='z')) ) {
                                    return 77;
                                }
                                else {
                                    return 44;}
                            }
                            else {
                                return 77;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        case 'r':
            {
            int LA11_98 = input.LA(3);

            if ( (LA11_98=='e') ) {
                int LA11_147 = input.LA(4);

                if ( ((LA11_147>='0' && LA11_147<='9')||(LA11_147>='A' && LA11_147<='Z')||LA11_147=='_'||(LA11_147>='a' && LA11_147<='z')) ) {
                    return 77;
                }
                else {
                    return 47;}
            }
            else {
                return 77;}
            }
        case 'o':
            {
            int LA11_99 = input.LA(3);

            if ( (LA11_99=='s') ) {
                int LA11_148 = input.LA(4);

                if ( (LA11_148=='t') ) {
                    int LA11_190 = input.LA(5);

                    if ( ((LA11_190>='0' && LA11_190<='9')||(LA11_190>='A' && LA11_190<='Z')||LA11_190=='_'||(LA11_190>='a' && LA11_190<='z')) ) {
                        return 77;
                    }
                    else {
                        return 46;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper029() throws RecognitionException {
        return 49;
    }

    private int mTokensHelper030() throws RecognitionException {
        return 50;
    }

    private int mTokensHelper031() throws RecognitionException {
        return 51;
    }

    private int mTokensHelper032() throws RecognitionException {
        int LA11_32 = input.LA(2);

        if ( (LA11_32=='u') ) {
            int LA11_103 = input.LA(3);

            if ( (LA11_103=='p') ) {
                int LA11_149 = input.LA(4);

                if ( (LA11_149=='l') ) {
                    int LA11_191 = input.LA(5);

                    if ( (LA11_191=='e') ) {
                        int LA11_226 = input.LA(6);

                        if ( ((LA11_226>='0' && LA11_226<='9')||(LA11_226>='A' && LA11_226<='Z')||LA11_226=='_'||(LA11_226>='a' && LA11_226<='z')) ) {
                            return 77;
                        }
                        else {
                            return 53;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper033() throws RecognitionException {
        return 56;
    }

    private int mTokensHelper034() throws RecognitionException {
        return 57;
    }

    private int mTokensHelper035() throws RecognitionException {
        return 58;
    }

    private int mTokensHelper036() throws RecognitionException {
        return 59;
    }

    private int mTokensHelper037() throws RecognitionException {
        return 60;
    }

    private int mTokensHelper038() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            int LA11_109 = input.LA(3);

            if ( (LA11_109=='l') ) {
                int LA11_150 = input.LA(4);

                if ( (LA11_150=='f') ) {
                    int LA11_192 = input.LA(5);

                    if ( ((LA11_192>='0' && LA11_192<='9')||(LA11_192>='A' && LA11_192<='Z')||LA11_192=='_'||(LA11_192>='a' && LA11_192<='z')) ) {
                        return 77;
                    }
                    else {
                        return 61;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        case 't':
            {
            int LA11_110 = input.LA(3);

            if ( (LA11_110=='a') ) {
                int LA11_151 = input.LA(4);

                if ( (LA11_151=='t') ) {
                    int LA11_193 = input.LA(5);

                    if ( (LA11_193=='i') ) {
                        int LA11_228 = input.LA(6);

                        if ( (LA11_228=='c') ) {
                            int LA11_253 = input.LA(7);

                            if ( ((LA11_253>='0' && LA11_253<='9')||(LA11_253>='A' && LA11_253<='Z')||LA11_253=='_'||(LA11_253>='a' && LA11_253<='z')) ) {
                                return 77;
                            }
                            else {
                                return 68;}
                        }
                        else {
                            return 77;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper039() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'h':
            {
            int LA11_111 = input.LA(3);

            if ( (LA11_111=='e') ) {
                int LA11_152 = input.LA(4);

                if ( (LA11_152=='n') ) {
                    int LA11_194 = input.LA(5);

                    if ( ((LA11_194>='0' && LA11_194<='9')||(LA11_194>='A' && LA11_194<='Z')||LA11_194=='_'||(LA11_194>='a' && LA11_194<='z')) ) {
                        return 77;
                    }
                    else {
                        return 63;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        case 'r':
            {
            int LA11_112 = input.LA(3);

            if ( (LA11_112=='u') ) {
                int LA11_153 = input.LA(4);

                if ( (LA11_153=='e') ) {
                    int LA11_195 = input.LA(5);

                    if ( ((LA11_195>='0' && LA11_195<='9')||(LA11_195>='A' && LA11_195<='Z')||LA11_195=='_'||(LA11_195>='a' && LA11_195<='z')) ) {
                        return 77;
                    }
                    else {
                        return 69;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
            }
        default:
            return 77;}

    }

    private int mTokensHelper040() throws RecognitionException {
        int LA11_40 = input.LA(2);

        if ( (LA11_40=='e') ) {
            int LA11_113 = input.LA(3);

            if ( (LA11_113=='t') ) {
                int LA11_154 = input.LA(4);

                if ( ((LA11_154>='0' && LA11_154<='9')||(LA11_154>='A' && LA11_154<='Z')||LA11_154=='_'||(LA11_154>='a' && LA11_154<='z')) ) {
                    return 77;
                }
                else {
                    return 66;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper041() throws RecognitionException {
        int LA11_41 = input.LA(2);

        if ( (LA11_41=='a') ) {
            int LA11_114 = input.LA(3);

            if ( (LA11_114=='l') ) {
                int LA11_155 = input.LA(4);

                if ( (LA11_155=='s') ) {
                    int LA11_197 = input.LA(5);

                    if ( (LA11_197=='e') ) {
                        int LA11_231 = input.LA(6);

                        if ( ((LA11_231>='0' && LA11_231<='9')||(LA11_231>='A' && LA11_231<='Z')||LA11_231=='_'||(LA11_231>='a' && LA11_231<='z')) ) {
                            return 77;
                        }
                        else {
                            return 70;}
                    }
                    else {
                        return 77;}
                }
                else {
                    return 77;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper042() throws RecognitionException {
        int LA11_42 = input.LA(2);

        if ( (LA11_42=='o') ) {
            int LA11_115 = input.LA(3);

            if ( (LA11_115=='r') ) {
                int LA11_156 = input.LA(4);

                if ( ((LA11_156>='0' && LA11_156<='9')||(LA11_156>='A' && LA11_156<='Z')||LA11_156=='_'||(LA11_156>='a' && LA11_156<='z')) ) {
                    return 77;
                }
                else {
                    return 72;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper043() throws RecognitionException {
        int LA11_43 = input.LA(2);

        if ( (LA11_43=='r') ) {
            int LA11_116 = input.LA(3);

            if ( ((LA11_116>='0' && LA11_116<='9')||(LA11_116>='A' && LA11_116<='Z')||LA11_116=='_'||(LA11_116>='a' && LA11_116<='z')) ) {
                return 77;
            }
            else {
                return 73;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper044() throws RecognitionException {
        int LA11_44 = input.LA(2);

        if ( (LA11_44=='n') ) {
            int LA11_117 = input.LA(3);

            if ( (LA11_117=='d') ) {
                int LA11_158 = input.LA(4);

                if ( ((LA11_158>='0' && LA11_158<='9')||(LA11_158>='A' && LA11_158<='Z')||LA11_158=='_'||(LA11_158>='a' && LA11_158<='z')) ) {
                    return 77;
                }
                else {
                    return 74;}
            }
            else {
                return 77;}
        }
        else {
            return 77;}
    }

    private int mTokensHelper045() throws RecognitionException {
        int LA11_45 = input.LA(2);

        if ( ((LA11_45>='\u0000' && LA11_45<='\uFFFE')) ) {
            return 75;
        }
        else {
            return 82;}
    }

    private int mTokensHelper046() throws RecognitionException {
        int LA11_46 = input.LA(2);

        if ( ((LA11_46>='\u0000' && LA11_46<='\uFFFE')) ) {
            return 76;
        }
        else {
            return 82;}
    }

    private int mTokensHelper047() throws RecognitionException {
        return 77;
    }

    private int mTokensHelper048() throws RecognitionException {
        return 77;
    }

    private int mTokensHelper049() throws RecognitionException {
        return 78;
    }

    private int mTokensHelper050() throws RecognitionException {
        return 81;
    }

    private int mTokensHelper051() throws RecognitionException {
        return 82;
    }

    private int mTokensHelper052() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 0, input);

        throw nvae;
    }



 

}