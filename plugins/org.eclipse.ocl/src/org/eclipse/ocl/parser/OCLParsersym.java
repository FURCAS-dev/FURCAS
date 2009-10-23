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
*
* </copyright>
*
* $Id: OCLParsersym.java,v 1.15 2009/10/23 21:26:55 ewillink Exp $
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
*   E.D.Willink - Bug 259818, 285633, 292112, 292594
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
      TK_STRING_LITERAL = 54,
      TK_INTEGER_LITERAL = 55,
      TK_REAL_LITERAL = 56,
      TK_PLUS = 49,
      TK_MINUS = 40,
      TK_MULTIPLY = 41,
      TK_DIVIDE = 64,
      TK_GREATER = 65,
      TK_LESS = 66,
      TK_EQUAL = 42,
      TK_GREATER_EQUAL = 67,
      TK_LESS_EQUAL = 68,
      TK_NOT_EQUAL = 71,
      TK_LPAREN = 1,
      TK_RPAREN = 3,
      TK_LBRACE = 77,
      TK_RBRACE = 78,
      TK_LBRACKET = 39,
      TK_RBRACKET = 79,
      TK_ARROW = 81,
      TK_BAR = 43,
      TK_COMMA = 5,
      TK_COLON = 2,
      TK_COLONCOLON = 4,
      TK_SEMICOLON = 82,
      TK_DOT = 83,
      TK_DOTDOT = 84,
      TK_AT = 38,
      TK_CARET = 85,
      TK_CARETCARET = 86,
      TK_QUESTIONMARK = 80,
      TK_self = 6,
      TK_if = 45,
      TK_then = 72,
      TK_else = 73,
      TK_endif = 74,
      TK_and = 57,
      TK_or = 58,
      TK_xor = 59,
      TK_not = 44,
      TK_implies = 69,
      TK_let = 46,
      TK_in = 75,
      TK_true = 7,
      TK_false = 8,
      TK_null = 9,
      TK_invalid = 10,
      TK_Set = 11,
      TK_Bag = 12,
      TK_Sequence = 13,
      TK_Collection = 14,
      TK_OrderedSet = 15,
      TK_iterate = 16,
      TK_forAll = 17,
      TK_exists = 18,
      TK_isUnique = 19,
      TK_any = 20,
      TK_one = 21,
      TK_collect = 22,
      TK_select = 23,
      TK_reject = 24,
      TK_collectNested = 25,
      TK_sortedBy = 26,
      TK_closure = 27,
      TK_String = 28,
      TK_Integer = 29,
      TK_UnlimitedNatural = 30,
      TK_Real = 31,
      TK_Boolean = 32,
      TK_Tuple = 47,
      TK_OclAny = 33,
      TK_OclVoid = 34,
      TK_OclInvalid = 35,
      TK_inv = 50,
      TK_pre = 51,
      TK_post = 60,
      TK_context = 52,
      TK_package = 70,
      TK_endpackage = 76,
      TK_def = 48,
      TK_body = 61,
      TK_derive = 62,
      TK_init = 63,
      TK_static = 53,
      TK_OclMessage = 36,
      TK_EOF_TOKEN = 87,
      TK_IDENTIFIER = 37,
      TK_SINGLE_LINE_COMMENT = 88,
      TK_MULTI_LINE_COMMENT = 89,
      TK_ERROR_TOKEN = 90;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "COLON",
                 "RPAREN",
                 "COLONCOLON",
                 "COMMA",
                 "self",
                 "true",
                 "false",
                 "null",
                 "invalid",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "iterate",
                 "forAll",
                 "exists",
                 "isUnique",
                 "any",
                 "one",
                 "collect",
                 "select",
                 "reject",
                 "collectNested",
                 "sortedBy",
                 "closure",
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "OclAny",
                 "OclVoid",
                 "OclInvalid",
                 "OclMessage",
                 "IDENTIFIER",
                 "AT",
                 "LBRACKET",
                 "MINUS",
                 "MULTIPLY",
                 "EQUAL",
                 "BAR",
                 "not",
                 "if",
                 "let",
                 "Tuple",
                 "def",
                 "PLUS",
                 "inv",
                 "pre",
                 "context",
                 "static",
                 "STRING_LITERAL",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "and",
                 "or",
                 "xor",
                 "post",
                 "body",
                 "derive",
                 "init",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "implies",
                 "package",
                 "NOT_EQUAL",
                 "then",
                 "else",
                 "endif",
                 "in",
                 "endpackage",
                 "LBRACE",
                 "RBRACE",
                 "RBRACKET",
                 "QUESTIONMARK",
                 "ARROW",
                 "SEMICOLON",
                 "DOT",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "EOF_TOKEN",
                 "SINGLE_LINE_COMMENT",
                 "MULTI_LINE_COMMENT",
                 "ERROR_TOKEN"
             };

    public final static boolean isValidForParser = true;
}
