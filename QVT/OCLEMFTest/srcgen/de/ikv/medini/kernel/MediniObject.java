/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.kernel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Medini Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.kernel.MediniObject#getMediniIdentifier <em>Medini Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.kernel.KernelPackage#getMediniObject()
 * @model abstract="true"
 * @generated
 */
public interface MediniObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Medini Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Medini Identifier</em>' attribute.
	 * @see #setMediniIdentifier(String)
	 * @see de.ikv.medini.kernel.KernelPackage#getMediniObject_MediniIdentifier()
	 * @model id="true" required="true" ordered="false"
	 * @generated
	 */
	String getMediniIdentifier();

	/**
	 * Sets the value of the '{@link de.ikv.medini.kernel.MediniObject#getMediniIdentifier <em>Medini Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Medini Identifier</em>' attribute.
	 * @see #getMediniIdentifier()
	 * @generated
	 */
	void setMediniIdentifier(String value);

} // MediniObject