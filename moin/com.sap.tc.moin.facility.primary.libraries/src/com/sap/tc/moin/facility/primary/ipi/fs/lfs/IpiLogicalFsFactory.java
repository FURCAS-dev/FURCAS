package com.sap.tc.moin.facility.primary.ipi.fs.lfs;


/**
 * Provides access to resources for logical file system.
 */
public interface IpiLogicalFsFactory {

    /**
     * Retrieve handle for root object identified by the path. This should
     * either be a folder or an archive in the case of build results
     * 
     * @param absolutePath Absolute path matching to the targeted logical
     * filesystem path. This could be C:/testfs/root for java.io.file and
     * /moin.fct_nwdi__tc~moin~fct_nwdi~persistence~fs~api_dev/content for
     * org.eclipse.core.resources.IResource
     * @return Object instance or null if not found
     */
    public IpiLogicalResource getResource( String absolutePath );

    /**
     * Creates a file referenced by a given absolute path if it does not exist.
     * <br>
     * Not existing parent folders are implicitly created.
     * 
     * @param absolutePath Absolute path of the file to create matching to the
     * targeted logical filesystem path. This could be
     * <code>C:/testfs/root</code> for {@link java.io.File} and
     * <code>/moin.fct_nwdi__tc~moin~fct_nwdi~persistence~fs~api_dev/content</code>
     * for {@link org.eclipse.core.resources.IResource}
     * @return LogicalFile A logical representation of the created file.
     * @throws RuntimeException If the file to create already exists or it could
     * not be created for some reason (e.g. if the given name of the file is not
     * valid in the underlaying file system).
     */
    public IpiLogicalFile createFile( String absolutePath );

    /**
     * Creates a folder referenced by a given absolute path if it does not
     * exist. <br>
     * Not existing parent folders are implicitly created.
     * 
     * @param absolutePath Absolute path of the folder to create matching to the
     * targeted logical filesystem path. This could be
     * <code>C:/testfs/root</code> for {@link java.io.File} and
     * <code>/moin.fct_nwdi__tc~moin~fct_nwdi~persistence~fs~api_dev/content</code>
     * for {@link org.eclipse.core.resources.IResource}
     * @return LogicalFile A logical representation of the created folder.
     * @throws RuntimeException If the file to create already exists or it could
     * not be created for some reason (e.g. if the given name of the folder is
     * not valid in the underlaying file system).
     * @throws IllegalArgumentException For illegal arguments like an empty
     * {@link String}.
     */
    public IpiLogicalFolder createFolder( String absolutePath );

}
