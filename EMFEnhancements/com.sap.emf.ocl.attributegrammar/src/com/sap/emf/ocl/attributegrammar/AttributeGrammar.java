package com.sap.emf.ocl.attributegrammar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;

/**
 * A set of OCL expressions defining how to compute and update structural features of
 * {@link EObject} elements. Contrary to derived features where the value is not actually
 * stored in the {@link EObject} instances, an attribute grammar updates non-derived
 * features. An attribute grammar can be activated and deactivated for an {@link EventManager}
 * from where it receives events that may affect the OCL expressions defining the attribute
 * grammar. It uses the OCL Impact Analysis component (see {@link ImpactAnalyzer}) to determine
 * those {@link EObject}s on which the structural features need to be updated base on the
 * change events received from the {@link EventManager}.
 *
 * @author Axel Uhl
 */
public interface AttributeGrammar {
    /**
     * Registers event listeners with <code>eventManager</code> based on the OCL expressions
     * defining this attribute grammar. When events are received, this attribute grammar
     * will determine the {@link EObject}s whose structural features could be affected by the
     * changes, using the OCL impact analysis component, and then updates the potentially
     * affected instances.<p>
     * 
     * Use {@link #deactivate(EventManager)} to stop receiving events from <code>eventManager</code>.
     */
    void activate(EventManager eventManager);
    
    /**
     * Same as {@link #activate(EventManager)}, only that the {@link EventManagerFactory} is used
     * to obtain an event manager for the resource set specified.
     */
    void activate(ResourceSet resourceSet);
    
    /**
     * When called for an <code>eventManager</code> for which this attribute grammar was not
     * previously {@link #activate(EventManager) activated}, this operation has no effect. Otherwise,
     * this grammar will deregister all its listeners from <code>eventManager</code> so that
     * events emitted by it won't lead to updates through the OCL expressions defined by this
     * grammar.
     */
    void deactivate(EventManager eventManager);
    
    /**
     * Same as {@link #deactivate(EventManager)} but uses an internal mapping that maintains
     * information about the resource sets for which this attribute grammar has been activated and
     * the corresponding {@link EventManager} objects used for this.
     * @param resourceSet
     */
    void deactivate(ResourceSet resourceSet);
}
