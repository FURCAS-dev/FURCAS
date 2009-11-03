package com.sap.tc.moin.incubation.mm.internal;

import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.tc.logging.Location;
import com.sap.tc.logging.Severity;

public final class Activator extends AbstractUIPlugin {

	public static final String ID = "com.sap.tc.moin.incubation.mm";

	private static Activator plugin;

	public Activator() {
		plugin = this;
	}

	public static Activator getDefault() {
		return plugin;
	}

	public URL getInstallURL() {
		return getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static void error(String message, Throwable e, Location location) {
		if (message == null && e != null) {
			message = e.getMessage();
		}
		if (message == null && e != null) {
			message = e.getClass().getName();
		}
		if (message == null) {
			message = "An error occurred";
		}
		if (location != null) {
			if (e != null) {
				location.logT(Severity.ERROR, message, new Object[] { e });
			} else {
				location.logT(Severity.ERROR, message);
			}
		} else {
			IStatus status = new Status(IStatus.ERROR, ID, message, e);
			getDefault().getLog().log(status);
		}
	}

}
