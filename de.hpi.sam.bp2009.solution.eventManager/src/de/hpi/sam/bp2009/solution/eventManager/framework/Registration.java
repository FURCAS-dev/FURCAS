package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;

import org.eclipse.emf.common.notify.Adapter;

/**
 * A Registration represents a set of events that a listener wants to receive. Due to the fact that one call to
 * register..() on the EventRegistry interface can result in multiple registrations (due to the internal design),
 * registrations can be pooled into a set (the {@link RegistrationSet}).
 * 
 * @author Daniel Vocke (D044825)
 */
class Registration extends AbstractRegistration {

    /**
     * if the registration as listener results in multiple registration instances, those instances will be pooled in the
     * RegistrationSet
     */
    private RegistrationSet _container = null;

    /**
     * @param listener the listener that registered for events
     */
    Registration(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType) {
        super(listener, listenerType);
    }

    /**
     * @param listener the listener that registered for events
     * @param container the RegistrationSet in which this registration will be pooled with other registrations
     */
    Registration(WeakReference<? extends Adapter> listener, RegistrationSet container, ListenerTypeEnum listenerType) {
        super(listener, listenerType);
        _container = container;
    }

    /**
     * When a call to register...() on the EventRegistry interface results in multiple Registrations, those
     * Registrations will be pooled in a RegistrationSet. This can happen due to the internal design where "OR
     * connected" filters are splitted into multiple Registrations.
     * 
     * @return the RegistrationSet that pools all Registrations that were created during one registration call
     */

    RegistrationSet getContainer() {
        return _container;
    }

    void setContainer(RegistrationSet container) {
        _container = container;
    }
}