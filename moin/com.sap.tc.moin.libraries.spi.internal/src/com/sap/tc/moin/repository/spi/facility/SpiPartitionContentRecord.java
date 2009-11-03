/*
 * Created on 13.06.2008
 */
package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.PRI;

/**
 * Data record for partition content.
 */
public interface SpiPartitionContentRecord extends SpiContentRecord {

    /** @return The {@link PRI} related to this update record. */
    public PRI getPri( );

}
