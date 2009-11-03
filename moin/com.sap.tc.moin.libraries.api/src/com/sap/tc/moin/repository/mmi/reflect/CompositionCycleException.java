package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception thrown when an instance object is a component of itself.
 */
public class CompositionCycleException extends JmiException {

    private static final long serialVersionUID = 1L;


    /**
     * @param objectInError
     * @param elementInError
     * @param msg
     * @param args
     */
    public CompositionCycleException( Object objectInError, RefObject elementInError, MoinLocalizedString msg, Object... args ) {

        super( objectInError, elementInError, msg, args );
    }
}