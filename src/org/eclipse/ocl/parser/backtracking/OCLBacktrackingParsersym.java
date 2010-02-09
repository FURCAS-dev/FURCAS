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
* $Id: OCLBacktrackingParsersym.java,v 1.19 2010/02/09 21:04:08 ewillink Exp $
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
      TK_QUOTED_IDENTIFIER = 5,
      TK_INTEGER_LITERAL = 28,
      TK_REAL_LITERAL = 29,
      TK_STRING_LITERAL = 25,
      TK_PLUS = 37,
      TK_MINUS = 7,
      TK_MULTIPLY = 8,
      TK_DIVIDE = 38,
      TK_GREATER = 44,
      TK_LESS = 45,
      TK_EQUAL = 24,
      TK_GREATER_EQUAL = 46,
      TK_LESS_EQUAL = 47,
      TK_NOT_EQUAL = 48,
      TK_LPAREN = 2,
      TK_RPAREN = 3,
      TK_LBRACE = 64,
      TK_RBRACE = 52,
      TK_LBRACKET = 61,
      TK_RBRACKET = 69,
      TK_ARROW = 40,
      TK_BAR = 50,
      TK_COMMA = 26,
      TK_COLON = 4,
      TK_COLONCOLON = 39,
      TK_SEMICOLON = 70,
      TK_DOT = 41,
      TK_DOTDOT = 74,
      TK_AT = 49,
      TK_CARET = 42,
      TK_CARETCARET = 43,
      TK_QUESTIONMARK = 65,
      TK_self = 30,
      TK_if = 31,
      TK_then = 75,
      TK_else = 76,
      TK_endif = 71,
      TK_and = 51,
      TK_or = 53,
      TK_xor = 56,
      TK_not = 27,
      TK_implies = 62,
      TK_let = 32,
      TK_in = 77,
      TK_true = 33,
      TK_false = 34,
      TK_null = 35,
      TK_invalid = 36,
      TK_Set = 9,
      TK_Bag = 10,
      TK_Sequence = 11,
      TK_Collection = 12,
      TK_OrderedSet = 13,
      TK_String = 14,
      TK_Integer = 15,
      TK_UnlimitedNatural = 16,
      TK_Real = 17,
      TK_Boolean = 18,
      TK_Tuple = 19,
      TK_OclAny = 20,
      TK_OclVoid = 21,
      TK_OclInvalid = 22,
      TK_inv = 57,
      TK_pre = 54,
      TK_post = 58,
      TK_context = 63,
      TK_package = 72,
      TK_endpackage = 66,
      TK_def = 55,
      TK_body = 59,
      TK_derive = 67,
      TK_init = 68,
      TK_static = 60,
      TK_OclMessage = 23,
      TK_EOF_TOKEN = 73,
      TK_IDENTIFIER = 6,
      TK_SINGLE_LINE_COMMENT = 78,
      TK_MULTI_LINE_COMMENT = 79,
      TK_ERROR_TOKEN = 1;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "RPAREN",
                 "COLON",
                 "QUOTED_IDENTIFIER",
                 "IDENTIFIER",
                 "MINUS",
                 "MULTIPLY",
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
                 "EQUAL",
                 "STRING_LITERAL",
                 "COMMA",
                 "not",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "self",
                 "if",
                 "let",
                 "true",
                 "false",
                 "null",
                 "invalid",
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
                 "NOT_EQUAL",
                 "AT",
                 "BAR",
                 "and",
                 "RBRACE",
                 "or",
                 "pre",
                 "def",
                 "xor",
                 "inv",
                 "post",
                 "body",
                 "static",
                 "LBRACKET",
                 "implies",
                 "context",
                 "LBRACE",
                 "QUESTIONMARK",
                 "endpackage",
                 "derive",
                 "init",
                 "RBRACKET",
                 "SEMICOLON",
                 "endif",
                 "package",
                 "EOF_TOKEN",
                 "DOTDOT",
                 "then",
                 "else",
                 "in",
                 "SINGLE_LINE_COMMENT",
                 "MULTI_LINE_COMMENT"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
