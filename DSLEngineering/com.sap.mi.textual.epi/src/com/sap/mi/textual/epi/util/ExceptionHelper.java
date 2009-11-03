package com.sap.mi.textual.epi.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.sap.mi.textual.epi.Activator;


/**
 * The Class ExceptionHelper.
 */
public class ExceptionHelper {

	
	/**
	 * Instantiates a new exception helper.
	 */
	private ExceptionHelper() {}
	
	/**
	 * Gets the error status.
	 * 
	 * @param message the message
	 * 
	 * @return the error status
	 */
	public static IStatus getErrorStatus(String message) {
		return new Status(Status.ERROR, Activator.PLUGIN_ID, message);
	}
	
	/**
     * Gets the error status.
     * 
     * @param message the message
     * 
     * @return the error status
     */
    public static IStatus getWarningStatus(String message) {
        return new Status(Status.WARNING, Activator.PLUGIN_ID, message);
    }

    /**
     * @param e
     * 
     * @return
     */
    public static IStatus getErrorStatus(Throwable e) {
        IStatus status;
        Throwable cause = e.getCause();
        if (cause == null) {
            status = new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
        } else {
            IStatus[] children = new IStatus[1];
            children[0] = getErrorStatus(cause);
            status = new MultiStatus(Activator.PLUGIN_ID, Status.ERROR, children, e.getMessage(), e);
        }
        
        return status;
    }
}
