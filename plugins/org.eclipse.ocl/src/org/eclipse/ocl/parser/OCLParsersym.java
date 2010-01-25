/**
* Essential OCL Grammar
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
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
* </copyright>
*
* $Id: OCLParsersym.java,v 1.20 2010/01/25 11:10:05 asanchez Exp $
*/
/**
* Complete OCL Grammar
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
*   E.D.Willink - Bug 259818, 285633, 292112
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
* </copyright>
*/

package org.eclipse.ocl.parser;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
@SuppressWarnings("nls")
public interface OCLParsersym {
	/**
	 * Token kind codes.
	 * 
	 * @noreference These constants are not intended to be referenced by clients.
	 */
    public final static int
      TK_INTEGER_LITERAL = 41,
      TK_REAL_LITERAL = 42,
      TK_STRING_LITERAL = 37,
      TK_PLUS = 9,
      TK_MINUS = 4,
      TK_MULTIPLY = 5,
      TK_DIVIDE = 10,
      TK_GREATER = 16,
      TK_LESS = 17,
      TK_EQUAL = 7,
      TK_GREATER_EQUAL = 18,
      TK_LESS_EQUAL = 19,
      TK_NOT_EQUAL = 35,
      TK_LPAREN = 1,
      TK_RPAREN = 2,
      TK_LBRACE = 59,
      TK_RBRACE = 60,
      TK_LBRACKET = 55,
      TK_RBRACKET = 65,
      TK_ARROW = 12,
      TK_BAR = 38,
      TK_COMMA = 8,
      TK_COLON = 3,
      TK_COLONCOLON = 11,
      TK_SEMICOLON = 66,
      TK_DOT = 13,
      TK_DOTDOT = 69,
      TK_AT = 36,
      TK_CARET = 14,
      TK_CARETCARET = 15,
      TK_QUESTIONMARK = 67,
      TK_self = 43,
      TK_if = 44,
      TK_then = 70,
      TK_else = 71,
      TK_endif = 72,
      TK_and = 39,
      TK_or = 45,
      TK_xor = 52,
      TK_not = 40,
      TK_implies = 56,
      TK_let = 46,
      TK_in = 73,
      TK_true = 47,
      TK_false = 48,
      TK_null = 49,
      TK_invalid = 50,
      TK_Set = 20,
      TK_Bag = 21,
      TK_Sequence = 22,
      TK_Collection = 23,
      TK_OrderedSet = 24,
      TK_String = 25,
      TK_Integer = 26,
      TK_UnlimitedNatural = 27,
      TK_Real = 28,
      TK_Boolean = 29,
      TK_Tuple = 30,
      TK_OclAny = 31,
      TK_OclVoid = 32,
      TK_OclInvalid = 33,
      TK_inv = 53,
      TK_pre = 57,
      TK_post = 61,
      TK_context = 58,
      TK_package = 68,
      TK_endpackage = 74,
      TK_def = 51,
      TK_body = 62,
      TK_derive = 63,
      TK_init = 64,
      TK_static = 54,
      TK_OclMessage = 34,
      TK_EOF_TOKEN = 75,
      TK_IDENTIFIER = 6,
      TK_SINGLE_LINE_COMMENT = 76,
      TK_MULTI_LINE_COMMENT = 77,
      TK_ERROR_TOKEN = 78;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "RPAREN",
                 "COLON",
                 "MINUS",
                 "MULTIPLY",
                 "IDENTIFIER",
                 "EQUAL",
                 "COMMA",
                 "PLUS",
                 "DIVIDE",
                 "COLONCOLON",
                 "ARROW",
                 "DOT",
                 "CARET",
                 "CARETCARET",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "Tuple",
                 "OclAny",
                 "OclVoid",
                 "OclInvalid",
                 "OclMessage",
                 "NOT_EQUAL",
                 "AT",
                 "STRING_LITERAL",
                 "BAR",
                 "and",
                 "not",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "self",
                 "if",
                 "or",
                 "let",
                 "true",
                 "false",
                 "null",
                 "invalid",
                 "def",
                 "xor",
                 "inv",
                 "static",
                 "LBRACKET",
                 "implies",
                 "pre",
                 "context",
                 "LBRACE",
                 "RBRACE",
                 "post",
                 "body",
                 "derive",
                 "init",
                 "RBRACKET",
                 "SEMICOLON",
                 "QUESTIONMARK",
                 "package",
                 "DOTDOT",
                 "then",
                 "else",
                 "endif",
                 "in",
                 "endpackage",
                 "EOF_TOKEN",
                 "SINGLE_LINE_COMMENT",
                 "MULTI_LINE_COMMENT",
                 "ERROR_TOKEN"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
