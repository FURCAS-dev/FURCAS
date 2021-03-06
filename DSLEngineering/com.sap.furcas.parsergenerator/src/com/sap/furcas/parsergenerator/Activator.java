package com.sap.furcas.parsergenerator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.furcas.utils.exceptions.StatusLogger;

public class Activator extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "DSLParserGeneratorPlugin";

    private static Activator plugin;
    public static StatusLogger logger;

    @Override
    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
	logger = new StatusLogger(this, PLUGIN_ID);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
	plugin = null;
	super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
	return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path.
     * 
     * @param path
     *            the path
     * 
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
	return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

}
