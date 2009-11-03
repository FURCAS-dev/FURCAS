package com.sap.tc.moin.repository.exception;

import com.sap.tc.moin.repository.mmi.reflect.JmiExceptionMessages;


/**
 * Thrown by execution calls (e.g. JMI, partition management and commands) to
 * indicate that the execution could not be completed due to an error that does
 * not allow to roll back partial modifications leading to possible
 * inconsistencies in the repository. Note that any other RuntimeException
 * thrown by execution calls would imply that any partial modification was
 * rolled back.
 */
public class UnrecoverableExecutionException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -3745951691621875026L;

    /**
     * Message: {@link JmiExceptionMessages#UNRECOVERABLEEXCEPTIONOCCURED}
     * 
     * @param rootCause root cause
     */
    public UnrecoverableExecutionException( Throwable rootCause ) {

        super( rootCause, JmiExceptionMessages.UNRECOVERABLEEXCEPTIONOCCURED );
    }


    /**
     * Generic constructor
     * 
     * @param message {@link MoinLocalizedString}
     * @param cause root cause
     * @param args arguments
     */
    public UnrecoverableExecutionException( Throwable cause, MoinLocalizedString message, Object... args ) {

        super( cause, message, args );
    }

}
