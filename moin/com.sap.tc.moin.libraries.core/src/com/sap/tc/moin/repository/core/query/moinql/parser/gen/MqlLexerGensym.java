/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package com.sap.tc.moin.repository.core.query.moinql.parser.gen;

public interface MqlLexerGensym {
    public final static int
      Char_CtlCharNotWS = 4,
      Char_LF = 2,
      Char_CR = 3,
      Char_HT = 5,
      Char_FF = 6,
      Char_a = 24,
      Char_b = 22,
      Char_c = 25,
      Char_d = 26,
      Char_e = 17,
      Char_f = 23,
      Char_g = 65,
      Char_h = 66,
      Char_i = 67,
      Char_j = 68,
      Char_k = 69,
      Char_l = 70,
      Char_m = 71,
      Char_n = 61,
      Char_o = 72,
      Char_p = 73,
      Char_q = 74,
      Char_r = 62,
      Char_s = 75,
      Char_t = 63,
      Char_u = 64,
      Char_v = 76,
      Char_w = 77,
      Char_x = 78,
      Char_y = 79,
      Char_z = 80,
      Char__ = 81,
      Char_A = 27,
      Char_B = 28,
      Char_C = 29,
      Char_D = 30,
      Char_E = 18,
      Char_F = 31,
      Char_G = 82,
      Char_H = 83,
      Char_I = 84,
      Char_J = 85,
      Char_K = 86,
      Char_L = 87,
      Char_M = 88,
      Char_N = 89,
      Char_O = 90,
      Char_P = 91,
      Char_Q = 92,
      Char_R = 93,
      Char_S = 94,
      Char_T = 95,
      Char_U = 96,
      Char_V = 97,
      Char_W = 98,
      Char_X = 99,
      Char_Y = 100,
      Char_Z = 101,
      Char_0 = 7,
      Char_1 = 8,
      Char_2 = 9,
      Char_3 = 10,
      Char_4 = 11,
      Char_5 = 12,
      Char_6 = 13,
      Char_7 = 14,
      Char_8 = 15,
      Char_9 = 16,
      Char_AfterASCIINotAcute = 102,
      Char_Space = 21,
      Char_DoubleQuote = 37,
      Char_SingleQuote = 20,
      Char_Percent = 38,
      Char_VerticalBar = 52,
      Char_Exclamation = 39,
      Char_AtSign = 53,
      Char_BackQuote = 54,
      Char_Acute = 103,
      Char_Tilde = 55,
      Char_Sharp = 40,
      Char_DollarSign = 56,
      Char_Ampersand = 57,
      Char_Caret = 58,
      Char_Colon = 34,
      Char_SemiColon = 59,
      Char_BackSlash = 35,
      Char_LeftBrace = 41,
      Char_RightBrace = 42,
      Char_LeftBracket = 43,
      Char_RightBracket = 44,
      Char_QuestionMark = 60,
      Char_Comma = 45,
      Char_Dot = 19,
      Char_LessThan = 46,
      Char_GreaterThan = 36,
      Char_Plus = 47,
      Char_Minus = 32,
      Char_Slash = 48,
      Char_Star = 49,
      Char_LeftParen = 50,
      Char_RightParen = 51,
      Char_Equal = 33,
      Char_EOF = 1;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "EOF", //$NON-NLS-1$
                 "LF", //$NON-NLS-1$
                 "CR", //$NON-NLS-1$
                 "CtlCharNotWS", //$NON-NLS-1$
                 "HT", //$NON-NLS-1$
                 "FF", //$NON-NLS-1$
                 "0", //$NON-NLS-1$
                 "1", //$NON-NLS-1$
                 "2", //$NON-NLS-1$
                 "3", //$NON-NLS-1$
                 "4", //$NON-NLS-1$
                 "5", //$NON-NLS-1$
                 "6", //$NON-NLS-1$
                 "7", //$NON-NLS-1$
                 "8", //$NON-NLS-1$
                 "9", //$NON-NLS-1$
                 "e", //$NON-NLS-1$
                 "E", //$NON-NLS-1$
                 "Dot", //$NON-NLS-1$
                 "SingleQuote", //$NON-NLS-1$
                 "Space", //$NON-NLS-1$
                 "b", //$NON-NLS-1$
                 "f", //$NON-NLS-1$
                 "a", //$NON-NLS-1$
                 "c", //$NON-NLS-1$
                 "d", //$NON-NLS-1$
                 "A", //$NON-NLS-1$
                 "B", //$NON-NLS-1$
                 "C", //$NON-NLS-1$
                 "D", //$NON-NLS-1$
                 "F", //$NON-NLS-1$
                 "Minus", //$NON-NLS-1$
                 "Equal", //$NON-NLS-1$
                 "Colon", //$NON-NLS-1$
                 "BackSlash", //$NON-NLS-1$
                 "GreaterThan", //$NON-NLS-1$
                 "DoubleQuote", //$NON-NLS-1$
                 "Percent", //$NON-NLS-1$
                 "Exclamation", //$NON-NLS-1$
                 "Sharp", //$NON-NLS-1$
                 "LeftBrace", //$NON-NLS-1$
                 "RightBrace", //$NON-NLS-1$
                 "LeftBracket", //$NON-NLS-1$
                 "RightBracket", //$NON-NLS-1$
                 "Comma", //$NON-NLS-1$
                 "LessThan", //$NON-NLS-1$
                 "Plus", //$NON-NLS-1$
                 "Slash", //$NON-NLS-1$
                 "Star", //$NON-NLS-1$
                 "LeftParen", //$NON-NLS-1$
                 "RightParen", //$NON-NLS-1$
                 "VerticalBar", //$NON-NLS-1$
                 "AtSign", //$NON-NLS-1$
                 "BackQuote", //$NON-NLS-1$
                 "Tilde", //$NON-NLS-1$
                 "DollarSign", //$NON-NLS-1$
                 "Ampersand", //$NON-NLS-1$
                 "Caret", //$NON-NLS-1$
                 "SemiColon", //$NON-NLS-1$
                 "QuestionMark", //$NON-NLS-1$
                 "n", //$NON-NLS-1$
                 "r", //$NON-NLS-1$
                 "t", //$NON-NLS-1$
                 "u", //$NON-NLS-1$
                 "g", //$NON-NLS-1$
                 "h", //$NON-NLS-1$
                 "i", //$NON-NLS-1$
                 "j", //$NON-NLS-1$
                 "k", //$NON-NLS-1$
                 "l", //$NON-NLS-1$
                 "m", //$NON-NLS-1$
                 "o", //$NON-NLS-1$
                 "p", //$NON-NLS-1$
                 "q", //$NON-NLS-1$
                 "s", //$NON-NLS-1$
                 "v", //$NON-NLS-1$
                 "w", //$NON-NLS-1$
                 "x", //$NON-NLS-1$
                 "y", //$NON-NLS-1$
                 "z", //$NON-NLS-1$
                 "_", //$NON-NLS-1$
                 "G", //$NON-NLS-1$
                 "H", //$NON-NLS-1$
                 "I", //$NON-NLS-1$
                 "J", //$NON-NLS-1$
                 "K", //$NON-NLS-1$
                 "L", //$NON-NLS-1$
                 "M", //$NON-NLS-1$
                 "N", //$NON-NLS-1$
                 "O", //$NON-NLS-1$
                 "P", //$NON-NLS-1$
                 "Q", //$NON-NLS-1$
                 "R", //$NON-NLS-1$
                 "S", //$NON-NLS-1$
                 "T", //$NON-NLS-1$
                 "U", //$NON-NLS-1$
                 "V", //$NON-NLS-1$
                 "W", //$NON-NLS-1$
                 "X", //$NON-NLS-1$
                 "Y", //$NON-NLS-1$
                 "Z", //$NON-NLS-1$
                 "AfterASCIINotAcute", //$NON-NLS-1$
                 "Acute" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
