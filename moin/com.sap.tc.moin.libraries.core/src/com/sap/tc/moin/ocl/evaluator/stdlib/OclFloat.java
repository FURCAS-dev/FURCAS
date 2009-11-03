package com.sap.tc.moin.ocl.evaluator.stdlib;

/**
 * Wrapper class that holds a reference to an underlying primitive float value,
 * and defines the supported methods.
 * 
 * Note that OclFlaot doesn't differentiate between <code>0.0</code> and 
 * <code>-0.0</code>, both are treated as <code>0.0</code>. This is done to 
 * avoid problems with the way the Float wrapper implements the equals method
 * when comparing the two values.
 */
public interface OclFloat extends OclAny {

    /**
     * Convenience method to get the underlying Float without having to cast 
     * it.
     * 
     * @return the wrapped Float
     */
    public Float getWrappedFloat( );
}
