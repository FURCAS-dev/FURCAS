package com.sap.tc.moin.repository.core.cps.parser.v2;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;

import com.sap.tc.moin.repository.core.cps.parser.ParserContext;
import com.sap.tc.moin.repository.core.cps.parser.v1.ContentHandlerV1;
import com.sap.tc.moin.repository.core.cps.serializer.v2.PartitionConstants;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.util.SpiMutableInteger;

public final class ContentHandlerV2 extends ContentHandlerV1 {

    public ContentHandlerV2( Locator documentLocator, SpiParserCallback callback ) {

        super( documentLocator, callback );
    }

    @Override
    protected ParserContext createContext( SpiParserCallback callback ) {

        return new ParserContextV2( callback );
    }

    @Override
    protected XmlElement createRootElement( ParserContext context ) {

        return new Root( context, PartitionConstants.ROOT );
    }

    private static final class Root extends ContentHandlerV1.Root {

        public Root( ParserContext context, String qName ) {

            super( context, qName );
        }

        @Override
        protected Instance createInstance( ) {

            return new Instance( context );
        }

        @Override
        public XmlElement startElement( String qName, Attributes attrs ) {

            if ( qName.equals( PartitionConstants.METAMODEL ) ) {
                String version = ( attrs.getLength( ) > 2 ? attrs.getValue( 2 ) : null );
                context.addContainer( attrs.getValue( 0 ), attrs.getValue( 1 ), version );
            } else if ( qName.length( ) == 1 ) {
                context.addMetaObject( qName, attrs );
            } else {
                // Can be either a model element or an association grouping tag. Decide based on the number of attributes,
                // because association grouping tags only carry the container id, while model elements at least carry 
                // container id and MOF-ID.
                if ( attrs.getLength( ) > 1 ) {
                    return instance.init( this, qName, attrs );
                }
                return association.init( this, qName, attrs );
            }
            return this;
        }
    }

    private static class Instance extends ContentHandlerV1.Instance {

        public Instance( ParserContext context ) {

            super( context );
        }

        @Override
        public XmlElement startElement( String attributeName, Attributes attrs ) {

            if ( element != null ) {
                if ( attrs.getQName( 0 ).equals( PartitionConstants.TYPE ) ) {
                    // Must be a structured value, with its type encoded in the first attribute (via its 
                    // qualified name), and the type's container id encoded in the second attribute.
                    String qualifiedNameOfType = attrs.getValue( 0 );
                    String containerIdOfType = attrs.getValue( 1 );
                    SpiType structureType = context.getType( containerIdOfType, qualifiedNameOfType );
                    if ( structureType instanceof SpiStructureType ) {
                        SpiStructuredValue value = parseStructuredValue( (SpiStructureType) structureType, 0, new SpiMutableInteger( 2 ), attrs );
                        context.addAttributeValue( element, attributeName, value );
                    } else {
                    }
                } else {
                    context.addAttributeValue( element, attributeName, attrs.getValue( 0 ) );
                }
            }
            return this;
        }

        /**
         * Recursively (in the case of structured fields) constructs an
         * SpiStructuredValue instance from the given list of XML attribute
         * names and values.
         */
        private SpiStructuredValue parseStructuredValue( SpiStructureType type, int nestingLevel, SpiMutableInteger currentIndex, Attributes attrs ) {

            SpiStructuredValue result = context.createStructuredValue( type );
            int originalCurrentIndex = currentIndex.getValue( );
            for ( int i = originalCurrentIndex, n = attrs.getLength( ); i < n; i++ ) {
                String name = attrs.getQName( i );
                String value = attrs.getValue( i );
                if ( name.startsWith( PartitionConstants.TYPE ) ) { // we are at the beginning of a nested StructuredValue => recurse
                    String qualifiedNameOfNestedStructureType = value;
                    String containerIdOfOfNestedStructureType = attrs.getValue( i + 1 );
                    SpiStructureType nestedStructureType = (SpiStructureType) context.getType( containerIdOfOfNestedStructureType, qualifiedNameOfNestedStructureType );
                    String fieldName = attrs.getQName( i + 2 );
                    for ( int j = 0; j < nestingLevel + 1; j++ ) {
                        fieldName = fieldName.substring( 0, fieldName.indexOf( '.' ) );
                    }
                    currentIndex.setValue( currentIndex.getValue( ) + 2 );
                    result.set___FieldValue( fieldName, parseStructuredValue( nestedStructureType, nestingLevel + 1, currentIndex, attrs ) );
                    i = currentIndex.getValue( );
                } else {
                    int dots = countDots( name );
                    if ( dots == nestingLevel ) {
                        // the XML attribute denotes a structure field for the current StructuredValue => set it and increment
                        // 'currentIndex' to mark it as processed
                        if ( nestingLevel > 0 ) {
                            result.set___FieldValue( name.substring( name.lastIndexOf( '.' ) + 1 ), value );
                        } else {
                            result.set___FieldValue( name, value );
                        }
                        currentIndex.increment( );
                    } else if ( dots < nestingLevel ) {
                        // the XML attribute denotes a structure field for the enclosing structured value => we are finished 
                        // with the current StructuredValue and return
                        return result;
                    }
                }
            }
            if ( originalCurrentIndex == currentIndex.getValue( ) ) {
                // No field values found => the whole RefStruct must have been 'null' during serialization.
                return null;
            }
            return result;
        }
    }
}