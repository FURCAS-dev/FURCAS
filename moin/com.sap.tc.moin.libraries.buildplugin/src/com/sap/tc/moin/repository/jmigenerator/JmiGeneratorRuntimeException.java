package com.sap.tc.moin.repository.jmigenerator;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * JMI Generator specific Exception
 */
public class JmiGeneratorRuntimeException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param rootCause
     * @param message
     * @param args
     */
    public JmiGeneratorRuntimeException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( rootCause, message, args );
    }

    /**
     * @param message
     * @param args
     */
    public JmiGeneratorRuntimeException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

}
