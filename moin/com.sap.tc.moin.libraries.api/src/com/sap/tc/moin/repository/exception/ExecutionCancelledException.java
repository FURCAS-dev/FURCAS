package com.sap.tc.moin.repository.exception;

import com.sap.tc.moin.repository.mmi.reflect.JmiExceptionMessages;

/**
 * Thrown by execution calls (e.g. JMI, partition management and commands) to
 * indicate that a user requested cancellation. Depending on the execution
 * context, any partial modification will be rolled back. This exception can
 * also be manually thrown from inside a
 * {@link com.sap.tc.moin.repository.commands.Command#doExecute()} to abort the
 * execution.
 */
public class ExecutionCancelledException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -5207715261216230148L;

    /**
     * Message: {@link JmiExceptionMessages#ACTIONCANCELED}
     * 
     * @param message will be ignored
     * @deprecated use the no-args constructor
     */
    @Deprecated
    public ExecutionCancelledException( String message ) {

        super( JmiExceptionMessages.ACTIONCANCELED );
    }

    /**
     * Message: {@link JmiExceptionMessages#ACTIONCANCELED}
     * 
     * @param message will be ignored
     * @param exception root cause
     * @deprecated use the no-args constructor
     */
    @Deprecated
    public ExecutionCancelledException( String message, Throwable exception ) {

        super( JmiExceptionMessages.ACTIONCANCELED );
    }

    /**
     * Message: {@link JmiExceptionMessages#ACTIONCANCELED}
     */
    public ExecutionCancelledException( ) {

        super( JmiExceptionMessages.ACTIONCANCELED );
    }

}
