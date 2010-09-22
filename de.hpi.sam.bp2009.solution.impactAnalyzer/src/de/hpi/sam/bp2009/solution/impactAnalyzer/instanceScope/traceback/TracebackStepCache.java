package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AbstractPathCache;

public class TracebackStepCache extends AbstractPathCache<TracebackStep> {

    public TracebackStepCache(OppositeEndFinder oppositeEndFinder) {
        super(oppositeEndFinder);
    }

    @Override
    protected TracebackStep createStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, String[] tupleLiteralNamesToLookFor) {
        // TODO Implement AbstractPathCache<TracebackStep>.createStep(...)
        return null;
    }

}
