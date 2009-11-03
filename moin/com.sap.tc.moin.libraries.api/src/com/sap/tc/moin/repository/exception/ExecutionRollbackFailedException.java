package com.sap.tc.moin.repository.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Thrown by execution calls (i.e. JMI, partition management and commands) to
 * indicate that the roll back of partial modifications could not be completed
 * leading to possible inconsistencies in the repository. The exception that
 * triggered the roll back can be retrieved with {
 * {@link #getOriginalTransactionException()}.
 * 
 * @see UnrecoverableExecutionException
 */

public class ExecutionRollbackFailedException extends UnrecoverableExecutionException {

    private Exception originalTransactionException;

    /**
     * @param originalException The exception that triggered the roll back
     * @param rollbackException The exception that was raised during the roll
     * back
     */
    public ExecutionRollbackFailedException( RuntimeException originalException, RuntimeException rollbackException ) {

        super( rollbackException );
        this.originalTransactionException = originalException;
    }

    /**
     * @return The exception that triggered the roll back
     */
    public Exception getOriginalTransactionException( ) {

        return this.originalTransactionException;
    }

    @Override
    public void printStackTrace( PrintStream s ) {

        synchronized ( s ) {
            super.printStackTrace( s );
            s.println( "Execution rollback caused by: " ); //$NON-NLS-1$ stacktrace is always in EN
            this.originalTransactionException.printStackTrace( s );
        }

    }

    @Override
    public void printStackTrace( PrintWriter s ) {

        synchronized ( s ) {
            super.printStackTrace( s );
            s.println( "Execution rollback caused by: " ); //$NON-NLS-1$ stacktrace is always in EN
            this.originalTransactionException.printStackTrace( s );
        }

    }



    static final long serialVersionUID = -3387416966124229948L;
}
