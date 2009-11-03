package com.sap.tc.moin.repository.test.core;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.IsOfType;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.util.properties.PropertiesPackage;

@SuppressWarnings( "nls" )
public class TestGetExtentsFromConnection extends CoreMoinTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testGetPackageExtentViaDescriptor( ) throws Exception {

        // get extents and check them
        ModelPackage modelPackage = getMOINConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        assertNotNull( "Package extent ModelPackage not found", modelPackage );
        PropertiesPackage propertiesPackage = getMOINConnection( ).getPackage( PropertiesPackage.PACKAGE_DESCRIPTOR );
        assertNotNull( "Package extent PropertiesPackage not found", propertiesPackage );
        // do something with the extents in order to check its basic functionality
        Collection<RefClass> allClasses = modelPackage.refAllClasses( );
        assertTrue( allClasses.size( ) > 0 );
        allClasses = propertiesPackage.refAllClasses( );
        assertTrue( allClasses.size( ) > 0 );
    }

    @Test
    public void testGetClassExtentViaDescriptor( ) throws Exception {

        // get extents and check them
        RefClass mofClassExtent = getMOINConnection( ).getClass( MofClass.CLASS_DESCRIPTOR );
        assertNotNull( "Class extent MofClassClass not found", mofClassExtent );
        // do something with the extents in order to check its basic functionality
        MofClass mofClass = (MofClass) mofClassExtent.refCreateInstance( );
        mofClass.setName( "MyMofClass" );
        assertEquals( "MyMofClass", mofClass.getName( ) );
    }

    @Test
    public void testGetAssociationExtentViaDescriptor( ) throws Exception {

        Attribute attribute = (Attribute) getMOINConnection( ).getClass( Attribute.CLASS_DESCRIPTOR ).refCreateInstance( );
        PrimitiveType primitiveType = (PrimitiveType) getMOINConnection( ).getClass( PrimitiveType.CLASS_DESCRIPTOR ).refCreateInstance( );
        // get extents and check them
        IsOfType isOfTypeAssociation = getMOINConnection( ).getAssociation( IsOfType.ASSOCIATION_DESCRIPTOR );
        isOfTypeAssociation.add( primitiveType, attribute );
    }
}
