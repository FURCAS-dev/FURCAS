package com.sap.tc.moin.repository.events;



/**
 * DO NOT USE!
 */
@Deprecated
public interface CommitListener extends EventListener {

    /**
     * This method will be invoked each time an event is sent to the client.
     * Though the invocation is done synchronously, so the order of the events
     * is guaranteed.
     * 
     * @param events the events that shall be notified to the client
     */
    public void notifyCommit( EventChain events );

}