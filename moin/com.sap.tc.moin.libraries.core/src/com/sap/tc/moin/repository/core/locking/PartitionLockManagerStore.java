package com.sap.tc.moin.repository.core.locking;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Store for in-memory locks.
 * <p>
 * There is always a lock argument and a corresponding lock owner in order to
 * {@link #obtainLock(Object, Object, boolean) obtain},
 * {@link #checkLock(Object, Object) check} or
 * {@link #releaseLock(Object, Object, boolean) release} a lock. Lock related
 * actions are either requested on behalf of the MOIN core or some MOIN
 * application. That's why some of the methods of this class offer a boolean
 * parameter to distinguish these two cases. Most methods require that the owner
 * of the lock is supplied in order to check if the operation is allowed (which
 * is only the case if the supplied owner corresponds to the owner of the lock).
 * 
 * @author d032153, d044711
 * @param <T>
 */
public final class PartitionLockManagerStore<T> {

    /**
     * The logger for this class.
     */
    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_LOCKING, PartitionLockManagerStore.class );

    /**
     * This is the main datastructure for holding the locks. Locks are
     * represented by {@link LockValue}, keyed by a lock argument in this data
     * structure.
     */
    private Map<T, LockValue> lockArgument2LockValue;

    /**
     * Mapping from lock owner to its lock arguments for fast access so that no
     * sequential access is required when {@link #removeAllByOwner(Object)} is
     * called.
     */
    private Map<Object, Set<T>> owner2LockArguments;

    /**
     * 
     */
    public PartitionLockManagerStore( ) {

        this.lockArgument2LockValue = new HashMap<T, LockValue>( );

        //if we don't use an identiy hash map anymore, we also have to change
        //the LockValue.checkLockOwner() implementation from == to equals
        this.owner2LockArguments = new IdentityHashMap<Object, Set<T>>( );
    }

    /**
     * Releases the lock for the given argument and owner.
     * <p>
     * If no lock exists for the given argument, this method will do nothing and
     * return <code>false</code>. ATTENTION: the return value does NOT tell if
     * this method was successful or not but only tells if the affected lock was
     * physically removed or not. There is no way to check with this method only
     * if it was a no-operation or if an existing lock was just not physically
     * released.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @param owner the owner of the locked resource.
     * @param coreLock to distinguish if the release is requested on behalf of
     * the core (if <code>true</code>) or an application (if <code>false</code>
     * ).
     * @return <code>true</code> if the existing lock for the given argument was
     * physically removed, <code>false</code> otherwise.
     * @throws LockedException thrown if a lock exists for the given lock
     * argument, but the given owner does not match the owner of the existing
     * lock.
     */
    public boolean releaseLock( T lockArgument, Object owner, boolean coreLock ) throws LockedException {

        if ( coreLock ) {
            return releaseCoreLock( lockArgument, owner );
        }
        return releaseApplicationLock( lockArgument, owner );
    }

    /**
     * Releases the lock for the given argument and owner on behalf of the core.
     * <p>
     * If there is no lock existing for the given argument or it is existing,
     * but not obtained by the core, this method is a no-operation. The lock is
     * physically removed if it is only obtained by the core. If it is also
     * obtained by at least one application, only the core count of the lock is
     * reset, but the lock is not removed.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @param owner the owner of the locked resource.
     * @return <code>true</code> if the existing lock for the given argument was
     * physically removed, <code>false</code> otherwise.
     * @throws LockedException thrown if a lock exists for the given lock
     * argument, but the given owner does not match the owner of the existing
     * lock.
     */
    private boolean releaseCoreLock( T lockArgument, Object owner ) throws LockedException {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASECORELOCK, lockArgument, owner );
        }

        LockValue lock = this.getLockAndCheckOwner( lockArgument, owner );

        // lock must be existing and must be obtained by the core because otherwise it is a no-operation
        if ( lock != null && lock.isObtainedByCore( ) ) {
            if ( lock.isObtainedByApplication( ) ) {
                lock.resetCoreCount( );
                return false; // is still locked by an application, therefore can't be removed
            }
            // is locked only by core (because it is not locked by any application), therefore remove it
            removeLock( lockArgument, owner );
            return true;// was physically removed
        }
        // there is either no lock or it is not obtained by the core -> do nothing, just trace the situation
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASENONEXISTINGLOCK, lockArgument );
        }


        return false;
    }

    /**
     * Releases the lock for the given argument and owner on behalf of an
     * application.
     * <p>
     * If there is no lock existing for the given argument or it is existing but
     * not obtained by an application, this method is a no-operation. Otherwise,
     * the application count for the lock is decremented. If after that the lock
     * is neither obtained by core nor by application, the lock is physically
     * removed.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @param owner the owner of the locked resource.
     * @return <code>true</code> if the existing lock for the given argument was
     * physically removed, <code>false</code> otherwise.
     * @throws LockedException thrown if a lock exists for the given lock
     * argument, but the given owner does not match the owner of the existing
     * lock.
     */
    private boolean releaseApplicationLock( T lockArgument, Object owner ) throws LockedException {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASEAPPLOCK, lockArgument, owner );
        }

        LockValue lock = this.getLockAndCheckOwner( lockArgument, owner );

        if ( ( lock != null ) && lock.isObtainedByApplication( ) ) {

            // decrement the application counter
            lock.decrementApplicationCount( );
            if ( ( !lock.isObtainedByCore( ) ) && !lock.isObtainedByApplication( ) ) {
                // lock is neither obtained by core nor by application, therefore it has to be physically removed.
                removeLock( lockArgument, owner );
                return true; // was physically removed
            }
        } else {
            // there is either no lock or it is not locked by an application -> no-op, but trace the situation
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.RELEASENONEXISTINGLOCKAPP, lockArgument );
            }
        }

        return false; // was not removed
    }

    /**
     * Physically removes a lock for the given argument and owner from this
     * store.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @param owner the owner of the locked resource.
     */
    private void removeLock( T lockArgument, Object owner ) {

        // update the owner2LockArguments mapping
        Set<T> lockArgumentsForOwner = this.owner2LockArguments.get( owner );
        if ( lockArgumentsForOwner != null ) {
            lockArgumentsForOwner.remove( lockArgument );
            if ( lockArgumentsForOwner.isEmpty( ) ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.NOMORELOCKARGS, owner );
                }
                // it was the last entry for this owner, therefore remove the mapping
                this.owner2LockArguments.remove( owner );
            }
        } else { // lockArgumentsForOwner == null
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.MAPPINGNOTFOUND, owner, lockArgument );
            }
        }

        // finally remove the lock
        this.lockArgument2LockValue.remove( lockArgument );

    }

    /**
     * @param owner
     * @return
     */
    public Collection<T> getLockedResources( Object owner ) {

        return this.owner2LockArguments.get( owner );
    }

    /**
     * Obtains a lock for the given argument and owner.
     * <p>
     * If there is already a lock existing, the core or the application count
     * respectively are increased (depending on the value of the coreLock
     * parameter). If there is no lock yet existing for the given argument, it
     * is created.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @param owner the owner of the locked resource.
     * @param coreLock to distinguish if the obtaining is requested on behalf of
     * the core (if <code>true</code>) or an application (if <code>false</code>
     * ).
     * @return <code>true</code> if there was no lock existing for the given
     * argument and was now newly created by this method, <code>false</code> if
     * there was already a lock existing for the given argument.
     * @throws LockedException thrown if a lock exists for the given lock
     * argument, but the given owner does not match the owner of the existing
     * lock.
     */
    public boolean obtainLock( T lockArgument, Object owner, boolean coreLock ) throws LockedException {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            if ( coreLock ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.OBTAINLOCKMEMORY, lockArgument, owner );
            } else {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.OBTAINLOCKMEMORYAPP, lockArgument, owner );
            }
        }

        LockValue lockVal = getLockAndCheckOwner( lockArgument, owner );
        boolean wasNotLockedBefore = false;

        if ( lockVal == null ) {// no lock existing yet, therefore create it

            lockVal = new LockValue( owner );
            this.lockArgument2LockValue.put( lockArgument, lockVal );
            Set<T> lockArgumentsForOwner = this.owner2LockArguments.get( owner );
            if ( lockArgumentsForOwner == null ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.CREATEMAPPING, owner );
                }
                // first time this owner requests a lock, therefore lazily initialize the owner2LockArguments structure
                lockArgumentsForOwner = new HashSet<T>( );
                lockArgumentsForOwner.add( lockArgument );
                this.owner2LockArguments.put( owner, lockArgumentsForOwner );
            } else {// lockValuesForOwner != null -> the owner already holds at least one lock
                // add the newly created lock
                lockArgumentsForOwner.add( lockArgument );
            }
            wasNotLockedBefore = true;
        }

        // update the counter of the lock value
        if ( coreLock ) {
            lockVal.incrementCoreCount( );
        } else {// application lock
            lockVal.incrementApplicationCount( );
        }

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.LOCKKEYDETAILS, lockArgument, lockVal.toString( ) );
        }
        return wasNotLockedBefore;
    }

    /**
     * Checks if there is a lock existing for the given argument and owner.
     * <p>
     * If it is exsting, but the owner doesn't match, an exception is thrown.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @param owner the owner of the locked resource.
     * @return <code>true</code> if there is lock existing for the given
     * argument and owner, </code>false</code> otherwise.
     * @throws LockedException thrown if a lock exists for the given lock
     * argument, but the given owner does not match the owner of the existing
     * lock.
     */
    public boolean checkLock( T lockArgument, Object owner ) throws LockedException {

        LockValue lock = getLockAndCheckOwner( lockArgument, owner );
        return lock != null;
    }

    /**
     * Gets the lock owner of the lock for the given argument.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @return the lock owner of the lock for the given argument,
     * <code>null</code> if no lock is existing for the supplied argument.
     */
    public Object getLockOwner( T lockArgument ) {

        LockValue lockVal = this.lockArgument2LockValue.get( lockArgument );
        if ( lockVal != null ) {
            return lockVal.getOwner( );
        }
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.NOLOCKFORARG, lockArgument );
        }
        return null;

    }

    /**
     * All locks of the passed lock owner are removed from this store. If the
     * supplied owner doesn't hold any locks, this method is a no-operation.
     */
    public void removeAllByOwner( Object pOwner ) {

        Set<T> lockArgumentsForOwner = this.owner2LockArguments.get( pOwner );
        if ( lockArgumentsForOwner != null ) {
            for ( T lockArgument : lockArgumentsForOwner ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.REMOVELOCK, lockArgument );
                }
                this.lockArgument2LockValue.remove( lockArgument );
            }
            this.owner2LockArguments.remove( pOwner );
        } else {// lockArgumentsForOwner == null

            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.NOLOCKARGS, pOwner );
            }
        }
    }

    /**
     * Gets the lock for the given argument and checks if the supplied owner
     * matches the lock. If there is no lock for the given argument,
     * <code>null</code> is returned and no exception will be thrown.
     * 
     * @param lockArgument the argument which identifies the locked resource.
     * @param owner the owner of the locked resource.
     * @return the lock for the given argument, <code>null</code> if there is no
     * lock for the given argument.
     * @throws LockedException thrown if a lock exists for the given lock
     * argument, but the given owner does not match the owner of the existing
     * lock.
     */
    private LockValue getLockAndCheckOwner( T lockArgument, Object owner ) throws LockedException {

        LockValue resultVal = null;
        LockValue lockVal = this.lockArgument2LockValue.get( lockArgument );

        if ( lockVal != null ) {
            lockVal.checkOwner( owner );
            resultVal = lockVal;
        } else {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, CoreLockingTraces.NOLOCKFORARGANDOWNER, lockArgument, owner );
            }
        }

        return ( resultVal );
    }

    /**
     * Represents a lock obtained on a resource. It maintains counters to track
     * how often it was requested for an application and the core. It knows its
     * owner and the point in time it was created.
     */
    private static final class LockValue {

        /**
         * The owner of this lock.
         */
        private Object owner;

        /**
         * Number of times this lock was obtained by the core.
         */
        private int obtainedByCore;

        /**
         * Number of times this lock was obtained by an application.
         */
        private int obtainedByApplication;

        /**
         * Time in milliseconds when this lock was created. Currently only used
         * for debug reasons
         */
        private long created;

        /**
         * Private because only {@link PartitionLockManagerStore} is allowed to
         * create new instances.
         * 
         * @param pOwner the owner for the lock.
         */
        private LockValue( Object pOwner ) {

            this.owner = pOwner;
            this.created = System.currentTimeMillis( );
            this.obtainedByApplication = 0;
            this.obtainedByCore = 0;
        }

        /**
         * Decreases the application count by one.
         */
        public void decrementApplicationCount( ) {

            --this.obtainedByApplication;
        }

        /**
         * Sets the core count back to its original value which is 0.
         */
        public void resetCoreCount( ) {

            this.obtainedByCore = 0;
        }

        /**
         * Increases the application count by one.
         */
        public void incrementApplicationCount( ) {

            ++this.obtainedByApplication;
        }

        /**
         * Increases the core count by one.
         */
        public void incrementCoreCount( ) {

            ++this.obtainedByCore;
        }

        /**
         * Returns a String representation of this lock and its current state
         * which is intended to be used for debug reasons mainly.
         */
        @Override
        public String toString( ) {

            return "created={" + DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.LONG, Locale.ENGLISH ).format( new Date( this.created ) ) + "}, application count={" + this.obtainedByApplication + "}, core count={" + this.obtainedByCore + "}, owner={" + this.owner + "}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
        }

        /**
         * Tells if this lock is currently obtained by the core.
         * 
         * @return <code>true</code> if obtained by the core, <code>false</code>
         * otherwise.
         */
        public boolean isObtainedByCore( ) {

            return ( this.obtainedByCore >= 1 );
        }

        /**
         * Tells if this lock is currently obtained by an application.
         * 
         * @return <code>true</code> if obtained by an application,
         * <code>false</code> otherwise.
         */
        public boolean isObtainedByApplication( ) {

            return ( this.obtainedByApplication >= 1 );
        }

        /**
         * Gets the owner of this lock.
         * 
         * @return the owner of this lock.
         */
        public Object getOwner( ) {

            return this.owner;
        }

        /**
         * Checks if the passed argument is the owner of this lock. If not, an
         * exception is thrown.
         * 
         * @param pOwner the object to check if it is the same as the owner of
         * this lock.
         * @throws LockedException thrown if the passed argument is not the same
         * as the owner of this lock.
         */
        public void checkOwner( Object pOwner ) throws LockedException {

            if ( this.owner != pOwner ) {
                throw new LockedException( this.owner, CoreLockingMessages.UNEXEPECTEDOWNER );
            }
        }
    }

}