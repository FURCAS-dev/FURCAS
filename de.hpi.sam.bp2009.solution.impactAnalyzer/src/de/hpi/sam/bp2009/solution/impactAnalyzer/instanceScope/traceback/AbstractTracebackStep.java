package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public abstract class AbstractTracebackStep implements TracebackStep {
    
    protected Map<String, TracebackStep> nextSteps = Collections.emptyMap();
    
    protected Set<AnnotatedEObject> traceback(Set<AnnotatedEObject> sources, Set<UnusedEvaluationRequest> pendingUnusedEvalRequests,
            TracebackCache cache) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        for (AnnotatedEObject source : sources) {
            result.addAll(traceback(source, pendingUnusedEvalRequests, cache));
        }
        return result;
    }

    public Set<AnnotatedEObject> traceback(AnnotatedEObject source, Set<UnusedEvaluationRequest> pendingUnusedEvalRequests,
            TracebackCache tracebackCache) {
        // TODO refine TracebackStep#traceback()        
        if(OptimizationActivation.getOption().isUnusedDetectionActive()){
            performUnusedDetection();
        }
        performScopeTransition();
        return performSubsequentTraceback(source, pendingUnusedEvalRequests, tracebackCache);
    }

    /**
     * This method is used to invoke the {@link TracebackStep#traceback(AnnotatedEObject, Set, TracebackCache)} method on all necessary subsequent {@link TracebackStep}s and return their results.
     * Which subsequent steps are necessary depends on the respective <code>source</code> {@link OCLExpression} the {@link TracebackStep} was created for.
     * @return
     */
    protected abstract Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source, Set<UnusedEvaluationRequest> pendingUnusedEvalRequests, TracebackCache tracebackCache);

    protected void performScopeTransition() {
        // TODO implement AbstractTracebackStep#performScopeTransition()
        
    }

    protected void performUnusedDetection() {
        // TODO implement AbstractTracebackStep#performUnusedDetection()
        
    }
}
