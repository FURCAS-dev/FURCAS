package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown in case of improper Session access e.g. trying to work on an already
 * closed Session.
 */
public final class InvalidSessionException extends MoinInvalidObjectException {

    private static final long serialVersionUID = 1L;


    /**
     * @param message
     * @param args
     */
    public InvalidSessionException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

}