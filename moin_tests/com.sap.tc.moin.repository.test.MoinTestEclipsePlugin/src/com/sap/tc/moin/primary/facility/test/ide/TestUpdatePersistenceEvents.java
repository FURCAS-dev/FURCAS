package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.Before;
import org.junit.Test;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceFoldersRecord;
import com.sap.tc.moin.facility.primary.persistence.fs.ResourceManagementImpl;
import com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelDcType;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;

/**
 * This test case covers the update-mechanisms between FsPersistence and
 * DbPersistence which are triggered by MOIN client API methods or by events
 * from Eclipse / Dii05 concerning resource / project changes and handled by
 * IdeDii05Service.
 * <p>
 * Tests:
 * <p>
 * - testRefreshFromFileSystem
 * <p>
 * - ...
 * </p>
 * 
 * @author d021091
 */
public class TestUpdatePersistenceEvents extends FacilityIdeMoinTest {

    private static final String CHANGE_LISTENER_OFF = "com.sap.tc.moin.resourcechangelistener.off";

    private static final String DC_CHANGE_LISTENER_OFF = "com.sap.tc.moin.dcchangelistener.off";

    private static final String TEST_CASE = "TestUpdatePersistenceEvents";

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    private static final int MAX_WAITING_FOR_EVENTS = 15000; // 15 sec

    // Convenience:
    final boolean NEW_INSTANCE = true;

    final boolean FORCED = true;

    final boolean NOT_FORCED = false;

    final boolean CLOSE_CONNECTION = true;

    final boolean DONT_CLOSE_CONNECTION = false;

    final String ORIGINAL_NAME_VALUE = "name1Value";

    final String CHANGED_NAME_VALUE = "changedName1Value";

    static final IProgressMonitor NO_PROGRESS_MONITOR = null;

    private ModelPackage modelPackage;

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.primary.facility.test.ide.FacilityIdeMoinTest#afterTestMethod
     * ()
     */
    @Override
    public void afterTestMethod( ) throws Exception {

        if ( Boolean.getBoolean( CHANGE_LISTENER_OFF ) ) {
            // test not applicable
            return;
        }
        super.afterTestMethod( );
    }

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

        if ( Boolean.getBoolean( CHANGE_LISTENER_OFF ) ) {
            // test not applicable
            return;
        }

        super.beforeTestMethod( );

        this.modelPackage = (ModelPackage) getMoinConnection( ).getPackage( null, "Model" );
        if ( this.modelPackage == null ) {
            throw new RuntimeException( "MOF model package could not be retrieved." );
        }

