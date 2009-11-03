package com.sap.tc.moin.ocl.evaluator;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception thrown when the evaluation of an
 * {@link org.omg.ocl.attaching.OclConstraint} results in an
 * {@link com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl#OCL_UNDEFINED
 * undefined} result.
 */
public class ExpressionUndefinedException extends MoinLocalizedBaseException {

    /**
     * Default constructor
     * 
     * @param message the message
     */
    public ExpressionUndefinedException( MoinLocalizedString message ) {

        super( message );
    }

    private static final long serialVersionUID = 1L;
}
