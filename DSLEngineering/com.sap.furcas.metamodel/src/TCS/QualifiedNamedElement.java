/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.QualifiedNamedElement#getNames <em>Names</em>}</li>
 *   <li>{@link TCS.QualifiedNamedElement#getMetaReference <em>Meta Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getQualifiedNamedElement()
 * @model
 * @generated
 */
public interface QualifiedNamedElement extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Names</em>' attribute list.
	 * @see TCS.TCSPackage#getQualifiedNamedElement_Names()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getNames();

	/**
	 * Returns the value of the '<em><b>Meta Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Reference</em>' reference.
	 * @see #setMetaReference(EClass)
	 * @see TCS.TCSPackage#getQualifiedNamedElement_MetaReference()
	 * @model
	 * @generated
	 */
	EClass getMetaReference();

	/**
	 * Sets the value of the '{@link TCS.QualifiedNamedElement#getMetaReference <em>Meta Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Reference</em>' reference.
	 * @see #getMetaReference()
	 * @generated
	 */
	void setMetaReference(EClass value);

} // QualifiedNamedElement
