package com.sap.finex.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import structure.FinexClass;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.finex.editor";

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

    public static ImageDescriptor getImageDescriptor(MofClass clazz) {
	StringBuilder imagename = new StringBuilder("resources/icons");
	for (String pathElement : clazz.getQualifiedName()) {
	    imagename.append('/');
	    imagename.append(pathElement);
	}
	imagename.append(".gif"); //$NON-NLS-1$
	return imageDescriptorFromPlugin(PLUGIN_ID, imagename.toString());
    }
    
    public static ImageDescriptor getImageDescriptor(RefObject element) {
	ImageDescriptor result;
	if (element instanceof FinexClass) {
	    FinexClass sc = (FinexClass) element;
	    StringBuilder imagename = new StringBuilder("resources/icons/structure/");
	    if (sc.isValueType()) {
		imagename.append("FinexClass_ValueType");
	    } else {
		imagename.append("FinexClass");
	    }
	    imagename.append(".gif");
	    result = imageDescriptorFromPlugin(PLUGIN_ID, imagename.toString());
	} else {
	    result = getImageDescriptor(((MofClass) element.refMetaObject()));
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
