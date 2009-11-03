/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package com.sap.tc.moin.repository.core.query.moinql.parser.gen;

public class MqlParserGenprs implements lpg.lpgjavaruntime.ParseTable, MqlParserGensym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            0,1,1,3,1,1,3,1,1,3,
            1,3,0,2,3,1,1,3,2,3,
            1,4,1,1,2,3,0,2,0,3,
            1,3,0,3,4,4,4,0,1,1,
            2,2,1,1,5,1,3,3,2,1,
            2,3,2,2,2,2,2,2,2,3,
            1,1,1,1,1,1,4,3,2,4,
            0,3,1,5,2,2,2,2,2,2,
            2,3,1,2,1,3,0,2,0,1,
            -6,0,-2,0,0,0,-35,0,-51,0,
            0,-7,0,0,0,0,0,0,0,0,
            0,-20,0,-1,0,0,0,-12,0,-9,
            0,0,0,-10,0,0,0,0,0,0,
            0,0,-30,0,-3,0,0,0,-17,0,
            -54,0,0,0,0,0,-5,0,0,-32,
            0,0,0,0,0,-49,0,-8,0,0,
            0,0,0,-4,0,-16,0,-42,0,0,
            0,0,0,-11,0,0,-13,0,0,0,
            0,-43,0,0,-22,0,0,0,0,0,
            -44,0,0,-45,0,0,-23,0,0,0,
            -15,0,-46,0,0,-47,0,0,-53,0,
            0,-62,0,-24,0,0,-14,0,0,-63,
            0,-80,0,-27,0,0,0,-81,0,-31,
            0,-34,0,-82,0,-76,0,0,0,-21,
            -88,0,0,0,0,0,-52,0,0,0,
            -19,0,0,-25,0,-26,0,-55,0,0,
            0,-41,-59,0,-48,0,-57,-18,0,0,
            -66,-67,0,0,-68,-69,0,0,-70,-28,
            0,0,-71,-72,0,0,-77,0,0,-78,
            0,-79,-29,0,-33,-36,-37,-38,-39,-40,
            -50,-56,-58,0,-60,-61,-64,-65,-73,-74,
            -75,-83,-84,-85,-86,-87,0
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            12,11,11,9,9,1,3,3,4,5,
            5,10,12,12,13,14,14,15,15,27,
            16,16,17,18,18,19,20,21,21,30,
            30,22,22,29,29,31,31,31,28,28,
            24,24,25,32,32,33,26,26,26,6,
            6,7,7,35,35,35,35,35,35,35,
            35,2,2,2,2,2,2,34,34,36,
            36,38,38,37,37,39,39,39,39,39,
            39,39,39,40,40,8,8,41,41,23,
            23,32,177,51,9,11,8,35,247,35,
            247,217,5,46,50,46,50,19,174,201,
            23,24,32,177,28,9,11,8,2,240,
            30,268,217,301,77,307,93,135,20,174,
            201,23,24,2,177,67,9,11,8,2,
            18,2,177,297,9,11,8,72,41,124,
            1,297,42,43,44,296,2,177,79,9,
            306,8,147,32,2,158,2,158,26,303,
            85,39,124,299,81,12,80,44,14,102,
            15,102,26,303,85,2,293,67,10,73,
            79,26,303,85,26,303,85,2,293,78,
            7,80,77,26,303,85,26,263,83,35,
            247,76,35,247,87,49,50,59,48,50,
            35,247,122,314,70,232,47,50,122,314,
            76,2,91,313,122,314,28,2,25,315,
            59,2,314,2,28,316,75,6,312,135,
            4,2,280,298,2,230,2,68,11,22,
            150,26,29,116,81,2,305,29,60,82,
            69,29,29,59,58,29,29,57,56,29,
            4,55,51,29,29,54,53,2,86,34,
            2,88,29,83,60,86,94,92,102,103,
            101,38,99,107,84,104,110,50,117,118,
            126,127,119,132,133,136,138,319,319
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,0,1,0,0,0,6,7,4,9,
            0,6,7,10,9,15,16,17,18,19,
            15,16,17,18,19,0,1,0,0,0,
            1,0,1,8,0,1,8,0,13,14,
            6,13,14,0,10,35,36,37,11,0,
            0,26,27,28,26,27,28,30,0,0,
            11,24,25,32,5,22,0,38,9,0,
            1,0,29,24,25,0,0,8,0,0,
            0,6,0,5,4,0,0,12,2,39,
            0,0,34,0,23,4,3,31,0,23,
            0,0,0,0,22,20,0,7,10,0,
            20,5,33,12,12,0,0,0,0,2,
            5,0,1,7,21,0,0,2,2,11,
            21,0,0,0,3,0,4,0,3,0,
            3,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            89,319,324,319,16,319,300,262,166,206,
            319,308,271,97,275,194,203,182,191,168,
            283,284,276,279,272,319,324,13,319,319,
            324,319,324,380,319,324,380,319,382,381,
            209,382,381,6,99,311,310,309,364,319,
            319,383,384,385,383,384,385,164,27,319,
            371,212,220,118,224,197,319,251,256,319,
            324,38,185,212,220,33,40,295,17,319,
            21,409,6,139,112,319,29,89,133,318,
            71,31,214,319,120,141,349,91,319,120,
            90,319,319,319,197,265,319,267,236,319,
            156,287,254,258,302,87,319,319,319,222,
            290,1,324,292,389,319,319,228,234,393,
            391,319,3,319,356,319,241,319,355,319,
            354
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static byte asb[] = {0,
            8,9,16,41,49,1,15,14,11,49,
            48,41,26,37,38,41,41,76,41,1,
            37,41,41,34,41,41,43,6,27,41,
            46,54,79,53,4,32,31,82,82,81,
            19,18,18,18,18,18,18,41,41,84,
            4,55,4,41,67,6,19,74,71,88,
            88,4,4,84,62,19,19,19,19,19,
            19,19,35,35,35,64,41,41,19,40,
            40,40,51,32,31,32,32,41
        };
    };
    public final static byte asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static byte asr[] = {0,
            1,32,0,6,1,10,0,30,39,0,
            38,1,0,5,4,31,0,1,8,14,
            13,26,27,28,0,29,21,33,34,22,
            4,3,0,33,2,0,34,33,0,3,
            1,0,1,8,0,12,6,4,39,23,
            11,0,20,12,16,15,18,17,9,19,
            6,7,0,11,30,0,35,36,37,0,
            11,23,39,5,0,5,9,0,20,0,
            7,12,0,11,25,24,0,21,0
        };
    };
    public final static byte asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            7,25,13,24,15,1,25,25,10,15,
            25,24,25,28,25,24,24,25,24,1,
            28,24,24,26,24,24,24,25,25,24,
            30,17,25,33,4,25,25,25,25,25,
            39,20,20,20,20,20,24,24,24,25,
            4,35,23,24,37,25,39,25,41,25,
            25,23,23,25,25,39,39,39,39,39,
            39,39,25,25,25,7,24,24,39,24,
            24,24,25,25,25,25,25,24
        };
    };
    public final static byte nasb[] = Nasb.nasb;
    public final int nasb(int index) { return nasb[index]; }

    public interface Nasr {
        public final static byte nasr[] = {0,
            1,17,0,1,26,0,13,12,0,1,
            32,0,27,0,25,0,23,37,0,1,
            8,0,6,1,0,30,0,21,0,23,
            29,0,38,0,35,0,31,0,2,0,
            41,0
        };
    };
    public final static byte nasr[] = Nasr.nasr;
    public final int nasr(int index) { return nasr[index]; }

    public interface TerminalIndex {
        public final static byte terminalIndex[] = {0,
            42,9,10,13,16,29,37,21,3,7,
            8,30,20,22,1,2,4,5,6,11,
            12,15,26,35,36,38,39,40,18,23,
            24,25,27,28,31,32,33,34,41,14,
            17,43
        };
    };
    public final static byte terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static byte nonterminalIndex[] = {0,
            45,64,46,47,0,62,0,68,44,48,
            0,0,49,51,52,53,54,55,0,0,
            0,56,0,58,59,61,50,0,0,0,
            57,60,0,0,63,65,66,0,0,67,
            0,0
        };
    };
    public final static byte nonterminalIndex[] = NonterminalIndex.nonterminalIndex;
    public final int nonterminalIndex(int index) { return nonterminalIndex[index]; }

    public interface ScopePrefix {
        public final static byte scopePrefix[] = {
            1,8
        };
    };
    public final static byte scopePrefix[] = ScopePrefix.scopePrefix;
    public final int scopePrefix(int index) { return scopePrefix[index]; }

    public interface ScopeSuffix {
        public final static byte scopeSuffix[] = {
            6,6
        };
    };
    public final static byte scopeSuffix[] = ScopeSuffix.scopeSuffix;
    public final int scopeSuffix(int index) { return scopeSuffix[index]; }

    public interface ScopeLhs {
        public final static byte scopeLhs[] = {
            37,7
        };
    };
    public final static byte scopeLhs[] = ScopeLhs.scopeLhs;
    public final int scopeLhs(int index) { return scopeLhs[index]; }

    public interface ScopeLa {
        public final static byte scopeLa[] = {
            11,11
        };
    };
    public final static byte scopeLa[] = ScopeLa.scopeLa;
    public final int scopeLa(int index) { return scopeLa[index]; }

    public interface ScopeStateSet {
        public final static byte scopeStateSet[] = {
            7,1
        };
    };
    public final static byte scopeStateSet[] = ScopeStateSet.scopeStateSet;
    public final int scopeStateSet(int index) { return scopeStateSet[index]; }

    public interface ScopeRhs {
        public final static byte scopeRhs[] = {0,
            54,10,12,65,0,8,0,68,10,0
        };
    };
    public final static byte scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static char scopeState[] = {0,
            220,212,209,99,97,0,150,0
        };
    };
    public final static char scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static byte inSymb[] = {0,
            0,54,55,30,69,31,57,43,23,67,
            59,32,43,52,60,4,5,43,38,4,
            43,29,22,34,33,9,5,43,43,2,
            43,78,8,43,10,64,52,65,65,6,
            7,19,17,18,15,16,9,20,20,68,
            10,43,6,4,12,12,7,43,43,43,
            46,24,25,68,6,7,19,9,17,18,
            15,16,37,36,35,10,5,5,7,2,
            2,2,54,53,43,53,53,4
        };
    };
    public final static byte inSymb[] = InSymb.inSymb;
    public final int inSymb(int index) { return inSymb[index]; }

    public interface Name {
        public final static String name[] = {
            "", //$NON-NLS-1$
            ">", //$NON-NLS-1$
            "<", //$NON-NLS-1$
            "=", //$NON-NLS-1$
            ">=", //$NON-NLS-1$
            "<=", //$NON-NLS-1$
            "<>", //$NON-NLS-1$
            "(", //$NON-NLS-1$
            ")", //$NON-NLS-1$
            "{", //$NON-NLS-1$
            "}", //$NON-NLS-1$
            "[", //$NON-NLS-1$
            "]", //$NON-NLS-1$
            ",", //$NON-NLS-1$
            ":", //$NON-NLS-1$
            "::", //$NON-NLS-1$
            ".", //$NON-NLS-1$
            "!", //$NON-NLS-1$
            "#", //$NON-NLS-1$
            "$empty", //$NON-NLS-1$
            "STRING_LITERAL", //$NON-NLS-1$
            "INTEGER_LITERAL", //$NON-NLS-1$
            "REAL_LITERAL", //$NON-NLS-1$
            "select", //$NON-NLS-1$
            "from", //$NON-NLS-1$
            "type", //$NON-NLS-1$
            "where", //$NON-NLS-1$
            "as", //$NON-NLS-1$
            "withoutsubtypes", //$NON-NLS-1$
            "not", //$NON-NLS-1$
            "in", //$NON-NLS-1$
            "partitions", //$NON-NLS-1$
            "containers", //$NON-NLS-1$
            "elements", //$NON-NLS-1$
            "for", //$NON-NLS-1$
            "or", //$NON-NLS-1$
            "and", //$NON-NLS-1$
            "like", //$NON-NLS-1$
            "true", //$NON-NLS-1$
            "false", //$NON-NLS-1$
            "null", //$NON-NLS-1$
            "EOF_TOKEN", //$NON-NLS-1$
            "IDENTIFIER", //$NON-NLS-1$
            "ERROR_TOKEN", //$NON-NLS-1$
            "identifierN", //$NON-NLS-1$
            "identifier", //$NON-NLS-1$
            "sPathName", //$NON-NLS-1$
            "pathName", //$NON-NLS-1$
            "typePathName", //$NON-NLS-1$
            "selectClause", //$NON-NLS-1$
            "fromClause", //$NON-NLS-1$
            "selectEntryN", //$NON-NLS-1$
            "selectEntry", //$NON-NLS-1$
            "fromEntryN", //$NON-NLS-1$
            "fromEntry", //$NON-NLS-1$
            "typeClause", //$NON-NLS-1$
            "typePathNameN", //$NON-NLS-1$
            "scopeClause", //$NON-NLS-1$
            "whereClauseN", //$NON-NLS-1$
            "whereClause", //$NON-NLS-1$
            "whereEntry", //$NON-NLS-1$
            "localWhereCondition", //$NON-NLS-1$
            "negativeWhereCondition", //$NON-NLS-1$
            "operationPart", //$NON-NLS-1$
            "literal", //$NON-NLS-1$
            "navigationStep", //$NON-NLS-1$
            "joinPart", //$NON-NLS-1$
            "comparisonPostElementEquals", //$NON-NLS-1$
            "comparisonPostElementOtherOper" + //$NON-NLS-1$
            "ation" //$NON-NLS-1$
        };
    };
    public final static String name[] = Name.name;
    public final String name(int index) { return name[index]; }

    public final static int
           ERROR_SYMBOL      = 42,
           SCOPE_UBOUND      = 1,
           SCOPE_SIZE        = 2,
           MAX_NAME_LENGTH   = 35;

    public final int getErrorSymbol() { return ERROR_SYMBOL; }
    public final int getScopeUbound() { return SCOPE_UBOUND; }
    public final int getScopeSize() { return SCOPE_SIZE; }
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int
           NUM_STATES        = 88,
           NT_OFFSET         = 42,
           LA_STATE_OFFSET   = 409,
           MAX_LA            = 1,
           NUM_RULES         = 90,
           NUM_NONTERMINALS  = 42,
           NUM_SYMBOLS       = 84,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 114,
           IDENTIFIER_SYMBOL = 1,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 39,
           ACCEPT_ACTION     = 318,
           ERROR_ACTION      = 319;

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

    public final int originalState(int state) {
        return -baseCheck[state];
    }
    public final int asi(int state) {
        return asb[originalState(state)];
    }
    public final int nasi(int state) {
        return nasb[originalState(state)];
    }
    public final int inSymbol(int state) {
        return inSymb[originalState(state)];
    }

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
