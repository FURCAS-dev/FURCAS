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
 * $Id: CompleteOCLCSTPackageImpl.java,v 1.4 2010/05/21 20:20:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTFactory;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS;
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
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;

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
	private EClass featureContextDeclCSEClass = null;

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
	private EClass completeOCLDocumentCSEClass = null;

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
		OCLinEcoreCSTPackage.eINSTANCE.eClass();

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
	public EClass getFeatureContextDeclCS() {
		return featureContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureContextDeclCS_Class() {
		return (EReference)featureContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureContextDeclCS_Type() {
		return (EReference)featureContextDeclCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getPackageDeclarationCS_Package() {
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
	public EClass getPropertyContextDeclCS() {
		return propertyContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclCS_Property() {
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
	public EReference getClassifierContextDeclCS_Classifier() {
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierContextDeclCS_SelfName() {
		return (EAttribute)classifierContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_Invs() {
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_Defs() {
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteOCLDocumentCS() {
		return completeOCLDocumentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteOCLDocumentCS_Packages() {
		return (EReference)completeOCLDocumentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteOCLDocumentCS_Contexts() {
		return (EReference)completeOCLDocumentCSEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getDefCS_ConstrainedName() {
		return (EAttribute)defCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getOperationContextDeclCS_Operation() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Parameters() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Result() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Pres() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Posts() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_Bodies() {
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(5);
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
	public EAttribute getNamedConstraintCS_ConstraintName() {
		return (EAttribute)namedConstraintCSEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getOclMessageCS_MessageName() {
		return (EAttribute)oclMessageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageCS_Arguments() {
		return (EReference)oclMessageCSEClass.getEStructuralFeatures().get(1);
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
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER);
		createEAttribute(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__INVS);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__DEFS);

		completeOCLDocumentCSEClass = createEClass(COMPLETE_OCL_DOCUMENT_CS);
		createEReference(completeOCLDocumentCSEClass, COMPLETE_OCL_DOCUMENT_CS__PACKAGES);
		createEReference(completeOCLDocumentCSEClass, COMPLETE_OCL_DOCUMENT_CS__CONTEXTS);

		constraintCSEClass = createEClass(CONSTRAINT_CS);
		createEReference(constraintCSEClass, CONSTRAINT_CS__EXPRESSION);

		contextDeclCSEClass = createEClass(CONTEXT_DECL_CS);

		defCSEClass = createEClass(DEF_CS);
		createEAttribute(defCSEClass, DEF_CS__STATIC);
		createEAttribute(defCSEClass, DEF_CS__CONSTRAINED_NAME);
		createEReference(defCSEClass, DEF_CS__PARAMETERS);
		createEReference(defCSEClass, DEF_CS__TYPE);

		derCSEClass = createEClass(DER_CS);

		featureContextDeclCSEClass = createEClass(FEATURE_CONTEXT_DECL_CS);
		createEReference(featureContextDeclCSEClass, FEATURE_CONTEXT_DECL_CS__CLASS);
		createEReference(featureContextDeclCSEClass, FEATURE_CONTEXT_DECL_CS__TYPE);

		initCSEClass = createEClass(INIT_CS);

		invCSEClass = createEClass(INV_CS);

		namedConstraintCSEClass = createEClass(NAMED_CONSTRAINT_CS);
		createEAttribute(namedConstraintCSEClass, NAMED_CONSTRAINT_CS__CONSTRAINT_NAME);

		oclMessageArgCSEClass = createEClass(OCL_MESSAGE_ARG_CS);
		createEReference(oclMessageArgCSEClass, OCL_MESSAGE_ARG_CS__TYPE);

		oclMessageCSEClass = createEClass(OCL_MESSAGE_CS);
		createEAttribute(oclMessageCSEClass, OCL_MESSAGE_CS__MESSAGE_NAME);
		createEReference(oclMessageCSEClass, OCL_MESSAGE_CS__ARGUMENTS);

		operationContextDeclCSEClass = createEClass(OPERATION_CONTEXT_DECL_CS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OPERATION);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PARAMETERS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__RESULT);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PRES);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__POSTS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__BODIES);

		packageDeclarationCSEClass = createEClass(PACKAGE_DECLARATION_CS);
		createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__PACKAGE);
		createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__CONTEXTS);

		postCSEClass = createEClass(POST_CS);

		preCSEClass = createEClass(PRE_CS);

		propertyContextDeclCSEClass = createEClass(PROPERTY_CONTEXT_DECL_CS);
		createEReference(propertyContextDeclCSEClass, PROPERTY_CONTEXT_DECL_CS__PROPERTY);
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
		BaseCSTPackage theBaseCSTPackage = (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);
		OCLinEcoreCSTPackage theOCLinEcoreCSTPackage = (OCLinEcoreCSTPackage)EPackage.Registry.INSTANCE.getEPackage(OCLinEcoreCSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bodyCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		classifierContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
		completeOCLDocumentCSEClass.getESuperTypes().add(theBaseCSTPackage.getDocumentCS());
		constraintCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		contextDeclCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		defCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		derCSEClass.getESuperTypes().add(this.getConstraintCS());
		featureContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
		initCSEClass.getESuperTypes().add(this.getConstraintCS());
		invCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		namedConstraintCSEClass.getESuperTypes().add(this.getConstraintCS());
		oclMessageArgCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		oclMessageCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getOperatorExpCS());
		operationContextDeclCSEClass.getESuperTypes().add(this.getFeatureContextDeclCS());
		packageDeclarationCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		postCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		preCSEClass.getESuperTypes().add(this.getNamedConstraintCS());
		propertyContextDeclCSEClass.getESuperTypes().add(this.getFeatureContextDeclCS());

		// Initialize classes and features; add operations and parameters
		initEClass(bodyCSEClass, BodyCS.class, "BodyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierContextDeclCSEClass, ClassifierContextDeclCS.class, "ClassifierContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierContextDeclCS_Classifier(), theBaseCSTPackage.getClassifierRefCS(), null, "classifier", null, 0, 1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierContextDeclCS_SelfName(), ecorePackage.getEString(), "selfName", null, 0, 1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclCS_Invs(), this.getInvCS(), null, "invs", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclCS_Defs(), this.getDefCS(), null, "defs", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completeOCLDocumentCSEClass, CompleteOCLDocumentCS.class, "CompleteOCLDocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompleteOCLDocumentCS_Packages(), this.getPackageDeclarationCS(), null, "packages", null, 0, -1, CompleteOCLDocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteOCLDocumentCS_Contexts(), this.getContextDeclCS(), null, "contexts", null, 0, -1, CompleteOCLDocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintCS_Expression(), theEssentialOCLCSTPackage.getExpCS(), null, "expression", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextDeclCSEClass, ContextDeclCS.class, "ContextDeclCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defCSEClass, DefCS.class, "DefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefCS_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefCS_ConstrainedName(), ecorePackage.getEString(), "constrainedName", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefCS_Parameters(), theEssentialOCLCSTPackage.getVariableCS(), null, "parameters", null, 0, -1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefCS_Type(), theBaseCSTPackage.getTypeCS(), null, "type", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(derCSEClass, DerCS.class, "DerCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureContextDeclCSEClass, FeatureContextDeclCS.class, "FeatureContextDeclCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureContextDeclCS_Class(), theOCLinEcoreCSTPackage.getOCLinEcoreClassCS(), null, "class", null, 0, 1, FeatureContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureContextDeclCS_Type(), theBaseCSTPackage.getTypeCS(), null, "type", null, 0, 1, FeatureContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initCSEClass, InitCS.class, "InitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invCSEClass, InvCS.class, "InvCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedConstraintCSEClass, NamedConstraintCS.class, "NamedConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedConstraintCS_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 0, 1, NamedConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclMessageArgCSEClass, OclMessageArgCS.class, "OclMessageArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclMessageArgCS_Type(), theBaseCSTPackage.getTypeCS(), null, "type", null, 0, 1, OclMessageArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclMessageCSEClass, OclMessageCS.class, "OclMessageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOclMessageCS_MessageName(), ecorePackage.getEString(), "messageName", null, 0, 1, OclMessageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageCS_Arguments(), theEssentialOCLCSTPackage.getExpCS(), null, "arguments", null, 0, -1, OclMessageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationContextDeclCSEClass, OperationContextDeclCS.class, "OperationContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationContextDeclCS_Operation(), theBaseCSTPackage.getOperationRefCS(), null, "operation", null, 0, 1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Parameters(), theEssentialOCLCSTPackage.getVariableCS(), null, "parameters", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Result(), theEssentialOCLCSTPackage.getVariableCS(), null, "result", null, 0, 1, OperationContextDeclCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Pres(), this.getPreCS(), null, "pres", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Posts(), this.getPostCS(), null, "posts", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_Bodies(), this.getBodyCS(), null, "bodies", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageDeclarationCSEClass, PackageDeclarationCS.class, "PackageDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageDeclarationCS_Package(), theBaseCSTPackage.getPackageRefCS(), null, "package", null, 0, 1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageDeclarationCS_Contexts(), this.getContextDeclCS(), null, "contexts", null, 0, -1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postCSEClass, PostCS.class, "PostCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(preCSEClass, PreCS.class, "PreCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyContextDeclCSEClass, PropertyContextDeclCS.class, "PropertyContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyContextDeclCS_Property(), theBaseCSTPackage.getStructuralFeatureRefCS(), null, "property", null, 0, 1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyContextDeclCS_Init(), this.getInitCS(), null, "init", null, 0, 1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyContextDeclCS_Der(), this.getDerCS(), null, "der", null, 0, 1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompleteOCLCSTPackageImpl
