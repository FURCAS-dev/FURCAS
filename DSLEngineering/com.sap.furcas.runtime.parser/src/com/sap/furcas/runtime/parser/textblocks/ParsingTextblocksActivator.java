package com.sap.furcas.runtime.parser.textblocks;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ParsingTextblocksActivator extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.mi.textual.parsing.textblocks";

    // The shared instance
    /** The plugin. */
    private static ParsingTextblocksActivator plugin;

    private static boolean moinLoggingOn = System.getProperties().get("furcas.moin.logging") != null
            && ((String) System.getProperties().get("furcas.moin.logging")).equalsIgnoreCase("true");

    //    private ChangeListener moinListener = new ChangeListener() {
    //	    @Override
    //	    public void notify(ChangeEvent event) {
    //	        System.out.println(event); // TODO
    //	    }
    //        };

    private final Set<ResourceSet> loggingEnabledFor = new HashSet<ResourceSet>();

    /**
     * The constructor.
     */
    public ParsingTextblocksActivator() {
    }

    public synchronized void disableMoinLogging(ResourceSet connection) {
        if (moinLoggingOn) {
            if (isMoinLoggingEnabled(connection)) {
                //connection.getPackageRegistry().deregister(moinListener);
                loggingEnabledFor.remove(connection);
            }
        }
    }

    public void enableMoinLogging(ResourceSet connection) {
        if (moinLoggingOn) {
            if (!isMoinLoggingEnabled(connection)) {
                // connection.getPackageRegistry().registerListener(moinListener, new SessionFilter(connection.getSession()));
                loggingEnabledFor.add(connection);
            }
        }
    }

    public boolean isMoinLoggingEnabled(ResourceSet connection) {
        return loggingEnabledFor.contains(connection);
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
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
    public static ParsingTextblocksActivator getDefault() {
        return plugin;
    }


}
