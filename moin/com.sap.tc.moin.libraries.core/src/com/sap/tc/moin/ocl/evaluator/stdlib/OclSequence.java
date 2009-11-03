package com.sap.tc.moin.ocl.evaluator.stdlib;

import java.util.List;

/**
 * Wrapper class that holds a reference to an underlying sequence value, and 
 * defines the supported methods.
 */
public interface OclSequence extends OclCollection {

    /**
     * Convenience method to get the underlying sequence without having to cast 
     * it.
     * 
     * @return the wrapped Sequence
     */
    public List<OclAny> getWrappedSequence( );
}
