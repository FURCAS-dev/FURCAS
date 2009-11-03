package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.IOException;
import java.io.InputStream;

/**
 * Interface for the generic archive access.
 * 
 * @author D026715
 */

public interface IpiMetamodelArchiveAccess {

    /**
     * Returns content of the resource identified by a path.
     * 
     * @param resourceName
     * @return
     */
    InputStream getResourceAsStream( String resourceName ) throws IOException;

    /**
     * Checks if the given resource exists.
     * 
     * @param resourceName
     * @return
     * @throws IOException
     */
    boolean resourceExists( String resourceName );

    /**
     * Returns an id of the archive.
     * 
     * @return
     */
    String getArchiveId( );

    /**
     * Returns the timestamp of the last modification.
     * 
     * @return
     */
    long getLastModified( );

    /**
     * Returns the length of a resource identified by the given name.
     * 
     * @param resourceName
     * @return
     */
    long getContentLength( String resourceName );

    /**
     * Closes the archive.
     * 
     * @throws IOException
     */
    void close( ) throws IOException;
}
