package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;


/**
 *
 */
public class MMDeploymentRuntimeException extends MoinBaseRuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * @deprecated use a localized constructor instead
     */
    public MMDeploymentRuntimeException( Throwable rootCause, String message ) {

        super( message, rootCause );
    }

    /**
     * @param rootCause
     * @param message
     * @param args
     */
    public MMDeploymentRuntimeException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( rootCause, message, args );
    }

    /**
     * @param message
     * @param args
     */
    public MMDeploymentRuntimeException( MoinLocalizedString message, Object... args ) {

        super( message, args );

    }

}
