package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

public interface MriReference extends MoinReference {

    public void elementRelocated( CoreModelPartition newPartition );

    /**
     * Obtains the resolved instance that is the target of this reference. If
     * this reference is not resolved this method returns <code>null</code>.
     */
    public CorePartitionable getIfResolved( );

    public MRI getMri( );

    public PRI getPri( );

}
