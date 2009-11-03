package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * This exception is thrown when accessing a wrapper fails because for some
 * reason the wrapped object cannot be resolved any more.
 */
public class UnresolvableException extends MoinLocalizedBaseRuntimeException {


    /**
     * @param message
     * @param args
     */
    public UnresolvableException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    private static final long serialVersionUID = 1L;
}