package com.sap.tc.moin.repository.core.cps.serializer.v2;

import java.util.List;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.core.cps.serializer.v1.PartitionSerializerV1;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.util.SpiMutableInteger;

/**
 * Changes in version 2:
 * <p>
 * <ul>
 * <li>'version' attribute added to 'Partition' element</li>
 * <li>Metamodel containers are serialized as 'MM' elements (instead of 'C')</li>
 * <li>Meta objects are serialized as either 'C' (classes), 'A' (associations)
 * or 'S' (StructureTypes) elements, instead of the old 'M' element</li>
 * <li>For all StructureTypes with instances (RefStructs) in the partition, a
 * corresponding meta object element is serialized (see previous list item)</li>
 * <li>All RefStruct instances now carry the qualified name of their type in the
 * new 'm:t' attribute and the container id of their type in the new 'm:c'
 * attribute</li>
 * </ul>
 */
public final class PartitionSerializerV2 extends PartitionSerializerV1 {

    private static final String PARTITION_FORMAT_VERSION = "2"; //$NON-NLS-1$

    public PartitionSerializerV2( ) {

    }

    @Override
    protected final void writeRootElement( ) {

        xmlHelper.startElement( PartitionConstants.ROOT );
        if ( !elements.isEmpty( ) ) {
            xmlHelper.addAttribute( PartitionConstants.XMLNS_PREFIX_MOIN, PartitionConstants.XMLNS_URI_MOIN, false /* replaceSpecialChars */);
            xmlHelper.addAttribute( PartitionConstants.VERSION, PARTITION_FORMAT_VERSION, false /* replaceSpecialChars */);
        }
    }

    @Override
    protected final void addUsedMetaObject( SpiType type ) {

        // In version 2, *all* meta-object tags (<C>, <A>, <S>) must be written (i.e. including StructureTypes).
        usedMetaObjects.put( type, type.get___MetamodelContainer( ) );
    }

    @Override
    protected final String getXmlTagOfContainer( ) {

        return PartitionConstants.METAMODEL;
    }

    @Override
    protected final void writeMetaObjects( ) {

        for ( Entry<SpiType, String> entry : usedMetaObjects.entrySet( ) ) {
            SpiType type = entry.getKey( );
            String tagName = null;
            if ( type instanceof SpiClass ) {
                tagName = PartitionConstants.META_OBJECT_CLASS;
            } else if ( type instanceof SpiAssociation ) {
                tagName = PartitionConstants.META_OBJECT_ASSOCIATION;
            } else {
                tagName = PartitionConstants.META_OBJECT_STRUCTURETYPE;
            }
            xmlHelper.startElement( tagName );
            String containerId = containerIds.get( entry.getValue( ) );
            xmlHelper.addAttribute( PartitionConstants.META_OBJECT_CONTAINER_ID, containerId, false /* replaceSpecialChars */);
            xmlHelper.addAttribute( PartitionConstants.META_OBJECT_QNAME, type.get___QualifiedName( ), false /* replaceSpecialChars */);
            xmlHelper.addAttribute( PartitionConstants.META_OBJECT_MOF_ID, type.get___MofId( ), false /* replaceSpecialChars */);
            if ( tagName == PartitionConstants.META_OBJECT_CLASS ) {
                List<String> objectValuedAttrs = objectValuedAttributesOfMetaObjects.get( type );
                if ( !objectValuedAttrs.isEmpty( ) ) {
                    StringBuilder sb = new StringBuilder( );
                    for ( int i = 0, n = objectValuedAttrs.size( ); i < n; i++ ) {
                        sb.append( objectValuedAttrs.get( i ) );
                        if ( i < n - 1 ) {
                            sb.append( ',' );
                        }
                    }
                    xmlHelper.addAttribute( PartitionConstants.META_OBJECT_OBJECT_VALUED_ATTRIBUTES, sb.toString( ), false /* replaceSpecialChars */);
                }
            } else if ( tagName == PartitionConstants.META_OBJECT_ASSOCIATION ) {
                SpiAssociation association = (SpiAssociation) type;
                xmlHelper.addAttribute( PartitionConstants.ASSOCIATION_STORED_END, String.valueOf( association.get___StoredEndNumber( ) ), false /* replaceSpecialChars */);
                xmlHelper.addAttribute( PartitionConstants.ASSOCIATION_COMPOSITE_END, String.valueOf( association.get___CompositeEndNumber( ) ), false /* replaceSpecialChars */);
                xmlHelper.addAttribute( PartitionConstants.ASSOCIATION_ORDERED_END, String.valueOf( association.get___OrderedEndNumber( ) ), false /* replaceSpecialChars */);
            }
            // else { Must be a StructureType, no additional header information for now.
            // }
            xmlHelper.endElement( tagName );
        }
    }

    @Override
    protected final void writeSingleStructuredValue( String tagName, SpiStructuredValue structuredValue ) {

        xmlHelper.startElement( tagName );
        SpiStructureType structureType = structuredValue.get___Type( );
        xmlHelper.addAttribute( PartitionConstants.TYPE, structureType.get___QualifiedName( ), false /* replaceSpecialChars */);
        xmlHelper.addAttribute( PartitionConstants.CONTAINER_ID_OF_STRUCTURETYPE, containerIds.get( structureType.get___MetamodelContainer( ) ), false /* replaceSpecialChars */);
        writeStructuredValue( structuredValue, null /* enclosingField */, new SpiMutableInteger( 1 ) );
        xmlHelper.endElement( tagName );
    }

    private void writeStructuredValue( SpiStructuredValue structuredValue, String enclosingField, SpiMutableInteger structureTypeCounter ) {

        if ( enclosingField != null ) {
            SpiStructureType structureType = structuredValue.get___Type( );
            xmlHelper.addAttribute( PartitionConstants.TYPE + structureTypeCounter, structureType.get___QualifiedName( ), false /* replaceSpecialChars */);
            xmlHelper.addAttribute( PartitionConstants.CONTAINER_ID_OF_STRUCTURETYPE + structureTypeCounter, containerIds.get( structureType.get___MetamodelContainer( ) ), false /* replaceSpecialChars */);
        }
        List<String> fieldNames = (List<String>) structuredValue.get___FieldNames( );
        for ( int i = 0, n = fieldNames.size( ); i < n; i++ ) {
            String fieldName = fieldNames.get( i );
            Object fieldValue = structuredValue.get___FieldValue( fieldName );
            if ( fieldValue == null ) {
                continue;
            }
            if ( fieldValue instanceof SpiStructuredValue ) {
                structureTypeCounter.increment( );
                if ( enclosingField != null ) {
                    writeStructuredValue( (SpiStructuredValue) fieldValue, enclosingField + "." + fieldName, structureTypeCounter ); //$NON-NLS-1$
                } else {
                    writeStructuredValue( (SpiStructuredValue) fieldValue, fieldName, structureTypeCounter );
                }
            } else {
                // fieldValue must be a String
                String value = (String) fieldValue;
                if ( enclosingField != null ) {
                    xmlHelper.addAttribute( enclosingField + "." + fieldName, value, true /* replaceSpecialChars */); //$NON-NLS-1$
                } else {
                    xmlHelper.addAttribute( fieldName, value, true /* replaceSpecialChars */);
                }
            }
        }
    }
}