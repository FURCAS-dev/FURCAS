/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;

import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl;

import com.sap.furcas.metamodel.FURCAS.impl.FURCASPackageImpl;

import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationFactory;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage;

import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;

import com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;

import com.sap.furcas.metamodel.FURCAS.textblocks.impl.TextblocksPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InterfaceconfigurationPackageImpl extends EPackageImpl implements InterfaceconfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingEClass = null;

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
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InterfaceconfigurationPackageImpl() {
		super(eNS_URI, InterfaceconfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InterfaceconfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InterfaceconfigurationPackage init() {
		if (isInited) return (InterfaceconfigurationPackage) EPackage.Registry.INSTANCE.getEPackage(InterfaceconfigurationPackage.eNS_URI);

		// Obtain or create and register package
		InterfaceconfigurationPackageImpl theInterfaceconfigurationPackage = (InterfaceconfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InterfaceconfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InterfaceconfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		FURCASPackageImpl theFURCASPackage = (FURCASPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FURCASPackage.eNS_URI) instanceof FURCASPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FURCASPackage.eNS_URI) : FURCASPackage.eINSTANCE);
		TCSPackageImpl theTCSPackage = (TCSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI) instanceof TCSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI) : TCSPackage.eINSTANCE);
		TextblocksPackageImpl theTextblocksPackage = (TextblocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) instanceof TextblocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) : TextblocksPackage.eINSTANCE);
		TextblockdefinitionPackageImpl theTextblockdefinitionPackage = (TextblockdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) instanceof TextblockdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) : TextblockdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theInterfaceconfigurationPackage.createPackageContents();
		theFURCASPackage.createPackageContents();
		theTCSPackage.createPackageContents();
		theTextblocksPackage.createPackageContents();
		theTextblockdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theInterfaceconfigurationPackage.initializePackageContents();
		theFURCASPackage.initializePackageContents();
		theTCSPackage.initializePackageContents();
		theTextblocksPackage.initializePackageContents();
		theTextblockdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInterfaceconfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InterfaceconfigurationPackage.eNS_URI, theInterfaceconfigurationPackage);
		return theInterfaceconfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_Bindings() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Name() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_RequireingSyntax() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_ProvidingSyntax() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_RequiredTemplate() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_ProvidedTemplate() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinding_Mode() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceconfigurationFactory getInterfaceconfigurationFactory() {
		return (InterfaceconfigurationFactory)getEFactoryInstance();
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
		configurationEClass = createEClass(CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__BINDINGS);
		createEAttribute(configurationEClass, CONFIGURATION__NAME);

		bindingEClass = createEClass(BINDING);
		createEReference(bindingEClass, BINDING__REQUIREING_SYNTAX);
		createEReference(bindingEClass, BINDING__PROVIDING_SYNTAX);
		createEReference(bindingEClass, BINDING__REQUIRED_TEMPLATE);
		createEReference(bindingEClass, BINDING__PROVIDED_TEMPLATE);
		createEAttribute(bindingEClass, BINDING__MODE);
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
		org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
		TCSPackage theTCSPackage = (TCSPackage)EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfiguration_Bindings(), this.getBinding(), null, "bindings", null, 1, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Name(), theEcorePackage_1.getEString(), "name", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingEClass, Binding.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinding_RequireingSyntax(), theTCSPackage.getConcreteSyntax(), null, "requireingSyntax", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinding_ProvidingSyntax(), theTCSPackage.getConcreteSyntax(), null, "providingSyntax", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinding_RequiredTemplate(), theTCSPackage.getRequiredInterfaceTemplate(), null, "requiredTemplate", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinding_ProvidedTemplate(), theTCSPackage.getTemplate(), null, "providedTemplate", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinding_Mode(), theEcorePackage_1.getEString(), "mode", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //InterfaceconfigurationPackageImpl
