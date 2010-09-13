package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

public class IfExpTracer extends AbstractTracer<IfExp> {
	public IfExpTracer(IfExp expression, String[] tuplePartNames) {
		super(expression, tuplePartNames);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
		NavigationStep thenPath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getThenExpression(), context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
		NavigationStep elsePath = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getElseExpression(), context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
		NavigationStep result = pathCache.navigationStepForBranch(getInnermostElementType(getExpression().getType()), context, getExpression(),
		        getTupleLiteralPartNamesToLookFor(), thenPath, elsePath);
		applyScopesOnNavigationStep(result);
		return result;
	}

}
