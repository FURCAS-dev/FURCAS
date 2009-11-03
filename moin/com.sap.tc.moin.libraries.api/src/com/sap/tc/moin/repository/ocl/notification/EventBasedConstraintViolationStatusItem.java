package com.sap.tc.moin.repository.ocl.notification;

import com.sap.tc.moin.repository.events.type.ModelChangeEvent;

/**
 * The constraint violation information sent to event based listeners when a
 * constraint violation is detected.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface EventBasedConstraintViolationStatusItem extends DeferredConstraintViolationStatusItem {

    /**
     * @return the model change event resulting in the violation
     */
    public ModelChangeEvent getOffendingChangeEvent( );
}
