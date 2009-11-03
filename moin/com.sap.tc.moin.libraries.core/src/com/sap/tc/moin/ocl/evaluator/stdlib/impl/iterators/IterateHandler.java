package com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * ResultHandler for evaluating the generic "iterate" iterator expression.
 */
public class IterateHandler implements ResultHandler {

    /**
     * The name of the result accumulator variable, that is used to set the most
     * recent evaluation result in the EvaluationContext under
     */
    private final String accumulatorName;

    /**
     * The result, initialised in the constructor, updated in the
     * processElementAndResult() method, and returned by getResult()
     */
    private OclAny result;

    /**
     * @param theAccumulatorName The name of the result accumulator expression
     * @param initialAccumulatorValue The initial value of the result
     * accumulator
     */
    public IterateHandler( String theAccumulatorName, OclAny initialAccumulatorValue ) {

        this.accumulatorName = theAccumulatorName;
        this.result = initialAccumulatorValue;
    }

    /**
     * Update the result accumulator variable in the supplied <code>ctx</code>
     * and the internal result with the value of <code>evalResult</code>. This
     * method always returns <code>true</code>.
     */
    public boolean processElementAndResult( EvaluationContext ctx, OclAny evalResult ) {

        this.result = evalResult;
        ctx.setVariable( this.accumulatorName, evalResult );
        // Always continue processing
        return true;
    }

    /**
     * Returns the internal result set in
     * {@link #processElementAndResult(EvaluationContext, OclAny)}, or in the
     * case where that method was not called, returns the initial result
     * accumulator value that was set in the constructor.
     */
    public OclAny getResult( CoreConnection connection, OclCollection sourceCollection ) {

        return this.result;
    }

}
