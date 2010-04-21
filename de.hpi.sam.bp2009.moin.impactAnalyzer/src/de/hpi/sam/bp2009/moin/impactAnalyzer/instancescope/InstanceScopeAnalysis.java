package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.ecore.LiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.PredefinedType;
import org.omg.ocl.expressions.AssociationEndCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.omg.ocl.expressions.ModelPropertyCallExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PrimitiveLiteralExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.StringLiteralExp;

import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclTypeImpl;
import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent;

import com.sap.tc.moin.ocl.ia.relevance.NavigationPath;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectWrapperImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
//import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
//import com.sap.tc.moin.repository.events.type.ChangeEvent;
//import com.sap.tc.moin.repository.events.type.ElementLifeCycleEvent;
//import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
//import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationWrapper;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Supports a lookup from a source model element of either an attribute value change event or a link add/remove event
 * together with an {@link OCLExpression<EClassifier>} to a set of context objects for which the expression may return a value
 * different from the one it returned before the change event occurred. An instance of this class manages the analysis
 * for all expression occuring within one root OCL expression, including the expressions reachable in operation body
 * expressions where the operation may be called directly of indirectly by the root expression.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class InstanceScopeAnalysis {
    private final Logger logger = Logger.getLogger(InstanceScopeAnalysis.class.getName());
    private final AssociationEndAndAttributeCallFinder associationEndAndAttributeCallFinder;
    private final Map<OCLExpression<EClassifier>, NavigationStep> expressionToStep;
    private final PathCache pathCache;
    private final ClassScopeAnalyzer classScopeAnalyzer;

    /**
     * @param expression
     * 		  the OCL expression for which to perform instance scope impact analysis
     * @param conn
     *            the connection used to walk the expression tree
     * @param pathCache
     *            caches {@link NavigationPath} traceback navigations to the possible contexts for a given expression
     *            that can be invoked for model elements; using this cache avoids redundant path calculations for common
     *            subexpressions, such as operation bodies called by several expressions.
     * @param classScopeAnalyzer
     *            makes available the operation call relations reachable from the root expression that was analyzed by
     *            the class scope analyzer.
     */
    public InstanceScopeAnalysis(OCLExpression<EClassifier> expression, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
        associationEndAndAttributeCallFinder = new AssociationEndAndAttributeCallFinder(classScopeAnalyzer);
        expressionToStep = new HashMap<OCLExpression<EClassifier>, NavigationStep>();
        this.pathCache = pathCache;
        this.classScopeAnalyzer = classScopeAnalyzer;
        associationEndAndAttributeCallFinder.walk(expression);
    }

    /**
     * Looks up <tt>exp</tt> in {@link #expressionToStep}. If not found, the respective {@link Tracer} is created and
     * used to compute and then cache the required {@link NavigationStep}.
     * 
     * @param context
     *            the overall context for the entire expression of which <tt>exp</tt> is a subexpression; this context
     *            type defines the type for <tt>self</tt> if used outside of operation bodies.
     */
    private NavigationStep getNavigationStepsToSelfForExpression(OCLExpression<EClassifier> exp, EClass context) {
        NavigationStep result = expressionToStep.get(exp);
        if (result == null) {
            result = getTracer(exp).traceback(context, pathCache, classScopeAnalyzer);
            expressionToStep.put(exp, result);
        }
        return result;
    }

//    public Set<MRI> getAffectedElements(EClass context, Collection<? extends ModelChangeEvent> changeEvents) {
//        return getAffectedElements((EClassImpl) ((RefObjectWrapperImpl<?>) context).unwrap(),
//                changeEvents);
//    }

//    public Set<EObject> getAffectedElements(EClassifier context, Collection<? extends ModelChangeEvent> changeEvents) {
//        Map<Map<NavigationStep, EObject>, Set<EObject>> cache = new HashMap<Map<NavigationStep, EObject>, Set<EObject>>();
//        Set<MRI> result = new HashSet<MRI>();
//        for (ModelChangeEvent ce : changeEvents) {
//            if (ce instanceof ModelChangeEvent) {
//                result.addAll(getAffectedElements(context, (ModelChangeEvent) ce, cache));
//            }
//        }
//        return result;
//    }

    /**
     * Tells the context model elements on which <tt>expression</tt> may now return a result different from
     * before the <tt>changeEvent</tt> occurred.
     */
    public Set<MRI> getAffectedElements(EClass context, ModelChangeEvent changeEvent, Map<Map<NavigationStep, EObject>, Set<EObject>> cache) {
        //FIXME: create the empty cache here
        if (changeEvent instanceof ElementLifeCycleEvent) {
            // create and delete of elements only affects the allInstances expressions;
            // for those, however, no "self" context can easily be determined and therefore
            // the expression may change value on all possible context instances:
            EObject metaObject = ((ElementLifeCycleEvent) changeEvent).getMetaObject(changeEvent.getEventTriggerConnection());
            // If package extents are created (RefPackage), those may also trigger ElementLifeCycleEvents.
            // However, their meta object would not be a Classifier but rather a package. Filter this case:
            if (metaObject instanceof EClassifier && expressionContainsAllInstancesCallForType((EClassifier) ((Wrapper<?>) metaObject).unwrap())) {
                return getAllPossibleContextInstancesMris(((ConnectionWrapper) changeEvent.getEventTriggerConnection())
                        .unwrap(), context);
            } else {
                return Collections.emptySet();
            }
        } else {
            Set<MRI> result = new LinkedHashSet<MRI>();
            for (PropertyCallExp attributeOrAssociationEndCall : getAttributeOrAssociationEndCalls(changeEvent)) {
                EObject sourceElement = getSourceElement(changeEvent, attributeOrAssociationEndCall);
                if (sourceElement != null) {
                    // the source element may have been deleted already by subsequent events; at this point,
                    // this makes it impossible to trace the change event back to a context; all we have is
                    // the LRI of a no longer existing model element...
                    for (EObject roi : self(attributeOrAssociationEndCall, sourceElement, context,
                            ((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap(), cache)) {
                        result.add(roi.get___Mri());
                    }
                }
            }
            return result;
        }
    }

    /**
     * Checks if all {@link ModelChangeEvent}s contained in <tt>events</tt> are attribute changes and the expressions
     * affected by the change event are all attribute call expressions for an attribute of primitive type that is used
     * in a direct comparison with a constant literal. If this is the case, compares the old and new value with the
     * literal's value, considering the comparison operator. If no change occurs in comparison result for any of the
     * events, <tt>true</tt> is returned because then the expression value didn't change based on the change event. If
     * any of the events is an event of different type or the attribute is not of primitive type or its value is not
     * compared to a constant, <tt>false</tt> is returned.
     * <p>
     * 
     * Note that further performance improvements are conceivable but not yet implemented. For example, the attribute
     * call expression may be used in a <tt>let</tt>-expression and then the variable may be compared to a primitive
     * literal.
     * 
     * @param replacementFor__TEMP__
     *            as a special case, expressions can contain the special string literal "__TEMP__" (see
     *            GlobalDelayedReferenceResolver.TEMPORARY_QUERY_PARAM_REPLACEMENT). Those will be replaced by the value
     *            of a lexical token. This value can be passed here so that the comparison does not happen with the
     *            special "__TEMP__" constant but with the parameter value instead in case the comparison argument is a
     *            string literal with value "__TEMP__".
     */
    public boolean isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(List<ModelChangeEvent> events,
            String replacementFor__TEMP__) {
        for (ModelChangeEvent ce : events) {
            if (ce instanceof ModelChangeEvent) {
                ModelChangeEvent changeEvent = (ModelChangeEvent) ce;
                Set<? extends org.eclipse.ocl.ecore.PropertyCallExp> calls = getAttributeOrAssociationEndCalls(changeEvent);
                if (calls.size() == 0) {
                    return false; // probably an allInstances-triggered element creation/deletion event
                }
                for (PropertyCallExp attributeOrAssociationEndCall : calls) {
                    if (changeEvent instanceof AttributeValueChangeEvent) {
                        AttributeValueChangeEvent avce = (AttributeValueChangeEvent) changeEvent;
                        if (attributeOrAssociationEndCall instanceof PropertyCallExp) {
                            PropertyCallExp ace = attributeOrAssociationEndCall;
                         
                            if (ace.getType() instanceof PrimitiveType) {
                                if (ace.getReferredAttribute().get___Mri().equals(avce.getAffectedMetaObjectMri())) {
                                    OCLExpression<EClassifier> otherArgument = null;
                                    OperationCallExp op;
                                    boolean attributeIsParameter = false;
                                    op = (OperationCallExp) ace.getParentOperation(); // argument of a comparison operation?
                                    if (op != null && isComparisonOperation(op)) {
                                        otherArgument = (OCLExpression<EClassifier>) op.getSource();
                                        attributeIsParameter = true;
                                    } else {
                                        PropertyCallExp propertyCallExp = ace.getAppliedProperty(); // source of a comparison operation?
                                        if (propertyCallExp != null
                                                && propertyCallExp instanceof OperationCallExp
                                                && isComparisonOperation(((OperationCallExp) propertyCallExp))) {
                                            op = ((OperationCallExp) propertyCallExp);
                                            otherArgument = (OCLExpression<EClassifier>) op.getArgument().iterator().next();
                                            attributeIsParameter = false;
                                        }
                                    }
                                    if (otherArgument != null && otherArgument instanceof PrimitiveLiteralExp) {
                                        if (doesComparisonResultChange(
                                                avce, (PrimitiveLiteralExp) otherArgument,
                                                replacementFor__TEMP__, op.getReferredOperation().getName(), attributeIsParameter)) {
                                            return false;
                                        }
                                    } else {
                                        // attribute not used in comparison operation; we assume a change
                                        return false;
                                    }
                                }
                            }
                        } else {
                            // not an attribute call expression; strange, but then we don't know anything
                            return false;
                        }
                    } else {
                        // not an attribute change event; consider changed
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked") // due to Comparable<Object> casts
    private boolean doesComparisonResultChange(AttributeValueChangeEvent avce, LiteralExp otherArgument,
            String replacementFor__TEMP__, String operationName, boolean attributeIsParameter) {
        Object value;
        // As a change event should only have occurred if something actually changed, if one of old and new
        // value is null, this always represents a change because when compared to either the null literal
        // or a constant, this would change, perhaps from/to an OclInvalid value:
        boolean result = avce.getBefore() == null || avce.getAfter() == null;
        if (!result) {
            if (otherArgument instanceof StringLiteralExp) {
                value = ((StringLiteralExp) otherArgument).getStringSymbol();
                if (value.equals("__TEMP__")) {
                    value = replacementFor__TEMP__;
                }
            } else if (otherArgument instanceof BooleanLiteralExp) {
                value = ((BooleanLiteralExp) otherArgument).isBooleanSymbol();
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

    private static final Set<String> comparisonOpNames = new HashSet<String>(Arrays.asList(new String[] { 
            PredefinedType.EQUAL_NAME,
            PredefinedType.LESS_THAN_NAME,
            PredefinedType.LESS_THAN_EQUAL_NAME,
            PredefinedType.GREATER_THAN_NAME,
            PredefinedType.GREATER_THAN_EQUAL_NAME,
            PredefinedType.NOT_EQUAL_NAME }));
    
    private boolean isComparisonOperation(OperationCallExp op) {
        return comparisonOpNames.contains(op.getReferredOperation().getName());
    }

    private boolean expressionContainsAllInstancesCallForType(EClassifier classifier) {
        return !associationEndAndAttributeCallFinder.getAllInstancesCallsFor(classifier).isEmpty();
    }

    protected static Set<MRI> getAllPossibleContextInstancesMris(EClass context) {
        //FIXME: atm the ported impact analyzer has no knowledge about the meta model instance. Actually getting all instances therefore is impossible
        return OclTypeImpl.getAllInstancesMris(context.getQualifiedName());
    }

    protected static Set<EObject> getAllPossibleContextInstances(EClass context) {
        //FIXME: atm the ported impact analyzer has no knowledge about the meta model instance. Actually getting all instances therefore is impossible
        return OclTypeImpl.getAllInstances(context.getQualifiedName());
    }

    /**
     * For attribute call expressions or association end call expressions determines for which context elements used for
     * the global <tt>self</tt> (not to confuse with the <tt>self</tt> value that applies for an operation body and
     * which is set to the value of the source expression on which the operation is invoked) the property call's
     * {@link ModelPropertyCallExp#getSource() source expression} may evaluate to <tt>sourceElement</tt>. This is a
     * conservative estimate which means that for some elements of the result set, when used as element for the global
     * <tt>self</tt> variable, the source expression may not necessarily evaluate to <tt>sourceElement</tt>. However,
     * there are no other {@link RefObject} elements that are not part of the result and for which the source expression
     * evaluates to <tt>sourceElement</tt>. This means, all contexts for which the source expression evaluates to
     * <tt>sourceElement</tt> are guaranteed to be found.
     * @param cache TODO
     */
    private Set<EObject> self(PropertyCallExp attributeOrAssociationEndCall, EObject sourceElement,
            EClass context, Map<Map<NavigationStep, EObject>, Set<EObject>> cache) {
        NavigationStep step = getNavigationStepsToSelfForExpression(attributeOrAssociationEndCall
                .getSource(), context);
        Set<EObject> sourceElementAsSet = Collections.singleton(sourceElement);
        Set<EObject> result = step.navigate(sourceElementAsSet, cache, tupleLiteralIdentifierStack);
        return result;
    }

    /**
     * Factory method that creatss an instance of some {@link Tracer}-implementing class specific to the
     * type of the OCL <tt>expression</tt>.
     */
    protected static Tracer getTracer(OCLExpression<EClassifier> expression) {
        try {
            Class<?> tracerClass = InstanceScopeAnalysis.class.getClassLoader().loadClass(
                    InstanceScopeAnalysis.class.getPackage().getName() + "." +
                    ((EClass) expression.refMetaObject()).getName() + "Tracer");
            return (Tracer) tracerClass.getConstructor(CoreConnection.class,
                    expression.getClass()).newInstance(expression);
        } catch (Exception e) {
            throw new RuntimeException("Internal error; probably the Tracer implementation class for OCL expression type "+
                    expression.getClass().getName()+" was not found", e);
        }
    }

    /**
     * @param changeEvent
     *            either an {@link AttributeValueChangeEvent} or a {@link LinkChangeEvent}.
     * @param attributeOrAssociationEndCall
     *            a (sub-)expression originally affected by <tt>changeEvent</tt>. For {@link LinkChangeEvent}s it
     *            depends on which end the expression uses what will be considered the source element of the change
     *            which will then be returned by this method. The source is the element at the end of the link changed
     *            that is the opposite end of the end used by the {@link AssociationEndCallExp}.
     *            <tt>attributeOrAssociationEndCall</tt> has to be of type {@link AttributeCallExp} in case
     *            <tt>changeEvent</tt> is an {@link AttributeValueChangeEvent}, and of type
     *            {@link AssociationEndCallExp} in case <tt>changeEvent</tt> is of type {@link LinkChangeEvent}.
     * @return <tt>null</tt> in case the source element indicated by the change event does not conform to the static
     *         attribute or association call's source expression type. <tt>null</tt> may also result if the element
     *         indicated by the event cannot be resolved (anymore). This is still an open issue. See the to-do marker
     *         below. In all other cases, the source element on which the event occured, is returned.
     */
    private EObject getSourceElement(ModelChangeEvent changeEvent, PropertyCallExp attributeOrAssociationEndCall) {
        
        assert changeEvent instanceof AttributeValueChangeEvent || changeEvent instanceof LinkLifeCycleEvent;
        EObject result;
        if (changeEvent instanceof AttributeValueChangeEvent) {
            Wrapper<?> sourceElement = (Wrapper<?>) ((AttributeValueChangeEvent) changeEvent).getAffectedElement();
            if (sourceElement != null) {
                result = (EObject) sourceElement.unwrap();
            } else {
                result = null;
            }
        } else {
            AssociationEndCallExpInternal aece = (AssociationEndCallExpInternal) attributeOrAssociationEndCall;
            int aeceEndNumber = jmiHelper.getAssociationEndNumber(aece.getReferredAssociationEnd());
            LinkLifeCycleEvent lce = (LinkLifeCycleEvent) changeEvent;
            EObject refObjectResult;
            if (aeceEndNumber == 0) {
                refObjectResult = lce.getSecondLinkEnd();
            } else {
                refObjectResult = lce.getFirstLinkEnd();
            }
            if (refObjectResult != null) {
                result = (EObject) ((Wrapper<?>) refObjectResult).unwrap();
            } else {
                // TODO clarify if this is a severe problem; deletes may have occurred; how does this impact the impact analysis?
                result = null;
            }
        }
        if (result != null
                && !result.refIsInstanceOf(((OCLExpression<EClassifier>) attributeOrAssociationEndCall.getSource()).getType(),
                        /* considerSubtypes */ true)) {
            result = null; // can't be source element of attributeOrAssociationEndCall because of incompatible type
            // also see the ASCII arts in AssociationEndCallExpTracer.traceback
        }
        return result;
    }
    /**
     * Finds all attribute and association end call expressions in <tt>expression</tt> that are affected by the
     * <tt>changeEvent</tt>. The result is always non-<tt>null</tt> but may be empty.
     */
    private Set<? extends PropertyCallExp> getAttributeOrAssociationEndCalls(ModelChangeEvent changeEvent) {
        Set<? extends PropertyCallExp> result;
        if (changeEvent instanceof AttributeValueChangeEvent) {
            result = associationEndAndAttributeCallFinder.getAttributeCallExpressions(
                    ((AttributeValueChangeEvent) changeEvent).getAffectedMetaObject());
        } else if (changeEvent instanceof LinkLifeCycleEvent) {
            Set<AssociationEndCallExp> localResult = new HashSet<AssociationEndCallExp>();
            AssociationWrapper assoc = (AssociationWrapper) ((LinkLifeCycleEvent) changeEvent).getAffectedMetaObject();
            List<AssociationEnd> ends = jmiHelper.getAssociationEnds(assoc.unwrap());
            localResult.addAll(associationEndAndAttributeCallFinder.getAssociationEndCallExpressions(ends.get(0)));
            localResult.addAll(associationEndAndAttributeCallFinder.getAssociationEndCallExpressions(ends.get(1)));
            result = localResult;
        } else {
            result = Collections.emptySet();
        }
        return result;
    }

    /**
     * For an "impl" object representing an OCL expression, obtains the {@link Operation} for which it is the body.
     * {@link OCLExpression<EClassifier>#getDefines()} is used because on "impl" objects the getters that receive the
     * {@link CoreConnection} need to be called. If the expression is not a body of an
     * operation, <tt>null</tt> is returned. Otherwise, the first operation (usually there would be
     * at most one) for which <tt>expression</tt> is the operation body is returned.
     */
    protected static EOperation getDefines(OCLExpression<EClassifier> expression) {
        //FIXME: use Query2 here to search operations annotated with a body entry that contains the given expression
        //        JmiListImpl<?> operationList = (JmiListImpl<?>) ((OCLExpression<EClassifier>) expression).getDefines(conn);
        //        EOperation result;
        //        if (operationList.size(conn.getSession()) > 0) {
        //            result = (EOperation) operationList.iterator().next();
        //        } else {
        //            result = null;
        //        }
        //        return result;
    }

}
