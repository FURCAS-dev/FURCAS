
/**
  * This file is generated for MOIN-OCL with LPG. 
  */

package com.sap.tc.moin.ocl.parser.gen;

public class OclKeywordLexerprs implements lpg.lpgjavaruntime.ParseTable, OclKeywordLexersym {

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
            11,11,9,14,12,12,6,7,4,5,
            6,7,5,6,7,10,4,7,3,3,
            3,4,4,7,7,10,3,6,4
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
            1,62,59,107,94,21,31,112,109,121,
            123,124,118,57,128,64,16,73,129,44,
            131,45,80,51,62,36,75,65,132,133,
            135,140,134,137,143,148,146,150,85,152,
            155,156,157,159,160,90,162,164,167,173,
            176,163,181,177,182,86,88,185,186,187,
            188,190,192,96,194,195,197,198,200,201,
            206,208,211,212,213,219,221,223,227,41,
            230,233,236,232,224,228,237,241,99,25,
            242,97,244,249,251,253,254,256,260,262,
            258,105,266,267,268,271,274,270,275,278,
            280,283,282,288,289,293,295,297,299,302,
            305,303,307,308,311,310,309,316,319,318,
            322,325,327,330,276,332,334,336,328,337,
            340,342,202,343,341,345,346,351,354,353,
            15,357,359,360,362,363,365,373,364,376,
            377,380,381,382,383,386,390,391,393,395,
            398,399,400,401,402,405,407,410,413,411,
            418,416,419,420,421,423,424,427,429,432,
            433,435,436,444,450,443,452,454,458,437,
            462,460,466,468,464,471,472,473,474,476,
            477,482,478,485,486,488,491,493,494,495,
            497,498,503,511,508,513,505,516,518,520,
            292,292
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,0,0,1,17,3,19,
            0,21,22,23,0,5,26,27,8,9,
            0,17,32,33,34,0,22,37,3,4,
            0,17,28,0,0,10,16,12,4,35,
            0,8,2,9,4,11,0,17,0,16,
            20,0,0,0,0,9,31,11,5,19,
            9,8,0,9,0,1,12,5,38,0,
            8,2,8,4,0,0,2,0,4,0,
            29,6,3,0,7,0,0,39,0,14,
            13,8,7,7,0,1,0,1,0,13,
            2,0,0,18,25,17,12,0,20,8,
            0,1,0,0,1,8,4,0,0,1,
            0,0,0,0,0,8,0,6,8,0,
            1,5,0,11,10,0,13,0,3,0,
            8,0,5,2,0,0,0,2,0,0,
            6,0,0,0,8,2,0,0,9,3,
            9,9,0,15,2,0,0,1,3,30,
            0,0,2,2,0,0,0,0,1,0,
            6,0,1,0,0,10,0,0,2,0,
            0,0,16,9,7,0,13,0,3,2,
            0,0,0,14,2,14,5,28,0,1,
            0,1,0,0,24,3,0,0,2,0,
            1,0,0,23,2,0,0,2,7,16,
            0,0,2,0,1,0,10,20,0,1,
            0,10,0,0,4,0,4,0,3,0,
            3,0,9,2,5,0,0,0,1,0,
            0,5,2,0,0,0,3,0,1,0,
            1,0,0,18,15,11,4,0,0,8,
            15,4,0,1,0,1,0,9,0,1,
            4,0,0,2,0,1,0,0,0,0,
            0,4,10,3,5,0,10,0,0,2,
            12,0,7,5,0,1,0,0,7,0,
            1,0,1,0,1,0,0,11,3,0,
            0,0,0,1,0,0,19,11,7,5,
            0,11,0,0,4,2,0,18,0,0,
            15,0,0,0,0,3,10,0,10,6,
            11,7,0,1,22,0,0,1,3,0,
            0,0,0,3,3,0,25,5,9,0,
            0,6,0,3,0,6,4,0,0,0,
            0,0,4,4,0,11,0,3,7,0,
            0,14,0,1,14,0,6,0,0,0,
            0,2,0,0,1,16,0,10,0,7,
            24,0,0,0,0,0,0,6,4,13,
            5,26,0,0,8,13,18,27,5,0,
            1,0,1,0,36,0,14,0,1,0,
            7,0,1,0,5,0,1,0,1,6,
            0,0,0,0,4,0,0,0,3,6,
            4,0,10,2,0,0,15,0,0,12,
            0,1,0,0,0,3,0,0,11,0,
            7,7,0,1,0,21,21,0,12,12,
            0,1,0,6,10,0,4,0,1,0,
            0,6,0,0,0,6,0,0,0,0,
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
            292,83,78,84,79,82,63,85,81,71,
            86,72,77,65,292,292,105,70,104,80,
            292,73,66,64,292,89,75,76,90,91,
            292,231,74,67,68,292,233,69,122,123,
            292,183,232,292,292,121,92,294,113,234,
            292,110,118,299,117,112,292,171,292,109,
            173,292,292,292,292,100,124,99,103,116,
            119,102,292,127,292,126,349,107,172,292,
            106,114,125,115,292,292,138,292,137,292,
            120,298,307,292,150,12,292,291,292,316,
            343,88,157,186,292,192,292,87,292,185,
            94,292,292,158,144,182,293,292,181,93,
            292,95,292,292,97,98,96,292,292,108,
            292,292,292,292,292,101,292,128,111,292,
            342,132,292,129,130,292,131,292,135,292,
            133,292,134,139,292,292,292,141,292,292,
            140,292,292,292,142,146,292,292,143,303,
            145,300,292,308,147,292,292,317,301,136,
            292,292,148,149,292,292,292,292,154,292,
            151,292,156,292,292,152,292,292,161,292,
            292,292,153,160,162,292,159,292,344,164,
            292,292,292,345,331,336,166,155,292,167,
            292,168,292,292,163,169,292,292,170,292,
            174,292,292,165,175,292,292,176,177,178,
            292,292,339,292,296,292,180,179,292,305,
            292,184,292,292,295,292,187,292,351,49,
            191,292,188,190,189,292,292,292,335,292,
            292,194,195,292,292,292,332,292,198,292,
            199,292,292,193,196,197,200,292,292,201,
            220,202,292,204,292,205,292,203,292,207,
            206,292,292,208,292,306,292,292,292,292,
            292,211,209,212,213,292,210,292,292,216,
            297,292,214,215,292,218,292,292,217,292,
            350,292,333,292,221,292,292,219,320,292,
            292,292,292,226,292,292,222,223,225,228,
            292,227,292,292,229,313,292,224,292,292,
            329,292,292,292,292,238,235,292,314,241,
            236,239,292,240,230,292,292,347,319,292,
            292,292,292,346,242,292,237,243,330,292,
            292,337,292,245,292,244,334,292,292,292,
            292,292,248,249,292,246,292,252,251,292,
            292,247,292,312,250,292,340,292,26,292,
            292,257,292,292,309,254,292,302,292,259,
            253,292,292,292,292,292,292,262,264,260,
            265,255,292,292,270,263,261,258,266,292,
            315,292,267,292,256,292,322,292,269,292,
            268,292,325,292,271,292,272,292,273,274,
            292,292,292,292,275,292,292,292,311,338,
            310,292,277,278,292,292,276,292,292,279,
            292,348,292,292,292,283,292,292,282,292,
            284,285,292,286,292,280,281,292,324,323,
            292,287,292,327,328,292,288,292,289,292,
            292,321,292,292,292,326
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
           NUM_STATES        = 229,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 351,
           MAX_LA            = 1,
           NUM_RULES         = 59,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 60,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 291,
           ERROR_ACTION      = 292;

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
