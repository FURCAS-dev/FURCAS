package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown if editing a partition is not possible.
 */
public class PartitionEditingNotPossibleException extends PartitionChangingNotPossibleException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param pri
     */
    public PartitionEditingNotPossibleException( MoinLocalizedString message, PRI pri ) {

        super( message, pri );
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param rootCause the root cause for this exception
     * @param message the localized message
     * @param pri the concerned partition
     */
    public PartitionEditingNotPossibleException( Throwable rootCause, MoinLocalizedString message, PRI pri ) {

        super( rootCause, message, pri );
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param message the message
     * @param pri the concerned partition
     * @param args the arguments of the message (might contain the pri again at
     * any position)
     */
    public PartitionEditingNotPossibleException( MoinLocalizedString message, PRI pri, Object... args ) {

        super( message, pri, args );
    }

}
