package com.sap.tc.moin.globalmodellistener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener.ListenerType;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * Clients who want to receive event notifications from <em>all</em> MOIN connections can extend the
 * extension point <tt>eventListeners</tt> of this plugin. This plugin's {@link Activator} should be
 * used as the activator of participating metamodel plugins (the <tt>.epi</tt> wrapper projects typically
 * created for each "platform-independent" metamodel project). A metamodel wrapper project can do so
 * by adding a dependency to this plugin and then setting {@link com.sap.tc.moin.globalmodellistener.Activator}
 * as their activator.<p>
 * 
 * Clients who extend the <tt>eventListeners</tt> extension point need to specify a class that
 * implements the {@link GlobalEventListener} interface.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class Activator extends Plugin implements BundleActivator, GlobalEventListenerRegistry {
    private static Activator plugin;
    
    private Set<SessionCreationListenerImpl> sessionCreationListeners = new HashSet<SessionCreationListenerImpl>();

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.tc.moin.globalmodellistener";

    private Map<EventFilter, Map<GlobalEventListener.ListenerType, Set<EventListener>>> filters;
    
    /**
     * Weakly-referenced sessions; value objects are all <tt>null</tt>.
     */
    private WeakHashMap<Session, Object> knownSessions;
    private Bundle myBundle;
    
    public Activator() {
    }
    
    public static Activator getDefault() {
	return plugin;
    }
    
    void addSessionCreationListener(SessionCreationListenerImpl listener) {
	sessionCreationListeners.add(listener);
    }

    @Override
    public void start(BundleContext context) {
	plugin = this;
	filters = new HashMap<EventFilter, Map<GlobalEventListener.ListenerType, Set<EventListener>>>();
	knownSessions = new WeakHashMap<Session, Object>();
	myBundle = context.getBundle();
	context.registerService(GlobalEventListenerRegistry.class.getName(), this, null);
    }
    
    /**
     * Registers all filters defined in {@link #filters} on the <tt>session</tt> specified.
     */
    public synchronized void registerFilters(Session session) {
		for (EventFilter filter : filters.keySet()) {
		    Map<ListenerType, Set<EventListener>> listenersPerType = filters.get(filter);
		    for (ListenerType type : listenersPerType.keySet()) {
				for (EventListener listener : listenersPerType.get(type)) {
				    registerListenerForSession(filter, type, listener, session);
				}
		    }
		}
    }
    
    /**
     * Removes all filters defined in {@link #filters} on the <tt>session</tt> specified.
     */
    public synchronized void deregisterFilters(Session session) {
		for (EventFilter filter : filters.keySet()) {
		    Map<ListenerType, Set<EventListener>> listenersPerType = filters.get(filter);
		    for (ListenerType type : listenersPerType.keySet()) {
				for (EventListener listener : listenersPerType.get(type)) {
				    deregisterListenerForSession(listener, session);
				}
		    }
		}
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry#addFilters(java.util.Map)
     */
    public synchronized void addFilters(Map<EventFilter, Map<ListenerType, EventListener>> listenerFilters) {
	for (EventFilter filter : listenerFilters.keySet()) {
	    Map<ListenerType, Set<EventListener>> registrationsForFilter;
	    if (filters.containsKey(filter)) {
		registrationsForFilter = filters.get(filter);
	    } else {
		registrationsForFilter = new HashMap<ListenerType, Set<EventListener>>();
		filters.put(filter, registrationsForFilter);
	    }
	    Map<ListenerType, EventListener> listenersForFilter = listenerFilters.get(filter);
	    for (ListenerType type : listenersForFilter.keySet()) {
		Set<EventListener> listeners;
		if (registrationsForFilter.containsKey(type)) {
		    listeners = registrationsForFilter.get(type);
		} else {
		    listeners = new HashSet<EventListener>();
		    registrationsForFilter.put(type, listeners);
		}
		if (!listeners.contains(listenersForFilter.get(type))) {
		    listeners.add(listenersForFilter.get(type));
		    registerListenerOnKnownSessions(filter, type, listenersForFilter.get(type));
		}
	    }
	}
    }
    
    /* (non-Javadoc)
     * @see com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry#removeFilters(java.util.Map)
     */
    public synchronized void removeFilters(Map<EventFilter, Map<ListenerType, EventListener>> listenerFilters) {
	for (EventFilter filter : listenerFilters.keySet()) {
	    Map<ListenerType, Set<EventListener>> registrationsForFilter;
	    if (filters.containsKey(filter)) {
		registrationsForFilter = filters.remove(filter);
		Map<ListenerType, EventListener> listenersForFilter = listenerFilters
			.get(filter);
		for (ListenerType type : listenersForFilter.keySet()) {
		    if (registrationsForFilter.containsKey(type)) {
			deregisterListenerOnKnownSessions(
				listenersForFilter.get(type));
		    }
		}
    	    }
	}
    }

    private void deregisterListenerOnKnownSessions(EventListener eventListener) {
	Set<Session> deadSessions = new HashSet<Session>();
	for (Session session : knownSessions.keySet()) {
	    if (session != null) {
		if (session.isAlive()) {
		    deregisterListenerForSession(eventListener, session);
		} else {
		    deadSessions.add(session);
		}
	    }
	}
	for (Session deadSession : deadSessions) {
	    knownSessions.remove(deadSession);
	}
    }

    private void deregisterListenerForSession(EventListener eventListener, Session session) {
	if (session.isAlive()) {
	    EventRegistry er = session.getEventRegistry();
	    if (er != null) {
		er.deregister(eventListener);
	    }
	}
    }

    private void registerListenerOnKnownSessions(EventFilter filter, ListenerType type,
	    EventListener eventListener) {
	Set<Session> deadSessions = new HashSet<Session>();
	for (Session session : knownSessions.keySet()) {
	    if (session != null) {
		if (session.isAlive()) {
		    registerListenerForSession(filter, type, eventListener, session);
		} else {
		    deadSessions.add(session);
		}
	    }
	}
	for (Session deadSession : deadSessions) {
	    knownSessions.remove(deadSession);
	}
    }

    @SuppressWarnings("deprecation")
    private void registerListenerForSession(EventFilter filter, ListenerType type,
	    EventListener eventListener, Session session) {
	if (session.isAlive()) {
	    EventRegistry er = session.getEventRegistry();
	    if (er != null) {
		switch (type) {
		case PRE_CHANGE:
		    er.registerPreChangeListener((PreChangeListener) eventListener, filter);
		    break;
		case POST_CHANGE:
		    er.registerListener((ChangeListener) eventListener, filter);
		    break;
		case UPDATE:
		    er.registerUpdateListener((UpdateListener) eventListener, filter);
		    break;
		case PRE_COMMIT:
		    er.registerPreCommitListener((PreCommitListener) eventListener, filter);
		    break;
		case POST_COMMIT:
		    er.registerCommitListener(
			    (com.sap.tc.moin.repository.events.CommitListener) eventListener,
			    filter);
		    break;
		default:
		    throw new RuntimeException("Listeners of type " + type + " not supported");
		}
	    }
	}
    }

    @Override
    public void stop(BundleContext context) {
	// TODO unregister all filters from all known sessions
    }

    void sessionCreated(Session session) {
	knownSessions.put(session, null);
	registerFilters(session);
    }

    BundleContext getBundleContext() {
	return myBundle.getBundleContext();
    }
    
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
                        System.out.println("ParsingTextblocksActivator.logError: "
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
