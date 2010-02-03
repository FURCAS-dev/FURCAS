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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: OCLBacktrackingParsersym.java,v 1.18 2010/02/03 19:54:12 ewillink Exp $
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
      TK_INTEGER_LITERAL = 27,
      TK_REAL_LITERAL = 28,
      TK_STRING_LITERAL = 24,
      TK_PLUS = 36,
      TK_MINUS = 6,
      TK_MULTIPLY = 7,
      TK_DIVIDE = 37,
      TK_GREATER = 43,
      TK_LESS = 44,
      TK_EQUAL = 23,
      TK_GREATER_EQUAL = 45,
      TK_LESS_EQUAL = 46,
      TK_NOT_EQUAL = 47,
      TK_LPAREN = 2,
      TK_RPAREN = 3,
      TK_LBRACE = 63,
      TK_RBRACE = 51,
      TK_LBRACKET = 60,
      TK_RBRACKET = 68,
      TK_ARROW = 39,
      TK_BAR = 49,
      TK_COMMA = 25,
      TK_COLON = 4,
      TK_COLONCOLON = 38,
      TK_SEMICOLON = 69,
      TK_DOT = 40,
      TK_DOTDOT = 73,
      TK_AT = 48,
      TK_CARET = 41,
      TK_CARETCARET = 42,
      TK_QUESTIONMARK = 64,
      TK_self = 29,
      TK_if = 30,
      TK_then = 74,
      TK_else = 75,
      TK_endif = 70,
      TK_and = 50,
      TK_or = 52,
      TK_xor = 55,
      TK_not = 26,
      TK_implies = 61,
      TK_let = 31,
      TK_in = 76,
      TK_true = 32,
      TK_false = 33,
      TK_null = 34,
      TK_invalid = 35,
      TK_Set = 8,
      TK_Bag = 9,
      TK_Sequence = 10,
      TK_Collection = 11,
      TK_OrderedSet = 12,
      TK_String = 13,
      TK_Integer = 14,
      TK_UnlimitedNatural = 15,
      TK_Real = 16,
      TK_Boolean = 17,
      TK_Tuple = 18,
      TK_OclAny = 19,
      TK_OclVoid = 20,
      TK_OclInvalid = 21,
      TK_inv = 56,
      TK_pre = 53,
      TK_post = 57,
      TK_context = 62,
      TK_package = 71,
      TK_endpackage = 65,
      TK_def = 54,
      TK_body = 58,
      TK_derive = 66,
      TK_init = 67,
      TK_static = 59,
      TK_OclMessage = 22,
      TK_EOF_TOKEN = 72,
      TK_IDENTIFIER = 5,
      TK_SINGLE_LINE_COMMENT = 77,
      TK_MULTI_LINE_COMMENT = 78,
      TK_ERROR_TOKEN = 1;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "ERROR_TOKEN",
                 "LPAREN",
                 "RPAREN",
                 "COLON",
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
