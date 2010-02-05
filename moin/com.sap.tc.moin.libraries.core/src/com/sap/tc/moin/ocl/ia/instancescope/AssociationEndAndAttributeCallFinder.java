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
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.OperationCallExpInternal;
import org.omg.ocl.expressions.__impl.TypeExpInternal;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.treewalker.TreeWalker;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * A tree walker that finds and remembers all expressions of type {@link AttributeCallExp} and
 * {@link AssociationEndCallExp}. Those are the ones for which later we must be able to find them quickly based on the
 * association/attribute and model element for which a corresponding change event was sent.<p>
 * 
 * TODO Turn this into a cache where a client can free the results of walking a top-level expression after using it
 * 
 * @author Axel Uhl D043530
 * 
 */
public class AssociationEndAndAttributeCallFinder extends TreeWalker {
    private Map<Attribute, Set<AttributeCallExp>> attributeCallExpressions = new HashMap<Attribute, Set<AttributeCallExp>>();
    private Map<AssociationEnd, Set<AssociationEndCallExp>> associationEndCallExpressions = new HashMap<AssociationEnd, Set<AssociationEndCallExp>>();
    private Set<OclExpressionInternal> visitedExpressions = new HashSet<OclExpressionInternal>();
    private Map<ClassifierInternal, Set<OperationCallExp>> allInstancesCalls = new HashMap<ClassifierInternal, Set<OperationCallExp>>();

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
	OclExpressionInternal bodyExpr = (OclExpressionInternal) assoc.getBody(connection, referredOperation);
	if (bodyExpr != null) {
	    walk(bodyExpr);
	} else if (referredOperation.getName().equals(OclConstants.OP_ALLINSTANCES)) {
	    Classifier classifier = ((TypeExpInternal) ((OperationCallExpInternal) oce).getSource(connection)).getReferredType(connection);
	    for (ClassifierInternal specialization : getAllSpecializationsIncludingSelf((ClassifierInternal) classifier)) {
		Set<OperationCallExp> set = allInstancesCalls.get(specialization);
		if (set == null) {
		    set = new HashSet<OperationCallExp>();
		    allInstancesCalls.put(specialization, set);
		}
		set.add(oce);
	    }
	}
    }
    
    private Set<ClassifierInternal> getAllSpecializationsIncludingSelf(ClassifierInternal classifier) {
	Set<ClassifierInternal> result = new HashSet<ClassifierInternal>();
	SpiJmiHelper jmiHelper = connection.getCoreJmiHelper();
	for (GeneralizableElement ge : jmiHelper.getAllSubtypes(connection, (GeneralizableElement) classifier)) {
	    result.add((ClassifierInternal) ge);
	}
	result.add(classifier);
	return result;
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

    /**
     * Always returns a non-<tt>null</tt> set. Finds all occurrences of an <tt>allInstances</tt> call on a type
     * expression for the classifier <tt>c</tt> or its generalizations in the expression analyzed by this visitor.
     */
    public Set<OperationCallExp> getAllInstancesCallsFor(ClassifierInternal c) {
	Set<OperationCallExp> result = allInstancesCalls.get(c);
	if (result == null) {
	    result = Collections.emptySet();
	}
	return result;
    }
    
    public void walk(OclExpressionInternal expression) {
	if (!connection.isAlive()) {
	    throw new RuntimeException("Can't walk OCL expression with dead connection "+connection);
	}
	if (!visitedExpressions.contains(expression)) {
	    visitedExpressions.add(expression);
	    super.walk((OclExpression) expression);
	}
    }
}
