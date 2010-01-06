/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.events.impl;

import de.hpi.sam.bp2009.solution.events.EventsPackage;
import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Change Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.events.impl.ModelChangeEventImpl#getSourceResourceSet <em>Source Resource Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelChangeEventImpl extends EObjectImpl implements ModelChangeEvent {
	/**
	 * The default value of the '{@link #getSourceResourceSet() <em>Source Resource Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceResourceSet()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceSet SOURCE_RESOURCE_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceResourceSet() <em>Source Resource Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceResourceSet()
	 * @generated
	 * @ordered
	 */
	protected ResourceSet sourceResourceSet = SOURCE_RESOURCE_SET_EDEFAULT;

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
		return EventsPackage.Literals.MODEL_CHANGE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSet getSourceResourceSet() {
		return sourceResourceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceResourceSet(ResourceSet newSourceResourceSet) {
		ResourceSet oldSourceResourceSet = sourceResourceSet;
		sourceResourceSet = newSourceResourceSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET, oldSourceResourceSet, sourceResourceSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET:
				return getSourceResourceSet();
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
			case EventsPackage.MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET:
				setSourceResourceSet((ResourceSet)newValue);
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
			case EventsPackage.MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET:
				setSourceResourceSet(SOURCE_RESOURCE_SET_EDEFAULT);
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
			case EventsPackage.MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET:
				return SOURCE_RESOURCE_SET_EDEFAULT == null ? sourceResourceSet != null : !SOURCE_RESOURCE_SET_EDEFAULT.equals(sourceResourceSet);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sourceResourceSet: ");
		result.append(sourceResourceSet);
		result.append(')');
		return result.toString();
	}

} //ModelChangeEventImpl
