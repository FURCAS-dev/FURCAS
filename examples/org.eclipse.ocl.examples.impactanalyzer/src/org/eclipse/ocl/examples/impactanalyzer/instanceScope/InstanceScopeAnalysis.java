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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LiteralExp;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.NullLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.PrimitiveLiteralExp;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.eventmanager.NotificationHelper;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorFactoryImpl;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorImpl;
import org.eclipse.ocl.examples.impactanalyzer.filterSynthesis.FilterSynthesisImpl;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackStepCache;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OclHelper;
import org.eclipse.ocl.utilities.PredefinedType;



/**
 * Supports a lookup from a source model element of either an attribute value change event or a link add/remove event together
 * with an {@link OCLExpression<EClassifier>} to a set of context objects for which the expression may return a value different
 * from the one it returned before the change event occurred. An instance of this class manages the analysis for all expression
 * occuring within one root OCL expression, including the expressions reachable in operation body expressions where the operation
 * may be called directly of indirectly by the root expression.
 *
 */
public class InstanceScopeAnalysis extends PartialEvaluatorFactoryImpl {
    private final Logger logger = Logger.getLogger(InstanceScopeAnalysis.class.getName());
    private final PathCache pathCache;
    private final TracebackStepCache tracebackStepCache;
    private final OCLExpression expression;
    private final FilterSynthesisImpl filterSynthesizer;
    private final EClass context;
    private final OppositeEndFinder oppositeEndFinder;
    private final ActivationOption configuration;
    private final OCLFactory oclFactory;
    private final PartialEvaluatorImpl partialEvaluatorForAllInstancesDeltaPropagation;

    private static final Set<String> comparisonOpNames = new HashSet<String>(Arrays.asList(new String[] {
            PredefinedType.EQUAL_NAME, PredefinedType.LESS_THAN_NAME, PredefinedType.LESS_THAN_EQUAL_NAME,
            PredefinedType.GREATER_THAN_NAME, PredefinedType.GREATER_THAN_EQUAL_NAME, PredefinedType.NOT_EQUAL_NAME }));

    /**
     * @param expression
     *            the OCL expression for which to perform instance scope impact analysis
     * @param oppositeEndFinder
     *            used during partial evaluation and for metamodel queries, e.g., finding opposite role names, or finding all
     *            subclasses of a class; as well as for obtaining all instances of a type while performing an
     *            {@link AllInstancesNavigationStep}. It is handed to the {@link PathCache} object from where
     *            {@link Tracer}s can retrieve it using {@link PathCache#getOppositeEndFinder()}.
     */
    public InstanceScopeAnalysis(OCLExpression expression, EClass exprContext, FilterSynthesisImpl filterSynthesizer, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        this(expression, exprContext, filterSynthesizer, oppositeEndFinder, new PartialEvaluatorImpl(oclFactory, oppositeEndFinder), configuration,
                oclFactory,
                /* pathCache */ configuration.isTracebackStepISAActive() ? null : new PathCache(oppositeEndFinder), /* tracebackStepCache */ configuration.isTracebackStepISAActive() ? new TracebackStepCache(oppositeEndFinder) : null);
    }

    protected void initInstanceScopeAnalysisOnPathCache() {
        if (pathCache != null) {
            pathCache.initInstanceScopeAnalysis(this);
        }
        if (tracebackStepCache != null) {
            tracebackStepCache.initInstanceScopeAnalysis(this);
        }
    }

    protected InstanceScopeAnalysis(OCLExpression expression, EClass exprContext, FilterSynthesisImpl filterSynthesizer, OppositeEndFinder oppositeEndFinder, PartialEvaluatorImpl partialEvaluator, ActivationOption configuration, OCLFactory oclFactory, PathCache pathCache, TracebackStepCache tracebackStepCache) {
        checkConstructorArgs(expression, exprContext, filterSynthesizer);
        context = exprContext;
        this.oclFactory = oclFactory;
        this.expression = expression;
        partialEvaluatorForAllInstancesDeltaPropagation = partialEvaluator;
        this.filterSynthesizer = filterSynthesizer;
        this.oppositeEndFinder = oppositeEndFinder;
        this.configuration = configuration;
        this.tracebackStepCache = tracebackStepCache;
        this.pathCache = pathCache;
        initInstanceScopeAnalysisOnPathCache();
    }

