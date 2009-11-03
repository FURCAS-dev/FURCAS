/**
   * This file is generated for MOIN-OCL with LPG. 
   */

package com.sap.tc.moin.ocl.parser.gen;

public interface OclParserGensym {
    public final static int
      TK_STRING_LITERAL = 39,
      TK_INTEGER_LITERAL = 40,
      TK_REAL_LITERAL = 41,
      TK_GREATER = 5,
      TK_LESS = 6,
      TK_EQUAL = 2,
      TK_GREATER_EQUAL = 7,
      TK_LESS_EQUAL = 8,
      TK_NOT_EQUAL = 9,
      TK_LPAREN = 1,
      TK_RPAREN = 3,
      TK_LBRACE = 62,
      TK_RBRACE = 63,
      TK_LBRACKET = 67,
      TK_RBRACKET = 68,
      TK_COMMA = 48,
      TK_COLON = 10,
      TK_COLONCOLON = 52,
      TK_DOT = 69,
      TK_EXCLAMATION = 92,
      TK_SHARP = 64,
      TK_INTEGER_RANGE_START = 65,
      TK_PLUS = 16,
      TK_MINUS = 23,
      TK_MULTIPLY = 11,
      TK_DIVIDE = 12,
      TK_ARROW = 70,
      TK_DOTDOT = 71,
      TK_BAR = 50,
      TK_ATPRE = 72,
      TK_SEMICOLON = 73,
      TK_self = 42,
      TK_if = 49,
      TK_then = 74,
      TK_else = 75,
      TK_endif = 76,
      TK_and = 13,
      TK_or = 14,
      TK_xor = 15,
      TK_not = 43,
      TK_implies = 77,
      TK_let = 51,
      TK_in = 78,
      TK_true = 44,
      TK_false = 45,
      TK_Set = 24,
      TK_Bag = 25,
      TK_Sequence = 26,
      TK_Collection = 27,
      TK_OrderedSet = 28,
      TK_iterate = 79,
      TK_forAll = 80,
      TK_exists = 81,
      TK_isUnique = 82,
      TK_any = 83,
      TK_one = 84,
      TK_collect = 85,
      TK_select = 86,
      TK_reject = 87,
      TK_collectNested = 88,
      TK_sortedBy = 89,
      TK_oclIsKindOf = 17,
      TK_oclIsTypeOf = 18,
      TK_oclAsType = 19,
      TK_oclIsUndefined = 20,
      TK_oclIsInvalid = 21,
      TK_allInstances = 22,
      TK_String = 29,
      TK_Integer = 30,
      TK_Real = 31,
      TK_Float = 32,
      TK_Double = 33,
      TK_Boolean = 34,
      TK_Tuple = 35,
      TK_OclAny = 36,
      TK_OclVoid = 37,
      TK_OclInvalid = 38,
      TK_null = 46,
      TK_invalid = 47,
      TK_inv = 54,
      TK_pre = 55,
      TK_exp = 56,
      TK_post = 57,
      TK_body = 58,
      TK_context = 53,
      TK_package = 66,
      TK_endpackage = 90,
      TK_def = 59,
      TK_derive = 60,
      TK_init = 61,
      TK_EOF_TOKEN = 91,
      TK_IDENTIFIER = 4,
      TK_ERROR_TOKEN = 93;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "oclIsKindOf", //$NON-NLS-1$
                 "oclIsTypeOf", //$NON-NLS-1$
                 "oclAsType", //$NON-NLS-1$
                 "oclIsUndefined", //$NON-NLS-1$
                 "oclIsInvalid", //$NON-NLS-1$
                 "allInstances", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
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
                 "STRING_LITERAL", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "invalid", //$NON-NLS-1$
                 "COMMA", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "context", //$NON-NLS-1$
                 "inv", //$NON-NLS-1$
                 "pre", //$NON-NLS-1$
                 "exp", //$NON-NLS-1$
                 "post", //$NON-NLS-1$
                 "body", //$NON-NLS-1$
                 "def", //$NON-NLS-1$
                 "derive", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "SHARP", //$NON-NLS-1$
                 "INTEGER_RANGE_START", //$NON-NLS-1$
                 "package", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "ATPRE", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
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
                 "endpackage", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "EXCLAMATION", //$NON-NLS-1$
                 "ERROR_TOKEN" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
