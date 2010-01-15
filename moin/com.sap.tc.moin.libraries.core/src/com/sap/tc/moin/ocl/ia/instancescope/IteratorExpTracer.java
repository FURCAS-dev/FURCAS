package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.Set;

import org.omg.ocl.expressions.__impl.IterateExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class IteratorExpTracer extends AbstractTracer<IterateExpImpl> {
    public IteratorExpTracer(CoreConnection conn, IterateExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	Set<RefObjectImpl> result;
	String name = getExpression().getName();
	if (name.equals("select") || name.equals("reject") || name.equals("sortedBy") || name.equals("any")) {
	    Tracer sourceTracer = InstanceScopeAnalysis.getTracer(getConnection(),
		    getExpression().getSource(getConnection()));
	    result = sourceTracer.traceback(s);
	} else if (name.equals("collect") || name.equals("collectNested")) {
	    Tracer sourceTracer = InstanceScopeAnalysis.getTracer(getConnection(),
		    getExpression().getBody(getConnection()));
	    result = sourceTracer.traceback(s);
	} else {
	    // boolean or other non-class-type-result iterator
	    result = Collections.emptySet();
	}
	return result;
    }

}
