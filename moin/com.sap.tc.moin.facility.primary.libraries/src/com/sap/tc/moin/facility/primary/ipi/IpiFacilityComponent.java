package com.sap.tc.moin.facility.primary.ipi;

import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;

/**
 * Facility internal IPI interface which defines lifecycle operations for
 * primary facility components. The lifecycle of such a component corresponds
 * with the lifecycle of the facility itself (see {@link SpiFacilityLifecycle}
 * for details).
 * <p>
 * All facility components have to implement this interface!
 * 
 * @see SpiFacilityLifecycle
 */
public interface IpiFacilityComponent {

    /**
     * This happens immediately after all components have been bound in the
     * facility
     */
    void initialize( );

    /**
     * This happens only after the meta-models have been deployed
     */
    void finalizeStartup( );

    /**
     * This happens when the facility shuts itself down
     */
    void tearDown( );
}
