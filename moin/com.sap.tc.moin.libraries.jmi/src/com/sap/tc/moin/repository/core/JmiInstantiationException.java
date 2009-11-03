package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * 
 */
public class JmiInstantiationException extends MoinLocalizedBaseRuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * @param rootCause
     */
    public JmiInstantiationException( Throwable rootCause ) {

        super( rootCause, JmiCoreMessages.JMIINSTANTIATIONFAILED, rootCause.getMessage( ) );
    }


}
