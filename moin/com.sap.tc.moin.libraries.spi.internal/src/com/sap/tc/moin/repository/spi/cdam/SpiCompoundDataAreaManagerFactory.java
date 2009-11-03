package com.sap.tc.moin.repository.spi.cdam;

import com.sap.tc.moin.repository.spi.core.SpiCore;


public interface SpiCompoundDataAreaManagerFactory {

    public SpiCompoundDataAreaManager getCompoundDataAreaManager( SpiCore moin );

}
