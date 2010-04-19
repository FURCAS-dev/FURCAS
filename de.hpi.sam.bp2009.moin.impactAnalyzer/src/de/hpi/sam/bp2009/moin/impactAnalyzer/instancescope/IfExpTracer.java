package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;

public class IfExpTracer extends AbstractTracer<IfExp> {
	public IfExpTracer(IfExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
		NavigationStep thenPath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getThenExpression(), context, classScopeAnalyzer);
		NavigationStep elsePath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getElseExpression(), context, classScopeAnalyzer);
		return new BranchingNavigationStep(getInnermostElementType(getExpression().getType()), context, getExpression(), thenPath, elsePath);
	}

}
