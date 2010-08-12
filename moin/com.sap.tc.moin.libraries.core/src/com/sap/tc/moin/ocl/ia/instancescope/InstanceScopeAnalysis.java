package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.ModelPropertyCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.PrimitiveLiteralExp;
import org.omg.ocl.expressions.PropertyCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.AttributeCallExpInternal;
import org.omg.ocl.expressions.__impl.ModelPropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpInternal;
import org.omg.ocl.expressions.__impl.PrimitiveLiteralExpInternal;
import org.omg.ocl.expressions.__impl.PropertyCallExpInternal;

import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.NavigatingModifiedLinkException;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclTypeImpl;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.ocl.ia.Statistics;
import com.sap.tc.moin.ocl.ia.relevance.NavigationPath;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectWrapperImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementLifeCycleEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationWrapper;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Supports a lookup from a source model element of either an attribute value change event or a link add/remove event
 * together with an {@link OclExpression} to a set of context objects for which the expression may return a value
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
    private final Map<OclExpression, NavigationStep> expressionToStep;
    private final PathCache pathCache;
    private final ClassScopeAnalyzer classScopeAnalyzer;
    private final OclRegistration forRegistration;
    
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
    public InstanceScopeAnalysis(OclRegistration forRegistration, OclExpression expression, CoreConnection conn, PathCache pathCache,
	    ClassScopeAnalyzer classScopeAnalyzer) {
	associationEndAndAttributeCallFinder = new AssociationEndAndAttributeCallFinder(conn);
	expressionToStep = new HashMap<OclExpression, NavigationStep>();
	this.pathCache = pathCache;
	this.classScopeAnalyzer = classScopeAnalyzer;
	associationEndAndAttributeCallFinder.walk((OclExpressionInternal) expression);
	this.forRegistration = forRegistration;
    }
    
