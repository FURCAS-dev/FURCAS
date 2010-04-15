package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.RealLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;

public class RealLiteralExpTracer extends AbstractTracer<RealLiteralExpImpl> {
    public RealLiteralExpTracer(CoreConnection conn, RealLiteralExpImpl expression) {
	super(conn, expression);
    }

}
