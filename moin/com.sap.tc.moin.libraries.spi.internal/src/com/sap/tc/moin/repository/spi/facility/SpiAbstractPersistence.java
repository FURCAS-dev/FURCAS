package com.sap.tc.moin.repository.spi.facility;

import java.util.Collection;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XDocument;

/**
 * An abstract {@link SpiPersistence} implementation which provides a default
 * implementation for the bulk save operation and the callback mechanism.
 * <p>
 * Therefore this class defines to abstract methods which are responsible for
 * saving and deleting single partitions.
 * 
 * @see SpiPersistence
 */
public abstract class SpiAbstractPersistence implements SpiPersistence {

    /**
     * Processes a save operation for a set of given partitions (see
     * {@link SpiPersistence} for details).
     * <p>
     * This implementation splits the bulk operation into single partition save
     * operations. Therefore it delegates to the abstract methods:<br>
     * -
     * {@link #storePartition(Connection, SpiModelPartition, SpiPartitionDelta)}
     * for the creation and update of partitions and<br>
     * - {@link #deletePartition(PRI, SpiStage)} for the deletion of partitions.
     * <p>
     * In addition this default implementation takes care for catching exception
     * which might occur during the save process and nofities the caller about
     * the results via the callback mechanism defined in {@link SpiPersistence}.
     * 
     * @param conn The connection which is the context of the save operation.
     * @param partitionsToBeStored A {@link Collection} of partitions to be
     * stored (not yet existing and already existing partitions). May be
     * <code>null</code>.
     * @param partitionsToBeDeleted A {@link Collection} of partitions to be
     * deleted. May be <code>null</code>.
     * @param cb The callback interface to be notified when save is finished.
     * May be <code>null</code>.
     * @param changeRecorder A partition change recorder which provides deltas
     * for the processed partitions.
     * @param lockHandle A handle for locks previously obtained by the
     * {@link SpiExternalSaveLocking} service of this facility.
     * @see SpiPersistence#savePartitions(Connection, Collection, Collection,
     * com.sap.tc.moin.repository.spi.facility.SpiPersistence.SaveCallback,
     * SpiPartitionChangeRecorder, Object)
     */
    public void savePartitions( Collection<SpiPartitionSaveContext> partitionsToBeCreated, Collection<SpiPartitionSaveContext> partitionsToBeEdited, Collection<SpiPartitionSaveContext> partitionsToBeDeleted, Object lockHandle ) {

        if ( partitionsToBeCreated != null && partitionsToBeCreated.size( ) > 0 ) {
            for ( SpiPartitionSaveContext toCreate : partitionsToBeCreated ) {
                try {
                    this.storePartition( toCreate );
                    this.storePartitionTexts( toCreate );
                } catch ( Throwable t ) {
                    toCreate.signalFail( t );
                }
            }
        }
        if ( partitionsToBeEdited != null && partitionsToBeEdited.size( ) > 0 ) {
            for ( SpiPartitionSaveContext toEdit : partitionsToBeEdited ) {
                try {
                    this.storePartition( toEdit );
                    this.storePartitionTexts( toEdit );
                } catch ( Throwable t ) {
                    toEdit.signalFail( t );
                }
            }
        }
        if ( partitionsToBeDeleted != null && partitionsToBeDeleted.size( ) > 0 ) {
            for ( SpiPartitionSaveContext toDelete : partitionsToBeDeleted ) {
                try {
                    this.deletePartition( toDelete.getPri( ) );
                    deletePartitionTexts( toDelete.getPri( ) );
                } catch ( Throwable t ) {
                    toDelete.signalFail( t );
                }
            }
        }
    }

    /**
     * Makes the contents of the model partition passed as parameter persistent.
     * <p>
     * The implementation may choose to use the changes passed in the
     * {@link SpiPartitionDelta} parameter. This can be an efficient solution
     * particularly for fine-grained database like stores, whereas a filesystem
     * store will typically pass all model elements of the partition to a
     * serializer.
     * <p>
     * Storing a partition may fail for various reasons. Implementors of this
     * method are expected to throw a {@link RuntimeException} in case of any
     * problem which prevents the deletion.<br>
     * This is necessary to fulfill the callback contract defined in
     * {@link SpiPersistence}.
     * <p>
     * This abstract method <i>is</i> intended to be implemented by service
     * providers.
     * 
     * @param conn
     * @param mp
     * @param delta
     * @throws RuntimeException Thrown if any problem occurs which prevents the
     * storage of the partition.
     */
    abstract protected void storePartition( SpiPartitionSaveContext toSave );

    /**
     * Deletes a partition from the persistence.
     * <p>
     * The method does not care about inconsistencies that might be caused by
     * the deletion.
     * <p>
     * The deletion of a partition may fail for various reasons. Implementors of
     * this method are expected to throw a {@link RuntimeException} in case of
     * any problem which prevents the deletion.<br>
     * This is necessary to fulfill the callback contract defined in
     * {@link SpiPersistence}.
     * <p>
     * This abstract method <i>is</i> intended to be implemented by service
     * providers.
     * 
     * @param pri Identifier of the partition to be deleted.
     * @throws RuntimeException Thrown if any problem occurs which prevents the
     * deletion of the partition.
     */
    abstract protected void deletePartition( PRI pri );

    /**
     * Makes the text contents of the model partition passed as parameter
     * persistent.
     * <p>
     * The implementation may choose to use the changes passed in the
     * {@link SpiPartitionDelta} parameter. This can be an efficient solution
     * particularly for fine-grained database like stores, whereas a filesystem
     * store will typically pass all model elements of the partition to a
     * serializer.
     * <p>
     * Storing may fail for various reasons. Implementors of this method are
     * expected to throw a {@link RuntimeException} in case of any problem which
     * prevents the storage.<br>
     * This is necessary to fulfill the callback contract defined in
     * {@link SpiPersistence}.
     * <p>
     * This abstract method <i>is</i> intended to be implemented by service
     * providers.
     * 
     * @param conn
     * @param mp
     * @param s2xDocument
     * @throws RuntimeException Thrown if any problem occurs which prevents the
     * storage of the partition.
     */
    abstract protected void storePartitionTexts( SpiPartitionSaveContext toSave, SpiS2XDocument s2xDocument );

    /**
     * The function optionally stores partition texts depending on the usage
     * scenario. Texts must be stored if:
     * <ul>
     * <li>a partition text file already exists.
     * <li>the partition contains translated texts.
     * </ul>
     * In this case the function should delegate to
     * <code>SpiAbstractPersistence#storePartitionTexts(SpiPartitionSaveContext, SpiS2XDocument)</code>
     * .
     * 
     * @param partition
     * @throws RuntimeException Thrown if any problem occurs which prevents the
     * storage of the texts.
     */
    protected void storePartitionTexts( SpiPartitionSaveContext partition ) {

    }

    /**
     * Deletes the partition texts from the persistence.
     * <p>
     * The method does not care about inconsistencies that might be caused by
     * the deletion.
     * <p>
     * The deletion of partition texts may fail for various reasons.
     * Implementors of this method are expected to throw a
     * {@link RuntimeException} in case of any problem which prevents the
     * deletion.<br>
     * This is necessary to fulfill the callback contract defined in
     * {@link SpiPersistence}.
     * 
     * @param pri Identifier of the partition to be deleted.
     * @throws RuntimeException Thrown if any problem occurs which prevents the
     * deletion of the partition.
     */
    protected void deletePartitionTexts( PRI pri ) {

    }

}
