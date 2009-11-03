package com.sap.tc.moin.facility.primary.ipi;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService.SpiMofRomPartitionContent;

/**
 * Facility internal IPI interface which provides other facility componenet
 * access to management functionality (i.e. update, synchronization) of the
 * index.
 * 
 * @author D048997
 */
public interface IpiIndexManagement {

    public static interface SyncTicket {
    }

    /**
     * Enumeration which defines indexing actions. An index operation can use
     * these values to indicate which actions were actually executed.
     * <p>
     * E.g. If the a partition was not re-index due to timestamp equality the
     * operation can return <code>NOP</code>.
     */
    public static enum IndexingAction {

        /** Content was indexed. */
        ADDED,

        /** Content was indexed and error-handled. */
        ADDED_EH,

        /** Content was re-indexed. */
        UPDATED,

        /** Content was re-indexed and error-handled. */
        UPDATED_EH,

        /** Content was removed from the index. */
        DELETED,

        /** No operation necessary. */
        NOP,

        /** An exception occurred. */
        EXCEPTION
    }

    /**
     * A data structure which represents the result of a synchronization
     * operation.
     */
    public static final class SyncReport {

        /**
         * Added partitions whose content in index differs from persistence
         * content. I.e. if an error handler got involved. It is a sub-set of
         * {@link #ADDED}.
         */
        public final List<PRI> ADDED_EH;

        /** Partitions which were added to the index. */
        public final List<PRI> ADDED;

        /**
         * updated partitions whose content in index differs from persistence
         * content. I.e. if an error handler got involved. It is a sub-set of
         * {@link #UPDATED}.
         */
        public final List<PRI> UPDATED_EH;

        /** Partitions which were updated in the index. */
        public final List<PRI> UPDATED;

        /** Partitions for which no operation had to be done. */
        public final List<PRI> NOP;

        /** Partitions which were deleted to the index. */
        public final List<PRI> DELETED;

        /** Partitions which were not be processed because of an exception. */
        public final List<PRI> EXCEPTION;

        /**
         * Default constructor.
         * 
         * @param added Partitions which were added to the index.
         * @param updated Partitions which were updated in the index.
         * @param nop Partitions for which no operation had to be done.
         * @param deleted Partitions which were deleted to the index.
         * @param errors Partitions which were not be processed because of an
         * exception.
         */
        public SyncReport( List<PRI> added, List<PRI> add_eh, List<PRI> updated, List<PRI> upd_eh, List<PRI> nop, List<PRI> deleted, List<PRI> errors ) {

            this.ADDED = ( added == null ? new ArrayList<PRI>( 0 ) : added );
            this.ADDED_EH = ( add_eh == null ? new ArrayList<PRI>( 0 ) : add_eh );
            this.UPDATED = ( updated == null ? new ArrayList<PRI>( 0 ) : updated );
            this.UPDATED_EH = ( upd_eh == null ? new ArrayList<PRI>( 0 ) : upd_eh );
            this.NOP = ( nop == null ? new ArrayList<PRI>( 0 ) : nop );
            this.DELETED = ( deleted == null ? new ArrayList<PRI>( 0 ) : deleted );
            this.EXCEPTION = ( errors == null ? new ArrayList<PRI>( 0 ) : errors );
        }

    }

    /**
     * Indexes a MOF rom partition.<br>
     * <br>
     * The time stamp is used to determine whether a partition needs to be
     * updated or not. If the time stamp did not change, nothing is done.
     * 
     * @param pri The {@link PRI} of the partition
     * @param mofRomContent The partition content as {@link SpiPartitionDelta}
     * @param timestamp An identifier for the partition
     */
    public void indexMofRomPartition( SpiMofRomPartitionContent mofRomContent, long timestamp );

    /**
     * Adds a new partition to the index. It is used to index persisted
     * partitions available as file streams.
     * <p>
     * If the given timestamp equals the timestamp of the already indexed
     * version of this partition, no operation is done. Otherwise, the partition
     * is removed from index, re-indexed and the new timestamp is set. Therefore
     * the index fetches the input stream from the partition stream provider.
     * <p>
     * The timestamp mechanism can be bypassed by the <code>forced</code>
     * parameter. If <code>true</code> is passed for this parameter a partition
     * is re-indexed regardless of timestamps.
     * 
     * @param pri The {@link PRI} of the partition to be indexed.
     * @param streamProvider A stream provider for the partition to index.
     * @param timestamp A unique timestamp which identifies a specific partition
     * state.
     * @param forced <code>false</code>: the default indexing mechanism is used<br>
     * <code>true</code>: deactivates the timestamp check
     * @return The action which was actually executed (
     * {@link IndexingAction#ADDED}, {@link IndexingAction#UPDATED},
     * {@link IndexingAction#NOP}, or {@link IndexingAction#EXCEPTION}).
     * @see IndexingAction
     */
    public IndexingAction indexPartition( PRI pri, SpiPartitionStreamProvider streamProvider, long timestamp, boolean forced );

