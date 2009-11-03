package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * This class is the SAX handler used for parsing XMI documents. Before each
 * parsing run the {@link SaxReader} instance gets re-initialized by calling the
 * {@link #init()} method.
 */
class SaxReader extends DefaultHandler {

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

    /**
     * The locator for precise reporting of parsing errors.
     */
    private Locator documentLocator;

    /**
     * The XmiContext instance storing all parsed data.
     */
    private XmiContext context;

    /**
     * The currently processed XmiElement.
     */
    private XmiElement currentElement;

    /**
     * Creates an instance and links it to the given XmiContext instance. This
     * class is instantiated by instances of {@link XmiContext} only.
     */
    SaxReader( XmiContext ctx ) {

        context = ctx;
        init( );
    }

    /**
     * Re-initializes the SAX reader for another run.
     */
    void init( ) {

        currentElement = null;
    }

    /**
     * Creates a new SAX parser and parses the given InputStream.
     */
    void read( InputStream stream ) throws IOException, SAXException, ParserConfigurationException {

        SAX_PARSER_FACTORY.newSAXParser( ).parse( stream, this );
    }

    @Override
    public void setDocumentLocator( Locator locator ) {

        documentLocator = locator;
    }

    private String getXmiParsingErrorInfo( boolean startOfElement, String qName ) {

        String location = "XMI parsing error during " + ( startOfElement ? "startElement" : "endElement" ) + " of <" + qName + "> (URI: " + context.getCurrentURI( ) + ", line: " + documentLocator.getLineNumber( ) + ")"; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
        return location;
    }

    /**
     * Called back by the SAX parser when the start of an element is found.
     * <p>
     * If the element is the <code>&lt;XMI&gt;</code> element, an instance of
     * {@link Root} is created. Otherwise,
     * {@link XmiElement#startElement(String, Attributes)} is called on the
     * {@link #currentElement current element}.
     */
    public void startElement( String namespaceURI, String sName, String qName, Attributes attrs ) throws SAXException {

        if ( qName.equals( XmiConstants.XMI_ROOT ) ) {
            currentElement = new Root( null /* parent */, context, attrs );
            return;
        }
        if ( currentElement != null ) {
            try {
                currentElement = currentElement.startElement( qName, attrs );
            } catch ( XmiParseException ex ) {
                // Enrich the XmiParseException with the SAX location before re-throwing it.
                ex.addSaxParserLocation( getXmiParsingErrorInfo( true /* startOfElement */, qName ) );
                throw ex;
            } catch ( Exception ex ) {
                throw new XmiParseException( XMI.MOIN_XMI_1073, new Object[] { getXmiParsingErrorInfo( true /* startOfElement */, qName ) }, ex );
            }
            if ( currentElement == null ) {
                throw new XmiParseException( XMI.MOIN_XMI_1073, new Object[] { getXmiParsingErrorInfo( true /* startOfElement */, qName ) }, new IllegalStateException( "Unexpected 'null' value of currentElement" ) ); //$NON-NLS-1$
            }
        }
    }

    /**
     * Called back by the SAX parser when the end of an element is found.
     * <p>
     * The call is delegated to the {@link XmiElement#endElement(String)} method
     * of the {@link #currentElement current element}.
     */
    public void endElement( String namespaceURI, String sName, String qName ) throws SAXException {

        try {
            currentElement = currentElement.endElement( qName );
        } catch ( XmiParseException ex ) {
            // Enrich the XmiParseException with the SAX location before re-throwing it.
            ex.addSaxParserLocation( getXmiParsingErrorInfo( true /* startOfElement */, qName ) );
            throw ex;
        } catch ( Exception ex ) {
            throw new XmiParseException( XMI.MOIN_XMI_1073, new Object[] { getXmiParsingErrorInfo( false /* startOfElement */, qName ) }, ex );
        }
        if ( currentElement == null && !( qName.equals( XmiConstants.XMI_ROOT ) ) ) {
            throw new XmiParseException( XMI.MOIN_XMI_1073, new Object[] { getXmiParsingErrorInfo( false /* startOfElement */, qName ) }, new IllegalStateException( "Unexpected 'null' value of currentElement" ) ); //$NON-NLS-1$
        }
    }

    /**
     * Called back by the SAX parser when character data inside an element has
     * been read.
     * <p>
     * If the {@link #currentElement current element} is not <code>null</code>,
     * the call is immediately delegated to it.
     */
    public void characters( char buf[], int offset, int len ) throws SAXException {

        if ( currentElement != null ) {
            currentElement.characters( buf, offset, len );
        }
    }

    /**
     * Resolves an external entity. This method is overridden and returns some
     * dummy InputSource in order to prevent the SAX parser from initiating a
     * network connection, which is the default behaviour.
     */
    public InputSource resolveEntity( String publicID, String systemID ) {

        // TODO Log the external entity.
        return new InputSource( new StringReader( "" ) ); //$NON-NLS-1$
    }
}
