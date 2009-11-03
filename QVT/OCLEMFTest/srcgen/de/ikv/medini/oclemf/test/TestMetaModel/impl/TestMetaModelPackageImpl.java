/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.impl;

import de.ikv.medini.kernel.KernelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.PrimitiveTypesStaticTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.impl.PrimitiveTypesTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsPackageImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelFactory;
import de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.TopLevelDummyClass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestMetaModelPackageImpl extends EPackageImpl implements TestMetaModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelDummyClassEClass = null;

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
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestMetaModelPackageImpl() {
		super(eNS_URI, TestMetaModelFactory.eINSTANCE);
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
	public static TestMetaModelPackage init() {
		if (isInited) return (TestMetaModelPackage)EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI);

		// Obtain or create and register package
		TestMetaModelPackageImpl theTestMetaModelPackage = (TestMetaModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof TestMetaModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new TestMetaModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KernelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ClassifierTestPackageImpl theClassifierTestPackage = (ClassifierTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) instanceof ClassifierTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI) : ClassifierTestPackage.eINSTANCE);
		DataTypeTestsPackageImpl theDataTypeTestsPackage = (DataTypeTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) instanceof DataTypeTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) : DataTypeTestsPackage.eINSTANCE);
		PrimitiveTypesTestsPackageImpl thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) instanceof PrimitiveTypesTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) : PrimitiveTypesTestsPackage.eINSTANCE);
		PrimitiveTypesStaticTestsPackageImpl thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) instanceof PrimitiveTypesStaticTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) : PrimitiveTypesStaticTestsPackage.eINSTANCE);
		RelationshipTestsPackageImpl theRelationshipTestsPackage = (RelationshipTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) instanceof RelationshipTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) : RelationshipTestsPackage.eINSTANCE);

		// Create package meta-data objects
		theTestMetaModelPackage.createPackageContents();
		theClassifierTestPackage.createPackageContents();
		theDataTypeTestsPackage.createPackageContents();
		thePrimitiveTypesTestsPackage.createPackageContents();
		thePrimitiveTypesStaticTestsPackage.createPackageContents();
		theRelationshipTestsPackage.createPackageContents();

		// Initialize created meta-data
		theTestMetaModelPackage.initializePackageContents();
		theClassifierTestPackage.initializePackageContents();
		theDataTypeTestsPackage.initializePackageContents();
		thePrimitiveTypesTestsPackage.initializePackageContents();
		thePrimitiveTypesStaticTestsPackage.initializePackageContents();
		theRelationshipTestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestMetaModelPackage.freeze();

		return theTestMetaModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelDummyClass() {
		return topLevelDummyClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestMetaModelFactory getTestMetaModelFactory() {
		return (TestMetaModelFactory)getEFactoryInstance();
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
		topLevelDummyClassEClass = createEClass(TOP_LEVEL_DUMMY_CLASS);
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
		ClassifierTestPackage theClassifierTestPackage = (ClassifierTestPackage)EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI);
		DataTypeTestsPackage theDataTypeTestsPackage = (DataTypeTestsPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI);
		PrimitiveTypesTestsPackage thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI);
		PrimitiveTypesStaticTestsPackage thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI);
		RelationshipTestsPackage theRelationshipTestsPackage = (RelationshipTestsPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theClassifierTestPackage);
		getESubpackages().add(theDataTypeTestsPackage);
		getESubpackages().add(thePrimitiveTypesTestsPackage);
		getESubpackages().add(thePrimitiveTypesStaticTestsPackage);
		getESubpackages().add(theRelationshipTestsPackage);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(topLevelDummyClassEClass, TopLevelDummyClass.class, "TopLevelDummyClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TestMetaModelPackageImpl
