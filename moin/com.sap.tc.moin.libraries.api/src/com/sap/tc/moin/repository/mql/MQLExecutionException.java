package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * This exception may occur during query execution, for instance, when the
 * requested data is larger than the provided threshold. It also wraps
 * exceptions from the facility-dependent query implementation. This exception
 * should not occur under normal operation.
 */
public class MQLExecutionException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -1196470979072864388L;

    /**
     * @param rootCause
     * @param message
     * @param args
     */
    public MQLExecutionException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( rootCause, message, args );
    }

    /**
     * Instantiates a new mQL execution exception.
     * 
     * @param message the message
     * @param args
     */
    public MQLExecutionException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }
}
