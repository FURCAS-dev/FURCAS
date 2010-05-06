package org.eclipse.ocl.examples.xtext.oclinecore.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOCLinEcoreLexer extends Lexer {
    public static final int T114=114;
    public static final int T115=115;
    public static final int T116=116;
    public static final int T117=117;
    public static final int T118=118;
    public static final int T119=119;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_DOUBLE_QUOTED_STRING=8;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int RULE_ID_TERMINAL=6;
    public static final int RULE_SINGLE_QUOTED_STRING=5;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T100=100;
    public static final int T43=43;
    public static final int T42=42;
    public static final int T102=102;
    public static final int T41=41;
    public static final int T101=101;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int RULE_ML_COMMENT=9;
    public static final int T45=45;
    public static final int T44=44;
    public static final int T109=109;
    public static final int T107=107;
    public static final int T108=108;
    public static final int T105=105;
    public static final int T106=106;
    public static final int T103=103;
    public static final int T104=104;
    public static final int T50=50;
    public static final int T59=59;
    public static final int T113=113;
    public static final int T52=52;
    public static final int T112=112;
    public static final int T51=51;
    public static final int T111=111;
    public static final int T54=54;
    public static final int T110=110;
    public static final int T53=53;
    public static final int T56=56;
    public static final int T55=55;
    public static final int T58=58;
    public static final int T57=57;
    public static final int T75=75;
    public static final int T76=76;
    public static final int T73=73;
    public static final int T74=74;
    public static final int T79=79;
    public static final int T77=77;
    public static final int T78=78;
    public static final int T72=72;
    public static final int T71=71;
    public static final int T70=70;
    public static final int T62=62;
    public static final int T63=63;
    public static final int T64=64;
    public static final int T65=65;
    public static final int T66=66;
    public static final int T67=67;
    public static final int T68=68;
    public static final int T69=69;
    public static final int RULE_UNQUOTED_STRING=7;
    public static final int RULE_INT=4;
    public static final int T61=61;
    public static final int T60=60;
    public static final int T99=99;
    public static final int T97=97;
    public static final int T98=98;
    public static final int T95=95;
    public static final int T96=96;
    public static final int T94=94;
    public static final int Tokens=120;
    public static final int T93=93;
    public static final int RULE_SL_COMMENT=10;
    public static final int T92=92;
    public static final int T91=91;
    public static final int T90=90;
    public static final int T88=88;
    public static final int T89=89;
    public static final int T84=84;
    public static final int T85=85;
    public static final int T86=86;
    public static final int T87=87;
    public static final int T13=13;
    public static final int T14=14;
    public static final int RULE_WS=11;
    public static final int T15=15;
    public static final int T81=81;
    public static final int T16=16;
    public static final int T80=80;
    public static final int T17=17;
    public static final int T83=83;
    public static final int T18=18;
    public static final int T82=82;
    public static final int T19=19;
    public InternalOCLinEcoreLexer() {;} 
    public InternalOCLinEcoreLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g"; }

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:10:5: ( '*' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:10:7: '*'
            {
            match('*'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:11:5: ( 'abstract' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:11:7: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:12:5: ( 'annotation' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:12:7: 'annotation'
            {
            match("annotation"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:13:5: ( 'attribute' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:13:7: 'attribute'
            {
            match("attribute"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:14:5: ( 'body' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:14:7: 'body'
            {
            match("body"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:15:5: ( 'class' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:15:7: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:16:5: ( 'composes' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:16:7: 'composes'
            {
            match("composes"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:17:5: ( 'datatype' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:17:7: 'datatype'
            {
            match("datatype"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:18:5: ( 'derived' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:18:7: 'derived'
            {
            match("derived"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:19:5: ( 'documentation' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:19:7: 'documentation'
            {
            match("documentation"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:20:5: ( 'enum' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:20:7: 'enum'
            {
            match("enum"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:21:5: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:21:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:22:5: ( 'id' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:22:7: 'id'
            {
            match("id"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:23:5: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:23:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24:5: ( 'initial' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24:7: 'initial'
            {
            match("initial"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:25:5: ( 'interface' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:25:7: 'interface'
            {
            match("interface"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:26:5: ( 'invariant' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:26:7: 'invariant'
            {
            match("invariant"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:27:5: ( 'library' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:27:7: 'library'
            {
            match("library"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:28:5: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:28:7: 'operation'
            {
            match("operation"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:29:5: ( 'ordered' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:29:7: 'ordered'
            {
            match("ordered"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:30:5: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:30:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:31:5: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:31:7: 'property'
            {
            match("property"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:32:5: ( 'readonly' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:32:7: 'readonly'
            {
            match("readonly"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:33:5: ( 'resolve' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:33:7: 'resolve'
            {
            match("resolve"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:34:5: ( 'serializable' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:34:7: 'serializable'
            {
            match("serializable"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:35:5: ( 'static' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:35:7: 'static'
            {
            match("static"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:36:5: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:36:7: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:37:5: ( 'transient' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:37:7: 'transient'
            {
            match("transient"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:38:5: ( 'unique' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:38:7: 'unique'
            {
            match("unique"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:39:5: ( 'unsettable' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:39:7: 'unsettable'
            {
            match("unsettable"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:40:5: ( 'volatile' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:40:7: 'volatile'
            {
            match("volatile"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:41:5: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:41:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:42:5: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:42:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:43:5: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:43:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:44:5: ( '!derived' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:44:7: '!derived'
            {
            match("!derived"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:45:5: ( '!id' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:45:7: '!id'
            {
            match("!id"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:46:5: ( '!ordered' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:46:7: '!ordered'
            {
            match("!ordered"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:47:5: ( '!readonly' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:47:7: '!readonly'
            {
            match("!readonly"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:48:5: ( '!transient' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:48:7: '!transient'
            {
            match("!transient"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:49:5: ( '!unique' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:49:7: '!unique'
            {
            match("!unique"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:50:5: ( '!unsettable' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:50:7: '!unsettable'
            {
            match("!unsettable"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:51:5: ( '!volatile' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:51:7: '!volatile'
            {
            match("!volatile"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:52:5: ( '!abstract' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:52:7: '!abstract'
            {
            match("!abstract"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:53:5: ( '!interface' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:53:7: '!interface'
            {
            match("!interface"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:54:5: ( '!serializable' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:54:7: '!serializable'
            {
            match("!serializable"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:55:5: ( '!composes' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:55:7: '!composes'
            {
            match("!composes"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:56:5: ( '!resolve' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:56:7: '!resolve'
            {
            match("!resolve"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:57:5: ( 'e' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:57:7: 'e'
            {
            match('e'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:58:5: ( 'E' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:58:7: 'E'
            {
            match('E'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:59:5: ( '-' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:59:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:60:5: ( 'Boolean' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:60:7: 'Boolean'
            {
            match("Boolean"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:61:5: ( 'Integer' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:61:7: 'Integer'
            {
            match("Integer"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:62:5: ( 'Real' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:62:7: 'Real'
            {
            match("Real"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:63:5: ( 'String' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:63:7: 'String'
            {
            match("String"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:64:5: ( 'UnlimitedNatural' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:64:7: 'UnlimitedNatural'
            {
            match("UnlimitedNatural"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:65:5: ( 'OclAny' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:65:7: 'OclAny'
            {
            match("OclAny"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:66:5: ( 'OclInvalid' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:66:7: 'OclInvalid'
            {
            match("OclInvalid"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:67:5: ( 'OclVoid' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:67:7: 'OclVoid'
            {
            match("OclVoid"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:68:5: ( 'Set' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:68:7: 'Set'
            {
            match("Set"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:69:5: ( 'Bag' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:69:7: 'Bag'
            {
            match("Bag"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:70:5: ( 'Sequence' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:70:7: 'Sequence'
            {
            match("Sequence"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:71:5: ( 'Collection' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:71:7: 'Collection'
            {
            match("Collection"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:72:5: ( 'OrderedSet' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:72:7: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:73:5: ( '=' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:73:7: '='
            {
            match('='); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:74:5: ( '<>' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:74:7: '<>'
            {
            match("<>"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:75:5: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:75:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:76:5: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:76:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:77:5: ( '>=' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:77:7: '>='
            {
            match(">="); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:78:5: ( '<=' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:78:7: '<='
            {
            match("<="); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:79:5: ( '/' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:79:7: '/'
            {
            match('/'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:80:5: ( 'not' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:80:7: 'not'
            {
            match("not"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:81:5: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:81:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:82:5: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:82:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T85

    // $ANTLR start T86
    public final void mT86() throws RecognitionException {
        try {
            int _type = T86;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:83:5: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:83:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T86

    // $ANTLR start T87
    public final void mT87() throws RecognitionException {
        try {
            int _type = T87;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:84:5: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:84:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T87

    // $ANTLR start T88
    public final void mT88() throws RecognitionException {
        try {
            int _type = T88;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:85:5: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:85:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T88

    // $ANTLR start T89
    public final void mT89() throws RecognitionException {
        try {
            int _type = T89;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:86:5: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:86:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T89

    // $ANTLR start T90
    public final void mT90() throws RecognitionException {
        try {
            int _type = T90;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:87:5: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:87:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T90

    // $ANTLR start T91
    public final void mT91() throws RecognitionException {
        try {
            int _type = T91;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:88:5: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:88:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T91

    // $ANTLR start T92
    public final void mT92() throws RecognitionException {
        try {
            int _type = T92;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:89:5: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:89:7: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T92

    // $ANTLR start T93
    public final void mT93() throws RecognitionException {
        try {
            int _type = T93;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:90:5: ( 'throws' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:90:7: 'throws'
            {
            match("throws"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T93

    // $ANTLR start T94
    public final void mT94() throws RecognitionException {
        try {
            int _type = T94;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:91:5: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:91:7: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T94

    // $ANTLR start T95
    public final void mT95() throws RecognitionException {
        try {
            int _type = T95;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:92:5: ( '#' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:92:7: '#'
            {
            match('#'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T95

    // $ANTLR start T96
    public final void mT96() throws RecognitionException {
        try {
            int _type = T96;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:93:5: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:93:7: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T96

    // $ANTLR start T97
    public final void mT97() throws RecognitionException {
        try {
            int _type = T97;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:94:5: ( '.' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:94:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T97

    // $ANTLR start T98
    public final void mT98() throws RecognitionException {
        try {
            int _type = T98;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:95:5: ( 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:95:7: 'Tuple'
            {
            match("Tuple"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T98

    // $ANTLR start T99
    public final void mT99() throws RecognitionException {
        try {
            int _type = T99;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:96:5: ( 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:96:7: 'invalid'
            {
            match("invalid"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T99

    // $ANTLR start T100
    public final void mT100() throws RecognitionException {
        try {
            int _type = T100;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:97:6: ( 'null' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:97:8: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T100

    // $ANTLR start T101
    public final void mT101() throws RecognitionException {
        try {
            int _type = T101;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:98:6: ( '->' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:98:8: '->'
            {
            match("->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T101

    // $ANTLR start T102
    public final void mT102() throws RecognitionException {
        try {
            int _type = T102;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:99:6: ( '|' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:99:8: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T102

    // $ANTLR start T103
    public final void mT103() throws RecognitionException {
        try {
            int _type = T103;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:100:6: ( 'self' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:100:8: 'self'
            {
            match("self"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T103

    // $ANTLR start T104
    public final void mT104() throws RecognitionException {
        try {
            int _type = T104;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:101:6: ( 'if' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:101:8: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T104

    // $ANTLR start T105
    public final void mT105() throws RecognitionException {
        try {
            int _type = T105;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:102:6: ( 'then' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:102:8: 'then'
            {
            match("then"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T105

    // $ANTLR start T106
    public final void mT106() throws RecognitionException {
        try {
            int _type = T106;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:103:6: ( 'else' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:103:8: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T106

    // $ANTLR start T107
    public final void mT107() throws RecognitionException {
        try {
            int _type = T107;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:104:6: ( 'endif' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:104:8: 'endif'
            {
            match("endif"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T107

    // $ANTLR start T108
    public final void mT108() throws RecognitionException {
        try {
            int _type = T108;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:105:6: ( 'let' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:105:8: 'let'
            {
            match("let"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T108

    // $ANTLR start T109
    public final void mT109() throws RecognitionException {
        try {
            int _type = T109;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:106:6: ( 'in' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:106:8: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T109

    // $ANTLR start T110
    public final void mT110() throws RecognitionException {
        try {
            int _type = T110;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:107:6: ( 'derivation' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:107:8: 'derivation'
            {
            match("derivation"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T110

    // $ANTLR start T111
    public final void mT111() throws RecognitionException {
        try {
            int _type = T111;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:108:6: ( 'postcondition' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:108:8: 'postcondition'
            {
            match("postcondition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T111

    // $ANTLR start T112
    public final void mT112() throws RecognitionException {
        try {
            int _type = T112;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:109:6: ( 'precondition' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:109:8: 'precondition'
            {
            match("precondition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T112

    // $ANTLR start T113
    public final void mT113() throws RecognitionException {
        try {
            int _type = T113;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:110:6: ( 'definition' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:110:8: 'definition'
            {
            match("definition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T113

    // $ANTLR start T114
    public final void mT114() throws RecognitionException {
        try {
            int _type = T114;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:111:6: ( 'true' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:111:8: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T114

    // $ANTLR start T115
    public final void mT115() throws RecognitionException {
        try {
            int _type = T115;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:112:6: ( 'false' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:112:8: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T115

    // $ANTLR start T116
    public final void mT116() throws RecognitionException {
        try {
            int _type = T116;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:113:6: ( 'implies' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:113:8: 'implies'
            {
            match("implies"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T116

    // $ANTLR start T117
    public final void mT117() throws RecognitionException {
        try {
            int _type = T117;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:114:6: ( 'xor' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:114:8: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T117

    // $ANTLR start T118
    public final void mT118() throws RecognitionException {
        try {
            int _type = T118;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:115:6: ( 'or' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:115:8: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T118

    // $ANTLR start T119
    public final void mT119() throws RecognitionException {
        try {
            int _type = T119;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:116:6: ( 'and' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:116:8: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T119

    // $ANTLR start RULE_UNQUOTED_STRING
    public final void mRULE_UNQUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_UNQUOTED_STRING;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24787:22: ( '\\u00A3$%^\\u00A3$%^' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24787:24: '\\u00A3$%^\\u00A3$%^'
            {
            match("\u00A3$%^\u00A3$%^"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_UNQUOTED_STRING

    // $ANTLR start RULE_DOUBLE_QUOTED_STRING
    public final void mRULE_DOUBLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_QUOTED_STRING;
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24789:27: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24789:29: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24789:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24789:34: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24789:75: ~ ( ( '\\\\' | '\"' ) )
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24791:27: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24791:29: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24791:34: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24791:35: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24791:76: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24793:18: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24793:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24793:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )
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
                    new NoViableAltException("24793:20: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_SINGLE_QUOTED_STRING )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24793:21: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24793:45: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:
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
                    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24793:79: '_' RULE_SINGLE_QUOTED_STRING
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24795:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24795:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24795:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24795:13: '0' .. '9'
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24797:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24797:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24797:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24797:52: .
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24799:41: '\\r'
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24801:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24801:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24801:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24803:16: ( . )
            // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:24803:18: .
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
        // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:8: ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_UNQUOTED_STRING | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt11=116;
        int LA11_0 = input.LA(1);

        if ( (LA11_0=='*') ) {
            alt11 = mTokensHelper001();
        }
        else if ( (LA11_0=='a') ) {
            alt11 = mTokensHelper002();
        }
        else if ( (LA11_0=='b') ) {
            alt11 = mTokensHelper003();
        }
        else if ( (LA11_0=='c') ) {
            alt11 = mTokensHelper004();
        }
        else if ( (LA11_0=='d') ) {
            alt11 = mTokensHelper005();
        }
        else if ( (LA11_0=='e') ) {
            alt11 = mTokensHelper006();
        }
        else if ( (LA11_0=='i') ) {
            alt11 = mTokensHelper007();
        }
        else if ( (LA11_0=='l') ) {
            alt11 = mTokensHelper008();
        }
        else if ( (LA11_0=='o') ) {
            alt11 = mTokensHelper009();
        }
        else if ( (LA11_0=='p') ) {
            alt11 = mTokensHelper010();
        }
        else if ( (LA11_0=='r') ) {
            alt11 = mTokensHelper011();
        }
        else if ( (LA11_0=='s') ) {
            alt11 = mTokensHelper012();
        }
        else if ( (LA11_0=='t') ) {
            alt11 = mTokensHelper013();
        }
        else if ( (LA11_0=='u') ) {
            alt11 = mTokensHelper014();
        }
        else if ( (LA11_0=='v') ) {
            alt11 = mTokensHelper015();
        }
        else if ( (LA11_0==';') ) {
            alt11 = mTokensHelper016();
        }
        else if ( (LA11_0=='+') ) {
            alt11 = mTokensHelper017();
        }
        else if ( (LA11_0=='?') ) {
            alt11 = mTokensHelper018();
        }
        else if ( (LA11_0=='!') ) {
            alt11 = mTokensHelper019();
        }
        else if ( (LA11_0=='E') ) {
            alt11 = mTokensHelper020();
        }
        else if ( (LA11_0=='-') ) {
            alt11 = mTokensHelper021();
        }
        else if ( (LA11_0=='B') ) {
            alt11 = mTokensHelper022();
        }
        else if ( (LA11_0=='I') ) {
            alt11 = mTokensHelper023();
        }
        else if ( (LA11_0=='R') ) {
            alt11 = mTokensHelper024();
        }
        else if ( (LA11_0=='S') ) {
            alt11 = mTokensHelper025();
        }
        else if ( (LA11_0=='U') ) {
            alt11 = mTokensHelper026();
        }
        else if ( (LA11_0=='O') ) {
            alt11 = mTokensHelper027();
        }
        else if ( (LA11_0=='C') ) {
            alt11 = mTokensHelper028();
        }
        else if ( (LA11_0=='=') ) {
            alt11 = mTokensHelper029();
        }
        else if ( (LA11_0=='<') ) {
            alt11 = mTokensHelper030();
        }
        else if ( (LA11_0=='>') ) {
            alt11 = mTokensHelper031();
        }
        else if ( (LA11_0=='/') ) {
            alt11 = mTokensHelper032();
        }
        else if ( (LA11_0=='n') ) {
            alt11 = mTokensHelper033();
        }
        else if ( (LA11_0==':') ) {
            alt11 = mTokensHelper034();
        }
        else if ( (LA11_0=='(') ) {
            alt11 = mTokensHelper035();
        }
        else if ( (LA11_0==')') ) {
            alt11 = mTokensHelper036();
        }
        else if ( (LA11_0==',') ) {
            alt11 = mTokensHelper037();
        }
        else if ( (LA11_0=='{') ) {
            alt11 = mTokensHelper038();
        }
        else if ( (LA11_0=='}') ) {
            alt11 = mTokensHelper039();
        }
        else if ( (LA11_0=='[') ) {
            alt11 = mTokensHelper040();
        }
        else if ( (LA11_0==']') ) {
            alt11 = mTokensHelper041();
        }
        else if ( (LA11_0=='.') ) {
            alt11 = mTokensHelper042();
        }
        else if ( (LA11_0=='#') ) {
            alt11 = mTokensHelper043();
        }
        else if ( (LA11_0=='&') ) {
            alt11 = mTokensHelper044();
        }
        else if ( (LA11_0=='T') ) {
            alt11 = mTokensHelper045();
        }
        else if ( (LA11_0=='|') ) {
            alt11 = mTokensHelper046();
        }
        else if ( (LA11_0=='f') ) {
            alt11 = mTokensHelper047();
        }
        else if ( (LA11_0=='x') ) {
            alt11 = mTokensHelper048();
        }
        else if ( (LA11_0=='\u00A3') ) {
            alt11 = mTokensHelper049();
        }
        else if ( (LA11_0=='\"') ) {
            alt11 = mTokensHelper050();
        }
        else if ( (LA11_0=='\'') ) {
            alt11 = mTokensHelper051();
        }
        else if ( (LA11_0=='_') ) {
            alt11 = mTokensHelper052();
        }
        else if ( (LA11_0=='A'||LA11_0=='D'||(LA11_0>='F' && LA11_0<='H')||(LA11_0>='J' && LA11_0<='N')||(LA11_0>='P' && LA11_0<='Q')||(LA11_0>='V' && LA11_0<='Z')||(LA11_0>='g' && LA11_0<='h')||(LA11_0>='j' && LA11_0<='k')||LA11_0=='m'||LA11_0=='q'||LA11_0=='w'||(LA11_0>='y' && LA11_0<='z')) ) {
            alt11 = mTokensHelper053();
        }
        else if ( ((LA11_0>='0' && LA11_0<='9')) ) {
            alt11 = mTokensHelper054();
        }
        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
            alt11 = mTokensHelper055();
        }
        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||(LA11_0>='$' && LA11_0<='%')||LA11_0=='@'||LA11_0=='\\'||LA11_0=='^'||LA11_0=='`'||(LA11_0>='~' && LA11_0<='\u00A2')||(LA11_0>='\u00A4' && LA11_0<='\uFFFE')) ) {
            alt11 = mTokensHelper056();
        }
        else {
            alt11 = mTokensHelper057();
        }
        switch (alt11) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:10: T13
                {
                mT13(); 

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:14: T14
                {
                mT14(); 

                }
                break;
            case 3 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:18: T15
                {
                mT15(); 

                }
                break;
            case 4 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:22: T16
                {
                mT16(); 

                }
                break;
            case 5 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:26: T17
                {
                mT17(); 

                }
                break;
            case 6 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:30: T18
                {
                mT18(); 

                }
                break;
            case 7 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:34: T19
                {
                mT19(); 

                }
                break;
            case 8 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:38: T20
                {
                mT20(); 

                }
                break;
            case 9 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:42: T21
                {
                mT21(); 

                }
                break;
            case 10 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:46: T22
                {
                mT22(); 

                }
                break;
            case 11 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:50: T23
                {
                mT23(); 

                }
                break;
            case 12 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:54: T24
                {
                mT24(); 

                }
                break;
            case 13 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:58: T25
                {
                mT25(); 

                }
                break;
            case 14 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:62: T26
                {
                mT26(); 

                }
                break;
            case 15 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:66: T27
                {
                mT27(); 

                }
                break;
            case 16 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:70: T28
                {
                mT28(); 

                }
                break;
            case 17 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:74: T29
                {
                mT29(); 

                }
                break;
            case 18 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:78: T30
                {
                mT30(); 

                }
                break;
            case 19 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:82: T31
                {
                mT31(); 

                }
                break;
            case 20 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:86: T32
                {
                mT32(); 

                }
                break;
            case 21 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:90: T33
                {
                mT33(); 

                }
                break;
            case 22 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:94: T34
                {
                mT34(); 

                }
                break;
            case 23 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:98: T35
                {
                mT35(); 

                }
                break;
            case 24 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:102: T36
                {
                mT36(); 

                }
                break;
            case 25 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:106: T37
                {
                mT37(); 

                }
                break;
            case 26 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:110: T38
                {
                mT38(); 

                }
                break;
            case 27 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:114: T39
                {
                mT39(); 

                }
                break;
            case 28 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:118: T40
                {
                mT40(); 

                }
                break;
            case 29 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:122: T41
                {
                mT41(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:126: T42
                {
                mT42(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:130: T43
                {
                mT43(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:134: T44
                {
                mT44(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:138: T45
                {
                mT45(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:142: T46
                {
                mT46(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:146: T47
                {
                mT47(); 

                }
                break;
            case 36 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:150: T48
                {
                mT48(); 

                }
                break;
            case 37 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:154: T49
                {
                mT49(); 

                }
                break;
            case 38 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:158: T50
                {
                mT50(); 

                }
                break;
            case 39 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:162: T51
                {
                mT51(); 

                }
                break;
            case 40 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:166: T52
                {
                mT52(); 

                }
                break;
            case 41 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:170: T53
                {
                mT53(); 

                }
                break;
            case 42 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:174: T54
                {
                mT54(); 

                }
                break;
            case 43 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:178: T55
                {
                mT55(); 

                }
                break;
            case 44 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:182: T56
                {
                mT56(); 

                }
                break;
            case 45 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:186: T57
                {
                mT57(); 

                }
                break;
            case 46 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:190: T58
                {
                mT58(); 

                }
                break;
            case 47 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:194: T59
                {
                mT59(); 

                }
                break;
            case 48 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:198: T60
                {
                mT60(); 

                }
                break;
            case 49 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:202: T61
                {
                mT61(); 

                }
                break;
            case 50 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:206: T62
                {
                mT62(); 

                }
                break;
            case 51 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:210: T63
                {
                mT63(); 

                }
                break;
            case 52 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:214: T64
                {
                mT64(); 

                }
                break;
            case 53 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:218: T65
                {
                mT65(); 

                }
                break;
            case 54 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:222: T66
                {
                mT66(); 

                }
                break;
            case 55 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:226: T67
                {
                mT67(); 

                }
                break;
            case 56 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:230: T68
                {
                mT68(); 

                }
                break;
            case 57 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:234: T69
                {
                mT69(); 

                }
                break;
            case 58 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:238: T70
                {
                mT70(); 

                }
                break;
            case 59 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:242: T71
                {
                mT71(); 

                }
                break;
            case 60 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:246: T72
                {
                mT72(); 

                }
                break;
            case 61 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:250: T73
                {
                mT73(); 

                }
                break;
            case 62 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:254: T74
                {
                mT74(); 

                }
                break;
            case 63 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:258: T75
                {
                mT75(); 

                }
                break;
            case 64 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:262: T76
                {
                mT76(); 

                }
                break;
            case 65 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:266: T77
                {
                mT77(); 

                }
                break;
            case 66 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:270: T78
                {
                mT78(); 

                }
                break;
            case 67 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:274: T79
                {
                mT79(); 

                }
                break;
            case 68 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:278: T80
                {
                mT80(); 

                }
                break;
            case 69 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:282: T81
                {
                mT81(); 

                }
                break;
            case 70 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:286: T82
                {
                mT82(); 

                }
                break;
            case 71 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:290: T83
                {
                mT83(); 

                }
                break;
            case 72 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:294: T84
                {
                mT84(); 

                }
                break;
            case 73 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:298: T85
                {
                mT85(); 

                }
                break;
            case 74 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:302: T86
                {
                mT86(); 

                }
                break;
            case 75 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:306: T87
                {
                mT87(); 

                }
                break;
            case 76 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:310: T88
                {
                mT88(); 

                }
                break;
            case 77 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:314: T89
                {
                mT89(); 

                }
                break;
            case 78 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:318: T90
                {
                mT90(); 

                }
                break;
            case 79 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:322: T91
                {
                mT91(); 

                }
                break;
            case 80 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:326: T92
                {
                mT92(); 

                }
                break;
            case 81 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:330: T93
                {
                mT93(); 

                }
                break;
            case 82 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:334: T94
                {
                mT94(); 

                }
                break;
            case 83 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:338: T95
                {
                mT95(); 

                }
                break;
            case 84 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:342: T96
                {
                mT96(); 

                }
                break;
            case 85 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:346: T97
                {
                mT97(); 

                }
                break;
            case 86 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:350: T98
                {
                mT98(); 

                }
                break;
            case 87 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:354: T99
                {
                mT99(); 

                }
                break;
            case 88 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:358: T100
                {
                mT100(); 

                }
                break;
            case 89 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:363: T101
                {
                mT101(); 

                }
                break;
            case 90 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:368: T102
                {
                mT102(); 

                }
                break;
            case 91 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:373: T103
                {
                mT103(); 

                }
                break;
            case 92 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:378: T104
                {
                mT104(); 

                }
                break;
            case 93 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:383: T105
                {
                mT105(); 

                }
                break;
            case 94 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:388: T106
                {
                mT106(); 

                }
                break;
            case 95 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:393: T107
                {
                mT107(); 

                }
                break;
            case 96 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:398: T108
                {
                mT108(); 

                }
                break;
            case 97 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:403: T109
                {
                mT109(); 

                }
                break;
            case 98 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:408: T110
                {
                mT110(); 

                }
                break;
            case 99 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:413: T111
                {
                mT111(); 

                }
                break;
            case 100 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:418: T112
                {
                mT112(); 

                }
                break;
            case 101 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:423: T113
                {
                mT113(); 

                }
                break;
            case 102 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:428: T114
                {
                mT114(); 

                }
                break;
            case 103 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:433: T115
                {
                mT115(); 

                }
                break;
            case 104 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:438: T116
                {
                mT116(); 

                }
                break;
            case 105 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:443: T117
                {
                mT117(); 

                }
                break;
            case 106 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:448: T118
                {
                mT118(); 

                }
                break;
            case 107 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:453: T119
                {
                mT119(); 

                }
                break;
            case 108 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:458: RULE_UNQUOTED_STRING
                {
                mRULE_UNQUOTED_STRING(); 

                }
                break;
            case 109 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:479: RULE_DOUBLE_QUOTED_STRING
                {
                mRULE_DOUBLE_QUOTED_STRING(); 

                }
                break;
            case 110 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:505: RULE_SINGLE_QUOTED_STRING
                {
                mRULE_SINGLE_QUOTED_STRING(); 

                }
                break;
            case 111 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:531: RULE_ID_TERMINAL
                {
                mRULE_ID_TERMINAL(); 

                }
                break;
            case 112 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:548: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 113 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:557: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 114 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:573: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 115 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:589: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 116 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore.ui/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/ui/contentassist/antlr/internal/InternalOCLinEcore.g:1:597: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        return 1;
    }

    private int mTokensHelper002() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'b':
            {
            int LA11_58 = input.LA(3);

            if ( (LA11_58=='s') ) {
                int LA11_150 = input.LA(4);

                if ( (LA11_150=='t') ) {
                    int LA11_214 = input.LA(5);

                    if ( (LA11_214=='r') ) {
                        int LA11_277 = input.LA(6);

                        if ( (LA11_277=='a') ) {
                            int LA11_331 = input.LA(7);

                            if ( (LA11_331=='c') ) {
                                int LA11_378 = input.LA(8);

                                if ( (LA11_378=='t') ) {
                                    int LA11_420 = input.LA(9);

                                    if ( ((LA11_420>='0' && LA11_420<='9')||(LA11_420>='A' && LA11_420<='Z')||LA11_420=='_'||(LA11_420>='a' && LA11_420<='z')) ) {
                                        return 111;
                                    }
                                    else {
                                        return 2;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        case 'n':
            {
            switch ( input.LA(3) ) {
            case 'd':
                {
                int LA11_151 = input.LA(4);

                if ( ((LA11_151>='0' && LA11_151<='9')||(LA11_151>='A' && LA11_151<='Z')||LA11_151=='_'||(LA11_151>='a' && LA11_151<='z')) ) {
                    return 111;
                }
                else {
                    return 107;}
                }
            case 'n':
                {
                int LA11_152 = input.LA(4);

                if ( (LA11_152=='o') ) {
                    int LA11_216 = input.LA(5);

                    if ( (LA11_216=='t') ) {
                        int LA11_278 = input.LA(6);

                        if ( (LA11_278=='a') ) {
                            int LA11_332 = input.LA(7);

                            if ( (LA11_332=='t') ) {
                                int LA11_379 = input.LA(8);

                                if ( (LA11_379=='i') ) {
                                    int LA11_421 = input.LA(9);

                                    if ( (LA11_421=='o') ) {
                                        int LA11_457 = input.LA(10);

                                        if ( (LA11_457=='n') ) {
                                            int LA11_480 = input.LA(11);

                                            if ( ((LA11_480>='0' && LA11_480<='9')||(LA11_480>='A' && LA11_480<='Z')||LA11_480=='_'||(LA11_480>='a' && LA11_480<='z')) ) {
                                                return 111;
                                            }
                                            else {
                                                return 3;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

            }
        case 't':
            {
            int LA11_60 = input.LA(3);

            if ( (LA11_60=='t') ) {
                int LA11_153 = input.LA(4);

                if ( (LA11_153=='r') ) {
                    int LA11_217 = input.LA(5);

                    if ( (LA11_217=='i') ) {
                        int LA11_279 = input.LA(6);

                        if ( (LA11_279=='b') ) {
                            int LA11_333 = input.LA(7);

                            if ( (LA11_333=='u') ) {
                                int LA11_380 = input.LA(8);

                                if ( (LA11_380=='t') ) {
                                    int LA11_422 = input.LA(9);

                                    if ( (LA11_422=='e') ) {
                                        int LA11_458 = input.LA(10);

                                        if ( ((LA11_458>='0' && LA11_458<='9')||(LA11_458>='A' && LA11_458<='Z')||LA11_458=='_'||(LA11_458>='a' && LA11_458<='z')) ) {
                                            return 111;
                                        }
                                        else {
                                            return 4;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper003() throws RecognitionException {
        int LA11_3 = input.LA(2);

        if ( (LA11_3=='o') ) {
            int LA11_62 = input.LA(3);

            if ( (LA11_62=='d') ) {
                int LA11_154 = input.LA(4);

                if ( (LA11_154=='y') ) {
                    int LA11_218 = input.LA(5);

                    if ( ((LA11_218>='0' && LA11_218<='9')||(LA11_218>='A' && LA11_218<='Z')||LA11_218=='_'||(LA11_218>='a' && LA11_218<='z')) ) {
                        return 111;
                    }
                    else {
                        return 5;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper004() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'o':
            {
            int LA11_63 = input.LA(3);

            if ( (LA11_63=='m') ) {
                int LA11_155 = input.LA(4);

                if ( (LA11_155=='p') ) {
                    int LA11_219 = input.LA(5);

                    if ( (LA11_219=='o') ) {
                        int LA11_281 = input.LA(6);

                        if ( (LA11_281=='s') ) {
                            int LA11_334 = input.LA(7);

                            if ( (LA11_334=='e') ) {
                                int LA11_381 = input.LA(8);

                                if ( (LA11_381=='s') ) {
                                    int LA11_423 = input.LA(9);

                                    if ( ((LA11_423>='0' && LA11_423<='9')||(LA11_423>='A' && LA11_423<='Z')||LA11_423=='_'||(LA11_423>='a' && LA11_423<='z')) ) {
                                        return 111;
                                    }
                                    else {
                                        return 7;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        case 'l':
            {
            int LA11_64 = input.LA(3);

            if ( (LA11_64=='a') ) {
                int LA11_156 = input.LA(4);

                if ( (LA11_156=='s') ) {
                    int LA11_220 = input.LA(5);

                    if ( (LA11_220=='s') ) {
                        int LA11_282 = input.LA(6);

                        if ( ((LA11_282>='0' && LA11_282<='9')||(LA11_282>='A' && LA11_282<='Z')||LA11_282=='_'||(LA11_282>='a' && LA11_282<='z')) ) {
                            return 111;
                        }
                        else {
                            return 6;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper005() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            switch ( input.LA(3) ) {
            case 'r':
                {
                int LA11_157 = input.LA(4);

                if ( (LA11_157=='i') ) {
                    int LA11_221 = input.LA(5);

                    if ( (LA11_221=='v') ) {
                        switch ( input.LA(6) ) {
                        case 'e':
                            {
                            int LA11_336 = input.LA(7);

                            if ( (LA11_336=='d') ) {
                                int LA11_382 = input.LA(8);

                                if ( ((LA11_382>='0' && LA11_382<='9')||(LA11_382>='A' && LA11_382<='Z')||LA11_382=='_'||(LA11_382>='a' && LA11_382<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 9;}
                            }
                            else {
                                return 111;}
                            }
                        case 'a':
                            {
                            int LA11_337 = input.LA(7);

                            if ( (LA11_337=='t') ) {
                                int LA11_383 = input.LA(8);

                                if ( (LA11_383=='i') ) {
                                    int LA11_425 = input.LA(9);

                                    if ( (LA11_425=='o') ) {
                                        int LA11_460 = input.LA(10);

                                        if ( (LA11_460=='n') ) {
                                            int LA11_482 = input.LA(11);

                                            if ( ((LA11_482>='0' && LA11_482<='9')||(LA11_482>='A' && LA11_482<='Z')||LA11_482=='_'||(LA11_482>='a' && LA11_482<='z')) ) {
                                                return 111;
                                            }
                                            else {
                                                return 98;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                            }
                        default:
                            return 111;}

                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 'f':
                {
                int LA11_158 = input.LA(4);

                if ( (LA11_158=='i') ) {
                    int LA11_222 = input.LA(5);

                    if ( (LA11_222=='n') ) {
                        int LA11_284 = input.LA(6);

                        if ( (LA11_284=='i') ) {
                            int LA11_338 = input.LA(7);

                            if ( (LA11_338=='t') ) {
                                int LA11_384 = input.LA(8);

                                if ( (LA11_384=='i') ) {
                                    int LA11_426 = input.LA(9);

                                    if ( (LA11_426=='o') ) {
                                        int LA11_461 = input.LA(10);

                                        if ( (LA11_461=='n') ) {
                                            int LA11_483 = input.LA(11);

                                            if ( ((LA11_483>='0' && LA11_483<='9')||(LA11_483>='A' && LA11_483<='Z')||LA11_483=='_'||(LA11_483>='a' && LA11_483<='z')) ) {
                                                return 111;
                                            }
                                            else {
                                                return 101;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

            }
        case 'o':
            {
            int LA11_66 = input.LA(3);

            if ( (LA11_66=='c') ) {
                int LA11_159 = input.LA(4);

                if ( (LA11_159=='u') ) {
                    int LA11_223 = input.LA(5);

                    if ( (LA11_223=='m') ) {
                        int LA11_285 = input.LA(6);

                        if ( (LA11_285=='e') ) {
                            int LA11_339 = input.LA(7);

                            if ( (LA11_339=='n') ) {
                                int LA11_385 = input.LA(8);

                                if ( (LA11_385=='t') ) {
                                    int LA11_427 = input.LA(9);

                                    if ( (LA11_427=='a') ) {
                                        int LA11_462 = input.LA(10);

                                        if ( (LA11_462=='t') ) {
                                            int LA11_484 = input.LA(11);

                                            if ( (LA11_484=='i') ) {
                                                int LA11_500 = input.LA(12);

                                                if ( (LA11_500=='o') ) {
                                                    int LA11_509 = input.LA(13);

                                                    if ( (LA11_509=='n') ) {
                                                        int LA11_514 = input.LA(14);

                                                        if ( ((LA11_514>='0' && LA11_514<='9')||(LA11_514>='A' && LA11_514<='Z')||LA11_514=='_'||(LA11_514>='a' && LA11_514<='z')) ) {
                                                            return 111;
                                                        }
                                                        else {
                                                            return 10;}
                                                    }
                                                    else {
                                                        return 111;}
                                                }
                                                else {
                                                    return 111;}
                                            }
                                            else {
                                                return 111;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        case 'a':
            {
            int LA11_67 = input.LA(3);

            if ( (LA11_67=='t') ) {
                int LA11_160 = input.LA(4);

                if ( (LA11_160=='a') ) {
                    int LA11_224 = input.LA(5);

                    if ( (LA11_224=='t') ) {
                        int LA11_286 = input.LA(6);

                        if ( (LA11_286=='y') ) {
                            int LA11_340 = input.LA(7);

                            if ( (LA11_340=='p') ) {
                                int LA11_386 = input.LA(8);

                                if ( (LA11_386=='e') ) {
                                    int LA11_428 = input.LA(9);

                                    if ( ((LA11_428>='0' && LA11_428<='9')||(LA11_428>='A' && LA11_428<='Z')||LA11_428=='_'||(LA11_428>='a' && LA11_428<='z')) ) {
                                        return 111;
                                    }
                                    else {
                                        return 8;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper006() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'x':
            {
            int LA11_68 = input.LA(3);

            if ( (LA11_68=='t') ) {
                int LA11_161 = input.LA(4);

                if ( (LA11_161=='e') ) {
                    int LA11_225 = input.LA(5);

                    if ( (LA11_225=='n') ) {
                        int LA11_287 = input.LA(6);

                        if ( (LA11_287=='d') ) {
                            int LA11_341 = input.LA(7);

                            if ( (LA11_341=='s') ) {
                                int LA11_387 = input.LA(8);

                                if ( ((LA11_387>='0' && LA11_387<='9')||(LA11_387>='A' && LA11_387<='Z')||LA11_387=='_'||(LA11_387>='a' && LA11_387<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 12;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        case 'n':
            {
            switch ( input.LA(3) ) {
            case 'd':
                {
                int LA11_162 = input.LA(4);

                if ( (LA11_162=='i') ) {
                    int LA11_226 = input.LA(5);

                    if ( (LA11_226=='f') ) {
                        int LA11_288 = input.LA(6);

                        if ( ((LA11_288>='0' && LA11_288<='9')||(LA11_288>='A' && LA11_288<='Z')||LA11_288=='_'||(LA11_288>='a' && LA11_288<='z')) ) {
                            return 111;
                        }
                        else {
                            return 95;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 'u':
                {
                int LA11_163 = input.LA(4);

                if ( (LA11_163=='m') ) {
                    int LA11_227 = input.LA(5);

                    if ( ((LA11_227>='0' && LA11_227<='9')||(LA11_227>='A' && LA11_227<='Z')||LA11_227=='_'||(LA11_227>='a' && LA11_227<='z')) ) {
                        return 111;
                    }
                    else {
                        return 11;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

            }
        case 'l':
            {
            int LA11_70 = input.LA(3);

            if ( (LA11_70=='s') ) {
                int LA11_164 = input.LA(4);

                if ( (LA11_164=='e') ) {
                    int LA11_228 = input.LA(5);

                    if ( ((LA11_228>='0' && LA11_228<='9')||(LA11_228>='A' && LA11_228<='Z')||LA11_228=='_'||(LA11_228>='a' && LA11_228<='z')) ) {
                        return 111;
                    }
                    else {
                        return 94;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
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
        case 'y':
        case 'z':
            {
            return 111;
            }
        default:
            return 48;}

    }

    private int mTokensHelper007() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'm':
            {
            int LA11_72 = input.LA(3);

            if ( (LA11_72=='p') ) {
                switch ( input.LA(4) ) {
                case 'o':
                    {
                    int LA11_229 = input.LA(5);

                    if ( (LA11_229=='r') ) {
                        int LA11_291 = input.LA(6);

                        if ( (LA11_291=='t') ) {
                            int LA11_343 = input.LA(7);

                            if ( ((LA11_343>='0' && LA11_343<='9')||(LA11_343>='A' && LA11_343<='Z')||LA11_343=='_'||(LA11_343>='a' && LA11_343<='z')) ) {
                                return 111;
                            }
                            else {
                                return 14;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                    }
                case 'l':
                    {
                    int LA11_230 = input.LA(5);

                    if ( (LA11_230=='i') ) {
                        int LA11_292 = input.LA(6);

                        if ( (LA11_292=='e') ) {
                            int LA11_344 = input.LA(7);

                            if ( (LA11_344=='s') ) {
                                int LA11_389 = input.LA(8);

                                if ( ((LA11_389>='0' && LA11_389<='9')||(LA11_389>='A' && LA11_389<='Z')||LA11_389=='_'||(LA11_389>='a' && LA11_389<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 104;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                    }
                default:
                    return 111;}

            }
            else {
                return 111;}
            }
        case 'n':
            {
            switch ( input.LA(3) ) {
            case 'v':
                {
                int LA11_166 = input.LA(4);

                if ( (LA11_166=='a') ) {
                    switch ( input.LA(5) ) {
                    case 'l':
                        {
                        int LA11_293 = input.LA(6);

                        if ( (LA11_293=='i') ) {
                            int LA11_345 = input.LA(7);

                            if ( (LA11_345=='d') ) {
                                int LA11_390 = input.LA(8);

                                if ( ((LA11_390>='0' && LA11_390<='9')||(LA11_390>='A' && LA11_390<='Z')||LA11_390=='_'||(LA11_390>='a' && LA11_390<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 87;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                        }
                    case 'r':
                        {
                        int LA11_294 = input.LA(6);

                        if ( (LA11_294=='i') ) {
                            int LA11_346 = input.LA(7);

                            if ( (LA11_346=='a') ) {
                                int LA11_391 = input.LA(8);

                                if ( (LA11_391=='n') ) {
                                    int LA11_432 = input.LA(9);

                                    if ( (LA11_432=='t') ) {
                                        int LA11_464 = input.LA(10);

                                        if ( ((LA11_464>='0' && LA11_464<='9')||(LA11_464>='A' && LA11_464<='Z')||LA11_464=='_'||(LA11_464>='a' && LA11_464<='z')) ) {
                                            return 111;
                                        }
                                        else {
                                            return 17;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                        }
                    default:
                        return 111;}

                }
                else {
                    return 111;}
                }
            case 't':
                {
                int LA11_167 = input.LA(4);

                if ( (LA11_167=='e') ) {
                    int LA11_232 = input.LA(5);

                    if ( (LA11_232=='r') ) {
                        int LA11_295 = input.LA(6);

                        if ( (LA11_295=='f') ) {
                            int LA11_347 = input.LA(7);

                            if ( (LA11_347=='a') ) {
                                int LA11_392 = input.LA(8);

                                if ( (LA11_392=='c') ) {
                                    int LA11_433 = input.LA(9);

                                    if ( (LA11_433=='e') ) {
                                        int LA11_465 = input.LA(10);

                                        if ( ((LA11_465>='0' && LA11_465<='9')||(LA11_465>='A' && LA11_465<='Z')||LA11_465=='_'||(LA11_465>='a' && LA11_465<='z')) ) {
                                            return 111;
                                        }
                                        else {
                                            return 16;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 'i':
                {
                int LA11_168 = input.LA(4);

                if ( (LA11_168=='t') ) {
                    int LA11_233 = input.LA(5);

                    if ( (LA11_233=='i') ) {
                        int LA11_296 = input.LA(6);

                        if ( (LA11_296=='a') ) {
                            int LA11_348 = input.LA(7);

                            if ( (LA11_348=='l') ) {
                                int LA11_393 = input.LA(8);

                                if ( ((LA11_393>='0' && LA11_393<='9')||(LA11_393>='A' && LA11_393<='Z')||LA11_393=='_'||(LA11_393>='a' && LA11_393<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 15;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
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
            case 'u':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                return 111;
                }
            default:
                return 97;}

            }
        case 'f':
            {
            int LA11_74 = input.LA(3);

            if ( ((LA11_74>='0' && LA11_74<='9')||(LA11_74>='A' && LA11_74<='Z')||LA11_74=='_'||(LA11_74>='a' && LA11_74<='z')) ) {
                return 111;
            }
            else {
                return 92;}
            }
        case 'd':
            {
            int LA11_75 = input.LA(3);

            if ( ((LA11_75>='0' && LA11_75<='9')||(LA11_75>='A' && LA11_75<='Z')||LA11_75=='_'||(LA11_75>='a' && LA11_75<='z')) ) {
                return 111;
            }
            else {
                return 13;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper008() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            int LA11_76 = input.LA(3);

            if ( (LA11_76=='t') ) {
                int LA11_172 = input.LA(4);

                if ( ((LA11_172>='0' && LA11_172<='9')||(LA11_172>='A' && LA11_172<='Z')||LA11_172=='_'||(LA11_172>='a' && LA11_172<='z')) ) {
                    return 111;
                }
                else {
                    return 96;}
            }
            else {
                return 111;}
            }
        case 'i':
            {
            int LA11_77 = input.LA(3);

            if ( (LA11_77=='b') ) {
                int LA11_173 = input.LA(4);

                if ( (LA11_173=='r') ) {
                    int LA11_235 = input.LA(5);

                    if ( (LA11_235=='a') ) {
                        int LA11_297 = input.LA(6);

                        if ( (LA11_297=='r') ) {
                            int LA11_349 = input.LA(7);

                            if ( (LA11_349=='y') ) {
                                int LA11_394 = input.LA(8);

                                if ( ((LA11_394>='0' && LA11_394<='9')||(LA11_394>='A' && LA11_394<='Z')||LA11_394=='_'||(LA11_394>='a' && LA11_394<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 18;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper009() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'r':
            {
            switch ( input.LA(3) ) {
            case 'd':
                {
                int LA11_174 = input.LA(4);

                if ( (LA11_174=='e') ) {
                    int LA11_236 = input.LA(5);

                    if ( (LA11_236=='r') ) {
                        int LA11_298 = input.LA(6);

                        if ( (LA11_298=='e') ) {
                            int LA11_350 = input.LA(7);

                            if ( (LA11_350=='d') ) {
                                int LA11_395 = input.LA(8);

                                if ( ((LA11_395>='0' && LA11_395<='9')||(LA11_395>='A' && LA11_395<='Z')||LA11_395=='_'||(LA11_395>='a' && LA11_395<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 20;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
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
                return 111;
                }
            default:
                return 106;}

            }
        case 'p':
            {
            int LA11_79 = input.LA(3);

            if ( (LA11_79=='e') ) {
                int LA11_176 = input.LA(4);

                if ( (LA11_176=='r') ) {
                    int LA11_237 = input.LA(5);

                    if ( (LA11_237=='a') ) {
                        int LA11_299 = input.LA(6);

                        if ( (LA11_299=='t') ) {
                            int LA11_351 = input.LA(7);

                            if ( (LA11_351=='i') ) {
                                int LA11_396 = input.LA(8);

                                if ( (LA11_396=='o') ) {
                                    int LA11_437 = input.LA(9);

                                    if ( (LA11_437=='n') ) {
                                        int LA11_466 = input.LA(10);

                                        if ( ((LA11_466>='0' && LA11_466<='9')||(LA11_466>='A' && LA11_466<='Z')||LA11_466=='_'||(LA11_466>='a' && LA11_466<='z')) ) {
                                            return 111;
                                        }
                                        else {
                                            return 19;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper010() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'r':
            {
            switch ( input.LA(3) ) {
            case 'o':
                {
                int LA11_177 = input.LA(4);

                if ( (LA11_177=='p') ) {
                    int LA11_238 = input.LA(5);

                    if ( (LA11_238=='e') ) {
                        int LA11_300 = input.LA(6);

                        if ( (LA11_300=='r') ) {
                            int LA11_352 = input.LA(7);

                            if ( (LA11_352=='t') ) {
                                int LA11_397 = input.LA(8);

                                if ( (LA11_397=='y') ) {
                                    int LA11_438 = input.LA(9);

                                    if ( ((LA11_438>='0' && LA11_438<='9')||(LA11_438>='A' && LA11_438<='Z')||LA11_438=='_'||(LA11_438>='a' && LA11_438<='z')) ) {
                                        return 111;
                                    }
                                    else {
                                        return 22;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 'e':
                {
                int LA11_178 = input.LA(4);

                if ( (LA11_178=='c') ) {
                    int LA11_239 = input.LA(5);

                    if ( (LA11_239=='o') ) {
                        int LA11_301 = input.LA(6);

                        if ( (LA11_301=='n') ) {
                            int LA11_353 = input.LA(7);

                            if ( (LA11_353=='d') ) {
                                int LA11_398 = input.LA(8);

                                if ( (LA11_398=='i') ) {
                                    int LA11_439 = input.LA(9);

                                    if ( (LA11_439=='t') ) {
                                        int LA11_468 = input.LA(10);

                                        if ( (LA11_468=='i') ) {
                                            int LA11_488 = input.LA(11);

                                            if ( (LA11_488=='o') ) {
                                                int LA11_501 = input.LA(12);

                                                if ( (LA11_501=='n') ) {
                                                    int LA11_510 = input.LA(13);

                                                    if ( ((LA11_510>='0' && LA11_510<='9')||(LA11_510>='A' && LA11_510<='Z')||LA11_510=='_'||(LA11_510>='a' && LA11_510<='z')) ) {
                                                        return 111;
                                                    }
                                                    else {
                                                        return 100;}
                                                }
                                                else {
                                                    return 111;}
                                            }
                                            else {
                                                return 111;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

            }
        case 'o':
            {
            int LA11_81 = input.LA(3);

            if ( (LA11_81=='s') ) {
                int LA11_179 = input.LA(4);

                if ( (LA11_179=='t') ) {
                    int LA11_240 = input.LA(5);

                    if ( (LA11_240=='c') ) {
                        int LA11_302 = input.LA(6);

                        if ( (LA11_302=='o') ) {
                            int LA11_354 = input.LA(7);

                            if ( (LA11_354=='n') ) {
                                int LA11_399 = input.LA(8);

                                if ( (LA11_399=='d') ) {
                                    int LA11_440 = input.LA(9);

                                    if ( (LA11_440=='i') ) {
                                        int LA11_469 = input.LA(10);

                                        if ( (LA11_469=='t') ) {
                                            int LA11_489 = input.LA(11);

                                            if ( (LA11_489=='i') ) {
                                                int LA11_502 = input.LA(12);

                                                if ( (LA11_502=='o') ) {
                                                    int LA11_511 = input.LA(13);

                                                    if ( (LA11_511=='n') ) {
                                                        int LA11_516 = input.LA(14);

                                                        if ( ((LA11_516>='0' && LA11_516<='9')||(LA11_516>='A' && LA11_516<='Z')||LA11_516=='_'||(LA11_516>='a' && LA11_516<='z')) ) {
                                                            return 111;
                                                        }
                                                        else {
                                                            return 99;}
                                                    }
                                                    else {
                                                        return 111;}
                                                }
                                                else {
                                                    return 111;}
                                            }
                                            else {
                                                return 111;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        case 'a':
            {
            int LA11_82 = input.LA(3);

            if ( (LA11_82=='c') ) {
                int LA11_180 = input.LA(4);

                if ( (LA11_180=='k') ) {
                    int LA11_241 = input.LA(5);

                    if ( (LA11_241=='a') ) {
                        int LA11_303 = input.LA(6);

                        if ( (LA11_303=='g') ) {
                            int LA11_355 = input.LA(7);

                            if ( (LA11_355=='e') ) {
                                int LA11_400 = input.LA(8);

                                if ( ((LA11_400>='0' && LA11_400<='9')||(LA11_400>='A' && LA11_400<='Z')||LA11_400=='_'||(LA11_400>='a' && LA11_400<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 21;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper011() throws RecognitionException {
        int LA11_11 = input.LA(2);

        if ( (LA11_11=='e') ) {
            switch ( input.LA(3) ) {
            case 's':
                {
                int LA11_181 = input.LA(4);

                if ( (LA11_181=='o') ) {
                    int LA11_242 = input.LA(5);

                    if ( (LA11_242=='l') ) {
                        int LA11_304 = input.LA(6);

                        if ( (LA11_304=='v') ) {
                            int LA11_356 = input.LA(7);

                            if ( (LA11_356=='e') ) {
                                int LA11_401 = input.LA(8);

                                if ( ((LA11_401>='0' && LA11_401<='9')||(LA11_401>='A' && LA11_401<='Z')||LA11_401=='_'||(LA11_401>='a' && LA11_401<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 24;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 'a':
                {
                int LA11_182 = input.LA(4);

                if ( (LA11_182=='d') ) {
                    int LA11_243 = input.LA(5);

                    if ( (LA11_243=='o') ) {
                        int LA11_305 = input.LA(6);

                        if ( (LA11_305=='n') ) {
                            int LA11_357 = input.LA(7);

                            if ( (LA11_357=='l') ) {
                                int LA11_402 = input.LA(8);

                                if ( (LA11_402=='y') ) {
                                    int LA11_443 = input.LA(9);

                                    if ( ((LA11_443>='0' && LA11_443<='9')||(LA11_443>='A' && LA11_443<='Z')||LA11_443=='_'||(LA11_443>='a' && LA11_443<='z')) ) {
                                        return 111;
                                    }
                                    else {
                                        return 23;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

        }
        else {
            return 111;}
    }

    private int mTokensHelper012() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            switch ( input.LA(3) ) {
            case 'l':
                {
                int LA11_183 = input.LA(4);

                if ( (LA11_183=='f') ) {
                    int LA11_244 = input.LA(5);

                    if ( ((LA11_244>='0' && LA11_244<='9')||(LA11_244>='A' && LA11_244<='Z')||LA11_244=='_'||(LA11_244>='a' && LA11_244<='z')) ) {
                        return 111;
                    }
                    else {
                        return 91;}
                }
                else {
                    return 111;}
                }
            case 'r':
                {
                int LA11_184 = input.LA(4);

                if ( (LA11_184=='i') ) {
                    int LA11_245 = input.LA(5);

                    if ( (LA11_245=='a') ) {
                        int LA11_307 = input.LA(6);

                        if ( (LA11_307=='l') ) {
                            int LA11_358 = input.LA(7);

                            if ( (LA11_358=='i') ) {
                                int LA11_403 = input.LA(8);

                                if ( (LA11_403=='z') ) {
                                    int LA11_444 = input.LA(9);

                                    if ( (LA11_444=='a') ) {
                                        int LA11_471 = input.LA(10);

                                        if ( (LA11_471=='b') ) {
                                            int LA11_490 = input.LA(11);

                                            if ( (LA11_490=='l') ) {
                                                int LA11_503 = input.LA(12);

                                                if ( (LA11_503=='e') ) {
                                                    int LA11_512 = input.LA(13);

                                                    if ( ((LA11_512>='0' && LA11_512<='9')||(LA11_512>='A' && LA11_512<='Z')||LA11_512=='_'||(LA11_512>='a' && LA11_512<='z')) ) {
                                                        return 111;
                                                    }
                                                    else {
                                                        return 25;}
                                                }
                                                else {
                                                    return 111;}
                                            }
                                            else {
                                                return 111;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

            }
        case 't':
            {
            int LA11_85 = input.LA(3);

            if ( (LA11_85=='a') ) {
                int LA11_185 = input.LA(4);

                if ( (LA11_185=='t') ) {
                    int LA11_246 = input.LA(5);

                    if ( (LA11_246=='i') ) {
                        int LA11_308 = input.LA(6);

                        if ( (LA11_308=='c') ) {
                            int LA11_359 = input.LA(7);

                            if ( ((LA11_359>='0' && LA11_359<='9')||(LA11_359>='A' && LA11_359<='Z')||LA11_359=='_'||(LA11_359>='a' && LA11_359<='z')) ) {
                                return 111;
                            }
                            else {
                                return 26;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        case 'u':
            {
            int LA11_86 = input.LA(3);

            if ( (LA11_86=='p') ) {
                int LA11_186 = input.LA(4);

                if ( (LA11_186=='e') ) {
                    int LA11_247 = input.LA(5);

                    if ( (LA11_247=='r') ) {
                        int LA11_309 = input.LA(6);

                        if ( ((LA11_309>='0' && LA11_309<='9')||(LA11_309>='A' && LA11_309<='Z')||LA11_309=='_'||(LA11_309>='a' && LA11_309<='z')) ) {
                            return 111;
                        }
                        else {
                            return 27;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper013() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'h':
            {
            switch ( input.LA(3) ) {
            case 'r':
                {
                int LA11_187 = input.LA(4);

                if ( (LA11_187=='o') ) {
                    int LA11_248 = input.LA(5);

                    if ( (LA11_248=='w') ) {
                        int LA11_310 = input.LA(6);

                        if ( (LA11_310=='s') ) {
                            int LA11_361 = input.LA(7);

                            if ( ((LA11_361>='0' && LA11_361<='9')||(LA11_361>='A' && LA11_361<='Z')||LA11_361=='_'||(LA11_361>='a' && LA11_361<='z')) ) {
                                return 111;
                            }
                            else {
                                return 81;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 'e':
                {
                int LA11_188 = input.LA(4);

                if ( (LA11_188=='n') ) {
                    int LA11_249 = input.LA(5);

                    if ( ((LA11_249>='0' && LA11_249<='9')||(LA11_249>='A' && LA11_249<='Z')||LA11_249=='_'||(LA11_249>='a' && LA11_249<='z')) ) {
                        return 111;
                    }
                    else {
                        return 93;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

            }
        case 'r':
            {
            switch ( input.LA(3) ) {
            case 'u':
                {
                int LA11_189 = input.LA(4);

                if ( (LA11_189=='e') ) {
                    int LA11_250 = input.LA(5);

                    if ( ((LA11_250>='0' && LA11_250<='9')||(LA11_250>='A' && LA11_250<='Z')||LA11_250=='_'||(LA11_250>='a' && LA11_250<='z')) ) {
                        return 111;
                    }
                    else {
                        return 102;}
                }
                else {
                    return 111;}
                }
            case 'a':
                {
                int LA11_190 = input.LA(4);

                if ( (LA11_190=='n') ) {
                    int LA11_251 = input.LA(5);

                    if ( (LA11_251=='s') ) {
                        int LA11_313 = input.LA(6);

                        if ( (LA11_313=='i') ) {
                            int LA11_362 = input.LA(7);

                            if ( (LA11_362=='e') ) {
                                int LA11_406 = input.LA(8);

                                if ( (LA11_406=='n') ) {
                                    int LA11_445 = input.LA(9);

                                    if ( (LA11_445=='t') ) {
                                        int LA11_472 = input.LA(10);

                                        if ( ((LA11_472>='0' && LA11_472<='9')||(LA11_472>='A' && LA11_472<='Z')||LA11_472=='_'||(LA11_472>='a' && LA11_472<='z')) ) {
                                            return 111;
                                        }
                                        else {
                                            return 28;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

            }
        default:
            return 111;}

    }

    private int mTokensHelper014() throws RecognitionException {
        int LA11_14 = input.LA(2);

        if ( (LA11_14=='n') ) {
            switch ( input.LA(3) ) {
            case 'i':
                {
                int LA11_191 = input.LA(4);

                if ( (LA11_191=='q') ) {
                    int LA11_252 = input.LA(5);

                    if ( (LA11_252=='u') ) {
                        int LA11_314 = input.LA(6);

                        if ( (LA11_314=='e') ) {
                            int LA11_363 = input.LA(7);

                            if ( ((LA11_363>='0' && LA11_363<='9')||(LA11_363>='A' && LA11_363<='Z')||LA11_363=='_'||(LA11_363>='a' && LA11_363<='z')) ) {
                                return 111;
                            }
                            else {
                                return 29;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 's':
                {
                int LA11_192 = input.LA(4);

                if ( (LA11_192=='e') ) {
                    int LA11_253 = input.LA(5);

                    if ( (LA11_253=='t') ) {
                        int LA11_315 = input.LA(6);

                        if ( (LA11_315=='t') ) {
                            int LA11_364 = input.LA(7);

                            if ( (LA11_364=='a') ) {
                                int LA11_408 = input.LA(8);

                                if ( (LA11_408=='b') ) {
                                    int LA11_446 = input.LA(9);

                                    if ( (LA11_446=='l') ) {
                                        int LA11_473 = input.LA(10);

                                        if ( (LA11_473=='e') ) {
                                            int LA11_492 = input.LA(11);

                                            if ( ((LA11_492>='0' && LA11_492<='9')||(LA11_492>='A' && LA11_492<='Z')||LA11_492=='_'||(LA11_492>='a' && LA11_492<='z')) ) {
                                                return 111;
                                            }
                                            else {
                                                return 30;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            default:
                return 111;}

        }
        else {
            return 111;}
    }

    private int mTokensHelper015() throws RecognitionException {
        int LA11_15 = input.LA(2);

        if ( (LA11_15=='o') ) {
            int LA11_90 = input.LA(3);

            if ( (LA11_90=='l') ) {
                int LA11_193 = input.LA(4);

                if ( (LA11_193=='a') ) {
                    int LA11_254 = input.LA(5);

                    if ( (LA11_254=='t') ) {
                        int LA11_316 = input.LA(6);

                        if ( (LA11_316=='i') ) {
                            int LA11_365 = input.LA(7);

                            if ( (LA11_365=='l') ) {
                                int LA11_409 = input.LA(8);

                                if ( (LA11_409=='e') ) {
                                    int LA11_447 = input.LA(9);

                                    if ( ((LA11_447>='0' && LA11_447<='9')||(LA11_447>='A' && LA11_447<='Z')||LA11_447=='_'||(LA11_447>='a' && LA11_447<='z')) ) {
                                        return 111;
                                    }
                                    else {
                                        return 31;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper016() throws RecognitionException {
        return 32;
    }

    private int mTokensHelper017() throws RecognitionException {
        return 33;
    }

    private int mTokensHelper018() throws RecognitionException {
        return 34;
    }

    private int mTokensHelper019() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'i':
            {
            int LA11_94 = input.LA(3);

            if ( (LA11_94=='n') ) {
                return 44;
            }
            else if ( (LA11_94=='d') ) {
                return 36;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_UNQUOTED_STRING | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 94, input);

                throw nvae;
            }
            }
        case 'a':
            {
            return 43;
            }
        case 'v':
            {
            return 42;
            }
        case 'u':
            {
            int LA11_97 = input.LA(3);

            if ( (LA11_97=='n') ) {
                int LA11_196 = input.LA(4);

                if ( (LA11_196=='s') ) {
                    return 41;
                }
                else if ( (LA11_196=='i') ) {
                    return 40;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_UNQUOTED_STRING | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 196, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_UNQUOTED_STRING | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 97, input);

                throw nvae;
            }
            }
        case 't':
            {
            return 39;
            }
        case 'r':
            {
            int LA11_99 = input.LA(3);

            if ( (LA11_99=='e') ) {
                int LA11_197 = input.LA(4);

                if ( (LA11_197=='a') ) {
                    return 38;
                }
                else if ( (LA11_197=='s') ) {
                    return 47;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_UNQUOTED_STRING | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 197, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_UNQUOTED_STRING | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 99, input);

                throw nvae;
            }
            }
        case 'o':
            {
            return 37;
            }
        case 'd':
            {
            return 35;
            }
        case 'c':
            {
            return 46;
            }
        case 's':
            {
            return 45;
            }
        default:
            return 116;}

    }

    private int mTokensHelper020() throws RecognitionException {
        int LA11_20 = input.LA(2);

        if ( ((LA11_20>='0' && LA11_20<='9')||(LA11_20>='A' && LA11_20<='Z')||LA11_20=='_'||(LA11_20>='a' && LA11_20<='z')) ) {
            return 111;
        }
        else {
            return 49;}
    }

    private int mTokensHelper021() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '>':
            {
            return 89;
            }
        case '-':
            {
            return 114;
            }
        default:
            return 50;}

    }

    private int mTokensHelper022() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'a':
            {
            int LA11_108 = input.LA(3);

            if ( (LA11_108=='g') ) {
                int LA11_198 = input.LA(4);

                if ( ((LA11_198>='0' && LA11_198<='9')||(LA11_198>='A' && LA11_198<='Z')||LA11_198=='_'||(LA11_198>='a' && LA11_198<='z')) ) {
                    return 111;
                }
                else {
                    return 60;}
            }
            else {
                return 111;}
            }
        case 'o':
            {
            int LA11_109 = input.LA(3);

            if ( (LA11_109=='o') ) {
                int LA11_199 = input.LA(4);

                if ( (LA11_199=='l') ) {
                    int LA11_260 = input.LA(5);

                    if ( (LA11_260=='e') ) {
                        int LA11_317 = input.LA(6);

                        if ( (LA11_317=='a') ) {
                            int LA11_366 = input.LA(7);

                            if ( (LA11_366=='n') ) {
                                int LA11_410 = input.LA(8);

                                if ( ((LA11_410>='0' && LA11_410<='9')||(LA11_410>='A' && LA11_410<='Z')||LA11_410=='_'||(LA11_410>='a' && LA11_410<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 51;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper023() throws RecognitionException {
        int LA11_23 = input.LA(2);

        if ( (LA11_23=='n') ) {
            int LA11_110 = input.LA(3);

            if ( (LA11_110=='t') ) {
                int LA11_200 = input.LA(4);

                if ( (LA11_200=='e') ) {
                    int LA11_261 = input.LA(5);

                    if ( (LA11_261=='g') ) {
                        int LA11_318 = input.LA(6);

                        if ( (LA11_318=='e') ) {
                            int LA11_367 = input.LA(7);

                            if ( (LA11_367=='r') ) {
                                int LA11_411 = input.LA(8);

                                if ( ((LA11_411>='0' && LA11_411<='9')||(LA11_411>='A' && LA11_411<='Z')||LA11_411=='_'||(LA11_411>='a' && LA11_411<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 52;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper024() throws RecognitionException {
        int LA11_24 = input.LA(2);

        if ( (LA11_24=='e') ) {
            int LA11_111 = input.LA(3);

            if ( (LA11_111=='a') ) {
                int LA11_201 = input.LA(4);

                if ( (LA11_201=='l') ) {
                    int LA11_262 = input.LA(5);

                    if ( ((LA11_262>='0' && LA11_262<='9')||(LA11_262>='A' && LA11_262<='Z')||LA11_262=='_'||(LA11_262>='a' && LA11_262<='z')) ) {
                        return 111;
                    }
                    else {
                        return 53;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper025() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'e':
            {
            switch ( input.LA(3) ) {
            case 'q':
                {
                int LA11_202 = input.LA(4);

                if ( (LA11_202=='u') ) {
                    int LA11_263 = input.LA(5);

                    if ( (LA11_263=='e') ) {
                        int LA11_320 = input.LA(6);

                        if ( (LA11_320=='n') ) {
                            int LA11_368 = input.LA(7);

                            if ( (LA11_368=='c') ) {
                                int LA11_412 = input.LA(8);

                                if ( (LA11_412=='e') ) {
                                    int LA11_450 = input.LA(9);

                                    if ( ((LA11_450>='0' && LA11_450<='9')||(LA11_450>='A' && LA11_450<='Z')||LA11_450=='_'||(LA11_450>='a' && LA11_450<='z')) ) {
                                        return 111;
                                    }
                                    else {
                                        return 61;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
                }
            case 't':
                {
                int LA11_203 = input.LA(4);

                if ( ((LA11_203>='0' && LA11_203<='9')||(LA11_203>='A' && LA11_203<='Z')||LA11_203=='_'||(LA11_203>='a' && LA11_203<='z')) ) {
                    return 111;
                }
                else {
                    return 59;}
                }
            default:
                return 111;}

            }
        case 't':
            {
            int LA11_113 = input.LA(3);

            if ( (LA11_113=='r') ) {
                int LA11_204 = input.LA(4);

                if ( (LA11_204=='i') ) {
                    int LA11_265 = input.LA(5);

                    if ( (LA11_265=='n') ) {
                        int LA11_321 = input.LA(6);

                        if ( (LA11_321=='g') ) {
                            int LA11_369 = input.LA(7);

                            if ( ((LA11_369>='0' && LA11_369<='9')||(LA11_369>='A' && LA11_369<='Z')||LA11_369=='_'||(LA11_369>='a' && LA11_369<='z')) ) {
                                return 111;
                            }
                            else {
                                return 54;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper026() throws RecognitionException {
        int LA11_26 = input.LA(2);

        if ( (LA11_26=='n') ) {
            int LA11_114 = input.LA(3);

            if ( (LA11_114=='l') ) {
                int LA11_205 = input.LA(4);

                if ( (LA11_205=='i') ) {
                    int LA11_266 = input.LA(5);

                    if ( (LA11_266=='m') ) {
                        int LA11_322 = input.LA(6);

                        if ( (LA11_322=='i') ) {
                            int LA11_370 = input.LA(7);

                            if ( (LA11_370=='t') ) {
                                int LA11_414 = input.LA(8);

                                if ( (LA11_414=='e') ) {
                                    int LA11_451 = input.LA(9);

                                    if ( (LA11_451=='d') ) {
                                        int LA11_476 = input.LA(10);

                                        if ( (LA11_476=='N') ) {
                                            int LA11_493 = input.LA(11);

                                            if ( (LA11_493=='a') ) {
                                                int LA11_505 = input.LA(12);

                                                if ( (LA11_505=='t') ) {
                                                    int LA11_513 = input.LA(13);

                                                    if ( (LA11_513=='u') ) {
                                                        int LA11_518 = input.LA(14);

                                                        if ( (LA11_518=='r') ) {
                                                            int LA11_521 = input.LA(15);

                                                            if ( (LA11_521=='a') ) {
                                                                int LA11_522 = input.LA(16);

                                                                if ( (LA11_522=='l') ) {
                                                                    int LA11_523 = input.LA(17);

                                                                    if ( ((LA11_523>='0' && LA11_523<='9')||(LA11_523>='A' && LA11_523<='Z')||LA11_523=='_'||(LA11_523>='a' && LA11_523<='z')) ) {
                                                                        return 111;
                                                                    }
                                                                    else {
                                                                        return 55;}
                                                                }
                                                                else {
                                                                    return 111;}
                                                            }
                                                            else {
                                                                return 111;}
                                                        }
                                                        else {
                                                            return 111;}
                                                    }
                                                    else {
                                                        return 111;}
                                                }
                                                else {
                                                    return 111;}
                                            }
                                            else {
                                                return 111;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper027() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'c':
            {
            int LA11_115 = input.LA(3);

            if ( (LA11_115=='l') ) {
                switch ( input.LA(4) ) {
                case 'V':
                    {
                    int LA11_267 = input.LA(5);

                    if ( (LA11_267=='o') ) {
                        int LA11_323 = input.LA(6);

                        if ( (LA11_323=='i') ) {
                            int LA11_371 = input.LA(7);

                            if ( (LA11_371=='d') ) {
                                int LA11_415 = input.LA(8);

                                if ( ((LA11_415>='0' && LA11_415<='9')||(LA11_415>='A' && LA11_415<='Z')||LA11_415=='_'||(LA11_415>='a' && LA11_415<='z')) ) {
                                    return 111;
                                }
                                else {
                                    return 58;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                    }
                case 'I':
                    {
                    int LA11_268 = input.LA(5);

                    if ( (LA11_268=='n') ) {
                        int LA11_324 = input.LA(6);

                        if ( (LA11_324=='v') ) {
                            int LA11_372 = input.LA(7);

                            if ( (LA11_372=='a') ) {
                                int LA11_416 = input.LA(8);

                                if ( (LA11_416=='l') ) {
                                    int LA11_453 = input.LA(9);

                                    if ( (LA11_453=='i') ) {
                                        int LA11_477 = input.LA(10);

                                        if ( (LA11_477=='d') ) {
                                            int LA11_494 = input.LA(11);

                                            if ( ((LA11_494>='0' && LA11_494<='9')||(LA11_494>='A' && LA11_494<='Z')||LA11_494=='_'||(LA11_494>='a' && LA11_494<='z')) ) {
                                                return 111;
                                            }
                                            else {
                                                return 57;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                    }
                case 'A':
                    {
                    int LA11_269 = input.LA(5);

                    if ( (LA11_269=='n') ) {
                        int LA11_325 = input.LA(6);

                        if ( (LA11_325=='y') ) {
                            int LA11_373 = input.LA(7);

                            if ( ((LA11_373>='0' && LA11_373<='9')||(LA11_373>='A' && LA11_373<='Z')||LA11_373=='_'||(LA11_373>='a' && LA11_373<='z')) ) {
                                return 111;
                            }
                            else {
                                return 56;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                    }
                default:
                    return 111;}

            }
            else {
                return 111;}
            }
        case 'r':
            {
            int LA11_116 = input.LA(3);

            if ( (LA11_116=='d') ) {
                int LA11_207 = input.LA(4);

                if ( (LA11_207=='e') ) {
                    int LA11_270 = input.LA(5);

                    if ( (LA11_270=='r') ) {
                        int LA11_326 = input.LA(6);

                        if ( (LA11_326=='e') ) {
                            int LA11_374 = input.LA(7);

                            if ( (LA11_374=='d') ) {
                                int LA11_418 = input.LA(8);

                                if ( (LA11_418=='S') ) {
                                    int LA11_454 = input.LA(9);

                                    if ( (LA11_454=='e') ) {
                                        int LA11_478 = input.LA(10);

                                        if ( (LA11_478=='t') ) {
                                            int LA11_495 = input.LA(11);

                                            if ( ((LA11_495>='0' && LA11_495<='9')||(LA11_495>='A' && LA11_495<='Z')||LA11_495=='_'||(LA11_495>='a' && LA11_495<='z')) ) {
                                                return 111;
                                            }
                                            else {
                                                return 63;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper028() throws RecognitionException {
        int LA11_28 = input.LA(2);

        if ( (LA11_28=='o') ) {
            int LA11_117 = input.LA(3);

            if ( (LA11_117=='l') ) {
                int LA11_208 = input.LA(4);

                if ( (LA11_208=='l') ) {
                    int LA11_271 = input.LA(5);

                    if ( (LA11_271=='e') ) {
                        int LA11_327 = input.LA(6);

                        if ( (LA11_327=='c') ) {
                            int LA11_375 = input.LA(7);

                            if ( (LA11_375=='t') ) {
                                int LA11_419 = input.LA(8);

                                if ( (LA11_419=='i') ) {
                                    int LA11_455 = input.LA(9);

                                    if ( (LA11_455=='o') ) {
                                        int LA11_479 = input.LA(10);

                                        if ( (LA11_479=='n') ) {
                                            int LA11_496 = input.LA(11);

                                            if ( ((LA11_496>='0' && LA11_496<='9')||(LA11_496>='A' && LA11_496<='Z')||LA11_496=='_'||(LA11_496>='a' && LA11_496<='z')) ) {
                                                return 111;
                                            }
                                            else {
                                                return 62;}
                                        }
                                        else {
                                            return 111;}
                                    }
                                    else {
                                        return 111;}
                                }
                                else {
                                    return 111;}
                            }
                            else {
                                return 111;}
                        }
                        else {
                            return 111;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper029() throws RecognitionException {
        return 64;
    }

    private int mTokensHelper030() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '=':
            {
            return 69;
            }
        case '>':
            {
            return 65;
            }
        default:
            return 67;}

    }

    private int mTokensHelper031() throws RecognitionException {
        int LA11_31 = input.LA(2);

        if ( (LA11_31=='=') ) {
            return 68;
        }
        else {
            return 66;}
    }

    private int mTokensHelper032() throws RecognitionException {
        int LA11_32 = input.LA(2);

        if ( (LA11_32=='*') ) {
            return 113;
        }
        else {
            return 70;}
    }

    private int mTokensHelper033() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'o':
            {
            int LA11_126 = input.LA(3);

            if ( (LA11_126=='t') ) {
                int LA11_209 = input.LA(4);

                if ( ((LA11_209>='0' && LA11_209<='9')||(LA11_209>='A' && LA11_209<='Z')||LA11_209=='_'||(LA11_209>='a' && LA11_209<='z')) ) {
                    return 111;
                }
                else {
                    return 71;}
            }
            else {
                return 111;}
            }
        case 'u':
            {
            int LA11_127 = input.LA(3);

            if ( (LA11_127=='l') ) {
                int LA11_210 = input.LA(4);

                if ( (LA11_210=='l') ) {
                    int LA11_273 = input.LA(5);

                    if ( ((LA11_273>='0' && LA11_273<='9')||(LA11_273>='A' && LA11_273<='Z')||LA11_273=='_'||(LA11_273>='a' && LA11_273<='z')) ) {
                        return 111;
                    }
                    else {
                        return 88;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
            }
        default:
            return 111;}

    }

    private int mTokensHelper034() throws RecognitionException {
        int LA11_34 = input.LA(2);

        if ( (LA11_34==':') ) {
            return 82;
        }
        else {
            return 72;}
    }

    private int mTokensHelper035() throws RecognitionException {
        return 73;
    }

    private int mTokensHelper036() throws RecognitionException {
        return 74;
    }

    private int mTokensHelper037() throws RecognitionException {
        return 75;
    }

    private int mTokensHelper038() throws RecognitionException {
        return 76;
    }

    private int mTokensHelper039() throws RecognitionException {
        return 77;
    }

    private int mTokensHelper040() throws RecognitionException {
        return 78;
    }

    private int mTokensHelper041() throws RecognitionException {
        return 79;
    }

    private int mTokensHelper042() throws RecognitionException {
        int LA11_42 = input.LA(2);

        if ( (LA11_42=='.') ) {
            return 80;
        }
        else {
            return 85;}
    }

    private int mTokensHelper043() throws RecognitionException {
        return 83;
    }

    private int mTokensHelper044() throws RecognitionException {
        int LA11_44 = input.LA(2);

        if ( (LA11_44=='&') ) {
            return 84;
        }
        else {
            return 116;}
    }

    private int mTokensHelper045() throws RecognitionException {
        int LA11_45 = input.LA(2);

        if ( (LA11_45=='u') ) {
            int LA11_141 = input.LA(3);

            if ( (LA11_141=='p') ) {
                int LA11_211 = input.LA(4);

                if ( (LA11_211=='l') ) {
                    int LA11_274 = input.LA(5);

                    if ( (LA11_274=='e') ) {
                        int LA11_329 = input.LA(6);

                        if ( ((LA11_329>='0' && LA11_329<='9')||(LA11_329>='A' && LA11_329<='Z')||LA11_329=='_'||(LA11_329>='a' && LA11_329<='z')) ) {
                            return 111;
                        }
                        else {
                            return 86;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper046() throws RecognitionException {
        return 90;
    }

    private int mTokensHelper047() throws RecognitionException {
        int LA11_47 = input.LA(2);

        if ( (LA11_47=='a') ) {
            int LA11_143 = input.LA(3);

            if ( (LA11_143=='l') ) {
                int LA11_212 = input.LA(4);

                if ( (LA11_212=='s') ) {
                    int LA11_275 = input.LA(5);

                    if ( (LA11_275=='e') ) {
                        int LA11_330 = input.LA(6);

                        if ( ((LA11_330>='0' && LA11_330<='9')||(LA11_330>='A' && LA11_330<='Z')||LA11_330=='_'||(LA11_330>='a' && LA11_330<='z')) ) {
                            return 111;
                        }
                        else {
                            return 103;}
                    }
                    else {
                        return 111;}
                }
                else {
                    return 111;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper048() throws RecognitionException {
        int LA11_48 = input.LA(2);

        if ( (LA11_48=='o') ) {
            int LA11_144 = input.LA(3);

            if ( (LA11_144=='r') ) {
                int LA11_213 = input.LA(4);

                if ( ((LA11_213>='0' && LA11_213<='9')||(LA11_213>='A' && LA11_213<='Z')||LA11_213=='_'||(LA11_213>='a' && LA11_213<='z')) ) {
                    return 111;
                }
                else {
                    return 105;}
            }
            else {
                return 111;}
        }
        else {
            return 111;}
    }

    private int mTokensHelper049() throws RecognitionException {
        int LA11_49 = input.LA(2);

        if ( (LA11_49=='$') ) {
            return 108;
        }
        else {
            return 116;}
    }

    private int mTokensHelper050() throws RecognitionException {
        int LA11_50 = input.LA(2);

        if ( ((LA11_50>='\u0000' && LA11_50<='\uFFFE')) ) {
            return 109;
        }
        else {
            return 116;}
    }

    private int mTokensHelper051() throws RecognitionException {
        int LA11_51 = input.LA(2);

        if ( ((LA11_51>='\u0000' && LA11_51<='\uFFFE')) ) {
            return 110;
        }
        else {
            return 116;}
    }

    private int mTokensHelper052() throws RecognitionException {
        return 111;
    }

    private int mTokensHelper053() throws RecognitionException {
        return 111;
    }

    private int mTokensHelper054() throws RecognitionException {
        return 112;
    }

    private int mTokensHelper055() throws RecognitionException {
        return 115;
    }

    private int mTokensHelper056() throws RecognitionException {
        return 116;
    }

    private int mTokensHelper057() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_UNQUOTED_STRING | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ID_TERMINAL | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 11, 0, input);

        throw nvae;
    }



 

}