
/**
  * This file is generated for MOIN-MQL with LPG. 
  */

package com.sap.tc.moin.repository.core.query.moinql.parser.gen;

public class MqlKeywordLexerprs implements lpg.lpgjavaruntime.ParseTable, MqlKeywordLexersym {

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
            6,4,3,2,2,3,4,4,5,4,
            5,2,15,10,10,8,3,4
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
            21,14,30,33,38,36,15,11,23,42,
            46,24,25,51,39,53,55,56,47,60,
            57,64,65,66,67,68,71,7,72,76,
            74,82,85,78,86,79,94,90,95,99,
            101,103,105,106,107,108,110,32,115,116,
            118,117,122,126,121,129,130,131,137,135,
            139,141,144,133,146,150,145,152,151,156,
            157,159,94,94
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,0,7,8,9,
            0,11,12,0,0,5,6,11,18,9,
            20,7,0,0,0,3,4,13,5,0,
            6,0,0,10,21,0,7,0,0,15,
            8,0,5,12,9,0,0,6,2,4,
            0,1,0,1,0,0,0,19,4,0,
            1,6,6,0,0,0,0,0,5,2,
            0,0,8,0,8,0,1,0,0,8,
            10,0,17,2,0,0,2,14,0,0,
            13,6,14,0,0,1,3,8,0,1,
            0,1,0,1,0,0,0,0,1,0,
            1,5,7,9,0,0,0,0,4,2,
            0,0,7,2,4,0,10,2,0,0,
            0,2,0,3,0,7,0,1,0,5,
            0,3,10,0,0,0,6,4,3,0,
            0,0,3,2,0,0,0,1,0,0,
            16,3,0,0,0,15,11,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static byte termAction[] = {0,
            94,23,32,33,31,29,94,30,22,28,
            94,25,24,94,94,40,41,59,27,42,
            26,38,94,94,94,106,43,39,45,94,
            46,94,94,44,93,94,34,94,94,47,
            35,94,36,72,37,94,94,99,53,98,
            94,48,94,50,94,94,94,49,51,94,
            54,52,111,94,94,94,94,94,55,97,
            94,94,56,94,57,94,112,94,94,60,
            58,94,100,62,94,94,63,61,94,94,
            64,65,104,94,94,102,66,101,94,96,
            94,67,94,68,94,94,94,94,105,94,
            103,71,70,69,94,94,94,94,73,75,
            94,94,74,95,78,94,76,77,94,94,
            94,80,94,110,94,79,94,81,94,82,
            94,83,86,94,94,94,84,85,109,94,
            94,94,108,88,94,94,94,91,94,94,
            87,107,94,94,94,89,90
        };
    };
    public final static byte termAction[] = TermAction.termAction;
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
           NUM_STATES        = 72,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 112,
           MAX_LA            = 0,
           NUM_RULES         = 18,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 19,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 21,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 93,
           ERROR_ACTION      = 94;

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
