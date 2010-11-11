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
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;

import com.sap.emf.ocl.util.OclHelper;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.UnusedEvaluationRequestSet.UnusedEvaluationResult;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.HighlightingToStringVisitor;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OperationCallExpKeyedSet;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public abstract class AbstractTracebackStep<E extends OCLExpression> implements TracebackStep {
    /**
     * If set to a non-<code>null</code> class, this step asserts that if the source objects passed to its
     * {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)} or
     * {@link #traceback(Set, UnusedEvaluationRequestSet, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)} operation are not compatible to that
     * type, then the result set will be empty.
     */
    protected EClass requiredType;
    
    /**
     * The OCL expression for which this is the traceback step
     */
    private final E expression;
    
    /**
     * Descriptions of the partial evaluations to perform when executing this step, in order to try to prove that the
     * {@link #expression} is unused by the particular change currently being traced back.
     * 
     * @see #determineUnusedEvaluationRequests(OCLExpression, OperationBodyToCallMapper, UnusedEvaluationRequestFactory)
     */
    private final Set<UnusedEvaluationRequest> unusedEvaluationRequests;
    
    /**
     * To avoid endless recursions, a step remembers for which combinations of <code>source</code> objects and
     * {@link UnusedEvaluationRequestSet}s it is currently executing. If any of those combinations is to be evaluated
     * again while already being evaluated by the current thread, an empty set is returned. It uses the two attributes
     * {@link #currentlyEvaluatingTracebackFor} and {@link #listOfKeysCurrentlyEvaluatingTracebackFor} for this purpose to
     * be memory-economic. If not evaluating for any key, both are <code>null</code>. If evaluating for a single key,
     * that key is stored in {@link #currentlyEvaluatingTracebackFor}. If evaluating for multiple objects,
     * {@link #currentlyEvaluatingTracebackFor} is <code>null</code>, and {@link #listOfKeysCurrentlyEvaluatingTracebackFor}
     * holds a collection of keys for which the step is currently evaluating.<p>
     * 
     * @see #startEvaluationFor(Pair)
     * @see #finishedEvaluationFor(Pair)
     * @see #isCurrentlyEvaluatingFor(Pair)
     */
    private Pair<AnnotatedEObject, UnusedEvaluationRequestSet> currentlyEvaluatingTracebackFor;
    private Collection<Pair<AnnotatedEObject, UnusedEvaluationRequestSet>> listOfKeysCurrentlyEvaluatingTracebackFor;

    private final OppositeEndFinder oppositeEndFinder;
    
    /**
     * Used in "debug" mode, storing this step's annotation string to be used in {@link AnnotatedEObject}s to explain how
     * a result was inferred.
     */
    private final String annotation;
    
    protected final OCLFactory oclFactory;

    /**
     * Encapsulates the scope change that has to happen before invoking a subsequent traceback step.
     * @author Axel Uhl (D043530)
     */
    public static class TracebackStepAndScopeChange implements TracebackStep {
        private final TracebackStep step;
        private final Set<Variable> variablesThatLeaveOrEnterScopeWhenCallingStep;
        
        public TracebackStepAndScopeChange(TracebackStep step, Set<Variable> variablesThatLeaveOrEnterScopeWhenCallingStep) {
            this.step = step;
            this.variablesThatLeaveOrEnterScopeWhenCallingStep = variablesThatLeaveOrEnterScopeWhenCallingStep;
        }
        
        public OperationCallExpKeyedSet traceback(AnnotatedEObject source, UnusedEvaluationRequestSet pendingUnusedEvalRequests,
                de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
            UnusedEvaluationRequestSet reducedUnusedEvaluationRequestSet;
            if (tracebackCache.getConfiguration().isUnusedDetectionActive()) {
                reducedUnusedEvaluationRequestSet = pendingUnusedEvalRequests == null ? null
                        : pendingUnusedEvalRequests.createReducedSet(variablesThatLeaveOrEnterScopeWhenCallingStep,
                                tracebackCache.getUnusedEvaluationRequestFactory());
            } else {
                reducedUnusedEvaluationRequestSet = null;
            }
            return step.traceback(source, reducedUnusedEvaluationRequestSet, tracebackCache, changeEvent);
        }
        
        public String toString() {
            StringBuilder result = new StringBuilder("Unscope ");
            for (Variable v : variablesThatLeaveOrEnterScopeWhenCallingStep) {
                result.append(v.getName());
                result.append(", ");
            }
            result.append("then perform ");
            result.append(step);
            return result.toString();
        }
    }
    
    /**
     * When executed using the {@link #traceback(AnnotatedEObject, UnusedEvaluationRequestSet, TracebackCache, Notification)} method,
     * results will be keyed with {@link #callToWhichResultsAreSpecific} because the {@link TracebackStep} encapsulated by this object
     * navigates back to the specified call expression, and there either to the source or an argument expression.
     * 
     * @see OperationCallExpKeyedSet
     * @author Axel Uhl (D043530)
     *
     */
    protected static class TracebackStepAndScopeChangeWithOperationCallExp extends TracebackStepAndScopeChange {
        private final OperationCallExp callToWhichResultsAreSpecific;

        /**
         * Remembers <code>call</code> as the only operation call through which 
         * @param orCreateNavigationPath
         * @param variablesChangingScope
         * @param callToWhichResultsAreSpecific
         */
        public TracebackStepAndScopeChangeWithOperationCallExp(TracebackStep step, Set<Variable> variablesChangingScope,
                OperationCallExp callToWhichResultsAreSpecific) {
            super(step, variablesChangingScope);
            this.callToWhichResultsAreSpecific = callToWhichResultsAreSpecific;
        }

        public OperationCallExpKeyedSet traceback(AnnotatedEObject source, UnusedEvaluationRequestSet pendingUnusedEvalRequests,
                de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache,
                Notification changeEvent) {
            OperationCallExpKeyedSet resultsForSourceOrArgument = super.traceback(source, pendingUnusedEvalRequests,
                    tracebackCache, changeEvent);
            OperationCallExpKeyedSet result = tracebackCache.getOperationCallExpKeyedSetFactory().createOperationCallExpKeyedSet(
                    callToWhichResultsAreSpecific, resultsForSourceOrArgument);
            return result;
        }

        public String toString() {
            StringBuilder result = new StringBuilder(super.toString());
            result.append(", then filter for results specific to OperationCallExp ");
            result.append(callToWhichResultsAreSpecific);
            return result.toString();
        }        
    }

    /**
     * If the expression's type for which this traceback step is constructed is class-like, {@link #requiredType} is set to the
     * expression's type.
     * @param tupleLiteralNamesToLookFor
     *            if a tuple part is being sought, the expression type will be a tuple type; in this case, extract the sought
     *            part's type as the {@link #requiredType}.
     */
    protected AbstractTracebackStep(E sourceExpression, Stack<String> tupleLiteralNamesToLookFor,
            OppositeEndFinder oppositeEndFinder, OperationBodyToCallMapper operationBodyToCallMapper,
            UnusedEvaluationRequestFactory unusedEvaluationRequestFactory, OCLFactory oclFactory) {
        this.expression = sourceExpression;
        this.oppositeEndFinder = oppositeEndFinder;
        this.oclFactory = oclFactory;
        EClassifier type = sourceExpression.getType();
        requiredType = getInnermostTypeConsideringTupleLiteralsLookedFor(tupleLiteralNamesToLookFor, type);
        if (OptimizationActivation.getOption().isUnusedDetectionActive()) {
            unusedEvaluationRequests = determineUnusedEvaluationRequests(getExpression(), operationBodyToCallMapper,
                    unusedEvaluationRequestFactory);
        } else {
            unusedEvaluationRequests = null;
        }
        annotation = getVerboseDebugInfo(operationBodyToCallMapper);
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
     * these requests are {@link UnusedEvaluationRequest#evaluate(org.eclipse.emf.ecore.opposites.OppositeEndFinder, OCL) evaluated}.
     * using {@link UnusedEvaluationRequestSet#evaluate(Set, org.eclipse.emf.ecore.opposites.OppositeEndFinder, TracebackCache, OCL)}. If this proves
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
     * @return the set of evaluation requests with which to try to prove unusedness of the {@link #expression}
     */
    private Set<UnusedEvaluationRequest> determineUnusedEvaluationRequests(OCLExpression e,
            OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        Set<UnusedEvaluationRequest> result = new HashSet<UnusedEvaluationRequest>();
        OCLExpression root = OclHelper.getRootExpression(e);
        Set<Variable> variablesInScope = getAllVariablesInScope(e, operationBodyToCallMapper);
        return determineUnusedEvaluationRequests(e, root, variablesInScope, operationBodyToCallMapper, result, unusedEvaluationRequestFactory);
    }

    /**
     * @param upTo during following the composition rule, ascends up to this expression and no further
     * @return <code>result</code>
     */
    private Set<UnusedEvaluationRequest> determineUnusedEvaluationRequests(OCLExpression e, OCLExpression upTo,
            Set<Variable> variablesInScope, OperationBodyToCallMapper operationBodyToCallMapper, Set<UnusedEvaluationRequest> result, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        UnusedEvaluationRequest thenClauseRequest = getThenClauseUnusedCheckRequest(e, variablesInScope, operationBodyToCallMapper, unusedEvaluationRequestFactory);
        if (thenClauseRequest != null) {
            result.add(thenClauseRequest);
        } else {
            UnusedEvaluationRequest elseClauseRequest = getElseClauseUnusedCheckRequest(e, variablesInScope, operationBodyToCallMapper, unusedEvaluationRequestFactory);
            if (elseClauseRequest != null) {
                result.add(elseClauseRequest);
            } else {
                UnusedEvaluationRequest loopBodyRequest = getLoopBodyUnusedCheckRequest(e, variablesInScope, operationBodyToCallMapper, unusedEvaluationRequestFactory);
                if (loopBodyRequest != null) {
                    result.add(loopBodyRequest);
                } else {
                    Set<UnusedEvaluationRequest> letVariableInitRequests = getLetVariableInitUnusedCheckRequests(e, variablesInScope, operationBodyToCallMapper, oppositeEndFinder, unusedEvaluationRequestFactory);
                    if (letVariableInitRequests != null) {
                        result.addAll(letVariableInitRequests);
                    } else {
                        Set<UnusedEvaluationRequest> operationArgumentRequests = getOperationArgumentUnusedCheckRequests(e, variablesInScope, operationBodyToCallMapper);
                        if (operationArgumentRequests != null) {
                            result.addAll(operationArgumentRequests);
                        } else {
                            UnusedEvaluationRequest collectionLiteralWithAtRequest = getCollectionLiteralWithAtUnusedCheckRequest(e, variablesInScope, operationBodyToCallMapper);
                            if (collectionLiteralWithAtRequest != null) {
                                result.add(collectionLiteralWithAtRequest);
                            }
                        }
                    }
                }
            }
        }
        Set<UnusedEvaluationRequest> compositeParentRequests = getCompositeParentUnusedCheckRequests(e, upTo,
                variablesInScope, new HashSet<UnusedEvaluationRequest>(), operationBodyToCallMapper, unusedEvaluationRequestFactory);
        result.addAll(compositeParentRequests);
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    /**
     * @param e the expression for which to investigate unusedness
     * @param upTo during following the composition rule, ascends up to this expression and no further
     * @param result a set to which to add the results and which to return
     * @return <code>requestsToAddTo</code>
     */
    private Set<UnusedEvaluationRequest> getCompositeParentUnusedCheckRequests(OCLExpression e, OCLExpression upTo,
            Set<Variable> variablesInScope, Set<UnusedEvaluationRequest> result, OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        EObject container = e.eContainer();
        while (container != null && !(container instanceof OCLExpression)) {
            container = container.eContainer();
        }
        if (container != null && container instanceof OCLExpression) {
            Set<Variable> variablesLeavingScope = getVariablesScopedByExpression(e, operationBodyToCallMapper);
            Set<Variable> remainingVariablesInScope = new HashSet<Variable>(variablesInScope);
            remainingVariablesInScope.removeAll(variablesLeavingScope);
            determineUnusedEvaluationRequests((OCLExpression) container, upTo, remainingVariablesInScope,
                    operationBodyToCallMapper, result, unusedEvaluationRequestFactory);
        }
        return result;
    }

    private UnusedEvaluationRequest getCollectionLiteralWithAtUnusedCheckRequest(OCLExpression e, Set<Variable> variablesInScope,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        // TODO Implement AbstractTracebackStep.getCollectionLiteralWithAtUnusedCheckRequest(...)
        return null;
    }

    private Set<UnusedEvaluationRequest> getOperationArgumentUnusedCheckRequests(OCLExpression e, Set<Variable> variablesInScope,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        // TODO Implement AbstractTracebackStep.getOperationArgumentUnusedCheckRequests(...)
        return null;
    }

    private Set<UnusedEvaluationRequest> getLetVariableInitUnusedCheckRequests(OCLExpression e, Set<Variable> variablesInScope,
            OperationBodyToCallMapper operationBodyToCallMapper, OppositeEndFinder oppositeEndFinder, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        Set<UnusedEvaluationRequest> result = new HashSet<UnusedEvaluationRequest>();
        EObject container = e.eContainer();
        if (container != null && container instanceof Variable && ((Variable) container).getInitExpression() == e) {
            EObject letCandidate = container.eContainer();
            if (letCandidate instanceof LetExp && ((LetExp) letCandidate).getIn() == e) {
                Collection<EObject> variableExps = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(EcorePackage.eINSTANCE.getVariableExp().getEStructuralFeature(
                        EcorePackage.VARIABLE_EXP__REFERRED_VARIABLE), container);
                for (EObject ve : variableExps) {
                    VariableExp variableExp = (VariableExp) ve;
                    Set<Variable> variableScopeChange = getVariablesChangingScope(e, variableExp, operationBodyToCallMapper);
                    Set<Variable> newScope = new HashSet<Variable>(variablesInScope);
                    newScope.removeAll(variableScopeChange);
                    determineUnusedEvaluationRequests(variableExp,
                            /* up to */ (OCLExpression) ((LetExp) letCandidate).getIn(),
                            newScope, operationBodyToCallMapper, result, unusedEvaluationRequestFactory);
                }
            }
        }
        return result;
    }

    private UnusedEvaluationRequest getLoopBodyUnusedCheckRequest(OCLExpression e, Set<Variable> variablesInScope,
            OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        UnusedEvaluationRequest result = null;
        EObject container = e.eContainer();
        if (container instanceof LoopExp && ((LoopExp) container).getBody() == e) {
            Set<Variable> variablesInScopeReducedByIteratorsAndResult = new HashSet<Variable>(variablesInScope);
            variablesInScopeReducedByIteratorsAndResult.removeAll(((LoopExp) container).getIterator());
            if (container instanceof IterateExp) {
                Variable resultVariable = (Variable) ((IterateExp) container).getResult();
                if (resultVariable != null) {
                    variablesInScopeReducedByIteratorsAndResult.remove(resultVariable);
                }
            }
            result = unusedEvaluationRequestFactory.getUnusedEvaluationRequest((OCLExpression) ((LoopExp) container).getSource(),
                    /* unused if */ null /* meaning empty */, null, variablesInScopeReducedByIteratorsAndResult);
        }
        return result;
    }

    private UnusedEvaluationRequest getElseClauseUnusedCheckRequest(OCLExpression e, Set<Variable> variablesInScope,
            OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        UnusedEvaluationRequest result = null;
        EObject container = e.eContainer();
        if (container instanceof IfExp && ((IfExp) container).getElseExpression() == e) {
            result = unusedEvaluationRequestFactory.getUnusedEvaluationRequest((OCLExpression) ((IfExp) container).getCondition(), /* unused if */ true, null,
                    variablesInScope);
        }
        return result;
    }

    private UnusedEvaluationRequest getThenClauseUnusedCheckRequest(OCLExpression e, Set<Variable> variablesInScope,
            OperationBodyToCallMapper operationBodyToCallMapper, UnusedEvaluationRequestFactory unusedEvaluationRequestFactory) {
        UnusedEvaluationRequest result = null;
        EObject container = e.eContainer();
        if (container instanceof IfExp && ((IfExp) container).getThenExpression() == e) {
            result = unusedEvaluationRequestFactory.getUnusedEvaluationRequest((OCLExpression) ((IfExp) container).getCondition(), /* unused if */ false, null,
                    variablesInScope);
        }
        return result;
    }

    /**
     * @return the expression for which this step is responsible
     */
    public E getExpression() {
        return expression;
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

    public OperationCallExpKeyedSet traceback(AnnotatedEObject source, UnusedEvaluationRequestSet pendingUnusedEvalRequests,
            de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent) {
        OperationCallExpKeyedSet result;
        Pair<AnnotatedEObject, UnusedEvaluationRequestSet> key = new Pair<AnnotatedEObject, UnusedEvaluationRequestSet>(source, pendingUnusedEvalRequests);
        if (isCurrentlyEvaluatingFor(key)) {
            result = tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
        } else {
            try {
                startEvaluationFor(key);
                result = tracebackCache.get(this, source, pendingUnusedEvalRequests);
                if (result == null) {
                    if (requiredType != null && !requiredType.isInstance(source.getAnnotatedObject())) {
                        result = tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
                    } else {
                        if (tracebackCache.getConfiguration().isUnusedDetectionActive()) {
                            // try to prove unusedness with the unused rules recorded for this step; if that fails,
                            // merge the unused evaluation requests that failed for unknown variables
                            // with the ones passed in pendingUnusedEvalRequests and carry on
                            UnusedEvaluationResult unusedEvaluationResult = UnusedEvaluationRequestSet.evaluate(
                                    unusedEvaluationRequests, oppositeEndFinder, tracebackCache, oclFactory);
                            if (unusedEvaluationResult.hasProvenUnused()) {
                                result = tracebackCache.getOperationCallExpKeyedSetFactory().emptySet();
                            } else {
                                result = performSubsequentTraceback(source,
                                        unusedEvaluationResult.getNewRequestSet() == null ? null : unusedEvaluationResult
                                                .getNewRequestSet().merge(pendingUnusedEvalRequests), tracebackCache, changeEvent);
                            }
                        } else {
                            result = performSubsequentTraceback(source, null, tracebackCache, changeEvent);
                        }
                    }
                    tracebackCache.put(this, source, pendingUnusedEvalRequests, result);
                }
            } finally {
                finishedEvaluationFor(key);
            }
        }
        return result;
    }

    private boolean isCurrentlyEvaluatingFor(Pair<AnnotatedEObject, UnusedEvaluationRequestSet> key) {
        return listOfKeysCurrentlyEvaluatingTracebackFor != null
                ? listOfKeysCurrentlyEvaluatingTracebackFor.contains(key)
                : key.equals(currentlyEvaluatingTracebackFor);
    }

    private void finishedEvaluationFor(Pair<AnnotatedEObject, UnusedEvaluationRequestSet> key) {
        if (listOfKeysCurrentlyEvaluatingTracebackFor != null) {
            if (listOfKeysCurrentlyEvaluatingTracebackFor.size() == 1) {
                listOfKeysCurrentlyEvaluatingTracebackFor = null;
            } else {
                listOfKeysCurrentlyEvaluatingTracebackFor.remove(key);
            }
        } else {
            currentlyEvaluatingTracebackFor = null;
        }
    }

    private void startEvaluationFor(Pair<AnnotatedEObject, UnusedEvaluationRequestSet> key) {
        if (listOfKeysCurrentlyEvaluatingTracebackFor != null) {
            listOfKeysCurrentlyEvaluatingTracebackFor.add(key);
        } else {
            if (currentlyEvaluatingTracebackFor == null) {
                currentlyEvaluatingTracebackFor = key;
            } else {
                listOfKeysCurrentlyEvaluatingTracebackFor = new ArrayList<Pair<AnnotatedEObject, UnusedEvaluationRequestSet>>();
                listOfKeysCurrentlyEvaluatingTracebackFor.add(currentlyEvaluatingTracebackFor);
                currentlyEvaluatingTracebackFor = null;
                listOfKeysCurrentlyEvaluatingTracebackFor.add(key);
            }
        }
    }

    /**
     * This method is used to invoke the {@link TracebackStep#traceback(AnnotatedEObject, Set, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache, Notification)} method on all necessary subsequent {@link TracebackStep}s and return their results.
     * Which subsequent steps are necessary depends on the respective <code>source</code> {@link OCLExpression} the {@link TracebackStep} was created for.
     */
    protected abstract OperationCallExpKeyedSet performSubsequentTraceback(AnnotatedEObject source,
            UnusedEvaluationRequestSet pendingUnusedEvalRequests, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache tracebackCache, Notification changeEvent);


    /**
     * @return a new set that the caller therefore may modify at will without causing any harm
     */
    private Set<Variable> getVariablesChangingScope(OCLExpression sourceExpression, OCLExpression targetExpression,
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
     * This method returns all variables introduced by <code>origin</code> or any of its containers, up to but excluding
     * <code>parent</code>. For example, if <code>parent</code> is the <code>in</code>-expression of a {@link LetExp} in which a
     * {@link LoopExp} is nested whose {@link LoopExp#getBody() body} contains <code>origin</code>, then the
     * {@link LoopExp#getIterator() iterator variables} will be part of the result, but the <code>let</code>-variable to which the
     * <code>in</code>-expression belongs will not be because it is immediately scoped by <code>parent</code>.
     * 
     * @param origin
     *            The {@link OCLExpression} used as the origin of the search.
     * @param parent
     *            The {@link OCLExpression} that is an immediate or transitive containment parent of the origin (see
     *            {@link EObject#eContainer()}). Variables immediately scoped by <code>parent</code> are included in the result.
     * @return A {@link Set} of {@link OCLExpression}s containing all scope creating expressions in the containment hierarchy
     *         between origin and parent. The set returned is new and may be modified by the caller without causing any harm.
     */
    private Set<Variable> variablesIntroducedBetween(OCLExpression origin, OCLExpression parent,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject e = origin;
        Set<Variable> result = new HashSet<Variable>();
        while (e != null && e != parent) {
            if (e instanceof OCLExpression) {
                result.addAll(getVariablesScopedByExpression((OCLExpression) e, operationBodyToCallMapper));
            }
            e = e.eContainer();
        }
        return result;
    }
    
    protected static Set<Variable> getVariablesScopedByExpression(OCLExpression e, OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject container = e.eContainer();
        Set<Variable> result = null;
        if (container instanceof LoopExp && ((LoopExp) container).getBody() == e) {
            // body of a loop expression
            result = new HashSet<Variable>();
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
            if (result == null) {
                result = new HashSet<Variable>();
            }
            // in-expression of a let-expression
            result.add((Variable) ((LetExp) container).getVariable());
        } else {
            Set<OperationCallExp> calls = operationBodyToCallMapper.getCallsOf(e);
            if (!calls.isEmpty()) {
                // body of an operation
                result = addAll(result, operationBodyToCallMapper.getSelfVariablesUsedInBody(e));
                result = addAll(result, operationBodyToCallMapper.getParameterVariablesUsedInBody(e));
            } else if (e == OclHelper.getRootExpression(e)) {
                result = addAll(result, operationBodyToCallMapper.getSelfVariablesUsedInBody(e));
            }
        }
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }
    
    private static <T> Set<T> addAll(Set<T> to, Collection<T> what) {
        if (to == null) {
            to = new HashSet<T>();
        }
        to.addAll(what);
        return to;
    }
    
    /**
     * Starting from <code>e</code> and ascending its containment hierarchy, adds to the resulting set all variables that are scoped by
     * any of the expressions visited.
     * 
     * @return a new set that the client may modify at will without doing any harm
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
    
    /**
     * Creates a new {@link TracebackStepAndScopeChange}} object. Fetches from the cache or produces the {@link TracebackStep}}
     * and computes the variable scope changes (see {@link #getVariablesChangingScope(OCLExpression, OCLExpression, OperationBodyToCallMapper)}.
     * The results of these two operations are used for the {@link TracebackStepAndScopeChange} constructor.
     */
    protected TracebackStepAndScopeChange createTracebackStepAndScopeChange(OCLExpression sourceExpression,
            OCLExpression targetExpression, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        return new TracebackStepAndScopeChange(tracebackStepCache.getOrCreateNavigationPath(targetExpression, context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, oclFactory), getVariablesChangingScope(sourceExpression,
                targetExpression, operationBodyToCallMapper));
    }

    /**
     * Creates a new {@link TracebackStepAndScopeChange}} object, remembering an {@link OperationCallExp} to which the
     * results produced by this step are specific. The results produced by the step returned will all be keyed
     * by the <code>call</code>. Fetches from the cache or produces the {@link TracebackStep}}
     * and computes the variable scope changes (see {@link #getVariablesChangingScope(OCLExpression, OCLExpression, OperationBodyToCallMapper)}.
     * The results of these two operations are used for the {@link TracebackStepAndScopeChange} constructor.
     */
    protected TracebackStepAndScopeChangeWithOperationCallExp createTracebackStepAndScopeChange(OCLExpression sourceExpression,
            OCLExpression targetExpression, OperationCallExp call, EClass context, OperationBodyToCallMapper operationBodyToCallMapper,
            Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        return new TracebackStepAndScopeChangeWithOperationCallExp(tracebackStepCache.getOrCreateNavigationPath(targetExpression, context,
                operationBodyToCallMapper, tupleLiteralNamesToLookFor, oclFactory), getVariablesChangingScope(sourceExpression,
                targetExpression, operationBodyToCallMapper), call);
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

    private String getAnnotation() {
        return annotation;
    }

    /**
     * Constructs a human-readable description of the OCL expression used as debug info for this
     * navigation step. This includes traveling up to the root expression in which the debug info
     * expression is embedded.
     */
    private String getVerboseDebugInfo(OperationBodyToCallMapper operationBodyToCallMapper) {
        try {
            if (AnnotatedEObject.IS_IN_DEBUG_MODE) {
                StringBuilder result = new StringBuilder();
                result.append(" ==== ");
                result.append(getClass().getSimpleName());
                result.append(" for expression ====\n ");
                result.append(getExpression());
                OCLExpression root = OclHelper.getRootExpression(getExpression());
                if (root != getExpression()) {
                    result.append("\n ==== in expression =====\n");
                    result.append(root.accept(HighlightingToStringVisitor.getInstance(root, getExpression())));
                }
                Set<OperationCallExp> calls = operationBodyToCallMapper.getCallsOf(root);
                result.append(!calls.isEmpty() ? "\n ===== which is the body of operation "
                        + formatOperation(calls.iterator().next().getReferredOperation()) + " ====="
                        : "");
                return result.toString();
            } else {
                return AnnotatedEObject.NOT_IN_DEBUG_MODE_MESSAGE;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String formatOperation(EOperation operation) {
        StringBuilder result = new StringBuilder(((ENamedElement) operation.eContainer()).getName());
        result.append('.');
        result.append(operation.getName());
        result.append('(');
        boolean first = true;
        for (EParameter param : operation.getEParameters()) {
            if (!first) {
                result.append(", ");
            } else {
                first = false;
            }
            result.append(param.getName());
            result.append(':');
            result.append(param.getEType().getName());
        }
        result.append(')');
        return result.toString();
    }

    /**
     * Annotates a navigation from <code>fromObject</code> to <code>next</code> by taking over <code>fromObject</code>'s annotation,
     * adding a description of this step and telling at which object the navigation arrived. In case we're not in
     * {@link AnnotatedEObject#IS_IN_DEBUG_MODE debug mode}, a default message (see {@link AnnotatedEObject#NOT_IN_DEBUG_MODE_MESSAGE})
     * is used instead to save memory.
     */
    protected AnnotatedEObject annotateEObject(AnnotatedEObject fromObject,
            EObject next) {
        if (AnnotatedEObject.IS_IN_DEBUG_MODE) {
            return new AnnotatedEObject(next, fromObject, getAnnotation());
        } else {
            return new AnnotatedEObject(next, AnnotatedEObject.NOT_IN_DEBUG_MODE_MESSAGE);
        }
    }

    /**
     * Annotates a non-navigation where <code>object</code> is forwarded unchanged from this step to another. The result is an
     * {@link AnnotatedEObject} with its from-object and reached object both being set to <code>object</code>, adding a
     * description of this step and telling at which object the navigation arrived. In case we're not in
     * {@link AnnotatedEObject#IS_IN_DEBUG_MODE debug mode}, a default message (see
     * {@link AnnotatedEObject#NOT_IN_DEBUG_MODE_MESSAGE}) is used instead to save memory.
     */
    protected AnnotatedEObject annotateEObject(AnnotatedEObject object) {
        if (AnnotatedEObject.IS_IN_DEBUG_MODE) {
            return new AnnotatedEObject(object.getAnnotatedObject(), object, getAnnotation());
        } else {
            return object;
        }
    }

    /**
     * If in {@link AnnotatedEObject#IS_IN_DEBUG_MODE debug mode}, creates a new {@link AnnotatedEObject} for each
     * one in <code>newResults</code>, assuming that there is no "from" object; as an alibi "from" object, the
     * annotated objects from <code>newResults</code> are used.
     */
    protected Set<AnnotatedEObject> annotate(AnnotatedEObject fromObject, Set<AnnotatedEObject> newResults) {
        if (AnnotatedEObject.IS_IN_DEBUG_MODE) {
            Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
            for (AnnotatedEObject newResult : newResults) {
                result.add(new AnnotatedEObject(newResult.getAnnotatedObject(), fromObject, getAnnotation()));
            }
            return result;
        } else {
            return newResults;
        }
    }

    protected OppositeEndFinder getOppositeEndFinder() {
        return oppositeEndFinder;
    }

}
