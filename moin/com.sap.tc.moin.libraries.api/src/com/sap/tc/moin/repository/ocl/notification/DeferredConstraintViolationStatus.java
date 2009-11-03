package com.sap.tc.moin.repository.ocl.notification;

import java.util.List;

/**
 * The constraint violation status information sent to deferred listeners when a
 * constraint violation is detected.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface DeferredConstraintViolationStatus extends ConstraintViolationStatus {

    /**
     * @return the errors or an empty <code>List</code>.
     */
    public List<DeferredConstraintViolationStatusItem> getErrors( );

    /**
     * @return the warnings or an empty <code>List</code>.
     */
    public List<DeferredConstraintViolationStatusItem> getWarnings( );

    /**
     * @return the informations or an empty <code>List</code>.
     */
    public List<DeferredConstraintViolationStatusItem> getInfos( );

    /**
     * @return all items or an empty <code>List</code>.
     */
    public List<DeferredConstraintViolationStatusItem> getAll( );

}
