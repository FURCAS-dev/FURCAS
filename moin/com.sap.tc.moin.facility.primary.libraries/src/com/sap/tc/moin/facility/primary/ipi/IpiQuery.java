package com.sap.tc.moin.facility.primary.ipi;

import java.util.Collection;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;

/**
 * IPI interface for facility internal query functionality.
 * 
 * @author d047015
 */
public interface IpiQuery {

    /**
     * Returns all {@link PRI PRIs} stored in the given container.
     * 
     * @param cri The {@link CRI} of the container whose partitions are
     * requested.
     * @return All {@link PRI PRIs} stored in the given container.
     */
    public Collection<PRI> getPartitionsInContainer( CRI cri );

}
