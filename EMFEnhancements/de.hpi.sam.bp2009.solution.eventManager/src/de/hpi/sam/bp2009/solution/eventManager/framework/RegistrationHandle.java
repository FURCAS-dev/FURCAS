package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Adapter;

/**
 * The <code>RegistrationHandle</code> is returned when clients register as listener on the
 * EventRegistry. This handle is needed when clients want to undo their registration call.
 * 
 * @author Daniel Vocke (D044825), Axel Uhl (D043530)
 */
public class RegistrationHandle {
    private final Adapter listener;
    private final RegistrationSet registrationSet;
    
    public RegistrationHandle(Adapter listener, RegistrationSet registrationSet) {
        super();
        this.listener = listener;
        this.registrationSet = registrationSet;
    }

    protected Adapter getListener() {
        return listener;
    }
    
    protected RegistrationSet getRegistrationSet() {
        return registrationSet;
    }
}