package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

public interface ReferenceManager {

    public MriReference getMriReference( MRI mri, Workspace requestor );

    public MriReference getMriReference( CorePartitionable partitionable, Workspace requestor );

    public LriReference getLriReference( LRI lri );

    public MetamodelMriReference getMetamodelMriReference( CorePartitionable partitionable );

    public MetamodelLriReference getMetamodelLriReference( LRI lri );

    public PriReference getPriReference( CoreModelPartition partition, Workspace requestor );

    public PriReference getPriReference( PRI pri, Workspace requestor );

    public void elementRelocated( CoreConnection connection, CoreModelPartition oldPartition, CoreModelPartition newPartition, String mofId );

    public void notifyBeforePartitionEviction( CoreModelPartition modelPartition );

    public void notifyBeforeInstanceEviction( CorePartitionable element );


}
