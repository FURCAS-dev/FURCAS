package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Iterator;
import java.util.Set;

import org.omg.ocl.expressions.ATypeOclExpression;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.ATypeOclExpressionImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.types.TupleType;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;

public class AttributeCallExpTracer extends AbstractTracer<AttributeCallExpImpl> {
    public AttributeCallExpTracer(CoreConnection conn, AttributeCallExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s, Classifier context) {
	String referredAttributeName = getExpression().getReferredAttribute(getConnection()).getName();
	OclExpression source = getExpression().getSource(getConnection());
	Classifier type = InstanceScopeAnalysis.getType(getConnection(), source);
	OclExpression sourceExpression = null;
	RefObjectImpl sourceObject;
	if (type instanceof TupleType) {
	    JmiListImpl<VariableDeclaration> tupleParts = (JmiListImpl<VariableDeclaration>) ((TupleLiteralExpImpl) ((JmiListImpl<OclExpression>) ((ATypeOclExpressionImpl) getConnection()
		    .getAssociation(ATypeOclExpression.ASSOCIATION_DESCRIPTOR)).getOclExpression(getConnection(), type))
		    .iterator(getConnection()).next()).getTuplePart(getConnection());
	    for (Iterator<VariableDeclaration> i=tupleParts.iterator(getConnection()); i.hasNext(); ) {
		VariableDeclaration tuplePart = i.next();
		if (tuplePart.getName().equals(referredAttributeName)) {
		    sourceExpression = ((VariableDeclarationImpl) tuplePart).getInitExpression(getConnection());
		    break;
		}
	    }
	    if (sourceExpression == null) {
		throw new RuntimeException("Internal error. Couldn't find tuple part named "+referredAttributeName);
	    }
	    sourceObject = s;
	} else {
	    sourceExpression = getExpression().getSource(getConnection());
	    sourceObject = (RefObjectImpl) s.refImmediateComposite(getConnection().getSession());
	}
	return InstanceScopeAnalysis.getTracer(getConnection(), sourceExpression).traceback(sourceObject, context);
    }

}
