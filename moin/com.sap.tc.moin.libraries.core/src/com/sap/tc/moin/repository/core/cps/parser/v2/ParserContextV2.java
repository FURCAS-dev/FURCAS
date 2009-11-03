package com.sap.tc.moin.repository.core.cps.parser.v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.cps.parser.v1.ParserContextV1;
import com.sap.tc.moin.repository.core.cps.serializer.v2.PartitionConstants;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;

public final class ParserContextV2 extends ParserContextV1 {

    public ParserContextV2( SpiParserCallback callback ) {

        super( callback );
    }

    @Override
    public void addMetaObject( String qName, Attributes attributes ) {

        String containerId = intern( attributes.getValue( 0 ) );
        String qualifiedName = attributes.getValue( 1 );
        String mofId = attributes.getValue( 2 );
        String containerName = containers.get( containerId );
        SpiType type = null;
        String ovas = null;
        if ( qName.equals( PartitionConstants.META_OBJECT_CLASS ) ) {
            type = callback.getClass( mofId, containerName, qualifiedName );
            ovas = attributes.getValue( OBJECT_VALUED_ATTRIBUTES ); // look for object-valued attributes info
        } else if ( qName.equals( PartitionConstants.META_OBJECT_ASSOCIATION ) ) {
            type = callback.getAssociation( mofId, containerName, qualifiedName );
        } else if ( qName.equals( PartitionConstants.META_OBJECT_STRUCTURETYPE ) ) {
            type = callback.getStructureType( mofId, containerName, qualifiedName );
        }
        if ( type != null ) {
            // We successfully resolved the type. Note that the MOF-ID or qualified name can now be different 
            // from those found in the file (-> metamodel evolution)!
            Map<String, SpiType> mapping = usedMetaObjects.get( containerId );
            if ( mapping == null ) {
                usedMetaObjects.put( containerId, mapping = new HashMap<String, SpiType>( ) );
            }
            mapping.put( qualifiedName, type );
            if ( ovas != null ) {
                String objectValuedAttributes = attributes.getValue( OBJECT_VALUED_ATTRIBUTES ); // look for object-valued attributes info
                if ( objectValuedAttributes != null ) {
                    String[] attrNames = split( objectValuedAttributes, ',' );
                    objectValuedAttributesOfMofClass.put( type, new HashSet<String>( Arrays.asList( attrNames ) ) );
                }
            }
        }
    }

    @Override
    protected boolean isObjectValuedAttribute( SpiClass mofClass, String attributeName, Object attributeValue ) {

        // The header of the partition format version 2 contains information about all object-valued attributes 
        // of a MofClass ('ova' attribute of <C> element).
        if ( !objectValuedAttributesOfMofClass.isEmpty( ) ) {
            Set<String> ovas = objectValuedAttributesOfMofClass.get( mofClass );
            if ( ovas != null ) {
                return ovas.contains( attributeName );
            }
            return false;
        }
        return false;
    }
}