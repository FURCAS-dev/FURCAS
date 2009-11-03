package com.sap.tc.moin.repository.mmi.xmi;

import com.sap.tc.moin.repository.mmi.reflect.JmiExceptionMessages;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;

/**
 * The <code>MalformedXMIException</code> is thrown when the XMIReader is given
 * a malformed XMI element.
 */
public class MalformedXMIException extends MoinLocalizedBaseException {

    /**
     * Constructs an instance of <code>MalformedXMIException</code> with the
     * specified detail message.
     * 
     * @param cause the cause of the exception
     */
    public MalformedXMIException( Exception cause ) {

        super( cause, JmiExceptionMessages.MALFORMEDXMI, cause.getMessage( ) );
    }

    private static final long serialVersionUID = 1L;
}
