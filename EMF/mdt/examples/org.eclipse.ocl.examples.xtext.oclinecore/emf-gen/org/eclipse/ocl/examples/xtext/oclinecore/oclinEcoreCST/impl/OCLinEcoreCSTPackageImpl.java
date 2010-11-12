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
 * $Id: OCLinEcoreCSTPackageImpl.java,v 1.4 2010/05/09 09:48:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreAttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PostconditionCS;

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
	private EClass annotationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreAttributeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreClassCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreClassifierCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreDocumentCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcorePackageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreReferenceCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreStructuralFeatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postconditionCSEClass = null;

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
	private EClass dataTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeOrEnumCSEClass = null;

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
		EcorePackage.eINSTANCE.eClass();
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
	public EClass getAnnotationCS() {
		return annotationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationCS_IdSource() {
		return (EAttribute)annotationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationCS_StringSource() {
		return (EAttribute)annotationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_Contents() {
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_References() {
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreAttributeCS() {
		return ocLinEcoreAttributeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreClassCS() {
		return ocLinEcoreClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentationCS() {
		return documentationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentationCS_Value() {
		return (EAttribute)documentationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCS() {
		return enumCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCS_Literals() {
		return (EReference)enumCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreClassifierCS() {
		return ocLinEcoreClassifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOCLinEcoreClassifierCS_Constraints() {
		return (EReference)ocLinEcoreClassifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOCLinEcoreClassifierCS_InstanceClassName() {
		return (EAttribute)ocLinEcoreClassifierCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOCLinEcoreClassifierCS_Qualifiers() {
		return (EAttribute)ocLinEcoreClassifierCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreDocumentCS() {
		return ocLinEcoreDocumentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOCLinEcoreDocumentCS_Packages() {
		return (EReference)ocLinEcoreDocumentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreOperationCS() {
		return ocLinEcoreOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOCLinEcoreOperationCS_Constraints() {
		return (EReference)ocLinEcoreOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOCLinEcoreOperationCS_Exceptions() {
		return (EReference)ocLinEcoreOperationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcorePackageCS() {
		return ocLinEcorePackageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreReferenceCS() {
		return ocLinEcoreReferenceCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOCLinEcoreReferenceCS_Keys() {
		return (EReference)ocLinEcoreReferenceCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLinEcoreStructuralFeatureCS() {
		return ocLinEcoreStructuralFeatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOCLinEcoreStructuralFeatureCS_Constraints() {
		return (EReference)ocLinEcoreStructuralFeatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOCLinEcoreStructuralFeatureCS_DefaultValueLiteral() {
		return (EAttribute)ocLinEcoreStructuralFeatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostconditionCS() {
		return postconditionCSEClass;
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
	public EAttribute getConstraintCS_Stereotype() {
		return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintCS_ExprString() {
		return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintCS_ExprValue() {
		return (EReference)constraintCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeCS() {
		return dataTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeOrEnumCS() {
		return dataTypeOrEnumCSEClass;
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
		annotationCSEClass = createEClass(ANNOTATION_CS);
		createEAttribute(annotationCSEClass, ANNOTATION_CS__ID_SOURCE);
		createEAttribute(annotationCSEClass, ANNOTATION_CS__STRING_SOURCE);
		createEReference(annotationCSEClass, ANNOTATION_CS__CONTENTS);
		createEReference(annotationCSEClass, ANNOTATION_CS__REFERENCES);

		constraintCSEClass = createEClass(CONSTRAINT_CS);
		createEAttribute(constraintCSEClass, CONSTRAINT_CS__STEREOTYPE);
		createEAttribute(constraintCSEClass, CONSTRAINT_CS__EXPR_STRING);
		createEReference(constraintCSEClass, CONSTRAINT_CS__EXPR_VALUE);

		dataTypeCSEClass = createEClass(DATA_TYPE_CS);

		dataTypeOrEnumCSEClass = createEClass(DATA_TYPE_OR_ENUM_CS);

		documentationCSEClass = createEClass(DOCUMENTATION_CS);
		createEAttribute(documentationCSEClass, DOCUMENTATION_CS__VALUE);

		enumCSEClass = createEClass(ENUM_CS);
		createEReference(enumCSEClass, ENUM_CS__LITERALS);

		ocLinEcoreAttributeCSEClass = createEClass(OC_LIN_ECORE_ATTRIBUTE_CS);

		ocLinEcoreClassCSEClass = createEClass(OC_LIN_ECORE_CLASS_CS);

		ocLinEcoreClassifierCSEClass = createEClass(OC_LIN_ECORE_CLASSIFIER_CS);
		createEReference(ocLinEcoreClassifierCSEClass, OC_LIN_ECORE_CLASSIFIER_CS__CONSTRAINTS);
		createEAttribute(ocLinEcoreClassifierCSEClass, OC_LIN_ECORE_CLASSIFIER_CS__INSTANCE_CLASS_NAME);
		createEAttribute(ocLinEcoreClassifierCSEClass, OC_LIN_ECORE_CLASSIFIER_CS__QUALIFIERS);

		ocLinEcoreDocumentCSEClass = createEClass(OC_LIN_ECORE_DOCUMENT_CS);
		createEReference(ocLinEcoreDocumentCSEClass, OC_LIN_ECORE_DOCUMENT_CS__PACKAGES);

		ocLinEcoreOperationCSEClass = createEClass(OC_LIN_ECORE_OPERATION_CS);
		createEReference(ocLinEcoreOperationCSEClass, OC_LIN_ECORE_OPERATION_CS__CONSTRAINTS);
		createEReference(ocLinEcoreOperationCSEClass, OC_LIN_ECORE_OPERATION_CS__EXCEPTIONS);

		ocLinEcorePackageCSEClass = createEClass(OC_LIN_ECORE_PACKAGE_CS);

		ocLinEcoreReferenceCSEClass = createEClass(OC_LIN_ECORE_REFERENCE_CS);
		createEReference(ocLinEcoreReferenceCSEClass, OC_LIN_ECORE_REFERENCE_CS__KEYS);

		ocLinEcoreStructuralFeatureCSEClass = createEClass(OC_LIN_ECORE_STRUCTURAL_FEATURE_CS);
		createEReference(ocLinEcoreStructuralFeatureCSEClass, OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__CONSTRAINTS);
		createEAttribute(ocLinEcoreStructuralFeatureCSEClass, OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL);

		postconditionCSEClass = createEClass(POSTCONDITION_CS);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		annotationCSEClass.getESuperTypes().add(theBaseCSTPackage.getAnnotationElementCS());
		constraintCSEClass.getESuperTypes().add(theBaseCSTPackage.getNamedElementCS());
		dataTypeCSEClass.getESuperTypes().add(this.getDataTypeOrEnumCS());
		dataTypeOrEnumCSEClass.getESuperTypes().add(this.getOCLinEcoreClassifierCS());
		documentationCSEClass.getESuperTypes().add(theBaseCSTPackage.getAnnotationElementCS());
		enumCSEClass.getESuperTypes().add(this.getDataTypeOrEnumCS());
		enumCSEClass.getESuperTypes().add(theBaseCSTPackage.getNamespaceCS());
		ocLinEcoreAttributeCSEClass.getESuperTypes().add(this.getOCLinEcoreStructuralFeatureCS());
		ocLinEcoreAttributeCSEClass.getESuperTypes().add(theBaseCSTPackage.getAttributeCS());
		ocLinEcoreClassCSEClass.getESuperTypes().add(this.getOCLinEcoreClassifierCS());
		ocLinEcoreClassCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		ocLinEcoreClassifierCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassifierCS());
		ocLinEcoreDocumentCSEClass.getESuperTypes().add(theBaseCSTPackage.getDocumentCS());
		ocLinEcoreOperationCSEClass.getESuperTypes().add(theBaseCSTPackage.getOperationCS());
		ocLinEcorePackageCSEClass.getESuperTypes().add(theBaseCSTPackage.getPackageCS());
		ocLinEcoreReferenceCSEClass.getESuperTypes().add(this.getOCLinEcoreStructuralFeatureCS());
		ocLinEcoreReferenceCSEClass.getESuperTypes().add(theBaseCSTPackage.getReferenceCS());
		ocLinEcoreStructuralFeatureCSEClass.getESuperTypes().add(theBaseCSTPackage.getStructuralFeatureCS());
		postconditionCSEClass.getESuperTypes().add(this.getConstraintCS());

		// Initialize classes and features; add operations and parameters
		initEClass(annotationCSEClass, AnnotationCS.class, "AnnotationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotationCS_IdSource(), ecorePackage.getEString(), "idSource", null, 0, 1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationCS_StringSource(), ecorePackage.getEString(), "stringSource", null, 0, 1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationCS_Contents(), theBaseCSTPackage.getModelElementCS(), null, "contents", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationCS_References(), theBaseCSTPackage.getModelElementCSRef(), null, "references", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraintCS_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraintCS_ExprString(), ecorePackage.getEString(), "exprString", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintCS_ExprValue(), theEssentialOCLCSTPackage.getExpCS(), null, "exprValue", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeCSEClass, DataTypeCS.class, "DataTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeOrEnumCSEClass, DataTypeOrEnumCS.class, "DataTypeOrEnumCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(documentationCSEClass, DocumentationCS.class, "DocumentationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentationCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, DocumentationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumCSEClass, EnumCS.class, "EnumCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumCS_Literals(), theBaseCSTPackage.getEnumLiteralCS(), null, "literals", null, 0, -1, EnumCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ocLinEcoreAttributeCSEClass, OCLinEcoreAttributeCS.class, "OCLinEcoreAttributeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ocLinEcoreClassCSEClass, OCLinEcoreClassCS.class, "OCLinEcoreClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ocLinEcoreClassifierCSEClass, OCLinEcoreClassifierCS.class, "OCLinEcoreClassifierCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOCLinEcoreClassifierCS_Constraints(), this.getConstraintCS(), null, "constraints", null, 0, -1, OCLinEcoreClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOCLinEcoreClassifierCS_InstanceClassName(), ecorePackage.getEString(), "instanceClassName", null, 0, 1, OCLinEcoreClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOCLinEcoreClassifierCS_Qualifiers(), ecorePackage.getEString(), "qualifiers", null, 0, -1, OCLinEcoreClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ocLinEcoreDocumentCSEClass, OCLinEcoreDocumentCS.class, "OCLinEcoreDocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOCLinEcoreDocumentCS_Packages(), this.getOCLinEcorePackageCS(), null, "packages", null, 0, -1, OCLinEcoreDocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ocLinEcoreOperationCSEClass, OCLinEcoreOperationCS.class, "OCLinEcoreOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOCLinEcoreOperationCS_Constraints(), this.getConstraintCS(), null, "constraints", null, 0, -1, OCLinEcoreOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOCLinEcoreOperationCS_Exceptions(), theBaseCSTPackage.getTypedRefCS(), null, "exceptions", null, 0, -1, OCLinEcoreOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ocLinEcorePackageCSEClass, OCLinEcorePackageCS.class, "OCLinEcorePackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ocLinEcoreReferenceCSEClass, OCLinEcoreReferenceCS.class, "OCLinEcoreReferenceCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOCLinEcoreReferenceCS_Keys(), theBaseCSTPackage.getAttributeCSRef(), null, "keys", null, 0, -1, OCLinEcoreReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ocLinEcoreStructuralFeatureCSEClass, OCLinEcoreStructuralFeatureCS.class, "OCLinEcoreStructuralFeatureCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOCLinEcoreStructuralFeatureCS_Constraints(), this.getConstraintCS(), null, "constraints", null, 0, -1, OCLinEcoreStructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOCLinEcoreStructuralFeatureCS_DefaultValueLiteral(), ecorePackage.getEString(), "defaultValueLiteral", null, 0, 1, OCLinEcoreStructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postconditionCSEClass, PostconditionCS.class, "PostconditionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OCLinEcoreCSTPackageImpl
