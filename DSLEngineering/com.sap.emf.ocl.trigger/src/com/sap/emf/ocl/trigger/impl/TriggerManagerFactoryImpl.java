package com.sap.emf.ocl.trigger.impl;

import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.TriggerManagerFactory;


public class TriggerManagerFactoryImpl implements TriggerManagerFactory {

    @Override
    public TriggerManager createTriggerManager() {
        return new TriggerManagerImpl();
    }

    @Override
    public TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder) {
        return new TriggerManagerImpl(oppositeEndFinder);
    }

    @Override
    public TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder, ActivationOption impactAnalysisConfiguration) {
        return new TriggerManagerImpl(oppositeEndFinder, impactAnalysisConfiguration);
    }

    @Override
    public TriggerManager createTriggerManager(ActivationOption impactAnalysisConfiguration) {
        return new TriggerManagerImpl(impactAnalysisConfiguration);
    }

}
