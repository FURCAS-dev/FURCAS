/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disambiguate PArg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.DisambiguatePArgImpl#getDisambiguation <em>Disambiguation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DisambiguatePArgImpl extends PropertyArgImpl implements DisambiguatePArg {
        /**
	 * The default value of the '{@link #getDisambiguation() <em>Disambiguation</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getDisambiguation()
	 * @generated
	 * @ordered
	 */
        protected static final String DISAMBIGUATION_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getDisambiguation() <em>Disambiguation</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getDisambiguation()
	 * @generated
	 * @ordered
	 */
        protected String disambiguation = DISAMBIGUATION_EDEFAULT;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected DisambiguatePArgImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.DISAMBIGUATE_PARG;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getDisambiguation() {
		return disambiguation;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setDisambiguation(String newDisambiguation) {
		String oldDisambiguation = disambiguation;
		disambiguation = newDisambiguation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.DISAMBIGUATE_PARG__DISAMBIGUATION, oldDisambiguation, disambiguation));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.DISAMBIGUATE_PARG__DISAMBIGUATION:
				return getDisambiguation();
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
			case TCSPackage.DISAMBIGUATE_PARG__DISAMBIGUATION:
				setDisambiguation((String)newValue);
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
			case TCSPackage.DISAMBIGUATE_PARG__DISAMBIGUATION:
				setDisambiguation(DISAMBIGUATION_EDEFAULT);
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
			case TCSPackage.DISAMBIGUATE_PARG__DISAMBIGUATION:
				return DISAMBIGUATION_EDEFAULT == null ? disambiguation != null : !DISAMBIGUATION_EDEFAULT.equals(disambiguation);
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
		result.append(" (disambiguation: ");
		result.append(disambiguation);
		result.append(')');
		return result.toString();
	}

} //DisambiguatePArgImpl
