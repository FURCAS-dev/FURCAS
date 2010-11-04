package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.traceback;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.instancescope.InstanceScopeAnalysisWithHiddenOpposites;
import de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.unusedEvaluation.UnusedEvaluationRequestWithHiddenOppositesFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackStepCache;

public class TracebackStepCacheWithHiddenOpposites extends TracebackStepCache {
    public TracebackStepCacheWithHiddenOpposites(OppositeEndFinder oppositeEndFinder, InstanceScopeAnalysisWithHiddenOpposites instanceScopeAnalysis) {
        super(oppositeEndFinder, new UnusedEvaluationRequestWithHiddenOppositesFactory(), instanceScopeAnalysis);
    }

    @Override
    protected TracebackStep createStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, OCLFactory oclFactory) {
        TracebackStep result;
        switch (sourceExpression.eClass().getClassifierID()) {
        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP:
            result = new OppositePropertyCallTracebackStep((OppositePropertyCallExp) sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, this, getUnusedEvaluationRequestFactory(), oclFactory);
            break;
        default:
            result = super.createStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, oclFactory);
        }
        return result;
    }
}
