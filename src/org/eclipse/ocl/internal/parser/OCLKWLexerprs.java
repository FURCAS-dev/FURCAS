/**
* <copyright>
*
* Copyright (c) 2005, 2006 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*
* </copyright>
*
* $Id: OCLKWLexerprs.java,v 1.1 2007/01/25 18:24:35 cdamus Exp $
*/

package org.eclipse.ocl.internal.parser;

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
            7,11,11,9,8,14,12,12,12,6,
            7,16,4,7,5,6,7,7,10,4,
            10
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
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,64,34,110,21,111,121,127,
            46,124,61,14,70,131,72,129,40,58,
            74,135,48,76,133,59,29,87,79,137,
            138,81,141,144,145,147,148,77,150,89,
            151,153,154,161,162,166,167,170,172,93,
            164,178,90,176,180,183,181,104,185,184,
            186,196,168,198,187,95,200,201,204,205,
            208,210,211,216,27,218,220,221,224,213,
            225,227,229,96,228,232,234,236,239,240,
            107,243,248,249,237,28,254,255,256,258,
            261,263,118,267,244,270,262,269,273,274,
            278,279,281,284,286,289,291,294,297,295,
            299,300,301,302,308,306,309,312,314,316,
            317,319,325,326,328,329,330,332,334,338,
            340,341,342,343,345,346,349,350,357,352,
            18,353,364,360,362,366,367,369,370,282,
            371,379,382,383,387,385,372,391,393,395,
            397,400,394,399,405,407,408,413,406,409,
            416,417,423,425,426,430,420,434,432,418,
            436,439,444,427,442,445,438,103,451,156,
            452,455,456,457,454,463,460,465,468,466,
            469,471,477,479,483,484,486,489,490,491,
            492,495,497,498,500,502,507,508,501,509,
            511,514,517,515,519,526,521,522,520,530,
            534,536,537,543,538,546,541,547,551,552,
            554,556,555,558,557,317,317
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,0,1,15,3,0,18,19,
            0,1,22,23,24,25,0,0,0,29,
            30,3,4,0,34,18,8,37,21,0,
            12,24,25,4,18,0,20,0,9,2,
            11,4,35,26,9,27,11,0,0,2,
            0,4,36,5,38,5,19,9,10,0,
            10,0,39,0,5,0,0,2,0,10,
            0,10,9,3,13,10,0,1,0,0,
            14,3,0,15,0,0,10,17,9,7,
            6,12,0,0,31,2,0,4,16,0,
            0,17,6,18,4,20,28,0,1,17,
            0,15,13,0,4,23,0,1,0,12,
            0,1,0,10,0,1,0,0,10,2,
            0,5,10,0,0,2,0,0,2,0,
            0,7,0,0,2,0,3,10,9,9,
            0,0,2,0,3,0,0,0,2,0,
            1,0,32,2,9,0,13,0,1,0,
            0,6,0,0,0,0,0,8,33,7,
            10,7,25,8,11,0,1,0,1,0,
            0,15,2,0,0,2,2,0,9,0,
            0,1,0,6,5,0,1,0,1,0,
            0,2,2,0,0,13,0,0,0,6,
            2,0,1,0,8,0,0,4,0,0,
            1,6,0,0,20,18,8,0,0,2,
            8,3,16,0,0,0,3,0,4,2,
            0,0,0,3,9,3,0,1,0,0,
            27,2,0,0,1,14,4,0,0,11,
            0,0,4,0,1,0,1,10,0,9,
            0,1,4,0,0,2,0,1,0,0,
            0,0,8,4,3,0,8,0,0,28,
            5,0,1,0,1,0,0,17,0,12,
            5,13,6,5,0,0,1,0,0,0,
            6,0,1,0,6,6,3,0,11,0,
            0,0,0,1,0,0,6,8,0,0,
            5,0,0,4,17,11,0,16,2,0,
            8,0,14,0,1,0,0,8,0,0,
            0,0,11,3,9,24,0,11,0,1,
            9,0,0,14,0,3,0,19,7,3,
            0,7,0,0,0,5,0,4,0,0,
            8,7,3,7,0,0,0,0,0,11,
            4,4,0,1,6,0,0,0,3,0,
            16,16,0,1,0,0,0,3,3,0,
            1,0,13,0,1,0,1,0,0,8,
            2,0,26,0,0,1,29,6,5,23,
            0,0,15,0,0,0,0,7,4,0,
            5,5,0,1,0,0,15,0,0,1,
            0,7,0,6,21,16,0,1,0,14,
            10,3,0,0,1,0,1,5,0,0,
            0,0,1,4,0,7,0,0,1,0,
            0,0,3,7,14,4,0,0,0,2,
            0,5,12,0,0,21,0,1,0,0,
            0,0,8,5,11,0,6,6,3,0,
            22,12,22,0,1,0,0,0,3,3,
            0,12,0,1,7,0,0,1,8,4,
            0,0,1,0,0,0,0,0,2,0,
            7,7,5,13,9,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            317,82,75,80,76,79,86,81,87,69,
            78,83,74,317,99,85,98,317,68,77,
            317,89,70,73,65,67,317,317,317,72,
            84,123,125,317,71,235,122,66,237,317,
            329,238,236,107,168,317,171,317,334,114,
            106,115,239,189,94,124,93,317,317,108,
            317,109,169,119,170,97,113,121,120,317,
            96,317,316,317,101,317,317,116,317,100,
            317,104,110,132,103,117,317,127,317,317,
            343,342,317,128,22,317,126,131,147,333,
            160,326,317,317,111,152,317,153,351,317,
            317,319,184,180,90,179,139,317,194,274,
            317,185,88,317,91,273,317,92,317,318,
            317,102,317,95,317,112,317,317,105,130,
            317,129,118,317,317,134,317,317,136,317,
            317,135,317,317,141,317,338,137,138,140,
            317,317,142,317,336,317,317,317,143,317,
            352,317,133,144,335,317,145,317,146,317,
            317,148,317,317,317,317,317,149,362,150,
            151,154,157,156,155,317,320,317,158,317,
            317,159,162,317,317,163,370,317,161,317,
            317,166,317,164,165,317,167,317,172,317,
            317,173,174,317,317,176,317,317,317,175,
            377,317,340,317,178,317,317,330,317,317,
            331,182,317,317,177,181,183,317,317,187,
            186,188,322,317,317,317,321,317,190,192,
            317,317,317,328,191,193,317,372,317,317,
            195,196,317,317,200,197,199,317,317,198,
            317,317,202,317,204,317,205,201,317,203,
            317,207,206,317,317,208,317,341,317,317,
            317,317,209,211,213,317,210,317,317,246,
            214,317,216,317,217,317,317,212,317,332,
            218,215,219,220,317,317,222,317,317,317,
            221,317,226,317,224,225,355,317,223,317,
            317,317,317,230,317,317,229,228,317,317,
            232,317,317,233,227,231,317,373,348,317,
            240,317,367,317,327,317,317,349,317,317,
            317,317,241,247,242,234,317,243,317,248,
            368,317,317,245,317,354,317,244,249,250,
            317,375,317,317,317,251,317,371,317,317,
            252,374,254,253,317,317,317,317,317,255,
            257,258,317,259,261,317,317,317,262,317,
            256,260,317,358,317,317,317,264,323,317,
            324,317,265,317,347,317,267,317,317,337,
            268,317,263,317,317,344,266,271,269,270,
            317,317,272,36,317,317,317,275,277,317,
            278,279,317,350,317,317,276,317,317,284,
            317,281,317,282,280,357,317,361,317,283,
            285,286,317,317,288,317,289,287,317,317,
            317,317,293,291,317,290,317,317,376,317,
            317,317,346,378,292,345,317,317,317,296,
            317,295,297,317,317,294,317,325,317,317,
            317,317,301,302,300,317,304,305,303,317,
            298,360,299,317,306,317,317,317,307,308,
            317,359,317,365,364,317,317,310,366,309,
            317,317,312,317,317,317,317,317,369,317,
            356,363,314,311,313
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
           NUM_STATES        = 252,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 378,
           MAX_LA            = 1,
           NUM_RULES         = 61,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 62,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 316,
           ERROR_ACTION      = 317;

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
