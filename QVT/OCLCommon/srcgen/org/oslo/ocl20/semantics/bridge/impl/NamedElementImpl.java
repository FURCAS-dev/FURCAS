/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.NamedElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl#getMayBeImplicit <em>May Be
 * Implicit</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl#getName <em>Name</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl#getReferredElement <em>Referred
 * Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NamedElementImpl extends ElementImpl implements NamedElement {
	/**
	 * The default value of the '{@link #getMayBeImplicit() <em>May Be Implicit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMayBeImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean MAY_BE_IMPLICIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMayBeImplicit() <em>May Be Implicit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMayBeImplicit()
	 * @generated
	 * @ordered
	 */
	protected Boolean mayBeImplicit = MAY_BE_IMPLICIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredElement() <em>Referred Element</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferredElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElement referredElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return BridgePackage.Literals.NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Boolean getMayBeImplicit() {
		return mayBeImplicit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMayBeImplicit(Boolean newMayBeImplicit) {
		Boolean oldMayBeImplicit = mayBeImplicit;
		mayBeImplicit = newMayBeImplicit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT,
			    oldMayBeImplicit, mayBeImplicit));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement getReferredElement() {
		if (referredElement != null && referredElement.eIsProxy()) {
			InternalEObject oldReferredElement = (InternalEObject) referredElement;
			referredElement = (ModelElement) eResolveProxy(oldReferredElement);
			if (referredElement != oldReferredElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT, oldReferredElement, referredElement));
			}
		}
		return referredElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement basicGetReferredElement() {
		return referredElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferredElement(ModelElement newReferredElement) {
		ModelElement oldReferredElement = referredElement;
		referredElement = newReferredElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT,
			    oldReferredElement, referredElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier getType() {
		if (referredElement instanceof org.oslo.ocl20.semantics.model.expressions.VariableDeclaration)
			return ((org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) referredElement).getType();
		if (referredElement instanceof Classifier)
			return (Classifier) referredElement;
		// if (referredElement instanceof IState)
		// return ???
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT:
				return getMayBeImplicit();
			case BridgePackage.NAMED_ELEMENT__NAME:
				return getName();
			case BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT:
				if (resolve)
					return getReferredElement();
				return basicGetReferredElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT:
				setMayBeImplicit((Boolean) newValue);
				return;
			case BridgePackage.NAMED_ELEMENT__NAME:
				setName((String) newValue);
				return;
			case BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT:
				setReferredElement((ModelElement) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT:
				setMayBeImplicit(MAY_BE_IMPLICIT_EDEFAULT);
				return;
			case BridgePackage.NAMED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT:
				setReferredElement((ModelElement) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT:
				return MAY_BE_IMPLICIT_EDEFAULT == null ? mayBeImplicit != null : !MAY_BE_IMPLICIT_EDEFAULT
				        .equals(mayBeImplicit);
			case BridgePackage.NAMED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT:
				return referredElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mayBeImplicit: ");
		result.append(mayBeImplicit);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // NamedElementImpl
