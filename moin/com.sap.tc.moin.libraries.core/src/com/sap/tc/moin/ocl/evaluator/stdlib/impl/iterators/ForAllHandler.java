package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating a collect iterator expression.
 */
public class ForAllHandler implements ResultHandler {

    /** The result set in processElementAndResult(), returned by getResult() */
    private OclBoolean result = OclBoolean.TRUE;

    /**
     * If this method has previously been called with <code>evalResult</code>
     * equal to {@link OclBoolean#FALSE}, this method returns <code>false</code>
     * . Otherwise, the internal result is set to the value of evalResult, and
     * this method returns the underlying boolean value of that result. Assumes
     * <code>evalResult</code> is of type {@link OclBoolean}.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        // If the result has already been set to FALSE, there is no need to 
        // continue iterating, so return false
        if ( OclBoolean.FALSE.equals( this.result ) ) {
            return false;
        }

        if ( !( evalResult instanceof OclBoolean ) ) {
            return false;
        }

        // Set the result to be the value of this evaluation. If it is
        // false, this method will return false, and the iteration should stop
        this.result = (OclBoolean) evalResult;
        return this.result.getWrappedBoolean( ).booleanValue( );
    }

    /**
     * If any of the evalResult values passed into the
     * {@link #processElementAndResult(EvaluationContext, OclAny)} method were
     * {@link OclBoolean#FALSE}, returns {@link OclBoolean#FALSE}, otherwise,
     * returns {@link OclBoolean#TRUE}.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        return this.result;
    }

}
