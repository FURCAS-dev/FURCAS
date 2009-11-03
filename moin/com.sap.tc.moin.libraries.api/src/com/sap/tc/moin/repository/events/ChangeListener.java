package com.sap.tc.moin.repository.events;

import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * This is the standard listener interface of the MOIN Event Framework. Clients implement this interface in case of a
 * registration as post change listener. They will get notified after a change has occured, (but before it is commited)
 * by an invocation of the {@link #notify(ChangeEvent)} method. All post change events will be sent synchronously.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 * 
 * @author Daniel Vocke (D044825)
 */
public interface ChangeListener extends EventListener {

    /**
     * This method will be invoked each time an event is sent to the client. 
     * 
     * @param event the event that shall be notified to the client
     */
    public void notify( ChangeEvent event );

}