package com.sap.tc.moin.tcs.mof.editor;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.tc.moin.tcs.mof.editor";

    // The shared instance
    private static Activator plugin;

    public Activator() {
    }

    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
    }

    public void stop(BundleContext context) throws Exception {
	plugin = null;
	super.stop(context);
    }

    public static Activator getDefault() {

	return plugin;
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
	MofClass elementType = (MofClass) element.refMetaObject();
	List<String> fqn = elementType.getQualifiedName();
	StringBuilder imagename = new StringBuilder("resources/icons");
	for (String nameSegment : fqn) {
	    imagename.append('/');
	    imagename.append(nameSegment);
	}
	imagename.append(".gif");
	result = imageDescriptorFromPlugin(PLUGIN_ID, imagename.toString());
	return result;
    }
}