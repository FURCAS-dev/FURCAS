package com.sap.ide.cts.parser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.fzi.se.cts.parser";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
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
        
        if (getDefault() != null) {
			getDefault().getLog().log(
					new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e));
		} else {
			System.out.println("Activator.logWarning: " + e.getMessage());
			e.printStackTrace();
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
		if (getDefault() != null) {
			getDefault().getLog().log(
					new Status(IStatus.WARNING, PLUGIN_ID, IStatus.OK, msg, e));
		} else {
			System.out.println("Activator.logWarning: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Log warning.
	 * 
	 * @param msg
	 *            the msg
	 */
	public static void logWarning(String msg) {
		if (msg != null) {
			if (getDefault() != null) {
				getDefault().getLog().log(
						new Status(IStatus.WARNING, PLUGIN_ID, msg));
			} else {
				System.out.println("Activator.logWarning: " + msg);
			}
		}
	}
    
    /**
     * Log warning.
     * 
     * @param msg the msg
     */
    public static void logError(String msg) {
		if (msg != null) {
			if (getDefault() != null) {
				getDefault().getLog().log(
						new Status(IStatus.ERROR, PLUGIN_ID, msg,
								new Exception(msg)));
			} else {
				System.out.println("Activator.logError: " + msg);
			}
		}
	}

	/**
	 * Log info.
	 * 
	 * @param info
	 *            the info
	 */
	public static void logInfo(String info) {
		if (getDefault() != null) {
			getDefault().getLog()
					.log(
							new Status(IStatus.INFO, PLUGIN_ID, IStatus.OK,
									info, null));
		} else {
			System.out.println("Activator.logInfo: " + info);
		}
	}
}
