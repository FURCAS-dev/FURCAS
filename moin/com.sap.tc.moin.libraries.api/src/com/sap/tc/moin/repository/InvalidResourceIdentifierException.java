package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown if ResourceIdentifiers (MRI, LRI, ORI) are syntactically invalid.
 */
public class InvalidResourceIdentifierException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param args
     */
    public InvalidResourceIdentifierException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * @param localizedRootCause the root cause, see
     * {@link Throwable#initCause(Throwable)}
     */
    public InvalidResourceIdentifierException( MoinLocalizedBaseRuntimeException localizedRootCause ) {

        super( localizedRootCause );
    }

}
