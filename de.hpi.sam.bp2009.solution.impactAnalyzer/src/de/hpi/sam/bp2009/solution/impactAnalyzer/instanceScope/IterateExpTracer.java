package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class IterateExpTracer extends AbstractTracer<IterateExp> {
    public IterateExpTracer(IterateExp expression, String[] tuplePartNames) {
        super(expression, tuplePartNames);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getBody(), context,
                operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor());
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

    @Override
    protected Set<OCLExpression> calculateEnteringScope() {
        // IterateExpressions are traced back by tracing back their body, which opens a new scope
        return Collections.singleton((OCLExpression) getExpression().getBody());
    }
}
