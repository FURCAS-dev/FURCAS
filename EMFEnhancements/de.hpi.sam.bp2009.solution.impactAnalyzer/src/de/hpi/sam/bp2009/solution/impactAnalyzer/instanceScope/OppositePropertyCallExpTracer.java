package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;


public class OppositePropertyCallExpTracer extends  AbstractTracer<OppositePropertyCallExp> {

    protected OppositePropertyCallExpTracer(OppositePropertyCallExp expression, Stack<String> tuplePartNames) {
        super(expression, tuplePartNames);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        // reverse traversal of a reverted reference is traversing the original reference itself
        NavigationStep result = new AssociationNavigationStep(
                getInnermostElementType(getExpression().getType()),
                getInnermostElementType(getExpression().getSource().getType()),
                (EReference)getExpression().getReferredOppositeProperty(),
                getExpression());
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

}
