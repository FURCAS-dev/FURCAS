/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorEnd;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorFactory;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorStart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoopOperatorPackageImpl extends EPackageImpl implements LoopOperatorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopOperatorStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopOperatorEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopOperatorOptionObjectEClass = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LoopOperatorPackageImpl() {
		super(eNS_URI, LoopOperatorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LoopOperatorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LoopOperatorPackage init() {
		if (isInited) return (LoopOperatorPackage)EPackage.Registry.INSTANCE.getEPackage(LoopOperatorPackage.eNS_URI);

		// Obtain or create and register package
		LoopOperatorPackageImpl theLoopOperatorPackage = (LoopOperatorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LoopOperatorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LoopOperatorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLoopOperatorPackage.createPackageContents();

		// Initialize created meta-data
		theLoopOperatorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLoopOperatorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LoopOperatorPackage.eNS_URI, theLoopOperatorPackage);
		return theLoopOperatorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopOperatorStart() {
		return loopOperatorStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopOperatorEnd() {
		return loopOperatorEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopOperatorOptionObject() {
		return loopOperatorOptionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopOperatorOptionObject_LoopCount() {
		return (EAttribute)loopOperatorOptionObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopOperatorOptionObject_Operator() {
		return (EReference)loopOperatorOptionObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperatorFactory getLoopOperatorFactory() {
		return (LoopOperatorFactory)getEFactoryInstance();
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
		loopOperatorStartEClass = createEClass(LOOP_OPERATOR_START);

		loopOperatorEndEClass = createEClass(LOOP_OPERATOR_END);

		loopOperatorOptionObjectEClass = createEClass(LOOP_OPERATOR_OPTION_OBJECT);
		createEAttribute(loopOperatorOptionObjectEClass, LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT);
		createEReference(loopOperatorOptionObjectEClass, LOOP_OPERATOR_OPTION_OBJECT__OPERATOR);
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
		loopOperatorStartEClass.getESuperTypes().add(theBenchframeworkPackage.getStartOperator());
		loopOperatorEndEClass.getESuperTypes().add(theBenchframeworkPackage.getEndOperator());
		loopOperatorOptionObjectEClass.getESuperTypes().add(theBenchframeworkPackage.getStartAndEndOperatorOptionObject());

		// Initialize classes and features; add operations and parameters
		initEClass(loopOperatorStartEClass, LoopOperatorStart.class, "LoopOperatorStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopOperatorEndEClass, LoopOperatorEnd.class, "LoopOperatorEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopOperatorOptionObjectEClass, LoopOperatorOptionObject.class, "LoopOperatorOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopOperatorOptionObject_LoopCount(), ecorePackage.getEInt(), "loopCount", null, 0, 1, LoopOperatorOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopOperatorOptionObject_Operator(), theBenchframeworkPackage.getOperator(), null, "operator", null, 0, 1, LoopOperatorOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LoopOperatorPackageImpl
