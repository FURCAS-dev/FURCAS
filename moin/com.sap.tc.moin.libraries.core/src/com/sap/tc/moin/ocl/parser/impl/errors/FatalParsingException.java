package com.sap.tc.moin.ocl.parser.impl.errors;

import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * Indicates a fatal problem during parse
 */
public class FatalParsingException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    private final ProcessError error;

    /**
     * @param message the message
     * @param actError the error
     */
    public FatalParsingException( MoinLocalizedBaseException message, ProcessError actError ) {

        super( message );
        this.error = actError;
    }

    /**
     * @return the offending parsing error
     */
    public ProcessError getParsingError( ) {

        return this.error;
    }
}
