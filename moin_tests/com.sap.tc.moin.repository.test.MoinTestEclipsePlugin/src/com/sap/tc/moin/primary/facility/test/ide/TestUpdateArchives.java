package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.junit.Test;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.lib.api.core.IDcProject;
import com.sap.ide.dii05.lib.api.modeledit.DiiModelEditService;
import com.sap.ide.dii05.lib.api.modeledit.IMeBuildPlugin;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcDependency;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPartRef;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditFactory;
import com.sap.ide.dii05.lib.api.util.DiiPathService;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.ui.api.actions.DiiActionFactory;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceArchiveFoldersRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceArchivesRecord;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;

/**
 * Base testcase, providing DC Build functionality.
 * 
 * @author D046220
 */
public class TestUpdateArchives extends FacilityIdeMoinTest {

//    @Deprecated
//    private static final String CHANGE_LISTENER_OFF = "com.sap.tc.moin.resourcechangelistener.off";

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    @SuppressWarnings( "unchecked" )
    @Test
    public void testCreateArchive( ) throws Exception {

        boolean testSucceeded = false;
        List<PRI> testObjects = new ArrayList<PRI>( );

        final String fullTestCaseName = getFullTestCaseName( "TestUpdateArchives", "testCreateArchive" );

        printTestBeginInfo( fullTestCaseName );

        Connection connection = null;

        try {
            File tmpFile = null;

            // Retrieve the packageExtend for the MetaModel (which later is needed
            // to create the respective model
            // elements)
            String modelContainerName = null;
            String[] qualifiedName = new String[] { TestMetaModels.SERVICE_INTERACTIONS };
            this._packageExtendForServiceInteractionsModels = (ServiceInteractionsPackage) ( getMoinConnection( ).getPackage( modelContainerName, qualifiedName ) );
            if ( this._packageExtendForServiceInteractionsModels == null ) {
                throw new RuntimeException( "PackageExtend for ServiceInteraction models could not be retrieved." );
            }


            String dcVendor = "sap.com";
            String dcName = "test/moin/changearchive";
            IProject eclipseProject = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName );

            SpiClientSpec clientSpec = getClientSpec( eclipseProject );
            String clientSpecificStageName = getClientSpecificStageName( clientSpec );


            // setup modified example with new created partition and changed partition

            String createdPartitionName = makePartitionName( "createdPartition" );
            ModelPartition createdPartition = createPartition( clientSpec, dcVendor + "/" + dcName, "moin/meta/" + createdPartitionName );
            PRI createdPartitionPri = createdPartition.getPri( );
            testObjects.add( createdPartitionPri );
            fillPartitionWithServiceInteractionsModelElements( createdPartition );

            final String CHANGED_MESSAGE_TYPE_VALUE = "changedMessage1TypeValue";
            String changedPartitionName = makePartitionName( "changedPartition" );
            ModelPartition changedPartition = createPartition( clientSpec, dcVendor + "/" + dcName, "moin/meta/" + changedPartitionName );
            PRI changedPartitionPri = changedPartition.getPri( );
            testObjects.add( changedPartitionPri );
            List<MRI> mrisInChangedPartition = fillPartitionWithServiceInteractionsModelElements( changedPartition );
            String mofIdOfChangedModelElement = getMofIdOfAnyMessageInServiceInteractionsModel( changedPartition );

            connection = getMoinConnection( );
            changeModelElementInPartitionWithServiceInteractionsModelElements( connection, mrisInChangedPartition, mofIdOfChangedModelElement, CHANGED_MESSAGE_TYPE_VALUE );
            connection.save( );

            String absoluteFilePath = null;
            IDevelopmentComponent devComp = executeTestBuild( dcVendor, dcName );
            File[] zips = null;
            File file = DiiPathService.getPublicPartArchivesFolder( devComp, "def_cmp" );
            if ( file != null ) {
                File child = new File( file, "lib/moin" );
                FilenameFilter aZipFilter = new FilenameFilter( ) {

                    public boolean accept( File aDir, String aFileName ) {

                        return aFileName.endsWith( ".zip" );
                    }
                };
                zips = child.listFiles( aZipFilter );
            }
            if ( zips != null ) {
                absoluteFilePath = zips[0].getAbsolutePath( );
                tmpFile = File.createTempFile( "case1_", ".zip" );
                MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( zips[0], tmpFile );
                System.out.println( "file copied: " + tmpFile.getAbsolutePath( ) );
            }


            // setup before example with one partition to be deleted and one partition to be changed

            String deletedPartitionName = makePartitionName( "deletedPartition" );
            ModelPartition deletedPartition = createPartition( clientSpec, dcVendor + "/" + dcName, "moin/meta/" + deletedPartitionName );
            PRI deletedPartitionPri = deletedPartition.getPri( );
            testObjects.add( deletedPartitionPri );
            fillPartitionWithServiceInteractionsModelElements( deletedPartition );

            // remove this
            createdPartition.delete( );


            // partition before change
            final String ORIGINAL_MESSAGE_TYPE_VALUE = "message1TypeValue";
            changeModelElementInPartitionWithServiceInteractionsModelElements( connection, mrisInChangedPartition, mofIdOfChangedModelElement, ORIGINAL_MESSAGE_TYPE_VALUE );

            connection.save( );

            executeTestBuild( dcVendor, dcName );
//            if ( absoluteFilePath != null ) {
//                File zip = new File( absoluteFilePath );
//                tmpFile2 = File.createTempFile( "case2_", ".zip" );
//                copyFile( zip, tmpFile2 );
//                System.out.println( "file copied: " + tmpFile2.getAbsolutePath( ) );
//            }

            // Clean-up of test objects:
            cleanUpTestObjects( testObjects, connection );
            testObjects = null;

            // check cleanup has been done
            assertFalse( getPreconditionFailedMessage( "Partition is in file system", deletedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, deletedPartitionPri ) );
            assertFalse( getPreconditionFailedMessage( "Partition is in index", deletedPartitionPri ), isPartitionInIndex( deletedPartitionPri, clientSpecificStageName ) );
            assertFalse( getPreconditionFailedMessage( "Partition is in file system", createdPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, createdPartitionPri ) );
            assertFalse( getPreconditionFailedMessage( "Partition is in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );
            assertFalse( getPreconditionFailedMessage( "Partition is in file system", changedPartitionPri ), MOIN_IDE_TEST_HELPER.getFileUtil( ).isPartitionInFileSystem( eclipseProject, changedPartitionPri ) );
            assertFalse( getPreconditionFailedMessage( "Partition is in index", changedPartitionPri ), isPartitionInIndex( changedPartitionPri, clientSpecificStageName ) );



            String containerId = dcVendor + "/" + dcName;
            String dataAreaId = clientSpec.getDataArea( ).getName( );
            CRI cri = this.getResourceIdentifierFactory( ).createCri( dataAreaId, containerId );
            Set<String> rfSet = getResourceManagement( ).getRegisteredResourceFoldersForContainer( cri );
            List<String> resources = new ArrayList<String>( rfSet );
            List<String> paths = new ArrayList<String>( );
            paths.add( absoluteFilePath );
            ResourceArchivesRecord resourceArchives = new ResourceArchivesRecord( );
            resourceArchives.resourceFoldersPaths = resources;
            resourceArchives.archivePaths = paths;

            Exception exception = null;
            try {
                getResourceManagement( ).updateContainer( cri, resourceArchives, false );
                // this.refreshEclipseResources( eclipseProject );
                // wait to give the core notification a chance
                // Thread.sleep( 1000 );
            } catch ( RuntimeException e ) {
                e.printStackTrace( );
                exception = e;
            }

            // - no exception during execution of refreshFromFileSystem
            assertNull( getExceptionThrownAssertMessage( "updateContainer", exception ), exception );

            // check archive registration has been done
            //assertTrue( getPreconditionFailedMessage( "Partition is not in file system", deletedPartitionPri ), isPartitionInFileSystem( eclipseProject, deletedPartitionPri ) );
            assertTrue( getPreconditionFailedMessage( "Partition is not in index", deletedPartitionPri ), isPartitionInIndex( deletedPartitionPri, clientSpecificStageName ) );
            //assertTrue( getPreconditionFailedMessage( "Partition is not in file system", changedPartitionPri ), isPartitionInFileSystem( eclipseProject, changedPartitionPri ) );
            assertTrue( getPreconditionFailedMessage( "Partition is not in index", changedPartitionPri ), isPartitionInIndex( changedPartitionPri, clientSpecificStageName ) );
            //assertFalse( getPreconditionFailedMessage( "Partition is in file system", createdPartitionPri ), isPartitionInFileSystem( eclipseProject, createdPartitionPri ) );
            assertFalse( getPreconditionFailedMessage( "Partition is in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );

            assertTrue( getPreconditionFailedMessage( "Different model elements in partition in file system and index", changedPartitionPri ), doesContainEqualMris( mrisInChangedPartition, getMrisInPartition( changedPartitionPri, connection ) ) );
            assertTrue( getPreconditionFailedMessage( "Changed model element in partition from index is different", changedPartitionPri ), isModelElementInPartitionWithServiceInterationsModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement,
                                                                                                                                                                                                                         ORIGINAL_MESSAGE_TYPE_VALUE ) );

            // copy zip containing post state
            File zip = new File( absoluteFilePath );
            MOIN_IDE_TEST_HELPER.getFileUtil( ).copyFile( tmpFile, zip );
            tmpFile.delete( );
            System.out.println( "file restored: " + tmpFile.getAbsolutePath( ) + " to: " + absoluteFilePath );

            ResourceArchiveFoldersRecord resourceArchiveFoldersRecord = new ResourceArchiveFoldersRecord( );
            resourceArchiveFoldersRecord.resourceFoldersPaths = resources;
            resourceArchiveFoldersRecord.archiveFoldersPaths = Arrays.asList( new String[] { zips[0].getParent( ) } );

            exception = null;
            boolean eclRefresh = false;//Boolean.getBoolean( TEST_LISTENER_ON );
            try {
                if ( eclRefresh ) {
                    this.refreshEclipseResources( eclipseProject );
                } else {
                    getResourceManagement( ).updateContainer( cri, resourceArchiveFoldersRecord, false );
                }
                // wait to give the core notification a chance
                threadSleep( 1000, fullTestCaseName );
            } catch ( RuntimeException e ) {
                e.printStackTrace( );
                exception = e;
            }

            // - no exception during execution of refreshFromFileSystem
            assertNull( getExceptionThrownAssertMessage( "refreshFromFileSystem", exception ), exception );

            //assertFalse( getPostconditionFailedMessage( "Partition is in file system", deletedPartitionPri ), isPartitionInFileSystem( eclipseProject, deletedPartitionPri ) );
            assertFalse( getPostconditionFailedMessage( "Partition is in index", deletedPartitionPri ), isPartitionInIndex( deletedPartitionPri, clientSpecificStageName ) );
            //assertTrue( getPostconditionFailedMessage( "Partition is not in file system", createdPartitionPri ), isPartitionInFileSystem( eclipseProject, createdPartitionPri ) );
            assertTrue( getPostconditionFailedMessage( "Partition is not in index", createdPartitionPri ), isPartitionInIndex( createdPartitionPri, clientSpecificStageName ) );
            //assertTrue( getPostconditionFailedMessage( "Partition is not in file system", changedPartitionPri ), isPartitionInFileSystem( eclipseProject, changedPartitionPri ) );
            assertTrue( getPostconditionFailedMessage( "Partition is not in index", changedPartitionPri ), isPartitionInIndex( changedPartitionPri, clientSpecificStageName ) );
            assertTrue( getPostconditionFailedMessage( "Changed model element in partition from index is different", changedPartitionPri ), isModelElementInPartitionWithServiceInterationsModelElementsCorrectlyChanged( connection, mrisInChangedPartition, mofIdOfChangedModelElement,
                                                                                                                                                                                                                          CHANGED_MESSAGE_TYPE_VALUE ) );

            testSucceeded = true; // succeeded includes the clean-up for the
            // test objects !!!
        } catch ( RuntimeException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        } finally {

            // Print test result
            if ( testSucceeded ) {
                printTestSucceededInfo( fullTestCaseName );
            } else {
                try {
                    // The test objects potentially have not yet been
                    // cleaned-up:
                    if ( testObjects != null ) {
                        cleanUpTestObjects( testObjects, connection );
                    }
                } catch ( Exception e1 ) {
                    e1.printStackTrace( );
                }
                printTestFailedInfo( fullTestCaseName );
            }
        }

    }

    public IDevelopmentComponent executeTestBuild( String dcVendor, String dcName ) throws Exception {

        IProject project = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName );

        IDcProject dcProject = DiiResourceService.getDcProject( project );

        IDevelopmentComponent devComp = dcProject.getDevelopmentComponent( );

        enableMMBuild( devComp );

        JdiJob buildJob = DiiCommandFactory.forDevelopmentComponent( ).create_BuildDcsJob( new IDevelopmentComponent[] { devComp }, true );

        IStatus status = JobUtil.syncExec( buildJob, null );

        assertTrue( "Build job failed.", status.isOK( ) );

        return devComp;
    }

    @SuppressWarnings( "unchecked" )
    protected void enableMMBuild( IDevelopmentComponent developmentComponent ) throws Exception {

        // Get the editable state of the DC
        IMeDcMetadataState state = null;

        state = DiiModelEditService.getEditableState( developmentComponent.getLocalState( ), null );

        // Set the build plugin
        IMeBuildPlugin buildPlugin = state.getBuildPlugin( );
        buildPlugin.setName( "tc/moin/bi/bp/mmbuildplugin" );
        buildPlugin.setVendor( "sap.com" );
        buildPlugin.setPpName( "def" );

        // Add dependency to tc/moin/api
        IMeDcDependency dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency( );
        IMePublicPartRef ppRef = ModelEditFactory.eINSTANCE.createIMePublicPartRef( );
        ppRef.setName( "tc/moin/api" );
        ppRef.setVendor( "sap.com" );
        ppRef.setPpName( "api" );
        dependency.setDcOrPpRef( ppRef );
        dependency.setAtBuildTime( true );
        state.getDependencies( ).add( dependency );

        // Add dependency to tc/moin/jmicore/api
        dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency( );
        ppRef = ModelEditFactory.eINSTANCE.createIMePublicPartRef( );
        ppRef.setName( "tc/moin/jmicore/api" );
        ppRef.setVendor( "sap.com" );
        ppRef.setPpName( "api" );
        dependency.setDcOrPpRef( ppRef );
        dependency.setAtBuildTime( true );
        state.getDependencies( ).add( dependency );

        DiiModelEditService.commitChanges( state );

        DiiActionFactory.forDevelopmentComponent( ).create_SyncUsedDcsAction( new IDevelopmentComponent[] { developmentComponent }, true ).run( null );
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

}
