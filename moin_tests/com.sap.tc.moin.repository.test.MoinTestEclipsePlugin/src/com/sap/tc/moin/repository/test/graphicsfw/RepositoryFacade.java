package com.sap.tc.moin.repository.test.graphicsfw;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * Implementations of this interface are used by the TestsUtil classes for the communication with the infrastructure.
 * Implementations of this interface can be statefull, and should manage their state itself.
 * The Instance can be used after calling createConnection(), and before closeConnection(). 
 * The implementation must self contain a mechanisms to load the required metamodels. 
 * 
 * @author d043982
 */
public interface RepositoryFacade {

    /**
     * Initializes the repository, and creates a new connection/session
     *
     * @throws RepositoryException 
     */
    public void getConnection( ) throws RepositoryException;

    /**
     * Closes the connection/session. Modifications that were not saved are lost.
     * After closing the connection, all resources must be released.
     * Calling createConnection() after closing the connection should result in 
     * a new connection with clear caches.
     * 
     * @throws RepositoryException
     */
    public void closeConnection( ) throws RepositoryException;

    /**
     * Returns the RefPackage whose fully qualified name is provided as parameter
     * 
     * @param containerName Name of the model container for the requested RefPackage
     * @param refPackageName Fully qualified name of the JMI RefPackage
     * 
     * @return RefPackage, or null if such a RefPackage could not be found
     */
    public RefPackage selectRefPackage( String containerName, String refPackageName );

    /**
     * Save all pending modifications
     * 
     * @throws RepositoryException
     */
    public void save( ) throws RepositoryException;

    /**
     * Revert all pending modifications, and reloads from persistence
     * 
     * @throws RepositoryException
     */
    public void revert( ) throws RepositoryException;

    /**
     * Create an XMI representation of the provided RefObjects in a file. 
     * 
     * @param elements Collection of elements to be written
     * @param relativeFileName relative name of the resulting file
     * @throws java.io.IOException
     */
    public void writeToFile( Collection elements, String relativeFileName ) throws java.io.IOException;

    /**
     * Create an XMI representation of the collection of RefObjects in a Stream
     * 
     * @param elements Collection of elements to be written
     * @return OutputStream with the model
     */
    public OutputStream writeToStream( Collection elements ) throws IOException;

}