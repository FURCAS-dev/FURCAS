package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.FilterSynthesisImpl;



public class IterateExpTracer extends AbstractTracer<IterateExp> {
	public IterateExpTracer(IterateExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
		return pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getBody(), context, filterSynthesizer);
	}

}
