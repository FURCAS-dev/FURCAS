/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Multi Value Change Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeMultiValueChangeEventImpl#isAdd <em>Add</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeMultiValueChangeEventImpl extends AttributeValueChangeEventImpl implements AttributeMultiValueChangeEvent {
	/**
	 * The default value of the '{@link #isAdd() <em>Add</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdd()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADD_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAdd() <em>Add</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdd()
	 * @generated
	 * @ordered
	 */
	protected boolean add = ADD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMultiValueChangeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAdd() {
		return add;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdd(boolean newAdd) {
		boolean oldAdd = add;
		add = newAdd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__ADD, oldAdd, add));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__ADD:
				return isAdd();
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
			case EventManagerPackage.ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__ADD:
				setAdd((Boolean)newValue);
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
			case EventManagerPackage.ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__ADD:
				setAdd(ADD_EDEFAULT);
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
			case EventManagerPackage.ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__ADD:
				return add != ADD_EDEFAULT;
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
		result.append(" (add: ");
		result.append(add);
		result.append(')');
		return result.toString();
	}

} //AttributeMultiValueChangeEventImpl
