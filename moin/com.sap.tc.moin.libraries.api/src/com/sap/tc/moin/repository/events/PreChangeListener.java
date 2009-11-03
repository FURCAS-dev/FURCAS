package com.sap.tc.moin.repository.events;

import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * Clients that want to be notified of changes <b>BEFORE</b> they are performed
 * can implement this interface and register as PreChangeListener using the
 * {@link EventRegistry#registerPreChangeListener(PreChangeListener, EventFilter) registerPreChangeListener}
 * method of the {@link EventRegistry} interface. PreChangeListeners are
 * notified synchronously by an invocation of their prepare-method. If a
 * <code>PreChangeListener</code> wants to prevent a change which is indicated
 * by the event, it is able to call the
 * {@link com.sap.tc.moin.repository.events.type.ChangeEvent#veto(String) veto(reason)}
 * method on the event.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 * 
 * @author Daniel Vocke (D044825)
 */
public interface PreChangeListener extends EventListener {

    /**
     * This method will be invoked synchronously before a change to the model is
     * performed. If the client wants to retard the change, it must call the
     * {@link ChangeEvent#veto(String)} method of the {@link ChangeEvent}.
     * 
     * @param event the event that indicates the change which shall be performed
     * in future
     */
    public void prepare( ChangeEvent event );
}