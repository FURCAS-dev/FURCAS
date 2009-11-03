package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;

/**
 * The PartitionCreateEvent indicates the creation of a new partition. The
 * creation of so called "No-Partitions" is not covered. Both, the
 * PartitionCreatedEvent and the PartitionRemovedEvent do not only have global
 * character. They will also be used to indicate transient changes in a session
 * (which then of course only will be sent to local clients).
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */
public interface PartitionEvent extends ChangeEvent {

    /**
     * @return the <code>PRI</code> of the affected partition.
     */
    public PRI getAffectedPartitionPri( );

    /**
     * resolves the PRI
     * 
     * @param resolvingConnection the connection used to resolve.
     * @return the affected partition.
     */
    public ModelPartition getAffectedPartition( Connection resolvingConnection );

}