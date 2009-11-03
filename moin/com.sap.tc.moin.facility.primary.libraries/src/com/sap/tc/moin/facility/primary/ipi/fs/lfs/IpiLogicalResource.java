package com.sap.tc.moin.facility.primary.ipi.fs.lfs;


/**
 * Resource interface with common methods. Resource might actually not exist.
 */
public interface IpiLogicalResource {

    /**
     * Is handle for an existing resource
     * 
     * @return true for existing resource, false else
     */
    public boolean exists( );

    /**
     * Can be casted to LogicalFolder (see {@link IpiLogicalFolder})
     * 
     * @return true for LogicalFolder, false else
     */
    public boolean isFolder( );

    /**
     * Can be casted to LogicalFile (see {@link IpiLogicalFile})
     * 
     * @return true for LogicalFile, false else
     */
    public boolean isFile( );

    /**
     * @return true for LogicalArchive, false else
     */
    public boolean isArchive( );

    /**
     * Get resource atomic name
     * 
     * @return NameString
     */
    public String getName( );

    /**
     * Get resource path
     * 
     * @return PathString, could be C:/testfs/root for java.io.file and
     * /moin.fct_nwdi__tc~moin~fct_nwdi~persistence~fs~api_dev/content for
     * org.eclipse.core.resources.IResource
     */
    public String getPath( );

    /**
     * Returns a canonical path of the resource.
     * 
     * @return A canonical pathname string
     * @throws RuntimeException If the canonical path can not be determined
     */
    public String getCanonicalPath( );

    /**
     * Get change timestamp as provided. Can indicate a real modification.
     * 
     * @return Date of last change
     */
    public long lastChangedTime( );

    /**
     * Returns the scenario specific system object (e.g. file system: File;
     * Eclipse: IFile) that represents this resource.
     * 
     * @param typeToken Class of expected resource type.
     * @return scenario specific system object or {@code null} if it is not of
     * typeToken class.
     */
    public <T> T getUnderlyingResource( Class<T> typeToken );
}
