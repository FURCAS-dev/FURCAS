/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.ide.cts.editor.prettyprint.imported;


public class PrettyPrintConstants {
    
    /**
     * Debug serialization
     */
    public final static boolean DEBUG_SERIALIZATION = false;

    /**
     * Debug whitspace printouts
     */
    public final static boolean DEBUG_WHITESPACES = false;
    
    /**
     * Print complete output stream also to console
     */
    public static boolean DEBUG_STREAM_CONSOLE_DUMP = false;
    
    /**
     * Print caught property init exceptions.
     * This indicates either backtracking or ignoring of partial properties
     */
    public static boolean DEBUG_BACKTRACKING = true;

    
    
    public final static boolean KEYWORDS_CHECK_IGNORE_CASE = false;
    public final static boolean SERIALIZE_COMMENTS = false;

    public final static String IDENTIFIER_ESCAPING_END = "\"";
    public final static String IDENTIFIER_ESCAPING_START = "\"";
    
    public final static String STRING_DELIMITER = "\"";
    public final static String DEFAULT_SEPARATOR = " ";
    public final static String INDENTATION_PRIMITIVE = "  ";
    public final static String LINE_FEED = "\n";
    

    
    public final static int SYMBOL_LEFT_NONE = 64;
    public final static int SYMBOL_LEFT_SPACE = 16;
    public final static int SYMBOL_RIGHT_NONE = 128;
    public final static int SYMBOL_RIGHT_SPACE = 32; 
    public final static int SYMBOL_BOTH_SPACE = SYMBOL_LEFT_SPACE + SYMBOL_RIGHT_SPACE;

    public final static int TYPE_SYMBOL = 2;
    
    public final static int TYPE_BOOL = 4;
    public final static int TYPE_COMMENT = 9;
    public final static int TYPE_IDENT = 3;
    public final static int TYPE_INT = 5;
    public final static int TYPE_KEYWORD = 1;
    public final static int TYPE_REAL = 6;
    public final static int TYPE_SPACE = 8;
    public final static int TYPE_STRING = 7;

    
}
