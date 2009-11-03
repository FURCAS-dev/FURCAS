package com.sap.tc.moin.xm.kernel.impl.parser.sax;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.XMLConstants;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.parser.XmParserHandler;
import com.sap.tc.moin.repository.xm.parser.XmlAttribute;


/** SAX Handler for the source XML. */
public final class SourceXmlHandler extends DefaultHandler {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, SourceXmlHandler.class );

    private static final String XSI_NIL = "_!xSi#NiL$_"; //$NON-NLS-1$

    private static final String NIL_NAME = "nil"; //$NON-NLS-1$

    private final Map<String, String> vcache = new MapWith300Entries( );

    private static final class MapWith300Entries extends LinkedHashMap<String, String> {

        MapWith300Entries( ) {

            super( );
        }

        private static final long serialVersionUID = 1l;

        @Override
        protected boolean removeEldestEntry( final Map.Entry<String, String> eldest ) {

            return size( ) > 300;
        }

    }

    // current attributes
    private final List<XmlAttribute> currentAttrs = new LinkedList<XmlAttribute>( );

    // switch that is on when parser should be stopped
    private boolean isEnough = false;

    private boolean tagStarted = false;// going up

    private final Stack<Boolean> nilStack = new Stack<Boolean>( );

    // value of current element
    private final StringBuffer value = new StringBuffer( );

    private final XmParserHandler listener;

    private String oldLocalName;

    private String oldNamespace;


    /**
     * Constructor.
     * 
     * @param aListener
     * @throws NullPointerException if a parameter is null
     */
    public SourceXmlHandler( final XmParserHandler aListener ) {


        if ( aListener == null ) {
            throw new MoinNullPointerException( "aListener" ); //$NON-NLS-1$
        }
        this.listener = aListener;
    }



    @Override
    public void characters( final char ch[], final int start, final int length ) throws SAXException {

        value.append( ch, start, length );
    }


    @Override
    public void endDocument( ) throws SAXException {

        // do nothing
    }

    @Override
    public void endElement( final String uri, final String localName, final String qName ) throws SAXException {

        try {
            if ( isEnough ) {
                if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                    LOGGER.trace( MoinSeverity.INFO, "Stopping parsing" ); //$NON-NLS-1$
                }
                throw new XmStopParseException( );
            }

            final boolean nil = nilStack.pop( );
            final String tagValue = nil ? XSI_NIL : value.toString( );
            if ( tagStarted ) {
                addValue( this.oldLocalName, this.oldNamespace, tagValue, this.currentAttrs, false ); // leaf
                this.oldLocalName = null;
                this.oldNamespace = null;
            }
            tagStarted = false;
            value.setLength( 0 );
            elementClosed( );
        } catch ( final XmException e ) {
            throw new SAXException( e );
        }
    }


    @Override
    public void startDocument( ) throws SAXException {

        // do nothing
    }


    @Override
    public void startElement( final String uri, final String localName, final String qName, final Attributes attr ) throws SAXException {

        try {
            value.setLength( 0 );
            if ( tagStarted ) {
                addValue( this.oldLocalName, this.oldNamespace, "", this.currentAttrs, true ); // no leaf --> add empty value  //$NON-NLS-1$
            } else {
                tagStarted = true;
            }

            this.currentAttrs.clear( );
            for ( int i = 0; i < attr.getLength( ); i++ ) {
                // we must create own objects for the attributes; 
                // if we just used "this.currentAttrs=attr" then the attr object would change before we have treated the old attributes
                this.currentAttrs.add( new XmlAttributeImpl( attr.getLocalName( i ), attr.getURI( i ), this.reuseValue( attr.getValue( i ) ) ) );
            }
            boolean nil = false;
            final String nilValue = attr.getValue( XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, NIL_NAME );
            if ( "true".equalsIgnoreCase( nilValue ) ) { //$NON-NLS-1$
                nil = true;
            }
            nilStack.push( nil );
            this.oldLocalName = localName;
            this.oldNamespace = uri;
        } catch ( final XmException e ) {
            throw new SAXException( e );
        }
    }

    private void addValue( final String localName, final String namespace, final String _value, final List<XmlAttribute> attributes, final boolean hasSubElements ) throws XmException {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Element with name {0} and namespace {1} and value {2} started", new Object[] { localName, namespace, _value } ); //$NON-NLS-1$
        }
        this.listener.elementStarted( localName, namespace, this.reuseValue( _value ), attributes );
    }

    private String reuseValue( String _value ) {

        if ( _value != null ) {
            if ( _value.length( ) == 0 ) {
                _value = ""; //$NON-NLS-1$
            } else {
                final String reuse = vcache.get( _value );
                if ( reuse == null ) {
                    vcache.put( _value, _value );
                } else {
                    _value = reuse;
                }
            }
        }
        return _value;
    }

    private void elementClosed( ) throws XmException {

        this.listener.elementClosed( );
    }

    public void stop( ) {

        isEnough = true;
        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Stop of parsing requested" ); //$NON-NLS-1$
        }
    }

    static class XmlHandlerException extends XmException {

        private static final long serialVersionUID = -6346029142408526419L;

        public XmlHandlerException( final MoinLocalizedString message, final Object... args ) {

            super( message, args );
        }
    }
}
