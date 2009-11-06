package com.sap.mi.fwk.services.local;

import java.awt.Dialog;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import com.sap.mi.fwk.services.local.internal.Activator;
import com.sap.mi.fwk.services.local.internal.MiLocations;

/**
 * Utility for some error handling actions like raising error dialogs or logging
 * 
 * @author d031150
 * 
 */
public final class ErrorHandling {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MIE);

	/**
	 * Raises a dialog for the given status if called from the UI thread.
	 * Additionally the status is logged either using the given tracer or with
	 * the {@link ILog Platform log}.
	 * 
	 * @param status
	 *            the status to log
	 * @param title
	 *            a title for the dialog or <code>null</code>
	 * @param tracer
	 *            a tracer to log into or <code>null</code>
	 * @param pluginId
	 *            the id of the plugin where the error occurred
	 * @return the status for convenience
	 * 
	 * @see #logStatus(IStatus, Logger, String)
	 */
	public static IStatus showStatus(IStatus status, String title, Logger tracer, String pluginId) {
		logStatus(status, tracer, pluginId);
		if (Display.getCurrent() != null) {
		    Shell shell = Display.getCurrent().getActiveShell();
		    title = (title != null) ? title
                            : "Internal Error"; //$NON-NLS-1$
		    String message = status.getMessage();
		    int sev = status.getSeverity();
	                if (sev == IStatus.CANCEL) {
	                    MessageDialog.openInformation(shell, title, message);
	                }
	                if (sev == IStatus.ERROR){
	                    ErrorDialog.openError(shell, title, message, status);
	                }
	                if (sev == IStatus.INFO){
	                    MessageDialog.openInformation(shell, title, message);
	                }
	                if (sev == IStatus.OK){
	                    MessageDialog.openInformation(shell, title, message);
	                }
	                if (sev == IStatus.WARNING){
	                    MessageDialog.openWarning(shell, title, message);
	                }			
		}
		return status;
	}

	/**
	 * Raises a dialog for the given error details. Additionally the data is
	 * logged either using the given tracer or with the
	 * {@link ILog Platform log}.
	 * 
	 * @param message
	 *            the message to log
	 * @param exception
	 *            the exception to log or <code>null</code>
	 * @param title
	 *            a title for the dialog or <code>null</code>
	 * @param tracer
	 *            a tracer to log into or <code>null</code>
	 * @param pluginId
	 *            the id of the plugin where the error occurred
	 * @return the status for convenience
	 * 
	 * @see #showStatus(IStatus, String, Logger, String)
	 */
	public static IStatus showError(String message, Throwable exception, String title, Logger tracer, String pluginId) {
		IStatus status = createStatus(IStatus.ERROR, 0, message, exception, pluginId);
		return showStatus(status, title, tracer, pluginId);
	}

	/**
	 * Logs the given status either using the given tracer or with the
	 * {@link ILog Platform log}.
	 * 
	 * @param status
	 *            the status to log
	 * @param tracer
	 *            a tracer to log into or <code>null</code>
	 * @param pluginId
	 *            the id of the plugin where the error occurred
	 * 
	 * @see #showStatus(IStatus, String, Logger, String)
	 */
	public static void logStatus(IStatus status, Logger tracer, String pluginId) {
		if (tracer == null) {
			Bundle bundle = Platform.getBundle(pluginId);
			if (bundle == null) {
				IllegalArgumentException e = new IllegalArgumentException("No such plugin: " + pluginId); //$NON-NLS-1$
				Activator.logError(e, sTracer);
				// use own bundle as fallback
				bundle = Activator.getDefault().getBundle();
			}
			Platform.getLog(bundle).log(status);
		} else {
			String message = status.getMessage();
			switch (status.getSeverity()) {
				case IStatus.ERROR:
					tracer.log(Level.SEVERE, message, status.getException());
					break;
				case IStatus.WARNING:
					tracer.log(Level.WARNING, message, status.getException());
					break;
				default:
					tracer.info(message);
					break;
			}
		}

		// SAP tracing does not provide a distinct logging for MultiStatus,
		// if such a logging is requested, unwrap them, otherwise inner
		// exception traces would get lost.
		if (status.isMultiStatus()) {
			IStatus[] children = status.getChildren();
			for (IStatus childStatus : children)
				logStatus(childStatus, tracer, pluginId);
		}
	}

	/**
	 * Logs the given error details either using the given tracer or with the
	 * {@link ILog Platform log}.
	 * 
	 * @param message
	 *            the message to log
	 * @param exception
	 *            the exception to log or <code>null</code>
	 * @param tracer
	 *            a tracer to log into or <code>null</code>
	 * @param pluginId
	 *            the id of the plugin where the error occurred
	 * 
	 * @see #showStatus(IStatus, String, Logger, String)
	 */
	public static void logError(String message, Throwable exception, Logger tracer, String pluginId) {
		IStatus status = createStatus(IStatus.ERROR, 0, message, exception, pluginId);
		logStatus(status, tracer, pluginId);
	}

	/**
	 * Creates a status object out of the given details ensuring that its
	 * message is never <code>null</code> (which would cause an exception).
	 * 
	 * @return the status
	 * 
	 * @see Status#Status(int, String, int, String, Throwable)
	 */
	public static IStatus createStatus(int severity, int code, String message, Throwable exception, String pluginId) {
		if (message == null && exception != null)
			message = exception.getMessage();
		if (message == null)
			message = "An error occured";//$NON-NLS-1$
		if (pluginId == null || pluginId.length() == 0)
			pluginId = "<Unknown plugin>";//$NON-NLS-1$
		IStatus status = new Status(severity, pluginId, code, message, exception);
		return status;
	}

}
