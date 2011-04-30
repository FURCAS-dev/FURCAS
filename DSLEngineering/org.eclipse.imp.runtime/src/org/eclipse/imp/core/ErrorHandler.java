/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.core;

import org.eclipse.imp.preferences.PreferenceCache;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 2005  All Rights Reserved
 */
/**
 * Utility class for internal error messages
 * 
 * @author Claffra
 */
public class ErrorHandler {
    private static final boolean PRINT= true;
    private static final boolean DUMP= true;
    private static final boolean LOG= true;

    public static void reportError(String message, Throwable e) {
    	if (message == null)
    		message = "No message given";
    	reportError(message, false, e);
    }

    public static void reportError(String message, boolean showDialog, Throwable e) {
	    if (message == null)
	    		message = "No message given";
		if (PRINT)
		    System.err.println(message);
		if (DUMP)
		    e.printStackTrace();
		if (LOG)
		    logError(message, e);
		if (showDialog)
		    MessageDialog.openError(null, "IMP Error", message);
    }

    public static void reportError(String message) {
    	if (message == null)
    		message = "No message given";
    	reportError(message, false);
    }

    public static void reportError(String message, boolean showDialog) {
    	if (message == null)
    		message = "No message given";
    	reportError(message, showDialog, DUMP);
    }

    public static void reportError(final String message, boolean showDialog, boolean noDump) {
    	final String checkedMessage = message != null ? message : "No message given"; 
		if (PRINT)
		    System.err.println(checkedMessage);
		if (!noDump)
		    new Error(checkedMessage).printStackTrace();
		if (LOG || PreferenceCache.emitMessages)
		    logError(checkedMessage, new Error(checkedMessage));
		if (showDialog) {
		    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
			    MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "IMP Error", checkedMessage);
			}
		    });
		}
    }

    public static void logError(String msg, Throwable e) {
    	if (msg == null)
    		msg = "No message given";
    	RuntimePlugin.getInstance().logException(msg, e);
    }

    public static void logMessage(String msg, Throwable e) {
    	if (msg == null)
    		msg = "No message given";
    	RuntimePlugin.getInstance().logException(msg, e);
    }
}
