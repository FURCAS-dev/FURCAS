/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Feature#getScope <em>Scope</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Feature#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link com.sap.tc.moin.repository.mmi.Model.ScopeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.ScopeKind
	 * @see #setScope(ScopeKind)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getFeature_Scope()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ScopeKind getScope();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Feature#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.ScopeKind
	 * @see #getScope()
	 * @generated
	 */
	void setScope(ScopeKind value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link com.sap.tc.moin.repository.mmi.Model.VisibilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.VisibilityKind
	 * @see #setVisibility(VisibilityKind)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getFeature_Visibility()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	VisibilityKind getVisibility();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Feature#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.VisibilityKind
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityKind value);

} // Feature
