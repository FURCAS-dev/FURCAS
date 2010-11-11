/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;

import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl;

import com.sap.furcas.metamodel.FURCAS.impl.FURCASPackageImpl;

import com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionFactory;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;

import com.sap.furcas.metamodel.FURCAS.textblocks.impl.TextblocksPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
public class TextblockdefinitionPackageImpl extends EPackageImpl implements TextblockdefinitionPackage {
        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        private EClass textBlockDefinitionEClass = null;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        private EEnum formatPolicyEEnum = null;

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
	 * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
        private TextblockdefinitionPackageImpl() {
		super(eNS_URI, TextblockdefinitionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TextblockdefinitionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
        public static TextblockdefinitionPackage init() {
		if (isInited) return (TextblockdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI);

		// Obtain or create and register package
		TextblockdefinitionPackageImpl theTextblockdefinitionPackage = (TextblockdefinitionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TextblockdefinitionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TextblockdefinitionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		FURCASPackageImpl theFURCASPackage = (FURCASPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FURCASPackage.eNS_URI) instanceof FURCASPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FURCASPackage.eNS_URI) : FURCASPackage.eINSTANCE);
		TCSPackageImpl theTCSPackage = (TCSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI) instanceof TCSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI) : TCSPackage.eINSTANCE);
		TextblocksPackageImpl theTextblocksPackage = (TextblocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) instanceof TextblocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) : TextblocksPackage.eINSTANCE);

		// Create package meta-data objects
		theTextblockdefinitionPackage.createPackageContents();
		theFURCASPackage.createPackageContents();
		theTCSPackage.createPackageContents();
		theTextblocksPackage.createPackageContents();

		// Initialize created meta-data
		theTextblockdefinitionPackage.initializePackageContents();
		theFURCASPackage.initializePackageContents();
		theTCSPackage.initializePackageContents();
		theTextblocksPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTextblockdefinitionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TextblockdefinitionPackage.eNS_URI, theTextblockdefinitionPackage);
		return theTextblockdefinitionPackage;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EClass getTextBlockDefinition() {
		return textBlockDefinitionEClass;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EAttribute getTextBlockDefinition_FormatPolicy() {
		return (EAttribute)textBlockDefinitionEClass.getEStructuralFeatures().get(0);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EAttribute getTextBlockDefinition_DefaultTemplate() {
		return (EAttribute)textBlockDefinitionEClass.getEStructuralFeatures().get(1);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EReference getTextBlockDefinition_ParseRule() {
		return (EReference)textBlockDefinitionEClass.getEStructuralFeatures().get(2);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EReference getTextBlockDefinition_Context() {
		return (EReference)textBlockDefinitionEClass.getEStructuralFeatures().get(3);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EReference getTextBlockDefinition_SubDefinitions() {
		return (EReference)textBlockDefinitionEClass.getEStructuralFeatures().get(4);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EReference getTextBlockDefinition_Generalisation() {
		return (EReference)textBlockDefinitionEClass.getEStructuralFeatures().get(5);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EAttribute getTextBlockDefinition_Name() {
		return (EAttribute)textBlockDefinitionEClass.getEStructuralFeatures().get(6);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EEnum getFormatPolicy() {
		return formatPolicyEEnum;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextblockdefinitionFactory getTextblockdefinitionFactory() {
		return (TextblockdefinitionFactory)getEFactoryInstance();
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
		textBlockDefinitionEClass = createEClass(TEXT_BLOCK_DEFINITION);
		createEAttribute(textBlockDefinitionEClass, TEXT_BLOCK_DEFINITION__FORMAT_POLICY);
		createEAttribute(textBlockDefinitionEClass, TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE);
		createEReference(textBlockDefinitionEClass, TEXT_BLOCK_DEFINITION__PARSE_RULE);
		createEReference(textBlockDefinitionEClass, TEXT_BLOCK_DEFINITION__CONTEXT);
		createEReference(textBlockDefinitionEClass, TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS);
		createEReference(textBlockDefinitionEClass, TEXT_BLOCK_DEFINITION__GENERALISATION);
		createEAttribute(textBlockDefinitionEClass, TEXT_BLOCK_DEFINITION__NAME);

		// Create enums
		formatPolicyEEnum = createEEnum(FORMAT_POLICY);
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
		initEClass(textBlockDefinitionEClass, TextBlockDefinition.class, "TextBlockDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextBlockDefinition_FormatPolicy(), this.getFormatPolicy(), "formatPolicy", "", 0, 1, TextBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextBlockDefinition_DefaultTemplate(), theEcorePackage_1.getEString(), "defaultTemplate", "", 0, 1, TextBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlockDefinition_ParseRule(), theTCSPackage.getTemplate(), null, "parseRule", null, 0, 1, TextBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlockDefinition_Context(), this.getTextBlockDefinition(), this.getTextBlockDefinition_SubDefinitions(), "context", null, 0, 1, TextBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlockDefinition_SubDefinitions(), this.getTextBlockDefinition(), this.getTextBlockDefinition_Context(), "subDefinitions", null, 0, -1, TextBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlockDefinition_Generalisation(), this.getTextBlockDefinition(), null, "generalisation", null, 0, 1, TextBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextBlockDefinition_Name(), theEcorePackage_1.getEString(), "name", null, 0, 1, TextBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(formatPolicyEEnum, FormatPolicy.class, "FormatPolicy");
		addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_ALWAYS);
		addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_NEVER);
		addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_BEFORE);
		addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_AFTER);
	}

} //TextblockdefinitionPackageImpl
