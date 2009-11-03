package com.sap.tc.moin.xm.generation;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception thrown by the XM Generator.
 */
public final class XmGeneratorException extends MoinLocalizedBaseException {

    private static final long serialVersionUID = 1170529809074720358L;


    /**
     * Constructor with localized error message.
     * 
     * @param message localized error message
     * @param args argument of the message
     */
    public XmGeneratorException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * Constructor with localized error message and root cause exception.
     * 
     * @param cause root cause exception
     * @param message localized error message
     * @param args argument of the message
     */
    public XmGeneratorException( Throwable cause, MoinLocalizedString message, Object... args ) {

        super( cause, message, args );
    }
}
