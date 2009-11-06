package com.sap.mi.fwk.dcfwk.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class for plugin <code>com.sap.mi.fwk.dcfwk</code>
 * 
 * @author d031150
 */
public final class DcFwkPlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "com.sap.mi.fwk.dcfwk"; //$NON-NLS-1$

	private static DcFwkPlugin plugin;
	
	public DcFwkPlugin() {
		plugin = this;
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception { //$JL-EXC$
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static DcFwkPlugin getDefault() {
		return plugin;
	}

	public static void logError(Throwable e, Logger tracer) {
		logError(e.getMessage(), e, tracer);
	}
	
	public static void logError(String message, Throwable e, Logger tracer) {
		if (tracer != null)
			tracer.log(Level.SEVERE, message != null ? message : e.getMessage(), e);
		else
			getDefault().getLog().log(createStatus(IStatus.ERROR, message, e));
	}
	
	public static IStatus createStatus(int severity, String message, Throwable exception) {
		return createStatus(severity, 0, message, exception);
	}

	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		// create non-null message since status expects it
		if (message == null && exception != null)
			message = exception.getMessage();
		if (message == null)
			message = "An error occurred"; //$NON-NLS-1$
		IStatus status = new Status(
				severity, PLUGIN_ID, code, message, exception);
		return status;
	}
	
	public static IStatus showErrorDialog(Throwable e, String message, String title, Logger tracer) {
		IStatus status = createStatus(IStatus.ERROR, message, e);
		ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				title != null ? title : "Internal Error", status.getMessage(), null //$NON-NLS-1$
			 );
		return status;
	}

}
