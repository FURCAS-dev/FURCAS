package com.sap.tc.moin.facility.primary.ipi;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinBaseException;

/**
 * Facility internal IPI interface for a file system based storage.
 */
public interface IpiStorage {

    /**
     * Returns an input stream for the given partition.
     * 
     * @param pri The partition for which the stream is requested.
     * @return An input stream for the given partition.
     * @throws RuntimeException if the stream could not be created or opened for
     * some reason.
     */
    public InputStream getInputStreamForPartitionLoad( PRI pri );

    /**
     * Returns an input stream for the texts of the given partition.
     * 
     * @param pri The partition for which the stream is requested.
     * @return An input stream for the given partition.
     * @throws RuntimeException if the stream could not be created or opened for
     * some reason.
     */
    public InputStream getInputStreamForPartitionTextLoad( PRI pri );

    /**
     * Returns an output stream for the given partition.
     * 
     * @param pri The partition for which the stream is requested.
     * @return An output stream for the given partition.
     * @throws RuntimeException if the stream could not be created or opened for
     * some reason.
     */
    public OutputStream getOutputStreamForPartitionStore( PRI pri );

    /**
     * Returns an output stream for the texts in the given partition.
     * 
     * @param pri The partition for which the stream is requested.
     * @return An output stream for the texts in the given partition.
     * @throws RuntimeException if the stream could not be created or opened for
     * some reason.
     */
    public OutputStream getOutputStreamForPartitionTextStore( PRI pri );

    /**
     * Deletes the given partition.
     * 
     * @param pri The partition to delete.
     * @return <code>true</code> if the partition was deleted successfully,
     * <code>false</code> otherwise.
     */
    public boolean deletePartition( PRI pri );

    /**
     * Deletes the texts of given partition.
     * 
     * @param pri The partition for which the texts should be deleted.
     * @return <code>true</code> if the partition texts were deleted
     * successfully, <code>false</code> otherwise.
     */
    public boolean deletePartitionTexts( PRI pri );

    /**
     * Returns if the given partition is read-only.
     * 
     * @param pri The partition to check.
     * @return <code>true</code> if the given partition is read-only,
     * <code>false</code> otherwise.
     */
    public boolean isPartitionReadonly( PRI pri );

    /**
     * Returns the timestamp of the last change.
     * 
     * @param pri The partition identifier
     * @return The timestamp of the last change.
     */
    public long partitionLastChanged( PRI pri );

    /**
     * Returns the file size of the given partition.
     * 
     * @param pri The partition identifier to determine the file size for.
     * @return The file size in bytes for the given {@link PRI} or
     * <code>-1</code> if the partition does not exist.
     */
    public long partitionFileSize( PRI pri );

    /**
     * Data structure that holds (meta) information which is related to a
     * specific partition.
     */
    static public final class PartitionInfo {

        /** The name of the partition. */
        public String partitionName;

        /** The timestamp of the partition. */
        public long timeStamp;
    }

    /**
     * Returns {@link PartitionInfo PartitionInfos} for all partitions in this
     * storage.
     * 
     * @return {@link PartitionInfo PartitionInfos} for all partitions in this
     * storage.
     */
    public List<PartitionInfo> getPartitionInfos( );

    /**
     * Returns the absolute path to the source directory or jar containing the
     * partitions.
     * 
     * @return The absolute path to the source directory or jar.
     */
    public String getSourcePath( );

    /**
     * Performs a case sensitive check and returns if the given relative path
     * can potentially be created.
     * <p>
     * If one ore more sections (folder or file) in the given path already exist
     * in a different case this method will return <code>false</code> as well as
     * the existing path.
     * 
     * @param relativePath The relative path to check.
     * @return A result record which denotes if the given relative path can
     * potentially be created.
     * @throws MoinBaseException
     */
    public PartitionIsCreatableResultRecord isPathCreatable( String relativePath ) throws MoinBaseException;

    /**
     * Returns the registered resource folder name of this storage.
     * <p>
     * This storage will only resolve (is responsible for) {@link PRI PRIs}
     * which are located in this resource folder.
     * 
     * @return The resource folder name of this storage.
     * @see #isResponsible(PRI)
     */
    public String getResourceFolder( );

    /**
     * May this storage contain partitions indicated by the PRI? The answer
     * depends on the development component vendor and development component
     * name of the storage area and the PRI.
     * 
     * @param pri The partition to check.
     * @return <code>true</code> if this storage can handle the object indicated
     * by the {@link PRI}.
     */
    public boolean isResponsible( PRI pri );


    /**
     * Checks is a text file (xlf) exists for a given partition.
     * 
     * @param pri The partition to check.
     * @return <code>true</code> if a xlf file exists for the object indicated
     * by the {@link PRI}.
     */
    public boolean textFileExists( PRI pri );


    /**
     * Gets the resource handle for a given partition. The function returns
     * {@code null}, if the partition is inside an archive.
     * 
     * @param pri The partition to get the IpiLogicalResource for.
     * @return <code>IpiLogicalResource</code> for the pri. {@code null} if the
     * partition is inside an archive.
     */
    public IpiLogicalResource getPartitionResourceHandle( PRI pri );

    /**
     * Gets the resource handle for a given partition text file. The function
     * returns {@code null}, if the partition is inside an archive.
     * 
     * @param pri The partition to get the IpiLogicalResource for.
     * @return <code>IpiLogicalResource</code> for the pri. {@code null} if the
     * partition is inside an archive.
     */
    public IpiLogicalResource getTextFileResourceHandle( PRI pri );

}