package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;

/**
 * Base interface for events that deal with the element's life-cycle (create,
 * delete).
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Martin Kolb
 */
public interface ElementLifeCycleEvent extends ElementChangeEvent {

    /**
     * @return the <code>MRI</code> of the type (MetaObject) of the affected
     * element.
     */
    public MRI getMetaObjectMri( );

    /**
     * resolves the MRI which can be retrieved using the
     * {@link #getMetaObjectMri()}method.
     * 
     * @param resolvingConnection the connection used to resolve
     * @return the meta object of the deleted element
     */
    public RefObject getMetaObject( Connection resolvingConnection );

}
