package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;

import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public class IdentityPropagationStrategy extends DeltaPropagationStrategyWithTargetExpression {

    public IdentityPropagationStrategy(OCLExpression propagatesTo) {
        super(propagatesTo);
    }

    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression e, Collection<Object> delta) {
        return PartialEvaluator.getResultCollectionFromSingleDelta(getPropagatesTo(), delta);
    }

}
