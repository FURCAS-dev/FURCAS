/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Bibtex;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Bibtex.BibtexPackage
 * @generated
 */
public interface BibtexFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BibtexFactory eINSTANCE = Bibtex.impl.BibtexFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Literature Db</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Literature Db</em>'.
     * @generated
     */
    LiteratureDb createLiteratureDb();

    /**
     * Returns a new object of class '<em>Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Entry</em>'.
     * @generated
     */
    Entry createEntry();

    /**
     * Returns a new object of class '<em>Author</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Author</em>'.
     * @generated
     */
    Author createAuthor();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    BibtexPackage getBibtexPackage();

} //BibtexFactory
