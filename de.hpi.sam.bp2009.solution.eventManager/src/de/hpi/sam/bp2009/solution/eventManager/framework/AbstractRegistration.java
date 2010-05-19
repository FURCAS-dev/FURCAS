package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;

import org.eclipse.emf.common.notify.Adapter;

/**
 * The <code>AbstractRegistration</code> represents either a {@link com.sap.tc.moin.repository.events.framework.Registration}
 * object or a {@link com.sap.tc.moin.repository.events.framework.RegistrationSet} object. These objects are only used internally.
 * An instance of <code>AbstractRegistration</code> will be returned when clients register as listener. A client can
 * use this object in order to undo the registration call.
 * 
 * @author Daniel Vocke (D044825)
 */
abstract class AbstractRegistration implements RegistrationHandle {

    /**
     * The MoinEventFramework only stores <code>WeakReferences</code> to the registered listeners. Clients will have to
     * keep a reference to their listener in order ro prevent the garbage collector from cleaning up the instance.
     */
    private WeakReference<? extends Adapter> _listener = null;

    /**
     * defines the type of the registration. (whether it is a registration for PreChangeEvent, ChangeEvents,...)
     */
    private ListenerTypeEnum listenerType;

    /**
     * @param listener a <code>WeakReference</code> to the associated listener
     */
    protected AbstractRegistration(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType) {
        _listener = listener;
        this.listenerType = listenerType;
    }

    /**
     * Every Registration belongs exactly to one listener.
     * 
     * @return a <code>WeakReference</code> to the associated listener
     */
    WeakReference<? extends Adapter> getListener() {
        return _listener;
    }

    /**
     * The return value defines the type of the Listener
     * 
     * @see com.sap.tc.moin.repository.core.events.ListenerTypeEnum
     * @return 
     */
    public ListenerTypeEnum getListenerType() {
        return listenerType;
    }
}