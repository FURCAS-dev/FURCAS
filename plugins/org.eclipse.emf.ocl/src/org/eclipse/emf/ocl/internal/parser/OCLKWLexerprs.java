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
* $Id: OCLKWLexerprs.java,v 1.3 2006/05/17 13:58:27 cdamus Exp $
*/

package org.eclipse.emf.ocl.internal.parser;

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
            7,4,7,5,6,7,7,10,4,10
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
            1,1,63,99,119,66,59,121,61,101,
            69,76,75,123,33,126,36,81,82,127,
            54,86,131,55,25,17,132,136,87,133,
            137,14,142,143,145,147,91,149,148,151,
            153,160,156,165,161,168,89,169,171,97,
            41,173,174,176,98,175,177,180,189,178,
            191,183,45,193,194,198,199,202,204,208,
            32,210,212,213,187,216,217,218,219,93,
            220,222,225,226,227,235,106,239,228,240,
            232,241,244,242,249,250,251,253,117,257,
            260,255,261,263,269,264,271,266,277,279,
            281,282,284,287,289,290,293,274,298,103,
            294,292,302,304,306,300,309,310,312,315,
            316,319,322,317,321,323,328,329,332,333,
            335,336,337,341,16,345,346,349,342,350,
            352,354,356,357,358,365,367,359,368,370,
            371,372,377,379,385,383,381,389,390,391,
            396,393,398,399,400,403,407,408,412,401,
            414,417,418,419,420,426,422,427,429,108,
            431,432,433,435,436,437,434,445,440,449,
            450,451,453,454,464,466,458,468,470,472,
            460,474,478,479,481,482,483,487,490,491,
            492,493,494,497,496,498,500,505,507,509,
            511,515,518,520,521,522,528,526,530,301,
            301
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,0,14,0,0,1,18,19,
            7,21,22,23,0,9,26,3,4,29,
            6,0,0,18,34,0,12,37,23,4,
            0,9,27,28,0,10,11,15,8,18,
            35,20,8,0,0,2,32,4,0,5,
            0,17,4,9,10,0,1,36,0,38,
            10,11,19,5,0,0,1,9,3,5,
            0,0,2,9,4,0,0,2,0,3,
            0,10,0,3,9,7,0,0,0,2,
            0,4,0,17,16,0,10,0,12,9,
            18,30,20,8,12,25,0,1,0,14,
            0,1,0,1,17,0,0,1,12,22,
            0,0,0,15,9,0,0,39,2,9,
            5,0,0,2,0,14,0,0,0,2,
            0,9,0,3,2,0,10,13,10,0,
            0,1,3,31,0,10,2,0,0,2,
            0,1,0,0,0,0,0,0,6,0,
            7,7,0,15,9,6,0,11,0,1,
            0,1,0,0,8,2,14,0,0,2,
            2,0,10,0,1,28,5,0,1,0,
            1,0,0,2,2,0,0,0,0,0,
            2,0,1,6,0,0,0,0,4,2,
            15,0,6,8,0,1,20,18,0,0,
            0,0,3,0,6,4,3,16,0,0,
            0,2,0,3,0,3,0,1,10,0,
            0,2,0,0,24,0,4,13,0,1,
            0,11,9,0,4,10,0,1,0,1,
            0,0,1,0,4,2,0,1,0,0,
            17,0,0,0,6,6,4,0,5,0,
            3,0,1,0,1,0,15,8,0,0,
            5,0,1,5,0,0,0,8,0,1,
            0,0,0,8,3,11,6,0,0,1,
            8,0,0,17,0,0,0,5,2,4,
            0,0,11,16,0,0,1,13,0,0,
            6,0,11,0,6,0,0,0,0,10,
            3,3,11,23,0,1,0,0,13,0,
            0,0,19,7,7,5,0,6,0,10,
            0,25,0,7,0,7,4,3,0,0,
            0,11,0,4,4,0,1,0,0,0,
            0,3,0,1,16,8,0,0,16,3,
            3,0,1,0,1,15,0,0,0,0,
            2,0,6,24,5,0,0,1,0,8,
            0,0,0,0,0,0,0,7,4,0,
            5,5,14,26,0,1,14,22,0,0,
            0,1,0,0,1,16,8,0,1,0,
            27,9,13,0,33,0,3,0,1,0,
            5,0,13,0,1,4,7,0,0,1,
            0,0,0,3,7,4,0,5,2,0,
            0,0,0,0,1,0,0,0,3,0,
            0,12,6,11,0,8,0,8,0,1,
            0,21,21,3,0,1,12,0,12,0,
            0,0,1,4,7,0,6,0,1,0,
            0,0,7,0,0,0,7,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            301,80,73,78,74,77,85,79,84,76,
            67,81,72,301,83,301,301,124,66,75,
            131,68,71,64,301,123,70,120,122,82,
            119,301,301,228,69,301,313,65,231,104,
            301,101,230,229,22,318,103,100,144,163,
            232,166,156,301,301,111,121,112,301,116,
            301,303,88,117,118,301,87,164,301,165,
            91,90,110,94,301,301,96,93,95,98,
            301,301,105,97,106,301,301,113,301,128,
            301,107,301,326,114,317,301,301,301,148,
            301,149,301,127,335,301,143,301,310,92,
            175,108,174,179,316,135,301,189,301,180,
            301,89,301,99,265,301,301,109,302,264,
            301,301,301,86,102,301,301,300,130,115,
            126,301,301,132,301,125,301,301,301,137,
            301,133,301,322,138,301,134,327,136,301,
            301,336,320,129,301,319,139,301,301,140,
            301,142,301,301,301,301,301,301,145,301,
            146,150,301,141,147,152,301,151,301,304,
            301,154,301,301,170,158,155,301,301,159,
            353,301,157,301,161,153,160,301,162,301,
            167,301,301,168,169,301,301,301,301,301,
            360,301,324,173,301,301,301,301,314,182,
            171,301,178,177,301,315,172,176,301,301,
            301,301,183,301,181,185,305,306,301,301,
            301,187,301,312,301,188,301,355,186,301,
            301,190,301,301,184,301,193,191,301,194,
            301,192,195,301,196,197,301,198,301,199,
            301,301,201,301,200,202,301,325,301,301,
            206,301,301,301,203,204,205,301,208,301,
            207,301,210,301,211,301,209,213,301,301,
            212,301,216,214,301,301,301,215,301,219,
            301,301,301,218,339,217,221,301,301,223,
            222,301,301,220,301,301,301,225,332,226,
            301,301,224,356,301,301,311,351,301,301,
            233,301,234,301,333,301,301,301,301,235,
            240,338,236,227,301,241,301,301,238,301,
            301,301,237,242,358,243,301,244,301,352,
            301,239,301,357,301,245,354,246,301,301,
            301,247,301,249,250,301,251,301,301,301,
            301,254,301,342,248,253,301,301,252,256,
            307,301,308,301,331,257,301,301,301,301,
            259,301,321,255,260,301,301,328,301,262,
            301,301,301,36,301,301,301,266,268,301,
            269,270,263,258,301,334,267,261,301,301,
            301,274,301,301,345,341,272,301,278,301,
            271,275,273,301,346,301,276,301,279,301,
            277,301,282,301,283,281,280,301,301,359,
            301,301,301,330,361,329,301,284,285,301,
            301,301,301,301,309,301,301,301,291,301,
            301,286,290,289,301,292,301,293,301,294,
            301,287,288,295,301,349,344,301,343,301,
            301,301,297,296,348,301,350,301,298,301,
            301,301,340,301,301,301,347
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
           NUM_STATES        = 237,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 361,
           MAX_LA            = 1,
           NUM_RULES         = 60,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 61,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 300,
           ERROR_ACTION      = 301;

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
