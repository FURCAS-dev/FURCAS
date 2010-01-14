package com.sap.tc.moin.ocl.ia.instancescope;

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
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;

import com.sap.tc.moin.ocl.utils.treewalker.TreeWalker;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Operation;

/**
 * A tree walker that finds and remembers all expressions of type {@link AttributeCallExp} and
 * {@link AssociationEndCallExp}. Those are the ones for which later we must be able to find them quickly based on the
 * association/attribute and model element for which a corresponding change event was sent.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class AssociationEndAndAttributeCallFinder extends TreeWalker {
    private Map<Attribute, Set<AttributeCallExp>> attributeCallExpressions = new HashMap<Attribute, Set<AttributeCallExp>>();
    private Map<AssociationEnd, Set<AssociationEndCallExp>> associationEndCallExpressions = new HashMap<AssociationEnd, Set<AssociationEndCallExp>>();
    private Set<OclExpression> visitedExpressions = new HashSet<OclExpression>();

    public AssociationEndAndAttributeCallFinder(CoreConnection actConnection) {
	super(actConnection);
    }

    @Override
    protected void upAttributeCallExp(AttributeCallExp ace) {
	Set<AttributeCallExp> set = attributeCallExpressions.get(ace.getReferredAttribute());
	if (set==null) {
	    set = new HashSet<AttributeCallExp>();
	    attributeCallExpressions.put(ace.getReferredAttribute(), set);
	}
	set.add(ace);
    }

    @Override
    protected void upAssociationEndCallExp(AssociationEndCallExp ace) {
	Set<AssociationEndCallExp> set = associationEndCallExpressions.get(ace.getReferredAssociationEnd());
	if (set==null) {
	    set = new HashSet<AssociationEndCallExp>();
	    associationEndCallExpressions.put(ace.getReferredAssociationEnd(), set);
	}
	set.add(ace);
    }
    
    /**
     * If an operation is defined by an OCL body, walk that body too and collect all attribute
     * and association end calls from it recursively.
     */
    @Override
    protected void upOperationCallExp(OperationCallExp oce) {
	Operation referredOperation = ((OperationCallExpImpl) oce).getReferredOperation(connection);
	OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) connection
		.getAssociation(OperationBodyDefinition.ASSOCIATION_DESCRIPTOR);
	OclExpression bodyExpr = assoc.getBody(connection, referredOperation);
	if (bodyExpr != null) {
	    walk(bodyExpr);
	}
    }
    
    /**
     * Always returns a non-<tt>null</tt> set
     */
    public Set<AttributeCallExp> getAttributeCallExpressions(Attribute a) {
	Set<AttributeCallExp> result;
	Set<AttributeCallExp> lookup = attributeCallExpressions.get(a);
	if (lookup == null) {
	    result = Collections.emptySet();
	} else {
	    result = Collections.unmodifiableSet(attributeCallExpressions.get(a));
	}
	return result;
    }

    /**
     * Always returns a non-<tt>null</tt> set
     */
    public Set<AssociationEndCallExp> getAssociationEndCallExpressions(AssociationEnd a) {
	Set<AssociationEndCallExp> result;
	Set<AssociationEndCallExp> lookup = associationEndCallExpressions.get(a);
	if (lookup == null) {
	    result = Collections.emptySet();
	} else {
	    result = Collections.unmodifiableSet(associationEndCallExpressions.get(a));
	}
	return result;
    }
    
    public void walk(OclExpression expression) {
	if (!visitedExpressions.contains(expression)) {
	    visitedExpressions.add(expression);
	    super.walk(expression);
	}
    }
}
