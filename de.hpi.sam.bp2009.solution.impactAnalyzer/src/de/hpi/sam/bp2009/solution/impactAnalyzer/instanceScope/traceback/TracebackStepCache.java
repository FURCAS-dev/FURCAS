package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.EcorePackage;
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
        TracebackStep result;
        switch (sourceExpression.eClass().getClassifierID()) {
        case EcorePackage.COLLECTION_LITERAL_EXP:
            result = new CollectionLiteralTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.IF_EXP:
            result = new IfTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.ITERATE_EXP:
            result = new IterateTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.ITERATOR_EXP:
            result = new IteratorTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.LET_EXP:
            result = new LetTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.OPERATION_CALL_EXP:
            result = new OperationCallTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.PROPERTY_CALL_EXP:
            result = new PropertyCallTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.TUPLE_LITERAL_EXP:
            result = new TupleLiteralTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.VARIABLE_EXP:
            result = new VariableTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        case EcorePackage.INTEGER_LITERAL_EXP:
        case EcorePackage.UNLIMITED_NATURAL_LITERAL_EXP:
        case EcorePackage.STRING_LITERAL_EXP:
        case EcorePackage.REAL_LITERAL_EXP:
        case EcorePackage.ENUM_LITERAL_EXP:
        case EcorePackage.BOOLEAN_LITERAL_EXP:
        case EcorePackage.NULL_LITERAL_EXP:
        case EcorePackage.INVALID_LITERAL_EXP:
            result = new EmptyTracebackStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor);
            break;
        default:
            throw new RuntimeException("Unknown OCL expression type "+sourceExpression.eClass().getName()+" of expression "+
                    sourceExpression);
        }
        return result;
    }

}
