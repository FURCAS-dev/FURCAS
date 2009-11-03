package com.sap.tc.moin.repository.core.locking;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreLockManager;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.LockManagerWrapper;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.impl.ConnectionImpl;
import com.sap.tc.moin.repository.core.impl.WorkspaceSetImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.Notifyee;
import com.sap.tc.moin.repository.shared.util.NotifyingWeakHashMap;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiInternalDistributedDirtyLocking;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObtainTransientLockMicroTransactionable;

/**
 * Common implementation of both the {@link PartitionLockManager} and
 * {@link CoreLockManager} interfaces
 * <p>
 * This class is capable of doing pure memory locking which it implements itself
 * or it delegates the locking to a facility specific implementation if
 * existing. In the latter case it then acts as an in-memory cache for fast
 * access when called repeatedly, especially
 * {@link #obtainApplicationLock(PRI, Connection)} or
 * {@link #obtainLock(PRI, Object)}. If no facility locking is available, the
 * locking is done in memory only.
 * 
 * @author d032153, d044711
 */
public final class PartitionLockManagerImpl implements PartitionLockManager, CoreLockManager, Notifyee {

    /**
     * The logger for this class.
     */
    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_LOCKING, PartitionLockManagerImpl.class );

    /**
     * Actual storage of the in-memory locks.
     */
    private PartitionLockManagerStore<PRI> store = null;

    /**
     * Each lock owner (which is in general an object and in particular or many
     * cases in moin context a connection) is assigned to a unique technical
     * lock owner of type TechLockOwner. That is done in order to avoid that the
     * {@link PartitionLockManagerStore in-memory lock store} or the
     * {@link SpiInternalDistributedDirtyLocking} has to take care not to hold a
     * strong reference to the owner of a lock.<br>
     * The technical lock owner is stored as value of the lock owner (which is
     * the key) in a {@link NotifyingWeakHashMap} because we don't want to
     * prevent the lock owner from being garbage collected.
     */
    private NotifyingWeakHashMap<Object, TechLockOwner> lockOwner2TechLockOwner;

    /**
     * Each lock owner (which is in general an object and in particular or many
     * cases in moin context a connection) is assigned to a unique technical
     * lock owner of type TechLockOwner. <br>
     * The lock owner is stored as a weak referenced value of the technical lock
     * owner (which is the key) because we don't want to prevent the owner from
     * being garbage collected. This "backward" mapping is needed for the
     * {@link #getLockOwner(SpiResourceInfo)} and
     * {@link #getApplicationLockOwner(MRI, Connection)} methods.
     * 
     * @see #lockOwner2TechLockOwner
     */
    private HashMap<TechLockOwner, WeakReference> techLockOwner2LockOwner;

    /**
     * The data area this partition lock manager instance is responsible for.
     * The {@link LockManagerRegistry} takes care, that there is only one
     * instance of this class per data area.
     */
    private DataArea dataArea;

    /**
     * The specific locking of the facility responsible for the
     * {@link #dataArea} of this instance. Is it not guaranteed that every
     * facility has its own locking implementation, therefore it might be
     * <code>null</code>.
     */
    private SpiInternalDistributedDirtyLocking facilityLocking;

    private final LockManagerWrapper wrapper;

    private WorkspaceSet workspaceSet;

    /**
     * Is package-private as only {@link LockManagerRegistry} should instantiate
     * this class.
     * 
     * @param pDataArea the data area this particular instance is working on.
     */
    PartitionLockManagerImpl( DataArea pDataArea, WorkspaceSet workspaceSet ) {

        checkParameterIsNotNull( workspaceSet );
        checkParameterIsNotNull( pDataArea );

        this.workspaceSet = workspaceSet;
        this.dataArea = pDataArea;
        this.store = new PartitionLockManagerStore<PRI>( );
        this.lockOwner2TechLockOwner = new NotifyingWeakHashMap<Object, TechLockOwner>( workspaceSet.getMoin( ).getReferenceQueue( ) );
        this.techLockOwner2LockOwner = new HashMap<TechLockOwner, WeakReference>( );

        SpiFacility coreFacility = (SpiFacility) this.dataArea.getFacility( );
        if ( coreFacility != null ) {
            // keep a reference to the facility locking, might also be null if
            // the facility doesn't have a specific
            // locking implementation
            this.facilityLocking = coreFacility.getInternalDistributedDirtyLocking( this.dataArea );
        }
        this.wrapper = new LockManagerWrapper( this, workspaceSet );
    }

    public boolean isLockedByConnection( PRI pri, Connection connection ) {

        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( connection );
        Object lockOwner = this.getLockOwnerInternal( pri );
        if ( lockOwner == null || !connection.equals( lockOwner ) ) {
            return false;
        }
        return true;

    }

    public Connection getLockOwner( PRI pri ) {

        checkParameterIsNotNull( pri );

        return (Connection) this.getLockOwnerInternal( pri );

    }

    public Collection<PRI> getLockedResources( Object owner ) {

        checkParameterIsNotNull( owner );
        TechLockOwner techLockOwner = this.lockOwner2TechLockOwner.get( owner );
        if ( techLockOwner == null ) {
            return Collections.emptyList( );
        }

        Collection<PRI> result = null;

        if ( this.facilityLocking != null ) {
            result = this.facilityLocking.getLockedResources( techLockOwner );
        } else {
            result = this.store.getLockedResources( techLockOwner );
        }

        if ( result == null ) {
            result = Collections.emptyList( );
        }

        return result;
    }

    public Collection<PRI> getLockedPartitions( Connection owner ) {

        checkParameterIsNotNull( owner );

        return this.getLockedResources( owner );
    }

    public void obtainTransientLock( PRI pri, Connection owner ) throws LockingException {

        CoreConnection coreConnection = ( (CoreConnection) owner );
        CoreSession session = coreConnection.getSession( );
        TransactionManager transactionManager = session.getTransactionManager( );
        MicroTransactionableFactory microTxFactory = session.getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
        ObtainTransientLockMicroTransactionable lockMicroTransactionable = microTxFactory.createObtainTransientLockMicroTransactionable( coreConnection, pri, owner );
        transactionManager.runInMicroTransaction( lockMicroTransactionable );
    }

    /**
     * Implementation of {@link PartitionLockManager#checkLock(PRI, Object)}.
     * <p>
     * In case a facility locking is defined for the passed resource, the lock
     * is always checked at the facility directly. Otherwise the memory locking
     * is used to check if the passed resource is locked by the passed owner.
     */
    public synchronized void checkLock( PRI pri, Object pOwner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pOwner );
        checkParameterIsNotNull( pri );
        checkResourceInfoCompatibility( pri );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.CHECKINGLOCKFORCORE, pri, pOwner );
        }

        // delegate to the actual implementation
        checkLockInternal( pri, pOwner );
    }

    /**
     * Implementation of
     * {@link LockManager#checkApplicationLock(PRI, Connection)}.
     * <p>
     * In case a facility locking is defined for the resource represented by the
     * passed MRI, the lock is always checked at the facility directly.
     * Otherwise the memory locking is used to check if the passed resource is
     * locked by the passed owner.
     */
    public synchronized void checkApplicationLock( PRI pri, Connection pOwner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( pOwner );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.CHECKINGLOCKFORAPP, pri, pOwner );
        }

        // delegate to the actual implementation
        checkLockInternal( pri, pOwner );
    }

    /**
     * Common implementation for both
     * {@link #checkApplicationLock(MRI, Connection)} and
     * {@link #checkLock(SpiResourceInfo, Object)}.
     * <p>
     * This method does not validate the supplied parameters (e.g. if
     * <code>null</code>), the calling methods are supposed to take care of
     * that. If there is a facility locking existing, this method delegates to
     * that locking implementation, otherwise the memory locking is used.
     * 
     * @param pri the resource which is to be locked.
     * @param pOwner the owner of the lock.
     */
    private void checkLockInternal( PRI pri, Object pOwner ) throws LockingException {

        TechLockOwner techLockOwner = this.getOrCreateTechLockOwner( pOwner );
        try {
            if ( this.facilityLocking != null ) {
                this.facilityLocking.checkLock( pri, techLockOwner );
            } else {
                boolean isLocked = this.store.checkLock( pri, techLockOwner );
                if ( !isLocked ) {// not locked by anybody
                    if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                        logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.CHECKLOCKFAILEDNOLOCK, pri, pOwner );
                    }
                    throw new LockingException( CoreLockingMessages.NOLOCKFORRESOURCE, pri );
                }
            }
        } catch ( LockedException e ) {
            handleLockedException( e, pOwner, pri );
        }
    }


    private synchronized Connection getApplicationLockOwner( PRI pri, Connection connection ) throws LockingException {

        // input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( connection );

        // delegate to the actual implementation
        Object lockOwner = getLockOwnerInternal( pri );

        if ( lockOwner == null ) {
            // the resource was not locked
            return null;
        }

        if ( lockOwner instanceof Connection ) {
            return (Connection) ( lockOwner );
        }
        if ( logger.isTraced( MoinSeverity.ERROR ) ) {
            logger.trace( MoinSeverity.ERROR, CoreLockingTraces.LOCKOWNERNOTCONNECTION, lockOwner.getClass( ).getName( ) );
        }
        throw new LockingException( CoreLockingMessages.LOCKOWNERNOTCONNECTION );

    }

    private Object getLockOwnerInternal( PRI pri ) throws LockingException {

        TechLockOwner techLockOwner = null;
        if ( this.facilityLocking != null ) {
            techLockOwner = (TechLockOwner) this.facilityLocking.getLockOwner( pri );
        } else {
            techLockOwner = (TechLockOwner) this.store.getLockOwner( pri );
        }
        if ( techLockOwner == null ) {
            // the resource was not locked
            return null;
        }
        Object lockOwner = getOriginalOwner( techLockOwner );
        if ( lockOwner == null ) {
            throw new LockingException( CoreLockingMessages.OWNERGARBAGECOLLECTED );
        }
        return lockOwner;

    }

    /**
     * Gets the corresponding owner to a
     * {@link #getOrCreateTechLockOwner(Object) technical lock owner}.
     * 
     * @param technicalLockOwner the technical owner for which the lock owner is
     * requested.
     * @return the corresponding owner to a
     * {@link #getOrCreateTechLockOwner(Object) technical lock owner},
     * <code>null</code> if owner can't be determined anymore (e.g. was garbage
     * collected).
     */
    private Object getOriginalOwner( TechLockOwner technicalLockOwner ) {

        WeakReference weakLockOwner = this.techLockOwner2LockOwner.get( technicalLockOwner );
        Object lockOwner = null;

        // the weak reference must be there and it must return a non-null value,
        // otherwise exception
        if ( ( weakLockOwner != null ) && ( ( lockOwner = weakLockOwner.get( ) ) != null ) ) {

            return lockOwner;

        }
        if ( logger.isTraced( MoinSeverity.WARNING ) ) {
            logger.trace( MoinSeverity.WARNING, CoreLockingTraces.LOCKOWNEREXPIRED, technicalLockOwner );
        }
        return null;


    }

    /**
     * Implementation of {@link PartitionLockManager#obtainLock(PRI, Object)}.
     * <p>
     * For performance reason only the first obtainLock() is forwarded to a
     * possible facility locking. Every subsequent call works with the memory
     * locking which is the PartitionLockManagerStore store.
     */
    public synchronized boolean obtainLock( PRI pri, Object pOwner ) throws LockingException {

        // input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( pOwner );
        checkResourceInfoCompatibility( pri );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.OBTAININGLOCKFORCORE, pri, pOwner );
        }

        // delegate to actual implementation
        return obtainLockInternal( pri, pOwner, true );
    }

    /**
     * Implementation of
     * {@link LockManager#obtainApplicationLock(PRI, Connection)}.
     * <p>
     * For performance reasons only the first obtainLock() is forwarded to a
     * possible facility locking. Every subsequent call works with the memory
     * locking which is the PartitionLockManagerStore store.
     */
    public synchronized void obtainApplicationLock( PRI pri, Connection pOwner ) throws LockingException {

        // input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( pOwner );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.OBTAINLOCKFORAPP, pri, pOwner );
        }

        // delegate to actual implementation
        obtainLockInternal( pri, pOwner, false );
    }

    /**
     * Common implementation for both
     * {@link #obtainLock(SpiResourceInfo, Object)} and
     * {@link #obtainApplicationLock(MRI, Connection)}.
     * 
     * @param pri the resource for which a lock is requested
     * @param pOwner the owner of the requested lock
     * @param coreLock flag for distinguishing if the lock is requested by the
     * core (if <code>true</code>) or by an application (if <code>false</code>.
     */
    private boolean obtainLockInternal( PRI pri, Object pOwner, boolean coreLock ) throws LockingException {

        boolean lockTraceEnabled = ( JMX_ENABLED && ( (WorkspaceSetImpl) this.workspaceSet ).lockingTraceEnabled( ) && pOwner instanceof ConnectionImpl );
        long duration = 0;

        TechLockOwner techLockOwner = getOrCreateTechLockOwner( pOwner );

        try {
            if ( lockTraceEnabled ) {
                duration = System.nanoTime( );
            }

            boolean wasNotLockedBefore = this.store.obtainLock( pri, techLockOwner, coreLock );

            if ( wasNotLockedBefore && ( this.facilityLocking != null ) ) {
                // delegate to facility locking only if it is the first time the
                // lock is requested. On repeated calls on
                // a already locked resource the memory locking is used as cache
                // in order to prevent (possible
                // expensive) calls to the facility locking.
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.DELEGATINGOBTAINLOCK, pri );
                }
                this.facilityLocking.obtainLock( pri, techLockOwner );
            }

            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.OBTAINLOCKRESULT, wasNotLockedBefore );
            }

            if ( lockTraceEnabled && wasNotLockedBefore ) {
                duration = ( System.nanoTime( ) - duration ) / 1000000;
                ( (WorkspaceSetImpl) this.workspaceSet ).obtainedPartitionLock( pri, (ConnectionImpl) pOwner, coreLock, Thread.currentThread( ).getStackTrace( ), duration );
            }

            return wasNotLockedBefore;

        } catch ( LockedException e ) {
            handleLockedException( e, pOwner, pri );
        }

        // this statement can never be reached but otherwise the compiler
        // complains
        return false;
    }

    /**
     * Determines the supplied exception and maps back the technical user to the
     * "real" lock owner. This information is put into a new
     * {@link LockedException} which is then thrown.
     * 
     * @param exceptionToBeHandled the exception which needs to be handled.
     * @param wannabeOwner the owner which tried to do something which lead to
     * the exception.
     * @param pri the resource on which the operation was performed that lead to
     * the exception.
     * @throws LockedException is always thrown by this method. A new instance
     * has to be created in order to inform the caller who the current lock
     * owner is. The original exception only contains the technical lock owner,
     * therefore the mapping to the "real" lock owner must be done and the
     * original exception can NOT be thrown to the caller directly.
     */
    private void handleLockedException( LockedException exceptionToBeHandled, Object wannabeOwner, PRI pri ) throws LockedException {

        Object currentOwner = getOriginalOwner( (TechLockOwner) exceptionToBeHandled.getLockedBy( ) );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.LOCKCOLLISION, pri, currentOwner, wannabeOwner );
        }
        throw new LockedException( currentOwner, CoreLockingMessages.FOREIGNLOCK, wannabeOwner, pri, currentOwner );
    }

    /**
     * Implementation of {@link PartitionLockManager#releaseAllLocks(Object)}.
     * <p>
     * As all locks need to be released both when this method is called directly
     * and when a lock owner is garbage collected, the actual implementation is
     * located at {@link #notifyOnObjectRemoved(boolean, Object)}, which is
     * triggered when a lock owner is removed from the
     * {@link #lockOwner2TechLockOwner} structure. That's the only thing this
     * method does.
     * 
     * @see #notifyOnObjectRemoved(boolean, Object)
     */
    public synchronized void releaseAllLocks( Object pOwner ) {

        checkParameterIsNotNull( pOwner );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASEALLLOCKSFOROWNER, pOwner );
        }

        // this removal will trigger the notifyOnObjectRemoved() method where
        // the actual removal logic is implemented
        this.lockOwner2TechLockOwner.remove( pOwner );
    }

    /**
     * This method is called in the following cases:<br>
     * <ol>
     * <li>{@link #releaseAllLocks(Object)} was called which then explicitly
     * removed the corresponding entry in the lockOwner2TechLockOwner structure
     * -> this triggered this notification.</li>
     * <li>the lock "owner" was garbage collected (and therefore implicitly
     * removed from lockOwner2TechLockOwner structure which then triggered this
     * notification).</li>
     * </ol>
     * So it is NOT necessary to do anything with the lockOwner2TechLockOwner
     * structure as this is already up to date. The remaining things to do are
     * to clean up the locks in the facility locking(s), in memory and to remove
     * the corresponding entry in the "backward" mapping structure
     * techLockOwner2LockOwner. Attention: This method must NOT be synchronized
     * because that can lead to a very difficult to detect deadlock. The
     * housekeeping thread has the synchronized lock for the
     * "lockOwner2TechLockOwner" NotifyingWeakHashMap when it calls this method.
     * If this method is synchronized, it could happen, that another thread
     * already has the synchronized lock for "this" and tries to acquire the
     * synchronized lock for the "lockOwner2TechLockOwner" NotifyingWeakHashMap
     * -> deadlock! as both threads wait on each other to get the synchronized
     * lock.
     */
    public void notifyOnObjectRemoved( boolean garbageCollected, Object context ) {

        TechLockOwner techLockOwner = (TechLockOwner) context;

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {

            if ( garbageCollected ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.OWNERWASGARBAGECOLLECTED, techLockOwner );
            } else {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.OWNERWASREMOVED, techLockOwner );
            }
        }

        if ( techLockOwner != null ) {

            if ( this.facilityLocking != null ) {
                try {

                    this.facilityLocking.releaseAllLocks( techLockOwner );

                } catch ( LockingException e ) {
                    if ( logger.isLoggedOrTraced( MoinSeverity.ERROR ) ) {
                        logger.logAndTrace( e, MoinSeverity.ERROR, CoreLockingMessages.RELEASEALLFAILED, this.facilityLocking );
                    }
                }
            }

            // remove all locks of lock owner pOwner from memory store
            this.store.removeAllByOwner( techLockOwner );

            // remove tech lock owner from techLockOwner2LockOwner table
            this.techLockOwner2LockOwner.remove( techLockOwner );

        }
    }

    /**
     * Implementation of {@link PartitionLockManager#releaseLock(PRI, Object)}.
     */
    public synchronized void releaseLock( PRI pri, Object pOwner ) throws LockingException {

        // input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( pOwner );
        checkResourceInfoCompatibility( pri );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASELOCKFORCORE, pri, pOwner );
        }

        releaseLockInternal( pri, pOwner, true );

    }

    /**
     * Implementation of
     * {@link LockManager#releaseApplicationLock(PRI, Connection)}.
     */
    public synchronized void releaseApplicationLock( PRI pri, Connection pOwner ) throws LockingException {

        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( pOwner );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASELOCKFORAPP, pri, pOwner );
        }

        releaseLockInternal( pri, pOwner, false );
    }

    public LockManagerWrapper getWrapper( ) {

        return this.wrapper;
    }

    /**
     * Commmon implementation of both
     * {@link #releaseLock(SpiResourceInfo, Object)} and
     * {@link #releaseApplicationLock(MRI, Connection)}.
     * <p>
     * It releases the lock in memory first and only if it is physically
     * removed, it delegates to the
     * {@link SpiInternalDistributedDirtyLocking#releaseLock(SpiResourceInfo, Object)
     * facility locking}.
     */
    private void releaseLockInternal( PRI pri, Object pOwner, boolean coreLock ) throws LockingException {

        boolean lockTracingEnabled = ( JMX_ENABLED && ( (WorkspaceSetImpl) this.workspaceSet ).lockingTraceEnabled( ) && pOwner instanceof ConnectionImpl );
        long duration = 0;

        TechLockOwner techLockOwner = this.getOrCreateTechLockOwner( pOwner );

        try {
            if ( lockTracingEnabled ) {
                duration = System.nanoTime( );
            }

            boolean wasRemoved = this.store.releaseLock( pri, techLockOwner, coreLock );

            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASELOCKMEMORYRESULT, wasRemoved );
            }

            if ( wasRemoved ) {
                // was physically removed, therefore it must also be removed
                // from a possibly existing facility locking
                if ( this.facilityLocking != null ) {
                    // a facility locking exists, therefore request lock release
                    this.facilityLocking.releaseLock( pri, techLockOwner );
                }
            }

            if ( lockTracingEnabled && wasRemoved ) {
                duration = ( System.nanoTime( ) - duration ) / 1000000;
                ( (WorkspaceSetImpl) this.workspaceSet ).releasedPartitionLock( pri, (ConnectionImpl) pOwner, coreLock, Thread.currentThread( ).getStackTrace( ), duration );
            }

        } catch ( LockedException e ) {
            handleLockedException( e, pOwner, pri );
        }

    }

    /**
     * Gets or creates a technical lock owner for the passed owner. A technical
     * lock owner is nothing more than a unique object (java identity).
     */
    private synchronized TechLockOwner getOrCreateTechLockOwner( Object pOwner ) {

        TechLockOwner techLockOwner = this.lockOwner2TechLockOwner.get( pOwner );

        // if not already existing, the technical lock owner is created
        if ( techLockOwner == null ) {
            // create the technical lock owner which is a GUID
            //techLockOwner = Utilities.getUtilities( ).createGUID( );
            techLockOwner = createTechLockOwner( pOwner );

            // do the mapping from lockOwner to techLockOwner and register the
            // techLockOwner as "context" which will
            // then be available when notifyOnObjectRemoved() is called. This is
            // necessary because it cannot be
            // guaranteed that the lock owner is still existing when cleanup
            // operations are required, therefore the
            // technical lock owner must be used for such cleanup operations.
            this.lockOwner2TechLockOwner.put( pOwner, techLockOwner, techLockOwner, this );

            // also maintain the "backward" mapping i.e. to get the
            // corresponding lock owner to a technical lock owner.
            // That's needed for the methods getLockOwner() resp.
            // getApplicationLockOwner()
            this.techLockOwner2LockOwner.put( techLockOwner, new WeakReference<Object>( pOwner ) );

            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.MAPPING, pOwner, techLockOwner );
            }
        }

        return techLockOwner;
    }

    private TechLockOwner createTechLockOwner( Object owner ) {

        return new TechLockOwner( owner );
    }

    /**
     * Makes sure that the passed ResourceInfo pResInfo corresponds to the
     * DataArea that this PartitionLockManagerImpl is based on. In case the
     * DataArea which is defined for the passed ResourceInfo pResInfo is null or
     * does not equals the DataArea this.dataArea on which this
     * PartitionLockManagerImpl is based on an IllegalArgumentException is
     * thrown.
     */
    private void checkResourceInfoCompatibility( PRI pri ) throws IllegalArgumentException {

        DataAreaDescriptor dataAreaDescriptor = this.dataArea.getDescriptor( );
        DataAreaDescriptor resInfoDataAreaDescriptor = pri.getDataAreaDescriptor( );
        if ( !dataAreaDescriptor.equals( resInfoDataAreaDescriptor ) ) {
            if ( logger.isLoggedOrTraced( MoinSeverity.ERROR ) ) {
                logger.logAndTrace( MoinSeverity.ERROR, CoreLockingMessages.INCOMPATIBLERESOURCE, pri, resInfoDataAreaDescriptor, dataAreaDescriptor );
            }
            LockingException ex = new LockingException( CoreLockingMessages.INCOMPATIBLERESOURCE, pri, resInfoDataAreaDescriptor, dataAreaDescriptor );
            throw new IllegalArgumentException( ex );
        }
    }

    /**
     * Checks if the parameter is <code>null</code>. If so, a
     * {@link IllegalArgumentException} is thrown.
     */
    private static void checkParameterIsNotNull( Object pCheckedObject ) throws IllegalArgumentException {

        if ( pCheckedObject == null ) {
            throw new MoinIllegalStateException( CoreLockingMessages.LOCKARGISNULL );
        }
    }

    private static final class TechLockOwner {

        private String string;

        public TechLockOwner( Object lockOwner ) {

            this.string = lockOwner.toString( ) + " - " + System.identityHashCode( this ); //$NON-NLS-1$
        }

        @Override
        public String toString( ) {

            return this.string;
        }


    }
}