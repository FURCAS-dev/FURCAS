package com.sap.ide.treeprovider.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import com.sap.ide.treeprovider.ImageProvider;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author D046040
 */
public class Activator extends AbstractUIPlugin {

    private static final String PLUGIN_ID_PARSING_TEXTBLOCKS = "com.sap.mi.textual.parsing.textblocks";

    private static final String PLUGIN_ID_GLOBALMODELLISTENER = "com.sap.tc.moin.globalmodellistener";

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.ide.treeprovider";

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
	return plugin;
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
	ensurePluginLoaded(context, PLUGIN_ID_GLOBALMODELLISTENER);
	ensurePluginLoaded(context, PLUGIN_ID_PARSING_TEXTBLOCKS);
    }

    private void ensurePluginLoaded(BundleContext context, String bundleName) {
	for (Bundle b : context.getBundles()) {
	    if (b.getSymbolicName() != null && b.getSymbolicName().equals(bundleName)) {
		if (b.getState() != Bundle.ACTIVE) {
		    try {
			b.start();
		    } catch (BundleException e) {
			throw new RuntimeException("OSGi failure", e);
		    }
		}
	    }
	}
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

    public static Image getImageModelRoot() {
	ImageRegistry registry = getDefault().getImageRegistry();

	String key = "resources/icons/tree/containment/ATN_ModelRoot.gif"; //$NON-NLS-1$
	Image image = registry.get(key);
	if (image == null) {
	    ImageDescriptor desc = imageDescriptorFromPlugin(PLUGIN_ID, key);
	    registry.put(key, desc);
	    image = registry.get(key);
	}
	return image;
    }

    /**
     * Returns an {@link Image} for a model element. Asks {@link ImageProvider}s first for element
     * specific images. Fallback to {@link MofClass} based image in case no element specific image
     * is provided.
     * @param element
     * @return
     */
    public static Image getImage(EObject element) {
	IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint("com.sap.ide.treeprovider.imageProvider");
	for (IConfigurationElement e : eventListenerPoint.getConfigurationElements()) {
	    if (e.getName().equals("imageProvider")) {
		ImageProvider provider;
		try {
		    provider = (ImageProvider) e.createExecutableExtension("classname");
		    ImageDescriptor desc = provider.getImageDescriptor(element);
		    if (desc != null) {
			return desc.createImage();
		    }
		} catch (CoreException ex) {
		    throw new RuntimeException(ex);
		}
	    }
	}
	return Activator.getImage((EClass)element.refMetaObject());
    }

    /**
     * Looks locally under resources/icons/metamodel for images that match the
     * classname. If not found, polls all providers to the
     * <tt>imageProvider</tt> extension point.
     */
    public static Image getImage(EClass clazz) {
	ImageRegistry registry = getDefault().getImageRegistry();
	String classMofId = clazz.refMofId();
	Image image = registry.get(classMofId);
	if (image == null) {
	    IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry()
		    .getExtensionPoint("com.sap.ide.treeprovider.imageProvider");
	    for (IConfigurationElement e : eventListenerPoint.getConfigurationElements()) {
		if (e.getName().equals("imageProvider")) {
		    ImageProvider provider;
		    try {
			provider = (ImageProvider) e.createExecutableExtension("classname");
			ImageDescriptor desc = provider.getImageDescriptor(clazz);
			if (desc != null) {
			    registry.put(classMofId, desc);
			    image = registry.get(classMofId);
			    break;
			}
		    } catch (CoreException ex) {
			throw new RuntimeException(ex);
		    }
		}
	    }
	}
	return image;
    }

    public static ImageDescriptor getImageDescriptor(EClass clazz) {
	IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint("com.sap.ide.treeprovider.imageProvider");
	for (IConfigurationElement e : eventListenerPoint.getConfigurationElements()) {
	    if (e.getName().equals("imageProvider")) {
		ImageProvider provider;
		try {
		    provider = (ImageProvider) e.createExecutableExtension("classname");
		    ImageDescriptor imageDescr = provider.getImageDescriptor(clazz);
		    if (imageDescr != null) {
			return imageDescr;
		    }
		} catch (CoreException ex) {
		    throw new RuntimeException(ex);
		}
	    }
	}
	return null;
    }
    
    /**
     * Log error
     * @param e the e
     */
    public static void logError(Exception e) {
    	logError(e, /*silent*/ false);
    }

    /**
     * Log error.
     *
     * @param e the e
     * @param silent, false if a user dialog should be shown
     */
    public static void logError(Exception e, Boolean silent) {
        String msg;
        if (e instanceof CoreException) {
            IStatus status = ((CoreException) e).getStatus();
            msg = getMessagesRecursively(status);
        } else {
            msg = e.getMessage();
        }

        e.printStackTrace();
        if (e instanceof CoreException) {
            IStatus status = ((CoreException)e).getStatus();
            printStackTracesRecursively(status);
        }

        if (msg == null) {
            msg = String.valueOf(e);
        }
        if (getDefault() != null) {
            getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e));
        }
        
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (!silent && window != null) {
        	IStatus status = (e instanceof CoreException) ?
        		((CoreException) e).getStatus() :
        			new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e);
        	int result = ErrorDialog.openError(window.getShell(),
        		"Error in GrammarBasedEditor Plugin", msg + "\nPress OK to close editor.", status);
        	if(result == Dialog.OK) {
        	    ModelManagerUI.getEditorManager().closeAllActiveModelEditors(false);
        	}        	
        }
    }
    
    /**
     * Gets the messages recursively.
     *
     * @param status the status
     *
     * @return the messages recursively
     */
    private static String getMessagesRecursively(IStatus status) {
        String message = status.getMessage();
        IStatus[] children = status.getChildren();
        for (IStatus childstatus : children) {
            message += '\n' + getMessagesRecursively(childstatus);
        }
        return message;
    }
    
    /**
     * Prints the stack traces recursively.
     *
     * @param status the status
     */
    private static void printStackTracesRecursively(IStatus status) {
        if (status.getException() != null) {
            System.err.println("Child Exception:" + '\n');
            status.getException().printStackTrace();
        }
        IStatus[] children = status.getChildren();
        for (IStatus childstatus : children) {
            printStackTracesRecursively(childstatus);
        }
    }

}
