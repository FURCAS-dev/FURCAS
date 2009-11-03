package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;

/**
 * @author d020383
 */
public interface CoreModelPartition extends SpiModelPartition {

    /**
     * This interface specifies identity for a ModelPartition within a
     * WorkspaceSet. If the CoreModelPartitionIdentity is used for hash
     * structures equality is just based on Java object identity and therefore
     * very fast. The equals method of the CoreModelPartition delegates to the
     * ResourceInfo in order to check for equality. That is much more costly and
     * in many cases not necessary. The eviction manager will make use of the
     * CoreModelPartitionIdentity in order to key statistics info for model
     * partitions.
     * 
     * @author d024227
     */
    public interface CoreModelPartitionIdentity {

        /**
         * Returns the enclosing CoreModelPartition of this
         * CoreModelPartitionIdentity
         * 
         * @return the enclosing CoreModelPartition of this
         * CoreModelPartitionIdentity
         */
        CoreModelPartition getCoreModelPartition( );
    }

    /**
     * Obtains the workspace in which this partition is currently loaded. Throws
     * an exception if it is null (evicted or otherwise invalid).
     */
    public Workspace getWorkspace( );

    /**
     * Adds the supplied element to this partition's root element collection and
     * updates element's partition variables. No component children are updated,
     * no events are fired, no checks executed.
     * 
     * @param element the element to add to this partition root element
     * collection. <code>null</code> is not allowed as argument value.
     * @see CorePartitionable#set___ExplicitPartitionAssignment(CoreModelPartition)
     */
    public void addElement( CorePartitionable element );

    /**
     * Removes the given element from this partition's root element collection
     * and nulls out element's partition variables. No component children are
     * updated, no events are fired, no checks executed.
     * 
     * @param element the model element to remove from this model partition.
     * <code>null</code> is not allowed as argument value.
     * @see CorePartitionable#remove___PartitionAssignment()
     */
    public void removeElement( CorePartitionable element );

    /**
     * Gets all the component child elements of the passed "parent" element
     * which reside in this partition. The parent element is NOT part of the
     * returned collection of elements.
     * 
     * @param connection
     * @param parent the parent element
     * @return the component child elements of the passed "parent" element which
     * reside in this partition. If there are no such elements, an empty set is
     * returned, never <code>null</code>.
     */
    public Set<CorePartitionable> getComponentChildrenInThisPartition( CoreSession session, CorePartitionable parent );

    /**
     * Tells if this partition is the extent partition
     */
    public boolean isExtentPartition( );

    /**
     * Tells if this partition is empty. That means that no relocation entries,
     * no model elements and no links are part of this partition.
     * 
     * @return <code>true</code> if empty, <code>false</code>otherwise.
     */
    public boolean isEmpty( );

    /**
     * Marks this partition as dirty and informs the {@link CoreConnection
     * connection} in whose context the modification is done.
     * 
     * @param connection the connection to inform
     * @return the dirty state of this partition before execution of this method
     */
    public boolean markDirty( CoreConnection connection );

    /**
     * Returns the {@link CoreModelPartitionIdentity} instance which can be used
     * to compare CoreModelPartition for Java identity.
     * 
     * @return CoreModelPartitionIdentity instance of this
     * CoreModelPartitionIdentity
     */
    public CoreModelPartitionIdentity getCoreModelPartitionIdentity( );

    public void setWorkspace( Workspace workspace );

    public void setResourceInfo( SpiResourceInfo resourceInfo );

    /**
     * This method is called to signal this object that it has been deleted from
     * the repository. So this object can do cleanup operations.<br>
     * This method is ONLY to be called by the MOIN core.
     */
    public void ___delete( );

    /**
     * Updates the eviction timestamp with the current time.
     */
    public void updateEvictionTimestamp( );

    /**
     * Returns this partition's current eviction timestamp.
     */
    public long getEvictionTimestamp( );

    public Map<Association, List<EndStorageLink>> getAssociationLinksGroupedByMetaObject( CoreSession session );

    public void assignElement( CoreConnection connection, Partitionable element );

    public void assignElementIncludingChildren( CoreConnection connection, Partitionable element );

    public void clearDirty( CoreConnection connection );

    public void delete( CoreConnection connection );

    public void deleteElements( CoreConnection connection );

    public Collection<EndStorageLink> evictLinks( );

    public DistributedLinkContainer getDistributedLinkContainer( );

    public JmiListContainer getJmiListContainer( );

    public OverflowContainer getOverflowContainer( );

    public <T extends RefObject> T createElement( CoreConnection connection, ClassDescriptor<? extends RefClass, T> classDescriptor );

    public <T extends RefObject> T createElement( CoreConnection connection, Class<T> classDescriptor );

    public void trimToSize( );

    public boolean hasLinksToPartition( CoreModelPartition partition );

    public Map<SpiAssociation, List<SpiLink>> getAssociationLinksStable( CoreSession session );

    public void markHadErrorsDuringLoad( );

    public void clearHadErrorsDuringLoad( );

    public void markHadUnhandledErrorsDuringLoad( );

    public void clearHadUnhandledErrorsDuringLoad( );

    public void addUsedMetamodel( CRI metamodel, String version );

    public void clearUsedMetamodels( );

    public byte[] getPrefixForSegmentedMofIds( );
}