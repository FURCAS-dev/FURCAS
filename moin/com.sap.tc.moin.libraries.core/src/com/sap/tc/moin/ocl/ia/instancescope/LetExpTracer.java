package com.sap.tc.moin.ocl.ia.instancescope;

import org.omg.ocl.expressions.__impl.LetExpImpl;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class LetExpTracer extends AbstractTracer<LetExpImpl> {
    public LetExpTracer(CoreConnection conn, LetExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	return pathCache.getOrCreateNavigationPath(getConnection(), getExpression().getIn(getConnection()), context, classScopeAnalyzer);
    }

}
