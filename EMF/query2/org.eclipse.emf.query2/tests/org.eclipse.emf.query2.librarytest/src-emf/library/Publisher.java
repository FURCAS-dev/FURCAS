/**
 * <copyright>
 * </copyright>
 *
 * $Id: Publisher.java,v 1.1 2010/12/07 13:18:53 akrsharma Exp $
 */
package library;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Publisher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Publisher#getManuscripts <em>Manuscripts</em>}</li>
 *   <li>{@link library.Publisher#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getPublisher()
 * @model
 * @generated
 */
public interface Publisher extends EObject {
	/**
	 * Returns the value of the '<em><b>Manuscripts</b></em>' containment reference list.
	 * The list contents are of type {@link library.Manuscript}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manuscripts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manuscripts</em>' containment reference list.
	 * @see library.LibraryPackage#getPublisher_Manuscripts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Manuscript> getManuscripts();

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
	 * @see library.LibraryPackage#getPublisher_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link library.Publisher#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Publisher
