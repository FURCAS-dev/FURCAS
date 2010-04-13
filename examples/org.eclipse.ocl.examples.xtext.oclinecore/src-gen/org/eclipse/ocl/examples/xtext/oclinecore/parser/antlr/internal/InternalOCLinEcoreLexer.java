/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: InternalOCLinEcoreLexer.java,v 1.1 2010/04/13 06:44:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.parser.antlr.Lexer;

public class InternalOCLinEcoreLexer extends Lexer {
    public static final int T29=29;
    public static final int T70=70;
    public static final int T74=74;
    public static final int T85=85;
    public static final int T20=20;
    public static final int T102=102;
    public static final int T18=18;
    public static final int T103=103;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T81=81;
    public static final int T16=16;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T62=62;
    public static final int T109=109;
    public static final int T68=68;
    public static final int T73=73;
    public static final int T84=84;
    public static final int T33=33;
    public static final int T78=78;
    public static final int T42=42;
    public static final int T96=96;
    public static final int T71=71;
    public static final int T13=13;
    public static final int T72=72;
    public static final int T94=94;
    public static final int T76=76;
    public static final int T75=75;
    public static final int RULE_WS=11;
    public static final int T15=15;
    public static final int T89=89;
    public static final int T67=67;
    public static final int T31=31;
    public static final int T60=60;
    public static final int T82=82;
    public static final int T100=100;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int T30=30;
    public static final int T79=79;
    public static final int T14=14;
    public static final int RULE_OCL=6;
    public static final int T36=36;
    public static final int T58=58;
    public static final int T93=93;
    public static final int T35=35;
    public static final int T107=107;
    public static final int T83=83;
    public static final int T61=61;
    public static final int T45=45;
    public static final int T34=34;
    public static final int T101=101;
    public static final int T64=64;
    public static final int T25=25;
    public static final int T91=91;
    public static final int T105=105;
    public static final int T37=37;
    public static final int T86=86;
    public static final int T26=26;
    public static final int RULE_INT=5;
    public static final int T51=51;
    public static final int T111=111;
    public static final int T46=46;
    public static final int T77=77;
    public static final int T38=38;
    public static final int T106=106;
    public static final int T112=112;
    public static final int T69=69;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T44=44;
    public static final int RULE_ML_COMMENT=9;
    public static final int T55=55;
    public static final int RULE_ID=4;
    public static final int T95=95;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T110=110;
    public static final int T108=108;
    public static final int RULE_STRING_LITERAL=8;
    public static final int T92=92;
    public static final int T43=43;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T40=40;
    public static final int T66=66;
    public static final int T88=88;
    public static final int T63=63;
    public static final int T57=57;
    public static final int T65=65;
    public static final int T98=98;
    public static final int RULE_URL=7;
    public static final int T56=56;
    public static final int T87=87;
    public static final int T80=80;
    public static final int T59=59;
    public static final int T97=97;
    public static final int T48=48;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T104=104;
    public static final int T47=47;
    public static final int Tokens=113;
    public static final int T53=53;
    public static final int RULE_ANY_OTHER=12;
    public static final int T99=99;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T90=90;
    public InternalOCLinEcoreLexer() {;} 
    public InternalOCLinEcoreLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g"; }

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10:5: ( '.' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:11:5: ( '*' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:11:7: '*'
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:12:5: ( 'body' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:12:7: 'body'
            {
            match("body"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:13:5: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:13:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:14:5: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:14:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:15:5: ( 'derivation' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:15:7: 'derivation'
            {
            match("derivation"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:16:5: ( 'initial' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:16:7: 'initial'
            {
            match("initial"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:17:5: ( 'invariant' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:17:7: 'invariant'
            {
            match("invariant"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:18:5: ( 'postcondition' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:18:7: 'postcondition'
            {
            match("postcondition"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:19:5: ( 'precondition' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:19:7: 'precondition'
            {
            match("precondition"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:20:5: ( '@' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:20:7: '@'
            {
            match('@'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:21:5: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:21:7: '('
            {
            match('('); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:22:5: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:22:7: ','
            {
            match(','); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:23:5: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:23:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:24:5: ( 'derived' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:24:7: 'derived'
            {
            match("derived"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:25:5: ( '!derived' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:25:7: '!derived'
            {
            match("!derived"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:26:5: ( 'id' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:26:7: 'id'
            {
            match("id"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:27:5: ( '!id' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:27:7: '!id'
            {
            match("!id"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:28:5: ( 'ordered' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:28:7: 'ordered'
            {
            match("ordered"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:29:5: ( '!ordered' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:29:7: '!ordered'
            {
            match("!ordered"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:30:5: ( 'readonly' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:30:7: 'readonly'
            {
            match("readonly"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:31:5: ( '!readonly' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:31:7: '!readonly'
            {
            match("!readonly"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:32:5: ( 'transient' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:32:7: 'transient'
            {
            match("transient"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:33:5: ( '!transient' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:33:7: '!transient'
            {
            match("!transient"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:34:5: ( 'unique' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:34:7: 'unique'
            {
            match("unique"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:35:5: ( '!unique' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:35:7: '!unique'
            {
            match("!unique"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:36:5: ( 'unsettable' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:36:7: 'unsettable'
            {
            match("unsettable"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:37:5: ( '!unsettable' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:37:7: '!unsettable'
            {
            match("!unsettable"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:38:5: ( 'volatile' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:38:7: 'volatile'
            {
            match("volatile"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:39:5: ( '!volatile' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:39:7: '!volatile'
            {
            match("!volatile"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:40:5: ( 'attribute' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:40:7: 'attribute'
            {
            match("attribute"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:41:5: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:41:7: '['
            {
            match('['); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:42:5: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:42:7: '..'
            {
            match(".."); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:43:5: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:43:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:44:5: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:44:7: '?'
            {
            match('?'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:45:5: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:45:7: ']'
            {
            match(']'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:46:5: ( '=' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:46:7: '='
            {
            match('='); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:47:5: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:47:7: '{'
            {
            match('{'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:48:5: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:48:7: '}'
            {
            match('}'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:49:5: ( 'abstract' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:49:7: 'abstract'
            {
            match("abstract"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:50:5: ( '!abstract' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:50:7: '!abstract'
            {
            match("!abstract"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:51:5: ( 'interface' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:51:7: 'interface'
            {
            match("interface"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:52:5: ( '!interface' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:52:7: '!interface'
            {
            match("!interface"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:53:5: ( 'class' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:53:7: 'class'
            {
            match("class"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:54:5: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:54:7: '<'
            {
            match('<'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:55:5: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:55:7: '>'
            {
            match('>'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:56:5: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:56:7: 'extends'
            {
            match("extends"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:57:5: ( 'datatype' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:57:7: 'datatype'
            {
            match("datatype"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:58:5: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:58:7: '::'
            {
            match("::"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:59:5: ( 'enum' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:59:7: 'enum'
            {
            match("enum"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:60:5: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:60:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:61:5: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:61:7: 'operation'
            {
            match("operation"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:62:5: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:62:7: 'package'
            {
            match("package"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:63:5: ( 'resolve' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:63:7: 'resolve'
            {
            match("resolve"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:64:5: ( '!resolve' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:64:7: '!resolve'
            {
            match("!resolve"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:65:5: ( 'reference' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:65:7: 'reference'
            {
            match("reference"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:66:5: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:66:7: 'property'
            {
            match("property"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:67:5: ( '#' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:67:7: '#'
            {
            match('#'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:68:5: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:68:7: '&&'
            {
            match("&&"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:69:5: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:69:7: 'super'
            {
            match("super"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:70:5: ( 'e' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:70:7: 'e'
            {
            match('e'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:71:5: ( 'E' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:71:7: 'E'
            {
            match('E'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:72:5: ( '-' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:72:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:73:5: ( 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:73:7: 'Tuple'
            {
            match("Tuple"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:74:5: ( 'self' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:74:7: 'self'
            {
            match("self"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:75:5: ( 'Boolean' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:75:7: 'Boolean'
            {
            match("Boolean"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:76:5: ( 'Integer' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:76:7: 'Integer'
            {
            match("Integer"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:77:5: ( 'Real' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:77:7: 'Real'
            {
            match("Real"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:78:5: ( 'String' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:78:7: 'String'
            {
            match("String"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:79:5: ( 'UnlimitedNatural' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:79:7: 'UnlimitedNatural'
            {
            match("UnlimitedNatural"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:80:5: ( 'OclAny' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:80:7: 'OclAny'
            {
            match("OclAny"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:81:5: ( 'OclInvalid' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:81:7: 'OclInvalid'
            {
            match("OclInvalid"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:82:5: ( 'OclVoid' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:82:7: 'OclVoid'
            {
            match("OclVoid"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:83:5: ( 'Set' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:83:7: 'Set'
            {
            match("Set"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:84:5: ( 'Bag' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:84:7: 'Bag'
            {
            match("Bag"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:85:5: ( 'Sequence' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:85:7: 'Sequence'
            {
            match("Sequence"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:86:5: ( 'Collection' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:86:7: 'Collection'
            {
            match("Collection"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:87:5: ( 'OrderedSet' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:87:7: 'OrderedSet'
            {
            match("OrderedSet"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:88:5: ( 'true' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:88:7: 'true'
            {
            match("true"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:89:5: ( 'false' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:89:7: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:90:5: ( 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:90:7: 'invalid'
            {
            match("invalid"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:91:5: ( 'null' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:91:7: 'null'
            {
            match("null"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:92:5: ( 'implies' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:92:7: 'implies'
            {
            match("implies"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:93:5: ( 'xor' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:93:7: 'xor'
            {
            match("xor"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:94:5: ( 'or' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:94:7: 'or'
            {
            match("or"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:95:5: ( 'and' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:95:7: 'and'
            {
            match("and"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:96:5: ( '<>' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:96:7: '<>'
            {
            match("<>"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:97:6: ( '>=' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:97:8: '>='
            {
            match(">="); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:98:6: ( '<=' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:98:8: '<='
            {
            match("<="); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:99:6: ( '/' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:99:8: '/'
            {
            match('/'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:100:6: ( 'not' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:100:8: 'not'
            {
            match("not"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:101:6: ( '->' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:101:8: '->'
            {
            match("->"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:102:6: ( '|' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:102:8: '|'
            {
            match('|'); 

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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:103:6: ( '@pre' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:103:8: '@pre'
            {
            match("@pre"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:104:6: ( 'if' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:104:8: 'if'
            {
            match("if"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:105:6: ( 'then' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:105:8: 'then'
            {
            match("then"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:106:6: ( 'else' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:106:8: 'else'
            {
            match("else"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:107:6: ( 'endif' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:107:8: 'endif'
            {
            match("endif"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:108:6: ( 'let' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:108:8: 'let'
            {
            match("let"); 


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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:109:6: ( 'in' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:109:8: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T112

    // $ANTLR start RULE_URL
    public final void mRULE_URL() throws RecognitionException {
        try {
            int _type = RULE_URL;
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10160:10: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10160:12: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10160:16: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10160:17: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10160:58: ~ ( ( '\\\\' | '\"' ) )
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
    // $ANTLR end RULE_URL

    // $ANTLR start RULE_OCL
    public final void mRULE_OCL() throws RecognitionException {
        try {
            int _type = RULE_OCL;
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10162:10: ( '\\u00A3' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\\u00A3' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10162:12: '\\u00A3' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\\u00A3'
            {
            match('\u00A3'); 
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10162:21: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\u00A3') ) {
                    int LA2_1 = input.LA(2);

                    if ( ((LA2_1>='\u0000' && LA2_1<='!')||(LA2_1>='#' && LA2_1<='\uFFFE')) ) {
                        alt2=2;
                    }


                }
                else if ( (LA2_0=='\\') ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\u00A2')||(LA2_0>='\u00A4' && LA2_0<='\uFFFE')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10162:22: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10162:63: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop2;
                }
            } while (true);

            match('\u00A3'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_OCL

    // $ANTLR start RULE_STRING_LITERAL
    public final void mRULE_STRING_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_STRING_LITERAL;
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10164:21: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10164:23: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10164:28: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFE')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10164:29: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10164:70: ~ ( ( '\\\\' | '\\'' ) )
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
            	    break loop3;
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

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10166:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10166:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10166:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='_') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='\'') ) {
                    alt5=2;
                }
                else {
                    alt5=1;}
            }
            else if ( ((LA5_0>='A' && LA5_0<='Z')||(LA5_0>='a' && LA5_0<='z')) ) {
                alt5=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("10166:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '_' RULE_STRING_LITERAL )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10166:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10166:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:
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
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10166:70: '_' RULE_STRING_LITERAL
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
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10168:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10168:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10168:12: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10168:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10170:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10170:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10170:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10170:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10172:41: '\\r'
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10174:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10174:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10174:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10176:16: ( . )
            // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:10176:18: .
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
        // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:8: ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | RULE_URL | RULE_OCL | RULE_STRING_LITERAL | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=109;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='.') ) {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='.') ) {
                alt12=33;
            }
            else {
                alt12=1;}
        }
        else if ( (LA12_0=='*') ) {
            alt12=2;
        }
        else if ( (LA12_0=='b') ) {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='o') ) {
                int LA12_61 = input.LA(3);

                if ( (LA12_61=='d') ) {
                    int LA12_147 = input.LA(4);

                    if ( (LA12_147=='y') ) {
                        int LA12_204 = input.LA(5);

                        if ( ((LA12_204>='0' && LA12_204<='9')||(LA12_204>='A' && LA12_204<='Z')||LA12_204=='_'||(LA12_204>='a' && LA12_204<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=3;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0==':') ) {
            int LA12_4 = input.LA(2);

            if ( (LA12_4==':') ) {
                alt12=49;
            }
            else {
                alt12=4;}
        }
        else if ( (LA12_0==';') ) {
            alt12=5;
        }
        else if ( (LA12_0=='d') ) {
            switch ( input.LA(2) ) {
            case 'e':
                {
                int LA12_66 = input.LA(3);

                if ( (LA12_66=='r') ) {
                    int LA12_148 = input.LA(4);

                    if ( (LA12_148=='i') ) {
                        int LA12_205 = input.LA(5);

                        if ( (LA12_205=='v') ) {
                            switch ( input.LA(6) ) {
                            case 'e':
                                {
                                int LA12_307 = input.LA(7);

                                if ( (LA12_307=='d') ) {
                                    int LA12_347 = input.LA(8);

                                    if ( ((LA12_347>='0' && LA12_347<='9')||(LA12_347>='A' && LA12_347<='Z')||LA12_347=='_'||(LA12_347>='a' && LA12_347<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=15;}
                                }
                                else {
                                    alt12=104;}
                                }
                                break;
                            case 'a':
                                {
                                int LA12_308 = input.LA(7);

                                if ( (LA12_308=='t') ) {
                                    int LA12_348 = input.LA(8);

                                    if ( (LA12_348=='i') ) {
                                        int LA12_383 = input.LA(9);

                                        if ( (LA12_383=='o') ) {
                                            int LA12_413 = input.LA(10);

                                            if ( (LA12_413=='n') ) {
                                                int LA12_433 = input.LA(11);

                                                if ( ((LA12_433>='0' && LA12_433<='9')||(LA12_433>='A' && LA12_433<='Z')||LA12_433=='_'||(LA12_433>='a' && LA12_433<='z')) ) {
                                                    alt12=104;
                                                }
                                                else {
                                                    alt12=6;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                                }
                                break;
                            default:
                                alt12=104;}

                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'a':
                {
                int LA12_67 = input.LA(3);

                if ( (LA12_67=='t') ) {
                    int LA12_149 = input.LA(4);

                    if ( (LA12_149=='a') ) {
                        int LA12_206 = input.LA(5);

                        if ( (LA12_206=='t') ) {
                            int LA12_262 = input.LA(6);

                            if ( (LA12_262=='y') ) {
                                int LA12_309 = input.LA(7);

                                if ( (LA12_309=='p') ) {
                                    int LA12_349 = input.LA(8);

                                    if ( (LA12_349=='e') ) {
                                        int LA12_384 = input.LA(9);

                                        if ( ((LA12_384>='0' && LA12_384<='9')||(LA12_384>='A' && LA12_384<='Z')||LA12_384=='_'||(LA12_384>='a' && LA12_384<='z')) ) {
                                            alt12=104;
                                        }
                                        else {
                                            alt12=48;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='i') ) {
            switch ( input.LA(2) ) {
            case 'm':
                {
                int LA12_68 = input.LA(3);

                if ( (LA12_68=='p') ) {
                    switch ( input.LA(4) ) {
                    case 'l':
                        {
                        int LA12_207 = input.LA(5);

                        if ( (LA12_207=='i') ) {
                            int LA12_263 = input.LA(6);

                            if ( (LA12_263=='e') ) {
                                int LA12_310 = input.LA(7);

                                if ( (LA12_310=='s') ) {
                                    int LA12_350 = input.LA(8);

                                    if ( ((LA12_350>='0' && LA12_350<='9')||(LA12_350>='A' && LA12_350<='Z')||LA12_350=='_'||(LA12_350>='a' && LA12_350<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=83;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                        }
                        break;
                    case 'o':
                        {
                        int LA12_208 = input.LA(5);

                        if ( (LA12_208=='r') ) {
                            int LA12_264 = input.LA(6);

                            if ( (LA12_264=='t') ) {
                                int LA12_311 = input.LA(7);

                                if ( ((LA12_311>='0' && LA12_311<='9')||(LA12_311>='A' && LA12_311<='Z')||LA12_311=='_'||(LA12_311>='a' && LA12_311<='z')) ) {
                                    alt12=104;
                                }
                                else {
                                    alt12=51;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                        }
                        break;
                    default:
                        alt12=104;}

                }
                else {
                    alt12=104;}
                }
                break;
            case 'n':
                {
                switch ( input.LA(3) ) {
                case 'i':
                    {
                    int LA12_151 = input.LA(4);

                    if ( (LA12_151=='t') ) {
                        int LA12_209 = input.LA(5);

                        if ( (LA12_209=='i') ) {
                            int LA12_265 = input.LA(6);

                            if ( (LA12_265=='a') ) {
                                int LA12_312 = input.LA(7);

                                if ( (LA12_312=='l') ) {
                                    int LA12_352 = input.LA(8);

                                    if ( ((LA12_352>='0' && LA12_352<='9')||(LA12_352>='A' && LA12_352<='Z')||LA12_352=='_'||(LA12_352>='a' && LA12_352<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=7;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 'v':
                    {
                    int LA12_152 = input.LA(4);

                    if ( (LA12_152=='a') ) {
                        switch ( input.LA(5) ) {
                        case 'l':
                            {
                            int LA12_266 = input.LA(6);

                            if ( (LA12_266=='i') ) {
                                int LA12_313 = input.LA(7);

                                if ( (LA12_313=='d') ) {
                                    int LA12_353 = input.LA(8);

                                    if ( ((LA12_353>='0' && LA12_353<='9')||(LA12_353>='A' && LA12_353<='Z')||LA12_353=='_'||(LA12_353>='a' && LA12_353<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=81;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                            }
                            break;
                        case 'r':
                            {
                            int LA12_267 = input.LA(6);

                            if ( (LA12_267=='i') ) {
                                int LA12_314 = input.LA(7);

                                if ( (LA12_314=='a') ) {
                                    int LA12_354 = input.LA(8);

                                    if ( (LA12_354=='n') ) {
                                        int LA12_388 = input.LA(9);

                                        if ( (LA12_388=='t') ) {
                                            int LA12_415 = input.LA(10);

                                            if ( ((LA12_415>='0' && LA12_415<='9')||(LA12_415>='A' && LA12_415<='Z')||LA12_415=='_'||(LA12_415>='a' && LA12_415<='z')) ) {
                                                alt12=104;
                                            }
                                            else {
                                                alt12=8;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                            }
                            break;
                        default:
                            alt12=104;}

                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 't':
                    {
                    int LA12_153 = input.LA(4);

                    if ( (LA12_153=='e') ) {
                        int LA12_211 = input.LA(5);

                        if ( (LA12_211=='r') ) {
                            int LA12_268 = input.LA(6);

                            if ( (LA12_268=='f') ) {
                                int LA12_315 = input.LA(7);

                                if ( (LA12_315=='a') ) {
                                    int LA12_355 = input.LA(8);

                                    if ( (LA12_355=='c') ) {
                                        int LA12_389 = input.LA(9);

                                        if ( (LA12_389=='e') ) {
                                            int LA12_416 = input.LA(10);

                                            if ( ((LA12_416>='0' && LA12_416<='9')||(LA12_416>='A' && LA12_416<='Z')||LA12_416=='_'||(LA12_416>='a' && LA12_416<='z')) ) {
                                                alt12=104;
                                            }
                                            else {
                                                alt12=42;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
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
                    alt12=104;
                    }
                    break;
                default:
                    alt12=100;}

                }
                break;
            case 'f':
                {
                int LA12_70 = input.LA(3);

                if ( ((LA12_70>='0' && LA12_70<='9')||(LA12_70>='A' && LA12_70<='Z')||LA12_70=='_'||(LA12_70>='a' && LA12_70<='z')) ) {
                    alt12=104;
                }
                else {
                    alt12=95;}
                }
                break;
            case 'd':
                {
                int LA12_71 = input.LA(3);

                if ( ((LA12_71>='0' && LA12_71<='9')||(LA12_71>='A' && LA12_71<='Z')||LA12_71=='_'||(LA12_71>='a' && LA12_71<='z')) ) {
                    alt12=104;
                }
                else {
                    alt12=17;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='p') ) {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA12_72 = input.LA(3);

                if ( (LA12_72=='s') ) {
                    int LA12_157 = input.LA(4);

                    if ( (LA12_157=='t') ) {
                        int LA12_212 = input.LA(5);

                        if ( (LA12_212=='c') ) {
                            int LA12_269 = input.LA(6);

                            if ( (LA12_269=='o') ) {
                                int LA12_316 = input.LA(7);

                                if ( (LA12_316=='n') ) {
                                    int LA12_356 = input.LA(8);

                                    if ( (LA12_356=='d') ) {
                                        int LA12_390 = input.LA(9);

                                        if ( (LA12_390=='i') ) {
                                            int LA12_417 = input.LA(10);

                                            if ( (LA12_417=='t') ) {
                                                int LA12_436 = input.LA(11);

                                                if ( (LA12_436=='i') ) {
                                                    int LA12_448 = input.LA(12);

                                                    if ( (LA12_448=='o') ) {
                                                        int LA12_455 = input.LA(13);

                                                        if ( (LA12_455=='n') ) {
                                                            int LA12_458 = input.LA(14);

                                                            if ( ((LA12_458>='0' && LA12_458<='9')||(LA12_458>='A' && LA12_458<='Z')||LA12_458=='_'||(LA12_458>='a' && LA12_458<='z')) ) {
                                                                alt12=104;
                                                            }
                                                            else {
                                                                alt12=9;}
                                                        }
                                                        else {
                                                            alt12=104;}
                                                    }
                                                    else {
                                                        alt12=104;}
                                                }
                                                else {
                                                    alt12=104;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'o':
                    {
                    int LA12_158 = input.LA(4);

                    if ( (LA12_158=='p') ) {
                        int LA12_213 = input.LA(5);

                        if ( (LA12_213=='e') ) {
                            int LA12_270 = input.LA(6);

                            if ( (LA12_270=='r') ) {
                                int LA12_317 = input.LA(7);

                                if ( (LA12_317=='t') ) {
                                    int LA12_357 = input.LA(8);

                                    if ( (LA12_357=='y') ) {
                                        int LA12_391 = input.LA(9);

                                        if ( ((LA12_391>='0' && LA12_391<='9')||(LA12_391>='A' && LA12_391<='Z')||LA12_391=='_'||(LA12_391>='a' && LA12_391<='z')) ) {
                                            alt12=104;
                                        }
                                        else {
                                            alt12=57;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 'e':
                    {
                    int LA12_159 = input.LA(4);

                    if ( (LA12_159=='c') ) {
                        int LA12_214 = input.LA(5);

                        if ( (LA12_214=='o') ) {
                            int LA12_271 = input.LA(6);

                            if ( (LA12_271=='n') ) {
                                int LA12_318 = input.LA(7);

                                if ( (LA12_318=='d') ) {
                                    int LA12_358 = input.LA(8);

                                    if ( (LA12_358=='i') ) {
                                        int LA12_392 = input.LA(9);

                                        if ( (LA12_392=='t') ) {
                                            int LA12_419 = input.LA(10);

                                            if ( (LA12_419=='i') ) {
                                                int LA12_437 = input.LA(11);

                                                if ( (LA12_437=='o') ) {
                                                    int LA12_449 = input.LA(12);

                                                    if ( (LA12_449=='n') ) {
                                                        int LA12_456 = input.LA(13);

                                                        if ( ((LA12_456>='0' && LA12_456<='9')||(LA12_456>='A' && LA12_456<='Z')||LA12_456=='_'||(LA12_456>='a' && LA12_456<='z')) ) {
                                                            alt12=104;
                                                        }
                                                        else {
                                                            alt12=10;}
                                                    }
                                                    else {
                                                        alt12=104;}
                                                }
                                                else {
                                                    alt12=104;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                default:
                    alt12=104;}

                }
                break;
            case 'a':
                {
                int LA12_74 = input.LA(3);

                if ( (LA12_74=='c') ) {
                    int LA12_160 = input.LA(4);

                    if ( (LA12_160=='k') ) {
                        int LA12_215 = input.LA(5);

                        if ( (LA12_215=='a') ) {
                            int LA12_272 = input.LA(6);

                            if ( (LA12_272=='g') ) {
                                int LA12_319 = input.LA(7);

                                if ( (LA12_319=='e') ) {
                                    int LA12_359 = input.LA(8);

                                    if ( ((LA12_359>='0' && LA12_359<='9')||(LA12_359>='A' && LA12_359<='Z')||LA12_359=='_'||(LA12_359>='a' && LA12_359<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=53;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='@') ) {
            int LA12_9 = input.LA(2);

            if ( (LA12_9=='p') ) {
                alt12=94;
            }
            else {
                alt12=11;}
        }
        else if ( (LA12_0=='(') ) {
            alt12=12;
        }
        else if ( (LA12_0==',') ) {
            alt12=13;
        }
        else if ( (LA12_0==')') ) {
            alt12=14;
        }
        else if ( (LA12_0=='!') ) {
            switch ( input.LA(2) ) {
            case 't':
                {
                alt12=24;
                }
                break;
            case 'v':
                {
                alt12=30;
                }
                break;
            case 'r':
                {
                int LA12_82 = input.LA(3);

                if ( (LA12_82=='e') ) {
                    int LA12_161 = input.LA(4);

                    if ( (LA12_161=='a') ) {
                        alt12=22;
                    }
                    else if ( (LA12_161=='s') ) {
                        alt12=55;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | RULE_URL | RULE_OCL | RULE_STRING_LITERAL | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 161, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | RULE_URL | RULE_OCL | RULE_STRING_LITERAL | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 82, input);

                    throw nvae;
                }
                }
                break;
            case 'd':
                {
                alt12=16;
                }
                break;
            case 'a':
                {
                alt12=41;
                }
                break;
            case 'u':
                {
                int LA12_85 = input.LA(3);

                if ( (LA12_85=='n') ) {
                    int LA12_162 = input.LA(4);

                    if ( (LA12_162=='s') ) {
                        alt12=28;
                    }
                    else if ( (LA12_162=='i') ) {
                        alt12=26;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | RULE_URL | RULE_OCL | RULE_STRING_LITERAL | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 162, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | RULE_URL | RULE_OCL | RULE_STRING_LITERAL | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 85, input);

                    throw nvae;
                }
                }
                break;
            case 'o':
                {
                alt12=20;
                }
                break;
            case 'i':
                {
                int LA12_87 = input.LA(3);

                if ( (LA12_87=='d') ) {
                    alt12=18;
                }
                else if ( (LA12_87=='n') ) {
                    alt12=43;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | RULE_URL | RULE_OCL | RULE_STRING_LITERAL | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 87, input);

                    throw nvae;
                }
                }
                break;
            default:
                alt12=109;}

        }
        else if ( (LA12_0=='o') ) {
            switch ( input.LA(2) ) {
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'd':
                    {
                    int LA12_165 = input.LA(4);

                    if ( (LA12_165=='e') ) {
                        int LA12_220 = input.LA(5);

                        if ( (LA12_220=='r') ) {
                            int LA12_273 = input.LA(6);

                            if ( (LA12_273=='e') ) {
                                int LA12_320 = input.LA(7);

                                if ( (LA12_320=='d') ) {
                                    int LA12_360 = input.LA(8);

                                    if ( ((LA12_360>='0' && LA12_360<='9')||(LA12_360>='A' && LA12_360<='Z')||LA12_360=='_'||(LA12_360>='a' && LA12_360<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=19;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
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
                    alt12=104;
                    }
                    break;
                default:
                    alt12=85;}

                }
                break;
            case 'p':
                {
                int LA12_89 = input.LA(3);

                if ( (LA12_89=='e') ) {
                    int LA12_167 = input.LA(4);

                    if ( (LA12_167=='r') ) {
                        int LA12_221 = input.LA(5);

                        if ( (LA12_221=='a') ) {
                            int LA12_274 = input.LA(6);

                            if ( (LA12_274=='t') ) {
                                int LA12_321 = input.LA(7);

                                if ( (LA12_321=='i') ) {
                                    int LA12_361 = input.LA(8);

                                    if ( (LA12_361=='o') ) {
                                        int LA12_395 = input.LA(9);

                                        if ( (LA12_395=='n') ) {
                                            int LA12_420 = input.LA(10);

                                            if ( ((LA12_420>='0' && LA12_420<='9')||(LA12_420>='A' && LA12_420<='Z')||LA12_420=='_'||(LA12_420>='a' && LA12_420<='z')) ) {
                                                alt12=104;
                                            }
                                            else {
                                                alt12=52;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='r') ) {
            int LA12_15 = input.LA(2);

            if ( (LA12_15=='e') ) {
                switch ( input.LA(3) ) {
                case 'a':
                    {
                    int LA12_168 = input.LA(4);

                    if ( (LA12_168=='d') ) {
                        int LA12_222 = input.LA(5);

                        if ( (LA12_222=='o') ) {
                            int LA12_275 = input.LA(6);

                            if ( (LA12_275=='n') ) {
                                int LA12_322 = input.LA(7);

                                if ( (LA12_322=='l') ) {
                                    int LA12_362 = input.LA(8);

                                    if ( (LA12_362=='y') ) {
                                        int LA12_396 = input.LA(9);

                                        if ( ((LA12_396>='0' && LA12_396<='9')||(LA12_396>='A' && LA12_396<='Z')||LA12_396=='_'||(LA12_396>='a' && LA12_396<='z')) ) {
                                            alt12=104;
                                        }
                                        else {
                                            alt12=21;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 'f':
                    {
                    int LA12_169 = input.LA(4);

                    if ( (LA12_169=='e') ) {
                        int LA12_223 = input.LA(5);

                        if ( (LA12_223=='r') ) {
                            int LA12_276 = input.LA(6);

                            if ( (LA12_276=='e') ) {
                                int LA12_323 = input.LA(7);

                                if ( (LA12_323=='n') ) {
                                    int LA12_363 = input.LA(8);

                                    if ( (LA12_363=='c') ) {
                                        int LA12_397 = input.LA(9);

                                        if ( (LA12_397=='e') ) {
                                            int LA12_422 = input.LA(10);

                                            if ( ((LA12_422>='0' && LA12_422<='9')||(LA12_422>='A' && LA12_422<='Z')||LA12_422=='_'||(LA12_422>='a' && LA12_422<='z')) ) {
                                                alt12=104;
                                            }
                                            else {
                                                alt12=56;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 's':
                    {
                    int LA12_170 = input.LA(4);

                    if ( (LA12_170=='o') ) {
                        int LA12_224 = input.LA(5);

                        if ( (LA12_224=='l') ) {
                            int LA12_277 = input.LA(6);

                            if ( (LA12_277=='v') ) {
                                int LA12_324 = input.LA(7);

                                if ( (LA12_324=='e') ) {
                                    int LA12_364 = input.LA(8);

                                    if ( ((LA12_364>='0' && LA12_364<='9')||(LA12_364>='A' && LA12_364<='Z')||LA12_364=='_'||(LA12_364>='a' && LA12_364<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=54;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                default:
                    alt12=104;}

            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='t') ) {
            switch ( input.LA(2) ) {
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'a':
                    {
                    int LA12_171 = input.LA(4);

                    if ( (LA12_171=='n') ) {
                        int LA12_225 = input.LA(5);

                        if ( (LA12_225=='s') ) {
                            int LA12_278 = input.LA(6);

                            if ( (LA12_278=='i') ) {
                                int LA12_325 = input.LA(7);

                                if ( (LA12_325=='e') ) {
                                    int LA12_365 = input.LA(8);

                                    if ( (LA12_365=='n') ) {
                                        int LA12_399 = input.LA(9);

                                        if ( (LA12_399=='t') ) {
                                            int LA12_423 = input.LA(10);

                                            if ( ((LA12_423>='0' && LA12_423<='9')||(LA12_423>='A' && LA12_423<='Z')||LA12_423=='_'||(LA12_423>='a' && LA12_423<='z')) ) {
                                                alt12=104;
                                            }
                                            else {
                                                alt12=23;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 'u':
                    {
                    int LA12_172 = input.LA(4);

                    if ( (LA12_172=='e') ) {
                        int LA12_226 = input.LA(5);

                        if ( ((LA12_226>='0' && LA12_226<='9')||(LA12_226>='A' && LA12_226<='Z')||LA12_226=='_'||(LA12_226>='a' && LA12_226<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=79;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                default:
                    alt12=104;}

                }
                break;
            case 'h':
                {
                int LA12_92 = input.LA(3);

                if ( (LA12_92=='e') ) {
                    int LA12_173 = input.LA(4);

                    if ( (LA12_173=='n') ) {
                        int LA12_227 = input.LA(5);

                        if ( ((LA12_227>='0' && LA12_227<='9')||(LA12_227>='A' && LA12_227<='Z')||LA12_227=='_'||(LA12_227>='a' && LA12_227<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=96;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='u') ) {
            int LA12_17 = input.LA(2);

            if ( (LA12_17=='n') ) {
                switch ( input.LA(3) ) {
                case 'i':
                    {
                    int LA12_174 = input.LA(4);

                    if ( (LA12_174=='q') ) {
                        int LA12_228 = input.LA(5);

                        if ( (LA12_228=='u') ) {
                            int LA12_281 = input.LA(6);

                            if ( (LA12_281=='e') ) {
                                int LA12_326 = input.LA(7);

                                if ( ((LA12_326>='0' && LA12_326<='9')||(LA12_326>='A' && LA12_326<='Z')||LA12_326=='_'||(LA12_326>='a' && LA12_326<='z')) ) {
                                    alt12=104;
                                }
                                else {
                                    alt12=25;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 's':
                    {
                    int LA12_175 = input.LA(4);

                    if ( (LA12_175=='e') ) {
                        int LA12_229 = input.LA(5);

                        if ( (LA12_229=='t') ) {
                            int LA12_282 = input.LA(6);

                            if ( (LA12_282=='t') ) {
                                int LA12_327 = input.LA(7);

                                if ( (LA12_327=='a') ) {
                                    int LA12_367 = input.LA(8);

                                    if ( (LA12_367=='b') ) {
                                        int LA12_400 = input.LA(9);

                                        if ( (LA12_400=='l') ) {
                                            int LA12_424 = input.LA(10);

                                            if ( (LA12_424=='e') ) {
                                                int LA12_441 = input.LA(11);

                                                if ( ((LA12_441>='0' && LA12_441<='9')||(LA12_441>='A' && LA12_441<='Z')||LA12_441=='_'||(LA12_441>='a' && LA12_441<='z')) ) {
                                                    alt12=104;
                                                }
                                                else {
                                                    alt12=27;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                default:
                    alt12=104;}

            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='v') ) {
            int LA12_18 = input.LA(2);

            if ( (LA12_18=='o') ) {
                int LA12_94 = input.LA(3);

                if ( (LA12_94=='l') ) {
                    int LA12_176 = input.LA(4);

                    if ( (LA12_176=='a') ) {
                        int LA12_230 = input.LA(5);

                        if ( (LA12_230=='t') ) {
                            int LA12_283 = input.LA(6);

                            if ( (LA12_283=='i') ) {
                                int LA12_328 = input.LA(7);

                                if ( (LA12_328=='l') ) {
                                    int LA12_368 = input.LA(8);

                                    if ( (LA12_368=='e') ) {
                                        int LA12_401 = input.LA(9);

                                        if ( ((LA12_401>='0' && LA12_401<='9')||(LA12_401>='A' && LA12_401<='Z')||LA12_401=='_'||(LA12_401>='a' && LA12_401<='z')) ) {
                                            alt12=104;
                                        }
                                        else {
                                            alt12=29;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='a') ) {
            switch ( input.LA(2) ) {
            case 't':
                {
                int LA12_95 = input.LA(3);

                if ( (LA12_95=='t') ) {
                    int LA12_177 = input.LA(4);

                    if ( (LA12_177=='r') ) {
                        int LA12_231 = input.LA(5);

                        if ( (LA12_231=='i') ) {
                            int LA12_284 = input.LA(6);

                            if ( (LA12_284=='b') ) {
                                int LA12_329 = input.LA(7);

                                if ( (LA12_329=='u') ) {
                                    int LA12_369 = input.LA(8);

                                    if ( (LA12_369=='t') ) {
                                        int LA12_402 = input.LA(9);

                                        if ( (LA12_402=='e') ) {
                                            int LA12_426 = input.LA(10);

                                            if ( ((LA12_426>='0' && LA12_426<='9')||(LA12_426>='A' && LA12_426<='Z')||LA12_426=='_'||(LA12_426>='a' && LA12_426<='z')) ) {
                                                alt12=104;
                                            }
                                            else {
                                                alt12=31;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'n':
                {
                int LA12_96 = input.LA(3);

                if ( (LA12_96=='d') ) {
                    int LA12_178 = input.LA(4);

                    if ( ((LA12_178>='0' && LA12_178<='9')||(LA12_178>='A' && LA12_178<='Z')||LA12_178=='_'||(LA12_178>='a' && LA12_178<='z')) ) {
                        alt12=104;
                    }
                    else {
                        alt12=86;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'b':
                {
                int LA12_97 = input.LA(3);

                if ( (LA12_97=='s') ) {
                    int LA12_179 = input.LA(4);

                    if ( (LA12_179=='t') ) {
                        int LA12_233 = input.LA(5);

                        if ( (LA12_233=='r') ) {
                            int LA12_285 = input.LA(6);

                            if ( (LA12_285=='a') ) {
                                int LA12_330 = input.LA(7);

                                if ( (LA12_330=='c') ) {
                                    int LA12_370 = input.LA(8);

                                    if ( (LA12_370=='t') ) {
                                        int LA12_403 = input.LA(9);

                                        if ( ((LA12_403>='0' && LA12_403<='9')||(LA12_403>='A' && LA12_403<='Z')||LA12_403=='_'||(LA12_403>='a' && LA12_403<='z')) ) {
                                            alt12=104;
                                        }
                                        else {
                                            alt12=40;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='[') ) {
            alt12=32;
        }
        else if ( (LA12_0=='+') ) {
            alt12=34;
        }
        else if ( (LA12_0=='?') ) {
            alt12=35;
        }
        else if ( (LA12_0==']') ) {
            alt12=36;
        }
        else if ( (LA12_0=='=') ) {
            alt12=37;
        }
        else if ( (LA12_0=='{') ) {
            alt12=38;
        }
        else if ( (LA12_0=='}') ) {
            alt12=39;
        }
        else if ( (LA12_0=='c') ) {
            int LA12_27 = input.LA(2);

            if ( (LA12_27=='l') ) {
                int LA12_105 = input.LA(3);

                if ( (LA12_105=='a') ) {
                    int LA12_180 = input.LA(4);

                    if ( (LA12_180=='s') ) {
                        int LA12_234 = input.LA(5);

                        if ( (LA12_234=='s') ) {
                            int LA12_286 = input.LA(6);

                            if ( ((LA12_286>='0' && LA12_286<='9')||(LA12_286>='A' && LA12_286<='Z')||LA12_286=='_'||(LA12_286>='a' && LA12_286<='z')) ) {
                                alt12=104;
                            }
                            else {
                                alt12=44;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='<') ) {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt12=87;
                }
                break;
            case '=':
                {
                alt12=89;
                }
                break;
            default:
                alt12=45;}

        }
        else if ( (LA12_0=='>') ) {
            int LA12_29 = input.LA(2);

            if ( (LA12_29=='=') ) {
                alt12=88;
            }
            else {
                alt12=46;}
        }
        else if ( (LA12_0=='e') ) {
            switch ( input.LA(2) ) {
            case 'n':
                {
                switch ( input.LA(3) ) {
                case 'd':
                    {
                    int LA12_181 = input.LA(4);

                    if ( (LA12_181=='i') ) {
                        int LA12_235 = input.LA(5);

                        if ( (LA12_235=='f') ) {
                            int LA12_287 = input.LA(6);

                            if ( ((LA12_287>='0' && LA12_287<='9')||(LA12_287>='A' && LA12_287<='Z')||LA12_287=='_'||(LA12_287>='a' && LA12_287<='z')) ) {
                                alt12=104;
                            }
                            else {
                                alt12=98;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                case 'u':
                    {
                    int LA12_182 = input.LA(4);

                    if ( (LA12_182=='m') ) {
                        int LA12_236 = input.LA(5);

                        if ( ((LA12_236>='0' && LA12_236<='9')||(LA12_236>='A' && LA12_236<='Z')||LA12_236=='_'||(LA12_236>='a' && LA12_236<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=50;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                default:
                    alt12=104;}

                }
                break;
            case 'x':
                {
                int LA12_112 = input.LA(3);

                if ( (LA12_112=='t') ) {
                    int LA12_183 = input.LA(4);

                    if ( (LA12_183=='e') ) {
                        int LA12_237 = input.LA(5);

                        if ( (LA12_237=='n') ) {
                            int LA12_289 = input.LA(6);

                            if ( (LA12_289=='d') ) {
                                int LA12_333 = input.LA(7);

                                if ( (LA12_333=='s') ) {
                                    int LA12_371 = input.LA(8);

                                    if ( ((LA12_371>='0' && LA12_371<='9')||(LA12_371>='A' && LA12_371<='Z')||LA12_371=='_'||(LA12_371>='a' && LA12_371<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=47;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'l':
                {
                int LA12_113 = input.LA(3);

                if ( (LA12_113=='s') ) {
                    int LA12_184 = input.LA(4);

                    if ( (LA12_184=='e') ) {
                        int LA12_238 = input.LA(5);

                        if ( ((LA12_238>='0' && LA12_238<='9')||(LA12_238>='A' && LA12_238<='Z')||LA12_238=='_'||(LA12_238>='a' && LA12_238<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=97;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
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
            case 'y':
            case 'z':
                {
                alt12=104;
                }
                break;
            default:
                alt12=61;}

        }
        else if ( (LA12_0=='#') ) {
            alt12=58;
        }
        else if ( (LA12_0=='&') ) {
            int LA12_32 = input.LA(2);

            if ( (LA12_32=='&') ) {
                alt12=59;
            }
            else {
                alt12=109;}
        }
        else if ( (LA12_0=='s') ) {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA12_117 = input.LA(3);

                if ( (LA12_117=='p') ) {
                    int LA12_185 = input.LA(4);

                    if ( (LA12_185=='e') ) {
                        int LA12_239 = input.LA(5);

                        if ( (LA12_239=='r') ) {
                            int LA12_291 = input.LA(6);

                            if ( ((LA12_291>='0' && LA12_291<='9')||(LA12_291>='A' && LA12_291<='Z')||LA12_291=='_'||(LA12_291>='a' && LA12_291<='z')) ) {
                                alt12=104;
                            }
                            else {
                                alt12=60;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'e':
                {
                int LA12_118 = input.LA(3);

                if ( (LA12_118=='l') ) {
                    int LA12_186 = input.LA(4);

                    if ( (LA12_186=='f') ) {
                        int LA12_240 = input.LA(5);

                        if ( ((LA12_240>='0' && LA12_240<='9')||(LA12_240>='A' && LA12_240<='Z')||LA12_240=='_'||(LA12_240>='a' && LA12_240<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=65;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='E') ) {
            int LA12_34 = input.LA(2);

            if ( ((LA12_34>='0' && LA12_34<='9')||(LA12_34>='A' && LA12_34<='Z')||LA12_34=='_'||(LA12_34>='a' && LA12_34<='z')) ) {
                alt12=104;
            }
            else {
                alt12=62;}
        }
        else if ( (LA12_0=='-') ) {
            switch ( input.LA(2) ) {
            case '-':
                {
                alt12=107;
                }
                break;
            case '>':
                {
                alt12=92;
                }
                break;
            default:
                alt12=63;}

        }
        else if ( (LA12_0=='T') ) {
            int LA12_36 = input.LA(2);

            if ( (LA12_36=='u') ) {
                int LA12_123 = input.LA(3);

                if ( (LA12_123=='p') ) {
                    int LA12_187 = input.LA(4);

                    if ( (LA12_187=='l') ) {
                        int LA12_241 = input.LA(5);

                        if ( (LA12_241=='e') ) {
                            int LA12_293 = input.LA(6);

                            if ( ((LA12_293>='0' && LA12_293<='9')||(LA12_293>='A' && LA12_293<='Z')||LA12_293=='_'||(LA12_293>='a' && LA12_293<='z')) ) {
                                alt12=104;
                            }
                            else {
                                alt12=64;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='B') ) {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA12_124 = input.LA(3);

                if ( (LA12_124=='g') ) {
                    int LA12_188 = input.LA(4);

                    if ( ((LA12_188>='0' && LA12_188<='9')||(LA12_188>='A' && LA12_188<='Z')||LA12_188=='_'||(LA12_188>='a' && LA12_188<='z')) ) {
                        alt12=104;
                    }
                    else {
                        alt12=75;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'o':
                {
                int LA12_125 = input.LA(3);

                if ( (LA12_125=='o') ) {
                    int LA12_189 = input.LA(4);

                    if ( (LA12_189=='l') ) {
                        int LA12_243 = input.LA(5);

                        if ( (LA12_243=='e') ) {
                            int LA12_294 = input.LA(6);

                            if ( (LA12_294=='a') ) {
                                int LA12_336 = input.LA(7);

                                if ( (LA12_336=='n') ) {
                                    int LA12_372 = input.LA(8);

                                    if ( ((LA12_372>='0' && LA12_372<='9')||(LA12_372>='A' && LA12_372<='Z')||LA12_372=='_'||(LA12_372>='a' && LA12_372<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=66;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='I') ) {
            int LA12_38 = input.LA(2);

            if ( (LA12_38=='n') ) {
                int LA12_126 = input.LA(3);

                if ( (LA12_126=='t') ) {
                    int LA12_190 = input.LA(4);

                    if ( (LA12_190=='e') ) {
                        int LA12_244 = input.LA(5);

                        if ( (LA12_244=='g') ) {
                            int LA12_295 = input.LA(6);

                            if ( (LA12_295=='e') ) {
                                int LA12_337 = input.LA(7);

                                if ( (LA12_337=='r') ) {
                                    int LA12_373 = input.LA(8);

                                    if ( ((LA12_373>='0' && LA12_373<='9')||(LA12_373>='A' && LA12_373<='Z')||LA12_373=='_'||(LA12_373>='a' && LA12_373<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=67;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='R') ) {
            int LA12_39 = input.LA(2);

            if ( (LA12_39=='e') ) {
                int LA12_127 = input.LA(3);

                if ( (LA12_127=='a') ) {
                    int LA12_191 = input.LA(4);

                    if ( (LA12_191=='l') ) {
                        int LA12_245 = input.LA(5);

                        if ( ((LA12_245>='0' && LA12_245<='9')||(LA12_245>='A' && LA12_245<='Z')||LA12_245=='_'||(LA12_245>='a' && LA12_245<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=68;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='S') ) {
            switch ( input.LA(2) ) {
            case 'e':
                {
                switch ( input.LA(3) ) {
                case 't':
                    {
                    int LA12_192 = input.LA(4);

                    if ( ((LA12_192>='0' && LA12_192<='9')||(LA12_192>='A' && LA12_192<='Z')||LA12_192=='_'||(LA12_192>='a' && LA12_192<='z')) ) {
                        alt12=104;
                    }
                    else {
                        alt12=74;}
                    }
                    break;
                case 'q':
                    {
                    int LA12_193 = input.LA(4);

                    if ( (LA12_193=='u') ) {
                        int LA12_247 = input.LA(5);

                        if ( (LA12_247=='e') ) {
                            int LA12_297 = input.LA(6);

                            if ( (LA12_297=='n') ) {
                                int LA12_338 = input.LA(7);

                                if ( (LA12_338=='c') ) {
                                    int LA12_374 = input.LA(8);

                                    if ( (LA12_374=='e') ) {
                                        int LA12_407 = input.LA(9);

                                        if ( ((LA12_407>='0' && LA12_407<='9')||(LA12_407>='A' && LA12_407<='Z')||LA12_407=='_'||(LA12_407>='a' && LA12_407<='z')) ) {
                                            alt12=104;
                                        }
                                        else {
                                            alt12=76;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                    }
                    break;
                default:
                    alt12=104;}

                }
                break;
            case 't':
                {
                int LA12_129 = input.LA(3);

                if ( (LA12_129=='r') ) {
                    int LA12_194 = input.LA(4);

                    if ( (LA12_194=='i') ) {
                        int LA12_248 = input.LA(5);

                        if ( (LA12_248=='n') ) {
                            int LA12_298 = input.LA(6);

                            if ( (LA12_298=='g') ) {
                                int LA12_339 = input.LA(7);

                                if ( ((LA12_339>='0' && LA12_339<='9')||(LA12_339>='A' && LA12_339<='Z')||LA12_339=='_'||(LA12_339>='a' && LA12_339<='z')) ) {
                                    alt12=104;
                                }
                                else {
                                    alt12=69;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='U') ) {
            int LA12_41 = input.LA(2);

            if ( (LA12_41=='n') ) {
                int LA12_130 = input.LA(3);

                if ( (LA12_130=='l') ) {
                    int LA12_195 = input.LA(4);

                    if ( (LA12_195=='i') ) {
                        int LA12_249 = input.LA(5);

                        if ( (LA12_249=='m') ) {
                            int LA12_299 = input.LA(6);

                            if ( (LA12_299=='i') ) {
                                int LA12_340 = input.LA(7);

                                if ( (LA12_340=='t') ) {
                                    int LA12_376 = input.LA(8);

                                    if ( (LA12_376=='e') ) {
                                        int LA12_408 = input.LA(9);

                                        if ( (LA12_408=='d') ) {
                                            int LA12_429 = input.LA(10);

                                            if ( (LA12_429=='N') ) {
                                                int LA12_443 = input.LA(11);

                                                if ( (LA12_443=='a') ) {
                                                    int LA12_451 = input.LA(12);

                                                    if ( (LA12_451=='t') ) {
                                                        int LA12_457 = input.LA(13);

                                                        if ( (LA12_457=='u') ) {
                                                            int LA12_460 = input.LA(14);

                                                            if ( (LA12_460=='r') ) {
                                                                int LA12_462 = input.LA(15);

                                                                if ( (LA12_462=='a') ) {
                                                                    int LA12_463 = input.LA(16);

                                                                    if ( (LA12_463=='l') ) {
                                                                        int LA12_464 = input.LA(17);

                                                                        if ( ((LA12_464>='0' && LA12_464<='9')||(LA12_464>='A' && LA12_464<='Z')||LA12_464=='_'||(LA12_464>='a' && LA12_464<='z')) ) {
                                                                            alt12=104;
                                                                        }
                                                                        else {
                                                                            alt12=70;}
                                                                    }
                                                                    else {
                                                                        alt12=104;}
                                                                }
                                                                else {
                                                                    alt12=104;}
                                                            }
                                                            else {
                                                                alt12=104;}
                                                        }
                                                        else {
                                                            alt12=104;}
                                                    }
                                                    else {
                                                        alt12=104;}
                                                }
                                                else {
                                                    alt12=104;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='O') ) {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA12_131 = input.LA(3);

                if ( (LA12_131=='d') ) {
                    int LA12_196 = input.LA(4);

                    if ( (LA12_196=='e') ) {
                        int LA12_250 = input.LA(5);

                        if ( (LA12_250=='r') ) {
                            int LA12_300 = input.LA(6);

                            if ( (LA12_300=='e') ) {
                                int LA12_341 = input.LA(7);

                                if ( (LA12_341=='d') ) {
                                    int LA12_377 = input.LA(8);

                                    if ( (LA12_377=='S') ) {
                                        int LA12_409 = input.LA(9);

                                        if ( (LA12_409=='e') ) {
                                            int LA12_430 = input.LA(10);

                                            if ( (LA12_430=='t') ) {
                                                int LA12_444 = input.LA(11);

                                                if ( ((LA12_444>='0' && LA12_444<='9')||(LA12_444>='A' && LA12_444<='Z')||LA12_444=='_'||(LA12_444>='a' && LA12_444<='z')) ) {
                                                    alt12=104;
                                                }
                                                else {
                                                    alt12=78;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'c':
                {
                int LA12_132 = input.LA(3);

                if ( (LA12_132=='l') ) {
                    switch ( input.LA(4) ) {
                    case 'V':
                        {
                        int LA12_251 = input.LA(5);

                        if ( (LA12_251=='o') ) {
                            int LA12_301 = input.LA(6);

                            if ( (LA12_301=='i') ) {
                                int LA12_342 = input.LA(7);

                                if ( (LA12_342=='d') ) {
                                    int LA12_378 = input.LA(8);

                                    if ( ((LA12_378>='0' && LA12_378<='9')||(LA12_378>='A' && LA12_378<='Z')||LA12_378=='_'||(LA12_378>='a' && LA12_378<='z')) ) {
                                        alt12=104;
                                    }
                                    else {
                                        alt12=73;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                        }
                        break;
                    case 'I':
                        {
                        int LA12_252 = input.LA(5);

                        if ( (LA12_252=='n') ) {
                            int LA12_302 = input.LA(6);

                            if ( (LA12_302=='v') ) {
                                int LA12_343 = input.LA(7);

                                if ( (LA12_343=='a') ) {
                                    int LA12_379 = input.LA(8);

                                    if ( (LA12_379=='l') ) {
                                        int LA12_411 = input.LA(9);

                                        if ( (LA12_411=='i') ) {
                                            int LA12_431 = input.LA(10);

                                            if ( (LA12_431=='d') ) {
                                                int LA12_445 = input.LA(11);

                                                if ( ((LA12_445>='0' && LA12_445<='9')||(LA12_445>='A' && LA12_445<='Z')||LA12_445=='_'||(LA12_445>='a' && LA12_445<='z')) ) {
                                                    alt12=104;
                                                }
                                                else {
                                                    alt12=72;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                        }
                        break;
                    case 'A':
                        {
                        int LA12_253 = input.LA(5);

                        if ( (LA12_253=='n') ) {
                            int LA12_303 = input.LA(6);

                            if ( (LA12_303=='y') ) {
                                int LA12_344 = input.LA(7);

                                if ( ((LA12_344>='0' && LA12_344<='9')||(LA12_344>='A' && LA12_344<='Z')||LA12_344=='_'||(LA12_344>='a' && LA12_344<='z')) ) {
                                    alt12=104;
                                }
                                else {
                                    alt12=71;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                        }
                        break;
                    default:
                        alt12=104;}

                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='C') ) {
            int LA12_43 = input.LA(2);

            if ( (LA12_43=='o') ) {
                int LA12_133 = input.LA(3);

                if ( (LA12_133=='l') ) {
                    int LA12_198 = input.LA(4);

                    if ( (LA12_198=='l') ) {
                        int LA12_254 = input.LA(5);

                        if ( (LA12_254=='e') ) {
                            int LA12_304 = input.LA(6);

                            if ( (LA12_304=='c') ) {
                                int LA12_345 = input.LA(7);

                                if ( (LA12_345=='t') ) {
                                    int LA12_381 = input.LA(8);

                                    if ( (LA12_381=='i') ) {
                                        int LA12_412 = input.LA(9);

                                        if ( (LA12_412=='o') ) {
                                            int LA12_432 = input.LA(10);

                                            if ( (LA12_432=='n') ) {
                                                int LA12_446 = input.LA(11);

                                                if ( ((LA12_446>='0' && LA12_446<='9')||(LA12_446>='A' && LA12_446<='Z')||LA12_446=='_'||(LA12_446>='a' && LA12_446<='z')) ) {
                                                    alt12=104;
                                                }
                                                else {
                                                    alt12=77;}
                                            }
                                            else {
                                                alt12=104;}
                                        }
                                        else {
                                            alt12=104;}
                                    }
                                    else {
                                        alt12=104;}
                                }
                                else {
                                    alt12=104;}
                            }
                            else {
                                alt12=104;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='f') ) {
            int LA12_44 = input.LA(2);

            if ( (LA12_44=='a') ) {
                int LA12_134 = input.LA(3);

                if ( (LA12_134=='l') ) {
                    int LA12_199 = input.LA(4);

                    if ( (LA12_199=='s') ) {
                        int LA12_255 = input.LA(5);

                        if ( (LA12_255=='e') ) {
                            int LA12_305 = input.LA(6);

                            if ( ((LA12_305>='0' && LA12_305<='9')||(LA12_305>='A' && LA12_305<='Z')||LA12_305=='_'||(LA12_305>='a' && LA12_305<='z')) ) {
                                alt12=104;
                            }
                            else {
                                alt12=80;}
                        }
                        else {
                            alt12=104;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='n') ) {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA12_135 = input.LA(3);

                if ( (LA12_135=='l') ) {
                    int LA12_200 = input.LA(4);

                    if ( (LA12_200=='l') ) {
                        int LA12_256 = input.LA(5);

                        if ( ((LA12_256>='0' && LA12_256<='9')||(LA12_256>='A' && LA12_256<='Z')||LA12_256=='_'||(LA12_256>='a' && LA12_256<='z')) ) {
                            alt12=104;
                        }
                        else {
                            alt12=82;}
                    }
                    else {
                        alt12=104;}
                }
                else {
                    alt12=104;}
                }
                break;
            case 'o':
                {
                int LA12_136 = input.LA(3);

                if ( (LA12_136=='t') ) {
                    int LA12_201 = input.LA(4);

                    if ( ((LA12_201>='0' && LA12_201<='9')||(LA12_201>='A' && LA12_201<='Z')||LA12_201=='_'||(LA12_201>='a' && LA12_201<='z')) ) {
                        alt12=104;
                    }
                    else {
                        alt12=91;}
                }
                else {
                    alt12=104;}
                }
                break;
            default:
                alt12=104;}

        }
        else if ( (LA12_0=='x') ) {
            int LA12_46 = input.LA(2);

            if ( (LA12_46=='o') ) {
                int LA12_137 = input.LA(3);

                if ( (LA12_137=='r') ) {
                    int LA12_202 = input.LA(4);

                    if ( ((LA12_202>='0' && LA12_202<='9')||(LA12_202>='A' && LA12_202<='Z')||LA12_202=='_'||(LA12_202>='a' && LA12_202<='z')) ) {
                        alt12=104;
                    }
                    else {
                        alt12=84;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='/') ) {
            int LA12_47 = input.LA(2);

            if ( (LA12_47=='*') ) {
                alt12=106;
            }
            else {
                alt12=90;}
        }
        else if ( (LA12_0=='|') ) {
            alt12=93;
        }
        else if ( (LA12_0=='l') ) {
            int LA12_49 = input.LA(2);

            if ( (LA12_49=='e') ) {
                int LA12_141 = input.LA(3);

                if ( (LA12_141=='t') ) {
                    int LA12_203 = input.LA(4);

                    if ( ((LA12_203>='0' && LA12_203<='9')||(LA12_203>='A' && LA12_203<='Z')||LA12_203=='_'||(LA12_203>='a' && LA12_203<='z')) ) {
                        alt12=104;
                    }
                    else {
                        alt12=99;}
                }
                else {
                    alt12=104;}
            }
            else {
                alt12=104;}
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_50 = input.LA(2);

            if ( ((LA12_50>='\u0000' && LA12_50<='\uFFFE')) ) {
                alt12=101;
            }
            else {
                alt12=109;}
        }
        else if ( (LA12_0=='\u00A3') ) {
            int LA12_51 = input.LA(2);

            if ( ((LA12_51>='\u0000' && LA12_51<='!')||(LA12_51>='#' && LA12_51<='\uFFFE')) ) {
                alt12=102;
            }
            else {
                alt12=109;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_52 = input.LA(2);

            if ( ((LA12_52>='\u0000' && LA12_52<='\uFFFE')) ) {
                alt12=103;
            }
            else {
                alt12=109;}
        }
        else if ( (LA12_0=='_') ) {
            alt12=104;
        }
        else if ( (LA12_0=='A'||LA12_0=='D'||(LA12_0>='F' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='N')||(LA12_0>='P' && LA12_0<='Q')||(LA12_0>='V' && LA12_0<='Z')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='m'||LA12_0=='q'||LA12_0=='w'||(LA12_0>='y' && LA12_0<='z')) ) {
            alt12=104;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=105;
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=108;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='$' && LA12_0<='%')||LA12_0=='\\'||LA12_0=='^'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\u00A2')||(LA12_0>='\u00A4' && LA12_0<='\uFFFE')) ) {
            alt12=109;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | RULE_URL | RULE_OCL | RULE_STRING_LITERAL | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:10: T13
                {
                mT13(); 

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:14: T14
                {
                mT14(); 

                }
                break;
            case 3 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:18: T15
                {
                mT15(); 

                }
                break;
            case 4 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:22: T16
                {
                mT16(); 

                }
                break;
            case 5 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:26: T17
                {
                mT17(); 

                }
                break;
            case 6 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:30: T18
                {
                mT18(); 

                }
                break;
            case 7 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:34: T19
                {
                mT19(); 

                }
                break;
            case 8 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:38: T20
                {
                mT20(); 

                }
                break;
            case 9 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:42: T21
                {
                mT21(); 

                }
                break;
            case 10 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:46: T22
                {
                mT22(); 

                }
                break;
            case 11 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:50: T23
                {
                mT23(); 

                }
                break;
            case 12 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:54: T24
                {
                mT24(); 

                }
                break;
            case 13 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:58: T25
                {
                mT25(); 

                }
                break;
            case 14 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:62: T26
                {
                mT26(); 

                }
                break;
            case 15 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:66: T27
                {
                mT27(); 

                }
                break;
            case 16 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:70: T28
                {
                mT28(); 

                }
                break;
            case 17 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:74: T29
                {
                mT29(); 

                }
                break;
            case 18 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:78: T30
                {
                mT30(); 

                }
                break;
            case 19 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:82: T31
                {
                mT31(); 

                }
                break;
            case 20 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:86: T32
                {
                mT32(); 

                }
                break;
            case 21 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:90: T33
                {
                mT33(); 

                }
                break;
            case 22 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:94: T34
                {
                mT34(); 

                }
                break;
            case 23 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:98: T35
                {
                mT35(); 

                }
                break;
            case 24 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:102: T36
                {
                mT36(); 

                }
                break;
            case 25 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:106: T37
                {
                mT37(); 

                }
                break;
            case 26 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:110: T38
                {
                mT38(); 

                }
                break;
            case 27 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:114: T39
                {
                mT39(); 

                }
                break;
            case 28 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:118: T40
                {
                mT40(); 

                }
                break;
            case 29 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:122: T41
                {
                mT41(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:126: T42
                {
                mT42(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:130: T43
                {
                mT43(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:134: T44
                {
                mT44(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:138: T45
                {
                mT45(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:142: T46
                {
                mT46(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:146: T47
                {
                mT47(); 

                }
                break;
            case 36 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:150: T48
                {
                mT48(); 

                }
                break;
            case 37 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:154: T49
                {
                mT49(); 

                }
                break;
            case 38 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:158: T50
                {
                mT50(); 

                }
                break;
            case 39 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:162: T51
                {
                mT51(); 

                }
                break;
            case 40 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:166: T52
                {
                mT52(); 

                }
                break;
            case 41 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:170: T53
                {
                mT53(); 

                }
                break;
            case 42 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:174: T54
                {
                mT54(); 

                }
                break;
            case 43 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:178: T55
                {
                mT55(); 

                }
                break;
            case 44 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:182: T56
                {
                mT56(); 

                }
                break;
            case 45 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:186: T57
                {
                mT57(); 

                }
                break;
            case 46 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:190: T58
                {
                mT58(); 

                }
                break;
            case 47 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:194: T59
                {
                mT59(); 

                }
                break;
            case 48 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:198: T60
                {
                mT60(); 

                }
                break;
            case 49 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:202: T61
                {
                mT61(); 

                }
                break;
            case 50 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:206: T62
                {
                mT62(); 

                }
                break;
            case 51 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:210: T63
                {
                mT63(); 

                }
                break;
            case 52 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:214: T64
                {
                mT64(); 

                }
                break;
            case 53 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:218: T65
                {
                mT65(); 

                }
                break;
            case 54 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:222: T66
                {
                mT66(); 

                }
                break;
            case 55 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:226: T67
                {
                mT67(); 

                }
                break;
            case 56 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:230: T68
                {
                mT68(); 

                }
                break;
            case 57 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:234: T69
                {
                mT69(); 

                }
                break;
            case 58 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:238: T70
                {
                mT70(); 

                }
                break;
            case 59 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:242: T71
                {
                mT71(); 

                }
                break;
            case 60 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:246: T72
                {
                mT72(); 

                }
                break;
            case 61 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:250: T73
                {
                mT73(); 

                }
                break;
            case 62 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:254: T74
                {
                mT74(); 

                }
                break;
            case 63 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:258: T75
                {
                mT75(); 

                }
                break;
            case 64 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:262: T76
                {
                mT76(); 

                }
                break;
            case 65 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:266: T77
                {
                mT77(); 

                }
                break;
            case 66 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:270: T78
                {
                mT78(); 

                }
                break;
            case 67 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:274: T79
                {
                mT79(); 

                }
                break;
            case 68 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:278: T80
                {
                mT80(); 

                }
                break;
            case 69 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:282: T81
                {
                mT81(); 

                }
                break;
            case 70 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:286: T82
                {
                mT82(); 

                }
                break;
            case 71 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:290: T83
                {
                mT83(); 

                }
                break;
            case 72 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:294: T84
                {
                mT84(); 

                }
                break;
            case 73 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:298: T85
                {
                mT85(); 

                }
                break;
            case 74 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:302: T86
                {
                mT86(); 

                }
                break;
            case 75 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:306: T87
                {
                mT87(); 

                }
                break;
            case 76 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:310: T88
                {
                mT88(); 

                }
                break;
            case 77 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:314: T89
                {
                mT89(); 

                }
                break;
            case 78 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:318: T90
                {
                mT90(); 

                }
                break;
            case 79 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:322: T91
                {
                mT91(); 

                }
                break;
            case 80 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:326: T92
                {
                mT92(); 

                }
                break;
            case 81 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:330: T93
                {
                mT93(); 

                }
                break;
            case 82 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:334: T94
                {
                mT94(); 

                }
                break;
            case 83 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:338: T95
                {
                mT95(); 

                }
                break;
            case 84 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:342: T96
                {
                mT96(); 

                }
                break;
            case 85 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:346: T97
                {
                mT97(); 

                }
                break;
            case 86 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:350: T98
                {
                mT98(); 

                }
                break;
            case 87 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:354: T99
                {
                mT99(); 

                }
                break;
            case 88 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:358: T100
                {
                mT100(); 

                }
                break;
            case 89 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:363: T101
                {
                mT101(); 

                }
                break;
            case 90 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:368: T102
                {
                mT102(); 

                }
                break;
            case 91 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:373: T103
                {
                mT103(); 

                }
                break;
            case 92 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:378: T104
                {
                mT104(); 

                }
                break;
            case 93 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:383: T105
                {
                mT105(); 

                }
                break;
            case 94 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:388: T106
                {
                mT106(); 

                }
                break;
            case 95 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:393: T107
                {
                mT107(); 

                }
                break;
            case 96 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:398: T108
                {
                mT108(); 

                }
                break;
            case 97 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:403: T109
                {
                mT109(); 

                }
                break;
            case 98 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:408: T110
                {
                mT110(); 

                }
                break;
            case 99 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:413: T111
                {
                mT111(); 

                }
                break;
            case 100 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:418: T112
                {
                mT112(); 

                }
                break;
            case 101 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:423: RULE_URL
                {
                mRULE_URL(); 

                }
                break;
            case 102 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:432: RULE_OCL
                {
                mRULE_OCL(); 

                }
                break;
            case 103 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:441: RULE_STRING_LITERAL
                {
                mRULE_STRING_LITERAL(); 

                }
                break;
            case 104 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:461: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 105 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:469: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 106 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:478: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 107 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:494: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 108 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:510: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 109 :
                // ../org.eclipse.ocl.examples.xtext.oclinecore/src-gen/org/eclipse/ocl/examples/xtext/oclinecore/parser/antlr/internal/InternalOCLinEcore.g:1:518: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}