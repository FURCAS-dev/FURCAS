/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.textverticalization.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationFactory;
import org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage;
import org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextverticalizationPackageImpl extends EPackageImpl implements TextverticalizationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translatableTextEClass = null;

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
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TextverticalizationPackageImpl() {
		super(eNS_URI, TextverticalizationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TextverticalizationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TextverticalizationPackage init() {
		if (isInited) return (TextverticalizationPackage)EPackage.Registry.INSTANCE.getEPackage(TextverticalizationPackage.eNS_URI);

		// Obtain or create and register package
		TextverticalizationPackageImpl theTextverticalizationPackage = (TextverticalizationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TextverticalizationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TextverticalizationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTextverticalizationPackage.createPackageContents();

		// Initialize created meta-data
		theTextverticalizationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTextverticalizationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TextverticalizationPackage.eNS_URI, theTextverticalizationPackage);
		return theTextverticalizationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTranslatableText() {
		return translatableTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslatableText_MaxWidth() {
		return (EAttribute)translatableTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslatableText_OriginalText() {
		return (EAttribute)translatableTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslatableText_ResType() {
		return (EAttribute)translatableTextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslatableText_Translate() {
		return (EAttribute)translatableTextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslatableText_TransUnitId() {
		return (EAttribute)translatableTextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslatableText_ResName() {
		return (EAttribute)translatableTextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextverticalizationFactory getTextverticalizationFactory() {
		return (TextverticalizationFactory)getEFactoryInstance();
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
		translatableTextEClass = createEClass(TRANSLATABLE_TEXT);
		createEAttribute(translatableTextEClass, TRANSLATABLE_TEXT__MAX_WIDTH);
		createEAttribute(translatableTextEClass, TRANSLATABLE_TEXT__ORIGINAL_TEXT);
		createEAttribute(translatableTextEClass, TRANSLATABLE_TEXT__RES_TYPE);
		createEAttribute(translatableTextEClass, TRANSLATABLE_TEXT__TRANSLATE);
		createEAttribute(translatableTextEClass, TRANSLATABLE_TEXT__TRANS_UNIT_ID);
		createEAttribute(translatableTextEClass, TRANSLATABLE_TEXT__RES_NAME);
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
		initEClass(translatableTextEClass, TranslatableText.class, "TranslatableText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslatableText_MaxWidth(), ecorePackage.getEInt(), "maxWidth", "255", 1, 1, TranslatableText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatableText_OriginalText(), ecorePackage.getEString(), "originalText", null, 1, 1, TranslatableText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatableText_ResType(), ecorePackage.getEString(), "resType", null, 1, 1, TranslatableText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatableText_Translate(), ecorePackage.getEBoolean(), "translate", "true", 1, 1, TranslatableText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatableText_TransUnitId(), ecorePackage.getEString(), "transUnitId", null, 1, 1, TranslatableText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatableText_ResName(), ecorePackage.getEString(), "resName", null, 1, 1, TranslatableText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://sap.com/MOIN
		createMOINAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://sap.com/MOIN</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMOINAnnotations() {
		String source = "http://sap.com/MOIN";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "textverticalization.TranslatableTextFragment", "//TranslatableTextFragment",
			 "textverticalization.TranslatableText", "//TranslatableText"
		   });		
		addAnnotation
		  (translatableTextEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/textverticalization[2.0.0]",
			 "metaObject", "textverticalization.TranslatableTextFragment",
			 "metaObjectMofId", "48D4188D58380873869111DD8E220019993BAD15",
			 "isStructureType", "true"
		   });	
	}

} //TextverticalizationPackageImpl
