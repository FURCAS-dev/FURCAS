/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites;

import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.ecore.NavigationCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.oclwithhiddenopposites.OppositePropertyCallExp#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.emf.ocl.oclwithhiddenopposites.OclwithhiddenoppositesPackage#getOppositePropertyCallExp()
 * @model
 * @generated
 */
public interface OppositePropertyCallExp extends NavigationCallExp {
	/**
	 * Returns the value of the '<em><b>Referred Opposite Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Opposite Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #setReferredOppositeProperty(EReference)
	 * @see com.sap.emf.ocl.oclwithhiddenopposites.OclwithhiddenoppositesPackage#getOppositePropertyCallExp_ReferredOppositeProperty()
	 * @model
	 * @generated
	 */
	EReference getReferredOppositeProperty();

	/**
	 * Sets the value of the '{@link com.sap.emf.ocl.oclwithhiddenopposites.OppositePropertyCallExp#getReferredOppositeProperty <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #getReferredOppositeProperty()
	 * @generated
	 */
	void setReferredOppositeProperty(EReference value);

} // OppositePropertyCallExp
