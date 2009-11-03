package com.sap.tc.moin.repository.runtimehost.filesystem.mmhandling;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.runtimehost.deployment.DirectoryAccessImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.IpiCustomSerializationClassLoader;
import com.sap.tc.moin.repository.runtimehost.deployment.IpiMetamodelArchiveAccess;
import com.sap.tc.moin.repository.runtimehost.deployment.MetamodelRegistryImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MmInfoImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinArchiveInfoImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinDeploymentException;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.ZipArchiveAccessImpl;
import com.sap.tc.moin.repository.runtimehost.filesystem.FileSystemRuntimeHostMessages;
import com.sap.tc.moin.repository.runtimehost.filesystem.FileSystemRuntimeHostTraces;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsFacility;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsMetaModelManager;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsMetaModelManager.MetaModelPartitionDeploymentRecord;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetaModelInfo;

public class FileSystemMetaModelReceiver {

    private static final MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_METAMODELS, FileSystemMetaModelReceiver.class );

//    private final String EXTENSION_CLASS_NAME = ".MetamodelExtension"; //$NON-NLS-1$

    private final SpiMoin moin;

    private MetamodelRegistryImpl registry;

    public FileSystemMetaModelReceiver( SpiMoin moin ) {

        this.moin = moin;
        this.registry = new MetamodelRegistryImpl( );
    }

    public void startup( String[] metamodelJars, PartitionSerializationManagerImpl serializationManager ) {

        if ( metamodelJars != null && metamodelJars.length > 0 ) {
            List<MmInfoImpl> availableMetaModels = new ArrayList<MmInfoImpl>( metamodelJars.length );

            for ( String path : metamodelJars ) {

                try {
                    _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostMessages.REGISTERING_META_MODEL_JAR, path );
                    File f = new File( path );

                    IpiCustomSerializationClassLoader loader = new StandaloneClassloaderImpl( );
                    IpiMetamodelArchiveAccess archiveElement;
                    if ( f.isDirectory( ) ) {
                        archiveElement = new DirectoryAccessImpl( f );
                    } else {
                        archiveElement = new ZipArchiveAccessImpl( f );
                    }

                    MoinArchiveInfoImpl archiveInfo = new MoinArchiveInfoImpl( archiveElement );

                    archiveInfo.loadArchiveContent( );

                    // get (and load) metamodel info
                    MmInfoImpl metaModelInfo = archiveInfo.createMmInfo( moin, loader );

                    if ( metaModelInfo != null ) {
                        availableMetaModels.add( metaModelInfo );
                    }

                    // register parser/serializer, error handler, tv callbacks
                    serializationManager.registerMetamodelArchive( archiveElement.getArchiveId( ), archiveInfo.getArchiveDescriptor( ) );

                    // load classes
                    serializationManager.createInstancesOfRegisteredExtension( archiveElement.getArchiveId( ), loader );

                    _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostMessages.METAMODEL_JAR_REGISTERED, path );
                } catch ( MoinDeploymentException e ) {
                    // currently, the exception is never thrown in the constructor
                    // instead, the status is set not "not deployable"
                    _log.trace( e, MoinSeverity.ERROR, FileSystemRuntimeHostTraces.INVALID_METAMODEL_SPECIFICATION, path );
                    continue;
                } catch ( IOException e ) {
                    _log.trace( e, MoinSeverity.ERROR, FileSystemRuntimeHostTraces.PROBLEMS_OPENING_METAMODEL_ARCHIVE, path );
                    continue;
                }
            }

            this.deployInstalledMetaModels( availableMetaModels );

            // register the meta-models in the central deployment registry - also fills the JmiClassResolver
            for ( MmInfoImpl metaModelInfo : availableMetaModels ) {

                this.registry.registerMetaModel( metaModelInfo );
            }
        } else {
            _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.NO_META_MODEL_JARS_SPECIFIED );
        }
    }

    public MetamodelRegistryImpl getMetaModelRegistry( ) {

        return this.registry;
    }

    private void deployInstalledMetaModels( Collection<MmInfoImpl> availableMetaModels ) {

        Map<SpiFsMetaModelManager, List<MetaModelPartitionDeploymentRecord>> mmManagerToMmPartitions = new HashMap<SpiFsMetaModelManager, List<MetaModelPartitionDeploymentRecord>>( );

        for ( MmInfoImpl metaModelInfo : availableMetaModels ) {
            // if (metaModelInfo.getStatus() == MmDeploymentStatus.NOT_DEPLOYED) {
            SpiFsMetaModelManager mmPartitionManager = ( (SpiFsFacility) metaModelInfo.getFacility( ) ).getFsMetaModelManager( );

            Collection<PRI> pris;

            pris = metaModelInfo.getPRIs( );

            List<MetaModelPartitionDeploymentRecord> mmPartitionDeploymentRecords = mmManagerToMmPartitions.get( mmPartitionManager );
            if ( mmPartitionDeploymentRecords == null ) {
                mmPartitionDeploymentRecords = new ArrayList<MetaModelPartitionDeploymentRecord>( pris.size( ) );
                mmManagerToMmPartitions.put( mmPartitionManager, mmPartitionDeploymentRecords );
            }

            for ( PRI pri : pris ) {
                MetaModelPartitionDeploymentRecord deploymentRecord = new MetaModelPartitionDeploymentRecord( );
                deploymentRecord.pri = pri;
                deploymentRecord.streamProvider = metaModelInfo;
                deploymentRecord.timestamp = metaModelInfo.getTimeStamp( pri );
                mmPartitionDeploymentRecords.add( deploymentRecord );
            }
        }

        for ( Map.Entry<SpiFsMetaModelManager, List<MetaModelPartitionDeploymentRecord>> entry : mmManagerToMmPartitions.entrySet( ) ) {
            SpiFsMetaModelManager mmPartitionManager = entry.getKey( );
            List<MetaModelPartitionDeploymentRecord> mmPartitionDeploymentRecords = entry.getValue( );

            // deploy all meta-models per facility
            List<PRI> notDeployablePartitions = mmPartitionManager.setDeployedMetamodelPartitions( mmPartitionDeploymentRecords );

            // handle deployment problems:
            // undeploy all metamodels (= containers) that contain not deployable partitions

            if ( notDeployablePartitions != null && !notDeployablePartitions.isEmpty( ) ) {
                // collect containers that contain partitions the facility could not deploy
                List<CRI> notDeployableContainers = new ArrayList<CRI>( );
                for ( PRI pri : notDeployablePartitions ) {
                    notDeployableContainers.add( pri.getCri( ) );
                }

                // handle erroneous container
                for ( CRI cri : notDeployableContainers ) {
                    // undeploy the complete metamodel container
                    mmPartitionManager.removeDeployedMetamodelPartitions( cri );
                }
            }
        }

        //        //this should be integrated in the deployment problem handling
        //        for (BuildMetaModelInfo metaModelInfo : this.metaModels) {
        //            if (metaModelInfo.getStatus() == MmDeploymentStatus.NOT_DEPLOYED) {
        //                metaModelInfo.setStatus(MmDeploymentStatus.DEPLOYED);
        //            }
        //        }

    }


    public void finalizeStartup( SpiMoin spiMoin ) {

        // register the meta-model info for the MofRom
        SpiMetaModelInfo mofRomInfo = spiMoin.getMofRomInfo( );
        this.registry.registerMetaModel( mofRomInfo );
    }

    /**
     * Archive access wrapper.
     * 
     * @author D026715
     */
    private static class StandaloneClassloaderImpl implements IpiCustomSerializationClassLoader {

        public Class<?> loadClass( String className ) throws ClassNotFoundException {

            return this.getClass( ).getClassLoader( ).loadClass( className );
        }

    }

}
