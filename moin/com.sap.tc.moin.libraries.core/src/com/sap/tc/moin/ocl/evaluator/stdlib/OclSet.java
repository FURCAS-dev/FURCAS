package com.sap.tc.moin.ocl.evaluator.stdlib;

import java.util.Set;

/**
 * Wrapper class that holds a reference to an underlying Set value, and defines 
 * the supported methods.
 */
public interface OclSet extends OclCollection {

    /**
     * Convenience method to get the underlying set without having to cast it.
     * 
     *  @return the wrapped Set
     */
    public Set<OclAny> getWrappedSet( );
}
