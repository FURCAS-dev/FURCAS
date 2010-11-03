package com.sap.emf.ocl.attributegrammar;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.attributegrammar.impl.AttributeGrammarFactoryImpl;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

/**
 * Produces {@link AttributeGrammar}s based on OCL expressions that define values for
 * structural features. Contrary to derived features where the value is not actually
 * stored in the {@link EObject} instances, an attribute grammar updates non-derived
 * features.
 * 
 * @author Axel Uhl
 */
public interface AttributeGrammarFactory {
    public static AttributeGrammarFactory INSTANCE = new AttributeGrammarFactoryImpl();
    
    /**
     * Defines an attribute grammar by providing inferencing rules for structural features
     * (attributes and references) of an Ecore metamodel. When the resulting attribute grammar
     * is registered with an {@link EventManager}, events received from that event manager that
     * affect the value of any of the OCL expressions used in the attribute grammar lead to
     * an update of the structural feature on all elements for which the value of the expression
     * may have changed.<p>
     * 
     * A default {@link OppositeEndFinder} will be used to backward-traverse references during
     * impact analysis. If you want to provide a specific implementation for this, consider using
     * {@link #createAttributeGrammar(Map, OppositeEndFinder, OCLFactory)}.
     * 
     * Precondition: the type of the {@link OCLExpression} used in an entry in <code>rules</code>
     * must conform to the type of the {@link EStructuralFeature} used as the entry's key.
     */
    AttributeGrammar createAttributeGrammar(Map<EStructuralFeature, OCLExpression> rules, OCLFactory oclFactory) throws RuleTypeConformanceException;

    /**
     * Same as {@ink #createAttributeGrammar(Map)}, only that a specific {@link OppositeEndFinder}
     * can be defined which will be used during the impact analysis for backward-traversing
     * references.
     */
    AttributeGrammar createAttributeGrammar(Map<EStructuralFeature, OCLExpression> rules, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory)
            throws RuleTypeConformanceException;
}
