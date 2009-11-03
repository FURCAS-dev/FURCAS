package com.sap.tc.moin.globalmodellistener;

import java.util.Map;

import org.osgi.framework.BundleContext;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * A global event listener has to tell the {@link EventFilter} to be used for
 * the registration, then the lifecycle point (pre-chance, pre-commit, post-change)
 * and the handler(s) to be notified when the event occurs.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface GlobalEventListener {
    enum ListenerType { PRE_CHANGE, POST_CHANGE, UPDATE, PRE_COMMIT, POST_COMMIT }
    
    /**
     * Implementing classes use this to return the event listeners, grouped by the event filter (the
     * "condition"), the listener type (before change, after change, before commit, ...), telling
     * the listener for each of those.
     * 
     * @param context
     *                the OSGi context which can be used, e.g., to access the event listener
     *                registry; see also {@link GlobalEventListenerRegistry}.
     * 
     * @return It is permissible to return <tt>null</tt>.
     */
    Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context);
    
}
