package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown to indicate that provided parameter or element of collection is is of
 * wrong type.
 */
public class TypeMismatchException extends JmiException {

    private static final long serialVersionUID = 1L;

    private final Class<? extends Object> myExcpectedType;

    /**
     * @param expectedType
     * @param objectInError
     * @param elementInError
     */
    public TypeMismatchException( Class<? extends Object> expectedType, Object objectInError, RefObject elementInError ) {

        super( objectInError, elementInError, JmiExceptionMessages.TYPEMISMATCHNOINFO );
        this.myExcpectedType = expectedType;
    }

    /**
     * @param expectedType
     * @param objectInError
     * @param elementInError
     * @param msg technical information
     */
    public TypeMismatchException( Class<? extends Object> expectedType, Object objectInError, RefObject elementInError, String msg ) {

        super( objectInError, elementInError, JmiExceptionMessages.TYPEMISMATCHWITHINFO, msg );
        this.myExcpectedType = expectedType;
    }

    /**
     * @param expectedType
     * @param objectInError
     * @param elementInError
     * @param message
     * @param args
     */
    public TypeMismatchException( Class<? extends Object> expectedType, Object objectInError, RefObject elementInError, MoinLocalizedString message, Object... args ) {

        super( objectInError, elementInError, message, args );
        this.myExcpectedType = expectedType;
    }

    /**
     * Returns class of expected type.
     * 
     * @return expected type.
     */
    public Class<? extends Object> getExpectedType( ) {

        return this.myExcpectedType;
    }
}
