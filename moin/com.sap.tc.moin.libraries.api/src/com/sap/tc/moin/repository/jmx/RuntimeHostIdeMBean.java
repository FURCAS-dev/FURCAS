package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import javax.management.openmbean.TabularData;

import com.sap.tc.moin.repository.admin.RuntimeHost;

/**
 * The JMX instrumentation of the {@link RuntimeHost} in the IDE scenario.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RuntimeHostIdeMBean {

    /**
     * Returns information about all metamodels available in the IDE, whether
     * deployed or not. The information includes:
     * <ul>
     * <li>Name</li> <li>Description</li> <li>Vendor</li> <li>Facility</li> <li>
     * Status</li> <li>Available Version</li> <li>Deployed Version</li>
     * </ul>
     * 
     * @return a {@link TabularData} instance containing information about all
     * available metamodels
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns information about all metamodels available in the IDE, whether deployed or not." )
    public TabularData showAllMetamodels( ) throws IOException;
}
