/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

/**
 * Common interface for all Implementations of an EMF EventManager
 * 
 * @author Philipp Berger
 * 
 */
public interface EventManager {
    final static int CONTAINMENT_EVENT_TYPE = 666;

    /**
     * Register an {@link Adapter} on the {@link EventManager} which will be notified for any {@link Notification} which matches
     * the given filter. If an equal or the same <code>caller</code> registers multiple times using equal <code>filter</code>s,
     * the <code>caller</code> will get notified as many times as it subscribed.
     * 
     * @param filter
     *            the {@link EventFilter} which is used to filter events for the given {@link Adapter}
     * @param listener
     *            the adapter which should receive event which matches the filter
     */
    void subscribe(EventFilter filter, Adapter listener);

    /**
     * Removes the given {@link Adapter} from the {@link EventManager} and the linked {@link EventFilter}, so that the given
     * {@link Adapter} will not be notified anymore
     * 
     * @param caller
     *            the {@link Adapter} to unsubscribe
     * @return <code>true</code> if the adapter was registered
     */
    boolean unsubscribe(Adapter caller);

    /**
     * Returns the {@link ResourceSet} of the {@link EventManager}, which defines the root for receiving event of composite
     * {@link EObject}s
     * 
     * @return the composition
     */
    ResourceSet getResourceSet();

    /**
     * Initialize the filtering process for a given {@link Notification}, all {@link Adapter} registered with a matching filter
     * will be notified. Normally, clients don't have to call this method explicitly. It will be called by the
     * event manager automatically when an event has been received from any elements in the {@link ResourceSet}
     * for which the event manager has been obtained (see {@link EventManagerFactory#getEventManagerFor(ResourceSet)}).
     * However, for testing purposes and in case clients want to explicitly send events that have not emerged
     * from the {@link ResourceSet} to registered clients, they may use this method.
     * 
     * @param notification
     *            {@link Notification} to send to clients whose event filter matches the notification
     */
    void handleEMFEvent(Notification notification);
} // EventManager
