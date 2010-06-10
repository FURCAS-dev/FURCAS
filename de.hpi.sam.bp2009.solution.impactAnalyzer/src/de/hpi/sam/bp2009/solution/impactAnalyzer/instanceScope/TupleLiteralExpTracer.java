package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

public class TupleLiteralExpTracer extends AbstractTracer<TupleLiteralExp> {
	public TupleLiteralExpTracer(TupleLiteralExp expression, String[] tuplePartNames) {
		super(expression, tuplePartNames);
	}
	
	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer){
	    if (!isLookingForTuplePart()) {
	        throw new RuntimeException("TupleLiteralExpTracer must be looking for a tuple literal part");
	    }
	    String partName = getTuplePartNameLookedFor();
	    for (TupleLiteralPart<EClassifier, EStructuralFeature> part : getExpression().getPart()) {
	        if (part.getName().equals(partName)) {
                return pathCache.getOrCreateNavigationPath((OCLExpression) part.getValue(), context, filterSynthesizer,
                        getListOfTuplePartNamesWithFoundRemoved());
            }
	    }
	    throw new RuntimeException("Part name "+partName+" not found in tuple literal "+getExpression());
	}
}
