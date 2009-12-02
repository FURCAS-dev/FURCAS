package com.sap.tc.moin.facility.primary.persistence.fs;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaManager;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityEventNotifier;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.IndexingAction;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord.CreatableCheckResult;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionNameVerifier;

/**
 * A file system based handler for resource folders and archives.
 * <p>
 * Provides other facility components access to update the scope of the file
 * system persistence. All update operations overwrite the existing scope.
 * <p>
 * The scope defines which resources are under file system persistence control.
 * Any scope changes or resource updates may result in the eviction of outdated
 * persistence in the MOIN core.
 */
public class ResourceManagementImpl implements IpiFsResourceManagement, SpiPartitionStreamProvider, IpiFacilityComponent {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS, ResourceManagementImpl.class );

    private static final int INITIAL_STORAGE_REGISTRY_CAPACITY = 4;

    /*
     * Used facility components
     */
    private IpiIndexManagement indexManagement;

    private IpiFacilityEventNotifier eventManager;

    private IpiDataAreaManager dataAreaManager;

    private ResourceIdentifierFactory riFactory;

    private SpiPartitionNameVerifier partitionSerializationManager;

    private IpiLogicalFsFactory directoryLogicalFsFactory;

    private IpiLogicalFsFactory archiveLogicalFsFactory;

    /*
     * resource management data structures
     */

    /**
     * Central mapping holding all storage registration data.
     */
    protected Map<DataAreaDescriptor, Map<String, List<IpiStorage>>> storageRegistry;

    /**
     * Locking object for storage registry.
     */
    protected ReentrantReadWriteLock registryLock;

    /**
     * Secondary mapping [CRI] -> [rootPaths].<br>
     * This mapping redundantly holds information for performance reasons.
     * <p>
     * Maintained for all types of registered resources.
     */
    private Map<CRI, Set<String>> containerToRootPaths;

    /**
     * Secondary mapping: [rootPath] -> [Set<resourceFolders>, CRI].<br>
     * This mapping redundantly holds information for performance reasons.
     * <p>
     * Maintained only for registered for resource folders (and <i>not</i> for
     * archives).
     */
    private Map<String, ContainerResourceFolders> rootPathToContainerResourceFolders;

    /**
     * Data structure used for
     * {@link AbstractFsPersistenceImpl#rootPathToContainerResourceFolders}
     * mapping.
     */
    public final static class ContainerResourceFolders {

        public Set<String> resourceFolders;

        public CRI container;
    }


    public ResourceManagementImpl( ) {

        this.storageRegistry = new HashMap<DataAreaDescriptor, Map<String, List<IpiStorage>>>( ResourceManagementImpl.INITIAL_STORAGE_REGISTRY_CAPACITY );

        this.registryLock = new ReentrantReadWriteLock( );

        // CRIs are cached and guaranteed to only exists once
        this.containerToRootPaths = new IdentityHashMap<CRI, Set<String>>( );

        this.rootPathToContainerResourceFolders = new HashMap<String, ContainerResourceFolders>( );

    }

    public void bind( IpiLogicalFsFactory directoryLogicalFsFactory, IpiLogicalFsFactory archiveLogicalFsFactory ) {

        this.directoryLogicalFsFactory = directoryLogicalFsFactory;
        this.archiveLogicalFsFactory = archiveLogicalFsFactory;
    }

    public void bind( ResourceIdentifierFactory riFactory ) {

        this.riFactory = riFactory;
    }

    public void bind( SpiPartitionNameVerifier serializationManager ) {

        this.partitionSerializationManager = serializationManager;
    }

    public void bind( IpiIndexManagement indexManagement ) {

        this.indexManagement = indexManagement;
    }

    public void bind( IpiFacilityEventNotifier eventManager ) {

        this.eventManager = eventManager;
    }

    public void bind( IpiDataAreaManager dataAreaManager ) {

        this.dataAreaManager = dataAreaManager;
    }

    public void initialize( ) {

    }

    public void tearDown( ) {

    }

    public void finalizeStartup( ) {

    }

    /*
     * Resource Management IPI functionality
     */

    public boolean partitionExists( PRI pri ) {

        // we rely on the index state for this check
        return this.indexManagement.isPartitionIndexed( pri );
    }

    public boolean partitionIsReadOnly( PRI pri ) {

        boolean isReadOnly = false;

        IpiStorage storage = this.getStorageResponsibleForPRI( pri );
        if ( storage != null ) {
            isReadOnly = storage.isPartitionReadonly( pri );
        }

        return isReadOnly;
    }

    public void removeContainer( CRI cri ) {

        // convenience - the value of the forced flag is irrelevant
        this.updateContainer( cri, null, false );
    }

    public void removeDataArea( DataAreaDescriptor dataAreaDescriptor ) {

        // convenience
        this.updateDataArea( dataAreaDescriptor, null );
    }

    public void updateDataArea( DataAreaDescriptor dataAreaDescriptor, List<ContainerResourceRecord> containerResourceRecords ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Updating DataArea " + dataAreaDescriptor.getDataAreaName( ) ); //$NON-NLS-1$
        }

        this.registryLock.writeLock( ).lock( );
        try {
            // destructively remove a possible existing data area for the descriptor        
            Map<String, List<IpiStorage>> containerRegistry = this.storageRegistry.remove( dataAreaDescriptor );
            if ( containerRegistry != null ) {
                for ( Map.Entry<String, List<IpiStorage>> containerRegistryRecord : containerRegistry.entrySet( ) ) {
                    CRI cri = this.riFactory.createCri( dataAreaDescriptor.getDataAreaName( ), containerRegistryRecord.getKey( ) );
                    Set<String> rootPaths = this.containerToRootPaths.remove( cri );
                    // remove the associated containerResourceFolders for each rootPath
                    for ( String rootPath : rootPaths ) {
                        this.rootPathToContainerResourceFolders.remove( rootPath );
                    }
                }
            }

            // update individual containers
            if ( containerResourceRecords != null ) {
                // loop over the provider containerResourceRecords and update each cri individually
                for ( ContainerResourceRecord containerResourceRecord : containerResourceRecords ) {
                    this.updateContainerRegistration( containerResourceRecord.cri, containerResourceRecord.resourceRecord );
                }
            }
        } finally {
            this.registryLock.writeLock( ).unlock( );
        }

        // refresh individal containers
