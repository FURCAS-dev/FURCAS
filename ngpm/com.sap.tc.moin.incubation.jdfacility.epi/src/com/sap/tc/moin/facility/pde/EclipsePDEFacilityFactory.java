package com.sap.tc.moin.facility.pde;

import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityFactory;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;


public class EclipsePDEFacilityFactory implements SpiFacilityFactory {

    /**
     * This method is legacy of the old extension point mechanism of the ide
     * runtime host FIXME :-)
     */
    public SpiFacility getFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

        EclipsePDEFacility fsFac = new EclipsePDEFacility( core, serializationManager, runtimeContext );
        return new JazzUpFileSystemFacilityWithIdePrimaryFacility( fsFac );
    }

}