    /**
     * Adds a new (non-persisted) partition or updates a partition in the index.
     * <p>
     * If the given timestamp equals the timestamp of the already indexed
     * version of this partition, no operation is done. Otherwise, the partition
     * is updated and the new timestamp is set.
     * 
     * @param pri The {@link PRI} of the partition to be indexed.
     * @param pDelta Changes made to the partition.
     * @param timestamp A unique timestamp which identifies a specific partition
     * state.
     * @return The action which was actually executed (
     * {@link IndexingAction#ADDED}, {@link IndexingAction#UPDATED},
     * {@link IndexingAction#NOP}, or {@link IndexingAction#EXCEPTION}).
     * @see IndexingAction
     */
    public IndexingAction indexPartition( PRI pri, SpiPartitionDelta pDelta, long timestamp );

    /**
     * Removes a partition from the index.
     * 
     * @param pri The {@link PRI} of the partition to be removed.
     * @return The action which was actually executed (
     * {@link IndexingAction#DELETED}, {@link IndexingAction#NOP}, or
     * {@link IndexingAction#EXCEPTION}).
     * @see IndexingAction
     */
    public IndexingAction removePartition( PRI pri );

    /**
     * Causes the index to synchronize its content with a set of given
     * partitions. The content of the partitions is provided via a
     * {@link SpiPartitionStreamProvider}.
     * <p>
     * This method is called in order to trigger the synchronization of
     * metamodel partitions and model partitions. An index implementation may
     * handle synchronization operations for those partition types differently.
     * Therefore this method provides the <code>kind</code> parameter which
     * denotes the synchronization mode.
     * <p>
     * The method applies timestamp checks to determine which partitions have to
     * be re-indexed (see
     * {@link #indexPartition(PRI, SpiPartitionStreamProvider, long, boolean)}
     * for details).
     * <p>
     * Synchronization procedure (on partition level):
     * 
     * <pre>
     * -----------------------------------
     * input  | in index      | action
     * -----------------------------------
     * (p,tj) | (p,tk|tk!=tj) | reindex(p,tj)
     * (p,tj) | (p,tk|tk==tj) | nop
     * (p,tj) | -             | index(p, tj)
     * -      | (p,v)         | delete(p)
     * -----------------------------------
     * legend:
     * p - partition 
     * ti - timestamp i (ti > ti+1)
     * </pre>
     * The parameter <code>forced</code> can be used to deactivate the timestamp
     * checks. This will actually lead to the removal of all existing partitions
     * (in the given scope) and subsequent indexing of all given partitions.
     * <p>
     */

    /**
     * Causes the index to synchronize its content of a specified data area with
     * a set of given partitions. The content of the partitions is provided via
     * a {@link SpiPartitionStreamProvider}.
     * <p>
     * This method is called in order to trigger the synchronization of
     * metamodel partitions and model partitions. An index implementation may
     * handle synchronization operations for those partition types differently.
     * Therefore this method provides the <code>kind</code> parameter which
     * denotes the synchronization mode.
     * <p>
     * The method applies timestamp checks to determine which partitions have to
     * be re-indexed (see
     * {@link #indexPartition(PRI, SpiPartitionStreamProvider, long, boolean)}
     * for details).
     * <p>
     * Synchronization procedure (on partition level):
     * 
     * <pre>
     * -----------------------------------
     * input  | in index      | action
     * -----------------------------------
     * (p,tj) | (p,tk|tk!=tj) | reindex(p,tj)
     * (p,tj) | (p,tk|tk==tj) | nop
     * (p,tj) | -             | index(p, tj)
     * -      | (p,v)         | delete(p)
     * -----------------------------------
     * legend:
     * p - partition 
     * ti - timestamp i (ti > ti+1)
     * </pre>
     * The parameter <code>forced</code> can be used to deactivate the timestamp
     * checks. This will actually lead to the removal of all existing partitions
     * (in the given scope) and subsequent indexing of all given partitions.
     * <p>
     * All queries are blocked by this operation.
     * 
     * @param toIndex A list of known {@link PRI PRIs} of (meta-)models
     * partitions.
     * @param timestamps The timestamps of the given partitions.
     * @param streamProvider An input stream provider for the given partitions.
     * @param forced <code>false</code>: the default synchronization mechanism
     * is used<br>
     * <code>true</code>: deactivates the timestamp checks.
     * @param dataAreaDescriptor The descriptor of the data area which defines
     * the synchronization scope.
     * @return A synchronization report which describes the actions executed
     * during the synchronization on partition level.
     */
    public SyncReport synchronize( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor deletionScope );

