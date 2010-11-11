/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AtomExp;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atom Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AtomExpImpl#getAndExp <em>And Exp</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AtomExpImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AtomExpImpl#getPropertyReference <em>Property Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AtomExpImpl extends LocatedElementImpl implements AtomExp {
        /**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
        protected static final String PROPERTY_NAME_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
        protected String propertyName = PROPERTY_NAME_EDEFAULT;

        /**
	 * The cached value of the '{@link #getPropertyReference() <em>Property Reference</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getPropertyReference()
	 * @generated
	 * @ordered
	 */
        protected PropertyReference propertyReference;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected AtomExpImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.ATOM_EXP;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public AndExp getAndExp() {
		if (eContainerFeatureID() != TCSPackage.ATOM_EXP__AND_EXP) return null;
		return (AndExp)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetAndExp(AndExp newAndExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAndExp, TCSPackage.ATOM_EXP__AND_EXP, msgs);
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setAndExp(AndExp newAndExp) {
		if (newAndExp != eInternalContainer() || (eContainerFeatureID() != TCSPackage.ATOM_EXP__AND_EXP && newAndExp != null)) {
			if (EcoreUtil.isAncestor(this, newAndExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAndExp != null)
				msgs = ((InternalEObject)newAndExp).eInverseAdd(this, TCSPackage.AND_EXP__EXPRESSIONS, AndExp.class, msgs);
			msgs = basicSetAndExp(newAndExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.ATOM_EXP__AND_EXP, newAndExp, newAndExp));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getPropertyName() {
		return propertyName;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.ATOM_EXP__PROPERTY_NAME, oldPropertyName, propertyName));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public PropertyReference getPropertyReference() {
		if (propertyReference != null && propertyReference.eIsProxy()) {
			InternalEObject oldPropertyReference = (InternalEObject)propertyReference;
			propertyReference = (PropertyReference)eResolveProxy(oldPropertyReference);
			if (propertyReference != oldPropertyReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.ATOM_EXP__PROPERTY_REFERENCE, oldPropertyReference, propertyReference));
			}
		}
		return propertyReference;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public PropertyReference basicGetPropertyReference() {
		return propertyReference;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setPropertyReference(PropertyReference newPropertyReference) {
		PropertyReference oldPropertyReference = propertyReference;
		propertyReference = newPropertyReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.ATOM_EXP__PROPERTY_REFERENCE, oldPropertyReference, propertyReference));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.ATOM_EXP__AND_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAndExp((AndExp)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.ATOM_EXP__AND_EXP:
				return basicSetAndExp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TCSPackage.ATOM_EXP__AND_EXP:
				return eInternalContainer().eInverseRemove(this, TCSPackage.AND_EXP__EXPRESSIONS, AndExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.ATOM_EXP__AND_EXP:
				return getAndExp();
			case TCSPackage.ATOM_EXP__PROPERTY_NAME:
				return getPropertyName();
			case TCSPackage.ATOM_EXP__PROPERTY_REFERENCE:
				if (resolve) return getPropertyReference();
				return basicGetPropertyReference();
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
			case TCSPackage.ATOM_EXP__AND_EXP:
				setAndExp((AndExp)newValue);
				return;
			case TCSPackage.ATOM_EXP__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case TCSPackage.ATOM_EXP__PROPERTY_REFERENCE:
				setPropertyReference((PropertyReference)newValue);
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
			case TCSPackage.ATOM_EXP__AND_EXP:
				setAndExp((AndExp)null);
				return;
			case TCSPackage.ATOM_EXP__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case TCSPackage.ATOM_EXP__PROPERTY_REFERENCE:
				setPropertyReference((PropertyReference)null);
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
			case TCSPackage.ATOM_EXP__AND_EXP:
				return getAndExp() != null;
			case TCSPackage.ATOM_EXP__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case TCSPackage.ATOM_EXP__PROPERTY_REFERENCE:
				return propertyReference != null;
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
		result.append(" (propertyName: ");
		result.append(propertyName);
		result.append(')');
		return result.toString();
	}

} //AtomExpImpl
