package com.sap.tc.moin.repository;


/**
 * This represents an error during a process.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ProcessError extends ProcessMessage {

    /**
     * Gets the root cause
     * 
     * @return the root cause
     */
    public Exception getRootCause( );
}