package com.sap.tc.moin.repository.xm.parser;

import org.xml.sax.SAXParseException;

import com.sap.tc.moin.repository.xm.XmInvalidXmlException;

/**
 * Default Implementation of the parser error handler. It does report validation
 * errors and fatal errors by throwing an exception and does ignore validation
 * warnings.
 */
public class ParserErrorHandlerDefault implements ParserErrorHandler {

    /**
     * This implementation forwards the validation error exception.
     */
    public void error( final SAXParseException exception ) throws XmInvalidXmlException {

        throw new XmInvalidXmlException( exception, XmApiMessages.SAPEXCEPTIONREPORTED, exception.getMessage( ) );

    }

    /**
     * This implementation forwards the fatal error exception.
     */
    public void fatalError( final SAXParseException exception ) throws XmInvalidXmlException {

        throw new XmInvalidXmlException( exception, XmApiMessages.SAPEXCEPTIONREPORTED, exception.getMessage( ) );
    }

    /**
     * This implementation does ignore validation warnings.
     */
    public void warning( final SAXParseException exception ) throws XmInvalidXmlException {

        // ignore
    }

}
