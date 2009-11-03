/*
 * Created on 08.06.2006
 */
package com.sap.tc.moin.repository.test.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Version;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class TestBasics extends MoinTestCase {

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
    public void testGetPackageDirectlyAfterMoinStart( ) throws Exception {

        getTestHelper( ).reset( );
        assertNotNull( "Expected to find package for testcases metamodel", getConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE ) );
    }

    @Test
    public void testCoreRuntimeVersion( ) throws Exception {

        Version coreRuntimeVersion = getTestHelper( ).getMoin( ).getCoreRuntimeVersion( );
        int major = coreRuntimeVersion.getMajor( );
        int minor = coreRuntimeVersion.getMinor( );
        assertEquals( major + "." + minor, coreRuntimeVersion.toString( ) );
    }

    @Test
    public void testNullArgumentsAtConnection( ) throws Exception {

        Connection connection = getConnection( );
        try {
            connection.getPartition( null );
            fail( "Expected Exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }
        try {
            connection.getElement( (LRI) null );
            fail( "Expected Exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }
        try {
            connection.getElement( (MRI) null );
            fail( "Expected Exception" );
        } catch ( IllegalArgumentException e ) {
            //expected
        }

    }


    private Connection getConnection( ) {

        return getTestHelper( ).getDefaultTestClient( true ).getConnection( );
    }
}