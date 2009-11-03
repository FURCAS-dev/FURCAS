package com.sap.tc.moin.globalmodellistener;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener.ListenerType;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.SessionCreationListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * Clients who want to receive event notifications from <em>all</em> MOIN connections can extend the
 * extension point <tt>eventListeners</tt> of this plugin. This plugin's {@link SessionCreationListenerImpl} should be
 * used as the activator of participating metamodel plugins (the <tt>.epi</tt> wrapper projects typically
 * created for each "platform-independent" metamodel project). A metamodel wrapper project can do so
 * by adding a dependency to this plugin and then setting {@link SessionCreationListenerImpl}
 * as their activator.<p>
 * 
 * Clients who extend the <tt>eventListeners</tt> extension point need to specify a class that
 * implements the {@link GlobalEventListener} interface.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class SessionCreationListenerImpl implements SessionCreationListener {
    private Activator activator;
    
    public SessionCreationListenerImpl() {
	activator = Activator.getDefault();
	activator.addSessionCreationListener(this); // avoid garbage collection
    }
    
    @Override
    public void sessionCreated(Session session) {
	activator.sessionCreated(session);
    }

    @Override
    public void moinInitialized(Moin moin) {
	try {
	    Connection connection = moin.createSession(moin.getCompoundDataAreaManager().getCompoundClientSpecTransientOnly())
		    .createConnection();
	    IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint(
		    "com.sap.tc.moin.globalmodellistener.eventListeners");
	    for (IConfigurationElement element : eventListenerPoint.getConfigurationElements()) {
		if (element.getName().equals("listener")) {
		    GlobalEventListener listener;
		    try {
			listener = (GlobalEventListener) element.createExecutableExtension("classname");
		    } catch (CoreException e) {
			throw new RuntimeException(e);
		    }
		    Map<EventFilter, Map<ListenerType, EventListener>> listenerFilters = listener.getFilters(
			    connection, activator.getBundleContext());
		    if (listenerFilters != null) {
			activator.addFilters(listenerFilters);
		    }
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

}
