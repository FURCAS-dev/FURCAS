package com.sap.tc.moin.repository.xm;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.xm.parser.XmApiMessages;


/**
 * Exception which can be used for reporting errors during the parsing or
 * serializing.
 * <p>
 * This class is intended to be sub-classed by clients.
 */
public class XmCustomException extends XmException {

    private static final long serialVersionUID = -6346029142408526419L;

    /**
     * Constructor with non-localized error message.
     * 
     * @param message non-localized error message
     */
    public XmCustomException( final java.lang.String message ) {

        super( XmApiMessages.PROBLEMOCCURED, message );
    }

    /**
     * Constructor with localized error messages.
     * 
     * @param message localized error message
     * @param args arguments of the localized error message
     */
    public XmCustomException( final MoinLocalizedString message, final Object... args ) {

        super( message, args );
    }

    /**
     * Constructor with non-localized error message and root cause exception.
     * 
     * @param cause root cause exception
     * @param message non-localized error message
     */
    public XmCustomException( final Throwable cause, final String message ) {

        super( XmApiMessages.PROBLEMOCCURED, message );
    }

    /**
     * Constructor for localized error message with root cause exception.
     * 
     * @param cause root cause exception
     * @param message localized error message
     * @param args arguments of the localized error message, can be
     * <tt>null</tt>
     */
    public XmCustomException( final Throwable cause, final MoinLocalizedString message, final java.lang.Object... args ) {

        super( cause, message, args );
    }
}