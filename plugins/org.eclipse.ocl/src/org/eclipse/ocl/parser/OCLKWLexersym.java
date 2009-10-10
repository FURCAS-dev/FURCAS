/**
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
*   E.D.Willink - Bug 285633 static definitions
*
* </copyright>
*
* $Id: OCLKWLexersym.java,v 1.8 2009/10/10 07:04:20 ewillink Exp $
*/

package org.eclipse.ocl.parser;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
@SuppressWarnings("nls")
public interface OCLKWLexersym {
    public final static int
      Char_DollarSign = 38,
      Char_a = 4,
      Char_b = 28,
      Char_c = 11,
      Char_d = 9,
      Char_e = 1,
      Char_f = 14,
      Char_g = 13,
      Char_h = 29,
      Char_i = 6,
      Char_j = 30,
      Char_k = 19,
      Char_l = 3,
      Char_m = 20,
      Char_n = 5,
      Char_o = 8,
      Char_p = 15,
      Char_q = 21,
      Char_r = 7,
      Char_s = 10,
      Char_t = 2,
      Char_u = 12,
      Char_v = 17,
      Char_w = 39,
      Char_x = 18,
      Char_y = 16,
      Char_z = 40,
      Char_A = 22,
      Char_B = 23,
      Char_C = 31,
      Char_D = 41,
      Char_E = 42,
      Char_F = 43,
      Char_G = 44,
      Char_H = 45,
      Char_I = 24,
      Char_J = 46,
      Char_K = 47,
      Char_L = 48,
      Char_M = 32,
      Char_N = 25,
      Char_O = 33,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 34,
      Char_S = 26,
      Char_T = 35,
      Char_U = 27,
      Char_V = 36,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
      Char_EOF = 37;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "t",
                 "l",
                 "a",
                 "n",
                 "i",
                 "r",
                 "o",
                 "d",
                 "s",
                 "c",
                 "u",
                 "g",
                 "f",
                 "p",
                 "y",
                 "v",
                 "x",
                 "k",
                 "m",
                 "q",
                 "A",
                 "B",
                 "I",
                 "N",
                 "S",
                 "U",
                 "b",
                 "h",
                 "j",
                 "C",
                 "M",
                 "O",
                 "R",
                 "T",
                 "V",
                 "EOF",
                 "DollarSign",
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

    public final static boolean isValidForParser = true;
}
