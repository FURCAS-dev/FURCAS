package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.BooleanLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;

public class BooleanLiteralExpTracer extends AbstractTracer<BooleanLiteralExpImpl> {
    public BooleanLiteralExpTracer(CoreConnection conn, BooleanLiteralExpImpl expression) {
	super(conn, expression);
    }

}
