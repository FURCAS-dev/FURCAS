package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class IterateTracebackStep extends AbstractTracebackStep {

    public IterateTracebackStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, String[] tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            Set<UnusedEvaluationRequest> pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        // TODO implement AbstractTracebackStep#performSubsequentTraceback()
        return null;
    }

}
