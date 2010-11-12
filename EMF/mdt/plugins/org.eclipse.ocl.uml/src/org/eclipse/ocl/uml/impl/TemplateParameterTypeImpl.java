/**
 * <copyright>
 *
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TemplateParameterTypeImpl.java,v 1.2 2010/04/08 06:23:31 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.uml.TemplateParameterType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.impl.ClassifierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter Type</b></em>'.
 * @since 3.0
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.TemplateParameterTypeImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.TemplateParameterTypeImpl#getFeatures <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.TemplateParameterTypeImpl#getOwnedOperations <em>Owned Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class TemplateParameterTypeImpl
		extends ClassifierImpl
		implements TemplateParameterType {

	/**
	 * The default value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected String specification = SPECIFICATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedOperations() <em>Owned Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> ownedOperations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateParameterTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLPackage.Literals.TEMPLATE_PARAMETER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(String newSpecification) {
		String oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION,
				oldSpecification, specification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Feature> getFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Feature> features = (EList<Feature>) cache.get(eResource,
				this,
				org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__FEATURE);
			if (features == null) {
				cache
					.put(
						eResource,
						this,
						org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__FEATURE,
						features = new DerivedUnionEObjectEList<Feature>(
							Feature.class, this,
							UMLPackage.TEMPLATE_PARAMETER_TYPE__FEATURE,
							FEATURE_ESUBSETS));
			}
			return features;
		}
		return new DerivedUnionEObjectEList<Feature>(Feature.class, this,
			UMLPackage.TEMPLATE_PARAMETER_TYPE__FEATURE, FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getFeatures() <em>Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] FEATURE_ESUBSETS = new int[]{
		UMLPackage.TEMPLATE_PARAMETER_TYPE__ATTRIBUTE,
		UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOwnedOperations() {
		if (ownedOperations == null) {
			ownedOperations = new EObjectContainmentEList<Operation>(
				Operation.class, this,
				UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION);
		}
		return ownedOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOwnedOperation(String name,
			EList<String> ownedParameterNames, EList<Type> ownedParameterTypes) {
		return getOwnedOperation(name, ownedParameterNames,
			ownedParameterTypes, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOwnedOperation(String name,
			EList<String> ownedParameterNames, EList<Type> ownedParameterTypes,
			boolean ignoreCase) {
		ownedOperationLoop : for (Operation ownedOperation : getOwnedOperations()) {
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(ownedOperation.getName())
				: name.equals(ownedOperation.getName())))
				continue ownedOperationLoop;
			EList<Parameter> ownedParameterList = ownedOperation
				.getOwnedParameters();
			int ownedParameterListSize = ownedParameterList.size();
			if (ownedParameterNames != null
				&& ownedParameterNames.size() != ownedParameterListSize
				|| (ownedParameterTypes != null && ownedParameterTypes.size() != ownedParameterListSize))
				continue ownedOperationLoop;
			for (int j = 0; j < ownedParameterListSize; j++) {
				Parameter ownedParameter = ownedParameterList.get(j);
				if (ownedParameterNames != null
					&& !(ignoreCase
						? (ownedParameterNames.get(j))
							.equalsIgnoreCase(ownedParameter.getName())
						: ownedParameterNames.get(j).equals(
							ownedParameter.getName())))
					continue ownedOperationLoop;
				if (ownedParameterTypes != null
					&& !ownedParameterTypes.get(j).equals(
						ownedParameter.getType()))
					continue ownedOperationLoop;
			}
			return ownedOperation;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION :
				return ((InternalEList<?>) getOwnedOperations()).basicRemove(
					otherEnd, msgs);
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
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION :
				return getSpecification();
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION :
				return getOwnedOperations();
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
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION :
				setSpecification((String) newValue);
				return;
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION :
				getOwnedOperations().clear();
				getOwnedOperations().addAll(
					(Collection<? extends Operation>) newValue);
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
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION :
				setSpecification(SPECIFICATION_EDEFAULT);
				return;
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION :
				getOwnedOperations().clear();
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
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION :
				return SPECIFICATION_EDEFAULT == null
					? specification != null
					: !SPECIFICATION_EDEFAULT.equals(specification);
			case UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION :
				return ownedOperations != null && !ownedOperations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.types.TemplateParameterType.class) {
			switch (derivedFeatureID) {
				case UMLPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION :
					return TypesPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION;
				default :
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.types.TemplateParameterType.class) {
			switch (baseFeatureID) {
				case TypesPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION :
					return UMLPackage.TEMPLATE_PARAMETER_TYPE__SPECIFICATION;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (specification: "); //$NON-NLS-1$
		result.append(specification);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFeatures() {
		return super.isSetFeatures()
			|| eIsSet(UMLPackage.TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION);
	}

} //TemplateParameterTypeImpl
