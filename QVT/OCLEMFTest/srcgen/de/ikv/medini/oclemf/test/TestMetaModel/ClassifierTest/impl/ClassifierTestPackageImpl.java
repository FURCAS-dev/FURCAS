/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl;

import de.ikv.medini.kernel.KernelPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass;
import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestFactory;
import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass;
import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsPackageImpl;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassifierTestPackageImpl extends EPackageImpl implements ClassifierTestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSuperClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass superClassEClass = null;

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
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ClassifierTestPackageImpl() {
		super(eNS_URI, ClassifierTestFactory.eINSTANCE);
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
	public static ClassifierTestPackage init() {
		if (isInited) return (ClassifierTestPackage)EPackage.Registry.INSTANCE.getEPackage(ClassifierTestPackage.eNS_URI);

		// Obtain or create and register package
		ClassifierTestPackageImpl theClassifierTestPackage = (ClassifierTestPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ClassifierTestPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ClassifierTestPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KernelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TestMetaModelPackageImpl theTestMetaModelPackage = (TestMetaModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) instanceof TestMetaModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestMetaModelPackage.eNS_URI) : TestMetaModelPackage.eINSTANCE);
		DataTypeTestsPackageImpl theDataTypeTestsPackage = (DataTypeTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) instanceof DataTypeTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataTypeTestsPackage.eNS_URI) : DataTypeTestsPackage.eINSTANCE);
		PrimitiveTypesTestsPackageImpl thePrimitiveTypesTestsPackage = (PrimitiveTypesTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) instanceof PrimitiveTypesTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesTestsPackage.eNS_URI) : PrimitiveTypesTestsPackage.eINSTANCE);
		PrimitiveTypesStaticTestsPackageImpl thePrimitiveTypesStaticTestsPackage = (PrimitiveTypesStaticTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) instanceof PrimitiveTypesStaticTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesStaticTestsPackage.eNS_URI) : PrimitiveTypesStaticTestsPackage.eINSTANCE);
		RelationshipTestsPackageImpl theRelationshipTestsPackage = (RelationshipTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) instanceof RelationshipTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipTestsPackage.eNS_URI) : RelationshipTestsPackage.eINSTANCE);

		// Create package meta-data objects
		theClassifierTestPackage.createPackageContents();
		theTestMetaModelPackage.createPackageContents();
		theDataTypeTestsPackage.createPackageContents();
		thePrimitiveTypesTestsPackage.createPackageContents();
		thePrimitiveTypesStaticTestsPackage.createPackageContents();
		theRelationshipTestsPackage.createPackageContents();

		// Initialize created meta-data
		theClassifierTestPackage.initializePackageContents();
		theTestMetaModelPackage.initializePackageContents();
		theDataTypeTestsPackage.initializePackageContents();
		thePrimitiveTypesTestsPackage.initializePackageContents();
		thePrimitiveTypesStaticTestsPackage.initializePackageContents();
		theRelationshipTestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theClassifierTestPackage.freeze();

		return theClassifierTestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSuperClass() {
		return abstractSuperClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSuperClass_SubClass() {
		return (EReference)abstractSuperClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSuperClass_AbstractSuperName() {
		return (EAttribute)abstractSuperClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubClass() {
		return subClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubClass_SubName() {
		return (EAttribute)subClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubClass_AbstractSuperClass() {
		return (EReference)subClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSuperClass() {
		return superClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSuperClass_SuperName() {
		return (EAttribute)superClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierTestFactory getClassifierTestFactory() {
		return (ClassifierTestFactory)getEFactoryInstance();
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
		abstractSuperClassEClass = createEClass(ABSTRACT_SUPER_CLASS);
		createEReference(abstractSuperClassEClass, ABSTRACT_SUPER_CLASS__SUB_CLASS);
		createEAttribute(abstractSuperClassEClass, ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME);

		subClassEClass = createEClass(SUB_CLASS);
		createEAttribute(subClassEClass, SUB_CLASS__SUB_NAME);
		createEReference(subClassEClass, SUB_CLASS__ABSTRACT_SUPER_CLASS);

		superClassEClass = createEClass(SUPER_CLASS);
		createEAttribute(superClassEClass, SUPER_CLASS__SUPER_NAME);
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
		abstractSuperClassEClass.getESuperTypes().add(theKernelPackage.getMediniObject());
		subClassEClass.getESuperTypes().add(this.getSuperClass());
		superClassEClass.getESuperTypes().add(this.getAbstractSuperClass());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractSuperClassEClass, AbstractSuperClass.class, "AbstractSuperClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractSuperClass_SubClass(), this.getSubClass(), this.getSubClass_AbstractSuperClass(), "subClass", null, 0, -1, AbstractSuperClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractSuperClass_AbstractSuperName(), ecorePackage.getEString(), "AbstractSuperName", "", 1, 1, AbstractSuperClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subClassEClass, SubClass.class, "SubClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubClass_SubName(), ecorePackage.getEString(), "SubName", "", 1, 1, SubClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSubClass_AbstractSuperClass(), this.getAbstractSuperClass(), this.getAbstractSuperClass_SubClass(), "abstractSuperClass", null, 0, -1, SubClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(superClassEClass, SuperClass.class, "SuperClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSuperClass_SuperName(), ecorePackage.getEString(), "SuperName", "", 1, 1, SuperClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ClassifierTestPackageImpl
