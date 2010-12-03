/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate Semantic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PredicateSemanticImpl#getAs <em>As</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PredicateSemanticImpl#getWhen <em>When</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PredicateSemanticImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateSemanticImpl extends EObjectImpl implements PredicateSemantic {
        /**
	 * The cached value of the '{@link #getAs() <em>As</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getAs()
	 * @generated
	 * @ordered
	 */
        protected Template as;

        /**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
        protected OCLExpression when;

        /**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
        protected static final String MODE_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
        protected String mode = MODE_EDEFAULT;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected PredicateSemanticImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.PREDICATE_SEMANTIC;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Template getAs() {
		if (as != null && as.eIsProxy()) {
			InternalEObject oldAs = (InternalEObject)as;
			as = (Template)eResolveProxy(oldAs);
			if (as != oldAs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.PREDICATE_SEMANTIC__AS, oldAs, as));
			}
		}
		return as;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Template basicGetAs() {
		return as;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setAs(Template newAs) {
		Template oldAs = as;
		as = newAs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PREDICATE_SEMANTIC__AS, oldAs, as));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public OCLExpression getWhen() {
		if (when != null && when.eIsProxy()) {
			InternalEObject oldWhen = (InternalEObject)when;
			when = (OCLExpression)eResolveProxy(oldWhen);
			if (when != oldWhen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.PREDICATE_SEMANTIC__WHEN, oldWhen, when));
			}
		}
		return when;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public OCLExpression basicGetWhen() {
		return when;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setWhen(OCLExpression newWhen) {
		OCLExpression oldWhen = when;
		when = newWhen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PREDICATE_SEMANTIC__WHEN, oldWhen, when));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getMode() {
		return mode;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PREDICATE_SEMANTIC__MODE, oldMode, mode));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.PREDICATE_SEMANTIC__AS:
				if (resolve) return getAs();
				return basicGetAs();
			case TCSPackage.PREDICATE_SEMANTIC__WHEN:
				if (resolve) return getWhen();
				return basicGetWhen();
			case TCSPackage.PREDICATE_SEMANTIC__MODE:
				return getMode();
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
			case TCSPackage.PREDICATE_SEMANTIC__AS:
				setAs((Template)newValue);
				return;
			case TCSPackage.PREDICATE_SEMANTIC__WHEN:
				setWhen((OCLExpression)newValue);
				return;
			case TCSPackage.PREDICATE_SEMANTIC__MODE:
				setMode((String)newValue);
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
			case TCSPackage.PREDICATE_SEMANTIC__AS:
				setAs((Template)null);
				return;
			case TCSPackage.PREDICATE_SEMANTIC__WHEN:
				setWhen((OCLExpression)null);
				return;
			case TCSPackage.PREDICATE_SEMANTIC__MODE:
				setMode(MODE_EDEFAULT);
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
			case TCSPackage.PREDICATE_SEMANTIC__AS:
				return as != null;
			case TCSPackage.PREDICATE_SEMANTIC__WHEN:
				return when != null;
			case TCSPackage.PREDICATE_SEMANTIC__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
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
		result.append(" (mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //PredicateSemanticImpl
