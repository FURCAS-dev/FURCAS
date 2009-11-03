package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Base exception for locking related issues. Every exception which is related
 * to locking should extend this class.
 */
public class LockingException extends MoinLocalizedBaseRuntimeException {


    private static final long serialVersionUID = 1L;


    /**
     * @param message message key
     * @param args
     */
    public LockingException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

}
