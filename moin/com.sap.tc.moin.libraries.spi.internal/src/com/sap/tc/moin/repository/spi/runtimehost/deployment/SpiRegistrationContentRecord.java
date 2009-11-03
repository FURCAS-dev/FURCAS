package com.sap.tc.moin.repository.spi.runtimehost.deployment;

import com.sap.tc.moin.repository.spi.facility.SpiContentRecord;

/**
 * Record containing registration file content.
 * 
 * @author D026715
 */
public interface SpiRegistrationContentRecord extends SpiContentRecord {

    /**
     * Returns the name of the registration content.
     * 
     * @return
     */
    String getRegistrationContentName( );

}
