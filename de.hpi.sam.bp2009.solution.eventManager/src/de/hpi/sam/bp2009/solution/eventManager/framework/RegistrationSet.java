package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;

/**
 * A RegistrationSet is used to pool multiple {@link Registration Registrations} that were created by one call to a register...()
 * method on the EventRegistry interface. This may happen when a client registers with multiple OR-connected filters. They are
 * mapped to multiple registrations internally. In order to distinguish between one registration using OR-connected filters and
 * several registrations, the resulting Registration objects are being pooled in the first case.
 * 
 * @author Daniel Vocke (D044825)
 */
public class RegistrationSet {

    /**
     * The MoinEventFramework only stores <code>WeakReferences</code> to the registered listeners. Clients will have to
     * keep a reference to their listener in order ro prevent the garbage collector from cleaning up the instance.
     */
    private WeakReference<? extends Adapter> _listener = null;

    /**
     * defines the type of the registration. (whether it is a registration for PreChangeEvent, ChangeEvents,...)
     */
    private ListenerTypeEnum listenerType;

    private Set<Registration> registrations = new HashSet<Registration>();

    public RegistrationSet(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType) {
        _listener = listener;
        this.listenerType = listenerType;
    }

    /**
     * Every Registration belongs exactly to one listener.
     * 
     * @return a <code>WeakReference</code> to the associated listener
     */
    WeakReference<? extends Adapter> getListener() {
        return _listener;
    }

    /**
     * The return value defines the type of the Listener
     * 
     * @see com.sap.tc.moin.repository.core.events.ListenerTypeEnum
     * @return 
     */
    public ListenerTypeEnum getListenerType() {
        return listenerType;
    }

    void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    /* needed at all? */
    void removeRegistration(Registration registration) {
        registrations.remove(registration);
    }

    /**
     * @return a read-only collection with all {@link Registration}s that are pooled in this set
     */
    Set<Registration> getRegistrations() {
        return Collections.unmodifiableSet(registrations);
    }

}