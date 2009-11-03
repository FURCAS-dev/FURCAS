package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.ocl.evaluator.EvaluatorException;

/**
 * Wrapper class that holds a reference to an underlying map of name/value 
 * pairs, and defines the supported methods. 
 */
public interface OclTuple extends OclAny {

    /**
     * Return the value for the tuple part with the supplied <code>name</code>.
     * 
     * @param name the name of the tuple part
     * @return the value for that tuple part
     * 
     * @throws EvaluatorException Thrown if there is no tuple part for the
     *         supplied <code>name</code>.
     */
    public OclAny getValue( String name ) throws EvaluatorException;
}
