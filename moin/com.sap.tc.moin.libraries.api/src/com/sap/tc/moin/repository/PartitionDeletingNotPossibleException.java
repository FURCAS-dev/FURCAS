package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown if deleting a partition is not possible.
 */
public class PartitionDeletingNotPossibleException extends PartitionChangingNotPossibleException {


    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param pri
     */
    public PartitionDeletingNotPossibleException( MoinLocalizedString message, PRI pri ) {

        super( message, pri );
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param rootCause the root cause for this exception
     * @param message the localized message
     * @param pri the concerned partition
     */
    public PartitionDeletingNotPossibleException( Throwable rootCause, MoinLocalizedString message, PRI pri ) {

        super( rootCause, message, pri );
    }

    /**
     * Creates an instance of this exception.
     * <p>
     * Remark:
     * <p>
     * This constructor is reasonable in case the rootException is a
     * PartitionException, i.e. it already contains the PRI.
     * 
     * @param rootException the root exception for this exception (contains the
     * root cause)
     */
    public PartitionDeletingNotPossibleException( MoinLocalizedBaseRuntimeException rootException ) {

        super( rootException );
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param message the message
     * @param pri the concerned partition
     * @param args the arguments of the message (might contain the pri again at
     * any position)
     */
    public PartitionDeletingNotPossibleException( MoinLocalizedString message, PRI pri, Object... args ) {

        super( message, pri, args );
    }

}
