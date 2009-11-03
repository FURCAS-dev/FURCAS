package com.sap.tc.moin.repository.spi.facility;

import java.util.Collection;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;

/**
 * The persistence API which is used to load and store model partitions by the
 * transient repository core.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @see SpiFacility
 * @author d043530
 */
public interface SpiPersistence {

    /**
     * Loads a model partition from the persistent store. Returns
     * <code>true</code> if the load was successful, <code>false</code>
     * otherwise.
     * <p>
     * The implementation is expected to use a kind of partition reader in order
     * to load the partition into the target workspace. The facility itself
     * should only obtain the partition data and delegate all other tasks.
     * <p>
     * The {@link SpiPartitionLoadContext loadContext} parameter provides an
     * operational context. It provides information needed to load the partition
     * as well as a callback which can be used by partition readers in order to
     * actually load the partition into MOIN core.
     * 
     * @param loadContext Provides context information for the load operation
     * and provides a parser callback.
     * @return <code>false</code> if the partition could not be loaded. Possible
     * reasons are: the partition does not exist or an exception occurred.
     * <code>true</code> if the load was successful.
     */
    public boolean loadPartition( SpiPartitionLoadContext loadContext );

    /**
     * Operational context for partition load operations.
     * <p>
     * Provides information needed to load a partition as well as a callback
     * which can be used by partition readers in order to actually load the
     * partition into MOIN core.
     */
    public interface SpiPartitionLoadContext {

        /**
         * Sets the timestamp that denotes the time at which the partition was
         * persisted on the loaded model partition.
         * <p>
         * This information has to be provided by the persistence.
         * 
         * @param timestamp Denotes the time at which the partition was
         * originally persisted
         */
        public void setPersistedTimestamp( long timestamp );

        /**
         * Returns the {@link PRI} of the partition to be loaded.
         * 
         * @return The {@link PRI} of the partition to be loaded
         */
        public PRI getPri( );

        /**
         * Returns the {@link SpiParserCallback} for the load operation.
         * 
         * @return The {@link SpiParserCallback} for the load operation
         */
        public SpiParserCallback getParserCallback( );

        /**
         * Returns the {@link SpiStage} the load operations relates to.
         * 
         * @return The {@link SpiStage} the load operations relates to
         */
        public SpiStage getStage( );

        /**
         * Returns the {@link SpiSession session} that triggered the load.
         * 
         * @return the session that triggered the load
         */
        public SpiSession getSession( );
    }

    /**
     * Processes a save operation for a set of given partitions.
     * <p>
     * This encompasses the creation and update (elements of
     * <code>partitionsToBeSaved</code>) as well as the deletion (elements of
     * <code>partitionsToBeDeleted</code>) of existing partitions.
     * <p>
     * Implementors must guarantee that
     * {@link SpiPartitionSaveContext#signalFail(Throwable)} is called for each
     * partition that could not be save. Possibly occurred exceptions must be
     * reported using the {@link SpiPartitionSaveContext#signalFail(Throwable)
     * signalFail()} method and must not be thrown.
     * 
     * @param partitionsToBeAdded A {@link Collection} of
     * {@link SpiPartitionSaveContext}s representing a save operation for not
     * yet existing partitions. May be <code>null</code>.
     * @param partitionsToBeEdited A {@link Collection} of
     * {@link SpiPartitionSaveContext}s representing a save operation for
     * already existing partitions. May be <code>null</code>.
     * @param partitionsToBeDeleted A {@link Collection} of
     * {@link SpiPartitionSaveContext}s representing a deletion operation for
     * existing partitions. May be <code>null</code>.
     * @param lockHandle A handle for locks previously obtained by the
     * {@link SpiExternalSaveLocking} service of this facility.
     * @see SpiExternalSaveLocking
     * @see SpiFacility#getExternalSaveLocking()
     * @see SpiPartitionDelta
     * @see SpiPartitionSaveContext
     */
    public void savePartitions( Collection<SpiPartitionSaveContext> partitionsToBeAdded, Collection<SpiPartitionSaveContext> partitionsToBeEdited, Collection<SpiPartitionSaveContext> partitionsToBeDeleted, Object lockHandle );

    /**
     * Operational context for partition save operations.
     * <p>
     * Provides information needed to load a partition as well as a callback
     * which can be used by partition readers in order to actually load the
     * partition into MOIN core.
     */
    public interface SpiPartitionSaveContext {

        /**
         * Sets the timestamp that denotes the time at which the partition was
         * persisted on the loaded model partition.
         * <p>
         * This information has to be provided by the persistence after an
         * actual save operation.
         * 
         * @param timestamp Denotes the time at which the partition was
         * originally persisted
         */
        public void setPersistedTimestamp( long timestamp );

        /**
         * Returns the timestamp that denotes the time at which the partition
         * was persisted from the loaded model partition.
         * 
         * @return Denotes the time at which the partition was actually
         * persisted
         */
        public long getPersistedTimestamp( );

        /**
         * Returns the {@link SpiSerializerCallback} for the save operation.
         * 
         * @return The {@link SpiSerializerCallback} for the save operation
         */
        public SpiSerializerCallback getSerializerCallback( );

        /**
         * Returns the {@link PRI} of the partition related to this save
         * operation.
         * 
         * @return The {@link PRI} of the partition related to this save
         * operation
         */
        public PRI getPri( );

        /**
         * Allows to report a failed save operation.
         * 
         * @param t The error which cause the save operation to fail
         * @see #hasFailed()
         * @see #getFailedReason()
         */
        public void signalFail( Throwable t );

        /**
         * Returns if the save operation failed.
         * 
         * @return <code>true</code> if the save operation failed,
         * <code>false</code> otherwise
         * @see #signalFail(Throwable)
         * @see #getFailedReason()
         */
        public boolean hasFailed( );

        /**
         * Returns the {@link Throwable} which caused the save operation to
         * fail.
         * 
         * @return The {@link Throwable} which caused the save operation to fail
         */
        public Throwable getFailedReason( );

        /**
         * Returns the save operation to be performed.
         * 
         * @return The save operation to be performed
         */
        public SpiSaveOperation getOperation( );

        /**
         * The partition delta for the partition related to this save context
         * (except for partitions to be deleted).
         * 
         * @return the partition delta for the partition related to this save
         * context (except for partitions to be deleted)
         */
        public SpiPartitionDelta getPartitionDelta( );

        /**
         * Returns the {@link SpiStage} the save operations relates to.
         * 
         * @return The {@link SpiStage} the save operations relates to
         */
        public SpiStage getStage( );

        /**
         * Denotes if the partition related to the save operation was already
         * stored persistently.
         * 
         * @return <code>true</code> if the partition related to the save
         * operation was already stored persistently, <code>false</code>
         * otherwise
         */
        public boolean isPartitionPersisted( );

        /**
         * Denotes if the partition related to the save operation has
         * translatable texts.
         * 
         * @return <code>true</code> if the partition related to the save
         * operation has translatable texts, <code>false</code> otherwise
         */
        public boolean hasTranslatableTexts( );

        /**
         * Returns the number of elements in the partition.
         * 
         * @return the number of elements in the partition
         */
        public int getNumberOfElements( );

        /**
         * Returns the number of links in the partition.
         * 
         * @return the number of links in the partition
         */
        public int getNumberOfLinks( );
    }

    /**
     * An enumeration representing types of save operations.
     */
    public enum SpiSaveOperation {
        ADD, EDIT, DELETE;
    }

}
