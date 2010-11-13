package com.sap.emf.ocl.attributegrammar.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.attributegrammar.AttributeGrammar;
import com.sap.emf.ocl.attributegrammar.AttributeGrammarFactory;
import com.sap.emf.ocl.attributegrammar.RuleTypeConformanceException;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

public class AttributeGrammarFactoryImpl implements AttributeGrammarFactory {

    @Override
    public AttributeGrammar createAttributeGrammar(Map<EStructuralFeature, OCLExpression> rules, OCLFactory oclFactory)
            throws RuleTypeConformanceException {
        assertTypeConformance(rules);
        return new AttributeGrammarImpl(rules, oclFactory);
    }

    @Override
    public AttributeGrammar createAttributeGrammar(Map<EStructuralFeature, OCLExpression> rules,
            OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) throws RuleTypeConformanceException {
        assertTypeConformance(rules);
        return new AttributeGrammarImpl(rules, oppositeEndFinder, oclFactory);
    }

    /**
     * For each entry in the <code>rules</code> map, asserts that the type of the OCL expression
     * conforms to the type of the structural feature used as key for the repsective OCL expression.
     * If one or more non-conformances are detected, they are reported in an exception.
     * @throws RuleTypeConformanceException 
     */
    private void assertTypeConformance(Map<EStructuralFeature, OCLExpression> rules) throws RuleTypeConformanceException {
        Map<EStructuralFeature, OCLExpression> nonConformingRules = new HashMap<EStructuralFeature, OCLExpression>();
        for (Map.Entry<EStructuralFeature, OCLExpression> entry : rules.entrySet()) {
            EClassifier expressionType = entry.getValue().getType();
            EClassifier featureType = entry.getKey().getEType();
            if (expressionType != featureType &&
                    (!(expressionType instanceof EClass) ||
                            !((EClass) expressionType).getEAllSuperTypes().contains(featureType))) {
                nonConformingRules.put(entry.getKey(), entry.getValue());
            }
        }
        if (!nonConformingRules.isEmpty()) {
            throw new RuleTypeConformanceException(nonConformingRules);
        }
    }

}
