package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

/**
 * The JMX instrumentation of the coding that deals with dumping the index to
 * the filesystem.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IndexDumpedMBean extends IndexMBean {

    /**
     * Saves the index state in the dump file. Returns true on success and false
     * otherwise.
     * 
     * @return whether the index dump was successful or not
     * @throws IOException in case of network communication issues
     */
    @Description( "Saves the index state in the dump. Returns true on success and false otherwise." )
    public boolean forceDump( ) throws IOException;

    /**
     * Rebuilds the index from the persisted dump.
     * 
     * @return whether the index dump was successfully loaded
     * @throws IOException
     */
    public boolean forceLoad( ) throws IOException;

    /**
     * Indicates if the last dump attempt was successful or not
     * 
     * @return <code>true</code> if the last dump attempt was successful,
     * <code>false</code> otherwise
     */
    public boolean isDumpFailed( );
}
