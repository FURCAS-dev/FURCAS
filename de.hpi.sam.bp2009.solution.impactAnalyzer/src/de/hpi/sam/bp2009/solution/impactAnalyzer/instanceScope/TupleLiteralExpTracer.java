package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.TupleLiteralExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

public class TupleLiteralExpTracer extends AbstractTracer<TupleLiteralExp> {
	public TupleLiteralExpTracer(TupleLiteralExp expression) {
		super(expression);
	}
	
	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer){
	    //TODO: implement this
	    return super.traceback(context, pathCache, filterSynthesizer);
	}
}
