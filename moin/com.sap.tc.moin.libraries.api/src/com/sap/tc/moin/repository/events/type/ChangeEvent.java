package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.Connection;

/**
 * Every event that is supported by MOIN must implement the
 * <code>ChangeEvent</code> interface.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */

public interface ChangeEvent {

    /**
     * by calling this method, the indicated change to the model will be
     * prevented.
     * 
     * @param reason a human readable reason for the veto
     */
    public void veto( String reason );

    /**
     * This method returns the connection that caused this event.
     * 
     * @return Returns the connection that caused this event
     */
    public Connection getEventTriggerConnection( );

}