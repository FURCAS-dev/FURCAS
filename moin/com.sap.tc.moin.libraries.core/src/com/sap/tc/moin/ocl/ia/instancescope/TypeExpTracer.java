package com.sap.tc.moin.ocl.ia.instancescope;

import org.omg.ocl.expressions.__impl.TypeExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;

public class TypeExpTracer extends AbstractTracer<TypeExpImpl> {
    public TypeExpTracer(CoreConnection conn, TypeExpImpl expression) {
	super(conn, expression);
    }

}
