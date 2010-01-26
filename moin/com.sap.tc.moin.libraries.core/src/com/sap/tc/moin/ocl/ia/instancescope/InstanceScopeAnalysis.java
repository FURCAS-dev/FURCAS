package com.sap.tc.moin.ocl.ia.instancescope;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.ModelPropertyCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclTypeImpl;
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
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Supports a lookup from a source model element of either an attribute value change event
 * or a link add/remove event together with an {@link OclExpression} to a set of context
 * objects for which the expression may return a value different from the one it returned
 * before the change event occurred.
 * 
 * @author Axel Uhl D043530
 *
 */
public class InstanceScopeAnalysis {
    private AssociationEndAndAttributeCallFinder associationEndAndAttributeCallFinder;
    private CoreConnection conn;
    
    public InstanceScopeAnalysis(CoreConnection conn) {
	this.conn = conn;
	associationEndAndAttributeCallFinder = new AssociationEndAndAttributeCallFinder(conn);
    }
    
    public InstanceScopeAnalysis(Connection conn) {
	this(((ConnectionWrapper) conn).unwrap());
    }
    
    public Set<MRI> getAffectedElements(OclExpression expression, RefObject context, ModelChangeEvent changeEvent) {
	return getAffectedElements((OclExpressionInternal) ((Wrapper<?>) expression).unwrap(),
		(RefObjectImpl) ((RefObjectWrapperImpl<?>) context).unwrap(), changeEvent);
    }

    /**
     * Tells the context model elements on which <tt>expression</tt> may now return a result different from
     * before the <tt>changeEvent</tt> occurred.
     */
    public Set<MRI> getAffectedElements(OclExpressionInternal expression, RefObjectImpl context, ModelChangeEvent changeEvent) {
	if (changeEvent instanceof ElementLifeCycleEvent) {
	    // create and delete of elements only affects the allInstances expressions;
	    // for those, however, no "self" context can easily be determined and therefore
	    // the expression may change value on all possible context instances:
	    RefObject metaObject = ((ElementLifeCycleEvent) changeEvent).getMetaObject(changeEvent.getEventTriggerConnection());
	    // If package extents are created (RefPackage), those may also trigger ElementLifeCycleEvents.
	    // However, their meta object would not be a Classifier but rather a package. Filter this case:
	    if (metaObject instanceof Classifier && expressionContainsAllInstancesCallForType(expression,
		    (ClassifierInternal) ((Wrapper<?>) metaObject).unwrap())) {
		return getAllPossibleContextInstancesMris(conn, context);
	    } else {
		return Collections.emptySet();
	    }
	} else {
	    Set<MRI> result = new LinkedHashSet<MRI>();
	    for (ModelPropertyCallExp attributeOrAssociationEndCall : getAttributeOrAssociationEndCalls(expression,
		    changeEvent)) {
		for (RefObjectImpl roi : self(attributeOrAssociationEndCall, getSourceElement(changeEvent,
			attributeOrAssociationEndCall), (Classifier) context)) {
		    result.add(roi.get___Mri());
		}
	    }
	    return result;
	}
    }

    private boolean expressionContainsAllInstancesCallForType(OclExpressionInternal expression, ClassifierInternal classifier) {
	associationEndAndAttributeCallFinder.walk(expression);
	return !associationEndAndAttributeCallFinder.getAllInstancesCallsFor(classifier).isEmpty();
    }

    protected static Set<MRI> getAllPossibleContextInstancesMris(CoreConnection conn, RefObject context) {
	return OclTypeImpl.getAllInstancesMris(conn, ((MofClass) context).getQualifiedName());
    }

    protected static Set<RefObjectImpl> getAllPossibleContextInstances(CoreConnection conn, RefObject context) {
	return OclTypeImpl.getAllInstances(conn, ((MofClass) context).getQualifiedName());
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
     * @param context TODO
     */
    private Set<RefObjectImpl> self(ModelPropertyCallExp attributeOrAssociationEndCall, RefObjectImpl sourceElement, Classifier context) {
	return getTracer(conn, attributeOrAssociationEndCall.getSource()).traceback(sourceElement, context);
    }
    
    /**
     * Factory method that creatss an instance of some {@link Tracer}-implementing class specific to the
     * type of the OCL <tt>expression</tt>.
     * @throws ClassNotFoundException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws SecurityException 
     * @throws IllegalArgumentException 
     * @throws JmiException 
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
     */
    private RefObjectImpl getSourceElement(ModelChangeEvent changeEvent, OclExpression attributeOrAssociationEndCall) {
	assert changeEvent instanceof AttributeValueChangeEvent || changeEvent instanceof LinkChangeEvent;
	RefObjectImpl result;
	if (changeEvent instanceof AttributeValueChangeEvent) {
	    result = (RefObjectImpl) ((AttributeValueChangeEvent) changeEvent).getAffectedElement(conn);
	} else {
	    AssociationEndCallExp aece = (AssociationEndCallExp) attributeOrAssociationEndCall;
	    SpiJmiHelper jmiHelper = conn.getCoreJmiHelper();
	    int aeceEndNumber = jmiHelper.getAssociationEndNumber(conn.getSession(), aece.getReferredAssociationEnd());
	    LinkChangeEvent lce = (LinkChangeEvent) changeEvent;
	    if (aeceEndNumber == 0) {
		result = (RefObjectImpl) lce.getSecondLinkEnd(conn);
	    } else {
		result = (RefObjectImpl) lce.getFirstLinkEnd(conn);
	    }
	}
	return result;
    }
    /**
     * Finds all attribute and association end call expressions in <tt>expression</tt> that are affected by the
     * <tt>changeEvent</tt>. The result is always non-<tt>null</tt> but may be empty.
     */
    private Set<? extends ModelPropertyCallExp> getAttributeOrAssociationEndCalls(OclExpressionInternal expression,
	    ModelChangeEvent changeEvent) {
	associationEndAndAttributeCallFinder.walk(expression);
	Set<? extends ModelPropertyCallExp> result;
	if (changeEvent instanceof AttributeValueChangeEvent) {
	    result = associationEndAndAttributeCallFinder.getAttributeCallExpressions(
		    ((AttributeValueChangeEvent) changeEvent).getAffectedMetaObject(conn));
	} else if (changeEvent instanceof LinkChangeEvent) {
	    Set<AssociationEndCallExp> localResult = new HashSet<AssociationEndCallExp>();
	    Association assoc = (Association) ((LinkChangeEvent) changeEvent).getAffectedMetaObject(conn);
	    SpiJmiHelper jmiHelper = conn.getCoreJmiHelper();
	    List<AssociationEnd> ends = jmiHelper.getAssociationEnds(conn.getSession(), assoc);
	    localResult.addAll(associationEndAndAttributeCallFinder.getAssociationEndCallExpressions(ends.get(0)));
	    localResult.addAll(associationEndAndAttributeCallFinder.getAssociationEndCallExpressions(ends.get(1)));
	    result = localResult;
	} else {
	    result = Collections.emptySet();
	}
	return result;
    }
    
    /**
     * For an "impl" object representing an OCL expression, obtains the type. {@link OclExpression#getType()} cannot
     * be used because on "impl" objects the getters that receive the {@link CoreConnection} need to be called.
     * This method does this by reflection because the abstract {@link OclExpression} interface doesn't offer
     * such a method.
     */
    protected static Classifier getType(CoreConnection conn, OclExpression expression) {
	try {
	    Method getType = expression.getClass().getDeclaredMethod("getType", CoreConnection.class);
	    return (Classifier) getType.invoke(expression, conn);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
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
