package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public interface CorePartitionFactory {

    public static final String EXTENT_PARTITION_NAME = "extent-partition"; //$NON-NLS-1$

    public CoreModelPartition ___createModelPartition( CoreConnection connection, PRI pri );

    public CoreModelPartition ___createModelPartition( CoreConnection connection, PRI pri, SpiStage stage, Workspace workspace );

    public CoreModelPartition createModelPartition( PRI pri, SpiStage stage, Workspace workspace );

    public CoreModelPartition createTransientPartition( CoreConnection connection, PRI pri, SpiStage stage, String partitionName );

    public CoreModelPartition createTransientPartitionNonTransactional( CoreConnection connection, PRI pri, SpiStage stage );

    public CoreModelPartition createExtentPartition( PRI pri, SpiStage metaModelStage );

    public CoreModelPartition createModelPartition( CoreConnection connection, PRI pri );
}
