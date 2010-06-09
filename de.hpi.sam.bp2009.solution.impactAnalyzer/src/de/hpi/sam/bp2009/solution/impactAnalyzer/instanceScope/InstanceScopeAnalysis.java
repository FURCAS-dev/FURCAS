package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LiteralExp;
import org.eclipse.ocl.ecore.NavigationCallExp;
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
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.eventManager.util.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

/**
 * Supports a lookup from a source model element of either an attribute value change event or a link add/remove event together
 * with an {@link OCLExpression<EClassifier>} to a set of context objects for which the expression may return a value different
 * from the one it returned before the change event occurred. An instance of this class manages the analysis for all expression
 * occuring within one root OCL expression, including the expressions reachable in operation body expressions where the operation
 * may be called directly of indirectly by the root expression.
 * 
 */
public class InstanceScopeAnalysis {
    private final Logger logger = Logger.getLogger(InstanceScopeAnalysis.class.getName());
    private final AssociationEndAndAttributeCallFinder associationEndAndAttributeCallFinder;
    private final Map<OCLExpression, NavigationStep> expressionToStep;
    private final PathCache pathCache;
    private final FilterSynthesisImpl filterSynthesizer;
    private final EClass context;

    private static final Set<String> comparisonOpNames = new HashSet<String>(Arrays.asList(new String[] {
            PredefinedType.EQUAL_NAME, PredefinedType.LESS_THAN_NAME, PredefinedType.LESS_THAN_EQUAL_NAME,
            PredefinedType.GREATER_THAN_NAME, PredefinedType.GREATER_THAN_EQUAL_NAME, PredefinedType.NOT_EQUAL_NAME }));

    protected static Set<AnnotatedEObject> getAllPossibleContextInstances(Resource container, EClass context) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();

        List<EClass> classes = new ArrayList<EClass>(EcoreHelper.getInstance().getAllSubclasses(context));
        classes.add(context);

        QueryContext scope = new ProjectBasedScopeProviderImpl(container).getForwardScopeAsQueryContext();

