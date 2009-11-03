package com.sap.tc.moin.repository;

/**
 * This class represents a warning issued during a process. Warnings are not
 * critical and will not cause the process to fail.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ProcessWarning extends ProcessMessage {

    /**
     * @return the stack trace if it was set by the application, may be null
     */
    public StackTraceElement[] getStackTrace( );
}