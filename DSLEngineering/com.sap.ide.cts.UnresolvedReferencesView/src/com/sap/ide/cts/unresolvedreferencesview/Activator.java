package com.sap.ide.cts.unresolvedreferencesview;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    private static final String PLUGIN_ID_PARSING_TEXTBLOCKS = "com.sap.mi.textual.parsing.textblocks";

    private static final String PLUGIN_ID_GLOBALMODELLISTENER = "com.sap.tc.moin.globalmodellistener";

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.ide.cts.UnresolvedReferencesView";

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
	ensurePluginLoaded(context, PLUGIN_ID_GLOBALMODELLISTENER);
	ensurePluginLoaded(context, PLUGIN_ID_PARSING_TEXTBLOCKS);
    }

    private void ensurePluginLoaded(BundleContext context, String bundleName) {
	for (Bundle b : context.getBundles()) {
	    if (b.getSymbolicName() != null
		    && b.getSymbolicName().equals(bundleName)) {
		if (b.getState() != Bundle.ACTIVE) {
		    try {
			b.start();
		    } catch (BundleException e) {
			throw new RuntimeException("OSGi failure", e);
		    }
		}
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
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

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
	return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
}
