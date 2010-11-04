package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.utilities.PredefinedType;

import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.FlatSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.IterableAsOperationCallExpKeyedSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSet;

public class OperationCallTracebackStep extends BranchingTracebackStep<OperationCallExp> {
    private static final Set<String> sourcePassThroughStdLibOpNames;
    private static final Set<String> argumentPassThroughStdLibOpNames;
    static {
        sourcePassThroughStdLibOpNames = new HashSet<String>();
        sourcePassThroughStdLibOpNames.add(PredefinedType.ANY_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_BAG_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_SET_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_ORDERED_SET_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AS_SEQUENCE_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.AT_NAME);
        //       sourcePassThroughStdLibOpNames.add(PredefinedType.ATRPRE_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.EXCLUDING_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.FIRST_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.FLATTEN_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.INCLUDING_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.INSERT_AT_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.APPEND_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.INTERSECTION_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.OCL_AS_TYPE_NAME);
        sourcePassThroughStdLibOpNames.add(PredefinedType.UNION_NAME);

        argumentPassThroughStdLibOpNames = new HashSet<String>();
        argumentPassThroughStdLibOpNames.add(PredefinedType.INCLUDING_NAME);
        argumentPassThroughStdLibOpNames.add(PredefinedType.INSERT_AT_NAME);
        argumentPassThroughStdLibOpNames.add(PredefinedType.APPEND_NAME);
        argumentPassThroughStdLibOpNames.add(PredefinedType.UNION_NAME);
        // TODO what about "product"?
    }

    /**
     * If set to a non-<code>null</code> value, the step executes an all-instances query using the
     * {@link #oppositeEndFinder}. Otherwise, the steps are performed and their results returned.
     */
    private final EClass allInstancesClass;
    private final OppositeEndFinder oppositeEndFinder;

    /**
     * Set to <code>true</code> for operations whose body is specified again in OCL. For such operations, this step will trace
     * back using the body expression. Except for <code>allInstances()</code> cases this will lead back to <code>self</code> or
     * operation parameters for which then all calls to the operation will be investigated.
     * <p>
     * 
     * While it would be nice to restrict this traceback to the single call currently under investigation, we so far haven't found
     * a way to combine this with the caching technique used. We would have to record the complete call stack as part of the cache
     * key, leading to a combinatorial explosion of cache keys and therefore to almost zero cache hits.<p>
     * 
     * Instead, we compute the results for all calls but key them by the {@link OperationCallExp} through which the traceback
     * of <code>self</code> or any parameter variables went so that later we can filter for those whose call we're actually
     * interested in.<p>
     * 
     * However, this applies only for operations whose body is specified in OCL. Therefore this flag.
     */
    private final boolean filterResultsByCall;

    public OperationCallTracebackStep(OperationCallExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder(), operationBodyToCallMapper, unusedEvaluationRequestFactory, oclFactory);
        oppositeEndFinder = tracebackStepCache.getOppositeEndFinder();
        // important to enter this step before recursive lookups may occur:
        tracebackStepCache.put(sourceExpression, tupleLiteralNamesToLookFor, this);
        OCLExpression body = operationBodyToCallMapper.getOperationBody(sourceExpression.getReferredOperation());
        if (body != null) {
            allInstancesClass = null;
            filterResultsByCall = true;
            // an OCL-specified operation; trace back using the body expression
            getSteps().add(
                    createTracebackStepAndScopeChange(sourceExpression, body, context, operationBodyToCallMapper,
                            tupleLiteralNamesToLookFor, tracebackStepCache));
        } else {
            filterResultsByCall = false;
            String opName = sourceExpression.getReferredOperation().getName();
            if (opName.equals(PredefinedType.OCL_AS_TYPE_NAME)) {
                allInstancesClass = null;
                handleOclAsType(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor,
                        tracebackStepCache);
            } else if (sourcePassThroughStdLibOpNames.contains(opName)) {
                allInstancesClass = null;
                handleSourcePassThroughOperation(sourceExpression, context, operationBodyToCallMapper,
                        tupleLiteralNamesToLookFor, tracebackStepCache, opName);
            } else if (opName.equals(PredefinedType.ALL_INSTANCES_NAME)) {
                // the object from where to trace back later in the navigate method may not
                // conform to the type on which allInstances() is invoked here; for example, the
                // expression may navigate from the result of allInstances() across an association
                // defined on a superclass of the one on which allInstances() was invoked. Therefore,
                // ensure that the typing of the AllInstancesNavigationStep is correct.
                allInstancesClass = context;
            } else {
                allInstancesClass = null;
            }
            // hope, we didn't forget stdlib operations that pass on
            // source or argument values into their result
        }
    }

    private void handleSourcePassThroughOperation(OperationCallExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache, String opName) {
        // FIXME handle product
        getSteps().add(createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getSource(),
                context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache));
        if (argumentPassThroughStdLibOpNames.contains(opName)) {
            int paramPos = 0;
            if (opName.equals(PredefinedType.INSERT_AT_NAME)) {
                // "insertAt" takes two arguments, the index and the object to add.
                // The OCL spec says the index comes first, so getting the first argument makes no sense in this case.
                paramPos = 1;
            }
            OCLExpression argument = (OCLExpression) (sourceExpression.getArgument()).get(paramPos);
            getSteps().add(createTracebackStepAndScopeChange(sourceExpression, argument,
                    context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache));
        }
    }

    private void handleOclAsType(OperationCallExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache) {
        OCLExpression argument = (OCLExpression) (sourceExpression.getArgument()).get(0);
        if (argument instanceof TypeExp) {
            // trace the source expression of the cast
            getSteps().add(createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) sourceExpression.getSource(),
                    context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache));
        } else {
            throw new RuntimeException("What else could be the argument of oclAsType if not a TypeExp? "
                    + (argument.eClass()).getName());
        }
    }

    @Override
    protected OperationCallExpKeyedSet performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        OperationCallExpKeyedSet result;
        if (allInstancesClass != null) {
            FlatSet preResult = new FlatSet();
            for (EObject roi : InstanceScopeAnalysis.getAllPossibleContextInstances((Notifier) changeEvent.getNotifier(), allInstancesClass,
                    oppositeEndFinder)) {
                preResult.add(annotateEObject(source, roi));
            }
            result = preResult;
        } else {
            OperationCallExpKeyedSet preResult = (OperationCallExpKeyedSet) super
                    .performSubsequentTraceback(source, pendingUnusedEvalRequests, tracebackCache, changeEvent);
            if (filterResultsByCall && tracebackCache.getConfiguration().isOperationCallSelectionActive()) {
                result = new IterableAsOperationCallExpKeyedSet(preResult.getCombinedResultsFor(getExpression()));
//                result = new FlatSet(preResult.getCombinedResultsFor(getExpression()));
//                result = tracebackCache.getOperationCallExpKeyedSetFactory().createOperationCallExpKeyedSet(preResult.getCombinedResultsFor(getExpression()));
            } else {
                result = preResult;
            }
        }
        return result;
    }

}
