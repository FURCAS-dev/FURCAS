package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.HashSet;
import java.util.Set;

import org.omg.ocl.expressions.__impl.IfExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class IfExpTracer extends AbstractTracer<IfExpImpl> {
    public IfExpTracer(CoreConnection conn, IfExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	Tracer thenTracer = InstanceScopeAnalysis.getTracer(getConnection(), getExpression().getThenExpression(getConnection()));
	Tracer elseTracer = InstanceScopeAnalysis.getTracer(getConnection(), getExpression().getElseExpression(getConnection()));
	Set<RefObjectImpl> result = new HashSet<RefObjectImpl>();
	result.addAll(thenTracer.traceback(s));
	result.addAll(elseTracer.traceback(s));
	return result;
    }

}
