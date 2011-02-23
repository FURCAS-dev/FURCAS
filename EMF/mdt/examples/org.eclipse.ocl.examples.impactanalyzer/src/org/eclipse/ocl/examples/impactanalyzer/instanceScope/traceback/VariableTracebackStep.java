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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet.UnusedEvaluationResult;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OclHelper;
import org.eclipse.ocl.examples.impactanalyzer.util.OperationCallExpKeyedSet;



/**
 * The step produced will be invoked with the value for the variable. This knowledge can be helpful when trying to perform
 * partial evaluations. Variables have an {@link OCLExpression} as their scope. For example, a let-variable has the
 * {@link LetExp#getIn() in} expression as its static scope. Additionally, scopes are dynamically instantiated during
 * expression evaluation. For example, during evaluation of an {@link IterateExp}, the body expression forms the static scope
 * for the {@link IterateExp#getResult() result variable}. During each iteration, a new dynamic scope is created and the same
 * static result variable may have a different value in each dynamic scope. It is important to understand that the traceback
 * step learns about the value of the variable only in one particular dynamic scope.
 * <p>
 */
public class VariableTracebackStep extends BranchingTracebackStep<VariableExp> {
    /**
     * Tells if this step, when executed, will return the <code>fromObject</code> unmodified. This is the case if
     * the variable expression refers to a <code>self</code> variable outside of an operation body. If set to <code>true</code>,
     * the {@link #steps} are ignored.
     */
    private boolean identity = false;
    
    private final Variable variable;
    private final OppositeEndFinder oppositeEndFinder;
    private final boolean variableHasCollectionType;

    public VariableTracebackStep(VariableExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        oppositeEndFinder = tracebackStepCache.getOppositeEndFinder();
        variable = (Variable) sourceExpression.getReferredVariable();
        variableHasCollectionType = variable.getType() instanceof CollectionType;
        // enter step into cache already to let it be found during recursive lookups
        tracebackStepCache.put(sourceExpression, tupleLiteralNamesToLookFor, this);
        if (isSelf()) {
            getSteps().addAll(tracebackSelf(sourceExpression, context, tracebackStepCache, operationBodyToCallMapper, tupleLiteralNamesToLookFor));
        } else if (isIteratorVariable()) {
            getSteps().addAll(tracebackIteratorVariable(sourceExpression, context, tracebackStepCache, operationBodyToCallMapper, tupleLiteralNamesToLookFor));
        } else if (isIterateResultVariable()) {
            getSteps().addAll(tracebackIterateResultVariable(sourceExpression, context, tracebackStepCache, operationBodyToCallMapper, tupleLiteralNamesToLookFor));
        } else if (isLetVariable()) {
            getSteps().addAll(tracebackLetVariable(sourceExpression, context, tracebackStepCache, operationBodyToCallMapper, tupleLiteralNamesToLookFor));
        } else if (isOperationParameter()) {
            getSteps().addAll(tracebackOperationParameter(sourceExpression, context, tracebackStepCache, operationBodyToCallMapper, tupleLiteralNamesToLookFor));
        } else {
            throw new RuntimeException("Unknown variable expression that is neither an iterator variable "
                    + "nor an iterate result variable nor an operation parameter nor a let variable nor self: "
                    + variable.getName());
        }
    }

