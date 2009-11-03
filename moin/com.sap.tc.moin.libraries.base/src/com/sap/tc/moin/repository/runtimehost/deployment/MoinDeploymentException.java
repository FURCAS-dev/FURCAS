package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;


/**
 *
 */
public class MoinDeploymentException extends MoinLocalizedBaseRuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    /**
     * @param message
     * @param args
     */
    public MoinDeploymentException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * @param rootCause
     * @param message
     * @param args
     */
    public MoinDeploymentException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( message, args );
        this.initCause( rootCause );
    }

}
