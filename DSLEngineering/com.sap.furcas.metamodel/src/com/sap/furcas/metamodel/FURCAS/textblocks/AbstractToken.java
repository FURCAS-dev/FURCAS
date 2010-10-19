/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getValue <em>Value</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getLookahead <em>Lookahead</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getLookback <em>Lookback</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getState <em>State</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getAbstractToken()
 * @model
 * @generated
 */
public interface AbstractToken extends DocumentNode {
        /**
         * Returns the value of the '<em><b>Value</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Value</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Value</em>' attribute.
         * @see #setValue(String)
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getAbstractToken_Value()
         * @model
         * @generated
         */
        String getValue();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getValue <em>Value</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Value</em>' attribute.
         * @see #getValue()
         * @generated
         */
        void setValue(String value);

        /**
         * Returns the value of the '<em><b>Lookahead</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Lookahead</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Lookahead</em>' attribute.
         * @see #setLookahead(int)
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getAbstractToken_Lookahead()
         * @model
         * @generated
         */
        int getLookahead();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getLookahead <em>Lookahead</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Lookahead</em>' attribute.
         * @see #getLookahead()
         * @generated
         */
        void setLookahead(int value);

        /**
         * Returns the value of the '<em><b>Lookback</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Lookback</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Lookback</em>' attribute.
         * @see #setLookback(int)
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getAbstractToken_Lookback()
         * @model
         * @generated
         */
        int getLookback();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getLookback <em>Lookback</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Lookback</em>' attribute.
         * @see #getLookback()
         * @generated
         */
        void setLookback(int value);

        /**
         * Returns the value of the '<em><b>State</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>State</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>State</em>' attribute.
         * @see #setState(int)
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getAbstractToken_State()
         * @model
         * @generated
         */
        int getState();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getState <em>State</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>State</em>' attribute.
         * @see #getState()
         * @generated
         */
        void setState(int value);

        /**
         * Returns the value of the '<em><b>Type</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Type</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Type</em>' attribute.
         * @see #setType(int)
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getAbstractToken_Type()
         * @model
         * @generated
         */
        int getType();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken#getType <em>Type</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Type</em>' attribute.
         * @see #getType()
         * @generated
         */
        void setType(int value);

} // AbstractToken