        String modelContainerName = null;
        String[] qualifiedName = new String[] { TestMetaModels.SERVICE_INTERACTIONS };
        this._packageExtendForServiceInteractionsModels = (ServiceInteractionsPackage) ( getMoinConnection( ).getPackage( modelContainerName, qualifiedName ) );
        if ( this._packageExtendForServiceInteractionsModels == null ) {
            throw new RuntimeException( "PackageExtend for ServiceInteraction models could not be retrieved." );
        }

    }

    @Test
    public void testRefreshFromFileSystem( ) throws Exception {

        final String SUB_TEST_CASE = "refreshFromFileSystem";
        internalTestRefreshFromFileSystem( SUB_TEST_CASE, this.NOT_FORCED, this.DONT_CLOSE_CONNECTION );
    }

    @Test
    public void testRefreshFromFileSystemWithoutConnection( ) throws Exception {

        //TODO This test is deprecated because there are no internal connections anymore 
        final String SUB_TEST_CASE = "refreshFromFileSystemWithoutConnection";
        internalTestRefreshFromFileSystem( SUB_TEST_CASE, this.NOT_FORCED, this.CLOSE_CONNECTION );
    }

    private void internalTestRefreshFromFileSystem( String subTestCaseName, boolean forced, boolean closeConnection ) throws Exception {

        if ( Boolean.getBoolean( CHANGE_LISTENER_OFF ) ) {
            // test not applicable
            printTestInfo( "test not applicable - change listener not active" );
            return;
        }

        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, subTestCaseName );

        boolean testSucceeded = false;

        // Test objects
        List testObjects = new ArrayList( );
        Connection connection = null;

        printTestBeginInfo( fullTestCaseName );

        try {
            // hot_todo: introduce IdeTestClient derived from TestClient, which
            // provides specific methods which take the
            // name of the DC and partition as parameter (else: the partition is
            // created with fixed name in default-dc)
            // this might help: TestClientFactory testClientFactory =
            // MOIN_TEST_HELPER.getTestClientFactory(
            // idePrimaryFacility.getId() );
            // current state here: myTestClient is not used, but own helper
            // methods for creation of partition
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            // Preparation of test:
            // --------------------
            // Create/Determine the needed test data: test project, test
            // partitions in this project, …

            printTestPreparationInfo( );

            // - Deploy/Import MM for the model data which will be created
            // during test
            // todo: first check if MM is already imported, if not, then import

            // - Get or create the specific test-DC, including test-project in
            // the given default local DevConfig
            // todo: --> getter in TestHelper, see also in:
            // IdeNwdiTestClientImpl for concrete values
            // or getter in basis test class of IdeFacilityTests
            // todo: --> if DC already exists from previous test-run, then
            // clean-up the test data inside
            // dcName-length restriction from DbIndex: 80 characters
            // 'test.sap.com\tc\moin\facility\test\\dcToBeRefreshed' --> 71 -->
            // test case name can have length <= 29
            String subTestCaseNameWithRestrictedLength = subTestCaseName.length( ) <= 29 ? subTestCaseName : subTestCaseName.substring( 0, 29 );
            String dcVendor = "test.sap.com";
            String dcName = "tc/moin/facility/test/" + subTestCaseNameWithRestrictedLength + "/dcToBeRefreshed";
            String fullDcName = dcVendor + "/" + dcName;
            IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName );

            ClientSpec clientSpec = getIdeFacilityDispatcher( ).getClientSpec( eclipseProject );
            String clientSpecificStageName = getClientSpecificStageName( clientSpec );

            // The standard test project and the testProject in this test case
            // both are located in the default local
            // devConfig
            // --> we can use the standard MOIN connection in this test
            connection = getMoinConnection( );

            // - Create the test partitions in the test DC:

            // -- create an additional partition 'createdPartition' only on file
            // system, not in DbIndex

            // --- create and fill partition and save --> partition available in
            // MOIN workspaces, on FS, in DB
            String createdPartitionName = makePartitionName( "createdPartition" );
            ModelPartition createdPartition = createPartition( clientSpec, fullDcName, "src/" + createdPartitionName );
            PRI createdPartitionPri = createdPartition.getPri( );
            testObjects.add( createdPartitionPri );
            List<MRI> mrisInCreatedPartition = fillPartitionWithMofModel( connection, createdPartition, "create" );
            connection.save( );

            // --- create temporary copy (file without partition suffix !!!)
            // (We use java.io.file to prevent Eclipse from immediately firing
            // resourceChangeEvents)
            File file_cr = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, createdPartitionPri );
            testObjects.add( file_cr );
            String absoluteFilePath = file_cr.getAbsolutePath( );
            String TEXT_FILE_SUFFIX = ".txt";
            File tmpFileCopy_cr = new File( absoluteFilePath + TEXT_FILE_SUFFIX );
            testObjects.add( tmpFileCopy_cr );
            MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( file_cr, tmpFileCopy_cr );

            // --- Delete the partition in MOIN workspaces and on FS and DB
            createdPartition.delete( );
            connection.save( );

            // -- delete a partition deletedPartition only on file system, not
            // in DbIndex

            // --- create and fill partition and save --> partition available in
            // MOIN workspaces, on FS, in DB
            ModelPartition deletedPartition = createPartition( clientSpec, fullDcName, makePartitionName( "src/deletedPartition" ) );
            PRI deletedPartitionPri = deletedPartition.getPri( );
            testObjects.add( deletedPartitionPri );
            List<MRI> mrisInDeletedPartition = fillPartitionWithMofModel( connection, deletedPartition, "delete" );
            connection.save( );

            // -- change the content of partition changedPartition only on file
            // system, not in DbIndex

            // --- create and fill partition and save --> partition available in
            // MOIN workspaces, on FS, in DB
            String changedPartitionName = makePartitionName( "changedPartition" );
            ModelPartition changedPartition = createPartition( clientSpec, fullDcName, "src/" + changedPartitionName );
            PRI changedPartitionPri = changedPartition.getPri( );
            testObjects.add( changedPartitionPri );
            List<MRI> mrisInChangedPartition = fillPartitionWithMofModel( connection, changedPartition, "change" );
            String mofIdOfChangedModelElement = getMofIdOfAnyMofClass( changedPartition );
            changeModelElementInPartitionWithsModelElements( connection, mrisInChangedPartition, mofIdOfChangedModelElement, ORIGINAL_NAME_VALUE );
            connection.save( );

            // --- create temporary copy (file without partition suffix !!!)
            // (We use java.io.file to prevent Eclipse from immediately firing
            // resourceChangeEvents)
            File file_ch = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, changedPartitionPri );
            testObjects.add( file_ch );
            absoluteFilePath = file_ch.getAbsolutePath( );
            File tmpFileCopy_ch = new File( absoluteFilePath + TEXT_FILE_SUFFIX );
            testObjects.add( tmpFileCopy_ch );
            MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( file_ch, tmpFileCopy_ch );
            long timestampOfTmpFileCopy = tmpFileCopy_ch.lastModified( );

            // --- change the content of changedPartition and save
            changeModelElementInPartitionWithsModelElements( connection, mrisInChangedPartition, mofIdOfChangedModelElement, CHANGED_NAME_VALUE );
            if ( !forced ) {
                // In this case the update is only done when the timestamp
                // before and after the last connection save is
                // different, but the test program is too fast and therefore we
                // have to ensure this explicitely.
                final long twoSecondsInMilliSeconds = 2000;
                threadSleep( twoSecondsInMilliSeconds, fullTestCaseName ); // ensure
                // that
                // the
                // timestamps
                // of
                // original
                // and copy are different
            } // else-handling for the forced-case: see below
            connection.save( );
            long timestampOfOriginalFileAfterModification = file_ch.lastModified( );
            if ( forced ) {
                // In this case the update is also done when the timestamp
                // before and after the last connection save is
                // equal, but the test program could also result in timestamps
                // which are different (in rare cases, by
                // change).
                // Therefore we ensure explicitely that the timestamp of
                // original and copy are equal.
                // --> below we check for forced-update that the updated is also
                // done if the timestamp is equal.
                tmpFileCopy_ch.setLastModified( timestampOfOriginalFileAfterModification );
            }


            if ( !Boolean.getBoolean( DC_CHANGE_LISTENER_OFF ) ) {
                // wait to have any notifications done before
                final long twoSecondsInMilliSeconds = 2000;
                threadSleep( twoSecondsInMilliSeconds, fullTestCaseName ); // ensure
            }

            // perform file system operations

            // --- rename temporary copy to original name
            if ( !tmpFileCopy_cr.renameTo( file_cr ) ) {
                throw new IllegalStateException( "File '" + createdPartitionName + ".txt' could not be renamed to '" + createdPartitionName + "'" );
            }

            // --- delete deletedPartition on file system (using java.io.File
            // !!!)
            File file_dl = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, deletedPartition.getPri( ) );
            testObjects.add( file_dl );
            file_dl.delete( );

            // --- overwrite changedPartition with the copy which holds the
            // original content of this partition (using
            // java.io.File !!!)
            file_ch.delete( );
            if ( !tmpFileCopy_ch.renameTo( file_ch ) ) {
                throw new IllegalStateException( "File '" + changedPartitionName + ".txt' could not be renamed to '" + changedPartitionName + "'" );
            }

            // Precondition checks:
            // --------------------

            printPreconditionTestInfo( );

            // - is createdPartition only available in file system, but not in
            // DbIndex
            assertTrue( getPreconditionFailedMessage( "Partition is not in file system", createdPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, createdPartitionPri ) );

            assertFalse( getPreconditionFailedMessage( "Partition is in DB index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );

            // - is deletedPartition only available in DbIndex, but not in file
            // system
            assertFalse( getPreconditionFailedMessage( "Partition is in file system", deletedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, deletedPartitionPri ) );

            assertTrue( getPreconditionFailedMessage( "Partition is not in index", deletedPartitionPri ), isPartitionInIndex( deletedPartitionPri, clientSpecificStageName ) );

            // - is there a difference between changedPartition on file system
            // and changedPartition on DbIndex, i.e.:
            // changePartition is available in file system as well as in
            // DbIndex, but with different timestamp
            assertTrue( getPreconditionFailedMessage( "Partition is not in file system", changedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, changedPartitionPri ) );

            assertTrue( getPreconditionFailedMessage( "Partition is not in index", changedPartitionPri ), isPartitionInIndex( changedPartitionPri, clientSpecificStageName ) );

            if ( forced ) {
                // We left away the sleep --> the timestamp should normally be
                // the same (only in rare cases this will
                // fail
                // ...
                // --> this check cannot be used for nightly build and not as
                // smoke test ...)

                assertTrue( getPreconditionFailedMessage( "Timestamp of partition in file system and index is equal", changedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, changedPartitionPri ) == getTimestampFromIndex( changedPartitionPri,
                                                                                                                                                                                                                                                                             clientSpecificStageName ) );

            } else {
                assertTrue( getPreconditionFailedMessage( "Timestamp in file system is not the timestamp of the copied file", changedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, changedPartitionPri ) == timestampOfTmpFileCopy );

                assertTrue( getPreconditionFailedMessage( "Timestamp in index is not the original one", changedPartitionPri ), getTimestampFromIndex( changedPartitionPri, clientSpecificStageName ) == timestampOfOriginalFileAfterModification );

            }

            // Close connection, so that only the internal connection is
            // available
            if ( closeConnection ) {
                connection.close( );
            }

            // Operation which is tested: refreshFromFileSystem for the
            // respective EclipseProject
            // ----------------------------------------------------------------------------------

            printTestMethodInfo( "refreshFromFileSystem" );

            Exception exception = null;
            try {
                // getIdePrimaryFacility().refreshFromFileSystem(eclipseProject, forced);
                this.refreshEclipseResources( eclipseProject );
                // wait to have any notifications done before
                threadSleep( 1000, fullTestCaseName ); // ensure
            } catch ( RuntimeException e ) {
                e.printStackTrace( );
                exception = e;
            }

            // Postcondition checks:
            // ---------------------

            printPostconditionTestInfo( );

            // Retrieve open connection again in case it was closed before:
            if ( closeConnection ) {
                connection = getMoinConnection( );
            }

            // - no exception during execution of refreshFromFileSystem
            assertNull( getExceptionThrownAssertMessage( "refreshFromFileSystem", exception ), exception );

            // - is createdPartition available in file system as well as in
            // DbIndex and is identical (same timestamp)
            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", createdPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, createdPartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", createdPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, createdPartitionPri ) == getTimestampFromIndex( createdPartitionPri,
                                                                                                                                                                                                                                                                              clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", createdPartitionPri ), doesContainEqualMris( mrisInCreatedPartition, getMrisInPartition( createdPartitionPri, connection ) ) );

            // - is deletedPartition neither available in DbIndex nor in file
            // system

            System.out.println( "PRI which should not exist in index or file system : " + deletedPartitionPri.toString( ) );

            assertFalse( getPostconditionFailedMessage( "Partition is in file system", deletedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, deletedPartitionPri ) );

            assertFalse( getPostconditionFailedMessage( "Partition is in index", deletedPartitionPri ), isPartitionInIndex( deletedPartitionPri, clientSpecificStageName ) );

            assertNull( getPostconditionFailedMessage( "Model elements can be found in partition", deletedPartitionPri ), getMrisInPartition( deletedPartitionPri, connection ) );

            // - is there no difference between changedPartition on file system
            // and changedPartition on DbIndex, i.e.:
            // changePartition is available in file system as well as in
            // DbIndex, but with different timestamp
            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", changedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, changedPartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", changedPartitionPri ), isPartitionInIndex( changedPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", changedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, changedPartitionPri ) == getTimestampFromIndex( changedPartitionPri,
                                                                                                                                                                                                                                                                              clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Different model elements in partition in file system and index", changedPartitionPri ), doesContainEqualMris( mrisInChangedPartition, getMrisInPartition( changedPartitionPri, connection ) ) );
            assertTrue( getPostconditionFailedMessage( "Changed model element in partition from index is different", changedPartitionPri ), isModelElementInPartitionWithModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement, ORIGINAL_NAME_VALUE ) );

            // todo: Later: Advanced:
            // - check also for partitions with path
            // - check also for non-local partitions with different states (e.g.
            // checked-out-for-delete)
            // - check also if there is a second session to same client spec and
            // the partitions are also loaded in the
            // respective workspace there

            // todo: Later: additional postcondition checks:
            // - is a partition-created-event fired for createdPartition
            // - is a partition-content-changed-event fired for changedPartition
            // - is a partition-deleted-event fired for deletedPartition

            // todo: Later: side-effect tests could be added:
            // - is only the given container affected
            // - ...

            // Test end:
            // ---------

            // Clean-up of test objects:
            cleanUpTestObjects( testObjects, connection );

            testSucceeded = true; // succeeded includes the clean-up for the
            // test objects !!!

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        } finally {

            // Print test result
            if ( testSucceeded ) {
                printTestSucceededInfo( fullTestCaseName );
            } else {
                try {
                    // The test objects potentially have not yet been
                    // cleaned-up:
                    cleanUpTestObjects( testObjects, connection );
                } catch ( Exception e1 ) {
                    e1.printStackTrace( );
                }
                printTestFailedInfo( fullTestCaseName );
            }
        }


    }

    private void refreshEclipseResources( final IProject eclipseProject ) {

        if ( ResourcesPlugin.getWorkspace( ).isTreeLocked( ) ) {
            // situation as has been observed when being called from listeners
            // refresh is not possible anyhow, therefore try continue without refresh
            return;
        }
        IWorkspaceRunnable runnable = new IWorkspaceRunnable( ) {

            public void run( IProgressMonitor monitor ) {

                Exception firstEx = null;
                String failed = null;

                try {
                    eclipseProject.refreshLocal( IResource.DEPTH_INFINITE, NO_PROGRESS_MONITOR );
                } catch ( CoreException e ) {
                    failed = eclipseProject.getLocation( ).toOSString( );
                    if ( firstEx == null ) {
                        firstEx = e;
                    }
                }
                if ( firstEx != null ) {
                    throw new RuntimeException( new Exception( "Refreshing Eclipse resources failed for resources: " + failed, firstEx ) );
                }
            }
        };

        try {
            ResourcesPlugin.getWorkspace( ).run( runnable, eclipseProject, IWorkspace.AVOID_UPDATE, null );
        } catch ( CoreException e ) {
            throw new RuntimeException( e );
        }
    }

    @Test
    public void testCreateCloseOpenDeleteProject( ) throws Exception {

        final String SUB_TEST_CASE = "testCreateCloseOpenDeleteProject";
        String subTestCaseName = SUB_TEST_CASE;

        if ( Boolean.getBoolean( CHANGE_LISTENER_OFF ) ) {
            // test not applicable
            printTestInfo( "test not applicable - change listener not active" );
            return;
        }

        if ( Boolean.getBoolean( DC_CHANGE_LISTENER_OFF ) ) {
            // test not applicable
            printTestInfo( "test not applicable - dc change listener not active" );
            return;
        }

        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, SUB_TEST_CASE );

        boolean testSucceeded = false;

        // Test objects
        List testObjects = new ArrayList( );
        Connection connection = null;

        printTestBeginInfo( fullTestCaseName );

        try {

            // 1. create project and add content using standard means
            //
            //
            // - Deploy/Import MM for the model data which will be created
            // during test
            // todo: first check if MM is already imported, if not, then import

            // - Get or create the specific test-DC, including test-project in
            // the given default local DevConfig
            // todo: --> getter in TestHelper, see also in:
            // IdeNwdiTestClientImpl for concrete values
            // or getter in basis test class of IdeFacilityTests
            // todo: --> if DC already exists from previous test-run, then
            // clean-up the test data inside
            // dcName-length restriction from DbIndex: 80 characters
            // 'test.sap.com\tc\moin\facility\test\\dcToBeRefreshed' --> 71 -->
            // test case name can have length <= 29
            String subTestCaseNameWithRestrictedLength = subTestCaseName.length( ) <= 29 ? subTestCaseName : subTestCaseName.substring( 0, 29 );
            String dcVendor = "test.sap.com";
            String dcName = "tc/moin/facility/test/" + subTestCaseNameWithRestrictedLength + "/dcToBeRefreshed";
            String fullDcName = dcVendor + "/" + dcName;
            final IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName );
            final IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent( eclipseProject );

            ClientSpec clientSpec = getIdeFacilityDispatcher( ).getClientSpec( eclipseProject );
            String clientSpecificStageName = getClientSpecificStageName( clientSpec );

            // The standard test project and the testProject in this test case
            // both are located in the default local
            // devConfig
            // --> we can use the standard MOIN connection in this test
            connection = getMoinConnection( );

            // - Create the test partitions in the test DC:

            // -- create an additional partition 'createdPartition' only on file
            // system, not in DbIndex

            // --- create and fill partition and save --> partition available in
            // MOIN workspaces, on FS, in DB
            String createdPartitionName = makePartitionName( "createdPartition" );
            String dataAreaId = clientSpec.getDataArea( ).getName( );
            IpiFsResourceManagement abstractFsPersistence = getResourceManagement( );
            CRI cri = getResourceIdentifierFactory( ).createCri( dataAreaId, fullDcName );
            Set<String> rootPaths = ( (ResourceManagementImpl) abstractFsPersistence ).getRegisteredRootPathsForContainer( cri );

            String root = rootPaths.iterator( ).next( );
            Map<String, String> resourcesAndPath = new HashMap<String, String>( );
            resourcesAndPath.put( "src/test1/", root );
            resourcesAndPath.put( "src/test2/", root );
            ResourceFoldersRecord resourceFoldersRecord = new ResourceFoldersRecord( );
            resourceFoldersRecord.resourceFolderPathsToRootPaths = resourcesAndPath;
            abstractFsPersistence.updateContainer( cri, resourceFoldersRecord, false );

            ModelPartition createdPartition = createPartition( clientSpec, fullDcName, "src/test1/" + createdPartitionName );
            PRI createdPartitionPri = createdPartition.getPri( );
            testObjects.add( createdPartitionPri );
            List<MRI> mrisInCreatedPartition = fillPartitionWithMofModel( connection, createdPartition, "create" );
            File file = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, createdPartitionPri );
            testObjects.add( file );

            ModelPartition createdPartition2 = createPartition( clientSpec, fullDcName, "src/test2/" + createdPartitionName );
            PRI createdPartitionPri2 = createdPartition2.getPri( );
            testObjects.add( createdPartitionPri2 );
            List<MRI> mrisInCreatedPartition2 = fillPartitionWithMofModel( connection, createdPartition2, "create2" );
            File file2 = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, createdPartitionPri2 );
            testObjects.add( file2 );
            connection.save( );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", createdPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, createdPartitionPri ) == getTimestampFromIndex( createdPartitionPri,
                                                                                                                                                                                                                                                                              clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", createdPartitionPri ), doesContainEqualMris( mrisInCreatedPartition, getMrisInPartition( createdPartitionPri, connection ) ) );
            assertNotNull( getPostconditionFailedMessage( "No model elements can be found in partition", createdPartitionPri ), getMrisInPartition( createdPartitionPri, connection ) );

            // 2. close project
            //
            Exception exception = null;
            try {
                String message = "----- close project -----";
                java.lang.System.out.println( message );
                java.lang.System.out.flush( );
                eclipseProject.close( NO_PROGRESS_MONITOR );
                // wait to give the core notification a chance
                //Thread.sleep( 2500 );
                waitPartition( "eclipseProject.close", false, createdPartitionPri, clientSpecificStageName, connection );
            } catch ( CoreException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
                exception = e;
            }
            // - no exception during execution of refreshFromFileSystem
            assertNull( getExceptionThrownAssertMessage( "eclipseProject.close", exception ), exception );

            assertFalse( getPostconditionFailedMessage( "Partition is in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );

            assertFalse( getPostconditionFailedMessage( "Partition is alive", createdPartitionPri ), isAlive( createdPartitionPri, connection ) );

            //
            try {
                String message = "----- open project -----";
                java.lang.System.out.println( message );
                java.lang.System.out.flush( );
                eclipseProject.open( NO_PROGRESS_MONITOR );
                // wait to give the core notification a chance
                waitPartition( "eclipseProject.open", true, createdPartitionPri, clientSpecificStageName, connection );
                //Thread.sleep( 5000 );
            } catch ( CoreException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
                exception = e;
            }
            // - no exception during execution of refreshFromFileSystem
            assertNull( getExceptionThrownAssertMessage( "eclipseProject.open", exception ), exception );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", createdPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, createdPartitionPri ) == getTimestampFromIndex( createdPartitionPri,
                                                                                                                                                                                                                                                                              clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", createdPartitionPri ), doesContainEqualMris( mrisInCreatedPartition, getMrisInPartition( createdPartitionPri, connection ) ) );
            assertNotNull( getPostconditionFailedMessage( "No model elements can be found in partition", createdPartitionPri ), getMrisInPartition( createdPartitionPri, connection ) );

            // 4. delete project
            //
            try {
                String message = "----- delete project -----";
                java.lang.System.out.println( message );
                java.lang.System.out.flush( );
                eclipseProject.delete( IResource.NEVER_DELETE_PROJECT_CONTENT, NO_PROGRESS_MONITOR );
                // this older case causes inconsistencies in component handling:
                waitPartition( "eclipseProject.delete", false, createdPartitionPri, clientSpecificStageName, connection );
                //Thread.sleep( 5000 );

            } catch ( CoreException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
                exception = e;
            }
            // - no exception during execution of refreshFromFileSystem
            assertNull( getExceptionThrownAssertMessage( "eclipseProject.delete", exception ), exception );

            assertFalse( getPostconditionFailedMessage( "Partition is in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );

            // FIXME: reenable assert
            /**
             * Condition can actually not be fulfilled, because the clientspec
             * is not available for a closed project Hopefully this can be
             * resolved using adaption from core colleagues, not requiring the
             * clientspec anymore.
             */
            //            assertNull(getPostconditionFailedMessage("Model elements can be found in partition", createdPartitionPri),
            //                getMrisInPartition(createdPartitionPri, connection));
            // Test end:
            // ---------
            // Clean-up of test objects:
            cleanUpTestObjects( testObjects, connection );

            testSucceeded = true; // succeeded includes the clean-up for the
            // test objects !!!

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        } finally {

            // Print test result
            if ( testSucceeded ) {
                printTestSucceededInfo( fullTestCaseName );
            } else {
                try {
                    // The test objects potentially have not yet been
                    // cleaned-up:
                    cleanUpTestObjects( testObjects, connection );
                } catch ( Exception e1 ) {
                    e1.printStackTrace( );
                }
                printTestFailedInfo( fullTestCaseName );
            }
        }
    }

    @Test
    public void testProjectArchive( ) throws Exception {

        final String SUB_TEST_CASE = "testProjectArchive";
        String subTestCaseName = SUB_TEST_CASE;

        if ( Boolean.getBoolean( CHANGE_LISTENER_OFF ) ) {
            // test not applicable
            printTestInfo( "test not applicable - change listener not active" );
            return;
        }

        if ( Boolean.getBoolean( DC_CHANGE_LISTENER_OFF ) ) {
            // test not applicable
            printTestInfo( "test not applicable - dc change listener not active" );
            return;
        }

        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, SUB_TEST_CASE );

        boolean testSucceeded = false;

        // Test objects
        List testObjects = new ArrayList( );
        Connection connection = null;

        printTestBeginInfo( fullTestCaseName );

        try {

            // 1. create project and add content using standard means
            //
            //
            // - Deploy/Import MM for the model data which will be created
            // during test
            // todo: first check if MM is already imported, if not, then import

            // - Get or create the specific test-DC, including test-project in
            // the given default local DevConfig
            // todo: --> getter in TestHelper, see also in:
            // IdeNwdiTestClientImpl for concrete values
            // or getter in basis test class of IdeFacilityTests
            // todo: --> if DC already exists from previous test-run, then
            // clean-up the test data inside
            // dcName-length restriction from DbIndex: 80 characters
            // 'test.sap.com\tc\moin\facility\test\\dcToBeRefreshed' --> 71 -->
            // test case name can have length <= 29
            String subTestCaseNameWithRestrictedLength = "tPA";//subTestCaseName.length( ) <= 29 ? subTestCaseName : subTestCaseName.substring( 0, 29 );
            String dcVendor = "test.sap.com";
            String dcName = "test/moin/" + subTestCaseNameWithRestrictedLength + "/dc";
            String fullDcName = dcVendor + "/" + dcName;
            // IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName ); MoinTestDcType vs. MoinMetaModelDcType

            final IProject eclipseProject = MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).getOrCreateLocalMoinDCProject( MoinMetaModelDcType.getDcType( ), dcVendor, dcName, MOIN_IDE_TEST_HELPER.DO_INITIALIZE );
            final IDevelopmentComponent developmentComponent = DiiResourceService.getDevelopmentComponent( eclipseProject );

            ClientSpec clientSpec = getIdeFacilityDispatcher( ).getClientSpec( eclipseProject );
            String clientSpecificStageName = getClientSpecificStageName( clientSpec );

            // The standard test project and the testProject in this test case
            // both are located in the default local
            // devConfig
            // --> we can use the standard MOIN connection in this test
            connection = getMoinConnection( );
            String dataAreaId = clientSpec.getDataArea( ).getName( );
            CRI cri = getResourceIdentifierFactory( ).createCri( dataAreaId, fullDcName );

            // - Create the test partitions in the test DC:

            // -- first version: deletePartition, changePartition

            // --- create and fill partition and save 
            String deletePartitionName = makePartitionName( "deletePartition" );
            ModelPartition deletePartition = createPartition( clientSpec, fullDcName, "moin/meta/" + deletePartitionName );
            PRI deletePartitionPri = deletePartition.getPri( );
            testObjects.add( deletePartitionPri );
            List<MRI> mrisInDeletePartition = fillPartitionWithMofModel( connection, deletePartition, "delete" );
            File file = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, deletePartitionPri );
            testObjects.add( file );

            connection.save( );

            String changePartitionName = makePartitionName( "changePartition" );
            ModelPartition changePartition = createPartition( clientSpec, fullDcName, "moin/meta/" + changePartitionName );
            PRI changePartitionPri = changePartition.getPri( );
            testObjects.add( changePartitionPri );
            List<MRI> mrisInChangedPartition = fillPartitionWithMofModel( connection, changePartition, "change" );
            String mofIdOfChangedModelElement = getMofIdOfAnyMofClass( changePartition );
            changeModelElementInPartitionWithsModelElements( connection, mrisInChangedPartition, mofIdOfChangedModelElement, ORIGINAL_NAME_VALUE );
            connection.save( );

            // first check after creation

            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", deletePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, deletePartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", deletePartitionPri ), isPartitionInIndex( deletePartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", deletePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, deletePartitionPri ) == getTimestampFromIndex( deletePartitionPri,
                                                                                                                                                                                                                                                                            clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", deletePartitionPri ), doesContainEqualMris( mrisInDeletePartition, getMrisInPartition( deletePartitionPri, connection ) ) );
            assertNotNull( getPostconditionFailedMessage( "No model elements can be found in partition", deletePartitionPri ), getMrisInPartition( deletePartitionPri, connection ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", changePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, changePartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", changePartitionPri ), isPartitionInIndex( changePartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", changePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, changePartitionPri ) == getTimestampFromIndex( changePartitionPri,
                                                                                                                                                                                                                                                                            clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Different model elements in partition in file system and index", changePartitionPri ), doesContainEqualMris( mrisInChangedPartition, getMrisInPartition( changePartitionPri, connection ) ) );
            assertTrue( getPostconditionFailedMessage( "Changed model element in partition from index is different", changePartitionPri ), isModelElementInPartitionWithModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement, ORIGINAL_NAME_VALUE ) );
            Exception exception = null;


            // 2. build archive 
            java.lang.System.out.println( "----- build dc -----" );
            java.lang.System.out.flush( );
            boolean buildOk = MOIN_IDE_TEST_HELPER.getDcBuildUtil( ).executeDcBuildForLocalMMDc( developmentComponent );
            assertTrue( "Build failed for development component " + developmentComponent, buildOk );


            // 3. change project
            // -- delete partition
            deletePartition.delete( );
            connection.save( );

            // -- change partition
            changeModelElementInPartitionWithsModelElements( connection, mrisInChangedPartition, mofIdOfChangedModelElement, CHANGED_NAME_VALUE );
            connection.save( );

            // -- create new partition
            String createPartitionName = makePartitionName( "createPartition" );
            ModelPartition createPartition = createPartition( clientSpec, fullDcName, "moin/meta/" + createPartitionName );
            PRI createPartitionPri = createPartition.getPri( );
            testObjects.add( createPartitionPri );
            List<MRI> mrisInCreatePartition = fillPartitionWithMofModel( connection, createPartition, "create" );
            connection.save( );

            // -- check new state
            assertFalse( getPostconditionFailedMessage( "Partition is in file system", deletePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, deletePartitionPri ) );
            assertFalse( getPostconditionFailedMessage( "Partition is in index", deletePartitionPri ), isPartitionInIndex( deletePartitionPri, clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", createPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, createPartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", createPartitionPri ), isPartitionInIndex( createPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", createPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, createPartitionPri ) == getTimestampFromIndex( createPartitionPri,
                                                                                                                                                                                                                                                                            clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", createPartitionPri ), doesContainEqualMris( mrisInCreatePartition, getMrisInPartition( createPartitionPri, connection ) ) );
            assertNotNull( getPostconditionFailedMessage( "No model elements can be found in partition", createPartitionPri ), getMrisInPartition( createPartitionPri, connection ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", changePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, changePartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", changePartitionPri ), isPartitionInIndex( changePartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", changePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, changePartitionPri ) == getTimestampFromIndex( changePartitionPri,
                                                                                                                                                                                                                                                                            clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Different model elements in partition in file system and index", changePartitionPri ), doesContainEqualMris( mrisInChangedPartition, getMrisInPartition( changePartitionPri, connection ) ) );
            assertTrue( getPostconditionFailedMessage( "Changed model element in partition from index is different", changePartitionPri ), isModelElementInPartitionWithModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement, CHANGED_NAME_VALUE ) );

            // 4. close project: nothing visible
            exception = null;
            try {
                String message = "----- close project -----";
                java.lang.System.out.println( message );
                java.lang.System.out.flush( );
                eclipseProject.close( NO_PROGRESS_MONITOR );
                // wait to give the core notification a chance
                // ignoring dirty archive: no partitions with closed project
                waitPartition( "eclipseProject.closeAfterBuild", false, createPartitionPri, clientSpecificStageName, connection );
                // accounting for dirty archive: old state without change is visible
//                waitPartition( true, deletePartitionPri, clientSpecificStageName, connection );
            } catch ( CoreException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
                exception = e;
            }
            // - no exception 
            assertNull( getExceptionThrownAssertMessage( "eclipseProject.closeAfterBuild", exception ), exception );

//            // accounting for dirty archive: old state without change is visible
//            assertTrue( getPostconditionFailedMessage( "Partition is not in index", deletePartitionPri ), isPartitionInIndex( deletePartitionPri, clientSpecificStageName ) );
//            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", deletePartitionPri ), doesContainEqualMris( mrisInDeletePartition, getMrisInPartition( deletePartitionPri, connection ) ) );
//            assertNotNull( getPostconditionFailedMessage( "No model elements can be found in partition", deletePartitionPri ), getMrisInPartition( deletePartitionPri, connection ) );
//
//            assertTrue( getPostconditionFailedMessage( "Partition is not in index", changePartitionPri ), isPartitionInIndex( changePartitionPri, clientSpecificStageName ) );
//
//            assertTrue( getPostconditionFailedMessage( "Different model elements in partition in file system and index", changePartitionPri ), doesContainEqualMris( mrisInChangedPartition, getMrisInPartition( changePartitionPri, connection ) ) );
//            assertTrue( getPostconditionFailedMessage( "Changed model element in partition from index is different", changePartitionPri ), isModelElementInPartitionWithServiceInterationsModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement,
//                                                                                                                                                                                                                         ORIGINAL_MESSAGE_TYPE_VALUE ) );
//            assertFalse( getPostconditionFailedMessage( "Partition is in index", createPartitionPri ), isPartitionInIndex( createPartitionPri, clientSpecificStageName ) );

            // ignoring dirty archive: no partitions with closed project
            assertFalse( getPostconditionFailedMessage( "Partition is in index", deletePartitionPri ), isPartitionInIndex( createPartitionPri, clientSpecificStageName ) );
            assertFalse( getPostconditionFailedMessage( "Partition is in index", changePartitionPri ), isPartitionInIndex( createPartitionPri, clientSpecificStageName ) );
            assertFalse( getPostconditionFailedMessage( "Partition is in index", createPartitionPri ), isPartitionInIndex( createPartitionPri, clientSpecificStageName ) );

            // 5. build closed project: change visible
            java.lang.System.out.println( "----- build dc -----" );
            java.lang.System.out.flush( );
            buildOk = MOIN_IDE_TEST_HELPER.getDcBuildUtil( ).executeDcBuildForLocalMMDc( developmentComponent );
            assertTrue( "Build failed for development component " + developmentComponent, buildOk );

            waitPartition( "buildDCForClosedProject", true, createPartitionPri, clientSpecificStageName, connection );

            // -- check new state
            assertFalse( getPostconditionFailedMessage( "Partition is in index", deletePartitionPri ), isPartitionInIndex( deletePartitionPri, clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", createPartitionPri ), isPartitionInIndex( createPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", createPartitionPri ), doesContainEqualMris( mrisInCreatePartition, getMrisInPartition( createPartitionPri, connection ) ) );
            assertNotNull( getPostconditionFailedMessage( "No model elements can be found in partition", createPartitionPri ), getMrisInPartition( createPartitionPri, connection ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", changePartitionPri ), isPartitionInIndex( changePartitionPri, clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Different model elements in partition in file system and index", changePartitionPri ), doesContainEqualMris( mrisInChangedPartition, getMrisInPartition( changePartitionPri, connection ) ) );
            assertTrue( getPostconditionFailedMessage( "Changed model element in partition from index is different", changePartitionPri ), isModelElementInPartitionWithModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement, CHANGED_NAME_VALUE ) );

            // reopen project: change visible 
            // - open project
            exception = null;
            try {
                String message = "----- open project -----";
                java.lang.System.out.println( message );
                java.lang.System.out.flush( );
                eclipseProject.open( NO_PROGRESS_MONITOR );
                // wait to give the core notification a chance
                threadSleep( 4000, fullTestCaseName );
            } catch ( CoreException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
                exception = e;
            }
            // - no exception 
            assertNull( getExceptionThrownAssertMessage( "eclipseProject.open", exception ), exception );

            // -- check 
            assertFalse( getPostconditionFailedMessage( "Partition is in file system", deletePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, deletePartitionPri ) );
            assertFalse( getPostconditionFailedMessage( "Partition is in index", deletePartitionPri ), isPartitionInIndex( deletePartitionPri, clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", createPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, createPartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", createPartitionPri ), isPartitionInIndex( createPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", createPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, createPartitionPri ) == getTimestampFromIndex( createPartitionPri,
                                                                                                                                                                                                                                                                            clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Content of partition in file system and index is different", createPartitionPri ), doesContainEqualMris( mrisInCreatePartition, getMrisInPartition( createPartitionPri, connection ) ) );
            assertNotNull( getPostconditionFailedMessage( "No model elements can be found in partition", createPartitionPri ), getMrisInPartition( createPartitionPri, connection ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in file system", changePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, changePartitionPri ) );

            assertTrue( getPostconditionFailedMessage( "Partition is not in index", changePartitionPri ), isPartitionInIndex( changePartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Timestamp of partition in file system and index is different", changePartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).getTimestampFromFileSystem( eclipseProject, changePartitionPri ) == getTimestampFromIndex( changePartitionPri,
                                                                                                                                                                                                                                                                            clientSpecificStageName ) );

            assertTrue( getPostconditionFailedMessage( "Different model elements in partition in file system and index", changePartitionPri ), doesContainEqualMris( mrisInChangedPartition, getMrisInPartition( changePartitionPri, connection ) ) );
            assertTrue( getPostconditionFailedMessage( "Changed model element in partition from index is different", changePartitionPri ), isModelElementInPartitionWithModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement, CHANGED_NAME_VALUE ) );

            // last. delete project
            //
            try {
                String message = "----- delete project -----";
                java.lang.System.out.println( message );
                java.lang.System.out.flush( );

                eclipseProject.delete( IResource.NEVER_DELETE_PROJECT_CONTENT, NO_PROGRESS_MONITOR );
                // this older case causes inconsistencies in component handling:
                // eclipseProject.delete( true, NO_PROGRESS_MONITOR );

                boolean deleteDcs = MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).deleteDcs( new IDevelopmentComponent[] { developmentComponent } );
                assertTrue( "Cleanup failed for development component " + developmentComponent, deleteDcs );
                // todo: Dii05 currently does not send event for the deletion of DCs
                getIdePrimaryFacility( ).refreshFromFileSystem( eclipseProject, false );
                //getIdeDiService( ).refreshFromFileSystem( developmentComponent, false );

                // wait to give the core notification a chance
                // Thread.sleep( 5000 );
            } catch ( CoreException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
                exception = e;
            }
            // - no exception during execution of refreshFromFileSystem
            assertNull( getExceptionThrownAssertMessage( "eclipseProject.delete", exception ), exception );

//            assertFalse( getPostconditionFailedMessage( "Partition is in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );

            // FIXME: reenable assert
            /**
             * Condition can actually not be fulfilled, because the clientspec
             * is not available for a closed project Hopefully this can be
             * resolved using adaption from core colleagues, not requiring the
             * clientspec anymore.
             */
            //            assertNull(getPostconditionFailedMessage("Model elements can be found in partition", createdPartitionPri),
            //                getMrisInPartition(createdPartitionPri, connection));
            // Test end:
            // ---------
            // Clean-up of test objects:
            cleanUpTestObjects( testObjects, connection );

            testSucceeded = true; // succeeded includes the clean-up for the
            // test objects !!!

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        } finally {

            // Print test result
            if ( testSucceeded ) {
                printTestSucceededInfo( fullTestCaseName );
            } else {
                try {
                    // The test objects potentially have not yet been
                    // cleaned-up:
                    cleanUpTestObjects( testObjects, connection );
                } catch ( Exception e1 ) {
                    e1.printStackTrace( );
                }
                printTestFailedInfo( fullTestCaseName );
            }
        }
    }

    private void waitPartition( String testedMethod, boolean isThere, PRI partitionPri, String clientSpecificStageName, Connection connection ) throws Exception {

        // We wait max MAX_WAITING_FOR_PERSISTENCE_EVENTS sec for the persistence refresh, which is asynchronously performed.
        // This might take more time due to the scheduling (separate Java Thread) and due to required Lock (MoinCoreWriteLock). 
        int max_counter = MAX_WAITING_FOR_EVENTS / 100;
        int counter = max_counter;
        while ( counter > 0 && !checkItem( isThere, partitionPri, clientSpecificStageName, connection ) ) {
            threadSleep( 100, testedMethod );
            counter--;
        }
        printTestInfo( "Waiting for persistence refresh: " + ( max_counter - counter + 1 ) + " times 100 msec." );

    }

    private boolean checkItem( boolean isThere, PRI partitionPri, String clientSpecificStageName, Connection connection ) {

        if ( isThere ) {
            if ( connection == null ) {
                return isPartitionInIndex( partitionPri, clientSpecificStageName );
            }
//            if ( connection != null ) {
//                // forced version to check core response
//                return ( getMrisInPartition( partitionPri, connection ) != null );
//            }
            return ( isPartitionInIndex( partitionPri, clientSpecificStageName ) && ( getMrisInPartition( partitionPri, connection ) != null ) );
        } else {
            if ( connection == null ) {
                return !isPartitionInIndex( partitionPri, clientSpecificStageName );
            }
//            if ( connection != null ) {
//                // forced version to check core response
//                return ( getMrisInPartition( partitionPri, connection ) == null );
//            }
            return ( !isPartitionInIndex( partitionPri, clientSpecificStageName ) && ( !isAlive( partitionPri, connection ) ) );
        }
    }


    private boolean isAlive( PRI partitionPri, Connection connection ) {

        ModelPartition partition = connection.getPartition( partitionPri );
        if ( partition == null ) {
            return false;
        }
        return partition.isAlive( );
    }

    /**
     * Have an own separate method to generate partition content for several
     * partitions in one container. The packages for each partition should be
     * named uniquely, as we otherwise would have conflicts with the other
     * partitions packages. The package separator is taken for this, basically
     * to distinguish partitions for the create, the change and the delete test
     * case. A simpler standard fill pmethod could be found at {@link
     * UtilityModelCreation.fillPartitionWithMofModel(Connection,
     * ModelPartition)}
     * 
     * @param connection
     * @param partition
     * @param packageSeparator Unique discriminator to differ packages for one
     * partition
     * @return
     */
    private List<MRI> fillPartitionWithMofModel( Connection connection, ModelPartition partition, String packageSeparator ) {

        ModelPackage modelPackage = (ModelPackage) connection.getPackage( null, "Model" );

        List<RefObject> modelElements = new ArrayList<RefObject>( );

        // - create multiple packages
        MofPackage package1 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage package2 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage package3 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage package4 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        setDefaultAttributes( package1 );
        setDefaultAttributes( package2 );
        setDefaultAttributes( package3 );
        setDefaultAttributes( package4 );
        modelElements.add( package1 );
        modelElements.add( package2 );
        modelElements.add( package3 );
        modelElements.add( package4 );

        // - create associations

        // - create classes
        MofClass class1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class3 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        setDefaultAttributes( class1 );
        setDefaultAttributes( class2 );
        setDefaultAttributes( class3 );
        List<ModelElement> p1 = package1.getContents( );
        p1.add( class1 );
        p1.add( class2 );
        p1.add( class3 );

        MofClass class4 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass class5 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        setDefaultAttributes( class4 );
        setDefaultAttributes( class5 );
        List<ModelElement> p2 = package2.getContents( );
        p2.add( class4 );
        p2.add( class5 );

        MofClass class6 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        setDefaultAttributes( class6 );
        package3.getContents( ).add( class6 );

        modelElements.add( class1 );
        modelElements.add( class2 );
        modelElements.add( class3 );
        modelElements.add( class4 );
        modelElements.add( class5 );
        modelElements.add( class6 );

        // Assign the created model elements to the given partition
        // Determine and return the MRIs of the created model elements:

        List<MRI> mris = new ArrayList( modelElements.size( ) );
        for ( RefObject refObject : modelElements ) {
            partition.assignElement( refObject );
            mris.add( ( (Partitionable) refObject ).get___Mri( ) );
        }

        // set names including packageSeparator to avoid package conflicts with further partitions
        assertNotNull( "Invalid package separator: null", packageSeparator );
        package1.setName( "package1" + packageSeparator );
        package2.setName( "package2" + packageSeparator );
        package3.setName( "package3" + packageSeparator );
        package4.setName( "package4" + packageSeparator );
        class1.setName( "class1" );
        class2.setName( "class2" );
        class3.setName( "class3" );
        class4.setName( "class4" );
        class5.setName( "class5" );
        class6.setName( "class6" );

        return mris;
    }

    private void setDefaultAttributes( GeneralizableElement element ) {

        // These attributes are required to avoid underflow constraint check errors in mof editor
        element.setAnnotation( "" );
        element.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
    }

    /**
     * Performs the changes which later are tested in method
     * isModelElementInPartitionWithServiceInterationsModelElementsCorrectlyChanged
     * 
     * @param connection MOIN connection
     * @param mrisInPartition
     * @param mofIdOfMessage
     * @param changedNameValue
     */
    private void changeModelElementInPartitionWithsModelElements( Connection connection, List<MRI> mrisInPartition, String mofIdOfMessage, String changedNameValue ) {

        for ( MRI mri : mrisInPartition ) {
            if ( mri.getMofId( ).equals( mofIdOfMessage ) ) {
                RefBaseObject modelElement = connection.getElement( mri );
                // We change the type attribute of the first message we find,
                // that should be enough 'changedContent' for
                // this test case (if not, then additional changes can be
                // performed ...)
                if ( modelElement instanceof MofClass ) {
                    MofClass mofClass = (MofClass) modelElement;
                    mofClass.setName( changedNameValue );
                    return;
                }
            }
        }

        // Given partition did not contain a message
        throw new IllegalStateException( "Internal test error: test tries to change partition with wrong content" );
    }

    /**
     * Tests if the concrete changes performed in method
     * changeModelElementInPartitionWithServiceInteractionsModelElements are
     * still there in the given model elements.
     * 
     * @param connection MOIN connection
     * @param mrisInPartition
     * @param mofIdOfChangedModelElement
     * @param nameValueToBeChecked
     * @return
     */
    private boolean isModelElementInPartitionWithModelElementsCorrectlyChanged( Connection connection, List<MRI> mrisInPartition, String mofIdOfChangedModelElement, String nameValueToBeChecked ) {

        for ( MRI mri : mrisInPartition ) {
            RefBaseObject modelElement = connection.getElement( mri );
            if ( mofIdOfChangedModelElement.equals( modelElement.refMofId( ) ) ) {
                if ( modelElement instanceof MofClass ) {
                    MofClass mofClass = (MofClass) modelElement;
                    if ( nameValueToBeChecked.equals( mofClass.getName( ) ) ) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    /**
     * Get the MOF ID for one of the model element which is a MofClass.
     */
    private String getMofIdOfAnyMofClass( ModelPartition partition ) {

        Collection<Partitionable> modelElements = partition.getElements( );
        for ( Partitionable modelElement : modelElements ) {
            if ( modelElement instanceof MofClass ) {
                return modelElement.refMofId( );
            }
        }
        return null;
    }

}
