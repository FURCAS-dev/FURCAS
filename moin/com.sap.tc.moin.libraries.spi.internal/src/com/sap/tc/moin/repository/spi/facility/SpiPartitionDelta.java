package com.sap.tc.moin.repository.spi.facility;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.spi.core.SpiEndAndMetaObject;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;

/**
 * This interface provides information on partition changes. It represents the
 * delta between two partition states (i.e. persisted and dirty).
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 */
public interface SpiPartitionDelta {

    /**
     * Returns the partition the delta belongs to.
     * 
     * @return The partition the delta belongs to.
     */
    public SpiModelPartition getPartition( );

    /**
     * Returns whether the delta contains any change that needs to be persisted
     * or not.
     * 
     * @return <code>true</code> if the delty contains changes,
     * <code>false</code> otherwise.
     */
    public boolean isEmpty( );

    /**
     * @return All changed attributes belonging to model elements that already
     * existed in the persistence prior to this delta. The returned map contains
     * for each changed attribute another map, mapping the {@link Attribute} to
     * its previous, persistent value.
     */
    public Map<Partitionable, Map<Attribute, Object /* persistentValue */>> getChangedAttributes( );

    /**
     * @return Returns all persisted model elements that are now assigned to
     * this partition and were assigned to a different persistent partition
     * prior to this delta. The resulting map maps each model element to its
     * source partition.
     */
    public Map<Partitionable, ModelPartition> getAssignedElements( );

    /**
     * @return Returns all model elements that were assigned to and persisted in
     * this partition prior to this delta, but are now assigned to a different
     * persistent partition. The resulting map maps each model element to its
     * target partition.
     */
    public Map<Partitionable, ModelPartition> getUnassignedElements( );

    /**
     * @return Returns all links that were persisted in this partition prior to
     * this delta, but have now moved to a different persistent partition (as
     * the result of re-assigning a model element). The resulting map maps each
     * link to its target partition.
     */
    public Map<SpiLink, ModelPartition> getUnassignedLinks( );

    /**
     * @return Returns all persisted model elements that are now assigned to
     * this partition and were assigned to a different persistent partition
     * prior to this delta. The resulting map maps each model element to its
     * source partition.
     */
    public Map<SpiLink, ModelPartition> getAssignedLinks( );

    /**
     * @return Returns all model elements that are now assigned to this
     * partition and that do not exist in the persistence yet.
     */
    public Collection<Partitionable> getCreatedElements( );

    /**
     * @return Returns the MRIs of all model elements that were assigned to and
     * persisted in this partition prior to this delta, and which now have been
     * deleted.
     */
    public Collection<MRI> getDeletedElements( );

    /**
     * @return Returns all links of this partition which do not exist in the
     * persistence yet.
     */
    public Collection<SpiLink> getAddedLinks( );

    /**
     * @return Returns all links which were persisted in this partition prior to
     * this delta, and which now have been removed.
     */
    public Collection<SpiLink> getRemovedLinks( );

    /**
     * If additions / removals of links have occurred whose meta object is
     * ordered, this map contains for each affected model element (represented
     * by its {@link MRI}) a map of all modified link collections, keyed by
     * instances of {@link SpiEndAndMetaObject}. Persistence implementations
     * that need to compute and persist their own link ordering criterion are
     * expected to always check this map and update the ordering criterion for
     * all contained link collections accordingly.
     * <p>
     * Note that this delta is produced <b>in addition</b> to a link addition /
     * removal delta, and it is also produced if a link was added to / removed
     * from the end of an existing list (thus not affecting the positions of
     * other links in the collection).
     * <p>
     * If a link has been moved within the same link collection from position
     * <code>x</code> to position <code>y</code>, no link addition /
     * removal delta will be produced, but only an entry in the map returned by
     * this method.
     * 
     * @return The map contains for each affected model element (represented by
     * its {@link MRI}) a map of all modified link collections, keyed by
     * instances of {@link SpiEndAndMetaObject}.
     */
    public Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> getModifiedOrderedLinkCollections( );
}