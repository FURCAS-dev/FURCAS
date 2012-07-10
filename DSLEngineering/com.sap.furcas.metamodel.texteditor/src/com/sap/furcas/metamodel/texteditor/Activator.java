package com.sap.furcas.metamodel.texteditor; 

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.furcas.utils.exceptions.StatusLogger;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "com.sap.furcas.metamodel.texteditor"; //NON-NLS-1
    private static Activator plugin;
    private StatusLogger logger;
    

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

    public StatusLogger getLogger() {
        return logger;
    }

}
