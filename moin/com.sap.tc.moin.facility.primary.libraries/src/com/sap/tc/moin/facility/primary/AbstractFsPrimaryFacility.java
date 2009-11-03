package com.sap.tc.moin.facility.primary;

import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * TODO: move this functionality to the test helper and get rid of this class
 * again!
 */
public abstract class AbstractFsPrimaryFacility extends AbstractPrimaryFacility implements IpiPrimaryFacility, IpiFsFacilityForTest, SpiFacilityLifecycle {

    public AbstractFsPrimaryFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

        super( core, serializationManager, runtimeContext );
    }

    /*
     * internal components for testing which are available for both primary
     * facilities
     */
    abstract public IpiFsResourceManagement getResourceManagement( );

}
