package com.sap.tc.moin.xm.test.xml;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import javax.xml.XMLConstants;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sap.tc.moin.repository.xm.parser.NodeType;


/** SAX Handler for the source XML. */
public final class SaxHandler extends DefaultHandler {

    public static final String TIME_TO_STOP = "time to stop";

    private static final String XSI_NIL = "_!xSi#NiL$_";

    private static final String NIL_NAME = "nil";

    // switch that is on when parser should be stopped
    private boolean isEnough = false;

    private boolean tagStarted = false;// going up


    private Map<String, String> vcache = new LinkedHashMap<String, String>( 512 ) {

        private static final long serialVersionUID = 1l;

        @Override
        protected boolean removeEldestEntry( final Map.Entry<String, String> eldest ) {

            return size( ) > 300;
        }
    };

    private final Path currentXPath;

    private Stack<Boolean> nilStack = new Stack<Boolean>( );

    // value of current element
    private StringBuffer value = new StringBuffer( );

    private final ValueListener listener;

    private final Map<String, String> namespace2Prefix;

    /**
     * Constructor.
     * 
     * @param path
     * @param aListener
     * @throws NullPointerException if a parameter is null
     */
    public SaxHandler( final Path path, ValueListener aListener, Map<String, String> aNamespace2Prefix ) {


        if ( path == null ) {
            throw new NullPointerException( "path must not be null" );
        }
        if ( aListener == null ) {
            throw new NullPointerException( "listener must not be null" );
        }
        this.currentXPath = path;
        this.listener = aListener;
        if ( aNamespace2Prefix == null ) {
            throw new NullPointerException( "aNamespace2Prefix is null" );
        }
        this.namespace2Prefix = aNamespace2Prefix;
    }

    @Override
    public void characters( char ch[], int start, int length ) throws SAXException {

        value.append( ch, start, length );
    }


    @Override
    public void endDocument( ) throws SAXException {

        // do nothing
    }

    @Override
    public void endElement( String uri, String localName, String qName ) throws SAXException {

        if ( isEnough ) {
            throw new SAXException( TIME_TO_STOP );
        }

        boolean nil = nilStack.pop( );
        String tagValue = nil ? XSI_NIL : value.toString( );
        if ( tagStarted ) {
            addValue( tagValue, false ); // leaf
        }
        tagStarted = false;
        value.setLength( 0 );
        elementClosed( );
        this.currentXPath.pop( );

    }


    @Override
    public void startDocument( ) throws SAXException {

        // do nothing
    }


    @Override
    public void startElement( final String uri, final String localName, final String qName, final Attributes attr ) throws SAXException {

        value.setLength( 0 );
        if ( tagStarted ) {
            addValue( "", true ); // no leaf --> add empty value 
        } else {
            tagStarted = true;
        }

        this.currentXPath.push( this.getPrefix( uri ), localName, NodeType.Element );

        Map<String, XmlAttribute> currentAttrs = new HashMap<String, XmlAttribute>( );
        for ( int i = 0; i < attr.getLength( ); i++ ) {
            // we must create own objects for the attributes; 
            // if we just used "this.currentAttrs=attr" then the attr object would change before we have treated the old attributes
            String name = attr.getLocalName( i );
            String ns = this.getPrefix( attr.getURI( i ) );
            XmlAttribute a = new XmlAttribute( name, ns, attr.getValue( i ) );
            currentAttrs.put( ns + ":" + name, a );
        }
        this.currentXPath.setCurrentAttributes( currentAttrs );

        boolean nil = false;
        String nilValue = attr.getValue( XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, NIL_NAME );
        if ( "true".equalsIgnoreCase( nilValue ) ) {
            nil = true;
        }
        nilStack.push( nil );
    }

    private void addValue( String _value, final boolean hasSubElements ) {

        _value = this.reuseValue( _value );
        this.listener.addValue( _value );
    }

    private String reuseValue( String _value ) {

        if ( _value != null ) {
            if ( _value.length( ) == 0 ) {
                _value = "";
            } else {
                String reuse = vcache.get( _value );
                if ( reuse == null ) {
                    vcache.put( _value, _value );
                } else {
                    _value = reuse;
                }
            }
        }
        return _value;
    }

    private void elementClosed( ) {

        this.listener.elementClosed( );
    }

    private String getPrefix( String uri ) {

        if ( uri == null || "".equals( uri ) ) {
            return "";
        } else {
            String prefix = this.namespace2Prefix.get( uri );
            if ( prefix == null ) {
                prefix = "n" + this.namespace2Prefix.keySet( ).size( );
                this.namespace2Prefix.put( uri, prefix );
            }
            return prefix;
        }
    }

    public void stop( ) {

        isEnough = true;
    }

}
