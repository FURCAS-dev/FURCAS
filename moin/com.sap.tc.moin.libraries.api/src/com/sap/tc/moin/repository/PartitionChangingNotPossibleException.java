package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Common base class for grouping the exceptions which indicate that creating,
 * editing or deleting a partition is not possible.
 */
public abstract class PartitionChangingNotPossibleException extends PartitionException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param pri
     */
    public PartitionChangingNotPossibleException( MoinLocalizedString message, PRI pri ) {

        super( message, pri );
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param rootCause the root cause for this exception
     * @param message the message
     * @param pri the concerned partition
     */
    public PartitionChangingNotPossibleException( Throwable rootCause, MoinLocalizedString message, PRI pri ) {

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
    public PartitionChangingNotPossibleException( MoinLocalizedBaseRuntimeException rootException ) {

        super( rootException );
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
    public PartitionChangingNotPossibleException( MoinLocalizedBaseRuntimeException rootException, PRI pri ) {

        super( rootException, pri );
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param message the message
     * @param pri the concerned partition
     * @param args the arguments of the message (might contain the pri again at
     * any position)
     */
    public PartitionChangingNotPossibleException( MoinLocalizedString message, PRI pri, Object... args ) {

        super( message, pri, args );
    }


}
