package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;

import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.AmbiguousPackageNameException;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidSessionException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreEventFactory;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CoreOclRegistryService;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.SessionWrapper;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.consistency.impl.ConsistencyViolationRegistryImpl;
import com.sap.tc.moin.repository.core.events.framework.SessionEventManager;
import com.sap.tc.moin.repository.core.events.framework.simple.SessionEventManagerSimple;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.core.ocl.service.OclService;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclRegistryServiceImpl;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclServiceImpl;
import com.sap.tc.moin.repository.core.transactions.TransactionManagerImpl;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.jmx.SessionMBean;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.Notifyee;
import com.sap.tc.moin.repository.shared.util.NotifyingWeakHashMap;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.transactions.TransactionManager;


public class SessionImpl implements CoreSession, Notifyee, ConsistencyListener {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CONNECTIONS_SESSIONS, SessionImpl.class );

    private static AtomicInteger sessionCounter = new AtomicInteger( 1 );

    private AtomicInteger connectionCounter = new AtomicInteger( 1 );

    private final int instanceIndex;

    /**
     * Protects all caches of session-specific wrappers (JMI Wrappers, partition
     * wrappers, JmiList wrappers) against other threads working on the same
     * session.
     * <p>
     * Note: this lock must never be nulled !!!
     */
    private final Object wrapperCacheLock;

    /**
     * The user workspace holding the model elements and links that all
     * connections of this session share.
     */
    private SessionWorkspace sessionWorkspace;

    /**
     * The collection of Connections with the same ClientSpec and therefore all
     * assigned to the same Session.
     */
    private Map<CoreConnection, Object> connections;

    /**
     * Synchronization object for the "connections" map. The map itself cannot
     * be used, because it is itself synchronized and calls out when it is
     * "notifying" which would lead to lock order problems. Therefore we use
     * this extra synchronization lock object so we can guarantee lock order.
     */
    private Object connectionsLock = new Object( );


    /**
     * This is the ClientSpec which is used to identify which Connections to
     * group by a Session.
     */
    private final SpiCompoundClientSpec compoundClientSpec;

    /**
     * Flag which indicates, if a Session is still alive or if it has been
     * closed already.
     */
    private boolean alive;

    /**
     * The event manager for this session.
     */
    private SessionEventManager eventManager;

    /**
     * The transaction manager for this session.
     */
    private TransactionManager transactionManager;

    /**
     * The lock manager for this session.
     */
    private PartitionLockManager partitionLockManager;

    /**
     * This is the context to register for a Connection. If this context is
     * passed in the notification method, we know that a remove connection has
     * explicitly called
     */
    private Object sessionPrivateContext;

    private CoreOclRegistryService oclRegistryService;

    private ConsistencyViolationRegistryImpl consistencyRegistry;

    private final boolean oclServiceFailure = false;

    /**
     * Caches the value of toString().
     */
    private String toString;

    /**
     * This session's wrapper.
     */
    private final SessionWrapper wrapper;

    private WorkspaceSet workspaceSet;

    /**
     * cache for persistent partitions in each model container.
     */
    private Map<CRI, Collection<PRI>> cachePartitionsInContainer = new HashMap<CRI, Collection<PRI>>( );

    /**
     * The name identifying this session in JMX.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer. We need it
     * for the emission of JMX notifications.
     */
    private JmxAdapter jmxAdapter;

    /**
     * Whether the emission of JMX notifications is currently enabled.
     */
    public volatile boolean jmxNotificationsEnabled;

    /**
     * @param clientSpec the ClientSpec which is the criteria to group
     * Connections aggregated by this Session
     * @param moin the Moin instance hosting this session; must be provided in
     * order to allow for session termination notification
     */
    SessionImpl( SessionWorkspace sessionWorkspace, WorkspaceSet workspaceSet, SpiCompoundClientSpec clientSpec ) {

        this.alive = true;
        this.workspaceSet = workspaceSet;
        this.connections = new NotifyingWeakHashMap<CoreConnection, Object>( this.getReferenceQueue( ) );
        this.compoundClientSpec = clientSpec;
        this.eventManager = new SessionEventManagerSimple( );
        this.sessionWorkspace = sessionWorkspace;
        this.wrapper = new SessionWrapper( this.workspaceSet, this );
        this.instanceIndex = sessionCounter.getAndIncrement( );
        this.consistencyRegistry = new ConsistencyViolationRegistryImpl( this );
        this.sessionPrivateContext = new Object( );
        this.wrapperCacheLock = new Object( );
        if ( JMX_ENABLED ) {
            objectName = getObjectName( );
            jmxAdapter = new JmxAdapter( this, objectName, this.getReferenceQueue( ) );
            eventManager.registerMBean( this );
        }
    }

    public final Object getWrapperCacheLock( ) {

        return this.wrapperCacheLock;
    }

    private ReferenceQueue getReferenceQueue( ) {

        return this.workspaceSet.getMoin( ).getReferenceQueue( );
    }

    public CorePartitionable getElement( MRI mri ) {

        if ( mri == null ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.CANNOTGETELEMENTFORARGUMENTMRIEQUALSNULL );
        }

        return this.workspaceSet.resolveMri( this, mri );
    }

    public CorePartitionable getElement( LRI lri ) {

        if ( lri == null ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.CANNOTGETELEMENTFORARGUMENTLRIEQUALSNULL );
        }
        return this.workspaceSet.resolveLri( this, lri );
    }

    public RefPackage getPackage( String modelContainerName, String... qualifiedName ) {

        if ( ( qualifiedName == null ) || ( qualifiedName.length == 0 ) ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.NOQUALIFIEDNAMESPECIFIED );
        }
        RefPackage[] resultArray = this.workspaceSet.getPackages( modelContainerName, qualifiedName );
        if ( resultArray == null ) {
            return null;
        }
        if ( resultArray.length == 0 ) {
            return null;
        }
        if ( resultArray.length == 1 ) {
            return resultArray[0];
        }
        // if more than one packages is found, than throw an exception

        throw new AmbiguousPackageNameException( resultArray, RepositoryCoreMessages.DUPLICATEPACKAGES, QualifiedName.createQualifiedName( qualifiedName ).toDotSeparatedString( ) );
    }

    /**
     * @return Returns the ClientSpec of this Session.
     */
    public SpiCompoundClientSpec getCompoundClientSpec( ) {

        return this.compoundClientSpec;
    }

    /**
     * @return Returns the workspace.
     */
    public SessionWorkspace getWorkspace( ) {

        // Client code relies on the "assertAlive"!!! Do not remove!
        assertAlive( );
        return this.sessionWorkspace;
    }

    /**
     * Gets the event registry for this session
     * 
     * @return the event registry for this session
     */
    public EventRegistry getEventRegistry( ) {

        return this.eventManager;
    }

    public boolean isAlive( ) {

        return this.alive;
    }

    /**
     * @return Returns the connections.
     */
    public Set<CoreConnection> getConnections( ) {

        assertAlive( );
        return getConnectionsInternal( );
    }

    private Set<CoreConnection> getConnectionsInternal( ) {

        synchronized ( connectionsLock ) {
            if ( connections != null ) {
                //we cannot use "result.addAll(connections.keySet()), because the keyset 
                //of the "connections" map can contain "null" keys
                //That's the case when a connection was garbage collected but the weak reference wasn't removed yet
                //therefore we have to iterate explicitly and check for null
                synchronized ( connections ) {
                    //we also have to synchronize on "connections" itself because when a connection is garbage
                    //collected, it is automatically removed by the NotifyingWeakHashMap "connections" itself 
                    //which also synchronizes on itself. So if we don't also synchronize here, a ConcurrentModificationException
                    //could occur when the garbage collection takes place after we got the keySet but before we finished
                    //iterating over it
                    HashSet<CoreConnection> result = new HashSet<CoreConnection>( );
                    for ( CoreConnection connection : connections.keySet( ) ) {
                        if ( connection != null ) {
                            result.add( connection );
                        }
                    }
                    return result;
                }
            } else {
                return Collections.emptySet( );
            }
        }
    }

    public WorkspaceSet getWorkspaceSet( ) {

        return this.workspaceSet;
    }

    @SuppressWarnings( "unchecked" )
    public Connection createConnection( ) {

        return this.createConnection( null );
    }

    @SuppressWarnings( "unchecked" )
    public Connection createConnection( String label ) {

        assertAlive( );
        synchronized ( connectionsLock ) {
            assertAlive( );
            for ( Connection connection : getConnectionsInternal( ) ) {
                if ( connection.isAlive( ) ) {
                    throw new MoinIllegalStateException( RepositoryCoreMessages.MAX_NUMBER_OF_CONNECTIONS_REACHED, this.toString( ) );
                }
            }
            CoreConnection connection = new ConnectionImpl( this, this.connectionCounter.getAndIncrement( ), label );
            ( (NotifyingWeakHashMap) this.connections ).put( connection, null, sessionPrivateContext, this );

            // as the partition manager has structures that are keyed by the
            // connection (resp. its getId()), it has to be notified when the
            // connection is closed or garbage collected so that the structures
            // can be cleaned up
            this.registerForConnectionCloseEvent( connection, connection.getId( ), getWorkspace( ).getPartitionManager( ) );

            return connection;
        }
    }

    public void removeConnection( Connection connection ) {

        assertAlive( );
        synchronized ( connectionsLock ) {
            if ( this.connections != null ) {
                this.connections.remove( connection );
                // destroy() is indirectly called by the above "this.connections.remove(connection)" call
                //as "connections" is a NotifyingWeakHashMapnotifying which calls "notifyOnObjectRemoved"
            }
        }
    }

    public void notifyOnObjectRemoved( boolean garbageCollected, Object context ) {

        //all "explicit" access (i.e. session.close() or indirectly via connection.close()) is synchronized
        //via the MicroWriteLock. But this method can also be called "implicitly" if a connection is garbage collected.
        //In this gc case, no locks are acquired, therefore we have to acquire the locks here because otherwise
        //it is not thread-safe and other threads using this session (e.g. cross session notification during save) 
        //could be confronted with InvalidSessionException
        if ( garbageCollected ) {
            SynchronizationManager synchronizationManager = getWorkspaceSet( ).getSynchronizationManager( );
            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                synchronizationManager.acquireMicroWriteLock( );
                try {
                    this.destroy( );
                } finally {
                    synchronizationManager.releaseMicroWriteLock( );
                }
            }
        } else {
            this.destroy( );
        }

    }

    @SuppressWarnings( "unchecked" )
    public void registerForConnectionCloseEvent( Connection connection, Object context, Notifyee notifyee ) {

        synchronized ( connectionsLock ) {
            if ( this.connections != null ) {
                if ( this.connections.containsKey( connection ) ) {
                    // register as "first" in the notification list
                    ( (NotifyingWeakHashMap) this.connections ).register( connection, context, notifyee, 0 );
                }
            }
        }
    }



    // -- private methods

    /**
     * Asserts that the Session is still alive and was not closed.
     * 
     * @throws InvalidSessionException if {@link #isAlive()}returns false
     */
    private void assertAlive( ) {

        if ( !isAlive( ) ) {
            throw new InvalidSessionException( JmiCoreMessages.SESSIONISINVALID );
        }
    }

    public void close( ) throws IllegalStateException {

        synchronized ( connectionsLock ) {
            if ( this.connections != null ) {
                if ( this.connections.size( ) > 0 ) {
                    throw new MoinIllegalStateException( CoreImplMessages.ATTEMPTTOCLOSEASESSIONWHERESTILLCONNECTIONSOPEN, this.connections.size( ) );
                }
                destroyInternal( );
            }
        }
    }

    private void destroy( ) {

        synchronized ( connectionsLock ) {
            if ( this.connections != null ) {
                this.getConsistencyViolationRegistry( ).shutdown( );
                if ( this.connections.size( ) == 0 ) {
                    destroyInternal( );
                }
            }
        }
    }

    private void destroyInternal( ) {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.traceWithStack( MoinSeverity.DEBUG, "Starting to destroy session {0}", this ); //$NON-NLS-1$
        }



        // getClientSpec() would throw an assertion exception
        this.getWorkspaceSet( ).removeSession( this ); // .compoundClientSpec);
        if ( this.sessionWorkspace != null ) {
            this.sessionWorkspace.destroy( ); // TODO close
            // the Workspace
            // stack?
            // remove clientspec to workspace mapping added during
            // createClientSpecificWorkspace
            // this.workspace.getWorkspaceSet().removeClientSpecificWorkspace(this);
        }
        this.alive = false;
        this.sessionWorkspace = null;
        if ( JMX_ENABLED ) {
            SpiJmxHelper.unregisterMBean( this.eventManager.getObjectName( ) );
            if ( this.oclRegistryService != null ) {
                SpiJmxHelper.unregisterMBean( this.oclRegistryService.getObjectName( ) );
            }
            SpiJmxHelper.unregisterMBean( this.objectName );
            this.objectName = null;
        }

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Finished destroying of session {0}", this ); //$NON-NLS-1$
        }

        this.jmxAdapter = null;
        this.eventManager = null;
        this.connections = null;

        this.partitionLockManager = null;
        // removed to enable reopening of connection for inconsistency
        // notification thread
        //this.compoundClientSpec = null;

        this.transactionManager = null;
        this.sessionPrivateContext = null;
        this.oclRegistryService = null;
        this.toString = null;
        this.workspaceSet = null;
        this.cachePartitionsInContainer = null;
        this.connectionCounter = null;
        this.consistencyRegistry = null;



    }

    public List<CoreModelPartition> getPartitionsToConsiderMemoryState( ) {

        List<CoreModelPartition> result = new ArrayList<CoreModelPartition>( );
        for ( CoreConnection connection : getConnectionsInternal( ) ) {
            result.add( connection.getNullPartition( ) );
            Collection<CoreModelPartition> transientPartitions = connection.getTransientPartitionsInternal( );
            result.addAll( transientPartitions );
            Collection<CoreModelPartition> dirtyPartitionsWithoutNullPartition = connection.getDirtyPartitionsWithoutNullPartition( );
            result.addAll( dirtyPartitionsWithoutNullPartition );
        }
        return result;
    }

    @Override
    public String toString( ) {

        if ( this.toString == null ) {
            this.toString = new DecimalFormat( "000" ).format( this.instanceIndex ); //$NON-NLS-1$
        }
        return this.toString;
    }

    /**
     * The PartitionLockManager for this session. The method is used by
     * {@link ConnectionImpl} and therefore it is package-private and not
     * exposed by the {@link com.sap.tc.moin.repository.core.impl.Session}
     * interface but the
     * {@link com.sap.tc.moin.repository.core.impl.CoreConnection} interface.
     * 
     * @return the PartitionLockManager for this session.
     * @see com.sap.tc.moin.repository.core.impl.CoreConnection#getPartitionLockManager()
     */
    PartitionLockManager getPartitionLockManager( ) {

        if ( this.partitionLockManager == null ) {
            this.partitionLockManager = this.workspaceSet.getLockManager( );
        }

        return this.partitionLockManager;
    }

    public LockManager getLockManager( ) {

        return this.getPartitionLockManager( );
    }

    /**
     * @see CoreSession#getEventManager()
     */
    public SpiEventManager getEventManager( ) {

        return this.eventManager;
    }

    /**
     * @see CoreSession#getEventFactory()
     */
    public CoreEventFactory getEventFactory( ) {

        return getWorkspaceSet( ).getMoin( ).getEventFactory( );
    }

    /**
     * @see CoreSession#getTransactionManager()
     */
    public TransactionManager getTransactionManager( ) {

        if ( this.transactionManager == null ) {
            this.transactionManager = new TransactionManagerImpl( this );
        }
        return this.transactionManager;
    }

    /**
     * Used by the connection
     * 
     * @return the service
     */
    public CoreOclRegistryService getCoreOclRegistryService( ) {

        if ( this.oclServiceFailure ) {
            throw new RuntimeException( OclServiceExceptions.OCLREGISTRYNOTAVAILABLE.getLocalizedMessage( Locale.ENGLISH ) );
        }
        if ( this.oclRegistryService == null ) {
            this.oclRegistryService = new OclRegistryServiceImpl( this );
            if ( JMX_ENABLED ) {
                this.oclRegistryService.registerMBean( this );
            }
        }
        return this.oclRegistryService;
    }

    public ConsistencyViolationRegistryImpl getConsistencyViolationRegistry( ) {

        return this.consistencyRegistry;
    }

    public OclService getOclService( ) {

        return OclServiceImpl.getInstance( );
    }

    public CoreMoin getMoin( ) {

        return this.workspaceSet.getMoin( );
    }

    public SessionWrapper getWrapper( ) {

        return this.wrapper;
    }

    public ObjectName getObjectName( ) {

        try {
            return new ObjectName( MOIN_DOMAIN + "type=Session,moin=" + this.workspaceSet.getMoin( ).getId( ) + ",id=" + toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
    }

    private static final class JmxAdapter extends NotificationBroadcasterSupport implements SessionMBean {

        private final SynchronizationManager synchronizationManager;

        private final WeakReferenceWithObjectName<SessionImpl> sessionRef;

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private final AtomicLong seqNo = new AtomicLong( 0 );

        private final ObjectName objectName;

        JmxAdapter( SessionImpl session, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            synchronizationManager = session.getWorkspaceSet( ).getSynchronizationManager( );
            sessionRef = new WeakReferenceWithObjectName<SessionImpl>( session, objectName, refQueue );
            registerBroadcastingMBean( this, SessionMBean.class, objectName );
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( SessionMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by a Session MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public void startNotifications( ) throws IOException {

            SessionImpl session = this.sessionRef.get( );
            if ( session != null ) {
                session.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            SessionImpl session = this.sessionRef.get( );
            if ( session != null ) {
                return session.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            SessionImpl session = this.sessionRef.get( );
            if ( session != null ) {
                session.jmxNotificationsEnabled = false;
            }
        }

        public void consistencyViolationOccured( ConsistencyViolation violation, Connection connection ) {

            SessionImpl session = this.sessionRef.get( );
            if ( session != null ) {
                Notification notification = new Notification( SessionMBean.CONSISTENCY_VIOLATION_OCCURED, this.objectName, this.seqNo.incrementAndGet( ), violation.toString( ) );
                notification.setUserData( "Session=" + session.toString( ) + ",Connection=" + connection.toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
                this.sendNotification( notification );
            }
        }

        public void consistencyViolationFixed( ConsistencyViolation violation, Connection connection ) {

            SessionImpl session = this.sessionRef.get( );
            if ( session != null ) {
                Notification notification = new Notification( SessionMBean.CONSISTENCY_VIOLATION_FIXED, this.objectName, this.seqNo.incrementAndGet( ), violation.toString( ) );
                notification.setUserData( "Session=" + session.toString( ) + ( ( connection != null ) ? ( ",Connection=" + connection.toString( ) ) : "" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                this.sendNotification( notification );
            }
        }

        public String[] getLoadedPartitions( ) throws IOException {

            SessionImpl session = sessionRef.get( );
            if ( session != null ) {
                synchronizationManager.acquireReadLock( );
                try {
                    List<String> result = new ArrayList<String>( );
                    Collection<SpiModelPartition> loadedPartitions = new ArrayList<SpiModelPartition>( session.getWorkspace( ).getPartitionManager( ).getLoadedPartitions( ) );
                    loadedPartitions.addAll( session.getCompoundClientSpecWorkspace( ).getPartitionManager( ).getLoadedPartitions( ) );
                    for ( SpiModelPartition partition : loadedPartitions ) {
                        result.add( partition.getPri( ).toString( ) );
                    }
                    return result.toArray( new String[result.size( )] );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            return null;
        }

        public String showSummaryOfLoadedPartitions( ) {

            SessionImpl session = sessionRef.get( );
            if ( session != null ) {
                synchronizationManager.acquireReadLock( );
                try {
                    //FIXME HACK!!!
                    CoreConnection connection = session.getConnections( ).iterator( ).next( );
                    StringBuilder result = new StringBuilder( );
                    Collection<SpiModelPartition> loadedPartitions = new ArrayList<SpiModelPartition>( session.getWorkspace( ).getPartitionManager( ).getLoadedPartitions( ) );
                    loadedPartitions.addAll( session.getCompoundClientSpecWorkspace( ).getPartitionManager( ).getLoadedPartitions( ) );
                    result.append( loadedPartitions.size( ) ).append( " partition(s) are currently loaded.\n\n" ); //$NON-NLS-1$
                    for ( SpiModelPartition partition : loadedPartitions ) {
                        result.append( "Partition: " ).append( partition.getPri( ).toString( ) ).append( "\n" ); //$NON-NLS-1$//$NON-NLS-2$
                        result.append( "   Elements:  " ).append( partition.getElements( ).size( ) ).append( "\n" ); //$NON-NLS-1$//$NON-NLS-2$
                        if ( partition.getElements( ).size( ) > 0 ) {
                            result.append( "      Class Histogram:\n" ); //$NON-NLS-1$
                            TreeMap<String, AtomicInteger> histogram = new TreeMap<String, AtomicInteger>( );
                            int maxClassNameLength = 0;

                            for ( Partitionable element : partition.getElements( ) ) {
                                String qName = QualifiedName.toDotSeparatedString( ( (ModelElementInternal) ( (RefObject) element ).refMetaObject( ) ).getQualifiedName( connection ) );
                                maxClassNameLength = Math.max( maxClassNameLength, qName.length( ) );
                                AtomicInteger count = histogram.get( qName );
                                if ( count == null ) {
                                    histogram.put( qName, count = new AtomicInteger( 0 ) );
                                }
                                count.incrementAndGet( );
                            }
                            for ( Entry<String, AtomicInteger> entry : histogram.entrySet( ) ) {
                                String qName = entry.getKey( );
                                char[] whiteSpace = new char[maxClassNameLength - qName.length( )];
                                Arrays.fill( whiteSpace, ' ' );
                                result.append( "         " ).append( qName ).append( whiteSpace ).append( " : " ).append( entry.getValue( ).intValue( ) ).append( "\n" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
                            }
                        }
                        result.append( "   Links:     " ).append( partition.getLinks( ).size( ) ).append( "\n" ); //$NON-NLS-1$//$NON-NLS-2$
                        if ( partition.getLinks( ).size( ) > 0 ) {
                            result.append( "      Link Histogram:\n" ); //$NON-NLS-1$
                            TreeMap<String, AtomicInteger> histogram = new TreeMap<String, AtomicInteger>( );
                            int maxAssociationNameLength = 0;
                            for ( SpiLink link : partition.getLinks( ) ) {
                                ModelElementInternal metaObject = (ModelElementInternal) ( (EndStorageLink) link ).getMetaObject( );
                                String qName = QualifiedName.toDotSeparatedString( metaObject.getQualifiedName( connection ) );
                                maxAssociationNameLength = Math.max( maxAssociationNameLength, qName.length( ) );
                                AtomicInteger count = histogram.get( qName );
                                if ( count == null ) {
                                    histogram.put( qName, count = new AtomicInteger( 0 ) );
                                }
                                count.incrementAndGet( );
                            }
                            for ( Entry<String, AtomicInteger> entry : histogram.entrySet( ) ) {
                                String qName = entry.getKey( );
                                char[] whiteSpace = new char[maxAssociationNameLength - qName.length( )];
                                Arrays.fill( whiteSpace, ' ' );
                                result.append( "         " ).append( qName ).append( whiteSpace ).append( " : " ).append( entry.getValue( ).intValue( ) ).append( "\n" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
                            }
                        }
                        result.append( "   Dirty:     " ).append( partition.isDirty( ) ).append( "\n" ); //$NON-NLS-1$//$NON-NLS-2$
                        result.append( "   Persisted: " ).append( partition.isPersisted( ) ).append( "\n" ); //$NON-NLS-1$//$NON-NLS-2$
                        result.append( "\n" ); //$NON-NLS-1$
                    }
                    return result.toString( );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            return null;
        }

        public String[] getAllConsistencyViolations( ) {

            SessionImpl session = sessionRef.get( );
            if ( session != null ) {
                synchronizationManager.acquireReadLock( );
                try {
                    Collection<ConsistencyViolation> violations = session.getConsistencyViolationRegistry( ).getAllConsistencyViolations( );
                    String[] result = new String[violations.size( )];
                    int i = 0;
                    for ( ConsistencyViolation violation : violations ) {
                        result[i++] = violation.toString( );
                    }
                    return result;
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            return null;

        }

        public String[] getAllConsistencyListeners( ) {

            SessionImpl session = sessionRef.get( );
            if ( session != null ) {
                synchronizationManager.acquireReadLock( );
                try {
                    Collection<ConsistencyListener> listeners = session.getConsistencyViolationRegistry( ).getAllConsistencyListeners( );
                    String[] result = new String[listeners.size( )];
                    int i = 0;
                    for ( ConsistencyListener listener : listeners ) {
                        result[i++] = listener.toString( );
                    }
                    return result;
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            return null;

        }

        public void initializeOclRegistryService( ) throws IOException {

            SessionImpl session = sessionRef.get( );
            if ( session != null ) {
                session.getCoreOclRegistryService( );
            }
        }
    }

    public void onConsistencyResolution( ConsistencyViolation[] consistencyViolations, Connection connection ) {

        synchronized ( connectionsLock ) {
            if ( connections != null ) {
                if ( ( this.jmxAdapter != null ) && ( consistencyViolations.length > 0 ) ) {
                    for ( ConsistencyViolation consistencyViolation : consistencyViolations ) {
                        this.jmxAdapter.consistencyViolationFixed( consistencyViolation, connection );
                    }
                }
            }
        }
    }

    public void onConsistencyViolation( ConsistencyViolation[] consistencyViolations, Connection connection ) {

        synchronized ( connectionsLock ) {
            if ( this.connections != null ) {
                if ( ( this.jmxAdapter != null ) && ( consistencyViolations.length > 0 ) ) {
                    for ( ConsistencyViolation consistencyViolation : consistencyViolations ) {
                        this.jmxAdapter.consistencyViolationOccured( consistencyViolation, connection );
                    }
                }
            }
        }
    }

    public Map<CRI, Collection<PRI>> getCachePartitionsInContainer( ) {

        return this.cachePartitionsInContainer;
    }

    public Collection<PRI> getInnerPartitions( CRI cri ) {

        // Then check if requested partitions are already in cache
        Collection<PRI> cachedPris = getCachePartitionsInContainer( ).get( cri );
        // if cache is empty, then ask persistence
        if ( cachedPris == null || cachedPris.isEmpty( ) ) {
            // Cache miss -> really check the content
            SpiFacility facility = (SpiFacility) getMoin( ).getFacilityById( cri.getDataAreaDescriptor( ).getFacilityId( ) );
            SpiCoreQueryService query = facility.getCoreQueryService( );
            if ( query != null ) {
                cachedPris = query.getPartitionsInContainer( this.getCompoundClientSpec( ).getClientSpec( cri.getDataAreaDescriptor( ) ), cri );
            } else {
                cachedPris = Collections.emptyList( );
            }

            // inject OCL pri if CRI is MOF container
            if ( !this.getMoin( ).isSecondStageInjected( ) ) {
                if ( cri.getDataAreaDescriptor( ).isMetamodelDataArea( ) && cri.getContainerName( ).equals( MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME ) ) {
                    PRI oclPri = this.getMoin( ).createPri( MoinMofRomServicesImpl.OCL_PRI_STRING );
                    cachedPris.add( oclPri );
                }
            }

            // Store found partitions in cache
            getCachePartitionsInContainer( ).put( cri, cachedPris );
        }

        Collection<PRI> pris = new LinkedList<PRI>( );
        pris.addAll( cachedPris );

        // Mix-up the persisted state with the current "dirty state"
        Set<CoreConnection> connections = getConnections( );
        for ( CoreConnection connection : connections ) {
            // Check dircty partitions
            for ( ModelPartition dirtyPartition : connection.getPartitionsToBeSaved( ) ) {
                PRI dirtyPartitionPri = dirtyPartition.getPri( );
                if ( dirtyPartitionPri.getContainerName( ).equals( cri.getContainerName( ) ) ) {
                    // check if partition is to be deleted
                    if ( !dirtyPartition.isAlive( ) ) {
                        pris.remove( dirtyPartitionPri );
                    } else {
                        // check if partition is newly created, but not yet saved
                        if ( !cachedPris.contains( dirtyPartitionPri ) ) {
                            pris.add( dirtyPartitionPri );
                        }
                    }
                }
            }

            // Check NullPartition
            PRI nullPartitionPri = connection.getNullPartition( ).getPri( );
            if ( cri.equals( nullPartitionPri.getCri( ) ) ) {
                pris.add( nullPartitionPri );
            }
        }

        // Check volatile partitions
        if ( cri.isVolatileContainer( ) ) {
            Collection<CoreModelPartition> allTransientPartitions = getWorkspace( ).getPartitionManager( ).getAllTransientPartitions( );
            if ( allTransientPartitions != null ) {
                for ( CoreModelPartition coreModelPartition : allTransientPartitions ) {
                    pris.add( coreModelPartition.getPri( ) );
                }
            }
        }

        return Collections.unmodifiableCollection( pris );
    }

    public Collection<PRI> getOuterPartitions( CRI cri ) {

        // Mix-up the persisted state with the current "dirty state"
        List<PartitionOperation> dirtyPartitions = new LinkedList<PartitionOperation>( );
        Set<CoreConnection> connections = getConnections( );
        for ( CoreConnection connection : connections ) {
            for ( ModelPartition dirtyPartition : connection.getPartitionsToBeSaved( ) ) {
                PRI dirtyPartitionPri = dirtyPartition.getPri( );
                // check if partition is to be deleted
                if ( !dirtyPartition.isAlive( ) ) {
                    // Partition is not alive -> dirty deleted
                    dirtyPartitions.add( new PartitionOperation( PartitionOperation.Operation.DELETE, dirtyPartitionPri ) );
                } else {
                    if ( ( (CoreModelPartition) dirtyPartition ).isPersisted( ) ) {
                        // Partition is already there -> dirty editing
                        dirtyPartitions.add( new PartitionOperation( PartitionOperation.Operation.EDIT, dirtyPartitionPri ) );
                    } else {
                        // Partition is not persisted yet -> dirty create
                        dirtyPartitions.add( new PartitionOperation( PartitionOperation.Operation.CREATE, dirtyPartitionPri ) );
                    }
                }
            }
        }

        SpiFacility facility = (SpiFacility) getMoin( ).getFacilityById( cri.getDataAreaDescriptor( ).getFacilityId( ) );
        SpiLifecycleManagement lifecycleManagement = facility.getLifecycleManagement( );
        SpiClientSpec clientSpec = (SpiClientSpec) getCompoundClientSpec( ).getClientSpec( cri.getDataAreaDescriptor( ) );
        return lifecycleManagement.getOuterPartitions( clientSpec, cri, dirtyPartitions );
    }

    public Collection<CRI> getReferencedContainers( CRI cri ) {

        SpiFacility facility = (SpiFacility) getMoin( ).getFacilityById( cri.getDataAreaDescriptor( ).getFacilityId( ) );
        SpiLifecycleManagement lifecycleManagement = facility.getLifecycleManagement( );
        SpiClientSpec clientSpec = (SpiClientSpec) getCompoundClientSpec( ).getClientSpec( cri.getDataAreaDescriptor( ) );
        return lifecycleManagement.getVisibleContainers( clientSpec, cri );
    }

    public boolean hasCrossPartitionLinks( PRI priOne, PRI... otherPris ) {

        if ( otherPris == null || otherPris.length == 0 || priOne == null ) {
            return false;
        }

        // obtain all transient and dirty partitions
        Map<PRI, CoreModelPartition> transientAndDirtyPartitions = new HashMap<PRI, CoreModelPartition>( );
        for ( SpiModelPartition partition : getWorkspace( ).getPartitionManager( ).getLoadedPartitions( ) ) {
            PRI priOfPartition = partition.getPri( );
            if ( partition.isDirty( ) || priOfPartition.isVolatilePartition( ) ) {
                transientAndDirtyPartitions.put( priOfPartition, (CoreModelPartition) partition );
            }
        }

        // determine whether the one PRI is dirty or transient
        CoreModelPartition priOneAsPartition = transientAndDirtyPartitions.get( priOne );
        DataAreaDescriptor priOneDa = priOne.getDataAreaDescriptor( );
        SpiFacility facilityOne = (SpiFacility) getMoin( ).getFacilityById( priOneDa.getFacilityId( ) );
        SpiClientSpec[] allClientSpecs = getCompoundClientSpec( ).getClientSpecs( ).toArray( new SpiClientSpec[getCompoundClientSpec( ).getClientSpecs( ).size( )] );
        SpiClientSpec clientSpecOne = (SpiClientSpec) getCompoundClientSpec( ).getClientSpec( priOneDa );

        for ( PRI priTwo : otherPris ) {
            if ( priTwo == null || priOne.equals( priTwo ) ) {
                continue;
            }

            CoreModelPartition priTwoAsPartition = transientAndDirtyPartitions.get( priTwo );
            DataAreaDescriptor priTwoDa = priTwo.getDataAreaDescriptor( );
            SpiFacility facilityTwo = (SpiFacility) getMoin( ).getFacilityById( priTwoDa.getFacilityId( ) );
            SpiClientSpec clientSpecTwo = (SpiClientSpec) getCompoundClientSpec( ).getClientSpec( priTwoDa );


            // we need to separate the different use-cases
            if ( priOneAsPartition == null && priTwoAsPartition == null ) {
                // none of the partitions is dirty
                // -----------------------------------------------

                if ( facilityOne.equals( facilityTwo ) ) {
                    // if the facilities are different, we won't have a hit for these two PRIs
                    if ( facilityOne.getCoreQueryService( ).hasCrossPartitionLinks( clientSpecOne, priOne, clientSpecTwo, priTwo ) ) {
                        return true;
                    }
                }

            } else {
                if ( priOneAsPartition == null || priTwoAsPartition == null ) {
                    // one of the partitions is dirty
                    // ------------------------------

                    CoreModelPartition dirtyPartition = priOneAsPartition == null ? priTwoAsPartition : priOneAsPartition;
                    PRI nonDirtyPri = priOneAsPartition == null ? priOne : priTwo;

                    // first loop over the dirty partition's links and check if they are pointing to non-dirty PRI
                    Collection<SpiLink> links = dirtyPartition.getLinks( );
                    for ( SpiLink spiLink : links ) {
                        LRI lriOfLinkTarget = spiLink.getOtherEndLri( );
                        if ( allClientSpecs != null && allClientSpecs.length > 0 ) {
                            PRI priForLri = facilityOne.getCoreQueryService( ).getPriForLri( allClientSpecs, lriOfLinkTarget );
                            if ( priForLri != null && priForLri.equals( nonDirtyPri ) ) {
                                return true;
                            }
                        }
                    }

                    // Then loop over the dirty partition's elements and check if the Facility has cross-partition links pointing to them
                    Collection<Partitionable> elements = dirtyPartition.getElements( );
                    for ( Partitionable element : elements ) {
                        if ( facilityOne.getCoreQueryService( ).hasCrossPartitionLink( clientSpecOne, nonDirtyPri, element.get___Mri( ).getLri( ) ) ) {
                            return true;
                        }
                    }

                } else {
                    // both partitions are dirty
                    // -------------------------

                    if ( priOneAsPartition.hasLinksToPartition( priTwoAsPartition ) ) {
                        return true;
                    }

                    if ( priTwoAsPartition.hasLinksToPartition( priOneAsPartition ) ) {
                        return true;
                    }
                }
            }
        }

        // if we reach this point, there were no cross-partition links
        return false;
    }

    public boolean isContainerModifiable( CRI cri ) {

        String facilityId = cri.getDataAreaDescriptor( ).getFacilityId( );
        SpiFacility facility = (SpiFacility) getMoin( ).getFacilityById( facilityId );
        SpiClientSpec clientSpec = (SpiClientSpec) getCompoundClientSpec( ).getClientSpec( cri.getDataAreaDescriptor( ) );
        return facility.getLifecycleManagement( ).isContainerModifiable( cri, clientSpec );
    }

    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( ) {

        return workspaceSet.getCompoundClientSpecWorkspace( compoundClientSpec );
    }

    /**
     * Loads the partition with the specified PRI into the session's
     * SessionWorkspace, effectively creating a private copy for isolated
     * editing. Furthermore, this connection's wrapper caches need to be
     * updated.
     * <p>
     * Note that this method can safely be called multiple times for the same
     * PRI. If the PRI is already loaded in the SessionWorkspace from a previous
     * call, this connection's wrapper caches are not updated again.
     */
    public CoreModelPartition createPrivateCopyOfPartition( PRI pri ) {

        if ( !pri.isVolatilePartition( ) && !pri.isMetaModelPartition( ) ) {
            CorePartitionManager partitionManager = getWorkspace( ).getPartitionManager( );
            SynchronizationManager synchronizationManager = getWorkspaceSet( ).getSynchronizationManager( );
            synchronizationManager.acquireMicroWriteLock( );
            try {
                boolean wasLoaded = partitionManager.isPartitionLoaded( pri );
                CoreModelPartition partitionCopy = partitionManager.getPartition( this, pri, !wasLoaded /* loadMissing */);
                if ( partitionCopy != null ) {
                    if ( !wasLoaded ) {
                        updateWrapperCaches( pri, getWorkspace( ) );
                        getWorkspace( ).setHasPrivateCopies( true );
                        getCompoundClientSpecWorkspace( ).privateCopyAdded( pri );
                    }
                    return partitionCopy;
                } else {
                    if ( wasLoaded ) {
                        throw new MoinIllegalStateException( CoreImplMessages.PRIVATECOPYFAILURE );
                    }
                }


            } finally {
                synchronizationManager.releaseMicroWriteLock( );
            }
        }
        return null;
    }

    public void updateWrapperCaches( PRI pri, Workspace workspaceToHostTheReferencesAfterwards ) {

        synchronized ( this.wrapperCacheLock ) {
            for ( CoreConnection connection : getConnectionsInternal( ) ) {
                connection.updateWrapperCaches( pri, workspaceToHostTheReferencesAfterwards );
            }
        }
    }

}
