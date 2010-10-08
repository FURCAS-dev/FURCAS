package com.sap.furcas.utils.exceptions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

/**
 * The Class ExceptionHelper.
 */
public class EclipseExceptionHelper {

    /**
     * Instantiates a new exception helper.
     */
    private EclipseExceptionHelper() {
    }

    /**
     * Gets the error status.
     * 
     * @param message
     *            the message
     * 
     * @return the error status
     */
    public static IStatus getErrorStatus(String message, String pluginId) {
	return new Status(Status.ERROR, pluginId, message);
    }

    /**
     * Gets the error status.
     * 
     * @param message
     *            the message
     * 
     * @return the error status
     */
    public static IStatus getWarningStatus(String message, String pluginId) {
	return new Status(Status.WARNING, pluginId, message);
    }

    /**
     * @param e
     * 
     * @return
     */
    public static IStatus getErrorStatus(Throwable e, String pluginId) {
	IStatus status;
	Throwable cause = e.getCause();
	if (cause == null) {
	    status = new Status(Status.ERROR, pluginId, e.getMessage(), e);
	} else {
	    IStatus[] children = new IStatus[1];
	    children[0] = getErrorStatus(cause, pluginId);
	    status = new MultiStatus(pluginId, Status.ERROR, children, e.getMessage(), e);
	}

	return status;
    }
}
