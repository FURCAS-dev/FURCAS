package com.sap.tc.moin.repository.core.cps.parser.v1;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.cps.parser.CoreCpsParserMessages;
import com.sap.tc.moin.repository.core.cps.parser.ParserContext;
import com.sap.tc.moin.repository.core.cps.serializer.v1.PartitionConstants;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiPartitionParseException;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.util.SpiMutableInteger;

public class ContentHandlerV1 implements ContentHandler {

    private XmlElement currentElement;

    private final PRI partitionBehindStream;

    private final Locator documentLocator;

    public ContentHandlerV1( Locator documentLocator, SpiParserCallback callback ) {

        this.documentLocator = documentLocator;
        this.partitionBehindStream = callback.getPri( );
        this.currentElement = createRootElement( createContext( callback ) );
    }

    protected ParserContext createContext( SpiParserCallback callback ) {

        return new ParserContextV1( callback );
    }

    protected XmlElement createRootElement( ParserContext ctx ) {

        return new Root( ctx, PartitionConstants.ROOT );
    }

    /**
     * Called back by the SAX parser when the start of an element is found.
     */
    public void startElement( String namespaceURI, String sName, String qName, Attributes attrs ) throws SAXException {

        try {
            currentElement = currentElement.startElement( qName, attrs );
        } catch ( SpiPartitionParseException ex ) {
            // Enrich the PartitionParseException with the SAX location before re-throwing it.
            ex.setParserLocation( getParsingErrorInfo( true /* startOfElement */, qName ) );
            throw ex;
        } catch ( Exception ex ) {
            throw new SpiPartitionParseException( ex, getParsingErrorInfo( true /* startOfElement */, qName ) );
        }
        if ( currentElement == null ) {
            throw new SpiPartitionParseException( new MoinIllegalStateException( CoreCpsParserMessages.UNEXPECTEDNULLVALUE ), getParsingErrorInfo( true /* startOfElement */, qName ) );
        }
    }

    /**
     * Called back by the SAX parser when the end of an element is found.
     */
    public void endElement( String namespaceURI, String sName, String qName ) throws SAXException {

        try {
            currentElement = currentElement.endElement( qName );
        } catch ( SpiPartitionParseException ex ) {
            // Enrich the PartitionParseException with the SAX location before re-throwing it.
            ex.setParserLocation( getParsingErrorInfo( true /* startOfElement */, qName ) );
            throw ex;
        } catch ( Exception ex ) {
            throw new SpiPartitionParseException( ex, getParsingErrorInfo( false /* startOfElement */, qName ) );
        }
    }

