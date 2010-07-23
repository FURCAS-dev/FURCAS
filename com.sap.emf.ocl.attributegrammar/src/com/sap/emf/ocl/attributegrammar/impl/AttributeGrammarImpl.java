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
    private final Map<OCLExpression, ImpactAnalyzer> impactAnalyzers = new HashMap<OCLExpression, ImpactAnalyzer>();
    
    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules) {
        oppositeEndFinder = null;
        this.rules = rules;
        initImpactAnalyzers();
    }

    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules, OppositeEndFinder oppositeEndFinder) {
        this.oppositeEndFinder = oppositeEndFinder;
        this.rules = rules;
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
        // TODO Auto-generated method stub

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