//    public InstanceScopeAnalysis(OclRegistration forRegistration, OclExpression expression, Connection conn, PathCache pathCache,
//	    ClassScopeAnalyzer classScopeAnalyzer) {
//	this(forRegistration, (OclExpression)((Wrapper<?>) expression).unwrap(), ((ConnectionWrapper) conn).unwrap(), pathCache, classScopeAnalyzer); 
//    }
    
    /**
     * Looks up <tt>exp</tt> in {@link #expressionToStep}. If not found, the respective {@link Tracer} is created and
     * used to compute and then cache the required {@link NavigationStep}.
     * 
     * @param context
     *            the overall context for the entire expression of which <tt>exp</tt> is a subexpression; this context
     *            type defines the type for <tt>self</tt> if used outside of operation bodies.
     */
    private NavigationStep getNavigationStepsToSelfForExpression(CoreConnection conn, OclExpression exp,
	    MofClass context) {
	NavigationStep result = expressionToStep.get(exp);
	if (result == null) {
	    long start = System.nanoTime();
	    result = getTracer(conn, exp).traceback(context, pathCache, classScopeAnalyzer);
	    Statistics.getInstance().instanceScopeNavigationStepComputed(this, exp, result, System.nanoTime()-start);
	    expressionToStep.put(exp, result);
	}
	return result;
    }
    
    public Set<MRI> getAffectedElements(MofClass context, Collection<? extends ChangeEvent> changeEvents) {
	return getAffectedElements((MofClassImpl) ((RefObjectWrapperImpl<?>) context).unwrap(),
		changeEvents);
    }

    public Set<MRI> getAffectedElements(MofClassImpl context, Collection<? extends ChangeEvent> changeEvents) {
	Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache = new HashMap<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>>();
	Set<MRI> result = new HashSet<MRI>();
	for (ChangeEvent ce : changeEvents) {
	    if (ce instanceof ModelChangeEvent) {
		result.addAll(getAffectedElements(context, (ModelChangeEvent) ce, cache));
	    }
	}
	return result;
    }

    /**
     * Tells the context model elements on which <tt>expression</tt> may now return a result different from
     * before the <tt>changeEvent</tt> occurred.
     */
    public Set<MRI> getAffectedElements(MofClassImpl context, ModelChangeEvent changeEvent,
	    Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache) {
	CoreConnection conn = ((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap();
	if (changeEvent instanceof ElementLifeCycleEvent) {
	    // create and delete of elements only affects the allInstances expressions;
	    // for those, however, no "self" context can easily be determined and therefore
	    // the expression may change value on all possible context instances:
	    RefObject metaObject = ((ElementLifeCycleEvent) changeEvent).getMetaObject(changeEvent.getEventTriggerConnection());
	    // If package extents are created (RefPackage), those may also trigger ElementLifeCycleEvents.
	    // However, their meta object would not be a Classifier but rather a package. Filter this case:
	    if (metaObject instanceof Classifier && expressionContainsAllInstancesCallForType((ClassifierInternal) ((Wrapper<?>) metaObject).unwrap())) {
		return getAllPossibleContextInstancesMris(conn, context);
	    } else {
		return Collections.emptySet();
	    }
	} else {
	    Set<MRI> result = new LinkedHashSet<MRI>();
	    for (ModelPropertyCallExp attributeOrAssociationEndCall : getAttributeOrAssociationEndCalls(changeEvent)) {
		Pair<RefObjectImpl, RefObjectImpl> sourceAndTargetElement = getSourceAndTargetElement(changeEvent,
			(ModelPropertyCallExpInternal) attributeOrAssociationEndCall);
		if (sourceAndTargetElement != null && sourceAndTargetElement.getA() != null) {
		    LeadsToEmptySetResult leadsToEmptySet = null;
		    if (sourceAndTargetElement.getB() == null ||
			    (leadsToEmptySet = leadsToEmptySet(attributeOrAssociationEndCall, sourceAndTargetElement.getB(),
			    conn, changeEvent)) != LeadsToEmptySetResult.YES) {
			// the source element may have been deleted already by subsequent events; at this point,
			// this makes it impossible to trace the change event back to a context; all we have is
			// the LRI of a no longer existing model element...
			Set<Pair<RefFeatured, RefObject>> throwExceptionWhenCrossing = null;
			if (changeEvent instanceof LinkChangeEvent) {
			    throwExceptionWhenCrossing = getThrowExceptionWhenCrossing((LinkChangeEvent) changeEvent, conn);
			}
			for (AnnotatedRefObjectImpl roi : self(attributeOrAssociationEndCall, sourceAndTargetElement
				.getA(), context, conn, cache, throwExceptionWhenCrossing)) {
			    if (result.add(roi.getElement().get___Mri()) &&
				    leadsToEmptySet == LeadsToEmptySetResult.NO_BECAUSE_OF_OPERATION_WITHOUT_PARAMETERS) {
				Statistics.getInstance().affectedElementComputedForSourceOfParameterlessOperation(
					attributeOrAssociationEndCall);
			    }
			}
		    }
		}
	    }
	    return result;
	}
    }

    public enum LeadsToEmptySetResult { YES, NO_BECAUSE_OF_NON_PROPERTY_CALL, NO_BECAUSE_OF_OPERATION_WITH_PARAMETERS,
	NO_BECAUSE_OF_OPERATION_WITHOUT_PARAMETERS, NO_BECAUSE_OF_NON_LINK_EVENT, NO_BECAUSE_OF_CYCLE_BACK_TO_CHANGED_LINK,
	NO_BECAUSE_NON_REF_OBJECT_REACHED, NO_BECAUSE_OF_OPERATION_WITHOUT_PARAMETERS_NAVIGATED_BACK_THROUGH_MODIFIED_LINK,
	NO_BECAUSE_UNDEFINED_VARIABLE_REACHED, NO_BECAUSE_NO_CALLS_TO_OPERATION_FOUND };

    /**
     * When in the continuation of the expression the <tt>sourceElement</tt> does not contribute to the expression's
     * result, e.g., because it is filtered out in a subsequent ->select expression or there is a ->isEmpty() or
     * ->notEmpty() expression, we can be smarter about telling if the change event could at all lead to a change of the
     * expression's evaluation result.<p>
     * 
     * Based on <tt>propertyCallExp</tt>, the value of the overall expression has not changed if the
     * <tt>propertyCallExp</tt> is the source of another expression which for the <tt>sourceElement</tt> (which is
     * assumed to be the result of <tt>propertyCallExp</tt>) coming from the original change event evaluates to an empty
     * set or is itself the source of such an expression for which this condition holds recursively.
     * 
     * @param resultOfPropertyCallExp
     *            one result element of <tt>propertyCallExp</tt>, such as delivered by an event notification that tells
     *            about a link change from which one target element of an attribute or association navigation call
     *            expression can be determined. Must not be <tt>null</tt>.
     */
    private LeadsToEmptySetResult leadsToEmptySet(ModelPropertyCallExp propertyCallExp,
	    RefObjectImpl resultOfPropertyCallExp, CoreConnection conn, ModelChangeEvent originalEvent) {
	long time = System.nanoTime();
	LeadsToEmptySetResult result = LeadsToEmptySetResult.NO_BECAUSE_OF_NON_LINK_EVENT; // be conservative; need to prove cases where no change may happen
	if (originalEvent instanceof LinkChangeEvent) {
	    PropertyCallExp isSourceOf = ((ModelPropertyCallExpInternal) propertyCallExp).getAppliedProperty(conn);
	    if (isSourceOf != null) {
		result = leadsToEmptySetRecursively(isSourceOf, resultOfPropertyCallExp, conn, (LinkChangeEvent) originalEvent);
	    } else {
		result = nonPropertyCallLeadsToEmptySet(propertyCallExp, resultOfPropertyCallExp, conn, (LinkChangeEvent) originalEvent);
	    }
	}
	Statistics.getInstance().leadsToEmptySetPerformed(forRegistration, System.nanoTime()-time, result);
	return result;
    }

    /**
     * Evaluate <tt>e</tt> using <tt>sourceForE</tt> as the element where to start the navigation. If the result is empty,
     * return <tt>LeadsToEmptySetResult.YES</tt>. If not, and if <tt>e</tt> is the source of another
     * {@link PropertyCallExp}, try this recursively. If recursively for all elements reached by the first navigation
     * this leads to empty sets again, return <tt>LeadsToEmptySetResult.YES</tt>, too.
     * <p>
     * 
     * A result other than <tt>LeadsToEmptySetResult.YES</tt> just means we can't guarantee that evaluating <tt>e</tt>
     * with <tt>sourceForE</tt> leads to an empty set; it still may, but we don't know. The specific result literal tells
     * a bit about the reason why we may not know.
     */
    private LeadsToEmptySetResult leadsToEmptySetRecursively(PropertyCallExp e, RefObjectImpl sourceForE, CoreConnection conn,
	    LinkChangeEvent originalEvent) {
	LeadsToEmptySetResult result;
	try {
	    OclAny o = evaluate(e, sourceForE, originalEvent, conn);
	    if (o == null || o == OclVoidImpl.OCL_UNDEFINED) {
		result = LeadsToEmptySetResult.YES;
	    } else {
		PropertyCallExp isSourceOf = ((PropertyCallExpInternal) e).getAppliedProperty(conn);
		if (isSourceOf == null) {
		    /**
		     * if e is:
		     * 
		     * 		Expression e: associationEnd->asSet()
 				===== in expression =====
				self.elementsOfType->collect(>>>associationEnd->asSet()<<<)->asSet()
 				===== which is the body of operation getAssociationEnds =====
 				
 		     * then e is not the source of a PropertyCallExp. Still, it is emitted from the
 		     * ->collect expression and hence ends up as one element of the subsequent ->asSet()
 		     * PropertyCallExp. We're trying to find out if e evaluates to an empty set in order to find out
 		     * if the overall expression maz have changed at all based on the original change event.
 		     * This comes down to proving that the existence of the link does not impact the overall
 		     * expression value. The approach taken is based on the assumption that the attribute or
 		     * association end call expression itself appears in a "collect" expression such that
 		     * if for the particular link affected by the change an empty set results from the
 		     * "collect" body, nothing will be added to the "collect" expression's value. That's
 		     * why continuations resulting in empty sets imply that no change occurs on the root
 		     * expression's value.
 		     * 
 		     * If in the expression

    				<tt>x->collect(i | e_i)</tt>

		     * the expression e_i evaluates to an empty set for an element i from x before and after the change,
		     * then the change does not impact the value of the overall expression x->collect(i | e_i).
		     * 
		     * In x->asSet(), x->asSequence(), ..., if x evaluates to an empty set, then so does the x->as...() expression.
		     * However, we can construct expressions where an asSet() does have impact on the emptyness of the result:
		     * 
		     * 		Bag{1, 1}->excluding(1)->isEmpty()          == false
		     * 		Bag{1, 1}->asSet()->excluding(1)->isEmpty() == true
		     * 
		     * 
 		     * 
 		     * TODO I don't think we ensure that this approach is only used for ->collect expressions.
 		     * 
 		     * Note also that this may not even apply anymore for a ->collectNested expression because
 		     * the empty set explicitly needs to be part of the collectNested expression.
 		     * 
		     */
		    // check if body of an operation; then check to right of calling expressions
		    if (o instanceof RefObjectImpl) {
			result = nonPropertyCallLeadsToEmptySet(e, (RefObjectImpl) o, conn, originalEvent);
		    } else if (o instanceof OclCollection) {
			if (((OclCollection) o).getWrappedCollection().isEmpty()) {
			    result = LeadsToEmptySetResult.YES;
			} else {
			    result = nonPropertyCallLeadsToEmptySet(e, (OclCollection) o, conn, originalEvent);
			}
		    } else {
			result = LeadsToEmptySetResult.NO_BECAUSE_NON_REF_OBJECT_REACHED;
		    }
		} else {
		    if (o instanceof OclCollection) {
			if (((OclCollection) o).getWrappedCollection().isEmpty()) {
			    result = LeadsToEmptySetResult.YES;
			} else {
			    Iterator<OclAny> i = ((OclCollection) o).getWrappedCollection().iterator();
			    result = LeadsToEmptySetResult.YES;
			    while (result == LeadsToEmptySetResult.YES && i.hasNext()) {
				Object next = i.next().getWrappedObject();
				LeadsToEmptySetResult localResult;
				if (next instanceof RefObjectImpl) {
				    // o is a single object that is source of another property call expression
				    localResult = leadsToEmptySetRecursively(isSourceOf, (RefObjectImpl) next, conn, originalEvent);
				} else {
				    // could, e.g., be an instance of a DataType, such as Integer, etc.
				    // and therefore can only be source of an operation call that
				    // will most likely produce a non-empty set.
				    localResult = LeadsToEmptySetResult.NO_BECAUSE_NON_REF_OBJECT_REACHED;
				}
				if (localResult != LeadsToEmptySetResult.YES) {
				    result = localResult;
				}
			    }
			}
		    } else {
			if (o instanceof RefObjectImpl) {
			    // o is a single object that is source of another property call expression
			    result = leadsToEmptySetRecursively(isSourceOf, (RefObjectImpl) o, conn, originalEvent);
			} else {
			    // could, e.g., be an instance of a DataType, such as Integer, etc.
			    // and therefore can only be source of an operation call that
			    // will most likely produce a non-empty set.
			    result = LeadsToEmptySetResult.NO_BECAUSE_NON_REF_OBJECT_REACHED;
			}
		    }
		}
	    }
	} catch (EvaluatorException ex) {
	    result = LeadsToEmptySetResult.NO_BECAUSE_UNDEFINED_VARIABLE_REACHED;
	} catch (NavigatingModifiedLinkException ex) {
	    result = LeadsToEmptySetResult.NO_BECAUSE_OF_CYCLE_BACK_TO_CHANGED_LINK;
	}

	return result;
    }

    /**
     * Performs {@link #nonPropertyCallLeadsToEmptySet(PropertyCallExp, RefObjectImpl, CoreConnection, LinkChangeEvent)}
     * for a whole {@link OclCollection} of {@link RefObjectImpl} elements. {@link LeadsToEmptySetResult#YES} is
     * returned if the collection is empty or if
     * {@link #nonPropertyCallLeadsToEmptySet(PropertyCallExp, RefObjectImpl, CoreConnection, LinkChangeEvent)} returns
     * {@link LeadsToEmptySetResult#YES} for all elements contained in the collection.
     */
    private LeadsToEmptySetResult nonPropertyCallLeadsToEmptySet(PropertyCallExp e,
	    OclCollection resultOfE, CoreConnection conn, LinkChangeEvent changeEvent) {
	LeadsToEmptySetResult result;
	if (AbstractTracer.getRootExpression((RefObjectImpl) e,
		((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap()).equals(e)) {
	    // is a root expression; check if it's an operation body
	    Set<OperationCallExp> calls = classScopeAnalyzer.getCallsOf((OclExpressionInternal) e);
	    if (!calls.isEmpty()) {
		if (resultOfE.getWrappedCollection().isEmpty()) {
		    result = LeadsToEmptySetResult.YES;
		} else {
		    Iterator<OclAny> i = resultOfE.getWrappedCollection().iterator();
		    result = LeadsToEmptySetResult.YES;
		    while (result == LeadsToEmptySetResult.YES && i.hasNext()) {
			Object next = i.next().getWrappedObject();
			LeadsToEmptySetResult localResult;
			if (next instanceof RefObjectImpl) {
			    // o is a single object that is source of another property call expression
			    Map<OperationCallExp, LeadsToEmptySetResult> resultForOperations = getLeadsToEmptySetResultForOperationCalls(
					(RefObjectImpl) next, conn, changeEvent, calls);
			    localResult = projectResultForCalls(resultForOperations);
			} else {
			    // could, e.g., be an instance of a DataType, such as Integer, etc.
			    // and therefore can only be source of an operation call that
			    // will most likely produce a non-empty set.
			    localResult = LeadsToEmptySetResult.NO_BECAUSE_NON_REF_OBJECT_REACHED;
			}
			if (localResult != LeadsToEmptySetResult.YES) {
			    result = localResult;
			}
		    }
		}
	    } else {
		// A root expression that is not an operation body or body of an operation nobody calls
		result = LeadsToEmptySetResult.NO_BECAUSE_NO_CALLS_TO_OPERATION_FOUND;
	    }
	} else {
	    // e is not a root expression
	    // TODO Check if e is body of ->collect(...) or ->collectNested iterator; in that case, proceed with that IteratorExp, checking if it is a PropertyCallExp's source or an operation's body. But think again about correctness: what if the ->collect would have returned more results in reality? We would continue with incomplete ->collect results... 
	    result = LeadsToEmptySetResult.NO_BECAUSE_OF_NON_PROPERTY_CALL;
	}
	// TODO how to pass on the information about which operation calls lead to empty results in which context?
	return result;
    }

    private LeadsToEmptySetResult projectResultForCalls(Map<OperationCallExp, LeadsToEmptySetResult> resultForOperations) {
	LeadsToEmptySetResult localResult;
	localResult = LeadsToEmptySetResult.YES;
	for (LeadsToEmptySetResult l : resultForOperations.values()) {
	    if (l != LeadsToEmptySetResult.YES) {
		localResult = l;
		break; // conservative: if any call can't be proven to lead to an empty set, don't return YES
	    }
	}
	return localResult;
    }

    /**
     * When an expression is not the source of another property call expression, maybe it's the body of an
     * operation. In that case, we can check if the {@link OperationCallExp} is again the source of a
     * property call expression. If so, we can again recursively check if that expression evaluates
     * to an empty set, given the evaluation results of the operation body so far. If it results in
     * an empty set, we don't have to check through that operation in our later efforts to trace back
     * to <tt>self</tt>. As a consequence, only traceback trails will be pursued that lead through
     * operations where the call is either not source of a property call expression or where that
     * property call expression can't be proven to evaluate to an empty result.<p>
     * 
     * TODO The set of operations that remain to be checked needs to be returned somehow by this operation
     * We would like to constrain the set of {@link OperationCallExp}s for which tracing back to <tt>self</tt>
     * is required.
     */
    private LeadsToEmptySetResult nonPropertyCallLeadsToEmptySet(PropertyCallExp e,
	    RefObjectImpl resultOfE, CoreConnection conn, LinkChangeEvent changeEvent) {
	LeadsToEmptySetResult result;
	if (AbstractTracer.getRootExpression((RefObjectImpl) e,
		    ((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap()).equals(e)) {
	    // is a root expression; check if it's an operation body
	    Set<OperationCallExp> calls = classScopeAnalyzer.getCallsOf((OclExpressionInternal) e);
	    if (!calls.isEmpty()) {
		Map<OperationCallExp, LeadsToEmptySetResult> resultForOperations = getLeadsToEmptySetResultForOperationCalls(
			resultOfE, conn, changeEvent, calls);
		result = projectResultForCalls(resultForOperations);
	    } else {
		// Not an operation body or body of an operation not called by anyone.
		result = LeadsToEmptySetResult.NO_BECAUSE_NO_CALLS_TO_OPERATION_FOUND;
	    }
	} else {
	    // not a root expression
	    result = LeadsToEmptySetResult.NO_BECAUSE_OF_NON_PROPERTY_CALL;
	}
	// TODO handle passing on the results of which operation calls lead to empty sets for which contexts
	return result;
    }

    private Map<OperationCallExp, LeadsToEmptySetResult> getLeadsToEmptySetResultForOperationCalls(RefObjectImpl resultOfE, CoreConnection conn,
	    LinkChangeEvent changeEvent, Set<OperationCallExp> calls) {
	Map<OperationCallExp, LeadsToEmptySetResult> result = new HashMap<OperationCallExp, LeadsToEmptySetResult>();
	for (OperationCallExp operationCall : calls) {
	    PropertyCallExp isSourceOf = ((PropertyCallExpInternal) operationCall).getAppliedProperty(conn);
	    if (isSourceOf != null) {
		result.put(operationCall, leadsToEmptySetRecursively(isSourceOf, resultOfE, conn, changeEvent));
	    } else {
		// check if it's an operation body that's called from somewhere:
		Set<OperationCallExp> callsOfCall = classScopeAnalyzer
			.getCallsOf((OclExpressionInternal) operationCall);
		if (!callsOfCall.isEmpty()) {
		    // the call was itself the body expression of an operation; recursively check its calls
		    result.put(operationCall, projectResultForCalls(getLeadsToEmptySetResultForOperationCalls(
			    resultOfE, conn, changeEvent, callsOfCall)));
		} else {
		    result.put(operationCall, LeadsToEmptySetResult.NO_BECAUSE_OF_NON_PROPERTY_CALL);
		}
	    }
	}
	return result;
    }

    private static Set<Pair<RefFeatured, RefObject>> getThrowExceptionWhenCrossing(LinkChangeEvent originalEvent,
	    CoreConnection conn) {
	Set<Pair<RefFeatured, RefObject>> throwExceptionWhenCrossing = new HashSet<Pair<RefFeatured, RefObject>>();
	RefFeatured eventMetaObject = originalEvent.getAffectedMetaObject(conn);
	if (eventMetaObject instanceof Attribute) {
	    throwExceptionWhenCrossing.add(new Pair<RefFeatured, RefObject>(eventMetaObject,
		    originalEvent.getFirstLinkEnd(conn)));
	} else {
	    Association a = (Association) eventMetaObject;
	    List<AssociationEnd> ends = conn.getCoreJmiHelper().getAssociationEnds(conn.getSession(), a);
	    throwExceptionWhenCrossing.add(new Pair<RefFeatured, RefObject>(ends.get(1),
		    originalEvent.getFirstLinkEnd(conn)));
	    throwExceptionWhenCrossing.add(new Pair<RefFeatured, RefObject>(ends.get(0),
		    originalEvent.getSecondLinkEnd(conn)));
	}
	return throwExceptionWhenCrossing;
    }
    
    private static OclAny evaluate(PropertyCallExp e, RefObjectImpl source, LinkChangeEvent originalEvent, CoreConnection conn)
    throws EvaluatorException {
	OclAny sourceContext;
	if (source != null) {
	    sourceContext = OclFactory.instance().create(source);
	} else {
	    sourceContext = OclVoidImpl.OCL_UNDEFINED;
	}
	OclAny o = ExpressionEvaluator.instance().evaluate(conn, e, sourceContext,
		getThrowExceptionWhenCrossing(originalEvent, conn));
	return o;
    }

    /**
     * Checks if <tt>event</tt> is an attribute change event and the expressions affected by the change event are all
     * attribute call expressions for an attribute of primitive type that is used in a direct comparison with a constant
     * literal. If this is the case, compares the old and new value with the literal's value, considering the comparison
     * operator. If no change occurs in comparison result for any of the events, <tt>true</tt> is returned because then
     * the expression value didn't change based on the change event. If any of the events is an event of different type
     * or the attribute is not of primitive type or its value is not compared to a constant, <tt>false</tt> is returned.
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
    public boolean isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(ChangeEvent ce,
	    String replacementFor__TEMP__) {
	if (ce instanceof ModelChangeEvent) {
	    ModelChangeEvent changeEvent = (ModelChangeEvent) ce;
	    Set<? extends ModelPropertyCallExp> calls = getAttributeOrAssociationEndCalls(changeEvent);
	    if (calls.size() == 0) {
		return false; // probably an allInstances-triggered element creation/deletion event
	    }
	    for (ModelPropertyCallExp attributeOrAssociationEndCall : calls) {
		if (changeEvent instanceof AttributeValueChangeEvent) {
		    AttributeValueChangeEvent avce = (AttributeValueChangeEvent) changeEvent;
		    if (attributeOrAssociationEndCall instanceof AttributeCallExp) {
			AttributeCallExpInternal ace = (AttributeCallExpInternal) attributeOrAssociationEndCall;
			CoreConnection conn = ((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap();
			if (ace.getType(conn) instanceof PrimitiveType) {
			    if (ace.getReferredAttribute(conn).get___Mri().equals(avce.getAffectedMetaObjectMri())) {
				OclExpressionInternal otherArgument = null;
				OperationCallExpInternal op;
				boolean attributeIsParameter = false;
				op = (OperationCallExpInternal) ace.getParentOperation(conn); // argument of a comparison operation?
				if (op != null && isComparisonOperation(op, conn)) {
				    otherArgument = (OclExpressionInternal) op.getSource(conn);
				    attributeIsParameter = true;
				} else {
				    PropertyCallExp propertyCallExp = ace.getAppliedProperty(conn); // source of a comparison operation?
				    if (propertyCallExp != null
					    && propertyCallExp instanceof OperationCallExp
					    && isComparisonOperation(((OperationCallExpInternal) propertyCallExp), conn)) {
					op = ((OperationCallExpInternal) propertyCallExp);
					otherArgument = (OclExpressionInternal) ((JmiListImpl<?>) op.getArguments(conn))
						.iterator(conn).next();
					attributeIsParameter = false;
				    }
				}
				if (otherArgument != null && otherArgument instanceof PrimitiveLiteralExp) {
				    if (doesComparisonResultChange(avce, (PrimitiveLiteralExpInternal) otherArgument,
					    replacementFor__TEMP__, op.getReferredOperation(conn).getName(),
					    attributeIsParameter)) {
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
	return true;
    }

    @SuppressWarnings("unchecked") // due to Comparable<Object> casts
    private boolean doesComparisonResultChange(AttributeValueChangeEvent avce, PrimitiveLiteralExpInternal otherArgument,
	    String replacementFor__TEMP__, String operationName, boolean attributeIsParameter) {
	Object value;
	// As a change event should only have occurred if something actually changed, if one of old and new
	// value is null, this always represents a change because when compared to either the null literal
	// or a constant, this would change, perhaps from/to an OclInvalid value:
	boolean result = avce.getOldValue() == null || avce.getNewValue() == null;
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
	    if (operationName.equals(OclConstants.OP_EQSTDLIB)) {
		result = (oldComparison == 0) != (newComparison == 0);
	    } else if (operationName.equals(OclConstants.OP_NOTEQSTDLIB)) {
		result = (oldComparison != 0) != (newComparison != 0);
	    } else if (operationName.equals(OclConstants.OP_LTSTDLIB)) {
		result = oldComparison < 0 != newComparison < 0;
	    } else if (operationName.equals(OclConstants.OP_LTEQSTDLIB)) {
		result = oldComparison <= 0 != newComparison <= 0;
	    } else if (operationName.equals(OclConstants.OP_GTSTDLIB)) {
		result = oldComparison > 0 != newComparison > 0;
	    } else if (operationName.equals(OclConstants.OP_GTEQSTDLIB)) {
		result = oldComparison >= 0 != newComparison >= 0;
	    } else {
		logger.info("operator " + operationName
			+ " not supported in impact analysis performance improvement; assuming a change");
		result = true;
	    }
	}
	return result;
    }

    private static final Set<String> comparisonOpNames = new HashSet<String>(Arrays.asList(
	    new String[] { OclConstants.OP_EQSTDLIB, OclConstants.OP_LTSTDLIB, OclConstants.OP_LTEQSTDLIB,
		    OclConstants.OP_GTSTDLIB, OclConstants.OP_GTEQSTDLIB, OclConstants.OP_NOTEQSTDLIB }));
    private boolean isComparisonOperation(OperationCallExpInternal op, CoreConnection conn) {
	return comparisonOpNames.contains(op.getReferredOperation(conn).getName());
    }

    private boolean expressionContainsAllInstancesCallForType(ClassifierInternal classifier) {
	return !associationEndAndAttributeCallFinder.getAllInstancesCallsFor(classifier).isEmpty();
    }

    protected static Set<MRI> getAllPossibleContextInstancesMris(CoreConnection conn, MofClass context) {
	return OclTypeImpl.getAllInstancesMris(conn, context.getQualifiedName());
    }

    protected static Set<RefObjectImpl> getAllPossibleContextInstances(CoreConnection conn, MofClass context) {
	return OclTypeImpl.getAllInstances(conn, context.getQualifiedName());
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
     * @param throwExceptionWhenVisiting TODO
     */
    private Set<AnnotatedRefObjectImpl> self(ModelPropertyCallExp attributeOrAssociationEndCall, RefObjectImpl sourceElement,
	    MofClass context, CoreConnection connection, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting) {
	NavigationStep step = getNavigationStepsToSelfForExpression(connection, attributeOrAssociationEndCall
		.getSource(), context);
	Set<AnnotatedRefObjectImpl> sourceElementAsSet = Collections.singleton(
		new AnnotatedRefObjectImpl("<start>\nat object: "+sourceElement, sourceElement));
	Set<AnnotatedRefObjectImpl> result = step.navigate(connection, sourceElementAsSet, cache, throwExceptionWhenVisiting);
	Statistics.getInstance().stepPerformed(step);
	return result;
    }
    
    /**
     * Factory method that creatss an instance of some {@link Tracer}-implementing class specific to the
     * type of the OCL <tt>expression</tt>.
     */
    protected static Tracer getTracer(CoreConnection conn, OclExpression expression) {
	try {
	    Class<?> tracerClass = InstanceScopeAnalysis.class.getClassLoader().loadClass(
		    InstanceScopeAnalysis.class.getPackage().getName() + "." +
		    ((MofClass) expression.refMetaObject()).getName() + "Tracer");
	    return (Tracer) tracerClass.getConstructor(CoreConnection.class,
		    expression.getClass()).newInstance(conn, expression);
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
     * @return the source element in the {@link Pair#getA() first component}, the target element in the
     *         {@link Pair#getB() second component}, if any. <tt>null</tt> in case the source element indicated by the
     *         change event does not conform to the static attribute or association call's source expression type.
     *         <tt>null</tt> may also result for the contained source or target element if the element indicated by the
     *         event cannot be resolved (anymore). This is still an open issue. See the to-do marker below. In all other
     *         cases, the source element on which the event occured, is returned.
     */
    private Pair<RefObjectImpl, RefObjectImpl> getSourceAndTargetElement(ModelChangeEvent changeEvent, ModelPropertyCallExpInternal attributeOrAssociationEndCall) {
	Connection conn = changeEvent.getEventTriggerConnection();
	CoreConnection coreConn = ((ConnectionWrapper) conn).unwrap();
	assert changeEvent instanceof AttributeValueChangeEvent || changeEvent instanceof LinkChangeEvent;
	Pair<RefObjectImpl, RefObjectImpl> result;
	if (changeEvent instanceof AttributeValueChangeEvent) {
	    Wrapper<?> sourceElement = (Wrapper<?>) ((AttributeValueChangeEvent) changeEvent).getAffectedElement(conn);
	    if (sourceElement != null) {
		result = new Pair<RefObjectImpl, RefObjectImpl>(/* source */ (RefObjectImpl) sourceElement.unwrap(), /* target */ null);
	    } else {
		result = null;
	    }
	} else {
	    AssociationEndCallExpInternal aece = (AssociationEndCallExpInternal) attributeOrAssociationEndCall;
	    SpiJmiHelper jmiHelper = coreConn.getCoreJmiHelper();
	    int aeceEndNumber = jmiHelper.getAssociationEndNumber(coreConn.getSession(), aece.getReferredAssociationEnd(coreConn));
	    LinkChangeEvent lce = (LinkChangeEvent) changeEvent;
	    RefObject sourceElement;
	    RefObject targetElement;
	    RefObjectImpl sourceElementUnwrapped;
	    RefObjectImpl targetElementUnwrapped;
	    if (aeceEndNumber == 0) {
		sourceElement = lce.getSecondLinkEnd(conn);
		targetElement = lce.getFirstLinkEnd(conn);
	    } else {
		sourceElement = lce.getFirstLinkEnd(conn);
		targetElement = lce.getSecondLinkEnd(conn);
	    }
	    if (sourceElement != null) {
		sourceElementUnwrapped = (RefObjectImpl) ((Wrapper<?>) sourceElement).unwrap();
	    } else {
		// TODO clarify if this is a severe problem; deletes may have occurred; how does this impact the impact analysis?
		sourceElementUnwrapped = null;
	    }
	    if (targetElement != null) {
		targetElementUnwrapped = (RefObjectImpl) ((Wrapper<?>) targetElement).unwrap();
	    } else {
		// TODO clarify if this is a severe problem; deletes may have occurred; how does this impact the impact analysis?
		targetElementUnwrapped = null;
	    }
	    result = new Pair<RefObjectImpl, RefObjectImpl>(sourceElementUnwrapped, targetElementUnwrapped);
	}
	if (result.getA() != null
		&& !result.getA().refIsInstanceOf(coreConn.getSession(),
			((OclExpressionInternal) attributeOrAssociationEndCall.getSource(coreConn)).getType(coreConn),
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
    private Set<? extends ModelPropertyCallExp> getAttributeOrAssociationEndCalls(ModelChangeEvent changeEvent) {
	CoreConnection conn = ((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap();
	Set<? extends ModelPropertyCallExp> result;
	if (changeEvent instanceof AttributeValueChangeEvent) {
	    result = associationEndAndAttributeCallFinder.getAttributeCallExpressions(
		    ((AttributeValueChangeEvent) changeEvent).getAffectedMetaObject(conn));
	} else if (changeEvent instanceof LinkChangeEvent) {
	    Set<AssociationEndCallExp> localResult = new HashSet<AssociationEndCallExp>();
	    AssociationWrapper assoc = (AssociationWrapper) ((LinkChangeEvent) changeEvent).getAffectedMetaObject(conn.getWrapper());
	    SpiJmiHelper jmiHelper = conn.getCoreJmiHelper();
	    List<AssociationEnd> ends = jmiHelper.getAssociationEnds(conn.getSession(), assoc.unwrap());
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
     * {@link OclExpressionInternal#getDefines()} is used because on "impl" objects the getters that receive the
     * {@link CoreConnection} need to be called. If the expression is not a body of an
     * operation, <tt>null</tt> is returned. Otherwise, the first operation (usually there would be
     * at most one) for which <tt>expression</tt> is the operation body is returned.
     */
    public static OperationImpl getDefines(CoreConnection conn, OclExpression expression) {
	JmiListImpl<?> operationList = (JmiListImpl<?>) ((OclExpressionInternal) expression).getDefines(conn);
	OperationImpl result;
	if (operationList.size(conn.getSession()) > 0) {
	    result = (OperationImpl) operationList.iterator(conn).next();
	} else {
	    result = null;
	}
	return result;
    }

}
