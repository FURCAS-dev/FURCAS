package com.sap.tc.moin.repository.runtimehost.deployment.ide;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.runtimehost.deployment.IpiCustomSerializationClassLoader;
import com.sap.tc.moin.repository.runtimehost.deployment.IpiMetamodelArchiveAccess;
import com.sap.tc.moin.repository.runtimehost.deployment.MetamodelRegistryImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MmInfoImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinArchiveDescriptorImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinArchiveInfoImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinDeploymentException;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
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
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

public class IdeMetaModelReceiverImpl {

    private static final String METAMODEL_EX_POINT_NAME = "com.sap.tc.moin.runtime.MoinMetaModel"; //$NON-NLS-1$

    // MOIN logger
    private static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_METAMODELS, IdeMetaModelReceiverImpl.class );

    protected MetamodelRegistryImpl registry;

    private IdeDeploymentManagerImpl deploymentManager;

    public IdeMetaModelReceiverImpl( SpiMoin moin ) {

        this.registry = new MetamodelRegistryImpl( );
        this.deploymentManager = new IdeDeploymentManagerImpl( this.registry );
    }


    public IdeDeploymentManagerImpl getMetamodelRegistry( ) {

        return this.deploymentManager;
    }

    public MetamodelRegistryImpl getMetamodelCatalog( ) {

        return this.registry;
    }

    public void startup( SpiMoin moin, PartitionSerializationManagerImpl serializationManager ) {

        // MetaModelreceiver initializes the meta-models. This functionality is
        // called at each Moin startup.
        try {

            // scan the platform for meta-model plug-ins
            List<MmInfoImpl> allMetamodelPlugins = this.scanInstalledMetaModels( moin, serializationManager );

            // deploy the meta-models into the facility
            Collection<MmInfoImpl> successfullyDeployedMetaModels = this.deployMetaModels( allMetamodelPlugins );

            // register all successfully deployed meta-models inside the meta-model registry
            this.registry.registerAllMetaModels( successfullyDeployedMetaModels );
        } catch ( Exception e ) {
            _log.trace( e, MoinSeverity.ERROR, "MOIN metamodel initialization failed." ); //$NON-NLS-1$
            // TODO: rethrow exception ?
        }
    }

    public void shutdown( ) {

        this.registry = null;
    }

    // ========================= MmDeploymentManager ==========================

    /**
     * Reads all eclipse bundles containing metamodels and adds them to the
     * archive registry.
     */
    private List<MmInfoImpl> scanInstalledMetaModels( SpiMoin moin, PartitionSerializationManagerImpl serializationManager ) {

        IExtensionPoint mmExtPoint = Platform.getExtensionRegistry( ).getExtensionPoint( METAMODEL_EX_POINT_NAME );

        IExtension[] extensions = mmExtPoint.getExtensions( );

        List<MmInfoImpl> mmsInfoList = new ArrayList<MmInfoImpl>( extensions.length );

        for ( IExtension extension : extensions ) {

            // the archive access is the wrapper around the bundle
            MetamodelArchiveAccessImpl archiveAccess = new MetamodelArchiveAccessImpl( extension );

            Bundle bundle = archiveAccess.getBundle( );

            // builds the moin archive info. The moin archive info wraps the metamodel info and the archive descriptor that
            // delegates to the archive access. The roles are the following (roughly):
            // Archive access: provides the simple resource access
            // Archive descriptor: reads the needed streams
            // Archive Info: interprets the descriptor content
            // In case of problems interpreting the content, a MoinDeploymentException should be thrown by all
            // "participants" (metamodel, cps, textverticalization ...)
            MoinArchiveInfoImpl archiveInfo = null;
            try {
                archiveInfo = new MoinArchiveInfoImpl( archiveAccess );

                // the ide deployment info is used by the deployment view application
                // in its constructor, the deployment info is registered as status listener so that it gets
                // the status from the archive info.
                IdeDeploymentInfoImpl deploymentInfo = new IdeDeploymentInfoImpl( archiveInfo, bundle );
                this.deploymentManager.add( deploymentInfo );

                // load content
                archiveInfo.loadArchiveContent( );

                // get (and load) metamodel info
                // archiveAccess also provides the class loader interface
                MmInfoImpl metamodelInfo = archiveInfo.createMmInfo( moin, archiveAccess );

                // in case there is no metamodel info, we have an archive that only contains cps etc. but no metamodel              
                if ( metamodelInfo != null ) {
                    mmsInfoList.add( metamodelInfo );
                }

                // register parser/serializer, error handler, tv callbacks
                this.registerCustomSerializationParts( archiveAccess.getArchiveId( ), archiveInfo.getArchiveDescriptor( ), archiveAccess, serializationManager );

                // if there is no metamodel, deployment is successful if custom serialization parts could be
                // registered successfully
                if ( metamodelInfo == null ) {
                    archiveInfo.setDeployed( );
                }

            } catch ( MoinDeploymentException e ) {

                serializationManager.unregister( archiveAccess.getArchiveId( ) );
                if ( archiveInfo != null ) {
                    archiveInfo.disableDeployment( e );
                }
                _log.trace( e, MoinSeverity.ERROR, "Invalid metamodel specification. Check the declaration in " + bundle.getSymbolicName( ) ); //$NON-NLS-1$
            }

        }

        return mmsInfoList;
    }

    /**
     * Registers all cps parts of the archive: cps, error handler, s2x
     * callbacks.
     * 
     * @param bundle
     * @param serializationManager
     */
    private void registerCustomSerializationParts( String deploymentId, MoinArchiveDescriptorImpl archive, IpiCustomSerializationClassLoader loader, PartitionSerializationManagerImpl serializationManager ) {

        // register the xmls for cps etc.
        serializationManager.registerMetamodelArchive( deploymentId, archive );

        // in contrast to the server, the instances of the registered classes can be created at once
        serializationManager.createInstancesOfRegisteredExtension( deploymentId, loader );
    }

    /**
     * Deploys the specified meta-models into the facility.
     * 
     * @param foundMetamodels a collection of all available meta-models
     * @return a collection of successfully deployed meta-models
     */
    protected Collection<MmInfoImpl> deployMetaModels( Collection<MmInfoImpl> foundMetamodels ) {

        // partitions have to be deployed to the index in one shot - collect per facility (index implementation)
        Map<SpiFsMetaModelManager, List<SpiFsMetaModelManager.MetaModelPartitionDeploymentRecord>> mmManagerToMmPartitions = new HashMap<SpiFsMetaModelManager, List<SpiFsMetaModelManager.MetaModelPartitionDeploymentRecord>>( );

        for ( MmInfoImpl metaModelInfo : foundMetamodels ) {

            SpiFsFacility fsFacility = (SpiFsFacility) metaModelInfo.getFacility( );
            SpiFsMetaModelManager mmPartitionManager = fsFacility.getFsMetaModelManager( );
            Collection<PRI> pris = null;

            pris = metaModelInfo.getPRIs( );

            List<SpiFsMetaModelManager.MetaModelPartitionDeploymentRecord> mmPartitionDeploymentRecords = mmManagerToMmPartitions.get( mmPartitionManager );
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

            if ( _log.isTraced( MoinSeverity.DEBUG ) ) {
                _log.trace( MoinSeverity.DEBUG, "Deploy metamodel " + metaModelInfo.getContainerName( ) ); //$NON-NLS-1$
            }

        }

        // all metamodels for which no deployment errors occurred are deployed -> set status
        Collection<MmInfoImpl> successfullyDeployedMetaModels = new ArrayList<MmInfoImpl>( foundMetamodels.size( ) );
        successfullyDeployedMetaModels.addAll( foundMetamodels );

        // deploy to index
        for ( Map.Entry<SpiFsMetaModelManager, List<SpiFsMetaModelManager.MetaModelPartitionDeploymentRecord>> entry : mmManagerToMmPartitions.entrySet( ) ) {
            SpiFsMetaModelManager mmPartitionManager = entry.getKey( );
            List<SpiFsMetaModelManager.MetaModelPartitionDeploymentRecord> mmPartitionDeploymentRecords = entry.getValue( );

            // deploy all meta-models per facility
            List<PRI> notDeployablePartitions = mmPartitionManager.setDeployedMetamodelPartitions( mmPartitionDeploymentRecords );

            // handle deployment problems:
            // undeploy all metamodels (= containers) that contain not deployable partitions

            if ( notDeployablePartitions != null && !notDeployablePartitions.isEmpty( ) ) {
                // collect containers that contain partitions the facility could not deploy
                Set<CRI> notDeployableContainers = new HashSet<CRI>( );
                for ( PRI pri : notDeployablePartitions ) {
                    notDeployableContainers.add( pri.getCri( ) );
                }

                for ( Iterator<MmInfoImpl> it = successfullyDeployedMetaModels.iterator( ); it.hasNext( ); ) {
                    MmInfoImpl metaModelInfo = it.next( );
                    if ( notDeployableContainers.contains( metaModelInfo.getContainer( ) ) ) {
                        mmPartitionManager.removeDeployedMetamodelPartitions( metaModelInfo.getContainer( ) );
                        metaModelInfo.disableDeployment( );
                        it.remove( );

                        metaModelInfo.errorMessage( IdeDeploymentMessages.PARTITION_DEPLOYMENT_FAILED.getLocalizedMessage( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) ) );
                        _log.trace( MoinSeverity.WARNING, "The metamodel " + metaModelInfo.getContainerName( ) + " could not be deployed into facility" + metaModelInfo.getFacility( ).getId( ) );//$NON-NLS-1$ //$NON-NLS-2$
                    }
                }
            }
        }

        // set deployment flag for remaining metamodels
        for ( MmInfoImpl mmInfoImpl : successfullyDeployedMetaModels ) {
            mmInfoImpl.setDeployed( );
        }

        return successfullyDeployedMetaModels;
    }

    public void finalizeStartup( SpiMoin spiMoin ) {

        SpiMetaModelInfo mofRomInfo = spiMoin.getMofRomInfo( );
        this.registry.registerMetaModel( mofRomInfo );
    }

    private static class MetamodelArchiveAccessImpl implements IpiMetamodelArchiveAccess, IpiCustomSerializationClassLoader {

        private IExtension extension;

        private Bundle bundle;

        MetamodelArchiveAccessImpl( IExtension extension ) {

            this.extension = extension;
            String bundleId = this.extension.getContributor( ).getName( );
            this.bundle = Platform.getBundle( bundleId );
        }

        public IExtension getExtension( ) {

            return this.extension;
        }

        public Bundle getBundle( ) {

            return this.bundle;
        }


        public InputStream getResourceAsStream( String resourceName ) throws IOException {

            if ( this.bundle != null ) {

                InputStream stream = null;

                URL url = bundle.getEntry( resourceName );
                if ( url != null ) {
                    //jared plugin format
                    stream = url.openStream( );
                } else {
                    //must be non-jared plugin format with xmi-jar
                    URL urlOfMetamodelStorageInf = getUrlFromBundle( resourceName );

                    if ( urlOfMetamodelStorageInf != null ) {
                        stream = urlOfMetamodelStorageInf.openStream( );
                    }
                }
                return stream;

            }
            return null;

        }

        public Class<?> loadClass( String className ) throws ClassNotFoundException {

            return this.bundle.loadClass( className );
        }

        private URL getUrlFromBundle( String resourceName ) throws IOException {

            Enumeration<URL> resources = this.bundle.getResources( resourceName );
            if ( resources == null ) {
                return null;
            }
            ArrayList<URL> overflow = null;
            URL result = null;
            for ( int i = 0; resources.hasMoreElements( ); i++ ) {

                if ( i == 0 ) {
                    result = resources.nextElement( );
                } else if ( i == 1 ) {
                    overflow = new ArrayList<URL>( );
                    overflow.add( resources.nextElement( ) );
                } else {//i > 1
                    overflow.add( resources.nextElement( ) );
                }
            }


            if ( overflow != null ) {
                if ( result.getHost( ).equals( Long.toString( this.bundle.getBundleId( ) ) ) ) {
                    return result;
                } else {
                    for ( int i = 0; i < overflow.size( ); i++ ) {
                        URL tempResult = overflow.get( i );
                        if ( tempResult.getHost( ).equals( Long.toString( this.bundle.getBundleId( ) ) ) ) {
                            return tempResult;
                        }
                    }
                }
            } else {
                if ( result != null ) {
                    if ( result.getHost( ).equals( Long.toString( this.bundle.getBundleId( ) ) ) ) {
                        return result;
                    }
                }
            }

            return null;
        }

        public String getArchiveId( ) {

            return this.bundle.getSymbolicName( );
        }

        public long getLastModified( ) {

            return this.bundle.getLastModified( );
        }

        public boolean resourceExists( String resourceName ) {

            try {
                return this.getUrlFromBundle( resourceName ) != null;
            } catch ( IOException e ) {
                return false;
            }
        }

        public void close( ) {

        }

        public long getContentLength( String resourceName ) {

            try {
                URL url = this.getUrlFromBundle( resourceName );
                return new File( url.getFile( ) ).length( );
            } catch ( IOException e ) {
                return 0;
            }
        }
    }
}
