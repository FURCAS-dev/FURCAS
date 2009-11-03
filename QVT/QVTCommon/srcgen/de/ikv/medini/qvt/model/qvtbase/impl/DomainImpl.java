/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase.impl;

import de.ikv.medini.qvt.model.qvtbase.Domain;
import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.DomainImpl#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.DomainImpl#isIsEnforcable <em>Is Enforcable</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.DomainImpl#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainImpl extends NamedElementImpl implements Domain {
	/**
	 * The default value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECKABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheckable = IS_CHECKABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEnforcable() <em>Is Enforcable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforcable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforcable() <em>Is Enforcable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforcable()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforcable = IS_ENFORCABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypedModel() <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel typedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtBasePackage.Literals.DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCheckable() {
		return isCheckable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCheckable(boolean newIsCheckable) {
		boolean oldIsCheckable = isCheckable;
		isCheckable = newIsCheckable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.DOMAIN__IS_CHECKABLE, oldIsCheckable, isCheckable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsEnforcable() {
		return isEnforcable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEnforcable(boolean newIsEnforcable) {
		boolean oldIsEnforcable = isEnforcable;
		isEnforcable = newIsEnforcable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.DOMAIN__IS_ENFORCABLE, oldIsEnforcable, isEnforcable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel getTypedModel() {
		if (typedModel != null && typedModel.eIsProxy()) {
			InternalEObject oldTypedModel = (InternalEObject)typedModel;
			typedModel = (TypedModel)eResolveProxy(oldTypedModel);
			if (typedModel != oldTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtBasePackage.DOMAIN__TYPED_MODEL, oldTypedModel, typedModel));
			}
		}
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetTypedModel() {
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedModel(TypedModel newTypedModel) {
		TypedModel oldTypedModel = typedModel;
		typedModel = newTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.DOMAIN__TYPED_MODEL, oldTypedModel, typedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtBasePackage.DOMAIN__IS_CHECKABLE:
				return isIsCheckable() ? Boolean.TRUE : Boolean.FALSE;
			case QvtBasePackage.DOMAIN__IS_ENFORCABLE:
				return isIsEnforcable() ? Boolean.TRUE : Boolean.FALSE;
			case QvtBasePackage.DOMAIN__TYPED_MODEL:
				if (resolve) return getTypedModel();
				return basicGetTypedModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtBasePackage.DOMAIN__IS_CHECKABLE:
				setIsCheckable(((Boolean)newValue).booleanValue());
				return;
			case QvtBasePackage.DOMAIN__IS_ENFORCABLE:
				setIsEnforcable(((Boolean)newValue).booleanValue());
				return;
			case QvtBasePackage.DOMAIN__TYPED_MODEL:
				setTypedModel((TypedModel)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtBasePackage.DOMAIN__IS_CHECKABLE:
				setIsCheckable(IS_CHECKABLE_EDEFAULT);
				return;
			case QvtBasePackage.DOMAIN__IS_ENFORCABLE:
				setIsEnforcable(IS_ENFORCABLE_EDEFAULT);
				return;
			case QvtBasePackage.DOMAIN__TYPED_MODEL:
				setTypedModel((TypedModel)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtBasePackage.DOMAIN__IS_CHECKABLE:
				return isCheckable != IS_CHECKABLE_EDEFAULT;
			case QvtBasePackage.DOMAIN__IS_ENFORCABLE:
				return isEnforcable != IS_ENFORCABLE_EDEFAULT;
			case QvtBasePackage.DOMAIN__TYPED_MODEL:
				return typedModel != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCheckable: ");
		result.append(isCheckable);
		result.append(", isEnforcable: ");
		result.append(isEnforcable);
		result.append(')');
		return result.toString();
	}

} //DomainImpl
