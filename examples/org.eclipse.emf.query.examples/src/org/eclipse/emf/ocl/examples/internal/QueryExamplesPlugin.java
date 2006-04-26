package org.eclipse.emf.ocl.examples.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;


public class QueryExamplesPlugin
	extends AbstractUIPlugin {

	// The shared instance.
	private static QueryExamplesPlugin plugin;
	
	public QueryExamplesPlugin() {
		super();
		plugin = this;
	}
	
	/**
	 * Returns the shared instance.
	 */
	public static QueryExamplesPlugin getDefault() {
		return plugin;
	}
}
