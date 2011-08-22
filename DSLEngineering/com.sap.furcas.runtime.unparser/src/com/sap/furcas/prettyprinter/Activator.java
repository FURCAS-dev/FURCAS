package com.sap.furcas.prettyprinter;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.sap.furcas.utils.exceptions.StatusLogger;


public class Activator extends Plugin {

    public static final String PLUGIN_ID = "com.sap.furcas.prettyprinter";

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
    
    public static Activator getDefault() {
        return plugin;
    }

}
