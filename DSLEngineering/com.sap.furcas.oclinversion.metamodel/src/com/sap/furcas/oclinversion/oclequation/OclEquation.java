/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.oclequation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.oclinversion.oclequation.OclEquation#getLeft <em>Left</em>}</li>
 *   <li>{@link com.sap.furcas.oclinversion.oclequation.OclEquation#getRight <em>Right</em>}</li>
 *   <li>{@link com.sap.furcas.oclinversion.oclequation.OclEquation#isIsSource <em>Is Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.oclinversion.oclequation.OclequationPackage#getOclEquation()
 * @model
 * @generated
 */
public interface OclEquation extends EObject {
    /**
     * Returns the value of the '<em><b>Left</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Left</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Left</em>' containment reference.
     * @see #setLeft(OCLExpression)
     * @see com.sap.furcas.oclinversion.oclequation.OclequationPackage#getOclEquation_Left()
     * @model containment="true" required="true"
     * @generated
     */
    OCLExpression getLeft();

    /**
     * Sets the value of the '{@link com.sap.furcas.oclinversion.oclequation.OclEquation#getLeft <em>Left</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left</em>' containment reference.
     * @see #getLeft()
     * @generated
     */
    void setLeft(OCLExpression value);

    /**
     * Returns the value of the '<em><b>Right</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Right</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Right</em>' containment reference.
     * @see #setRight(OCLExpression)
     * @see com.sap.furcas.oclinversion.oclequation.OclequationPackage#getOclEquation_Right()
     * @model containment="true" required="true"
     * @generated
     */
    OCLExpression getRight();

    /**
     * Sets the value of the '{@link com.sap.furcas.oclinversion.oclequation.OclEquation#getRight <em>Right</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right</em>' containment reference.
     * @see #getRight()
     * @generated
     */
    void setRight(OCLExpression value);

    /**
     * Returns the value of the '<em><b>Is Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Source</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Source</em>' attribute.
     * @see #setIsSource(boolean)
     * @see com.sap.furcas.oclinversion.oclequation.OclequationPackage#getOclEquation_IsSource()
     * @model
     * @generated
     */
    boolean isIsSource();

    /**
     * Sets the value of the '{@link com.sap.furcas.oclinversion.oclequation.OclEquation#isIsSource <em>Is Source</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Source</em>' attribute.
     * @see #isIsSource()
     * @generated
     */
    void setIsSource(boolean value);

} // OclEquation
