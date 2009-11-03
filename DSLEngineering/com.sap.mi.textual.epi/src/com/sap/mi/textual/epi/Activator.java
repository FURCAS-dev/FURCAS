package com.sap.mi.textual.epi;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.mi.textual.epi.util.ExceptionHelper;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    /** The Constant PLUGIN_ID. */
    public static final String PLUGIN_ID = "TextualSyntaxGeneratorPlugin";

    // The shared instance
    /** The plugin. */
    private static Activator plugin;

    /**
     * The constructor.
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
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
     * Log error.
     * 
     * @param e the e
     */
    public static void logError(Exception e) {
        String msg;
        if (e instanceof CoreException) {
            IStatus status = ((CoreException) e).getStatus();
            msg = getMessagesRecursively(status);
        } else {
            msg = e.getMessage();
        }
//        ErrorDialog.openError(
//                getDefault().getWorkbench()
//                .getActiveWorkbenchWindow().getShell(),
//                "Error in SyntaxGeneration Plugin", msg, ExceptionHelper
//                .getErrorStatus(msg));

        e.printStackTrace();
        if (e instanceof CoreException) {
            IStatus status = ((CoreException)e).getStatus();
            printStackTracesRecursively(status);
        } 

        if (msg == null) {
            msg = String.valueOf(e);
        }
        getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e));
    }
    
    /**
     * Log error.
     * 
     * @param msg the msg
     */
    public static void logError(String msg) {
        if (msg != null) {
            getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, new Exception("Dummy Exception")));
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
        for (int i = 0; i < children.length; i++) {
            IStatus childstatus = children[i];
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
        for (int i = 0; i < children.length; i++) {
            IStatus childstatus = children[i];
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
     * Log info.
     * 
     * @param info the info
     */
    public static void logInfo(String info) {
        getDefault().getLog().log(new Status(IStatus.INFO, PLUGIN_ID, IStatus.OK, info, null));
    }

    /**
     * Display error.
     * 
     * @param message the message
     */
    public static void displayError(String message) {
        ErrorDialog.openError(
                getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
                "Error in SyntaxGeneration Plugin" , message, ExceptionHelper.getErrorStatus(message));
    }
}
