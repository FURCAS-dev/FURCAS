package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.omg.ocl.expressions.__impl.IteratorExpImpl;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class IteratorExpTracer extends AbstractTracer<IteratorExpImpl> {
    public IteratorExpTracer(CoreConnection conn, IteratorExpImpl expression) {
	super(conn, expression);
    }

    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep result;
	String name = getExpression().getName();
	if (name.equals("select") || name.equals("reject") || name.equals("sortedBy") || name.equals("any")) {
	    result = pathCache.getOrCreateNavigationPath(getConnection(), getExpression().getSource(getConnection()),
		    context, classScopeAnalyzer);
	} else if (name.equals("collect") || name.equals("collectNested")) {
	    result = pathCache.getOrCreateNavigationPath(getConnection(), getExpression().getBody(getConnection()),
		    context, classScopeAnalyzer);
	} else {
	    // boolean or other non-class-type-result iterator
	    result = new EmptyResultNavigationStep(getExpression());
	}
	return result;
    }

}
