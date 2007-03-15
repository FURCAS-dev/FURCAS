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
*
* </copyright>
*
* $Id: OCLLPGParsersym.java,v 1.3 2007/03/15 21:35:11 cdamus Exp $
*/

package org.eclipse.ocl.internal.parser;

public interface OCLLPGParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 44,
      TK_STRING_LITERAL = 45,
      TK_INTEGER_LITERAL = 46,
      TK_REAL_LITERAL = 47,
      TK_PLUS = 26,
      TK_MINUS = 27,
      TK_MULTIPLY = 19,
      TK_DIVIDE = 20,
      TK_GREATER = 14,
      TK_LESS = 15,
      TK_EQUAL = 4,
      TK_GREATER_EQUAL = 16,
      TK_LESS_EQUAL = 17,
      TK_NOT_EQUAL = 18,
      TK_LPAREN = 1,
      TK_RPAREN = 2,
      TK_LBRACE = 65,
      TK_RBRACE = 66,
      TK_LBRACKET = 67,
      TK_RBRACKET = 68,
      TK_ARROW = 73,
      TK_BAR = 56,
      TK_COMMA = 43,
      TK_COLON = 22,
      TK_COLONCOLON = 52,
      TK_SEMICOLON = 74,
      TK_DOT = 75,
      TK_DOTDOT = 76,
      TK_ATPRE = 55,
      TK_CARET = 77,
      TK_CARETCARET = 78,
      TK_QUESTIONMARK = 69,
      TK_self = 21,
      TK_inv = 59,
      TK_pre = 60,
      TK_post = 61,
      TK_body = 62,
      TK_context = 57,
      TK_package = 70,
      TK_endpackage = 79,
      TK_def = 63,
      TK_derive = 71,
      TK_init = 72,
      TK_if = 53,
      TK_then = 80,
      TK_else = 81,
      TK_endif = 82,
      TK_and = 23,
      TK_or = 24,
      TK_xor = 25,
      TK_not = 33,
      TK_implies = 83,
      TK_let = 54,
      TK_in = 84,
      TK_true = 48,
      TK_false = 49,
      TK_Set = 28,
      TK_Bag = 29,
      TK_Sequence = 30,
      TK_Collection = 31,
      TK_OrderedSet = 32,
      TK_iterate = 85,
      TK_forAll = 86,
      TK_exists = 87,
      TK_isUnique = 88,
      TK_any = 89,
      TK_one = 90,
      TK_collect = 91,
      TK_select = 92,
      TK_reject = 93,
      TK_collectNested = 94,
      TK_sortedBy = 95,
      TK_closure = 96,
      TK_oclIsKindOf = 34,
      TK_oclIsTypeOf = 35,
      TK_oclAsType = 36,
      TK_oclIsNew = 37,
      TK_oclIsUndefined = 38,
      TK_oclIsInvalid = 39,
      TK_oclIsInState = 40,
      TK_allInstances = 41,
      TK_String = 5,
      TK_Integer = 6,
      TK_UnlimitedNatural = 7,
      TK_Real = 8,
      TK_Boolean = 9,
      TK_Tuple = 42,
      TK_OclAny = 10,
      TK_OclVoid = 11,
      TK_Invalid = 12,
      TK_OclMessage = 13,
      TK_null = 50,
      TK_OclInvalid = 51,
      TK_EOF_TOKEN = 58,
      TK_IDENTIFIER = 3,
      TK_INTEGER_RANGE_START = 64,
      TK_ERROR_TOKEN = 97;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "String", //$NON-NLS-1$
                 "Integer", //$NON-NLS-1$
                 "UnlimitedNatural", //$NON-NLS-1$
                 "Real", //$NON-NLS-1$
                 "Boolean", //$NON-NLS-1$
                 "OclAny", //$NON-NLS-1$
                 "OclVoid", //$NON-NLS-1$
                 "Invalid", //$NON-NLS-1$
                 "OclMessage", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "oclIsKindOf", //$NON-NLS-1$
                 "oclIsTypeOf", //$NON-NLS-1$
                 "oclAsType", //$NON-NLS-1$
                 "oclIsNew", //$NON-NLS-1$
                 "oclIsUndefined", //$NON-NLS-1$
                 "oclIsInvalid", //$NON-NLS-1$
                 "oclIsInState", //$NON-NLS-1$
                 "allInstances", //$NON-NLS-1$
                 "Tuple", //$NON-NLS-1$
                 "COMMA", //$NON-NLS-1$
                 "NUMERIC_OPERATION", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "OclInvalid", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "ATPRE", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "context", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "inv", //$NON-NLS-1$
                 "pre", //$NON-NLS-1$
                 "post", //$NON-NLS-1$
                 "body", //$NON-NLS-1$
                 "def", //$NON-NLS-1$
                 "INTEGER_RANGE_START", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "package", //$NON-NLS-1$
                 "derive", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "CARET", //$NON-NLS-1$
                 "CARETCARET", //$NON-NLS-1$
                 "endpackage", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "iterate", //$NON-NLS-1$
                 "forAll", //$NON-NLS-1$
                 "exists", //$NON-NLS-1$
                 "isUnique", //$NON-NLS-1$
                 "any", //$NON-NLS-1$
                 "one", //$NON-NLS-1$
                 "collect", //$NON-NLS-1$
                 "select", //$NON-NLS-1$
                 "reject", //$NON-NLS-1$
                 "collectNested", //$NON-NLS-1$
                 "sortedBy", //$NON-NLS-1$
                 "closure", //$NON-NLS-1$
                 "ERROR_TOKEN" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
