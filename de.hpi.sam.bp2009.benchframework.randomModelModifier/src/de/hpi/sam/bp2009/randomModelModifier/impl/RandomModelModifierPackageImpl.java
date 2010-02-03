/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierFactory;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage;

import de.hpi.sam.bp2009.randomModelModifier.tasks;
import java.util.Random;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomModelModifierPackageImpl extends EPackageImpl implements RandomModelModifierPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomModelModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomModelModifierOptionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tasksEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType randomEDataType = null;

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
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RandomModelModifierPackageImpl() {
		super(eNS_URI, RandomModelModifierFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RandomModelModifierPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RandomModelModifierPackage init() {
		if (isInited) return (RandomModelModifierPackage)EPackage.Registry.INSTANCE.getEPackage(RandomModelModifierPackage.eNS_URI);

		// Obtain or create and register package
		RandomModelModifierPackageImpl theRandomModelModifierPackage = (RandomModelModifierPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RandomModelModifierPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RandomModelModifierPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRandomModelModifierPackage.createPackageContents();

		// Initialize created meta-data
		theRandomModelModifierPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRandomModelModifierPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RandomModelModifierPackage.eNS_URI, theRandomModelModifierPackage);
		return theRandomModelModifierPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomModelModifier() {
		return randomModelModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomModelModifier_RandomNumberGenerator() {
		return (EAttribute)randomModelModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomModelModifierOptionObject() {
		return randomModelModifierOptionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomModelModifierOptionObject_Times() {
		return (EAttribute)randomModelModifierOptionObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomModelModifierOptionObject_Task() {
		return (EAttribute)randomModelModifierOptionObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum gettasks() {
		return tasksEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRandom() {
		return randomEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomModelModifierFactory getRandomModelModifierFactory() {
		return (RandomModelModifierFactory)getEFactoryInstance();
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
		randomModelModifierEClass = createEClass(RANDOM_MODEL_MODIFIER);
		createEAttribute(randomModelModifierEClass, RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR);

		randomModelModifierOptionObjectEClass = createEClass(RANDOM_MODEL_MODIFIER_OPTION_OBJECT);
		createEAttribute(randomModelModifierOptionObjectEClass, RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES);
		createEAttribute(randomModelModifierOptionObjectEClass, RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK);

		// Create enums
		tasksEEnum = createEEnum(TASKS);

		// Create data types
		randomEDataType = createEDataType(RANDOM);
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
		BenchframeworkPackage theBenchframeworkPackage = (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		randomModelModifierEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
		randomModelModifierOptionObjectEClass.getESuperTypes().add(theBenchframeworkPackage.getOptionObject());

		// Initialize classes and features; add operations and parameters
		initEClass(randomModelModifierEClass, RandomModelModifier.class, "RandomModelModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomModelModifier_RandomNumberGenerator(), this.getRandom(), "RandomNumberGenerator", null, 0, 1, RandomModelModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomModelModifierOptionObjectEClass, RandomModelModifierOptionObject.class, "RandomModelModifierOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomModelModifierOptionObject_Times(), ecorePackage.getEIntegerObject(), "times", null, 0, 1, RandomModelModifierOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomModelModifierOptionObject_Task(), this.gettasks(), "task", null, 0, 1, RandomModelModifierOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(tasksEEnum, tasks.class, "tasks");
		addEEnumLiteral(tasksEEnum, tasks.CLASS_DELETE);
		addEEnumLiteral(tasksEEnum, tasks.CLASS_CREATE);
		addEEnumLiteral(tasksEEnum, tasks.REFERENCE_DELETE);
		addEEnumLiteral(tasksEEnum, tasks.REFERENCE_CREATE);
		addEEnumLiteral(tasksEEnum, tasks.MODIFY_ATTRIBUTE);

		// Initialize data types
		initEDataType(randomEDataType, Random.class, "Random", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //RandomModelModifierPackageImpl