        for (EClass c : classes) {
            String query = "select obj from [" + EcoreUtil.getURI(c) + "] as obj";
            ResultSet resultSet = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance()).execute(
                    query, scope);
            if (!resultSet.isEmpty()) {
                for (int i = 0; i < resultSet.getSize(); i++) {
                    String uri = resultSet.getUri(i, "obj").toString();
                    String uriFragment = uri.split("#")[1];
                    EObject obj = container.getEObject(uriFragment);
                    AnnotatedEObject annObj = new AnnotatedEObject(obj);
                    result.add(annObj);
                }
            }
        }
        return result;
    }

    /**
     * Factory method that creats an instance of some {@link Tracer}-implementing class specific to the type of the OCL
     * <tt>expression</tt>.
     */
    protected static Tracer getTracer(OCLExpression expression) {
        // Using the class loader is another option, but that would create implicit naming conventions.
        // Thats why we do the mapping "manually".
        switch (expression.eClass().getClassifierID()) {
        case EcorePackage.PROPERTY_CALL_EXP:
            return new PropertyCallExpTracer((PropertyCallExp) expression);
        case EcorePackage.BOOLEAN_LITERAL_EXP:
            return new BooleanLiteralExpTracer((BooleanLiteralExp) expression);
        case EcorePackage.COLLECTION_LITERAL_EXP:
            return new CollectionLiteralExpTracer((CollectionLiteralExp) expression);
        case EcorePackage.ENUM_LITERAL_EXP:
            return new EnumLiteralExpTracer((EnumLiteralExp) expression);
        case EcorePackage.IF_EXP:
            return new IfExpTracer((IfExp) expression);
        case EcorePackage.INTEGER_LITERAL_EXP:
            return new IntegerLiteralExpTracer((IntegerLiteralExp) expression);
        case EcorePackage.ITERATE_EXP:
            return new IterateExpTracer((IterateExp) expression);
        case EcorePackage.ITERATOR_EXP:
            return new IteratorExpTracer((IteratorExp) expression);
        case EcorePackage.LET_EXP:
            return new LetExpTracer((LetExp) expression);
        case EcorePackage.OPERATION_CALL_EXP:
            return new OperationCallExpTracer((OperationCallExp) expression);
        case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP:
            return new OppositePropertyCallExpTracer((OppositePropertyCallExp) expression);
        case EcorePackage.REAL_LITERAL_EXP:
            return new RealLiteralExpTracer((RealLiteralExp) expression);
        case EcorePackage.STRING_LITERAL_EXP:
            return new StringLiteralExpTracer((StringLiteralExp) expression);
        case EcorePackage.TUPLE_LITERAL_EXP:
            return new TupleLiteralExpTracer((TupleLiteralExp) expression);
        case EcorePackage.TYPE_EXP:
            return new TypeExpTracer((TypeExp) expression);
        case EcorePackage.VARIABLE_EXP:
            return new VariableExpTracer((VariableExp) expression);
        default:
            throw new RuntimeException("Unsupported expression type " + expression.eClass().getName());
        }
    }

    /**
     * @param expression
     *            the OCL expression for which to perform instance scope impact analysis
     * @param exprContext
     *            TODO
     * @param pathCache
     *            caches {@link NavigationPath} traceback navigations to the possible contexts for a given expression that can be
     *            invoked for model elements; using this cache avoids redundant path calculations for common subexpressions, such
     *            as operation bodies called by several expressions.
     */
    public InstanceScopeAnalysis(OCLExpression expression, EClass exprContext, PathCache pathCache,
            FilterSynthesisImpl filterSynthesizer) {
        if (expression == null || exprContext == null || pathCache == null || filterSynthesizer == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        associationEndAndAttributeCallFinder = new AssociationEndAndAttributeCallFinder();
        associationEndAndAttributeCallFinder.walk(expression);
        expressionToStep = new HashMap<OCLExpression, NavigationStep>();
        this.pathCache = pathCache;
        this.context = exprContext;
        this.filterSynthesizer = filterSynthesizer;
    }

    public Collection<EObject> getContextObjects(Notification event) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        if (NotificationHelper.isElementLifeCycleEvent(event)) {
            handleLifeCycleEvent(event, result);
        }
        // TODO fix this optimization
//        if (isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(event, "")) {
//            return Collections.emptySet();
//        }
        for (NavigationCallExp attributeOrAssociationEndCall : getAttributeOrAssociationEndCalls(event)) {
            AnnotatedEObject sourceElement = getSourceElement(event, attributeOrAssociationEndCall);
            if (sourceElement != null) {
                Map<List<Object>, Set<AnnotatedEObject>> cache = new HashMap<List<Object>, Set<AnnotatedEObject>>();
                // the source element may have been deleted already by subsequent events; at this point,
                // this makes it impossible to trace the change event back to a context; all we have is
                result.addAll(self(attributeOrAssociationEndCall, sourceElement, getContext(), cache));
            }
        }
        Iterator<AnnotatedEObject> it = result.iterator();
        Collection<EObject> resultCollection = new HashSet<EObject>();
        while (it.hasNext()) {
            resultCollection.add(it.next().getAnnotatedObject());
        }
        return resultCollection;
    }

    private void handleLifeCycleEvent(Notification event, Set<AnnotatedEObject> result) {
        Boolean addEvent = NotificationHelper.isAddEvent(event);
        Resource container;
        Set<EClass> relevantClasses = new HashSet<EClass>();
        relevantClasses.add(getContext());
        relevantClasses.addAll(getContext().getEAllSuperTypes());
        if (event.getNotifier() instanceof EObject) {
            container = ((EObject) event.getNotifier()).eResource();
        } else if (event.getNotifier() instanceof Resource) {
            container = (Resource) event.getNotifier();
        } else {
            throw new IllegalArgumentException("Unhandled notifier in Notification: " + event.getNotifier());
        }

        if (NotificationHelper.isManyEvent(event)) {
            List<?> featureValue;
            if (addEvent) {
                featureValue = (List<?>) event.getNewValue();
            } else {
                featureValue = (List<?>) event.getOldValue();
            }
            for (Object value : featureValue) {
                if (value instanceof EObject) {
                    if (expressionContainsAllInstancesCallForType(((EObject) value).eClass())) {
                        result.addAll(getAllPossibleContextInstances(container, getContext()));
                    }
                    if (addEvent && relevantClasses.contains(((EObject) value).eClass())) {
                        result.add(new AnnotatedEObject((EObject) value));
                    }
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
                if (expressionContainsAllInstancesCallForType(((EObject) value).eClass())) {
                    result.addAll(getAllPossibleContextInstances(container, getContext()));
                }
                if (addEvent && relevantClasses.contains(((EObject) value).eClass())) {
                    result.add(new AnnotatedEObject((EObject) value));
                }
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

    private boolean expressionContainsAllInstancesCallForType(EClassifier classifier) {
        return !associationEndAndAttributeCallFinder.getAllInstancesCallsFor(classifier).isEmpty();
    }

    /**
     * Finds all attribute and association end call expressions in <tt>expression</tt> that are affected by the
     * <tt>changeEvent</tt>. The result is always non-<tt>null</tt> but may be empty.
     */
    private Set<? extends NavigationCallExp> getAttributeOrAssociationEndCalls(Notification changeEvent) {
        Set<? extends NavigationCallExp> result;
        if (NotificationHelper.isAttributeValueChangeEvent(changeEvent)) {
            result = associationEndAndAttributeCallFinder.getAttributeCallExpressions((EAttribute) NotificationHelper
                    .getNotificationFeature(changeEvent));
        } else if (NotificationHelper.isLinkLifeCycleEvent(changeEvent)) {
            EReference ref = (EReference) NotificationHelper.getNotificationFeature(changeEvent);

            Set<NavigationCallExp> localResult = new HashSet<NavigationCallExp>();
            localResult.addAll(associationEndAndAttributeCallFinder.getAssociationEndCallExpressions(ref));
            if (ref.getEOpposite() != null) {
                // TODO: check if the EOpposite is really needed
                localResult.addAll(associationEndAndAttributeCallFinder.getAssociationEndCallExpressions(ref.getEOpposite()));
            }
            result = localResult;
        } else {
            result = Collections.emptySet();
        }
        return result;
    }

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
        NavigationStep result = expressionToStep.get(exp);
        if (result == null) {
            result = getTracer(exp).traceback(context, pathCache, filterSynthesizer);
            expressionToStep.put(exp, result);
        }
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
    private AnnotatedEObject getSourceElement(Notification changeEvent, NavigationCallExp attributeOrAssociationEndCall) {
        assert NotificationHelper.isAttributeValueChangeEvent(changeEvent)
                || NotificationHelper.isLinkLifeCycleEvent(changeEvent);
        AnnotatedEObject result = new AnnotatedEObject((EObject) changeEvent.getNotifier());
        if (!attributeOrAssociationEndCall.getSource().getType().isInstance(result.getAnnotatedObject())) {
            result = null; // can't be source element of attributeOrAssociationEndCall because of incompatible type
            // also see the ASCII arts in AssociationEndCallExpTracer.traceback
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
     * means, all contexts for which the source expression evaluates to <tt>sourceElement</tt> are guaranteed to be found.
     * 
     * @param cache
     */
    private Set<AnnotatedEObject> self(NavigationCallExp attributeOrAssociationEndCall, AnnotatedEObject sourceElement,
            EClass context, Map<List<Object>, Set<AnnotatedEObject>> cache) {
        NavigationStep step = getNavigationStepsToSelfForExpression((OCLExpression) attributeOrAssociationEndCall.getSource(),
                context);
        Set<AnnotatedEObject> sourceElementAsSet = Collections.singleton(sourceElement);
        Set<AnnotatedEObject> result = step.navigate(sourceElementAsSet, cache);
        return result;
    }
}
