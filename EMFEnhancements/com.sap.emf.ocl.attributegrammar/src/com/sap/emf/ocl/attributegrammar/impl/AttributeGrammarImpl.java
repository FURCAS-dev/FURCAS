package com.sap.emf.ocl.attributegrammar.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.attributegrammar.AttributeGrammar;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

public class AttributeGrammarImpl implements AttributeGrammar {
    private final Map<EStructuralFeature, OCLExpression> rules;
    private final OppositeEndFinder oppositeEndFinder;
    private final boolean notifyOnNewContextElements;
    private final Map<OCLExpression, ImpactAnalyzer> impactAnalyzers = new HashMap<OCLExpression, ImpactAnalyzer>();
    private final OCLFactory oclFactory;
    
    /**
     * Defaults: no notifications upon appearance of new context elements; impact analyzers will use
     * a default {@link OppositeEndFinder} to navigate references in reverse direction.
     */
    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules, OCLFactory oclFactory) {
        oppositeEndFinder = null;
        this.rules = rules;
        notifyOnNewContextElements = false;
        this.oclFactory = oclFactory;
        initImpactAnalyzers(oclFactory);
    }

    /**
     * Defaults: no notifications upon appearance of new context elements
     */
    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        this.oppositeEndFinder = oppositeEndFinder;
        this.rules = rules;
        this.oclFactory = oclFactory;
        notifyOnNewContextElements = false;
        initImpactAnalyzers(oclFactory);
    }

    public AttributeGrammarImpl(Map<EStructuralFeature, OCLExpression> rules, OppositeEndFinder oppositeEndFinder,
            boolean notifyOnNewContextElements, OCLFactory oclFactory) {
        this.oppositeEndFinder = oppositeEndFinder;
        this.rules = rules;
        this.notifyOnNewContextElements = notifyOnNewContextElements;
        this.oclFactory = oclFactory;
        notifyOnNewContextElements = false;
        initImpactAnalyzers(oclFactory);
    }

    private void initImpactAnalyzers(OCLFactory oclFactory) {
        ImpactAnalyzerFactory iaFactory = ImpactAnalyzerFactory.INSTANCE;
        for (OCLExpression e : rules.values()) {
            ImpactAnalyzer ia;
            if (oppositeEndFinder == null) {
                ia = iaFactory.createImpactAnalyzer(e, notifyOnNewContextElements, oclFactory);
            } else {
                ia = iaFactory.createImpactAnalyzer(e, notifyOnNewContextElements, oppositeEndFinder, oclFactory);
            }
            impactAnalyzers.put(e, ia);
        }
    }

    @Override
    public void activate(EventManager eventManager) {
        for (Map.Entry<EStructuralFeature, OCLExpression> rule : rules.entrySet()) {
            ImpactAnalyzer ia = impactAnalyzers.get(rule.getValue());
            eventManager.subscribe(ia.createFilterForExpression(),
                    new UpdateListener(rule.getKey(), rule.getValue(), ia, oclFactory.createOCL(oppositeEndFinder)));
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
