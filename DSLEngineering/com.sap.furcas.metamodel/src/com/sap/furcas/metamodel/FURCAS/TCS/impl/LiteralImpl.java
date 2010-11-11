/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralImpl#getLiteralRefs <em>Literal Refs</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LiteralImpl extends NamedElementImpl implements Literal {
        /**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
        protected EList<Operator> operators;

        /**
	 * The cached value of the '{@link #getLiteralRefs() <em>Literal Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getLiteralRefs()
	 * @generated
	 * @ordered
	 */
        protected EList<LiteralRef> literalRefs;

        /**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
        protected static final String VALUE_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
        protected String value = VALUE_EDEFAULT;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected LiteralImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.LITERAL;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectWithInverseResolvingEList<Operator>(Operator.class, this, TCSPackage.LITERAL__OPERATORS, TCSPackage.OPERATOR__LITERAL);
		}
		return operators;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<LiteralRef> getLiteralRefs() {
		if (literalRefs == null) {
			literalRefs = new EObjectWithInverseResolvingEList<LiteralRef>(LiteralRef.class, this, TCSPackage.LITERAL__LITERAL_REFS, TCSPackage.LITERAL_REF__REFERRED_LITERAL);
		}
		return literalRefs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getValue() {
		return value;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.LITERAL__VALUE, oldValue, value));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @SuppressWarnings("unchecked")
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.LITERAL__OPERATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperators()).basicAdd(otherEnd, msgs);
			case TCSPackage.LITERAL__LITERAL_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLiteralRefs()).basicAdd(otherEnd, msgs);
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
			case TCSPackage.LITERAL__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
			case TCSPackage.LITERAL__LITERAL_REFS:
				return ((InternalEList<?>)getLiteralRefs()).basicRemove(otherEnd, msgs);
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
			case TCSPackage.LITERAL__OPERATORS:
				return getOperators();
			case TCSPackage.LITERAL__LITERAL_REFS:
				return getLiteralRefs();
			case TCSPackage.LITERAL__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @SuppressWarnings("unchecked")
        @Override
        public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TCSPackage.LITERAL__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
				return;
			case TCSPackage.LITERAL__LITERAL_REFS:
				getLiteralRefs().clear();
				getLiteralRefs().addAll((Collection<? extends LiteralRef>)newValue);
				return;
			case TCSPackage.LITERAL__VALUE:
				setValue((String)newValue);
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
			case TCSPackage.LITERAL__OPERATORS:
				getOperators().clear();
				return;
			case TCSPackage.LITERAL__LITERAL_REFS:
				getLiteralRefs().clear();
				return;
			case TCSPackage.LITERAL__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case TCSPackage.LITERAL__OPERATORS:
				return operators != null && !operators.isEmpty();
			case TCSPackage.LITERAL__LITERAL_REFS:
				return literalRefs != null && !literalRefs.isEmpty();
			case TCSPackage.LITERAL__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //LiteralImpl
