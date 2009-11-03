package com.sap.tc.moin.repository.runtimehost.test.build;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.primary.facility.test.ide.UtilityModelCreation;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.test.fw.build.MoinBuildBaseTest;
import com.sap.tc.moin.test.fw.build.MoinBuildTestHelper;

public class TestInBuildEnvironment extends MoinBuildBaseTest {

    private static final String TEST_CASE = "TestRuntimeHostBuild";

    /**
     * Test-SetUp:
     * <p>
     * Perform the standard set-up procedure
     * <p>
     * The MetaModel used in the test cases is imported and the corresponding
     * packageExtend for models is retrieved.
     * </p>
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        // clean handling of Moin reset.
        super.afterTestMethod( );
    }

    @Test
    public void testRuntimeHostBuild( ) throws Exception {

        final String SUB_TEST_CASE = "testRuntimeHostBuild";
        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, SUB_TEST_CASE );

        printTestBeginInfo( fullTestCaseName );

        Moin moin = getTestHelper( ).getMoin( );

        boolean isMoinRunning = getTestHelper( ).isMoinRunning( );

        if ( moin != null && isMoinRunning ) {
            assertTrue( "Moin running", true );
        } else {
            assertFalse( "Moin not running - ERROR", false );
        }

        Connection connection = getTestHelper( ).getConnection( );
        assertNotNull( "Connection null", connection );
        assertTrue( "Connection is not alive ", connection.isAlive( ) );

        ModelPartition partition = getTestHelper( ).getOrCreatePartitionStable( "testBuild", MoinBuildTestHelper.DEFAULT_DC.toString( ) );
        UtilityModelCreation.fillPartitionWithMofModel( connection, partition );
        connection.save( );

        getTestHelper( ).build( partition );

        getTestHelper( ).stopMoin( );

        isMoinRunning = getTestHelper( ).isMoinRunning( );
        if ( isMoinRunning == false ) {
            assertTrue( "Moin stopped", true );
        } else {
            assertFalse( "Moin still running - ERROR", false );
        }
    }

    private String getFullTestCaseName( String testCase, String subTestCase ) {

        return testCase + "[" + subTestCase + "]";
    }

    static protected void printTestBeginInfo( String testCase ) {

        java.lang.System.out.println( "------ Begin of test case: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

}