    /**
     * Causes the index to synchronize its content for specified data area and
     * container with a set of given partitions. The content of the partitions
     * is provided via a {@link SpiPartitionStreamProvider}.
     * <p>
     * This method works in an analogous manner as
     * {@link #synchronize(com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncKind, PRI[], long[], SpiPartitionStreamProvider, boolean, DataAreaDescriptor)}
     * . It just additionally provides the possibility to define a container as
     * scope for the operation.
     * 
     * @param toIndex A list of known {@link PRI PRIs} of (meta-)models
     * partitions.
     * @param timestamps The timestamps of the given partitions.
     * @param streamProvider An input stream provider for the given partitions.
     * @param forced <code>false</code>: the default synchronization mechanism
     * is used<br>
     * <code>true</code>: deactivates the timestamp checks.
     * @param cri The identifier of the container which defines the
     * synchronization scope.
     * @return A synchronization report which describes the actions executed
     * during the synchronization on partition level.
     */
    public SyncReport synchronize( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, CRI deletionScope );

    /**
     * Causes the index to synchronize its content for specified data area and
     * container with a set of given partitions. The content of the partitions
     * is provided via a {@link SpiPartitionStreamProvider}.
     * <p>
     * This method works in an analogous manner as
     * {@link #synchronize(com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncKind, PRI[], long[], SpiPartitionStreamProvider, boolean, DataAreaDescriptor)}
     * , except that it allows to specify an explicit set of partitions to be
     * deleted, instead of deleting all partitions in the sync scope that are
     * not in the toIndex list.
     * 
     * @param toIndex A list of known {@link PRI PRIs} of (meta-)models
     * partitions.
     * @param timestamps The timestamps of the given partitions.
     * @param streamProvider An input stream provider for the given partitions.
     * @param forced <code>false</code>: the default synchronization mechanism
     * is used<br>
     * <code>true</code>: deactivates the timestamp checks.
     * @param dataArea The identifier of the container which defines the
     * synchronization scope.
     * @param toDelete The list of partitions that are to be deleted in the
     * synchronization scope
     * @return A synchronization report which describes the actions executed
     * during the synchronization on partition level.
     */
    public SyncReport synchronize( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor dataArea, PRI[] toDelete );

    /**
     * Causes the index to synchronize its content for specified data area and
     * container with a set of given partitions. The content of the partitions
     * is provided via a {@link SpiPartitionStreamProvider}.
     * <p>
     * In contrast to
     * {@link #synchronize(PRI[], long[], SpiPartitionStreamProvider, boolean, DataAreaDescriptor)}
     * all partitions are indexed in an inactive mode, i.e. changes are not
     * visible for queries until their activation (@see #activate(SyncTicket)).
     * <p>
     * Queries are NOT blocked during this operation.
     * <p>
     * CAUTION: You must synchronize on the IpiIndexManagement object for the
     * whole process of inactive indexing.
     * 
     * <pre>
     * Example:<br>
     * <code>
     *    synchronized( indexManagement ) {
     *      SyncTicket ticket = indexManagement.synchronizeInactive(...);
     *      indexManagement.activate( ticket );
     *      indexManagement.finalizeInactiveSync( ticket );
     *    }
     * </code>
     * </pre>
     * 
     * @see #synchronize(PRI[], long[], SpiPartitionStreamProvider, boolean,
     * DataAreaDescriptor)
     * @see #activate(SyncTicket)
     * @see #deactivate(SyncTicket)
     * @see #finalizeInactiveSync(SyncTicket)
     * @param toIndex A list of known {@link PRI PRIs} of (meta-)models
     * partitions.
     * @param timestamps The timestamps of the given partitions.
     * @param streamProvider An input stream provider for the given partitions.
     * @param forced <code>false</code>: the default synchronization mechanism
     * is used<br>
     * <code>true</code>: deactivates the timestamp checks.
     * @param dataAreaDescriptor The descriptor of the data area which defines
     * the synchronization scope.
     * @return A synchronization ticket that is needed for the activation and
     * finalization.
     */
    public SyncTicket synchronizeInactive( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor deletionScope );