    private void checkConstructorArgs(OCLExpression expression, EClass exprContext, FilterSynthesisImpl filterSynthesizer) {
        if (exprContext == null) {
            throw new IllegalArgumentException("exprContext must not be null. Maybe no context type specified to ImpactAnalyzerImpl constructor, and no self-expression found to infer it?");
        }
        if (expression == null || filterSynthesizer == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
    }
    
    protected PathCache getPathCache() {
        return pathCache;
    }

    /**
     * Finds all elements of type <code>cls</code> or conforming to <code>cls</code> such that based on the scope definition
     * implemented by the <code>oppositeEndFinder</code>'s
     * {@link OppositeEndFinder#getAllInstancesSeeing(EClass, org.eclipse.emf.common.notify.Notifier)} method, the elements
     * returned can "see" <code>container</code>.
     *
     * @param cls
     *            the overall context type for the entire expression; this context type defines the type for <tt>self</tt> if used
     *            outside of operation bodies.
     * @param oppositeEndFinder
     *            used to determine all instances
     */
    public static Set<EObject> getAllPossibleContextInstances(Notifier context, EClass cls, OppositeEndFinder oppositeEndFinder) {
        return oppositeEndFinder.getAllInstancesSeeing(cls, context);
    }

    /**
     * Factory method that creates an instance of some {@link Tracer}-implementing class specific to the type of the OCL
     * <tt>expression</tt>.
     * @param caller the calling tracer from which the list of tuple part names to look for are copied
     * unchanged to the new tracer created by this operation. May be <tt>null</tt> in which case the
     * new tracer does not look for any tuple literal parts initially.
     */
    protected Tracer createTracer(OCLExpression expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        // Using the class loader is another option, but that would create implicit naming conventions.
        // Thats why we do the mapping "manually".
        switch (expression.eClass().getClassifierID()) {
        case EcorePackage.PROPERTY_CALL_EXP:
            return new PropertyCallExpTracer((PropertyCallExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP:
            return new OppositePropertyCallExpTracer((OppositePropertyCallExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.BOOLEAN_LITERAL_EXP:
            return new BooleanLiteralExpTracer((BooleanLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.COLLECTION_LITERAL_EXP:
            return new CollectionLiteralExpTracer((CollectionLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.ENUM_LITERAL_EXP:
            return new EnumLiteralExpTracer((EnumLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.IF_EXP:
            return new IfExpTracer((IfExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.INTEGER_LITERAL_EXP:
            return new IntegerLiteralExpTracer((IntegerLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.ITERATE_EXP:
            return new IterateExpTracer((IterateExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.ITERATOR_EXP:
            return new IteratorExpTracer((IteratorExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.LET_EXP:
            return new LetExpTracer((LetExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.OPERATION_CALL_EXP:
            return new OperationCallExpTracer((OperationCallExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.REAL_LITERAL_EXP:
            return new RealLiteralExpTracer((RealLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.STRING_LITERAL_EXP:
            return new StringLiteralExpTracer((StringLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.TUPLE_LITERAL_EXP:
            return new TupleLiteralExpTracer((TupleLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.TYPE_EXP:
            return new TypeExpTracer((TypeExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.VARIABLE_EXP:
            return new VariableExpTracer((VariableExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.NULL_LITERAL_EXP:
            return new NullLiteralExpTracer((NullLiteralExp) expression, tuplePartNames, oclFactory);
        case EcorePackage.INVALID_LITERAL_EXP:
            return new InvalidlLiteralExpTracer((InvalidLiteralExp) expression, tuplePartNames, oclFactory);
        default:
            throw new RuntimeException("Unsupported expression type " + expression.eClass().getName());
        }
    }

    public Collection<EObject> getContextObjects(Notification event, boolean notifyOnNewContextElements) {
        Collection<EObject> resultCollection;
        if (NotificationHelper.isElementLifeCycleEvent(event)) {
            resultCollection = handleLifeCycleEvent(event, notifyOnNewContextElements);
        } else {
            resultCollection = new HashSet<EObject>();
        }
        TracebackCache cacheForNavigationSteps = createNavigationStepCache();
        org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache cacheForTracebackSteps = createTracebackStepCache();
        for (NavigationCallExp attributeOrAssociationEndCall : getAttributeOrAssociationEndCalls(event)) {
            for (AnnotatedEObject sourceElement : getSourceElement(event, attributeOrAssociationEndCall)) {
                // TODO contemplate parallel execution of hasNoEffectOnOverallExpression and self which both may take long and we
                // don't know which one takes longer
                if (!hasNoEffectOnOverallExpression(event, attributeOrAssociationEndCall, sourceElement)) {
                    if (sourceElement != null) {
                        // the source element may have been deleted already by subsequent events; at this point,
                        // this makes it impossible to trace the change event back to a context; all we have is
                        Iterable<AnnotatedEObject> selfCandidates;
                        if (configuration.isTracebackStepISAActive()) {
                            selfCandidates = selfWithTracebackSteps(attributeOrAssociationEndCall, sourceElement, context, event, cacheForTracebackSteps);
                        } else {
                            selfCandidates = selfWithNavigationSteps(attributeOrAssociationEndCall, sourceElement, context, event, cacheForNavigationSteps);
                        }
                        for (AnnotatedEObject r : selfCandidates) {
                            resultCollection.add(r.getAnnotatedObject());
                        }
                    }
                }
            }
        }
        return resultCollection;
    }

	private org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache createTracebackStepCache() {
		org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache cacheForTracebackSteps;
        if (configuration.isTracebackStepISAActive()) {
            cacheForTracebackSteps = new org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache(
                    configuration, tracebackStepCache.getUnusedEvaluationRequestFactory());
        } else {
            cacheForTracebackSteps = null;
        }
		return cacheForTracebackSteps;
	}

	private TracebackCache createNavigationStepCache() {
		TracebackCache cacheForNavigationSteps;
        if (configuration.isTracebackStepISAActive()) {
            cacheForNavigationSteps = null;
        } else {
            cacheForNavigationSteps = new TracebackCache();
        }
		return cacheForNavigationSteps;
	}

	/**
	 * Determines a superset of the set of context objects for which the overall
	 * {@link #expression} managed by this instance scope analysis results in
	 * <code>evaluationResult</code>. The result is always a valid collection,
	 * never <code>null</code>, but possibly empty.
	 * 
	 * @param evaluationResult
	 *            has to be a non-<code>null</code> {@link EObject} because
	 *            backwards navigation is not easily possible for
	 *            primitive-typed values and is impossible from
	 *            <code>null</code> values for now.
	 */
    public Collection<EObject> getContextObjects(EObject evaluationResult) {
        Iterable<AnnotatedEObject> annotatedResults;
		AnnotatedEObject startObject = createStartObject(evaluationResult);
		if (configuration.isTracebackStepISAActive()) {
	        TracebackCache cache = createNavigationStepCache();
	        NavigationStep step = getNavigationStepsToSelfForExpression(
	                expression, context);
	        Set<AnnotatedEObject> sourceElementAsSet = Collections.singleton(startObject);
	        annotatedResults = step.navigate(sourceElementAsSet, cache, /* notification */ null);
		} else {
			org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache cache = createTracebackStepCache();
	        TracebackStep step = getTracebackStepForExpression(expression, context);
	        annotatedResults = step.traceback(startObject,
	        		/* pending unused evaluation requests */ null, cache, /* notification */ null);
		}
		Set<EObject> result = new HashSet<EObject>();
		for (AnnotatedEObject annotatedResult : annotatedResults) {
			result.add(annotatedResult.getAnnotatedObject());
		}
		return result;
    }

    private boolean hasNoEffectOnOverallExpression(Notification event, NavigationCallExp attributeOrAssociationEndCall,
            AnnotatedEObject sourceElement){
	if(configuration.isDeltaPropagationActive()) {
	    PartialEvaluatorImpl partialEvaluatorAtPre = createPartialEvaluator(event, oppositeEndFinder, oclFactory);
	    Object oldValue = partialEvaluatorAtPre.evaluate(null, attributeOrAssociationEndCall, sourceElement.getAnnotatedObject());
	    PartialEvaluatorImpl partialEvaluatorAtPost = createPartialEvaluator(oppositeEndFinder, oclFactory);
	    Object newValue = partialEvaluatorAtPost.evaluate(null, attributeOrAssociationEndCall, sourceElement.getAnnotatedObject());
	    return partialEvaluatorAtPost.hasNoEffectOnOverallExpression(attributeOrAssociationEndCall, oldValue, newValue, filterSynthesizer);
	} else {
	    return false;
	}
    }

    private Collection<EObject> handleLifeCycleEvent(Notification event, boolean notifyOnNewContextElements) {
        Collection<EObject> result = new HashSet<EObject>();
        Boolean addEvent = NotificationHelper.isAddEvent(event);
        if (NotificationHelper.isManyEvent(event)) {
            List<?> featureValue;
            if (addEvent) {
                featureValue = (List<?>) event.getNewValue();
            } else {
                featureValue = (List<?>) event.getOldValue();
            }
            for (Object value : featureValue) {
                if (value instanceof EObject) {
                    if (addEvent && notifyOnNewContextElements && getContext().isInstance(value)) {
                        // put new elements into result set
                        result.add((EObject) value);
                    }
                    EClass valuesClass = ((EObject) value).eClass();
                    addAllPossibleContextsIfNonEmptyDelta(featureValue, result, event, valuesClass);
                }
            }
        } else {
            Object value;
            if (addEvent) {
                value = event.getNewValue();
            } else {
                value = event.getOldValue();
            }
            if (value instanceof EObject) {
                if (addEvent && notifyOnNewContextElements && getContext().isInstance(value)) {
                    // put new elements into result set
                    result.add((EObject) value);
                }
                Collection<Object> featureValueAsObjectCollection = Collections.singletonList(value);
                EClass valuesClass = ((EObject) value).eClass();
                addAllPossibleContextsIfNonEmptyDelta(featureValueAsObjectCollection, result, event, valuesClass);
            }
        }
        return result;
    }

    private void addAllPossibleContextsIfNonEmptyDelta(Collection<?> featureValue, Collection<EObject> result,
            Notification event, EClass eClass) {
        addAllPossibleContextsIfNotEmptyDeltaForSingleClass(featureValue, result, event, eClass);
        for (EClass superClass : eClass.getEAllSuperTypes()) {
            addAllPossibleContextsIfNotEmptyDeltaForSingleClass(featureValue, result, event, superClass);
        }
    }

    private void addAllPossibleContextsIfNotEmptyDeltaForSingleClass(Collection<?> featureValue, Collection<EObject> result,
            Notification event, EClass eClass) {
        for (OperationCallExp allInstancesCall : filterSynthesizer.getAllInstancesCallsFor(eClass)) {
            // if we can prove that the delta of allInstances() propagates to an empty set,
            // the overall expression remains unchanged by the original change:
            @SuppressWarnings("unchecked")
            Collection<Object> featureValueAsObjectCollection = (Collection<Object>) featureValue;
            if (!getPartialEvaluatorForAllInstancesDeltaPropagation().transitivelyPropagateDelta(allInstancesCall,
                    featureValueAsObjectCollection, filterSynthesizer).isEmpty()) {
                result.addAll(getAllPossibleContextInstances((Notifier) event.getNotifier(), getContext(), oppositeEndFinder));
            }
        }
    }

    /**
     * Checks if all {@link ModelChangeEvent}s contained in <tt>events</tt> are attribute changes and the expressions affected by
     * the change event are all attribute call expressions for an attribute of primitive type that is used in a direct comparison
     * with a constant literal. If this is the case, compares the old and new value with the literal's value, considering the
     * comparison operator. If no change occurs in comparison result for any of the events, <tt>true</tt> is returned because then
     * the expression value didn't change based on the change event. If any of the events is an event of different type or the
     * attribute is not of primitive type or its value is not compared to a constant, <tt>false</tt> is returned.
     * <p>
     *
     * Note that further performance improvements are conceivable but not yet implemented. For example, the attribute call
     * expression may be used in a <tt>let</tt>-expression and then the variable may be compared to a primitive literal.
     *
     * @param replacementFor__TEMP__
     *            as a special case, expressions can contain the special string literal "__TEMP__" (see
     *            GlobalDelayedReferenceResolver.TEMPORARY_QUERY_PARAM_REPLACEMENT). Those will be replaced by the value of a
     *            lexical token. This value can be passed here so that the comparison does not happen with the special "__TEMP__"
     *            constant but with the parameter value instead in case the comparison argument is a string literal with value
     *            "__TEMP__".
     */
    public boolean isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(Notification changeEvent,
            String replacementFor__TEMP__) {
        if (!NotificationHelper.isAttributeValueChangeEvent(changeEvent)) {
	    return false;
	}
        Set<? extends NavigationCallExp> calls = getAttributeOrAssociationEndCalls(changeEvent);
        if (calls.size() == 0) {
            // this is likely to be dead code because if the filter synthesis works correctly,
            // we always reevaluate the expressions containing the changed attribute once an attributeValueChange occurs
            System.err.println("Could niot find any attribute or association end calls for the attribute value change event : " + changeEvent);
            return false; // probably an allInstances-triggered element creation/deletion event
        }
        for (NavigationCallExp ace : calls) {
            if (ace.getType() instanceof PrimitiveType) {
                if (((PropertyCallExp) ace).getReferredProperty().equals(NotificationHelper.getNotificationFeature(changeEvent))) {
                    OCLExpression otherArgument = null;
                    OperationCallExp op;
                    boolean attributeIsParameter = false;
                    if (!(ace.eContainer() instanceof OperationCallExp)) {
                        continue;
                    }
                    op = (OperationCallExp) ace.eContainer(); // argument of a comparison operation?
                    if (op != null && isComparisonOperation(op)) {
                        otherArgument = (OCLExpression) op.getSource();
                        attributeIsParameter = true;
                    } else {
                        CallExp callExp = (CallExp) ace.eContainer(); // source of a comparison operation?
                        if (callExp != null && callExp instanceof OperationCallExp
                                && isComparisonOperation(((OperationCallExp) callExp))) {
                            op = ((OperationCallExp) callExp);
                            otherArgument = (OCLExpression) op.getArgument().iterator().next();
                            attributeIsParameter = false;
                        }
                    }
                    if (otherArgument != null && otherArgument instanceof PrimitiveLiteralExp) {
                        if (doesComparisonResultChange(changeEvent, (PrimitiveLiteralExp) otherArgument, replacementFor__TEMP__,
                                op.getReferredOperation().getName(), attributeIsParameter)) {
			    return false;
			}
                    } else {
			// attribute not used in comparison operation; we assume a change
                        return false;
		    }
                }
            }

        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // due to Comparable<Object> casts
    private boolean doesComparisonResultChange(Notification avce, LiteralExp otherArgument, String replacementFor__TEMP__,
            String operationName, boolean attributeIsParameter) {
        Object value;
        // As a change event should only have occurred if something actually changed, if one of old and new
        // value is null, this always represents a change because when compared to either the null literal
        // or a constant, this would change, perhaps from/to an OclInvalid value:
        boolean result = avce.getNewValue() == null || avce.getOldValue() == null;
        if (!result) {
            if (otherArgument instanceof StringLiteralExp) {
                value = ((StringLiteralExp) otherArgument).getStringSymbol();
                if (value.equals("__TEMP__")) {
                    value = replacementFor__TEMP__;
                }
            } else if (otherArgument instanceof BooleanLiteralExp) {
                value = ((BooleanLiteralExp) otherArgument).getBooleanSymbol();
            } else if (otherArgument instanceof IntegerLiteralExp) {
                value = ((IntegerLiteralExp) otherArgument).getIntegerSymbol();
            } else if (otherArgument instanceof RealLiteralExp) {
                value = ((RealLiteralExp) otherArgument).getRealSymbol();
            } else {
		throw new RuntimeException("Internal error. Unknown OCL primitive literal expression " + otherArgument);
	    }
            int oldComparison = (attributeIsParameter ? ((Comparable<Object>) value).compareTo(avce.getOldValue())
                    : ((Comparable<Object>) avce.getOldValue()).compareTo(value));
            int newComparison = (attributeIsParameter ? ((Comparable<Object>) value).compareTo(avce.getNewValue())
                    : ((Comparable<Object>) avce.getNewValue()).compareTo(value));
            if (operationName.equals(PredefinedType.EQUAL_NAME)) {
                result = (oldComparison == 0) != (newComparison == 0);
            } else if (operationName.equals(PredefinedType.NOT_EQUAL_NAME)) {
                result = (oldComparison != 0) != (newComparison != 0);
            } else if (operationName.equals(PredefinedType.LESS_THAN_NAME)) {
                result = oldComparison < 0 != newComparison < 0;
            } else if (operationName.equals(PredefinedType.LESS_THAN_EQUAL_NAME)) {
                result = oldComparison <= 0 != newComparison <= 0;
            } else if (operationName.equals(PredefinedType.GREATER_THAN_NAME)) {
                result = oldComparison > 0 != newComparison > 0;
            } else if (operationName.equals(PredefinedType.GREATER_THAN_EQUAL_NAME)) {
                result = oldComparison >= 0 != newComparison >= 0;
            } else {
                logger.info("operator " + operationName
                        + " not supported in impact analysis performance improvement; assuming a change");
                result = true;
            }
        }
        return result;
    }

    /**
     * Finds all attribute and association end call expressions in <tt>expression</tt> that are affected by the
     * <tt>changeEvent</tt>. The result is always non-<tt>null</tt> but may be empty.
     */
    private Set<? extends NavigationCallExp> getAttributeOrAssociationEndCalls(Notification changeEvent) {
        Set<? extends NavigationCallExp> result;
        if (NotificationHelper.isAttributeValueChangeEvent(changeEvent)) {
            result = filterSynthesizer.getAttributeCallExpressions((EAttribute) NotificationHelper
                    .getNotificationFeature(changeEvent));
        } else if (NotificationHelper.isLinkLifeCycleEvent(changeEvent)) {
            EReference ref = (EReference) NotificationHelper.getNotificationFeature(changeEvent);

            Set<NavigationCallExp> localResult = new HashSet<NavigationCallExp>();
            localResult.addAll(filterSynthesizer.getAssociationEndCallExpressions(ref));
            result = localResult;
        } else {
            result = Collections.emptySet();
        }
        return result;
    }

    /**
     * @return the overall context type for the entire expression; this context type defines
     *         the type for <tt>self</tt> if used outside of operation bodies.
     */
    private EClass getContext() {
        return context;
    }

    /**
     * Looks up <tt>exp</tt> in {@link #expressionToStep}. If not found, the respective {@link Tracer} is created and used to
     * compute and then cache the required {@link NavigationStep}.
     *
     * @param context
     *            the overall context for the entire expression of which <tt>exp</tt> is a subexpression; this context type
     *            defines the type for <tt>self</tt> if used outside of operation bodies.
     */
    private NavigationStep getNavigationStepsToSelfForExpression(OCLExpression exp, EClass context) {
        NavigationStep result = getPathCache().getOrCreateNavigationPath(exp, context, filterSynthesizer, /* tupleLiteralNamesToLookFor */ null, oclFactory);
        return result;
    }

    /**
     * Looks up <tt>exp</tt> in {@link #expressionToStep}. If not found, the respective {@link Tracer} is created and used to
     * compute and then cache the required {@link NavigationStep}.
     *
     * @param context
     *            the overall context for the entire expression of which <tt>exp</tt> is a subexpression; this context type
     *            defines the type for <tt>self</tt> if used outside of operation bodies.
     */
    private TracebackStep getTracebackStepForExpression(OCLExpression exp, EClass context) {
        TracebackStep result = tracebackStepCache.getOrCreateNavigationPath(exp, context, filterSynthesizer,
                                                                            /* tupleLiteralNamesToLookFor */ null, oclFactory);
        return result;
    }

    /**
     * @param changeEvent
     *            either an {@link AttributeValueChangeEvent} or a {@link LinkChangeEvent}.
     * @param attributeOrAssociationEndCall
     *            a (sub-)expression originally affected by <tt>changeEvent</tt>. For {@link LinkChangeEvent}s it depends on which
     *            end the expression uses what will be considered the source element of the change which will then be returned by
     *            this method. The source is the element at the end of the link changed that is the opposite end of the end used
     *            by the {@link AssociationEndCallExp}. <tt>attributeOrAssociationEndCall</tt> has to be of type
     *            {@link AttributeCallExp} in case <tt>changeEvent</tt> is an {@link AttributeValueChangeEvent}, and of type
     *            {@link AssociationEndCallExp} in case <tt>changeEvent</tt> is of type {@link LinkChangeEvent}.
     * @return <tt>null</tt> in case the source element indicated by the change event does not conform to the static attribute or
     *         association call's source expression type. <tt>null</tt> may also result if the element indicated by the event
     *         cannot be resolved (anymore). This is still an open issue. See the to-do marker below. In all other cases, the
     *         source element on which the event occured, is returned.
     */
    protected Collection<AnnotatedEObject> getSourceElement(Notification changeEvent, NavigationCallExp attributeOrAssociationEndCall) {
        assert NotificationHelper.isAttributeValueChangeEvent(changeEvent)
                || NotificationHelper.isLinkLifeCycleEvent(changeEvent);
        EClassifier sourceType = attributeOrAssociationEndCall.getSource().getType();
        Collection<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        // can't be source element of attributeOrAssociationEndCall because of incompatible type
        // also see the ASCII arts in AssociationEndCallExpTracer.traceback
        if (attributeOrAssociationEndCall instanceof PropertyCallExp) {
            if (sourceType.isInstance(changeEvent.getNotifier())) {
                result.add(createStartObject((EObject) changeEvent.getNotifier()));
            }
        } else {
	    throw new RuntimeException("Can only handle PropertyCallExp and OppositePropertyCallExp expression types, not "+
                    attributeOrAssociationEndCall.getClass().getName());
	}
        return result;
    }

	private AnnotatedEObject createStartObject(EObject eObject) {
		return new AnnotatedEObject(eObject, "<start>");
	}

    protected Collection<Object> getSourceElementsForOppositePropertyCallExp(Notification changeEvent) {
        Collection<Object> result = new HashSet<Object>();
        Object oldValue = changeEvent.getOldValue();
        Object newValue = changeEvent.getNewValue();
        switch (changeEvent.getEventType()) {
        case Notification.SET:
        case Notification.UNSET:
            result.addAll(OclHelper.flatten(oldValue));
            result.addAll(OclHelper.flatten(newValue));
            break;
        case Notification.ADD:
        case Notification.ADD_MANY:
            result.addAll(OclHelper.flatten(newValue));
            break;
        case Notification.REMOVE:
        case Notification.REMOVE_MANY:
            result.addAll(OclHelper.flatten(oldValue));
            break;
        }
        return result;
    }

    private boolean isComparisonOperation(OperationCallExp op) {
        return comparisonOpNames.contains(op.getReferredOperation().getName());
    }

    /**
     * For attribute call expressions or association end call expressions determines for which context elements used for the
     * global <tt>self</tt> (not to confuse with the <tt>self</tt> value that applies for an operation body and which is set to
     * the value of the source expression on which the operation is invoked) the property call's
     * {@link ModelPropertyCallExp#getSource() source expression} may evaluate to <tt>sourceElement</tt>. This is a conservative
     * estimate which means that for some elements of the result set, when used as element for the global <tt>self</tt> variable,
     * the source expression may not necessarily evaluate to <tt>sourceElement</tt>. However, there are no other {@link RefObject}
     * elements that are not part of the result and for which the source expression evaluates to <tt>sourceElement</tt>. This
     * means, all contexts for which the source expression evaluates to <tt>sourceElement</tt> are guaranteed to be found.<p>
     *
     * This implementation variant uses {@link TracebackStep}s.
     * 
     * @param context
     *            the overall context for the entire expression of which <tt>exp</tt> is a subexpression; this context type
     *            defines the type for <tt>self</tt> if used outside of operation bodies.
     */
    private Iterable<AnnotatedEObject> selfWithNavigationSteps(NavigationCallExp attributeOrAssociationEndCall,
            AnnotatedEObject sourceElement, EClass context, Notification changeEvent, TracebackCache cache) {
        Iterable<AnnotatedEObject> result;
        NavigationStep step = getNavigationStepsToSelfForExpression(
                (OCLExpression) attributeOrAssociationEndCall.getSource(), context);
        Set<AnnotatedEObject> sourceElementAsSet = Collections.singleton(sourceElement);
        result = step.navigate(sourceElementAsSet, cache, changeEvent);
        return result;
    }

    /**
     * For attribute call expressions or association end call expressions determines for which context elements used for the
     * global <tt>self</tt> (not to confuse with the <tt>self</tt> value that applies for an operation body and which is set to
     * the value of the source expression on which the operation is invoked) the property call's
     * {@link ModelPropertyCallExp#getSource() source expression} may evaluate to <tt>sourceElement</tt>. This is a conservative
     * estimate which means that for some elements of the result set, when used as element for the global <tt>self</tt> variable,
     * the source expression may not necessarily evaluate to <tt>sourceElement</tt>. However, there are no other {@link RefObject}
     * elements that are not part of the result and for which the source expression evaluates to <tt>sourceElement</tt>. This
     * means, all contexts for which the source expression evaluates to <tt>sourceElement</tt> are guaranteed to be found.<p>
     *
     * This implementation variant uses {@link NavigationStep}s.
     * 
     * @param context
     *            the overall context for the entire expression of which <tt>exp</tt> is a subexpression; this context type
     *            defines the type for <tt>self</tt> if used outside of operation bodies.
     */
    private Iterable<AnnotatedEObject> selfWithTracebackSteps(NavigationCallExp attributeOrAssociationEndCall,
            AnnotatedEObject sourceElement, EClass context, Notification changeEvent,
            org.eclipse.ocl.examples.impactanalyzer.instanceScope.traceback.TracebackCache cache) {
        Iterable<AnnotatedEObject> result;
        TracebackStep step = getTracebackStepForExpression((OCLExpression) attributeOrAssociationEndCall.getSource(), context);
        result = step.traceback(sourceElement, /* pending unused evaluation requests */ null, cache, changeEvent);
        return result;
    }

    protected PartialEvaluatorImpl getPartialEvaluatorForAllInstancesDeltaPropagation() {
        return partialEvaluatorForAllInstancesDeltaPropagation;
    }

    public PartialEvaluatorFactory getPartialEvaluatorFactory() {
        return this;
    }

}
