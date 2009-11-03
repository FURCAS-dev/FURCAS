package com.sap.river.expressionpad;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.river.expressionpad";

    // The shared instance
    private static Activator plugin;

    private static ServiceReference globalEventListenerRegistryRef;
    
    private static BundleContext context;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
	Activator.context = context;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
     * Returns an image descriptor for the image file at the given plug-in relative path
     * 
     * @param path
     *                the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
	return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    public static GlobalEventListenerRegistry getGlobalEventListenerRegistry() {
	if (getGlobalEventListenerRegistryRef() != null) {
	    return (GlobalEventListenerRegistry) context.getService(getGlobalEventListenerRegistryRef());
	} else {
	    return null;
	}
    }

    private static void setGlobalEventListenerRegistryRef(ServiceReference globalEventListenerRegistryRef) {
	Activator.globalEventListenerRegistryRef = globalEventListenerRegistryRef;
    }

    private static ServiceReference getGlobalEventListenerRegistryRef() {
	if (globalEventListenerRegistryRef == null) {
	    setGlobalEventListenerRegistryRef(context
			.getServiceReference(GlobalEventListenerRegistry.class.getName()));
	}
	return globalEventListenerRegistryRef;
    }
}
