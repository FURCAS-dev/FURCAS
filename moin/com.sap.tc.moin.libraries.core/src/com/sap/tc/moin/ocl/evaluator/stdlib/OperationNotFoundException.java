package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * This Exception is used to indicate that the evaluation framework attempted to
 * evaluate an operation that does not exist on the source that was evaluated
 * for the operation. In theory, this scenario should be picked up in the
 * Semantic Analysis phase of the parser, therefore, this exception would
 * indicate a logical or programming error in either the parser or evaluator.
 */
public class OperationNotFoundException extends EvaluatorException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for messages with one parameter
     * 
     * @param message message
     * @param parameter parameters
     */
    public OperationNotFoundException( MoinLocalizedString message, String parameter ) {

        super( message, parameter );
    }

    /**
     * Constructor for messages with more than one parameter
     * 
     * @param message message
     * @param parameters parameters
     */
    public OperationNotFoundException( MoinLocalizedString message, String[] parameters ) {

        super( message, parameters );
    }


}
