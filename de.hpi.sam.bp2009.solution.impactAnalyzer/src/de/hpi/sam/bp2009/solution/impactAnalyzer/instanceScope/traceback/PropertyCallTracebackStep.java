package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.TupleType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class PropertyCallTracebackStep extends AbstractTracebackStep {
    
    private final Set<TracebackStep> nextSteps;
    

    public PropertyCallTracebackStep(PropertyCallExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression);
        nextSteps = new HashSet<TracebackStep>();
        if (((PropertyCallExp)sourceExpression).getSource().getType() instanceof TupleType){
            
        }
    }

    @Override
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache) {
        // TODO implement AbstractTracebackStep#performSubsequentTraceback()
        return null;
    }

}
