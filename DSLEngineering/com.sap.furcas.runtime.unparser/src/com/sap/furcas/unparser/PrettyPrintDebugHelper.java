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
package com.sap.furcas.unparser;

import com.sap.furcas.unparser.PrettyPrintExceptions.SyntaxMismatchException;

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
