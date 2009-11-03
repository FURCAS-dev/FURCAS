package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;

public interface ReferenceKeeper {

    public void elementRelocated( CoreConnection connection, CoreModelPartition newPartition, MRI oldMri );

    public MriReference getMriReference( CorePartitionable partitionable, MRI mri );

    public PriReference getPriReference( CoreModelPartition partition );

    public PriReference getPriReference( PRI pri );

    public void uncacheMriReference( MRI mri );

    public void uncachePriReference( ModelPartition partition );


}
