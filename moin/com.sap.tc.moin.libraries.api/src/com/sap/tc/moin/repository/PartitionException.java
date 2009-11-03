package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Base class for exceptions around a single partition. Therefore it contains
 * the PRI of the concerned partition.
 */
public abstract class PartitionException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    private transient PRI myPri;

    /**
     * @param message
     * @param pri
     */
    public PartitionException( MoinLocalizedString message, PRI pri ) {

        super( message, pri );
        this.myPri = pri;
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param message the message
     * @param pri the concerned partition
     * @param args the arguments of the message (might contain the pri again at
     * any position)
     */
    public PartitionException( MoinLocalizedString message, PRI pri, Object... args ) {

        super( message, args );
        myPri = pri;
    }

    /**
     * Creates an instance of this exception.
     * 
     * @param rootCause the root cause for this exception
     * @param message the message
     * @param pri the concerned partition
     */
    public PartitionException( Throwable rootCause, MoinLocalizedString message, PRI pri ) {

        super( rootCause, message, pri.toString( ) );
        this.myPri = pri;
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
    public PartitionException( MoinLocalizedBaseRuntimeException rootException ) {

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
    public PartitionException( MoinLocalizedBaseRuntimeException rootException, PRI pri ) {

        super( rootException );
        this.myPri = pri;
    }

    /**
     * Get the MRI of the partition this exception refers to.
     * 
     * @return the MRI of the partition this exception refers to.
     */
    public PRI getPri( ) {

        return this.myPri;
    }

}
