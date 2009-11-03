package com.sap.tc.moin.ocl.evaluator.stdlib;

/**
 * Wrapper class that holds a reference to an underlying primitive integer 
 * value, and defines the supported methods.
 */
public interface OclInteger extends OclFloat {

    /**
     * Convenience method to get the underlying Integer without having to cast 
     * it.
     * 
     * @return the Integer
     */
    public Integer getWrappedInteger( );
}
