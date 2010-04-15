package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.TypeExpImpl;

import com.sap.tc.moin.repository.core.CoreConnection;

public class TypeExpTracer extends AbstractTracer<TypeExpImpl> {
    public TypeExpTracer(CoreConnection conn, TypeExpImpl expression) {
	super(conn, expression);
    }

}
