package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.FilterSynthesis;



public class LetExpTracer extends AbstractTracer<LetExp> {
	public LetExpTracer(LetExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesis filterSynthesizer) {
		return pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getIn(), context, filterSynthesizer);
	}

}
