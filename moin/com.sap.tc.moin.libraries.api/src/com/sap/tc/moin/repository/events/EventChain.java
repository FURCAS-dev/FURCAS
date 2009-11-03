package com.sap.tc.moin.repository.events;

import java.util.List;

import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * EventChains are used to group several events. This functionality is needed
 * when several deferred events shall be delivered at once. <br>
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */

public interface EventChain {

    /**
     * This method returns the events that are part of the chain
     * 
     * @return events inside the chain
     */
    public List<ChangeEvent> getEvents( );

}