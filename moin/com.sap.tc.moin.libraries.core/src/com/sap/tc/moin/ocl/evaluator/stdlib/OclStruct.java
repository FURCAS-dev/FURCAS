package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

/**
 * The wrapper for RefStruct objects
 */
public interface OclStruct extends OclAny {

    /**
     * Convenience method to get the underlying RefStruct without having to cast it.
     * 
     * @return the wrapped RefStruct
     */
    public RefStruct getWrappedRefStruct( );

    /**
     * @param name the structure field name
     * @return the field value
     */
    public OclAny getValue( String name );
}
