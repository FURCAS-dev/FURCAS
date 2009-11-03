package com.sap.tc.moin.facility.primary.ipi.fs;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord.CreatableCheckResult;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;

/**
 * Facility internal IPI interface for a file system based handler for resource
 * folders and archives.
 * <p>
 * Provides other facility components access to update the scope of the file
 * system persistence. All update operations overwrite the existing scope.
 * <p>
 * The scope defines which resources are under file system persistence control.
 * Any scope changes or resource updates may result in the eviction of outdated
 * persistence in the MOIN core.
 * 
 * @author d047015
 * @author d045917
 */
public interface IpiFsResourceManagement {

    /*
     * On the possible existence, nature, and creatability of partitions
     */

    /**
     * Returns if the partition is read only.
     * 
     * @param pri The partition to check.
     * @return <code>true</code> if the partition is read only,
     * <code>false</code> otherwise.
     * @throws RuntimeException If the partition can not be found in the file
     * system.
     */
    public boolean partitionIsReadOnly( PRI pri );

    /**
     * Checks if the given partition can be created.
     * <p>
     * The returned data structure denotes if the partition can be created or
     * not. Possible results are: <br>
     * a) {@link CreatableCheckResult#CREATABLE}: partition does not exists and
     * path is valid<br>
     * b)
     * {@link CreatableCheckResult#NOT_CREATABLE_RESOURCE_ARCHIVE_NOT_WRITEABLE}
     * : The given pri can not be saved in a resource archive<br>
     * c) {@link CreatableCheckResult#NOT_CREATABLE_ALREADY_EXISTS}: partition
     * already exists<br>
     * d) {@link CreatableCheckResult#NOT_CREATABLE_CASE_CONFLICT}: partition
     * does not exists but a part of the path exists with different case
     * <p>
     * For case d) the existing path is included in the result data structure.
     * 
     * @param pri The partition to check.
     * @return A result record which denotes if the partition can be created or
     * not.
     * @throws MoinBaseException If a file system exception occurs.
     */
    public PartitionIsCreatableResultRecord partitionIsCreatable( PRI pri ) throws MoinBaseException;

    /**
     * Data structure for a results of method
     * {@link IpiFsResourceManagement#partitionIsCreatable(PRI)}.
     */
    public static final class PartitionIsCreatableResultRecord {

        /**
         * The result state.
         */
        public CreatableCheckResult result;

        /**
         * Contains the conflicting, already existing path if {@link #result} is
         * {@link CreatableCheckResult#NOT_CREATABLE_CASE_CONFLICT}.
         */
        public String existingPath;

        /**
         * Result state enumeration.
         */
        public enum CreatableCheckResult {

            /**
             * Denotes that the partition is <i>creatable</i>.
             */
            CREATABLE,

            /**
             * Denotes that the partition is <i>not creatable</i> because a
             * resource (partition or directory) with the given name already
             * exists.
             */
            NOT_CREATABLE_ALREADY_EXISTS,

            /**
             * Denotes that the partition is <i>not creatable</i> because it
             * points to a registered resource archive which can not be written.
             */
            NOT_CREATABLE_RESOURCE_ARCHIVE_NOT_WRITEABLE,

            /**
             * Denotes that the partition is <i>not creatable</i> because it's
             * name conflicts with an existing path.
             */
            NOT_CREATABLE_CASE_CONFLICT;
        }
    }

    /**
     * Returns if the partition exists.
     * <p>
     * This method is backed by the index.
     * 
     * @param pri The partition to check.
     * @return <code>true</code> if the partition exists, <code>false</code>
     * otherwise.
     */
    public boolean partitionExists( PRI pri );

    /*
     * Synchronization methods
     */

    /**
     * Updates the file system persistence on data area level. The scope is
     * updated based on the given resource information.
     * <p>
     * Partitions that are not longer up-to-date will be evicted in the MOIN
     * core.
     * 
     * @param dataAreaDescriptor The descriptor of the data area to update.
     * @param containerResourceRecords The resources to register.
     */
    public void updateDataArea( DataAreaDescriptor dataAreaDescriptor, List<ContainerResourceRecord> containerResourceRecords );

    /**
     * Removes the given data area from the scope of the file system
     * persistence.
     * <p>
     * Partitions that are not longer up-to-date will be evicted in the MOIN
     * core.
     * 
     * @param dataAreaDescriptor The descriptor of the data area to remove.
     */
    public void removeDataArea( DataAreaDescriptor dataAreaDescriptor );

    /**
     * Updates the file system persistence on container level. The scope is
     * updated based on the given resource information.
     * <p>
     * Partitions that are not longer up-to-date will be evicted in the MOIN
     * core.
     * <p>
     * If forced, the container update is guaranteed to be destructive.
     * 
     * @param cri The container to update.
     * @param resourceRecord The resources to register.
     * @param forced <code>true</code> if the container update shall be
     * destructively.
     */
    public void updateContainer( CRI cri, ResourceRecord resourceRecord, boolean forced );

