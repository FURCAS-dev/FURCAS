package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

/**
 * The JMX instrumentation of a MOIN instance.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MoinMBean {

    /**
     * Returns the elapsed time of the MOIN instance since startup.
     * 
     * @return a formatted String containing the elapsed time of the MOIN
     * instance since startup
     * @throws IOException in case of network communication issues
     */
    @Description( "The uptime of this MOIN instance." )
    public String getUptime( ) throws IOException;

    /**
     * Returns the date and time when the MOIN instance was started.
     * 
     * @return a formatted String containing the date and time when the MOIN
     * instance was started
     * @throws IOException in case of network communication issues
     */
    @Description( "When this MOIN instance was started." )
    public String getStartedAt( ) throws IOException;

    /**
     * Returns the version number of the MOIN instance.
     * 
     * @return the version number of the MOIN instance
     */
    @Description( "The version number of this MOIN instance." )
    public String getMoinVersionNumber( );

    /**
     * Returns the version date of the MOIN instance.
     * 
     * @return the version date of the MOIN instance
     */
    @Description( "The date of this version." )
    public String getMoinVersionDate( );

    /**
     * Returns the version comment of the MOIN instance.
     * 
     * @return the version comment of the MOIN instance
     */
    @Description( "Comments on this version." )
    public String getMoinVersionComment( );

    /**
     * Returns the major version number of the MOIN core.
     * 
     * @return the major version number of the MOIN core
     * @throws IOException in case of network communication issues
     */
    @Description( "The major version of the MOIN core runtime." )
    public String getMoinCoreRuntimeVersionMajor( ) throws IOException;

    /**
     * Returns the minor version number of the MOIN core.
     * 
     * @return the minor version number of the MOIN core
     * @throws IOException in case of network communication issues
     */
    @Description( "The minor version of the MOIN core runtime." )
    public String getMoinCoreRuntimeVersionMinor( ) throws IOException;

    /**
     * Performs a deep check of the MOIN Core data structures in order to reveal
     * illegal in-memory states.
     * <p>
     * ! FOR MOIN-INTERNAL USE ONLY !
     * 
     * @return a String containing a report of the discovered incidents
     */
    @Description( "Performs a deep check of the MOIN Core data structures in order to reveal illegal states." )
    public String checkConsistencyOfMoinCore( ) throws IOException;

    /**
     * Performs a deep check of the MOIN Core data structures in order to reveal
     * illegal in-memory states, without obtaining the MOIN Core locks in
     * advance.
     * <p>
     * ! FOR MOIN-INTERNAL USE ONLY !
     * 
     * @return a String containing a report of the discovered incidents
     */
    @Description( "Performs a deep check of the MOIN Core data structures in order to reveal illegal states, without obtaining the MOIN Core locks in advance." )
    public String checkConsistencyOfMoinCoreWithoutLocks( ) throws IOException;
}