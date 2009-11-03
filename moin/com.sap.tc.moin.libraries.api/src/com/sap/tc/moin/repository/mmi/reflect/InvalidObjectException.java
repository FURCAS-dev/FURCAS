package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception thrown when an object operation detects a non-existing (i.e.
 * deleted) object.
 */
public class InvalidObjectException extends JmiException {

    private static final long serialVersionUID = 1L;


    /**
     * @param elementInError
     * @param message
     * @param args
     */
    public InvalidObjectException( RefObject elementInError, MoinLocalizedString message, Object... args ) {

        super( elementInError, message, args );
    }
}
