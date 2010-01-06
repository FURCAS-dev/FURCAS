/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impl;

import de.hpi.sam.bp2009.solution.Persistence;
import de.hpi.sam.bp2009.solution.SolutionPackage;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Persistence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.impl.PersistenceImpl#getEventManager <em>Event Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersistenceImpl extends EObjectImpl implements Persistence {
	/**
	 * The cached value of the '{@link #getEventManager() <em>Event Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventManager()
	 * @generated
	 * @ordered
	 */
	protected EventManager eventManager;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersistenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.PERSISTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManager getEventManager() {
		if (eventManager != null && eventManager.eIsProxy()) {
			InternalEObject oldEventManager = (InternalEObject)eventManager;
			eventManager = (EventManager)eResolveProxy(oldEventManager);
			if (eventManager != oldEventManager) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionPackage.PERSISTENCE__EVENT_MANAGER, oldEventManager, eventManager));
			}
		}
		return eventManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManager basicGetEventManager() {
		return eventManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventManager(EventManager newEventManager) {
		EventManager oldEventManager = eventManager;
		eventManager = newEventManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.PERSISTENCE__EVENT_MANAGER, oldEventManager, eventManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SolutionPackage.PERSISTENCE__EVENT_MANAGER:
				if (resolve) return getEventManager();
				return basicGetEventManager();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SolutionPackage.PERSISTENCE__EVENT_MANAGER:
				setEventManager((EventManager)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SolutionPackage.PERSISTENCE__EVENT_MANAGER:
				setEventManager((EventManager)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SolutionPackage.PERSISTENCE__EVENT_MANAGER:
				return eventManager != null;
		}
		return super.eIsSet(featureID);
	}

} //PersistenceImpl