    protected final String getParsingErrorInfo( boolean startOfElement, String qName ) {

        return "Partition: " + partitionBehindStream + ", parsing error during " + ( startOfElement ? "startElement" : "endElement" ) + " of <" + qName + ">, Line: " + documentLocator.getLineNumber( ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
    }

    protected static abstract class XmlElement {

        protected XmlElement parentElement;

        protected String qualifiedName;

        protected XmlElement( ) {

        }

        public abstract XmlElement startElement( String qName, Attributes attrs );

        public abstract XmlElement endElement( String qName );
    }

    protected static class Root extends XmlElement {

        protected final ParserContext context;

        protected Instance instance;

        protected Association association;

        public Root( ParserContext context, String qName ) {

            this.context = context;
            this.qualifiedName = qName;
            this.instance = createInstance( );
            this.association = createAssociation( );
        }

        protected Instance createInstance( ) {

            return new Instance( context );
        }

        protected Association createAssociation( ) {

            return new Association( context );
        }

        @Override
        public XmlElement startElement( String qName, Attributes attrs ) {

            if ( qName.equals( PartitionConstants.CONTAINER ) ) {
                String version = ( attrs.getLength( ) > 2 ? attrs.getValue( 2 ) : null );
                context.addContainer( attrs.getValue( 0 ), attrs.getValue( 1 ), version );
            } else if ( qName.equals( PartitionConstants.META_OBJECT ) ) {
                context.addMetaObject( qName, attrs );
            } else {
                // Can be either a model element or an association grouping tag. Decide based on the number of attributes.
                if ( attrs.getLength( ) > 1 ) {
                    return instance.init( this, qName, attrs );
                }
                return association.init( this, qName, attrs );
            }
            return this;
        }

        @Override
        public XmlElement endElement( String qName ) {

            if ( qName.equals( qualifiedName ) ) {
                context.parsingFinished( );
                return null;
            }
            return this;
        }
    }

    protected static class Instance extends XmlElement {

        private String mofId;

        private String containerId;

        protected SpiElement element;

        protected final ParserContext context;

        public Instance( ParserContext context ) {

            this.context = context;
        }

        public XmlElement init( XmlElement parent, String qName, Attributes attrs ) {

            this.parentElement = parent;
            this.qualifiedName = qName;
            this.containerId = attrs.getValue( 0 );
            this.mofId = attrs.getValue( 1 );
            this.element = context.addElement( containerId, qualifiedName, mofId );
            if ( element != null ) {
                if ( attrs.getLength( ) > 2 ) {
                    for ( int i = 2; i < attrs.getLength( ); i++ ) {
                        // For all XML attributes of the model element we know that they already represent the complete 
                        // attribute value. Therefore we can set them immediately.
                        context.addAttributeValue( element, attrs.getQName( i ), attrs.getValue( i ) );
                    }
                }
            }
            return this;
        }

        @Override
        public XmlElement startElement( String attributeName, Attributes attrs ) {

            if ( element != null ) {
                // We assume that the existence of more than one attribute for a nested element only occurs 
                // for structured values. Primitive-, enumeration- or object-typed attributes only have one XML
                // attribute, namely 'v'.
                // Note: this is not clean - we will run into trouble if the metamodel contains a StructureType 
                // with only one StructureField named 'v'. We cannot distinguish such a value from a primitive
                // value without access to the metamodel!
                // The correct solution would have been to use 'm:v' in the partition format instead of 'v' 
                // to avoid collisions with modeled attributes named 'v'.
                if ( attrs.getLength( ) > 1 || ( attrs.getLength( ) == 1 && !attrs.getQName( 0 ).equals( PartitionConstants.VALUE ) ) ) {
                    // Assumed to be a structured value (see comment above: assumption might be a wrong!)
                    SpiStructuredValue value = parseStructuredValue( 0, new SpiMutableInteger( 0 ), attrs );
                    context.addAttributeValue( element, attributeName, value );
                } else {
                    context.addAttributeValue( element, attributeName, attrs.getValue( 0 ) );
                }
            }
            return this;
        }

        @Override
        public XmlElement endElement( String qName ) {

            if ( qName.equals( qualifiedName ) ) {
                return parentElement;
            }
            return this;
        }

        /**
         * Recursively (in the case of structured fields) constructs an
         * SpiStructuredValue instance from the given list of XML attribute
         * names and values.
         */
        private SpiStructuredValue parseStructuredValue( int nestingLevel, SpiMutableInteger currentIndex, Attributes attrs ) {

            SpiStructuredValue result = context.createStructuredValue( );
            int originalCurrentIndex = currentIndex.getValue( );
            for ( int i = originalCurrentIndex, n = attrs.getLength( ); i < n; i++ ) {
                String name = attrs.getQName( i );
                String value = attrs.getValue( i );
                int dots = countDots( name );
                if ( dots == nestingLevel ) {
                    // the attribute denotes a structure field for the current structured value => set it and increment
                    // 'currentIndex' to mark it as processed
                    if ( nestingLevel > 0 ) {
                        result.set___FieldValue( name.substring( name.lastIndexOf( '.' ) + 1 ), value );
                    } else {
                        result.set___FieldValue( name, value );
                    }
                    currentIndex.increment( );
                } else if ( dots < nestingLevel ) {
                    // the attribute denotes a structure field for the enclosing structured value => we are finished with the current
                    // structured value and return
                    return result;
                } else { // dots > nestingLevel
                    // the attribute denotes a structure field for the a nested structured value => recurse
                    String attrName = name;
                    for ( int j = 0; j < nestingLevel + 1; j++ ) {
                        attrName = attrName.substring( 0, attrName.indexOf( '.' ) );
                    }
                    result.set___FieldValue( attrName, parseStructuredValue( nestingLevel + 1, currentIndex, attrs ) );
                    i = currentIndex.getValue( );
                }
            }
            if ( originalCurrentIndex == currentIndex.getValue( ) ) {
                // No field values found => the whole RefStruct must have been 'null' during serialization.
                return null;
            }
            return result;
        }

        protected final int countDots( String attrName ) {

            int result = 0;
            for ( int i = 0, n = attrName.length( ); i < n; i++ ) {
                if ( attrName.charAt( i ) == '.' ) {
                    result++;
                }
            }
            return result;
        }
    }

    protected static final class Association extends XmlElement {

        private String containerId;

        private SpiAssociation association;

        private final ParserContext context;

        public Association( ParserContext context ) {

            this.context = context;
        }

        public XmlElement init( XmlElement parent, String qName, Attributes attrs ) {

            parentElement = parent;
            qualifiedName = qName;
            containerId = attrs.getValue( 0 );
            SpiType type = context.getType( containerId, qualifiedName );
            if ( type instanceof SpiAssociation ) {
                association = (SpiAssociation) type;
            }
            return this;
        }

        @Override
        public XmlElement startElement( String qName, Attributes attrs ) {

            if ( association != null ) { // otherwise, we failed to resolve the association during init()
                String firstEnd = attrs.getValue( 0 );
                String secondEnd = attrs.getValue( 1 );
                context.addLink( association, firstEnd, secondEnd );
            }
            return this;
        }

        @Override
        public XmlElement endElement( String qName ) {

            if ( qName.equals( qualifiedName ) ) {
                return parentElement;
            }
            return this;
        }
    }

    public void characters( char[] ch, int start, int length ) throws SAXException {

    }

    public void endDocument( ) throws SAXException {

    }

    public void endPrefixMapping( String prefix ) throws SAXException {

    }

    public void ignorableWhitespace( char[] ch, int start, int length ) throws SAXException {

    }

    public void processingInstruction( String target, String data ) throws SAXException {

    }

    public void setDocumentLocator( Locator locator ) {

    }

    public void skippedEntity( String name ) throws SAXException {

    }

    public void startDocument( ) throws SAXException {

    }

    public void startPrefixMapping( String prefix, String uri ) throws SAXException {

    }
}