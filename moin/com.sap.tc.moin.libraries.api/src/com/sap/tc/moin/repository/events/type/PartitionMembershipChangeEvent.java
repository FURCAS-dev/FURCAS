package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;

/**
 * This Event indicates a movement of a model element from one partition to
 * another (repartitioning). This is the only <code>ModelChangeEvent</code> that
 * does not indicate a change to the model identity. Note, that a repartitioning
 * from a TransientPartition are also covered.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */
public interface PartitionMembershipChangeEvent extends ModelChangeEvent {

    /**
     * @return an {@link MRI MRI} that points to the object in the old
     * partition.
     */
    public MRI getAffectedElementOldMri( );

    /**
     * @return an {@link MRI MRI} that points to the object in the new
     * partition.
     */
    public MRI getAffectedElementNewMri( );

    /**
     * @param resolvingConnection the connection used to resolve the MRI.
     * @return the moved/moving element.
     */
    public RefObject getAffectedElement( Connection resolvingConnection );

    /**
     * @return the <code>PRI</code> of the partition where the affected element
     * lives in after the movement.
     */
    public PRI getNewPartitionPri( );

    /**
     * resolves the PRI that can be retrieved using the
     * {@link #getNewPartitionPri()} method.
     * 
     * @param resolvingConnection the connection used to resolve.
     * @return the partition where the affected element now lives in.
     */
    public ModelPartition getNewPartition( Connection resolvingConnection );

    /**
     * @return the <code>PRI</code> of the partition where the affected element
     * lived in before the movement.
     */
    public PRI getOldPartitionPri( );

    /**
     * resolves the PRI that can be retrieved using the
     * {@link #getOldPartitionPri()} method.
     * 
     * @param resolvingConnection the connection used to resolve.
     * @return the partition where the affected element lived in.
     */
    public ModelPartition getOldPartition( Connection resolvingConnection );

}