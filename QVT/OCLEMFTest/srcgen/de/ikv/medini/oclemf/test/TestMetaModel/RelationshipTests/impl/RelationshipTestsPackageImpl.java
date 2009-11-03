/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl;

import de.ikv.medini.kernel.KernelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.PrimitiveTypesStaticTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.impl.PrimitiveTypesTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest;
import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest;
import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsFactory;
import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.impl.TestMetaModelPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationshipTestsPackageImpl extends EPackageImpl implements RelationshipTestsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigableAssociationTestEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RelationshipTestsPackageImpl() {
		super(eNS_URI, RelationshipTestsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RelationshipTestsPackage init() {
		if (isInited) return (RelationshipTestsPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI);

		// Obtain or create and register package
		RelationshipTestsPackageImpl theRelationshipTestsPackage = (RelationshipTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof RelationshipTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new RelationshipTestsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KernelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TestMetaModelPackageImpl theTestMetaModelPackage = (TestMetaModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) instanceof TestMetaModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) : TestMetaModelPackage.eINSTANCE);
		ClassifierTestPackageImpl theClassifierTestPackage = (ClassifierTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) instanceof ClassifierTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) : ClassifierTestPackage.eINSTANCE);
		DataTypeTestsPackageImpl theDataTypeTestsPackage = (DataTypeTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) instanceof DataTypeTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) : DataTypeTestsPackage.eINSTANCE);
		PrimitiveTypesTestsPackageImpl thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) instanceof PrimitiveTypesTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) : PrimitiveTypesTestsPackage.eINSTANCE);
		PrimitiveTypesStaticTestsPackageImpl thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) instanceof PrimitiveTypesStaticTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) : PrimitiveTypesStaticTestsPackage.eINSTANCE);

		// Create package meta-data objects
		theRelationshipTestsPackage.createPackageContents();
		theTestMetaModelPackage.createPackageContents();
		theClassifierTestPackage.createPackageContents();
		theDataTypeTestsPackage.createPackageContents();
		thePrimitiveTypesTestsPackage.createPackageContents();
		thePrimitiveTypesStaticTestsPackage.createPackageContents();

		// Initialize created meta-data
		theRelationshipTestsPackage.initializePackageContents();
		theTestMetaModelPackage.initializePackageContents();
		theClassifierTestPackage.initializePackageContents();
		theDataTypeTestsPackage.initializePackageContents();
		thePrimitiveTypesTestsPackage.initializePackageContents();
		thePrimitiveTypesStaticTestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRelationshipTestsPackage.freeze();

		return theRelationshipTestsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassTest() {
		return classTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTest_MultiClassReference() {
		return (EReference)classTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTest_SingleClassReference() {
		return (EReference)classTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTest_SingleClassAttribute() {
		return (EReference)classTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTest_MultiUniqueClassAttribute() {
		return (EReference)classTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTest_MultiNonUniqueClassAttribute() {
		return (EReference)classTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigableAssociationTest() {
		return navigableAssociationTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigableAssociationTest_ComponentEnd() {
		return (EReference)navigableAssociationTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigableAssociationTest_Aggregate() {
		return (EReference)navigableAssociationTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipTestsFactory getRelationshipTestsFactory() {
		return (RelationshipTestsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		classTestEClass = createEClass(CLASS_TEST);
		createEReference(classTestEClass, CLASS_TEST__MULTI_CLASS_REFERENCE);
		createEReference(classTestEClass, CLASS_TEST__SINGLE_CLASS_REFERENCE);
		createEReference(classTestEClass, CLASS_TEST__SINGLE_CLASS_ATTRIBUTE);
		createEReference(classTestEClass, CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE);
		createEReference(classTestEClass, CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE);

		navigableAssociationTestEClass = createEClass(NAVIGABLE_ASSOCIATION_TEST);
		createEReference(navigableAssociationTestEClass, NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END);
		createEReference(navigableAssociationTestEClass, NAVIGABLE_ASSOCIATION_TEST__AGGREGATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		KernelPackage theKernelPackage = (KernelPackage)EPackage.Registry.INSTANCE.getEPackage(KernelPackage.eNS_URI);
		PrimitiveTypesStaticTestsPackage thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI);
		PrimitiveTypesTestsPackage thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI);

		// Add supertypes to classes
		classTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		navigableAssociationTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());

		// Initialize classes and features; add operations and parameters
		initEClass(classTestEClass, ClassTest.class, "ClassTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassTest_MultiClassReference(), thePrimitiveTypesStaticTestsPackage.getStaticBooleanTest(), null, "multiClassReference", null, 0, -1, ClassTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassTest_SingleClassReference(), thePrimitiveTypesStaticTestsPackage.getStringTest(), null, "singleClassReference", null, 1, 1, ClassTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassTest_SingleClassAttribute(), thePrimitiveTypesTestsPackage.getStringTest(), null, "SingleClassAttribute", null, 1, 1, ClassTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassTest_MultiUniqueClassAttribute(), thePrimitiveTypesTestsPackage.getIntegerTest(), null, "MultiUniqueClassAttribute", null, 0, -1, ClassTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassTest_MultiNonUniqueClassAttribute(), thePrimitiveTypesTestsPackage.getStringTest(), null, "MultiNonUniqueClassAttribute", null, 0, -1, ClassTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(navigableAssociationTestEClass, NavigableAssociationTest.class, "NavigableAssociationTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigableAssociationTest_ComponentEnd(), thePrimitiveTypesStaticTestsPackage.getStaticIntegerTest(), null, "componentEnd", null, 1, 1, NavigableAssociationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNavigableAssociationTest_Aggregate(), thePrimitiveTypesStaticTestsPackage.getStaticLongTest(), null, "aggregate", null, 0, -1, NavigableAssociationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //RelationshipTestsPackageImpl
