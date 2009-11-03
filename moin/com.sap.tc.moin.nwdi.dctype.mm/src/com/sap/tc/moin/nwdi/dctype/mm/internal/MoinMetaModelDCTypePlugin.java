package com.sap.tc.moin.nwdi.dctype.mm.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class MoinMetaModelDCTypePlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.sap.tc.moin.nwdi.dctype.mm";

	// The shared instance.
	private static MoinMetaModelDCTypePlugin plugin;

	/**
	 * The constructor.
	 */
	public MoinMetaModelDCTypePlugin() {
		plugin = this;
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception { // $JL-EXC$
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static MoinMetaModelDCTypePlugin getDefault() {
		return plugin;
	}
}
