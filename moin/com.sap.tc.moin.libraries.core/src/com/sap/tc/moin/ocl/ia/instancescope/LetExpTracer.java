package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Set;

import org.omg.ocl.expressions.__impl.LetExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class LetExpTracer extends AbstractTracer<LetExpImpl> {
    public LetExpTracer(CoreConnection conn, LetExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	Tracer inTracer = InstanceScopeAnalysis.getTracer(getConnection(), getExpression().getIn(getConnection()));
	return inTracer.traceback(s);
    }

}
