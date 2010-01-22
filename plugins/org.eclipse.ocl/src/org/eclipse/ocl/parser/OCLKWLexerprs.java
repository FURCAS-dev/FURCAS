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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396) 
*
* </copyright>
*
*
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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
* </copyright>
*/

package org.eclipse.ocl.parser;

public class OCLKWLexerprs implements lpg.runtime.ParseTable, OCLKWLexersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 159;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 56;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 247;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 42;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 2;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 58;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 43;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 36;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 57;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 204;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 205;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return OCLKWLexersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            2,1
        };
    };
    public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;
    public final int prosthesesIndex(int index) { return prosthesesIndex[index]; }

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,6,
            7,16,4,7,5,6,7,10,4,7,
            3,3,4,4,7,7,10,3,6,4,
            10,6
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
            1,1,1,1,45,66,72,67,70,37,
            75,81,78,85,17,86,47,18,87,94,
            42,92,88,96,48,52,25,57,55,98,
            100,104,105,106,109,111,13,110,117,112,
            121,118,122,126,59,127,128,130,133,137,
            139,140,138,141,142,63,144,150,151,152,
            157,145,156,161,166,167,170,162,10,171,
            175,178,179,174,181,182,65,186,189,191,
            194,195,198,201,193,202,207,205,210,203,
            212,213,215,216,217,219,225,229,227,233,
            235,237,231,238,239,242,246,243,249,250,
            251,253,254,257,255,258,266,265,260,268,
            267,274,278,271,282,283,286,287,288,290,
            292,293,295,297,303,291,304,305,306,310,
            309,315,317,318,320,321,322,325,326,328,
            330,332,338,333,340,344,345,347,350,352,
            348,354,359,205,205
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,0,
            10,11,0,13,2,15,0,0,1,19,
            3,21,22,23,0,9,10,27,28,5,
            21,31,32,33,34,26,0,13,29,0,
            4,0,18,7,35,9,0,0,7,2,
            4,0,5,7,0,14,0,1,0,3,
            9,3,0,9,0,0,0,13,6,0,
            6,0,1,7,0,24,7,0,16,15,
            0,1,5,25,0,0,0,0,14,5,
            4,0,7,0,1,0,9,0,7,0,
            5,36,5,0,0,0,1,8,0,0,
            0,0,3,10,4,11,0,0,2,8,
            0,0,2,15,7,0,0,0,2,0,
            3,2,0,12,9,3,0,0,0,0,
            0,0,1,0,0,9,8,8,11,0,
            0,0,2,4,14,0,0,6,15,3,
            0,0,1,3,20,0,0,2,2,0,
            0,1,17,0,0,6,2,0,0,2,
            0,0,0,2,6,0,1,14,0,1,
            0,11,0,0,0,5,3,0,4,2,
            0,0,0,3,0,13,0,1,4,0,
            1,0,0,1,0,0,0,16,0,5,
            18,5,7,12,0,1,0,9,0,1,
            0,5,0,1,0,1,0,0,0,2,
            4,0,0,13,6,0,1,6,0,0,
            0,1,0,0,0,6,0,0,1,0,
            12,19,6,11,0,0,0,0,4,16,
            0,12,5,0,20,10,10,0,1,6,
            10,0,0,1,3,0,0,0,3,0,
            0,0,0,4,0,9,0,3,11,8,
            8,5,0,0,0,0,1,17,0,0,
            2,8,10,4,0,11,0,0,1,0,
            0,0,6,4,0,0,1,0,8,0,
            6,0,0,12,7,0,22,0,1,0,
            8,12,3,0,0,1,0,0,5,0,
            4,0,3,0,0,0,9,4,0,0,
            2,30,0,0,0,14,0,0,0,0,
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
            205,64,59,65,63,60,66,62,46,205,
            47,67,205,58,106,49,205,205,84,61,
            83,53,57,48,205,79,78,56,55,95,
            132,54,51,50,52,134,205,207,131,205,
            71,205,96,72,133,73,205,205,88,92,
            82,205,91,81,205,87,205,98,205,97,
            93,220,12,99,205,205,205,243,120,205,
            142,205,68,69,205,94,70,205,121,141,
            205,75,76,113,205,205,205,205,74,77,
            85,205,80,205,86,205,212,205,89,205,
            90,204,100,205,205,205,237,101,205,205,
            205,205,107,102,105,103,205,205,108,109,
            205,205,110,104,111,205,205,205,114,205,
            216,115,205,221,112,214,205,205,205,205,
            205,205,119,205,205,213,211,116,117,205,
            205,205,124,123,118,205,205,125,122,126,
            205,205,130,238,239,205,205,128,228,205,
            205,135,127,205,205,129,136,205,205,137,
            205,205,205,234,138,205,209,139,205,218,
            205,140,205,205,31,208,245,205,143,144,
            205,205,205,145,205,206,205,147,148,205,
            230,205,205,151,205,205,205,146,205,152,
            149,154,153,150,205,156,205,155,205,157,
            205,158,205,159,205,219,205,205,205,161,
            160,205,205,210,162,205,244,163,205,205,
            205,167,205,205,205,166,205,205,171,205,
            165,164,170,168,205,205,205,205,173,169,
            205,225,174,205,231,172,175,205,177,176,
            247,205,205,241,240,205,205,205,178,205,
            205,205,205,180,205,226,205,182,179,232,
            181,229,205,205,205,205,185,184,205,205,
            187,235,183,186,205,215,205,205,222,205,
            205,205,189,190,205,205,194,205,191,205,
            193,205,205,192,195,205,188,205,246,205,
            233,196,224,205,205,242,205,205,223,205,
            198,205,199,205,205,205,201,202,205,205,
            227,197,205,205,205,200
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
    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    /**
     * assert(! goto_default);
     */
    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    /**
     * assert(! shift_default);
     */
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
