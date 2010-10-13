package com.sap.emf.ocl.trigger.impl;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.Triggerable;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;

public class TriggerManagerImpl implements TriggerManager {
    private final EventManager eventManager;
    
    TriggerManagerImpl() {
        eventManager = EventManagerFactory.eINSTANCE.createEventManager();
    }
    
    @Override
    public void register(Triggerable triggerable) {
        // TODO Implement TriggerManagerImpl.register(...)

    }

    @Override
    public void addToObservedResourceSets(ResourceSet resourceSet) {
        eventManager.addToObservedResourceSets(resourceSet);
    }

    @Override
    public void removeFromObservedResourceSets(ResourceSet resourceSet) {
        eventManager.removeFromObservedResourceSets(resourceSet);
    }

}
