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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet.UnusedEvaluationResult;
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
            UnusedEvaluationRequestSet reducedUnusedEvaluationRequestSet = pendingUnusedEvalRequests == null ? null
                    : pendingUnusedEvalRequests.createReducedSet(variablesThatLeaveOrEnterScopeWhenCallingStep);
            return step.traceback(source, reducedUnusedEvaluationRequestSet, tracebackCache, changeEvent);
        }
    }

    /**
     * If the expression's type for which this traceback step is constructed is class-like, {@link #requiredType} is set to the
     * expression's type.
     * 
     * @param tupleLiteralNamesToLookFor
     *            if a tuple part is being sought, the expression type will be a tuple type; in this case, extract the sought
     *            part's type as the {@link #requiredType}.
     */
    protected AbstractTracebackStep(OCLExpression sourceExpression, Stack<String> tupleLiteralNamesToLookFor) {
        EClassifier type = sourceExpression.getType();
        requiredType = getInnermostTypeConsideringTupleLiteralsLookedFor(tupleLiteralNamesToLookFor, type);
        determineUnusedEvaluationRequests(sourceExpression);
    }

    /**
     * There are a few rules for determining, whether a sub-expression is unused under a given set of variable values.
     * <ul>
     * <li><b>Unused branch in {@link IfExp}</b>: The {@link IfExp#getThenExpression() then}-expression of an {@link IfExp} is
     * unused if the {@link IfExp#getCondition() condition} of that {@link IfExp} evaluates to <code>false</code>. Analogously,
     * the {@link IfExp#getElseExpression() else}-expression of an {@link IfExp} is unused if the {@link IfExp#getCondition()
     * condition} of that {@link IfExp} evaluates to <code>true</code>.</li>
     * 
     * <li><b>Unused {@link LetExp let} declaration</b>: the {@link Variable#getInitExpression() initialization expression} for a
     * <code>let</code>-variable is unused if all {@link VariableExp} expressions referring to that variable are unused within the
     * {@link LetExp#getIn() in}-expression.</li>
     * 
     * <li><b>Unused {@link OperationCallExp#getArgument() argument} expression of an operation call</b>: the argument of an
     * operation call is unused if all {@link VariableExp} expression in the operation body referring to the corresponding formal
     * parameter are unused.</li>
     * 
     * <li><b>Unused body of loop over empty collection</b>: The body expression of any {@link LoopExp} expression won't be used
     * if the {@link LoopExp#getSource() source} of the loop expression evaluates to an empty collection.</li>
     * 
     * <li><b>Unused element of ordered collection literal in conjunction with <code>-&gt;at(...)</code></b>: When the
     * <code>-&gt;at(...)</code> standard library operation is applied to an ordered collection literal and it is possible to
     * evaluate the argument of the <code>at</code> call, all literal items at other positions than the one identified by the
     * argument are unused.</li>
     * 
     * <li><b>Composition rule</b>: An expression is unused if its {@link EObject#eContainer() containing expression} is unused.</li>
     * </ul>
     * 
     * Eventually, unused checks perform one or more {@link PartialEvaluator (partial) evaluations} of expressions which are
     * reached by navigation across the OCL expression's AST, starting from the expression whose "unusedness" is to be proven.
     * Similar to the scope changes implied by the AST navigations during
     * {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, TracebackCache, Notification)}, these navigations leave and
     * enter dynamic variable scopes. Once a variable's scope is left or a new one entered, we currently don't assume that the
     * {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, TracebackCache, Notification)} calculation will be able
     * reliably perform dynamic scope matching. Therefore, we don't expect to be able to infer a variable's value anymore, once
     * its dynamic scope has been left or (re-)entered.
     * <p>
     * 
     * Therefore, this method produces {@link UnusedEvaluationRequest}s which hold slots only for variables that remained in scope
     * during the AST navigation from the <code>sourceExpression</code> to the expression to be evaluated during the "unused"
     * check. They are stored in the {@link TracebackStep} whose expression's unusedness they shall prove. When a step is executed
     * by invoking its {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, TracebackCache, Notification)} method,
     * these requests are {@link UnusedEvaluationRequest#evaluate(com.sap.emf.ocl.hiddenopposites.OppositeEndFinder) evaluated}.
     * using {@link UnusedEvaluationRequestSet#evaluate(Set, com.sap.emf.ocl.hiddenopposites.OppositeEndFinder)}. If this proves
     * that the expression is unused, an empty set can be returned right away. Otherwise, the follow-up
     * {@link UnusedEvaluationRequestSet} delivered via {@link UnusedEvaluationResult#getNewRequestSet()} is merged with the one
     * passed to {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, TracebackCache, Notification)}.
     * <p>
     * 
     * It may happen that a <code>let</code>-variable is unknown during a partial evaluation attempt but that its initialization
     * expression can successfully be evaluated with the variable values inferred. In this case, the <code>let</code>-variable is
     * <em>indirectly inferred</em>. Similarly, a formal operation parameter may be unknown while trying to prove that it or
     * another formal parameter is unused. However, these types of unused checks for formal operation parameters may be performed
     * based on the "Unused {@link OperationCallExp#getArgument() argument} expression of an operation call" rule. In this case,
     * the argument expressions are known and an attempt can be made to evaluate them. If such an evaluation succeeds, the
     * evaluation result represents the inferred value of the corresponding formal parameter.
     */
    private void determineUnusedEvaluationRequests(OCLExpression sourceExpression) {
        // TODO Implement AbstractTracebackStep.determineUnusedEvaluationRequests(...)
        
    }

    protected EClass getInnermostTypeConsideringTupleLiteralsLookedFor(Stack<String> tupleLiteralNamesToLookFor, EClassifier type) {
        EClass result;
        if (tupleLiteralNamesToLookFor == null || tupleLiteralNamesToLookFor.isEmpty()) {
            result = getInnermostClass(type);
        } else {
            EClassifier currentType = getInnermostElementType(type);
            int i=tupleLiteralNamesToLookFor.size()-1;
            while (i>=0) {
                TupleType tt = (TupleType) currentType;
                EStructuralFeature part = tt.getEStructuralFeature(tupleLiteralNamesToLookFor.get(i));
                currentType = getInnermostClass(part.getEType());
                i--;
            }
            result = (EClass) currentType;
        }
        return result;
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
     * We assume a collection, possibly nested, that eventually has elements of a class-like type inside. If the innermost
     * type is not an {@link EClass}, <code>null</code> is returned.
     */
    protected EClass getInnermostClass(EClassifier type) {
        EClass result = null;
        while (!(type instanceof EClass) && type instanceof CollectionType) {
            type = ((CollectionType) type).getElementType();
        }
        if (type instanceof EClass) {
            result = (EClass) type;
        }
        return result;
    }

    /**
     * We assume a collection, possibly nested, that eventually has elements of a class-like type inside. If the innermost
     * type is not an {@link EClass}, <code>null</code> is returned.
     */
    protected EClassifier getInnermostElementType(EClassifier type) {
        while (!(type instanceof EClass) && type instanceof CollectionType) {
            type = ((CollectionType) type).getElementType();
        }
        return type;
    }

    protected Stack<String> cloneWithTypeCheck(Stack<String> tupleLiteralNamesToLookFor) {
        if (tupleLiteralNamesToLookFor == null) {
            return null;
        }
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
