/**
* <copyright>
*
* Copyright (c) 2005, 2006 IBM Corporation and others.
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
* $Id: OCLLPGParsersym.java,v 1.5 2006/10/10 14:29:26 cdamus Exp $
*/

package org.eclipse.emf.ocl.internal.parser;

public interface OCLLPGParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 43,
      TK_STRING_LITERAL = 44,
      TK_INTEGER_LITERAL = 45,
      TK_REAL_LITERAL = 46,
      TK_PLUS = 25,
      TK_MINUS = 26,
      TK_MULTIPLY = 19,
      TK_DIVIDE = 20,
      TK_GREATER = 13,
      TK_LESS = 14,
      TK_EQUAL = 4,
      TK_GREATER_EQUAL = 15,
      TK_LESS_EQUAL = 16,
      TK_NOT_EQUAL = 17,
      TK_LPAREN = 1,
      TK_RPAREN = 2,
      TK_LBRACE = 64,
      TK_RBRACE = 65,
      TK_LBRACKET = 66,
      TK_RBRACKET = 67,
      TK_ARROW = 71,
      TK_BAR = 54,
      TK_COMMA = 42,
      TK_COLON = 21,
      TK_COLONCOLON = 51,
      TK_SEMICOLON = 72,
      TK_DOT = 73,
      TK_DOTDOT = 74,
      TK_ATPRE = 55,
      TK_CARET = 75,
      TK_CARETCARET = 76,
      TK_QUESTIONMARK = 68,
      TK_self = 18,
      TK_inv = 57,
      TK_pre = 58,
      TK_post = 59,
      TK_body = 60,
      TK_context = 56,
      TK_package = 77,
      TK_endpackage = 78,
      TK_def = 61,
      TK_derive = 69,
      TK_init = 70,
      TK_if = 52,
      TK_then = 79,
      TK_else = 80,
      TK_endif = 81,
      TK_and = 22,
      TK_or = 23,
      TK_xor = 24,
      TK_not = 27,
      TK_implies = 82,
      TK_let = 53,
      TK_in = 83,
      TK_true = 47,
      TK_false = 48,
      TK_Set = 28,
      TK_Bag = 29,
      TK_Sequence = 30,
      TK_Collection = 31,
      TK_OrderedSet = 32,
      TK_iterate = 84,
      TK_forAll = 85,
      TK_exists = 86,
      TK_isUnique = 87,
      TK_any = 88,
      TK_one = 89,
      TK_collect = 90,
      TK_select = 91,
      TK_reject = 92,
      TK_collectNested = 93,
      TK_sortedBy = 94,
      TK_closure = 95,
      TK_oclIsKindOf = 33,
      TK_oclIsTypeOf = 34,
      TK_oclAsType = 35,
      TK_oclIsNew = 36,
      TK_oclIsUndefined = 37,
      TK_oclIsInvalid = 38,
      TK_oclIsInState = 39,
      TK_allInstances = 40,
      TK_String = 5,
      TK_Integer = 6,
      TK_Real = 7,
      TK_Boolean = 8,
      TK_Tuple = 41,
      TK_OclAny = 9,
      TK_OclVoid = 10,
      TK_Invalid = 11,
      TK_OclMessage = 12,
      TK_null = 49,
      TK_OclInvalid = 50,
      TK_EOF_TOKEN = 62,
      TK_IDENTIFIER = 3,
      TK_INTEGER_RANGE_START = 63,
      TK_ERROR_TOKEN = 96;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "String", //$NON-NLS-1$
                 "Integer", //$NON-NLS-1$
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
                 "self", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
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
                 "BAR", //$NON-NLS-1$
                 "ATPRE", //$NON-NLS-1$
                 "context", //$NON-NLS-1$
                 "inv", //$NON-NLS-1$
                 "pre", //$NON-NLS-1$
                 "post", //$NON-NLS-1$
                 "body", //$NON-NLS-1$
                 "def", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "INTEGER_RANGE_START", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "derive", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "CARET", //$NON-NLS-1$
                 "CARETCARET", //$NON-NLS-1$
                 "package", //$NON-NLS-1$
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
