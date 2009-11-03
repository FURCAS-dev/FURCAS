package com.sap.tc.moin.xm.kernel.impl.parser.sax;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.XmInvalidXmlException;
import com.sap.tc.moin.repository.xm.parser.ParserErrorHandler;


/**
 * Delegator for {@link ParserErrorHandler}. The exceptions thrown by the parser
 * error handler are wrapped into SAX exceptions.
 */
public final class ErrorHandlerImpl implements ErrorHandler {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, ErrorHandlerImpl.class );

    private final ParserErrorHandler errorHandler;

    public ErrorHandlerImpl( final ParserErrorHandler aErrorHandler ) {

        if ( aErrorHandler == null ) {
            throw new MoinNullPointerException( "aErrorHandler" ); //$NON-NLS-1$
        }
        this.errorHandler = aErrorHandler;
    }

    public void warning( final SAXParseException exception ) throws SAXException {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( exception, MoinSeverity.DEBUG, "SAX error handler receieved warning" ); //$NON-NLS-1$
        }
        try {
            this.errorHandler.warning( exception );
        } catch ( final XmInvalidXmlException e ) {
            LOGGER.trace( e, MoinSeverity.WARNING, "Customer Error Handler throwed exception" ); //$NON-NLS-1$
            throw new WrappedInvalidXmlException( e );
        }
    }



    public void error( final SAXParseException exception ) throws SAXException {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( exception, MoinSeverity.DEBUG, "SAX error handler receieved error" ); //$NON-NLS-1$
        }
        try {
            this.errorHandler.error( exception );
        } catch ( final XmInvalidXmlException e ) {
            LOGGER.trace( e, MoinSeverity.WARNING, "Customer Error Handler throwed exception" ); //$NON-NLS-1$
            throw new WrappedInvalidXmlException( e );
        }
    }



    public void fatalError( final SAXParseException exception ) throws SAXException {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( exception, MoinSeverity.DEBUG, "SAX error handler receieved fatal error" ); //$NON-NLS-1$
        }
        try {
            this.errorHandler.fatalError( exception );
        } catch ( final XmInvalidXmlException e ) {
            LOGGER.trace( e, MoinSeverity.WARNING, "Customer Error Handler throwed exception" ); //$NON-NLS-1$
            throw new WrappedInvalidXmlException( e );
        }
    }
}
