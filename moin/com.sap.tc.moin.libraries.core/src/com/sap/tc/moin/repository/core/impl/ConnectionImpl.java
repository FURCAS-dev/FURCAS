package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerStandardMBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.core.AbstractConnectionAwareWrapper;
import com.sap.tc.moin.repository.core.AttributeValuesWrapper;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreCommandStack;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreOclRegistryService;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.DeepCopyPolicyHandlerWrapper;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkManager;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.IeFactory;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.JmiListWrapper;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.ModelPartitionWrapper;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.PartitionChangeRecorder;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.core.PriReference;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.cps.serializer.CoreSerializerCallbackImpl;
import com.sap.tc.moin.repository.core.cps.serializer.PartitionSerializerImpl;
import com.sap.tc.moin.repository.core.events.PartitionContentChangeEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionCreateEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionDeleteEventImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefBaseObjectWrapperImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.query.moinql.controller.MQLProcessorImpl;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.DeregisterListenerMicroTransactionable;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.RegisterChangeListenerMicroTransactionable;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.RegisterCommitListenerMicroTransactionable;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.RegisterPreChangeListenerMicroTransactionable;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.RegisterPreCommitListenerMicroTransactionable;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.RegisterUpdateListenerMicroTransactionable;
import com.sap.tc.moin.repository.core.xmi.reader.XmiReaderImpl;
import com.sap.tc.moin.repository.core.xmi.writer.XmiWriterImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinIndexOutOfBoundsException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ExtentDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.MetamodelElementDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor;
import com.sap.tc.moin.repository.jmx.ConnectionMBean;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.mql.MQLNotSupportedException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.WeakObjectCache;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.shared.util.HousekeepingThread.ActionOnBeingGarbageCollectedProvider;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiMQLQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.repository.xmi.XmiReader;
import com.sap.tc.moin.repository.xmi.XmiWriter;
import com.sap.tc.moin.xm.adapter.ie.IeFactoryImpl;


/**
 * All interactions (read and write access) with a Modeling Infrastructure based
 * repository happen in the context of a Connection.
 */
