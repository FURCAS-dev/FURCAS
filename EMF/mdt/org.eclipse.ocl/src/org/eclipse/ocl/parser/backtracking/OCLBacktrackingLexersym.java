/**
* Essential OCL Lexer
* <copyright>
*
* Copyright (c) 2005, 2010 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   Borland - Bug 242880
*   E.D.Willink - Bug 292112, 295166
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
* </copyright>
*
* $Id: OCLBacktrackingLexersym.java,v 1.17 2010/02/09 21:04:18 ewillink Exp $
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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
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
      Char_a = 17,
      Char_b = 18,
      Char_c = 19,
      Char_d = 20,
      Char_e = 11,
      Char_f = 21,
      Char_g = 22,
      Char_h = 23,
      Char_i = 24,
      Char_j = 25,
      Char_k = 26,
      Char_l = 27,
      Char_m = 28,
      Char_n = 29,
      Char_o = 30,
      Char_p = 31,
      Char_q = 32,
      Char_r = 33,
      Char_s = 34,
      Char_t = 35,
      Char_u = 36,
      Char_v = 37,
      Char_w = 38,
      Char_x = 39,
      Char_y = 40,
      Char_z = 41,
      Char__ = 42,
      Char_A = 43,
      Char_B = 44,
      Char_C = 45,
      Char_D = 46,
      Char_E = 12,
      Char_F = 47,
      Char_G = 48,
      Char_H = 49,
      Char_I = 50,
      Char_J = 51,
      Char_K = 52,
      Char_L = 53,
      Char_M = 54,
      Char_N = 55,
      Char_O = 56,
      Char_P = 57,
      Char_Q = 58,
      Char_R = 59,
      Char_S = 60,
      Char_T = 61,
      Char_U = 62,
      Char_V = 63,
      Char_W = 64,
      Char_X = 65,
      Char_Y = 66,
      Char_Z = 67,
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
      Char_AfterASCIINotAcute = 68,
      Char_Space = 69,
      Char_DoubleQuote = 90,
      Char_SingleQuote = 70,
      Char_Percent = 91,
      Char_VerticalBar = 75,
      Char_Exclamation = 92,
      Char_AtSign = 76,
      Char_BackQuote = 77,
      Char_Acute = 102,
      Char_Tilde = 93,
      Char_Sharp = 94,
      Char_DollarSign = 78,
      Char_Ampersand = 95,
      Char_Caret = 71,
      Char_Colon = 72,
      Char_SemiColon = 79,
      Char_BackSlash = 96,
      Char_LeftBrace = 80,
      Char_RightBrace = 81,
      Char_LeftBracket = 82,
      Char_RightBracket = 83,
      Char_QuestionMark = 84,
      Char_Comma = 85,
      Char_Dot = 13,
      Char_LessThan = 86,
      Char_GreaterThan = 14,
      Char_Plus = 73,
      Char_Minus = 15,
      Char_Slash = 87,
      Char_Star = 74,
      Char_LeftParen = 88,
      Char_RightParen = 89,
      Char_Equal = 16,
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
                 "SingleQuote",
                 "Caret",
                 "Colon",
                 "Plus",
                 "Star",
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
                 "DoubleQuote",
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

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
