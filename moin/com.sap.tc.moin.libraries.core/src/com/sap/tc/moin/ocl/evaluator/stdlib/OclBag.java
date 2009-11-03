package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.ocl.evaluator.util.Bag;

/**
 * Wrapper class that holds a reference to an underlying bag value, and defines 
 * the supported methods.
 */
public interface OclBag extends OclCollection {

    /**
     * Convenience method to get the underlying bag without having to cast it.
     * 
     * @return the wrapped bag
     */
    public Bag getWrappedBag( );
}
