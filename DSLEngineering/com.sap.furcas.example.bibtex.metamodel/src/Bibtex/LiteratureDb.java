/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Bibtex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literature Db</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Bibtex.LiteratureDb#getAuthor <em>Author</em>}</li>
 *   <li>{@link Bibtex.LiteratureDb#getEntries <em>Entries</em>}</li>
 *   <li>{@link Bibtex.LiteratureDb#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see Bibtex.BibtexPackage#getLiteratureDb()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL uniqueName='LiteratureDb.allInstances().name.entries->select(db | db.name = self.name)->size() = 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='uniqueName'"
 * @generated
 */
public interface LiteratureDb extends EObject {
    /**
     * Returns the value of the '<em><b>Author</b></em>' containment reference list.
     * The list contents are of type {@link Bibtex.Author}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Author</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Author</em>' containment reference list.
     * @see Bibtex.BibtexPackage#getLiteratureDb_Author()
     * @model containment="true"
     * @generated
     */
    EList<Author> getAuthor();

    /**
     * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
     * The list contents are of type {@link Bibtex.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entries</em>' containment reference list.
     * @see Bibtex.BibtexPackage#getLiteratureDb_Entries()
     * @model containment="true"
     * @generated
     */
    EList<Entry> getEntries();

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
     * @see Bibtex.BibtexPackage#getLiteratureDb_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link Bibtex.LiteratureDb#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // LiteratureDb
