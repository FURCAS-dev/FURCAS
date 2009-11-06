package com.sap.mi.fwk.test.service.internal;

import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.sap.mi.fwk.services.local.ErrorHandling;

/**
 * The framework plugin class
 * 
 * @author d031150
 */
public final class TestServicePlugin extends Plugin {

	public static final String PLUGIN_ID = "com.sap.mi.fwk.test.service"; //$NON-NLS-1$

	private static TestServicePlugin sInstance;

	public TestServicePlugin() {
		sInstance = this;
	}

	public static TestServicePlugin getDefault() {
		return sInstance;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		sInstance = null;
		super.stop(context);
	}

	public static void logError(Throwable e, Logger tracer) {
		logError(e.getMessage(), e, tracer);
	}

	public static void logError(String message, Throwable e, Logger tracer) {
		ErrorHandling.logError(message, e, tracer, PLUGIN_ID);
	}

	public static void logStatus(IStatus status, Logger tracer) {
		ErrorHandling.logStatus(status, tracer, PLUGIN_ID);
	}

	public static IStatus createStatus(int severity, String message, Throwable exception) {
		return createStatus(severity, 0, message, exception);
	}

	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return ErrorHandling.createStatus(severity, code, message, exception, PLUGIN_ID);
	}

}
