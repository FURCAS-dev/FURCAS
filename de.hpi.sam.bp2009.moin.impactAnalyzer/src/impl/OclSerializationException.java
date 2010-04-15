package com.sap.tc.moin.ocl.utils.impl;

/**
 * This exception is thrown if anything goes wrong during serialization of an
 * OclStatement or OclExpression.
 */
public class OclSerializationException extends Exception {

    private static final long serialVersionUID = 1L;


    /**
     * @param root the root cause
     */
    public OclSerializationException( Throwable root ) {

        super( root );

    }

    /**
     * @param message the message
     */
    public OclSerializationException( String message ) {

        super( message );
    }

}
