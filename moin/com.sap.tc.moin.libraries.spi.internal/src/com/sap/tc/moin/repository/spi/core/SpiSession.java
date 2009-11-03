/*
 * Created on 30.06.2006
 */
package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.Session;

/**
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d044711
 */
public interface SpiSession extends Session {

    /**
     * @return Returns the client-specific workspace.
     */
    public SpiWorkspace getWorkspace( );

    /**
     * Returns the event factory
     */
    public SpiEventFactory getEventFactory( );

    /**
     * Returns the event manager
     */
    public SpiEventManager getEventManager( );
}
