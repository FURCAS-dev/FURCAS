package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Set;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;

public interface OperationBodyToCallMapper {
    /**
     * Returns all the calls to the operation whose body is <tt>operationBodyExpression</tt> that are reachable from some scope.
     * Which scope this is depends on the particular implementation. If no such calls exist, an empty set is returned.
     */
    public Set<OperationCallExp> getCallsOf(OCLExpression operationBodyExpression);
}
