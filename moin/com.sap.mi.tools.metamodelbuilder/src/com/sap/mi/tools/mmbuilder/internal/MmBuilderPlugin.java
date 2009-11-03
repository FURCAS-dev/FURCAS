package com.sap.mi.tools.mmbuilder.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The plugin activator
 */
public final class MmBuilderPlugin extends Plugin {

	private static MmBuilderPlugin sPlugin;

	public MmBuilderPlugin() {
		sPlugin = this;
	}

	public static MmBuilderPlugin getDefault() {
		return sPlugin;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		sPlugin = null;
		super.stop(context);
	}
}
