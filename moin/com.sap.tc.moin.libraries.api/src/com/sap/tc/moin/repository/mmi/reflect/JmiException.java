package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Ancestor for all JMI exceptions thrown by reflective and generated methods.
 * This exception is not abstract as the standard JmiException is. It also has a
 * serial version ID.
 */
public class JmiException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 7819788037933959109L;

    private RefObject myElementInError;

    private Object myObjectInError;

    // Makes sure that the elementInError can be replaced at most once.
    private boolean elementInErrorReplaced = false;

    // Makes sure that the objectInError can be replaced at most once.
    private boolean objectInErrorReplaced = false;


    /**
     * Constructs new <code>JmiException</code> without detail message.
     * 
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method).
     */
    public JmiException( Throwable cause ) {

        super( cause, JmiExceptionMessages.UNEXPECTEDEXCEPTION, cause.getMessage( ) );
    }

    /**
     * @param elementInError
     * @param message
     * @param args
     */
    public JmiException( RefObject elementInError, MoinLocalizedString message, Object... args ) {

        super( message, args );
        this.myElementInError = elementInError;

    }


    /**
     * @param objectInError
     * @param elementInError
     * @param message
     * @param args
     */
    public JmiException( Object objectInError, RefObject elementInError, MoinLocalizedString message, Object... args ) {

        super( message, args );
        this.myObjectInError = objectInError;
        this.myElementInError = elementInError;
    }

    /**
     * @param message
     * @param args
     */
    public JmiException( MoinLocalizedString message, Object... args ) {

        super( message, args );

    }


    /**
     * @param objectInError
     * @param elementInError
     * @param cause
     */
    public JmiException( Object objectInError, RefObject elementInError, MoinLocalizedBaseException cause ) {

        super( cause );
        this.myObjectInError = objectInError;
        this.myElementInError = elementInError;
    }

    /**
     * Returns element in error.
     * 
     * @return element in error.
     */
    public RefObject getElementInError( ) {

        return this.myElementInError;
    }

    /**
     * MOIN INTERNAL USE ONLY!
     * <p>
     * The method is required for replacing the elementInError after
     * construction of the exception with a wrapped equivalent, without losing
     * the stack trace.
     * 
     * @param elementInError
     */
    public void setElementInError( RefObject elementInError ) {

        if ( !this.elementInErrorReplaced ) {
            this.myElementInError = elementInError;
            this.elementInErrorReplaced = true;
        }
    }

    /**
     * MOIN INTERNAL USE ONLY!
     * <p>
     * The method is required for replacing the objectInError after construction
     * of the exception with a wrapped equivalent, without losing the stack
     * trace.
     * 
     * @param objectInError
     */
    public void setObjectInError( Object objectInError ) {

        if ( !this.objectInErrorReplaced ) {
            this.myObjectInError = objectInError;
            this.objectInErrorReplaced = true;
        }
    }

    /**
     * Returns object in error.
     * 
     * @return object in error
     */
    public Object getObjectInError( ) {

        return this.myObjectInError;
    }
}