package com.sap.tc.moin.nwdi.dctype.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class MoinDCTypePlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "com.sap.tc.moin.nwdi.dctype"; //$NON-NLS-1$

	//The shared instance.
	private static MoinDCTypePlugin plugin;
	
	/**
	 * The constructor.
	 */
	public MoinDCTypePlugin() {
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
	public static MoinDCTypePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("MoinDCType", path); //$NON-NLS-1$
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

}
