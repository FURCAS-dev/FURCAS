/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generalizable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#isIsRoot <em>Is Root</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#isIsLeaf <em>Is Leaf</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#getSupertypes <em>Supertypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getGeneralizableElement()
 * @model abstract="true"
 * @generated
 */
public interface GeneralizableElement extends Namespace {
	/**
	 * Returns the value of the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Root</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Root</em>' attribute.
	 * @see #setIsRoot(boolean)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getGeneralizableElement_IsRoot()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsRoot();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#isIsRoot <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Root</em>' attribute.
	 * @see #isIsRoot()
	 * @generated
	 */
	void setIsRoot(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Leaf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Leaf</em>' attribute.
	 * @see #setIsLeaf(boolean)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getGeneralizableElement_IsLeaf()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsLeaf();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#isIsLeaf <em>Is Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Leaf</em>' attribute.
	 * @see #isIsLeaf()
	 * @generated
	 */
	void setIsLeaf(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getGeneralizableElement_IsAbstract()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

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
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getGeneralizableElement_Visibility()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	VisibilityKind getVisibility();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see com.sap.tc.moin.repository.mmi.Model.VisibilityKind
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityKind value);

	/**
	 * Returns the value of the '<em><b>Supertypes</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supertypes</em>' reference list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getGeneralizableElement_Supertypes()
	 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Generalizes' metaObjectMofId='45ED2E29EBEA040675924D782BC3C9E3F7C65DCA' storedEnd='1' compositeEnd='-1' orderedEnd='0' exposedEndNumber='1'"
	 * @generated
	 */
	EList<GeneralizableElement> getSupertypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<GeneralizableElement> allSupertypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" nameUnique="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	ModelElement lookupElementExtended(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ofTypeUnique="false" ofTypeRequired="true" ofTypeOrdered="false" includeSubtypesUnique="false" includeSubtypesRequired="true" includeSubtypesOrdered="false"
	 * @generated
	 */
	EList<ModelElement> findElementsByTypeExtended(com.sap.tc.moin.repository.mmi.Model.Class ofType, boolean includeSubtypes);

} // GeneralizableElement
