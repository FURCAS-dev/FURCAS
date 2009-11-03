package com.sap.tc.moin.repository.ide.metamodels;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.ide.localization.RuntimeEpiMessages;

/**
 * @deprecated
 */
public class MoinDeploymentException extends MoinLocalizedBaseRuntimeException {

    /**
     * @deprecated
     */
    public MoinDeploymentException( String message, Throwable rootCause ) {

        super( rootCause, RuntimeEpiMessages.MOINDEPLOYMENTEXCEPTIONMESSAGE, message );
    }

    private static final long serialVersionUID = -4086081778395199910L;

}
