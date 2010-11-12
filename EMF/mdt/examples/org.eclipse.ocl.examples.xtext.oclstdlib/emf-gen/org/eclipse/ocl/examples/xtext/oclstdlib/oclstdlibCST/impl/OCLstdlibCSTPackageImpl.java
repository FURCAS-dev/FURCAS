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
 * $Id: OCLstdlibCSTPackageImpl.java,v 1.4 2010/05/24 08:59:14 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibBoundClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassifierCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibDocumentCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTFactory;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLstdlibCSTPackageImpl extends EPackageImpl implements OCLstdlibCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libBoundClassCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libClassCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libClassifierCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libDocumentCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libIterationCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libOperationCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libPackageCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libPropertyCSEClass = null;
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
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OCLstdlibCSTPackageImpl() {
		super(eNS_URI, OCLstdlibCSTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OCLstdlibCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OCLstdlibCSTPackage init() {
		if (isInited) return (OCLstdlibCSTPackage)EPackage.Registry.INSTANCE.getEPackage(OCLstdlibCSTPackage.eNS_URI);

		// Obtain or create and register package
		OCLstdlibCSTPackageImpl theOCLstdlibCSTPackage = (OCLstdlibCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OCLstdlibCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OCLstdlibCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BaseCSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOCLstdlibCSTPackage.createPackageContents();

		// Initialize created meta-data
		theOCLstdlibCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOCLstdlibCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OCLstdlibCSTPackage.eNS_URI, theOCLstdlibCSTPackage);
		return theOCLstdlibCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibBoundClassCS() {
		return libBoundClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibClassCS() {
		return libClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibClassCS_Class() {
		return (EAttribute)libClassCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibClassCS_ConformsTo() {
		return (EReference)libClassCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibClassifierCS() {
		return libClassifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibDocumentCS() {
		return libDocumentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibDocumentCS_Packages() {
		return (EReference)libDocumentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibIterationCS() {
		return libIterationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibIterationCS_Class() {
		return (EAttribute)libIterationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibOperationCS() {
		return libOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibOperationCS_Class() {
		return (EAttribute)libOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibPackageCS() {
		return libPackageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibPropertyCS() {
		return libPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibPropertyCS_Class() {
		return (EAttribute)libPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSTFactory getOCLstdlibCSTFactory() {
		return (OCLstdlibCSTFactory)getEFactoryInstance();
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
		libBoundClassCSEClass = createEClass(LIB_BOUND_CLASS_CS);

		libClassCSEClass = createEClass(LIB_CLASS_CS);
		createEAttribute(libClassCSEClass, LIB_CLASS_CS__CLASS);
		createEReference(libClassCSEClass, LIB_CLASS_CS__CONFORMS_TO);

		libClassifierCSEClass = createEClass(LIB_CLASSIFIER_CS);

		libDocumentCSEClass = createEClass(LIB_DOCUMENT_CS);
		createEReference(libDocumentCSEClass, LIB_DOCUMENT_CS__PACKAGES);

		libIterationCSEClass = createEClass(LIB_ITERATION_CS);
		createEAttribute(libIterationCSEClass, LIB_ITERATION_CS__CLASS);

		libOperationCSEClass = createEClass(LIB_OPERATION_CS);
		createEAttribute(libOperationCSEClass, LIB_OPERATION_CS__CLASS);

		libPackageCSEClass = createEClass(LIB_PACKAGE_CS);

		libPropertyCSEClass = createEClass(LIB_PROPERTY_CS);
		createEAttribute(libPropertyCSEClass, LIB_PROPERTY_CS__CLASS);
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

		// Obtain other dependent packages
		BaseCSTPackage theBaseCSTPackage = (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getLibClassifierCS());
		libBoundClassCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theBaseCSTPackage.getBoundElementCS());
		EGenericType g2 = createEGenericType(this.getLibClassCS());
		g1.getETypeArguments().add(g2);
		libBoundClassCSEClass.getEGenericSuperTypes().add(g1);
		libClassCSEClass.getESuperTypes().add(this.getLibClassifierCS());
		libClassifierCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		libDocumentCSEClass.getESuperTypes().add(theBaseCSTPackage.getDocumentCS());
		libIterationCSEClass.getESuperTypes().add(theBaseCSTPackage.getOperationCS());
		libOperationCSEClass.getESuperTypes().add(theBaseCSTPackage.getOperationCS());
		libPackageCSEClass.getESuperTypes().add(theBaseCSTPackage.getPackageCS());
		libPropertyCSEClass.getESuperTypes().add(theBaseCSTPackage.getAttributeCS());

		// Initialize classes and features; add operations and parameters
		initEClass(libBoundClassCSEClass, LibBoundClassCS.class, "LibBoundClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(libClassCSEClass, LibClassCS.class, "LibClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getLibClassCS_Class(), g1, "class", null, 0, 1, LibClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibClassCS_ConformsTo(), theBaseCSTPackage.getTypedRefCS(), null, "conformsTo", null, 0, -1, LibClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libClassifierCSEClass, LibClassifierCS.class, "LibClassifierCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(libDocumentCSEClass, LibDocumentCS.class, "LibDocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibDocumentCS_Packages(), this.getLibPackageCS(), null, "packages", null, 0, -1, LibDocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libIterationCSEClass, LibIterationCS.class, "LibIterationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibIterationCS_Class(), ecorePackage.getEString(), "class", null, 0, 1, LibIterationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libOperationCSEClass, LibOperationCS.class, "LibOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibOperationCS_Class(), ecorePackage.getEString(), "class", null, 0, 1, LibOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libPackageCSEClass, LibPackageCS.class, "LibPackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(libPropertyCSEClass, LibPropertyCS.class, "LibPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibPropertyCS_Class(), ecorePackage.getEString(), "class", null, 0, 1, LibPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OCLstdlibCSTPackageImpl
