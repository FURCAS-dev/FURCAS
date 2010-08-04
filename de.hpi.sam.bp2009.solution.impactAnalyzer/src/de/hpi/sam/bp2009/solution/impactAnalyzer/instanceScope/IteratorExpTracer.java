package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

public class IteratorExpTracer extends AbstractTracer<IteratorExp> {
    public IteratorExpTracer(IteratorExp expression, String[] tuplePartNames) {
        super(expression, tuplePartNames);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
        NavigationStep result;
        String name = getExpression().getName();
        int opCode = OCLStandardLibraryUtil.getOperationCode(name);
        if (opCode == PredefinedType.SELECT || opCode == PredefinedType.REJECT || opCode == PredefinedType.SORTED_BY
                || opCode == PredefinedType.ANY) {
            result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getSource(), context, filterSynthesizer,
                    getTupleLiteralPartNamesToLookFor());
            if (opCode == PredefinedType.SELECT || opCode == PredefinedType.REJECT || opCode == PredefinedType.ANY) {
                // evaluate predicate before checking how it goes on
                Variable<EClassifier, EParameter> varDecl = getExpression().getIterator().get(0);
                EClass iteratorType = getInnermostElementType(varDecl.getType());
                result = pathCache.navigationStepFromSequence(getExpression(), getTupleLiteralPartNamesToLookFor(),
                        new PredicateCheckNavigationStep(getInnermostElementType(getExpression().getType()), iteratorType,
                                getExpression(), pathCache), result);
            }
        } else if (opCode == PredefinedType.COLLECT || opCode == PredefinedType.COLLECT_NESTED) {
            result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getBody(), context, filterSynthesizer,
                    getTupleLiteralPartNamesToLookFor());
        } else {
            // boolean or other non-class-type-result iterator
            result = new EmptyResultNavigationStep(getExpression());
        }
        return result;
    }
}
