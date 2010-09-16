package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class LetExpTracer extends AbstractTracer<LetExp> {
    public LetExpTracer(LetExp expression, String[] tuplePartNames) {
        super(expression, tuplePartNames);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getIn(), context,
                operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor());
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

    @Override
    protected Set<Variable> calculateEnteringScope(OperationBodyToCallMapper operationBodyToCallMapper) {
        // tracing back a LetExp always leads to a traceback of the in expression, which opens a new scope
        return Collections.singleton((Variable) getExpression().getVariable());
    }
}
