package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.VariableExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * Objects of classes implementing this interface are constructed by
 * {@link TracebackStepCache#createStep(org.eclipse.ocl.ecore.OCLExpression, org.eclipse.emf.ecore.EClass, de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper, java.util.Stack)}
 * . For each (sub-)expression visited in the OCL AST, such a step is created. The constructors try to perform as much
 * pre-computation as possible so that when executing the step with its
 * {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, TracebackCache, Notification)} method, as little effort as possible needs to
 * be spent.
 * <p>
 * 
 * When being executed, the step computes a conservative superset of the objects that, when used as the context for the overall
 * {@link OCLExpression}, lead to the expression for which this {@link TracebackStep} was created evaluating to
 * <code>source</code>.
 * 
 * @author Martin Hanysz
 * @author Axel Uhl
 */
public interface TracebackStep {

    /**
     * When being executed, the step computes a conservative superset of the objects that, when used as the context for the
     * overall {@link OCLExpression}, may cause the expression for which this {@link TracebackStep} was created to evaluate to
     * <code>source</code>.
     * 
     * @param source
     *            the object to which the expression, for which this step was created, shall evaluate
     * @param pendingUnusedEvalRequests
     *            When tracing back a {@link VariableExp} expression, this infers a value for the variable referred to by the
     *            expression. This may trigger a previously delayed "unused" evaluation to be triggered. Those triggerable
     *            "unused" evaluation requests are passed using this parameter. When triggering one of them proves the location of
     *            the original change to be unused, an empty set will result from this call.
     * @param tracebackCache
     *            cache in which previous results of
     *            {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, TracebackCache, Notification)} executions can be found
     * @param changeEvent TODO
     * @return
     */
    public Set<AnnotatedEObject> traceback(AnnotatedEObject source, UnusedEvaluationRequestSet pendingUnusedEvalRequests,
            TracebackCache tracebackCache, Notification changeEvent);

}
