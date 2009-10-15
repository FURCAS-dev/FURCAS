/**
* Essential OCL Keyword Lexer
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
*   E.D.Willink - Bug 285633, 292112
* </copyright>
*
* $Id: OCLBacktrackingKWLexerprs.java,v 1.9 2009/10/15 19:40:57 ewillink Exp $
*/
/**
* Complete OCL Keyword Lexer
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
*   E.D.Willink - Bug 292112
* </copyright>
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
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,7,
            6,6,8,3,3,7,6,6,13,8,
            7,6,7,16,4,7,5,6,7,10,
            4,7,3,3,4,4,7,7,10,3,
            6,4,10,6
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
            1,1,1,1,1,1,57,69,90,99,
            13,18,108,88,111,112,23,55,114,45,
            63,68,117,40,115,70,119,38,71,37,
            59,73,120,121,125,126,128,130,133,137,
            131,138,79,141,140,142,147,150,98,81,
            151,153,152,157,162,159,167,85,165,169,
            170,172,173,148,176,86,179,181,182,183,
            187,188,14,190,195,196,191,200,202,205,
            206,207,22,211,213,214,218,209,219,220,
            222,223,89,226,228,231,232,235,238,239,
            244,246,249,96,245,250,252,255,256,257,
            258,259,263,265,267,271,273,274,276,282,
            280,286,288,289,292,293,284,295,296,299,
            303,304,305,307,311,308,313,314,320,316,
            317,325,324,326,327,328,329,331,337,332,
            346,347,338,349,340,352,353,355,357,358,
            362,365,369,363,372,374,375,378,379,380,
            381,382,386,385,387,392,393,398,395,397,
            399,401,408,410,402,403,414,417,418,411,
            416,422,424,429,430,432,433,434,438,441,
            436,447,439,450,452,453,458,461,454,463,
            457,465,467,265,265
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
            8,0,0,23,24,3,26,27,28,12,
            8,31,19,33,34,35,0,0,2,0,
            3,5,5,22,0,24,10,8,4,0,
            14,12,8,32,0,18,20,36,0,1,
            2,7,0,1,2,11,8,0,0,0,
            0,4,0,0,5,8,7,7,0,7,
            0,3,2,5,0,0,14,0,0,0,
            1,6,5,9,6,0,1,0,0,29,
            16,21,17,15,7,37,8,0,1,14,
            0,0,1,0,0,5,0,1,0,0,
            0,8,8,5,0,0,1,0,9,0,
            0,11,0,4,10,3,0,0,2,0,
            0,0,15,3,3,8,0,0,9,0,
            0,0,0,2,8,3,0,7,0,3,
            30,0,13,2,0,7,0,1,0,0,
            6,0,0,1,27,0,1,9,0,10,
            0,0,0,12,4,3,0,0,7,0,
            0,2,6,15,0,0,6,3,3,0,
            1,0,1,16,0,0,0,2,0,3,
            0,1,0,0,10,3,3,0,0,0,
            12,0,0,6,3,0,1,0,1,10,
            0,0,10,0,0,5,5,0,0,2,
            22,7,4,0,0,0,3,2,0,0,
            2,0,1,4,0,0,0,0,0,1,
            0,17,0,1,0,1,0,11,13,12,
            0,5,0,0,20,0,1,5,8,0,
            7,0,1,0,5,0,1,0,0,1,
            3,0,0,2,0,0,4,14,0,4,
            6,3,0,0,0,1,0,0,6,6,
            0,1,0,0,1,0,0,11,6,0,
            13,2,7,0,0,0,0,0,0,1,
            0,0,6,10,18,11,0,0,0,0,
            4,11,17,16,13,0,0,10,0,3,
            5,0,0,2,0,1,0,0,6,11,
            21,0,0,2,0,1,9,11,0,7,
            2,0,1,0,0,2,2,0,0,0,
            0,0,4,2,0,0,0,10,9,9,
            5,0,0,1,0,11,0,0,0,1,
            0,0,0,12,10,19,9,0,6,0,
            0,4,3,0,1,0,0,0,1,23,
            4,0,1,0,9,25,16,26,0,0,
            1,0,0,0,6,0,13,0,0,8,
            0,1,0,5,9,13,0,10,2,0,
            1,0,0,0,2,4,0,0,25,2,
            0,1,0,7,0,12,0,0,4,3,
            0,9,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            265,77,78,72,76,73,79,65,75,58,
            80,66,265,265,71,60,83,265,74,85,
            84,265,265,69,64,91,70,63,59,86,
            92,68,155,67,62,61,265,265,114,265,
            110,115,109,166,265,164,113,104,97,265,
            267,103,96,163,265,108,116,165,265,119,
            117,94,265,99,98,93,118,265,265,265,
            265,101,265,265,106,100,272,111,265,120,
            265,131,280,130,265,12,315,265,265,265,
            81,148,88,271,176,265,183,265,265,112,
            289,137,149,175,136,264,82,265,87,266,
            265,265,90,265,265,89,265,102,265,265,
            265,95,105,107,265,265,309,265,121,265,
            265,122,265,125,123,126,265,265,127,265,
            265,265,124,132,134,129,265,265,133,265,
            265,265,265,276,135,139,265,138,265,140,
            128,265,281,274,265,273,265,290,265,265,
            141,265,265,145,146,265,147,142,265,143,
            265,265,265,144,151,153,265,265,152,265,
            265,310,154,150,265,265,157,156,300,265,
            158,265,159,311,265,265,265,161,265,162,
            265,167,265,265,160,168,169,265,265,265,
            171,265,265,170,306,265,269,265,278,173,
            265,265,174,265,265,268,177,265,43,317,
            172,178,179,265,265,265,180,181,265,265,
            182,265,302,185,265,265,265,265,265,190,
            265,184,265,191,265,192,265,188,187,189,
            265,193,265,265,186,265,197,195,194,265,
            196,265,198,265,199,265,200,265,265,279,
            201,265,265,202,265,265,203,270,265,205,
            204,206,265,265,265,209,265,265,207,208,
            265,316,265,265,213,265,265,210,212,265,
            211,293,214,265,265,265,265,265,265,220,
            265,265,219,217,215,216,265,265,265,265,
            222,221,218,303,297,265,265,287,265,286,
            223,265,265,226,265,228,265,265,227,224,
            225,265,265,292,265,313,229,319,265,298,
            230,265,296,265,265,312,231,265,265,265,
            265,265,233,235,265,265,265,232,304,234,
            301,265,265,285,265,236,265,265,265,240,
            26,265,265,238,275,237,307,265,245,265,
            265,242,243,265,282,265,265,265,288,239,
            246,265,248,265,247,241,295,244,265,265,
            251,265,265,265,250,265,249,265,265,252,
            265,318,265,283,305,253,265,255,284,265,
            314,265,265,265,257,256,265,265,254,258,
            265,259,265,261,265,260,265,265,262,299,
            265,294
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
