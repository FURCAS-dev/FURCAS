package com.sap.tc.moin.repository.performance.test;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class MoinTestPerformanceEclipsePlugin extends AbstractUIPlugin {

    // The shared instance.
    private static MoinTestPerformanceEclipsePlugin plugin;

    // Resource bundle.
    private ResourceBundle resourceBundle;

    /**
     * The constructor.
     */
    public MoinTestPerformanceEclipsePlugin( ) {

        super( );
        plugin = this;
        try {
            resourceBundle = ResourceBundle.getBundle( "com.sap.tc.moin.repository.test.eclipse.plugin.Resources" );
        } catch ( MissingResourceException x ) {
            resourceBundle = null;
        }
    }

    /**
     * This method is called upon plug-in activation
     */
    public void start( BundleContext context ) throws Exception {

        super.start( context );
    }

    /**
     * This method is called when the plug-in is stopped
     */
    public void stop( BundleContext context ) throws Exception {

        super.stop( context );
    }

    /**
     * Returns the shared instance.
     */
    public static MoinTestPerformanceEclipsePlugin getDefault( ) {

        return plugin;
    }

    /**
     * Returns the string from the plugin's resource bundle, or 'key' if not
     * found.
     */
    public static String getResourceString( String key ) {

        ResourceBundle bundle = MoinTestPerformanceEclipsePlugin.getDefault( ).getResourceBundle( );
        try {
            return ( bundle != null ) ? bundle.getString( key ) : key;
        } catch ( MissingResourceException e ) {
            return key;
        }
    }

    /**
     * Returns the plugin's resource bundle,
     */
    public ResourceBundle getResourceBundle( ) {

        return resourceBundle;
    }
}
