/*
 * Created on 29.06.2006
 */
package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.Partitionable;

/**
 * <p>
 * This interface is not intended to be implemented by service providers. The implementation will be provided by the
 * MOIN Core.
 * 
 * @author d044711
 */
public interface SpiPartitionable extends Partitionable {

    /**
     * @return the Workspace that this model element lives in. A Partitionable is assigned to a Workspace in one of two
     * ways: either during construction via class proxy, or during loading of the hosting model partition into a
     * Workspace. During construction via the corresponding class proxy, it is automatically inserted into the
     * {@link UserSpecificWorkspace}attached to the current {@link CoreSession}. During loading, the target Workspace
     * is passed as an input parameter to {@link SpiPersistence#loadPartition(Workspace, ModelPartitionInfo)}. Both
     * scenarios internally call {@link Workspace#addInstance(Partitionable)}to establish a bi-directional link. This
     * link will be consistently maintained on both sides by modification operations like e.g.
     * {@link Workspace#removeInstance(Partitionable)}.
     */
    public SpiWorkspace get___Workspace( );

}
