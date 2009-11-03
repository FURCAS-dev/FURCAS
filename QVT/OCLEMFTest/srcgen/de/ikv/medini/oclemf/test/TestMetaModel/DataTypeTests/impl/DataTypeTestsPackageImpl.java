/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl;

import de.ikv.medini.kernel.KernelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsFactory;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.PrimitiveTypesStaticTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.impl.PrimitiveTypesTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.impl.TestMetaModelPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataTypeTestsPackageImpl extends EPackageImpl implements DataTypeTestsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureTestTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enumerationTestTypeEEnum = null;

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
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataTypeTestsPackageImpl() {
		super(eNS_URI, DataTypeTestsFactory.eINSTANCE);
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
	public static DataTypeTestsPackage init() {
		if (isInited) return (DataTypeTestsPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI);

		// Obtain or create and register package
		DataTypeTestsPackageImpl theDataTypeTestsPackage = (DataTypeTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DataTypeTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DataTypeTestsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KernelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TestMetaModelPackageImpl theTestMetaModelPackage = (TestMetaModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) instanceof TestMetaModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) : TestMetaModelPackage.eINSTANCE);
		ClassifierTestPackageImpl theClassifierTestPackage = (ClassifierTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) instanceof ClassifierTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) : ClassifierTestPackage.eINSTANCE);
		PrimitiveTypesTestsPackageImpl thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) instanceof PrimitiveTypesTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) : PrimitiveTypesTestsPackage.eINSTANCE);
		PrimitiveTypesStaticTestsPackageImpl thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) instanceof PrimitiveTypesStaticTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) : PrimitiveTypesStaticTestsPackage.eINSTANCE);
		RelationshipTestsPackageImpl theRelationshipTestsPackage = (RelationshipTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) instanceof RelationshipTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) : RelationshipTestsPackage.eINSTANCE);

		// Create package meta-data objects
		theDataTypeTestsPackage.createPackageContents();
		theTestMetaModelPackage.createPackageContents();
		theClassifierTestPackage.createPackageContents();
		thePrimitiveTypesTestsPackage.createPackageContents();
		thePrimitiveTypesStaticTestsPackage.createPackageContents();
		theRelationshipTestsPackage.createPackageContents();

		// Initialize created meta-data
		theDataTypeTestsPackage.initializePackageContents();
		theTestMetaModelPackage.initializePackageContents();
		theClassifierTestPackage.initializePackageContents();
		thePrimitiveTypesTestsPackage.initializePackageContents();
		thePrimitiveTypesStaticTestsPackage.initializePackageContents();
		theRelationshipTestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataTypeTestsPackage.freeze();

		return theDataTypeTestsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationTest() {
		return enumerationTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationTest_SequenceAttribute() {
		return (EAttribute)enumerationTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationTest_SetAttribute() {
		return (EAttribute)enumerationTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationTest_OrderedSetAttribute() {
		return (EAttribute)enumerationTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationTest_SimpleAttribute() {
		return (EAttribute)enumerationTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationTest_OptionalSimpleAttribute() {
		return (EAttribute)enumerationTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationTest_BagAttribute() {
		return (EAttribute)enumerationTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureTest() {
		return structureTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureTest_SequenceAttribute() {
		return (EReference)structureTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureTest_SetAttribute() {
		return (EReference)structureTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureTest_OrderedSetAttribute() {
		return (EReference)structureTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureTest_SimpleAttribute() {
		return (EReference)structureTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureTest_OptionalSimpleAttribute() {
		return (EReference)structureTestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureTest_BagAttribute() {
		return (EReference)structureTestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureTestType() {
		return structureTestTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureTestType_IntegerStructField() {
		return (EAttribute)structureTestTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureTestType_EnumStructField() {
		return (EAttribute)structureTestTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureTestType_StringStructField() {
		return (EAttribute)structureTestTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureTestType_BooleanStructField() {
		return (EAttribute)structureTestTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureTestType_FloatStructureField() {
		return (EAttribute)structureTestTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureTestType_DoubleStructureField() {
		return (EAttribute)structureTestTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureTestType_LongStructField() {
		return (EAttribute)structureTestTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureTestType_ClassStructField() {
		return (EReference)structureTestTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnumerationTestType() {
		return enumerationTestTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeTestsFactory getDataTypeTestsFactory() {
		return (DataTypeTestsFactory)getEFactoryInstance();
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
		enumerationTestEClass = createEClass(ENUMERATION_TEST);
		createEAttribute(enumerationTestEClass, ENUMERATION_TEST__SEQUENCE_ATTRIBUTE);
		createEAttribute(enumerationTestEClass, ENUMERATION_TEST__SET_ATTRIBUTE);
		createEAttribute(enumerationTestEClass, ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE);
		createEAttribute(enumerationTestEClass, ENUMERATION_TEST__SIMPLE_ATTRIBUTE);
		createEAttribute(enumerationTestEClass, ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEAttribute(enumerationTestEClass, ENUMERATION_TEST__BAG_ATTRIBUTE);

		structureTestEClass = createEClass(STRUCTURE_TEST);
		createEReference(structureTestEClass, STRUCTURE_TEST__SEQUENCE_ATTRIBUTE);
		createEReference(structureTestEClass, STRUCTURE_TEST__SET_ATTRIBUTE);
		createEReference(structureTestEClass, STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE);
		createEReference(structureTestEClass, STRUCTURE_TEST__SIMPLE_ATTRIBUTE);
		createEReference(structureTestEClass, STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE);
		createEReference(structureTestEClass, STRUCTURE_TEST__BAG_ATTRIBUTE);

		structureTestTypeEClass = createEClass(STRUCTURE_TEST_TYPE);
		createEAttribute(structureTestTypeEClass, STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD);
		createEAttribute(structureTestTypeEClass, STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD);
		createEAttribute(structureTestTypeEClass, STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD);
		createEAttribute(structureTestTypeEClass, STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD);
		createEAttribute(structureTestTypeEClass, STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD);
		createEAttribute(structureTestTypeEClass, STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD);
		createEAttribute(structureTestTypeEClass, STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD);
		createEReference(structureTestTypeEClass, STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD);

		// Create enums
		enumerationTestTypeEEnum = createEEnum(ENUMERATION_TEST_TYPE);
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
		PrimitiveTypesTestsPackage thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI);

		// Add supertypes to classes
		enumerationTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		structureTestEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		structureTestTypeEClass.getESuperTypes().add(theKernelPackage.getMediniObject());

		// Initialize classes and features; add operations and parameters
		initEClass(enumerationTestEClass, EnumerationTest.class, "EnumerationTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationTest_SequenceAttribute(), this.getEnumerationTestType(), "SequenceAttribute", null, 0, -1, EnumerationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerationTest_SetAttribute(), this.getEnumerationTestType(), "SetAttribute", null, 0, -1, EnumerationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEnumerationTest_OrderedSetAttribute(), this.getEnumerationTestType(), "OrderedSetAttribute", null, 0, -1, EnumerationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerationTest_SimpleAttribute(), this.getEnumerationTestType(), "SimpleAttribute", null, 1, 1, EnumerationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEnumerationTest_OptionalSimpleAttribute(), this.getEnumerationTestType(), "OptionalSimpleAttribute", null, 0, 1, EnumerationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEnumerationTest_BagAttribute(), this.getEnumerationTestType(), "BagAttribute", null, 0, -1, EnumerationTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(structureTestEClass, StructureTest.class, "StructureTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureTest_SequenceAttribute(), this.getStructureTestType(), null, "SequenceAttribute", null, 0, -1, StructureTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureTest_SetAttribute(), this.getStructureTestType(), null, "SetAttribute", null, 0, -1, StructureTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStructureTest_OrderedSetAttribute(), this.getStructureTestType(), null, "OrderedSetAttribute", null, 1, -1, StructureTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureTest_SimpleAttribute(), this.getStructureTestType(), null, "SimpleAttribute", null, 1, 1, StructureTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStructureTest_OptionalSimpleAttribute(), this.getStructureTestType(), null, "OptionalSimpleAttribute", null, 0, 1, StructureTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStructureTest_BagAttribute(), this.getStructureTestType(), null, "BagAttribute", null, 0, -1, StructureTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(structureTestTypeEClass, StructureTestType.class, "StructureTestType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStructureTestType_IntegerStructField(), ecorePackage.getEInt(), "IntegerStructField", null, 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStructureTestType_EnumStructField(), this.getEnumerationTestType(), "EnumStructField", null, 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStructureTestType_StringStructField(), ecorePackage.getEString(), "StringStructField", "", 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStructureTestType_BooleanStructField(), ecorePackage.getEBoolean(), "BooleanStructField", null, 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStructureTestType_FloatStructureField(), ecorePackage.getEFloat(), "FloatStructureField", null, 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStructureTestType_DoubleStructureField(), ecorePackage.getEDouble(), "DoubleStructureField", null, 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStructureTestType_LongStructField(), ecorePackage.getELong(), "LongStructField", null, 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStructureTestType_ClassStructField(), thePrimitiveTypesTestsPackage.getStringTest(), null, "ClassStructField", null, 1, 1, StructureTestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(enumerationTestTypeEEnum, EnumerationTestType.class, "EnumerationTestType");
		addEEnumLiteral(enumerationTestTypeEEnum, EnumerationTestType.LABEL3_LITERAL);
		addEEnumLiteral(enumerationTestTypeEEnum, EnumerationTestType.LABEL4_LITERAL);
		addEEnumLiteral(enumerationTestTypeEEnum, EnumerationTestType.LABEL1_LITERAL);
		addEEnumLiteral(enumerationTestTypeEEnum, EnumerationTestType.LABEL2_LITERAL);
	}

} //DataTypeTestsPackageImpl
