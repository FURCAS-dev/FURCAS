/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;


import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;



import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
	 */
	protected EventManagerImpl() {
		super();
	}
	
	private static class EventAdapter extends EContentAdapter{
		Adapter caller;
		ModelChangeEvent event;

		public EventAdapter(Adapter listener, ModelChangeEvent event) {
			this.caller = listener;
			this.event = event;
		}
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			caller.notifyChanged(notification);
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void subscribe(EObject root, EventFilter filter, Adapter caller) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void subscribe(Resource root, EventFilter filter, Adapter caller) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void subscribe(ResourceSet root, EventFilter filter, Adapter caller) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * naively subscribe to the whole resource
	 * <!-- end-user-doc -->
	 */
	public void subscribe(Adapter caller, EventFilter filter) {
		//TODO implement me
		ResourceSet resource = modelChangeEvent.getSourceResourceSet();
		if (null == resource) throw new IllegalArgumentException("model change event has no resource");

		resource.eAdapters().add(new EventAdapter(caller, modelChangeEvent));
	}



} //EventManagerImpl
