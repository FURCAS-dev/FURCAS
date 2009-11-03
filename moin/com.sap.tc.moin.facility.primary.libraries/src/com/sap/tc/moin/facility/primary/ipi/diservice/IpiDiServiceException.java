package com.sap.tc.moin.facility.primary.ipi.diservice;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;



public class IpiDiServiceException extends MoinLocalizedBaseRuntimeException {

    /** ******************** Internals ************************************** */

    private static final long serialVersionUID = -2257435416232870893L;

    /** ******************** Construction *********************************** */

    /**
     * @param message
     * @param args
     */
    public IpiDiServiceException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * @param rootCause
     * @param message
     * @param args
     */
    public IpiDiServiceException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( rootCause, message, args );
    }

    /** ********************* Interface ************************************* */

}
