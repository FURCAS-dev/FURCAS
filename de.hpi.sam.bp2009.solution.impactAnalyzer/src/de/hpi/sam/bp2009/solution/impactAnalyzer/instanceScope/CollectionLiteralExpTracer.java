package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        Set<NavigationStep> steps = new HashSet<NavigationStep>();
        for (Iterator<CollectionLiteralPart<EClassifier>> i = parts.iterator(); i.hasNext();) {
            CollectionLiteralPart<EClassifier> part = i.next();
            if (part instanceof CollectionItem) {
                steps.add(pathCache.getOrCreateNavigationPath((OCLExpression) ((CollectionItem) part)
                        .getItem(), context, filterSynthesizer, getTupleLiteralPartNamesToLookFor()));
            }
        }
        if (getExpression().getPart().size() > 0){
            EClass innermostType = getInnermostElementType(getExpression().getType());
            return new BranchingNavigationStep(innermostType, context, getExpression(), steps.toArray(new NavigationStep[0]));
        } else {
            //the collection was empty, like "Set{}"
            return new EmptyResultNavigationStep(getExpression());
        }
        
    }

}
