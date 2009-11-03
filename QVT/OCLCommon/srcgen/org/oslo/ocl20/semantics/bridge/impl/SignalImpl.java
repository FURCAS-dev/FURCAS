/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Signal;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Signal</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.SignalImpl#getParameterNames <em>Parameter Names
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.SignalImpl#getParameterTypes <em>Parameter Types
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SignalImpl extends ModelElementImpl implements Signal {
	/**
	 * The cached value of the '{@link #getParameterNames() <em>Parameter Names</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParameterNames()
	 * @generated
	 * @ordered
	 */
	protected EList parameterNames;

	/**
	 * The cached value of the '{@link #getParameterTypes() <em>Parameter Types</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList parameterTypes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SignalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return BridgePackage.Literals.SIGNAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getParameterNames() {
		if (parameterNames == null) {
			parameterNames = new EDataTypeUniqueEList(String.class, this, BridgePackage.SIGNAL__PARAMETER_NAMES);
		}
		return parameterNames;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getParameterTypes() {
		if (parameterTypes == null) {
			parameterTypes = new EObjectResolvingEList(Classifier.class, this, BridgePackage.SIGNAL__PARAMETER_TYPES);
		}
		return parameterTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BridgePackage.SIGNAL__PARAMETER_NAMES:
				return getParameterNames();
			case BridgePackage.SIGNAL__PARAMETER_TYPES:
				return getParameterTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BridgePackage.SIGNAL__PARAMETER_NAMES:
				getParameterNames().clear();
				getParameterNames().addAll((Collection) newValue);
				return;
			case BridgePackage.SIGNAL__PARAMETER_TYPES:
				getParameterTypes().clear();
				getParameterTypes().addAll((Collection) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case BridgePackage.SIGNAL__PARAMETER_NAMES:
				getParameterNames().clear();
				return;
			case BridgePackage.SIGNAL__PARAMETER_TYPES:
				getParameterTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BridgePackage.SIGNAL__PARAMETER_NAMES:
				return parameterNames != null && !parameterNames.isEmpty();
			case BridgePackage.SIGNAL__PARAMETER_TYPES:
				return parameterTypes != null && !parameterTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (parameterNames: ");
		result.append(parameterNames);
		result.append(')');
		return result.toString();
	}

} // SignalImpl
