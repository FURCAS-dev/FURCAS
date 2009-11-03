package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating an exists iterator expression.
 */
/*
 * Implementation Note: It may be possible to combine this handler with the
 * ForAllHandler, as the implementations are quite similar.
 */
public class ExistsHandler implements ResultHandler {

    /** The result set in processElementAndResult(), returned by getResult() */
    private OclBoolean result = OclBoolean.FALSE;

    /**
     * If this method has previously been called with <code>evalResult</code>
     * equal to {@link OclBoolean#TRUE}, this method returns <code>false</code>.
     * Otherwise, the internal result is set to the value of evalResult, and
     * this method returns the underlying boolean value of that result. Assumes
     * <code>evalResult</code> is of type {@link OclBoolean}.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        // If the result has already been set to TRUE, there is no need to 
        // continue iterating, so return false
        if ( OclBoolean.TRUE.equals( this.result ) ) {
            return false;
        }

        // Set the result to be the value of this evaluation. If it is
        // false, this method will return false, and the iteration should stop

        if ( !( evalResult instanceof OclBoolean ) ) {
            // undefined->continue
            return true;
        }

        this.result = (OclBoolean) evalResult;
        return !this.result.getWrappedBoolean( ).booleanValue( );
    }

    /**
     * If one of the evalResult values passed into the
     * {@link #processElementAndResult(EvaluationContext, OclAny)} method was
     * {@link OclBoolean#TRUE}, returns {@link OclBoolean#TRUE}, otherwise,
     * returns {@link OclBoolean#FALSE}.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        return this.result;
    }

}
