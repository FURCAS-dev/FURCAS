package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Base interface for all OCL wrapper objects, including {@link OclVoid}.
 */
public interface OclAny {

    /**
     * Execute the operation whose name is supplied on this object, with the
     * supplied arguments, and return the result.
     * 
     * @param connection the core connection
     * @param opName the name of the operation
     * @param args the operation arguments
     * @return the result of the operation
     * @throws OperationNotFoundException Thrown if the operation is not
     * recognized for this object. We assume the semantic analysis during
     * parsing captures all such errors - therefore this shouldn't be thrown,
     * unless a programming error has been made.
     */
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException;

    /**
     * Returns the underlying object that the OclAny instance is wrapping.
     * 
     * @return the wrapped object The exception to this is when the object is an
     * instance of OclVoid, i.e.
     * {@link com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl#OCL_UNDEFINED
     * OclUndefined}, in which case this method will throw a RuntimeException.
     * Care must be taken by calling code to check for OclUndefined and handle
     * it appropriately before calling this method.
     */
    public Object getWrappedObject( );
}
