package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Abstract base class for all exceptions that are thrown in case of accessing a
 * MOIN object that is no longer valid.
 */
public abstract class MoinInvalidObjectException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param args
     */
    public MoinInvalidObjectException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }


}