package com.sap.mi.tcs.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.mi.textual.tcs.editor";

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
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
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
	if (clazz.refOutermostPackage() == clazz.get___Connection().getPackage(TcsPackage.PACKAGE_DESCRIPTOR)) {
	    StringBuilder key = new StringBuilder("icons/");
	    // for (String pathElement : clazz.getQualifiedName()) {
	    // key.append('/');
	    // key.append(pathElement);
	    // }
	    key.append("furcas");
	    key.append(".gif"); //$NON-NLS-1$
	    return imageDescriptorFromPlugin(PLUGIN_ID, key.toString());
	} else {
	    return null;
	}
    }

    public static ImageDescriptor getImageDescriptor(EObject element) {
	ImageDescriptor result = null;
	// if (element instanceof SapClass) {
	// SapClass sc = (SapClass) element;
	// StringBuilder imagename = new
	// StringBuilder("resources/icons/data/classes/");
	// if (sc.isValueType()) {
	// imagename.append("Class_ValueType");
	// } else if (sc.getNotificationSignatures().size() > 0) {
	// imagename.append("Class_EventSource");
	// } else {
	// imagename.append("SapClass");
	// }
	// imagename.append(".gif");
	// result = imageDescriptorFromPlugin(PLUGIN_ID, imagename.toString());
	// }
	return result;
    }

}
