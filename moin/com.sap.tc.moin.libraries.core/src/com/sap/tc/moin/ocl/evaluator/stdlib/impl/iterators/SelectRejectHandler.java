package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating both select and reject iterator expressions.
 */
public class SelectRejectHandler implements ResultHandler {

    /** The name to look up the current value from the EvaluationContext with */
    private final String iteratorName;

    /** The value that the evalResult should be for accumulating elements */
    private final OclBoolean valueToAccumulateOn;

    /** Internal collection of accumulated elements at each iteration step */
    private final List<OclAny> accumulatedElements = new LinkedList<OclAny>( );

    /**
     * Create a new SelectRejectHandler. If <code>valueToAccumulateOn</code> is
     * {@link OclBoolean#TRUE}, the handler acts as a "select" handler. If it is
     * {@link OclBoolean#FALSE}, the handler acts as a "reject" handler.
     * 
     * @param theIteratorName The name of the iterator in the expression
     * @param theValueToAccumulateOn TRUE for select, FALSE for reject.
     */
    public SelectRejectHandler( String theIteratorName, OclBoolean theValueToAccumulateOn ) {

        this.iteratorName = theIteratorName;
        this.valueToAccumulateOn = theValueToAccumulateOn;
    }

    /**
     * If <code>evalResult</code> is equal to the <code>OclBoolean</code> value
     * that was passed in through the constructor, the current element in the
     * iteration is added to the internal collection of results. The element is
     * looked up in the supplied <code>ctx</code> and is assumed to be keyed by
     * the expression's iterator name. Assumes <code>evalResult</code> is of
     * type {@link OclBoolean}. This method always returns <code>true</code>.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        if ( !( evalResult instanceof OclBoolean ) ) {
            // undefined->we can't select or reject
            return true;
        }

        OclBoolean booleanResult = (OclBoolean) evalResult;
        if ( this.valueToAccumulateOn.equals( booleanResult ) ) {
            this.accumulatedElements.add( ctx.getVariable( this.iteratorName ) );
        }

        // Always continue processing
        return true;
    }

    /**
     * Return the collection of elements that were added in the
     * {@link #processElementAndResult(EvaluationContext, OclAny)} method,
     * wrapped in the collection returned by the
     * {@link OclCollection#newOclCollection(Collection)} method on the supplied
     * <code>sourceCollection</code>.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        Collection<OclAny> results = sourceCollection.newUnderlyingCollection( );
        results.addAll( this.accumulatedElements );
        return sourceCollection.newOclCollection( results );
    }

}
