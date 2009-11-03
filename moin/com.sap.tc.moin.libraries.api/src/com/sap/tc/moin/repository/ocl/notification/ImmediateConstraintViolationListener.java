package com.sap.tc.moin.repository.ocl.notification;


/**
 * The listener interface for event-based, immediate constraint checks.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface ImmediateConstraintViolationListener {

    /**
     * Notification should not be triggered with an empty status object, but
     * this behavior is not guaranteed
     * 
     * @param violationStatus the status object
     */
    public void notify( EventBasedConstraintViolationStatus violationStatus );
}
