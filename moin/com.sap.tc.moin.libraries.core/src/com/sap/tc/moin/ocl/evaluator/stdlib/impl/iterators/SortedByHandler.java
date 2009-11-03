package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating a sortedBy iterator expression.
 */
/*
 * NOTE: The algorithm for this class be improved in terms of performance. It
 * currently collects each element/result pair in the processElementAndResult()
 * method, then sorts the collection of element/result pairs, before iterating
 * over the sorted pairs once more to extract the elements in sorted order. It
 * is conceivable that the elements could be inserted into the resulting set, in
 * sorted order, during the processElementAndResult() method. However, at this
 * point in time, the complexity of doing that is not considered to be worth the
 * potential performance tradeoff.
 */
public class SortedByHandler implements ResultHandler {

    /** The name to look up the current value from the EvaluationContext with */
    private final String iteratorName;

    /** The list of {@link ElementResultPair}s added at each iteration step */
    private List<ElementResultPair> elementResultPairs = new LinkedList<ElementResultPair>( );

    /**
     * @param theIteratorName The name of the iterator in the expression
     */
    public SortedByHandler( String theIteratorName ) {

        this.iteratorName = theIteratorName;
    }

    /**
     * Adds the current element to an internal collection. The
     * <code>evalResult</code> is later used to sort the elements. The element
     * is looked up in the supplied <code>ctx</code> and is assumed to be
     * keyed by the expression's iterator name. This method always returns
     * <code>true</code>.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        OclAny element = ctx.getVariable( this.iteratorName );
        this.elementResultPairs.add( new ElementResultPair( element, evalResult ) );
        // Always continue processing
        return true;
    }

    /**
     * Returns the collection of elements added in the
     * {@link #processElementAndResult(EvaluationContext, OclAny)} method,
     * sorted by the evalResult that was passed into that method. The collection
     * is wrapped in the collection returned by the
     * {@link OclCollection#newSortedByOclCollection(List)} method on the
     * supplied <code>sourceCollection</code>.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        // Sort the element/result pairs using the "<" operation on the result.
        Collections.sort( this.elementResultPairs, new OclAnyLessThanComparator( connection ) );

        // Copy the elements, in order, from the list of element/result pairs
        // to the list of results
        List<OclAny> results = new ArrayList<OclAny>( this.elementResultPairs.size( ) );
        for ( Iterator<ElementResultPair> it = this.elementResultPairs.iterator( ); it.hasNext( ); ) {
            ElementResultPair pair = it.next( );
            results.add( pair.element );
        }
        return sourceCollection.newSortedByOclCollection( results );
    }

    /**
     * Value object that contains an element and the result of evaluating the
     * body expression in an iterator with that element set in the context.
     */
    static class ElementResultPair {

        final OclAny element;

        final OclAny result;

        ElementResultPair( OclAny theElement, OclAny theResult ) {

            this.element = theElement;
            this.result = theResult;
        }
    }

    /**
     * Comparator that compares two OclAny values using the result of the "&lt;"
     * operation.
     */
    static class OclAnyLessThanComparator implements Comparator<ElementResultPair> {

        // Create the array once so it doesn't need to be created each time
        // compare() is called
        private static final OclAny[] arg = new OclAny[1];

        private final CoreConnection myConnection;

        /**
         * @param connection the core connection
         */
        public OclAnyLessThanComparator( CoreConnection connection ) {

            this.myConnection = connection;
        }

        public int compare( ElementResultPair o1, ElementResultPair o2 ) {

            OclAny result = o1.result;
            arg[0] = o2.result;
            OclBoolean lessThan;
            try {
                lessThan = (OclBoolean) result.callOperation( this.myConnection, OclConstants.OP_LTSTDLIB, arg );
            } catch ( OperationNotFoundException e ) {
                throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_009 );
            }
            return lessThan.getWrappedBoolean( ).booleanValue( ) ? -1 : 1;
        }
    }
}
