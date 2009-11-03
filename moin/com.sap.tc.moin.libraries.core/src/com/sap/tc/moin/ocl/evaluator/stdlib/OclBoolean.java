package com.sap.tc.moin.ocl.evaluator.stdlib;

/**
 * Wrapper class that holds a reference to an underlying primitive boolean
 * value, and defines the supported methods.
 */
public interface OclBoolean extends OclAny {

    /** Instance representing true */
    OclBoolean TRUE = (OclBoolean) OclFactory.instance( ).create( Boolean.TRUE );

    /** Instance representing false */
    OclBoolean FALSE = (OclBoolean) OclFactory.instance( ).create( Boolean.FALSE );

    /**
     * Convenience method to get the underlying Boolean without having to cast
     * it.
     * 
     * @return the wrapped boolean
     */
    public Boolean getWrappedBoolean( );
}