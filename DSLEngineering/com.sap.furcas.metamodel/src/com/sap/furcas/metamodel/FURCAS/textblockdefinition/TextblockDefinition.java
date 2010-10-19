/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Textblock Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getFormatPolicy <em>Format Policy</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getDefaultTemplate <em>Default Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getParseRule <em>Parse Rule</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getContext <em>Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getSubDefinitions <em>Sub Definitions</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getGeneralisation <em>Generalisation</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition()
 * @model
 * @generated
 */
public interface TextblockDefinition extends EObject {
        /**
         * Returns the value of the '<em><b>Format Policy</b></em>' attribute.
         * The default value is <code>""</code>.
         * The literals are from the enumeration {@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Format Policy</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Format Policy</em>' attribute.
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy
         * @see #setFormatPolicy(FormatPolicy)
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition_FormatPolicy()
         * @model default=""
         * @generated
         */
        FormatPolicy getFormatPolicy();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getFormatPolicy <em>Format Policy</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Format Policy</em>' attribute.
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy
         * @see #getFormatPolicy()
         * @generated
         */
        void setFormatPolicy(FormatPolicy value);

        /**
         * Returns the value of the '<em><b>Default Template</b></em>' attribute.
         * The default value is <code>""</code>.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Default Template</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Default Template</em>' attribute.
         * @see #setDefaultTemplate(String)
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition_DefaultTemplate()
         * @model default=""
         * @generated
         */
        String getDefaultTemplate();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getDefaultTemplate <em>Default Template</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Default Template</em>' attribute.
         * @see #getDefaultTemplate()
         * @generated
         */
        void setDefaultTemplate(String value);

        /**
         * Returns the value of the '<em><b>Parse Rule</b></em>' reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Parse Rule</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Parse Rule</em>' reference.
         * @see #setParseRule(Template)
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition_ParseRule()
         * @model
         * @generated
         */
        Template getParseRule();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getParseRule <em>Parse Rule</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Parse Rule</em>' reference.
         * @see #getParseRule()
         * @generated
         */
        void setParseRule(Template value);

        /**
         * Returns the value of the '<em><b>Context</b></em>' container reference.
         * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getSubDefinitions <em>Sub Definitions</em>}'.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Context</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Context</em>' container reference.
         * @see #setContext(TextblockDefinition)
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition_Context()
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getSubDefinitions
         * @model opposite="subDefinitions" transient="false"
         * @generated
         */
        TextblockDefinition getContext();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getContext <em>Context</em>}' container reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Context</em>' container reference.
         * @see #getContext()
         * @generated
         */
        void setContext(TextblockDefinition value);

        /**
         * Returns the value of the '<em><b>Sub Definitions</b></em>' containment reference list.
         * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition}.
         * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getContext <em>Context</em>}'.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Sub Definitions</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Sub Definitions</em>' containment reference list.
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition_SubDefinitions()
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getContext
         * @model opposite="context" containment="true"
         * @generated
         */
        EList<TextblockDefinition> getSubDefinitions();

        /**
         * Returns the value of the '<em><b>Generalisation</b></em>' reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Generalisation</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Generalisation</em>' reference.
         * @see #setGeneralisation(TextblockDefinition)
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition_Generalisation()
         * @model
         * @generated
         */
        TextblockDefinition getGeneralisation();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getGeneralisation <em>Generalisation</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Generalisation</em>' reference.
         * @see #getGeneralisation()
         * @generated
         */
        void setGeneralisation(TextblockDefinition value);

        /**
         * Returns the value of the '<em><b>Name</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Name</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Name</em>' attribute.
         * @see #setName(String)
         * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getTextblockDefinition_Name()
         * @model
         * @generated
         */
        String getName();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockDefinition#getName <em>Name</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Name</em>' attribute.
         * @see #getName()
         * @generated
         */
        void setName(String value);

} // TextblockDefinition
