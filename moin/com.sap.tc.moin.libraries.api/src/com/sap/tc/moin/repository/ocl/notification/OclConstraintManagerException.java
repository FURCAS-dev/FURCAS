package com.sap.tc.moin.repository.ocl.notification;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * The base Exception class for OclConstraintManager Exceptions.
 */
public class OclConstraintManagerException extends OclManagerException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    /**
     * Generic constructor
     * 
     * @param message {@link MoinLocalizedString}
     * @param args arguments
     */
    public OclConstraintManagerException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * Generic constructor
     * 
     * @param rootCause root cause
     * @param message {@link MoinLocalizedString}
     * @param args arguments
     */
    public OclConstraintManagerException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( rootCause, message, args );
    }

    /**
     * @param rootCause root cause
     */
    public OclConstraintManagerException( MoinLocalizedBaseException rootCause ) {

        super( rootCause );
    }

}
