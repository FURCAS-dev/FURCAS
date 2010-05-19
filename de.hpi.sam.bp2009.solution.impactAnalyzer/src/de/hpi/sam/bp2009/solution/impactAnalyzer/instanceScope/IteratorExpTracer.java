package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;



public class IteratorExpTracer extends AbstractTracer<IteratorExp> {
	public IteratorExpTracer(IteratorExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
		NavigationStep result;
		String name = getExpression().getName();
		if (name.equals("select") || name.equals("reject") || name.equals("sortedBy") || name.equals("any")) {
			result = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getSource(),
					context, filterSynthesizer);
		} else if (name.equals("collect") || name.equals("collectNested")) {
			result = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getBody(),
					context, filterSynthesizer);
		} else {
			// boolean or other non-class-type-result iterator
			result = new EmptyResultNavigationStep(getExpression());
		}
		return result;
	}

}
