package com.sap.furcas.utils.exceptions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class StatusLogger {

    private final AbstractUIPlugin plugin;
    private final String pluginId;

    public StatusLogger(AbstractUIPlugin plugin, String pluginId) {
	this.plugin = plugin;
	this.pluginId = pluginId;
    }

    /**
     * Log error.
     */
    public void logError(String message, Exception e) {
	String msg;
	if (e instanceof CoreException) {
	    IStatus status = ((CoreException) e).getStatus();
	    msg = getMessagesRecursively(status);
	} else {
	    msg = e.getMessage();
	}

	e.printStackTrace();
	if (e instanceof CoreException) {
	    IStatus status = ((CoreException) e).getStatus();
	    printStackTracesRecursively(status);
	}
	if (msg == null) {
	    msg = String.valueOf(e);
	}
	msg = message + ":\n" + msg;
	plugin.getLog().log(new Status(IStatus.ERROR, pluginId, IStatus.OK, msg, e));
    }

    /**
     * Log error.
     * 
     * @param msg
     *            the msg
     */
    public void logError(String msg) {
	if (msg != null) {
	    plugin.getLog().log(new Status(IStatus.ERROR, pluginId, msg, new Exception("Dummy Exception")));
	}
    }

    /**
     * Prints the stack traces recursively.
     * 
     * @param status
     *            the status
     */
    private void printStackTracesRecursively(IStatus status) {
	if (status.getException() != null) {
	    System.err.println("Child Exception:" + '\n');
	    status.getException().printStackTrace();
	}
	IStatus[] children = status.getChildren();
	for (int i = 0; i < children.length; i++) {
	    IStatus childstatus = children[i];
	    printStackTracesRecursively(childstatus);
	}
    }

    /**
     * Gets the messages recursively.
     * 
     * @param status
     *            the status
     * 
     * @return the messages recursively
     */
    private String getMessagesRecursively(IStatus status) {
	String message = status.getMessage();
	IStatus[] children = status.getChildren();
	for (int i = 0; i < children.length; i++) {
	    IStatus childstatus = children[i];
	    message += '\n' + getMessagesRecursively(childstatus);
	}
	return message;
    }

    /**
     * Log warning.
     * 
     * @param e
     *            the e
     */
    public void logWarning(String message, Exception e) {
	String msg = e.getMessage();
	if (msg == null) {
	    msg = String.valueOf(e);
	}
	msg = message + ":\n" + msg;
	plugin.getLog().log(new Status(IStatus.WARNING, pluginId, IStatus.OK, msg, e));
    }

    /**
     * Log warning.
     * 
     * @param msg
     *            the msg
     */
    public void logWarning(String msg) {
	if (msg != null) {
	    plugin.getLog().log(new Status(IStatus.WARNING, pluginId, msg));
	}
    }

    /**
     * Log info.
     * 
     * @param info
     *            the info
     */
    public void logInfo(String info) {
	plugin.getLog().log(new Status(IStatus.INFO, pluginId, IStatus.OK, info, null));
    }

    /**
     * Display error.
     * 
     * @param message
     *            the message
     */
    public void displayError(String message) {
	ErrorDialog.openError(plugin.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error in SyntaxGeneration Plugin",
		message, EclipseExceptionHelper.getErrorStatus(message, pluginId));
    }
}
