/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventListener.EventListener;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */

public class EventManagerImpl extends EObjectImpl implements EventManager {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventManagerImpl() {
		super();
	}

	private static class EventAdapter extends EContentAdapter{
		EventListener caller;
		ModelChangeEvent event;
		
		public EventAdapter(EventListener listener, ModelChangeEvent event) {
			this.caller = listener;
			this.event = event;
		}
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			caller.callback(event);
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.EVENT_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * naively subscribe to the whole resource
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void subscribe(EventListener caller, ModelChangeEvent modelChangeEvent) {
		ResourceSet resource = modelChangeEvent.getSourceResourceSet();
		if (null == resource) throw new IllegalArgumentException("model change event has no resource");
		
		resource.eAdapters().add(new EventAdapter(caller, modelChangeEvent));
	}

} //EventManagerImpl
