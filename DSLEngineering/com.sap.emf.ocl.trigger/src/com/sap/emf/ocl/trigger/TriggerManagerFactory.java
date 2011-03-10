package com.sap.emf.ocl.trigger;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;

import com.sap.emf.ocl.trigger.impl.TriggerManagerFactoryImpl;


/**
 * Used to create a {@link TriggerManager}. The resulting {@link TriggerManager}
 * initially doesn't observe any {@link ResourceSet}. Use
 * {@link TriggerManager#addToObservedResourceSets(org.eclipse.emf.ecore.resource.ResourceSet)}
 * to start observing a {@link ResourceSet}.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public interface TriggerManagerFactory {
    static TriggerManagerFactory INSTANCE = new TriggerManagerFactoryImpl();
    
    /**
     * The trigger manager returned uses a default {@link OppositeEndFinder} during OCL impact analysis and uses the
     * default {@link ActivationOption configuration} for the impact analysis. Creates a new {@link EventManager}
     * specifically for this trigger manager.
     */
    TriggerManager createTriggerManager();

    /**
     * The trigger manager returned uses the default {@link ActivationOption configuration} for the impact analysis.
     * Creates a new {@link EventManager} specifically for this trigger manager.
     */
    TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder);
    
    /**
     * Creates a trigger manager with the specified <code>oppositeEndFinder</code> and using the
     * given <code>eventManager</code>. The default {@link ActivationOption configuration} is used for
     * impact analysis.
     */
    TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder, EventManager eventManager);

    /**
     * The trigger manager returned uses a default {@link OppositeEndFinder} during OCL impact analysis. Creates a new
     * {@link EventManager} specifically for this trigger manager.
     */
    TriggerManager createTriggerManager(ActivationOption impactAnalysisConfiguration);

    /**
     * Creates a new {@link EventManager} specifically for this trigger manager.
     */
    TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder, ActivationOption impactAnalysisConfiguration);

    TriggerManager createTriggerManager(OppositeEndFinder oppositeEndFinder, ActivationOption impactAnalysisConfiguration,
            EventManager eventManager);
}
