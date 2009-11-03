package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.core.SpiStage;

/**
 * SPI interface for a ClientSpec.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @author d020383
 */
public interface SpiClientSpec extends ClientSpec {

    /**
     * Returns the client's client-specific stage, if one exists. Returns null
     * otherwise.
     * 
     * @return The client's client-specific stage or <code>null</code> if none
     * exists
     */
    public SpiStage getClientSpecificStage( );

    /**
     * Creates a ResourceInfo for a given PRI.
     * 
     * @param pri the PRI for which to get the ResourceInfo
     * @return the ResourceInfo
     * @throws SpiFacilityException FacilityException if the ResourceInfo can
     * not be returned
     */
    public SpiResourceInfo getResourceInfo( PRI pri ) throws SpiFacilityException;

    /**
     * Get the ResourceInfo for a given LRI.
     * 
     * @param lri
     * @return resourceInfo
     * @throws SpiFacilityException
     */
    public SpiResourceInfo getResourceInfo( LRI lri ) throws SpiFacilityException;

}