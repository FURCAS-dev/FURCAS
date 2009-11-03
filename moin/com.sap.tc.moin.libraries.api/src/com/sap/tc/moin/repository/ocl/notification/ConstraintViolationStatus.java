package com.sap.tc.moin.repository.ocl.notification;

/**
 * The base interface for the constraint violation status.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ConstraintViolationStatus {

    /**
     * @return <code>true</code> if errors were found
     */
    public boolean hasErrors( );

    /**
     * @return <code>true</code> if warnings were found
     */
    public boolean hasWarnings( );

    /**
     * @return <code>true</code> if informations were found
     */
    public boolean hasInfos( );

    /**
     * @return <code>true</code> if any items were found
     */
    public boolean hasItems( );
}
