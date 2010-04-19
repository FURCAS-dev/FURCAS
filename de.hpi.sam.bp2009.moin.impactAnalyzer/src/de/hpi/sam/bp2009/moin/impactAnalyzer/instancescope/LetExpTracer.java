package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;

public class LetExpTracer extends AbstractTracer<LetExp> {
	public LetExpTracer(LetExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
		return pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getIn(), context, classScopeAnalyzer);
	}

}
