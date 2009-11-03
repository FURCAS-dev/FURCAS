package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown by reflection methods when client tries to call them incorrectly.
 * (e.g. when <code>refSetValue</code> is called for attribute which is not
 * changeable)
 */
public class InvalidCallException extends JmiException {

    private static final long serialVersionUID = 1L;

    /**
     * @param objectInError
     * @param elementInError
     */
    public InvalidCallException( Object objectInError, RefObject elementInError ) {

        super( objectInError, elementInError, JmiExceptionMessages.INVALIDCALLNOINFO );
    }

    /**
     * @param objectInError
     * @param elementInError
     * @param msg
     */
    public InvalidCallException( Object objectInError, RefObject elementInError, String msg ) {

        super( objectInError, elementInError, JmiExceptionMessages.INVALIDCALLWITHINFO, msg );
    }

    /**
     * @param objectInError
     * @param elementInError
     * @param message
     * @param args
     */
    public InvalidCallException( Object objectInError, RefObject elementInError, MoinLocalizedString message, Object... args ) {

        super( objectInError, elementInError, message, args );
    }
}