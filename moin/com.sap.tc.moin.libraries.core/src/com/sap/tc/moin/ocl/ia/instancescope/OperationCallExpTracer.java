package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.Set;

import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;

public class OperationCallExpTracer extends AbstractTracer<OperationCallExpImpl> {
    public OperationCallExpTracer(CoreConnection conn, OperationCallExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	Set<RefObjectImpl> result;
	OperationBodyDefinitionImpl a = (OperationBodyDefinitionImpl) getConnection().getAssociation(
		OperationBodyDefinition.ASSOCIATION_DESCRIPTOR);
	OclExpression body = a.getBody(getConnection(), getExpression().getReferredOperation(getConnection()));
	if (body != null) {
	    // an OCL-specified operation; trace back using the body expression
	    Tracer bodyTracer = InstanceScopeAnalysis.getTracer(getConnection(), body);
	    result = bodyTracer.traceback(s);
	} else if (((OperationImpl) getExpression().getReferredOperation(getConnection())).getName().equals(
		"oclAsType")) {
	    OclExpression argument = ((JmiListImpl<OclExpression>) getExpression().getArguments(getConnection())).get(
		    getConnection().getSession(), 0);
	    if (argument instanceof TypeExp) {
		Classifier type = ((TypeExpImpl) argument).getReferredType(getConnection());
		if (s.refIsInstanceOf(getConnection().getSession(), type, /* considerSubtypes */ true)) {
		    result = InstanceScopeAnalysis.getTracer(getConnection(),
			    getExpression().getSource(getConnection())).traceback(s);
		} else {
		    result = Collections.emptySet();
		}
	    } else {
		throw new RuntimeException("What else could be the argument of oclAsType if not a TypeExp? "+
			((MofClass) argument.refMetaObject()).getName());
	    }
	} else {
	    // TODO handle stdlib operations
	    throw new RuntimeException("not OCL-implemented operations other than oclAsType not supported yet");
	}
	return result;
    }

}
