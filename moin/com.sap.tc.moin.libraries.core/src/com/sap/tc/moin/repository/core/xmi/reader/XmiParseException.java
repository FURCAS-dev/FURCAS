package com.sap.tc.moin.repository.core.xmi.reader;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Internal exception thrown by the XMI parsing component of the XmiReader, if
 * semantical errors violating the XMI specification are detected in an XMI
 * document. Note that low-level syntactical errors result in
 * {@link org.xml.sax.SAXException}s instead.
 */
public final class XmiParseException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 590536375694485643L;

    private String message = null;

    public XmiParseException( MoinLocalizedString messageId ) {

        super( messageId );
    }

    public XmiParseException( MoinLocalizedString messageId, Object[] args ) {

        super( messageId, args );
    }

    public XmiParseException( MoinLocalizedString messageId, Object[] args, Throwable rootCause ) {

        super( rootCause, messageId, args, rootCause );
    }

    public XmiParseException( MoinLocalizedString messageId, Throwable cause ) {

        super( cause, messageId );
    }

    @Override
    public String getMessage( ) {

        if ( message == null ) {
            return super.getMessage( );
        }
        // Append the message that was added later on.
        return super.getMessage( ) + " [" + message + "]"; //$NON-NLS-1$//$NON-NLS-2$
    }

    public void addSaxParserLocation( String locationOfError ) {

        message = locationOfError;
    }
}
