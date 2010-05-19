package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;

/**
 * A RegistrationSet is used to pool multiple {@link Registration Registrations} that were created by one call to a register...()
 * method on the EventRegistry interface. This may happen when a client registeres with multiple OR-connected filters. They are
 * mapped to multiple registrations internally. In order to distinguish between one registration using OR-connected filters and
 * several registrations, the resulting Registration objects are being pooled in the first case.
 * 
 * @author Daniel Vocke (D044825)
 */
public class RegistrationSet extends AbstractRegistration {

    private Set<Registration> registrations = new HashSet<Registration>();

    public RegistrationSet(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType) {
        super(listener, listenerType);
    }

    void addRegistration(Registration registration) {

        registrations.add(registration);
    }

    /* needed at all? */
    void removeRegistration(Registration registration) {

        registrations.remove(registration);
    }

    /**
     * @return all {@link Registration}s that are pooled in this set
     */
    Set<Registration> getRegistrations() {

        return registrations;
    }

}