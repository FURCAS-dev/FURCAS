package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;


public interface Core extends SpiCore {

    public boolean isLinkAllowed( SpiLifecycleManagement lifecycleManagement, PRI priOfStoredEnd, PRI priOfOtherEnd, SpiClientSpec clientSpecOfStoredEnd, SpiClientSpec clientSpecOfOtherEnd );

    public boolean isSavablePartition( PRI pri );

    public void shutDown( );
}
