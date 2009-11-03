package com.sap.tc.moin.repository.test.core;


import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.util.properties.PropertiesPackage;
import com.sap.tc.moin.util.properties.Property;
import com.sap.tc.moin.util.properties.PropertyBag;

@SuppressWarnings( "nls" )
public class TestUtilMetamodel extends CoreMoinTest {

    private static final String PROPERTY_KEY = "key01";

    private static final String PROPERTY_VALUE = "value01";

    private static final String BAG_ID = "bagid01";

    private PropertiesPackage pp = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        pp = getMOINConnection( ).getPackage( PropertiesPackage.PACKAGE_DESCRIPTOR );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        pp = null;
    }

    @Test
    public void testPropertyAndPropertyBag( ) throws Exception {

        StructureFieldContainer<Property> container = new StructureFieldContainer<Property>( );
        container.put( Property.DESCRIPTORS.KEY( ), PROPERTY_KEY );
        container.put( Property.DESCRIPTORS.VALUE( ), PROPERTY_VALUE );
        Property property = pp.createProperty( container );

        PropertyBag propBag = getMOINConnection( ).createElement( PropertyBag.CLASS_DESCRIPTOR );
        propBag.setId( BAG_ID );
        propBag.getProperties( ).add( property );
        getPartitionOne( ).assignElement( propBag );
        getMOINConnection( ).save( );

        MQLResultSet resultSet = getSecondMOINConnection( ).getMQLProcessor( ).execute( "select bag from properties::PropertyBag as bag where bag.id = '" + BAG_ID + "'" );
        RefObject[] resultElements = resultSet.getRefObjects( "bag" );
        assertEquals( "Expected exactly one bag", 1, resultElements.length );

        PropertyBag foundBag = (PropertyBag) resultElements[0];
        assertEquals( "PropertyBag has different id than expected", BAG_ID, foundBag.getId( ) );

        Collection<Property> properties = foundBag.getProperties( );
        assertEquals( "Expected exactly one property", 1, properties.size( ) );

        Property foundProperty = properties.iterator( ).next( );
        assertEquals( "Property key has different value than expected", PROPERTY_KEY, foundProperty.getKey( ) );
        assertEquals( "Property key has different value than expected", PROPERTY_VALUE, foundProperty.getValue( ) );
        // clean up
        getPartitionOne( ).delete( );
        getMOINConnection( ).save( );
    }
}
