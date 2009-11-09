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
* </copyright>
*
* $Id: OCLBacktrackingKWLexersym.java,v 1.9 2009/11/09 22:14:17 ewillink Exp $
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
* </copyright>
*/

package org.eclipse.ocl.parser.backtracking;

/**
 * The backtracking variant of the OCL keyword lexer symbol table.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * 
 * @since 1.3
 */
@SuppressWarnings("nls")
public interface OCLBacktrackingKWLexersym {
    public final static int
      Char_DollarSign = 37,
      Char_a = 4,
      Char_b = 23,
      Char_c = 10,
      Char_d = 8,
      Char_e = 1,
      Char_f = 13,
      Char_g = 12,
      Char_h = 24,
      Char_i = 6,
      Char_j = 38,
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
      Char_w = 39,
      Char_x = 19,
      Char_y = 20,
      Char_z = 40,
      Char_A = 26,
      Char_B = 27,
      Char_C = 28,
      Char_D = 41,
      Char_E = 42,
      Char_F = 43,
      Char_G = 44,
      Char_H = 45,
      Char_I = 21,
      Char_J = 46,
      Char_K = 47,
      Char_L = 48,
      Char_M = 29,
      Char_N = 30,
      Char_O = 31,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 32,
      Char_S = 22,
      Char_T = 33,
      Char_U = 34,
      Char_V = 35,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
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

    public final static boolean isValidForParser = true;
}
