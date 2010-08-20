package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;

import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OclHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public class IteratorSourcePropagationStrategy extends DeltaPropagationStrategyWithTargetExpressionAndPartialEvaluator {

    public IteratorSourcePropagationStrategy(IteratorExp loopExp, PartialEvaluator evaluator) {
        super(loopExp, evaluator);
    }

    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression sourceOfIterator, Collection<Object> delta) {
        return PartialEvaluator.getResultCollectionFromSingleDelta(getPropagatesTo(), OclHelper.flatten(
                getEvaluator().evaluate(null, (CallExp) getPropagatesTo(), delta)));
    }

}
