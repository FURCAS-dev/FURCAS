/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase;

import org.oslo.ocl20.semantics.bridge.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Domain#isIsEnforcable <em>Is Enforcable</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Domain#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Checkable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Checkable</em>' attribute.
	 * @see #setIsCheckable(boolean)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getDomain_IsCheckable()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsCheckable();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Checkable</em>' attribute.
	 * @see #isIsCheckable()
	 * @generated
	 */
	void setIsCheckable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Enforcable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforcable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforcable</em>' attribute.
	 * @see #setIsEnforcable(boolean)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getDomain_IsEnforcable()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsEnforcable();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Domain#isIsEnforcable <em>Is Enforcable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforcable</em>' attribute.
	 * @see #isIsEnforcable()
	 * @generated
	 */
	void setIsEnforcable(boolean value);

	/**
	 * Returns the value of the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Model</em>' reference.
	 * @see #setTypedModel(TypedModel)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getDomain_TypedModel()
	 * @model
	 * @generated
	 */
	TypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Domain#getTypedModel <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Model</em>' reference.
	 * @see #getTypedModel()
	 * @generated
	 */
	void setTypedModel(TypedModel value);

} // Domain
