/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getName <em>Name</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getRequiredElements <em>Required Elements</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getContainer <em>Container</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getModelElement_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getModelElement_QualifiedName()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<String> getQualifiedName();

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' attribute.
	 * @see #setAnnotation(String)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getModelElement_Annotation()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getAnnotation();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getAnnotation <em>Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' attribute.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Required Elements</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Elements</em>' reference list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getModelElement_RequiredElements()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.DependsOn' metaObjectMofId='45ED2E2942C3DA8923564C501065F240D01C18FB' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<ModelElement> getRequiredElements();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.sap.tc.moin.repository.mmi.Model.Namespace#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Namespace)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getModelElement_Container()
	 * @see com.sap.tc.moin.repository.mmi.Model.Namespace#getContents
	 * @model opposite="contents" transient="false" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Contains' metaObjectMofId='45ED2E29A15C5D7FDF8D483F1CFA93E430ADEDCC' storedEnd='0' compositeEnd='0' orderedEnd='1' exposedEndNumber='1'"
	 * @generated
	 */
	Namespace getContainer();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Namespace value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.Constraint}.
	 * It is bidirectional and its opposite is '{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getConstrainedElements <em>Constrained Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getModelElement_Constraints()
	 * @see com.sap.tc.moin.repository.mmi.Model.Constraint#getConstrainedElements
	 * @model opposite="constrainedElements" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Constrains' metaObjectMofId='45ED2E290BBB4E28BAC041E52E7FE0AD24662FFD' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" kindsRequired="true" kindsMany="true" kindsOrdered="false" recursiveUnique="false" recursiveRequired="true" recursiveOrdered="false"
	 * @generated
	 */
	EList<ModelElement> findRequiredElements(EList<String> kinds, boolean recursive);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" otherElementUnique="false" otherElementRequired="true" otherElementOrdered="false" reasonUnique="false" reasonRequired="true" reasonOrdered="false"
	 * @generated
	 */
	boolean isRequiredBecause(ModelElement otherElement, String reason);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isFrozen();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" otherElementUnique="false" otherElementRequired="true" otherElementOrdered="false"
	 * @generated
	 */
	boolean isVisible(ModelElement otherElement);

} // ModelElement
