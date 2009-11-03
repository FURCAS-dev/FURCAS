package com.sap.tc.moin.xm.kernel.impl.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.ValidatorHandler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.XmInvalidXmlException;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.parser.XmParserHandler;
import com.sap.tc.moin.xm.kernel.XmParser;
import com.sap.tc.moin.xm.kernel.XmParserCallback;
import com.sap.tc.moin.xm.kernel.impl.XmExceptionMessages;
import com.sap.tc.moin.xm.kernel.impl.XmKernelException;
import com.sap.tc.moin.xm.kernel.impl.parser.sax.ErrorHandlerImpl;
import com.sap.tc.moin.xm.kernel.impl.parser.sax.SourceXmlHandler;
import com.sap.tc.moin.xm.kernel.impl.parser.sax.WrappedInvalidXmlException;
import com.sap.tc.moin.xm.kernel.impl.parser.sax.XmStopParseException;
import com.sap.tc.moin.xm.kernel.impl.parser.util.ParserHelperImpl;


/** Implementation of the XM Parser. It wraps a parser handler. */
public final class XmParserImpl<TElement, TMofClass, TMofAssociation> extends XmParser<TElement, TMofClass, TMofAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmParserImpl.class );

    private static SAXParserFactory saxParserFactory;

    private final ParserHelperImpl<TElement, TMofClass, TMofAssociation> helper;

    private final XmParserHandler handler;

    private ErrorHandlerImpl saxErrorHandler;

    /**
     * Constructor.
     * 
     * @param config configuration
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public XmParserImpl( final XmParserConfiguration config ) {

        if ( config == null ) {
            throw new MoinNullPointerException( "config" ); //$NON-NLS-1$
        }
        this.handler = config.getHandler( );
        this.helper = new ParserHelperImpl<TElement, TMofClass, TMofAssociation>( config.getXmlSchema( ), config.getErrorHandler( ) );
        this.helper.setNamespaceMaps( this.getPrefixToNamespace( this.handler.getNamespaceToPrefix( ) ), this.handler.getNamespaceToPrefix( ) );
        initSAXParserFactory( );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Core XM Parser for Custom XM Parser {0} created", this.handler.getClass( ).getName( ) ); //$NON-NLS-1$
        }
    }

    private Map<String, String> getPrefixToNamespace( final Map<String, String> ns2Prefix ) {

        if ( ns2Prefix == null ) {
            throw new MoinNullPointerException( "ns2Prefix" ); //$NON-NLS-1$
        }
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Prefix to namespace map: {0}", ns2Prefix ); //$NON-NLS-1$
        }
        final Map<String, String> result = new HashMap<String, String>( );
        for ( final Entry<String, String> entry : ns2Prefix.entrySet( ) ) {
            result.put( entry.getValue( ), entry.getKey( ) );
        }
        return Collections.unmodifiableMap( result );
    }

    @Override
    public void parse( final InputStream is, final XmParserCallback<TElement, TMofClass, TMofAssociation> callback ) throws XmException {

        long time;
        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            time = System.currentTimeMillis( );
        } else {
            time = 0;
        }

        this.helper.setCallback( callback );

        try {
            this.handler.startDocument( this.helper );
            this.parse( is );
            /**
             * Executes the retarded links. At the end of the mapping the
             * retarded links are executed here, because one can decide whether
             * a retarded link is an inner- or inter-partition link ( at the end
             * all instances of the partition are in the cache).
             */
            this.helper.executeRetardedLinks( );
        } finally {
            // free resources after the execution of a mapping
            this.helper.reset( );
            this.handler.endDocument( );
        }
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.INFO, "XM Parsing took {0} ms", Long.toString( System.currentTimeMillis( ) - time ) ); //$NON-NLS-1$
        }
    }


    private void parse( final InputStream is ) throws XmException {

        final SourceXmlHandler handler = new SourceXmlHandler( this.handler );
        if ( this.helper.getValidatorHandler( ) == null ) {
            this.parseWithoutValidation( is, handler );
        } else {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, "The model partition {0} is parsed and validated", this.helper.getPri( ) ); //$NON-NLS-1$
            }
            this.parseWithValidation( is, handler );
        }
    }

    /**
     * Parses and validates the source XML document.
     * 
     * @param inputStream input stream
     * @param saxHandler SAX handler
     * @throws XmInvalidXmlException if the custom error handler throws such an
     * exception
     * @throws XmInvalidXmlException if the custom error handler throws such an
     * exception
     * @throws XmException if other errors occur
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    private void parseWithValidation( final InputStream inputStream, final DefaultHandler saxHandler ) throws XmException {

        if ( inputStream == null ) {
            throw new MoinNullPointerException( "input" ); //$NON-NLS-1$
        }
        if ( saxHandler == null ) {
            throw new MoinNullPointerException( "saxHandler" ); //$NON-NLS-1$
        }
        try {
            if ( this.saxErrorHandler == null ) {
                this.saxErrorHandler = new ErrorHandlerImpl( this.helper.getErrorHandler( ) );
            }
            final ValidatorHandler validatorHandler = this.helper.getValidatorHandler( );
            validatorHandler.setContentHandler( saxHandler );
            validatorHandler.setErrorHandler( this.saxErrorHandler );

            final XMLReader reader = saxParserFactory.newSAXParser( ).getXMLReader( );

            reader.setContentHandler( validatorHandler );
            reader.parse( new InputSource( inputStream ) );
        } catch ( final WrappedInvalidXmlException e ) {
            throw e.getWrappedException( );
        } catch ( final XmStopParseException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, "Parsing stopped by XmStopParseException" ); //$NON-NLS-1$
            }
            // ignore, parsing stopped
        } catch ( final SAXException e ) {
            if ( e.getException( ) instanceof XmException ) {
                // wrapped XMException
                LOGGER.logAndTrace( e.getException( ), MoinSeverity.ERROR, XmExceptionMessages.EXCEPTIONDURINGPARSE );
                throw (XmException) e.getException( );
            } else {
                LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmExceptionMessages.EXCEPTIONDURINGPARSE );
                throw new XmKernelException( e, XmExceptionMessages.EXCEPTIONDURINGPARSE );
            }
        } catch ( final IOException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmExceptionMessages.IOEXCEPTIONDURINGPARSE );
            throw new XmKernelException( e, XmExceptionMessages.IOEXCEPTIONDURINGPARSE );
        } catch ( final ParserConfigurationException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmExceptionMessages.SAPPARSERCONFIGPROBLEM );
            throw new XmKernelException( e, XmExceptionMessages.SAPPARSERCONFIGPROBLEM );
        }
    }

    private void parseWithoutValidation( final InputStream inputStream, final DefaultHandler handler ) throws XmException {

        if ( inputStream == null ) {
            throw new MoinNullPointerException( "input" ); //$NON-NLS-1$
        }
        if ( handler == null ) {
            throw new MoinNullPointerException( "handler" ); //$NON-NLS-1$
        }
        try {
            final SAXParser saxParser = saxParserFactory.newSAXParser( );
            saxParser.parse( new InputSource( inputStream ), handler );
        } catch ( final XmStopParseException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, "Parsing stopped by XmStopParseException" ); //$NON-NLS-1$
            }
            // ignore, parsing stopped
        } catch ( final SAXException e ) {
            if ( e.getException( ) instanceof XmException ) {
                // wrapped XMException
                LOGGER.logAndTrace( e.getException( ), MoinSeverity.ERROR, XmExceptionMessages.EXCEPTIONDURINGPARSE );
                throw (XmException) e.getException( );
            } else {
                LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmExceptionMessages.EXCEPTIONDURINGPARSE );
                throw new XmKernelException( e, XmExceptionMessages.EXCEPTIONDURINGPARSE );
            }
        } catch ( final IOException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmExceptionMessages.IOEXCEPTIONDURINGPARSE );
            throw new XmKernelException( e, XmExceptionMessages.IOEXCEPTIONDURINGPARSE );
        } catch ( final ParserConfigurationException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmExceptionMessages.SAPPARSERCONFIGPROBLEM );
            throw new XmKernelException( e, XmExceptionMessages.SAPPARSERCONFIGPROBLEM );
        }
    }

    private static synchronized void initSAXParserFactory( ) {

        if ( saxParserFactory == null ) {
            saxParserFactory = SAXParserFactory.newInstance( );
            saxParserFactory.setNamespaceAware( true );
        }
    }

}
