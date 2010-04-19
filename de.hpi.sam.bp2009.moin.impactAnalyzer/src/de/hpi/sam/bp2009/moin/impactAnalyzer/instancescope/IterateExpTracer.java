package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;

public class IterateExpTracer extends AbstractTracer<IterateExp> {
	public IterateExpTracer(IterateExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
		return pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getBody(), context, classScopeAnalyzer);
	}

}
