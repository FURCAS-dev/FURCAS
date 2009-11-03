package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.repository.mmi.reflect.RefEnum;

/**
 * Wrapper class that holds a reference to an underlying {@link RefEnum}
 * value, and defines the supported methods.
 */
public interface OclEnum extends OclAny {

    /**
     * Convenience method to get the underlying RefEnum without having to cast 
     * it.
     * 
     * @return the wrapped enum
     */
    public RefEnum getWrappedRefEnum( );
}
