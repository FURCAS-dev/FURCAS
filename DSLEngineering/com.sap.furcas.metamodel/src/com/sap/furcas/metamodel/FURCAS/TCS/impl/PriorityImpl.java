/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl#getList <em>List</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl#getAssociativity <em>Associativity</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PriorityImpl extends LocatedElementImpl implements Priority {
        /**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
        protected static final int VALUE_EDEFAULT = 0;

        /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
        protected int value = VALUE_EDEFAULT;

        /**
	 * The default value of the '{@link #getAssociativity() <em>Associativity</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getAssociativity()
	 * @generated
	 * @ordered
	 */
        protected static final Associativity ASSOCIATIVITY_EDEFAULT = Associativity.LEFT;

        /**
	 * The cached value of the '{@link #getAssociativity() <em>Associativity</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getAssociativity()
	 * @generated
	 * @ordered
	 */
        protected Associativity associativity = ASSOCIATIVITY_EDEFAULT;

        /**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
        protected EList<Operator> operators;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected PriorityImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.PRIORITY;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public OperatorList getList() {
		if (eContainerFeatureID() != TCSPackage.PRIORITY__LIST) return null;
		return (OperatorList)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetList(OperatorList newList, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newList, TCSPackage.PRIORITY__LIST, msgs);
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setList(OperatorList newList) {
		if (newList != eInternalContainer() || (eContainerFeatureID() != TCSPackage.PRIORITY__LIST && newList != null)) {
			if (EcoreUtil.isAncestor(this, newList))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newList != null)
				msgs = ((InternalEObject)newList).eInverseAdd(this, TCSPackage.OPERATOR_LIST__PRIORITIES, OperatorList.class, msgs);
			msgs = basicSetList(newList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIORITY__LIST, newList, newList));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public int getValue() {
		return value;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIORITY__VALUE, oldValue, value));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Associativity getAssociativity() {
		return associativity;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setAssociativity(Associativity newAssociativity) {
		Associativity oldAssociativity = associativity;
		associativity = newAssociativity == null ? ASSOCIATIVITY_EDEFAULT : newAssociativity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIORITY__ASSOCIATIVITY, oldAssociativity, associativity));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectContainmentWithInverseEList<Operator>(Operator.class, this, TCSPackage.PRIORITY__OPERATORS, TCSPackage.OPERATOR__PRIORITY);
		}
		return operators;
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
			case TCSPackage.PRIORITY__LIST:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetList((OperatorList)otherEnd, msgs);
			case TCSPackage.PRIORITY__OPERATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperators()).basicAdd(otherEnd, msgs);
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
			case TCSPackage.PRIORITY__LIST:
				return basicSetList(null, msgs);
			case TCSPackage.PRIORITY__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
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
			case TCSPackage.PRIORITY__LIST:
				return eInternalContainer().eInverseRemove(this, TCSPackage.OPERATOR_LIST__PRIORITIES, OperatorList.class, msgs);
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
			case TCSPackage.PRIORITY__LIST:
				return getList();
			case TCSPackage.PRIORITY__VALUE:
				return getValue();
			case TCSPackage.PRIORITY__ASSOCIATIVITY:
				return getAssociativity();
			case TCSPackage.PRIORITY__OPERATORS:
				return getOperators();
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
			case TCSPackage.PRIORITY__LIST:
				setList((OperatorList)newValue);
				return;
			case TCSPackage.PRIORITY__VALUE:
				setValue((Integer)newValue);
				return;
			case TCSPackage.PRIORITY__ASSOCIATIVITY:
				setAssociativity((Associativity)newValue);
				return;
			case TCSPackage.PRIORITY__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
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
			case TCSPackage.PRIORITY__LIST:
				setList((OperatorList)null);
				return;
			case TCSPackage.PRIORITY__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case TCSPackage.PRIORITY__ASSOCIATIVITY:
				setAssociativity(ASSOCIATIVITY_EDEFAULT);
				return;
			case TCSPackage.PRIORITY__OPERATORS:
				getOperators().clear();
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
			case TCSPackage.PRIORITY__LIST:
				return getList() != null;
			case TCSPackage.PRIORITY__VALUE:
				return value != VALUE_EDEFAULT;
			case TCSPackage.PRIORITY__ASSOCIATIVITY:
				return associativity != ASSOCIATIVITY_EDEFAULT;
			case TCSPackage.PRIORITY__OPERATORS:
				return operators != null && !operators.isEmpty();
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
		result.append(", associativity: ");
		result.append(associativity);
		result.append(')');
		return result.toString();
	}

} //PriorityImpl
