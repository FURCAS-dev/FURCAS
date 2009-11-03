package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating an "one" iterator expression.
 */
public class OneHandler implements ResultHandler {

    /** Keeps track of the number of times the body has evaluated to TRUE */
    private int noOfMatches = 0;

    /**
     * If the <code>evalResult<code> is equal to {@link OclBoolean#TRUE}, an
     * internal counter is incremented. Returns <code>true</code> if zero or one
     * TRUE values ave been received, <code>false</code> if more than one TRUE
     * value has been received. Assumes <code>evalResult</code> is of type
     * {@link OclBoolean}.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        if ( !( evalResult instanceof OclBoolean ) ) {
            // undefined->continue
            return true;
        }

        OclBoolean booleanResult = (OclBoolean) evalResult;
        if ( booleanResult.getWrappedBoolean( ).booleanValue( ) ) {
            // If the result is true, we have found a match
            this.noOfMatches++;
        }

        // Return false if we have already found more than one match
        return this.noOfMatches <= 1;
    }

    /**
     * Returns {@link OclBoolean#TRUE} if exactly one TRUE evalResult was
     * received in {@link #processElementAndResult(EvaluationContext, OclAny)},
     * {@link OclBoolean#FALSE} otherwise.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        return this.noOfMatches == 1 ? OclBoolean.TRUE : OclBoolean.FALSE;
    }

}
