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
 * $Id: OCLinEcoreCSTPackageImpl.java,v 1.6 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLinEcoreCSTPackageImpl extends EPackageImpl implements OCLinEcoreCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreConstraintCSEClass = null;

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
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OCLinEcoreCSTPackageImpl() {
		super(eNS_URI, OCLinEcoreCSTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OCLinEcoreCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OCLinEcoreCSTPackage init() {
		if (isInited) return (OCLinEcoreCSTPackage)EPackage.Registry.INSTANCE.getEPackage(OCLinEcoreCSTPackage.eNS_URI);

		// Obtain or create and register package
		OCLinEcoreCSTPackageImpl theOCLinEcoreCSTPackage = (OCLinEcoreCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OCLinEcoreCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OCLinEcoreCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOCLinEcoreCSTPackage.createPackageContents();

		// Initialize created meta-data
		theOCLinEcoreCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOCLinEcoreCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OCLinEcoreCSTPackage.eNS_URI, theOCLinEcoreCSTPackage);
		return theOCLinEcoreCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreConstraintCS()
	{
		return ocLinEcoreConstraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSTFactory getOCLinEcoreCSTFactory() {
		return (OCLinEcoreCSTFactory)getEFactoryInstance();
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
		ocLinEcoreConstraintCSEClass = createEClass(OC_LIN_ECORE_CONSTRAINT_CS);
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
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ocLinEcoreConstraintCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpConstraintCS());

		// Initialize classes and features; add operations and parameters
		initEClass(ocLinEcoreConstraintCSEClass, OCLinEcoreConstraintCS.class, "OCLinEcoreConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OCLinEcoreCSTPackageImpl
