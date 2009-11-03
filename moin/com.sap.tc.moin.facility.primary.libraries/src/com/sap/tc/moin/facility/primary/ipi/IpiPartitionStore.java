package com.sap.tc.moin.facility.primary.ipi;

import java.io.InputStream;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;

/**
 * A store which provides means read, write, and delete content and meta
 * information of model as well as meta model partitions.
 * <p>
 * If the relevant meta information of model and meta model partitions (which is
 * saved besides the content itself) diverge in the future this interface should
 * be divided accordingly.
 */
public interface IpiPartitionStore {

    /**
     * A data structure which is used to transport partition meta information.
     */
    public abstract static class PartitionRecord {

        /** The {@ink PRI} of the partition described by this record. */
        public PRI pri;

        /**
         * A partition version id (no predefined semantics, could be a
         * modification date/time or changelist number).
         */
        public long versionId;

        // FIXME: this should be a long (db schema has to be adapted accordingly)
        /** The length of the <code>contentInputStream</code>. */
        public int streamLength;
    }

    /**
     * A data structure which enriches the partition meta information record
     * with a stream provider that provides the partition content.
     */
    public static final class PartitionLoadRecord extends PartitionRecord {

        /** Stream provider for the reading the partitions content. */
        public SpiPartitionStreamProvider contentStreamProvider;

    }

    /**
     * A data structure which enriches the partition meta information record
     * with the content to save.
     */
    public static final class PartitionSaveRecord extends PartitionRecord {

        /** Input stream from which the content to be saved can be read. */
        public InputStream contentInputStream;
    }

    /**
     * Returns the {@link PRI}s of all stored partitions (active state).
     * 
     * @return all stored partitions
     */
    public PRI[] getAllStoredPris( );

    /**
     * Loads the persisted partition information denoted by the given
     * {@link PRI} from the store.
     * 
     * @param pri The partition to load.
     * @return The loaded partition information or <code>null</code> if the
     * partition does not exist.
     */
    public PartitionLoadRecord loadPartition( PRI pri );

    /**
     * Loads the inactive persisted partition information denoted by the given
     * {@link PRI} from the store.
     * 
     * @param pri The partition to load.
     * @return The loaded partition information or <code>null</code> if the
     * partition does not exist.
     */
    public PartitionLoadRecord loadPartitionInactive( PRI pri );

    /**
     * Stores the given partition information in the partition store. Existence
     * check is included, and subsequently either a new partition is added or an
     * existing partition is updated.
     * 
     * @param saveRecord The partition information to save.
     * @throws RuntimeException for unexpected SQL Exceptions
     */
    public void storePartition( PartitionSaveRecord saveRecord );

    /**
     * Updates the given partition information in the partition store.
     * Prerequisite is an existing partition. Existence is not checked. For
     * missing partition an exception is thrown.
     * 
     * @param saveRecord The partition information to save.
     * @throws RuntimeException for SQL Exceptions
     */
    public void updatePartition( PartitionSaveRecord saveRecord );

    /**
     * Adds the given partition information in the partition store. Prerequisite
     * is a new partition. Existence is not checked. For existing partition an
     * exception is thrown.
     * 
     * @param saveRecord The partition information to save.
     * @throws RuntimeException for SQL Exceptions
     */
    public void addPartition( PartitionSaveRecord saveRecord );

    /**
     * Adds the given partition information as inactive in the partition store.
     * Prerequisite is a new partition. Existence is not checked. For existing
     * partition an exception is thrown.
     * 
     * @param saveRecord The partition information to save.
     * @throws RuntimeException for SQL Exceptions
     * @throws UnsupportedOperationException for partitions in the metamodel
     * data area
     */
    public void addPartitionInactive( PartitionSaveRecord saveRecord );

    /**
     * Removes the partition denoted by the given {@link PRI} from the partition
     * store if it exists.
     * 
     * @param pri The partition to delete.
     */
    public void deletePartition( PRI pri );

    /**
     * Deletes all partitions in the given {@link DataArea} from the partition
     * store.
     * 
     * @param dataArea The data area to remove from the partition store.
     */
    public void deletePartitions( DataArea dataArea );

    /**
     * Deletes all partitions in the container denoted by the given {@link CRI}
     * from the partition store.
     * 
     * @param cri The container to remove from the partition store.
     * @throws RuntimeException for unexpected SQL Exceptions
     */
    public void deletePartitions( CRI cri );

    /**
     * Activates a set of given partitions.
     * <p>
     * For each given PRI
     * <ul>
     * <li>the active entry will be removed if it exists</li>
     * <li>the corresponding inactive entry will become the active entry if it
     * exists.</li>
     * </ul>
     * The following table illustrates the activation results: *
     * 
     * <pre>
     * |-----------|-------------|-------------|---------------|
     * | active(t) | inactive(t) | active(t+1) | inactive(t+1) |
     * |-----------|-------------|-------------|---------------|
     * | p1        | p1'         | p1'         |               |
     * |           | p2          | p2          |               |
     * | p3        |             |             |               |
     * |-----------|-------------|-------------|---------------|
     * </pre>
     * 
     * @param pris The partitions to activate
     * @see #addPartitionInactive(PartitionSaveRecord)
     * @see #loadPartitionInactive(PRI)
     */
    public void activate( PRI[] pris );

}
