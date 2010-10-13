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
            5,2,15,9,8,3,4
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,20,
            14,27,24,37,8,12,23,39,40,26,
            13,43,30,45,50,47,53,55,56,59,
            57,60,63,34,61,66,68,70,72,73,
            76,77,80,81,87,91,93,95,97,99,
            100,102,98,106,107,108,112,113,111,119,
            118,124,126,127,130,131,132,133,121,138,
            140,83,83
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,0,8,9,
            10,0,0,0,3,3,9,6,18,12,
            20,10,0,0,2,0,0,15,5,0,
            8,6,7,0,21,9,0,1,0,0,
            7,3,0,1,0,1,0,8,19,0,
            4,2,0,1,0,0,0,3,0,0,
            0,6,0,5,5,0,4,0,1,0,
            5,0,0,17,14,0,0,6,3,0,
            0,2,13,0,12,5,0,1,0,13,
            0,1,0,1,0,1,0,0,0,0,
            1,0,1,7,6,0,0,0,11,3,
            0,0,0,8,7,4,4,0,0,2,
            0,11,4,0,1,0,0,2,2,0,
            0,0,0,0,14,4,7,0,1,0,
            0,2,0,0,0,0,16,15,0,0,
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
        public final static byte termAction[] = {0,
            83,22,31,23,30,21,27,83,29,28,
            26,83,83,83,38,43,35,37,25,36,
            24,39,83,83,95,83,83,44,33,83,
            40,42,41,83,82,32,83,34,83,83,
            54,88,83,45,83,47,83,87,46,83,
            49,48,83,50,83,83,83,99,83,83,
            83,51,83,52,53,83,86,83,100,83,
            56,83,83,89,55,83,83,58,60,83,
            83,61,57,83,59,90,83,91,83,93,
            83,85,83,62,83,63,83,83,83,83,
            94,83,92,64,65,83,83,83,66,68,
            83,83,83,67,69,84,70,83,83,98,
            83,71,72,83,73,83,83,74,97,83,
            83,83,83,83,79,77,75,83,80,83,
            83,96,83,83,83,83,76,78
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
           NUM_STATES        = 62,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 100,
           MAX_LA            = 0,
           NUM_RULES         = 17,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 56,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 18,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 21,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 82,
           ERROR_ACTION      = 83;

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
