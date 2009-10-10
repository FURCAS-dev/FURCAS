/**
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   E.D.Willink - Bug 285633 static definitions
*
* </copyright>
*
* $Id: OCLKWLexerprs.java,v 1.9 2009/10/10 07:04:20 ewillink Exp $
*/

package org.eclipse.ocl.parser;

public class OCLKWLexerprs implements lpg.lpgjavaruntime.ParseTable, OCLKWLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            4,3,3,4,4,7,7,10,3,6,
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,7,
            6,6,8,3,3,7,6,6,13,8,
            7,6,7,16,4,7,5,6,7,10,
            10,4,7,6
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,57,48,94,101,
            107,111,103,55,105,45,63,68,114,18,
            117,70,118,71,119,38,79,121,13,37,
            59,69,122,124,128,50,131,14,132,133,
            136,137,31,138,139,146,140,150,147,155,
            74,151,157,81,153,160,162,161,86,164,
            165,167,174,166,178,168,92,180,181,182,
            186,187,191,194,198,22,200,202,203,204,
            196,192,207,209,215,213,219,211,222,93,
            220,224,226,229,231,232,233,235,236,241,
            240,246,247,96,251,237,253,254,255,258,
            259,264,261,270,272,274,275,277,281,278,
            260,283,284,286,289,291,296,287,299,301,
            302,304,308,306,312,313,319,315,294,316,
            320,323,326,327,328,329,330,338,332,335,
            340,343,344,345,348,349,352,350,355,359,
            361,365,357,360,371,372,373,374,378,377,
            379,384,387,390,393,391,395,397,399,386,
            400,402,410,404,405,414,412,417,418,420,
            422,421,423,424,427,426,432,428,437,440,
            441,445,446,444,448,455,456,459,451,461,
            462,464,471,265,265
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,0,0,14,15,4,0,18,7,
            8,0,9,23,24,8,26,27,28,12,
            0,31,2,33,34,35,0,0,2,0,
            3,5,5,22,0,24,10,0,4,0,
            14,21,8,32,0,18,20,36,0,1,
            2,7,0,1,2,11,8,0,0,0,
            0,4,0,0,5,8,7,7,0,30,
            0,3,9,15,37,0,8,7,3,16,
            5,0,0,0,14,0,1,6,6,29,
            0,1,0,1,0,12,0,15,17,14,
            0,5,8,0,1,5,0,0,0,1,
            0,0,5,0,8,4,3,0,8,2,
            0,0,0,3,3,0,0,0,0,0,
            8,3,3,7,7,0,0,2,13,0,
            0,2,0,7,0,1,0,1,6,0,
            0,0,12,0,0,0,0,0,8,10,
            9,0,9,0,1,11,10,0,1,0,
            0,0,15,4,3,0,0,7,3,3,
            0,0,27,0,1,0,6,0,1,0,
            1,0,0,0,3,3,0,12,0,6,
            0,3,0,22,0,1,10,5,0,0,
            10,0,1,0,6,0,3,2,0,10,
            0,0,0,2,0,0,0,5,3,0,
            0,7,2,4,16,0,0,2,2,19,
            0,1,0,0,0,1,20,0,0,0,
            0,2,5,0,11,13,8,7,5,0,
            1,0,1,0,0,1,0,0,5,3,
            0,1,0,0,0,0,0,4,0,1,
            0,1,6,0,17,0,14,12,0,4,
            0,0,4,0,3,0,6,0,1,6,
            17,0,0,1,0,0,11,6,0,0,
            2,6,0,1,10,0,0,0,0,0,
            4,0,3,5,0,16,11,0,1,0,
            13,10,0,0,0,11,7,0,0,0,
            2,0,1,11,0,6,0,13,0,0,
            0,18,2,7,0,11,2,9,21,10,
            0,0,0,0,4,2,0,0,0,0,
            9,9,5,0,1,0,0,11,2,0,
            0,2,0,1,0,1,0,19,0,0,
            1,0,12,0,0,4,10,9,23,0,
            6,0,3,0,1,4,0,0,1,0,
            0,0,0,0,1,0,0,0,6,26,
            9,0,1,13,8,16,0,1,13,0,
            0,25,2,0,0,0,1,0,9,5,
            0,4,25,10,0,0,2,2,0,1,
            0,0,12,0,0,0,0,4,7,9,
            0,0,0,3,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            265,75,73,68,72,69,79,62,71,74,
            80,76,265,265,67,78,110,265,70,112,
            111,265,126,65,61,97,66,60,77,96,
            265,64,290,63,59,58,265,265,114,265,
            105,116,106,161,265,159,113,265,90,265,
            277,130,89,158,265,104,115,160,265,119,
            117,87,265,92,91,86,118,265,265,265,
            265,94,265,265,99,93,282,101,265,124,
            265,107,281,120,264,265,108,136,141,299,
            142,22,265,265,274,265,183,149,171,102,
            265,82,265,85,265,81,265,172,150,266,
            265,83,88,265,95,84,265,265,265,103,
            265,265,100,265,98,121,122,265,109,123,
            265,265,265,125,127,265,265,265,265,265,
            128,132,133,129,131,265,265,286,291,265,
            265,284,265,283,265,300,265,135,137,265,
            265,265,134,265,265,265,265,265,140,138,
            139,265,143,265,268,144,145,265,147,265,
            265,265,148,151,153,265,265,152,154,310,
            265,265,146,265,156,265,155,265,157,265,
            162,265,265,265,163,164,265,166,265,165,
            265,317,265,167,265,288,168,278,265,265,
            170,265,279,265,169,265,174,175,265,173,
            265,265,265,269,265,265,265,177,179,2,
            265,178,276,180,270,265,265,181,182,176,
            265,312,265,265,265,187,184,265,265,265,
            265,198,188,265,186,185,189,191,190,265,
            192,265,193,265,265,195,265,265,194,196,
            265,289,265,265,265,265,265,199,265,201,
            265,202,204,265,197,265,280,200,265,203,
            265,265,205,265,207,265,206,265,209,208,
            214,265,265,212,265,265,210,211,265,265,
            303,215,265,216,213,265,265,265,265,265,
            218,265,296,219,265,313,217,265,275,265,
            307,297,265,265,265,220,221,265,265,265,
            226,265,227,222,265,228,265,224,265,265,
            265,223,302,308,265,319,230,229,225,231,
            265,265,265,265,232,234,265,265,265,265,
            314,233,311,265,306,265,265,235,237,265,
            265,271,265,272,265,295,265,236,265,265,
            240,265,238,265,265,241,285,318,239,265,
            244,265,242,265,292,245,36,265,298,265,
            265,265,265,265,250,265,265,265,249,243,
            247,265,253,248,251,305,265,316,252,265,
            265,246,294,265,265,265,273,265,315,293,
            265,256,254,255,265,265,257,258,265,259,
            265,265,260,265,265,265,265,262,261,304,
            265,265,265,309
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int getErrorSymbol() { return 0; }
    public final int getScopeUbound() { return 0; }
    public final int getScopeSize() { return 0; }
    public final int getMaxNameLength() { return 0; }

    public final static int
           NUM_STATES        = 207,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 319,
           MAX_LA            = 1,
           NUM_RULES         = 54,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 55,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 37,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 264,
           ERROR_ACTION      = 265;

    public final static boolean BACKTRACK = false;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
