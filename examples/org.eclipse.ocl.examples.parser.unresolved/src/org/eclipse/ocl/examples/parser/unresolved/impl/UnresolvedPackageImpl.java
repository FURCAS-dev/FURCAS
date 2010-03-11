/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UnresolvedPackageImpl.java,v 1.1 2010/03/11 11:54:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.unresolved.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedClassifier;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedEnum;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedFactory;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnresolvedPackageImpl extends EPackageImpl implements UnresolvedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unresolvedClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unresolvedClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unresolvedEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unresolvedDataTypeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UnresolvedPackageImpl() {
		super(eNS_URI, UnresolvedFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UnresolvedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UnresolvedPackage init() {
		if (isInited) return (UnresolvedPackage)EPackage.Registry.INSTANCE.getEPackage(UnresolvedPackage.eNS_URI);

		// Obtain or create and register package
		UnresolvedPackageImpl theUnresolvedPackage = (UnresolvedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UnresolvedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UnresolvedPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theUnresolvedPackage.createPackageContents();

		// Initialize created meta-data
		theUnresolvedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUnresolvedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UnresolvedPackage.eNS_URI, theUnresolvedPackage);
		return theUnresolvedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnresolvedClass() {
		return unresolvedClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnresolvedClass_UnresolvedAttribute() {
		return (EAttribute)unresolvedClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnresolvedClass_UnresolvedReference() {
		return (EReference)unresolvedClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnresolvedClass_UnresolvedProperty() {
		return (EReference)unresolvedClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnresolvedClassifier() {
		return unresolvedClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnresolvedEnum() {
		return unresolvedEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUnresolvedDataType() {
		return unresolvedDataTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedFactory getUnresolvedFactory() {
		return (UnresolvedFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		unresolvedClassEClass = createEClass(UNRESOLVED_CLASS);
		createEAttribute(unresolvedClassEClass, UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE);
		createEReference(unresolvedClassEClass, UNRESOLVED_CLASS__UNRESOLVED_REFERENCE);
		createEReference(unresolvedClassEClass, UNRESOLVED_CLASS__UNRESOLVED_PROPERTY);

		unresolvedClassifierEClass = createEClass(UNRESOLVED_CLASSIFIER);

		// Create enums
		unresolvedEnumEEnum = createEEnum(UNRESOLVED_ENUM);

		// Create data types
		unresolvedDataTypeEDataType = createEDataType(UNRESOLVED_DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(unresolvedClassEClass, UnresolvedClass.class, "UnresolvedClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnresolvedClass_UnresolvedAttribute(), this.getUnresolvedDataType(), "unresolvedAttribute", null, 0, 1, UnresolvedClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnresolvedClass_UnresolvedReference(), this.getUnresolvedClass(), null, "unresolvedReference", null, 0, 1, UnresolvedClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnresolvedClass_UnresolvedProperty(), this.getUnresolvedClassifier(), null, "unresolvedProperty", null, 0, 1, UnresolvedClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(unresolvedClassEClass, null, "unresolvedOperation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unresolvedClassifierEClass, UnresolvedClassifier.class, "UnresolvedClassifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(unresolvedEnumEEnum, UnresolvedEnum.class, "UnresolvedEnum");
		addEEnumLiteral(unresolvedEnumEEnum, UnresolvedEnum.UNRESOLVED_ENUM_LITERAL);

		// Initialize data types
		initEDataType(unresolvedDataTypeEDataType, String.class, "UnresolvedDataType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //UnresolvedPackageImpl
