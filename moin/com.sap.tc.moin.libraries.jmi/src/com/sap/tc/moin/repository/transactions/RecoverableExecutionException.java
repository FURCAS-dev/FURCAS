package com.sap.tc.moin.repository.transactions;

import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown by micro transaction execution calls to indicate that the execution
 * could not be completed due to an error that does allow to rollback partial
 * modifications.
 */
public class RecoverableExecutionException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 42L;

    /**
     * @param aRootCause
     */
    public RecoverableExecutionException( RuntimeException aRootCause ) {

        super( aRootCause, JmiCoreMessages.RECOVERABLEEXCEPTIONOCCUREDX, aRootCause.getLocalizedMessage( ) );
    }

    /**
     * @param aRootCause
     * @param message
     * @param args
     */
    public RecoverableExecutionException( RuntimeException aRootCause, MoinLocalizedString message, Object... args ) {

        super( aRootCause, message, args );
    }

    /**
     * @param aRootCause
     */
    public RecoverableExecutionException( MoinLocalizedBaseRuntimeException aRootCause ) {

        super( aRootCause );
    }

    /**
     * @param message
     * @param args
     */
    public RecoverableExecutionException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }


}
