package com.sap.emf.ocl.trigger;

import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.trigger.impl.TriggerManagerFactoryImpl;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;

/**
 * Used to create a {@link TriggerManager}.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface TriggerManagerFactory {
    static TriggerManagerFactory INSTANCE = new TriggerManagerFactoryImpl();
    
    /**
     * The trigger manager returned uses a default {@link OppositeEndFinder} during OCL impact analysis and uses the
     * default {@link ActivationOption configuration} for the impact analysis.
     */
    TriggerManager createTriggerManager();

    /**
     * The trigger manager returned uses the default {@link ActivationOption configuration} for the impact analysis.
     */
    TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder);

    /**
     * The trigger manager returned uses a default {@link OppositeEndFinder} during OCL impact analysis.
     */
    TriggerManager createTriggerManager(ActivationOption impactAnalysisConfiguration);

    TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder, ActivationOption impactAnalysisConfiguration);
}
