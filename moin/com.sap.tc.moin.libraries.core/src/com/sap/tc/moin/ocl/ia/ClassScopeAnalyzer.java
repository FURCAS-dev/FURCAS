package com.sap.tc.moin.ocl.ia;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.AttributeCallExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpInternal;
import org.omg.ocl.expressions.__impl.TypeExpInternal;
import org.omg.ocl.expressions.__impl.VariableExpInternal;

import com.sap.tc.moin.ocl.ia.instancescope.InstanceScopeAnalysis;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.treewalker.TreeWalker;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Collects the events for a single {@link OclExpression} recursively. The analyzer can be parameterized during
 * construction such that it either registers for creation events on the context type or not. Registering for element
 * creation on the context type is useful for invariants / constraints because when a new element is created, validating
 * the constraint may be useful. For other use cases, registering for element creation may not be so useful. For
 * example, when a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
 * the element has been fully initialized from those OCL expressions. In those cases, some framework may be responsible
 * for the initial evaluation of those OCL expressions on new element, and therefore, context element creation events
 * are not of interest.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class ClassScopeAnalyzer extends TreeWalker {
    final private boolean notifyNewContextElements;
    final private Set<EventFilter> filters = new HashSet<EventFilter>();
    
    /**
     * For each operation body analyzed, stores the calls to the operation that were visited
     */
    final private Map<OclExpression, Set<OperationCallExp>> visitedOperationBodies = new HashMap<OclExpression, Set<OperationCallExp>>();
    
    // TODO declare structures to accumulate the events of the expression analyzed; may need to add some data to avoid
    // redundant/duplicate filters

    /**
     * Use this constructor when you have a {@link CoreConnection} at hand, meaning that you're "inside" the
     * core. The OCL expression in this case is an "Impl" object.
     * 
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation
     *            events on the context type or not. Registering for element creation on the context type is useful for
     *            invariants / constraints because when a new element is created, validating the constraint may be
     *            useful. For other use cases, registering for element creation may not be so useful. For example, when
     *            a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
     *            the element has been fully initialized from those OCL expressions. In those cases, some framework may
     *            be responsible for the initial evaluation of those OCL expressions on new elementt, and therefore,
     *            context element creation events are not of interest.
     */
    public ClassScopeAnalyzer(CoreConnection actConnection, OclExpressionInternal exp, boolean notifyNewContextElements) {
	super(actConnection);
	this.notifyNewContextElements = notifyNewContextElements;
	walk((OclExpression) exp);
    }
    
    /**
     * Use this constructor when invoking from outside the core. This means you have a client's connection
     * at hand, and the OCL expression object is actually a wrapper 
     * @param conn
     * @param exp
     * @param notifyNewContextElements
     */
    public ClassScopeAnalyzer(Connection conn, OclExpression exp, boolean notifyNewContextElements) {
	this(((ConnectionWrapper) conn).unwrap(), (OclExpressionInternal) ((Wrapper<?>) exp).unwrap(),
		notifyNewContextElements);
    }

    /**
     * Obtains the event filter for the expression passed to the constructor. When an event matches the filter, the
     * value of the expression may have changed for one or more evaluation contexts. To determine a superset of those
     * context elements for which the value may have changed, feed the event and the {@link OclStatement} holding the
     * expression and its context into
     * {@link InstanceScopeAnalysis#getAffectedElements(com.sap.tc.moin.ocl.utils.OclStatement, com.sap.tc.moin.repository.events.type.ModelChangeEvent, Map)}.
     */
    public EventFilter getEventFilter() {
	return new OrFilter(filters);
    }
    
    /**
     * TODO check if adding the filter is redundant to another filter already in {@link #filters}. If so, combine into one.
     * 
     * The combination of filters 
     */
    private void addFilter(EventFilter filter) {
	filters.add(filter);
    }

    @Override
    protected void upAssociationEndCallExp(AssociationEndCallExp exp) {
	addFilter(new AndFilter(new AssociationFilter(
		(Association) ((AssociationImpl) ((AssociationEndInternal) ((AssociationEndCallExpInternal) exp)
			.getReferredAssociationEnd(connection)).getContainer(connection)).createWrapper(connection,
				/* synchronize */ true)), new ClassFilter(
		(MofClass) ((MofClassImpl) ((OclExpressionInternal) ((AssociationEndCallExpInternal) exp).getSource(connection))
			.getType(connection)).createWrapper(connection, /* synchronize */ true), /* includeSubclasses */ true)));
    }

    @Override
    protected void upAttributeCallExp(AttributeCallExp exp) {
	AttributeCallExpInternal attributeCall = (AttributeCallExpInternal) exp;
	Classifier sourceType = ((OclExpressionInternal) attributeCall.getSource(connection)).getType(connection);
	AttributeImpl attribute = (AttributeImpl) attributeCall.getReferredAttribute(connection);
	if (sourceType instanceof MofClass) { // and not a TupleType, which is the other possible source type
	    addFilter(new AndFilter(new AttributeFilter((Attribute) attribute.createWrapper(connection, /* synchronize */
	    true)), new ClassFilter((MofClass) ((MofClassImpl) sourceType).createWrapper(connection, /* synchronize */
		    true),
	    /* includeSubclasses */true)));
	}
    }

    @Override
    protected void upOperationCallExp(OperationCallExp exp) {
	OperationCallExpInternal expInt = (OperationCallExpInternal) exp;
	if (expInt.getReferredOperation(connection).getName().equals(
		OclConstants.OP_ALLINSTANCES)) {
	    TypeExpInternal typeExp = (TypeExpInternal) expInt.getSource(connection);
	    addFilter(new AndFilter(
		    new OrFilter(new EventTypeFilter(ElementCreateEvent.class),
			         new EventTypeFilter(ElementDeleteEvent.class)),
		    new ClassFilter((MofClass) ((MofClassImpl) typeExp.getReferredType(connection)).createWrapper(
			    connection, /* synchronize */true),
			    /* includeSubclasses */ true /* because we understand the allInstances() as returning subclass instances too */)));
	} else {
	    OperationBodyDefinitionImpl a = (OperationBodyDefinitionImpl) connection
		    .getAssociation(OperationBodyDefinition.ASSOCIATION_DESCRIPTOR);
	    OclExpression body = a.getBody(connection, expInt.getReferredOperation(connection));
	    if (body != null) {
		Set<OperationCallExp> analyzedCallsToBody = visitedOperationBodies.get(body);
		if (analyzedCallsToBody == null) {
		    analyzedCallsToBody = new HashSet<OperationCallExp>();
		    // we didn't analyze the body on behalf of the this analyzer's root expression yet; do it now: 
		    visitedOperationBodies.put(body, analyzedCallsToBody);
		    walk(body);
		}
		analyzedCallsToBody.add(exp);
	    }
	}
    }
    
    /**
     * Returns all the calls to the operation whose body is <tt>operationBody</tt> that are reachable
     * from the root expression analyzed by this {@link ClassScopeAnalyzer}. If no such calls exist,
     * an empty set is returned.
     */
    public Set<OperationCallExp> getCallsOf(OclExpressionInternal operationBody) {
	Set<OperationCallExp> result = visitedOperationBodies.get(operationBody);
	if (result == null) {
	    result = Collections.emptySet();
	}
	return result;
    }

    @Override
    protected void upVariableExp(VariableExp exp) {
	if (((VariableExpInternal) exp).getReferredVariable(connection).getVarName().equals(OclConstants.VAR_SELF)
		&& notifyNewContextElements) {
	    addFilter(new AndFilter(new EventTypeFilter(ElementCreateEvent.class), new ClassFilter(
		    (MofClass) ((MofClassImpl) ((VariableExpInternal) exp).getType(connection)).createWrapper(
			    connection, /* synchronize */true),
		    /* includeSubclasses */true /*
						 * because we understand the allInstances() as returning subclass
						 * instances too
						 */)));
	}
    }
}
