package com.sap.tc.moin.repository.ocl.notification;

import java.util.List;

/**
 * The immediate constraint violation status.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface EventBasedConstraintViolationStatus extends ConstraintViolationStatus {

    /**
     * @return the warnings or an empty <code>List</code>.
     */
    public List<EventBasedConstraintViolationStatusItem> getWarnings( );

    /**
     * @return the errors or an empty <code>List</code>.
     */
    public List<EventBasedConstraintViolationStatusItem> getErrors( );

    /**
     * @return the informations or an empty <code>List</code>.
     */
    public List<EventBasedConstraintViolationStatusItem> getInfos( );

    /**
     * @return all items or an empty <code>List</code>.
     */
    public List<EventBasedConstraintViolationStatusItem> getAll( );

}
