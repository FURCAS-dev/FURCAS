package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown if a workspace is asked to evict a partition but cannot.
 * 
 * @author D043530
 */
public final class CannotEvictPartitionException extends MoinLocalizedBaseRuntimeException {

    /**
     * Needed for JLin
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor takes message and partition.
     * 
     * @param messageId the message id
     * @param mp the offending model partition
     */
    public CannotEvictPartitionException( MoinLocalizedString messageId, ModelPartition mp ) {

        super( messageId, mp.getPri( ).toString( ) );
        this.modelPartition = mp;
    }

    /**
     * Obtains the partition that cannot be evicted.
     * 
     * @return the offending model partition
     */
    public ModelPartition getPartition( ) {

        return this.modelPartition;
    }

    // ----------------- attributes ----------------
    /**
     * The model partition that cannot be evicted
     */
    private ModelPartition modelPartition;
}