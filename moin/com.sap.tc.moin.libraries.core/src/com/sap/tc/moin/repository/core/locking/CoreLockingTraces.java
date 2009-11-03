package com.sap.tc.moin.repository.core.locking;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.localization.ExternalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Externalized Messages in alphabetical order:
 * <ol>
 * <li>LockKeyDetails_XMSG: After obtainLock() execution, the lock for argument "{0}" looks the following: "{1}"</li>
 * <li>CheckLockFailedNoLock_XMSG: Checking of lock on resource "{0}" and owner "{1}" failed because resource is not locked at all</li>
 * <li>MappingNotFound_XMSG: Couldn't find an entry for owner "{0}" in owner2LockArguments mapping, cannot remove lock for argument "{1}"</li>
 * <li>ObtainLockMemoryApp_XMSG: In memory: Trying to obtain lock on behalf an application for argument "{0}" and owner "{1}"</li>
 * <li>LockCollision_XMSG: Lock collision: the resource "{0}" is already locked by "{1}", therefore can not be locked by "{2}"</li>
 * <li>ReleaseNonExistingLockApp_XMSG: Lock for argument "{0}" is either not existing or not obtained by an application, but was requested by an application to be released</li>
 * <li>ReleaseNonExistingLock_XMSG: Lock for argument "{0}" is either not existing or not obtained by core, but was requested by core to be released</li>
 * <li>LockOwnerNotConnection_XMSG: Lock owner is NOT an instance of Connection, getClass().getName() returns "{0}"</li>
 * <li>Mapping_XMSG: Mapped owner "{0}" to technical owner "{1}"</li>
 * <li>ObtainLockResult_XMSG: ObtainLock() returned "{0}"</li>
 * <li>DelegatingObtainLock_XMSG: Obtaining of lock for resource "{0}" is delegated to facility locking</li>
 * <li>CreateMapping_XMSG: Owner "{0}" has not locked anything yet, createing mapping owner2LockArguments</li>
 * <li>OwnerWasGarbageCollected_XMSG: Owner which maps to technical owner "{0}" was removed because of garbage collection</li>
 * <li>OwnerWasRemoved_XMSG: Owner which maps to technical owner "{0}" was removed explicitly</li>
 * <li>ReleaseLockMemoryResult_XMSG: ReleaseLock() on memory-store returned "{0}"</li>
 * <li>ReleaseAllLocksForOwner_XMSG: Releasing all locks for owner "{0}"</li>
 * <li>LockOwnerExpired_XMSG: The lock owner for technical owner "{0}" could no longer be determined, might have been garbage collected</li>
 * <li>NoLockArgs_XMSG: There are no lock arguments for owner "{0}", can't remove anything</li>
 * <li>NoMoreLockArgs_XMSG: There are no more lock arguments for owner "{0}", removing mapping from owner2LockArguments</li>
 * <li>NoLockForArg_XMSG: There is no lock for argument "{0}"</li>
 * <li>NoLockForArgAndOwner_XMSG: There is no lock for argument "{0}" and owner "{1}"</li>
 * <li>RemoveLock_XMSG: Try to remove lock for argument "{0}"</li>
 * <li>CheckingLockForApp_XMSG: Trying to check lock on partition "{0}" for owner "{1}" on behalf of application</li>
 * <li>CheckingLockForCore_XMSG: Trying to check lock on resource "{0}" for owner "{1}" on behalf of core</li>
 * <li>ObtainLockMemory_XMSG: Trying to obtain in-memory lock on behalf of the core for argument "{0}" and owner "{1}"</li>
 * <li>ObtainLockForApp_XMSG: Trying to obtain lock on partition "{0}" for owner "{1}" on behalf of application</li>
 * <li>ObtainingLockForCore_XMSG: Trying to obtain lock on resource {0} for owner {1} on behalf of core</li>
 * <li>ReleaseAppLock_XMSG: Trying to release lock on behalf of an application for lock argument "{0}" and owner "{1}"</li>
 * <li>ReleaseCoreLock_XMSG: Trying to release lock on behalf of the core for lock argument "{0}" and owner "{1}"</li>
 * <li>ReleaseLockForApp_XMSG: Trying to release lock on partition "{0}" for owner "{1}" on behalf of application</li>
 * <li>ReleaseLockForCore_XMSG: Trying to release lock on resource "{0}" for owner "{1}" on behalf of core</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreLockingTraces.properties
 */
 
public enum CoreLockingTraces implements MoinExternalizedString {


