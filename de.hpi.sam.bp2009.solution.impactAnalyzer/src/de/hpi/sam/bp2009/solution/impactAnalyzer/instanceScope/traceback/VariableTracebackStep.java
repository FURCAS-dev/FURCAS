package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.util.OclHelper;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet.UnusedEvaluationResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

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
public class VariableTracebackStep extends BranchingTracebackStep {
    /**
     * Tells if this step, when executed, will return the <code>fromObject</code> unmodified. This is the case if
     * the variable expression refers to a <code>self</code> variable outside of an operation body. If set to <code>true</code>,
     * the {@link #steps} are ignored.
     */
    private boolean identity = false;
    
    private final Variable variable;
    private final OppositeEndFinder oppositeEndFinder;

    public VariableTracebackStep(VariableExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor,
            TracebackStepCache tracebackStepCache) {
        super(sourceExpression);
        oppositeEndFinder = tracebackStepCache.getOppositeEndFinder();
        variable = (Variable) sourceExpression.getReferredVariable();
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
    protected Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, TracebackCache tracebackCache, Notification changeEvent) {
        Set<AnnotatedEObject> result;
        UnusedEvaluationResult unusedResult = pendingUnusedEvalRequests.setVariable(variable, source.getAnnotatedObject(), oppositeEndFinder);
        if (!unusedResult.hasProvenUnused()) {
            if (identity) {
                result = Collections.singleton(source);
            } else {
                result = super.performSubsequentTraceback(source, unusedResult.getNewRequestSet(), tracebackCache, changeEvent);
            }
        } else {
            result = Collections.emptySet();
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
            TracebackStepAndScopeChange stepWithScopeChange = createTracebackStepAndScopeChange(variableExp,
                    argumentExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
            result.add(stepWithScopeChange);
        }
        return result;
    }

    /**
     * Determines the position of the parameter of operation <tt>op</tt> that is named like the variable referred to by this
     * tracer's {@link #getExpression() variable expression).
     */
    private int getParameterPosition(EOperation op) {
        String variableName = variable.getName();
        // determine position of formal IN_DIR parameter named variableName
        int pos = 0;
        EList<EObject> pList = op.eContents();
        for (EObject p : pList) {
            if (p instanceof EParameter) {
                if (variableName.equals(((EParameter) p).getName())) {
                    break;
                } else {
                    pos++;
                }
            }
        }
        return pos;
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
                (OCLExpression) ((IterateExp) variableExp.eContainer()).getBody(), context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
        HashSet<TracebackStepAndScopeChange> result = new HashSet<TracebackStepAndScopeChange>();
        result.add(stepForBodyExpression);
        result.add(stepForInitExpression);
        return result;
    }

    private Set<TracebackStepAndScopeChange> tracebackIteratorVariable(VariableExp variableExp, EClass context,
            TracebackStepCache tracebackStepCache, OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor) {
        TracebackStepAndScopeChange result = createTracebackStepAndScopeChange(
                variableExp, (OCLExpression) ((LoopExp) variableExp.eContainer()).getSource(), context, operationBodyToCallMapper,
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
                TracebackStepAndScopeChange stepForCall = createTracebackStepAndScopeChange(variableExp, callSource, context,
                        operationBodyToCallMapper, tupleLiteralNamesToLookFor, tracebackStepCache);
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