public final class ConnectionImpl implements CoreConnection, EventRegistry {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, ConnectionImpl.class );

    private int instanceIndex;

    /**
     * Human readable label, defaults to null
     */
    private String label;

    /**
     * The Session this Connection is assigned to
     */
    SessionImpl session;

    /**
     * id
     */
    private String id;

    /**
     * Caches the value of toString().
     */
    private String toString;

    private XmiWriter xmiWriter;

    private XmiReader xmiReader;

    /** Factory for the model importer/exporter. */
    private final IeFactory ieFactory = new IeFactoryImpl( );

    /**
     * Each connection holds its own instance of an MQL processor
     */
    private MQLProcessor mqlProcessor;

    private CoreCommandStack commandStack;

    private DataArea targetDataArea = null;

    private ConnectionWrapper wrapper;

    /**
     * The name identifying this connection in JMX.
     */
    private ObjectName objectName;

    /**
     * The indicator to show if the Connection is still alive or has been closed
     */
    private enum LiveStatus {
        ALIVE, DYING, DEAD
    }

    private LiveStatus liveStatus;

    /**
     * The set of partitions which were modified by this connection. <br>
     */
    private Set<CoreModelPartition> modifiedPartitions = new LinkedHashSet<CoreModelPartition>( );

    private CoreModelPartition nullPartition;

    private static final int INITIAL_SIZE_OF_JMI_WRAPPER_CACHE = 512;

    private static final int INITIAL_SIZE_OF_JMILIST_WRAPPER_CACHE = 512;

    private static final int INITIAL_SIZE_OF_ATTRIBUTE_VALUES_WRAPPER_CACHE = 128;

    private static final int INITIAL_CAPACITY_OF_PARTITION_WRAPPER_CACHE = 256;

    private boolean saveAllowed = true;

    private volatile boolean memoryChangeOnlyEnabled = false;

    private WrapperManagerImpl wrapperManager;

    // Dim 0: String (data area name, interned),
    // Dim 1: Map<String /* MOF-ID, interned */, WeakReferenceToJmiWrapper>
    protected Object[][] jmiWrapperCache;

    protected Map<Object /* identity of JmiList */, WeakReferenceToJmiListWrapper> jmiListWrapperCache;

    protected Map<LRI /* RefFeatured */, Map<String /*
                                                     * MOF id of attribute
                                                     */, WeakReferenceToAttributeValuesWrapper>> attributeValuesWrapperCache;

    protected WeakObjectCache<PRI, ModelPartition> partitionWrapperCache;

    private Set<CorePartitionable> newElements = new HashSet<CorePartitionable>( );

    private PartitionChangeRecorder changeRecorder;

    private Collection<EventListener> registeredListeners = new ArrayList<EventListener>( );

    private DeepCopyImpl deepCopier;



    /**
     * Creates a new Connection and stores the passed parameters for that
     * Connection
     * 
     * @param session the Session this Connection is assigned to
     */
    ConnectionImpl( SessionImpl session, int instanceIndex, String label ) {

        this.session = session;
        this.liveStatus = LiveStatus.ALIVE;
        this.instanceIndex = instanceIndex;
        this.label = label;
        this.xmiReader = new XmiReaderImpl( this, session.getWorkspace( ) );
        this.xmiWriter = new XmiWriterImpl( session );
        this.wrapperManager = (WrapperManagerImpl) session.getWorkspaceSet( ).getWrapperManager( );
        CompoundDataArea cda = session.getWorkspaceSet( ).getCompoundDataArea( );
        int dataAreas = cda.getDataAreas( ).size( );
        this.jmiWrapperCache = new Object[dataAreas][dataAreas];
        int i = 0;
        for ( DataArea da : cda.getDataAreas( ) ) {
            this.jmiWrapperCache[i++][0] = da.getName( ).intern( );
        }
        this.partitionWrapperCache = new WeakObjectCache<PRI, ModelPartition>( this.getReferenceQueue( ), INITIAL_CAPACITY_OF_PARTITION_WRAPPER_CACHE );
        this.jmiListWrapperCache = new IdentityHashMap<Object, WeakReferenceToJmiListWrapper>( INITIAL_SIZE_OF_JMILIST_WRAPPER_CACHE );
        this.attributeValuesWrapperCache = new HashMap<LRI, Map<String, WeakReferenceToAttributeValuesWrapper>>( INITIAL_SIZE_OF_ATTRIBUTE_VALUES_WRAPPER_CACHE );
        this.wrapper = new ConnectionWrapper( session.getWorkspaceSet( ), this );
        this.changeRecorder = new PartitionChangeRecorderImpl( this );
        if ( JMX_ENABLED ) {
            this.objectName = this.getObjectName( );
            new JmxAdapter( this, this.objectName, Thread.currentThread( ).getStackTrace( ) );
        }
        // Trace successful connection creation
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.traceWithStack( MoinSeverity.DEBUG, "Connection " + this.toString( ) + " was created. For detail information - see below call stack: " ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        this.commandStack = new CommandStackImpl( this );
    }

    ReferenceQueue getReferenceQueue( ) {

        return this.session.getMoin( ).getReferenceQueue( );
    }


    /**
     * @see Connection#revert()
     */
    public void revert( ) {

        // Trace successful connection close
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Connection " + this.toString( ) + " starts to revert." ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        // there must be no command running
        this.ensureNoCommandRunning( );

        // get clientspecific workspace
        Workspace workspace = this.session.getWorkspace( );

        // use a new collection because otherwise a
        // ConcurrentModificationException can occur as the evict partition
        // also changes the dirty partitions collection of this connection.
        Collection<CoreModelPartition> dirtyPartitions = new LinkedHashSet<CoreModelPartition>( this.getDirtyPartitionsWithoutNullPartition( ) );

        // for collecting the events so that they can be fired after the
        // synchronization lock has been released
        Collection<PartitionChangeEvent> changeEvents = new ArrayList<PartitionChangeEvent>( dirtyPartitions.size( ) );

        SynchronizationManager synchronizationManager = this.session.getWorkspaceSet( ).getSynchronizationManager( );

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {

            synchronizationManager.acquireMicroWriteLock( );
            try {

                // Cleanup CommandStack
                this.getCommandStack( ).clear( );

                // evict real partitions which are dirty
                for ( CoreModelPartition partition : dirtyPartitions ) {
                    PRI pri = partition.getPri( );
                    PartitionChangeEvent changeEvent = null;
                    if ( partition.isPersisted( ) ) {
                        if ( partition.isAlive( ) ) {
                            // the partition already exists in the persistence and
                            // as it is alive means that changes have
                            // been
                            // made, therefore content was changed
                            changeEvent = new PartitionContentChangeEventImpl( this, pri );
                        } else {
                            // the partition already exists in the persistence but
                            // as it is not alive means that it was
                            // deleted,
                            // therefore revert is like a new creation of this
                            // partition
                            changeEvent = new PartitionCreateEventImpl( this, pri );
                        }
                    } else {
                        // the partition wasn't in the persistence yet, therefore it
                        // must have been newly created and revert
                        // is
                        // like a deletion
                        changeEvent = new PartitionDeleteEventImpl( this, pri );
                    }

                    changeEvents.add( changeEvent );
                    session.updateWrapperCaches( pri, session.getCompoundClientSpecWorkspace( ) );
                    workspace.getPartitionManager( ).evictPartitionForced( partition );

                    this.getPartitionLockManager( ).releaseLock( pri, this );
                }

                // evict null partition
                if ( this.nullPartition != null ) {
                    workspace.getPartitionManager( ).evictPartitionForced( this.nullPartition );
                    this.nullPartition = null;
                }

                // clear the new elements: after revert there can't be any new
                // elements
                this.newElements.clear( );

                this.changeRecorder.clear( );

                saveAllowed = true;
            } finally {
                synchronizationManager.releaseMicroWriteLock( );
            }
        }

        // now the events can be fired as the synchronization write lock is
        // released and so even "half-synchronous"
        // listeners can work without deadlock
        this.getSession( ).getEventManager( ).beginUpdate( this );
        for ( PartitionChangeEvent event : changeEvents ) {
            this.getSession( ).getEventManager( ).fireChangeEvent( event );
        }
        this.getSession( ).getEventManager( ).deliverUpdate( this );

        // Trace successful revert
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.traceWithStack( MoinSeverity.DEBUG, "Connection " + this.toString( ) + " was reverted. For detail information - see below call stack (created for debugging purposes): ", (Object[]) null ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    public boolean isMemoryChangeOnlyEnabled( ) {

        return this.memoryChangeOnlyEnabled;
    }

    public void enableMemoryChangeOnly( ) {

        this.memoryChangeOnlyEnabled = true;
    }

    /**
     * @see Connection#save()
     */
    public void save( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        if ( memoryChangeOnlyEnabled ) {
            throw new MoinIllegalStateException( CoreImplMessages.SAVENOTALLOWEDINMEMORYCHANGEONLYCONNECTION );
        }

        if ( !saveAllowed ) {
            // since the save() can be called by anyone, this is a no-operation instead of an Exception
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.traceWithStack( MoinSeverity.DEBUG, "Method save() was called on externally loaded partition Connection " + this.toString( ) + "and will be ignored. For detail information - see below call stack (created for debugging purposes): " ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            return;
        }

        this.session.getWorkspace( ).getPartitionManager( ).savePartitionsOfConnection( this );

        // Trace successful connection saving
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.traceWithStack( MoinSeverity.DEBUG, "Connection " + this.toString( ) + " was saved. For detail information - see below call stack (created for debugging purposes): " ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * Implementation of {@link CoreConnection#getPartitionLockManager()}.
     * 
     * @see {@link SessionImpl#getPartitionLockManager()}
     */
    public PartitionLockManager getPartitionLockManager( ) {

        return this.session.getPartitionLockManager( );
    }

    /**
     * Returns <code>true</code> if the <code>Connection</code> is still alive.
     * 
     * @return <code>true</code> if the <code>Connection</code> is still alive
     * or <code>false</code> if the <code>Connection</code> has been closed
     * already.
     */
    public boolean isAlive( ) {

        return this.liveStatus == LiveStatus.ALIVE;
    }

    /**
     * Closes this <code>Connection</code> and releases resources.
     * <p>
     * Calling the method <code>close</code> on a <code>Connection</code> object
     * that is already closed is a no-op like with JDBC.
     */
    public void closeInternal( ) {

        if ( this.isAlive( ) ) {
            // Trace beginning of closing
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, "Connection " + this.toString( ) + " is starting to close." ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            this.ensureNoCommandRunning( );

            this.deregisterAllListeners( );
            this.revertIfConnectionHasUnsavedChanges( );
            this.releaseAllLocks( );

            // -- reset alive indicator that connection cannot be used any more
            this.liveStatus = LiveStatus.DYING;

            //this.wrapper.nullify( );
            this.newElements = null;
            this.modifiedPartitions = null;
            this.nullPartition = null;
            this.wrapperManager = null;
            this.jmiWrapperCache = null;
            this.jmiListWrapperCache = null;
            this.attributeValuesWrapperCache = null;
            this.partitionWrapperCache = null;
            this.changeRecorder = null;
            this.registeredListeners = null;
            this.toString = null;
            this.xmiWriter = null;
            this.xmiReader = null;
            this.targetDataArea = null;


            if ( this.session != null ) {
                this.session.removeConnection( this );
                this.session = null;
            }
            this.liveStatus = LiveStatus.DEAD;
            // Reset "toString", so that new LiveStatus can be reflected 
            this.toString = null;

            if ( JMX_ENABLED ) {
                SpiJmxHelper.unregisterMBean( this.objectName );
                this.objectName = null;
                if ( this.mqlProcessor != null ) {
                    SpiJmxHelper.unregisterMBean( ( (MQLProcessorImpl) this.mqlProcessor ).getObjectName( ) );
                }
                if ( this.commandStack != null ) {
                    SpiJmxHelper.unregisterMBean( ( (CommandStackImpl) this.commandStack ).getObjectName( ) );
                }
            }
            this.mqlProcessor = null;
            this.commandStack = null;

            // Trace successful connection close
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.traceWithStack( MoinSeverity.DEBUG, "Connection " + this.toString( ) + " was closed. For detail information - see below call stack (created for debugging purposes): ", (Object[]) null ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }

    public void close( ) {

        this.wrapper.close( );
    }

    public void shutdown( ) {

        this.close( );
    }

    private void deregisterAllListeners( ) {

        for ( EventListener listener : this.registeredListeners ) {
            this.session.getEventRegistry( ).deregister( listener );
        }
        this.registeredListeners.clear( );
    }

    /**
     * Releases all the locks this connection is still holding.
     */
    private void releaseAllLocks( ) {

        PartitionLockManager partitionLockManager = this.getPartitionLockManager( );
        if ( partitionLockManager != null ) {
            try {
                partitionLockManager.releaseAllLocks( this );
            } catch ( LockingException e ) {
                logger.trace( e, MoinSeverity.ERROR, "Releasing of all locks for connection {0} failed", new Object[] { this.toString( ) } ); //$NON-NLS-1$
            }
        } else {
            logger.trace( MoinSeverity.ERROR, "Couldn't release all locks for connection {0} as the partition lock manager was null", this.toString( ) ); //$NON-NLS-1$
        }
    }

    /**
     * If a connection has unsaved changes, those changes are reverted.
     */
    private void revertIfConnectionHasUnsavedChanges( ) {

        if ( this.hasUnsavedChanges( ) ) {
            this.revert( );
        }
    }

    public CoreSession getSession( ) {

        return this.session;
    }

    /**
     * Searches for MOF packages with the specified qualified name and returns
     * the according default package extents for it. Only those MOF packages are
     * considered, which are hosted in either of the specified model containers.
     * The model containers are specified by their names.<br>
     * The modelContainerNames String array either null or empty means that no
     * model container restriction is applied.
     * 
     * @param qualifiedName The qualified name of the to be searched MOF package
     * @param modelContainerNames The names of the model containers, in one of
     * which the MOF packages are searched
     * @return The found default package extents or an empty array, if nothing
     * has been found
     */
    public RefPackage getPackage( String modelContainerName, String... qualifiedName ) {

        return this.session.getPackage( modelContainerName, qualifiedName );
    }

    private Extent getExtent( ExtentDescriptor extentDescriptor ) {

        WorkspaceSet workspaceSet = getSession( ).getWorkspaceSet( );
        return workspaceSet.getMoin( ).getExtent( extentDescriptor );
    }

    public RefPackage getPackage( PackageDescriptor packageDescriptor ) {

        return (RefPackage) getExtent( packageDescriptor );
    }

    public RefClass getClass( ClassDescriptor classDescriptor ) {

        return (RefClass) getExtent( classDescriptor );
    }

    public RefAssociation getAssociation( AssociationDescriptor associationDescriptor ) {

        return (RefAssociation) getExtent( associationDescriptor );
    }

    public <T extends RefBaseObject> T getMetamodelElement( MetamodelElementDescriptor<T> metamodelElementDescriptor ) {

        return (T) this.session.getMoin( ).getMetamodelWorkspace( ).getMetamodelElement( metamodelElementDescriptor.getMofId( ) );
    }

    /**
     * Returns the RefPackages of all top level packages
     * 
     * @return the RefPackages of all top level packages
     */
    public RefPackage[] getTopLevelPackages( ) {

        return this.session.getWorkspaceSet( ).getMoin( ).getExtentManager( ).getTopLevelPackageExtents( );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.core.impl.Connection#getModelElement(com.sap
     * .tc.moin.repository.core.impl.MRI)
     */
    public RefBaseObject getElement( MRI mri ) {

        return (RefBaseObject) this.session.getElement( mri );
    }

    /**
     * Resolve a {@link Partitionable} based on its LRI by delegating to the
     * responsible {@link WorkspaceSet}
     * 
     * @param elementLri LRI of the element to be resolved
     * @return resolved element
     */
    public RefBaseObject getElement( LRI lri ) {

        return (RefBaseObject) this.session.getElement( lri );
    }

    public boolean elementExists( LRI lri ) {

        if ( lri == null ) {
            return false;
        }
        return ( session.getWorkspaceSet( ).lriExists( this.session, lri ) );
    }

    public boolean elementExists( MRI mri ) {

        if ( mri == null ) {
            return false;
        }
        return ( session.getWorkspaceSet( ).mriExists( this.session, mri ) );
    }

    @SuppressWarnings( "unchecked" )
    public <T extends RefObject> T createElementInPartition( ClassDescriptor<? extends RefClass, T> classDescriptor, ModelPartition partition ) {

        RefClassImpl rc = (RefClassImpl) getClass( classDescriptor );
        return (T) rc.refCreateInstanceInPartition( this, null, partition );
    }

    @SuppressWarnings( "unchecked" )
    public <T extends RefObject> T createElementInPartition( Class<T> clazz, ModelPartition partition ) {

        Field fld = null;
        ClassDescriptor classDescriptor = null;
        try {
            fld = clazz.getField( "CLASS_DESCRIPTOR" ); //$NON-NLS-1$
            classDescriptor = (ClassDescriptor) fld.get( null );
        } catch ( Exception e ) {
            return null;
        }

        RefClassImpl rc = (RefClassImpl) getClass( classDescriptor );
        return (T) rc.refCreateInstanceInPartition( this, null, partition );
    }

    public <T extends RefObject> T createElement( ClassDescriptor<? extends RefClass, T> classDescriptor ) {

        return createElementInPartition( classDescriptor, null );
    }

    public <T extends RefObject> T createElement( Class<T> clazz ) {

        return createElementInPartition( clazz, null );
    }

    public XmiReader getXmiReader( ) {

        return this.xmiReader;
    }

    public XmiWriter getXmiWriter( ) {

        return this.xmiWriter;
    }

    public ModelImporter createModelImporter( XmParserConfiguration configuration ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.UNWRAPPEDMODELIMPORTERNOTSUPPORTED );
    }


    public ModelExporter createModelExporter( XmSerializerConfiguration configuration ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.UNWRAPPEDMODELEXPORTERNOTSUPPORTED );
    }

    /**
     * @see Connection#createPartition(PRI)
     */
    public ModelPartition createPartition( PRI pri ) throws PartitionCreatingNotPossibleException, InvalidResourceIdentifierException {

        if ( pri.isVolatilePartition( ) || pri.isMetaModelPartition( ) ) {
            throw new PartitionCreatingNotPossibleException( RepositoryCoreMessages.PARTITIONISTRANSIENT, pri );
        }

        return this.session.getWorkspace( ).getPartitionFactory( ).createModelPartition( this, pri );
    }

    /**
     * @see Connection#getPartition(PRI)
     */
    public CoreModelPartition getPartition( PRI pri ) {

        return this.session.getWorkspaceSet( ).resolvePri( this.session, pri );
    }

    public boolean partitionExists( PRI pri ) {

        if ( pri == null ) {
            return false;
        }
        return ( session.getWorkspaceSet( ).priExists( this.session, pri ) );
    }

    /**
     * @see CoreConnection#getNullPartition()
     */
    public CoreModelPartition getNullPartition( ) {

        return this.getNullPartitionInternal( );
    }

    private CoreModelPartition getNullPartitionInternal( ) {

        if ( this.nullPartition == null /* not requested yet */) {
            this.nullPartition = this.session.getWorkspace( ).getPartitionManager( ).getNullPartition( this );
        }
        return this.nullPartition;
    }

    /**
     * @see CoreConnection#modifiedPartition(CoreModelPartition)
     */
    public void modifiedPartition( CoreModelPartition partition ) {

        this.getDirtyPartitionsWithoutNullPartition( ).add( partition );
    }

    /**
     * @param partition
     */
    public void removeFromModifiedPartitions( CoreModelPartition partition ) {

        this.getDirtyPartitionsWithoutNullPartition( ).remove( partition );
    }

    private void ensureNoCommandRunning( ) {

        // there must be no command running
        if ( this.getCommandStack( ).getState( ).isRunning( ) ) {
            throw new IllegalStateException( "Illegal call to Connection while Command is running." ); //$NON-NLS-1$
        }
    }

    public boolean hasReferencedTransientElements( ) {

        return null != this.getReferencedTransientElements( true );
    }

    public boolean hasCrossPartitionLinks( PRI priOne, PRI... otherPris ) {

        return session.hasCrossPartitionLinks( priOne, otherPris );
    }

    public Collection<MRI> getReferencedTransientElements( ) {

        return this.getReferencedTransientElements( false );
    }

    @SuppressWarnings( "null" )
    private Collection<MRI> getReferencedTransientElements( boolean abortOnFirstOccurence ) {

        Collection<MRI> referencedElements;
        if ( abortOnFirstOccurence ) {
            referencedElements = null;
        } else {
            referencedElements = new ArrayList<MRI>( );
        }

        if ( !this.modifiedPartitions.isEmpty( ) ) {
            Collection<CoreModelPartition> transientPartitions = this.session.getWorkspace( ).getPartitionManager( ).getTransientPartitions( this );
            if ( !transientPartitions.isEmpty( ) ) {
                Collection<LRI> otherEndLris = new HashSet<LRI>( );
                for ( CoreModelPartition partition : this.modifiedPartitions ) {
                    SpiPartitionDelta partitionDelta = this.changeRecorder.getDeltaForPartition( partition );
                    Collection<SpiLink> addedLinks = partitionDelta.getAddedLinks( );
                    for ( SpiLink link : addedLinks ) {
                        otherEndLris.add( link.getOtherEndLri( ) );
                    }
                }

                if ( !otherEndLris.isEmpty( ) ) {
                    for ( CoreModelPartition partition : transientPartitions ) {
                        Collection<Partitionable> elements = partition.getElements( );
                        for ( Partitionable element : elements ) {
                            if ( otherEndLris.contains( element.get___Mri( ).getLri( ) ) ) {
                                if ( abortOnFirstOccurence ) {
                                    return Collections.emptyList( ); // only to indicate that there is an element, which one doesn't matter
                                }
                                referencedElements.add( element.get___Mri( ) );
                            }
                        }
                    }
                }
            }
        }

        return referencedElements;
    }

    /**
     * Tells if there are unsaved changes for this connection which means
     * partitions were made dirty by this connection which haven't been saved
     * yet.
     * 
     * @return <code>true</code> if there are unsaved changes for this
     * connection, <code>false</code> otherwise
     */
    private boolean hasUnsavedChanges( ) {

        return !this.getDirtyPartitionsWithoutNullPartition( ).isEmpty( );
    }

    public Collection<CoreModelPartition> getDirtyPartitionsWithoutNullPartition( ) {

        return this.modifiedPartitions;
    }

    /**
     * Returns the {MQLProcessor} instance
     * 
     * @see com.sap.tc.moin.repository.core.impl.Connection#getMQLProcessor() of
     * this connection
     */
    public MQLProcessor getMQLProcessor( ) {

        // pro connection, we maintain one MQL processor
        if ( this.mqlProcessor == null ) {
            this.mqlProcessor = this.createMqlProcessor( );
            if ( this.mqlProcessor == null ) {
                throw new MQLNotSupportedException( RepositoryCoreMessages.MQL_NOT_AVAILABLE );
            }
        }
        return this.mqlProcessor;
    }

    private MQLProcessor createMqlProcessor( ) {

        // obtain all facilities via MOIN
        Collection<Facility> facilities = this.getSession( ).getMoin( ).getFacilities( );

        // obtain all facility IDs for the relevant data areas of this session
        Set<DataAreaDescriptor> sessionRelevantDataAreas = new HashSet<DataAreaDescriptor>( );
        Set<Facility> sessionRelevantFacilities = new HashSet<Facility>( );
        for ( DataArea dataArea : this.getSession( ).getCompoundClientSpec( ).getCompoundDataArea( ).getDataAreas( ) ) {
            sessionRelevantDataAreas.add( dataArea.getDescriptor( ) );
            sessionRelevantFacilities.add( dataArea.getFacility( ) );
        }
        Collection<SpiMQLQueryService> queryServices = new ArrayList<SpiMQLQueryService>( facilities.size( ) );

        // obtain all relevant FQLs
        for ( Facility facility : facilities ) {
            if ( sessionRelevantFacilities.contains( facility ) ) {
                SpiMQLQueryService queryService = ( (SpiFacility) facility ).getMQLQueryService( );

                if ( queryService != null ) {
                    queryServices.add( queryService );
                } else {
                    throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.FACILITYWITHOUTMQLQUERYSERVICE );
                }
            }
        }

        return new MQLProcessorImpl( this, queryServices, sessionRelevantDataAreas );
    }

    /**
     * Returns the connection's {CommandStack} instance
     * 
     * @see com.sap.tc.moin.repository.core.impl.Connection#getCommandStack()
     */
    public CoreCommandStack getCommandStack( ) {

        return this.commandStack;
    }

    @Override
    public String toString( ) {

        if ( this.toString == null ) {
            this.toString = ( this.getLabel( ) != null ? this.getLabel( ) + ", " : "" ) + this.getId( ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( liveStatus == LiveStatus.DEAD ) {
                toString += " - " + LiveStatus.DEAD; //$NON-NLS-1$
            }
        }
        return this.toString;
    }

    public DataArea getTargetDataArea( ) {

        if ( this.targetDataArea == null ) {
            // set default target DataArea to first non-metamodel data area
            Collection<DataArea> dataAreas = this.session.getWorkspaceSet( ).getCompoundDataArea( ).getDataAreas( );
            for ( DataArea area : dataAreas ) {
                if ( !area.getDescriptor( ).isMetamodelDataArea( ) ) {
                    this.targetDataArea = area;
                }
            }
        }
        return this.targetDataArea;
    }

    public JmiHelper getJmiHelper( ) {

        //this method is not to be called internally, only at the "Connection" API. 
        //Within the Core we have to use getCoreJmiHelper() as we have to provide connection/session context 
        //to each method (that's what the wrappers do automatically for API calls).
        throw new MoinUnsupportedOperationException( CoreImplMessages.THISMETHODSHOULDNOTBECALLEDINTERNALLY__CORECONNECTION_GETCOREJMIHELPER );
    }

    public SpiJmiHelper getCoreJmiHelper( ) {

        return this.session.getWorkspaceSet( ).getMoin( ).getJmiHelper( );
    }

    public DeepCopyResultSet deepCopy( Collection<RefObject> elementsToBeCopied, DeepCopyPolicyHandler policyHandler, boolean includeExternalCompositeParents ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.NOTSUPPORTEDINCORE );
    }

    public DeepCopyResultSet deepCopy( Map<MRI, CoreConnection> elementsToBeCopied, DeepCopyPolicyHandlerWrapper policyHandler, boolean includeExternalCompositeParents ) {

        if ( this.deepCopier == null ) {
            this.deepCopier = new DeepCopyImpl( this );
        }
        return this.deepCopier.deepCopy( elementsToBeCopied, policyHandler, includeExternalCompositeParents );
    }

    public OclRegistryService getOclRegistryService( ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.NOLONGERSUPPORTED );
    }

    public CoreOclRegistryService getCoreOclRegistryService( ) {

        return getSession( ).getCoreOclRegistryService( );
    }

    public ConsistencyViolationListenerRegistry getConsistencyViolationListenerRegistry( ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.METHODNOTAVAILABLE );
    }

    public ConsistencyViolationRegistry getConsistencyViolationRegistry( ) {

        return this.session.getConsistencyViolationRegistry( );
    }

    private boolean isConsistent( RefBaseObject refBaseObject ) {

        // check if there are duplicates at all
        if ( this.getConsistencyViolationRegistry( ).duplicatesExisting( false ) ) {
            // check if consistency violation affects refBaseObject
            if ( this.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( ( (Partitionable) refBaseObject ).get___Mri( ) ) != null ) {
                return false;
            }
        }
        return true;
    }

    public ConnectionWrapper getWrapper( ) {

        return this.wrapper;
    }

    public ModelPartition getWrapperForModelPartition( ModelPartition partition ) {

        if ( partition == null ) {
            // null is not wrapped
            return null;
        }

        ModelPartition result = null;
        CoreModelPartition cmp = (CoreModelPartition) partition;
        boolean wrapperForSharedPartitionRequested = ( cmp.getWorkspace( ) instanceof CompoundClientSpecWorkspace );
        PRI pri = partition.getPri( );

        synchronized ( session.getWrapperCacheLock( ) ) {
            boolean privateCopyExists = session.getWorkspace( ).getPartitionManager( ).isPartitionLoaded( pri );
            if ( ( privateCopyExists && wrapperForSharedPartitionRequested ) || ( !privateCopyExists && !wrapperForSharedPartitionRequested ) ) {
                cmp = getPartition( pri );
            }
            if ( this.partitionWrapperCache != null ) { // otherwise, the connection has already been closed
                result = this.partitionWrapperCache.get( pri );
                if ( result == null ) {
                    this.partitionWrapperCache.put( pri, result = this.wrapperManager.getWrapperForModelPartition( this, cmp ) );
                }
            }
        }
        return result;
    }

    @SuppressWarnings( { "unchecked", "null" } )
    public <T extends RefBaseObject> T getWrapperForJmiObject( T refBaseObject ) {

        if ( refBaseObject == null ) {
            // null is not wrapped
            return null;
        }

        T result = null;
        T rbo = refBaseObject;

        CorePartitionable partitionable = (CorePartitionable) rbo;
        boolean wrapperForSharedRefBaseObjectRequested = ( partitionable.get___Workspace( ) instanceof CompoundClientSpecWorkspace );

        synchronized ( session.getWrapperCacheLock( ) ) {
            boolean privateCopyExists = session.getWorkspace( ).getPartitionManager( ).isPartitionLoaded( partitionable.get___Partition( ).getPri( ) );
            if ( ( privateCopyExists && wrapperForSharedRefBaseObjectRequested ) || ( !privateCopyExists && !wrapperForSharedRefBaseObjectRequested ) ) {
                rbo = (T) getElement( partitionable.get___Mri( ) );
                if ( rbo == null ) {
                    // If a wrapper for a shared RefBaseObject was requested, but in the meantime the model element has been
                    // deleted (i.e. a private copy exists but does not contain the model element any more), 'null' will be 
                    // returned by the getElement() call above. In this case, returning 'null' is the correct answer.
                    return null;
                }
            }
            Map<String, WeakReferenceToJmiWrapper> wrappersInDataArea = null;
            String dataAreaName = ( (Partitionable) rbo ).get___Mri( ).getDataAreaDescriptor( ).getDataAreaName( );
            for ( int i = 0; i < this.jmiWrapperCache.length; i++ ) {
                if ( this.jmiWrapperCache[i][0] == dataAreaName ) { // interned Strings!
                    wrappersInDataArea = (Map<String, WeakReferenceToJmiWrapper>) this.jmiWrapperCache[i][1];
                    if ( wrappersInDataArea == null ) {
                        this.jmiWrapperCache[i][1] = wrappersInDataArea = new IdentityHashMap<String, WeakReferenceToJmiWrapper>( INITIAL_SIZE_OF_JMI_WRAPPER_CACHE );
                    }
                    break;
                }
            }
            String mofId = rbo.refMofId( );
            WeakReferenceToJmiWrapper ref = wrappersInDataArea.get( mofId );
            boolean createNewWrapper = true;
            if ( ref != null ) {
                result = (T) ref.get( );
                if ( result != null && ( (Partitionable) result ).get___Mri( ).equals( ( (Partitionable) rbo ).get___Mri( ) ) ) {
                    createNewWrapper = false;
                }
            }
            if ( createNewWrapper ) {
                result = this.wrapperManager.getWrapperForJmiObject( this, rbo );
                wrappersInDataArea.put( mofId, new WeakReferenceToJmiWrapper( result, dataAreaName, mofId ) );
            } else if ( !this.isConsistent( rbo ) ) {
                // create wrapper but do not cache it
                result = this.wrapperManager.getWrapperForJmiObject( this, rbo );
            }
        }
        return result;
    }

    @SuppressWarnings( "unchecked" )
    public AbstractConnectionAwareWrapper getWrapperForJmiList( JmiList jl ) {

        if ( jl == null ) {
            // null is not wrapped
            return null;
        }

        AbstractConnectionAwareWrapper result = null;
        boolean wrapperForSharedJmiListRequested = ( jl.getWorkspace( ) instanceof CompoundClientSpecWorkspace );
        JmiList jmiList = jl;

        synchronized ( session.getWrapperCacheLock( ) ) {
            if ( !jmiList.isDistributed( ) ) {
                boolean privateCopyExists = session.getWorkspace( ).getPartitionManager( ).isPartitionLoaded( jmiList.getFromEnd( ).getPri( ) );
                if ( ( privateCopyExists && wrapperForSharedJmiListRequested ) || ( !privateCopyExists && !wrapperForSharedJmiListRequested ) ) {
                    CorePartitionable elementAtEnd = (CorePartitionable) getElement( jmiList.getFromEnd( ) );
                    EndStorageLinkManager linkManager = elementAtEnd.get___Workspace( ).getMemoryLinkManager( );
                    jmiList = linkManager.getElementsForEndAndMetaobject( this, jmiList.getEndAndMetaObject( ), elementAtEnd );
                }
            }
            Object identity = jmiList.getIdentity( );
            WeakReferenceToJmiListWrapper ref = this.jmiListWrapperCache.get( identity );
            if ( ref == null || ( result = ref.get( ) ) == null ) {
                result = this.wrapperManager.getWrapperForJmiList( this, jmiList );
                this.jmiListWrapperCache.put( identity, new WeakReferenceToJmiListWrapper( result, identity ) );
            }
        }
        return result;
    }

    public AttributeValuesWrapper getWrapperForMultiValuedAttributesList( MultiValuedAttributesList list ) {

        if ( list == null ) {
            // null is not wrapped
            return null;
        }
        AttributeValuesWrapper result = null;
        synchronized ( session.getWrapperCacheLock( ) ) {
            LRI lriOfRefFeatured = list.getRefFeatured( ).get___Mri( ).getLri( );
            String attributeMofId = list.getAttributeMofId( );
            Map<String, WeakReferenceToAttributeValuesWrapper> map = this.attributeValuesWrapperCache.get( lriOfRefFeatured );
            if ( map == null ) {
                this.attributeValuesWrapperCache.put( lriOfRefFeatured, map = new IdentityHashMap<String, WeakReferenceToAttributeValuesWrapper>( ) );
            }
            WeakReferenceToAttributeValuesWrapper ref = map.get( attributeMofId );
            if ( ref == null || ( result = ref.get( ) ) == null ) {
                CorePartitionable featuredElement = (CorePartitionable) list.getRefFeatured( );
                Workspace workspaceOfFeatured = featuredElement.get___Workspace( );
                MriReference featured = session.getWorkspaceSet( ).getReferenceManager( ).getMriReference( featuredElement, workspaceOfFeatured );
                result = new AttributeValuesWrapper( this, this.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ), featured, list.getAttributeMofId( ) );
                map.put( attributeMofId, new WeakReferenceToAttributeValuesWrapper( result, lriOfRefFeatured, attributeMofId ) );
            }
        }
        return result;
    }

    public final ObjectName getObjectName( ) {

        try {
            return new ObjectName( MOIN_DOMAIN + "type=Connection,moin=" + session.getMoin( ).getId( ) + ",session=" + this.session.toString( ) + ",id=" + new DecimalFormat( "000" ).format( this.instanceIndex ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
    }

    public boolean isNewElement( CorePartitionable element ) {

        synchronized ( this.newElements ) {
            return this.newElements.contains( element );
        }
    }

    public Collection<CorePartitionable> getNewElements( ) {

        synchronized ( this.newElements ) {
            return Collections.unmodifiableCollection( this.newElements );
        }
    }

    public void addNewElement( CorePartitionable element ) {

        synchronized ( this.newElements ) {
            this.newElements.add( element );
        }
    }

    public void removeNewElement( CorePartitionable element ) {

        synchronized ( this.newElements ) {
            this.newElements.remove( element );
        }
    }

    // only to be called by PartitionManager
    public void clearNewElements( ) {

        this.newElements.clear( );
    }

    public PartitionChangeRecorder getPartitionChangeRecorder( ) {

        return this.changeRecorder;
    }

    public boolean isDirty( ) {

        return !this.modifiedPartitions.isEmpty( ) || !this.getNullPartitionInternal( ).isEmpty( );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#deregister(com.sap.tc
     * .moin.repository.events.EventListener)
     */
    public void deregister( EventListener listener ) {

        synchronized ( session.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            session.getTransactionManager( ).runInMicroTransaction( new DeregisterListenerMicroTransactionable( this, listener ) );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerCommitListener
     * (com.sap.tc.moin.repository.events.CommitListener,
     * com.sap.tc.moin.repository.events.filter.EventFilter)
     */
    public void registerCommitListener( CommitListener listener, EventFilter eventFilterTree ) {

        synchronized ( session.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            session.getTransactionManager( ).runInMicroTransaction( new RegisterCommitListenerMicroTransactionable( this, listener, eventFilterTree ) );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerListener(com.
     * sap.tc.moin.repository.events.ChangeListener,
     * com.sap.tc.moin.repository.events.filter.EventFilter)
     */
    public void registerListener( ChangeListener listener, EventFilter eventFilterTree ) {

        synchronized ( session.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            session.getTransactionManager( ).runInMicroTransaction( new RegisterChangeListenerMicroTransactionable( this, listener, eventFilterTree ) );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerPreChangeListener
     * (com.sap.tc.moin.repository.events.PreChangeListener,
     * com.sap.tc.moin.repository.events.filter.EventFilter)
     */
    public void registerPreChangeListener( PreChangeListener listener, EventFilter eventFilterTree ) {

        synchronized ( session.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            session.getTransactionManager( ).runInMicroTransaction( new RegisterPreChangeListenerMicroTransactionable( this, listener, eventFilterTree ) );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerPreCommitListener
     * (com.sap.tc.moin.repository.events.PreCommitListener,
     * com.sap.tc.moin.repository.events.filter.EventFilter)
     */
    public void registerPreCommitListener( PreCommitListener listener, EventFilter eventFilterTree ) {

        synchronized ( session.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            session.getTransactionManager( ).runInMicroTransaction( new RegisterPreCommitListenerMicroTransactionable( this, listener, eventFilterTree ) );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerPreCommitListener
     * (com.sap.tc.moin.repository.events.PreCommitListener,
     * com.sap.tc.moin.repository.events.filter.EventFilter)
     */
    public void registerUpdateListener( UpdateListener listener, EventFilter eventFilterTree ) {

        synchronized ( session.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            session.getTransactionManager( ).runInMicroTransaction( new RegisterUpdateListenerMicroTransactionable( this, listener, eventFilterTree ) );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.Connection#getEventRegistry()
     */
    public EventRegistry getEventRegistry( ) {

        return this;
    }

    public boolean isLegalNameForTransientPartition( String partitionName ) {

        return this.session.getWorkspace( ).getPartitionManager( ).isLegalPartitionNameForTransientPartition( partitionName );
    }

    public CoreModelPartition getOrCreateTransientPartition( String partitionName ) {

        return this.session.getWorkspace( ).getPartitionManager( ).getOrCreateTransientPartition( partitionName, this );
    }

    public CoreModelPartition getOrCreateTransientPartitionNonTransactional( String partitionName ) {

        return this.session.getWorkspace( ).getPartitionManager( ).getOrCreateTransientPartitionNonTransactional( partitionName, this );
    }

    public Collection<ModelPartition> getPartitionsToBeSaved( ) {

        Collection result = Utilities.getSnapshotOfCollectionAsSet( this.modifiedPartitions );
        return result;
    }

    public Collection<ModelPartition> getTransientPartitions( ) {

        Set result = Utilities.getSnapshotOfCollectionAsSet( this.session.getWorkspace( ).getPartitionManager( ).getTransientPartitions( this ) );
        if ( !result.isEmpty( ) ) {
            result.add( this.getNullPartitionInternal( ) );
        } else {
            result = Collections.singleton( this.getNullPartitionInternal( ) );
        }
        return result;
    }

    public Collection<CoreModelPartition> getTransientPartitionsInternal( ) {

        return this.session.getWorkspace( ).getPartitionManager( ).getTransientPartitions( this );
    }

    public String getLabel( ) {

        return this.label;
    }

    public void setLabel( String label ) {

        this.label = label;
        this.toString = null;
    }

    public String getId( ) {

        if ( this.id == null ) {
            this.id = ( this.session != null ? this.session.toString( ) : "unknown" ) + "-" + new DecimalFormat( "000" ).format( this.instanceIndex ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        return this.id;
    }

    private static final class JmxAdapter implements ConnectionMBean {

        private static final CompositeType compositeTypeForModelElementAttributeValues;

        private static final TabularType tabularTypeForModelElementAttributeValues;

        private static final CompositeType compositeTypeForModelElement;

        static {
            try {
                compositeTypeForModelElementAttributeValues = new CompositeType( "AttributeInfo", "AttributeInfo", new String[] { "1: Name", "2: Value" }, new String[] { "1: Name", "2: Value" }, new OpenType[] { SimpleType.STRING, SimpleType.STRING } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                tabularTypeForModelElementAttributeValues = new TabularType( "PrimitiveAttributeValues", "Attribute values (only primitive ones)", compositeTypeForModelElementAttributeValues, new String[] { "1: Name" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                compositeTypeForModelElement = new CompositeType( "ModelElementInfo", "ModelElementInfo", new String[] { "1: MOF-ID", "2: Type (MRI)", "3: Type (qual. name)", "4: MRI", "5: Attributes" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
                                                                  new String[] { "1: MOF-ID", "2: Type (MRI)", "3: Type (qual. name)", "4: MRI", "5: Attributes" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                                                                  new OpenType[] { SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, tabularTypeForModelElementAttributeValues } );
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e ); // not expected to occur
            }
        }

        private final SynchronizationManager synchronizationManager;

        private final WeakReferenceWithObjectName<ConnectionImpl> connectionRef;

        private final StackTraceElement[] allocationStackTrace;

        JmxAdapter( ConnectionImpl connection, ObjectName objectName, StackTraceElement[] stackTrace ) {

            this.allocationStackTrace = stackTrace;
            this.synchronizationManager = connection.getSession( ).getWorkspace( ).getWorkspaceSet( ).getSynchronizationManager( );
            this.connectionRef = new WeakReferenceWithObjectName<ConnectionImpl>( connection, objectName, connection.getReferenceQueue( ) );
            registerStandardMBean( this, ConnectionMBean.class, objectName );
        }

        public boolean isAlive( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                return connection.isAlive( );
            }
            return false;
        }

        public String[] getDirtyPartitions( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        List<String> result = new ArrayList<String>( connection.getPartitionsToBeSaved( ).size( ) + 1 );
                        for ( ModelPartition partition : connection.getPartitionsToBeSaved( ) ) {
                            result.add( partition.getPri( ).toString( ) );
                        }
                        if ( !connection.getNullPartition( ).isEmpty( ) ) {
                            result.add( connection.getNullPartition( ).getPri( ).toString( ) );
                        }
                        return result.toArray( new String[result.size( )] );
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return new String[] { SpiJmxHelper.getExceptionAsString( e ) };
                }
            }
            return null;
        }

        public String[] getTransientPartitions( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        Collection<CoreModelPartition> transientPartitions = connection.getTransientPartitionsInternal( );
                        List<String> result = new ArrayList<String>( transientPartitions.size( ) + 1 );
                        for ( ModelPartition partition : transientPartitions ) {
                            result.add( partition.getPri( ).toString( ) );
                        }
                        result.add( connection.getNullPartition( ).getPri( ).toString( ) );
                        return result.toArray( new String[result.size( )] );
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return new String[] { SpiJmxHelper.getExceptionAsString( e ) };
                }
            }
            return null;
        }

        public int getNumberOfElementsInNullPartition( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                this.synchronizationManager.acquireReadLock( );
                try {
                    CoreModelPartition nullPartition = connection.getNullPartition( );
                    return nullPartition.getElements( ).size( );
                } finally {
                    this.synchronizationManager.releaseReadLock( );
                }
            }
            return 0;
        }

        public StackTraceElement[] getAllocationStackTrace( ) throws IOException {

            return this.allocationStackTrace;
        }

        public String[] getElementsInPartition( String priString ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        PRI pri = connection.getSession( ).getMoin( ).createPri( priString );
                        CoreModelPartition partition = connection.getPartition( pri );
                        Collection<Partitionable> elements = partition.getElements( );
                        List<String> result = new ArrayList<String>( elements.size( ) );
                        for ( Partitionable element : elements ) {
                            result.add( element.get___Mri( ).toString( ) );
                        }
                        return result.toArray( new String[result.size( )] );
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return new String[] { SpiJmxHelper.getExceptionAsString( e ) };
                }
            }
            return null;
        }

        public String[] getRootElementsInPartition( String priString ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        PRI pri = connection.getSession( ).getMoin( ).createPri( priString );
                        CoreModelPartition partition = connection.getPartition( pri );
                        Collection<Partitionable> elements = partition.getElements( );
                        List<String> result = new ArrayList<String>( elements.size( ) );
                        for ( Partitionable element : elements ) {
                            Partitionable compositeParent = ( (RefObjectImpl) element ).refImmediateComposite( connection.getSession( ) );
                            if ( compositeParent == null || ( !compositeParent.get___Partition( ).equals( partition ) ) ) {
                                result.add( element.get___Mri( ).toString( ) );
                            }
                        }
                        return result.toArray( new String[result.size( )] );
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return new String[] { SpiJmxHelper.getExceptionAsString( e ) };
                }
            }
            return null;
        }

        public String showContentOfPartition( String priString ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        PRI pri = connection.getSession( ).getMoin( ).createPri( priString );
                        CoreModelPartition partition = connection.getPartition( pri );
                        if ( partition != null ) {
                            ByteArrayOutputStream bos = new ByteArrayOutputStream( );
                            CoreSerializerCallbackImpl callback = new CoreSerializerCallbackImpl( connection.getSession( ), partition );
                            new PartitionSerializerImpl( ).serialize( bos, callback );
                            return bos.toString( "UTF-8" ); //$NON-NLS-1$
                        }
                        return "The partition " + pri.toString( ) + " could not be retrieved."; //$NON-NLS-1$ //$NON-NLS-2$
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return SpiJmxHelper.getExceptionAsString( e );
                }
            }
            return "Connection is not alive."; //$NON-NLS-1$
        }

        public String showContentOfPartition( String priString, String version ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        PRI pri = connection.getSession( ).getMoin( ).createPri( priString );
                        CoreModelPartition partition = connection.getPartition( pri );
                        if ( partition != null ) {
                            ByteArrayOutputStream bos = new ByteArrayOutputStream( );
                            CoreSerializerCallbackImpl callback = new CoreSerializerCallbackImpl( connection.getSession( ), partition );
                            new PartitionSerializerImpl( version ).serialize( bos, callback );
                            return bos.toString( "UTF-8" ); //$NON-NLS-1$
                        }
                        return "The partition " + pri.toString( ) + " could not be retrieved."; //$NON-NLS-1$ //$NON-NLS-2$
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return SpiJmxHelper.getExceptionAsString( e );
                }
            }
            return "Connection is not alive."; //$NON-NLS-1$
        }

        public String showContentOfPartitionInNativeFormat( String priString ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        PRI pri = connection.getSession( ).getMoin( ).createPri( priString );
                        CoreModelPartition partition = connection.getPartition( pri );
                        if ( partition != null ) {
                            ByteArrayOutputStream bos = new ByteArrayOutputStream( );
                            CoreSerializerCallbackImpl callback = new CoreSerializerCallbackImpl( connection.getSession( ), partition );
                            SpiPartitionSerializationManager serializationManager = connection.getSession( ).getMoin( ).getPartitionSerializationManager( );
                            serializationManager.serialize( pri, bos, callback );
                            return bos.toString( "UTF-8" ); //$NON-NLS-1$
                        }
                        return "The partition " + pri.toString( ) + " could not be retrieved."; //$NON-NLS-1$ //$NON-NLS-2$
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return SpiJmxHelper.getExceptionAsString( e );
                }
            }
            return "Connection is not alive."; //$NON-NLS-1$
        }


        public String showPartitionDelta( String priString ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                this.synchronizationManager.acquireReadLock( );
                try {
                    PRI pri = connection.getSession( ).getMoin( ).createPri( priString );
                    CoreModelPartition partition = connection.getPartition( pri );
                    return connection.getPartitionChangeRecorder( ).getDeltaForPartition( partition ).toString( );
                } finally {
                    this.synchronizationManager.releaseReadLock( );
                }
            }
            return null;
        }

        public String showAllPartitionDeltas( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        StringBuilder result = new StringBuilder( );
                        for ( CoreModelPartition partition : connection.getDirtyPartitionsWithoutNullPartition( ) ) {
                            result.append( connection.getPartitionChangeRecorder( ).getDeltaForPartition( partition ).toString( ) );
                            result.append( "\n" ); //$NON-NLS-1$
                        }
                        return result.toString( );
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return null;
                }
            }
            return null;
        }

        public void deleteAllElementsInNullPartition( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                connection.getWrapper( ).getNullPartition( ).deleteElements( );
            }
        }

        public void save( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    connection.getWrapper( ).save( );
                } catch ( RuntimeException e ) {
                    throw e;
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
        }

        public void revert( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    connection.getWrapper( ).revert( );
                } catch ( RuntimeException e ) {
                    throw e;
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
        }

        public void close( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    connection.getWrapper( ).close( );
                } catch ( RuntimeException e ) {
                    throw e;
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
        }

        public CompositeData getElementByMRI( String mriString ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        MRI mri = connection.getSession( ).getMoin( ).createMri( mriString );
                        RefBaseObject rbo = connection.getElement( mri );
                        if ( rbo != null ) {
                            return this.getCompositeData( connection, rbo );
                        }
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( RuntimeException e ) {
                    throw e;
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
            return null;
        }

        public CompositeData getElementByLRI( String lriString ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        LRI lri = connection.getSession( ).getMoin( ).createLri( lriString );
                        RefBaseObject rbo = connection.getElement( lri );
                        if ( rbo != null ) {
                            return this.getCompositeData( connection, rbo );
                        }
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( RuntimeException e ) {
                    throw e;
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
            return null;
        }

        @SuppressWarnings( "unchecked" )
        private CompositeData getCompositeData( CoreConnection connection, RefBaseObject rbo ) throws OpenDataException {

            Map map = new LinkedHashMap( );
            map.put( "1: MOF-ID", rbo.refMofId( ) ); //$NON-NLS-1$
            ModelElement metaObject = (ModelElement) rbo.refMetaObject( );
            map.put( "2: Type (MRI)", ( (Partitionable) metaObject ).get___Mri( ).toString( ) ); //$NON-NLS-1$
            map.put( "3: Type (qual. name)", QualifiedName.toDotSeparatedString( ( (ModelElementInternal) metaObject ).getQualifiedName( connection ) ) ); //$NON-NLS-1$
            if ( rbo instanceof RefObject ) {
                map.put( "4: MRI", rbo.get___Mri( ).toString( ) ); //$NON-NLS-1$
                TabularDataSupport attrs = new TabularDataSupport( tabularTypeForModelElementAttributeValues );
                this.computeAttributeValues( connection, attrs, (RefObject) rbo );
                map.put( "5: Attributes", attrs ); //$NON-NLS-1$
            } else {
                map.put( "5: Attributes", null ); //$NON-NLS-1$
            }
            return new CompositeDataSupport( compositeTypeForModelElement, map );
        }

        @SuppressWarnings( "unchecked" )
        private void computeAttributeValues( CoreConnection connection, TabularData attrs, RefObject refObj ) throws OpenDataException {

            SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
            List<Attribute> attributes = jmiHelper.getAttributes( connection.getSession( ), (MofClass) refObj.refMetaObject( ), true );
            for ( Iterator it = attributes.iterator( ); it.hasNext( ); ) {
                Attribute attr = (Attribute) it.next( );
                Classifier type = jmiHelper.getNonAliasType( connection.getSession( ), ( (AttributeImpl) attr ).getType( connection ) );
                if ( type instanceof PrimitiveType || type instanceof EnumerationType ) {
                    Map attrValue = new LinkedHashMap( );
                    attrValue.put( "1: Name", attr.getName( ) ); //$NON-NLS-1$
                    Object value = ( (RefObjectImpl) refObj ).refGetValue( connection, attr );
                    attrValue.put( "2: Value", String.valueOf( value ) ); //$NON-NLS-1$
                    attrs.put( new CompositeDataSupport( compositeTypeForModelElementAttributeValues, attrValue ) );
                }
            }
        }

        public String getNullPartition( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null && connection.isAlive( ) ) {
                try {
                    this.synchronizationManager.acquireReadLock( );
                    try {
                        return connection.getNullPartition( ).getPri( ).toString( );
                    } finally {
                        this.synchronizationManager.releaseReadLock( );
                    }
                } catch ( Exception e ) {
                    return SpiJmxHelper.getExceptionAsString( e );
                }
            }
            return null;
        }

        @SuppressWarnings( "unchecked" )
        public int getCachedJmiWrappers( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                this.synchronizationManager.acquireReadLock( );
                try {
                    int result = 0;
                    for ( int i = 0; i < connection.jmiWrapperCache.length; i++ ) {
                        Map map = (Map) connection.jmiWrapperCache[i][1];
                        if ( map != null ) {
                            result += map.size( );
                        }
                    }
                    return result;
                } finally {
                    this.synchronizationManager.releaseReadLock( );
                }
            }
            return -1;
        }

        public int getCachedJmiListWrappers( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                this.synchronizationManager.acquireReadLock( );
                try {
                    return connection.jmiListWrapperCache.size( );
                } finally {
                    this.synchronizationManager.releaseReadLock( );
                }
            }
            return 0;
        }

        public int getCachedPartitionWrappers( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                return connection.partitionWrapperCache.size( );
            }
            return 0;
        }

        @SuppressWarnings( "unchecked" )
        public String[] showCachedJmiWrappers( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                this.synchronizationManager.acquireReadLock( );
                try {
                    TreeSet<String> result = new TreeSet<String>( );
                    for ( int i = 0; i < connection.jmiWrapperCache.length; i++ ) {
                        Map<String, WeakReferenceToJmiWrapper> wrappersInDataArea = (Map<String, WeakReferenceToJmiWrapper>) connection.jmiWrapperCache[i][1];
                        if ( wrappersInDataArea != null ) {
                            for ( WeakReferenceToJmiWrapper wrapperRef : wrappersInDataArea.values( ) ) {
                                Partitionable partitionable = wrapperRef.get( );
                                if ( partitionable != null ) {
                                    result.add( partitionable.get___Mri( ).toString( ) );
                                }
                            }
                        }
                    }
                    return result.toArray( new String[result.size( )] );
                } finally {
                    this.synchronizationManager.releaseReadLock( );
                }
            }
            return null;
        }

        public String[] showCachedPartitionWrappers( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                this.synchronizationManager.acquireReadLock( );
                try {
                    Set<PRI> pris = connection.partitionWrapperCache.keySet( );
                    TreeSet<String> result = new TreeSet<String>( );
                    for ( PRI pri : pris ) {
                        result.add( pri.toString( ) );
                    }
                    return result.toArray( new String[result.size( )] );
                } finally {
                    this.synchronizationManager.releaseReadLock( );
                }
            }
            return null;
        }

        public String getId( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                return connection.getId( );
            }
            return null;
        }

        public String getLabel( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                return connection.getLabel( );
            }
            return null;
        }

        public void initializeMqlProcessor( ) throws IOException {

            ConnectionImpl connection = this.connectionRef.get( );
            if ( connection != null ) {
                connection.getMQLProcessor( );
            }
        }
    }

    private final class WeakReferenceToJmiWrapper extends WeakReference<RefBaseObject> implements ActionOnBeingGarbageCollectedProvider {

        final String dataAreaName;

        final String mofId;

        @SuppressWarnings( "unchecked" )
        WeakReferenceToJmiWrapper( RefBaseObject referent, String dataAreaName, String mofId ) {

            super( referent, ConnectionImpl.this.getReferenceQueue( ) );
            this.dataAreaName = dataAreaName;
            this.mofId = mofId;
        }

        @SuppressWarnings( "unchecked" )
        public void actionOnBeingGarbageCollected( Reference reference ) {

            WeakReferenceToJmiWrapper ref = (WeakReferenceToJmiWrapper) reference;
            SessionImpl sessionImpl = ConnectionImpl.this.session;
            if ( sessionImpl != null ) {
                synchronized ( sessionImpl.getWrapperCacheLock( ) ) {
                    if ( ConnectionImpl.this.jmiWrapperCache != null ) {
                        for ( int i = 0; i < ConnectionImpl.this.jmiWrapperCache.length; i++ ) {
                            if ( ConnectionImpl.this.jmiWrapperCache[i][0] == ref.dataAreaName ) {
                                if ( ConnectionImpl.this.jmiWrapperCache[i][1] != null ) {
                                    Map map = (Map) ConnectionImpl.this.jmiWrapperCache[i][1];
                                    Object value = map.get( ref.mofId );
                                    if ( value == reference || value == null ) {
                                        //this check is absolutely essential because in the meantime a wrapper for the 
                                        //given MOFID could have been requested. If that's the case, we MUST NOT remove 
                                        //the entry from the map because otherwise the wrapper is no longer under our control
                                        //and cannot be updated correctly if something changes (e.g. COW transition) 
                                        map.remove( ref.mofId );
                                        if ( map.isEmpty( ) ) {
                                            ConnectionImpl.this.jmiWrapperCache[i][1] = null;
                                        }
                                    }
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    private final class WeakReferenceToJmiListWrapper extends WeakReference<AbstractConnectionAwareWrapper> implements ActionOnBeingGarbageCollectedProvider {

        final Object key;

        WeakReferenceToJmiListWrapper( AbstractConnectionAwareWrapper referent, Object key ) {

            super( referent, ConnectionImpl.this.getReferenceQueue( ) );
            this.key = key;
        }

        public void actionOnBeingGarbageCollected( Reference reference ) {

            WeakReferenceToJmiListWrapper ref = (WeakReferenceToJmiListWrapper) reference;
            SessionImpl sessionImpl = ConnectionImpl.this.session;
            if ( sessionImpl != null ) {
                synchronized ( sessionImpl.getWrapperCacheLock( ) ) {
                    Map<Object, WeakReferenceToJmiListWrapper> cache = ConnectionImpl.this.jmiListWrapperCache;
                    if ( cache != null ) {
                        cache.remove( ref.key );
                    }
                }
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    private final class WeakReferenceToAttributeValuesWrapper extends WeakReference<AttributeValuesWrapper> implements ActionOnBeingGarbageCollectedProvider {

        private final LRI lriOfRefFeatured;

        private final String mofIdOfAttribute;

        WeakReferenceToAttributeValuesWrapper( AttributeValuesWrapper referent, LRI lriOfRefFeatured, String mofIdOfAttribute ) {

            super( referent, ConnectionImpl.this.getReferenceQueue( ) );
            this.lriOfRefFeatured = lriOfRefFeatured;
            this.mofIdOfAttribute = mofIdOfAttribute;
        }

        public void actionOnBeingGarbageCollected( Reference reference ) {

            WeakReferenceToAttributeValuesWrapper ref = (WeakReferenceToAttributeValuesWrapper) reference;
            SessionImpl sessionImpl = ConnectionImpl.this.session;
            if ( sessionImpl != null ) {
                synchronized ( sessionImpl.getWrapperCacheLock( ) ) {
                    Map<LRI, Map<String, WeakReferenceToAttributeValuesWrapper>> cache = ConnectionImpl.this.attributeValuesWrapperCache;
                    if ( cache != null ) {
                        Map<String, WeakReferenceToAttributeValuesWrapper> map = cache.get( ref.lriOfRefFeatured );
                        if ( map != null ) {
                            map.remove( ref.mofIdOfAttribute );
                            if ( map.isEmpty( ) ) {
                                cache.remove( ref.lriOfRefFeatured );
                            }
                        }
                    }
                }
            }
        }
    }

    public Collection<EventListener> getRegisteredListeners( ) {

        return registeredListeners;
    }

    /**
     * @see RefObjectUtil#addLinkTarget(RefObject, AssociationEnd, LRI)
     */
    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target ) {

        this.addLinkTarget( host, targetAssociationEnd, target, -1 );
    }

    /**
     * @see RefObjectUtil#addLinkTarget(RefObject, AssociationEnd, LRI, int)
     */
    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target, int position ) {

        if ( host == null ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.HOSTELEMENTMUSTNOTBENULL );
        }

        if ( targetAssociationEnd == null ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.TARGETASSOCIATIONENDMUSTNOTBENULL );
        }

        if ( target == null ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.TARGETLRIMUSTNOTBENULL );
        }

        AssociationEnd hostAssociationEnd = ( (AssociationEndInternal) targetAssociationEnd ).otherEnd( this );
        WorkspaceSet workspaceSet = session.getWorkspaceSet( );
        boolean hostAssociationEndStored = workspaceSet.getMoin( ).getJmiHelper( ).isEndStored( session, hostAssociationEnd );
        if ( !hostAssociationEndStored ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.ASSOCIATIONENDFORHOSTMUSTHAVESTORAGE, hostAssociationEnd.getName( ) );
        }

        Association association = (Association) ( (RefObjectImpl) targetAssociationEnd ).refImmediateComposite( session );
        boolean targetAssociationEndOrdered = targetAssociationEnd.getMultiplicity( ).isOrdered( );
        if ( !targetAssociationEndOrdered ) {
            if ( position != -1 ) {
                throw new MoinIllegalArgumentException( CoreImplMessages.FORTARGETASSOCIATIONENDPOSITIONISNOTALLOWED, targetAssociationEnd.getName( ), position );
            }
        }

        MicroTransactionable mtx = null;
        byte fromEnd = workspaceSet.getMoin( ).getJmiHelper( ).getAssociationEndNumber( this.session, hostAssociationEnd );
        CorePartitionable hostPartitionable = (CorePartitionable) host;
        MemoryLinkManager linkManager = hostPartitionable.get___Workspace( ).getMemoryLinkManager( );
        Collection<EndStorageLink> linksForEndAndMetaObject = linkManager.getLinksForEndAndMetaObject( session, workspaceSet.getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEnd, association ), hostPartitionable );
        int size = linksForEndAndMetaObject.size( );
        if ( position > size || position < -1 ) {
            throw new MoinIndexOutOfBoundsException( position, size );
        }

        mtx = workspaceSet.getMoin( ).getMicroTransactionableFactory( ).createDanglingLinkAddElementMicroTransactionable( this, association, host, fromEnd, position, target );
        session.getTransactionManager( ).runInMicroTransaction( mtx );
    }

    public void setSaveAllowed( boolean allowed ) {

        saveAllowed = allowed;
    }

    // CAUTION: must be called by SessionImpl.updateWrapperCaches() only !!!
    @SuppressWarnings( "unchecked" )
    public void updateWrapperCaches( PRI pri, Workspace workspaceToHostTheReferencesAfterwards ) {

        // update partition wrapper
        if ( partitionWrapperCache != null ) { // otherwise, the connection has already been closed
            ModelPartitionWrapper partitionWrapper = (ModelPartitionWrapper) partitionWrapperCache.get( pri );
            if ( partitionWrapper != null ) {
                PriReference priReference = this.session.getWorkspaceSet( ).getReferenceManager( ).getPriReference( pri, workspaceToHostTheReferencesAfterwards );
                priReference.uncache( ); //uncache is important in case of deleted partition
                partitionWrapper.setPriReference( priReference );
            }
        }
        // update JMI wrappers
        if ( jmiWrapperCache != null ) {
            Map<String, WeakReferenceToJmiWrapper> cachedWrappers = null;
            String dataAreaName = pri.getDataAreaDescriptor( ).getDataAreaName( );

            for ( int i = 0; i < this.jmiWrapperCache.length; i++ ) {
                if ( jmiWrapperCache[i][0] == dataAreaName ) {
                    cachedWrappers = (Map<String, WeakReferenceToJmiWrapper>) jmiWrapperCache[i][1];
                    break;
                }
            }

            if ( cachedWrappers != null ) {
                // We must go through ALL wrappers, check whether they belong to the partition, and if yes, update their
                // MriReference. Trying this via partition.getElements() will not work if the partition has been deleted
                // in memory (getElements() will return an empty collection in that case). And even if the partition is still
                // alive, we will miss wrappers for deleted elements if we use partition.getElements().
                for ( WeakReferenceToJmiWrapper weakRef : cachedWrappers.values( ) ) {
                    if ( weakRef != null ) {
                        RefBaseObjectWrapperImpl cachedWrapper = (RefBaseObjectWrapperImpl) weakRef.get( );
                        if ( cachedWrapper != null ) {
                            MriReference currentMriReference = cachedWrapper.getMriReference( );
                            if ( currentMriReference.getMri( ).getPri( ).equals( pri ) ) {
                                MriReference mriReference = this.session.getWorkspaceSet( ).getReferenceManager( ).getMriReference( currentMriReference.getMri( ), workspaceToHostTheReferencesAfterwards );
                                cachedWrapper.setMriReference( mriReference );
                            }
                        }
                    }
                }
            }
        }

        // replace JmiLists in cached JmiListWrappers
        if ( jmiListWrapperCache != null ) {
            for ( WeakReferenceToJmiListWrapper weakRef : jmiListWrapperCache.values( ) ) {
                if ( weakRef != null ) {
                    JmiListWrapper jmiListWrapper = (JmiListWrapper) weakRef.get( );
                    if ( jmiListWrapper != null ) {
                        if ( jmiListWrapper.isValid( ) ) {
                            JmiList jmiList = jmiListWrapper.unwrap( );
                            if ( !jmiList.isDistributed( ) ) {
                                PRI fromEndPri = jmiList.getFromEnd( ).getPri( );
                                if ( fromEndPri.equals( pri ) ) {
                                    JmiList<CorePartitionable> newJmiList = session.getWorkspace( ).getMemoryLinkManager( ).getElementsForEndAndMetaobject( this, jmiList.getEndAndMetaObject( ), (CorePartitionable) getElement( jmiList.getFromEnd( ) ) );
                                    jmiListWrapper.setJmiList( newJmiList );
                                }
                            }
                        }
                    }
                }
            }
        }

        // update AttributeValues wrappers (primitive to-n Attributes)
        if ( attributeValuesWrapperCache != null ) {
            for ( Map<String, WeakReferenceToAttributeValuesWrapper> wrapperForAttribute : attributeValuesWrapperCache.values( ) ) {
                for ( WeakReferenceToAttributeValuesWrapper weakRef : wrapperForAttribute.values( ) ) {
                    if ( weakRef != null ) {
                        AttributeValuesWrapper attributeValuesWrapper = weakRef.get( );
                        if ( attributeValuesWrapper != null ) {
                            if ( attributeValuesWrapper.getMriOfFeatured( ).getPri( ).equals( pri ) ) {
                                MRI featuredElementMri = attributeValuesWrapper.getMriOfFeatured( );
                                MriReference featured = session.getWorkspaceSet( ).getReferenceManager( ).getMriReference( featuredElementMri, workspaceToHostTheReferencesAfterwards );
                                attributeValuesWrapper.setFeatured( featured );
                            }
                        }
                    }
                }
            }
        }
    }

    public MultiValuedAttributesList getMultiValueAttributesList( CorePartitionable featured, String attributeMofId ) {

        RefFeaturedImpl refFeatured = (RefFeaturedImpl) featured;
        Attribute attribute = (Attribute) getSession( ).getMoin( ).getMetamodelWorkspace( ).getMetamodelElement( attributeMofId );
        MultiValuedAttributesList result = (MultiValuedAttributesList) refFeatured.refGetValue( this, attribute );
        return result;
    }


    public IeFactory getImportExportFactory( ) {

        return this.ieFactory;
    }

    @SuppressWarnings( "unchecked" )
    public void setMriReferenceOfJmiWrapperToSessionWorkspace( MRI mriOfWrapper ) {

        Map<String, WeakReferenceToJmiWrapper> cachedWrappers = null;
        String dataAreaName = mriOfWrapper.getDataAreaDescriptor( ).getDataAreaName( );
        for ( int i = 0; i < this.jmiWrapperCache.length; i++ ) {
            if ( jmiWrapperCache[i][0] == dataAreaName ) {
                cachedWrappers = (Map<String, WeakReferenceToJmiWrapper>) jmiWrapperCache[i][1];
                break;
            }
        }
        if ( cachedWrappers != null ) {
            String mofId = mriOfWrapper.getMofId( );
            WeakReferenceToJmiWrapper ref = cachedWrappers.get( mofId );
            if ( ref != null ) {
                RefBaseObjectWrapperImpl cachedWrapper = (RefBaseObjectWrapperImpl) ref.get( );
                if ( cachedWrapper != null ) {
                    MriReference mriReference = this.session.getWorkspaceSet( ).getReferenceManager( ).getMriReference( mriOfWrapper, session.getWorkspace( ) );
                    cachedWrapper.setMriReference( mriReference );
                }
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    public Collection<Wrapper> getCachedJmiWrappers( ) {

        Collection<Wrapper> result = null;
        for ( int i = 0; i < this.jmiWrapperCache.length; i++ ) {
            Map<String /* MOF-ID, interned */, WeakReferenceToJmiWrapper> wrappersOfDataArea = (Map<String, WeakReferenceToJmiWrapper>) this.jmiWrapperCache[i][1];
            if ( wrappersOfDataArea != null ) {
                boolean wrappersObtained = false;
                while ( !wrappersObtained ) {
                    try {
                        result = new ArrayList<Wrapper>( );
                        for ( WeakReferenceToJmiWrapper weakRef : wrappersOfDataArea.values( ) ) {
                            if ( weakRef != null ) {
                                Wrapper jmiWrapper = (Wrapper) weakRef.get( );
                                if ( jmiWrapper != null ) {
                                    result.add( jmiWrapper );
                                }
                            }
                        }
                        wrappersObtained = true;
                    } catch ( ConcurrentModificationException ex ) {
                        continue;
                    }
                }
            }
        }
        if ( result == null ) {
            return Collections.emptyList( );
        }
        return result;
    }
}
