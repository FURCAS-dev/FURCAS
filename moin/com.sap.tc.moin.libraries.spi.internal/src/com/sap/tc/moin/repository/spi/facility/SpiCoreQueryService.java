package com.sap.tc.moin.repository.spi.facility;

import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DuplicateElementException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

/**
 * Defines a set of queries used by the MOIN core.
 * <p>
 * Service providers should take care for high-performance implementation since
 * the queries defined in this interface can significantly influence the overall
 * performance.
 * <p>
 * Note: All link related queries and query results in this interface
 * specifically refer to cross-partition associations and object-valued
 * attributes respectively, i.e. the linked elements are located in different
 * partitions.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @see SpiFacility
 * @see SpiMQLQueryService
 * @author d047015
 * @author d043530
 */
public interface SpiCoreQueryService {

    /**
     * Returns all {@link PRI PRIs} stored in the given container.
     * 
     * @param clientSpecs The ClientSpecs which define the scope for this query.
     * @param cri The {@link CRI} of the container whose partitions are
     * requested.
     * @return All {@link PRI PRIs} stored in the given container.
     */
    public Collection<PRI> getPartitionsInContainer( ClientSpec clientSpecs, CRI cri );

    /**
     * Returns the partitions containing elements that have a cross-partition
     * link to the given element. It does not matter if the given element is at
     * end 0 or 1. The result will contain the the partitions containing
     * elements at the opposite end.
     * 
     * @param clientSpecs The ClientSpecs which define the scope for this query.
     * @param element The {@link MRI} of the model element.
     * @return Collection of {@link PRI Pris}
     */
    public Collection<PRI> getReferringPartitions( ClientSpec[] clientSpecs, MRI element );

    /**
     * Navigates along an Association starting with one RefObject at the
     * <code>fromEnd</code> and retrieving elements on the other end. The
     * navigation direction is specified by the end number <code>fromEnd</code>
     * of the starting end and the end number <code>toEnd</code> of the target
     * end of the Association for which elements have to be retrieved on the
     * target side.<br>
     * <br>
     * This query returns only elements that are retrievable by navigation
     * AGAINST storage. Therefore "ReferringElements".
     * <p>
     * This query considers cross-partition associations only!
     * 
     * @param clientSpecs The ClientSpecs which define the scope for this query.
     * @param association The Association to navigate along.
     * @param fromElement The element to start from.
     * @param fromEnd The end number of the Association to start at.
     * @return A Collection of {@link MRI MRIs} found at the target end of the
     * Association.
     */
    public Collection<MRI> getReferringElementsForEndAndMetaobject( ClientSpec[] clientSpecs, MRI association, MRI fromElement, int fromEnd );

    /**
     * Returns the {@link PRI} of an element identified by a given {@link LRI}.
     * 
     * @param clientSpecs The {@link ClientSpec}s which define the scope for
     * this query.
     * @param lri The {@link LRI} to resolve.
     * @return The {@link PRI} of the element identified by the given
     * {@link LRI}.
     * @throws DuplicateElementException Thrown if multiple instances of the
     * same model element are found for the given {@link LRI} and
     * {@link ClientSpec}s scope.
     */
    public PRI getPriForLri( ClientSpec[] clientSpecs, LRI lri ) throws DuplicateElementException;

    /**
     * Returns a {@link Map} of all top level package {@link MRI MRIs} to their
     * respective package name as {@link String}.
     * 
     * @return A {@link Map} of found package {@link MRI MRIs} to their
     * respective package name as {@link String}.
     */
    public Map<MRI, String> getTopLevelPackages( );

    /**
     * Checks if the partition that belongs to the given {@link PRI} exists.
     * 
     * @param clientSpec The ClientSpecs which define the scope for this query.
     * @param pri The {@link PRI} to check.
     * @return <code>true</code> if the partition exists, <code>false</code>
     * otherwise.
     */
    public boolean isPartitionExistent( ClientSpec clientSpec, PRI pri );

    /**
     * Returns true, if the partitions are different and if there exists at
     * least one link, which is persisted in one of the two partitions and
     * points to the other partition. In all other cases, return false, also if
     * one of the partitions does not exist.
     * 
     * @param clientSpecOne The client specification of the
     * <code>onePartition</code> partition.
     * @param onePartition
     * @param clientSpecTwo The client specification of the
     * <code>twoPartition</code> partition.
     * @param twoPartition
     * @return <code>true</code>, if the partitions are different and if there
     * exists at least one link, which is persisted in one of the two partitions
     * and points to the other partition. In all other cases, <code>false</code>
     * , also if one of the partitions does not exist.
     */
    boolean hasCrossPartitionLinks( ClientSpec clientSpecOne, PRI onePartition, ClientSpec clientSpecTwo, PRI twoPartition );

    /**
     * Checks if there is a cross partition link between a given partition
     * (partitionFrom) and a LRI (elementTo). The method return true, even if
     * the link is dangling towards the LRI.
     * 
     * @param clientSpecFrom The client spec where the partitionFrom resides
     * @param partitionFrom The partition to check for a cross-partition link
     * @param elementTo The element to check for a cross partition link
     * @return <code>true</code> if a link to <code>elementTo</code> exists,
     * <code>false</code> otherwise
     */
    boolean hasCrossPartitionLink( ClientSpec clientSpecFrom, PRI partitionFrom, LRI elementTo );
}
