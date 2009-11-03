package com.sap.tc.moin.repository.events;

/**
 * Clients shall implement this interface if they want to receive events that
 * target updating the user interface.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 * 
 * @author Martin Kolb
 */
public interface UpdateListener extends EventListener {

    /**
     * This method will be invoked when the user interface shall be updated.
     * E.g. when a command group is used, then this method will be called when
     * the command group is closed.
     * 
     * @param events the events that shall be notified to the client
     */
    public void notifyUpdate( EventChain events );

}