package com.sap.tc.moin.repository.core.cps.serializer.v1;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.cps.XmlHelper;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;

public class PartitionSerializerV1 implements SpiCustomSerializer {

    /**
     * Compares two partitionables by their MOF ids.
     */
    private static Comparator<SpiType> MOF_ID_COMPARATOR = new Comparator<SpiType>( ) {

        public int compare( SpiType o1, SpiType o2 ) {

            String s1 = o1.get___MofId( );
            String s2 = o2.get___MofId( );
            if ( s1 == s2 ) { // Both MOF ids are interned!
                return 0;
            }
            return s1.compareTo( s2 );
        }
    };

    /**
     * The model partition's data area descriptor.
     */
    private DataAreaDescriptor dataAreaOfPartition;

    /**
     * Maps the names of all used metamodel containers to their ID (ID = "1",
     * "2", "3", ...).
     */
    protected Map<String /* container name */, String /* container id */> containerIds;

    /**
     * Maps the names of all used metamodel containers to their versions (e.g.
     * "1.0.0").
     */
    protected Map<String /* container name */, String /* container id */> containerVersions;

    /**
     * Maps all meta objects used in the model partition to the name of the
     * metamodel container they come from.
     */
    protected Map<SpiType, String /* containerName */> usedMetaObjects;

    /**
     * Maps all meta objects used in the model partition to their (possibly
     * empty) list of object-valued attributes.
     */
    protected Map<SpiClass, List<String>> objectValuedAttributesOfMetaObjects;

    /**
     * The XmlHelper instance used by this PartitionWriter instance. It
     * encapsulates the writing to the stream, offering methods to write opening
     * tags, closing tags, character sequences etc.
     */
    protected XmlHelper xmlHelper;

    protected SpiSerializerCallback callback;

    protected List<SpiElement> elements;

    protected Map<SpiAssociation, List<SpiLink>> associationLinksGroupedByMetaObject;

    public PartitionSerializerV1( ) {

        xmlHelper = new XmlHelper( );
    }

    /**
     * This method is called by each <code>write</code> method prior to
     * serialization, mainly to initialize some internal data structures.
     */
    protected void init( SpiSerializerCallback cb ) {

        callback = cb;
        containerIds = new IdentityHashMap<String, String>( );
        containerVersions = new IdentityHashMap<String, String>( );
        dataAreaOfPartition = callback.getPri( ).getDataAreaDescriptor( );
        usedMetaObjects = new TreeMap<SpiType, String>( MOF_ID_COMPARATOR );
        objectValuedAttributesOfMetaObjects = new IdentityHashMap<SpiClass, List<String>>( );
    }

    /**
     * This method is called at the end of each <code>write</code> call, mainly
     * to clear some internal data structures for garbage collection purposes.
     */
    protected void cleanup( ) {

        callback = null;
        elements = null;
        dataAreaOfPartition = null;
        containerIds = null;
        containerVersions = null;
        usedMetaObjects = null;
        associationLinksGroupedByMetaObject = null;
        objectValuedAttributesOfMetaObjects = null;
    }

    public void serialize( OutputStream stream, SpiSerializerCallback cb ) throws IOException {

        init( cb );
        try {
            collectData( );
            xmlHelper.init( stream, PartitionConstants.ENCODING, estimateBufferSize( ) );
            writePreamble( );
            writeRootElement( );
            writeContainers( );
            writeMetaObjects( );
            writeModelElements( );
            writeLinks( );
            xmlHelper.endElement( PartitionConstants.ROOT );
        } catch ( RuntimeException ex ) {
            throw ex;
        } catch ( IOException ex ) {
            throw ex;
        } catch ( Exception ex ) {
            throw new IOException( ex );
        } finally {
            try {
                xmlHelper.flushStream( );
            } finally {
                cleanup( );
            }
        }
    }

    private static final int PREAMBLE_LENGTH = 100;

    private static final int CONTAINER_LINE_LENGTH = 70;

    private static final int META_OBJECT_LINE_LENGTH = 130;

    private static final int REF_OBJECT_LINE_LENGTH = 250;

    private static final int ASSOCIATION_LENGTH = 100;

    private static final int LINK_LINE_LENGTH = 150;

