/**
   * This file is generated for MOIN-OCL with LPG. 
   */

package com.sap.tc.moin.ocl.parser.gen;

public interface OclParserSymbols {
    public final static int
      TK_self = 1,
      TK_if = 2,
      TK_then = 3,
      TK_else = 4,
      TK_endif = 5,
      TK_and = 6,
      TK_or = 7,
      TK_xor = 8,
      TK_not = 9,
      TK_implies = 10,
      TK_let = 11,
      TK_in = 12,
      TK_true = 13,
      TK_false = 14,
      TK_Set = 15,
      TK_Bag = 16,
      TK_Sequence = 17,
      TK_Collection = 18,
      TK_OrderedSet = 19,
      TK_iterate = 20,
      TK_forAll = 21,
      TK_exists = 22,
      TK_isUnique = 23,
      TK_any = 24,
      TK_one = 25,
      TK_collect = 26,
      TK_select = 27,
      TK_reject = 28,
      TK_collectNested = 29,
      TK_sortedBy = 30,
      TK_oclIsKindOf = 31,
      TK_oclIsTypeOf = 32,
      TK_oclAsType = 33,
      TK_oclIsUndefined = 34,
      TK_oclIsInvalid = 35,
      TK_allInstances = 36,
      TK_String = 37,
      TK_Integer = 38,
      TK_Real = 39,
      TK_Float = 40,
      TK_Double = 41,
      TK_Boolean = 42,
      TK_Tuple = 43,
      TK_OclAny = 44,
      TK_OclVoid = 45,
      TK_OclInvalid = 46,
      TK_null = 47,
      TK_invalid = 48,
      TK_inv = 49,
      TK_pre = 50,
      TK_exp = 51,
      TK_post = 52,
      TK_body = 53,
      TK_context = 54,
      TK_package = 55,
      TK_endpackage = 56,
      TK_def = 57,
      TK_derive = 58,
      TK_init = 59,
      TK_EOF_TOKEN = 60,
      TK_IDENTIFIER = 61,
      TK_STRING_LITERAL = 62,
      TK_INTEGER_LITERAL = 63,
      TK_REAL_LITERAL = 64,
      TK_GREATER = 65,
      TK_LESS = 66,
      TK_EQUAL = 67,
      TK_GREATER_EQUAL = 68,
      TK_LESS_EQUAL = 69,
      TK_NOT_EQUAL = 70,
      TK_LPAREN = 71,
      TK_RPAREN = 72,
      TK_LBRACE = 73,
      TK_RBRACE = 74,
      TK_LBRACKET = 75,
      TK_RBRACKET = 76,
      TK_COMMA = 77,
      TK_COLON = 78,
      TK_COLONCOLON = 79,
      TK_DOT = 80,
      TK_EXCLAMATION = 81,
      TK_SHARP = 82,
      TK_PLUS = 83,
      TK_MINUS = 84,
      TK_MULTIPLY = 85,
      TK_DIVIDE = 86,
      TK_ARROW = 87,
      TK_DOTDOT = 88,
      TK_BAR = 89,
      TK_INTEGER_RANGE_START = 90,
      TK_ATPRE = 91,
      TK_SEMICOLON = 92;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
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
                 "oclIsKindOf", //$NON-NLS-1$
                 "oclIsTypeOf", //$NON-NLS-1$
                 "oclAsType", //$NON-NLS-1$
                 "oclIsUndefined", //$NON-NLS-1$
                 "oclIsInvalid", //$NON-NLS-1$
                 "allInstances", //$NON-NLS-1$
                 "String", //$NON-NLS-1$
                 "Integer", //$NON-NLS-1$
                 "Real", //$NON-NLS-1$
                 "Float", //$NON-NLS-1$
                 "Double", //$NON-NLS-1$
                 "Boolean", //$NON-NLS-1$
                 "Tuple", //$NON-NLS-1$
                 "OclAny", //$NON-NLS-1$
                 "OclVoid", //$NON-NLS-1$
                 "OclInvalid", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "invalid", //$NON-NLS-1$
                 "inv", //$NON-NLS-1$
                 "pre", //$NON-NLS-1$
                 "exp", //$NON-NLS-1$
                 "post", //$NON-NLS-1$
                 "body", //$NON-NLS-1$
                 "context", //$NON-NLS-1$
                 "package", //$NON-NLS-1$
                 "endpackage", //$NON-NLS-1$
                 "def", //$NON-NLS-1$
                 "derive", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "COMMA", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "EXCLAMATION", //$NON-NLS-1$
                 "SHARP", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "INTEGER_RANGE_START", //$NON-NLS-1$
                 "ATPRE", //$NON-NLS-1$
                 "SEMICOLON" //$NON-NLS-1$
             };


    public final static boolean isValidForParser = false;
}
