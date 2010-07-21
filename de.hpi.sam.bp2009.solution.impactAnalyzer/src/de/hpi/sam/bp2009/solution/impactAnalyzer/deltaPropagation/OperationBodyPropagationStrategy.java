package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public class OperationBodyPropagationStrategy implements DeltaPropagationStrategy {
    private final OperationBodyToCallMapper mapper;
    
    public OperationBodyPropagationStrategy(OperationBodyToCallMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression e, Collection<Object> delta) {
        HashSet<Pair<OCLExpression, Collection<Object>>> result = new HashSet<Pair<OCLExpression, Collection<Object>>>();
        for (OperationCallExp oce : mapper.getCallsOf(e)) {
            result.addAll(PartialEvaluator.getResultCollectionFromSingleDelta(oce, delta));
        }
        return result;
    }

}
