/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElements <em>Elements</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getTemplateContainer <em>Template Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getPrefixContainer <em>Prefix Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getFunctionContainer <em>Function Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getBlockContainer <em>Block Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getThenContainer <em>Then Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElseContainer <em>Else Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getSeparatorContainer <em>Separator Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getOtContainer <em>Ot Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends LocatedElement {
        /**
     * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement}.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement#getElementSequence <em>Element Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Elements</em>' containment reference list.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_Elements()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement#getElementSequence
     * @model opposite="elementSequence" containment="true"
     * @generated
     */
        EList<SequenceElement> getElements();

        /**
     * Returns the value of the '<em><b>Template Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getTemplateSequence <em>Template Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Template Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Template Container</em>' container reference.
     * @see #setTemplateContainer(ClassTemplate)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_TemplateContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getTemplateSequence
     * @model opposite="templateSequence" transient="false" ordered="false"
     * @generated
     */
        ClassTemplate getTemplateContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getTemplateContainer <em>Template Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Template Container</em>' container reference.
     * @see #getTemplateContainer()
     * @generated
     */
        void setTemplateContainer(ClassTemplate value);

        /**
     * Returns the value of the '<em><b>Prefix Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getPrefixSequence <em>Prefix Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Prefix Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Prefix Container</em>' container reference.
     * @see #setPrefixContainer(ClassTemplate)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_PrefixContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getPrefixSequence
     * @model opposite="prefixSequence" transient="false" ordered="false"
     * @generated
     */
        ClassTemplate getPrefixContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getPrefixContainer <em>Prefix Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prefix Container</em>' container reference.
     * @see #getPrefixContainer()
     * @generated
     */
        void setPrefixContainer(ClassTemplate value);

        /**
     * Returns the value of the '<em><b>Function Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionSequence <em>Function Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Function Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Function Container</em>' container reference.
     * @see #setFunctionContainer(FunctionTemplate)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_FunctionContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionSequence
     * @model opposite="functionSequence" transient="false" ordered="false"
     * @generated
     */
        FunctionTemplate getFunctionContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getFunctionContainer <em>Function Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Function Container</em>' container reference.
     * @see #getFunctionContainer()
     * @generated
     */
        void setFunctionContainer(FunctionTemplate value);

        /**
     * Returns the value of the '<em><b>Block Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockSequence <em>Block Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Block Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Block Container</em>' container reference.
     * @see #setBlockContainer(Block)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_BlockContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockSequence
     * @model opposite="blockSequence" transient="false" ordered="false"
     * @generated
     */
        Block getBlockContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getBlockContainer <em>Block Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Block Container</em>' container reference.
     * @see #getBlockContainer()
     * @generated
     */
        void setBlockContainer(Block value);

        /**
     * Returns the value of the '<em><b>Then Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getThenSequence <em>Then Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Then Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Then Container</em>' container reference.
     * @see #setThenContainer(ConditionalElement)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_ThenContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getThenSequence
     * @model opposite="thenSequence" transient="false" ordered="false"
     * @generated
     */
        ConditionalElement getThenContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getThenContainer <em>Then Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Then Container</em>' container reference.
     * @see #getThenContainer()
     * @generated
     */
        void setThenContainer(ConditionalElement value);

        /**
     * Returns the value of the '<em><b>Else Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getElseSequence <em>Else Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Else Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Else Container</em>' container reference.
     * @see #setElseContainer(ConditionalElement)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_ElseContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getElseSequence
     * @model opposite="elseSequence" transient="false" ordered="false"
     * @generated
     */
        ConditionalElement getElseContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElseContainer <em>Else Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Else Container</em>' container reference.
     * @see #getElseContainer()
     * @generated
     */
        void setElseContainer(ConditionalElement value);

        /**
     * Returns the value of the '<em><b>Separator Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg#getSeparatorSequence <em>Separator Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Separator Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Separator Container</em>' container reference.
     * @see #setSeparatorContainer(SeparatorPArg)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_SeparatorContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg#getSeparatorSequence
     * @model opposite="separatorSequence" transient="false" ordered="false"
     * @generated
     */
        SeparatorPArg getSeparatorContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getSeparatorContainer <em>Separator Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Separator Container</em>' container reference.
     * @see #getSeparatorContainer()
     * @generated
     */
        void setSeparatorContainer(SeparatorPArg value);

        /**
     * Returns the value of the '<em><b>Ot Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getOtSequence <em>Ot Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Ot Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Ot Container</em>' container reference.
     * @see #setOtContainer(OperatorTemplate)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequence_OtContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getOtSequence
     * @model opposite="otSequence" transient="false" ordered="false"
     * @generated
     */
        OperatorTemplate getOtContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getOtContainer <em>Ot Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ot Container</em>' container reference.
     * @see #getOtContainer()
     * @generated
     */
        void setOtContainer(OperatorTemplate value);

} // Sequence
