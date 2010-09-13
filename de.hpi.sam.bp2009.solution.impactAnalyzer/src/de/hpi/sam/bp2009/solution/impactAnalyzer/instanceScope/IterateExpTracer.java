package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;



public class IterateExpTracer extends AbstractTracer<IterateExp> {
	public IterateExpTracer(IterateExp expression, String[] tuplePartNames) {
		super(expression, tuplePartNames);
	}

	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
		NavigationStep result = pathCache.getOrCreateNavigationPath((OCLExpression)getExpression().getBody(), context, filterSynthesizer, getTupleLiteralPartNamesToLookFor());
		applyScopesOnNavigationStep(result);
		return result;
	}

	@Override
	protected OCLExpression calculateEnteringScope(){
	    // IterateExpressions are traced back by tracing back their body, which opens a new scope
	    return (OCLExpression)getExpression().getBody();
	}
}
