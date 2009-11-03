package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception which arises when a collection contains fewer or more values than
 * is required by the corresponding <CODE>Multiplicity.lower</CODE> and
 * <code>Multiplicity.upper</code>.
 */
public class WrongSizeException extends JmiException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates <CODE>WrongSizeException</CODE> with a detail message.
     * 
     * @param elementInError element in error.
     * @param msg detail message.
     */
    public WrongSizeException( RefObject elementInError, String msg ) {

        super( elementInError, JmiExceptionMessages.WRONGSIZEWITHINFO, msg );
    }

    /**
     * Creates <CODE>WrongSizeException</CODE> with a detail message.
     * 
     * @param elementInError element in error.
     * @param message
     * @param args
     */
    public WrongSizeException( RefObject elementInError, MoinLocalizedString message, Object... args ) {

        super( elementInError, message, args );
    }
}
