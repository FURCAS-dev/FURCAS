/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: ModelRegistryPackageImpl.java,v 1.2 2010/04/08 06:24:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.modelregistry.ModelRegistration;
import org.eclipse.ocl.examples.modelregistry.ModelRegistry;
import org.eclipse.ocl.examples.modelregistry.ModelRegistryFactory;
import org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage;
import org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelRegistryPackageImpl extends EPackageImpl implements ModelRegistryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelRegistrationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelRegistrySettingsEClass = null;

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
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelRegistryPackageImpl() {
		super(eNS_URI, ModelRegistryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModelRegistryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelRegistryPackage init() {
		if (isInited) return (ModelRegistryPackage)EPackage.Registry.INSTANCE.getEPackage(ModelRegistryPackage.eNS_URI);

		// Obtain or create and register package
		ModelRegistryPackageImpl theModelRegistryPackage = (ModelRegistryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelRegistryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelRegistryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelRegistryPackage.createPackageContents();

		// Initialize created meta-data
		theModelRegistryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelRegistryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelRegistryPackage.eNS_URI, theModelRegistryPackage);
		return theModelRegistryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelRegistry() {
		return modelRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelRegistry_Name() {
		return (EAttribute)modelRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRegistry_Entry() {
		return (EReference)modelRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelRegistration() {
		return modelRegistrationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelRegistration_Accessor() {
		return (EAttribute)modelRegistrationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelRegistration_Kind() {
		return (EAttribute)modelRegistrationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelRegistration_Serialization() {
		return (EAttribute)modelRegistrationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelRegistration_Uri() {
		return (EAttribute)modelRegistrationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelRegistrySettings() {
		return modelRegistrySettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelRegistrySettings_Name() {
		return (EAttribute)modelRegistrySettingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRegistrySettings_Resource() {
		return (EReference)modelRegistrySettingsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRegistryFactory getModelRegistryFactory() {
		return (ModelRegistryFactory)getEFactoryInstance();
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
		modelRegistrationEClass = createEClass(MODEL_REGISTRATION);
		createEAttribute(modelRegistrationEClass, MODEL_REGISTRATION__ACCESSOR);
		createEAttribute(modelRegistrationEClass, MODEL_REGISTRATION__KIND);
		createEAttribute(modelRegistrationEClass, MODEL_REGISTRATION__SERIALIZATION);
		createEAttribute(modelRegistrationEClass, MODEL_REGISTRATION__URI);

		modelRegistryEClass = createEClass(MODEL_REGISTRY);
		createEAttribute(modelRegistryEClass, MODEL_REGISTRY__NAME);
		createEReference(modelRegistryEClass, MODEL_REGISTRY__ENTRY);

		modelRegistrySettingsEClass = createEClass(MODEL_REGISTRY_SETTINGS);
		createEAttribute(modelRegistrySettingsEClass, MODEL_REGISTRY_SETTINGS__NAME);
		createEReference(modelRegistrySettingsEClass, MODEL_REGISTRY_SETTINGS__RESOURCE);
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
	public void initializePackageContentsGen() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(modelRegistrationEClass, ModelRegistration.class, "ModelRegistration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelRegistration_Accessor(), theEcorePackage.getEString(), "accessor", null, 0, 1, ModelRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelRegistration_Kind(), theEcorePackage.getEString(), "kind", null, 0, 1, ModelRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelRegistration_Serialization(), theEcorePackage.getEString(), "serialization", null, 0, 1, ModelRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelRegistration_Uri(), theEcorePackage.getEString(), "uri", null, 0, 1, ModelRegistration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelRegistryEClass, ModelRegistry.class, "ModelRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelRegistry_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ModelRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRegistry_Entry(), this.getModelRegistration(), null, "entry", null, 0, -1, ModelRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelRegistrySettingsEClass, ModelRegistrySettings.class, "ModelRegistrySettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelRegistrySettings_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ModelRegistrySettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRegistrySettings_Resource(), this.getModelRegistry(), null, "resource", null, 0, -1, ModelRegistrySettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
	public void initializePackageContents() {
		initializePackageContentsGen();
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/gmt/umlx/2007/ModelRegistry", this);		// FIXME Deprecate use of obsolete namespace
	}

} //ModelRegistryPackageImpl
