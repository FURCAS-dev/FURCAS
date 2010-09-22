package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class AbstractTracebackStep implements TracebackStep {

    public Set<AnnotatedEObject> traceback(Set<AnnotatedEObject> sources, Set<UnusedEvaluationRequest> pendingUnusedEvalRequests,
            TracebackCache cache) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        for (AnnotatedEObject source : sources) {
            result.addAll(traceback(source, pendingUnusedEvalRequests, cache));
        }
        return result;
    }

    public Set<AnnotatedEObject> traceback(AnnotatedEObject source, Set<UnusedEvaluationRequest> pendingUnusedEvalRequests,
            TracebackCache cache) {
        // TODO implement TracebackStep#traceback()
        return null;
    }

}
