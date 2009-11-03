package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

/**
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ConfigurationMBean {

    /**
     * Returns the contents of the configuration XML used for initializing MOIN.
     * 
     * @deprecated there is no implementation class any more, since the
     * initialization process changed completely
     * @return the contents of the configuration XML used for initializing MOIN
     * @throws IOException in case of network communication issues
     */
    @Deprecated
    @Description( "Shows the complete content of the configuration file that is used for instantiating Moin instances." )
    public String showConfiguration( ) throws IOException;
}
