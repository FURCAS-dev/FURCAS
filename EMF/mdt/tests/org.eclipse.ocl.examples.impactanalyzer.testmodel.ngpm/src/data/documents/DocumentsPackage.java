/**
 * <copyright>
 * </copyright>
 *
 * $Id: DocumentsPackage.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.documents;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * <!-- begin-model-doc -->
 * Structures that help referencing and managing---typically external---document repositories. Structures shall allow to reference documents in such a repository, say something about the lifecycle of documents in such a repository in connection to the life cycle of other model elements, and integrate document repository capabilities into the modeling world, such as document ranking, versioning, etc.
 * <!-- end-model-doc -->
 * @see data.documents.DocumentsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface DocumentsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "documents";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/data/documents.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "data.documents";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	DocumentsPackage eINSTANCE = data.documents.impl.DocumentsPackageImpl.init();

	/**
     * The meta object id for the '{@link data.documents.impl.DummyImpl <em>Dummy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.documents.impl.DummyImpl
     * @see data.documents.impl.DocumentsPackageImpl#getDummy()
     * @generated
     */
	int DUMMY = 0;

	/**
     * The number of structural features of the '<em>Dummy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DUMMY_FEATURE_COUNT = 0;


	/**
     * Returns the meta object for class '{@link data.documents.Dummy <em>Dummy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dummy</em>'.
     * @see data.documents.Dummy
     * @generated
     */
	EClass getDummy();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	DocumentsFactory getDocumentsFactory();

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
         * The meta object literal for the '{@link data.documents.impl.DummyImpl <em>Dummy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.documents.impl.DummyImpl
         * @see data.documents.impl.DocumentsPackageImpl#getDummy()
         * @generated
         */
		EClass DUMMY = eINSTANCE.getDummy();

	}

} //DocumentsPackage
