package com.sap.tc.moin.repository.spi.facility;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * SPI interface which provides access to life cycle related functionality of a
 * facility.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @see SpiFacility
 * @author d047015
 */
public interface SpiLifecycleManagement {

    /**
     * The methods checks if a reference from a model element in partition
     * <code>usingPri</code> to a model element in partition
     * <code>usedPri</code> is allowed according to the rules of the underlying
     * infrastructure, i.e. to the SAP component model. This means that it must
     * be basically possible to navigate from a model element in partition
     * <code>usingPri</code> to a model element in partition
     * <code>usedPri</code> and to properly instantiate the respective link in
     * MOIN core in any scenario (also in Build scenario where only PPs of used
     * DCs are synced).
     * <p>
     * Example:
     * <p>
     * In SAP component model this reference is allowed when:
     * <p>
     * - The two model elements are located in the same container (DC).
     * <p>
     * - The two model elements are located in different containers:
     * <code>usingPri</code> is located in source-DC and <code>usedPri</code> is
     * located in destination-DC.
     * <p>
     * -- Additionally there is at least one usage relation from source-DC to a
     * public part of destination-DC
     * <p>
     * -- and <code>usedPri</code> is contained in one of those referenced
     * public parts.
     * <p>
     * Remark:
     * <p>
     * The parameter <code>clientSpecOfUsingPri</code> determines which client
     * spec builds the context for the creation of the reference. This client
     * spec is used to determine the container usage relations.
     * <p>
     * The parameter <code>clientSpecOfUsedPri</code> is needed for the future
     * handling of cross-data-area-links (e.g. ESR use-case: absolute SC
     * references).
     * <p>
     * If we would use only the respective clientSpecId then in the JEE scenario
     * this could mean that we need a DB access to retrieve the respective
     * client spec. On the other side, the Core has already available the client
     * spec in the context of a session and the respective compoundClientSpec.
     * 
     * @param usingPri The partition in which the from element is located in.
     * @param usedPri The partition to which the target element is located in.
     * @param clientSpecOfUsingPri Determines which client spec builds the
     * context for the creation of the reference.
     * @param clientSpecOfUsedPri Needed for the future handling of
     * cross-data-area-links (e.g. ESR use-case: absolute SC references).
     * @return <code>true</code> if a reference from a model element in
     * partition <code>usingPri</code> to a model element in partition
     * <code>usedPri</code> is allowed, <code>false</code> otherwise.
     */
    boolean isLinkBackedByContainerUsage( PRI usingPri, PRI usedPri, SpiClientSpec clientSpecOfUsingPri, SpiClientSpec clientSpecOfUsedPri );

    /**
     * The underlying infrastructure defines usage relations between containers.
     * Those usage relations define which parts of which containers content are
     * visible for which other containers. The method returns those containers
     * for which their content is visible for the given container defined by
     * <code>cri</code>.
     * <p>
     * Remark:
     * <p>
     * The parameter <code>clientSpec</code> determines which client spec builds
     * the context for the creation of the reference. This client spec is used
     * to determine the container usage relations.
     * 
     * @param clientSpec Determines which client spec builds the context for the
     * creation of the reference.
     * @param cri The container for which the visible containers are requested.
     * @return The containers for which the content is visible for the given
     * container <code>cri</code>.
     */
    Collection<CRI> getVisibleContainers( SpiClientSpec clientSpec, CRI cri );

    /**
     * The underlying infrastructure defines usage relations between containers.
     * Those usage relations define which parts of which containers content are
     * visible for which other containers. The method returns those partitions
     * from those other containers which are visible for the given container
     * defined by <code>cri</code>.
     * <p>
     * Remark:
     * <p>
     * The parameter <code>clientSpec</code> determines which client spec builds
     * the context for the creation of the reference. This client spec is used
     * to determine the container usage relations.
     * <p>
     * Remark:
     * <p>
     * The parameter <code>dirtyPartitions</code> provides all dirty partitions
     * of all containers in the scope of the given <code>clientSpec</code>. It
     * is needed because the method also considers the dirty-state of the
     * visible containers (i.e. the dirty created and dirty deleted partitions).
     * 
     * @param clientSpec Determines which client spec builds the context for the
     * creation of the reference.
     * @param cri The container for which the visible partitions in other
     * containers are requested.
     * @param dirtyPartitions Provides all dirty partitions of all containers in
     * the scope of the given <code>clientSpec</code>.
     * @return The partitions from those other containers which are visible for
     * the given container <code>cri</code>.
     */
    Collection<PRI> getOuterPartitions( SpiClientSpec clientSpec, CRI cri, List<PartitionOperation> dirtyPartitions );

    /**
     * The method ensures, that the creation of a partition with the given
     * <code>pri</code> is allowed.
     * <p>
     * Remark:
     * <p>
     * The first implementation of versioning in MOIN is to support preparation
     * approach. In this approach this method only checks if the operation is
     * principally possible (e.g. partition is not in MetaModel data area) and
     * if the partition is properly prepared and if not, then an expressive
     * exception is thrown.
     * <p>
     * The future implementation of versioning is to support preparation
     * approach and implicit check-out-approach. The user can switch between
     * those approaches by preferences in the environment (e.g. Eclipse
     * preferences). If preparation approach is switched on then the method
     * behaves as before. If implicit check-out-approach is swiched on then the
     * method first checks if the partition is properly prepared and if not,
     * then it tries to properly prepare the partition. In this approach it only
     * throws exceptions if the preparation is not possible at all (e.g.
     * partition in MetaModel data area) or if it fails.
     * </p>
     * 
     * @param pri The partition to check.
     * @param clientSpec The scope for this operation.
     */
    void ensureCreatingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionCreatingNotPossibleException;

    /**
     * The method ensures, that changes on the given partition <code>pri</code>
     * are allowed.
     * <p>
     * Remark: preparation approach and implicit check-out approach (see
     * ensureCreatingAllowed).
     * </p>
     * 
     * @param pri The identifier of the partition to check
     * @param clientSpec The scope for this operation
     */
    void ensureEditingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionEditingNotPossibleException;

    /**
     * The method ensures, that the deletion of the given partition
     * <code>pri</code> is allowed.
     * <p>
     * Remark: preparation approach and implicit check-out approach (see
     * ensureCreatingAllowed).
     * </p>
     * 
     * @param pri The identifier of the partition to check
     * @param clientSpec The scope for this operation
     */
    void ensureDeletingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionDeletingNotPossibleException;

    /**
     * The method checks if the given container <code>cri</code> is modifiable
     * in the context of the given <code>clientSpec</code>.
     * <p>
     * Example:
     * <p>
     * A container which is only available as archive and not as source is not
     * modifiable.
     * </p>
     * 
     * @param cri The container to check.
     * @param clientSpec The scope for this operation.
     * @return <code>true</code> if the given container is modifiable,
     * <code>false</code> otherwise.
     */
    boolean isContainerModifiable( CRI cri, SpiClientSpec clientSpec );

}