    /**
     * Message: "Checking of lock on resource "{0}" and owner "{1}" failed because resource is not locked at all"
     */
    CHECKLOCKFAILEDNOLOCK("CheckLockFailedNoLock_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to check lock on partition "{0}" for owner "{1}" on behalf of application"
     */
    CHECKINGLOCKFORAPP("CheckingLockForApp_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to check lock on resource "{0}" for owner "{1}" on behalf of core"
     */
    CHECKINGLOCKFORCORE("CheckingLockForCore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Owner "{0}" has not locked anything yet, createing mapping owner2LockArguments"
     */
    CREATEMAPPING("CreateMapping_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Obtaining of lock for resource "{0}" is delegated to facility locking"
     */
    DELEGATINGOBTAINLOCK("DelegatingObtainLock_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Lock collision: the resource "{0}" is already locked by "{1}", therefore can not be locked by "{2}""
     */
    LOCKCOLLISION("LockCollision_XMSG"), //$NON-NLS-1$

    /**
     * Message: "After obtainLock() execution, the lock for argument "{0}" looks the following: "{1}""
     */
    LOCKKEYDETAILS("LockKeyDetails_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The lock owner for technical owner "{0}" could no longer be determined, might have been garbage collected"
     */
    LOCKOWNEREXPIRED("LockOwnerExpired_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Lock owner is NOT an instance of Connection, getClass().getName() returns "{0}""
     */
    LOCKOWNERNOTCONNECTION("LockOwnerNotConnection_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Couldn't find an entry for owner "{0}" in owner2LockArguments mapping, cannot remove lock for argument "{1}""
     */
    MAPPINGNOTFOUND("MappingNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Mapped owner "{0}" to technical owner "{1}""
     */
    MAPPING("Mapping_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There are no lock arguments for owner "{0}", can't remove anything"
     */
    NOLOCKARGS("NoLockArgs_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There is no lock for argument "{0}" and owner "{1}""
     */
    NOLOCKFORARGANDOWNER("NoLockForArgAndOwner_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There is no lock for argument "{0}""
     */
    NOLOCKFORARG("NoLockForArg_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There are no more lock arguments for owner "{0}", removing mapping from owner2LockArguments"
     */
    NOMORELOCKARGS("NoMoreLockArgs_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to obtain lock on partition "{0}" for owner "{1}" on behalf of application"
     */
    OBTAINLOCKFORAPP("ObtainLockForApp_XMSG"), //$NON-NLS-1$

    /**
     * Message: "In memory: Trying to obtain lock on behalf an application for argument "{0}" and owner "{1}""
     */
    OBTAINLOCKMEMORYAPP("ObtainLockMemoryApp_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to obtain in-memory lock on behalf of the core for argument "{0}" and owner "{1}""
     */
    OBTAINLOCKMEMORY("ObtainLockMemory_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ObtainLock() returned "{0}""
     */
    OBTAINLOCKRESULT("ObtainLockResult_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to obtain lock on resource {0} for owner {1} on behalf of core"
     */
    OBTAININGLOCKFORCORE("ObtainingLockForCore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Owner which maps to technical owner "{0}" was removed because of garbage collection"
     */
    OWNERWASGARBAGECOLLECTED("OwnerWasGarbageCollected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Owner which maps to technical owner "{0}" was removed explicitly"
     */
    OWNERWASREMOVED("OwnerWasRemoved_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Releasing all locks for owner "{0}""
     */
    RELEASEALLLOCKSFOROWNER("ReleaseAllLocksForOwner_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to release lock on behalf of an application for lock argument "{0}" and owner "{1}""
     */
    RELEASEAPPLOCK("ReleaseAppLock_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to release lock on behalf of the core for lock argument "{0}" and owner "{1}""
     */
    RELEASECORELOCK("ReleaseCoreLock_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to release lock on partition "{0}" for owner "{1}" on behalf of application"
     */
    RELEASELOCKFORAPP("ReleaseLockForApp_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to release lock on resource "{0}" for owner "{1}" on behalf of core"
     */
    RELEASELOCKFORCORE("ReleaseLockForCore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ReleaseLock() on memory-store returned "{0}""
     */
    RELEASELOCKMEMORYRESULT("ReleaseLockMemoryResult_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Lock for argument "{0}" is either not existing or not obtained by an application, but was requested by an application to be released"
     */
    RELEASENONEXISTINGLOCKAPP("ReleaseNonExistingLockApp_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Lock for argument "{0}" is either not existing or not obtained by core, but was requested by core to be released"
     */
    RELEASENONEXISTINGLOCK("ReleaseNonExistingLock_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Try to remove lock for argument "{0}""
     */
    REMOVELOCK("RemoveLock_XMSG"); //$NON-NLS-1$

    private final static ExternalizedResourceBundleAccessor ACCESSOR = new ExternalizedResourceBundleAccessor( CoreLockingTraces.class );

    private final String myKey;

    private CoreLockingTraces( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );

    }

}  