package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.Set;

import org.omg.ocl.expressions.__impl.EnumLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class EnumLiteralExpTracer extends AbstractTracer<EnumLiteralExpImpl> {
    public EnumLiteralExpTracer(CoreConnection conn, EnumLiteralExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public Set<RefObjectImpl> traceback(RefObjectImpl s) {
	return Collections.emptySet();
    }

}
