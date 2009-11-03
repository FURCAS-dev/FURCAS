package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * This exception is thrown if it was tried to obtain a lock on a resource for a
 * certain owner, but the resource was already locked by a different owner. This
 * different owner can be retrieved with {@link #getLockedBy()}.
 */
public class LockedException extends LockingException {

    /**
     * Default serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * The owner which has locked the resource {@link #lockedResource()}.
     */
    private Object lockedBy;


    /**
     * @param actLockedBy
     * @param message
     * @param args
     */
    public LockedException( Object actLockedBy, MoinLocalizedString message, Object... args ) {

        super( message, args );
        this.lockedBy = actLockedBy;
    }

    /**
     * Get the current lock owner.
     * 
     * @return the object which is the current lock owner.
     */
    public Object getLockedBy( ) {

        return this.lockedBy;
    }

    /**
     * Sets the owner of the lock.
     * 
     * @param actLockedBy the owner of the lock
     */
    public void setLockedBy( Object actLockedBy ) {

        this.lockedBy = actLockedBy;
    }
}
