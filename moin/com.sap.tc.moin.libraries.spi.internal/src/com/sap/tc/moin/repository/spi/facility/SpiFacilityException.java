package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;

/**
 * The parent for all Exceptions originating within a Facility.
 */
public class SpiFacilityException extends MoinBaseRuntimeException {


    private static final long serialVersionUID = 1L;


    /**
     * @param message
     */
    public SpiFacilityException( String message ) {

        super( message );
    }


    /**
     * @param message
     * @param rootCause
     */
    public SpiFacilityException( String message, Throwable rootCause ) {

        super( message, rootCause );
    }

}
