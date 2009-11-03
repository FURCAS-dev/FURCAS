/*
 * Created on 28.06.2006
 */
package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.DataAreaDescriptor;

/**
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d044711
 */
public interface SpiWorkspace {

    /**
     * Returns the {@link SpiStage} for a given {@link DataAreaDescriptor}, or
     * null if the Workspace is not responsible for any stage of the specified
     * data area.
     * 
     * @return stage
     */
    public SpiStage getStage( DataAreaDescriptor dataAreaDescriptor );

    public SpiLinkManager getLinkManager( );

}
