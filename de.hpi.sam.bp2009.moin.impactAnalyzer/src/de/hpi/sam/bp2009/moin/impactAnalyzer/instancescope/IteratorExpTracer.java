package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;

public class IteratorExpTracer extends AbstractTracer<IteratorExp> {
	public IteratorExpTracer(IteratorExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
		NavigationStep result;
		String name = getExpression().getName();
		if (name.equals("select") || name.equals("reject") || name.equals("sortedBy") || name.equals("any")) {
			result = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getSource(),
					context, classScopeAnalyzer);
		} else if (name.equals("collect") || name.equals("collectNested")) {
			result = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getBody(),
					context, classScopeAnalyzer);
		} else {
			// boolean or other non-class-type-result iterator
			result = new EmptyResultNavigationStep(getExpression());
		}
		return result;
	}

}
