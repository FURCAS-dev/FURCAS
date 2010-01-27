/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomGeneratorPackageImpl extends EPackageImpl implements RandomGeneratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomGeneratorOptionObjectEClass = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RandomGeneratorPackageImpl() {
		super(eNS_URI, RandomGeneratorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RandomGeneratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RandomGeneratorPackage init() {
		if (isInited) return (RandomGeneratorPackage)EPackage.Registry.INSTANCE.getEPackage(RandomGeneratorPackage.eNS_URI);

		// Obtain or create and register package
		RandomGeneratorPackageImpl theRandomGeneratorPackage = (RandomGeneratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RandomGeneratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RandomGeneratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) instanceof EcorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) : EcorePackage.eINSTANCE);

		// Create package meta-data objects
		theRandomGeneratorPackage.createPackageContents();
		theEcorePackage.createPackageContents();

		// Initialize created meta-data
		theRandomGeneratorPackage.initializePackageContents();
		theEcorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRandomGeneratorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RandomGeneratorPackage.eNS_URI, theRandomGeneratorPackage);
		return theRandomGeneratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomGenerator() {
		return randomGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomGeneratorOptionObject() {
		return randomGeneratorOptionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRandomGeneratorOptionObject_MetaModel() {
		return (EReference)randomGeneratorOptionObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomGeneratorFactory getRandomGeneratorFactory() {
		return (RandomGeneratorFactory)getEFactoryInstance();
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
		randomGeneratorEClass = createEClass(RANDOM_GENERATOR);

		randomGeneratorOptionObjectEClass = createEClass(RANDOM_GENERATOR_OPTION_OBJECT);
		createEReference(randomGeneratorOptionObjectEClass, RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		randomGeneratorEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
		randomGeneratorOptionObjectEClass.getESuperTypes().add(theBenchframeworkPackage.getOptionObject());

		// Initialize classes and features; add operations and parameters
		initEClass(randomGeneratorEClass, RandomGenerator.class, "RandomGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomGeneratorOptionObjectEClass, RandomGeneratorOptionObject.class, "RandomGeneratorOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRandomGeneratorOptionObject_MetaModel(), theEcorePackage.getEPackage(), null, "metaModel", null, 0, 1, RandomGeneratorOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RandomGeneratorPackageImpl
