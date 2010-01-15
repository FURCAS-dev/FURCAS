package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.HashSet;
import java.util.Set;

import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.__impl.CollectionItemImpl;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class CollectionLiteralExpTracer extends AbstractTracer<CollectionLiteralExpImpl> {
    public CollectionLiteralExpTracer(CoreConnection conn, CollectionLiteralExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	Set<RefObjectImpl> result = new HashSet<RefObjectImpl>();
	for (CollectionLiteralPart part : getExpression().getParts(getConnection())) {
	    if (part instanceof CollectionItem) {
		Tracer itemTracer = InstanceScopeAnalysis.getTracer(getConnection(),
			((CollectionItemImpl) part).getItem(getConnection()));
		result.addAll(itemTracer.traceback(s));
	    }
	}
	return result;
    }

}
