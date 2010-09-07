/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks;

import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getType <em>Type</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getParentAltChoices <em>Parent Alt Choices</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getElementsInContext <em>Elements In Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getForEachContext <em>For Each Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getCachedString <em>Cached String</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock()
 * @model abstract="true"
 * @generated
 */
public interface TextBlock extends DocumentNode {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="de.hpi.sam.bp2009.OCL body='self.subNodes->select(n | n.oclIsTypeOf(AbstractToken)).oclAsType(OrderedSet(AbstractToken))'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	EList<AbstractToken> getTokens();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='self.subNodes->select(n | n.oclIsTypeOf(TextBlock)).oclAsType(OrderedSet(TextBlock))'"
	 * @generated
	 */
	EList<Template> getAdditionalTemplates();

	/**
	 * Returns the value of the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.textblocks.DocumentNode}.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.textblocks.DocumentNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Nodes</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_SubNodes()
	 * @see com.sap.furcas.metamodel.textblocks.DocumentNode#getParent
	 * @model opposite="parent" containment="true" transient="true" derived="true"
	 * @generated
	 */
	EList<DocumentNode> getSubNodes();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(TextblockDefinition)
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_Type()
	 * @model
	 * @generated
	 */
	TextblockDefinition getType();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.textblocks.TextBlock#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TextblockDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Blocks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='self.subNodes->select(n | n.oclIsTypeOf(TextBlock)).oclAsType(OrderedSet(TextBlock))'"
	 * @generated
	 */
	EList<TextBlock> getSubBlocks();

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
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_ParentAltChoices()
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
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_ElementsInContext()
	 * @model
	 * @generated
	 */
	EList<EObject> getElementsInContext();

	/**
	 * Returns the value of the '<em><b>For Each Context</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.textblocks.ForEachContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Each Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Each Context</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_ForEachContext()
	 * @model containment="true"
	 * @generated
	 */
	EList<ForEachContext> getForEachContext();

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
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_CachedString()
	 * @model
	 * @generated
	 */
	String getCachedString();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.textblocks.TextBlock#getCachedString <em>Cached String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cached String</em>' attribute.
	 * @see #getCachedString()
	 * @generated
	 */
	void setCachedString(String value);

} // TextBlock
