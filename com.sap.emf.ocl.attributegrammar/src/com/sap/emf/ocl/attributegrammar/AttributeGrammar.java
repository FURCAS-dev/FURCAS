package com.sap.emf.ocl.attributegrammar;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * A set of OCL expressions defining how to compute and update structural features of
 * {@link EObject} elements. Contrary to derived features where the value is not actually
 * stored in the {@link EObject} instances, an attribute grammar updates non-derived
 * features. An attribute grammar can be activated and deactivated for an {@link EventManager}
 * from where it receives events that may affect the OCL expressions defining the attribute
 * grammar.
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
     * When called for an <code>eventManager</code> for which this attribute grammar was not
     * previously {@link #activate(EventManager) activated}, this operation has no effect. Otherwise,
     * this grammar will deregister all its listeners from <code>eventManager</code> so that
     * events emitted by it won't lead to updates through the OCL expressions defined by this
     * grammar.
     */
    void deactivate(EventManager eventManager);
}
