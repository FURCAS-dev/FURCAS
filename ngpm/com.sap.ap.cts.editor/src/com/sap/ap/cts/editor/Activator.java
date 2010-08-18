package com.sap.ap.cts.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.ap.cts.refactoring.adaptation.RefactoringModelAdapterFactory;

import data.classes.SapClass;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
    
    // This is a crude (hopefully temporary hack) to make sure that the Adapter Factory's plugin gets loaded 
    {
	new RefactoringModelAdapterFactory();
	
    }

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.ap.cts.editor";

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
    @Override
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
    @Override
    public void stop(BundleContext context) throws Exception {
	plugin = null;
	super.stop(context);
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
    
    public static ImageDescriptor getImageDescriptor(EObject element) {
	ImageDescriptor result = null;
	if (element instanceof SapClass) {
	    SapClass sc = (SapClass) element;
	    StringBuilder imagename = new StringBuilder("resources/icons/data/classes/");
	    if (sc.isValueType()) {
		imagename.append("Class_ValueType");
	    } else if (sc.getNotificationSignatures().size() > 0) {
		imagename.append("Class_EventSource");
	    } else {
		imagename.append("SapClass");
	    }
	    imagename.append(".gif");
	    result = imageDescriptorFromPlugin(PLUGIN_ID, imagename.toString());
	}
	return result;
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
	return plugin;
    }

}
