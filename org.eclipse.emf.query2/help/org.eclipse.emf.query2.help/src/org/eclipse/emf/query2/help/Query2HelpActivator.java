package org.eclipse.emf.query2.help;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Query2HelpActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.query2.help"; //$NON-NLS-1$

	// The shared instance
	private static Query2HelpActivator plugin;
	
	/**
	 * The constructor
	 */
	public Query2HelpActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Query2HelpActivator getDefault() {
		return plugin;
	}

}
