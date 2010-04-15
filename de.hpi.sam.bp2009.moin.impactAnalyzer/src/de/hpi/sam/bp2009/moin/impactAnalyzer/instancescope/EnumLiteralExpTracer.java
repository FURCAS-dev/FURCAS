package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.EnumLiteralExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;

public class EnumLiteralExpTracer extends AbstractTracer<EnumLiteralExpImpl> {
    public EnumLiteralExpTracer(CoreConnection conn, EnumLiteralExpImpl expression) {
	super(conn, expression);
    }

}
