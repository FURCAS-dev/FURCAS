package com.sap.tc.moin.repository.ocl.notification;

import sun.org.mozilla.javascript.internal.EvaluatorException;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * The base class for OclManager Exceptions
 */
public class OclManagerException extends MoinLocalizedBaseException {

    private static final long serialVersionUID = 1L;

    /**
     * Generic constructor
     * 
     * @param cause root cause
     * @param message {@link MoinLocalizedString}
     * @param args arguments
     */
    public OclManagerException( Throwable cause, MoinLocalizedString message, Object... args ) {

        super( cause, message, args );
    }

    /**
     * Generic constructor
     * 
     * @param message {@link MoinLocalizedString}
     * @param parameters arguments
     */
    public OclManagerException( MoinLocalizedString message, Object... parameters ) {

        super( message, parameters );
    }

    /**
     * Generic constructor
     * 
     * @param rootCause root cause
     */
    public OclManagerException( MoinLocalizedBaseException rootCause ) {

        super( rootCause );
    }
    
    @Override
    public String getMessage() {
	if (getCause() == null || !(getCause() instanceof EvaluatorException)) {
	    return super.getMessage();
	} else {
	    return super.getMessage()+", caused by "+getCause().getMessage();
	}
    }
}
