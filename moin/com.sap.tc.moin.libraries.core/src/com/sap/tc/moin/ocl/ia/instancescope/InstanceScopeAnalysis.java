package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.ModelPropertyCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.ModelPropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclTypeImpl;
import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.ocl.ia.relevance.NavigationPath;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectWrapperImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementLifeCycleEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationWrapper;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
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
    private final AssociationEndAndAttributeCallFinder associationEndAndAttributeCallFinder;
    private final Map<OclExpression, NavigationStep> expressionToStep;
    private final PathCache pathCache;
    private final ClassScopeAnalyzer classScopeAnalyzer;

    /**
     * @param conn
     *            the connection used to
     * @param pathCache
     *            caches {@link NavigationPath} traceback navigations to the possible contexts for a given expression
     *            that can be invoked for model elements; using this cache avoids redundant path calculations for common
     *            subexpressions, such as operation bodies called by several expressions.
     * @param classScopeAnalyzer
     *            makes available the operation call relations reachable from the root expression that was analyzed by
     *            the class scope analyzer.
     */
    public InstanceScopeAnalysis(CoreConnection conn, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	associationEndAndAttributeCallFinder = new AssociationEndAndAttributeCallFinder(conn);
	expressionToStep = new HashMap<OclExpression, NavigationStep>();
	this.pathCache = pathCache;
	this.classScopeAnalyzer = classScopeAnalyzer;
    }
    
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
	    result = getTracer(conn, exp).traceback(context, pathCache, classScopeAnalyzer);
	    expressionToStep.put(exp, result);
	}
	return result;
    }
    
    public Set<MRI> getAffectedElements(OclExpression expression, MofClass context, ModelChangeEvent changeEvent) {
	return getAffectedElements((OclExpressionInternal) ((Wrapper<?>) expression).unwrap(),
		(MofClassImpl) ((RefObjectWrapperImpl<?>) context).unwrap(), changeEvent);
    }

    /**
     * Tells the context model elements on which <tt>expression</tt> may now return a result different from
     * before the <tt>changeEvent</tt> occurred.
     */
    public Set<MRI> getAffectedElements(OclExpressionInternal expression, MofClassImpl context, ModelChangeEvent changeEvent) {
	if (changeEvent instanceof ElementLifeCycleEvent) {
	    // create and delete of elements only affects the allInstances expressions;
	    // for those, however, no "self" context can easily be determined and therefore
	    // the expression may change value on all possible context instances:
	    RefObject metaObject = ((ElementLifeCycleEvent) changeEvent).getMetaObject(changeEvent.getEventTriggerConnection());
	    // If package extents are created (RefPackage), those may also trigger ElementLifeCycleEvents.
	    // However, their meta object would not be a Classifier but rather a package. Filter this case:
	    if (metaObject instanceof Classifier && expressionContainsAllInstancesCallForType(expression,
		    (ClassifierInternal) ((Wrapper<?>) metaObject).unwrap())) {
		return getAllPossibleContextInstancesMris(((ConnectionWrapper) changeEvent.getEventTriggerConnection())
			.unwrap(), context);
	    } else {
		return Collections.emptySet();
	    }
	} else {
	    Set<MRI> result = new LinkedHashSet<MRI>();
	    for (ModelPropertyCallExp attributeOrAssociationEndCall : getAttributeOrAssociationEndCalls(expression,
		    changeEvent)) {
		RefObjectImpl sourceElement = getSourceElement(changeEvent, (ModelPropertyCallExpInternal) attributeOrAssociationEndCall);
		if (sourceElement != null) {
		    // the source element may have been deleted already by subsequent events; at this point,
		    // this makes it impossible to trace the change event back to a context; all we have is
		    // the LRI of a no longer existing model element...
		    for (RefObjectImpl roi : self(attributeOrAssociationEndCall, sourceElement, context,
			    ((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap())) {
			result.add(roi.get___Mri());
		    }
		}
	    }
	    return result;
	}
    }

    private boolean expressionContainsAllInstancesCallForType(OclExpressionInternal expression, ClassifierInternal classifier) {
	associationEndAndAttributeCallFinder.walk(expression);
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
     */
    private Set<RefObjectImpl> self(ModelPropertyCallExp attributeOrAssociationEndCall, RefObjectImpl sourceElement,
	    MofClass context, CoreConnection connection) {
	NavigationStep step = getNavigationStepsToSelfForExpression(connection, attributeOrAssociationEndCall
		.getSource(), context);
	Set<RefObjectImpl> sourceElementAsSet = Collections.singleton(sourceElement);
	Set<RefObjectImpl> result = step.navigate(connection, sourceElementAsSet);
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
     * @return <tt>null</tt> in case the source element indicated by the change event does not conform to the static
     *         attribute or association call's source expression type. <tt>null</tt> may also result if the element
     *         indicated by the event cannot be resolved (anymore). This is still an open issue. See the to-do marker
     *         below. In all other cases, the source element on which the event occured, is returned.
     */
    private RefObjectImpl getSourceElement(ModelChangeEvent changeEvent, ModelPropertyCallExpInternal attributeOrAssociationEndCall) {
	Connection conn = changeEvent.getEventTriggerConnection();
	CoreConnection coreConn = ((ConnectionWrapper) conn).unwrap();
	assert changeEvent instanceof AttributeValueChangeEvent || changeEvent instanceof LinkChangeEvent;
	RefObjectImpl result;
	if (changeEvent instanceof AttributeValueChangeEvent) {
	    result = (RefObjectImpl) ((Wrapper<?>) ((AttributeValueChangeEvent) changeEvent).getAffectedElement(conn)).unwrap();
	} else {
	    AssociationEndCallExpInternal aece = (AssociationEndCallExpInternal) attributeOrAssociationEndCall;
	    SpiJmiHelper jmiHelper = coreConn.getCoreJmiHelper();
	    int aeceEndNumber = jmiHelper.getAssociationEndNumber(coreConn.getSession(), aece.getReferredAssociationEnd(coreConn));
	    LinkChangeEvent lce = (LinkChangeEvent) changeEvent;
	    RefObject refObjectResult;
	    if (aeceEndNumber == 0) {
		refObjectResult = lce.getSecondLinkEnd(conn);
	    } else {
		refObjectResult = lce.getFirstLinkEnd(conn);
	    }
	    if (refObjectResult != null) {
		result = (RefObjectImpl) ((Wrapper<?>) refObjectResult).unwrap();
	    } else {
		// TODO clarify if this is a severe problem; deletes may have occurred; how does this impact the impact analysis?
		result = null;
	    }
	}
	if (result != null
		&& !result.refIsInstanceOf(coreConn.getSession(),
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
    private Set<? extends ModelPropertyCallExp> getAttributeOrAssociationEndCalls(OclExpressionInternal expression,
	    ModelChangeEvent changeEvent) {
	CoreConnection conn = ((ConnectionWrapper) changeEvent.getEventTriggerConnection()).unwrap();
	associationEndAndAttributeCallFinder.walk(expression);
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
    protected static OperationImpl getDefines(CoreConnection conn, OclExpression expression) {
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
