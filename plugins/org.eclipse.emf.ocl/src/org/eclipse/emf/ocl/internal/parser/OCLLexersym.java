/**
* <copyright>
*
* Copyright (c) 2005, 2006 IBM Corporation and others.
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
* $Id: OCLLexersym.java,v 1.1 2006/04/04 18:09:05 cdamus Exp $
*/

package org.eclipse.emf.ocl.internal.parser;

public interface OCLLexersym {
    public final static int
      Char_CtlCharNotWS = 101,
      Char_LF = 99,
      Char_CR = 100,
      Char_HT = 96,
      Char_FF = 97,
      Char_a = 19,
      Char_b = 14,
      Char_c = 20,
      Char_d = 21,
      Char_e = 11,
      Char_f = 15,
      Char_g = 22,
      Char_h = 23,
      Char_i = 24,
      Char_j = 25,
      Char_k = 26,
      Char_l = 27,
      Char_m = 28,
      Char_n = 16,
      Char_o = 29,
      Char_p = 17,
      Char_q = 30,
      Char_r = 12,
      Char_s = 31,
      Char_t = 18,
      Char_u = 32,
      Char_v = 33,
      Char_w = 34,
      Char_x = 35,
      Char_y = 36,
      Char_z = 37,
      Char__ = 38,
      Char_A = 39,
      Char_B = 40,
      Char_C = 41,
      Char_D = 42,
      Char_E = 13,
      Char_F = 43,
      Char_G = 44,
      Char_H = 45,
      Char_I = 46,
      Char_J = 47,
      Char_K = 48,
      Char_L = 49,
      Char_M = 50,
      Char_N = 51,
      Char_O = 52,
      Char_P = 53,
      Char_Q = 54,
      Char_R = 55,
      Char_S = 56,
      Char_T = 57,
      Char_U = 58,
      Char_V = 59,
      Char_W = 60,
      Char_X = 61,
      Char_Y = 62,
      Char_Z = 63,
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
      Char_AfterASCII = 64,
      Char_Space = 69,
      Char_DoubleQuote = 70,
      Char_SingleQuote = 71,
      Char_Percent = 90,
      Char_VerticalBar = 76,
      Char_Exclamation = 91,
      Char_AtSign = 77,
      Char_BackQuote = 92,
      Char_Tilde = 93,
      Char_Sharp = 94,
      Char_DollarSign = 102,
      Char_Ampersand = 95,
      Char_Caret = 72,
      Char_Colon = 73,
      Char_SemiColon = 78,
      Char_BackSlash = 79,
      Char_LeftBrace = 80,
      Char_RightBrace = 81,
      Char_LeftBracket = 82,
      Char_RightBracket = 83,
      Char_QuestionMark = 84,
      Char_Comma = 85,
      Char_Dot = 65,
      Char_LessThan = 86,
      Char_GreaterThan = 66,
      Char_Plus = 74,
      Char_Minus = 67,
      Char_Slash = 87,
      Char_Star = 75,
      Char_LeftParen = 88,
      Char_RightParen = 89,
      Char_Equal = 68,
      Char_EOF = 98;

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
                 "AfterASCII", //$NON-NLS-1$
                 "Dot", //$NON-NLS-1$
                 "GreaterThan", //$NON-NLS-1$
                 "Minus", //$NON-NLS-1$
                 "Equal", //$NON-NLS-1$
                 "Space", //$NON-NLS-1$
                 "DoubleQuote", //$NON-NLS-1$
                 "SingleQuote", //$NON-NLS-1$
                 "Caret", //$NON-NLS-1$
                 "Colon", //$NON-NLS-1$
                 "Plus", //$NON-NLS-1$
                 "Star", //$NON-NLS-1$
                 "VerticalBar", //$NON-NLS-1$
                 "AtSign", //$NON-NLS-1$
                 "SemiColon", //$NON-NLS-1$
                 "BackSlash", //$NON-NLS-1$
                 "LeftBrace", //$NON-NLS-1$
                 "RightBrace", //$NON-NLS-1$
                 "LeftBracket", //$NON-NLS-1$
                 "RightBracket", //$NON-NLS-1$
                 "QuestionMark", //$NON-NLS-1$
                 "Comma", //$NON-NLS-1$
                 "LessThan", //$NON-NLS-1$
                 "Slash", //$NON-NLS-1$
                 "LeftParen", //$NON-NLS-1$
                 "RightParen", //$NON-NLS-1$
                 "Percent", //$NON-NLS-1$
                 "Exclamation", //$NON-NLS-1$
                 "BackQuote", //$NON-NLS-1$
                 "Tilde", //$NON-NLS-1$
                 "Sharp", //$NON-NLS-1$
                 "Ampersand", //$NON-NLS-1$
                 "HT", //$NON-NLS-1$
                 "FF", //$NON-NLS-1$
                 "EOF", //$NON-NLS-1$
                 "LF", //$NON-NLS-1$
                 "CR", //$NON-NLS-1$
                 "CtlCharNotWS", //$NON-NLS-1$
                 "DollarSign" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
