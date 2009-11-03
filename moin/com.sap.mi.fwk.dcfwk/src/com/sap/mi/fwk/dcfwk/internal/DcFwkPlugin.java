package com.sap.mi.fwk.dcfwk.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.tssap.util.trace.TracerI;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

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

	public static void logError(Throwable e, TracerI tracer) {
		logError(e.getMessage(), e, tracer);
	}
	
	public static void logError(String message, Throwable e, TracerI tracer) {
		if (tracer != null)
			tracer.error(message != null ? message : e.getMessage(), e);
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
	
	public static IStatus showErrorDialog(Throwable e, String message, String title, TracerI tracer) {
		IStatus status = createStatus(IStatus.ERROR, message, e);
		ExtendedMessageDialog.showStatus(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				title != null ? title : "Internal Error", status.getMessage(), null, //$NON-NLS-1$
				new String[] { IDialogConstants.OK_LABEL }, status);
		return status;
	}

}
