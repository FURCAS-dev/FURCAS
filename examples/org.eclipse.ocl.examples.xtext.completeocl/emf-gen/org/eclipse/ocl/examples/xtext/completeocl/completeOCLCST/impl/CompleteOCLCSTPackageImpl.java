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
 * $Id: CompleteOCLCSTPackageImpl.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTFactory;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ImportCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompleteOCLCSTPackageImpl extends EPackageImpl implements CompleteOCLCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyContextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierContextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationContextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bodyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedConstraintCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclMessageArgCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclMessageCSEClass = null;

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
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompleteOCLCSTPackageImpl() {
		super(eNS_URI, CompleteOCLCSTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompleteOCLCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompleteOCLCSTPackage init() {
		if (isInited) return (CompleteOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(CompleteOCLCSTPackage.eNS_URI);

		// Obtain or create and register package
		CompleteOCLCSTPackageImpl theCompleteOCLCSTPackage = (CompleteOCLCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompleteOCLCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompleteOCLCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCompleteOCLCSTPackage.createPackageContents();

		// Initialize created meta-data
		theCompleteOCLCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompleteOCLCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompleteOCLCSTPackage.eNS_URI, theCompleteOCLCSTPackage);
		return theCompleteOCLCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentCS() {
		return documentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentCS_Imports() {
		return (EReference)documentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentCS_Packages() {
		return (EReference)documentCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentCS_Contexts() {
		return (EReference)documentCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportCS() {
		return importCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportCS_ImportedNamespace() {
		return (EAttribute)importCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageDeclarationCS() {
		return packageDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageDeclarationCS_Name() {
		return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageDeclarationCS_Contexts() {
		return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextDeclCS() {
		return contextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextDeclCS_ContextName() {
		return (EReference)contextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyContextDeclCS() {
		return propertyContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclCS_Type() {
		return (EReference)propertyContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclCS_Init() {
		return (EReference)propertyContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclCS_Der() {
		return (EReference)propertyContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitCS() {
		return initCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerCS() {
		return derCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierContextDeclCS() {
		return classifierContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_SelfName() {
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_Invs() {
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_Defs() {
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvCS() {
		return invCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefCS() {
		return defCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefCS_Static() {
		return (EAttribute)defCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefCS_ConstrainedName() {
		return (EReference)defCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefCS_Parameters() {
		return (EReference)defCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefCS_Type() {
		return (EReference)defCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationContextDeclCS() {
		return operationContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Parameters() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Type() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Pres() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Posts() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Bodies() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreCS() {
		return preCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostCS() {
		return postCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBodyCS() {
		return bodyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintCS() {
		return constraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintCS_Expression() {
		return (EReference)constraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedConstraintCS() {
		return namedConstraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedConstraintCS_ConstraintName() {
		return (EReference)namedConstraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclMessageArgCS() {
		return oclMessageArgCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageArgCS_Type() {
		return (EReference)oclMessageArgCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclMessageCS() {
		return oclMessageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageCS_Source() {
		return (EReference)oclMessageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclMessageCS_Op() {
		return (EAttribute)oclMessageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageCS_MessageName() {
		return (EReference)oclMessageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageCS_Arguments() {
		return (EReference)oclMessageCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSTFactory getCompleteOCLCSTFactory() {
		return (CompleteOCLCSTFactory)getEFactoryInstance();
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
		bodyCSEClass = createEClass(BODY_CS);

		classifierContextDeclCSEClass = createEClass(CLASSIFIER_CONTEXT_DECL_CS);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__INVS);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__DEFS);

		constraintCSEClass = createEClass(CONSTRAINT_CS);
		createEReference(constraintCSEClass, CONSTRAINT_CS__EXPRESSION);

		contextDeclCSEClass = createEClass(CONTEXT_DECL_CS);
		createEReference(contextDeclCSEClass, CONTEXT_DECL_CS__CONTEXT_NAME);

		defCSEClass = createEClass(DEF_CS);
		createEAttribute(defCSEClass, DEF_CS__STATIC);
		createEReference(defCSEClass, DEF_CS__CONSTRAINED_NAME);
		createEReference(defCSEClass, DEF_CS__PARAMETERS);
		createEReference(defCSEClass, DEF_CS__TYPE);

		derCSEClass = createEClass(DER_CS);

		documentCSEClass = createEClass(DOCUMENT_CS);
		createEReference(documentCSEClass, DOCUMENT_CS__IMPORTS);
		createEReference(documentCSEClass, DOCUMENT_CS__PACKAGES);
		createEReference(documentCSEClass, DOCUMENT_CS__CONTEXTS);

		importCSEClass = createEClass(IMPORT_CS);
		createEAttribute(importCSEClass, IMPORT_CS__IMPORTED_NAMESPACE);

		initCSEClass = createEClass(INIT_CS);

		invCSEClass = createEClass(INV_CS);

		namedConstraintCSEClass = createEClass(NAMED_CONSTRAINT_CS);
		createEReference(namedConstraintCSEClass, NAMED_CONSTRAINT_CS__CONSTRAINT_NAME);

		oclMessageArgCSEClass = createEClass(OCL_MESSAGE_ARG_CS);
		createEReference(oclMessageArgCSEClass, OCL_MESSAGE_ARG_CS__TYPE);

		oclMessageCSEClass = createEClass(OCL_MESSAGE_CS);
		createEReference(oclMessageCSEClass, OCL_MESSAGE_CS__SOURCE);
		createEAttribute(oclMessageCSEClass, OCL_MESSAGE_CS__OP);
		createEReference(oclMessageCSEClass, OCL_MESSAGE_CS__MESSAGE_NAME);
		createEReference(oclMessageCSEClass, OCL_MESSAGE_CS__ARGUMENTS);

		operationContextDeclCSEClass = createEClass(OPERATION_CONTEXT_DECL_CS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PARAMETERS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__TYPE);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PRES);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__POSTS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__BODIES);

		packageDeclarationCSEClass = createEClass(PACKAGE_DECLARATION_CS);
		createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__NAME);
		createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__CONTEXTS);

		postCSEClass = createEClass(POST_CS);

		preCSEClass = createEClass(PRE_CS);

		propertyContextDeclCSEClass = createEClass(PROPERTY_CONTEXT_DECL_CS);
		createEReference(propertyContextDeclCSEClass, PROPERTY_CONTEXT_DECL_CS__TYPE);
		createEReference(propertyContextDeclCSEClass, PROPERTY_CONTEXT_DECL_CS__INIT);
		createEReference(propertyContextDeclCSEClass, PROPERTY_CONTEXT_DECL_CS__DER);
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
		bodyCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		classifierContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
		defCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		derCSEClass.getESuperTypes().add(this.getConstraintCS());
		documentCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getOclExpressionCS());
		initCSEClass.getESuperTypes().add(this.getConstraintCS());
		invCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		namedConstraintCSEClass.getESuperTypes().add(this.getConstraintCS());
		oclMessageArgCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getOclExpressionCS());
		oclMessageCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getOclExpressionCS());
		operationContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
		postCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		preCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		propertyContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());

		// Initialize classes and features; add operations and parameters
		initEClass(bodyCSEClass, BodyCS.class, "BodyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierContextDeclCSEClass, ClassifierContextDeclCS.class, "ClassifierContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierContextDeclCS_SelfName(), theEssentialOCLCSTPackage.getSimpleNameCS(), null, "selfName", null, 0, 1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclCS_Invs(), this.getInvCS(), null, "invs", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclCS_Defs(), this.getDefCS(), null, "defs", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintCS_Expression(), theEssentialOCLCSTPackage.getOclExpressionCS(), null, "expression", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextDeclCSEClass, ContextDeclCS.class, "ContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextDeclCS_ContextName(), theEssentialOCLCSTPackage.getPathNameCS(), null, "contextName", null, 0, 1, ContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defCSEClass, DefCS.class, "DefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefCS_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefCS_ConstrainedName(), theEssentialOCLCSTPackage.getSimpleNameCS(), null, "constrainedName", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefCS_Parameters(), theEssentialOCLCSTPackage.getVariableCS(), null, "parameters", null, 0, -1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefCS_Type(), theEssentialOCLCSTPackage.getTypeCS(), null, "type", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(derCSEClass, DerCS.class, "DerCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(documentCSEClass, DocumentCS.class, "DocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocumentCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, DocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentCS_Packages(), this.getPackageDeclarationCS(), null, "packages", null, 0, -1, DocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentCS_Contexts(), this.getContextDeclCS(), null, "contexts", null, 0, -1, DocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importCSEClass, ImportCS.class, "ImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportCS_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initCSEClass, InitCS.class, "InitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invCSEClass, InvCS.class, "InvCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedConstraintCSEClass, NamedConstraintCS.class, "NamedConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedConstraintCS_ConstraintName(), theEssentialOCLCSTPackage.getSimpleNameCS(), null, "constraintName", null, 0, 1, NamedConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclMessageArgCSEClass, OclMessageArgCS.class, "OclMessageArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclMessageArgCS_Type(), theEssentialOCLCSTPackage.getTypeCS(), null, "type", null, 0, 1, OclMessageArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclMessageCSEClass, OclMessageCS.class, "OclMessageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclMessageCS_Source(), theEssentialOCLCSTPackage.getOclExpressionCS(), null, "source", null, 0, 1, OclMessageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOclMessageCS_Op(), ecorePackage.getEString(), "op", null, 0, 1, OclMessageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageCS_MessageName(), theEssentialOCLCSTPackage.getSimpleNameCS(), null, "messageName", null, 0, 1, OclMessageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageCS_Arguments(), theEssentialOCLCSTPackage.getOclExpressionCS(), null, "arguments", null, 0, -1, OclMessageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationContextDeclCSEClass, OperationContextDeclCS.class, "OperationContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationContextDeclCS_Parameters(), theEssentialOCLCSTPackage.getVariableCS(), null, "parameters", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Type(), theEssentialOCLCSTPackage.getTypeCS(), null, "type", null, 0, 1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Pres(), this.getPreCS(), null, "pres", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Posts(), this.getPostCS(), null, "posts", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Bodies(), this.getBodyCS(), null, "bodies", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageDeclarationCSEClass, PackageDeclarationCS.class, "PackageDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageDeclarationCS_Name(), theEssentialOCLCSTPackage.getPathNameCS(), null, "name", null, 0, 1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageDeclarationCS_Contexts(), this.getContextDeclCS(), null, "contexts", null, 0, -1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postCSEClass, PostCS.class, "PostCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(preCSEClass, PreCS.class, "PreCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyContextDeclCSEClass, PropertyContextDeclCS.class, "PropertyContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyContextDeclCS_Type(), theEssentialOCLCSTPackage.getTypeCS(), null, "type", null, 0, 1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyContextDeclCS_Init(), this.getInitCS(), null, "init", null, 0, 1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyContextDeclCS_Der(), this.getDerCS(), null, "der", null, 0, 1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompleteOCLCSTPackageImpl
