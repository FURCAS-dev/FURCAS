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

/**
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
@SuppressWarnings("nls")
public interface OCLKWLexersym {
    public final static int
      Char_DollarSign = 37,
      Char_Percent = 38,
      Char__ = 39,
      Char_a = 4,
      Char_b = 23,
      Char_c = 10,
      Char_d = 8,
      Char_e = 1,
      Char_f = 13,
      Char_g = 12,
      Char_h = 24,
      Char_i = 6,
      Char_j = 40,
      Char_k = 17,
      Char_l = 2,
      Char_m = 18,
      Char_n = 5,
      Char_o = 7,
      Char_p = 15,
      Char_q = 25,
      Char_r = 9,
      Char_s = 11,
      Char_t = 3,
      Char_u = 14,
      Char_v = 16,
      Char_w = 41,
      Char_x = 19,
      Char_y = 20,
      Char_z = 42,
      Char_A = 26,
      Char_B = 27,
      Char_C = 28,
      Char_D = 43,
      Char_E = 44,
      Char_F = 45,
      Char_G = 46,
      Char_H = 47,
      Char_I = 21,
      Char_J = 48,
      Char_K = 49,
      Char_L = 50,
      Char_M = 29,
      Char_N = 30,
      Char_O = 31,
      Char_P = 51,
      Char_Q = 52,
      Char_R = 32,
      Char_S = 22,
      Char_T = 33,
      Char_U = 34,
      Char_V = 35,
      Char_W = 53,
      Char_X = 54,
      Char_Y = 55,
      Char_Z = 56,
      Char_EOF = 36;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "l",
                 "t",
                 "a",
                 "n",
                 "i",
                 "o",
                 "d",
                 "r",
                 "c",
                 "s",
                 "g",
                 "f",
                 "u",
                 "p",
                 "v",
                 "k",
                 "m",
                 "x",
                 "y",
                 "I",
                 "S",
                 "b",
                 "h",
                 "q",
                 "A",
                 "B",
                 "C",
                 "M",
                 "N",
                 "O",
                 "R",
                 "T",
                 "U",
                 "V",
                 "EOF",
                 "DollarSign",
                 "Percent",
                 "_",
                 "j",
                 "w",
                 "z",
                 "D",
                 "E",
                 "F",
                 "G",
                 "H",
                 "J",
                 "K",
                 "L",
                 "P",
                 "Q",
                 "W",
                 "X",
                 "Y",
                 "Z"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
