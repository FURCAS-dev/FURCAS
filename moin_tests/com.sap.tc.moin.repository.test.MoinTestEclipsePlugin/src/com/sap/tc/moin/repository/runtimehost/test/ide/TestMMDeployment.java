package com.sap.tc.moin.repository.runtimehost.test.ide;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentManager;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentStatus;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetaModelInfo;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class TestMMDeployment extends MoinTestCase {

    private static final String TEST_CASE = "TestMMDeployment";

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
    public void testUnmodifiableMetamodelCollections( ) throws Exception {

        MmDeploymentManager deploymentManager = MoinFactory.getMmDeploymentManager( );
        Collection<MmDeploymentInfo> metamodelPluginList = deploymentManager.getMetaModelPluginList( );
        Collection<MetaModelInfo> metamodelList = deploymentManager.getMetaModelList( );

        //try to modify the collections
        try {
            metamodelPluginList.clear( );
            fail( "Exception expected" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }

        try {
            metamodelList.clear( );
            fail( "Exception expected" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }

    }

    @Test
    public void testMetamodelDeployment( ) throws Exception {

        final String SUB_TEST_CASE = "testMetamodelDeployment";
        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, SUB_TEST_CASE );

        printTestBeginInfo( fullTestCaseName );


        MmDeploymentManager deploymentManager = MoinFactory.getMmDeploymentManager( );
        MetaModelCatalog metamodelCatalog = MoinFactory.getMetamodelCatalog( );
        String mofContainerName = TestMetaModels.MOIN_MOF_CN;
        assertNotNull( "CRI for MOF is null", mofContainerName );
        MetaModelInfo mofMetamodelInfo = null;
        Collection<MetaModelInfo> metamodelInfos = deploymentManager.getMetaModelList( );
        for ( MetaModelInfo metaModelInfo : metamodelInfos ) {
            if ( metaModelInfo.getContainerName( ).equals( mofContainerName ) ) {
                mofMetamodelInfo = metaModelInfo;
                break;
            }
        }

        assertNotNull( "Metamodel info for MOF couldn't be found", mofMetamodelInfo );

        // List of meta-model plugins
        Collection<MmDeploymentInfo> mmCollection = deploymentManager.getMetaModelPluginList( );
        assertFalse( "MOF metamodel is in plugin list", mmCollection.contains( mofMetamodelInfo ) );
        // List of deployed meta-models
        Collection<MetaModelInfo> mmDeployedCollection = metamodelCatalog.getMetaModelList( );
        if ( mmCollection.size( ) == mmDeployedCollection.size( ) ) {
            assertTrue( "All meta-model already deployed.", true );
        } else {
            assertTrue( "Not all meta-model deployed. Deployed: " + mmDeployedCollection.size( ) + "; installed plug-ins: " + mmCollection.size( ), true );
        }
        assertTrue( "MOF metamodel is not in list of deployed metamodels", mmDeployedCollection.contains( mofMetamodelInfo ) );

        Iterator<MmDeploymentInfo> mmIterator = mmCollection.iterator( );
        MmDeploymentInfo deployInfo = null;

        while ( mmIterator.hasNext( ) ) {
            deployInfo = mmIterator.next( );
            if ( deployInfo != null ) {
                if ( deployInfo.getStatus( ) == MmDeploymentStatus.DEPLOYED ) {
                    // MM deployed
                    assertTrue( "Metamodel already deployed - " + deployInfo.getContainerName( ), true );
                } else {
                    continue;
                }

                this.printMmDeploymentInfo( deployInfo );

                if ( deployInfo.getPRIs( ).size( ) > 0 ) {
                    for ( PRI pri : deployInfo.getPRIs( ) ) {
                        InputStream partitionInputStream = null;
                        try {
                            partitionInputStream = deployInfo.getPartitionStream( pri );
                            assertNotNull( "Metamodel partition stream is null. Metamodel: " + deployInfo.getContainerName( ) + "; PRI: " + pri, partitionInputStream );
                        } finally {
                            if ( partitionInputStream != null ) {
                                try {
                                    partitionInputStream.close( );
                                } catch ( IOException e ) {
                                    this.info( "Metamodel partition stream could not be closed. Metamodel: " + deployInfo.getContainerName( ) + "; PRI: " + pri, e );
                                }
                            }
                        }
                    }
                } else {
                    assertFalse( "The metamodel PRI(s) not determined. Please check the metamodel plug-in - " + deployInfo.getContainerName( ), false );
                }

                assertTrue( "The metamodel successfully checked - " + deployInfo.toString( ), true );

                if ( deployInfo.getLastReportedErrorMessage( ) == null || deployInfo.getLastReportedErrorMessage( ).length( ) == 0 ) {
                    assertTrue( "No deployment error reported.", true );
                } else {
                    assertTrue( "Following deployment error reported: " + deployInfo.getLastReportedErrorMessage( ), true );
                }

                Collection<String> regFiles = deployInfo.getDeployedRegistrationFiles( );
                assertFalse( "Empty registration file list", regFiles.isEmpty( ) );

                // check stream handling for one of the files#                
                if ( regFiles.contains( MmInfoConst.MM2_METAMODEL_XML_FILE_NAME ) ) {
                    String content = null;
                    content = deployInfo.getRegistrationFileContent( MmInfoConst.MM2_METAMODEL_XML_FILE_NAME );
                    assertFalse( "Metamodel.xml cannot be read", content == null );
                }

                // check name, vendor, label
                deployInfo.getName( ); // code coverage
                assertTrue( "Label not set", deployInfo.getLabel( ) != null );
                assertTrue( "Vendor not set", deployInfo.getVendor( ) != null );

            } else {
                assertNotNull( "Problem in deployment manager (getMetaModelPluginList()). Metamodel deploy info not exist.", deployInfo );
            }
        }

        for ( MetaModelInfo metaModelInfo : mmDeployedCollection ) {
            assertFalse( "The metamodel extension instance not set. Please check the metamodel plug-in - " + metaModelInfo.getContainerName( ), ( (SpiMetaModelInfo) metaModelInfo ).getMmExtensionInstance( ) == null );

        }
    }

    private void printMmDeploymentInfo( MmDeploymentInfo deployInfo ) throws IOException {

        assertTrue( "Metamodel name:      " + deployInfo.getContainerName( ) + "\n" + "  - vendor:          " + deployInfo.getVendor( ) + "\n" + "  - label:           " + deployInfo.getLabel( ) + "\n" + "  - facility name:   " + deployInfo.getFacilityName( ) + "\n" + "  - version:         "
                    + deployInfo.getDeployedMetaModelVersion( ) + "\n" + "  - plug-in version: " + deployInfo.getMetaModelPluginVersion( ) + "\n" + "  - plug-in name:    " + deployInfo.getBundleName( ) + "\n" + "  - plug-in ID:      " + deployInfo.getBundleId( ) + "\n" + "  - deploy status:   "
                    + deployInfo.getStatus( ).toString( ), deployInfo.getContainerName( ) != null && deployInfo.getVendor( ) != null && deployInfo.getLabel( ) != null && deployInfo.getFacilityName( ) != null && deployInfo.getMetaModelPluginVersion( ).toString( ) != null
                                                           && deployInfo.getBundleName( ) != null && deployInfo.getBundleName( ) != null && deployInfo.getBundleId( ) != null && deployInfo.getStatus( ).toString( ) != null
                                                           && ( !deployInfo.getPRIs( ).isEmpty( ) ? ( deployInfo.getDeployedMetaModelVersion( ) != null ) : true ) );

    }

//    @Test
//    public void testIsMoinRunning( ) throws Exception {
//
//        final String SUB_TEST_CASE = "testIsMoinRunning";
//        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, SUB_TEST_CASE );
//
//        printTestBeginInfo( fullTestCaseName );
//
//        Moin moin = MoinFactory.getMoinInstance( );
//
//        boolean isMoinRunning = MoinFactory.isMoinRunning( );
//
//        if ( moin != null && isMoinRunning ) {
//            assertTrue( "Moin running", true );
//        } else {
//            assertFalse( "Moin not running - ERROR", false );
//        }
//
//        getTestHelper( ).stopMoin( );
//
//        isMoinRunning = MoinFactory.isMoinRunning( );
//        if ( isMoinRunning == false ) {
//            assertTrue( "Moin stopped", true );
//        } else {
//            assertFalse( "Moin still running - ERROR", false );
//        }
//
//        moin = MoinFactory.getMoinInstance( );
//        if ( moin != null && MoinFactory.isMoinRunning( ) ) {
//            assertTrue( "Moin running agian.", true );
//        } else {
//            assertFalse( "Moin not running - ERROR", false );
//        }
//    }

    private String getFullTestCaseName( String testCase, String subTestCase ) {

        return testCase + "[" + subTestCase + "]";
    }

    static protected void printTestBeginInfo( String testCase ) {

        java.lang.System.out.println( "------ Begin of test case: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

}
