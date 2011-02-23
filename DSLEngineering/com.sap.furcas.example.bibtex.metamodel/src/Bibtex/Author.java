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
 * A representation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Bibtex.Author#getName <em>Name</em>}</li>
 *   <li>{@link Bibtex.Author#getPublications <em>Publications</em>}</li>
 *   <li>{@link Bibtex.Author#getLiteraturedb <em>Literaturedb</em>}</li>
 * </ul>
 * </p>
 *
 * @see Bibtex.BibtexPackage#getAuthor()
 * @model
 * @generated
 */
public interface Author extends EObject {
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
     * @see Bibtex.BibtexPackage#getAuthor_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link Bibtex.Author#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Publications</b></em>' reference list.
     * The list contents are of type {@link Bibtex.Entry}.
     * It is bidirectional and its opposite is '{@link Bibtex.Entry#getAuthor <em>Author</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Publications</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Publications</em>' reference list.
     * @see Bibtex.BibtexPackage#getAuthor_Publications()
     * @see Bibtex.Entry#getAuthor
     * @model opposite="author"
     * @generated
     */
    EList<Entry> getPublications();

    /**
     * Returns the value of the '<em><b>Literaturedb</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Literaturedb</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Literaturedb</em>' reference.
     * @see #setLiteraturedb(LiteratureDb)
     * @see Bibtex.BibtexPackage#getAuthor_Literaturedb()
     * @model required="true"
     * @generated
     */
    LiteratureDb getLiteraturedb();

    /**
     * Sets the value of the '{@link Bibtex.Author#getLiteraturedb <em>Literaturedb</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Literaturedb</em>' reference.
     * @see #getLiteraturedb()
     * @generated
     */
    void setLiteraturedb(LiteratureDb value);

} // Author