    /**
     * Use a heuristic to compute the maximum buffer size needed to write the
     * partition with only one file I/O.
     */
    private int estimateBufferSize( ) {

        int result = PREAMBLE_LENGTH;
        result += containerIds.size( ) * CONTAINER_LINE_LENGTH;
        result += usedMetaObjects.size( ) * META_OBJECT_LINE_LENGTH;
        result += elements.size( ) * REF_OBJECT_LINE_LENGTH;
        result += associationLinksGroupedByMetaObject.keySet( ).size( ) * ASSOCIATION_LENGTH;
        for ( List<SpiLink> linkCollection : associationLinksGroupedByMetaObject.values( ) ) {
            result += linkCollection.size( ) * LINK_LINE_LENGTH;
        }
        return result;
    }

    protected void collectData( ) {

        Set<String> usedContainers = new TreeSet<String>( );
        for ( SpiClass type : callback.getUsedClasses( ) ) {
            collectContainerAndMetaObjectInfo( type, usedContainers );
            // If the SpiClass has object-valued attributes, collect them.
            List<String> attributeNames = type.get___AttributeNames( );
            List<String> objectValuedAttributes = null;
            for ( int i = 0, n = attributeNames.size( ); i < n; i++ ) {
                String attributeName = attributeNames.get( i );
                if ( type.get___AttributeTypeAsEnum( attributeName ) == SpiValueTypeEnum.OBJECT_TYPED ) {
                    if ( objectValuedAttributes == null ) {
                        objectValuedAttributes = new ArrayList<String>( 4 );
                    }
                    objectValuedAttributes.add( attributeName );
                }
            }
            if ( objectValuedAttributes == null ) {
                objectValuedAttributes = Collections.emptyList( );
            }
            objectValuedAttributesOfMetaObjects.put( type, objectValuedAttributes );
        }
        for ( SpiAssociation type : callback.getUsedAssociations( ) ) {
            collectContainerAndMetaObjectInfo( type, usedContainers );
        }
        for ( SpiStructureType type : callback.getUsedStructureTypes( ) ) {
            collectContainerAndMetaObjectInfo( type, usedContainers );
        }
        int count = 1;
        for ( String containerName : usedContainers ) {
            containerIds.put( containerName, String.valueOf( count++ ) );
        }
        elements = (List<SpiElement>) callback.getElements( );
        associationLinksGroupedByMetaObject = callback.getLinksByAssociation( );
    }

    private void collectContainerAndMetaObjectInfo( SpiType type, Set<String> usedContainers ) {

        addUsedMetaObject( type );
        addContainer( usedContainers, type );
        List<SpiType> allSuperTypes = type.get___AllSuperTypes( );
        if ( !allSuperTypes.isEmpty( ) ) {
            for ( int i = 0, n = allSuperTypes.size( ); i < n; i++ ) {
                SpiType supertype = allSuperTypes.get( i );
                addContainer( usedContainers, supertype );
            }
        }
    }

    protected void addUsedMetaObject( SpiType type ) {

        if ( !( type instanceof SpiStructureType ) ) {
            // In version 1, do not produce meta-object tags (<M>) for used StructureTypes. 
            usedMetaObjects.put( type, type.get___MetamodelContainer( ) );
        }
    }

    private void addContainer( Set<String> usedContainers, SpiType type ) {

        String containerName = type.get___MetamodelContainer( );
        if ( usedContainers.add( containerName ) ) { // => first occurence of the containerName
            // Determine the version of the metamodel.
            String deployedMetaModelVersion = type.get___MetamodelVersion( );
            if ( deployedMetaModelVersion != null ) {
                containerVersions.put( containerName, deployedMetaModelVersion );
            }
        }
    }

    /**
     * Writes the XML preamble to the stream.
     */
    private void writePreamble( ) {

        xmlHelper.write( "<?xml version=\"1.0\" encoding=\"" + PartitionConstants.ENCODING + "\"?>" ); //$NON-NLS-1$//$NON-NLS-2$
        xmlHelper.writeln( );
    }

    protected void writeRootElement( ) {

        xmlHelper.startElement( PartitionConstants.ROOT );
        if ( !elements.isEmpty( ) ) {
            xmlHelper.addAttribute( PartitionConstants.XMLNS_PREFIX_MOIN, PartitionConstants.XMLNS_URI_MOIN, false /* replaceSpecialChars */);
        }
    }

