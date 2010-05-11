package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.FilterSynthesisImpl;

public class IfExpTracer extends AbstractTracer<IfExp> {
	public IfExpTracer(IfExp expression) {
		super(expression);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
		NavigationStep thenPath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getThenExpression(), context, filterSynthesizer);
		NavigationStep elsePath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getElseExpression(), context, filterSynthesizer);
		return new BranchingNavigationStep(getInnermostElementType(getExpression().getType()), context, getExpression(), thenPath, elsePath);
	}

}
