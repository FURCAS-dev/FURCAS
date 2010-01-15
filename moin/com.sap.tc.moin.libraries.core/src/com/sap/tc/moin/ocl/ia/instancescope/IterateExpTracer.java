package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Set;

import org.omg.ocl.expressions.__impl.IteratorExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class IterateExpTracer extends AbstractTracer<IteratorExpImpl> {
    public IterateExpTracer(CoreConnection conn, IteratorExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	Tracer bodyTracer = InstanceScopeAnalysis.getTracer(getConnection(), getExpression().getBody(getConnection()));
	return bodyTracer.traceback(s);
    }

}
