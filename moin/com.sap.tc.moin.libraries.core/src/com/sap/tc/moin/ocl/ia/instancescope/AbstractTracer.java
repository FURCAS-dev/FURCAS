package com.sap.tc.moin.ocl.ia.instancescope;

import org.omg.ocl.expressions.ATuplePartTupleLiteralExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.ATuplePartTupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

public abstract class AbstractTracer<T extends RefObjectImpl> implements Tracer {
    private T expression;
    private CoreConnection conn;

    protected AbstractTracer(CoreConnection conn, T expression) {
	this.conn = conn;
	this.expression = expression;
    }

    protected T getExpression() {
	return expression;
    }

    protected CoreConnection getConnection() {
	return conn;
    }

    protected OclExpression getRootExpression() {
	RefFeatured rootOrTupleLiteralVariableDeclaration = getExpression().refOutermostComposite(
		getConnection().getSession());
	ATuplePartTupleLiteralExpImpl a = (ATuplePartTupleLiteralExpImpl) getConnection().getAssociation(
		ATuplePartTupleLiteralExp.ASSOCIATION_DESCRIPTOR);
	while (rootOrTupleLiteralVariableDeclaration instanceof VariableDeclaration) {
	    // handle the special case of VariableDeclaration that represents a tuplePart
	    JmiListImpl<TupleLiteralExp> tupleLiteralCollection = ((JmiListImpl<TupleLiteralExp>) a.getTupleLiteralExp(getConnection(),
			(VariableDeclaration) rootOrTupleLiteralVariableDeclaration));
	    rootOrTupleLiteralVariableDeclaration = ((TupleLiteralExpImpl) tupleLiteralCollection.iterator(getConnection()).next()).
	    						refOutermostComposite(getConnection().getSession());
	}
	return (OclExpression) rootOrTupleLiteralVariableDeclaration;
    }
}
