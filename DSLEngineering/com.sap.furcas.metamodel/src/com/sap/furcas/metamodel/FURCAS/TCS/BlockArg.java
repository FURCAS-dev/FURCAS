/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Arg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.BlockArg#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getBlockArg()
 * @model abstract="true"
 * @generated
 */
public interface BlockArg extends LocatedElement {
        /**
     * Returns the value of the '<em><b>Block</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockArgs <em>Block Args</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Block</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Block</em>' container reference.
     * @see #setBlock(Block)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getBlockArg_Block()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockArgs
     * @model opposite="blockArgs" required="true" transient="false" ordered="false"
     * @generated
     */
        Block getBlock();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.BlockArg#getBlock <em>Block</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Block</em>' container reference.
     * @see #getBlock()
     * @generated
     */
        void setBlock(Block value);

} // BlockArg
