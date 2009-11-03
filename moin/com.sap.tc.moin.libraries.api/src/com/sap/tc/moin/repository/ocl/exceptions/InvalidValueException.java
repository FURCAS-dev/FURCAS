package com.sap.tc.moin.repository.ocl.exceptions;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Indicates an invalid value encountered at Runtime
 * <p>
 * For example, a division by zero would result in this Exception
 */
public class InvalidValueException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Generic constructor
     * 
     * @param message {@link MoinLocalizedString}
     */
    public InvalidValueException( MoinLocalizedString message ) {

        super( message );
    }
}
