package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class IterateExpTracer extends AbstractTracer<IterateExp> {
    public IterateExpTracer(IterateExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = pathCache.getOrCreateNavigationPath((OCLExpression) getExpression().getBody(), context,
                operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor(), oclFactory);
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

    @Override
    protected Set<Variable> calculateEnteringScope(OperationBodyToCallMapper operationBodyToCallMapper) {
        // IterateExpressions are traced back by tracing back their body, which opens a new scope where result
        // variable and iterator variables are in scope
        Set<Variable> result = new HashSet<Variable>();
        for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> v : getExpression().getIterator()) {
            result.add((Variable) v);
        }
        result.add((Variable) getExpression().getResult());
        return result;
    }
}
