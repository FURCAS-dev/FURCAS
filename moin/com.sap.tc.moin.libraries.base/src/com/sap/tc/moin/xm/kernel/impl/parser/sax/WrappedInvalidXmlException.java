package com.sap.tc.moin.xm.kernel.impl.parser.sax;

import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.xm.XmInvalidXmlException;

/**
 * Wrapper for {@link XmInvalidXmlException}. Thrown by {@link ErrorHandlerImpl}
 * .
 */
public final class WrappedInvalidXmlException extends SAXException {

    private static final long serialVersionUID = -6346029142408526419L;

    private final XmInvalidXmlException exception;

    WrappedInvalidXmlException( final XmInvalidXmlException e ) {

        super( e.getMessage( ) );
        this.exception = e;
    }

    /**
     * Returns the wrapped exception.
     * 
     * @return wrapped exception
     */
    public XmInvalidXmlException getWrappedException( ) {

        return this.exception;
    }

}
