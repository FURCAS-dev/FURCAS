/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl;

import de.ikv.medini.kernel.KernelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsFactory;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticDoubleTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticLongTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StringTest;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.impl.PrimitiveTypesTestsPackageImpl;

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
public class PrimitiveTypesStaticTestsPackageImpl extends EPackageImpl implements PrimitiveTypesStaticTestsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticBooleanTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticDoubleTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticFloatTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticIntegerTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticLongTestEClass = null;

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
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PrimitiveTypesStaticTestsPackageImpl() {
		super(eNS_URI, PrimitiveTypesStaticTestsFactory.eINSTANCE);
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
	public static PrimitiveTypesStaticTestsPackage init() {
		if (isInited) return (PrimitiveTypesStaticTestsPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI);

		// Obtain or create and register package
		PrimitiveTypesStaticTestsPackageImpl thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PrimitiveTypesStaticTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new PrimitiveTypesStaticTestsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KernelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TestMetaModelPackageImpl theTestMetaModelPackage = (TestMetaModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) instanceof TestMetaModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) : TestMetaModelPackage.eINSTANCE);
		ClassifierTestPackageImpl theClassifierTestPackage = (ClassifierTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) instanceof ClassifierTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) : ClassifierTestPackage.eINSTANCE);
		DataTypeTestsPackageImpl theDataTypeTestsPackage = (DataTypeTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) instanceof DataTypeTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) : DataTypeTestsPackage.eINSTANCE);
		PrimitiveTypesTestsPackageImpl thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) instanceof PrimitiveTypesTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) : PrimitiveTypesTestsPackage.eINSTANCE);
		RelationshipTestsPackageImpl theRelationshipTestsPackage = (RelationshipTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) instanceof RelationshipTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) : RelationshipTestsPackage.eINSTANCE);

		// Create package meta-data objects
		thePrimitiveTypesStaticTestsPackage.createPackageContents();
		theTestMetaModelPackage.createPackageContents();
		theClassifierTestPackage.createPackageContents();
		theDataTypeTestsPackage.createPackageContents();
		thePrimitiveTypesTestsPackage.createPackageContents();
		theRelationshipTestsPackage.createPackageContents();

		// Initialize created meta-data
		thePrimitiveTypesStaticTestsPackage.initializePackageContents();
		theTestMetaModelPackage.initializePackageContents();
		theClassifierTestPackage.initializePackageContents();
		theDataTypeTestsPackage.initializePackageContents();
		thePrimitiveTypesTestsPackage.initializePackageContents();
		theRelationshipTestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePrimitiveTypesStaticTestsPackage.freeze();

		return thePrimitiveTypesStaticTestsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticBooleanTest() {
		return staticBooleanTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticBooleanTest_SimpleAttribute() {
		return (EAttribute)staticBooleanTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticBooleanTest_OrderedSetAttribute() {
		return (EAttribute)staticBooleanTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticBooleanTest_SetAttribute() {
		return (EAttribute)staticBooleanTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticBooleanTest_BagAttribute() {
		return (EAttribute)staticBooleanTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticBooleanTest_OptionalSimpleAttribute() {
		return (EAttribute)staticBooleanTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticBooleanTest_SequenceAttribute() {
		return (EAttribute)staticBooleanTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticBooleanTest_Dummy() {
		return (EAttribute)staticBooleanTestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticDoubleTest() {
		return staticDoubleTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticDoubleTest_BagAttribute() {
		return (EAttribute)staticDoubleTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticDoubleTest_SetAttribute() {
		return (EAttribute)staticDoubleTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticDoubleTest_OrderedSetAttribute() {
		return (EAttribute)staticDoubleTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticDoubleTest_SimpleAttribute() {
		return (EAttribute)staticDoubleTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticDoubleTest_OptionalSimpleAttribute() {
		return (EAttribute)staticDoubleTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticDoubleTest_SequenceAttribute() {
		return (EAttribute)staticDoubleTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticDoubleTest_Dummy() {
		return (EAttribute)staticDoubleTestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticFloatTest() {
		return staticFloatTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticFloatTest_SequenceAttribute() {
		return (EAttribute)staticFloatTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticFloatTest_SetAttribute() {
		return (EAttribute)staticFloatTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticFloatTest_OrderedSetAttribute() {
		return (EAttribute)staticFloatTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticFloatTest_SimpleAttribute() {
		return (EAttribute)staticFloatTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticFloatTest_OptionalSimpleAttribute() {
		return (EAttribute)staticFloatTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticFloatTest_Dummy() {
		return (EAttribute)staticFloatTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticFloatTest_BagAttribute() {
		return (EAttribute)staticFloatTestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticIntegerTest() {
		return staticIntegerTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticIntegerTest_SequenceAttribute() {
		return (EAttribute)staticIntegerTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticIntegerTest_SetAttribute() {
		return (EAttribute)staticIntegerTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticIntegerTest_OrderedSetAttribute() {
		return (EAttribute)staticIntegerTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticIntegerTest_SimpleAttribute() {
		return (EAttribute)staticIntegerTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticIntegerTest_OptionalSimpleAttribute() {
		return (EAttribute)staticIntegerTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticIntegerTest_BagAttribute() {
		return (EAttribute)staticIntegerTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticIntegerTest_Dummy() {
		return (EAttribute)staticIntegerTestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticLongTest() {
		return staticLongTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticLongTest_SequenceAttribute() {
		return (EAttribute)staticLongTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticLongTest_SetAttribute() {
		return (EAttribute)staticLongTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticLongTest_OrderedSetAttribute() {
		return (EAttribute)staticLongTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticLongTest_SimpleAttribute() {
		return (EAttribute)staticLongTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticLongTest_OptionalSimpleAttribute() {
		return (EAttribute)staticLongTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticLongTest_BagAttribute() {
		return (EAttribute)staticLongTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticLongTest_Dummy() {
		return (EAttribute)staticLongTestEClass.getEStructuralFeatures().get(6);
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
	public EAttribute getStringTest_SimpleAttribute() {
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
	public EAttribute getStringTest_SequenceAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_SetAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_OrderedSetAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_Dummy() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTest_BagAttribute() {
		return (EAttribute)stringTestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypesStaticTestsFactory getPrimitiveTypesStaticTestsFactory() {
		return (PrimitiveTypesStaticTestsFactory)getEFactoryInstance();
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
		staticBooleanTestEClass = createEClass(STATIC_BOOLEAN_TEST);
		createEAttribute(staticBooleanTestEClass, STATIC_BOOLEAN_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(staticBooleanTestEClass, STATIC_BOOLEAN_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(staticBooleanTestEClass, STATIC_BOOLEAN_TEST__SET_ATTRIBUTE);
		createEAttribute(staticBooleanTestEClass, STATIC_BOOLEAN_TEST__BAG_ATTRIBUTE);
		createEAttribute(staticBooleanTestEClass, STATIC_BOOLEAN_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(staticBooleanTestEClass, STATIC_BOOLEAN_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(staticBooleanTestEClass, STATIC_BOOLEAN_TEST__DUMMY);

		staticDoubleTestEClass = createEClass(STATIC_DOUBLE_TEST);
		createEAttribute(staticDoubleTestEClass, STATIC_DOUBLE_TEST__BAG_ATTRIBUTE);
		createEAttribute(staticDoubleTestEClass, STATIC_DOUBLE_TEST__SET_ATTRIBUTE);
		createEAttribute(staticDoubleTestEClass, STATIC_DOUBLE_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(staticDoubleTestEClass, STATIC_DOUBLE_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(staticDoubleTestEClass, STATIC_DOUBLE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(staticDoubleTestEClass, STATIC_DOUBLE_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(staticDoubleTestEClass, STATIC_DOUBLE_TEST__DUMMY);

		staticFloatTestEClass = createEClass(STATIC_FLOAT_TEST);
		createEAttribute(staticFloatTestEClass, STATIC_FLOAT_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(staticFloatTestEClass, STATIC_FLOAT_TEST__SET_ATTRIBUTE);
		createEAttribute(staticFloatTestEClass, STATIC_FLOAT_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(staticFloatTestEClass, STATIC_FLOAT_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(staticFloatTestEClass, STATIC_FLOAT_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(staticFloatTestEClass, STATIC_FLOAT_TEST__DUMMY);
		createEAttribute(staticFloatTestEClass, STATIC_FLOAT_TEST__BAG_ATTRIBUTE);

		staticIntegerTestEClass = createEClass(STATIC_INTEGER_TEST);
		createEAttribute(staticIntegerTestEClass, STATIC_INTEGER_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(staticIntegerTestEClass, STATIC_INTEGER_TEST__SET_ATTRIBUTE);
		createEAttribute(staticIntegerTestEClass, STATIC_INTEGER_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(staticIntegerTestEClass, STATIC_INTEGER_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(staticIntegerTestEClass, STATIC_INTEGER_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(staticIntegerTestEClass, STATIC_INTEGER_TEST__BAG_ATTRIBUTE);
		createEAttribute(staticIntegerTestEClass, STATIC_INTEGER_TEST__DUMMY);

		staticLongTestEClass = createEClass(STATIC_LONG_TEST);
		createEAttribute(staticLongTestEClass, STATIC_LONG_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(staticLongTestEClass, STATIC_LONG_TEST__SET_ATTRIBUTE);
		createEAttribute(staticLongTestEClass, STATIC_LONG_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(staticLongTestEClass, STATIC_LONG_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(staticLongTestEClass, STATIC_LONG_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(staticLongTestEClass, STATIC_LONG_TEST__BAG_ATTRIBUTE);
		createEAttribute(staticLongTestEClass, STATIC_LONG_TEST__DUMMY);

		stringTestEClass = createEClass(STRING_TEST);
		createEAttribute(stringTestEClass, STRING_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__SET_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(stringTestEClass, STRING_TEST__DUMMY);
		createEAttribute(stringTestEClass, STRING_TEST__BAG_ATTRIBUTE);
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
		staticBooleanTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		staticDoubleTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		staticFloatTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		staticIntegerTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		staticLongTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		stringTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());

		// Initialize classes and features; add operations and parameters
		initEClass(staticBooleanTestEClass, StaticBooleanTest.class, "StaticBooleanTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticBooleanTest_SimpleAttribute(), ecorePackage.getEBoolean(), "SimpleAttribute", null, 1, 1, StaticBooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticBooleanTest_OrderedSetAttribute(), ecorePackage.getEBoolean(), "OrderedSetAttribute", null, 0, -1, StaticBooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticBooleanTest_SetAttribute(), ecorePackage.getEBoolean(), "SetAttribute", null, 0, -1, StaticBooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticBooleanTest_BagAttribute(), ecorePackage.getEBoolean(), "BagAttribute", null, 0, -1, StaticBooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticBooleanTest_OptionalSimpleAttribute(), ecorePackage.getEBoolean(), "OptionalSimpleAttribute", null, 0, 1, StaticBooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticBooleanTest_SequenceAttribute(), ecorePackage.getEBoolean(), "SequenceAttribute", null, 0, -1, StaticBooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticBooleanTest_Dummy(), ecorePackage.getEInt(), "Dummy", null, 1, 1, StaticBooleanTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(staticDoubleTestEClass, StaticDoubleTest.class, "StaticDoubleTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticDoubleTest_BagAttribute(), ecorePackage.getEDouble(), "BagAttribute", null, 0, -1, StaticDoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticDoubleTest_SetAttribute(), ecorePackage.getEDouble(), "SetAttribute", null, 0, -1, StaticDoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticDoubleTest_OrderedSetAttribute(), ecorePackage.getEDouble(), "OrderedSetAttribute", null, 0, -1, StaticDoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticDoubleTest_SimpleAttribute(), ecorePackage.getEDouble(), "SimpleAttribute", null, 1, 1, StaticDoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticDoubleTest_OptionalSimpleAttribute(), ecorePackage.getEDouble(), "OptionalSimpleAttribute", null, 0, 1, StaticDoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticDoubleTest_SequenceAttribute(), ecorePackage.getEDouble(), "SequenceAttribute", null, 0, -1, StaticDoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticDoubleTest_Dummy(), ecorePackage.getEInt(), "Dummy", null, 1, 1, StaticDoubleTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(staticFloatTestEClass, StaticFloatTest.class, "StaticFloatTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticFloatTest_SequenceAttribute(), ecorePackage.getEFloat(), "SequenceAttribute", null, 0, -1, StaticFloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticFloatTest_SetAttribute(), ecorePackage.getEFloat(), "SetAttribute", null, 0, -1, StaticFloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticFloatTest_OrderedSetAttribute(), ecorePackage.getEFloat(), "OrderedSetAttribute", null, 0, -1, StaticFloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticFloatTest_SimpleAttribute(), ecorePackage.getEFloat(), "SimpleAttribute", null, 1, 1, StaticFloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticFloatTest_OptionalSimpleAttribute(), ecorePackage.getEFloat(), "OptionalSimpleAttribute", null, 0, 1, StaticFloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticFloatTest_Dummy(), ecorePackage.getEInt(), "Dummy", null, 1, 1, StaticFloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticFloatTest_BagAttribute(), ecorePackage.getEFloat(), "BagAttribute", null, 0, -1, StaticFloatTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(staticIntegerTestEClass, StaticIntegerTest.class, "StaticIntegerTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticIntegerTest_SequenceAttribute(), ecorePackage.getEInt(), "SequenceAttribute", null, 0, -1, StaticIntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticIntegerTest_SetAttribute(), ecorePackage.getEInt(), "SetAttribute", null, 0, -1, StaticIntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticIntegerTest_OrderedSetAttribute(), ecorePackage.getEInt(), "OrderedSetAttribute", null, 0, -1, StaticIntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticIntegerTest_SimpleAttribute(), ecorePackage.getEInt(), "SimpleAttribute", null, 1, 1, StaticIntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticIntegerTest_OptionalSimpleAttribute(), ecorePackage.getEInt(), "OptionalSimpleAttribute", null, 0, 1, StaticIntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticIntegerTest_BagAttribute(), ecorePackage.getEInt(), "BagAttribute", null, 0, -1, StaticIntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticIntegerTest_Dummy(), ecorePackage.getEInt(), "Dummy", null, 1, 1, StaticIntegerTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(staticLongTestEClass, StaticLongTest.class, "StaticLongTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticLongTest_SequenceAttribute(), ecorePackage.getELong(), "SequenceAttribute", null, 0, -1, StaticLongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticLongTest_SetAttribute(), ecorePackage.getELong(), "SetAttribute", null, 0, -1, StaticLongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticLongTest_OrderedSetAttribute(), ecorePackage.getELong(), "OrderedSetAttribute", null, 0, -1, StaticLongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticLongTest_SimpleAttribute(), ecorePackage.getELong(), "SimpleAttribute", null, 1, 1, StaticLongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticLongTest_OptionalSimpleAttribute(), ecorePackage.getELong(), "OptionalSimpleAttribute", null, 0, 1, StaticLongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticLongTest_BagAttribute(), ecorePackage.getELong(), "BagAttribute", null, 0, -1, StaticLongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStaticLongTest_Dummy(), ecorePackage.getEInt(), "Dummy", null, 1, 1, StaticLongTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stringTestEClass, StringTest.class, "StringTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringTest_SimpleAttribute(), ecorePackage.getEString(), "SimpleAttribute", "", 1, 1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringTest_OptionalSimpleAttribute(), ecorePackage.getEString(), "OptionalSimpleAttribute", "", 0, 1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringTest_SequenceAttribute(), ecorePackage.getEString(), "SequenceAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringTest_SetAttribute(), ecorePackage.getEString(), "SetAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringTest_OrderedSetAttribute(), ecorePackage.getEString(), "OrderedSetAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringTest_Dummy(), ecorePackage.getEInt(), "Dummy", null, 1, 1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringTest_BagAttribute(), ecorePackage.getEString(), "BagAttribute", "", 0, -1, StringTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //PrimitiveTypesStaticTestsPackageImpl