    /**
     * Causes the index to synchronize its content for specified data area and
     * container with a set of given partitions. The content of the partitions
     * is provided via a {@link SpiPartitionStreamProvider}.
     * <p>
     * All constraints of
     * {@link #synchronizeInactive(PRI[], long[], SpiPartitionStreamProvider, boolean, DataAreaDescriptor)}
     * are also valid for this method.
     * 
     * @see #synchronizeInactive(PRI[], long[], SpiPartitionStreamProvider,
     * boolean, DataAreaDescriptor)
     * @param toIndex A list of known {@link PRI PRIs} of (meta-)models
     * partitions.
     * @param timestamps The timestamps of the given partitions.
     * @param streamProvider An input stream provider for the given partitions.
     * @param forced <code>false</code>: the default synchronization mechanism
     * is used<br>
     * <code>true</code>: deactivates the timestamp checks.
     * @param dataArea The identifier of the container which defines the
     * synchronization scope.
     * @param toDelete The list of partitions that are to be deleted in the
     * synchronization scope
     * @return A synchronization ticket that is needed for the activation and
     * finalization.
     */
    public SyncTicket synchronizeInactive( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, DataAreaDescriptor dataArea, PRI[] toDelete );

    /**
     * Causes the index to synchronize its content for specified data area and
     * container with a set of given partitions. The content of the partitions
     * is provided via a {@link SpiPartitionStreamProvider}.
     * <p>
     * All constraints of
     * {@link #synchronizeInactive(PRI[], long[], SpiPartitionStreamProvider, boolean, DataAreaDescriptor)}
     * are also valid for this method.
     * 
     * @see #synchronizeInactive(PRI[], long[], SpiPartitionStreamProvider,
     * boolean, DataAreaDescriptor) @param toIndex A list of known {@link PRI
     * PRIs} of (meta-)models partitions.
     * @param timestamps The timestamps of the given partitions.
     * @param streamProvider An input stream provider for the given partitions.
     * @param forced <code>false</code>: the default synchronization mechanism
     * is used<br>
     * <code>true</code>: deactivates the timestamp checks.
     * @param cri The identifier of the container which defines the
     * synchronization scope.
     * @return A synchronization ticket that is needed for the activation and
     * finalization.
     */
    public SyncTicket synchronizeInactive( PRI[] toIndex, long[] timestamps, SpiPartitionStreamProvider streamProvider, boolean forced, CRI deletionScope );

    /**
     * Activates inactively indexed and deactivates inactively deleted
     * partitions. This is just a switch of the activity state of partitions.
     * Use {@link #finalizeInactiveSync(SyncTicket)} to remove deleted
     * partitions.
     * 
     * @see #synchronizeInactive(PRI[], long[], SpiPartitionStreamProvider,
     * boolean, DataAreaDescriptor)
     * @param ticket The synchronization ticket
     */
    public void activate( SyncTicket ticket );

    /**
     * Reverts a prior activation on memory state level. It may only be used if
     * the activation failed.
     * 
     * @see #synchronizeInactive(PRI[], long[], SpiPartitionStreamProvider,
     * boolean, DataAreaDescriptor)
     * @param ticket The synchronization ticket
     */
    public void deactivate( SyncTicket ticket );

    /**
     * Finalizes the inactive sync process by deleting the deactivated
     * partitions. This method must be called even if the activation has failed.
     * 
     * @param ticket
     * @return
     */
    public SyncReport finalizeInactiveSync( SyncTicket ticket );

    /**
     * Returns the indexed timestamp of the given partition.
     * <p>
     * If the given partition is not indexed this method will return
     * <code>-1</code>.
     * 
     * @see #isPartitionIndexed(PRI)
     * @param pri Identifier of the partition.
     * @return The indexed timestamp of the given partition or <code>-1</code>
     * if the partition is not indexed.
     */
    public long getPartitionTimestamp( PRI pri );

    /**
     * Determines whether a partition is indexed.
     * 
     * @param pri PRI of the partition to check.
     * @return <code>true</code> if the partition is indexed, <code>false</code>
     * otherwise.
     */
    public boolean isPartitionIndexed( PRI pri );

    /**
     * Removes all content from the index.
     */
    public void clear( );
}
