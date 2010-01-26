package com.sap.tc.moin.globalmodellistener;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener.ListenerType;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * An OSGi service that can be obtained as follows:
 * 
 * <pre>
 *      BundleContext context = ...
 * 	ServiceReference ref = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
 * 	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(ref);
 * </pre>
 * 
 * The {@link BundleContext} as well as the {@link ServiceReference} may be cached. The resolved service
 * object should not be cached because OSGi may stop, unload and reload the bundle containing the
 * service.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface GlobalEventListenerRegistry {

    /**
     * Registers the <tt>listenerFilters</tt> with all currently known sessions and keeps them
     * around in order to register them when new sessions show up.
     */
    public abstract void addFilters(
	    Map<EventFilter, Map<ListenerType, EventListener>> listenerFilters);
    
    /**
     * Deregisters the <tt>listenerFilters</tt> from all currently known sessions and removes them from
     * its internal repository.
     */
    public abstract void removeFilters(
	    Map<EventFilter, Map<ListenerType, EventListener>> listenerFilters);

	/**
	 * Registers all filters defined in {@link #filters} on the <tt>session</tt> specified.
	 */
	public abstract void registerFilters(Session session);

	/**
	 * Removes all filters defined in {@link #filters} on the <tt>session</tt> specified.
	 */
	public abstract void deregisterFilters(Session session);

	
	/**
	 * When during the execution of <tt>runnable</tt> in the calling thread a new {@link session}
	 * is created, event listeners will <em>not</em> be registered for the events caused by that
	 * session.
	 */
	void executeWithoutRegisteringListenersForNewSessions(Runnable runnable);

}