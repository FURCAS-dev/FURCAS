/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.impl;

import de.ikv.medini.kernel.KernelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.PrimitiveTypesStaticTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.BooleanTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.DoubleTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.FloatTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.IntegerTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.LongTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsFactory;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.impl.TestMetaModelPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitiveTypesTestsPackageImpl extends EPackageImpl implements PrimitiveTypesTestsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTestEClass = null;

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
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PrimitiveTypesTestsPackageImpl() {
		super(eNS_URI, PrimitiveTypesTestsFactory.eINSTANCE);
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
	public static PrimitiveTypesTestsPackage init() {
		if (isInited) return (PrimitiveTypesTestsPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI);

		// Obtain or create and register package
		PrimitiveTypesTestsPackageImpl thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PrimitiveTypesTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new PrimitiveTypesTestsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KernelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TestMetaModelPackageImpl theTestMetaModelPackage = (TestMetaModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) instanceof TestMetaModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) : TestMetaModelPackage.eINSTANCE);
		ClassifierTestPackageImpl theClassifierTestPackage = (ClassifierTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) instanceof ClassifierTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) : ClassifierTestPackage.eINSTANCE);
		DataTypeTestsPackageImpl theDataTypeTestsPackage = (DataTypeTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) instanceof DataTypeTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) : DataTypeTestsPackage.eINSTANCE);
		PrimitiveTypesStaticTestsPackageImpl thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) instanceof PrimitiveTypesStaticTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) : PrimitiveTypesStaticTestsPackage.eINSTANCE);
		RelationshipTestsPackageImpl theRelationshipTestsPackage = (RelationshipTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) instanceof RelationshipTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) : RelationshipTestsPackage.eINSTANCE);

		// Create package meta-data objects
		thePrimitiveTypesTestsPackage.createPackageContents();
		theTestMetaModelPackage.createPackageContents();
		theClassifierTestPackage.createPackageContents();
		theDataTypeTestsPackage.createPackageContents();
		thePrimitiveTypesStaticTestsPackage.createPackageContents();
		theRelationshipTestsPackage.createPackageContents();

		// Initialize created meta-data
		thePrimitiveTypesTestsPackage.initializePackageContents();
		theTestMetaModelPackage.initializePackageContents();
		theClassifierTestPackage.initializePackageContents();
		theDataTypeTestsPackage.initializePackageContents();
		thePrimitiveTypesStaticTestsPackage.initializePackageContents();
		theRelationshipTestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePrimitiveTypesTestsPackage.freeze();

		return thePrimitiveTypesTestsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanTest() {
		return booleanTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTest_SequenceAttribute() {
		return (EAttribute)booleanTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTest_SetAttribute() {
		return (EAttribute)booleanTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTest_SimpleAttribute() {
		return (EAttribute)booleanTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTest_BagAttribute() {
		return (EAttribute)booleanTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTest_OptionalSimpleAttribute() {
		return (EAttribute)booleanTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTest_OrderedSetAttribute() {
		return (EAttribute)booleanTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleTest() {
		return doubleTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleTest_BagAttribute() {
		return (EAttribute)doubleTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleTest_OptionalSimpleAttribute() {
		return (EAttribute)doubleTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleTest_OrderedSetAttribute() {
		return (EAttribute)doubleTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleTest_SequenceAttribute() {
		return (EAttribute)doubleTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleTest_SetAttribute() {
		return (EAttribute)doubleTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleTest_SimpleAttribute() {
		return (EAttribute)doubleTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatTest() {
		return floatTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatTest_BagAttribute() {
		return (EAttribute)floatTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatTest_OrderedSetAttribute() {
		return (EAttribute)floatTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatTest_SequenceAttribute() {
		return (EAttribute)floatTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatTest_SetAttribute() {
		return (EAttribute)floatTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatTest_SimpleAttribute() {
		return (EAttribute)floatTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatTest_OptionalSimpleAttribute() {
		return (EAttribute)floatTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerTest() {
		return integerTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerTest_BagAttribute() {
		return (EAttribute)integerTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerTest_OrderedSetAttribute() {
		return (EAttribute)integerTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerTest_SequenceAttribute() {
		return (EAttribute)integerTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerTest_SetAttribute() {
		return (EAttribute)integerTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerTest_SimpleAttribute() {
		return (EAttribute)integerTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerTest_OptionalSimpleAttribute() {
		return (EAttribute)integerTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongTest() {
		return longTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongTest_BagAttribute() {
		return (EAttribute)longTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongTest_OptionalSimpleAttribute() {
		return (EAttribute)longTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongTest_OrderedSetAttribute() {
		return (EAttribute)longTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongTest_SequenceAttribute() {
		return (EAttribute)longTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongTest_SetAttribute() {
		return (EAttribute)longTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongTest_SimpleAttribute() {
		return (EAttribute)longTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringTest() {
		return stringTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_BagAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_OptionalSimpleAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_OrderedSetAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_SequenceAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_SetAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_SimpleAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypesTestsFactory getPrimitiveTypesTestsFactory() {
		return (PrimitiveTypesTestsFactory)getEFactoryInstance();
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
		booleanTestEClass = createEClass(BOOLEAN_TEST);
		createEAttribute(booleanTestEClass, BOOLEAN_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(booleanTestEClass, BOOLEAN_TEST__SET_ATTRIBUTE);
		createEAttribute(booleanTestEClass, BOOLEAN_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(booleanTestEClass, BOOLEAN_TEST__BAG_ATTRIBUTE);
		createEAttribute(booleanTestEClass, BOOLEAN_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(booleanTestEClass, BOOLEAN_TEST__ORDERED_SET_ATTRIBUTE);

		doubleTestEClass = createEClass(DOUBLE_TEST);
		createEAttribute(doubleTestEClass, DOUBLE_TEST__BAG_ATTRIBUTE);
		createEAttribute(doubleTestEClass, DOUBLE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(doubleTestEClass, DOUBLE_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(doubleTestEClass, DOUBLE_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(doubleTestEClass, DOUBLE_TEST__SET_ATTRIBUTE);
		createEAttribute(doubleTestEClass, DOUBLE_TEST__SIMPLE_ATTRIBUTE);

		floatTestEClass = createEClass(FLOAT_TEST);
		createEAttribute(floatTestEClass, FLOAT_TEST__BAG_ATTRIBUTE);
		createEAttribute(floatTestEClass, FLOAT_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(floatTestEClass, FLOAT_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(floatTestEClass, FLOAT_TEST__SET_ATTRIBUTE);
		createEAttribute(floatTestEClass, FLOAT_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(floatTestEClass, FLOAT_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);

		integerTestEClass = createEClass(INTEGER_TEST);
		createEAttribute(integerTestEClass, INTEGER_TEST__BAG_ATTRIBUTE);
		createEAttribute(integerTestEClass, INTEGER_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(integerTestEClass, INTEGER_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(integerTestEClass, INTEGER_TEST__SET_ATTRIBUTE);
		createEAttribute(integerTestEClass, INTEGER_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(integerTestEClass, INTEGER_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);

		longTestEClass = createEClass(LONG_TEST);
		createEAttribute(longTestEClass, LONG_TEST__BAG_ATTRIBUTE);
		createEAttribute(longTestEClass, LONG_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(longTestEClass, LONG_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(longTestEClass, LONG_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(longTestEClass, LONG_TEST__SET_ATTRIBUTE);
		createEAttribute(longTestEClass, LONG_TEST__SIMPLE_ATTRIBUTE);

		stringTestEClass = createEClass(STRING_TEST);
		createEAttribute(stringTestEClass, STRING_TEST__BAG_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__SET_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__SIMPLE_ATTRIBUTE);
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

		// Add supertypes to classes
		booleanTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		doubleTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		floatTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		integerTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		longTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		stringTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());

		// Initialize classes and features; add operations and parameters
		initEClass(booleanTestEClass, BooleanTest.class, "BooleanTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanTest_SequenceAttribute(), ecorePackage.getEBoolean(), "SequenceAttribute", null, 0, -1, BooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBooleanTest_SetAttribute(), ecorePackage.getEBoolean(), "SetAttribute", null, 0, -1, BooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBooleanTest_SimpleAttribute(), ecorePackage.getEBoolean(), "SimpleAttribute", null, 1, 1, BooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBooleanTest_BagAttribute(), ecorePackage.getEBoolean(), "BagAttribute", null, 0, -1, BooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBooleanTest_OptionalSimpleAttribute(), ecorePackage.getEBoolean(), "OptionalSimpleAttribute", null, 0, 1, BooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBooleanTest_OrderedSetAttribute(), ecorePackage.getEBoolean(), "OrderedSetAttribute", null, 0, -1, BooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleTestEClass, DoubleTest.class, "DoubleTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleTest_BagAttribute(), ecorePackage.getEDouble(), "BagAttribute", null, 0, -1, DoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleTest_OptionalSimpleAttribute(), ecorePackage.getEDouble(), "OptionalSimpleAttribute", null, 0, 1, DoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleTest_OrderedSetAttribute(), ecorePackage.getEDouble(), "OrderedSetAttribute", null, 0, -1, DoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDoubleTest_SequenceAttribute(), ecorePackage.getEDouble(), "SequenceAttribute", null, 0, -1, DoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDoubleTest_SetAttribute(), ecorePackage.getEDouble(), "SetAttribute", null, 0, -1, DoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleTest_SimpleAttribute(), ecorePackage.getEDouble(), "SimpleAttribute", null, 1, 1, DoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(floatTestEClass, FloatTest.class, "FloatTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatTest_BagAttribute(), ecorePackage.getEFloat(), "BagAttribute", null, 0, -1, FloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFloatTest_OrderedSetAttribute(), ecorePackage.getEFloat(), "OrderedSetAttribute", null, 0, -1, FloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFloatTest_SequenceAttribute(), ecorePackage.getEFloat(), "SequenceAttribute", null, 0, -1, FloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFloatTest_SetAttribute(), ecorePackage.getEFloat(), "SetAttribute", null, 0, -1, FloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFloatTest_SimpleAttribute(), ecorePackage.getEFloat(), "SimpleAttribute", null, 1, 1, FloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFloatTest_OptionalSimpleAttribute(), ecorePackage.getEFloat(), "OptionalSimpleAttribute", null, 0, 1, FloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(integerTestEClass, IntegerTest.class, "IntegerTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerTest_BagAttribute(), ecorePackage.getEInt(), "BagAttribute", null, 0, -1, IntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntegerTest_OrderedSetAttribute(), ecorePackage.getEInt(), "OrderedSetAttribute", null, 0, -1, IntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerTest_SequenceAttribute(), ecorePackage.getEInt(), "SequenceAttribute", null, 0, -1, IntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerTest_SetAttribute(), ecorePackage.getEInt(), "SetAttribute", null, 0, -1, IntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntegerTest_SimpleAttribute(), ecorePackage.getEInt(), "SimpleAttribute", null, 1, 1, IntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntegerTest_OptionalSimpleAttribute(), ecorePackage.getEInt(), "OptionalSimpleAttribute", null, 0, 1, IntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(longTestEClass, LongTest.class, "LongTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongTest_BagAttribute(), ecorePackage.getELong(), "BagAttribute", null, 0, -1, LongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLongTest_OptionalSimpleAttribute(), ecorePackage.getELong(), "OptionalSimpleAttribute", null, 0, 1, LongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLongTest_OrderedSetAttribute(), ecorePackage.getELong(), "OrderedSetAttribute", null, 0, -1, LongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLongTest_SequenceAttribute(), ecorePackage.getELong(), "SequenceAttribute", null, 0, -1, LongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLongTest_SetAttribute(), ecorePackage.getELong(), "SetAttribute", null, 0, -1, LongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLongTest_SimpleAttribute(), ecorePackage.getELong(), "SimpleAttribute", null, 1, 1, LongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stringTestEClass, StringTest.class, "StringTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringTest_BagAttribute(), ecorePackage.getEString(), "BagAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringTest_OptionalSimpleAttribute(), ecorePackage.getEString(), "OptionalSimpleAttribute", "", 0, 1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringTest_OrderedSetAttribute(), ecorePackage.getEString(), "OrderedSetAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringTest_SequenceAttribute(), ecorePackage.getEString(), "SequenceAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringTest_SetAttribute(), ecorePackage.getEString(), "SetAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringTest_SimpleAttribute(), ecorePackage.getEString(), "SimpleAttribute", "", 1, 1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //PrimitiveTypesTestsPackageImpl
