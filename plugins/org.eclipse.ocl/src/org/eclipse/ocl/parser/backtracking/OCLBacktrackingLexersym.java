/**
* Essential OCL Lexer
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
*   Borland - Bug 242880
*   E.D.Willink - Bug 292112
* </copyright>
*
* $Id: OCLBacktrackingLexersym.java,v 1.9 2009/10/23 21:26:18 ewillink Exp $
*/
/**
* Complete OCL Lexer
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
*   E.D.Willink - Bug 292112, 292594
* </copyright>
*/

package org.eclipse.ocl.parser.backtracking;

/**
 * The backtracking variant of the OCL lexer symbol table.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * 
 * @since 1.3
 */
@SuppressWarnings("nls")
public interface OCLBacktrackingLexersym {
    public final static int
      Char_CtlCharNotWS = 103,
      Char_LF = 100,
      Char_CR = 101,
      Char_HT = 97,
      Char_FF = 98,
      Char_a = 18,
      Char_b = 19,
      Char_c = 20,
      Char_d = 21,
      Char_e = 11,
      Char_f = 22,
      Char_g = 23,
      Char_h = 24,
      Char_i = 25,
      Char_j = 26,
      Char_k = 27,
      Char_l = 28,
      Char_m = 29,
      Char_n = 30,
      Char_o = 31,
      Char_p = 32,
      Char_q = 33,
      Char_r = 34,
      Char_s = 35,
      Char_t = 36,
      Char_u = 37,
      Char_v = 38,
      Char_w = 39,
      Char_x = 40,
      Char_y = 41,
      Char_z = 42,
      Char__ = 43,
      Char_A = 44,
      Char_B = 45,
      Char_C = 46,
      Char_D = 47,
      Char_E = 12,
      Char_F = 48,
      Char_G = 49,
      Char_H = 50,
      Char_I = 51,
      Char_J = 52,
      Char_K = 53,
      Char_L = 54,
      Char_M = 55,
      Char_N = 56,
      Char_O = 57,
      Char_P = 58,
      Char_Q = 59,
      Char_R = 60,
      Char_S = 61,
      Char_T = 62,
      Char_U = 63,
      Char_V = 64,
      Char_W = 65,
      Char_X = 66,
      Char_Y = 67,
      Char_Z = 68,
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
      Char_AfterASCIINotAcute = 69,
      Char_Space = 70,
      Char_DoubleQuote = 75,
      Char_SingleQuote = 13,
      Char_Percent = 91,
      Char_VerticalBar = 76,
      Char_Exclamation = 92,
      Char_AtSign = 77,
      Char_BackQuote = 78,
      Char_Acute = 102,
      Char_Tilde = 93,
      Char_Sharp = 94,
      Char_DollarSign = 79,
      Char_Ampersand = 95,
      Char_Caret = 71,
      Char_Colon = 72,
      Char_SemiColon = 80,
      Char_BackSlash = 96,
      Char_LeftBrace = 81,
      Char_RightBrace = 82,
      Char_LeftBracket = 83,
      Char_RightBracket = 84,
      Char_QuestionMark = 85,
      Char_Comma = 86,
      Char_Dot = 14,
      Char_LessThan = 87,
      Char_GreaterThan = 15,
      Char_Plus = 73,
      Char_Minus = 16,
      Char_Slash = 88,
      Char_Star = 74,
      Char_LeftParen = 89,
      Char_RightParen = 90,
      Char_Equal = 17,
      Char_EOF = 99;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "0",
                 "1",
                 "2",
                 "3",
                 "4",
                 "5",
                 "6",
                 "7",
                 "8",
                 "9",
                 "e",
                 "E",
                 "SingleQuote",
                 "Dot",
                 "GreaterThan",
                 "Minus",
                 "Equal",
                 "a",
                 "b",
                 "c",
                 "d",
                 "f",
                 "g",
                 "h",
                 "i",
                 "j",
                 "k",
                 "l",
                 "m",
                 "n",
                 "o",
                 "p",
                 "q",
                 "r",
                 "s",
                 "t",
                 "u",
                 "v",
                 "w",
                 "x",
                 "y",
                 "z",
                 "_",
                 "A",
                 "B",
                 "C",
                 "D",
                 "F",
                 "G",
                 "H",
                 "I",
                 "J",
                 "K",
                 "L",
                 "M",
                 "N",
                 "O",
                 "P",
                 "Q",
                 "R",
                 "S",
                 "T",
                 "U",
                 "V",
                 "W",
                 "X",
                 "Y",
                 "Z",
                 "AfterASCIINotAcute",
                 "Space",
                 "Caret",
                 "Colon",
                 "Plus",
                 "Star",
                 "DoubleQuote",
                 "VerticalBar",
                 "AtSign",
                 "BackQuote",
                 "DollarSign",
                 "SemiColon",
                 "LeftBrace",
                 "RightBrace",
                 "LeftBracket",
                 "RightBracket",
                 "QuestionMark",
                 "Comma",
                 "LessThan",
                 "Slash",
                 "LeftParen",
                 "RightParen",
                 "Percent",
                 "Exclamation",
                 "Tilde",
                 "Sharp",
                 "Ampersand",
                 "BackSlash",
                 "HT",
                 "FF",
                 "EOF",
                 "LF",
                 "CR",
                 "Acute",
                 "CtlCharNotWS"
             };

    public final static boolean isValidForParser = true;
}
