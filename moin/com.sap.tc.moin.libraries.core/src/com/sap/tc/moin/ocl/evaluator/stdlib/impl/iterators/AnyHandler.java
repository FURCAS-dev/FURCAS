package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating an "any" iterator expression.
 */
public class AnyHandler implements ResultHandler {

    /** The name to look up the current value from the EvaluationContext with */
    private final String iteratorName;

    /** The result set in processElementAndResult(), returned by getResult() */
    private OclAny result = OclVoidImpl.OCL_UNDEFINED;

    /**
     * @param theIteratorName The name of the iterator in the expression
     */
    public AnyHandler( String theIteratorName ) {

        this.iteratorName = theIteratorName;
    }

    /**
     * If the <code>evalResult<code> is equal to {@link OclBoolean#TRUE}, the 
     * internal result is set to the value of the current element in the 
     * supplied <code>ctx</code> (looked up by the expression's iterator name),
     * and this method returns <code>false</code>. Otherwise, this method
     * returns <code>true</code> if no result has been found previously,
     * <code>false</code> otherwise. Assumes <code>evalResult</code> is of type
     * {@link OclBoolean}.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        if ( !( evalResult instanceof OclBoolean ) ) {
            // undefined->continue
            return true;
        }
        OclBoolean booleanResult = (OclBoolean) evalResult;
        if ( booleanResult.getWrappedBoolean( ).booleanValue( ) ) {
            // Element found - set result
            this.result = ctx.getVariable( this.iteratorName );
            return false;
        }

        // If the internal result is still OCL undefined - return true to keep
        // iterating
        return OclVoidImpl.OCL_UNDEFINED.equals( this.result );
    }

    /**
     * Returns the internal result set in
     * {@link #processElementAndResult(EvaluationContext, OclAny)}, or
     * {@link OclVoidImpl#OCL_UNDEFINED} if that method was not called with the
     * evalResult equal to {@link OclBoolean#TRUE} (i.e., if no element was
     * found).
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        return this.result;
    }

}
