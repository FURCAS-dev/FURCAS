package com.sap.tc.moin.repository.cps.test;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import com.sap.tc.moin.repository.mmi.descriptors.ExtentDescriptor;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;

/**
 * Test custom serializer based on properties. The serializer is stateless.
 * 
 * @author d026715
 */

public class SimpleTestCustomSerializer implements SpiCustomSerializer {

    public void serialize( OutputStream stream, SpiSerializerCallback callback ) {

        Properties props = new Properties( );

        Collection<SpiElement> elements = callback.getElements( );

        for ( SpiElement spiElement : elements ) {
            SpiClass elementType = spiElement.get___Type( );
            String externalId = (String) spiElement.get___AttributeValue( SimpleTestCustomParser.EXTERNAL_ID_ATTRIBUTE );

            props.setProperty( SimpleTestCustomParser.ELEMENT_ID + SimpleTestCustomParser.SEPARATION_CHAR + externalId, this.getExternalTypeName( elementType.get___MofId( ) ) );

            List<String> attributeNames = elementType.get___AttributeNames( );
            for ( String name : attributeNames ) {
                if ( !name.equals( SimpleTestCustomParser.EXTERNAL_ID_ATTRIBUTE ) ) {
                    Object attributeValue = spiElement.get___AttributeValue( name );
                    if ( attributeValue instanceof SpiStructuredValue ) {
                        this.writeStructure( props, externalId, name, (SpiStructuredValue) attributeValue );
                    } else if ( attributeValue instanceof String ) {
                        this.writeAttribute( props, externalId, name, (String) attributeValue );
                    }
                }
            }
        }

        List<SpiLink> links = callback.getLinks( );

        for ( SpiLink link : links ) {
            SpiAssociation association = link.get___Association( );
            SpiElement element0 = (SpiElement) callback.getElementAtLinkEnd( link, 0 );
            String externalId0 = (String) element0.get___AttributeValue( SimpleTestCustomParser.EXTERNAL_ID_ATTRIBUTE );
            SpiElement element1 = (SpiElement) callback.getElementAtLinkEnd( link, 1 );
            String externalId1 = (String) element1.get___AttributeValue( SimpleTestCustomParser.EXTERNAL_ID_ATTRIBUTE );

            props.setProperty( SimpleTestCustomParser.LINK_ID + SimpleTestCustomParser.SEPARATION_CHAR + this.getExternalTypeName( association.get___MofId( ) ) + SimpleTestCustomParser.SEPARATION_CHAR + externalId0 + SimpleTestCustomParser.SEPARATION_CHAR + externalId1, "" );
        }

        try {
            props.store( stream, "" );
        } catch ( IOException e ) {
            //
            e.printStackTrace( );
        }
    }

    private void writeAttribute( Properties props, String externalId, String name, String attributeValue ) {

        String key = SimpleTestCustomParser.ATTRIBUTE_ID + SimpleTestCustomParser.SEPARATION_CHAR + externalId + SimpleTestCustomParser.SEPARATION_CHAR + name;
        props.setProperty( key, attributeValue );

    }

    private void writeStructure( Properties props, String externalId, String name, SpiStructuredValue structureValue ) {

        StringBuffer attributeValue = new StringBuffer( );

        Collection<String> fieldNames = structureValue.get___FieldNames( );
        int i = fieldNames.size( );

        for ( String fieldName : fieldNames ) {
            attributeValue = attributeValue.append( fieldName ).append( SimpleTestCustomParser.FIELD_SEPARATION_CHAR ).append( structureValue.get___FieldValue( fieldName ) );
            i--;
            if ( i > 0 ) {
                attributeValue.append( SimpleTestCustomParser.SEPARATION_CHAR );
            }
        }

        String key = SimpleTestCustomParser.STRUCTURE_ID + SimpleTestCustomParser.SEPARATION_CHAR + externalId + SimpleTestCustomParser.SEPARATION_CHAR + name;
        props.setProperty( key, attributeValue.toString( ) );

    }

    private String getExternalTypeName( String mofId ) {

        for ( String typeName : SimpleTestCustomParser.metamodelClasses.keySet( ) ) {
            ExtentDescriptor descriptor = SimpleTestCustomParser.metamodelClasses.get( typeName );
            if ( ( descriptor != null ) && ( descriptor.getMofId( ).equals( mofId ) ) ) {
                return typeName;
            }
        }
        return null;
    }
}
