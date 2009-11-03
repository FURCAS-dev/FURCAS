package com.sap.tc.moin.repository.core.query.moinql.shared;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 *
 */
public class MQLUsageException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;


    /**
     * @param cause
     * @param message
     * @param args
     */
    public MQLUsageException( Throwable cause, MoinLocalizedString message, Object... args ) {

        super( cause, message, args );
    }

    /**
     * @param message
     * @param args
     */
    public MQLUsageException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }
}
