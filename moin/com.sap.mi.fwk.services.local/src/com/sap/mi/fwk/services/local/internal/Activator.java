package com.sap.mi.fwk.services.local.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.BundleContext;

import com.sap.mi.fwk.services.local.ErrorHandling;

public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sap.mi.fwk.services.local";//$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static void logError(Throwable e, Logger tracer) {
		if (e instanceof InvocationTargetException)
			e = e.getCause();
		ErrorHandling.logError(null, e, tracer, PLUGIN_ID);
	}
	
	public static IStatus createStatus(int severity, String message, Throwable exception) {
		return createStatus(severity, 0, message, exception);
	}

	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return ErrorHandling.createStatus(severity, code, message, exception, PLUGIN_ID);
	}

//	public static Image getSharedImage(IImageKey imgKey) {
//    	IImagePool pool = SapUI.getImageServices().getGlobalImagePool();
//    	return pool.getImage(imgKey);
//    }

}
