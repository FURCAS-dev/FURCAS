package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Wrapper class that holds a reference to an underlying {@link RefObject}
 * value, and defines the supported methods.
 */
public interface OclModelElement extends OclAny {

    /**
     * Convenience method to get the underlying RefObject without having to 
     * cast it.
     * 
     * @return the wrapped object
     */
    public RefObject getWrappedRefObject( );
}
