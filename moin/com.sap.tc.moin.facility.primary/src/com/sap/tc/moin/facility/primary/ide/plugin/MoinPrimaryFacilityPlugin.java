package com.sap.tc.moin.facility.primary.ide.plugin;


import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The main-class of the plugin. It is mostly used to acces the 'environment' of
 * this plugin.
 */
public class MoinPrimaryFacilityPlugin extends AbstractUIPlugin {

    // The shared instance of the plugin:
    private static MoinPrimaryFacilityPlugin plugin;

    /**
     * ID of the primary facility plugin.
     * <code>PLUGIN_ID = "com.sap.tc.moin.facility.primary".</code>
     */
    public static final String PLUGIN_ID = "com.sap.tc.moin.facility.primary"; //$NON-NLS-1$

    /**
     * Creates the Plugin and caches its default instance.
     */
    public MoinPrimaryFacilityPlugin( ) {

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
     * 
     * @return The singleton default-instance of the primary facility plugin
     */
    public static MoinPrimaryFacilityPlugin getDefault( ) {

        return plugin;
    }

}