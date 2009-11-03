package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception is thrown when the formulated query requires unsupported
 * functionality.
 */
public class MQLNotSupportedException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 5538595882536186923L;

    /**
     * Instantiates a new MQL not supported exception.
     * 
     * @param message
     * @param args
     */
    public MQLNotSupportedException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }
}
