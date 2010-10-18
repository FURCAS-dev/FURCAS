/**
 * <copyright>
 * </copyright>
 *
 * $Id: Book.java,v 1.1 2009/10/08 15:02:51 bkolb Exp $
 */
package library;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Book#getBorrowedBy <em>Borrowed By</em>}</li>
 *   <li>{@link library.Book#getInstanceOf <em>Instance Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends EObject {
	/**
	 * Returns the value of the '<em><b>Borrowed By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Borrowed By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Borrowed By</em>' reference.
	 * @see #setBorrowedBy(Person)
	 * @see library.LibraryPackage#getBook_BorrowedBy()
	 * @model
	 * @generated
	 */
	Person getBorrowedBy();

	/**
	 * Sets the value of the '{@link library.Book#getBorrowedBy <em>Borrowed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Borrowed By</em>' reference.
	 * @see #getBorrowedBy()
	 * @generated
	 */
	void setBorrowedBy(Person value);

	/**
	 * Returns the value of the '<em><b>Instance Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Of</em>' reference.
	 * @see #setInstanceOf(Manuscript)
	 * @see library.LibraryPackage#getBook_InstanceOf()
	 * @model required="true"
	 * @generated
	 */
	Manuscript getInstanceOf();

	/**
	 * Sets the value of the '{@link library.Book#getInstanceOf <em>Instance Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Of</em>' reference.
	 * @see #getInstanceOf()
	 * @generated
	 */
	void setInstanceOf(Manuscript value);

} // Book
