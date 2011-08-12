/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lexed Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken#isOperator <em>Operator</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken#getReferencedElements <em>Referenced Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getLexedToken()
 * @model
 * @generated
 */
public interface LexedToken extends AbstractToken {
    /**
     * Returns the value of the '<em><b>Operator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operator</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operator</em>' attribute.
     * @see #setOperator(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getLexedToken_Operator()
     * @model
     * @generated
     */
    boolean isOperator();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken#isOperator <em>Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operator</em>' attribute.
     * @see #isOperator()
     * @generated
     */
    void setOperator(boolean value);

    /**
     * Returns the value of the '<em><b>Referenced Elements</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced Elements</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referenced Elements</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getLexedToken_ReferencedElements()
     * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='referencingDocumentNode'"
     * @generated
     */
    EList<EObject> getReferencedElements();

} // LexedToken
