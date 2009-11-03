package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception thrown when a collection passed to an operation parameter with
 * <CODE>isUnique</CODE> set to true contains duplicate values.
 */
public class DuplicateException extends JmiException {

    private static final long serialVersionUID = 1L;

    /**
     * @param objectInError
     * @param elementInError
     * @param msg technical information
     */
    public DuplicateException( Object objectInError, RefObject elementInError, String msg ) {

        super( objectInError, elementInError, JmiExceptionMessages.DUPLICATE, msg );
    }

    /**
     * @param objectInError
     * @param elementInError
     * @param msg technical information
     * @param message
     * @param args
     */
    public DuplicateException( Object objectInError, RefObject elementInError, MoinLocalizedString message, Object... args ) {

        super( objectInError, elementInError, message, args );
    }
}