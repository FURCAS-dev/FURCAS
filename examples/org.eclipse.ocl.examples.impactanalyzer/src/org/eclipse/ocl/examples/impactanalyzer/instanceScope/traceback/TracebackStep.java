/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OperationCallExpKeyedSet;


/**
 * Objects of classes implementing this interface are constructed by
 * {@link TracebackStepCache#createStep(org.eclipse.ocl.ecore.OCLExpression, org.eclipse.emf.ecore.EClass, de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper, java.util.Stack, OCLFactory)}
 * . For each (sub-)expression visited in the OCL AST, such a step is created. The constructors try to perform as much
 * pre-computation as possible so that when executing the step with its
 * {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache, Notification)} method, as little effort as possible needs to
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
     *            the original change to be unused, an empty set will result from this call. May be <code>null</code>, having the
     *            same effect as passing a set that contains no requests.
     * @param tracebackCache
     *            cache in which previous results of
     *            {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache, Notification)}
     *            executions can be found
     * @param changeEvent
     *            the original change event; used for performing pre/post evaluations
     * @return the set of objects (with optional annotation explaining the derivation path of each object) for which, when used as
     *         context for the overall expression, the OCL (sub-)expression for which this step is responsible may evaluate to
     *         <code>source</code>. The resulting objects may additionally be keyed by {@link OperationCallExp} expressions in case
     *         their inference left an operation body through a <code>self</code> or parameter variable. These keys are
     *         removed again in the {@link OperationCallTracebackStep}, keying the results specific to the call being traced
     *         by the <code>null</code> key. All object reached without leaving an operation body through a <code>self</code>
     *         or parameter variable are also keyed by the <code>null</code> key.
     */
    public OperationCallExpKeyedSet traceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests,
            org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent);

}
