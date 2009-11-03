package com.sap.tc.moin.repository.spi.facility;

/**
 * Controls the lifecycle of the facility.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 */
public interface SpiFacilityLifecycle {

    /**
     * Invoked immediately after construction of facility
     */
    public void initialize( );

    /**
     * Invoked after the deployment of the available metamodels and injection of
     * the MofRom into the facility.
     */
    public void finalizeStartup( );

    /**
     * Free all resources for a clean shutdown.
     */
    public void tearDown( );

}