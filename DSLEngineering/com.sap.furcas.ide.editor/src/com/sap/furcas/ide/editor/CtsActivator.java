package com.sap.furcas.ide.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class CtsActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sap.ide.cts.editor";


    // The shared instance
    /** The plugin. */
    private static CtsActivator plugin;

    /**
     * The constructor.
     */
    public CtsActivator() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        //this is to ensure that the global model listener is registered before an editor can be opened
        //ensurePluginLoaded(context, "com.sap.tc.moin.globalmodellistener");
	//	ensurePluginLoaded(context, "com.sap.mi.textual.parsing.textblocks");
    }

//	private void ensurePluginLoaded(BundleContext context, String bundleName) {
//		for (Bundle b : context.getBundles()) {
//			if (b.getSymbolicName() != null &&
//					b.getSymbolicName().equals(bundleName)) {
//				if (b.getState() != Bundle.ACTIVE){
//					try {
//						b.start();
//					} catch (BundleException e) {
//						throw new RuntimeException("OSGi failure",e);
//					}
//				}
//			}
//		}
//	}

    /*
     * (non-Javadoc)
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
    public static CtsActivator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path.
     *
     * @param path the path
     *
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
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
        		"Error in GrammarBasedEditor Plugin", msg + "\nPlease close editor (use the (x) button to close all open editors)!", status);   
        	if(result == ErrorDialog.CANCEL) {
        	    //FIXME ModelManagerUI.getEditorManager().closeAllActiveModelEditors(false);
        	}
        }
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
     * Log warning.
     *
     * @param e the e
     */
    public static void logWarning(Exception e) {
        String msg = e.getMessage();
        if (msg == null) {
            msg = String.valueOf(e);
        }
        getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, IStatus.OK, msg, e));
    }

    /**
     * Log warning.
     *
     * @param msg the msg
     */
    public static void logWarning(String msg) {
        if (msg != null) {
            getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, msg));
        }
    }

    /**
     * Log warning.
     *
     * @param msg the msg
     */
    public static void logError(String msg) {
        if (msg != null) {
            getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, new Exception("Dummy Exception")));
        }
    }

    /**
     * Log info.
     *
     * @param info the info
     */
    public static void logInfo(String info) {
        getDefault().getLog().log(new Status(IStatus.INFO, PLUGIN_ID, IStatus.OK, info, null));
    }



}
