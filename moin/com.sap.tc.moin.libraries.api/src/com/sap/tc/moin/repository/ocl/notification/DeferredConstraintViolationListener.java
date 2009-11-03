package com.sap.tc.moin.repository.ocl.notification;


/**
 * The listener interface for deferred constraint violation events.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface DeferredConstraintViolationListener {

    /**
     * Notification should not be triggerd with an empty status object, but this
     * behavior is not guaranteed
     * 
     * @param violationStatus the status object
     */
    public void notify( DeferredConstraintViolationStatus violationStatus );
}
