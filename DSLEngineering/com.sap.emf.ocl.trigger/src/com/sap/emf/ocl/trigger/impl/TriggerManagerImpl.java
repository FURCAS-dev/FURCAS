package com.sap.emf.ocl.trigger.impl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.trigger.AdapterForExpression;
import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.Triggerable;
import com.sap.emf.ocl.trigger.Triggerable.ExpressionWithContext;

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
        for (ExpressionWithContext expressionInOCL : triggerable.getTriggerExpressions()) {
            AdapterForExpression adapter;
            if (expressionInOCL.getContext() != null) {
                adapter = new AdapterForExpression(triggerable, expressionInOCL.getExpression(),
                    expressionInOCL.getContext(), expressionInOCL.isNotifyNewContextElements(), oppositeEndFinder, impactAnalysisConfiguration);
            } else {
                adapter = new AdapterForExpression(triggerable, expressionInOCL.getExpression(),
                        expressionInOCL.isNotifyNewContextElements(), oppositeEndFinder, impactAnalysisConfiguration);
            }
            EventFilter filter = adapter.getEventFilter(expressionInOCL.isNotifyNewContextElements());
            eventManager.subscribe(filter, adapter);
        }
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
