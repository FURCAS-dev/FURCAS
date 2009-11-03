package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Base exception for exceptions thrown when an inconsistency in the model
 * detected
 */
public class InconsistentModelException extends JmiException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param args
     */
    public InconsistentModelException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

}