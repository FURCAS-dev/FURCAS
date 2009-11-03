package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.PartitionsSaveRecord;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmx.LockingMBean;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.facility.SpiExternalSaveLocking;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;

public final class SynchronizationManagerImpl implements SynchronizationManager {

    /**
     * Only if the following system property is set and in addition the VM
     * parameter "-ea" is specified, we are checking whether the big write lock
     * is being held during a call to {@link #acquireMicroWriteLock()}.
     */
    private static final boolean CHECK_LOCK_HOLDING = initializeCheckLockHolding( );

    private Map<Thread, Integer> readLockHolders = CHECK_LOCK_HOLDING ? new HashMap<Thread, Integer>( ) : null;

    private final Object bigWriteLock;

    private final Object saveLock;

    private final ReadLock readLock;

    private final WriteLock writeLock;

    private final ReentrantReadWriteLock readWriteLock;

    /**
     * Whether each locking operation should be translated into a corresponding
     * JMX notification.
     */
    volatile boolean jmxNotificationsEnabled = false;

    /**
     * The name identifying this SynchronizationManager in JMX.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer. We need it
     * for the translation of locking operations to JMX notifications.
     */
    private JmxAdapter jmxAdapter;

    SynchronizationManagerImpl( WorkspaceSetImpl workspaceSet ) {

        // Currently we use the WorkspaceSet as locking granularity, therefore
        // use this instance of SynchonizationManager (which belongs to exactly
        // one WorkspaceSet) as synchronization object.
        bigWriteLock = this;
        saveLock = new Object( );
        readWriteLock = new ReentrantReadWriteLock( );
        readLock = readWriteLock.readLock( );
        writeLock = readWriteLock.writeLock( );

        if ( JMX_ENABLED ) {
            try {
                objectName = new ObjectName( MOIN_DOMAIN + "type=Locking,moin=" + workspaceSet.getMoin( ).getId( ) + ",compoundDataArea=" + workspaceSet.getCompoundDataArea( ).getName( ) ); //$NON-NLS-1$ //$NON-NLS-2$
                jmxAdapter = new JmxAdapter( this, objectName, workspaceSet.getMoin( ).getReferenceQueue( ) );
            } catch ( MalformedObjectNameException e ) {
                throw new RuntimeException( e );
            } catch ( NullPointerException e ) {
                throw new RuntimeException( e );
            }
        }
    }

    private static final boolean initializeCheckLockHolding( ) {

        boolean flag = Boolean.getBoolean( "com.sap.tc.moin.checkLockHolding" );//$NON-NLS-1$
        boolean ea = false;
        //don't try this at home, kids! But there is no proper API for that :-( 
        //it is not really necessary, but it is fun :-)
        try {
            assert 0 == 1;
        } catch ( AssertionError e ) {
            ea = true;
        }
        return flag && ea;
    }

    public final boolean checkLockHolding( ) {

        return CHECK_LOCK_HOLDING;
    }


    public Object getProhibitWriteSyncObject( ) {

        return bigWriteLock;
    }

    public Object getProhibitSaveSyncObject( ) {

        return saveLock;
    }

    public void acquireReadLock( ) {

        readLock.lock( );
        if ( CHECK_LOCK_HOLDING ) {
            incrementReadLockHolders( );
        }
        if ( JMX_ENABLED && jmxNotificationsEnabled ) {
            jmxAdapter.sendNotification( LockingMBean.READ_LOCK_OBTAINED, Thread.currentThread( ).getStackTrace( ) );
        }
    }

    public void releaseReadLock( ) {

        readLock.unlock( );

        if ( CHECK_LOCK_HOLDING ) {
            decrementReadLockHolders( );
        }
        if ( JMX_ENABLED && jmxNotificationsEnabled ) {
            jmxAdapter.sendNotification( LockingMBean.READ_LOCK_RELEASED, Thread.currentThread( ).getStackTrace( ) );
        }

    }

    //for monitoring or debugging purposes only!!!
    private final void incrementReadLockHolders( ) {

        synchronized ( this.readLockHolders ) {
            Thread currentThread = Thread.currentThread( );
            Integer count = this.readLockHolders.get( currentThread );
            if ( count == null ) {
                count = 1;
                this.readLockHolders.put( currentThread, count );
            } else {
                this.readLockHolders.put( currentThread, count + 1 );
            }

        }
    }

