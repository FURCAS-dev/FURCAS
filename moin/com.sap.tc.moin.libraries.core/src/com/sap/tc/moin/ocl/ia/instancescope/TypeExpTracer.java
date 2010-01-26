package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.Set;

import org.omg.ocl.expressions.__impl.TypeExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;

public class TypeExpTracer extends AbstractTracer<TypeExpImpl> {
    public TypeExpTracer(CoreConnection conn, TypeExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s, Classifier context) {
	return Collections.emptySet();
    }

}
