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
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040
*   Borland - Bug 242880
*
* </copyright>
*
* $Id: OCLBacktrackingParsersym.java,v 1.9 2009/10/10 11:49:15 ewillink Exp $
*/

package org.eclipse.ocl.parser.backtracking;

/**
 * The backtracking variant of the OCL parser symbol table.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * 
 * @since 1.3
 */
@SuppressWarnings("nls")
public interface OCLBacktrackingParsersym {
	/**
	 * Token kind codes.
	 * 
	 * @noreference These constants are not intended to be referenced by clients.
	 */
    public final static int
      TK_STRING_LITERAL = 50,
      TK_INTEGER_LITERAL = 51,
      TK_REAL_LITERAL = 52,
      TK_PLUS = 63,
      TK_MINUS = 37,
      TK_MULTIPLY = 38,
      TK_DIVIDE = 65,
      TK_GREATER = 66,
      TK_LESS = 67,
      TK_EQUAL = 55,
      TK_GREATER_EQUAL = 68,
      TK_LESS_EQUAL = 69,
      TK_NOT_EQUAL = 70,
      TK_LPAREN = 2,
      TK_RPAREN = 3,
      TK_LBRACE = 88,
      TK_RBRACE = 73,
      TK_LBRACKET = 71,
      TK_RBRACKET = 74,
      TK_ARROW = 76,
      TK_BAR = 62,
      TK_COMMA = 40,
      TK_COLON = 36,
      TK_COLONCOLON = 41,
      TK_SEMICOLON = 82,
      TK_DOT = 77,
      TK_DOTDOT = 83,
      TK_ATPRE = 64,
      TK_CARET = 78,
      TK_CARETCARET = 79,
      TK_QUESTIONMARK = 87,
      TK_self = 4,
      TK_inv = 47,
      TK_pre = 42,
      TK_post = 43,
      TK_context = 48,
      TK_package = 72,
      TK_endpackage = 53,
      TK_def = 46,
      TK_if = 54,
      TK_then = 84,
      TK_else = 85,
      TK_endif = 80,
      TK_and = 56,
      TK_or = 57,
      TK_xor = 58,
      TK_not = 39,
      TK_implies = 81,
      TK_let = 59,
      TK_in = 86,
      TK_true = 5,
      TK_false = 6,
      TK_body = 44,
      TK_derive = 60,
      TK_init = 61,
      TK_null = 7,
      TK_invalid = 8,
      TK_static = 49,
      TK_Set = 9,
      TK_Bag = 10,
      TK_Sequence = 11,
      TK_Collection = 12,
      TK_OrderedSet = 13,
      TK_iterate = 14,
      TK_forAll = 15,
      TK_exists = 16,
      TK_isUnique = 17,
      TK_any = 18,
      TK_one = 19,
      TK_collect = 20,
      TK_select = 21,
      TK_reject = 22,
      TK_collectNested = 23,
      TK_sortedBy = 24,
      TK_closure = 25,
      TK_String = 26,
      TK_Integer = 27,
      TK_UnlimitedNatural = 28,
      TK_Real = 29,
      TK_Boolean = 30,
      TK_Tuple = 45,
      TK_OclAny = 31,
      TK_OclVoid = 32,
      TK_OclInvalid = 33,
      TK_OclMessage = 34,
      TK_EOF_TOKEN = 75,
      TK_IDENTIFIER = 35,
      TK_SINGLE_LINE_COMMENT = 89,
      TK_MULTI_LINE_COMMENT = 90,
      TK_ERROR_TOKEN = 1;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "RPAREN",
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
                 "COLON",
                 "MINUS",
                 "MULTIPLY",
                 "not",
                 "COMMA",
                 "COLONCOLON",
                 "pre",
                 "post",
                 "body",
                 "Tuple",
                 "def",
                 "inv",
                 "context",
                 "static",
                 "STRING_LITERAL",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "endpackage",
                 "if",
                 "EQUAL",
                 "and",
                 "or",
                 "xor",
                 "let",
                 "derive",
                 "init",
                 "BAR",
                 "PLUS",
                 "ATPRE",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "NOT_EQUAL",
                 "LBRACKET",
                 "package",
                 "RBRACE",
                 "RBRACKET",
                 "EOF_TOKEN",
                 "ARROW",
                 "DOT",
                 "CARET",
                 "CARETCARET",
                 "endif",
                 "implies",
                 "SEMICOLON",
                 "DOTDOT",
                 "then",
                 "else",
                 "in",
                 "QUESTIONMARK",
                 "LBRACE",
                 "SINGLE_LINE_COMMENT",
                 "MULTI_LINE_COMMENT"
             };

    public final static boolean isValidForParser = true;
}
