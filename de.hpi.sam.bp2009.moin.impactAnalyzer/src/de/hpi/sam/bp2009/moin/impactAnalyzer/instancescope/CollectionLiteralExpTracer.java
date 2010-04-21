package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralPart;


import de.hpi.sam.bp2009.moin.impactAnalyzer.ClassScopeAnalyzer;


public class CollectionLiteralExpTracer extends AbstractTracer<CollectionLiteralExp> {
    public CollectionLiteralExpTracer(CollectionLiteralExp expression) {
        super(expression);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
        EList<CollectionLiteralPart<EClassifier>> parts = (EList<CollectionLiteralPart<EClassifier>>) getExpression().getPart();
        Set<NavigationStep> steps = new HashSet<NavigationStep>();
        for (Iterator<CollectionLiteralPart<EClassifier>> i = parts.iterator(); i.hasNext();) {
            CollectionLiteralPart<EClassifier> part = i.next();
            if (part instanceof CollectionItem) {
                steps.add(pathCache.getOrCreateNavigationPath(((CollectionItem) part)
                        .getItem(), context, classScopeAnalyzer));
            }
        }
        EClass innermostType = getInnermostElementType(getExpression().getType());
        return new BranchingNavigationStep(innermostType, innermostType, getExpression(), steps.toArray(new NavigationStep[0]));
    }

}
