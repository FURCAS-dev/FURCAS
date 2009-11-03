package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * This exception is thrown when a result set is not handled properly. For
 * Example, if an attempt is made to fetch a row beyond the size of the result
 * set.
 */
public class MQLResultException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -2934371245271900771L;

    /**
     * @param message
     * @param args
     */
    public MQLResultException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * @param rootCause
     * @param message
     * @param args
     */
    public MQLResultException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( rootCause, message, args );
    }

}
