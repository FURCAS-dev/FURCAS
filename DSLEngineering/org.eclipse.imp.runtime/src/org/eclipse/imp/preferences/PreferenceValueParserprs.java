
////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2007 IBM Corporation.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
//Author: Robert Fuhrer (rfuhrer@watson.ibm.com)
////////////////////////////////////////////////////////////////////////////////

package org.eclipse.imp.preferences;

public class PreferenceValueParserprs implements lpg.runtime.ParseTable, PreferenceValueParsersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 12;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 102;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 663;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 180;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 44;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 146;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 181;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 96;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 103;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 482;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 483;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return PreferenceValueParsersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,1,0,0,0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,3,36,38,
            39,31,32,33,34,35,37,2,40,41,
            42,43,44,1
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
            0,0,0,0,0,0,0,0,0,0,
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
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,2,1,1,2,1,2,1,1,2,
            2,2,2,5,0,2,1,1,2,2,
            1,1,1,2,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            38,28,28,28,28,28,28,28,28,28,
            28,1,1,2,2,3,3,4,4,5,
            5,6,6,7,7,8,8,9,9,10,
            10,11,11,12,12,13,13,14,14,15,
            15,16,16,17,17,18,18,19,19,20,
            20,21,21,22,22,23,23,24,24,25,
            25,26,26,27,27,27,27,27,27,27,
            27,27,27,27,27,27,27,27,27,27,
            27,27,27,27,27,27,27,27,27,38,
            38,32,32,34,33,33,36,36,35,35,
            35,35,35,35,29,40,40,39,41,41,
            41,37,37,37,30,42,42,42,31,31,
            31,31,31,31,31,31,31,31,31,31,
            31,31,31,31,31,31,31,31,31,31,
            31,31,31,31,31,31,31,31,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,97,63,64,65,66,67,68,69,70,
            71,72,73,74,75,76,77,78,79,80,
            81,82,83,84,85,86,87,88,111,112,
            96,99,113,89,90,444,341,259,98,295,
            97,63,64,65,66,67,68,69,70,71,
            72,73,74,75,76,77,78,79,80,81,
            82,83,84,85,86,87,88,111,112,96,
            99,113,89,90,444,341,259,98,106,192,
            63,64,65,66,67,68,69,70,71,72,
            73,74,75,76,77,78,79,80,81,82,
            83,84,85,86,87,88,111,112,97,99,
            113,95,501,444,341,498,98,1,63,64,
            65,66,67,68,69,70,71,72,73,74,
            75,76,77,78,79,80,81,82,83,84,
            85,86,87,88,115,116,499,502,483,483,
            483,483,327,483,483,483,483,483,483,114,
            117,287,63,64,65,66,67,68,69,70,
            71,72,73,74,75,76,77,78,79,80,
            81,82,83,84,85,86,87,88,101,102,
            483,100,103,445,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            108,483,483,483,483,483,483,483,483,483,
            483,483,292,483,415,382,63,64,65,66,
            67,68,69,70,71,72,73,74,75,76,
            77,78,79,80,81,82,83,84,85,86,
            87,88,109,110,500,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,96,483,483,483,92,483,483,
            259,483,483
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,0,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,64,63,0,0,0,0,0,0,
            0,0,0,0,75,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,96,0,0,95,0,0,0,
            0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            483,494,496,498,500,502,504,506,508,510,
            512,514,516,518,520,522,524,526,528,530,
            532,534,536,538,540,542,544,495,497,499,
            501,503,505,507,509,511,513,515,517,519,
            521,523,525,527,529,531,533,535,537,539,
            541,543,545,484,485,486,487,488,489,490,
            491,492,493,645,650,662,635,647,642,649,
            636,637,638,639,660,663,643,644,646,648,
            653,654,655,656,640,657,658,631,632,641,
            661,633,634,659,651,652,483,494,496,498,
            500,502,504,506,508,510,512,514,516,518,
            520,522,524,526,528,530,532,534,536,538,
            540,542,544,495,497,499,501,503,505,507,
            509,511,513,515,517,519,521,523,525,527,
            529,531,533,535,537,539,541,543,545,484,
            485,486,487,488,489,490,491,492,493,615,
            619,630,605,617,612,618,606,607,608,609,
            628,326,613,614,616,297,621,622,623,624,
            610,625,626,601,602,611,629,603,604,627,
            620,94,494,496,498,500,502,504,506,508,
            510,512,514,516,518,520,522,524,526,528,
            530,532,534,536,538,540,542,544,495,497,
            499,501,503,505,507,509,511,513,515,517,
            519,521,523,525,527,529,531,533,535,537,
            539,541,543,545,484,485,486,487,488,489,
            490,491,492,493,615,619,630,605,617,612,
            618,606,607,608,609,628,326,613,614,616,
            297,621,622,623,624,610,625,626,601,602,
            611,629,603,604,627,620,93,494,496,498,
            500,502,504,506,508,510,512,514,516,518,
            520,522,524,526,528,530,532,534,536,538,
            540,542,544,495,497,499,501,503,505,507,
            509,511,513,515,517,519,521,523,525,527,
            529,531,533,535,537,539,541,543,545,484,
            485,486,487,488,489,490,491,492,493,615,
            619,630,605,617,612,618,606,607,608,609,
            628,483,613,614,616,297,621,622,623,624,
            610,625,626,601,602,611,629,603,604,627,
            620,107,494,496,498,500,502,504,506,508,
            510,512,514,516,518,520,522,524,526,528,
            530,532,534,536,538,540,542,544,495,497,
            499,501,503,505,507,509,511,513,515,517,
            519,521,523,525,527,529,531,533,535,537,
            539,541,543,545,484,485,486,487,488,489,
            490,491,492,493,483,494,496,498,500,502,
            504,506,508,510,512,514,516,518,520,522,
            524,526,528,530,532,534,536,538,540,542,
            544,495,497,499,501,503,505,507,509,511,
            513,515,517,519,521,523,525,527,529,531,
            533,535,537,539,541,543,545,483,483,91,
            105,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,373,220,483,483,483,483,483,483,
            483,483,483,483,326,483,483,483,483,483,
            483,483,483,483,483,483,483,483,483,483,
            483,483,483,482,483,483,587
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
