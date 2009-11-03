package com.sap.tc.moin.repository.xm;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.xm.parser.ParserErrorHandler;
import com.sap.tc.moin.repository.xm.parser.XmApiMessages;


/**
 * Exception thrown by {@link ParserErrorHandler}.
 * <p>
 * This class can be sub-classed by clients.
 */
public class XmInvalidXmlException extends XmException {

    private static final long serialVersionUID = -6346029142408526419L;

    /**
     * Constructor with localized error message and root cause exception.
     * 
     * @param message localized error message
     */
    public XmInvalidXmlException( final MoinLocalizedString message, final Object... args ) {

        super( message, args );
    }

    /**
     * Constructor with localized error message and root cause exception.
     * 
     * @param cause root cause exception
     * @param message localized error message
     */
    public XmInvalidXmlException( final Throwable cause, final MoinLocalizedString message, final Object... args ) {

        super( cause, message, args );
    }

    /**
     * Constructor with non-localized error message.
     * 
     * @param message non-localized error message
     */
    public XmInvalidXmlException( final java.lang.String message ) {

        super( XmApiMessages.PROBLEMOCCURED, message );
    }

    /**
     * Constructor with non-localized error message and root cause exception.
     * 
     * @param cause root cause exception
     * @param message non-localized error message
     */
    public XmInvalidXmlException( final Throwable cause, final String message ) {

        super( XmApiMessages.PROBLEMOCCURED, message );
    }

}
