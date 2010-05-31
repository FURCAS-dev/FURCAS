/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

/**
 * Common interface for all Implementations of an EMF EventManager
 * @author Philipp
 * 
 */
public interface EventManager {
    final static int CONTAINMENT_EVENT_TYPE = 666;

    /**
     * Register an {@link Adapter} on the {@link EventManager} which will be notified for any {@link Notification} which matches the given filter
     * @param filter the {@link EventFilter} which is used to filter events for the given {@link Adapter}
     * @param caller the adapter which should receive event which matches the filter
     */
    void subscribe(EventFilter filter, Adapter caller);   
    
    /**
     * Additional to registering an {@link Adapter} with the filter which has to match for a {@link Notification}, 
     * one can give a {@link Collection} of {@link Notifier}, on which the {@link EventManager} should be attached (increase the size of the scope)
     * NOTE: idenpendent from the given notifier, an adapter will be notified for each {@link Notification} matching the filter from the whole scope of the {@link EventManager}
     * @see EventManager#subscribe(EventFilter, Adapter)
     * @param notifiers all notifiers to attach the {@link EventManager} on
     * @param filter the {@link EventFilter} which is used to filter events for the given {@link Adapter}
     * @param caller the adapter which should receive event which matches the filter
     */
    void subscribe(Collection<? extends Notifier> notifiers, EventFilter filter, Adapter caller);
    
    
    void subscribeTransactional(EventFilter filter, Adapter caller);   
    void subscribeTransactional(Collection<? extends Notifier> root, EventFilter filter, Adapter caller);



    /**
     * Removes the given {@link Adapter} from the {@link EventManager} and the linked {@link EventFilter}, so that the given {@link Adapter} will not be notified anymore
     * @param caller the {@link Adapter} to unsubscribe
     * @return <code>true</code> if the adapter was registered
     */
    boolean unsubscribe(Adapter caller);
    
    /**
     * Tries to detach the {@link EventManager} from the given {@link Notifier}s
     * @param notifiers notifiers to detach from
     * @return <code>true</code> if all {@link Notifier}s could be detached and no {@link Notifier} exists which contains the given {@link Notifier}s and as result prevent the EventManager from detaching
     */
    boolean detachFrom(Notifier... notifiers);
    /**
     * Gives all {@link Notifier}s where the {@link EventManager} was intentionally attached, so exclude all {@link Notifier}s which are in the compisition hierarchy 
     * @return {@link Collection} of all {@link Notifier}s
     */
    Collection<? extends Notifier> getAllNotifiers();
    boolean attachTo(Notifier... notifiers);

    /*
     * INTERN METHODS should only be used by the EventManager
     */
    /**
     * Notify a given {@link Adapter} with the given {@link Notification} and the matching {@link EventFilter}
     * @param application
     * @param msg
     * @param matchingFilter 
     */
    void notifyApplication(Adapter application, Notification msg, EventFilter matchingFilter);

    /**
     * Initialize the filtering process for a given {@link Notification}, all {@link Adapter} registered with a matching filter will be notified
     * @param notification {@link Notification} to handle
     */
    void handleEMFEvent(Notification notification);

} // EventManager
