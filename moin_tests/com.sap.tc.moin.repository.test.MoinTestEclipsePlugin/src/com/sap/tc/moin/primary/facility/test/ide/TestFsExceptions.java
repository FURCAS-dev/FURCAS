package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.junit.Before;
import org.junit.Test;

import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.facility.pde.FacilityResourceChangeListenerImpl;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;

/**
 * This test case checks exception handling in FsPersistence
 * <p>
 * Tests:
 * <p>
 * - testReadOnlyException()
 * <p>
 * - ...
 * </p>
 */
public class TestFsExceptions extends FacilityIdeMoinTest {

    private static final String TEST_CASE = "TestFsExceptions";

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    // Convenience:
    final boolean NEW_INSTANCE = true;

    final boolean FORCED = true;

    final boolean NOT_FORCED = false;

    final boolean CLOSE_CONNECTION = true;

    final boolean DONT_CLOSE_CONNECTION = false;

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

        // Retrieve the packageExtend for the MetaModel (which later is needed to create the respective model
        // elements)
        String modelContainerName = null;
        String[] qualifiedName = new String[] { TestMetaModels.SERVICE_INTERACTIONS };
        this._packageExtendForServiceInteractionsModels = (ServiceInteractionsPackage) ( getMoinConnection( ).getPackage( modelContainerName, qualifiedName ) );
        if ( this._packageExtendForServiceInteractionsModels == null ) {
            throw new RuntimeException( "PackageExtend for ServiceInteraction models could not be retrieved." );
        }
    }

    @Test
    public void testReadOnlyException( ) throws Exception {

        final String subTestCaseName = "testReadOnlyException";
        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, subTestCaseName );
        boolean testSucceeded = false;
        List testObjects = new ArrayList( );
        Connection connection = null;

        // hot_todo: introduce IdeTestClient derived from TestClient, which provides specific methods which take the
        // name of the DC and partition as parameter (else: the partition is created with fixed name in default-dc)
        // this might help: TestClientFactory testClientFactory = MOIN_TEST_HELPER.getTestClientFactory(
        // idePrimaryFacility.getId() );
        // current state here: myTestClient is not used, but own helper methods for creation of partition
        TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( this.NEW_INSTANCE );

        // Preparation of test:
        // --------------------
        // Create/Determine the needed test data: test project, test partitions in this project, …

        printTestPreparationInfo( );

        // - Deploy/Import MM for the model data which will be created during test
        // todo: first check if MM is already imported, if not, then import

        // - Get or create the specific test-DC, including test-project in the given default local DevConfig
        // todo: --> getter in TestHelper, see also in: IdeNwdiTestClientImpl for concrete values
        // or getter in basis test class of IdeFacilityTests
        // todo: --> if DC already exists from previous test-run, then clean-up the test data inside
        // dcName-length restriction from DbIndex: 80 characters
        // 'test.sap.com\tc\moin\facility\test\\dcToBeRefreshed' --> 71 --> test case name can have length <= 29
        String subTestCaseNameWithRestrictedLength = subTestCaseName.length( ) <= 29 ? subTestCaseName : subTestCaseName.substring( 0, 29 );
        String dcVendor = "test.sap.com";
        String dcName = "tc/moin/facility/test/" + subTestCaseNameWithRestrictedLength;
        String fullDcName = dcVendor + "/" + dcName;
        IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName );

        ClientSpec clientSpec = getIdeFacilityDispatcher( ).getClientSpec( eclipseProject );
        String clientSpecificStageName = getClientSpecificStageName( clientSpec );

        // The standard test project and the testProject in this test case both are located in the default local
        // devConfig
        // --> we can use the standard MOIN connection in this test
        connection = getMoinConnection( );

        // - Create the test partitions in the test DC:

        // -- create an additional partition 'createdPartition' only on file system, not in DbIndex

        // --- create and fill partition and save --> partition available in MOIN workspaces, on FS, in DB
        ModelPartition createdPartition = createPartition( clientSpec, fullDcName, makePartitionName( "src/createdPartition" ) );
        PRI createdPartitionPri = createdPartition.getPri( );
        testObjects.add( createdPartitionPri );
        List<MRI> mrisInCreatedPartition = fillPartitionWithServiceInteractionsModelElements( createdPartition );
        connection.save( );

        // - change partition
        final String ORIGINAL_MESSAGE_TYPE_VALUE = "message1TypeValue";
        String mofIdOfChangedModelElement = getMofIdOfAnyMessageInServiceInteractionsModel( createdPartition );
        changeModelElementInPartitionWithServiceInteractionsModelElements( connection, mrisInCreatedPartition, mofIdOfChangedModelElement, ORIGINAL_MESSAGE_TYPE_VALUE );

        // - set partition to read only mode
        // -- get file first
        File file = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, createdPartitionPri );
        testObjects.add( file );
        // -- copy file, so that the partition can be cleaned up finally
        File writableFileCopy = new File( file.getAbsolutePath( ) + ".copy" );
        MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( file, writableFileCopy );
        testObjects.add( writableFileCopy );
        // -- set read only
        file.setReadOnly( );

        try {
            connection.save( );
            fail( "PartitionsNotSavedException expected" );
        } catch ( PartitionsNotSavedException e ) {
            if ( !( e.getCause( ) instanceof RuntimeException ) ) {
                throw e;
            }
        }

        // Clean-up of test objects:

        // Resource change event handling MUST be dynamically switched off because renaming the file can only be done
        // via delete and copy. If a resource change event is raised between these two operations, the partition is removed
        // from the index and a precondition check for deletion will fail.
        boolean _resChangeListenerEnvOff = Boolean.getBoolean( FacilityResourceChangeListenerImpl.CHANGE_LISTENER_OFF );
        if ( !_resChangeListenerEnvOff ) {
            // set flag for test execution
            System.setProperty( FacilityResourceChangeListenerImpl.CHANGE_LISTENER_OFF, "true" );
        }

        try {
            // -- set writable again
            file.delete( );
            MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( writableFileCopy, file );
            // -- clean up
            cleanUpTestObjects( testObjects, connection );
        } finally {
            System.setProperty( FacilityResourceChangeListenerImpl.CHANGE_LISTENER_OFF, _resChangeListenerEnvOff ? "true" : "false" );
        }
    }

    /**
     * Checks if an exception which is thrown on a partition deletion is handled
     * correctly.<br>
     * The exception is intentionally triggered by an open {@link InputStream}.
     */
    @Test
    public void testExceptionOnDeletion( ) throws Exception {

        final String subTestCaseName = "testExceptionOnDeletion";
        List<Object> testObjects = new ArrayList<Object>( );

        // Get or create the specific test-DC, including test-project in the given default local DevConfig
        String subTestCaseNameWithRestrictedLength = subTestCaseName.length( ) <= 29 ? subTestCaseName : subTestCaseName.substring( 0, 29 );
        String dcVendor = "test.sap.com";
        String dcName = "tc/moin/facility/test/" + subTestCaseNameWithRestrictedLength;
        String fullDcName = dcVendor + "/" + dcName;
        IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName );

        // get clientSpec for project
        ClientSpec clientSpec = getIdeFacilityDispatcher( ).getClientSpec( eclipseProject );

        // get a connection
        Connection connection = getMoinConnection( );

        // create test partition
        ModelPartition createdPartition = createPartition( clientSpec, fullDcName, makePartitionName( "src/createdPartition" ) );
        PRI createdPartitionPri = createdPartition.getPri( );
        connection.save( );

        // memorize object for cleanup
        testObjects.add( createdPartitionPri );

        // delete partition
        createdPartition.delete( );

        // get java.io.File handle
        File file = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, createdPartitionPri );

        InputStream is = null;
        try {
            // open an input stream (this should cause the deletion to fail)
            is = new FileInputStream( file );
            is.read( ); // read first byte, stream is still open

            try {
                connection.save( );
                fail( "PartitionsNotSavedException expected" );
            } catch ( PartitionsNotSavedException e ) {
                if ( !( e.getCause( ) instanceof RuntimeException ) ) {
                    throw e;
                }
            }
        } finally {
            // close open input stream
            if ( is != null ) {
                try {
                    is.close( );
                } catch ( Exception exc ) {
                    // $JL-EXC$ repair funtionality
                }
            }
        }

        // clean up
        cleanUpTestObjects( testObjects, connection );
    }
}
