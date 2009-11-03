package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown in case of improper model partition access e.g. trying to work on an
 * already deleted model partition.
 */
public final class InvalidModelPartitionException extends MoinInvalidObjectException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param args
     */
    public InvalidModelPartitionException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

}