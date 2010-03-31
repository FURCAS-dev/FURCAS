/*
 * Created on 22.06.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.toplevel1.nested1.Nested1Package;
import com.sap.tc.moin.toplevel2.Toplevel2Package;
import com.sap.tc.moin.toplevel2.nested2.Nested2Package;
import com.sap.tc.moin.toplevel3.Toplevel3Package;
import com.sap.tc.moin.toplevel3.nested3.Nested3Package;

/**
 * TODO Create some more testcases which let the search algorithm go some
 * meanders.
 * 
 * @author D044784
 */
public class TestGetRefPackageForMofPackage extends CoreMoinTest {

    RefPackage toplevel1Ref;

    MofPackage toplevel1Mof;

    JmiHelper helper;

    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        toplevel1Ref = getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel1" } );
        toplevel1Mof = (MofPackage) toplevel1Ref.refMetaObject( );
        helper = getMOINConnection( ).getJmiHelper( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        toplevel1Ref = null;
        toplevel1Mof = null;
        helper = null;
    }

    @Test
    public void testNested( ) {

        MofPackage nested1Mof = (MofPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel1", "nested1" } ).refMetaObject( );
        RefPackage nested1Ref = helper.getRefPackageForMofPackage( nested1Mof );
        verify( nested1Ref != null && nested1Ref instanceof Nested1Package, "Nested package not found" );
    }

    @Test
    public void testClustered( ) {

        MofPackage toplevel2Mof = (MofPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel2" } ).refMetaObject( );
        RefPackage toplevel2Ref = helper.getRefPackageForMofPackage( toplevel2Mof );
        verify( toplevel2Ref != null && toplevel2Ref instanceof Toplevel2Package, "Clustered package not found" );
    }

    @Test
    public void testClusteredNested( ) {

        MofPackage nested2Mof = (MofPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel2", "nested2" } ).refMetaObject( );
        RefPackage nested2Ref = helper.getRefPackageForMofPackage( nested2Mof );
        verify( nested2Ref != null && nested2Ref instanceof Nested2Package, "Nested package in clustered package not found" );
    }

    @Test
    public void testClusteredClustered( ) {

        MofPackage toplevel3Mof = (MofPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel3" } ).refMetaObject( );
        RefPackage toplevel3Ref = helper.getRefPackageForMofPackage( toplevel3Mof );
        verify( toplevel3Ref != null && toplevel3Ref instanceof Toplevel3Package, "Clustered package in clustered package not found" );
    }

    @Test
    public void testClusteredClusteredNested( ) {

        MofPackage nested3Mof = (MofPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel3", "nested3" } ).refMetaObject( );
        RefPackage nested3Ref = helper.getRefPackageForMofPackage( nested3Mof );
        verify( nested3Ref != null && nested3Ref instanceof Nested3Package, "Nested package in clustered package in clustered package not found" );
    }

    @Test
    public void testClusteredClusteredNestedByName( ) {

        MofPackage nested3Mof = (MofPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel3", "nested3" } ).refMetaObject( );
        RefPackage nested3Ref = helper.findRefPackageByQualifiedName( nested3Mof.getQualifiedName( ), toplevel1Ref );
        verify( nested3Ref != null && nested3Ref instanceof Nested3Package, "Nested package in clustered package in clustered package not found" );
    }

    @Test
    public void testRefAllMethodsForReflect( ) throws Exception {

        RefPackage package1 = getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_REFLECT );
        assertNotNull( "Package " + TestMetaModels.MOIN_MOF_TPE_REFLECT + " not found", package1 );

        Collection refAllClasses = package1.refAllClasses( );
        assertSame( 1, refAllClasses.size( ) );
        assertEquals( "Element", ( (MofClass) ( (RefClass) refAllClasses.iterator( ).next( ) ).refMetaObject( ) ).getName( ) );

        Collection refAllPackages = package1.refAllPackages( );
        assertTrue( refAllPackages.isEmpty( ) );

        Collection refAllAssociations = package1.refAllAssociations( );
        assertTrue( refAllAssociations.isEmpty( ) );
    }
}
