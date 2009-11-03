package com.sap.tc.moin.repository.events;

import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * Clients that want to be notified of changes by a command <b>BEFORE</b> they
 * are committed can implement this interface and register as PreCommitListener
 * using the
 * {@link EventRegistry#registerPreCommitListener(PreCommitListener, EventFilter) registerPreChangeListener}
 * method of the {@link EventRegistry} interface. PreCommitListeners are
 * notified synchronously by an invocation of their prepare-method. If a
 * <code>PreCommitListener</code> wants to prevent a change which is indicated
 * by the events, it is able to call the
 * {@link com.sap.tc.moin.repository.events.type.ChangeEvent#veto(String) veto(reason)}
 * method on one of the event.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 * 
 * @author Daniel Vocke (D044825)
 */
public interface PreCommitListener extends EventListener {

    /**
     * This method will be invoked synchronously before a change to the model is
     * committed. If the client wants to retard the change, it must call the
     * {@link ChangeEvent#veto(String)} method of the {@link ChangeEvent}.
     * 
     * @param events the events that shall be notified to the client
     */
    public void prepareCommit( EventChain events );
}