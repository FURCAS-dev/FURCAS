package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class TestGeneratedJmiNames extends CoreMoinTest {

    private ModelPackage mp = null;

    private MofPackage myPackage = null;

    private MofPackage mySubPackage = null;

    private MofClass myClass1 = null;

    private Association myAssoc1 = null;

    private SpiJmiHelper jmiHelper = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        jmiHelper = getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getCoreJmiHelper( );
        mp = ( (MoinPackage) getMOINConnection( ).getPackage( null, new String[] { TestMetaModels.MOIN_MOF } ) ).getModel( );
        buildModel( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        jmiHelper = null;
        mp = null;
        myPackage = null;
        mySubPackage = null;
        myClass1 = null;
        myAssoc1 = null;
    }

    @Test
    public void testGeneratedInterfaceNameForPackages( ) {

        String expectedName = "com.sap.tc.moin.test.mypackage.MyPackagePackage";
        String generatedName = UtilitiesFactory.getMoinUtil( ).getJmiInterfaceName( myPackage );
        assertTrue( "The generated name \"" + generatedName + "\" is not equal to the expected name \"" + expectedName + "\".", generatedName.equals( expectedName ) );
    }

    @Test
    public void testGeneratedInterfaceNameForClasses( ) {

        String expectedName = "com.sap.tc.moin.test.mypackage.MyClass1";
        String generatedName = UtilitiesFactory.getMoinUtil( ).getJmiInterfaceName( myClass1 );
        assertTrue( "The generated name \"" + generatedName + "\" is not equal to the expected name \"" + expectedName + "\".", generatedName.equals( expectedName ) );
    }

    @Test
    public void testGeneratedInterfaceNameForAssociations( ) {

        String expectedName = "com.sap.tc.moin.test.mypackage.MyAssoc1";
        String generatedName = UtilitiesFactory.getMoinUtil( ).getJmiInterfaceName( myAssoc1 );
        assertTrue( "The generated name \"" + generatedName + "\" is not equal to the expected name \"" + expectedName + "\".", generatedName.equals( expectedName ) );
    }

    @Test
    public void testGeneratedPackageName( ) {

        String expectedName = "com.sap.tc.moin.test.mypackage.mysubpackage";
        String generatedName = UtilitiesFactory.getMoinUtil( ).getJmiPackageName( mySubPackage );
        assertTrue( "The generated name \"" + generatedName + "\" is not equal to the expected name \"" + expectedName + "\".", generatedName.equals( expectedName ) );
    }

    private void buildModel( ) {

        // a package prefix
        Tag packagePrefix = (Tag) mp.getTag( ).refCreateInstance( );
        packagePrefix.setName( "myPackagePrefix" );
        packagePrefix.setTagId( "javax.jmi.packagePrefix" );
        packagePrefix.getValues( ).add( "com.sap.tc.moin.test" );
        // the surrounding package
        myPackage = (MofPackage) mp.getMofPackage( ).refCreateInstance( );
        myPackage.setName( "MyPackage" );
        // a sub package
        mySubPackage = (MofPackage) mp.getMofPackage( ).refCreateInstance( );
        mySubPackage.setName( "My_Sub_Package" );
        // a class
        myClass1 = (MofClass) mp.getMofClass( ).refCreateInstance( );
        myClass1.setName( "MyClass1" );
        // an association
        myAssoc1 = (Association) mp.getAssociation( ).refCreateInstance( );
        myAssoc1.setName( "MyAssoc_1" );
        // build the model
        packagePrefix.getElements( ).add( myPackage );
        myPackage.getContents( ).add( mySubPackage );
        myPackage.getContents( ).add( myClass1 );
        myPackage.getContents( ).add( myAssoc1 );
    }
}
