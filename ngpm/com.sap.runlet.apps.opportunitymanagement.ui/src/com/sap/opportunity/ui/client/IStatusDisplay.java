package com.sap.opportunity.ui.client;

public interface IStatusDisplay {
    
    /**
     * Indicate that a new RPC will be issued.
     */
    public void startRPC();
    
    /**
     * Indicate that a RPC has returned.
     */
    public void finishRPC();
    
    /**
     * Allow output of error messages.
     * @param message
     */
    public void error(String message);

}
