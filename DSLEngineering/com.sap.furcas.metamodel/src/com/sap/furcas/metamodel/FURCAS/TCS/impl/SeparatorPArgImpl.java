/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Separator PArg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SeparatorPArgImpl#getSeparatorSequence <em>Separator Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeparatorPArgImpl extends PropertyArgImpl implements SeparatorPArg {
        /**
	 * The cached value of the '{@link #getSeparatorSequence() <em>Separator Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getSeparatorSequence()
	 * @generated
	 * @ordered
	 */
        protected Sequence separatorSequence;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected SeparatorPArgImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.SEPARATOR_PARG;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Sequence getSeparatorSequence() {
		return separatorSequence;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetSeparatorSequence(Sequence newSeparatorSequence, NotificationChain msgs) {
		Sequence oldSeparatorSequence = separatorSequence;
		separatorSequence = newSeparatorSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE, oldSeparatorSequence, newSeparatorSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setSeparatorSequence(Sequence newSeparatorSequence) {
		if (newSeparatorSequence != separatorSequence) {
			NotificationChain msgs = null;
			if (separatorSequence != null)
				msgs = ((InternalEObject)separatorSequence).eInverseRemove(this, TCSPackage.SEQUENCE__SEPARATOR_CONTAINER, Sequence.class, msgs);
			if (newSeparatorSequence != null)
				msgs = ((InternalEObject)newSeparatorSequence).eInverseAdd(this, TCSPackage.SEQUENCE__SEPARATOR_CONTAINER, Sequence.class, msgs);
			msgs = basicSetSeparatorSequence(newSeparatorSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE, newSeparatorSequence, newSeparatorSequence));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE:
				if (separatorSequence != null)
					msgs = ((InternalEObject)separatorSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE, null, msgs);
				return basicSetSeparatorSequence((Sequence)otherEnd, msgs);
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
			case TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE:
				return basicSetSeparatorSequence(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE:
				return getSeparatorSequence();
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
			case TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE:
				setSeparatorSequence((Sequence)newValue);
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
			case TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE:
				setSeparatorSequence((Sequence)null);
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
			case TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE:
				return separatorSequence != null;
		}
		return super.eIsSet(featureID);
	}

} //SeparatorPArgImpl
