package com.sap.tc.logging.interfaces;

/**
 *  Defines the way Correlation ID and DSR Transaction ID properties are retrieved
 *  for each LogRecord
 */
public interface IThreadRuntimeInfoProvider {
    
    /**
     * Returns the ID of the task that the current thread is executing at the moment.
     * 
     * @return long ID of the current operation if available or -1 otherwise.
     */
   
    public long getCorrelationID();
    
    /**
     * Returns the transaction ID of the current user request. 
     * 
     * @return hex string representation of GUID associated with the current user request.
     */
    public String getDsrTransactionID();

}
