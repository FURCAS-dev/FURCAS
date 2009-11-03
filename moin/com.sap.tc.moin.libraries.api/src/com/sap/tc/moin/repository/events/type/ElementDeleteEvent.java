package com.sap.tc.moin.repository.events.type;


/**
 * An <code>ElementDeleteEvent</code> will be fired every time a MOF element is
 * being removed using the {@link com.sap.tc.moin.repository.mmi.reflect.RefObject#refDelete()}
 * operation on the model element itself or on an composite parent. <br>
 * Note, that the MRI that can be obtained by calling
 * {@link com.sap.tc.moin.repository.events.type.ElementChangeEvent#getAffectedElementMri()}
 * method cannot be resolved after the element has been removed. (during the
 * invocation of the <code>PreChangeListener</code>'s method the element still
 * exists, but during the invocation of the <code>ChangeListener</code> 's
 * {@link com.sap.tc.moin.repository.events.ChangeListener#notify(ChangeEvent)
 * notify()} method the element has been removed yet.) <br>
 * This is why this event type offers additional information about the deleted
 * element. (e.g. its type)
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Martin Kolb
 */

public interface ElementDeleteEvent extends ElementLifeCycleEvent {

}