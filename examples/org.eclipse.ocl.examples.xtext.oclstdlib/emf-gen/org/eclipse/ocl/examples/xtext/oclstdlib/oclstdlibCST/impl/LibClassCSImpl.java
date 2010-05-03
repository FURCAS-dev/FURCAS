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
 * $Id: LibClassCSImpl.java,v 1.1 2010/05/03 05:30:20 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Class CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl#getStructuralFeatures <em>Structural Features</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl#getConformsTo <em>Conforms To</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl#getIterations <em>Iterations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibClassCSImpl extends NamedElementCSImpl implements LibClassCS {
	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeParameterCS> typeParameters;

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
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected Class<?> class_;

	/**
	 * The cached value of the '{@link #getConformsTo() <em>Conforms To</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> conformsTo;

	/**
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected EList<LibIterationCS> iterations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibClassCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSTPackage.Literals.LIB_CLASS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeParameterCS> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentEList<TypeParameterCS>(TypeParameterCS.class, this, OCLstdlibCSTPackage.LIB_CLASS_CS__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList.Unsettable<TypedRefCS>(TypedRefCS.class, this, OCLstdlibCSTPackage.LIB_CLASS_CS__SUPER_TYPES);
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
			operations = new EObjectContainmentEList<OperationCS>(OperationCS.class, this, OCLstdlibCSTPackage.LIB_CLASS_CS__OPERATIONS);
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
			structuralFeatures = new EObjectContainmentEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, OCLstdlibCSTPackage.LIB_CLASS_CS__STRUCTURAL_FEATURES);
		}
		return structuralFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<?> getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(Class<?> newClass) {
		Class<?> oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_CLASS_CS__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getConformsTo() {
		if (conformsTo == null) {
			conformsTo = new EObjectContainmentEList<TypedRefCS>(TypedRefCS.class, this, OCLstdlibCSTPackage.LIB_CLASS_CS__CONFORMS_TO);
		}
		return conformsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibIterationCS> getIterations() {
		if (iterations == null) {
			iterations = new EObjectContainmentEList<LibIterationCS>(LibIterationCS.class, this, OCLstdlibCSTPackage.LIB_CLASS_CS__ITERATIONS);
		}
		return iterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLstdlibCSTPackage.LIB_CLASS_CS__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASS_CS__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASS_CS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASS_CS__STRUCTURAL_FEATURES:
				return ((InternalEList<?>)getStructuralFeatures()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CONFORMS_TO:
				return ((InternalEList<?>)getConformsTo()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASS_CS__ITERATIONS:
				return ((InternalEList<?>)getIterations()).basicRemove(otherEnd, msgs);
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
			case OCLstdlibCSTPackage.LIB_CLASS_CS__TYPE_PARAMETERS:
				return getTypeParameters();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__SUPER_TYPES:
				return getSuperTypes();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__OPERATIONS:
				return getOperations();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__STRUCTURAL_FEATURES:
				return getStructuralFeatures();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CLASS:
				return getClass_();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CONFORMS_TO:
				return getConformsTo();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__ITERATIONS:
				return getIterations();
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
			case OCLstdlibCSTPackage.LIB_CLASS_CS__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends TypeParameterCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				getStructuralFeatures().addAll((Collection<? extends StructuralFeatureCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CLASS:
				setClass((Class<?>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CONFORMS_TO:
				getConformsTo().clear();
				getConformsTo().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__ITERATIONS:
				getIterations().clear();
				getIterations().addAll((Collection<? extends LibIterationCS>)newValue);
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
			case OCLstdlibCSTPackage.LIB_CLASS_CS__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__SUPER_TYPES:
				unsetSuperTypes();
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__OPERATIONS:
				getOperations().clear();
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CLASS:
				setClass((Class<?>)null);
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CONFORMS_TO:
				getConformsTo().clear();
				return;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__ITERATIONS:
				getIterations().clear();
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
			case OCLstdlibCSTPackage.LIB_CLASS_CS__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__SUPER_TYPES:
				return isSetSuperTypes();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__STRUCTURAL_FEATURES:
				return structuralFeatures != null && !structuralFeatures.isEmpty();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CLASS:
				return class_ != null;
			case OCLstdlibCSTPackage.LIB_CLASS_CS__CONFORMS_TO:
				return conformsTo != null && !conformsTo.isEmpty();
			case OCLstdlibCSTPackage.LIB_CLASS_CS__ITERATIONS:
				return iterations != null && !iterations.isEmpty();
		}
		return super.eIsSet(featureID);
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

} //LibClassCSImpl
