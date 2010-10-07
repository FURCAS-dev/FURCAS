package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;

/**
 * A partial evaluator which doesn't attempt to perform <code>allInstances()</code> requests
 * and instead throws a {@link NoAllInstancesDuringEvaluationForUnusedCheck} exception when
 * it happens. Useful in case partial evaluations are carried out to gain performance and if
 * performing the <code>allInstances()</code> call costs more than it saves.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class PartialEvaluatorNoAllInstances extends PartialEvaluator {
    public PartialEvaluatorNoAllInstances(OppositeEndFinder oppositeEndFinder) {
        super(new PartialEcoreEnvironmentFactoryNoAllInstances(oppositeEndFinder));
    }
}
