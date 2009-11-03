package com.sap.tc.moin.facility.versioning;

import java.util.Collection;

import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiPartitionSaveContext;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiSaveOperation;


public interface IpiVersioningSupport {

    void processPartitions( Collection<SpiPartitionSaveContext> partitions, SpiSaveOperation spiSaveOperation );

}
