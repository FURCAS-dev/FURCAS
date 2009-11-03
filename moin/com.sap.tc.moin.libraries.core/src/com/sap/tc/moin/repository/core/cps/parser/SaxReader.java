package com.sap.tc.moin.repository.core.cps.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.cps.XmlHelper;
import com.sap.tc.moin.repository.core.cps.parser.v1.ContentHandlerV1;
import com.sap.tc.moin.repository.core.cps.parser.v2.ContentHandlerV2;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiPartitionParseException;

public final class SaxReader extends DefaultHandler {

    private static final String ENCODING = "UTF-8"; //$NON-NLS-1$

    private static final String ROOT = "Partition"; //$NON-NLS-1$

    private static final String VERSION = "version"; //$NON-NLS-1$

    /**
     * The factory for SAX parsers.
     */
    private static SAXParserFactory SAX_PARSER_FACTORY;

    static {
        ClassLoader loader = Thread.currentThread( ).getContextClassLoader( );
        Thread.currentThread( ).setContextClassLoader( SaxReader.class.getClassLoader( ) );
        SAX_PARSER_FACTORY = SAXParserFactory.newInstance( );
        Thread.currentThread( ).setContextClassLoader( loader );
    }

    private final SAXParser SAX_PARSER;

    /**
     * The locator for precise reporting of parsing errors.
     */
    private Locator documentLocator;

    private SpiParserCallback callback;

    public SaxReader( ) {

        try {
            SAX_PARSER = SAX_PARSER_FACTORY.newSAXParser( );
        } catch ( RuntimeException e ) {
            throw e;
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    public void parse( InputStream stream, SpiParserCallback cb, long fileSize ) throws SpiPartitionParseException {

        this.callback = cb;
        Reader reader = null;
        try {
            reader = XmlHelper.getUnsynchronizedBufferedReader( stream, ENCODING, fileSize );
        } catch ( UnsupportedEncodingException e ) {
        } // $JL-EXC$
        try {
            SAX_PARSER.parse( new InputSource( reader ), this );
        } catch ( SAXException ex ) {
            throw createWrappingPartitionParseException( cb.getPri( ), ex );
        } catch ( IOException ex ) {
            throw createWrappingPartitionParseException( cb.getPri( ), ex );
        }
    }

    /**
     * Initializes the SaxReader for the next run.
     */
    public void reset( ) {

        this.documentLocator = null;
        this.callback = null;
        SAX_PARSER.reset( );
    }

    @Override
    public void setDocumentLocator( Locator locator ) {

        documentLocator = locator;
    }

    /**
     * Called back by the SAX parser when the start of an element is found.
     */
    @Override
    public void startElement( String namespaceURI, String sName, String qName, Attributes attrs ) throws SAXException {

        if ( qName.equals( ROOT ) ) {
            String version = attrs.getValue( VERSION );
            if ( version == null ) {
                SAX_PARSER.getXMLReader( ).setContentHandler( new ContentHandlerV1( documentLocator, callback ) );
            } else if ( version.equals( "2" ) ) { //$NON-NLS-1$
                SAX_PARSER.getXMLReader( ).setContentHandler( new ContentHandlerV2( documentLocator, callback ) );
            }
        }
    }

    /**
     * Resolves an external entity. This method is overridden and returns some
     * dummy InputSource in order to prevent the SAX parser from initiating a
     * network connection, which is the default behaviour.
     */
    @Override
    public InputSource resolveEntity( String publicID, String systemID ) {

        return new InputSource( new StringReader( "" ) ); //$NON-NLS-1$
    }

    private SpiPartitionParseException createWrappingPartitionParseException( PRI pri, Exception ex ) {

        SpiPartitionParseException ppe = new SpiPartitionParseException( ex, XMI.UNEXPECTEDEXCEPTIONINSAXREADER );
        String message = "Partition: " + pri; //$NON-NLS-1$
        if ( documentLocator != null ) {
            message += ", Line: " + documentLocator.getLineNumber( ) + ", Column: " + documentLocator.getColumnNumber( ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        ppe.setParserLocation( message );
        return ppe;
    }
}