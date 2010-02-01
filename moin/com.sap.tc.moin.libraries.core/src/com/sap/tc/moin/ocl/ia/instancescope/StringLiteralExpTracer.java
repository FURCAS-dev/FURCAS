package com.sap.tc.moin.ocl.ia.instancescope;

import org.omg.ocl.expressions.__impl.StringLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;

public class StringLiteralExpTracer extends AbstractTracer<StringLiteralExpImpl> {
    public StringLiteralExpTracer(CoreConnection conn, StringLiteralExpImpl expression) {
	super(conn, expression);
    }

}
