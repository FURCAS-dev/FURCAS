package com.sap.ide.cts.editor.prettyprint.imported;

import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintExceptions.SyntaxMismatchException;

public class PrettyPrintDebugHelper {
    
    public static void debug(String msg) {
	if (PrettyPrintConstants.DEBUG_SERIALIZATION) {
	    System.out.println(msg);
	}
    }
    
    public static void debugWhiteSpace(String msg) {
	if (PrettyPrintConstants.DEBUG_WHITESPACES) {
	    System.out.println(msg);
	}
    }
    
    public static void debugPropertyInitException(SyntaxMismatchException e) {
	debugPropertyInitException(e.getMessage());
    }
    
    public static void debugPropertyInitException(String message) {
	if (PrettyPrintConstants.DEBUG_BACKTRACKING) {
	    System.out.println(message);
	}	
    }
}
