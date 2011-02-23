/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapClassImplementationAnnotation.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package abapmapping;

import abapmapping.abapdictionary.AbapType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Class Implementation Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.AbapClassImplementationAnnotation#getKind <em>Kind</em>}</li>
 *   <li>{@link abapmapping.AbapClassImplementationAnnotation#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.AbapmappingPackage#getAbapClassImplementationAnnotation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL AbapTypeMustBeUnstructured='self.kind = AbapClassKind::ABAP_TYPE implies\r\n    self.abapType.oclIsKindOf(abapmapping::abapdictionary::UnstructuredAbapType)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AbapTypeMustBeUnstructured'"
 * @generated
 */
public interface AbapClassImplementationAnnotation extends EObject {
	/**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link abapmapping.AbapClassKind}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see abapmapping.AbapClassKind
     * @see #setKind(AbapClassKind)
     * @see abapmapping.AbapmappingPackage#getAbapClassImplementationAnnotation_Kind()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	AbapClassKind getKind();

	/**
     * Sets the value of the '{@link abapmapping.AbapClassImplementationAnnotation#getKind <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kind</em>' attribute.
     * @see abapmapping.AbapClassKind
     * @see #getKind()
     * @generated
     */
	void setKind(AbapClassKind value);

	/**
     * Returns the value of the '<em><b>Abap Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abap Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abap Type</em>' reference.
     * @see #setAbapType(AbapType)
     * @see abapmapping.AbapmappingPackage#getAbapClassImplementationAnnotation_AbapType()
     * @model required="true"
     * @generated
     */
	AbapType getAbapType();

	/**
     * Sets the value of the '{@link abapmapping.AbapClassImplementationAnnotation#getAbapType <em>Abap Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abap Type</em>' reference.
     * @see #getAbapType()
     * @generated
     */
	void setAbapType(AbapType value);

} // AbapClassImplementationAnnotation