    @Override
    protected OperationCallExpKeyedSet performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests,
            org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache tracebackCache,
            Notification changeEvent) {
        OperationCallExpKeyedSet result;
        // don't assign collection-type variables because having inferred one value of the collection doesn't
        // tell us the complete variable value; simple example that would fail otherwise:
        // "v->size()" would evaluate to 1 instead of whatever the size of the full collection would have been.
        // Don't need to check configuration here for unused-checks being active; pendingUnusedEvalRequests will be null
        // if unused checks are not activated.
        if (pendingUnusedEvalRequests != null && !variableHasCollectionType) {
            UnusedEvaluationResult unusedResult = pendingUnusedEvalRequests.setVariable(variable, source.getAnnotatedObject(),
                    oppositeEndFinder, tracebackCache, oclFactory);
            if (unusedResult.hasProvenUnused()) {
                provenUnused++;
                result = tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
            } else {
                result = perform(source, unusedResult.getNewRequestSet(), tracebackCache, changeEvent);
            }
        } else {
            result = perform(source, null, tracebackCache, changeEvent);
        }
        return result;
    }

    private OperationCallExpKeyedSet perform(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests,
            org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        OperationCallExpKeyedSet result;
        if (identity) {
            result = tracebackCache.getOperationCallExpKeyedSetFactory().createOperationCallExpKeyedSet(source);
        } else {
            result = super.performSubsequentTraceback(source, pendingUnusedEvalRequests, tracebackCache,
                    changeEvent);
        }
        return result;
    }

    private boolean isLetVariable() {
        // let variables are contained in the letExp
        return variable.eContainer() instanceof LetExp && ((LetExp) variable.eContainer()).getVariable() == variable;
    }

    private boolean isOperationParameter() {
        return variable.getRepresentedParameter() != null;
    }

    private boolean isIterateResultVariable() {
        // result variables are contained in iterateExp
        return (variable.eContainer() instanceof IterateExp && ((IterateExp) variable.eContainer()).getResult() == variable);
    }

    private boolean isIteratorVariable() {
        return (variable.eContainer() instanceof LoopExp && ((LoopExp) variable.eContainer()).getIterator().contains(variable));
    }

    private boolean isSelf() {
        return variable.getName().equals(EcoreEnvironment.SELF_VARIABLE_NAME);
    }

    private Set<TracebackStepAndScopeChange> tracebackOperationParameter(VariableExp variableExp, EClass context,
            TracebackStepCache tracebackStepCache, OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor) {
        Set<TracebackStepAndScopeChange> result = new HashSet<TracebackStepAndScopeChange>();
        OCLExpression rootExpression = getRootExpression(variableExp);
        // all operation bodies must have been reached through at least one call; all calls are
        // recorded in the filter synthesizer's cache. Therefore, we can determine the relationship
        // between body and EOperation.
        EOperation op = operationBodyToCallMapper.getCallsOf(rootExpression).iterator().next().getReferredOperation();
        int pos = getParameterPosition(op);
        // As new operation calls change the set of OperationCallExp returned here for existing operations,
        // the PathCache cannot trivially be re-used across expression registrations. We would have to
        // invalidate all cache entries that depend on this step. Or we add steps produced for new calls to this
        // step as the calls get added; but that may require a re-assessment of the isAlwaysEmpty() calls.
        // This may not pay off.
        for (OperationCallExp call : operationBodyToCallMapper.getCallsOf(rootExpression)) {
            OCLExpression argumentExpression = (OCLExpression) call.getArgument().get(pos);
            // record in this step's getSteps() that the stepForCall belongs to call so that results are keyed
            // by OperationCallExp objects and an OperationCallTracebackStep can extract the results specific to its call fast;
            // this is done by passing "call" to createTracebackStepAndScopeChange which records it in the
            // TracebackStepAndScopeChange object so that when it gets used, it'll store the call as key for the results
            TracebackStepAndScopeChangeWithOperationCallExp stepWithScopeChange = createTracebackStepAndScopeChange(variableExp,
                    argumentExpression, call, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
            result.add(stepWithScopeChange);
        }
        return result;
    }

    /**
     * Determines the position of the parameter of operation <tt>op</tt> that is named like the variable referred to by this
     * tracer's {@link #getExpression() variable expression).
     */
    private int getParameterPosition(EOperation op) {
        return op.getEParameters().indexOf(variable.getRepresentedParameter());
    }

    private Set<TracebackStepAndScopeChange> tracebackLetVariable(VariableExp variableExpression, EClass context,
            TracebackStepCache tracebackStepCache, OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor) {
        OCLExpression initExpression = (OCLExpression) variable.getInitExpression();
        TracebackStepAndScopeChange step = createTracebackStepAndScopeChange(variableExpression, initExpression, context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
        return Collections.singleton(step);
    }

    private Set<TracebackStepAndScopeChange> tracebackIterateResultVariable(VariableExp variableExp, EClass context,
            TracebackStepCache tracebackStepCache, OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor) {
        // the init expression can't reference the result variable, therefore no recursive reference may occur here:
        TracebackStepAndScopeChange stepForInitExpression = createTracebackStepAndScopeChange(variableExp, (OCLExpression) variable
                .getInitExpression(), context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
        // the body expression, however, may reference the result variable; computing the body's navigation step graph
        // may therefore recursively look up the navigation step graph for the result variable. We therefore need to
        // enter a placeholder into the cache before we start computing the navigation step graph for the body expression:
        TracebackStepAndScopeChange stepForBodyExpression = createTracebackStepAndScopeChange(variableExp,
                (OCLExpression) ((IterateExp) variableExp.getReferredVariable().eContainer()).getBody(), context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
        HashSet<TracebackStepAndScopeChange> result = new HashSet<TracebackStepAndScopeChange>();
        result.add(stepForBodyExpression);
        result.add(stepForInitExpression);
        return result;
    }

    private Set<TracebackStepAndScopeChange> tracebackIteratorVariable(VariableExp variableExp, EClass context,
            TracebackStepCache tracebackStepCache, OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor) {
        TracebackStepAndScopeChange result = createTracebackStepAndScopeChange(
                variableExp, (OCLExpression) ((LoopExp) variableExp.getReferredVariable().eContainer()).getSource(), context, operationBodyToCallMapper,
                tupleLiteralNamesToLookFor, tracebackStepCache);
        return Collections.singleton(result);
    }

    private Set<TracebackStepAndScopeChange> tracebackSelf(VariableExp variableExp, EClass context,
            TracebackStepCache tracebackStepCache, OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor) {
        Set<TracebackStepAndScopeChange> result;
        OCLExpression rootExpression = getRootExpression(variableExp);
        EOperation op = getOperationOfWhichRootExpressionIsTheBody(rootExpression, operationBodyToCallMapper);
        if (op != null) {
            result = new HashSet<TracebackStepAndScopeChange>();
            // in an operation, self needs to be traced back to all source expressions of
            // calls to that operation
            Collection<OperationCallExp> calls = operationBodyToCallMapper.getCallsOf(rootExpression);
            for (OperationCallExp call : calls) {
                OCLExpression callSource = (OCLExpression) call.getSource();
                // record in this step's getSteps() that the stepForCall belongs to call so that results are keyed
                // by OperationCallExp objects and an OperationCallTracebackStep can extract the results specific to its call fast;
                // this is done by passing "call" to createTracebackStepAndScopeChange which records it in the
                // TracebackStepAndScopeChange object so that when it gets used, it'll store the call as key for the results
                TracebackStepAndScopeChangeWithOperationCallExp stepForCall = createTracebackStepAndScopeChange(variableExp,
                        callSource, call, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
                result.add(stepForCall);
            }
        } else {
            // self occurred outside of an operation; it evaluates to s for s being the context
            identity = true;
            result = Collections.emptySet();
        }
        return result;
    }

    private EOperation getOperationOfWhichRootExpressionIsTheBody(OCLExpression potentialBody,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        // all operation bodies must have been reached through at least one call; all calls are
        // recorded in the filter synthesizer's cache. Therefore, we can determine the relationship
        // between body and EOperation.
        Set<OperationCallExp> filterSynthesizerCallCache = operationBodyToCallMapper.getCallsOf(potentialBody);
        EOperation op = null;
        if (!filterSynthesizerCallCache.isEmpty()) {
            op = filterSynthesizerCallCache.iterator().next().getReferredOperation();
        }
        return op;
    }

    /**
     * There are a few known idiosyncrasies in the OCL "composition" hierarchy. A {@link TupleLiteralExp} does not contain its
     * {@link TupleLiteralExp#getTuplePart() tuple parts} which are variable declarations, a {@link CollectionLiteralExp} does not
     * contain its {@link CollectionLiteralExp#getParts() parts}, and of those parts, none of {@link CollectionRange} nor
     * {@link CollectionItem} contains the expressions that it uses to describe itself.
     * <p>
     * 
     * We still need to be able to determine the scope of, e.g., <tt>self</tt> or operation parameters and therefore need to
     * ascend what may be called the "logical composition hierarchy" of an OCL expression. Therefore, this operation ascends the
     * real composition hierarchy until it finds a <tt>null</tt> parent or a parent of type constraint or EAnnotation.
     * 
     * In this case, it tries the aforementioned "logical compositions" one after the other. If for one such association another
     * element is found, ascending continues there.
     */
    protected OCLExpression getRootExpression(OCLExpression e) {
        return OclHelper.getRootExpression(e);
    }

}
