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
* $Id: OCLBacktrackingParsersym.java,v 1.10 2009/10/15 19:42:56 ewillink Exp $
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
* </copyright>
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
      TK_STRING_LITERAL = 44,
      TK_INTEGER_LITERAL = 45,
      TK_REAL_LITERAL = 46,
      TK_PLUS = 71,
      TK_MINUS = 40,
      TK_MULTIPLY = 41,
      TK_DIVIDE = 72,
      TK_GREATER = 73,
      TK_LESS = 74,
      TK_EQUAL = 56,
      TK_GREATER_EQUAL = 75,
      TK_LESS_EQUAL = 76,
      TK_NOT_EQUAL = 78,
      TK_LPAREN = 2,
      TK_RPAREN = 4,
      TK_LBRACE = 80,
      TK_RBRACE = 77,
      TK_LBRACKET = 50,
      TK_RBRACKET = 81,
      TK_ARROW = 83,
      TK_BAR = 67,
      TK_COMMA = 47,
      TK_COLON = 3,
      TK_COLONCOLON = 42,
      TK_SEMICOLON = 84,
      TK_DOT = 85,
      TK_DOTDOT = 86,
      TK_ATPRE = 48,
      TK_CARET = 87,
      TK_CARETCARET = 88,
      TK_QUESTIONMARK = 79,
      TK_self = 5,
      TK_if = 38,
      TK_then = 68,
      TK_else = 69,
      TK_endif = 64,
      TK_and = 58,
      TK_or = 59,
      TK_xor = 60,
      TK_not = 37,
      TK_implies = 65,
      TK_let = 39,
      TK_in = 70,
      TK_true = 6,
      TK_false = 7,
      TK_null = 8,
      TK_invalid = 9,
      TK_Set = 10,
      TK_Bag = 11,
      TK_Sequence = 12,
      TK_Collection = 13,
      TK_OrderedSet = 14,
      TK_iterate = 15,
      TK_forAll = 16,
      TK_exists = 17,
      TK_isUnique = 18,
      TK_any = 19,
      TK_one = 20,
      TK_collect = 21,
      TK_select = 22,
      TK_reject = 23,
      TK_collectNested = 24,
      TK_sortedBy = 25,
      TK_closure = 26,
      TK_String = 27,
      TK_Integer = 28,
      TK_UnlimitedNatural = 29,
      TK_Real = 30,
      TK_Boolean = 31,
      TK_Tuple = 43,
      TK_OclAny = 32,
      TK_OclVoid = 33,
      TK_OclInvalid = 34,
      TK_inv = 51,
      TK_pre = 52,
      TK_post = 53,
      TK_context = 57,
      TK_package = 66,
      TK_endpackage = 61,
      TK_def = 49,
      TK_body = 54,
      TK_derive = 62,
      TK_init = 63,
      TK_static = 55,
      TK_OclMessage = 35,
      TK_EOF_TOKEN = 82,
      TK_IDENTIFIER = 36,
      TK_SINGLE_LINE_COMMENT = 89,
      TK_MULTI_LINE_COMMENT = 90,
      TK_ERROR_TOKEN = 1;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "COLON",
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
                 "not",
                 "if",
                 "let",
                 "MINUS",
                 "MULTIPLY",
                 "COLONCOLON",
                 "Tuple",
                 "STRING_LITERAL",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "COMMA",
                 "ATPRE",
                 "def",
                 "LBRACKET",
                 "inv",
                 "pre",
                 "post",
                 "body",
                 "static",
                 "EQUAL",
                 "context",
                 "and",
                 "or",
                 "xor",
                 "endpackage",
                 "derive",
                 "init",
                 "endif",
                 "implies",
                 "package",
                 "BAR",
                 "then",
                 "else",
                 "in",
                 "PLUS",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "RBRACE",
                 "NOT_EQUAL",
                 "QUESTIONMARK",
                 "LBRACE",
                 "RBRACKET",
                 "EOF_TOKEN",
                 "ARROW",
                 "SEMICOLON",
                 "DOT",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "SINGLE_LINE_COMMENT",
                 "MULTI_LINE_COMMENT"
             };

    public final static boolean isValidForParser = true;
}
