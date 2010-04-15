package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.IntegerLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;

public class DoubleLiteralExpTracer extends AbstractTracer<IntegerLiteralExpImpl> {
    public DoubleLiteralExpTracer(CoreConnection conn, IntegerLiteralExpImpl expression) {
	super(conn, expression);
    }

}
