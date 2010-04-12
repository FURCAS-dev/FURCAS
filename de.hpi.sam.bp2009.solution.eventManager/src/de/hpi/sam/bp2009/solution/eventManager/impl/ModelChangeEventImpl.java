/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Change Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.ModelChangeEventImpl#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModelChangeEventImpl extends EObjectImpl implements ModelChangeEvent {
	/**
	 * The cached value of the '{@link #getSourceObject() <em>Source Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceObject()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelChangeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.MODEL_CHANGE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceObject() {
		if (sourceObject != null && sourceObject.eIsProxy()) {
			InternalEObject oldSourceObject = (InternalEObject)sourceObject;
			sourceObject = eResolveProxy(oldSourceObject);
			if (sourceObject != oldSourceObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.MODEL_CHANGE_EVENT__SOURCE_OBJECT, oldSourceObject, sourceObject));
			}
		}
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceObject() {
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceObject(EObject newSourceObject) {
		EObject oldSourceObject = sourceObject;
		sourceObject = newSourceObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.MODEL_CHANGE_EVENT__SOURCE_OBJECT, oldSourceObject, sourceObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public EventFilter getFilter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.MODEL_CHANGE_EVENT__SOURCE_OBJECT:
				if (resolve) return getSourceObject();
				return basicGetSourceObject();
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
			case EventManagerPackage.MODEL_CHANGE_EVENT__SOURCE_OBJECT:
				setSourceObject((EObject)newValue);
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
			case EventManagerPackage.MODEL_CHANGE_EVENT__SOURCE_OBJECT:
				setSourceObject((EObject)null);
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
			case EventManagerPackage.MODEL_CHANGE_EVENT__SOURCE_OBJECT:
				return sourceObject != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelChangeEventImpl
