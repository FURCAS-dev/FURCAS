package com.sap.runlet.testmetamodel.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.runlet.testmetamodel.editor";

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
     * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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

    public static ImageDescriptor getImageDescriptor(EClass clazz) {
	StringBuilder imagename = new StringBuilder("resources/icons");
	for (String pathElement : clazz.getQualifiedName()) {
	    imagename.append('/');
	    imagename.append(pathElement);
	}
	imagename.append(".gif"); //$NON-NLS-1$
	return imageDescriptorFromPlugin(PLUGIN_ID, imagename.toString());
    }

}
