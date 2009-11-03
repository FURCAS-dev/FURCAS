package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Set;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

public interface CoreInstanceManager {

    /**
     * Injects the specified element. If it has no partition assignment yet, the
     * relevant transient partition for new elements will be assigned.
     * 
     * @param connection the current connection
     * @param the element to inject.
     */
    public void injectInstance( CoreConnection connection, CorePartitionable element );

    public Workspace getWorkspace( );

    public void evictInstance( CorePartitionable element );

    public CorePartitionable getInstance( CoreSession session, LRI lri );

    public CorePartitionable getInstance( MRI mri );

    public Collection<CorePartitionable> getInstances( LRI lri );

    public Set<CorePartitionable> getInstances( );

    public Collection<Object> getInstancesLive( );

    public Object getInstancesRaw( LRI lri );
}
