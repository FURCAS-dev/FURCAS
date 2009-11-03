package com.sap.tc.moin.repository.core.locking;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ForeignLock_XMSG: "{0}" tried to acquire lock for resource "{1}" which is already locked by "{2}"</li>
 * <li>LockArgIsNull_XMSG: A parameter that was passed is null</li>
 * <li>AppLockNotAllowedDuringCommand_XMSG: Calling method obtainApplicationLock() is not allowed during command execution</li>
 * <li>AppLockRelNotAllowedDuringCommand_XMSG: Calling method releaseApplicationLock() is not allowed during command execution</li>
 * <li>LockOwnerNotConnection_XMSG: Lock owner is not a connection</li>
 * <li>OwnerGarbageCollected_XMSG: Lock owner no longer available, probably has been garbage collected</li>
 * <li>NoLockForResource_XMSG: No lock found for resource "{0}"</li>
 * <li>UnexepectedOwner_XMSG: Owner is not the expected one</li>
 * <li>ReleaseAllFailed_XMSG: Releasing all locks on facility locking {0} failed</li>
 * <li>IncompatibleResource_XMSG: Resource {0} is not compatible to PartitionLockManager: Data area of resource: {1}, data area of lock manager: {2}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreLockingMessages.properties
 */
 
public enum CoreLockingMessages implements MoinLocalizedString {


    /**
     * Message: "Calling method obtainApplicationLock() is not allowed during command execution"
     */
    APPLOCKNOTALLOWEDDURINGCOMMAND("AppLockNotAllowedDuringCommand_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Calling method releaseApplicationLock() is not allowed during command execution"
     */
    APPLOCKRELNOTALLOWEDDURINGCOMMAND("AppLockRelNotAllowedDuringCommand_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}" tried to acquire lock for resource "{1}" which is already locked by "{2}""
     */
    FOREIGNLOCK("ForeignLock_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Resource {0} is not compatible to PartitionLockManager: Data area of resource: {1}, data area of lock manager: {2}"
     */
    INCOMPATIBLERESOURCE("IncompatibleResource_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A parameter that was passed is null"
     */
    LOCKARGISNULL("LockArgIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Lock owner is not a connection"
     */
    LOCKOWNERNOTCONNECTION("LockOwnerNotConnection_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No lock found for resource "{0}""
     */
    NOLOCKFORRESOURCE("NoLockForResource_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Lock owner no longer available, probably has been garbage collected"
     */
    OWNERGARBAGECOLLECTED("OwnerGarbageCollected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Releasing all locks on facility locking {0} failed"
     */
    RELEASEALLFAILED("ReleaseAllFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Owner is not the expected one"
     */
    UNEXEPECTEDOWNER("UnexepectedOwner_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreLockingMessages.class );

    private final String myKey;

    private CoreLockingMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreLockingMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  