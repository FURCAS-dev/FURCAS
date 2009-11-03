/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest;

import de.ikv.medini.kernel.KernelPackage;

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
 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestFactory
 * @model kind="package"
 * @generated
 */
public interface ClassifierTestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ClassifierTest";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///TestMetaModel/ClassifierTest.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TestMetaModel.ClassifierTest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassifierTestPackage eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.AbstractSuperClassImpl <em>Abstract Super Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.AbstractSuperClassImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl#getAbstractSuperClass()
	 * @generated
	 */
	int ABSTRACT_SUPER_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SUPER_CLASS__MEDINI_IDENTIFIER = KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SUPER_CLASS__SUB_CLASS = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract Super Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Super Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SUPER_CLASS_FEATURE_COUNT = KernelPackage.MEDINI_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SuperClassImpl <em>Super Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SuperClassImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl#getSuperClass()
	 * @generated
	 */
	int SUPER_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS__MEDINI_IDENTIFIER = ABSTRACT_SUPER_CLASS__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS__SUB_CLASS = ABSTRACT_SUPER_CLASS__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Abstract Super Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS__ABSTRACT_SUPER_NAME = ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME;

	/**
	 * The feature id for the '<em><b>Super Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS__SUPER_NAME = ABSTRACT_SUPER_CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Super Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS_FEATURE_COUNT = ABSTRACT_SUPER_CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SubClassImpl <em>Sub Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SubClassImpl
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl#getSubClass()
	 * @generated
	 */
	int SUB_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Medini Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CLASS__MEDINI_IDENTIFIER = SUPER_CLASS__MEDINI_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Sub Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CLASS__SUB_CLASS = SUPER_CLASS__SUB_CLASS;

	/**
	 * The feature id for the '<em><b>Abstract Super Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CLASS__ABSTRACT_SUPER_NAME = SUPER_CLASS__ABSTRACT_SUPER_NAME;

	/**
	 * The feature id for the '<em><b>Super Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CLASS__SUPER_NAME = SUPER_CLASS__SUPER_NAME;

	/**
	 * The feature id for the '<em><b>Sub Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CLASS__SUB_NAME = SUPER_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CLASS__ABSTRACT_SUPER_CLASS = SUPER_CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CLASS_FEATURE_COUNT = SUPER_CLASS_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass <em>Abstract Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Super Class</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass
	 * @generated
	 */
	EClass getAbstractSuperClass();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getSubClass <em>Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Class</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getSubClass()
	 * @see #getAbstractSuperClass()
	 * @generated
	 */
	EReference getAbstractSuperClass_SubClass();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getAbstractSuperName <em>Abstract Super Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract Super Name</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass#getAbstractSuperName()
	 * @see #getAbstractSuperClass()
	 * @generated
	 */
	EAttribute getAbstractSuperClass_AbstractSuperName();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass <em>Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Class</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass
	 * @generated
	 */
	EClass getSubClass();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getSubName <em>Sub Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Name</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getSubName()
	 * @see #getSubClass()
	 * @generated
	 */
	EAttribute getSubClass_SubName();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getAbstractSuperClass <em>Abstract Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Abstract Super Class</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass#getAbstractSuperClass()
	 * @see #getSubClass()
	 * @generated
	 */
	EReference getSubClass_AbstractSuperClass();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Class</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass
	 * @generated
	 */
	EClass getSuperClass();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass#getSuperName <em>Super Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Name</em>'.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass#getSuperName()
	 * @see #getSuperClass()
	 * @generated
	 */
	EAttribute getSuperClass_SuperName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassifierTestFactory getClassifierTestFactory();

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
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.AbstractSuperClassImpl <em>Abstract Super Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.AbstractSuperClassImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl#getAbstractSuperClass()
		 * @generated
		 */
		EClass ABSTRACT_SUPER_CLASS = eINSTANCE.getAbstractSuperClass();

		/**
		 * The meta object literal for the '<em><b>Sub Class</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SUPER_CLASS__SUB_CLASS = eINSTANCE.getAbstractSuperClass_SubClass();

		/**
		 * The meta object literal for the '<em><b>Abstract Super Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME = eINSTANCE.getAbstractSuperClass_AbstractSuperName();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SubClassImpl <em>Sub Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SubClassImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl#getSubClass()
		 * @generated
		 */
		EClass SUB_CLASS = eINSTANCE.getSubClass();

		/**
		 * The meta object literal for the '<em><b>Sub Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_CLASS__SUB_NAME = eINSTANCE.getSubClass_SubName();

		/**
		 * The meta object literal for the '<em><b>Abstract Super Class</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_CLASS__ABSTRACT_SUPER_CLASS = eINSTANCE.getSubClass_AbstractSuperClass();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SuperClassImpl <em>Super Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SuperClassImpl
		 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl#getSuperClass()
		 * @generated
		 */
		EClass SUPER_CLASS = eINSTANCE.getSuperClass();

		/**
		 * The meta object literal for the '<em><b>Super Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPER_CLASS__SUPER_NAME = eINSTANCE.getSuperClass_SuperName();

	}

} //ClassifierTestPackage
