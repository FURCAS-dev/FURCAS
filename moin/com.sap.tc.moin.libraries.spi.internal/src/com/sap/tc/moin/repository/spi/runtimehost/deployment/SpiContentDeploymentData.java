/*
 * Created on 13.06.2008
 */
package com.sap.tc.moin.repository.spi.runtimehost.deployment;

import java.util.List;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionContentRecord;

/**
 * Data provider for content deployment.
 * <p>
 * Instances of this interface provide deployment data for a collection of
 * partitions belonging to the same container. The data is provided by an
 * iterator over {@link SpiPartitionContentRecord}s which contain the data per
 * partition.
 * <p>
 * The operation always refers to the container, not to single partitions, i.e.
 * the deployment interface does not provide delta-updates on partition level.
 * But it is guaranteed that a the data is always complete for one container.
 * This means that for update operations, the implementor of the
 * {@link com.sap.tc.moin.repository.spi.facility.js.SpiJsContentDeploymentManager}
 * can safely remove existing partitions which are not contained anymore in a
 * deployment data.
 * <p>
 * <b>Note</b>: this interface is currently only relevant for the server
 * scenario and would better be part of the
 * <code>tc.moin.libraries.spi.internal.js</code> library. But we have unit
 * tests in the hybrid test scenario which require both the SPI interface as
 * well as the implementation.
 */
public interface SpiContentDeploymentData {

    /**
     * Gets the CRI
     * 
     * @return the resource identifier for the container which is deployed
     */
    public CRI getCri( );

    /**
     * Gets the partition content records for the container
     * 
     * @return the partition content records for the container
     */
    public List<SpiPartitionContentRecord> getPartitionContentRecords( );

    public List<SpiRegistrationContentRecord> getRegistrationContentRecords( );
}
