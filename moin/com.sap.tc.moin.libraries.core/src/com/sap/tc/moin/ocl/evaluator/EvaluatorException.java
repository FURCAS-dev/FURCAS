package com.sap.tc.moin.ocl.evaluator;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception thrown to indicate that a semantic error has been detected.
 * <p>
 * This exception will be thrown as a result of a sanity check failing, most
 * likely as a result of a bug in the OCL Parser.
 */
public class EvaluatorException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message A description of the semantic error.
     */
    public EvaluatorException( MoinLocalizedString message ) {

        super( message );
    }

    /**
     * @param message A description of the semantic error.
     * @param parameter a single parameter for the message
     */
    public EvaluatorException( MoinLocalizedString message, String parameter ) {

        super( message, new Object[] { parameter } );
    }

    /**
     * @param message A description of the semantic error.
     * @param parameters a list of parameters for the message
     */
    public EvaluatorException( MoinLocalizedString message, String[] parameters ) {

        super( message, (Object[]) parameters );
    }

}
