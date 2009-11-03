package com.sap.tc.moin.facility.primaryreplacement;


import com.sap.tc.moin.facility.pde.EclipsePDEFacility;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;


public class PrimaryReplacementFacility extends EclipsePDEFacility {

    public PrimaryReplacementFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

        super( core, serializationManager, runtimeContext, getIndexLocation( ) );
    }

    @Override
    public String getId( ) {

        return "PF"; //$NON-NLS-1$

    }

    private static String getIndexLocation( ) {

        String wsfile = grantIndexBasePath( ) + "\\moin_PFidx.dat"; //$NON-NLS-1$
        return wsfile;
    }
}
