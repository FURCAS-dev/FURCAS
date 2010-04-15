package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.IteratorExpImpl;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class IterateExpTracer extends AbstractTracer<IteratorExpImpl> {
    public IterateExpTracer(CoreConnection conn, IteratorExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	return pathCache.getOrCreateNavigationPath(getConnection(), getExpression().getBody(getConnection()), context, classScopeAnalyzer);
    }

}
