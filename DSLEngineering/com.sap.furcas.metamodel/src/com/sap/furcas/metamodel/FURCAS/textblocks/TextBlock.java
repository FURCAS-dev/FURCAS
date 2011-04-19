/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getType <em>Type</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getParentAltChoices <em>Parent Alt Choices</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getElementsInContext <em>Elements In Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getForEachExecutions <em>For Each Executions</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getCachedString <em>Cached String</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#isComplete <em>Complete</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getAdditionalTemplates <em>Additional Templates</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getCorrespondingModelElements <em>Corresponding Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock()
 * @model
 * @generated
 */
public interface TextBlock extends DocumentNode {
        /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Type</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(TextBlockDefinition)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_Type()
     * @model
     * @generated
     */
        TextBlockDefinition getType();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
        void setType(TextBlockDefinition value);

        /**
     * Returns the value of the '<em><b>Sub Nodes</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode}.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Sub Nodes</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Nodes</em>' containment reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_SubNodes()
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getParent
     * @model opposite="parent" containment="true" resolveProxies="true"
     * @generated
     */
        EList<DocumentNode> getSubNodes();

        /**
     * Returns the value of the '<em><b>Parent Alt Choices</b></em>' attribute list.
     * The list contents are of type {@link java.lang.Integer}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Parent Alt Choices</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Parent Alt Choices</em>' attribute list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_ParentAltChoices()
     * @model
     * @generated
     */
        EList<Integer> getParentAltChoices();

        /**
     * Returns the value of the '<em><b>Elements In Context</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Elements In Context</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Elements In Context</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_ElementsInContext()
     * @model
     * @generated
     */
        EList<EObject> getElementsInContext();

        /**
     * Returns the value of the '<em><b>For Each Executions</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>For Each Context</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>For Each Executions</em>' containment reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_ForEachExecutions()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
        EList<ForEachExecution> getForEachExecutions();

        /**
     * Returns the value of the '<em><b>Cached String</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Cached String</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Cached String</em>' attribute.
     * @see #setCachedString(String)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_CachedString()
     * @model
     * @generated
     */
        String getCachedString();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getCachedString <em>Cached String</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cached String</em>' attribute.
     * @see #getCachedString()
     * @generated
     */
        void setCachedString(String value);

        /**
     * Returns the value of the '<em><b>Complete</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Complete</em>' attribute.
     * @see #setComplete(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_Complete()
     * @model default="false" required="true"
     * @generated
     */
	boolean isComplete();

								/**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#isComplete <em>Complete</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Complete</em>' attribute.
     * @see #isComplete()
     * @generated
     */
	void setComplete(boolean value);

								/**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.subNodes->select(n | n.oclIsKindOf(TextBlock)).oclAsType(TextBlock)->asOrderedSet()'"
     * @generated
     */
        EList<TextBlock> getSubBlocks();

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.subNodes->select(n | n.oclIsKindOf(AbstractToken)).oclAsType(AbstractToken)->asOrderedSet()'"
     * @generated
     */
        EList<AbstractToken> getTokens();

        /**
     * Returns the value of the '<em><b>Additional Templates</b></em>' reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.Template}.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the value of the '<em>Additional Templates</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_AdditionalTemplates()
     * @model
     * @generated
     */
        EList<Template> getAdditionalTemplates();

        /**
     * Returns the value of the '<em><b>Corresponding Model Elements</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Corresponding Model Elements</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Corresponding Model Elements</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getTextBlock_CorrespondingModelElements()
     * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='correspondingDocumentNode'"
     * @generated
     */
    EList<EObject> getCorrespondingModelElements();

} // TextBlock
