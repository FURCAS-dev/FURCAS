/**
* Essential OCL Grammar
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
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112, 295166
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: OCLParsersym.java,v 1.23 2010/02/09 21:04:08 ewillink Exp $
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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
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
      TK_QUOTED_IDENTIFIER = 6,
      TK_INTEGER_LITERAL = 42,
      TK_REAL_LITERAL = 43,
      TK_STRING_LITERAL = 36,
      TK_PLUS = 10,
      TK_MINUS = 4,
      TK_MULTIPLY = 5,
      TK_DIVIDE = 11,
      TK_GREATER = 17,
      TK_LESS = 18,
      TK_EQUAL = 8,
      TK_GREATER_EQUAL = 19,
      TK_LESS_EQUAL = 20,
      TK_NOT_EQUAL = 37,
      TK_LPAREN = 1,
      TK_RPAREN = 2,
      TK_LBRACE = 60,
      TK_RBRACE = 61,
      TK_LBRACKET = 56,
      TK_RBRACKET = 66,
      TK_ARROW = 13,
      TK_BAR = 39,
      TK_COMMA = 9,
      TK_COLON = 3,
      TK_COLONCOLON = 12,
      TK_SEMICOLON = 67,
      TK_DOT = 14,
      TK_DOTDOT = 70,
      TK_AT = 38,
      TK_CARET = 15,
      TK_CARETCARET = 16,
      TK_QUESTIONMARK = 68,
      TK_self = 44,
      TK_if = 45,
      TK_then = 71,
      TK_else = 72,
      TK_endif = 73,
      TK_and = 40,
      TK_or = 46,
      TK_xor = 53,
      TK_not = 41,
      TK_implies = 57,
      TK_let = 47,
      TK_in = 74,
      TK_true = 48,
      TK_false = 49,
      TK_null = 50,
      TK_invalid = 51,
      TK_Set = 21,
      TK_Bag = 22,
      TK_Sequence = 23,
      TK_Collection = 24,
      TK_OrderedSet = 25,
      TK_String = 26,
      TK_Integer = 27,
      TK_UnlimitedNatural = 28,
      TK_Real = 29,
      TK_Boolean = 30,
      TK_Tuple = 31,
      TK_OclAny = 32,
      TK_OclVoid = 33,
      TK_OclInvalid = 34,
      TK_inv = 54,
      TK_pre = 58,
      TK_post = 62,
      TK_context = 59,
      TK_package = 69,
      TK_endpackage = 75,
      TK_def = 52,
      TK_body = 63,
      TK_derive = 64,
      TK_init = 65,
      TK_static = 55,
      TK_OclMessage = 35,
      TK_EOF_TOKEN = 76,
      TK_IDENTIFIER = 7,
      TK_SINGLE_LINE_COMMENT = 77,
      TK_MULTI_LINE_COMMENT = 78,
      TK_ERROR_TOKEN = 79;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "RPAREN",
                 "COLON",
                 "MINUS",
                 "MULTIPLY",
                 "QUOTED_IDENTIFIER",
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
                 "STRING_LITERAL",
                 "NOT_EQUAL",
                 "AT",
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
