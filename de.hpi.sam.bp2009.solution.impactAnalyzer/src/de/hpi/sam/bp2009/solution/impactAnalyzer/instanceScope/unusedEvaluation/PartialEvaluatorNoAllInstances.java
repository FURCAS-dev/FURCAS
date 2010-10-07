package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;

public class PartialEvaluatorNoAllInstances extends PartialEvaluator {
    public PartialEvaluatorNoAllInstances(OppositeEndFinder oppositeEndFinder) {
        super(new PartialEcoreEnvironmentFactoryNoAllInstances(oppositeEndFinder));
    }
}