//        if ( containerResourceRecords != null ) {
//            // loop over the provider containerResourceRecords and update each cri individually
//            for ( ContainerResourceRecord containerResourceRecord : containerResourceRecords ) {
//                this.refreshContainer( containerResourceRecord.cri );
//            }
//        }

        // sync index against new file system state
        SyncReport indexSyncReport = this.synchronizeIndexForDataArea( dataAreaDescriptor, false );

        // evict changed partitions
        this.evictOutdatedPartitions( indexSyncReport, this.dataAreaManager.getDataAreaByName( dataAreaDescriptor.getDataAreaName( ) ).getSingleStage( ) );

    }

    public PartitionIsCreatableResultRecord partitionIsCreatable( PRI pri ) throws MoinBaseException {

        PartitionIsCreatableResultRecord checkResult = new PartitionIsCreatableResultRecord( );

        if ( this.partitionExists( pri ) ) {
            // not creatable because partition already exists
            checkResult.result = CreatableCheckResult.NOT_CREATABLE_ALREADY_EXISTS;

        } else {
            // potentially creatable -> check if storage is writable
            IpiStorage responsibleStorage = this.getStorageResponsibleForPRI( pri );

            if ( responsibleStorage instanceof StorageArchiveImpl ) {
                // pri points into an archive -> not creatable
                checkResult.result = CreatableCheckResult.NOT_CREATABLE_RESOURCE_ARCHIVE_NOT_WRITEABLE;

            } else if ( responsibleStorage instanceof StorageDirectoryImpl ) {
                // pri points to a directory -> check path the contained in partition name can be created (case sensitive)
                PartitionIsCreatableResultRecord storageResult = responsibleStorage.isPathCreatable( pri.getPartitionName( ) );
                if ( storageResult != null ) {
                    checkResult = storageResult;
                } else {
                    return null;
                }
            } else {
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNEXPECTEDSTORAGETYPE );
            }
        }

        return checkResult;
    }

    public void updatePartitions( List<PartitionResourceRecord> partitionResourceRecords ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            String message = String.format( "Update Partitions:\n\t%s", partitionResourceRecords.toString( ) ); //$NON-NLS-1$
            LOGGER.trace( MoinSeverity.DEBUG, message );
        }

        // outdated partitions are memorized per DataAreaDescriptor -> stage can be calculated per data area
        Map<DataAreaDescriptor, List<PRI>> outdatedPartitionsPerDataArea = new HashMap<DataAreaDescriptor, List<PRI>>( );

        this.registryLock.readLock( ).lock( );
        try {
            for ( final PartitionResourceRecord partitionResourceRecord : partitionResourceRecords ) {

                ContainerResourceFolders containerResourceFolders = this.rootPathToContainerResourceFolders.get( partitionResourceRecord.rootPath );

                if ( containerResourceFolders != null ) {
                    CRI cri = containerResourceFolders.container;
                    final PRI pri = this.riFactory.createPri( cri.getDataAreaDescriptor( ).getDataAreaName( ), cri.getContainerName( ), partitionResourceRecord.partitionName );

                    IndexingAction indexAction;
                    switch ( partitionResourceRecord.operation ) {
                        case CREATED: // same as changed
                        case CHANGED: {
                            SpiPartitionStreamProvider spiStreamProvider = new SpiPartitionStreamProvider( ) {

                                public InputStream getPartitionStream( final PRI _pri ) {

                                    if ( !pri.equals( _pri ) ) {
                                        // sanity check
                                        throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNEXPECTEDPRIFROMINDEX, _pri, pri );
                                    }
                                    return partitionResourceRecord.streamProvider.getInputStream( );
                                }
                            };
                            indexAction = this.indexManagement.indexPartition( pri, spiStreamProvider, partitionResourceRecord.timestamp, false ); // NOT forced indexing (false)
                            break;
                        }
                        case DELETED: {
                            indexAction = this.indexManagement.removePartition( pri );
                            break;
                        }
                        default: {
                            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNEXPECTEDENUMVALUE );

                        }
                    }

                    // mark re-indexed partitions for eviction (excluding created ones)
                    if ( indexAction != IndexingAction.NOP && indexAction != IndexingAction.ADDED ) {
                        DataAreaDescriptor dataAreaDescriptor = pri.getDataAreaDescriptor( );
                        List<PRI> outdatedPartitions = outdatedPartitionsPerDataArea.get( dataAreaDescriptor );

                        if ( outdatedPartitions == null ) {
                            // create outdated partitions list if it does not exist
                            outdatedPartitions = new ArrayList<PRI>( );
                            outdatedPartitionsPerDataArea.put( dataAreaDescriptor, outdatedPartitions );
                        }

                        outdatedPartitions.add( pri );
                    }
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }

        // evict partitions based on indexing actions of the index
        Map<SpiStage, List<PRI>> partitionsToEvictPerStage = new HashMap<SpiStage, List<PRI>>( );

        for ( Entry<DataAreaDescriptor, List<PRI>> outdatedPartitionsPerDataAreaEntry : outdatedPartitionsPerDataArea.entrySet( ) ) {
            // get stage for each data area
            DataAreaDescriptor dataAreaDescriptor = outdatedPartitionsPerDataAreaEntry.getKey( );
            IpiDataArea dataArea = this.dataAreaManager.getDataAreaByName( dataAreaDescriptor.getDataAreaName( ) );
            SpiStage stage = dataArea.getSingleStage( );

            // create stage based map for eviction
            partitionsToEvictPerStage.put( stage, outdatedPartitionsPerDataAreaEntry.getValue( ) );
        }

        // FIXME: remove this asap
        if ( Boolean.getBoolean( IpiPrimaryFacility.TEST_NOTIFICATION_AND_PARTITION_EVICTION_BY_MOIN_CORE ) ) {
            long currentTimeMillis = System.currentTimeMillis( );
            Date currentDate = new Date( currentTimeMillis );
            //$JL-SYS_OUT_ERR$ For testing only, having messages besides the test messages
            java.lang.System.out.println( "ResourceManagementImpl#updatePartitions: hand over partitions to be evicted to facilityEventManager, " + currentDate + "( " + currentTimeMillis + " )" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            java.lang.System.out.flush( );
        }

        this.eventManager.evictPartitions( partitionsToEvictPerStage );
    }

    public void updateContainer( CRI cri, ResourceRecord resourceRecord, boolean forced ) {

        boolean registrySwap = false;

        // update resource registration
        this.registryLock.writeLock( ).lock( );
        try {
            registrySwap = this.updateContainerRegistration( cri, resourceRecord );
        } finally {
            this.registryLock.writeLock( ).unlock( );
        }

        // sync index against new file system state
        SyncReport indexSyncReport = this.synchronizeIndexForContainer( cri, forced || registrySwap );

        // evict changed partitions
        this.evictOutdatedPartitions( indexSyncReport, this.dataAreaManager.getDataAreaByName( cri.getDataAreaDescriptor( ).getDataAreaName( ) ).getSingleStage( ) );
    }

    public boolean resourcesAvailableForContainer( CRI cri ) {

        boolean resourcesAvailable = false;

        // find registered storages for the given container
        this.registryLock.readLock( ).lock( );
        try {
            Map<String, List<IpiStorage>> containerMap = this.storageRegistry.get( cri.getDataAreaDescriptor( ) );
            if ( containerMap != null ) {
                List<IpiStorage> storages = containerMap.get( cri.getContainerName( ) );
                if ( storages != null && !storages.isEmpty( ) ) {
                    // we found one or more storages registered for the given container, so we return true
                    resourcesAvailable = true;
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }

        return resourcesAvailable;
    }


    public Set<String> getRegisteredResourceFoldersForContainer( CRI cri ) {

        Set<String> result = new HashSet<String>( );

        this.registryLock.readLock( ).lock( );
        try {
            Map<String, List<IpiStorage>> containerRegistry = this.storageRegistry.get( cri.getDataAreaDescriptor( ) );
            if ( containerRegistry != null ) {
                List<IpiStorage> storages = containerRegistry.get( cri.getContainerName( ) );
                if ( storages != null ) {
                    for ( IpiStorage storage : storages ) {
                        result.add( storage.getResourceFolder( ) );
                    }
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }
        return result;
    }

    public Set<String> getRegisteredResourceFoldersForRootPath( String rootPath ) {

        Set<String> resourceFolders = null;

        this.registryLock.readLock( ).lock( );
        try {
            ContainerResourceFolders containerResourceFolders = this.rootPathToContainerResourceFolders.get( rootPath );
            if ( containerResourceFolders != null ) {
                resourceFolders = containerResourceFolders.resourceFolders;
            } else {
                resourceFolders = Collections.emptySet( );
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }

        return resourceFolders;
    }

    public IpiStorage getStorageResponsibleForPRI( PRI pri ) {

        this.registryLock.readLock( ).lock( );
        try {
            Map<String, List<IpiStorage>> dataAreaRegistry = this.storageRegistry.get( pri.getDataAreaDescriptor( ) );
            if ( dataAreaRegistry != null ) {
                List<IpiStorage> containerStorages = dataAreaRegistry.get( pri.getCri( ).getContainerName( ) );
                if ( containerStorages != null ) {
                    for ( IpiStorage storage : containerStorages ) {
                        if ( storage.isResponsible( pri ) ) {
                            // returns the first storage found
                            return storage;
                        }
                    }
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }

        return null;
    }

    public InputStream getPartitionStream( PRI pri ) {

        IpiStorage storage = this.getStorageResponsibleForPRI( pri );
        if ( storage != null ) {
            return storage.getInputStreamForPartitionLoad( pri );
        }
        return null;
    }

    public Set<String> getRegisteredAbsoluteResourceFolderPaths( CRI cri ) {

        Set<String> result = new HashSet<String>( );

        this.registryLock.readLock( ).lock( );
        try {
            Map<String, List<IpiStorage>> containerMap = this.storageRegistry.get( cri.getDataAreaDescriptor( ) );
            if ( containerMap != null ) {
                List<IpiStorage> storages = containerMap.get( cri.getContainerName( ) );
                for ( IpiStorage storage : storages ) {
                    result.add( storage.getSourcePath( ) + "/" + storage.getResourceFolder( ) ); //$NON-NLS-1$
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }

        return result;
    }

    public Set<String> getRegisteredRootPathsForContainer( CRI cri ) {

        Set<String> result = new HashSet<String>( );

        this.registryLock.readLock( ).lock( );
        try {
            Map<String, List<IpiStorage>> containerMap = this.storageRegistry.get( cri.getDataAreaDescriptor( ) );
            if ( containerMap != null ) {
                List<IpiStorage> storages = containerMap.get( cri.getContainerName( ) );
                if ( storages != null ) {
                    for ( IpiStorage storage : storages ) {
                        if ( storage instanceof StorageDirectoryImpl ) {
                            result.add( storage.getSourcePath( ) );
                        }
                    }
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }

        return result;
    }

    /*
     * Private methods
     */


    /**
     * All update methods delegate to this method. Reason: No dependency between
     * those methods allows straightforward overwriting in subclasses.
     * <p>
     * Note that this method itself is not synchronized, but that all callers
     * have to lock the registry (see registryLock).
     * 
     * @return root paths of all registered directories (not archives)
     */
    private boolean updateContainerRegistration( CRI cri, ResourceRecord resourceRecord ) {

        boolean registrySwap = false;

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            String message = String.format( "Update container registration of %s: %s", cri.toString( ), formatResourceRecord( resourceRecord ) ); //$NON-NLS-1$
            LOGGER.trace( MoinSeverity.DEBUG, message );
        }

        // register folders
        Map<String, List<IpiStorage>> containerStorageRegistry = this.storageRegistry.get( cri.getDataAreaDescriptor( ) );

        if ( resourceRecord == null ) {
            if ( containerStorageRegistry != null ) {
                // remove the rootPaths for the container
                Set<String> rootPaths = this.containerToRootPaths.remove( cri );

                // remove the associated containerResourceFolders for each rootPath
                if ( rootPaths != null ) {
                    // remove the associated containerResourceFolders for each rootPath
                    for ( String rootPath : rootPaths ) {
                        this.rootPathToContainerResourceFolders.remove( rootPath );
                    }
                }

                // empty resource folders implies removal (deletion) of container
                List<IpiStorage> removed = containerStorageRegistry.remove( cri.getContainerName( ) );
                if ( removed != null && LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, "Removed storages: " + formatStorageList( removed ) ); //$NON-NLS-1$
                }
            }
        } else {
            if ( containerStorageRegistry == null ) {
                // container did not exist before
                containerStorageRegistry = new IdentityHashMap<String, List<IpiStorage>>( );
                Map<String, List<IpiStorage>> prevRegistration = this.storageRegistry.put( cri.getDataAreaDescriptor( ), containerStorageRegistry );

                // this code verifies if the registration changes from directories to archives and vice versa. In that case, we have a registrySwap, which leads
                // to a forced update in the index 
                if ( prevRegistration != null && !prevRegistration.isEmpty( ) ) {
                    List<IpiStorage> registeredStorages = prevRegistration.get( cri.getContainerName( ) );
                    if ( registeredStorages != null && !registeredStorages.isEmpty( ) ) {
                        IpiStorage storage = registeredStorages.iterator( ).next( );
                        if ( storage instanceof StorageDirectoryImpl && ( resourceRecord instanceof ResourceArchivesRecord || resourceRecord instanceof ResourceArchiveFoldersRecord ) ) {
                            registrySwap = true;
                        } else if ( storage instanceof StorageArchiveImpl && resourceRecord instanceof ResourceFoldersRecord ) {
                            registrySwap = true;
                        }
                    }
                }
            }

            Set<String> rootPaths = new HashSet<String>( );

            // overwrite any possible previous registrations!
            List<IpiStorage> storages = new ArrayList<IpiStorage>( );

            // keep a book-keep set to avoid duplicate registration of the same root path
            if ( resourceRecord instanceof ResourceFoldersRecord ) {
                // Registration of resource folders
                ResourceFoldersRecord resourceFolders = (ResourceFoldersRecord) resourceRecord;

                for ( Map.Entry<String, String> resourceFoldersToRootPathRecord : resourceFolders.resourceFolderPathsToRootPaths.entrySet( ) ) {
                    String resourceFolder = resourceFoldersToRootPathRecord.getKey( );
                    String rootPath = resourceFoldersToRootPathRecord.getValue( );

                    // register all root paths
                    rootPaths.add( rootPath );

                    // for each rootPath, update its associated ContainerResourceFolders
                    ContainerResourceFolders containerResourceFolders = this.rootPathToContainerResourceFolders.get( rootPath );
                    if ( containerResourceFolders != null ) {
                        if ( containerResourceFolders.container != cri ) {
                            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNEXPECTEDAMBIGUOUSREGISTRATION, rootPath, containerResourceFolders.container, cri );
                        }
                        containerResourceFolders.resourceFolders.add( resourceFolder );
                    } else {
                        containerResourceFolders = new ContainerResourceFolders( );
                        containerResourceFolders.container = cri;
                        containerResourceFolders.resourceFolders = new HashSet<String>( );
                        containerResourceFolders.resourceFolders.add( resourceFolder );
                        this.rootPathToContainerResourceFolders.put( rootPath, containerResourceFolders );
                    }


                    IpiStorage folderStorage;
                    if ( allSourceFoldersAreDirectoryFS( ) || rootPath.startsWith( File.separator ) ) { //$NON-NLS-1$
                        folderStorage = new StorageDirectoryImpl( cri, resourceFolder, rootPath, this.partitionSerializationManager, this.directoryLogicalFsFactory );
                    } else {
                        folderStorage = new StorageDirectoryImpl( cri, resourceFolder, rootPath, this.partitionSerializationManager, this.archiveLogicalFsFactory );
                    }
                    storages.add( folderStorage );
                }

            } else if ( resourceRecord instanceof ResourceArchivesRecord ) {
                // Registration of resource archives (directly referenced by their paths)
                ResourceArchivesRecord resourceArchivesRecord = (ResourceArchivesRecord) resourceRecord;

                for ( String resourceFolderPath : resourceArchivesRecord.resourceFoldersPaths ) {
                    for ( String archivePath : resourceArchivesRecord.archivePaths ) {

                        IpiStorage folderStorage = new StorageArchiveImpl( cri, resourceFolderPath, archivePath, this.partitionSerializationManager, this.archiveLogicalFsFactory );
                        storages.add( folderStorage );
                    }
                }

            } else if ( resourceRecord instanceof ResourceArchiveFoldersRecord ) {
                // Registration of resource archives in a given set of archive folders
                ResourceArchiveFoldersRecord resourceArchiveFoldersRecord = (ResourceArchiveFoldersRecord) resourceRecord;

                // obtain list of paths to archive folders
                List<String> archiveFoldersPaths = resourceArchiveFoldersRecord.archiveFoldersPaths;

                // obtain relevant archive paths from archive folders
                List<String> archivePaths = filterForRelevantArchivePaths( archiveFoldersPaths, new HashSet<String>( resourceArchiveFoldersRecord.resourceFoldersPaths ) );

                for ( String resourceFolderPath : resourceArchiveFoldersRecord.resourceFoldersPaths ) {
                    for ( String archivePath : archivePaths ) {

                        IpiStorage folderStorage = new StorageArchiveImpl( cri, resourceFolderPath, archivePath, this.partitionSerializationManager, this.archiveLogicalFsFactory );
                        storages.add( folderStorage );
                    }
                }

            } else {
                // Registration of unknown resource type
                throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNKNOWN_SUBTYPE_DETECTED, resourceRecord.getClass( ).getName( ), ResourceRecord.class.getName( ) );
            }

            if ( !storages.isEmpty( ) ) {
                // register storages 
                List<IpiStorage> replaced = containerStorageRegistry.put( cri.getContainerName( ), storages );
                if ( replaced != null && LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, "Replaced storages: " + formatStorageList( replaced ) ); //$NON-NLS-1$
                }
            } else {
                // deregister possibly registered storages if no valid storages could be created with the given registration information
                containerStorageRegistry.remove( cri.getContainerName( ) );
            }

            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, "Registered Storages: " + formatStorageList( storages ) ); //$NON-NLS-1$
            }

            this.containerToRootPaths.put( cri, rootPaths );
        }

        return registrySwap;
    }

    private static Boolean allSourceFoldersAreDirectoryFSValue = null;

    private boolean allSourceFoldersAreDirectoryFS( ) {

        if ( allSourceFoldersAreDirectoryFSValue == null ) {
            String value = System.getProperty( "com.sap.tc.moin.facility.primary.persistence.fs.AllSourceFoldersAreDirectoryFS" ); //$NON-NLS-1$
            if ( value == null || !"FALSE".equalsIgnoreCase( value ) ) //$NON-NLS-1$
            {
                allSourceFoldersAreDirectoryFSValue = true;
            } else {
                allSourceFoldersAreDirectoryFSValue = false;
            }
        }
        return allSourceFoldersAreDirectoryFSValue;
    }

    /**
     * We force the eviction of partitions which were deleted or changed.
     */
    private void evictOutdatedPartitions( SyncReport indexSyncReport, SpiStage stage ) {

        // FIXME: remove this asap
        if ( Boolean.getBoolean( IpiPrimaryFacility.TEST_NOTIFICATION_AND_PARTITION_EVICTION_BY_MOIN_CORE ) ) {
            long currentTimeMillis = System.currentTimeMillis( );
            Date currentDate = new Date( currentTimeMillis );
            //$JL-SYS_OUT_ERR$ For testing only, having messages besides the test messages
            java.lang.System.out.println( "ResourceManagementImpl#evictOutdatedPartitions: hand over partitions to be evicted to facilityEventManager, " + currentDate + "( " + currentTimeMillis + " )" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            java.lang.System.out.flush( );
        }

        Map<SpiStage, List<PRI>> partitionsToEvictPerStage = new HashMap<SpiStage, List<PRI>>( );

        List<PRI> partitionsEvict = new ArrayList<PRI>( indexSyncReport.DELETED.size( ) + indexSyncReport.UPDATED.size( ) );
        partitionsEvict.addAll( indexSyncReport.DELETED );
        partitionsEvict.addAll( indexSyncReport.UPDATED );

        partitionsToEvictPerStage.put( stage, partitionsEvict );

        this.eventManager.evictPartitions( partitionsToEvictPerStage );
    }

    // public for test purposes
    public SyncReport synchronizeIndexForDataArea( DataAreaDescriptor dataAreaDescriptor, boolean forced ) {

        SyncReport result = null;

        // for metamodel dataareas we do nothing...
        if ( !dataAreaDescriptor.isMetamodelDataArea( ) ) {

            List<PartitionSyncInfo> priInfos = this.getPartitionSyncInfos( dataAreaDescriptor );

            // for each partition in the file system:
            // create PRIs and determine timestamps
            PRI fsPartitionPris[] = new PRI[priInfos.size( )];
            long fsPartitionTimestamps[] = new long[priInfos.size( )];
            int i = 0;
            for ( Iterator<PartitionSyncInfo> iterator = priInfos.iterator( ); iterator.hasNext( ); i++ ) {
                PartitionSyncInfo priInfo = iterator.next( );
                fsPartitionPris[i] = priInfo.pri;
                fsPartitionTimestamps[i] = priInfo.timeStamp;
            }

            // get responsible index instance and start synchronization
            // of partitions in index and file system
//            result = this.indexManagement.synchronize( IpiIndexManagement.SyncKind.MODEL_CONTENT, fsPartitionPris, fsPartitionTimestamps, this, dataAreaDescriptor, forced );
            result = this.indexManagement.synchronize( fsPartitionPris, fsPartitionTimestamps, this, forced, dataAreaDescriptor );
        }

        return result;
    }

    private SyncReport synchronizeIndexForContainer( CRI cri, boolean forced ) {

        SyncReport result = null;

        // for metamodel datatareas we do nothing...
        if ( !IpiPrimaryFacility.META_MODEL_DATA_AREA_ID.equals( cri.getDataAreaDescriptor( ).getDataAreaName( ) ) ) {

            List<PartitionSyncInfo> priInfos = this.getPartitionSyncInfos( cri );

            // for each partition in the file system:
            // create PRIs and determine timestamps
            PRI fsPartitionPris[] = new PRI[priInfos.size( )];
            long fsPartitionTimestamps[] = new long[priInfos.size( )];
            int i = 0;
            for ( Iterator<PartitionSyncInfo> iterator = priInfos.iterator( ); iterator.hasNext( ); i++ ) {
                PartitionSyncInfo priInfo = iterator.next( );
                fsPartitionPris[i] = priInfo.pri;
                fsPartitionTimestamps[i] = priInfo.timeStamp;
            }

            // synchronization of partitions in index and file system
//            result = this.indexManagement.synchronize( IpiIndexManagement.SyncKind.MODEL_CONTENT, fsPartitionPris, fsPartitionTimestamps, this, cri, forced );
            result = this.indexManagement.synchronize( fsPartitionPris, fsPartitionTimestamps, this, forced, cri );
        }
        return result;
    }

    private List<PartitionSyncInfo> getPartitionSyncInfos( CRI cri ) {

        return this.getPartitionSyncInfos( cri.getDataAreaDescriptor( ), cri.getContainerName( ) );
    }

    private List<PartitionSyncInfo> getPartitionSyncInfos( DataAreaDescriptor dataAreaDescriptor, String containerName ) {

        List<PartitionSyncInfo> priInfos = new ArrayList<PartitionSyncInfo>( );

        this.registryLock.readLock( ).lock( );
        try {
            Map<String, List<IpiStorage>> containerMap = this.storageRegistry.get( dataAreaDescriptor );
            if ( containerMap != null ) {
                List<IpiStorage> storages = containerMap.get( containerName );
                if ( storages != null ) {
                    for ( IpiStorage storage : storages ) {
                        List<IpiStorage.PartitionInfo> partitionInfos = storage.getPartitionInfos( );
                        for ( IpiStorage.PartitionInfo partitionInfo : partitionInfos ) {
                            PartitionSyncInfo priInfo = new PartitionSyncInfo( );

                            priInfo.pri = this.riFactory.createPri( dataAreaDescriptor.getDataAreaName( ), containerName, partitionInfo.partitionName );
                            priInfo.timeStamp = partitionInfo.timeStamp;

                            priInfos.add( priInfo );
                        }
                    }
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }

        return priInfos;
    }

    public static final class PartitionSyncInfo {

        public PRI pri;

        long timeStamp;
    }

    private List<PartitionSyncInfo> getPartitionSyncInfos( DataAreaDescriptor dataAreaDescriptor ) {

        List<PartitionSyncInfo> priInfos = new ArrayList<PartitionSyncInfo>( );

        this.registryLock.readLock( ).lock( );
        try {
            Map<String, List<IpiStorage>> containerMap = this.storageRegistry.get( dataAreaDescriptor );

            if ( containerMap != null ) {
                for ( Map.Entry<String, List<IpiStorage>> containerMapEntries : containerMap.entrySet( ) ) {
                    priInfos.addAll( this.getPartitionSyncInfos( dataAreaDescriptor, containerMapEntries.getKey( ) ) );
                }
            }
        } finally {
            this.registryLock.readLock( ).unlock( );
        }


        return priInfos;
    }

    /**
     * Searches for all zip and jar archives in the archiveFoldersPaths
     * (non-recursively) and fetches those archives who have at least one of the
     * resourceFolderPaths in them
     */
    private List<String> filterForRelevantArchivePaths( List<String> archiveFoldersPaths, final Set<String> resourceFoldersPaths ) {

        // This filter only returns directories
        FileFilter fileFilter = new FileFilter( ) {

            public boolean accept( File file ) {

                if ( file == null ) {
                    return false;
                }

                // only interested in files, not directories 
                if ( file.isDirectory( ) ) {
                    return false;
                }

                // we only take zip or jar
                if ( file.getName( ).endsWith( ".zip" ) || file.getName( ).endsWith( ".jar" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                    ZipFile zipFile = null;
                    try {
                        zipFile = new ZipFile( file, ZipFile.OPEN_READ );
                        // iterate over all resourceFolderPaths and look if we find a zip entry for it
                        for ( String resourceFolderPath : resourceFoldersPaths ) {
                            ZipEntry zipEntry = zipFile.getEntry( resourceFolderPath );
                            if ( zipEntry != null ) {
                                return true;
                            }
                        }

                    } catch ( IOException e ) {
                        if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                            LOGGER.trace( e, MoinSeverity.ERROR, "Error opening zip or jar file: " + file.getAbsolutePath( ) + " ! ", null ); //$NON-NLS-1$ //$NON-NLS-2$
                        }
                    } finally {
                        if ( zipFile != null ) {
                            try {
                                zipFile.close( );
                            } catch ( IOException e ) {
                                if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                                    LOGGER.trace( e, MoinSeverity.ERROR, "Error closing zip or jar file: " + file.getAbsolutePath( ) + " ! ", null ); //$NON-NLS-1$ //$NON-NLS-2$
                                }
                            }
                        }
                    }
                }

                return false;
            }
        };

        List<String> relevantArchivePaths = new ArrayList<String>( archiveFoldersPaths.size( ) );

        for ( String archiveFolderPath : archiveFoldersPaths ) {
            // check for relevant archives for each archive folder path
            File archiveFolder = new File( archiveFolderPath );
            File[] relevantArchiveFiles = archiveFolder.listFiles( fileFilter );
            if ( relevantArchiveFiles != null ) {
                for ( int i = 0; i < relevantArchiveFiles.length; i++ ) {
                    relevantArchivePaths.add( relevantArchiveFiles[i].getPath( ) );
                }
            }
        }

        return relevantArchivePaths;
    }

    // ############## LOGGING HELPER METHODS ###############

    private static String formatResourceRecord( ResourceRecord record ) {

        if ( record == null ) {
            return String.valueOf( record );
        }
        StringBuilder sb = new StringBuilder( );
        sb.append( "RecordType=" ).append( record.getClass( ).getName( ) ); //$NON-NLS-1$
        if ( record instanceof ResourceFoldersRecord ) {
            ResourceFoldersRecord rfr = (ResourceFoldersRecord) record;
            sb.append( "\n\tResource folder paths to root paths:" ); //$NON-NLS-1$
            for ( Entry<String, String> entry : rfr.resourceFolderPathsToRootPaths.entrySet( ) ) {
                sb.append( "\n\t\t[ " ); //$NON-NLS-1$
                sb.append( entry.getKey( ) );
                sb.append( " , " ); //$NON-NLS-1$
                sb.append( entry.getValue( ) );
                sb.append( " ]" ); //$NON-NLS-1$
            }
        } else if ( record instanceof ResourceArchiveFoldersRecord ) {
            ResourceArchiveFoldersRecord rafr = (ResourceArchiveFoldersRecord) record;
            sb.append( "\n\tArchive folders paths:" ); //$NON-NLS-1$
            for ( String entry : rafr.archiveFoldersPaths ) {
                sb.append( "\n\t\t[ " ); //$NON-NLS-1$
                sb.append( entry );
                sb.append( " ]" ); //$NON-NLS-1$
            }
            sb.append( "\n\tResource folders paths:" ); //$NON-NLS-1$
            for ( String entry : rafr.resourceFoldersPaths ) {
                sb.append( "\n\t\t[ " ); //$NON-NLS-1$
                sb.append( entry );
                sb.append( " ]" ); //$NON-NLS-1$
            }
        } else if ( record instanceof ResourceArchivesRecord ) {
            ResourceArchivesRecord rar = (ResourceArchivesRecord) record;
            sb.append( "\n\tArchive paths:" ); //$NON-NLS-1$
            for ( String entry : rar.archivePaths ) {
                sb.append( "\n\t\t[ " ); //$NON-NLS-1$
                sb.append( entry );
                sb.append( " ]" ); //$NON-NLS-1$
            }
            sb.append( "\n\tResource folders paths:" ); //$NON-NLS-1$
            for ( String entry : rar.resourceFoldersPaths ) {
                sb.append( "\n\t\t[ " ); //$NON-NLS-1$
                sb.append( entry );
                sb.append( " ]" ); //$NON-NLS-1$
            }
        }
        return sb.toString( );
    }

    private static String formatStorageList( List<IpiStorage> storages ) {

        if ( storages == null ) {
            return "null"; //$NON-NLS-1$
        }

        StringBuilder sb = new StringBuilder( );
        for ( IpiStorage storage : storages ) {
            sb.append( "\n\t[ " ); //$NON-NLS-1$
            sb.append( storage.toString( ) );
            sb.append( " ]" ); //$NON-NLS-1$
        }
        return sb.toString( );
    }
}
