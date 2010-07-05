/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.impl;

import com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreach Predicate Property Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.ForeachPredicatePropertyInitImpl#getPredicateSemantic <em>Predicate Semantic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeachPredicatePropertyInitImpl extends PropertyInitImpl implements ForeachPredicatePropertyInit {
	/**
	 * The cached value of the '{@link #getPredicateSemantic() <em>Predicate Semantic</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicateSemantic()
	 * @generated
	 * @ordered
	 */
	protected EList<PredicateSemantic> predicateSemantic;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForeachPredicatePropertyInitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TCSPackage.Literals.FOREACH_PREDICATE_PROPERTY_INIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PredicateSemantic> getPredicateSemantic() {
		if (predicateSemantic == null) {
			predicateSemantic = new EObjectContainmentEList<PredicateSemantic>(PredicateSemantic.class, this, TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC);
		}
		return predicateSemantic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
				return ((InternalEList<?>)getPredicateSemantic()).basicRemove(otherEnd, msgs);
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
			case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
				return getPredicateSemantic();
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
			case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
				getPredicateSemantic().clear();
				getPredicateSemantic().addAll((Collection<? extends PredicateSemantic>)newValue);
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
			case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
				getPredicateSemantic().clear();
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
			case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
				return predicateSemantic != null && !predicateSemantic.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ForeachPredicatePropertyInitImpl
