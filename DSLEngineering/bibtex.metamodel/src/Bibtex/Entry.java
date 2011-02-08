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
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Bibtex.Entry#getTitle <em>Title</em>}</li>
 *   <li>{@link Bibtex.Entry#getId <em>Id</em>}</li>
 *   <li>{@link Bibtex.Entry#getAuthor <em>Author</em>}</li>
 *   <li>{@link Bibtex.Entry#getLiteraturedb <em>Literaturedb</em>}</li>
 * </ul>
 * </p>
 *
 * @see Bibtex.BibtexPackage#getEntry()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL uniqueID='self.literaturedb.entries->select(e | e.id = self.id)->size() = 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='uniqueID'"
 * @generated
 */
public interface Entry extends EObject {
    /**
     * Returns the value of the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Title</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Title</em>' attribute.
     * @see #setTitle(String)
     * @see Bibtex.BibtexPackage#getEntry_Title()
     * @model required="true"
     * @generated
     */
    String getTitle();

    /**
     * Sets the value of the '{@link Bibtex.Entry#getTitle <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Title</em>' attribute.
     * @see #getTitle()
     * @generated
     */
    void setTitle(String value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see Bibtex.BibtexPackage#getEntry_Id()
     * @model default="" required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link Bibtex.Entry#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Author</b></em>' reference list.
     * The list contents are of type {@link Bibtex.Author}.
     * It is bidirectional and its opposite is '{@link Bibtex.Author#getPublications <em>Publications</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Author</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Author</em>' reference list.
     * @see Bibtex.BibtexPackage#getEntry_Author()
     * @see Bibtex.Author#getPublications
     * @model opposite="publications"
     * @generated
     */
    EList<Author> getAuthor();

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
     * @see Bibtex.BibtexPackage#getEntry_Literaturedb()
     * @model required="true"
     * @generated
     */
    LiteratureDb getLiteraturedb();

    /**
     * Sets the value of the '{@link Bibtex.Entry#getLiteraturedb <em>Literaturedb</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Literaturedb</em>' reference.
     * @see #getLiteraturedb()
     * @generated
     */
    void setLiteraturedb(LiteratureDb value);

} // Entry
