/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition;

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
 * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionFactory
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
        TextblockdefinitionPackage eINSTANCE = com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl.init();

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl <em>Text Block Definition</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl#getTextBlockDefinition()
     * @generated
     */
        int TEXT_BLOCK_DEFINITION = 0;

        /**
     * The feature id for the '<em><b>Format Policy</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION__FORMAT_POLICY = 0;

        /**
     * The feature id for the '<em><b>Default Template</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE = 1;

        /**
     * The feature id for the '<em><b>Parse Rule</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION__PARSE_RULE = 2;

        /**
     * The feature id for the '<em><b>Context</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION__CONTEXT = 3;

        /**
     * The feature id for the '<em><b>Sub Definitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS = 4;

        /**
     * The feature id for the '<em><b>Generalisation</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION__GENERALISATION = 5;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION__NAME = 6;

        /**
     * The number of structural features of the '<em>Text Block Definition</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEXT_BLOCK_DEFINITION_FEATURE_COUNT = 7;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy <em>Format Policy</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl#getFormatPolicy()
     * @generated
     */
        int FORMAT_POLICY = 1;


        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition <em>Text Block Definition</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Block Definition</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition
     * @generated
     */
        EClass getTextBlockDefinition();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getFormatPolicy <em>Format Policy</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format Policy</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getFormatPolicy()
     * @see #getTextBlockDefinition()
     * @generated
     */
        EAttribute getTextBlockDefinition_FormatPolicy();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getDefaultTemplate <em>Default Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getDefaultTemplate()
     * @see #getTextBlockDefinition()
     * @generated
     */
        EAttribute getTextBlockDefinition_DefaultTemplate();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getParseRule <em>Parse Rule</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parse Rule</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getParseRule()
     * @see #getTextBlockDefinition()
     * @generated
     */
        EReference getTextBlockDefinition_ParseRule();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Context</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getContext()
     * @see #getTextBlockDefinition()
     * @generated
     */
        EReference getTextBlockDefinition_Context();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getSubDefinitions <em>Sub Definitions</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sub Definitions</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getSubDefinitions()
     * @see #getTextBlockDefinition()
     * @generated
     */
        EReference getTextBlockDefinition_SubDefinitions();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getGeneralisation <em>Generalisation</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Generalisation</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getGeneralisation()
     * @see #getTextBlockDefinition()
     * @generated
     */
        EReference getTextBlockDefinition_Generalisation();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition#getName()
     * @see #getTextBlockDefinition()
     * @generated
     */
        EAttribute getTextBlockDefinition_Name();

        /**
     * Returns the meta object for enum '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy <em>Format Policy</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Format Policy</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy
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
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl <em>Text Block Definition</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl#getTextBlockDefinition()
         * @generated
         */
                EClass TEXT_BLOCK_DEFINITION = eINSTANCE.getTextBlockDefinition();

                /**
         * The meta object literal for the '<em><b>Format Policy</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute TEXT_BLOCK_DEFINITION__FORMAT_POLICY = eINSTANCE.getTextBlockDefinition_FormatPolicy();

                /**
         * The meta object literal for the '<em><b>Default Template</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE = eINSTANCE.getTextBlockDefinition_DefaultTemplate();

                /**
         * The meta object literal for the '<em><b>Parse Rule</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference TEXT_BLOCK_DEFINITION__PARSE_RULE = eINSTANCE.getTextBlockDefinition_ParseRule();

                /**
         * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference TEXT_BLOCK_DEFINITION__CONTEXT = eINSTANCE.getTextBlockDefinition_Context();

                /**
         * The meta object literal for the '<em><b>Sub Definitions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS = eINSTANCE.getTextBlockDefinition_SubDefinitions();

                /**
         * The meta object literal for the '<em><b>Generalisation</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference TEXT_BLOCK_DEFINITION__GENERALISATION = eINSTANCE.getTextBlockDefinition_Generalisation();

                /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute TEXT_BLOCK_DEFINITION__NAME = eINSTANCE.getTextBlockDefinition_Name();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy <em>Format Policy</em>}' enum.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl#getFormatPolicy()
         * @generated
         */
                EEnum FORMAT_POLICY = eINSTANCE.getFormatPolicy();

        }

} //TextblockdefinitionPackage
