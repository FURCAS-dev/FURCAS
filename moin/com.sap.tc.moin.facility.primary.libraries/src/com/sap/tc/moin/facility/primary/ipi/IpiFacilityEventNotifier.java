package com.sap.tc.moin.facility.primary.ipi;

import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiStage;

/**
 * Facility internal IPI interface which provides facility components means to
 * send notifications to the MOIN core.
 * <p>
 * Implementors are expected to process notifications asynchronously.
 * 
 * @author d020214
 */
public interface IpiFacilityEventNotifier {


    /**
     * Triggers the eviction of the given partitions in the MOIN core.S
     * <p>
     * Implementors are expected to execute this operation asynchronously.
     * 
     * @param partitionsToEvictPerStage The partition to evict mapped per stage.
     * @throws IllegalArgumentException
     */
    public void evictPartitions( Map<SpiStage, List<PRI>> partitionsToEvictPerStage ) throws IllegalArgumentException;


}
