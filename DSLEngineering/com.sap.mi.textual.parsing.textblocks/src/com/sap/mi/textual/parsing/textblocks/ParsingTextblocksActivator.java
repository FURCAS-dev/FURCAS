package com.sap.mi.textual.parsing.textblocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.SessionFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * The activator class controls the plug-in life cycle
 */
public class ParsingTextblocksActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sap.mi.textual.parsing.textblocks";


	private static final String UNRESOLVED_REFERENCES_STORE_FILENAME = "unresolvedreferences.ser";


    // The shared instance
    /** The plugin. */
    private static ParsingTextblocksActivator plugin;

    private static boolean moinLoggingOn = System.getProperties().get("furcas.moin.logging") != null &&
    	((String) System.getProperties().get("furcas.moin.logging")).equalsIgnoreCase("true");
    
    private ChangeListener moinListener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
	        System.out.println(event); // TODO
	    }
        };

    private Set<Connection> loggingEnabledFor = new HashSet<Connection>();

    /**
     * The constructor.
     */
    public ParsingTextblocksActivator() {
    }

	public synchronized void disableMoinLogging(Connection connection) {
	    if (moinLoggingOn) {
	        if (isMoinLoggingEnabled(connection)) {
		    connection.getEventRegistry().deregister(moinListener);
		    loggingEnabledFor.remove(connection);
	        }
	    }
	}

	public void enableMoinLogging(Connection connection) {
	    if (moinLoggingOn) {
		if (!isMoinLoggingEnabled(connection)) {
		    connection.getEventRegistry().registerListener(moinListener, new SessionFilter(connection.getSession()));
		    loggingEnabledFor.add(connection);
		}
	    }
	}
	
	public boolean isMoinLoggingEnabled(Connection connection) {
	    return loggingEnabledFor.contains(connection);
	}

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
	public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        loadUnresolvedReferences();
    }

    private Set<DelayedReference> loadUnresolvedReferences() {
	IPath path = getStateLocation();
	if (path == null) {
	    return null;
	}
	path = path.append(UNRESOLVED_REFERENCES_STORE_FILENAME);
	File file = path.toFile();
	FileReader in = null;
	FileWriter out = null;
	try {
	    in = new FileReader(file);
	    // don't append data, overwrite what was there
	    char buffer[] = new char[4096];
	    int count;
	    while ((count = in.read(buffer, 0, buffer.length)) > 0) {
		if (true /* out != null */) {
		    // FIXME out is always null; to what should it be set?
		    out.write(buffer, 0, count);
		}
	    }
	} catch (FileNotFoundException e) {
	    return null;
	} catch (IOException e) {
	    return null;
	} finally {
	    try {
		if (in != null) {
		    in.close();
		}
		if (false /* out != null */) {
		    out.close();
		}
	    } catch (IOException e) {
		return null;
	    }
	}
	return null;
    }

    /*
     * (non-Javadoc)
     * 
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
    public static ParsingTextblocksActivator getDefault() {
        return plugin;
    }

    /**
     * Log error.
     * 
     * @param e the e
     */
    public static void logError(Exception e) {
        logError(e, "");
    }
    /**
     * Log error.
     * 
     * @param e the e
     */
    public static void logError(Exception e, String message) {
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
        msg = message + msg;
    	if (getDefault() != null) {
			getDefault().getLog().log(
					new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e));
		} else {
			System.out.println("ParsingTextblocksActivator.logWarning: "
					+ e.getMessage());
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
			System.out.println("ParsingTextblocksActivator.logWarning: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

    /**
     * Log warning.
     * 
     * @param msg the msg
     */
    public static void logWarning(String msg) {
		if (msg != null) {
			if (getDefault() != null) {
				getDefault().getLog().log(
						new Status(IStatus.WARNING, PLUGIN_ID, msg));
			}
			 else {
				System.out.println("ParsingTextblocksActivator.logWarning: "
						+ msg);
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
								new Exception("Dummy Exception")));
			}
		} else {
			System.out.println("ParsingTextblocksActivator.logError: " + msg);
		}
	}

    /**
     * Log info.
     * 
     * @param info the info
     */
    public static void logInfo(String info) {
		if (getDefault() != null) {
			getDefault().getLog()
					.log(
							new Status(IStatus.INFO, PLUGIN_ID, IStatus.OK,
									info, null));

		} else {
			System.out.println("ParsingTextblocksActivator.logInfo: " + info);
		}
	}

    

}
