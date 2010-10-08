package com.sap.mi.textual.parsing.textblocks.reference;

import java.util.Collection;

import com.sap.furcas.runtime.parser.impl.DelayedReference;

/**
 * This interface is provided as a listener for the {@link GlobalDelayedReferenceResolver}. 
 * A listener is notified using {@link #unresolvedReferenceRegistered(DelayedReference)}
 * as soon as a new unresolved reference is registered at the {@link GlobalDelayedReferenceResolver}.
 * If a reference gets resolved the listener is notified using {@link #referenceResolved(DelayedReference)}. 
 * @author C5106462
 *
 */
public interface ReferenceResolvingListener {

    /**
     * Called if a new unresolved {@link DelayedReference} is registered within 
     * {@link GlobalDelayedReferenceResolver}.
     * 
     * @param ref the newly registered {@link DelayedReference}.
     */
    void unresolvedReferenceRegistered(DelayedReference ref);
    
    /**
     * Called if a {@link DelayedReference} that was registered at the {@link GlobalDelayedReferenceResolver}
     * gets resolved.
     * 
     * @param ref The resolved reference.
     */
    void referenceResolved(DelayedReference ref);
    
    
    /**
     * Called when outdated references are removed.
     * 
     * @param refs the references that are no longer maintained by the {@link GlobalDelayedReferenceResolver}.
     */
    void outdatedReferencesRemoved(Collection<DelayedReference> refs);
    
}
