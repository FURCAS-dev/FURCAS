/**
 * <copyright>
 * </copyright>
 *
 * $Id: LibraryPackage.java,v 1.1 2010/12/07 13:18:53 akrsharma Exp $
 */
package library;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see library.LibraryFactory
 * @model kind="package"
 * @generated
 */
public interface LibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "library";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/modeling/emf/query/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "library";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LibraryPackage eINSTANCE = library.impl.LibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link library.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see library.impl.LibraryImpl
	 * @see library.impl.LibraryPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__BOOKS = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link library.impl.PublisherImpl <em>Publisher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see library.impl.PublisherImpl
	 * @see library.impl.LibraryPackageImpl#getPublisher()
	 * @generated
	 */
	int PUBLISHER = 1;

	/**
	 * The feature id for the '<em><b>Manuscripts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER__MANUSCRIPTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER__NAME = 1;

	/**
	 * The number of structural features of the '<em>Publisher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link library.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see library.impl.BookImpl
	 * @see library.impl.LibraryPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 2;

	/**
	 * The feature id for the '<em><b>Borrowed By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__BORROWED_BY = 0;

	/**
	 * The feature id for the '<em><b>Instance Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__INSTANCE_OF = 1;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link library.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see library.impl.PersonImpl
	 * @see library.impl.LibraryPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 0;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link library.impl.ManuscriptImpl <em>Manuscript</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see library.impl.ManuscriptImpl
	 * @see library.impl.LibraryPackageImpl#getManuscript()
	 * @generated
	 */
	int MANUSCRIPT = 4;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUSCRIPT__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUSCRIPT__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUSCRIPT__PAGES = 2;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUSCRIPT__FORMAT = 3;

	/**
	 * The number of structural features of the '<em>Manuscript</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUSCRIPT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link library.Format <em>Format</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see library.Format
	 * @see library.impl.LibraryPackageImpl#getFormat()
	 * @generated
	 */
	int FORMAT = 5;


	/**
	 * Returns the meta object for class '{@link library.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see library.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link library.Library#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Books</em>'.
	 * @see library.Library#getBooks()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Books();

	/**
	 * Returns the meta object for the attribute '{@link library.Library#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see library.Library#getLocation()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Location();

	/**
	 * Returns the meta object for class '{@link library.Publisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publisher</em>'.
	 * @see library.Publisher
	 * @generated
	 */
	EClass getPublisher();

	/**
	 * Returns the meta object for the containment reference list '{@link library.Publisher#getManuscripts <em>Manuscripts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Manuscripts</em>'.
	 * @see library.Publisher#getManuscripts()
	 * @see #getPublisher()
	 * @generated
	 */
	EReference getPublisher_Manuscripts();

	/**
	 * Returns the meta object for the attribute '{@link library.Publisher#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see library.Publisher#getName()
	 * @see #getPublisher()
	 * @generated
	 */
	EAttribute getPublisher_Name();

	/**
	 * Returns the meta object for class '{@link library.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see library.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the reference '{@link library.Book#getBorrowedBy <em>Borrowed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Borrowed By</em>'.
	 * @see library.Book#getBorrowedBy()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_BorrowedBy();

	/**
	 * Returns the meta object for the reference '{@link library.Book#getInstanceOf <em>Instance Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Of</em>'.
	 * @see library.Book#getInstanceOf()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_InstanceOf();

	/**
	 * Returns the meta object for class '{@link library.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see library.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link library.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see library.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for class '{@link library.Manuscript <em>Manuscript</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manuscript</em>'.
	 * @see library.Manuscript
	 * @generated
	 */
	EClass getManuscript();

	/**
	 * Returns the meta object for the reference list '{@link library.Manuscript#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Author</em>'.
	 * @see library.Manuscript#getAuthor()
	 * @see #getManuscript()
	 * @generated
	 */
	EReference getManuscript_Author();

	/**
	 * Returns the meta object for the attribute '{@link library.Manuscript#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see library.Manuscript#getTitle()
	 * @see #getManuscript()
	 * @generated
	 */
	EAttribute getManuscript_Title();

	/**
	 * Returns the meta object for the attribute '{@link library.Manuscript#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pages</em>'.
	 * @see library.Manuscript#getPages()
	 * @see #getManuscript()
	 * @generated
	 */
	EAttribute getManuscript_Pages();

	/**
	 * Returns the meta object for the attribute '{@link library.Manuscript#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see library.Manuscript#getFormat()
	 * @see #getManuscript()
	 * @generated
	 */
	EAttribute getManuscript_Format();

	/**
	 * Returns the meta object for enum '{@link library.Format <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Format</em>'.
	 * @see library.Format
	 * @generated
	 */
	EEnum getFormat();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LibraryFactory getLibraryFactory();

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
		 * The meta object literal for the '{@link library.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see library.impl.LibraryImpl
		 * @see library.impl.LibraryPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__BOOKS = eINSTANCE.getLibrary_Books();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__LOCATION = eINSTANCE.getLibrary_Location();

		/**
		 * The meta object literal for the '{@link library.impl.PublisherImpl <em>Publisher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see library.impl.PublisherImpl
		 * @see library.impl.LibraryPackageImpl#getPublisher()
		 * @generated
		 */
		EClass PUBLISHER = eINSTANCE.getPublisher();

		/**
		 * The meta object literal for the '<em><b>Manuscripts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PUBLISHER__MANUSCRIPTS = eINSTANCE.getPublisher_Manuscripts();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLISHER__NAME = eINSTANCE.getPublisher_Name();

		/**
		 * The meta object literal for the '{@link library.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see library.impl.BookImpl
		 * @see library.impl.LibraryPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Borrowed By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__BORROWED_BY = eINSTANCE.getBook_BorrowedBy();

		/**
		 * The meta object literal for the '<em><b>Instance Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__INSTANCE_OF = eINSTANCE.getBook_InstanceOf();

		/**
		 * The meta object literal for the '{@link library.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see library.impl.PersonImpl
		 * @see library.impl.LibraryPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '{@link library.impl.ManuscriptImpl <em>Manuscript</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see library.impl.ManuscriptImpl
		 * @see library.impl.LibraryPackageImpl#getManuscript()
		 * @generated
		 */
		EClass MANUSCRIPT = eINSTANCE.getManuscript();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANUSCRIPT__AUTHOR = eINSTANCE.getManuscript_Author();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANUSCRIPT__TITLE = eINSTANCE.getManuscript_Title();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANUSCRIPT__PAGES = eINSTANCE.getManuscript_Pages();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANUSCRIPT__FORMAT = eINSTANCE.getManuscript_Format();

		/**
		 * The meta object literal for the '{@link library.Format <em>Format</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see library.Format
		 * @see library.impl.LibraryPackageImpl#getFormat()
		 * @generated
		 */
		EEnum FORMAT = eINSTANCE.getFormat();

	}

} //LibraryPackage
