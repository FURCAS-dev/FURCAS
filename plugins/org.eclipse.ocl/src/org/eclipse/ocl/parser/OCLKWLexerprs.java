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
* $Id: OCLKWLexerprs.java,v 1.1 2007/10/11 23:05:00 cdamus Exp $
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
            7,16,4,7,5,6,7,7,10,4,
            10,4,4
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
            1,1,1,1,1,66,82,108,27,110,
            123,125,22,129,66,15,74,130,77,132,
            47,61,78,133,49,40,135,62,32,80,
            70,136,137,86,138,143,144,147,148,149,
            153,92,154,156,155,162,166,167,171,173,
            177,179,180,89,175,184,95,163,182,186,
            187,96,188,190,193,198,192,203,195,98,
            200,206,210,211,212,215,221,223,37,225,
            216,227,228,229,231,232,233,235,93,237,
            238,239,245,246,248,253,106,250,255,260,
            247,261,264,265,267,268,270,273,116,276,
            278,279,280,281,284,285,283,290,289,297,
            299,302,303,307,308,311,312,313,301,314,
            315,319,322,325,328,330,331,333,334,341,
            332,339,344,346,349,348,352,353,354,355,
            357,358,360,362,364,369,21,371,372,374,
            376,377,378,379,381,382,386,390,392,395,
            399,394,404,403,405,407,409,416,419,413,
            406,421,426,427,420,429,431,412,439,432,
            441,444,437,446,448,442,449,452,453,454,
            456,459,461,101,464,463,465,466,468,475,
            467,481,469,476,483,479,486,490,491,493,
            497,498,503,501,506,505,507,511,513,514,
            516,519,512,522,524,526,527,528,529,531,
            533,535,541,544,534,542,551,543,553,556,
            558,559,560,561,564,567,565,570,571,575,
            581,323,323
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,0,1,2,0,18,19,
            0,0,22,23,24,25,0,1,7,29,
            30,0,11,2,34,4,0,37,18,0,
            9,21,3,12,24,25,0,0,0,10,
            4,3,4,7,18,35,20,11,27,13,
            0,0,2,3,4,0,5,19,7,0,
            5,10,36,0,38,10,0,0,5,0,
            1,0,13,10,7,0,10,2,0,10,
            14,0,0,2,0,0,8,0,3,4,
            0,7,17,6,16,0,12,0,31,0,
            18,6,20,4,17,0,1,17,13,28,
            39,14,0,23,0,1,4,12,0,0,
            1,0,0,1,0,0,0,0,10,3,
            5,10,0,0,10,3,0,0,0,3,
            0,8,0,0,0,0,2,10,3,7,
            7,0,0,15,3,0,0,2,6,32,
            0,1,0,7,0,3,0,1,0,0,
            2,0,3,0,1,0,0,0,14,0,
            9,0,0,8,0,8,10,0,1,0,
            11,9,0,1,0,0,7,13,3,0,
            0,0,3,3,0,0,25,6,3,5,
            0,1,0,1,0,1,0,0,0,3,
            0,0,0,6,0,3,0,0,0,1,
            9,7,14,7,0,0,0,0,4,0,
            20,6,0,1,0,18,9,3,9,0,
            0,2,16,0,0,2,0,0,4,0,
            3,2,0,7,2,0,1,0,0,0,
            0,3,0,0,0,1,26,4,0,0,
            0,11,10,4,15,7,0,1,0,1,
            0,0,0,1,27,4,0,0,1,3,
            0,0,0,0,0,2,4,17,0,9,
            9,0,0,5,0,1,12,0,1,0,
            0,0,0,0,5,14,6,5,0,6,
            0,1,11,0,6,0,1,0,0,6,
            2,0,0,0,0,1,0,0,6,0,
            9,0,5,0,17,4,3,11,0,16,
            0,0,1,0,15,0,0,0,0,9,
            0,0,9,7,0,0,11,2,11,0,
            1,0,24,0,0,15,2,19,0,8,
            2,8,0,0,0,0,0,5,0,28,
            7,0,0,9,8,0,8,2,0,0,
            0,16,4,11,4,0,0,1,0,4,
            0,0,2,2,6,16,0,26,0,1,
            0,0,2,0,1,0,1,0,0,1,
            14,0,0,0,3,0,9,5,0,1,
            0,6,0,0,0,0,0,0,0,4,
            29,8,5,13,0,0,23,13,0,5,
            0,1,0,8,16,0,1,21,6,0,
            0,1,0,15,2,33,0,0,1,10,
            0,5,0,1,0,0,0,1,8,4,
            0,0,0,0,1,0,5,2,0,15,
            8,0,4,0,3,0,0,0,0,1,
            0,21,0,0,0,12,2,5,11,9,
            0,0,0,0,2,12,6,22,22,6,
            0,1,0,12,2,0,1,0,0,0,
            0,1,4,0,0,8,0,1,9,0,
            0,0,8,0,0,0,7,14,8,5,
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
            323,84,82,77,78,81,88,71,83,89,
            80,85,76,87,323,101,100,323,70,79,
            323,323,72,75,67,69,323,91,96,74,
            86,323,95,127,73,129,323,68,241,323,
            126,243,120,335,244,242,323,323,323,121,
            110,118,119,340,174,245,177,109,128,108,
            323,323,111,112,113,323,123,117,125,323,
            99,124,175,323,176,98,323,323,103,323,
            131,323,132,102,114,323,106,136,323,130,
            105,323,323,348,323,323,339,22,158,159,
            323,153,135,166,357,323,332,323,115,323,
            186,190,185,92,325,323,200,280,191,143,
            322,90,323,279,323,94,93,324,323,323,
            104,323,323,116,323,323,323,323,97,134,
            133,107,323,323,122,138,323,323,323,140,
            323,139,323,323,323,323,344,141,145,142,
            144,323,323,349,146,323,323,342,154,137,
            323,147,323,341,323,148,323,358,323,323,
            149,323,150,323,152,323,323,323,151,323,
            155,323,323,156,323,160,157,323,326,323,
            161,162,323,164,323,323,167,165,168,323,
            323,323,169,376,323,323,163,170,179,171,
            323,172,323,173,323,178,323,323,323,180,
            323,323,323,181,323,383,323,323,323,346,
            184,386,182,385,323,323,323,323,336,323,
            183,188,323,337,323,187,189,193,192,323,
            323,194,328,323,323,327,323,323,196,323,
            198,334,323,197,199,323,378,323,323,323,
            323,202,323,323,323,206,195,205,323,323,
            323,204,207,208,203,209,323,210,323,211,
            323,323,323,213,201,212,323,323,347,214,
            323,323,323,323,323,219,217,218,323,215,
            216,323,323,220,323,222,338,323,223,323,
            323,323,323,323,224,221,225,226,323,227,
            323,228,229,323,230,323,232,323,323,231,
            361,323,323,323,323,236,323,323,235,323,
            234,323,238,323,233,239,354,237,323,379,
            323,323,333,323,373,323,323,323,323,246,
            323,323,355,248,323,323,247,253,249,323,
            254,323,240,323,323,251,360,250,323,255,
            256,381,323,323,323,323,323,257,323,252,
            374,323,323,258,380,323,259,260,323,323,
            323,262,377,261,263,323,323,265,323,264,
            323,323,268,270,267,266,323,269,323,364,
            323,323,329,323,330,323,353,323,323,273,
            271,323,323,323,274,323,343,275,323,350,
            323,277,323,323,323,323,36,323,323,283,
            272,281,284,278,323,323,276,282,323,285,
            323,356,323,287,363,323,290,286,288,323,
            323,367,323,289,292,368,323,323,294,291,
            323,293,323,295,323,323,323,299,296,297,
            323,323,323,323,382,323,301,352,323,298,
            384,323,351,323,302,323,323,323,323,331,
            323,300,323,323,323,303,309,308,306,307,
            323,323,323,323,313,366,310,304,305,311,
            323,312,323,365,314,323,371,323,323,323,
            323,316,315,323,323,370,323,318,372,323,
            323,323,362,323,323,323,319,317,369,320,
            323,323,323,375
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
