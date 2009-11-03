package com.sap.tc.moin.facility.primary.persistence.fs;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmx.FsPersistenceMBean;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.facility.SpiAbstractPersistence;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XDocument;

/**
 * Pluggable instance of an index based filesystem persistence.
 * 
 * @author d047015
 * @author d025744
 */
public class FsPersistenceImpl extends SpiAbstractPersistence implements IpiFacilityComponent {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS, FsPersistenceImpl.class );

    private String moinId;

    // bound facility components

    private SpiPartitionStreamProvider metamodelPartitionStreamProvider;

    private SpiPartitionSerializationManager partitionSerializationManager;

    protected IpiFsResourceManagement resourceManagement;

    private IpiIndexManagement indexManagement;

    private ResourceIdentifierFactory riFactory; // only needed for resolution of pri strings in JmxAdapter

    // JMX related data

    /**
     * The {@link ObjectName} instance uniquely identifying our MBean in the
     * MBeanServer.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer.
     */
    private JmxAdapter jmxAdapter;

    /**
     * Whether the XMI trace is currently enabled.
     */
    public volatile boolean jmxNotificationsEnabled;

    public FsPersistenceImpl( String moinId, ReferenceQueue refQueue ) {

        this.moinId = moinId;
        if ( JMX_ENABLED ) {
            this.objectName = this.getObjectName( );
            this.jmxAdapter = new JmxAdapter( this, this.objectName, refQueue );
        }
    }

    /*
     * binding the different components
     */

    public void bind( IpiFsResourceManagement resourceManagement ) {

        this.resourceManagement = resourceManagement;
    }

    public void bind( SpiPartitionStreamProvider metaModelPartitionStreamProvider ) {

        this.metamodelPartitionStreamProvider = metaModelPartitionStreamProvider;
    }

    public void bind( IpiIndexManagement indexManagement ) {

        this.indexManagement = indexManagement;
    }

    public void bind( SpiPartitionSerializationManager serializationManager ) {

        this.partitionSerializationManager = serializationManager;
    }

    public void bind( ResourceIdentifierFactory riFactory ) {

        this.riFactory = riFactory;
    }

    public void initialize( ) {

    }

    public void tearDown( ) {

        if ( JMX_ENABLED ) {
            SpiJmxHelper.unregisterMBean( this.objectName );
        }
    }

    public void finalizeStartup( ) {

    }

    /*
     * SPI method
     */

    public boolean loadPartition( SpiPartitionLoadContext loadContext ) {

        boolean successfullyLoaded = false;
        InputStream partitionInputStream = null;
        PRI pri = loadContext.getPri( );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            // FIXME repair logging
//            String message = String.format( "Load partition %s\n\tSession: @%h=(%s)\n\tworkspace: @%h=%s", pri == null ? "PRI is null" : pri.toString( ), session, session == null ? "Session is null" : session.toString( ), ws, ws == null ? "Workspace is null" : ws.toString( ) );
//            LOGGER.trace( MoinSeverity.DEBUG, message );
        }

        // if the partition is not indexed we assume it's not available in the file system
        try {
            if ( pri.isMetaModelPartition( ) ) {
                // directly try to load the partition without checking existence via index; introduced to avoid deadlocks
                // during the lazy load of a metamodel performed during the load of a M1 partition and the indexing of a partition
                // crossed locks are: PartitionManagerImpl of metamodel workspace and index lock
                try {
                    partitionInputStream = this.metamodelPartitionStreamProvider.getPartitionStream( pri );
                    successfullyLoaded = this.loadPartitionInternal( partitionInputStream, loadContext, -1 ); // currently there is no file size information available for m2 partitions
                } finally {
                    if ( partitionInputStream != null ) {
                        try {
                            partitionInputStream.close( );
                        } catch ( IOException e ) {
                            // repair operation failed. no exception thrown, not traced.
                            // $JL-EXC$
                        }
                    }
                }
            } else {
                // this might throw a FsRuntimeException if the partition does not exist in the file system

                // check whether the partition is indexed
                if ( this.indexManagement.isPartitionIndexed( pri ) ) {
                    IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );

                    if ( storage != null ) {
                        for ( int i = 0; i < 10; i++ ) {
                            long timestampBeforeLoad = storage.partitionLastChanged( pri );
                            long partitionFileSize = storage.partitionFileSize( pri );

                            try {
                                partitionInputStream = storage.getInputStreamForPartitionLoad( pri );
                                successfullyLoaded = this.loadPartitionInternal( partitionInputStream, loadContext, partitionFileSize );
                            } finally {
                                if ( partitionInputStream != null ) {
                                    try {
                                        partitionInputStream.close( );
                                    } catch ( IOException ioe ) {
                                        // $JL-EXC$
                                    }
                                }
                            }

                            long timestampAfterLoad = storage.partitionLastChanged( pri );

                            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                                String message = String.format( "Tried to load partition %s (%d. try):\n\tBefore Load Disc Time: %d\n\tAfter Load Disc Time: %d\n\t -> load succeded = %b ", pri.toString( ), i, timestampBeforeLoad, timestampAfterLoad, ( timestampBeforeLoad == timestampAfterLoad ) ); //$NON-NLS-1$
                                LOGGER.trace( MoinSeverity.DEBUG, message );
                            }

                            // compare both timestamps to be sure that index has the content of the loaded stream
                            if ( timestampBeforeLoad == timestampAfterLoad ) {
                                loadContext.setPersistedTimestamp( timestampAfterLoad );
                                break;
                            } else {
                                // we give it another try
                                successfullyLoaded = false;
                            }
                        }
                    }
                    if ( !successfullyLoaded ) {
                        if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                            LOGGER.trace( MoinSeverity.ERROR, "Unable to load PRI " + pri.toString( ) + "  from file system! " ); //$NON-NLS-1$ //$NON-NLS-2$
                        }
                    }
                } else {
                    if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                        LOGGER.trace( MoinSeverity.DEBUG, "Unable to load PRI " + pri.toString( ) + "  from file system! Partition is not in index." ); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                }
            }
        } catch ( RuntimeException e ) {
            if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                LOGGER.trace( e, MoinSeverity.ERROR, "Unable to load PRI " + pri.toString( ) + "  from file system! " ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return successfullyLoaded;
    }

    /*
     * Mandatory implementation of abstract methods
     */

    @Override
    protected void storePartition( SpiPartitionSaveContext toSave ) {

        // save in file system
        this.storePartitionInternal( toSave );

        PRI pri = toSave.getPri( );

        // update index
        // get the time-stamp if the partition has been changed
        long timestamp = this.partitionLastChanged( pri );
        long indexTimestamp = this.indexManagement.getPartitionTimestamp( pri );

        // check if the index content is still the original loaded model partition
        if ( indexTimestamp == toSave.getPersistedTimestamp( ) ) {
            this.indexManagement.indexPartition( pri, toSave.getPartitionDelta( ), timestamp );
        } else {
            SpiPartitionStreamProvider streamProv = createStreamProvider( pri );
            this.indexManagement.indexPartition( pri, streamProv, timestamp, true ); // forced indexing
        }
        toSave.setPersistedTimestamp( timestamp );
    }

    @Override
    protected void storePartitionTexts( SpiPartitionSaveContext partition, SpiS2XDocument s2xDocument ) {

        // TODO enable JMX, see storePartitionInternal (MM)
        OutputStream fos = null;
        try {
            fos = this.getTextOutputStreamForPRI( partition.getPri( ) );
            try {
                if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                    long t = System.nanoTime( );
                    this.traceStoreTextFileStart( partition.getPri( ), Thread.currentThread( ).getStackTrace( ) );
                    this.serializePartitionTexts( fos, s2xDocument, partition );
                    long duration = ( System.nanoTime( ) - t ) / 1000000;
                    this.traceStoreTextFileEnd( partition.getPri( ), duration );
                } else {
                    this.serializePartitionTexts( fos, s2xDocument, partition );
                }
            } catch ( IOException e ) {
                throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.PARTITIONTEXTSCOULDNOTBEWRITTEN, partition.getPri( ) );
            }
        } finally {
            if ( fos != null ) {
                try {
                    fos.close( );
                } catch ( IOException e ) {
                    throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.STOREPARTITIONTEXTSFAILED );
                }
            }
        }
    }

    @Override
    protected void deletePartition( PRI pri ) {

        // there is only one stage in the IDE scenario
        // so we ignore the stage parameter for now

        // delegate deletion on the file system to super
        this.deletePartitionInternal( pri );

        // remove the partition from the index
        /*
         * The partition is not removed from index, if the prior called method
         * throws an exception. This is because we cannot determine, if the file
         * to delete still exists in a valid state. If the file was deleted from
         * file system, the index will be updated by eventing.
         */
        this.indexManagement.removePartition( pri );
    }

    @Override
    protected void deletePartitionTexts( PRI pri ) {

        IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );
        if ( storage == null ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNABLE_TO_DELETE_PARTITION_TEXT_NO_STORAGE, pri );
        }
        boolean wasDeleted = storage.deletePartitionTexts( pri );
        if ( !wasDeleted ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNABLE_TO_DELETE_PARTITION_TEXT_CAUSE_UNKNOWN, pri );
        }
    }

    protected boolean textFileExists( PRI pri ) {

        IpiStorage storage = resourceManagement.getStorageResponsibleForPRI( pri );
        return storage != null && storage.textFileExists( pri );
    }

    /*
     * private methods
     */

    private SpiPartitionStreamProvider createStreamProvider( final PRI pri ) {

        if ( pri == null ) {
            throw new MoinIllegalArgumentException( PersistenceFsMessages.ARGUMENT_MUST_NOT_BE_NULL, "pri" ); //$NON-NLS-1$
        }

        return new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI _pri ) {

                if ( pri == _pri ) {
                    // cannot return null
                    IpiStorage storage = FsPersistenceImpl.this.resourceManagement.getStorageResponsibleForPRI( pri );
                    return storage.getInputStreamForPartitionLoad( pri );
                } else {
                    throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNEXPECTED_PRI_STREAM_REQUESTED, pri, _pri );
                }
            }
        };
    }

    private boolean loadPartitionInternal( InputStream is, SpiPartitionLoadContext loadContext, long partitionFileSize ) {

        if ( is == null ) {
            return false;
        }
        try {
            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                long t = System.nanoTime( );
                this.traceLoadPartitionStart( loadContext.getSession( ), loadContext.getPri( ), Thread.currentThread( ).getStackTrace( ) );
                this.parsePartition( is, loadContext, partitionFileSize );
                long duration = ( System.nanoTime( ) - t ) / 1000000;
                this.traceLoadPartitionEnd( loadContext.getSession( ), loadContext.getPri( ), duration );
            } else {
                this.parsePartition( is, loadContext, partitionFileSize );
            }
        } catch ( IOException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.UNABLE_TO_READ_PARTITION, loadContext.getPri( ) );
        }
        return true;
    }

    private void parsePartition( InputStream is, SpiPartitionLoadContext loadContext, long partitionFileSize ) throws IOException {

        SpiParserCallback callback = loadContext.getParserCallback( );
        this.partitionSerializationManager.parse( loadContext.getPri( ), is, callback, partitionFileSize );
    }

    private void storePartitionInternal( SpiPartitionSaveContext toSave ) {

        OutputStream fos = null;
        try {
            fos = this.getOutputStreamForPRI( toSave.getPri( ) );
            try {
                if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                    long t = System.nanoTime( );
                    this.traceStorePartitionStart( toSave.getPri( ), Thread.currentThread( ).getStackTrace( ) );
                    this.serializePartition( fos, toSave );
                    long duration = ( System.nanoTime( ) - t ) / 1000000;
                    this.traceStorePartitionEnd( toSave.getPri( ), toSave.getNumberOfElements( ), toSave.getNumberOfLinks( ), duration );
                } else {
                    this.serializePartition( fos, toSave );
                }
            } catch ( IOException e ) {
                throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.PARTITIONCOULDNOTBEWRITTEN, toSave.getPri( ) );
            }
        } finally {
            if ( fos != null ) {
                try {
                    fos.close( );
                } catch ( IOException e ) {
                    throw new MoinLocalizedBaseRuntimeException( e, PersistenceFsMessages.STOREPARTITIONFAILED );
                }
            }
        }
    }

    private void serializePartition( OutputStream os, SpiPartitionSaveContext toSave ) throws IOException {

        this.partitionSerializationManager.serialize( toSave.getPri( ), os, toSave.getSerializerCallback( ) );
    }

    private void serializePartitionTexts( OutputStream outputStream, SpiS2XDocument s2xDocument, SpiPartitionSaveContext partition ) throws IOException {

        SpiSerializerCallback serializerCallback = partition.getSerializerCallback( );
        this.partitionSerializationManager.serializeTexts( partition.getPri( ), outputStream, s2xDocument, serializerCallback );
    }

    private void deletePartitionInternal( PRI pri ) {

        IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );
        if ( storage == null ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNABLE_TO_DELETE_PARTITION_NO_STORAGE, pri );
        }
        boolean wasDeleted = storage.deletePartition( pri );
        if ( !wasDeleted ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNABLE_TO_DELETE_PARTITION_CAUSE_UNKNOWN, pri );
        }
    }

    /**
     * Searches the unique OutputStream for the PRI
     */
    private OutputStream getOutputStreamForPRI( PRI pri ) {

        IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );
        if ( storage == null ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE, pri );
        }

        return storage.getOutputStreamForPartitionStore( pri );
    }

    /**
     * Searches the unique OutputStream for the texts in the partition with the
     * given PRI
     */
    private OutputStream getTextOutputStreamForPRI( PRI pri ) {

        IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );
        if ( storage == null ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceFsMessages.UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE, pri );
        }

        return storage.getOutputStreamForPartitionTextStore( pri );
    }

    private long partitionLastChanged( PRI pri ) {

        IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );

        if ( storage == null ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "No storage registed for PRI " + pri.toString( ) + " ! " ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            return -1;
        } else {
            return storage.partitionLastChanged( pri );
        }
    }

    /**
     * Returns the {@link ObjectName} uniquely identifying our MBean on the
     * MBeanServer.
     */
    public ObjectName getObjectName( ) {

        try {
            return new ObjectName( MOIN_DOMAIN + "type=FsPersistence,moin=" + moinId ); //$NON-NLS-1$
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Forwards the information about the beginning of a partition load
     * operation to our MBean, which in turn emits a JMX notification.
     */
    private void traceLoadPartitionStart( Session session, PRI pri, StackTraceElement[] elements ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.loadPartitionStart( session, pri, elements );
        }
    }

    /**
     * Forwards the information about the end of a partition load operation to
     * our MBean, which in turn emits a JMX notification.
     */
    private void traceLoadPartitionEnd( Session session, PRI pri, long duration ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.loadPartitionEnd( session, pri, duration );
        }
    }

    /**
     * Forwards the information about the beginning of a partition store
     * operation to our MBean, which in turn emits a JMX notification.
     */
    private void traceStorePartitionStart( PRI pri, StackTraceElement[] elements ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.storePartitionStart( pri, elements );
        }
    }

    /**
     * Forwards the information about the end of a partition store operation to
     * our MBean, which in turn emits a JMX notification.
     */
    private void traceStorePartitionEnd( PRI pri, int elements, int links, long duration ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.storePartitionEnd( pri, elements, links, duration );
        }
    }

    /**
     * Forwards the information about the beginning of a text file load
     * operation to our MBean, which in turn emits a JMX notification.
     */
    private void traceLoadTextFileStart( Session session, PRI pri, StackTraceElement[] elements ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.loadTextFileStart( session, pri, elements );
        }
    }

    /**
     * Forwards the information about the end of a text file load operation to
     * our MBean, which in turn emits a JMX notification.
     */
    private void traceLoadTextFileEnd( Session session, PRI pri, int texts, long duration ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.loadTextFileEnd( session, pri, texts, duration );
        }
    }

    /**
     * Forwards the information about the beginning of a text file store
     * operation to our MBean, which in turn emits a JMX notification.
     */
    private void traceStoreTextFileStart( PRI pri, StackTraceElement[] elements ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.storeTextFileStart( pri, elements );
        }
    }

    /**
     * Forwards the information about the end of a text file store operation to
     * our MBean, which in turn emits a JMX notification.
     */
    private void traceStoreTextFileEnd( PRI pri, long duration ) {

        if ( this.jmxAdapter != null ) {
            this.jmxAdapter.storeTextFileEnd( pri, duration );
        }
    }

    /**
     * The class implementing the MBean.
     */
    private static final class JmxAdapter extends NotificationBroadcasterSupport implements FsPersistenceMBean {

        private static final CompositeType compositeTypeForStorages;

        private static final TabularType tabularTypeForStorages;

        private static final String[] indexNames;

        static {
            try {
                indexNames = new String[] { "1: Data Area", "2: Container", "3: Source Path", "4: Resource Folder", "5: Storage Type" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                compositeTypeForStorages = new CompositeType( "Storage", "Storage", indexNames, indexNames, new OpenType[] { SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING } ); //$NON-NLS-1$ //$NON-NLS-2$
                tabularTypeForStorages = new TabularType( "Storages", "Storages", compositeTypeForStorages, indexNames ); //$NON-NLS-1$ //$NON-NLS-2$
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e ); // not expected to occur
            }
        }

        private final WeakReferenceWithObjectName<FsPersistenceImpl> fsPersistenceRef;

        /**
         * The object name uniquely identifying this MBean on the MBeanServer.
         */
        private final ObjectName objectName;

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        private JmxAdapter( FsPersistenceImpl fsPersistence, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            this.fsPersistenceRef = new WeakReferenceWithObjectName<FsPersistenceImpl>( fsPersistence, objectName, refQueue );
            registerBroadcastingMBean( this, FsPersistenceMBean.class, objectName );
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( FsPersistenceMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by a FsPersistence MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        @SuppressWarnings( "unchecked" )
        public TabularData getStorages( ) throws IOException {

            FsPersistenceImpl fsPersistence = this.fsPersistenceRef.get( );
            if ( fsPersistence != null ) {
                TabularData result = new TabularDataSupport( tabularTypeForStorages );

                List<AbstractStorageImpl> storages = new ArrayList<AbstractStorageImpl>( );

                // obtain resource management implementation
                ResourceManagementImpl resourceManagementImpl = (ResourceManagementImpl) fsPersistence.resourceManagement;

                resourceManagementImpl.registryLock.readLock( ).lock( );
                try {
                    for ( Map.Entry<DataAreaDescriptor, Map<String, List<IpiStorage>>> entry : resourceManagementImpl.storageRegistry.entrySet( ) ) {
                        if ( entry.getValue( ) != null ) {
                            for ( Map.Entry<String, List<IpiStorage>> entry2 : entry.getValue( ).entrySet( ) ) {
                                if ( entry2.getValue( ) != null ) {
                                    for ( IpiStorage storage : entry2.getValue( ) ) {
                                        storages.add( (AbstractStorageImpl) storage );
                                    }
                                }
                            }
                        }
                    }
                } finally {
                    resourceManagementImpl.registryLock.readLock( ).unlock( );
                }

                for ( AbstractStorageImpl storage : storages ) {
                    Map map = new HashMap( );
                    map.put( indexNames[0], storage.cri.getDataAreaDescriptor( ).getDataAreaName( ) );
                    map.put( indexNames[1], storage.cri.getContainerName( ) );
                    map.put( indexNames[2], storage.getSourcePath( ) );
                    map.put( indexNames[3], storage.getResourceFolder( ) );
                    if ( storage instanceof StorageArchiveImpl ) {
                        map.put( indexNames[4], "Archive" ); //$NON-NLS-1$
                    } else if ( storage instanceof StorageDirectoryImpl ) {
                        map.put( indexNames[4], "Directory" ); //$NON-NLS-1$
                    } else {
                        map.put( indexNames[4], "unknown" ); //$NON-NLS-1$
                    }
                    try {
                        result.put( new CompositeDataSupport( compositeTypeForStorages, map ) );
                    } catch ( OpenDataException ex ) {
                        throw new RuntimeException( ex );
                    }
                }
                return result;
            }
            return null;
        }

        public String getPartitionContent( String priString ) throws IOException {

            FsPersistenceImpl fsPersistence = this.fsPersistenceRef.get( );
            if ( fsPersistence != null ) {
                StringBuilder result = new StringBuilder( );
                PRI pri = fsPersistence.riFactory.createPri( priString );
                InputStream partitionInputStream = null;
                BufferedReader reader = null;
                try {
                    // get stream
                    if ( pri.isMetaModelPartition( ) ) {
                        partitionInputStream = fsPersistence.metamodelPartitionStreamProvider.getPartitionStream( pri );
                    } else {
                        IpiStorage storage = fsPersistence.resourceManagement.getStorageResponsibleForPRI( pri );
                        partitionInputStream = storage.getInputStreamForPartitionLoad( pri );
                    }

                    // read content from stream
                    reader = new BufferedReader( new InputStreamReader( partitionInputStream, "UTF-8" ) ); //$NON-NLS-1$
                    String line;
                    while ( ( line = reader.readLine( ) ) != null ) {
                        result.append( line ).append( "\n" ); //$NON-NLS-1$
                    }
                } catch ( Exception ex ) {
                    throw new RuntimeException( ex.getLocalizedMessage( ) );
                } finally {
                    if ( reader != null ) {
                        try {
                            reader.close( );
                        } catch ( IOException e ) {
                            // $JL-EXC$
                        }
                    }
                    if ( partitionInputStream != null ) {
                        try {
                            partitionInputStream.close( );
                        } catch ( IOException ioe ) {
                            // $JL-EXC$
                        }
                    }
                }
                return result.toString( );
            }
            return null;
        }

        public String getPartitionTexts( String priString ) throws IOException {

            FsPersistenceImpl fsPersistence = this.fsPersistenceRef.get( );
            if ( fsPersistence != null ) {
                PRI pri = fsPersistence.riFactory.createPri( priString );
                if ( !pri.isMetaModelPartition( ) ) {
                    InputStream partitionTextsInputStream = null;
                    BufferedReader reader = null;
                    try {
                        // get stream
                        IpiStorage storage = fsPersistence.resourceManagement.getStorageResponsibleForPRI( pri );
                        if ( storage.textFileExists( pri ) ) {
                            partitionTextsInputStream = storage.getInputStreamForPartitionTextLoad( pri );
                            // read content from stream
                            reader = new BufferedReader( new InputStreamReader( partitionTextsInputStream, "UTF-8" ) ); //$NON-NLS-1$
                            StringBuilder result = new StringBuilder( );
                            String line;
                            while ( ( line = reader.readLine( ) ) != null ) {
                                result.append( line ).append( "\n" ); //$NON-NLS-1$
                            }
                            return result.toString( );
                        }
                    } catch ( Exception ex ) {
                        throw new RuntimeException( ex.getLocalizedMessage( ) );
                    } finally {
                        if ( reader != null ) {
                            try {
                                reader.close( );
                            } catch ( IOException e ) {
                                // $JL-EXC$
                            }
                        }
                        if ( partitionTextsInputStream != null ) {
                            try {
                                partitionTextsInputStream.close( );
                            } catch ( IOException ioe ) {
                                // $JL-EXC$
                            }
                        }
                    }
                }
            }
            return null;
        }

        public void startNotifications( ) throws IOException {

            FsPersistenceImpl fsPersistence = this.fsPersistenceRef.get( );
            if ( fsPersistence != null ) {
                fsPersistence.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            FsPersistenceImpl fsPersistence = this.fsPersistenceRef.get( );
            if ( fsPersistence != null ) {
                return fsPersistence.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            FsPersistenceImpl fsPersistence = this.fsPersistenceRef.get( );
            if ( fsPersistence != null ) {
                fsPersistence.jmxNotificationsEnabled = false;
            }
        }

        public void loadPartitionStart( Session session, PRI pri, StackTraceElement[] elements ) {

            Notification notification = new Notification( FsPersistenceMBean.LOAD_PARTITION_START, this.objectName, this.seqNo.incrementAndGet( ), pri.toString( ) + " (Session: " + session + ")" ); //$NON-NLS-1$//$NON-NLS-2$
            notification.setUserData( elements );
            this.sendNotification( notification );
        }

        public void loadPartitionEnd( Session session, PRI pri, long duration ) {

            Notification notification = new Notification( FsPersistenceMBean.LOAD_PARTITION_END, this.objectName, this.seqNo.incrementAndGet( ), pri.toString( ) + " (Session: " + session + ")" ); //$NON-NLS-1$//$NON-NLS-2$
            notification.setUserData( "Time=" + String.valueOf( duration ) + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
            this.sendNotification( notification );
        }

        public void storePartitionStart( PRI pri, StackTraceElement[] elements ) {

            Notification notification = new Notification( FsPersistenceMBean.STORE_PARTITION_START, this.objectName, this.seqNo.incrementAndGet( ), pri.toString( ) );
            notification.setUserData( elements );
            this.sendNotification( notification );
        }

        public void storePartitionEnd( PRI pri, long elements, long links, long duration ) {

            Notification notification = new Notification( FsPersistenceMBean.STORE_PARTITION_END, this.objectName, this.seqNo.incrementAndGet( ), pri.toString( ) );
            notification.setUserData( "Time=" + String.valueOf( duration ) + "ms,Elements=" + elements + ",Links=" + links ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            this.sendNotification( notification );
        }

        public void loadTextFileStart( Session session, PRI pri, StackTraceElement[] elements ) {

        }

        public void loadTextFileEnd( Session session, PRI pri, int texts, long duration ) {

        }

        public void storeTextFileStart( PRI pri, StackTraceElement[] elements ) {

            Notification notification = new Notification( FsPersistenceMBean.STORE_TEXT_FILE_START, this.objectName, this.seqNo.incrementAndGet( ), pri.toString( ) );
            notification.setUserData( elements );
            this.sendNotification( notification );
        }

        public void storeTextFileEnd( PRI pri, long duration ) {

            Notification notification = new Notification( FsPersistenceMBean.STORE_TEXT_FILE_END, this.objectName, this.seqNo.incrementAndGet( ), pri.toString( ) );
            notification.setUserData( "Time=" + String.valueOf( duration ) + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
            this.sendNotification( notification );
        }
    }
}
