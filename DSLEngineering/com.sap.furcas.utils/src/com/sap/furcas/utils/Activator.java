package com.sap.furcas.utils;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.furcas.utils.exceptions.StatusLogger;


public class Activator extends AbstractUIPlugin {

    private static Activator plugin;
    public static final String PLUGIN_ID = "TextualSyntaxGeneratorPlugin";
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

    public static Activator getDefault() {
	return plugin;
    }

    public static ImageDescriptor getImageDescriptor(String path) {
	return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

}
