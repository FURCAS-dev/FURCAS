/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.Alternative#getSequences <em>Sequences</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.Alternative#isIsMulti <em>Is Multi</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getAlternative()
 * @model
 * @generated
 */
public interface Alternative extends SequenceElement {
	/**
	 * Returns the value of the '<em><b>Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.SequenceInAlternative}.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.SequenceInAlternative#getAlternativeContainer <em>Alternative Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequences</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getAlternative_Sequences()
	 * @see com.sap.furcas.metamodel.TCS.SequenceInAlternative#getAlternativeContainer
	 * @model opposite="alternativeContainer" containment="true" lower="2"
	 * @generated
	 */
	EList<SequenceInAlternative> getSequences();

	/**
	 * Returns the value of the '<em><b>Is Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Multi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Multi</em>' attribute.
	 * @see #setIsMulti(boolean)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getAlternative_IsMulti()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsMulti();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.Alternative#isIsMulti <em>Is Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Multi</em>' attribute.
	 * @see #isIsMulti()
	 * @generated
	 */
	void setIsMulti(boolean value);

} // Alternative
