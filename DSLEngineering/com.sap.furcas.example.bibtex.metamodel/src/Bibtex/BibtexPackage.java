/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Bibtex;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Bibtex.BibtexFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface BibtexPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "Bibtex";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.sap.com/furcas/examples/bibtex";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "bibtex";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BibtexPackage eINSTANCE = Bibtex.impl.BibtexPackageImpl.init();

    /**
     * The meta object id for the '{@link Bibtex.impl.LiteratureDbImpl <em>Literature Db</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see Bibtex.impl.LiteratureDbImpl
     * @see Bibtex.impl.BibtexPackageImpl#getLiteratureDb()
     * @generated
     */
    int LITERATURE_DB = 0;

    /**
     * The feature id for the '<em><b>Author</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LITERATURE_DB__AUTHOR = 0;

    /**
     * The feature id for the '<em><b>Entries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LITERATURE_DB__ENTRIES = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LITERATURE_DB__NAME = 2;

    /**
     * The number of structural features of the '<em>Literature Db</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LITERATURE_DB_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link Bibtex.impl.EntryImpl <em>Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see Bibtex.impl.EntryImpl
     * @see Bibtex.impl.BibtexPackageImpl#getEntry()
     * @generated
     */
    int ENTRY = 1;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTRY__TITLE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTRY__ID = 1;

    /**
     * The feature id for the '<em><b>Author</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTRY__AUTHOR = 2;

    /**
     * The feature id for the '<em><b>Literaturedb</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTRY__LITERATUREDB = 3;

    /**
     * The number of structural features of the '<em>Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTRY_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link Bibtex.impl.AuthorImpl <em>Author</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see Bibtex.impl.AuthorImpl
     * @see Bibtex.impl.BibtexPackageImpl#getAuthor()
     * @generated
     */
    int AUTHOR = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTHOR__NAME = 0;

    /**
     * The feature id for the '<em><b>Publications</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTHOR__PUBLICATIONS = 1;

    /**
     * The feature id for the '<em><b>Literaturedb</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTHOR__LITERATUREDB = 2;

    /**
     * The number of structural features of the '<em>Author</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTHOR_FEATURE_COUNT = 3;


    /**
     * Returns the meta object for class '{@link Bibtex.LiteratureDb <em>Literature Db</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Literature Db</em>'.
     * @see Bibtex.LiteratureDb
     * @generated
     */
    EClass getLiteratureDb();

    /**
     * Returns the meta object for the containment reference list '{@link Bibtex.LiteratureDb#getAuthor <em>Author</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Author</em>'.
     * @see Bibtex.LiteratureDb#getAuthor()
     * @see #getLiteratureDb()
     * @generated
     */
    EReference getLiteratureDb_Author();

    /**
     * Returns the meta object for the containment reference list '{@link Bibtex.LiteratureDb#getEntries <em>Entries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Entries</em>'.
     * @see Bibtex.LiteratureDb#getEntries()
     * @see #getLiteratureDb()
     * @generated
     */
    EReference getLiteratureDb_Entries();

    /**
     * Returns the meta object for the attribute '{@link Bibtex.LiteratureDb#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see Bibtex.LiteratureDb#getName()
     * @see #getLiteratureDb()
     * @generated
     */
    EAttribute getLiteratureDb_Name();

    /**
     * Returns the meta object for class '{@link Bibtex.Entry <em>Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Entry</em>'.
     * @see Bibtex.Entry
     * @generated
     */
    EClass getEntry();

    /**
     * Returns the meta object for the attribute '{@link Bibtex.Entry#getTitle <em>Title</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Title</em>'.
     * @see Bibtex.Entry#getTitle()
     * @see #getEntry()
     * @generated
     */
    EAttribute getEntry_Title();

    /**
     * Returns the meta object for the attribute '{@link Bibtex.Entry#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see Bibtex.Entry#getId()
     * @see #getEntry()
     * @generated
     */
    EAttribute getEntry_Id();

    /**
     * Returns the meta object for the reference list '{@link Bibtex.Entry#getAuthor <em>Author</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Author</em>'.
     * @see Bibtex.Entry#getAuthor()
     * @see #getEntry()
     * @generated
     */
    EReference getEntry_Author();

    /**
     * Returns the meta object for the reference '{@link Bibtex.Entry#getLiteraturedb <em>Literaturedb</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Literaturedb</em>'.
     * @see Bibtex.Entry#getLiteraturedb()
     * @see #getEntry()
     * @generated
     */
    EReference getEntry_Literaturedb();

    /**
     * Returns the meta object for class '{@link Bibtex.Author <em>Author</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Author</em>'.
     * @see Bibtex.Author
     * @generated
     */
    EClass getAuthor();

    /**
     * Returns the meta object for the attribute '{@link Bibtex.Author#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see Bibtex.Author#getName()
     * @see #getAuthor()
     * @generated
     */
    EAttribute getAuthor_Name();

    /**
     * Returns the meta object for the reference list '{@link Bibtex.Author#getPublications <em>Publications</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Publications</em>'.
     * @see Bibtex.Author#getPublications()
     * @see #getAuthor()
     * @generated
     */
    EReference getAuthor_Publications();

    /**
     * Returns the meta object for the reference '{@link Bibtex.Author#getLiteraturedb <em>Literaturedb</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Literaturedb</em>'.
     * @see Bibtex.Author#getLiteraturedb()
     * @see #getAuthor()
     * @generated
     */
    EReference getAuthor_Literaturedb();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BibtexFactory getBibtexFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link Bibtex.impl.LiteratureDbImpl <em>Literature Db</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see Bibtex.impl.LiteratureDbImpl
         * @see Bibtex.impl.BibtexPackageImpl#getLiteratureDb()
         * @generated
         */
        EClass LITERATURE_DB = eINSTANCE.getLiteratureDb();

        /**
         * The meta object literal for the '<em><b>Author</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LITERATURE_DB__AUTHOR = eINSTANCE.getLiteratureDb_Author();

        /**
         * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LITERATURE_DB__ENTRIES = eINSTANCE.getLiteratureDb_Entries();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LITERATURE_DB__NAME = eINSTANCE.getLiteratureDb_Name();

        /**
         * The meta object literal for the '{@link Bibtex.impl.EntryImpl <em>Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see Bibtex.impl.EntryImpl
         * @see Bibtex.impl.BibtexPackageImpl#getEntry()
         * @generated
         */
        EClass ENTRY = eINSTANCE.getEntry();

        /**
         * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENTRY__TITLE = eINSTANCE.getEntry_Title();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENTRY__ID = eINSTANCE.getEntry_Id();

        /**
         * The meta object literal for the '<em><b>Author</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENTRY__AUTHOR = eINSTANCE.getEntry_Author();

        /**
         * The meta object literal for the '<em><b>Literaturedb</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENTRY__LITERATUREDB = eINSTANCE.getEntry_Literaturedb();

        /**
         * The meta object literal for the '{@link Bibtex.impl.AuthorImpl <em>Author</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see Bibtex.impl.AuthorImpl
         * @see Bibtex.impl.BibtexPackageImpl#getAuthor()
         * @generated
         */
        EClass AUTHOR = eINSTANCE.getAuthor();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

        /**
         * The meta object literal for the '<em><b>Publications</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AUTHOR__PUBLICATIONS = eINSTANCE.getAuthor_Publications();

        /**
         * The meta object literal for the '<em><b>Literaturedb</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AUTHOR__LITERATUREDB = eINSTANCE.getAuthor_Literaturedb();

    }

} //BibtexPackage
