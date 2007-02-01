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
*
* </copyright>
*
* $Id: OCLLexersym.java,v 1.2 2007/02/01 16:14:56 cdamus Exp $
*/

package org.eclipse.ocl.internal.parser;

public interface OCLLexersym {
    public final static int
      Char_CtlCharNotWS = 102,
      Char_LF = 100,
      Char_CR = 101,
      Char_HT = 96,
      Char_FF = 97,
      Char_a = 20,
      Char_b = 14,
      Char_c = 21,
      Char_d = 22,
      Char_e = 11,
      Char_f = 15,
      Char_g = 23,
      Char_h = 24,
      Char_i = 25,
      Char_j = 26,
      Char_k = 27,
      Char_l = 28,
      Char_m = 29,
      Char_n = 16,
      Char_o = 30,
      Char_p = 17,
      Char_q = 31,
      Char_r = 12,
      Char_s = 32,
      Char_t = 18,
      Char_u = 33,
      Char_v = 34,
      Char_w = 35,
      Char_x = 36,
      Char_y = 37,
      Char_z = 38,
      Char__ = 39,
      Char_A = 40,
      Char_B = 41,
      Char_C = 42,
      Char_D = 43,
      Char_E = 13,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 47,
      Char_J = 48,
      Char_K = 49,
      Char_L = 50,
      Char_M = 51,
      Char_N = 52,
      Char_O = 53,
      Char_P = 54,
      Char_Q = 55,
      Char_R = 56,
      Char_S = 57,
      Char_T = 58,
      Char_U = 59,
      Char_V = 60,
      Char_W = 61,
      Char_X = 62,
      Char_Y = 63,
      Char_Z = 64,
      Char_0 = 1,
      Char_1 = 2,
      Char_2 = 3,
      Char_3 = 4,
      Char_4 = 5,
      Char_5 = 6,
      Char_6 = 7,
      Char_7 = 8,
      Char_8 = 9,
      Char_9 = 10,
      Char_AfterASCIINotAcute = 65,
      Char_Space = 71,
      Char_DoubleQuote = 72,
      Char_SingleQuote = 73,
      Char_Percent = 91,
      Char_VerticalBar = 78,
      Char_Exclamation = 92,
      Char_AtSign = 79,
      Char_BackQuote = 80,
      Char_Acute = 98,
      Char_Tilde = 93,
      Char_Sharp = 94,
      Char_DollarSign = 103,
      Char_Ampersand = 95,
      Char_Caret = 74,
      Char_Colon = 75,
      Char_SemiColon = 81,
      Char_BackSlash = 82,
      Char_LeftBrace = 83,
      Char_RightBrace = 84,
      Char_LeftBracket = 85,
      Char_RightBracket = 86,
      Char_QuestionMark = 87,
      Char_Comma = 88,
      Char_Dot = 66,
      Char_LessThan = 76,
      Char_GreaterThan = 67,
      Char_Plus = 69,
      Char_Minus = 68,
      Char_Slash = 77,
      Char_Star = 70,
      Char_LeftParen = 89,
      Char_RightParen = 90,
      Char_Equal = 19,
      Char_EOF = 99;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
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
                 "r", //$NON-NLS-1$
                 "E", //$NON-NLS-1$
                 "b", //$NON-NLS-1$
                 "f", //$NON-NLS-1$
                 "n", //$NON-NLS-1$
                 "p", //$NON-NLS-1$
                 "t", //$NON-NLS-1$
                 "Equal", //$NON-NLS-1$
                 "a", //$NON-NLS-1$
                 "c", //$NON-NLS-1$
                 "d", //$NON-NLS-1$
                 "g", //$NON-NLS-1$
                 "h", //$NON-NLS-1$
                 "i", //$NON-NLS-1$
                 "j", //$NON-NLS-1$
                 "k", //$NON-NLS-1$
                 "l", //$NON-NLS-1$
                 "m", //$NON-NLS-1$
                 "o", //$NON-NLS-1$
                 "q", //$NON-NLS-1$
                 "s", //$NON-NLS-1$
                 "u", //$NON-NLS-1$
                 "v", //$NON-NLS-1$
                 "w", //$NON-NLS-1$
                 "x", //$NON-NLS-1$
                 "y", //$NON-NLS-1$
                 "z", //$NON-NLS-1$
                 "_", //$NON-NLS-1$
                 "A", //$NON-NLS-1$
                 "B", //$NON-NLS-1$
                 "C", //$NON-NLS-1$
                 "D", //$NON-NLS-1$
                 "F", //$NON-NLS-1$
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
                 "Dot", //$NON-NLS-1$
                 "GreaterThan", //$NON-NLS-1$
                 "Minus", //$NON-NLS-1$
                 "Plus", //$NON-NLS-1$
                 "Star", //$NON-NLS-1$
                 "Space", //$NON-NLS-1$
                 "DoubleQuote", //$NON-NLS-1$
                 "SingleQuote", //$NON-NLS-1$
                 "Caret", //$NON-NLS-1$
                 "Colon", //$NON-NLS-1$
                 "LessThan", //$NON-NLS-1$
                 "Slash", //$NON-NLS-1$
                 "VerticalBar", //$NON-NLS-1$
                 "AtSign", //$NON-NLS-1$
                 "BackQuote", //$NON-NLS-1$
                 "SemiColon", //$NON-NLS-1$
                 "BackSlash", //$NON-NLS-1$
                 "LeftBrace", //$NON-NLS-1$
                 "RightBrace", //$NON-NLS-1$
                 "LeftBracket", //$NON-NLS-1$
                 "RightBracket", //$NON-NLS-1$
                 "QuestionMark", //$NON-NLS-1$
                 "Comma", //$NON-NLS-1$
                 "LeftParen", //$NON-NLS-1$
                 "RightParen", //$NON-NLS-1$
                 "Percent", //$NON-NLS-1$
                 "Exclamation", //$NON-NLS-1$
                 "Tilde", //$NON-NLS-1$
                 "Sharp", //$NON-NLS-1$
                 "Ampersand", //$NON-NLS-1$
                 "HT", //$NON-NLS-1$
                 "FF", //$NON-NLS-1$
                 "Acute", //$NON-NLS-1$
                 "EOF", //$NON-NLS-1$
                 "LF", //$NON-NLS-1$
                 "CR", //$NON-NLS-1$
                 "CtlCharNotWS", //$NON-NLS-1$
                 "DollarSign" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
