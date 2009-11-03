package com.sap.tc.moin.repository.core.cps.parser.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.cps.parser.ParserContext;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;

public class ParserContextV1 extends ParserContext {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CPS, ParserContextV1.class );

    protected static final char DATA_AREA_SEPARATOR = ':';

    protected static final String OBJECT_VALUED_ATTRIBUTES = "ova"; //$NON-NLS-1$

    protected static final String STORED_END = "se"; //$NON-NLS-1$

    protected static final char OBJECT_VALUED_ATTRIBUTE_SEPARATOR = '@';

    protected static final String META_MODEL_DATA_AREA_NAME = "MetaModelDataArea"; //$NON-NLS-1$

    protected final SpiParserCallback callback;

    protected Map<String /* container id */, String /* container name */> containers;

    protected Map<String /* MOF ID */, SpiElement> modelElements;

    protected Map<SpiType, Set<String /* name of ova */>> objectValuedAttributesOfMofClass;

    protected Map<SpiElement, Map<String, Object>> unresolvedObjectValuedAttributesPerElement;

    protected Map<String /* container id */, Map<String /* qualified name */, SpiType>> usedMetaObjects;

    /**
     * The partition header changed over time, especially the attribute 'ova'
     * was introduced later. Since the information about all object-valued
     * attributes of a MofClass is essential for correct parsing using CP/S, we
     * try to derive from the header whether this information is included, based
     * on the knowledge how exactly the partition header evolved. We definitely
     * know that info about ovas is included if we either encounter an 'ova'
     * attribute, or an 'se' attribute ("stored end" of an association), which
     * was introduced after the 'ova' property.
     */
    private boolean headerContainsObjectValuedAttributesInfo;

    private boolean missingOvaInfoTraced;

    public ParserContextV1( SpiParserCallback cb ) {

        callback = cb;
        containers = new IdentityHashMap<String, String>( );
        modelElements = new IdentityHashMap<String, SpiElement>( );
        usedMetaObjects = new IdentityHashMap<String, Map<String, SpiType>>( );
        objectValuedAttributesOfMofClass = new IdentityHashMap<SpiType, Set<String>>( );
        headerContainsObjectValuedAttributesInfo = false;
        missingOvaInfoTraced = false;
    }

    @Override
    public void addContainer( String containerName, String containerId, String version ) {

        containers.put( intern( containerId ), containerName );
        callback.notifyOnUsedMetamodel( containerName, version );
    }

    @Override
    public void addMetaObject( String qName, Attributes attributes ) {

        String containerId = attributes.getValue( 0 );
        String qualifiedName = attributes.getValue( 1 );
        String mofId = attributes.getValue( 2 );
        String key = intern( containerId );
        String containerName = containers.get( key );
        SpiType type = callback.getType( mofId, containerName, qualifiedName );
        if ( type != null ) {
            // We successfully resolved the type. Note that the MOF-ID or qualified name can now be different 
            // from those supplied in the file (-> metamodel evolution)!
            Map<String, SpiType> mapping = usedMetaObjects.get( key );
            if ( mapping == null ) {
                usedMetaObjects.put( key, mapping = new HashMap<String, SpiType>( ) );
            }
            mapping.put( qualifiedName, type );
            String objectValuedAttributes = attributes.getValue( OBJECT_VALUED_ATTRIBUTES ); // look for object-valued attributes info
            if ( objectValuedAttributes != null ) {
                String[] attrNames = split( objectValuedAttributes, ',' );
                objectValuedAttributesOfMofClass.put( type, new HashSet<String>( Arrays.asList( attrNames ) ) );
                headerContainsObjectValuedAttributesInfo = true;
            } else if ( type instanceof SpiAssociation ) {
                if ( attributes.getValue( STORED_END ) != null ) {
                    headerContainsObjectValuedAttributesInfo = true;
                }
            }
        }
    }

    @Override
    public SpiElement addElement( String containerId, String qualifiedName, String mofId ) {

        SpiType mofClass = getType( containerId, qualifiedName );
        if ( mofClass instanceof SpiClass ) {
            SpiElement element = callback.addElement( (SpiClass) mofClass, mofId );
            modelElements.put( intern( mofId ), element );
            return element;
        }
        return null;
    }

    @Override
    public void addLink( SpiAssociation association, String firstEnd, String secondEnd ) {

        boolean firstInPartition = ( firstEnd.indexOf( DATA_AREA_SEPARATOR ) == -1 );
        boolean secondInPartition = ( secondEnd.indexOf( DATA_AREA_SEPARATOR ) == -1 );
        if ( firstInPartition && secondInPartition ) {
            SpiElement first = modelElements.get( intern( firstEnd ) );
            SpiElement second = modelElements.get( intern( secondEnd ) );
            if ( first != null && second != null ) {
                callback.addLink( association, first, second );
            }
        } else if ( firstInPartition && !secondInPartition ) {
            SpiElement first = modelElements.get( intern( firstEnd ) );
            if ( first != null ) {
                callback.addLink( association, first, getLri( secondEnd ) );
            }
        } else if ( !firstInPartition && secondInPartition ) {
            SpiElement second = modelElements.get( intern( secondEnd ) );
            if ( second != null ) {
                callback.addLink( association, getLri( firstEnd ), second );
            }
        }
    }

    private LRI getLri( String lriString ) {

        DataAreaDescriptor dataAreaDescriptor = callback.getPri( ).getDataAreaDescriptor( );
        String facilityId = dataAreaDescriptor.getFacilityId( );
        String dataAreaName = null;
        if ( lriString.startsWith( "local:" ) ) { //$NON-NLS-1$
            dataAreaName = dataAreaDescriptor.getDataAreaName( );
        } else {
            dataAreaName = META_MODEL_DATA_AREA_NAME;
        }
        String mofId = lriString.substring( lriString.indexOf( DATA_AREA_SEPARATOR ) + 1 );
        return callback.createLri( facilityId, dataAreaName, mofId );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public void parsingFinished( ) {

        if ( unresolvedObjectValuedAttributesPerElement != null ) {
            for ( Entry<SpiElement, Map<String, Object>> entry : unresolvedObjectValuedAttributesPerElement.entrySet( ) ) {
                SpiElement element = entry.getKey( );
                for ( Entry<String, Object> entry2 : entry.getValue( ).entrySet( ) ) {
                    String attributeName = entry2.getKey( );
                    Object attributeValue = entry2.getValue( );
                    if ( attributeValue instanceof List ) {
                        List list = (List) attributeValue;
                        for ( Iterator<String> it = list.iterator( ); it.hasNext( ); ) {
                            String mofId = intern( it.next( ) );
                            element.add___ElementValue( attributeName, modelElements.get( mofId ) );
                        }
                    } else {
                        String mofId = intern( ( (String) attributeValue ) );
                        element.add___ElementValue( attributeName, modelElements.get( mofId ) );
                    }
                }
            }
        }
    }

    @Override
    public void addAttributeValue( SpiElement element, String attributeName, Object attributeValue ) {

        if ( isObjectValuedAttribute( element.get___Type( ), attributeName, attributeValue ) ) {
            // We can only set an object-valued attribute if the SpiElement with the MOF-ID in 'attributeValue' is already
            // known. Otherwise, we need to postpone the setting of the attribute.
            String value = (String) attributeValue;
            int ovaSeparatorPos = value.indexOf( OBJECT_VALUED_ATTRIBUTE_SEPARATOR );
            if ( ovaSeparatorPos != -1 ) {
                // The attribute value is in a different partition => add it now via addExternalElementValue().
                String lriString = value.substring( 0, ovaSeparatorPos );
                element.add___ExternalElementValue( attributeName, getLri( lriString ) );
            } else {
                // The attribute value must be in this partition.
                String mofId = intern( value );
                SpiElement otherElement = modelElements.get( mofId );
                if ( otherElement != null ) {
                    // The other element has already been parsed => add it now via addElementValue().
                    element.add___ElementValue( attributeName, otherElement );
                } else {
                    // The other element is in this partition, but has not been parsed yet => store it for later processing.
                    addUnresolvedObjectValuedAttribute( element, attributeName, value );
                }
            }
        } else {
            if ( attributeValue instanceof SpiStructuredValue ) {
                element.add___StructuredValue( attributeName, (SpiStructuredValue) attributeValue );
            } else {
                // Must be a String value for a primitive/enumeration typed attribute.
                String value = (String) attributeValue;
                element.add___PrimitiveOrEnumerationValue( attributeName, value );
            }
        }
    }

    @Override
    public SpiType getType( String containerId, String qualifiedName ) {

        String _containerId = intern( containerId );
        Map<String, SpiType> map = usedMetaObjects.get( _containerId );
        if ( map != null ) {
            return map.get( qualifiedName );
        }
        return null;
    }

    @Override
    public SpiStructuredValue createStructuredValue( ) {

        return callback.createStructuredValue( );
    }

    @Override
    public SpiStructuredValue createStructuredValue( SpiStructureType structureType ) {

        return ( structureType != null ? callback.createStructuredValue( structureType ) : callback.createStructuredValue( ) );
    }

    protected boolean isObjectValuedAttribute( SpiClass mofClass, String attributeName, Object attributeValue ) {

        // The header of the partition format of newly written partitions contains information about all
        // object-valued attributes of a MofClass ('ova' attribute). Unfortunately this info was added later on,
        // so there might be partitions out there not containing this info, which is essential for the error handler
        // functionality of CP/S.
        if ( headerContainsObjectValuedAttributesInfo ) {
            if ( !objectValuedAttributesOfMofClass.isEmpty( ) ) {
                Set<String> ovas = objectValuedAttributesOfMofClass.get( mofClass );
                if ( ovas != null ) {
                    return ovas.contains( attributeName );
                }
                return false;
            }
            return false;
        }
        // If we are here the partition was probably (but not necessarily) written with an older version of MOIN. 
        // It is not clear whether the header contains information about all object-valued attributes of MofClasses.
        // What we need to know is whether the attribute was object-valued at the time the partition was written.
        // Reconstructing this information is only possible by looking at the attribute value, and finding out
        // whether it is a String representing either a MOF-ID or an external LRI in "LRI@ATTRIBUTE_MOF_ID" notation.
        // Note that the following code is very hacky, and won't work with MOF-IDs from foreign facilities. Also,
        // if some metamodel has modeled an attribute of type String, containing our MOF-IDs, the attribute will
        // erroneously be reported as being object-valued.
        // The only other possibility to derive the ova info would be to look at the CURRENT metamodel, which might 
        // be wrong if the metamodel has evolved incompatibly in the meantime (e.g. attribute type changed from 
        // MofClass to StructureType).
        boolean result = isValueOfObjectValuedAttribute( attributeValue );
        if ( result ) {
            if ( !missingOvaInfoTraced && LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                LOGGER.trace( MoinSeverity.ERROR, "Encountered MOIN partition file without object-valued attribute info in header (PRI: " + callback.getPri( ) + "); to fix this error message the partition has to be loaded and saved with a current MOIN" ); //$NON-NLS-1$ //$NON-NLS-2$
                missingOvaInfoTraced = true; // only trace this once per partition
            }
        }
        return result;
    }

    //
    // <BEGIN HACK>
    //

    private static final int MOF_ID_LENGTH = 40;

    private boolean isValueOfObjectValuedAttribute( Object attributeValue ) {

        int pos = -1;
        if ( attributeValue instanceof String ) {
            String value = (String) attributeValue;
            if ( value.length( ) == MOF_ID_LENGTH ) {
                for ( int i = 0; i < MOF_ID_LENGTH; i++ ) {
                    char c = value.charAt( i );
                    if ( !( ( c >= '0' && c <= '9' ) || ( c >= 'A' && c <= 'F' ) ) ) {
                        return false;
                    }
                }
                return true;
            } else if ( ( pos = value.indexOf( OBJECT_VALUED_ATTRIBUTE_SEPARATOR ) ) != -1 ) {
                String attributeMofId = value.substring( pos + 1 );
                if ( attributeMofId.length( ) == MOF_ID_LENGTH ) {
                    for ( int i = 0; i < MOF_ID_LENGTH; i++ ) {
                        char c = attributeMofId.charAt( i );
                        if ( !( ( c >= '0' && c <= '9' ) || ( c >= 'A' && c <= 'F' ) ) ) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //
    // <END HACK>
    //

    @SuppressWarnings( "unchecked" )
    private void addUnresolvedObjectValuedAttribute( SpiElement element, String attributeName, String attributeValue ) {

        if ( unresolvedObjectValuedAttributesPerElement == null ) {
            unresolvedObjectValuedAttributesPerElement = new IdentityHashMap<SpiElement, Map<String, Object>>( );
        }
        Map<String, Object> unresolvedValues = unresolvedObjectValuedAttributesPerElement.get( element );
        if ( unresolvedValues == null ) {
            unresolvedObjectValuedAttributesPerElement.put( element, unresolvedValues = new HashMap<String, Object>( ) );
        }
        Object value = unresolvedValues.get( attributeName );
        if ( value == null ) {
            unresolvedValues.put( attributeName, attributeValue );
        } else if ( value instanceof List ) {
            ( (List) value ).add( attributeValue );
        } else {
            List list = new ArrayList( );
            list.add( value );
            list.add( attributeValue );
            unresolvedValues.put( attributeName, list );
        }
    }

    protected static final String[] split( String aString, char aSeparator ) {

        int lastIndex = 0;
        int nextIndex = 0;
        int tokenCount = 0;

        // First count the number of occurences of the separator string
        for ( int i = aString.length( ) - 1; i >= 0; --i ) {
            if ( aString.charAt( i ) == aSeparator ) {
                ++tokenCount;
            }
        }

        // if the separator did not occur in the string at all the original string
        // is the only entry in the result array
        if ( 0 == tokenCount ) {
            return new String[] { aString };
        }

        // More than one token, create the array of appropriate size
        String[] tokenArray = new String[tokenCount + 1];

        // And begin again to search for the tokens
        lastIndex = 0;
        tokenCount = 0;
        nextIndex = aString.indexOf( aSeparator );
        while ( nextIndex != -1 ) {
            tokenArray[tokenCount++] = aString.substring( lastIndex, nextIndex );
            lastIndex = nextIndex + 1;
            nextIndex = aString.indexOf( aSeparator, lastIndex );
        }

        // Copy the rest
        tokenArray[tokenCount] = aString.substring( lastIndex );
        return tokenArray;
    }
}