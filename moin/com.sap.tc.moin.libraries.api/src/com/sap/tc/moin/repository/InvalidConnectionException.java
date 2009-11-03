package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown in case of improper Connection handling e.g. trying to work on an
 * already closed Connection.
 */
public final class InvalidConnectionException extends MoinInvalidObjectException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param args
     */
    public InvalidConnectionException( MoinLocalizedString message, Object... args ) {

        super( message, args );

    }

}