package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown if creating a partition on persistence is not possible.
 */
public class PartitionCreatingNotPossibleException extends PartitionChangingNotPossibleException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param pri
     */
    public PartitionCreatingNotPossibleException( MoinLocalizedString message, PRI pri ) {

        super( message, pri );
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param rootCause the root cause for this exception
     * @param message the localized message
     * @param pri the concerned partition
     */
    public PartitionCreatingNotPossibleException( Throwable rootCause, MoinLocalizedString message, PRI pri ) {

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
    public PartitionCreatingNotPossibleException( MoinLocalizedString message, PRI pri, Object... args ) {

        super( message, pri, args );
    }

    /**
     * Creates an instance of this exception.
     * <p>
     * Remark:
     * <p>
     * This constructor is needed in case the rootException is no
     * PartitionException, i.e. it does not contain the PRI.
     * 
     * @param rootException the root exception for this exception (contains the
     * root cause)
     * @param pri the concerned partition
     */
    public PartitionCreatingNotPossibleException( MoinLocalizedBaseRuntimeException rootException, PRI pri ) {

        super( rootException, pri );
    }


}
