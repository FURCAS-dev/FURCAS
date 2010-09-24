package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

public class TupleLiteralTracebackStep extends BranchingTracebackStep<TupleLiteralExp> {

    public TupleLiteralTracebackStep(TupleLiteralExp sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, TracebackStepCache tracebackStepCache) {
        super(sourceExpression, tupleLiteralNamesToLookFor, tracebackStepCache.getOppositeEndFinder());
        if (tupleLiteralNamesToLookFor != null && !tupleLiteralNamesToLookFor.isEmpty()) {
            String partName = tupleLiteralNamesToLookFor.peek();
            for (TupleLiteralPart<EClassifier, EStructuralFeature> part : sourceExpression.getPart()) {
                if (part.getName().equals(partName)) {
                    Stack<String> clonedTupleLiteralNamesToLookFor = cloneWithTypeCheck(tupleLiteralNamesToLookFor);
                    clonedTupleLiteralNamesToLookFor.pop();
                    getSteps().add(
                            createTracebackStepAndScopeChange(sourceExpression, (OCLExpression) part.getValue(), context,
                                    operationBodyToCallMapper, clonedTupleLiteralNamesToLookFor, tracebackStepCache));
                    break;
                }
            }
        }
        if (getSteps().isEmpty()) {
            throw new RuntimeException("Internal error regarding tuple literal and tuple access nesting: couldn't find requested part "+
                    tupleLiteralNamesToLookFor.peek()+" in tuple parts "+sourceExpression.getPart());
        }
    }
}
