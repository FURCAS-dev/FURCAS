package com.sap.tc.moin.xm.test.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 * Parses an XML document and puts the parsed XML elements into a list
 */
final class XmlParser implements ValueListener {

    private final InputStream xmlDocument;

    private final List<XmlElement> result = new ArrayList<XmlElement>( 500 );

    private final Path xpath;

    private final Map<String, String> namespace2Prefix;

    public static final String TIME_TO_STOP = "time to stop";


    XmlParser( InputStream aXmlDocument, Map<String, String> aNamespace2Prefix ) {

        if ( aXmlDocument == null ) {
            throw new NullPointerException( "xmlDocument is null" );
        }
        this.xmlDocument = aXmlDocument;
        if ( aNamespace2Prefix == null ) {
            this.namespace2Prefix = new HashMap<String, String>( );
        } else {
            this.namespace2Prefix = aNamespace2Prefix;
        }
        this.xpath = new Path( );
    }

    /** Returns the XML document as a list of XmlElements. */
    List<XmlElement> toList( ) {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance( );
        saxParserFactory.setNamespaceAware( true );

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser( );

            saxParser.parse( new InputSource( xmlDocument ), new SaxHandler( this.xpath, this, this.namespace2Prefix ) );
        } catch ( SAXException e ) {
            if ( TIME_TO_STOP.equals( e.getMessage( ) ) ) {
                // ignore stopped
            } else {
                throw new RuntimeException( e );
            }
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        } catch ( ParserConfigurationException e ) {
            throw new RuntimeException( e );
        }
        return this.result;
    }

    public void addValue( String value ) {

        ComparablePath uniqueXpath = new ComparablePath( this.xpath );
        XmlElement element = new XmlElement( uniqueXpath, this.xpath.getCurrentAttributes( ), value );
        this.result.add( element );
    }


    public void elementClosed( ) {

        // do nothing
    }



}
