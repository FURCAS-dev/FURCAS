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
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockSequence <em>Block Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockArgs <em>Block Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends SequenceElement {
        /**
	 * Returns the value of the '<em><b>Block Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getBlockContainer <em>Block Container</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Block Sequence</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Sequence</em>' containment reference.
	 * @see #setBlockSequence(Sequence)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getBlock_BlockSequence()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getBlockContainer
	 * @model opposite="blockContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
        Sequence getBlockSequence();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockSequence <em>Block Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Sequence</em>' containment reference.
	 * @see #getBlockSequence()
	 * @generated
	 */
        void setBlockSequence(Sequence value);

        /**
	 * Returns the value of the '<em><b>Block Args</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.BlockArg}.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.BlockArg#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Block Args</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Args</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getBlock_BlockArgs()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.BlockArg#getBlock
	 * @model opposite="block" containment="true"
	 * @generated
	 */
        EList<BlockArg> getBlockArgs();

} // Block
