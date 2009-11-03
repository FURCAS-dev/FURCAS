package com.sap.tc.moin.ocl.evaluator.stdlib;

/**
 * Wrapper class that holds a reference to an underlying primitive string value,
 * and defines the supported methods.
 */
public interface OclString extends OclAny {

    /**
     * Convenience method to get the underlying String without having to cast 
     * it.
     * 
     * @return the wrapped String
     */
    public String getWrappedString( );
}
