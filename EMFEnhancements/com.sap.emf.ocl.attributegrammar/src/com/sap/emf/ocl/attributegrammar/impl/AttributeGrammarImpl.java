package com.sap.emf.ocl.attributegrammar.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.attributegrammar.AttributeGrammar;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;

public class AttributeGrammarImpl implements AttributeGrammar {
    private final Map<EStructuralFeature, OCLExpression> rules;
    private final OppositeEndFinder oppositeEndFinder;
    private final boolean notifyOnNewContextElements;
    private final Map<OCLExpression, ImpactAnalyzer> impactAnalyzers = new HashMap<OCLExpression, ImpactAnalyzer>();
    
    /**
     * Defaults: no notifications upon appearance of new context elements; impact analyzers will use
     * a default {@link OppositeEndFinder} to navigate references in reverse direction.
     */
    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules) {
        oppositeEndFinder = null;
        this.rules = rules;
        notifyOnNewContextElements = false;
        initImpactAnalyzers();
    }

    /**
     * Defaults: no notifications upon appearance of new context elements
     */
    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules, OppositeEndFinder oppositeEndFinder) {
        this.oppositeEndFinder = oppositeEndFinder;
        this.rules = rules;
        notifyOnNewContextElements = false;
        initImpactAnalyzers();
    }

    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules, OppositeEndFinder oppositeEndFinder,
            boolean notifyOnNewContextElements) {
        this.oppositeEndFinder = oppositeEndFinder;
        this.rules = rules;
        this.notifyOnNewContextElements = notifyOnNewContextElements;
        notifyOnNewContextElements = false;
        initImpactAnalyzers();
    }

    private void initImpactAnalyzers() {
        ImpactAnalyzerFactory iaFactory = ImpactAnalyzerFactory.INSTANCE;
        for (OCLExpression e : rules.values()) {
            ImpactAnalyzer ia;
            if (oppositeEndFinder == null) {
                ia = iaFactory.createImpactAnalyzer(e);
            } else {
                ia = iaFactory.createImpactAnalyzer(e, oppositeEndFinder);
            }
            impactAnalyzers.put(e, ia);
        }
    }

    @Override
    public void activate(EventManager eventManager) {
        for (Map.Entry<EStructuralFeature, OCLExpression> rule : rules.entrySet()) {
            ImpactAnalyzer ia = impactAnalyzers.get(rule.getValue());
            eventManager.subscribe(ia.createFilterForExpression(notifyOnNewContextElements),
                    new UpdateListener(rule.getKey(), rule.getValue(), ia, oppositeEndFinder));
        }
    }

    @Override
    public void activate(ResourceSet resourceSet) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deactivate(EventManager eventManager) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deactivate(ResourceSet resourceSet) {
        // TODO Auto-generated method stub

    }

}
