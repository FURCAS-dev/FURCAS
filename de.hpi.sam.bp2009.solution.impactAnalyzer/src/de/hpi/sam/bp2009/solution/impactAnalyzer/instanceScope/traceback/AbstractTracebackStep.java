package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public abstract class AbstractTracebackStep implements TracebackStep {
    /**
     * If set to a non-<code>null</code> class, this step asserts that if the source objects passed to its
     * {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)} or
     * {@link #traceback(Set, UnusedEvaluationRequestSet, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)} operation are not compatible to that
     * type, then the result set will be empty.
     */
    protected EClass requiredType;
    
    /**
     * To avoid endless recursions, a step remembers for which combinations of <code>source</code> objects and
     * {@link UnusedEvaluationRequestSet}s it is currently executing. If any of those combinations is to be evaluated
     * again while already being evaluated by the current thread, an empty set is returned.
     */
    private static class IndirectingStepThreadLocal extends ThreadLocal<Set<Pair<AnnotatedEObject, UnusedEvaluationRequestSet>>> {
        @Override
        protected Set<Pair<AnnotatedEObject, UnusedEvaluationRequestSet>> initialValue() {
            return new HashSet<Pair<AnnotatedEObject, UnusedEvaluationRequestSet>>();
        }
    }
    private final ThreadLocal<Set<Pair<AnnotatedEObject, UnusedEvaluationRequestSet>>> currentlyEvaluatingNavigateFor = new IndirectingStepThreadLocal();
    
    /**
     * Encapsulates the scope change that has to happen before invoking a subsequent traceback step.
     * @author Axel Uhl (D043530)
     */
    protected static class TracebackStepAndScopeChange implements TracebackStep {
        private final TracebackStep step;
        private final Set<Variable> variablesThatLeaveOrEnterScopeWhenCallingStep;
        
        public TracebackStepAndScopeChange(TracebackStep step, Set<Variable> variablesThatLeaveOrEnterScopeWhenCallingStep) {
            this.step = step;
            this.variablesThatLeaveOrEnterScopeWhenCallingStep = variablesThatLeaveOrEnterScopeWhenCallingStep;
        }
        
        public Set<AnnotatedEObject> traceback(AnnotatedEObject source, UnusedEvaluationRequestSet pendingUnusedEvalRequests,
                de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
            UnusedEvaluationRequestSet reducedUnusedEvaluationRequestSet = pendingUnusedEvalRequests
                    .createReducedSet(variablesThatLeaveOrEnterScopeWhenCallingStep);
            return step.traceback(source, reducedUnusedEvaluationRequestSet, tracebackCache, changeEvent);
        }
    }
    
    /**
     * If the expression's type for which this traceback step is constructed is class-like, {@link #requiredType} is
     * set to the expression's type.
     */
    public AbstractTracebackStep(OCLExpression sourceExpression) {
        requiredType = getInnermostElementType(sourceExpression.getType());
    }

    public Set<AnnotatedEObject> traceback(AnnotatedEObject source, UnusedEvaluationRequestSet pendingUnusedEvalRequests,
            de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        Set<AnnotatedEObject> result;
        Pair<AnnotatedEObject, UnusedEvaluationRequestSet> key = new Pair<AnnotatedEObject, UnusedEvaluationRequestSet>(source, pendingUnusedEvalRequests);
        if (currentlyEvaluatingNavigateFor.get().contains(key)) {
            result = Collections.emptySet();
        } else {
            try {
                currentlyEvaluatingNavigateFor.get().add(key);
                result = tracebackCache.get(this, source, pendingUnusedEvalRequests);
                if (result == null) {
                    if (requiredType != null && !requiredType.isInstance(source.getAnnotatedObject())) {
                        result = Collections.emptySet();
                    } else {
                        result = performSubsequentTraceback(source, pendingUnusedEvalRequests, tracebackCache, changeEvent);
                    }
                    tracebackCache.put(this, source, pendingUnusedEvalRequests, result);
                }
            } finally {
                currentlyEvaluatingNavigateFor.get().remove(key);
            }
        }
        return result;
    }

    /**
     * This method is used to invoke the {@link TracebackStep#traceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)} method on all necessary subsequent {@link TracebackStep}s and return their results.
     * Which subsequent steps are necessary depends on the respective <code>source</code> {@link OCLExpression} the {@link TracebackStep} was created for.
     * @param changeEvent TODO
     */
    protected abstract Set<AnnotatedEObject> performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent);


    protected Set<Variable> getVariablesChangingScope(OCLExpression sourceExpression, OCLExpression targetExpression,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        Set<Variable> result;
        OCLExpression commonCompositionParent = commonCompositionParent(sourceExpression, targetExpression);
        if (commonCompositionParent == null) {
            result = new HashSet<Variable>();
            result.addAll(getAllVariablesInScope(sourceExpression, operationBodyToCallMapper));
            result.addAll(getAllVariablesInScope(targetExpression, operationBodyToCallMapper));
        } else {
            result = variablesIntroducedBetween(sourceExpression, commonCompositionParent, operationBodyToCallMapper);
            result.addAll(variablesIntroducedBetween(targetExpression, commonCompositionParent, operationBodyToCallMapper));
        }
        return result;
    }

    /**
     * This method returns all variables introduced by <code>parent</code> or any of its containment children, down to and
     * including <code>origin</code>.
     * 
     * @param origin
     *            The {@link OCLExpression} used as the origin of the search.
     * @param parent
     *            The {@link OCLExpression} that is an immediate or transitive containment parent of the origin (see
     *            {@link EObject#eContainer()}). Variables immediately scoped by <code>parent</code> are included in the
     *            result.
     * @return A {@link Set} of {@link OCLExpression}s containing all scope creating expressions in the containment hierarchy
     *         between origin and parent.
     */
    private Set<Variable> variablesIntroducedBetween(OCLExpression origin, OCLExpression parent,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject e = origin;
        Set<Variable> result = new HashSet<Variable>();
        do {
            if (e instanceof OCLExpression) {
                result.addAll(getVariablesScopedByExpression((OCLExpression) e, operationBodyToCallMapper));
            }
            e = e.eContainer();
        } while (e != null && e != parent);
        return result;
    }
    
    protected static Set<Variable> getVariablesScopedByExpression(OCLExpression e, OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject container = e.eContainer();
        Set<Variable> result = new HashSet<Variable>();
        if (container instanceof LoopExp && ((LoopExp) container).getBody() == e) {
            // body of a loop expression
            for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> v : ((LoopExp) container).getIterator()) {
                result.add((Variable) v);
            }
            if (container instanceof IterateExp) {
                Variable resultVariable = (Variable) ((IterateExp) container).getResult();
                if (resultVariable != null) {
                    result.add(resultVariable);
                }
            }
        } else if (container instanceof LetExp && ((LetExp) container).getIn() == e) {
            // in-expression of a let-expression
            result.add((Variable) ((LetExp) container).getVariable());
        } else {
            Set<OperationCallExp> calls = operationBodyToCallMapper.getCallsOf(e);
            if (!calls.isEmpty()) {
                // body of an operation
                result.addAll(operationBodyToCallMapper.getSelfVariablesUsedInBody(e));
                result.addAll(operationBodyToCallMapper.getParameterVariablesUsedInBody(e));
            }
        }
        return result;
    }
    
    /**
     * Starting from <code>e</code> and ascending its containment hierarchy, adds to the resulting set all variables that are scoped by
     * any of the expressions visited.
     */
    protected static Set<Variable> getAllVariablesInScope(OCLExpression e, OperationBodyToCallMapper operationBodyToCallMapper) {
        Set<Variable> result = new HashSet<Variable>();
        for (EObject cursor = e; cursor != null; cursor = cursor.eContainer()) {
            if (cursor instanceof OCLExpression) {
                result.addAll(getVariablesScopedByExpression((OCLExpression) cursor, operationBodyToCallMapper));
            }
        }
        return result;
    }

    /**
     * This method finds the common composition parent of the two given {@link OCLExpression}s. If the two expressions
     * don't have a common container, <code>null</code> is returned.
     * 
     * @param first The first {@link OCLExpression}.
     * @param second The second {@link OCLExpression}.
     * @return The common composition parent or null, in case there is none.
     */
    private static OCLExpression commonCompositionParent(OCLExpression first, OCLExpression second) {
        Set<OCLExpression> firstsContainersIncludingFirst = new HashSet<OCLExpression>();
        EObject firstsContainer = first;
        while (firstsContainer != null && firstsContainer instanceof OCLExpression) {
            firstsContainersIncludingFirst.add((OCLExpression) firstsContainer);
            firstsContainer = firstsContainer.eContainer();
        }
        EObject secondsContainer = second;
        OCLExpression result = null;
        while (result == null && secondsContainer != null && secondsContainer instanceof OCLExpression) {
            if (firstsContainersIncludingFirst.contains(secondsContainer)) {
                result = (OCLExpression) secondsContainer;
            } else {
                secondsContainer = secondsContainer.eContainer();
            }
        }
        return result;
    }
    
    protected TracebackStepAndScopeChange createTracebackStepAndScopeChange(OCLExpression sourceExpression,
            OCLExpression targetExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        return new TracebackStepAndScopeChange(tracebackStepCache.getOrCreateNavigationPath(targetExpression, context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor), getVariablesChangingScope(sourceExpression,
                targetExpression, operationBodyToCallMapper));
    }

    /**
     * We assume a collection, possibly nested, that eventually has elements of a class-like type inside.
     */
    protected EClass getInnermostElementType(EClassifier type) {
        while (!(type instanceof EClass) && type instanceof CollectionType) {
            type = ((CollectionType) type).getElementType();
        }
        return (EClass) type;
    }

    protected Stack<String> cloneWithTypeCheck(Stack<String> tupleLiteralNamesToLookFor) {
        Object clone = tupleLiteralNamesToLookFor.clone();
        if (clone instanceof Stack<?>) {
            @SuppressWarnings("unchecked")
            Stack<String> newTupleStack = (Stack<String>) clone;
            return newTupleStack;
        } else {
            throw new ClassCastException("Cloning an instance of Stack<String> didn't return an instance of the same type.");
        }
    }
}
