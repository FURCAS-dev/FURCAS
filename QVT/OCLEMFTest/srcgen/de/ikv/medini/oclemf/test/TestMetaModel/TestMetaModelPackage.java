/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel;

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
 * @see de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelFactory
 * @model kind="package"
 * @generated
 */
public interface TestMetaModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TestMetaModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///TestMetaModel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TestMetaModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestMetaModelPackage eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.impl.TestMetaModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.impl.TopLevelDummyClassImpl <em>Top Level Dummy Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.impl.TopLevelDummyClassImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.impl.TestMetaModelPackageImpl#getTopLevelDummyClass()
	 * @generated
	 */
	int TOP_LEVEL_DUMMY_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Top Level Dummy Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_DUMMY_CLASS_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.TopLevelDummyClass <em>Top Level Dummy Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level Dummy Class</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.TopLevelDummyClass
	 * @generated
	 */
	EClass getTopLevelDummyClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestMetaModelFactory getTestMetaModelFactory();

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
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.impl.TopLevelDummyClassImpl <em>Top Level Dummy Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.impl.TopLevelDummyClassImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.impl.TestMetaModelPackageImpl#getTopLevelDummyClass()
		 * @generated
		 */
		EClass TOP_LEVEL_DUMMY_CLASS = eINSTANCE.getTopLevelDummyClass();

	}

} //TestMetaModelPackage