    //for monitoring or debugging purposes only!!!
    private final void decrementReadLockHolders( ) {

        synchronized ( this.readLockHolders ) {
            Thread currentThread = Thread.currentThread( );
            Integer count = this.readLockHolders.get( currentThread );
            if ( count != null ) {
                if ( count.intValue( ) == 1 ) {
                    this.readLockHolders.remove( currentThread );
                } else {
                    this.readLockHolders.put( currentThread, count - 1 );
                }
            }

        }

    }

    public Map<SpiFacility, Object> acquireFacilityLocks( Map<SpiFacility, PartitionsSaveRecord> facilityToPartitionOperations ) {

        Map<SpiFacility, Object> facilityLocks = new HashMap<SpiFacility, Object>( );

        for ( Entry<SpiFacility, PartitionsSaveRecord> facility : facilityToPartitionOperations.entrySet( ) ) {
            facilityLocks.put( facility.getKey( ), null );
        }

        for ( ; !doFacilityLocks( facilityLocks, facilityToPartitionOperations ); ) {
            try {
                Thread.sleep( (long) ( 100 * Math.random( ) ) );
            } catch ( InterruptedException e ) {
                //$JL-EXC$
                // do nothing here
            }
        }

        if ( JMX_ENABLED && jmxNotificationsEnabled ) {
            jmxAdapter.sendNotification( LockingMBean.FACILITIES_LOCK_OBTAINED, Thread.currentThread( ).getStackTrace( ) );
        }

        return facilityLocks;
    }

    private boolean doFacilityLocks( Map<SpiFacility, Object> facilityLocks, Map<SpiFacility, PartitionsSaveRecord> facilityToPartitionOperations ) {

        Queue<Map.Entry<SpiFacility, Object>> unlockingQueue = new LinkedList<Map.Entry<SpiFacility, Object>>( );

        for ( Map.Entry<SpiFacility, Object> currentPart : facilityLocks.entrySet( ) ) {
            PartitionsSaveRecord partitionsToBeHandled = facilityToPartitionOperations.get( currentPart.getKey( ) );

            SpiExternalSaveLocking externalSaveLocking = currentPart.getKey( ).getExternalSaveLocking( );

            if ( externalSaveLocking != null ) {
                Object lockHandle = externalSaveLocking.acquireLock( partitionsToBeHandled.getPrisOfEditedPartitions( ), partitionsToBeHandled.getPrisOfCreatedPartitions( ), partitionsToBeHandled.getPrisOfDeletedPartitions( ) );
                if ( lockHandle != null ) {
                    unlockingQueue.add( currentPart );
                    currentPart.setValue( lockHandle );
                } else {

                    for ( Map.Entry<SpiFacility, Object> unlockPart = unlockingQueue.poll( ); unlockPart != null; unlockPart = unlockingQueue.poll( ) ) {
                        unlockPart.getKey( ).getExternalSaveLocking( ).releaseLock( unlockPart.getValue( ) );
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public void releaseFacilityLocks( Map<SpiFacility, Object> lockHandle ) {

        if ( lockHandle != null ) {
            for ( Map.Entry<SpiFacility, Object> part : lockHandle.entrySet( ) ) {
                SpiExternalSaveLocking externalSaveLocking = part.getKey( ).getExternalSaveLocking( );

                if ( externalSaveLocking != null ) {
                    externalSaveLocking.releaseLock( part.getValue( ) );
                }
            }
        } else {
            throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.INVALIDLOCKHANDLE );
        }

        if ( JMX_ENABLED && jmxNotificationsEnabled ) {
            jmxAdapter.sendNotification( LockingMBean.FACILITIES_LOCK_RELEASED, Thread.currentThread( ).getStackTrace( ) );
        }
    }

    /**
     * Checks whether the big write lock is currently held. This is a
     * prerequisite for obtaining the micro write lock.
     */
    private boolean holdsBigWriteLock( ) {

        if ( CHECK_LOCK_HOLDING ) {
            return Thread.holdsLock( bigWriteLock );
        }
        return true;
    }

    public void acquireMicroWriteLock( ) {

        assert holdsBigWriteLock( ) : "Thread tries to write without having acquired the big write lock"; //$NON-NLS-1$
        writeLock.lock( );
        if ( JMX_ENABLED && jmxNotificationsEnabled ) {
            jmxAdapter.sendNotification( LockingMBean.WRITE_LOCK_OBTAINED, Thread.currentThread( ).getStackTrace( ) );
        }
    }

    public void releaseMicroWriteLock( ) {

        writeLock.unlock( );
        if ( JMX_ENABLED && jmxNotificationsEnabled ) {
            jmxAdapter.sendNotification( LockingMBean.WRITE_LOCK_RELEASED, Thread.currentThread( ).getStackTrace( ) );
        }
    }



    public boolean isLockHeldByCurrentThread( ) {

        if ( CHECK_LOCK_HOLDING ) {
            boolean holdsWriteLock = this.writeLock.isHeldByCurrentThread( );
            boolean holdsReadLock = this.readLockHolders.containsKey( Thread.currentThread( ) );
            boolean holdsBigWriteLock = holdsBigWriteLock( );
            return holdsWriteLock || holdsReadLock || holdsBigWriteLock;
        }
        throw new IllegalStateException( "Method must only be called if vm parameter com.sap.tc.moin.checkLockHolding is set to true" ); //$NON-NLS-1$
    }


    public void partitionLockObtain( PRI pri, ConnectionImpl connection, boolean coreLock, StackTraceElement[] stackTrace, long duration ) {

        if ( jmxNotificationsEnabled ) {
            jmxAdapter.sendPartitionLockNotification( LockingMBean.PARTITION_LOCK_OBTAINED, pri, connection, coreLock, stackTrace, duration );
        }
    }

    public void partitionLockRelease( PRI pri, ConnectionImpl connection, boolean coreLock, StackTraceElement[] stackTrace, long duration ) {

        if ( jmxNotificationsEnabled ) {
            jmxAdapter.sendPartitionLockNotification( LockingMBean.PARTITION_LOCK_RELEASED, pri, connection, coreLock, stackTrace, duration );
        }
    }

    public ObjectName getObjectName( ) {

        return objectName;
    }

    private static final class JmxAdapter extends NotificationBroadcasterSupport implements LockingMBean {

        private final WeakReferenceWithObjectName<SynchronizationManagerImpl> synchronizationManagerRef;

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        private final ObjectName objectName;

        JmxAdapter( SynchronizationManagerImpl synchronizationManager, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            this.synchronizationManagerRef = new WeakReferenceWithObjectName<SynchronizationManagerImpl>( synchronizationManager, objectName, refQueue );
            registerBroadcastingMBean( this, LockingMBean.class, objectName );
        }

        public void sendNotification( String notificationType, StackTraceElement[] stackTrace ) {

            Thread thread = Thread.currentThread( );
            String message = "Thread=" + thread.getName( ) + ",Id=" + thread.getId( ) + ",Group=" + thread.getThreadGroup( ).getName( ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            Notification notification = new Notification( notificationType, objectName, seqNo.incrementAndGet( ), message );
            notification.setUserData( stackTrace );
            sendNotification( notification );
        }

        public void sendPartitionLockNotification( String notificationType, PRI pri, ConnectionImpl connection, boolean coreLock, StackTraceElement[] stackTrace, long duration ) {

            StringBuilder message = new StringBuilder( );
            if ( duration > 0 ) {
                message.append( "Time=" + duration ).append( duration ).append( "ms," ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            message.append( "PRI=" ).append( pri ).append( ",Conn=" ).append( connection.toString( ) ).append( ",CoreLock=" ).append( coreLock ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            Notification notification = new Notification( notificationType, objectName, seqNo.incrementAndGet( ), message.toString( ) );
            notification.setUserData( stackTrace );
            sendNotification( notification );
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( LockingMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by a Locking MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public void startNotifications( ) throws IOException {

            SynchronizationManagerImpl synchronizationManager = synchronizationManagerRef.get( );
            if ( synchronizationManager != null ) {
                synchronizationManager.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            SynchronizationManagerImpl synchronizationManager = synchronizationManagerRef.get( );
            if ( synchronizationManager != null ) {
                return synchronizationManager.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            SynchronizationManagerImpl synchronizationManager = synchronizationManagerRef.get( );
            if ( synchronizationManager != null ) {
                synchronizationManager.jmxNotificationsEnabled = false;
            }
        }
    }

}
