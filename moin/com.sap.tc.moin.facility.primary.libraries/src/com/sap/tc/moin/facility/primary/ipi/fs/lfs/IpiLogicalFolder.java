package com.sap.tc.moin.facility.primary.ipi.fs.lfs;

/**
 * Folder interface for accessing or creating included resources
 */
public interface IpiLogicalFolder extends IpiLogicalResource {

    /**
     * Get handles for all resources directly in the folder
     * 
     * @return Array of resources
     */
    public IpiLogicalResource[] listResources( );

    /**
     * Retrieve handle for root object identified by the path. This should
     * either be a folder or an archive in the case of build results
     * 
     * @param relativePath
     * @return Object instance
     */
    public IpiLogicalResource getResource( String relativePath );

    /**
     * Creates a file referenced by a given relative path if it does not exist.
     * The relative path is resolved against this folder.
     * 
     * @param relativePath relative path of the file to create.
     * @return LogicalFile A logical representation of the created file.
     * @throws RuntimeException If the file to create already exists or it could
     * not be created for some reason (e.g. if the name of the file is not valid
     * in the underlaying file system).
     */
    public IpiLogicalFile createFile( String relativePath );

}
