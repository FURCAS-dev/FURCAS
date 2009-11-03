package com.sap.tc.moin.ocl.evaluator;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclInvalidImpl;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Evaluates OCL Constraints for model instances.
 */
public class OclConstraintEvaluator {

    /**
     * Evaluate the supplied <code>constraint</code> on the supplied
     * <code>context</code> object
     * 
     * @param connection the core connection
     * @param expr The constraint to evaluate.
     * @param context The context used in evaluating the <code>constraint</code>
     * @return <code>true</code> if the <code>refObj</code> is valid according
     * to the supplied <code>constraint</code>, <code>false</code> otherwise.
     * @throws ExpressionUndefinedException Thrown if the expression in the
     * supplied <code>constraint</code> evaluates to
     * {@link OclVoidImpl#OCL_UNDEFINED}
     * @throws EvaluatorException Thrown if a semantic error is encountered
     * during the evaluation of the supplied <code>constraint</code>, including
     * if it evaluates to a non-{@link OclBoolean} value.
     */
    public boolean evaluate( CoreConnection connection, OclExpression expr, RefObject context ) throws ExpressionUndefinedException {

        OclAny ctx = OclFactory.instance( ).create( context );
        EvaluationContext evalCtx = new EvaluationContextImpl( ctx );
        try {
            ExpressionEvaluator exprEvaluator = ExpressionEvaluator.instance( );
            OclAny value = exprEvaluator.evaluate( connection, expr, evalCtx );
            if ( OclVoidImpl.OCL_UNDEFINED.equals( value ) || OclInvalidImpl.OCL_INVALID.equals( value ) ) {
                throw new ExpressionUndefinedException( OclServiceExceptions.EXPEVALUATESTOUNDEFINED );
            }
            if ( !( value instanceof OclBoolean ) ) {
                throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_001, value.toString( ) );
            }
            return ( (OclBoolean) value ).getWrappedBoolean( ).booleanValue( );
        } finally {
            // Reset the current context so that the current thread can create
            // a new one later if required.
            EvaluationContext.CurrentContext.reset( );
        }
    }

}
