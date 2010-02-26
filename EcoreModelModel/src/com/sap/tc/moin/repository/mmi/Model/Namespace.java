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
 * A representation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Namespace#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getNamespace()
 * @model abstract="true"
 * @generated
 */
public interface Namespace extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.ModelElement}.
	 * It is bidirectional and its opposite is '{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getNamespace_Contents()
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelElement#getContainer
	 * @model opposite="container" containment="true"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Contains' metaObjectMofId='45ED2E29A15C5D7FDF8D483F1CFA93E430ADEDCC' storedEnd='0' compositeEnd='0' orderedEnd='1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<ModelElement> getContents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" ordered="false" nameUnique="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	ModelElement lookupElement(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" qualifiedNameUnique="false" qualifiedNameRequired="true" qualifiedNameMany="true"
	 * @generated
	 */
	ModelElement resolveQualifiedName(EList<String> qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ofTypeUnique="false" ofTypeRequired="true" ofTypeOrdered="false" includeSubtypesUnique="false" includeSubtypesRequired="true" includeSubtypesOrdered="false"
	 * @generated
	 */
	EList<ModelElement> findElementsByType(com.sap.tc.moin.repository.mmi.Model.Class ofType, boolean includeSubtypes);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" proposedNameUnique="false" proposedNameRequired="true" proposedNameOrdered="false"
	 * @generated
	 */
	boolean nameIsValid(String proposedName);

} // Namespace
