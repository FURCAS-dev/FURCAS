package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * 
 */
public class SpiFacilityQueryServiceException extends MoinLocalizedBaseRuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * Occurred error not further specified
     */
    public static final int ERROR_CODE_UNSPECIFIED = 0;

    /**
     * The result set of the query is too large.
     */
    public static final int ERROR_CODE_RESULTSET_TOO_LARGE = 1;

    /**
     * A query for all instances of Reflect::Element was fired with exclusive
     * scope
     */
    public static final int ERROR_CODE_REFLECT_ELEMENT = 2;

    private int errorCode;

    public SpiFacilityQueryServiceException( int errorCode, MoinLocalizedString message, Object... args ) {

        super( message, args );
        this.errorCode = errorCode;
    }

    public SpiFacilityQueryServiceException( Throwable cause, int errorCode, MoinLocalizedString message, Object... args ) {

        super( cause, message, args );
        this.errorCode = errorCode;
    }

    /**
     * Gets the error code.
     * 
     * @return {@link #ERROR_CODE_REFLECT_ELEMENT},
     * {@link #ERROR_CODE_RESULTSET_TOO_LARGE} or
     * {@link #ERROR_CODE_UNSPECIFIED}
     */
    public int getErrorCode( ) {

        return this.errorCode;
    }
}
