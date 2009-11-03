package com.sap.tc.moin.repository.cps.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ExtentDescriptor;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;
import com.sap.tc.moin.testcases.case017.Composition;
import com.sap.tc.moin.testcases.case025.B25;
import com.sap.tc.moin.testcases.case025.C25;
import com.sap.tc.moin.testcases.case025.D25;

/**
 * Test custom parser based on properties. The parser is stateless.
 * 
 * @author d026715
 */

public class SimpleTestCustomParser implements SpiCustomParser {

    public static final String SEPARATION_CHAR = "|";

    public static final String FIELD_SEPARATION_CHAR = ":";

    private static final String ESCAPED_SEPARATION_CHAR = "\\|";

    public static final String EXTERNAL_ID_ATTRIBUTE = "externalId";

    public static final String ELEMENT_ID = "Element";

    public static final String LINK_ID = "Link";

    public static final String ATTRIBUTE_ID = "Attribute";

    public static final String STRUCTURE_ID = "Structure";

    public static final HashMap<String, ExtentDescriptor> metamodelClasses = new HashMap<String, ExtentDescriptor>( );


    static {

        metamodelClasses.put( "A17", C25.CLASS_DESCRIPTOR );
        metamodelClasses.put( "A4", B25.CLASS_DESCRIPTOR );
        metamodelClasses.put( "A8", D25.CLASS_DESCRIPTOR );
        metamodelClasses.put( "Composition", Composition.ASSOCIATION_DESCRIPTOR );
    }

    public void parse( InputStream stream, SpiParserCallback callback, long fileSize ) throws IOException {

        java.util.Properties props = new Properties( );

        Set<String> linkSet = new HashSet<String>( );
        Set<String> attributeSet = new HashSet<String>( );
        Set<String> structureSet = new HashSet<String>( );
        Map<String, SpiElement> elementMap = new HashMap<String, SpiElement>( 0 );


        props.load( stream );
        for ( Object object : props.keySet( ) ) {
            String key = (String) object;
            this.createIt( callback, key, props.getProperty( key ), elementMap, linkSet, attributeSet, structureSet );
        }
        this.createLinks( callback, elementMap, linkSet );
        this.createAttributes( callback, elementMap, attributeSet, props );
        this.createStructures( callback, elementMap, structureSet, props );


    }

    private void createStructures( SpiParserCallback callback, Map<String, SpiElement> elementMap, Set<String> structureSet, Properties props ) {

        for ( String structureString : structureSet ) {
            String[] pieces = structureString.split( ESCAPED_SEPARATION_CHAR, 3 );
            String[] structureFields = props.getProperty( structureString ).split( ESCAPED_SEPARATION_CHAR );
            SpiStructuredValue structuredAttribute = callback.createStructuredValue( );
            for ( String structureField : structureFields ) {
                String[] fieldValuePair = structureField.split( FIELD_SEPARATION_CHAR );
                structuredAttribute.set___FieldValue( fieldValuePair[0], fieldValuePair[1] );
            }
            SpiElement element = elementMap.get( pieces[1] );
            element.add___StructuredValue( pieces[2], structuredAttribute );
        }

    }

    private void createAttributes( SpiParserCallback callback, Map<String, SpiElement> elementMap, Set<String> attributeSet, Properties props ) {

        for ( String attributeString : attributeSet ) {
            String[] pieces = attributeString.split( ESCAPED_SEPARATION_CHAR, 3 );
            SpiElement spiElement = elementMap.get( pieces[1] );
            spiElement.add___PrimitiveOrEnumerationValue( pieces[2], props.getProperty( attributeString ) );
        }
    }

    private void createLinks( SpiParserCallback callback, Map<String, SpiElement> elementMap, Set<String> linkSet ) {

        for ( String linkString : linkSet ) {
            String[] pieces = linkString.split( ESCAPED_SEPARATION_CHAR, 4 );
            ExtentDescriptor descriptor = metamodelClasses.get( pieces[1] );
            callback.addLink( (AssociationDescriptor<?>) descriptor, elementMap.get( pieces[2] ), elementMap.get( pieces[3] ) );
        }
    }

    private void createIt( SpiParserCallback callback, String key, String value, Map<String, SpiElement> elementMap, Set<String> linkSet, Set<String> attributeSet, Set<String> structureSet ) {

        if ( key.startsWith( ELEMENT_ID ) ) {
            this.createElement( callback, key, value, elementMap );
        } else if ( key.startsWith( LINK_ID ) ) {
            linkSet.add( key );
        } else if ( key.startsWith( ATTRIBUTE_ID ) ) {
            attributeSet.add( key );
        } else if ( key.startsWith( STRUCTURE_ID ) ) {
            structureSet.add( key );
        } else {
            // ignore
        }
    }

    private void createElement( SpiParserCallback callback, String propertyKey, String propertyValue, Map<String, SpiElement> elementMap ) {

        String[] pieces = propertyKey.split( ESCAPED_SEPARATION_CHAR, 2 );

        ExtentDescriptor descriptor = metamodelClasses.get( propertyValue );
        if ( descriptor != null ) {
            String mofId = callback.calculateElementMofId( (ClassDescriptor<?, ?>) descriptor, new String[] { pieces[1], callback.getPri( ).toString( ) } );

            SpiElement newElement = callback.addElement( (ClassDescriptor<?, ?>) descriptor, mofId );
            newElement.add___PrimitiveOrEnumerationValue( EXTERNAL_ID_ATTRIBUTE, pieces[1] );
            elementMap.put( pieces[1], newElement );

        }
    }

    private static String createQualifiedName( String[] parts ) {

        String name = "";
        for ( String part : parts ) {
            name += part + ".";
        }
        return ( name.substring( 0, name.length( ) - 1 ) );
    }

}
