package com.sap.mi.fwk.test.service.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.sap.mi.fwk.services.local.ErrorHandling;
import com.tssap.util.trace.TracerI;

/**
 * The framework plugin class
 * 
 * @author d031150
 */
public final class TestServiceUiPlugin extends Plugin {

	public static final String PLUGIN_ID = "com.sap.mi.fwk.test.service.core"; //$NON-NLS-1$

	private static TestServiceUiPlugin sInstance;

	public TestServiceUiPlugin() {
		sInstance = this;
	}

	public static TestServiceUiPlugin getDefault() {
		return sInstance;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		sInstance = null;
		super.stop(context);
	}

	public static void logError(Throwable e, TracerI tracer) {
		logError(e.getMessage(), e, tracer);
	}

	public static void logError(String message, Throwable e, TracerI tracer) {
		ErrorHandling.logError(message, e, tracer, PLUGIN_ID);
	}

	public static void logStatus(IStatus status, TracerI tracer) {
		ErrorHandling.logStatus(status, tracer, PLUGIN_ID);
	}
	
	public static IStatus createStatus(int severity, String message, Throwable exception) {
		return createStatus(severity, 0, message, exception);
	}

	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return ErrorHandling.createStatus(severity, code, message, exception, PLUGIN_ID);
	}

}
