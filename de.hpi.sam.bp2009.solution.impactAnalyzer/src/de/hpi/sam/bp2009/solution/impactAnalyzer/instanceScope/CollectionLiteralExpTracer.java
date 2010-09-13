package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.CollectionLiteralPart;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

public class CollectionLiteralExpTracer extends AbstractTracer<CollectionLiteralExp> {
    public CollectionLiteralExpTracer(CollectionLiteralExp expression, String[] tuplePartNames) {
        super(expression, tuplePartNames);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
        EList<CollectionLiteralPart<EClassifier>> parts = (EList<CollectionLiteralPart<EClassifier>>) getExpression().getPart();
        List<NavigationStep> steps = new ArrayList<NavigationStep>();
        NavigationStep result;
        
        for (Iterator<CollectionLiteralPart<EClassifier>> i = parts.iterator(); i.hasNext();) {
            CollectionLiteralPart<EClassifier> part = i.next();
            if (part instanceof CollectionItem) {
                steps.add(pathCache.getOrCreateNavigationPath((OCLExpression) ((CollectionItem) part)
                        .getItem(), context, filterSynthesizer, getTupleLiteralPartNamesToLookFor()));
            }
        }
        if (getExpression().getPart().size() > 0){
            EClass innermostType = getInnermostElementType(getExpression().getType());
            result = pathCache.navigationStepForBranch(innermostType, context, getExpression(),
                    getTupleLiteralPartNamesToLookFor(), steps.toArray(new NavigationStep[0]));
        } else {
            //the collection was empty, like "Set{}"
            result = new EmptyResultNavigationStep(getExpression());
        }
        applyScopesOnNavigationStep(result);
        return result;
    }

}
