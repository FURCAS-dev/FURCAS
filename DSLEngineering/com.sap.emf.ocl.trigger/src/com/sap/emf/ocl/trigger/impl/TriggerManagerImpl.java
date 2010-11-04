package com.sap.emf.ocl.trigger.impl;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.trigger.AdapterForExpression;
import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.Triggerable;
import com.sap.emf.oppositeendfinder.DefaultOppositeEndFinder;
import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;

public class TriggerManagerImpl implements TriggerManager {
    private final EventManager eventManager;
    private final OppositeEndFinder oppositeEndFinder;
    private final ActivationOption impactAnalysisConfiguration;
    
    TriggerManagerImpl() {
        this(new DefaultOppositeEndFinder(EPackage.Registry.INSTANCE));
    }
    
    public TriggerManagerImpl(OppositeEndFinder oppositeEndFinder) {
        this(oppositeEndFinder, OptimizationActivation.getOption());
    }

    public TriggerManagerImpl(ActivationOption impactAnalysisConfiguration) {
        this(new DefaultOppositeEndFinder(EPackage.Registry.INSTANCE), impactAnalysisConfiguration);
    }

    public TriggerManagerImpl(OppositeEndFinder oppositeEndFinder, ActivationOption impactAnalysisConfiguration) {
        eventManager = EventManagerFactory.eINSTANCE.createEventManager();
        this.oppositeEndFinder = oppositeEndFinder;
        this.impactAnalysisConfiguration = impactAnalysisConfiguration;
    }

    @Override
    public void register(Triggerable triggerable) {
        for (AdapterForExpression adapter : getAdapters(triggerable, oppositeEndFinder, impactAnalysisConfiguration)) {
            EventFilter filter = adapter.getEventFilter();
            eventManager.subscribe(filter, adapter);
        }
    }

    /**
     * Creates one adapter for each expression returned from {@link #getTriggerExpressionsWithContext()} and
     * {@link #getTriggerExpressionsWithoutContext()}. For the former, the context element 
     */
    private Collection<AdapterForExpression> getAdapters(Triggerable triggerable, OppositeEndFinder oppositeEndFinder,
            ActivationOption impactAnalysisConfiguration) {
        Collection<AdapterForExpression> result = new LinkedList<AdapterForExpression>();
        for (ExpressionWithContext expWithContext : triggerable.getTriggerExpressionsWithContext()) {
            result.add(new AdapterForExpression(triggerable, expWithContext.getExpression(),
                    expWithContext.getContext(), triggerable.notifyOnNewContextElements(), oppositeEndFinder, impactAnalysisConfiguration));
        }
        for (OCLExpression expWithoutContext : triggerable.getTriggerExpressionsWithoutContext()) {
            result.add(new AdapterForExpression(triggerable, expWithoutContext,
            /* notifyNewContextElements */false, oppositeEndFinder, impactAnalysisConfiguration));
        }
        return result;
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
