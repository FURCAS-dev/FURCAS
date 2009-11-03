package com.sap.tc.moin.ocl.evaluator.stdlib;

/**
 * Represents the OclVoid class and its single OclUndefined instance, and
 * defines the supported methods. For more details about the methods, see the
 * Undefined Values section at the end of 7.4 in the <a
 * href="http://www.omg.org/docs/ptc/03-10-14.pdf">UML 2.0 OCL Specification</a>
 * (PDF).
 */
public interface OclVoid extends OclAny {

    /**
     * This method is not intended to be called on OclVoid, and will throw a
     * RuntimeException if it is.
     * 
     * @throws InvalidValueException if the wrapped object is an instance of
     * {@link OclInvalid}
     */
    public Object getWrappedObject( );
}
