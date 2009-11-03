package com.sap.tc.moin.repository.core.events.framework;

import javax.management.ObjectName;

import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.events.framework.simple.CoreEventRegistry;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;

/**
 * The SessionEventManager implements 2 roles: <br>
 * It acts as a <code>EventRegistry</code> to clients and as
 * <code>EventManager</code> to the repository core which will trigger the
 * events using the {@link com.sap.tc.moin.repository.spi.core.SpiEventManager}
 * interface. After the method was called, the SessionEventManager will ask its
 * RegistrationManager for all affected listeners and notify them using the
 * associated Notifier.
 * 
 * @author Daniel Vocke (D044825)
 */

public interface SessionEventManager extends CoreEventRegistry, SpiEventManager {

    public void registerMBean( CoreSession session );

    public void setFireEvents( boolean doFireEventsValue );

    public ObjectName getObjectName( );
}