    private void writeContainers( ) {

        Map<String, String> map = null;
        if ( containerIds.size( ) > 1 ) {
            map = new TreeMap<String, String>( containerIds ); // sort alphabetically
        } else {
            map = containerIds;
        }
        for ( Entry<String, String> entry : map.entrySet( ) ) {
            xmlHelper.startElement( getXmlTagOfContainer( ) );
            String containerName = entry.getKey( );
            xmlHelper.addAttribute( PartitionConstants.CONTAINER_NAME, containerName, false /* replaceSpecialChars */);
            xmlHelper.addAttribute( PartitionConstants.CONTAINER_ID, entry.getValue( ), false /* replaceSpecialChars */);
            String metamodelVersion = containerVersions.get( containerName );
            if ( metamodelVersion != null ) {
                xmlHelper.addAttribute( PartitionConstants.CONTAINER_VERSION, metamodelVersion, true /* replaceSpecialChars */);
            }
            xmlHelper.endElement( getXmlTagOfContainer( ) );
        }
    }

    protected String getXmlTagOfContainer( ) {

        return PartitionConstants.CONTAINER;
    }

    protected void writeMetaObjects( ) {

        for ( Entry<SpiType, String> entry : usedMetaObjects.entrySet( ) ) {
            xmlHelper.startElement( PartitionConstants.META_OBJECT );
            String containerId = containerIds.get( entry.getValue( ) );
            xmlHelper.addAttribute( PartitionConstants.META_OBJECT_CONTAINER_ID, containerId, false /* replaceSpecialChars */);
            SpiType type = entry.getKey( );
            xmlHelper.addAttribute( PartitionConstants.META_OBJECT_QNAME, type.get___QualifiedName( ), false /* replaceSpecialChars */);
            xmlHelper.addAttribute( PartitionConstants.META_OBJECT_MOF_ID, type.get___MofId( ), false /* replaceSpecialChars */);
            if ( type instanceof SpiClass ) {
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
            } else {
                // Must be an association.
                SpiAssociation association = (SpiAssociation) type;
                xmlHelper.addAttribute( PartitionConstants.ASSOCIATION_STORED_END, String.valueOf( association.get___StoredEndNumber( ) ), false /* replaceSpecialChars */);
                xmlHelper.addAttribute( PartitionConstants.ASSOCIATION_COMPOSITE_END, String.valueOf( association.get___CompositeEndNumber( ) ), false /* replaceSpecialChars */);
                xmlHelper.addAttribute( PartitionConstants.ASSOCIATION_ORDERED_END, String.valueOf( association.get___OrderedEndNumber( ) ), false /* replaceSpecialChars */);
            }
            xmlHelper.endElement( PartitionConstants.META_OBJECT );
        }
    }

    private void writeModelElements( ) {

        for ( int i = 0, n = elements.size( ); i < n; i++ ) {
            SpiElement element = elements.get( i );
            SpiClass type = element.get___Type( );
            String tagName = type.get___QualifiedName( );
            xmlHelper.startElement( tagName );
            xmlHelper.addAttribute( PartitionConstants.CONTAINER_ID_OF_ELEMENT, containerIds.get( type.get___MetamodelContainer( ) ), false /* replaceSpecialChars */);
            xmlHelper.addAttribute( PartitionConstants.MOF_ID, element.get___MofId( ), false /* replaceSpecialChars */);
            writeXmlAttributesOfElement( type, element );
            xmlHelper.endElement( tagName );
        }
    }

    private void writeLinks( ) {

        for ( Entry<SpiAssociation, List<SpiLink>> entry : associationLinksGroupedByMetaObject.entrySet( ) ) {
            SpiAssociation association = entry.getKey( );
            String tagName = association.get___QualifiedName( );
            xmlHelper.startElement( tagName );
            xmlHelper.addAttribute( PartitionConstants.META_OBJECT_CONTAINER_ID, containerIds.get( association.get___MetamodelContainer( ) ), false /* replaceSpecialChars */);
            List<SpiLink> links = entry.getValue( );
            for ( int i = 0, n = links.size( ); i < n; i++ ) {
                SpiLink link = links.get( i );
                xmlHelper.startElement( PartitionConstants.LINK );
                xmlHelper.addAttribute( PartitionConstants.LINK_FIRST_END, getLinkEndString( callback.getElementAtLinkEnd( link, 0 ) ), false /* replaceSpecialChars */);
                xmlHelper.addAttribute( PartitionConstants.LINK_SECOND_END, getLinkEndString( callback.getElementAtLinkEnd( link, 1 ) ), false /* replaceSpecialChars */);
                xmlHelper.endElement( PartitionConstants.LINK );
            }
            xmlHelper.endElement( tagName );
        }
    }

