package com.sap.tc.moin.facility.versioning;

import java.util.Collection;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiPartitionSaveContext;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiSaveOperation;


public class IpiAbstractVersioningSupport implements IpiVersioningSupport, IpiFacilityComponent {

    public void processPartitions( Collection<SpiPartitionSaveContext> partitions, SpiSaveOperation spiSaveOperation ) {

    }

    public void finalizeStartup( ) {

    }

    public void initialize( ) {

    }

    public void tearDown( ) {

    }
}
