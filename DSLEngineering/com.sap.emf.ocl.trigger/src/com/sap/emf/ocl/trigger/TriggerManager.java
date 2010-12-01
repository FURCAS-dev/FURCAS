package com.sap.emf.ocl.trigger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Manages a number of {@link Triggerable}s and observes zero or more {@link ResourceSet}s for {@link Notification}s
 * that may trigger any of the expressions provided by the triggerables.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface TriggerManager {
    /**
     * Adds <code>resourceSet</code> to the resource sets from which this trigger manager receives notifications
     * that it dispatches to {@link Triggerable}s subscribed to this manager.
     * 
     * @see #removeFromObservedResourceSets(ResourceSet)
     */
    void addToObservedResourceSets(ResourceSet resourceSet);
    
    /**
     * Stops receiving and dispatching notifications coming from <code>resourceSet</code>.
     * 
     * @see #addToObservedResourceSets(ResourceSet)
     */
    void removeFromObservedResourceSets(ResourceSet resourceSet);
    
    
    /**
     * Registers a {@link Triggerable} with this manager so that it will get notified upon changes affecting
     * any of the {@link Triggerable#getTriggerExpressions() expressions} specified by the {@link Triggerable}.
     */
    void register(Triggerable triggerable);
}
