package com.sap.ide.refactoring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "com.sap.ide.refactoring";
    private static Activator plugin;

    @Override
    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
	plugin = null;
	super.stop(context);
    }

    public static Activator getDefault() {
	return plugin;
    }

    public static void logError(Exception e) {
	logError(e, "");
    }

    /**
     * Log error.
     *
     * @param e
     *            the e
     */
    public static void logError(Exception e, String message) {
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
	msg = message + msg;
	if (getDefault() != null) {
	    getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e));
	} else {
	    System.out.println("Refactoring.logError: " + e.getMessage());
	    e.printStackTrace();
	}
    }

    /**
     * Prints the stack traces recursively.
     *
     * @param status
     *            the status
     */
    private static void printStackTracesRecursively(IStatus status) {
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
    private static String getMessagesRecursively(IStatus status) {
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
    public static void logWarning(Exception e) {
	String msg = e.getMessage();
	if (msg == null) {
	    msg = String.valueOf(e);
	}
	if (getDefault() != null) {
	    getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, IStatus.OK, msg, e));
	} else {
	    System.out.println("Refactoring.logWarning: " + e.getMessage());
	    e.printStackTrace();
	}
    }

    /**
     * Log warning.
     *
     * @param msg
     *            the msg
     */
    public static void logWarning(String msg) {
	if (msg != null) {
	    if (getDefault() != null) {
		getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, msg));
	    } else {
		System.out.println("Refactoring.logWarning: " + msg);
	    }

	}
    }

    /**
     * Log warning.
     *
     * @param msg
     *            the msg
     */
    public static void logError(String msg) {
	if (msg != null) {
	    if (getDefault() != null) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, new Exception("Dummy Exception")));
	    }
	} else {
	    System.out.println("Refactoring.logError: " + msg);
	}
    }

    /**
     * Log info.
     *
     * @param info
     *            the info
     */
    public static void logInfo(String info) {
	if (getDefault() != null) {
	    getDefault().getLog().log(new Status(IStatus.INFO, PLUGIN_ID, IStatus.OK, info, null));

	} else {
	    System.out.println("Refactoring.logInfo: " + info);
	}
    }
}
