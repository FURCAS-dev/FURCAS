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
    public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
        NavigationStep result = null;
        if (isLookingForTuplePart()) {
            String partName = getTuplePartNameLookedFor();
            for (TupleLiteralPart<EClassifier, EStructuralFeature> part : getExpression().getPart()) {
                if (part.getName().equals(partName)) {
                    result = pathCache.getOrCreateNavigationPath((OCLExpression) part.getValue(), context, filterSynthesizer,
                                getListOfTuplePartNamesWithFoundRemoved());
                    break;
                }
            }
        }
        if (result == null) {
            result = super.traceback(context, pathCache, filterSynthesizer); // create an empty step
        }
        applyScopesOnNavigationStep(result);
        return result;
    }
}
