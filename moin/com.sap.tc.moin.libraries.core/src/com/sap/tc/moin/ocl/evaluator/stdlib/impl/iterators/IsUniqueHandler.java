package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating a collect iterator expression.
 */
public class IsUniqueHandler implements ResultHandler {

    /** The result set in processElementAndResult(), returned by getResult() */
    private OclBoolean result = OclBoolean.TRUE;

    /** Set to keep track of the evalResults from processElementAndResult() */
    private final Set<OclAny> evalResults = new HashSet<OclAny>( );

    /**
     * If this method has previously been called with a non-unique
     * <code>evalResult</code>, this method returns <code>false</code>.
     * Otherwise, the <code>evalResult</code> is checked against the previous
     * results - if it is unique, this method returns <code>true</code>,
     * otherwise <code>false</code> is returned.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        // If the result has already been set to FALSE, there is no need to 
        // continue iterating, so return false
        if ( OclBoolean.FALSE.equals( this.result ) ) {
            return false;
        }

        boolean evalResultIsUnique = this.evalResults.add( evalResult );
        this.result = evalResultIsUnique ? OclBoolean.TRUE : OclBoolean.FALSE;
        // This will return false if the result is not unique
        return evalResultIsUnique;
    }

    /**
     * If all of the evalResult values passed into the
     * {@link #processElementAndResult(EvaluationContext, OclAny)} method were
     * unique, returns {@link OclBoolean#FALSE}, otherwise, returns
     * {@link OclBoolean#TRUE}.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        return this.result;
    }

}
