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
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*
* </copyright>
*
* $Id: OCLKWLexersym.java,v 1.1 2007/10/11 23:05:00 cdamus Exp $
*/

package org.eclipse.ocl.parser;

@SuppressWarnings("nls")
public interface OCLKWLexersym {
    public final static int
      Char_DollarSign = 40,
      Char_a = 5,
      Char_b = 30,
      Char_c = 11,
      Char_d = 8,
      Char_e = 1,
      Char_f = 12,
      Char_g = 15,
      Char_h = 31,
      Char_i = 6,
      Char_j = 32,
      Char_k = 26,
      Char_l = 3,
      Char_m = 27,
      Char_n = 4,
      Char_o = 10,
      Char_p = 13,
      Char_q = 28,
      Char_r = 7,
      Char_s = 9,
      Char_t = 2,
      Char_u = 14,
      Char_v = 17,
      Char_w = 33,
      Char_x = 19,
      Char_y = 16,
      Char_z = 41,
      Char_A = 20,
      Char_B = 29,
      Char_C = 34,
      Char_D = 42,
      Char_E = 43,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 18,
      Char_J = 47,
      Char_K = 35,
      Char_L = 48,
      Char_M = 36,
      Char_N = 21,
      Char_O = 22,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 37,
      Char_S = 23,
      Char_T = 24,
      Char_U = 25,
      Char_V = 38,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
      Char_EOF = 39;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "t",
                 "l",
                 "n",
                 "a",
                 "i",
                 "r",
                 "d",
                 "s",
                 "o",
                 "c",
                 "f",
                 "p",
                 "u",
                 "g",
                 "y",
                 "v",
                 "I",
                 "x",
                 "A",
                 "N",
                 "O",
                 "S",
                 "T",
                 "U",
                 "k",
                 "m",
                 "q",
                 "B",
                 "b",
                 "h",
                 "j",
                 "w",
                 "C",
                 "K",
                 "M",
                 "R",
                 "V",
                 "EOF",
                 "DollarSign",
                 "z",
                 "D",
                 "E",
                 "F",
                 "G",
                 "H",
                 "J",
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