    private String getLinkEndString( Object elementAtEnd ) {

        if ( elementAtEnd instanceof SpiElement ) {
            return ( (SpiElement) elementAtEnd ).get___MofId( );
        }
        // Not an SpiElement => must be a LRI of some external element
        LRI lri = (LRI) elementAtEnd;
        if ( dataAreaOfPartition.equals( lri.getDataAreaDescriptor( ) ) ) {
            return PartitionConstants.LOCAL_DATA_AREA_PREFIX + lri.getMofId( );
        }
        return lri.toString( );
    }

    @SuppressWarnings( "unchecked" )
    private void writeXmlAttributesOfElement( SpiClass type, SpiElement element ) {

        Map<String, Object> attrsInContent = null;
        Collection<String> attributeNames = type.get___AttributeNames( );
        for ( String attributeName : attributeNames ) {
            SpiValueTypeEnum attributeType = type.get___AttributeTypeAsEnum( attributeName );
            boolean multiValued = type.is___MultiValuedAttribute( attributeName );
            Object value = element.get___AttributeValue( attributeName );
            if ( value == null ) {
                // optional attribute with no value
                continue;
            }
            Object valueToWrite = value;
            if ( multiValued ) {
                Collection col = null;
                if ( value instanceof Collection ) {
                    col = (Collection) value;
                } else {
                    col = new ArrayList( 1 );
                    col.add( value );
                }
                int size = col.size( );
                if ( size == 0 ) {
                    continue;
                }
                if ( size > 1 ) {
                    // values have to be serialized in content
                    if ( attrsInContent == null ) {
                        attrsInContent = new LinkedHashMap<String, Object>( );
                    }
                    attrsInContent.put( attributeName, value );
                    continue;
                }
                // We have a collection with exactly one entry. We serialize it as an XML attribute.
                valueToWrite = col.iterator( ).next( );
            }
            if ( attributeType == SpiValueTypeEnum.STRUCTURE_TYPE ) {
                // Structures are always serialized as sub-elements later on (see below), independent of the attribute's 
                // multiplicity.
                if ( attrsInContent == null ) {
                    attrsInContent = new LinkedHashMap<String, Object>( );
                }
                attrsInContent.put( attributeName, value );
            } else {
                writeValueInAttr( type, attributeName, attributeType, valueToWrite );
            }
        }
        if ( attrsInContent != null ) {
            for ( Entry<String, Object> entry : attrsInContent.entrySet( ) ) {
                writeValueInContent( type, entry.getKey( ), type.get___AttributeTypeAsEnum( entry.getKey( ) ), entry.getValue( ) );
            }
        }
    }

    /**
     * Serializes an attribute's value of Primitive or Enumeration type as a
     * normal XML attribute.
     */
    private void writeValueInAttr( SpiClass elementType, String attributeName, SpiValueTypeEnum attributeType, Object value ) {

        if ( attributeType == SpiValueTypeEnum.OBJECT_TYPED ) {
            // The value of an object-valued attribute is always passed to this method as a LRI.
            xmlHelper.addAttribute( attributeName, getAttributeLinkEndString( value, elementType.get___AttributeMofId( attributeName ) ), false /* replaceSpecialChars */);
        } else {
            boolean typeIsString = ( attributeType == SpiValueTypeEnum.PRIMITIVE_TYPE_STRING );
            xmlHelper.addAttribute( attributeName, value.toString( ), typeIsString /* replaceSpecialChars */);
        }
    }

    private String getAttributeLinkEndString( Object value, String mofIdOfAttribute ) {

        if ( value instanceof SpiElement ) {
            return ( (SpiElement) value ).get___MofId( );
        }
        // Not an SpiElement => must be a LRI of some external element
        LRI lri = (LRI) value;
        if ( dataAreaOfPartition.equals( lri.getDataAreaDescriptor( ) ) ) {
            return PartitionConstants.LOCAL_DATA_AREA_PREFIX + lri.getMofId( ) + PartitionConstants.OBJECT_VALUED_ATTRIBUTE_SEPARATOR + mofIdOfAttribute;
        }
        return lri.toString( ) + PartitionConstants.OBJECT_VALUED_ATTRIBUTE_SEPARATOR + mofIdOfAttribute;
    }

