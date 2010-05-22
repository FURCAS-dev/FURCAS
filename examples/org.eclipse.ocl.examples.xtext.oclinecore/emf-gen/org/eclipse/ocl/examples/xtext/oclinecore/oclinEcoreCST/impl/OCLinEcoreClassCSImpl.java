/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLinEcoreClassCSImpl.java,v 1.3 2010/05/22 18:51:40 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OC Lin Ecore Class CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl#getStructuralFeatures <em>Structural Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OCLinEcoreClassCSImpl extends ClassifierCSImpl implements OCLinEcoreClassCS {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> constraints;

	/**
	 * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;

	/**
	 * This is true if the Instance Class Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean instanceClassNameESet;

	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> qualifiers;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> superTypes;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationCS> operations;

	/**
	 * The cached value of the '{@link #getStructuralFeatures() <em>Structural Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuralFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeatureCS> structuralFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLinEcoreClassCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_CLASS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceClassName() {
		return instanceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceClassName(String newInstanceClassName) {
		String oldInstanceClassName = instanceClassName;
		instanceClassName = newInstanceClassName;
		boolean oldInstanceClassNameESet = instanceClassNameESet;
		instanceClassNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__INSTANCE_CLASS_NAME, oldInstanceClassName, instanceClassName, !oldInstanceClassNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInstanceClassName() {
		String oldInstanceClassName = instanceClassName;
		boolean oldInstanceClassNameESet = instanceClassNameESet;
		instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;
		instanceClassNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__INSTANCE_CLASS_NAME, oldInstanceClassName, INSTANCE_CLASS_NAME_EDEFAULT, oldInstanceClassNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInstanceClassName() {
		return instanceClassNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getQualifiers() {
		if (qualifiers == null) {
			qualifiers = new EDataTypeUniqueEList<String>(String.class, this, OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__QUALIFIERS);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList.Unsettable<TypedRefCS>(TypedRefCS.class, this, OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuperTypes() {
		if (superTypes != null) ((InternalEList.Unsettable<?>)superTypes).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuperTypes() {
		return superTypes != null && ((InternalEList.Unsettable<?>)superTypes).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationCS> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentWithInverseEList<OperationCS>(OperationCS.class, this, OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS, BaseCSTPackage.OPERATION_CS__OWNER);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuralFeatureCS> getStructuralFeatures() {
		if (structuralFeatures == null) {
			structuralFeatures = new EObjectContainmentWithInverseEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES, BaseCSTPackage.STRUCTURAL_FEATURE_CS__OWNER);
		}
		return structuralFeatures;
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
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStructuralFeatures()).basicAdd(otherEnd, msgs);
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
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES:
				return ((InternalEList<?>)getStructuralFeatures()).basicRemove(otherEnd, msgs);
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
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__CONSTRAINTS:
				return getConstraints();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__QUALIFIERS:
				return getQualifiers();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES:
				return getSuperTypes();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS:
				return getOperations();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES:
				return getStructuralFeatures();
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
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends String>)newValue);
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				getStructuralFeatures().addAll((Collection<? extends StructuralFeatureCS>)newValue);
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
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__CONSTRAINTS:
				getConstraints().clear();
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__INSTANCE_CLASS_NAME:
				unsetInstanceClassName();
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__QUALIFIERS:
				getQualifiers().clear();
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES:
				unsetSuperTypes();
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS:
				getOperations().clear();
				return;
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
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
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES:
				return isSetSuperTypes();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES:
				return structuralFeatures != null && !structuralFeatures.isEmpty();
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
		if (baseClass == NamespaceCS.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ClassCS.class) {
			switch (derivedFeatureID) {
				case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES: return BaseCSTPackage.CLASS_CS__SUPER_TYPES;
				case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS: return BaseCSTPackage.CLASS_CS__OPERATIONS;
				case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES: return BaseCSTPackage.CLASS_CS__STRUCTURAL_FEATURES;
				default: return -1;
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
		if (baseClass == NamespaceCS.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ClassCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.CLASS_CS__SUPER_TYPES: return OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__SUPER_TYPES;
				case BaseCSTPackage.CLASS_CS__OPERATIONS: return OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__OPERATIONS;
				case BaseCSTPackage.CLASS_CS__STRUCTURAL_FEATURES: return OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
} //OCLinEcoreClassCSImpl
