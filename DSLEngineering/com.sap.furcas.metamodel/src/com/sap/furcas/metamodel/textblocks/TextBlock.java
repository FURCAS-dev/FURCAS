/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks;

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
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getStartRow <em>Start Row</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getEndRow <em>End Row</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getTokens <em>Tokens</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getType <em>Type</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getSubBlocks <em>Sub Blocks</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getParentAltChoices <em>Parent Alt Choices</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.TextBlock#getElementsInContext <em>Elements In Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock()
 * @model abstract="true"
 * @generated
 */
public interface TextBlock extends DocumentNode {
	/**
	 * Returns the value of the '<em><b>Start Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Row</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Row</em>' attribute.
	 * @see #setStartRow(int)
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_StartRow()
	 * @model
	 * @generated
	 */
	int getStartRow();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.textblocks.TextBlock#getStartRow <em>Start Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Row</em>' attribute.
	 * @see #getStartRow()
	 * @generated
	 */
	void setStartRow(int value);

	/**
	 * Returns the value of the '<em><b>Start Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Column</em>' attribute.
	 * @see #setStartColumn(int)
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_StartColumn()
	 * @model
	 * @generated
	 */
	int getStartColumn();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.textblocks.TextBlock#getStartColumn <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Column</em>' attribute.
	 * @see #getStartColumn()
	 * @generated
	 */
	void setStartColumn(int value);

	/**
	 * Returns the value of the '<em><b>End Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Row</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Row</em>' attribute.
	 * @see #setEndRow(int)
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_EndRow()
	 * @model
	 * @generated
	 */
	int getEndRow();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.textblocks.TextBlock#getEndRow <em>End Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Row</em>' attribute.
	 * @see #getEndRow()
	 * @generated
	 */
	void setEndRow(int value);

	/**
	 * Returns the value of the '<em><b>End Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Column</em>' attribute.
	 * @see #setEndColumn(int)
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_EndColumn()
	 * @model
	 * @generated
	 */
	int getEndColumn();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.textblocks.TextBlock#getEndColumn <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Column</em>' attribute.
	 * @see #getEndColumn()
	 * @generated
	 */
	void setEndColumn(int value);

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.textblocks.AbstractToken}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' reference list.
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_Tokens()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/ocl/examples/OCL derive='self.subNodes->(n | n.oclIsTypeOf(textblocks::TextBlock))'"
	 * @generated
	 */
	EList<AbstractToken> getTokens();

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
	 * @model opposite="parent" containment="true"
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
	 * Returns the value of the '<em><b>Sub Blocks</b></em>' reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.textblocks.TextBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Blocks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Blocks</em>' reference list.
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getTextBlock_SubBlocks()
	 * @model transient="true" derived="true"
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

} // TextBlock
