package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown when a user passes an invalid feature name to a reflective method.
 */
public class InvalidNameException extends JmiException {

    private static final long serialVersionUID = 1L;

    private final String myInvalidName;

    /**
     * Constructs an <code>InvalidNameException</code> without detail message.
     * 
     * @param invalidName Invalid name.
     */
    public InvalidNameException( String invalidName ) {

        super( JmiExceptionMessages.INVALIDNAME, invalidName );
        this.myInvalidName = invalidName;
    }

    /**
     * @param invalidName
     * @param message
     * @param args
     */
    public InvalidNameException( String invalidName, MoinLocalizedString message, Object... args ) {

        super( message, args );
        this.myInvalidName = invalidName;
    }

    /**
     * Returns invalid name.
     * 
     * @return invalid name.
     */
    public String getInvalidName( ) {

        return this.myInvalidName;
    }
}
