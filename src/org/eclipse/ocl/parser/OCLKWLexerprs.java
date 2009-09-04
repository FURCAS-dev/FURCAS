/**
* <copyright>
*
* Copyright (c) 2005, 2007 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*
* </copyright>
*
* $Id: OCLKWLexerprs.java,v 1.6 2009/09/04 10:19:32 asanchez Exp $
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
            7,11,11,9,8,14,12,12,12,6,
            7,16,4,7,5,6,7,10,10,4,
            7,4,4,6
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
            1,1,1,1,1,1,67,97,114,65,
            116,121,126,68,130,73,15,76,131,80,
            133,45,60,82,134,51,85,137,67,32,
            27,48,139,138,19,110,145,146,149,150,
            151,155,91,156,158,40,164,157,165,168,
            170,174,176,177,84,171,181,96,183,179,
            184,186,98,187,190,191,193,197,198,202,
            99,203,204,206,207,213,212,219,223,33,
            225,214,227,228,221,229,231,233,232,87,
            237,238,241,243,245,248,252,109,250,258,
            254,246,260,263,264,266,267,269,272,274,
            278,111,281,275,279,284,287,285,283,292,
            290,298,300,303,304,306,310,308,312,314,
            313,320,315,319,316,325,328,332,333,335,
            336,338,343,344,323,346,347,351,350,354,
            355,357,362,356,360,364,366,368,358,22,
            369,374,376,377,380,381,383,384,386,389,
            393,390,395,397,398,401,404,407,408,409,
            410,419,420,412,415,422,425,427,430,432,
            433,434,436,439,440,443,445,447,449,453,
            450,451,457,463,454,464,455,465,106,467,
            468,469,472,480,481,471,473,483,487,488,
            484,493,496,497,489,500,507,509,504,511,
            502,513,516,518,520,521,522,524,527,531,
            525,532,533,534,536,541,538,542,549,539,
            550,552,556,557,560,563,564,565,566,569,
            572,570,575,576,580,586,328,328
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,0,1,2,17,0,19,
            2,0,22,23,24,25,0,1,2,29,
            30,0,0,2,34,4,10,37,17,0,
            9,2,21,12,0,24,25,0,4,17,
            0,7,20,3,4,11,35,13,27,0,
            13,2,3,4,0,1,0,0,36,19,
            38,5,0,7,7,0,10,5,11,0,
            5,0,10,0,0,10,0,3,7,10,
            0,8,2,14,10,0,0,0,0,16,
            3,4,7,17,6,0,20,12,0,0,
            0,1,31,0,6,0,18,0,28,4,
            0,13,12,18,4,0,1,14,23,0,
            0,1,0,0,1,39,0,0,0,10,
            3,32,10,5,0,0,10,3,0,0,
            0,3,0,8,0,0,0,0,2,10,
            3,7,7,0,0,15,3,0,1,0,
            0,7,3,0,1,0,0,2,0,3,
            0,1,0,0,14,0,0,9,6,0,
            0,8,0,1,8,10,0,0,1,9,
            11,0,0,0,0,0,0,5,3,3,
            7,0,0,0,13,3,3,6,0,1,
            0,25,0,1,0,1,0,0,0,3,
            0,0,0,6,14,3,0,0,7,9,
            0,1,0,7,0,0,4,0,20,0,
            6,0,1,0,17,2,9,0,9,0,
            3,16,0,0,2,0,0,4,0,3,
            2,0,7,0,0,2,5,0,0,2,
            0,1,0,0,0,26,0,1,4,0,
            0,0,10,15,11,4,7,0,1,0,
            1,27,0,0,1,0,4,0,3,0,
            1,0,0,0,0,0,9,4,0,0,
            9,2,0,5,0,1,12,0,1,14,
            18,0,0,11,0,0,5,0,6,5,
            3,6,0,0,1,0,0,1,6,0,
            0,6,2,0,0,0,0,0,9,0,
            6,0,1,0,5,0,11,0,0,4,
            3,18,16,0,1,0,0,9,15,0,
            0,24,0,0,9,0,7,11,0,0,
            2,11,0,1,0,6,0,0,15,2,
            0,19,2,0,8,11,0,0,0,0,
            7,0,5,28,0,9,8,8,0,0,
            2,0,11,4,0,4,0,1,4,0,
            16,0,0,0,2,0,1,6,0,0,
            2,2,0,1,0,16,0,1,0,0,
            0,1,0,0,0,1,0,9,14,26,
            8,5,0,0,0,3,0,0,0,6,
            0,0,0,1,8,4,23,13,29,0,
            0,13,0,0,5,5,0,0,0,6,
            2,21,0,1,8,0,0,1,16,0,
            33,0,15,0,5,10,0,1,0,1,
            0,8,0,1,4,0,15,0,1,0,
            0,0,2,0,0,4,0,8,5,3,
            0,0,0,0,1,0,21,0,0,2,
            0,0,12,11,9,5,22,6,0,0,
            12,0,1,22,6,0,0,2,2,0,
            1,12,0,0,0,0,1,4,0,0,
            8,0,1,9,0,0,0,8,0,0,
            0,7,14,8,5,0,0,0,3,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            328,85,83,78,79,82,89,72,84,90,
            81,86,77,88,328,102,101,71,328,80,
            137,328,73,76,68,70,328,133,131,75,
            87,328,328,128,74,130,132,69,245,328,
            127,349,247,340,328,248,246,328,111,177,
            328,345,179,119,120,110,249,109,129,328,
            134,112,113,114,328,92,328,328,176,118,
            178,124,328,126,97,328,125,100,96,328,
            104,328,99,328,328,103,328,121,115,107,
            328,344,353,106,122,328,328,328,22,362,
            159,160,154,188,167,328,187,337,328,328,
            328,204,116,328,192,328,168,328,144,93,
            328,193,329,285,94,328,95,91,284,328,
            328,105,328,328,117,327,328,328,328,98,
            136,138,108,135,328,328,123,139,328,328,
            328,141,328,140,328,328,328,328,347,142,
            146,143,145,328,328,354,147,328,148,328,
            328,346,149,328,363,328,328,150,328,151,
            328,153,328,328,152,328,328,156,155,328,
            328,157,328,331,161,158,328,328,165,163,
            162,328,328,328,328,328,328,169,171,172,
            170,328,328,328,166,381,181,173,328,174,
            328,164,328,175,328,180,328,328,328,182,
            328,328,328,183,184,388,328,328,391,186,
            328,351,328,390,328,328,341,328,185,328,
            190,328,342,328,189,196,191,328,194,328,
            195,333,328,328,332,328,328,198,328,200,
            339,2,199,328,328,202,201,328,328,203,
            328,383,328,328,328,197,328,208,209,328,
            328,328,210,206,207,211,212,328,213,328,
            214,205,328,328,216,328,215,328,217,328,
            352,328,328,328,328,328,218,220,328,328,
            219,222,328,223,328,225,343,328,226,224,
            221,328,328,234,328,328,227,328,228,229,
            231,230,328,328,233,328,328,236,232,328,
            328,235,366,328,328,328,328,328,237,328,
            239,328,240,328,242,328,241,328,328,243,
            359,238,384,328,338,328,328,250,378,328,
            328,244,328,328,360,328,252,251,328,328,
            257,253,328,258,328,259,328,328,255,365,
            328,254,261,328,260,392,328,328,328,328,
            379,328,263,256,328,262,385,264,328,328,
            265,328,266,382,328,268,328,270,269,328,
            267,328,328,328,273,328,369,272,328,328,
            275,334,328,335,328,271,328,358,328,328,
            328,278,328,328,328,355,328,348,276,274,
            389,279,328,328,328,280,328,328,328,282,
            36,328,328,361,286,288,281,283,277,328,
            328,287,328,328,289,290,328,328,328,294,
            297,291,328,295,292,328,328,372,368,328,
            373,328,293,328,298,296,328,299,328,300,
            328,301,328,304,302,328,303,328,387,328,
            328,328,357,328,328,356,328,386,306,307,
            328,328,328,328,336,328,305,328,328,314,
            328,328,308,311,312,313,309,315,328,328,
            371,328,317,310,316,328,328,318,319,328,
            376,370,328,328,328,328,321,320,328,328,
            375,328,323,377,328,328,328,367,328,328,
            328,324,322,374,325,328,328,328,380
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
           NUM_STATES        = 260,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 392,
           MAX_LA            = 1,
           NUM_RULES         = 64,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 65,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 327,
           ERROR_ACTION      = 328;

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
