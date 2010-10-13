/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblockdefinition.impl;

import com.sap.furcas.metamodel.TCS.TCSPackage;

import com.sap.furcas.metamodel.textblockdefinition.FormatPolicy;
import com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition;
import com.sap.furcas.metamodel.textblockdefinition.TextblockdefinitionFactory;
import com.sap.furcas.metamodel.textblockdefinition.TextblockdefinitionPackage;

import com.sap.furcas.metamodel.textblocks.TextblocksPackage;

import com.sap.furcas.metamodel.textblocks.impl.TextblocksPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

import org.eclipse.ocl.expressions.ExpressionsPackage;

import org.eclipse.ocl.types.TypesPackage;

import org.eclipse.ocl.utilities.UtilitiesPackage;

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
        private EClass textblockDefinitionEClass = null;

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
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockdefinitionPackage#eNS_URI
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
                TCSPackage.eINSTANCE.eClass();
                EcorePackage.eINSTANCE.eClass();
                TypesPackage.eINSTANCE.eClass();
                UtilitiesPackage.eINSTANCE.eClass();
                ExpressionsPackage.eINSTANCE.eClass();

                // Obtain or create and register interdependencies
                TextblocksPackageImpl theTextblocksPackage = (TextblocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) instanceof TextblocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) : TextblocksPackage.eINSTANCE);

                // Create package meta-data objects
                theTextblockdefinitionPackage.createPackageContents();
                theTextblocksPackage.createPackageContents();

                // Initialize created meta-data
                theTextblockdefinitionPackage.initializePackageContents();
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
        public EClass getTextblockDefinition() {
                return textblockDefinitionEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getTextblockDefinition_FormatPolicy() {
                return (EAttribute)textblockDefinitionEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getTextblockDefinition_DefaultTemplate() {
                return (EAttribute)textblockDefinitionEClass.getEStructuralFeatures().get(1);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getTextblockDefinition_ParseRule() {
                return (EReference)textblockDefinitionEClass.getEStructuralFeatures().get(2);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getTextblockDefinition_Context() {
                return (EReference)textblockDefinitionEClass.getEStructuralFeatures().get(3);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getTextblockDefinition_SubDefinitions() {
                return (EReference)textblockDefinitionEClass.getEStructuralFeatures().get(4);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getTextblockDefinition_Generalisation() {
                return (EReference)textblockDefinitionEClass.getEStructuralFeatures().get(5);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getTextblockDefinition_Name() {
                return (EAttribute)textblockDefinitionEClass.getEStructuralFeatures().get(6);
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
                textblockDefinitionEClass = createEClass(TEXTBLOCK_DEFINITION);
                createEAttribute(textblockDefinitionEClass, TEXTBLOCK_DEFINITION__FORMAT_POLICY);
                createEAttribute(textblockDefinitionEClass, TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE);
                createEReference(textblockDefinitionEClass, TEXTBLOCK_DEFINITION__PARSE_RULE);
                createEReference(textblockDefinitionEClass, TEXTBLOCK_DEFINITION__CONTEXT);
                createEReference(textblockDefinitionEClass, TEXTBLOCK_DEFINITION__SUB_DEFINITIONS);
                createEReference(textblockDefinitionEClass, TEXTBLOCK_DEFINITION__GENERALISATION);
                createEAttribute(textblockDefinitionEClass, TEXTBLOCK_DEFINITION__NAME);

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
                initEClass(textblockDefinitionEClass, TextblockDefinition.class, "TextblockDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getTextblockDefinition_FormatPolicy(), this.getFormatPolicy(), "formatPolicy", "", 0, 1, TextblockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getTextblockDefinition_DefaultTemplate(), theEcorePackage_1.getEString(), "defaultTemplate", "", 0, 1, TextblockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getTextblockDefinition_ParseRule(), theTCSPackage.getTemplate(), null, "parseRule", null, 0, 1, TextblockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getTextblockDefinition_Context(), this.getTextblockDefinition(), this.getTextblockDefinition_SubDefinitions(), "context", null, 0, 1, TextblockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getTextblockDefinition_SubDefinitions(), this.getTextblockDefinition(), this.getTextblockDefinition_Context(), "subDefinitions", null, 0, -1, TextblockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getTextblockDefinition_Generalisation(), this.getTextblockDefinition(), null, "generalisation", null, 0, 1, TextblockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getTextblockDefinition_Name(), theEcorePackage_1.getEString(), "name", null, 0, 1, TextblockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                // Initialize enums and add enum literals
                initEEnum(formatPolicyEEnum, FormatPolicy.class, "FormatPolicy");
                addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_ALWAYS);
                addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_NEVER);
                addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_BEFORE);
                addEEnumLiteral(formatPolicyEEnum, FormatPolicy.KEEP_AFTER);

                // Create resource
                createResource(eNS_URI);
        }

} //TextblockdefinitionPackageImpl
