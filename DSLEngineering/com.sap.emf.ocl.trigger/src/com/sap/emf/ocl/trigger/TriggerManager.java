package com.sap.emf.ocl.trigger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Manages a number of {@link Triggerable}s and observes one or more {@link ResourceSet}s for {@link Notification}s
 * that may trigger any of the expressions provided by the triggerables.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface TriggerManager {
    void observe(ResourceSet resourceSet);
}
