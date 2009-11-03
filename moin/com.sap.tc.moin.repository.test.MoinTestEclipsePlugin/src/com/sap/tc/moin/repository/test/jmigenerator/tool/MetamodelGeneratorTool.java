package com.sap.tc.moin.repository.test.jmigenerator.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.controller.DoNothingLogCallback;
import com.sap.tc.moin.repository.jmigenerator.controller.DoNothingTimerCallback;
import com.sap.tc.moin.repository.jmigenerator.mofrom.MoinMofRomGeneratorNG;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;
import com.sap.tc.moin.repository.test.jmigenerator.standalone.MetamodelGenerator;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Does a bit more than the MetamodelGenerator, e.g. MOF ROM generation
 */
public class MetamodelGeneratorTool extends MetamodelGenerator {

    private static final String MOF14_CONTAINER_NAME = TestMetaModels.MOIN_MOF_CN;

    private List<CoreModelPartition> transientMofRomPartitions = null;

    public MetamodelGeneratorTool( String aRootFolder ) {

        super( aRootFolder, new DoNothingTimerCallback( ), new DoNothingLogCallback( ) );
    }

    String getMofContainerName( ) {

        return MOF14_CONTAINER_NAME;
    }

    void generateMofRom( File folderWithMofXmis, File outputFolder, CoreConnection connection ) {


        File[] xmiFiles = getXmiFiles( folderWithMofXmis );
        if ( xmiFiles == null || xmiFiles.length == 0 ) {
            throw new RuntimeException( "Couldn't find any xmi files in folder " + folderWithMofXmis.getAbsolutePath( ) );
        }

        this.transientMofRomPartitions = new ArrayList<CoreModelPartition>( xmiFiles.length );

        for ( File file : xmiFiles ) {
            CoreModelPartition partition = connection.getOrCreateTransientPartitionNonTransactional( file.getName( ).replace( '.', '_' ) );
            synchronized ( connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
                partition.deleteElements( );
            }

            this.transientMofRomPartitions.add( partition );
        }

        readInXmis( this.transientMofRomPartitions, xmiFiles, connection );

        outputFolder.mkdirs( );
        MoinMofRomGeneratorNG generator = new MoinMofRomGeneratorNG( connection, outputFolder.getAbsolutePath( ), this.transientMofRomPartitions );
        generator.execute( );

    }



    private void readInXmis( List<CoreModelPartition> partitions, File[] xmiFiles, CoreConnection connection ) {

        WorkspaceSet workspaceSet = connection.getSession( ).getWorkspaceSet( );
        SpiPartitionReader partitionReader = workspaceSet.getMoin( ).getCore( ).getPartitionService( ).createPartitionReader( );
        synchronized ( workspaceSet.getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            for ( int i = 0; i < xmiFiles.length; i++ ) {
                try {
                    partitionReader.read( connection.getSession( ), new FileInputStream( xmiFiles[i] ), partitions.get( i ) );
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
        }
    }

    private File[] getXmiFiles( File folderWithMofXmis ) {

        return folderWithMofXmis.listFiles( new FilenameFilter( ) {

            public boolean accept( File dir, String name ) {

                if ( name.endsWith( MetaModelCatalog.META_MODEL_EXTENSION ) ) {
                    return true;
                }
                return false;
            }
        } );
    }

    public void generateJmi( String[] metamodelContainerNames, CoreConnection conn, JmiGenerationKind[] jmiGenerationKinds ) throws Exception {

        DataAreaDescriptor dataArea = conn.getSession( ).getWorkspaceSet( ).getMoin( ).getMetamodelDataArea( ).getDescriptor( );
        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
        for ( String containerName : metamodelContainerNames ) {
            CRI cri = conn.getSession( ).getMoin( ).createCri( dataArea.getFacilityId( ), dataArea.getDataAreaName( ), containerName );
            Collection<PRI> partitionsInContainer = conn.getSession( ).getInnerPartitions( cri );
            partitions.clear( );
            for ( PRI pri : partitionsInContainer ) {
                partitions.add( conn.getPartition( pri ) );
            }
            if ( !containerName.equals( MOF14_CONTAINER_NAME ) ) {
                // FOR non-MOF metamodels, generate everything (interfaces /
                // classes / wrappers) plus the deployment extensions.
                String targetPath = getTargetSourcePath( containerName );
                deleteDir( new File( targetPath ) );
                generateCode( conn, targetPath, containerName, partitions, true /* generateDeploymentExtension */, jmiGenerationKinds );
            } else {
                // For MOF, generate interfaces, implementations and wrappers into separate subfolders for easy Perforce check-in.
                String targetPath = null;
                if ( this.transientMofRomPartitions != null && !this.transientMofRomPartitions.isEmpty( ) ) {
                    // there is a newly generated MOF ROM transiently available,
                    // use this one instead of the deployed one
                    partitions = new HashSet<ModelPartition>( this.transientMofRomPartitions );
                }
                if ( contains( jmiGenerationKinds, JmiGenerationKind.INTERFACE ) ) {
                    targetPath = getTargetSourcePath( containerName, JmiGenerationKind.INTERFACE );
                    deleteDir( new File( targetPath ) );
                    generateCode( conn, targetPath, containerName, partitions, false /* generateDeploymentExtension */, JmiGenerationKind.INTERFACE );
                }
                if ( contains( jmiGenerationKinds, JmiGenerationKind.CLASS ) ) {
                    targetPath = getTargetSourcePath( containerName, JmiGenerationKind.CLASS );
                    deleteDir( new File( targetPath ) );
                    generateCode( conn, targetPath, containerName, partitions, false /* generateDeploymentExtension */, JmiGenerationKind.CLASS );
                }
                if ( contains( jmiGenerationKinds, JmiGenerationKind.WRAPPER ) ) {
                    targetPath = getTargetSourcePath( containerName, JmiGenerationKind.WRAPPER );
                    deleteDir( new File( targetPath ) );
                    generateCode( conn, targetPath, containerName, partitions, false /* generateDeploymentExtension */, JmiGenerationKind.WRAPPER );
                }
            }
        }
    }

    String getTargetSourcePath( String containerName, JmiGenerationKind generationkind ) {

        if ( MOF14_CONTAINER_NAME.equals( containerName ) ) {
            String containerPath = getTargetContainerPath( containerName );
            if ( JmiGenerationKind.INTERFACE.equals( generationkind ) ) {
                return containerPath + "/interfaces/src";
            }
            if ( JmiGenerationKind.CLASS.equals( generationkind ) ) {
                return containerPath + "/implementations/src";
            }
            if ( JmiGenerationKind.WRAPPER.equals( generationkind ) ) {
                return containerPath + "/wrappers/src";
            }
        }
        return getTargetSourcePath( containerName );
    }

    private boolean contains( JmiGenerationKind[] jmiGenerationKinds, JmiGenerationKind kind ) {

        for ( JmiGenerationKind jmiGenerationKind : jmiGenerationKinds ) {
            if ( jmiGenerationKind == kind ) {
                return true;
            }
        }

        return false;
    }
}