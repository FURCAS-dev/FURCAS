/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Change Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementChangeEventImpl#getChangedClass <em>Changed Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementChangeEventImpl extends ModelChangeEventImpl implements ElementChangeEvent {
	/**
	 * The cached value of the '{@link #getChangedClass() <em>Changed Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangedClass()
	 * @generated
	 * @ordered
	 */
	protected EClass changedClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementChangeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.ELEMENT_CHANGE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass getChangedClass() {
		if (changedClass != null && changedClass.eIsProxy()) {
			InternalEObject oldChangedClass = (InternalEObject)changedClass;
			changedClass = (EClass)eResolveProxy(oldChangedClass);
			if (changedClass != oldChangedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.ELEMENT_CHANGE_EVENT__CHANGED_CLASS, oldChangedClass, changedClass));
			}
		}
		if(getSourceObject()!=null)
			return getSourceObject().eClass();
		return changedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetChangedClass() {
		return changedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangedClass(EClass newChangedClass) {
		EClass oldChangedClass = changedClass;
		changedClass = newChangedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.ELEMENT_CHANGE_EVENT__CHANGED_CLASS, oldChangedClass, changedClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.ELEMENT_CHANGE_EVENT__CHANGED_CLASS:
				if (resolve) return getChangedClass();
				return basicGetChangedClass();
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
			case EventManagerPackage.ELEMENT_CHANGE_EVENT__CHANGED_CLASS:
				setChangedClass((EClass)newValue);
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
			case EventManagerPackage.ELEMENT_CHANGE_EVENT__CHANGED_CLASS:
				setChangedClass((EClass)null);
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
			case EventManagerPackage.ELEMENT_CHANGE_EVENT__CHANGED_CLASS:
				return changedClass != null;
		}
		return super.eIsSet(featureID);
	}


} //ElementChangeEventImpl
