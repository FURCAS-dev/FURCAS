package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * Defines the IDE-specific contract between the facilities and the MOIN
 * RuntimeHost, which is technically bases on the extension point mechanism of
 * Eclipse.
 */
public interface SpiFacilityFactory {

    /**
     * Returns instance of the {@link SpiFacility}.
     * 
     * @param core The {@link SpiCore} instance the returned facility has to
     * interact with.
     * @return A facility instance.
     */
    public SpiFacility getFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext );

}
