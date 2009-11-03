package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating both "collect" and "collectNested" iterator
 * expressions.
 */
public class CollectHandler implements ResultHandler {

    /** Internal collection of the evalResult at each step of the iteration */
    private final List<OclAny> results = new LinkedList<OclAny>( );

    /**
     * If true and the evalResult types are OclCollection, then the results are
     * flattened
     */
    private final boolean flatten;

    /**
     * Create a new CollectHandler. If <code>flatten</code> is <code>true</code>
     * , the handler acts as a "collect" handler. If it is <code>false</code>,
     * the handler acts as a "collectNested" handler.
     * 
     * @param theFlatten <code>true</code> for collect, <code>false</code> for
     * collectNested
     */
    public CollectHandler( boolean theFlatten ) {

        this.flatten = theFlatten;
    }

    /**
     * Add the <code>evalResult</code> to an internal collection, or, if the
     * evalResult is an {@link OclCollection} and this class was constructed
     * with the flatten argument set to <code>true</code>, then add the contents
     * of the collection to the internal collection. This method always returns
     * <code>true</code>.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        if ( this.flatten && evalResult instanceof OclCollection ) {
            Collection<OclAny> underlyingCollection = ( (OclCollection) evalResult ).getWrappedCollection( );
            this.results.addAll( underlyingCollection );
        } else {
            this.results.add( evalResult );
        }

        // Always continue processing
        return true;
    }

    /**
     * Return all the evalResult values that were added in the
     * {@link #processElementAndResult(EvaluationContext, OclAny)} method,
     * wrapped in the collection returned by the
     * {@link OclCollection#newCollectOclCollection(List)} method on the
     * supplied <code>sourceCollection</code>.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        return sourceCollection.newCollectOclCollection( this.results );
    }
}
