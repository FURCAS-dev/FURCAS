package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public class IteratorSourcePropagationStrategy extends DeltaPropagationStrategyWithTargetExpressionAndPartialEvaluator {

    public IteratorSourcePropagationStrategy(IteratorExp loopExp, PartialEvaluator evaluator) {
        super(loopExp, evaluator);
    }

    @Override
    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression sourceOfIterator, Collection<Object> delta) {
        return PartialEvaluator.getResultCollectionFromSingleDelta(getPropagatesTo(), flatten(
                getEvaluator().evaluate(null, (CallExp) getPropagatesTo(), delta)));
    }

    @SuppressWarnings("unchecked")
    private Collection<Object> flatten(Object o) {
        Collection<Object> result;
        if (o instanceof Collection<?>) {
            if (((Collection<?>) o).isEmpty()) {
                result = (Collection<Object>) o;
            } else {
                result = new HashSet<Object>();
                for (Object subO : (Collection<?>) o) {
                    result.addAll(flatten(subO));
                }
            }
        } else {
            result = Collections.singleton(o);
        }
        return result;
    }

}
