package com.sap.emf.ocl.attributegrammar;

import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * Produces {@link AttributeGrammar}s based on OCL expressions that define values for
 * structural features. Contrary to derived features where the value is not actually
 * stored in the {@link EObject} instances, an attribute grammar updates non-derived
 * features.
 * 
 * @author Axel Uhl
 */
public interface AttributeGrammarFactory {
    /**
     * Defines an attribute grammar by providing inferencing rules for structural features
     * (attributes and references) of an Ecore metamodel. When the resulting attribute grammar
     * is registered with an {@link EventManager}, events received from that event manager that
     * affect the value of any of the OCL expressions used in the attribute grammar lead to
     * an update of the structural feature on all elements for which the value of the expression
     * may have changed.
     */
    AttributeGrammar createAttributeGrammar(Map<EStructuralFeature, OCLExpression> rules);
}
