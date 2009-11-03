package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * A ResultHandler is similar to a Strategy. The OclIterator objects handles the
 * actual iteration of the collection, setting of the context variables, and
 * evaluating the expression, but the processing of the evaluation results and
 * returning the final result is delegated to an instance of this type. This is
 * the part of the iterator expressions that is different for the different
 * iterator operations.
 */
public interface ResultHandler {

    /**
     * Method called at each step of the iteration, after evaluating the body
     * expression to the supplied <code>evalResult</code>. Note:
     * <code>evalResult</code> is guaranteed not to be
     * {@link com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl#OCL_UNDEFINED}
     * .
     * 
     * @param ctx the evaluation context
     * @param evalResult the result
     * @return <code>false</code> if iteration should stop after this method
     * returns, <code>true</code> if it should continue.
     */
    boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult );

    /**
     * Method called after iterating over the entire collection, or when
     * {@link #processElementAndResult} method returns <code>false</code>.
     * 
     * @param connection the core connection
     * @param sourceCollection the source collection
     * @return the result
     */
    OclAny getResult( CoreConnection connection, OclCollection sourceCollection );
}
