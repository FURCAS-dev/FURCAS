/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyReferenceImpl#getStrucfeature <em>Strucfeature</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyReferenceImpl#isIsOppositeEnd <em>Is Opposite End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyReferenceImpl extends EObjectImpl implements PropertyReference {
        /**
	 * The cached value of the '{@link #getStrucfeature() <em>Strucfeature</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getStrucfeature()
	 * @generated
	 * @ordered
	 */
        protected EStructuralFeature strucfeature;

        /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
        protected static final String NAME_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
        protected String name = NAME_EDEFAULT;

        /**
	 * The default value of the '{@link #isIsOppositeEnd() <em>Is Opposite End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOppositeEnd()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OPPOSITE_END_EDEFAULT = false;

								/**
	 * The cached value of the '{@link #isIsOppositeEnd() <em>Is Opposite End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOppositeEnd()
	 * @generated
	 * @ordered
	 */
	protected boolean isOppositeEnd = IS_OPPOSITE_END_EDEFAULT;

								/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected PropertyReferenceImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.PROPERTY_REFERENCE;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EStructuralFeature getStrucfeature() {
		if (strucfeature != null && strucfeature.eIsProxy()) {
			InternalEObject oldStrucfeature = (InternalEObject)strucfeature;
			strucfeature = (EStructuralFeature)eResolveProxy(oldStrucfeature);
			if (strucfeature != oldStrucfeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.PROPERTY_REFERENCE__STRUCFEATURE, oldStrucfeature, strucfeature));
			}
		}
		return strucfeature;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EStructuralFeature basicGetStrucfeature() {
		return strucfeature;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setStrucfeature(EStructuralFeature newStrucfeature) {
		EStructuralFeature oldStrucfeature = strucfeature;
		strucfeature = newStrucfeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PROPERTY_REFERENCE__STRUCFEATURE, oldStrucfeature, strucfeature));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getName() {
		return name;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PROPERTY_REFERENCE__NAME, oldName, name));
	}

        /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOppositeEnd() {
		return isOppositeEnd;
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOppositeEnd(boolean newIsOppositeEnd) {
		boolean oldIsOppositeEnd = isOppositeEnd;
		isOppositeEnd = newIsOppositeEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PROPERTY_REFERENCE__IS_OPPOSITE_END, oldIsOppositeEnd, isOppositeEnd));
	}

								/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.PROPERTY_REFERENCE__STRUCFEATURE:
				if (resolve) return getStrucfeature();
				return basicGetStrucfeature();
			case TCSPackage.PROPERTY_REFERENCE__NAME:
				return getName();
			case TCSPackage.PROPERTY_REFERENCE__IS_OPPOSITE_END:
				return isIsOppositeEnd();
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
			case TCSPackage.PROPERTY_REFERENCE__STRUCFEATURE:
				setStrucfeature((EStructuralFeature)newValue);
				return;
			case TCSPackage.PROPERTY_REFERENCE__NAME:
				setName((String)newValue);
				return;
			case TCSPackage.PROPERTY_REFERENCE__IS_OPPOSITE_END:
				setIsOppositeEnd((Boolean)newValue);
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
			case TCSPackage.PROPERTY_REFERENCE__STRUCFEATURE:
				setStrucfeature((EStructuralFeature)null);
				return;
			case TCSPackage.PROPERTY_REFERENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TCSPackage.PROPERTY_REFERENCE__IS_OPPOSITE_END:
				setIsOppositeEnd(IS_OPPOSITE_END_EDEFAULT);
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
			case TCSPackage.PROPERTY_REFERENCE__STRUCFEATURE:
				return strucfeature != null;
			case TCSPackage.PROPERTY_REFERENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TCSPackage.PROPERTY_REFERENCE__IS_OPPOSITE_END:
				return isOppositeEnd != IS_OPPOSITE_END_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", isOppositeEnd: ");
		result.append(isOppositeEnd);
		result.append(')');
		return result.toString();
	}

} //PropertyReferenceImpl
