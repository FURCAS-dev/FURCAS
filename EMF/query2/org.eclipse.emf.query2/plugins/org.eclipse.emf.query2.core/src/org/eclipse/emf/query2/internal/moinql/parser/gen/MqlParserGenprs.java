/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package org.eclipse.emf.query2.internal.moinql.parser.gen;

public class MqlParserGenprs implements lpg.lpgjavaruntime.ParseTable, MqlParserGensym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            0,1,1,3,1,1,1,1,1,3,
            0,2,3,1,1,3,2,3,1,4,
            1,2,0,2,0,3,0,1,1,3,
            0,1,1,3,1,0,1,1,3,1,
            0,3,4,4,0,1,1,2,2,1,
            1,5,1,3,3,2,1,2,3,2,
            2,2,2,2,2,2,3,1,1,1,
            1,1,1,4,3,1,1,5,2,2,
            2,2,2,2,2,3,1,2,1,3,
            0,2,0,1,-6,-9,0,0,-18,-27,
            0,0,-2,0,0,0,0,0,0,0,
            0,0,0,-41,0,-4,0,0,0,-5,
            -19,0,-14,0,0,0,0,0,0,-26,
            -7,0,0,-15,0,0,-34,0,0,0,
            0,-3,0,0,-35,0,0,0,0,-8,
            0,-36,0,0,-37,0,0,0,-22,0,
            0,-38,0,0,0,0,0,0,-39,0,
            0,-43,0,-50,0,0,0,0,0,-51,
            0,-1,-67,0,0,0,-68,-10,0,0,
            -17,0,-25,0,-24,-12,-42,0,0,-44,
            -20,0,0,0,0,-63,0,0,0,0,
            0,0,0,0,0,0,-74,0,-75,0,
            -45,0,-21,0,-33,-47,0,0,-49,-54,
            0,0,0,-64,0,0,0,-55,-56,0,
            0,-57,-58,0,0,-59,-60,0,0,-11,
            0,-65,0,-66,-13,0,-16,-23,-28,-29,
            -30,-31,-32,-40,-46,-48,-52,0,-53,-61,
            -62,-69,-70,-71,-72,-73,0
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            7,41,41,42,42,1,43,44,45,46,
            7,7,8,9,9,10,10,23,11,11,
            12,13,14,26,26,27,27,47,47,15,
            15,28,28,16,16,3,29,29,17,17,
            18,25,25,30,30,24,24,20,20,21,
            31,31,32,22,22,22,4,4,5,5,
            34,34,34,34,34,34,34,34,2,2,
            2,2,2,2,33,33,35,36,36,37,
            37,37,37,37,37,37,37,38,38,6,
            6,39,39,19,19,62,27,257,196,62,
            8,197,196,2,53,57,17,250,255,21,
            18,250,255,21,8,197,59,150,53,57,
            60,81,264,59,150,12,131,49,50,51,
            1,70,13,131,59,16,267,26,266,89,
            46,188,46,84,10,26,266,89,24,262,
            72,83,26,266,89,26,266,89,82,59,
            76,81,26,266,89,120,74,77,80,26,
            229,87,8,197,8,197,56,57,55,57,
            8,197,35,105,54,57,274,107,67,103,
            142,59,258,45,130,62,73,6,260,32,
            62,59,193,260,37,276,35,79,48,188,
            259,273,261,272,142,30,275,62,20,117,
            274,33,22,59,75,29,29,85,86,99,
            29,58,66,34,59,90,39,276,29,29,
            65,64,29,29,63,62,29,29,61,60,
            76,42,59,92,29,78,67,28,79,82,
            83,3,85,89,36,91,95,47,88,102,
            94,100,110,111,112,114,115,279,279
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,0,0,3,4,0,6,0,3,4,
            3,6,5,11,7,15,16,17,18,19,
            15,16,17,18,19,0,0,0,0,2,
            5,5,0,6,0,0,35,12,13,14,
            12,13,14,8,0,0,0,3,23,24,
            25,23,24,25,8,11,21,22,0,0,
            34,0,28,5,32,33,0,21,22,0,
            1,0,0,2,29,0,1,0,0,20,
            0,0,0,1,0,7,20,26,0,9,
            0,10,4,0,0,11,2,7,0,0,
            2,0,9,31,0,4,0,30,9,0,
            0,0,1,0,0,1,0,8,0,0,
            10,0,0,10,0,0,0,0,0,0,
            26,0,0,27,0,0,0,0,0,0,
            0,0,0,27,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            93,279,279,263,225,279,169,279,269,230,
            172,239,284,221,114,155,162,145,152,137,
            246,247,242,243,238,279,279,279,279,159,
            284,284,279,223,11,279,278,349,347,348,
            349,347,348,331,41,279,279,373,350,351,
            352,350,351,352,338,93,174,180,279,45,
            191,279,116,284,271,270,47,174,180,14,
            123,15,23,134,95,19,99,279,279,96,
            25,279,29,200,279,100,96,314,94,195,
            279,305,226,279,279,265,234,206,91,279,
            252,279,183,121,31,254,36,201,187,279,
            279,33,217,279,38,219,279,357,279,279,
            323,279,279,322,279,279,279,279,279,279,
            314,279,279,319,279,279,279,279,279,279,
            279,279,279,319
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static byte asb[] = {0,
            35,36,33,4,47,1,32,31,3,47,
            46,51,52,4,4,65,4,1,10,4,
            4,4,8,1,44,13,6,39,68,72,
            72,71,24,23,23,23,23,23,23,74,
            6,14,6,1,57,8,24,63,60,6,
            6,74,21,24,24,24,24,24,24,24,
            11,11,54,4,4,24,38,41,49,39,
            68,39,68,1,42
        };
    };
    public final static byte asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static byte asr[] = {0,
            26,0,34,5,0,3,5,7,0,30,
            9,0,11,16,15,18,17,6,19,3,
            4,0,5,13,14,12,23,24,25,0,
            2,1,29,0,28,35,0,26,10,0,
            10,27,0,11,3,1,35,20,8,0,
            31,30,0,8,28,0,32,33,0,8,
            20,35,2,0,2,6,0,10,1,0,
            4,11,0,8,22,21,0
        };
    };
    public final static byte asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            27,26,20,25,10,1,26,26,4,10,
            26,35,26,25,25,26,25,1,12,25,
            25,22,26,2,32,14,7,26,26,26,
            26,26,41,17,17,17,17,17,25,26,
            7,37,24,2,39,26,41,26,43,24,
            24,26,26,41,41,41,41,41,41,41,
            26,26,27,25,25,41,2,30,26,26,
            26,26,26,2,30
        };
    };
    public final static byte nasb[] = Nasb.nasb;
    public final int nasb(int index) { return nasb[index]; }

    public interface Nasr {
        public final static byte nasr[] = {0,
            12,3,0,1,31,0,1,22,0,21,
            0,27,0,19,36,0,1,6,0,23,
            0,35,0,4,1,0,8,7,0,18,
            0,19,25,0,26,0,34,0,30,0,
            2,0,39,0
        };
    };
    public final static byte nasr[] = Nasr.nasr;
    public final int nasr(int index) { return nasr[index]; }

    public interface TerminalIndex {
        public final static byte terminalIndex[] = {0,
            13,16,29,36,43,3,7,8,9,10,
            30,20,21,22,1,2,4,5,6,26,
            34,35,37,38,39,41,42,23,24,27,
            28,31,32,33,40,11,12,14,15,17,
            18,25,44
        };
    };
    public final static byte terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static byte nonterminalIndex[] = {0,
            45,65,53,63,0,69,0,46,48,49,
            50,51,52,0,54,55,56,57,0,59,
            60,62,47,0,0,0,0,0,0,58,
            61,0,0,64,66,67,0,68,0,0,
            0,0,0,0,0,0,0
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
            36,5
        };
    };
    public final static byte scopeLhs[] = ScopeLhs.scopeLhs;
    public final int scopeLhs(int index) { return scopeLhs[index]; }

    public interface ScopeLa {
        public final static byte scopeLa[] = {
            8,8
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
            50,7,11,62,0,8,0,65,7,0
        };
    };
    public final static byte scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static char scopeState[] = {0,
            180,174,172,114,100,0,130,0
        };
    };
    public final static char scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static byte inSymb[] = {0,
            0,50,51,28,66,29,53,44,20,64,
            55,46,56,1,2,44,34,1,31,30,
            6,2,44,9,44,78,7,58,46,62,
            62,3,4,19,17,18,15,16,6,65,
            7,44,3,1,11,11,4,44,44,21,
            22,65,3,4,19,6,17,18,15,16,
            33,32,7,2,2,4,9,9,50,71,
            46,72,61,1,1
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
            "resources", //$NON-NLS-1$
            "elements", //$NON-NLS-1$
            "for", //$NON-NLS-1$
            "or", //$NON-NLS-1$
            "and", //$NON-NLS-1$
            "like", //$NON-NLS-1$
            "true", //$NON-NLS-1$
            "false", //$NON-NLS-1$
            "null", //$NON-NLS-1$
            "EOF_TOKEN", //$NON-NLS-1$
            "FRAGMENTADDRESS", //$NON-NLS-1$
            "URI", //$NON-NLS-1$
            "IDENTIFIER", //$NON-NLS-1$
            "ERROR_TOKEN", //$NON-NLS-1$
            "identifier", //$NON-NLS-1$
            "selectClause", //$NON-NLS-1$
            "fromClause", //$NON-NLS-1$
            "selectEntryN", //$NON-NLS-1$
            "selectEntry", //$NON-NLS-1$
            "fromEntryN", //$NON-NLS-1$
            "fromEntry", //$NON-NLS-1$
            "typeClause", //$NON-NLS-1$
            "fragmentaddress", //$NON-NLS-1$
            "typePathNameN", //$NON-NLS-1$
            "elementPathNameN", //$NON-NLS-1$
            "uriN", //$NON-NLS-1$
            "uri", //$NON-NLS-1$
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
           ERROR_SYMBOL      = 43,
           SCOPE_UBOUND      = 1,
           SCOPE_SIZE        = 2,
           MAX_NAME_LENGTH   = 35;

    public final int getErrorSymbol() { return ERROR_SYMBOL; }
    public final int getScopeUbound() { return SCOPE_UBOUND; }
    public final int getScopeSize() { return SCOPE_SIZE; }
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int
           NUM_STATES        = 75,
           NT_OFFSET         = 43,
           LA_STATE_OFFSET   = 373,
           MAX_LA            = 1,
           NUM_RULES         = 94,
           NUM_NONTERMINALS  = 47,
           NUM_SYMBOLS       = 90,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 182,
           IDENTIFIER_SYMBOL = 5,
           EOFT_SYMBOL       = 35,
           EOLT_SYMBOL       = 35,
           ACCEPT_ACTION     = 278,
           ERROR_ACTION      = 279;

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
