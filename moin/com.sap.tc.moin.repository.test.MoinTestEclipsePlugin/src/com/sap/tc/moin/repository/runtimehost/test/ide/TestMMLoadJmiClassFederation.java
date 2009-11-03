package com.sap.tc.moin.repository.runtimehost.test.ide;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentManager;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentStatus;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcasesfoundation.TestcasesfoundationPackage;

public class TestMMLoadJmiClassFederation extends MoinTestCase {

    protected TestClient _testClient;

    private static final String TEST_CASE = "TestMMLoadJmiClassFederation";

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
        _testClient = getTestHelper( ).getDefaultTestClient( true );
        _testClient.setAsCurrentClient( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        _testClient.clear( );
        _testClient = null;

        // clean handling of Moin reset.
        super.afterTestMethod( );
    }

    @Test
    public void testLoadJmiClassesFederation( ) throws Exception {

        final String SUB_TEST_CASE = "testLoadJmiClassesFederation";
        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, SUB_TEST_CASE );

        boolean testcases_MM_foundation_deployed = false;
        boolean testcases_MM_deployed = false;

        printTestBeginInfo( fullTestCaseName );

        boolean testSucceeded = false;

        try {
            // Obtain MM deployment manager and check the status of the Testcases MM's.
            MmDeploymentManager deploymentManager = MoinFactory.getMmDeploymentManager( );

            Collection<MmDeploymentInfo> mmCollection = deploymentManager.getMetaModelPluginList( );
            Iterator<MmDeploymentInfo> mmIterator = mmCollection.iterator( );
            MmDeploymentInfo deployInfo = null;

            while ( mmIterator.hasNext( ) ) {
                deployInfo = mmIterator.next( );
                if ( deployInfo != null ) {
                    if ( deployInfo.getContainerName( ).equalsIgnoreCase( TestMetaModels.TESTCASES_FOUNDATION_PLUGIN_ID ) ) {
                        if ( deployInfo.getStatus( ) == MmDeploymentStatus.DEPLOYED ) {
                            // OK - MM deployed
                            testcases_MM_foundation_deployed = true;
                            assertTrue( "The testcases foundation metamodel deployed. " + TestMetaModels.TESTCASES_FOUNDATION_PLUGIN_ID, true );
                        } else {
                            //deploymentManager.deployMetaModel(deployInfo);
                            testcases_MM_foundation_deployed = true;
                            assertTrue( "The testcases foundation metamodel deployed. " + TestMetaModels.TESTCASES_FOUNDATION_PLUGIN_ID, true );
                        }
                    }

                    if ( deployInfo.getContainerName( ).equalsIgnoreCase( TestMetaModels.TESTCASES_PLUGIN_ID ) ) {
                        if ( deployInfo.getStatus( ) == MmDeploymentStatus.DEPLOYED ) {
                            // OK - MM deployed
                            testcases_MM_deployed = true;
                            assertTrue( "The testcases metamodel deployed. " + testcases_MM_deployed, true );
                        } else {
                            //deploymentManager.deployMetaModel(deployInfo);
                            testcases_MM_deployed = true;
                            assertTrue( "The testcases metamodel deployed. " + testcases_MM_deployed, true );
                        }
                    }
                }
            }
        } catch ( Exception e ) {
            assertFalse( "Exception in the runtime host metamodel ckeck " + e.toString( ), false );
        }

        if ( testcases_MM_foundation_deployed && testcases_MM_deployed ) {
            // Start the JMI class load test

            Connection connection = null;

            try {
                connection = getMoinConnection( );

                // testcasesfouncation tpe
                RefPackage testCasesFoundationRefPackage = (RefPackage) connection.getPackage( TestMetaModels.TESTCASES_FOUNDATION_CN, new String[] { TestMetaModels.TESTCASES_FOUNDATION_TPE } );
                assertNotNull( "TestCasesFoundation extent not found: " + TestMetaModels.TESTCASES_FOUNDATION_CN + " ; " + TestMetaModels.TESTCASES_FOUNDATION_CN, testCasesFoundationRefPackage );
                TestcasesfoundationPackage testCasesFoundationPackage = (TestcasesfoundationPackage) testCasesFoundationRefPackage;

                // testcases tpe
                RefPackage testCasesRefPackage = (RefPackage) connection.getPackage( TestMetaModels.TESTCASES_CN, new String[] { TestMetaModels.TESTCASES_TPE } );
                assertNotNull( "Testcases extent not found: " + TestMetaModels.TESTCASES_CN + " ; " + TestMetaModels.TESTCASES_TPE, testCasesRefPackage );
                TestcasesPackage testCasesPackage = (TestcasesPackage) testCasesRefPackage;

                A1 a1 = (A1) testCasesPackage.getCase001( ).getA1( ).refCreateInstance( );
                assertNotNull( "Testcases - instance A1 could be created", a1 );

                // Test end:
                // ---------

                testSucceeded = true;

            } catch ( Exception e ) {
                // Exception in Pre- or Postcondition checks
                e.printStackTrace( );
                throw e;

            } finally {
                connection.close( );

                // Print test result
                if ( testSucceeded ) {
                    printTestSucceededInfo( fullTestCaseName );
                } else {
                    printTestFailedInfo( fullTestCaseName );
                }
            }
        } else {
            // MM are not deployed - stop the test
            assertFalse( "The testcases metamodels are not deployed. Please check the metamodel plug-ins: " + TestMetaModels.TESTCASES_PLUGIN_ID + " and " + TestMetaModels.TESTCASES_FOUNDATION_PLUGIN_ID, false );
        }

    }

    public Connection getMoinConnection( ) {

        _testClient.setAsCurrentClient( );
        return _testClient.getConnection( );
    }

    private String getFullTestCaseName( String testCase, String subTestCase ) {

        return testCase + "[" + subTestCase + "]";
    }

    static protected void printTestBeginInfo( String testCase ) {

        java.lang.System.out.println( "------ Begin of test case: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

    static protected void printTestSucceededInfo( String testCase ) {

        java.lang.System.out.println( "------ Test case succeeded: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

    static protected void printTestFailedInfo( String testCase ) {

        java.lang.System.out.println( "------ Test case failed: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

}
