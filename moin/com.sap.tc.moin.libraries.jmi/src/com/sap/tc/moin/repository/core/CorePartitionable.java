/*
 * Created on 19.12.2005
 */
package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence;

/**
 * INTERNAL interface with extended partitioning functionality.
 * 
 * @author d044711
 */
public interface CorePartitionable extends SpiPartitionable {

    /**
     * @return the Workspace that this model element lives in. A Partitionable
     * is assigned to a Workspace in one of two ways: either during construction
     * via class proxy, or during loading of the hosting model partition into a
     * Workspace. During construction via the corresponding class proxy, it is
     * automatically inserted into the {@link UserSpecificWorkspace}attached to
     * the current {@link CoreSession}. During loading, the target Workspace is
     * passed as an input parameter to
     * {@link SpiPersistence#loadPartition(Workspace, ModelPartitionInfo)}.
     * Both scenarios internally call
     * {@link Workspace#addInstance(Partitionable)}to establish a
     * bi-directional link. This link will be consistently maintained on both
     * sides by modification operations like e.g.
     * {@link Workspace#removeInstance(Partitionable)}.
     */
    public Workspace get___Workspace( );

    /**
     * Removes this element's partition assignment, i.e. the partition it was
     * assigned no longer knows this element and this element no longer has a
     * partition assigned (this.get___Partition() == null). This method is ONLY
     * to be called during a refDelete() on this element. There are no checks
     * (neither semantical nor technical), no events etc. It's a pure technical
     * internal method.
     */
    public void remove___PartitionAssignment( );

    /**
     * Internal method which is only to be used by the implementation of
     * {@link CoreModelPartition}. It just update
     * 
     * @param mp the model partition to set
     */
    public void set___PartitionAssignmentInternal( CoreModelPartition mp );

    /**
     * @see Partitionable#get___Partition()
     * <p>
     * Note, that after the creation of the model element and before the
     * addition to the workspace has finished, a model element may not even
     * belong to a "transient partition." In such a case, this operation will
     * return <tt>null</tt>.
     */
    public CoreModelPartition get___Partition( );

    public SpiJmiHelper get___JmiHelper( );

    public void set___PartitionAssignment( CoreModelPartition mp );

    public void assign___Partition( CoreConnection connection, ModelPartition mp );

    public void assign___PartitionIncludingChildren( CoreConnection connection, ModelPartition mp );

    public void delete___Isolated( CoreConnection connection );
}