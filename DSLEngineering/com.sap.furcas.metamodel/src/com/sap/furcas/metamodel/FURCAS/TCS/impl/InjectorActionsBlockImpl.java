/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Injector Actions Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionsBlockImpl#getPropertyInits <em>Property Inits</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionsBlockImpl#getInjectorActions <em>Injector Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InjectorActionsBlockImpl extends SequenceElementImpl implements InjectorActionsBlock {
        /**
	 * The cached value of the '{@link #getPropertyInits() <em>Property Inits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getPropertyInits()
	 * @generated
	 * @ordered
	 */
        protected EList<InjectorAction> propertyInits;

        /**
	 * The cached value of the '{@link #getInjectorActions() <em>Injector Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getInjectorActions()
	 * @generated
	 * @ordered
	 */
        protected EList<InjectorAction> injectorActions;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected InjectorActionsBlockImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.INJECTOR_ACTIONS_BLOCK;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<InjectorAction> getPropertyInits() {
		if (propertyInits == null) {
			propertyInits = new EObjectContainmentEList<InjectorAction>(InjectorAction.class, this, TCSPackage.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS);
		}
		return propertyInits;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<InjectorAction> getInjectorActions() {
		if (injectorActions == null) {
			injectorActions = new EObjectContainmentWithInverseEList<InjectorAction>(InjectorAction.class, this, TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS, TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK);
		}
		return injectorActions;
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
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInjectorActions()).basicAdd(otherEnd, msgs);
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
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS:
				return ((InternalEList<?>)getPropertyInits()).basicRemove(otherEnd, msgs);
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS:
				return ((InternalEList<?>)getInjectorActions()).basicRemove(otherEnd, msgs);
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
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS:
				return getPropertyInits();
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS:
				return getInjectorActions();
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
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS:
				getPropertyInits().clear();
				getPropertyInits().addAll((Collection<? extends InjectorAction>)newValue);
				return;
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS:
				getInjectorActions().clear();
				getInjectorActions().addAll((Collection<? extends InjectorAction>)newValue);
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
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS:
				getPropertyInits().clear();
				return;
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS:
				getInjectorActions().clear();
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
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS:
				return propertyInits != null && !propertyInits.isEmpty();
			case TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS:
				return injectorActions != null && !injectorActions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InjectorActionsBlockImpl
