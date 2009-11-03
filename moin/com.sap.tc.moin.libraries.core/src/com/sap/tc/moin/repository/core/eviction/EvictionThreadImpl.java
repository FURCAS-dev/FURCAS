package com.sap.tc.moin.repository.core.eviction;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EvictionThread;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.jmx.EvictionMBean;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;

public final class EvictionThreadImpl extends Thread implements EvictionThread {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_EVICTION, EvictionThreadImpl.class );

    private static final long EVICTION_INTERVAL_DEFAULT = 10 * 1000;

    private static final long MAX_AGE_DEFAULT = 300 * 1000;

    private static final String THREAD_NAME = "EvictionThread"; //$NON-NLS-1$

    private final Object monitor = new Object( );

    /**
     * The maximum allowed age of a model partition in milliseconds. Objects
     * older than this are potential candidates for eviction.
     */
    private long maximumAge;

    /**
     * The wait interval between two eviction runs in milliseconds.
     */
    private long evictionInterval;

    /**
     * The set of participating partition managers.
     */
    private Set<CorePartitionManager> partitionManagers;

    /**
     * The {@link ObjectName} identifying our MBean in the MBeanServer.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer.
     */
    private JmxAdapter jmxAdapter;

    /**
     * Whether the eviction trace is currently enabled.
     */
    private boolean jmxNotificationsEnabled;

    /**
     * Whether the eviction was triggered by a timeout (false) or by an explicit
     * {@link #runEviction()} or {@link #runEviction(long)} call through JMX.
     */
    private volatile boolean evictionTriggeredExplicitly;

    /**
     * Indicates that the wait timer has to be reset. This has to be done if the
     * eviction interval was changed via {@link #setEvictionInterval(long)}.
     */
    private volatile boolean resetTimer;

    /**
     * Maximum age just used during one subsequent eviction run. This parameter
     * is set through JMX via the {@link EvictionMBean#runEviction(long)}
     * operation.
     */
    private volatile long temporaryMaximumAge;

    /**
     * The list of eviction candidates. The list is cleared at the beginning of
     * each eviction run in {@link #doEviction()}.
     */
    private List<CoreModelPartition> evictionCandidates;

    /**
     * The flag that gets set when the thread is requested to shut down.
     */
    private volatile boolean shutdownRequested = false;

    @SuppressWarnings( "unchecked" )
    public EvictionThreadImpl( String moinId, ReferenceQueue refQueue ) {

        super( THREAD_NAME + "-" + moinId ); //$NON-NLS-1$
        maximumAge = MAX_AGE_DEFAULT;
        temporaryMaximumAge = -1;
        evictionInterval = EVICTION_INTERVAL_DEFAULT;
        partitionManagers = new LinkedHashSet<CorePartitionManager>( );
        evictionCandidates = new ArrayList<CoreModelPartition>( );
        setPriority( Thread.MIN_PRIORITY );
        setDaemon( true );
        start( );
        if ( JMX_ENABLED ) {
            // Start our MBean.
            try {
                objectName = new ObjectName( MOIN_DOMAIN + "type=EvictionThread, moin=" + moinId ); //$NON-NLS-1$
            } catch ( MalformedObjectNameException e ) {
                throw new RuntimeException( e );
            }
            jmxAdapter = new JmxAdapter( this, objectName, refQueue );
        }
    }

    public synchronized void register( CorePartitionManager partitionManager ) {

        partitionManagers.add( partitionManager );
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "EvictionThread: Register partition manager for CompoundClientSpec " + ( (CompoundClientSpecWorkspace) partitionManager.getWorkspace( ) ).getCompoundClientSpec( ).toString( ) ); //$NON-NLS-1$
        }
    }

    public synchronized void unregister( CorePartitionManager partitionManager ) {

        partitionManagers.remove( partitionManager );
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "EvictionThread: Unregister partition manager for CompoundClientSpec " + ( (CompoundClientSpecWorkspace) partitionManager.getWorkspace( ) ).getCompoundClientSpec( ).toString( ) ); //$NON-NLS-1$
        }
    }

    public synchronized void setJmxTraceEnabled( boolean enabled ) {

        jmxNotificationsEnabled = enabled;
    }

    public synchronized boolean isJmxTraceEnabled( ) {

        return jmxNotificationsEnabled;
    }

    public synchronized long getEvictionInterval( ) {

        return evictionInterval;
    }

    public synchronized long getMaximumAge( ) {

        return maximumAge;
    }

    public synchronized void setEvictionInterval( long evictionInterval ) {

        if ( evictionInterval < 0 ) {
            throw new MoinIllegalArgumentException( CoreEvictionMessages.EVICTIONINTERVALMUSTNOTBENEGATIVE, evictionInterval );
        }
        if ( evictionInterval != this.evictionInterval ) {
            this.evictionInterval = evictionInterval;
            // Wake up the eviction thread to trigger a new wait() with the new timeOut parameter. 
            // Note that this does NOT trigger an eviction, but only resets the timer.
            resetTimer = true;
            synchronized ( monitor ) {
                monitor.notify( );
            }
        }
    }

    public synchronized void setMaximumAge( long maximumAge ) {

        if ( maximumAge <= 0 ) {
            throw new MoinIllegalArgumentException( CoreEvictionMessages.MAXIMUMAGECANNOTBENEGATIVEORZERO );
        }
        this.maximumAge = maximumAge;
    }

    @Override
    public void run( ) {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "The MOIN partition eviction thread started." ); //$NON-NLS-1$
        }
        while ( true ) {
            try {
                long waitStart = 0;
                synchronized ( monitor ) {
                    if ( this.shutdownRequested ) {
                        break;
                    }
                    waitStart = System.currentTimeMillis( );
                    monitor.wait( evictionInterval );
                    if ( this.shutdownRequested ) {
                        break;
                    }
                }
                // If we are here, we were woken up. Check if we were not accidentally woken up by someone unexpected.
                if ( resetTimer ) {
                    // The 'evictionInterval' parameter was changed. Do not run an eviction!
                    resetTimer = false;
                } else {
                    // Only run an eviction if either 'evictionInterval' milliseconds have passed, or the eviction was triggered explicitly.
                    if ( evictionTriggeredExplicitly || ( System.currentTimeMillis( ) - waitStart ) >= evictionInterval ) {
                        doEviction( );
                    }
                }
            } catch ( InterruptedException e ) { // $JL-EXC$
            } catch ( Throwable t ) {
                logger.trace( t, MoinSeverity.ERROR, "Eviction thread encountered unexpected exception", new Object[] {} ); //$NON-NLS-1$
            }
        }
    }

    public void requestShutdown( ) {

        synchronized ( monitor ) {
            this.shutdownRequested = true;
            monitor.notify( );
        }
        if ( JMX_ENABLED ) {
            SpiJmxHelper.unregisterMBean( this.objectName );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.eviction.EvictionThrea#runEviction()
     */
    public void runEviction( ) {

        synchronized ( monitor ) {
            evictionTriggeredExplicitly = true;
            monitor.notify( );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.core.eviction.EvictionThrea#runEviction(long)
     */
    public void runEviction( long maxAge ) {

        if ( maxAge <= 0 ) {
            throw new MoinIllegalArgumentException( CoreEvictionMessages.MAXIMUMAGECANNOTBENEGATIVEORZERO );
        }
        synchronized ( monitor ) {
            evictionTriggeredExplicitly = true;
            temporaryMaximumAge = maxAge;
            monitor.notify( );
        }
    }

    @SuppressWarnings( { "null", "unchecked" } )
    private void doEviction( ) {

        long evictionStart = System.currentTimeMillis( );
        List<EvictionInfo> partitionsEvicted = null;
        evictionCandidates.clear( );
        try {
            // Search for eviction candidates.
            synchronized ( this ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Start determining eviction candidates." ); //$NON-NLS-1$
                }
                // Has to be synchronized as otherwise a ConcurrentModificationException can occur when, while looping 
                // over partitionManagers, a register() or unregister() call happens.
                for ( CorePartitionManager partitionManager : partitionManagers ) {
                    Collection<CoreModelPartition> loadedPartitions = (Collection<CoreModelPartition>) partitionManager.getLoadedPartitions( );
                    for ( CoreModelPartition partition : loadedPartitions ) {
                        if ( isCandidate( evictionStart, partitionManager, partition, false /* checkConsistency */) ) {
                            evictionCandidates.add( partition );
                            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                                logger.trace( MoinSeverity.DEBUG, "   - Eviction candidate: " + partition ); //$NON-NLS-1$
                            }
                        }
                    }
                }
            }
            if ( !evictionCandidates.isEmpty( ) ) {
                if ( JMX_ENABLED && jmxNotificationsEnabled ) {
                    partitionsEvicted = new ArrayList<EvictionInfo>( evictionCandidates.size( ) );
                }
                for ( int i = 0, n = evictionCandidates.size( ); i < n; i++ ) {
                    CoreModelPartition partitionToEvict = evictionCandidates.get( i );
                    CorePartitionManager partitionManager = partitionToEvict.getWorkspace( ).getPartitionManager( );
                    SynchronizationManager syncManager = partitionToEvict.getWorkspace( ).getWorkspaceSet( ).getSynchronizationManager( );
                    // Make sure that no one is modifying the repository.
                    synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {
                        // Now make sure that no one is reading.
                        syncManager.acquireMicroWriteLock( );
                        try {
                            // Check whether after obtaining the locks the partition is still evictable.
                            if ( isCandidate( evictionStart, partitionManager, partitionToEvict, true /* checkConsistency */) ) {
                                if ( JMX_ENABLED && jmxNotificationsEnabled ) {
                                    // Collect additional info about the partition.
                                    PRI pri = partitionToEvict.getPri( );
                                    String sessionId = null;
                                    Workspace workspace = partitionToEvict.getWorkspace( );
                                    int elements = partitionToEvict.getElements( ).size( );
                                    int links = partitionToEvict.getLinks( ).size( );
                                    partitionsEvicted.add( new EvictionInfo( pri, sessionId, elements, links ) );
                                }
                                // Perform the actual eviction.
                                partitionManager.evictPartition( partitionToEvict );
                            }
                        } finally {
                            syncManager.releaseMicroWriteLock( );
                        }
                    }
                }
            }
            if ( JMX_ENABLED && jmxNotificationsEnabled && partitionsEvicted != null && partitionsEvicted.size( ) > 0 ) {
                long duration = ( System.currentTimeMillis( ) - evictionStart );
                tracePartitionsEvicted( partitionsEvicted.toArray( new EvictionInfo[partitionsEvicted.size( )] ), evictionTriggeredExplicitly, duration );
            }
        } finally {
            evictionTriggeredExplicitly = false;
            temporaryMaximumAge = -1;
        }
    }

    /**
     * Returns whether the given model partition is a candidate for eviction.
     */
    private boolean isCandidate( long currentTime, CorePartitionManager partitionManager, CoreModelPartition partition, boolean checkConsistency ) {

        long maxAge = ( temporaryMaximumAge == -1 ? maximumAge : temporaryMaximumAge );
        boolean result = !partition.isEmpty( ) && partitionManager.canEvict( partition ) && ( currentTime - partition.getEvictionTimestamp( ) > maxAge );
        if ( checkConsistency ) {
            return result && !isInconsistent( partition );
        }
        if ( result ) {
            Workspace workspace = partitionManager.getWorkspace( );
            if ( workspace instanceof CompoundClientSpecWorkspace ) {
                if ( ( (CompoundClientSpecWorkspace) workspace ).privateCopyExists( partition.getPri( ) ) ) {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * Checks if the given partition is inconsistent. Partitions with
     * inconsistencies must not be evicted.
     */
    private boolean isInconsistent( CoreModelPartition partition ) {

        Collection<CoreSession> sessions = partition.getWorkspace( ).getWorkspaceSet( ).getSessions( );
        for ( CoreSession coreSession : sessions ) {
            if ( coreSession.getConsistencyViolationRegistry( ).isPartitionInconsistent( partition.getPri( ) ) ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Partition " + partition.getPri( ) + " must not be evicted because it is inconsistent." ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the {@link ObjectName} uniquely identifying our MBean on the
     * MBeanServer.
     */
    public ObjectName getObjectName( ) {

        return objectName;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.core.eviction.EvictionThrea#tracePartitionsEvicted
     * (
     * com.sap.tc.moin.repository.core.eviction.EvictionThreadImpl.EvictionInfo[
     * ], boolean, long)
     */
    public void tracePartitionsEvicted( EvictionInfo[] partitionsEvicted, boolean triggeredExplicitly, long duration ) {

        if ( jmxAdapter != null ) {
            jmxAdapter.partitionsEvicted( partitionsEvicted, triggeredExplicitly, duration );
        }
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.core.eviction.EvictionThrea#
     * traceEvictPartitionStart(com.sap.tc.moin.repository.PRI,
     * java.lang.String, java.lang.StackTraceElement[])
     */
    public void traceEvictPartitionStart( PRI pri, String sessionId, StackTraceElement[] stackTrace ) {

        if ( jmxAdapter != null ) {
            jmxAdapter.evictPartitionStart( pri, sessionId, stackTrace );
        }

    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.core.eviction.EvictionThrea#traceEvictPartitionEnd
     * (com.sap.tc.moin.repository.PRI, java.lang.String, int, int, long)
     */
    public void traceEvictPartitionEnd( PRI pri, String sessionId, int elements, int links, long duration ) {

        if ( jmxAdapter != null ) {
            jmxAdapter.evictPartitionEnd( pri, sessionId, elements, links, duration );
        }
    }

    /**
     * The class implementing the MBean.
     */
    private static final class JmxAdapter extends NotificationBroadcasterSupport implements EvictionMBean {

        private final WeakReferenceWithObjectName<EvictionThread> evictionThreadRef;

        /**
         * The object name uniquely identifying this MBean on the MBeanServer.
         */
        private final ObjectName objectName;

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        @SuppressWarnings( "unchecked" )
        JmxAdapter( EvictionThread evictionThread, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            this.evictionThreadRef = new WeakReferenceWithObjectName<EvictionThread>( evictionThread, objectName, refQueue );
            registerBroadcastingMBean( this, EvictionMBean.class, objectName );
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( EvictionMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by an Eviction MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public void startNotifications( ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                evictionThread.setJmxTraceEnabled( true );
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                return evictionThread.isJmxTraceEnabled( );
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                evictionThread.setJmxTraceEnabled( false );
            }
        }

        public void runEviction( ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                evictionThread.runEviction( );
            }
        }

        public void runEviction( long maximumAge ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                evictionThread.runEviction( maximumAge );
            }
        }

        public void partitionsEvicted( EvictionInfo[] partitionsEvicted, boolean evictionTriggeredExplicitly, long duration ) {

            StringBuilder message = new StringBuilder( );
            for ( int i = 0, n = partitionsEvicted.length; i < n; i++ ) {
                EvictionInfo info = partitionsEvicted[i];
                message.append( info.pri.toString( ) );
                if ( info.sessionId != null ) {
                    message.append( " (Session: " ).append( info.sessionId ).append( ", " ); //$NON-NLS-1$ //$NON-NLS-2$
                } else {
                    message.append( " (" ); //$NON-NLS-1$
                }
                message.append( "Elements: " ).append( info.elements ).append( ", Links: " ).append( info.links ).append( ")" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
                if ( i < n - 1 ) {
                    message.append( "\n" ); //$NON-NLS-1$
                }
            }
            Notification notification = new Notification( EvictionMBean.PARTITIONS_EVICTED, objectName, seqNo.incrementAndGet( ), message.toString( ) );
            String userData = "Evicted=" + partitionsEvicted.length + ",Trigger=" + ( evictionTriggeredExplicitly ? "Explicit" : "TimeOut" ) + ",Time=" + String.valueOf( duration ) + "ms"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
            notification.setUserData( userData );
            sendNotification( notification );
        }

        public void evictPartitionStart( PRI pri, String sessionId, StackTraceElement[] stackTrace ) {

            String message = null;
            if ( sessionId != null ) {
                message = pri.toString( ) + " (Session: " + sessionId + ")"; //$NON-NLS-1$//$NON-NLS-2$
            } else {
                message = pri.toString( );
            }
            Notification notification = new Notification( EvictionMBean.EVICT_PARTITION_START, objectName, seqNo.incrementAndGet( ), message );
            notification.setUserData( stackTrace );
            sendNotification( notification );
        }

        public void evictPartitionEnd( PRI pri, String sessionId, int elements, int links, long duration ) {

            String message = null;
            if ( sessionId != null ) {
                message = pri.toString( ) + " (Session: " + sessionId + ")"; //$NON-NLS-1$//$NON-NLS-2$
            } else {
                message = pri.toString( );
            }
            Notification notification = new Notification( EvictionMBean.EVICT_PARTITION_END, objectName, seqNo.incrementAndGet( ), message );
            String userData = "Time=" + duration + "ms,Elements=" + elements + ",Links=" + links; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            notification.setUserData( userData );
            sendNotification( notification );
        }

        public long getEvictionInterval( ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                return evictionThread.getEvictionInterval( );
            }
            return -1;
        }

        public void setEvictionInterval( long evictionInterval ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                evictionThread.setEvictionInterval( evictionInterval );
            }
        }

        public long getMaximumAge( ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                return evictionThread.getMaximumAge( );
            }
            return -1;
        }

        public void setMaximumAge( long maximumAge ) throws IOException {

            EvictionThread evictionThread = evictionThreadRef.get( );
            if ( evictionThread != null ) {
                evictionThread.setMaximumAge( maximumAge );
            }
        }
    }
}
