package com.sap.mi.textual.parsing.textblocks.reference;

import com.sap.mi.textual.grammar.impl.DelayedReference;

/**
 * This interface is provided as a listener for the {@link GlobalDelayedReferenceResolver}. 
 */
public interface ReferenceResolvingListener {
    
    /**
     * Called if a {@link DelayedReference} was successfully resolved.
     * 
     * @param ref The resolved reference.
     * @param valueSetOnProperty 
     * @param valueRemovedFromProperty 
     */
    public void referenceResolved(DelayedReference ref, Object valueSetOnProperty);
    
    
    /**
     * Called when outdated links are removed.
     * 
     * @param ref The resolved reference.
     * @param valueRemovedFromProperty 
     */
    public void outdatedReferencesRemoved(DelayedReference ref, Object valueRemovedFromProperty);
    
}