    /**
     * Removes the given container from the scope of the file system
     * persistence.
     * <p>
     * Partitions that are not longer up-to-date will be evicted in the MOIN
     * core.
     * 
     * @param cri The container to remove.
     */
    public void removeContainer( CRI cri );

    /**
     * Updates the given partitions in the file system persistence.
     * <p>
     * Partitions that are not longer up-to-date will be evicted in the MOIN
     * core.
     * 
     * @param partitionResourceRecords Resource information for all partitions
     * to update.
     */
    public void updatePartitions( List<PartitionResourceRecord> partitionResourceRecords );

    /**
     * Data Structure for resource registration.
     */
    abstract public static class ResourceRecord {
    }

    /**
     * Data structure for resource folder registration.
     */
    public static final class ResourceFoldersRecord extends ResourceRecord {

        /**
         * Maps resource folder paths to root folder paths (each registered
         * resource folder has exactly one root folder).
         */
        public Map<String, String> resourceFolderPathsToRootPaths;
    }

    /**
     * Data structure for resource archive registration.
     */
    public static final class ResourceArchivesRecord extends ResourceRecord {

        /**
         * A list of paths to resource archives.
         */
        public List<String> archivePaths;

        /**
         * A list of resource folders that specify relevant folders inside the
         * archives denoted in <code>archivePaths</code>.
         */
        public List<String> resourceFoldersPaths;
    }

    /**
     * Data structure for the registration of folders containing resource folder
     * archives.
     */
    public static final class ResourceArchiveFoldersRecord extends ResourceRecord {

        /**
         * A list of folder paths to resource archives.
         */
        public List<String> archiveFoldersPaths;

        /**
         * A list of resource folders that specify relevant folders inside the
         * archives denoted in <code>archivePaths</code>.
         */
        public List<String> resourceFoldersPaths;
    }

    /**
     * Data structure for resource registration with container scope.
     */
    public static final class ContainerResourceRecord {

        /**
         * The container that contains the resources.
         */
        public CRI cri;

        /**
         * The resources to be registered for the container.
         */
        public ResourceRecord resourceRecord;
    }

    /**
     * Data structure containing information on partition resources that have to
     * be updated.
     */
    public static final class PartitionResourceRecord {

        /** Root path of the partition. */
        public String rootPath;

        /** Partition name (which includes the resource folder). */
        public String partitionName;

        /** An input stream provider for the partition. */
        public PartitionResourceRecord.InputStreamProvider streamProvider;

        /** The timestamp of the resource. */
        public long timestamp;

        /** The operation which caused the resource update. */
        public Operation operation;

        /**
         * A (parameterless) input stream provider in the style of
         * {@link SpiPartitionStreamProvider}.
         */
        public interface InputStreamProvider {

            /**
             * Returns the input stream for the partition.
             * 
             * @return The input stream for the partition.
             */
            public InputStream getInputStream( );
        }

        /**
         * Operation which caused a resource update on partition level.
         */
        public enum Operation {

            /** The partiton was created. */
            CREATED,

            /** The partiton was changed. */
            CHANGED,

            /**
             * The partition was deleted.
             * <p>
             * With deletion, the inputStream and timestamp attributes do not
             * have to be set.
             */
            DELETED;
        }

        @Override
        public String toString( ) {

            return super.toString( ) + "(" + this.rootPath + "/" + this.partitionName + " <" + this.operation + ":" + timestamp + ">)"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
        }

    }

    /*
     * On registered and available resources
     */

    /**
     * Indicates if any resources are available for a given container.
     * <p>
     * The decisive factor for the returned result is if a previous container
     * update actually registered relevant resources.<br>
     * The registration of an archive folder that does not contain any relevant
     * archives will cause this method to return <code>false</code>.
     * 
     * @param cri The container to check.
     * @return <code>true</code> if resources are available for a given
     * container, <code>false</code> otherwise.
     */
    public boolean resourcesAvailableForContainer( CRI cri );

    /**
     * Returns the registered resource folders for a given rootPath.
     * 
     * @param rootPath The root path.
     * @return The registered resource folders for the given rootPath.
     */
    public Set<String> getRegisteredResourceFoldersForRootPath( String rootPath );

    /**
     * Returns all registered resource folders for the given container.
     * <p>
     * This all known resource folders whether they are registered for folders
     * or archives.
     * 
     * @param cri The container.
     * @return All registered resource folders for the given container.
     */
    public Set<String> getRegisteredResourceFoldersForContainer( CRI cri );

    /**
     * Returns storage for a given PRI. Returns null if no storage is
     * responsible.
     * 
     * @param pri The partition.
     * @return The storage which is responsible for the given partition.
     */
    public IpiStorage getStorageResponsibleForPRI( PRI pri );

}
