package org.eclipse.emf.ocl.examples.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;


public class OCLExamplesPlugin
	extends AbstractUIPlugin {

	// The shared instance.
	private static OCLExamplesPlugin plugin;
	
	public OCLExamplesPlugin() {
		super();
		plugin = this;
	}
	
	/**
	 * Returns the shared instance.
	 */
	public static OCLExamplesPlugin getDefault() {
		return plugin;
	}
}
