package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.ocl.evaluator.util.OrderedSet;

/**
 * Wrapper class that holds a reference to an underlying OrderedSet value, and 
 * defines the supported methods.
 */
public interface OclOrderedSet extends OclSet {

    /**
     * Convenience method to get the underlying ordered set without having to 
     * cast it.
     * 
     * @return the wrapped Set
     */
    public OrderedSet getWrappedOrderedSet( );
}
