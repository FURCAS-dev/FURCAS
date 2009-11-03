package com.sap.tc.moin.repository.spi.runtimehost.context;

/**
 * Environment-independent Wrapper for Locking Exceptions.
 */
public class SpiLockingException extends Exception {

    /**
     * Locking exception
     * 
     * @param Exception message.
     */
    public SpiLockingException(String message) {
    	super(message);
    }

    /**
     * Locking exception.
     * 
     * @param Exception message.
     * @param Exception cause.
     */
    public SpiLockingException(String message, Throwable cause) {
    	super(message, cause);
    }

}
