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
* $Id: OCLBacktrackingKWLexerprs.java,v 1.3 2009/09/01 20:11:23 ewillink Exp $
*/

package org.eclipse.ocl.parser.backtracking;

public class OCLBacktrackingKWLexerprs implements lpg.lpgjavaruntime.ParseTable, OCLBacktrackingKWLexersym {

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
            7,4,4
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
            1,1,1,1,1,66,97,114,65,116,
            121,126,68,19,73,15,76,130,80,132,
            45,60,82,133,51,85,135,67,32,27,
            48,138,137,40,118,141,139,146,148,151,
            152,91,153,154,161,162,167,164,155,170,
            174,176,177,84,168,183,96,179,172,186,
            187,98,188,189,190,191,193,201,195,99,
            198,203,204,209,210,213,219,33,221,223,
            224,211,215,225,228,230,231,87,232,234,
            235,240,241,243,248,109,246,250,254,242,
            257,259,260,262,263,265,268,270,111,274,
            271,276,277,278,280,282,281,286,289,294,
            296,301,303,304,299,307,309,297,310,311,
            314,317,320,324,322,326,328,329,334,338,
            330,336,343,345,340,346,348,350,351,356,
            353,355,357,359,360,22,363,368,365,371,
            373,375,376,377,378,379,387,383,385,394,
            397,391,400,402,403,404,408,401,413,414,
            415,416,417,421,422,423,426,431,427,433,
            438,434,440,436,442,443,446,444,451,453,
            455,456,458,106,459,460,462,464,465,469,
            463,477,466,473,479,480,487,485,489,496,
            492,499,501,483,503,504,505,508,509,512,
            511,514,516,522,515,517,523,524,530,528,
            533,532,536,540,541,543,547,549,550,556,
            554,559,558,560,564,565,568,570,571,569,
            572,323,323
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
            0,0,22,23,24,25,0,1,10,29,
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
            1,0,0,1,0,39,0,0,0,3,
            0,10,5,3,10,0,8,0,3,32,
            0,0,0,0,0,1,3,10,7,7,
            0,0,2,0,3,15,0,0,2,0,
            7,0,3,0,1,0,0,2,0,3,
            9,14,0,1,6,0,0,0,0,0,
            0,1,0,8,0,8,10,0,9,11,
            0,1,0,0,7,3,3,13,0,0,
            0,3,0,1,0,6,6,25,0,1,
            0,1,0,0,0,3,3,0,14,0,
            0,0,3,0,0,1,9,7,7,0,
            0,0,0,4,20,0,6,0,1,0,
            17,9,3,0,9,2,0,16,0,0,
            2,0,0,4,0,3,2,0,7,0,
            0,2,5,0,1,0,0,0,1,0,
            0,0,26,4,4,0,0,11,0,1,
            15,10,7,0,1,0,0,27,0,4,
            0,1,0,0,1,3,0,9,0,0,
            0,2,4,0,18,9,0,0,5,0,
            1,0,12,0,1,0,5,0,0,0,
            14,6,5,0,6,0,3,0,1,0,
            11,6,0,1,0,0,2,0,9,0,
            0,1,0,6,0,0,0,5,0,0,
            4,3,0,18,0,16,11,0,1,15,
            0,9,0,9,0,0,0,0,0,7,
            2,11,0,24,0,11,0,1,6,0,
            0,15,8,0,19,2,0,7,2,0,
            0,0,0,0,4,28,5,0,9,2,
            8,8,0,0,0,0,0,1,4,4,
            0,0,0,11,2,0,0,6,2,16,
            0,1,0,0,2,0,16,0,1,0,
            1,0,0,0,9,0,1,14,5,8,
            0,26,0,3,0,0,1,0,0,0,
            6,0,0,0,0,0,8,4,0,5,
            13,29,0,5,13,23,0,1,0,0,
            8,16,0,21,0,6,0,1,0,1,
            8,0,33,15,10,0,5,2,0,1,
            0,1,0,0,0,1,4,0,0,1,
            0,0,2,0,0,0,0,4,15,8,
            5,0,0,0,3,0,12,0,21,0,
            1,0,0,2,11,0,9,5,22,0,
            0,6,0,0,22,6,0,1,0,0,
            2,2,12,0,12,0,1,0,0,0,
            1,8,4,0,0,1,9,0,0,0,
            0,0,0,5,3,8,7,14,8,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            323,84,82,77,78,81,88,71,83,89,
            80,85,76,87,323,101,100,70,323,79,
            323,323,72,75,67,69,323,131,97,74,
            86,323,323,127,73,129,130,68,240,323,
            126,135,242,335,323,243,241,323,110,174,
            323,340,176,118,119,109,244,108,128,323,
            132,111,112,113,323,91,323,323,173,117,
            175,123,323,125,96,323,124,99,95,323,
            103,323,98,323,323,102,323,120,114,106,
            323,339,348,105,121,323,323,323,22,357,
            157,158,152,185,165,323,184,332,323,323,
            323,200,115,323,189,323,166,323,142,92,
            323,190,324,280,93,323,94,90,279,323,
            104,323,323,116,323,322,323,323,323,134,
            323,107,133,137,122,323,138,323,139,136,
            323,323,323,323,323,146,144,140,141,143,
            323,323,344,323,145,349,323,323,342,323,
            341,323,147,323,358,323,323,148,323,149,
            154,150,323,151,153,323,323,323,323,323,
            323,326,323,155,323,159,156,323,161,160,
            323,163,323,323,167,168,169,164,323,323,
            323,376,323,171,323,170,180,162,323,172,
            323,177,323,323,323,178,179,323,181,323,
            323,323,383,323,323,346,183,386,385,323,
            323,323,323,336,182,323,187,323,337,323,
            186,188,192,323,191,193,323,328,323,323,
            327,323,323,195,323,197,334,2,196,323,
            323,199,198,323,378,323,323,323,204,323,
            323,323,194,205,207,323,323,203,323,209,
            202,206,208,323,210,323,323,201,323,211,
            323,212,323,323,347,213,323,214,323,323,
            323,218,216,323,217,215,323,323,219,323,
            221,323,338,323,222,323,223,323,323,323,
            220,224,225,323,226,323,227,323,228,323,
            229,230,323,231,323,323,361,323,232,323,
            323,235,323,234,323,323,323,237,323,323,
            238,354,323,233,323,379,236,323,333,373,
            323,245,323,355,323,323,323,323,323,247,
            252,246,323,239,323,248,323,253,254,323,
            323,250,255,323,249,360,323,374,256,323,
            323,323,323,323,377,251,258,323,257,260,
            380,259,323,323,323,323,323,265,263,264,
            323,323,323,261,268,323,323,267,270,262,
            323,364,323,323,329,323,266,323,330,323,
            353,323,323,323,343,323,273,271,274,384,
            323,269,323,275,323,323,350,323,323,323,
            277,323,36,323,323,323,281,283,323,284,
            278,272,323,285,282,276,323,356,323,323,
            287,363,323,286,323,289,323,290,323,367,
            296,323,368,288,291,323,293,292,323,294,
            323,295,323,323,323,299,297,323,323,382,
            323,323,352,323,323,323,323,351,298,381,
            301,323,323,323,302,323,303,323,300,323,
            331,323,323,309,306,323,307,308,304,323,
            323,310,323,323,305,311,323,312,323,323,
            313,314,366,323,365,323,371,323,323,323,
            316,370,315,323,323,318,372,323,323,323,
            323,323,323,320,375,362,319,317,369
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
           NUM_STATES        = 256,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 386,
           MAX_LA            = 1,
           NUM_RULES         = 63,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 64,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 322,
           ERROR_ACTION      = 323;

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
