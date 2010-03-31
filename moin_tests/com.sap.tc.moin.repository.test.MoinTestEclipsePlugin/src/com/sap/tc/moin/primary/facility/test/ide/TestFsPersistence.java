package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.junit.Before;
import org.junit.Test;

import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.facility.primary.ipi.IpiDiCri;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimIndexQueryService;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.testcases.case002.C2;

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
public class TestFsPersistence extends FacilityIdeMoinTest {

    private static final String TEST_CASE = "TestFsPersistence";

    private static final String JAVA_IO_TMPDIR = SunSystemPropertyKeys.JAVA_IO_TMPDIR;

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

        // Retrieve the packageExtend for the MetaModel (which later is needed
        // to create the respective model
        // elements)
        String modelContainerName = null;
        String[] qualifiedName = new String[] { TestMetaModels.SERVICE_INTERACTIONS };
        this._packageExtendForServiceInteractionsModels = (ServiceInteractionsPackage) ( getMoinConnection( ).getPackage( modelContainerName, qualifiedName ) );
        if ( this._packageExtendForServiceInteractionsModels == null ) {
            throw new RuntimeException( "PackageExtend for ServiceInteraction models could not be retrieved." );
        }
    }

    /*
     * Test class was not executed in any test suite, so this test was commented
     * as it is put in a test suite.
     */