    @SuppressWarnings( "unchecked" )
    private void writeValueInContent( SpiClass elementType, String attributeName, SpiValueTypeEnum attributeType, Object value ) {

        if ( value == null ) {
            // No value is set => nothing to serialize.
            return;
        }
        // Determine the collection of values (possibly containing one entry only).
        Collection values;
        List valuesAsList = null;
        if ( elementType.is___MultiValuedAttribute( attributeName ) ) {
            values = (Collection) value;
            valuesAsList = ( value instanceof RandomAccess ? (List) value : null );
        } else {
            values = valuesAsList = new ArrayList( );
            values.add( value );
        }
        if ( attributeType == SpiValueTypeEnum.STRUCTURE_TYPE ) {
            if ( valuesAsList != null ) {
                for ( int i = 0, n = valuesAsList.size( ); i < n; i++ ) {
                    writeSingleStructuredValue( attributeName, (SpiStructuredValue) valuesAsList.get( i ) );
                }
            } else {
                for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                    writeSingleStructuredValue( attributeName, (SpiStructuredValue) it.next( ) );
                }
            }
        } else if ( attributeType == SpiValueTypeEnum.ENUMERATION_TYPE ) {
            // EnumerationType values are serialized in the content of the surrounding element (as opposed to
            // normal XML attributes), if and only if they are multi-valued and contain more than one value.
            if ( valuesAsList != null ) {
                for ( int i = 0, n = valuesAsList.size( ); i < n; i++ ) {
                    writeSingleEnumValue( attributeName, valuesAsList.get( i ).toString( ) );
                }
            } else {
                for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                    writeSingleEnumValue( attributeName, it.next( ).toString( ) );
                }
            }
        } else if ( attributeType == SpiValueTypeEnum.OBJECT_TYPED ) {
            for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                writeSingleObjectValuedAttribute( attributeName, it.next( ), elementType.get___AttributeMofId( attributeName ) );
            }
        } else {
            // Must be a PrimitiveType. PrimitiveType values are serialized in the content of the surrounding element 
            // (as opposed to normal XML attributes), if and only if they are multi-valued and contain more than one value.
            boolean typeIsString = ( attributeType == SpiValueTypeEnum.PRIMITIVE_TYPE_STRING );
            if ( valuesAsList != null ) {
                for ( int i = 0, n = valuesAsList.size( ); i < n; i++ ) {
                    writeSinglePrimitiveValue( attributeName, valuesAsList.get( i ).toString( ), typeIsString );
                }
            } else {
                for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                    writeSinglePrimitiveValue( attributeName, it.next( ).toString( ), typeIsString );
                }
            }
        }
    }

    private void writeSingleObjectValuedAttribute( String tagName, Object value, String mofIdOfAttribute ) {

        xmlHelper.startElement( tagName );
        xmlHelper.addAttribute( PartitionConstants.VALUE, getAttributeLinkEndString( value, mofIdOfAttribute ), false /* replaceSpecialChars */);
        xmlHelper.endElement( tagName );
    }

    private void writeSingleEnumValue( String tagName, String value ) {

        xmlHelper.startElement( tagName );
        xmlHelper.addAttribute( PartitionConstants.VALUE, value, false /* replaceSpecialChars */);
        xmlHelper.endElement( tagName );
    }

    private void writeSinglePrimitiveValue( String tagName, String value, boolean typeIsString ) {

        xmlHelper.startElement( tagName );
        xmlHelper.addAttribute( PartitionConstants.VALUE, value, typeIsString /* replaceSpecialChars */);
        xmlHelper.endElement( tagName );
    }

    protected void writeSingleStructuredValue( String tagName, SpiStructuredValue structuredValue ) {

        xmlHelper.startElement( tagName );
        writeStructuredValue( structuredValue, null /* enclosingField */);
        xmlHelper.endElement( tagName );
    }

    protected void writeStructuredValue( SpiStructuredValue structuredValue, String enclosingField ) {

        List<String> fieldNames = (List<String>) structuredValue.get___FieldNames( );
        for ( int i = 0, n = fieldNames.size( ); i < n; i++ ) {
            String fieldName = fieldNames.get( i );
            Object fieldValue = structuredValue.get___FieldValue( fieldName );
            if ( fieldValue == null ) {
                continue;
            }
            if ( fieldValue instanceof SpiStructuredValue ) {
                if ( enclosingField != null ) {
                    writeStructuredValue( (SpiStructuredValue) fieldValue, enclosingField + "." + fieldName ); //$NON-NLS-1$
                } else {
                    writeStructuredValue( (SpiStructuredValue) fieldValue, fieldName );
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
