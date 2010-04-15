package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.IfExpImpl;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class IfExpTracer extends AbstractTracer<IfExpImpl> {
    public IfExpTracer(CoreConnection conn, IfExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep thenPath = pathCache.getOrCreateNavigationPath(getConnection(), getExpression().getThenExpression(getConnection()), context, classScopeAnalyzer);
	NavigationStep elsePath = pathCache.getOrCreateNavigationPath(getConnection(), getExpression().getElseExpression(getConnection()), context, classScopeAnalyzer);
	return new BranchingNavigationStep(getConnection(),
		getInnermostElementType(getExpression().getType(getConnection())), context, getExpression(), thenPath, elsePath);
    }

}
