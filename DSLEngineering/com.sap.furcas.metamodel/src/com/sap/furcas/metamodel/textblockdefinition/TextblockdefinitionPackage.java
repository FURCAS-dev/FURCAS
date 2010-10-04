/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblockdefinition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.textblockdefinition.TextblockdefinitionFactory
 * @model kind="package"
 * @generated
 */
public interface TextblockdefinitionPackage extends EPackage {
        /**
         * The package name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNAME = "textblockdefinition";

        /**
         * The package namespace URI.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNS_URI = "http://www.furcas.org/textblockdefinition";

        /**
         * The package namespace name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNS_PREFIX = "com.sap.furcas.textblockdefinition";

        /**
         * The singleton instance of the package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        TextblockdefinitionPackage eINSTANCE = com.sap.furcas.metamodel.textblockdefinition.impl.TextblockdefinitionPackageImpl.init();

        /**
         * The meta object id for the '{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl <em>Textblock Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl
         * @see com.sap.furcas.metamodel.textblockdefinition.impl.TextblockdefinitionPackageImpl#getTextblockDefinition()
         * @generated
         */
        int TEXTBLOCK_DEFINITION = 0;

        /**
         * The feature id for the '<em><b>Format Policy</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION__FORMAT_POLICY = 0;

        /**
         * The feature id for the '<em><b>Default Template</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE = 1;

        /**
         * The feature id for the '<em><b>Parse Rule</b></em>' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION__PARSE_RULE = 2;

        /**
         * The feature id for the '<em><b>Context</b></em>' container reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION__CONTEXT = 3;

        /**
         * The feature id for the '<em><b>Sub Definitions</b></em>' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION__SUB_DEFINITIONS = 4;

        /**
         * The feature id for the '<em><b>Generalisation</b></em>' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION__GENERALISATION = 5;

        /**
         * The feature id for the '<em><b>Name</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION__NAME = 6;

        /**
         * The number of structural features of the '<em>Textblock Definition</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int TEXTBLOCK_DEFINITION_FEATURE_COUNT = 7;

        /**
         * The meta object id for the '{@link com.sap.furcas.metamodel.textblockdefinition.FormatPolicy <em>Format Policy</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.textblockdefinition.FormatPolicy
         * @see com.sap.furcas.metamodel.textblockdefinition.impl.TextblockdefinitionPackageImpl#getFormatPolicy()
         * @generated
         */
        int FORMAT_POLICY = 1;


        /**
         * Returns the meta object for class '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition <em>Textblock Definition</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for class '<em>Textblock Definition</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition
         * @generated
         */
        EClass getTextblockDefinition();

        /**
         * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getFormatPolicy <em>Format Policy</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the attribute '<em>Format Policy</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getFormatPolicy()
         * @see #getTextblockDefinition()
         * @generated
         */
        EAttribute getTextblockDefinition_FormatPolicy();

        /**
         * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getDefaultTemplate <em>Default Template</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the attribute '<em>Default Template</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getDefaultTemplate()
         * @see #getTextblockDefinition()
         * @generated
         */
        EAttribute getTextblockDefinition_DefaultTemplate();

        /**
         * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getParseRule <em>Parse Rule</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the reference '<em>Parse Rule</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getParseRule()
         * @see #getTextblockDefinition()
         * @generated
         */
        EReference getTextblockDefinition_ParseRule();

        /**
         * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getContext <em>Context</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the container reference '<em>Context</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getContext()
         * @see #getTextblockDefinition()
         * @generated
         */
        EReference getTextblockDefinition_Context();

        /**
         * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getSubDefinitions <em>Sub Definitions</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the containment reference list '<em>Sub Definitions</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getSubDefinitions()
         * @see #getTextblockDefinition()
         * @generated
         */
        EReference getTextblockDefinition_SubDefinitions();

        /**
         * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getGeneralisation <em>Generalisation</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the reference '<em>Generalisation</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getGeneralisation()
         * @see #getTextblockDefinition()
         * @generated
         */
        EReference getTextblockDefinition_Generalisation();

        /**
         * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getName <em>Name</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the attribute '<em>Name</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition#getName()
         * @see #getTextblockDefinition()
         * @generated
         */
        EAttribute getTextblockDefinition_Name();

        /**
         * Returns the meta object for enum '{@link com.sap.furcas.metamodel.textblockdefinition.FormatPolicy <em>Format Policy</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for enum '<em>Format Policy</em>'.
         * @see com.sap.furcas.metamodel.textblockdefinition.FormatPolicy
         * @generated
         */
        EEnum getFormatPolicy();

        /**
         * Returns the factory that creates the instances of the model.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the factory that creates the instances of the model.
         * @generated
         */
        TextblockdefinitionFactory getTextblockdefinitionFactory();

        /**
         * <!-- begin-user-doc -->
         * Defines literals for the meta objects that represent
         * <ul>
         *   <li>each class,</li>
         *   <li>each feature of each class,</li>
         *   <li>each enum,</li>
         *   <li>and each data type</li>
         * </ul>
         * <!-- end-user-doc -->
         * @generated
         */
        interface Literals {
                /**
                 * The meta object literal for the '{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl <em>Textblock Definition</em>}' class.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl
                 * @see com.sap.furcas.metamodel.textblockdefinition.impl.TextblockdefinitionPackageImpl#getTextblockDefinition()
                 * @generated
                 */
                EClass TEXTBLOCK_DEFINITION = eINSTANCE.getTextblockDefinition();

                /**
                 * The meta object literal for the '<em><b>Format Policy</b></em>' attribute feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EAttribute TEXTBLOCK_DEFINITION__FORMAT_POLICY = eINSTANCE.getTextblockDefinition_FormatPolicy();

                /**
                 * The meta object literal for the '<em><b>Default Template</b></em>' attribute feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EAttribute TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE = eINSTANCE.getTextblockDefinition_DefaultTemplate();

                /**
                 * The meta object literal for the '<em><b>Parse Rule</b></em>' reference feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference TEXTBLOCK_DEFINITION__PARSE_RULE = eINSTANCE.getTextblockDefinition_ParseRule();

                /**
                 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference TEXTBLOCK_DEFINITION__CONTEXT = eINSTANCE.getTextblockDefinition_Context();

                /**
                 * The meta object literal for the '<em><b>Sub Definitions</b></em>' containment reference list feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference TEXTBLOCK_DEFINITION__SUB_DEFINITIONS = eINSTANCE.getTextblockDefinition_SubDefinitions();

                /**
                 * The meta object literal for the '<em><b>Generalisation</b></em>' reference feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference TEXTBLOCK_DEFINITION__GENERALISATION = eINSTANCE.getTextblockDefinition_Generalisation();

                /**
                 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EAttribute TEXTBLOCK_DEFINITION__NAME = eINSTANCE.getTextblockDefinition_Name();

                /**
                 * The meta object literal for the '{@link com.sap.furcas.metamodel.textblockdefinition.FormatPolicy <em>Format Policy</em>}' enum.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see com.sap.furcas.metamodel.textblockdefinition.FormatPolicy
                 * @see com.sap.furcas.metamodel.textblockdefinition.impl.TextblockdefinitionPackageImpl#getFormatPolicy()
                 * @generated
                 */
                EEnum FORMAT_POLICY = eINSTANCE.getFormatPolicy();

        }

} //TextblockdefinitionPackage
