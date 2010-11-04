package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.unusedEvaluation;

import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.NoAllInstancesDuringEvaluationForUnusedCheck;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.PartialEvaluatorNoAllInstances;

/**
 * A partial evaluator which doesn't attempt to perform <code>allInstances()</code> requests
 * and instead throws a {@link NoAllInstancesDuringEvaluationForUnusedCheck} exception when
 * it happens. Useful in case partial evaluations are carried out to gain performance and if
 * performing the <code>allInstances()</code> call costs more than it saves.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class PartialEvaluatorNoAllInstancesWithHiddenOpposites extends PartialEvaluatorNoAllInstances {
    public PartialEvaluatorNoAllInstancesWithHiddenOpposites(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        super(new PartialEcoreEnvironmentNoAllInstWithHiddenOppositesFactory(oppositeEndFinder), oclFactory);
    }
}
