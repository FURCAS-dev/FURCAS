/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests;

import de.ikv.medini.kernel.KernelPackage;

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
 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsFactory
 * @model kind="package"
 * @generated
 */
public interface RelationshipTestsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RelationshipTests";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///TestMetaModel/RelationshipTests.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TestMetaModel.RelationshipTests";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationshipTestsPackage eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl <em>Class Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl#getClassTest()
	 * @generated
	 */
	int CLASS_TEST = 0;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEST__MEDINI_IDENTIFIER = KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Multi Class Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEST__MULTI_CLASS_REFERENCE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Single Class Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEST__SINGLE_CLASS_REFERENCE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Single Class Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEST__SINGLE_CLASS_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Multi Unique Class Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Multi Non Unique Class Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Class Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEST_FEATURE_COUNT = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.NavigableAssociationTestImpl <em>Navigable Association Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.NavigableAssociationTestImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl#getNavigableAssociationTest()
	 * @generated
	 */
	int NAVIGABLE_ASSOCIATION_TEST = 1;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_ASSOCIATION_TEST__MEDINI_IDENTIFIER = KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Component End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aggregate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_ASSOCIATION_TEST__AGGREGATE = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Navigable Association Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_ASSOCIATION_TEST_FEATURE_COUNT = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest <em>Class Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Test</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest
	 * @generated
	 */
	EClass getClassTest();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiClassReference <em>Multi Class Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multi Class Reference</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiClassReference()
	 * @see #getClassTest()
	 * @generated
	 */
	EReference getClassTest_MultiClassReference();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassReference <em>Single Class Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Class Reference</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassReference()
	 * @see #getClassTest()
	 * @generated
	 */
	EReference getClassTest_SingleClassReference();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassAttribute <em>Single Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Class Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getSingleClassAttribute()
	 * @see #getClassTest()
	 * @generated
	 */
	EReference getClassTest_SingleClassAttribute();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiUniqueClassAttribute <em>Multi Unique Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multi Unique Class Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiUniqueClassAttribute()
	 * @see #getClassTest()
	 * @generated
	 */
	EReference getClassTest_MultiUniqueClassAttribute();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiNonUniqueClassAttribute <em>Multi Non Unique Class Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multi Non Unique Class Attribute</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest#getMultiNonUniqueClassAttribute()
	 * @see #getClassTest()
	 * @generated
	 */
	EReference getClassTest_MultiNonUniqueClassAttribute();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest <em>Navigable Association Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigable Association Test</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest
	 * @generated
	 */
	EClass getNavigableAssociationTest();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest#getComponentEnd <em>Component End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component End</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest#getComponentEnd()
	 * @see #getNavigableAssociationTest()
	 * @generated
	 */
	EReference getNavigableAssociationTest_ComponentEnd();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest#getAggregate <em>Aggregate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Aggregate</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest#getAggregate()
	 * @see #getNavigableAssociationTest()
	 * @generated
	 */
	EReference getNavigableAssociationTest_Aggregate();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RelationshipTestsFactory getRelationshipTestsFactory();

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
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl <em>Class Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl#getClassTest()
		 * @generated
		 */
		EClass CLASS_TEST = eINSTANCE.getClassTest();

		/**
		 * The meta object literal for the '<em><b>Multi Class Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TEST__MULTI_CLASS_REFERENCE = eINSTANCE.getClassTest_MultiClassReference();

		/**
		 * The meta object literal for the '<em><b>Single Class Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TEST__SINGLE_CLASS_REFERENCE = eINSTANCE.getClassTest_SingleClassReference();

		/**
		 * The meta object literal for the '<em><b>Single Class Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TEST__SINGLE_CLASS_ATTRIBUTE = eINSTANCE.getClassTest_SingleClassAttribute();

		/**
		 * The meta object literal for the '<em><b>Multi Unique Class Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE = eINSTANCE.getClassTest_MultiUniqueClassAttribute();

		/**
		 * The meta object literal for the '<em><b>Multi Non Unique Class Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE = eINSTANCE.getClassTest_MultiNonUniqueClassAttribute();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.NavigableAssociationTestImpl <em>Navigable Association Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.NavigableAssociationTestImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl#getNavigableAssociationTest()
		 * @generated
		 */
		EClass NAVIGABLE_ASSOCIATION_TEST = eINSTANCE.getNavigableAssociationTest();

		/**
		 * The meta object literal for the '<em><b>Component End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END = eINSTANCE.getNavigableAssociationTest_ComponentEnd();

		/**
		 * The meta object literal for the '<em><b>Aggregate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGABLE_ASSOCIATION_TEST__AGGREGATE = eINSTANCE.getNavigableAssociationTest_Aggregate();

	}

} //RelationshipTestsPackage