//    @Test
//    public void testCreateAndReadModelArchives( ) throws Exception {
//
//        final String subTestCaseName = "testCreateAndReadModelArchives";
//        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, subTestCaseName );
//        boolean testSucceeded = false;
//        List testObjects = new ArrayList( );
//
//        printTestBeginInfo( fullTestCaseName );
//
//        Connection connection = null;
//
//        // hot_todo: introduce IdeTestClient derived from TestClient, which
//        // provides specific methods which take the
//        // name of the DC and partition as parameter (else: the partition is
//        // created with fixed name in default-dc)
//        // this might help: TestClientFactory testClientFactory =
//        // MOIN_TEST_HELPER.getTestClientFactory(
//        // idePrimaryFacility.getId() );
//        // current state here: myTestClient is not used, but own helper methods
//        // for creation of partition
//        TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( this.NEW_INSTANCE );
//
//        // Preparation of test:
//        // --------------------
//        // Create/Determine the needed test data: test project, test partitions
//        // in this project, …
//
//        printTestPreparationInfo( );
//
//        // - Deploy/Import MM for the model data which will be created during
//        // test
//        // todo: first check if MM is already imported, if not, then import
//
//        // - Get or create the specific test-DC, including test-project in the
//        // given default local DevConfig
//        // todo: --> getter in TestHelper, see also in: IdeNwdiTestClientImpl
//        // for concrete values
//        // or getter in basis test class of IdeFacilityTests
//        // todo: --> if DC already exists from previous test-run, then clean-up
//        // the test data inside
//        // dcName-length restriction from DbIndex: 80 characters
//        // 'test.sap.com\tc\moin\facility\test\\dcToBeRefreshed' --> 71 --> test
//        // case name can have length <= 29
//        String subTestCaseNameWithRestrictedLength = subTestCaseName.length( ) <= 29 ? subTestCaseName : subTestCaseName.substring( 0, 29 );
//        String dcVendor = "test.sap.com";
//        String dcName = "tc/moin/facility/test/" + subTestCaseNameWithRestrictedLength;
//        String fullDcName = dcVendor + "/" + dcName;
//        IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName );
//
//        ClientSpec clientSpec = getIdePrimaryFacility( ).getClientSpec( eclipseProject );
//        String dataAreaId = clientSpec.getDataArea( ).getName( );
//
//        // setup different resource folders
//        Map<String, String> rf = new HashMap<String, String>( 5 );
//
//        List<String> rfList = new ArrayList<String>( 5 );
//        for ( int i = 0; i < 4; i++ ) {
//            String rfstr = "src/testrf" + String.valueOf( i );
//            String rfTarget = eclipseProject.getName( ) + "/" + rfstr;
//            rf.put( rfstr, rfTarget );
//            rfList.add( rfstr );
//        }
//
//        ResourceFoldersRecord resourceFolders = new ResourceFoldersRecord( );
//        resourceFolders.resourceFolderPathsToRootPaths = rf;
//
//
//        // storage configuration
//        CRI cri = this.getResourceIdentifierFactory( ).createCri( dataAreaId, fullDcName );
//        ( (IdePrimaryFacilityImpl) getIdePrimaryFacility( ) ).getResourceManagement( ).updateContainer( cri, resourceFolders, false );
//
//        // register suffix
//        String containerId = fullDcName;
//        Set<String> allowedSuffixes = new HashSet<String>( 3 );
//        allowedSuffixes.add( ".xmi" );
//        allowedSuffixes.add( MoinTestHelper.TEST_PARTITION_SUFFIX );
//        allowedSuffixes.add( ".tst" );
//        for ( Iterator<String> it = rfList.iterator( ); it.hasNext( ); ) {
//            String resourceFolderId = it.next( );
//            ( (IdePrimaryFacilityImpl) getIdePrimaryFacility( ) ).getPartitionSuffixRegistry( ).registerPartitionSuffixes( allowedSuffixes );
//        }
//
//        // String clientSpecificStageName = getClientSpecificStageName(
//        // clientSpec );
//
//        // The standard test project and the testProject in this test case both
//        // are located in the default local
//        // devConfig
//        // --> we can use the standard MOIN connection in this test
//        connection = getMoinConnection( );
//
//        // - Create the test partitions in the test DC:
//
//        // -- create an additional partition 'createdPartition' only on file
//        // system, not in DbIndex
//
//        // --- create and fill partition and save --> partition available in
//        // MOIN workspaces, on FS, in DB
//        List<PRI> partitions = new ArrayList<PRI>( 5 );
//        for ( int i = 0; i < 4; i++ ) {
//            String rfstr = "src/testrf" + String.valueOf( i );
//            ModelPartition createdRfPartition = createPartition( clientSpec, fullDcName, rfstr + "/" + String.valueOf( i ) + makePartitionName( "createdPartition" ) );
//            PRI createdRfPartitionPri = createdRfPartition.getPri( );
//            partitions.add( createdRfPartitionPri );
//            testObjects.add( createdRfPartitionPri );
//            List<MRI> mrisInCreatedPartition = fillPartitionWithServiceInteractionsModelElements( createdRfPartition );
//        }
//        connection.save( );
//
//        // keep ziplocations
//        List<String> ziplist = new ArrayList<String>( 5 );
//
//        // pack zips
//        String eStr = eclipseProject.getLocation( ).toString( );
//        for ( Iterator<String> it = rfList.iterator( ); it.hasNext( ); ) {
//            String rfStr = it.next( );
//            IResource folder = eclipseProject.findMember( rfStr );
//            File file = folder.getLocation( ).toFile( );
//            File zipFile = new File( eStr, file.getName( ) + ".zip" );
//            FsFolder.createDirsOfPath( zipFile.getAbsolutePath( ) );
//            String eclipsePath = eclipseProject.getFullPath( ).toString( ) + "/" + file.getName( ) + ".zip";
//
//            // output stream
//            ZipOutputStream out = new ZipOutputStream( new FileOutputStream( zipFile ) );
//            // set archive mode
//            out.setMethod( ZipOutputStream.DEFLATED );
//
//            // get files and add them with relative path below this folder
//            this.addChildren( out, file, null );
//            out.close( );
//            ziplist.add( eclipsePath );
//        }
//
//        // refresh eclipse project to announce zipfiles
//        eclipseProject.refreshLocal( IResource.DEPTH_ONE, null );
//
//        // cleanup partitions
//        for ( Iterator<PRI> it = partitions.iterator( ); it.hasNext( ); ) {
//            PRI pri = it.next( );
//            ModelPartition modelPartition = getMoinConnection( ).getPartition( pri );
//            if ( modelPartition != null ) {
//                modelPartition.delete( );
//                getMoinConnection( ).save( );
//            }
//        }
//
//        // register zips
//        for ( Iterator<PRI> it = partitions.iterator( ); it.hasNext( ); ) {
//            PRI pri = it.next( );
//            ModelPartition modelPartition = getMoinConnection( ).getPartition( pri );
//            assertNull( "Partition is still available, should be missing: " + pri, modelPartition );
//        }
//
//        ResourceArchivesRecord resourceArchives = new ResourceArchivesRecord( );
//        resourceArchives.archivePaths = ziplist;
//        resourceArchives.resourceFoldersPaths = rfList;
//
//        // this will overwrite the existing registration
//        ( (IdePrimaryFacilityImpl) getIdePrimaryFacility( ) ).getResourceManagement( ).updateContainer( cri, resourceArchives, false );
//
//        // load partitions in zips
//        for ( Iterator<PRI> it = partitions.iterator( ); it.hasNext( ); ) {
//            PRI pri = it.next( );
//            ModelPartition modelPartition = getMoinConnection( ).getPartition( pri );
//            assertNotNull( "Partition is not available: " + pri, modelPartition );
//        }
//
//        // Clean-up of test objects:
//        // cleanUpTestObjects(testObjects, connection);
//    }
//
//    private void addChildren( ZipOutputStream out, File file, String path ) throws IOException {
//
//        // TODO Auto-generated method stub
//        File[] children = file.listFiles( );
//        if ( children == null || children.length < 1 ) {
//            return;
//        }
//        for ( int i = 0; i < children.length; i++ ) {
//            if ( children[i].isDirectory( ) ) {
//                // path ends with separator, starting with resource folder path
//                String myPath = null;
//                if ( path == null ) {
//                    myPath = children[i].getName( );
//                } else {
//                    myPath = path + "/" + children[i].getName( );
//                }
//                // continue recursive evaluation
//                this.addChildren( out, children[i], myPath );
//            } else if ( children[i].isFile( ) ) {
//                // setup and add entry
//                int read = 0;
//                FileInputStream in = null;
//                byte[] data = new byte[1024];
//                String entryPath = null;
//                if ( path == null ) {
//                    entryPath = children[i].getName( );
//                } else {
//                    entryPath = path + "/" + children[i].getName( );
//                }
//                ZipEntry entry = new ZipEntry( entryPath );
//                in = new FileInputStream( children[i] );
//                out.putNextEntry( entry );
//                while ( ( read = in.read( data, 0, 1024 ) ) != -1 ) {
//                    out.write( data, 0, read );
//                }
//                in.close( );
//                out.closeEntry( ); // close zip entry
//            }
//        }
//    }
    @Test( timeout = 10000 )
    public void testSaveDirtyPersistedRemovedFromDisc( ) throws Exception {

        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( "delete" );
        mp.deleteElements( );
        C2 cPersisted = this.createC2( );
        mp.assignElement( cPersisted );
        this.saveConnectionOne( );

        C2 cDirty = this.createC2( );
        mp.assignElement( cDirty );

        // delete the partition file
        PRI mpPri = mp.getPri( );
        IpiDiCri mpCri = (IpiDiCri) mpPri.getCri( );
        IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( mpCri.getDevComponentVendor( ), mpCri.getDevComponentName( ) );
        File partition = MOIN_IDE_TEST_HELPER.getFileUtil( ).getFile( eclipseProject, mpPri );
        assertNotNull( partition );
        partition.delete( );
        eclipseProject.refreshLocal( IResource.DEPTH_INFINITE, null );

        // wait until index removed partition (via resource changed event)
        SpiCoreQueryService query = getSpiFacility( ).getCoreQueryService( );
        ClientSpec clientSpec = this.getIdeFacilityDispatcher( ).getClientSpec( eclipseProject );
        while ( query.isPartitionExistent( clientSpec, mpPri ) ) {
            Thread.sleep( 100 );
        }

        this.saveConnectionOne( );

        // check if already persisted and dirty C2 elements are in index
        MRI c2MMri = ( (Partitionable) cDirty.refMetaObject( ) ).get___Mri( );
        SpiFacilitySlimIndexQueryService querySlim = (SpiFacilitySlimIndexQueryService) query;
        Collection<MRI> instances = querySlim.getInstances( new TestPersQueryClientScope( new ClientSpec[] { clientSpec } ), new MRI[] { c2MMri } );
        assertTrue( "cPersisted is not in index", instances.contains( ( (Partitionable) cPersisted ).get___Mri( ) ) );
        assertTrue( "cDirty is not in index", instances.contains( ( (Partitionable) cDirty ).get___Mri( ) ) );

        // cleanup
        mp.delete( );
        this.saveConnectionOne( );
    }

    private class TestPersQueryClientScope implements SpiFacilityQueryClientScope {

        private ClientSpec[] clientSpecs;

        public TestPersQueryClientScope( ClientSpec[] clientSpecs ) {

            this.clientSpecs = clientSpecs;
        }

        public Set<PRI> getPartitionsScope( ) {

            return Collections.emptySet( );
        }

        public ClientSpec[] getQueryClientScope( ) {

            return this.clientSpecs;
        }

        public boolean isPartitionScopeInclusive( ) {

            return false;
        }

    }

    private C2 createC2( ) {

        return this.getConnectionOne( ).createElementInPartition( C2.class, null );
    }
}
