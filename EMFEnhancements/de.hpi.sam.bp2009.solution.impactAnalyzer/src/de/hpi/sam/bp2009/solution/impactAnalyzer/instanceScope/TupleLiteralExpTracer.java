package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class TupleLiteralExpTracer extends AbstractTracer<TupleLiteralExp> {
    public TupleLiteralExpTracer(TupleLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = null;
        if (isLookingForTuplePart()) {
            String partName = getTuplePartNameLookedFor();
            for (TupleLiteralPart<EClassifier, EStructuralFeature> part : getExpression().getPart()) {
                if (part.getName().equals(partName)) {
                    result = pathCache.getOrCreateNavigationPath((OCLExpression) part.getValue(), context, operationBodyToCallMapper,
                                getListOfTuplePartNamesWithFoundRemoved(), oclFactory);
                    break;
                }
            }
        }
        if (result == null) {
            result = super.traceback(context, pathCache, operationBodyToCallMapper); // create an empty step
        }
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }
}
