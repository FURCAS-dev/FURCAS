package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;



public class LetExpTracer extends AbstractTracer<LetExp> {
	public LetExpTracer(LetExp expression, String[] tuplePartNames) {
		super(expression, tuplePartNames);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
		NavigationStep result = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getIn(), context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
		applyScopesOnNavigationStep(result);
		return result;
	}
	
	@Override
	protected OCLExpression calculateEnteringScope() {
	    // tracing back a LetExp always leads to a traceback of the in expression, which opens a new scope
	    return (OCLExpression) getExpression().getIn();
	}
}
