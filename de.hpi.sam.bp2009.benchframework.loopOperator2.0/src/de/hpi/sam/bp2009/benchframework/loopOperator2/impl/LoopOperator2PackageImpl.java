/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.loopOperator2.EndLoop;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Factory;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption;
import de.hpi.sam.bp2009.benchframework.loopOperator2.StartLoop;

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
public class LoopOperator2PackageImpl extends EPackageImpl implements LoopOperator2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopOptionEClass = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LoopOperator2PackageImpl() {
		super(eNS_URI, LoopOperator2Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LoopOperator2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LoopOperator2Package init() {
		if (isInited) return (LoopOperator2Package)EPackage.Registry.INSTANCE.getEPackage(LoopOperator2Package.eNS_URI);

		// Obtain or create and register package
		LoopOperator2PackageImpl theLoopOperator2Package = (LoopOperator2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LoopOperator2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LoopOperator2PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLoopOperator2Package.createPackageContents();

		// Initialize created meta-data
		theLoopOperator2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLoopOperator2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LoopOperator2Package.eNS_URI, theLoopOperator2Package);
		return theLoopOperator2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartLoop() {
		return startLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndLoop() {
		return endLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopOption() {
		return loopOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopOption_Repetitions() {
		return (EAttribute)loopOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperator2Factory getLoopOperator2Factory() {
		return (LoopOperator2Factory)getEFactoryInstance();
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
		startLoopEClass = createEClass(START_LOOP);

		endLoopEClass = createEClass(END_LOOP);

		loopOptionEClass = createEClass(LOOP_OPTION);
		createEAttribute(loopOptionEClass, LOOP_OPTION__REPETITIONS);
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
		startLoopEClass.getESuperTypes().add(theBenchframeworkPackage.getStartOperator());
		endLoopEClass.getESuperTypes().add(theBenchframeworkPackage.getEndOperator());
		loopOptionEClass.getESuperTypes().add(theBenchframeworkPackage.getOptionObject());

		// Initialize classes and features; add operations and parameters
		initEClass(startLoopEClass, StartLoop.class, "StartLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endLoopEClass, EndLoop.class, "EndLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopOptionEClass, LoopOption.class, "LoopOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopOption_Repetitions(), ecorePackage.getEIntegerObject(), "repetitions", null, 0, 1, LoopOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LoopOperator2PackageImpl
