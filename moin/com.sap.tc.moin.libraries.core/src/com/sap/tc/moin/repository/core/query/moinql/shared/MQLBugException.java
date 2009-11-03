package com.sap.tc.moin.repository.core.query.moinql.shared;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 */
final public class MQLBugException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -5627045929224860616L;

    /**
     * @param message
     */
    public MQLBugException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * @param message
     */
    public MQLBugException( Throwable cause, MoinLocalizedString message, Object... args ) {

        super( cause, message, args );

    }

}
