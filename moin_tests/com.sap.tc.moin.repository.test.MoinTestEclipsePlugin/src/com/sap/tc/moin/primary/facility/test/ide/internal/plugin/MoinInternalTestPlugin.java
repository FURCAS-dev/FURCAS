package com.sap.tc.moin.primary.facility.test.ide.internal.plugin;


import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The main-class of the plugin. It is mostly used to acces the 'environment' of
 * this plugin.
 */
public class MoinInternalTestPlugin extends AbstractUIPlugin {

    // The shared instance of the plugin:
    private static MoinInternalTestPlugin plugin;

    public static final String PLUGIN_ID = "com.sap.tc.moin.facility.primary.internal";

    /**
     * Creates the Plugin and caches its default instance.
     */
    public MoinInternalTestPlugin( ) {

        plugin = this;
        // todo: resource bundle handling needed ?
    }

    /**
     * This method is called upon plug-in activation
     */
    @Override
    public void start( BundleContext context ) throws Exception {

        super.start( context );
    }

    /**
     * This method is called when the plug-in is stopped
     */
    @Override
    public void stop( BundleContext context ) throws Exception {

        super.stop( context );
    }

    /**
     * Gets the default-instance of this plugin. Actually the default-instance
     * should always be the only instance -> Singleton.
     */
    public static MoinInternalTestPlugin getDefault( ) {

        return plugin;
    }

}