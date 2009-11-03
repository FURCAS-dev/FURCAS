package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;

/**
 * A stage factory that provides MOIN Core functionality to other layers.
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d047015
 */
public interface SpiStageService {

    // TODO: Add missing JavaDoc

    public SpiStage createSharedStage( DataAreaDescriptor dataAreaDescriptor, String name );

    public SpiStage createClientSpecificStage( DataAreaDescriptor dataAreaDescriptor, String name, String clientspecId );

    public SpiResourceInfo createResourceInfo( PRI pri, SpiStage stage );

}
