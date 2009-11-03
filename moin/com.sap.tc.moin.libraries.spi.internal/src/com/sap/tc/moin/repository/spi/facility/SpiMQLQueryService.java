package com.sap.tc.moin.repository.spi.facility;

/**
 * Each facility has to implement at least one MQL facility service.
 * <p>
 * This interface (more precisely on of its subinterfaces) <i>is</i> intended
 * to be implemented by service providers.
 * 
 * @see SpiCoreQueryService
 * @author D045917
 */
public interface SpiMQLQueryService {

    /**
     * Returns the facility id, e.g. "PF".
     * 
     * @return The id of the facility.
     */
    public String getFacilityId( );
}
