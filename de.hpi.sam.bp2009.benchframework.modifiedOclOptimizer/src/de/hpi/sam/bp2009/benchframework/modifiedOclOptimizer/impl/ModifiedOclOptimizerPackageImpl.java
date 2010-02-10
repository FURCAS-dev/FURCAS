/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.EmbedModifiedOclOptOperator;
import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizer;
import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerFactory;
import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerPackage;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifiedOclOptimizerPackageImpl extends EPackageImpl implements ModifiedOclOptimizerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiedOclOptimizerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass embedModifiedOclOptOperatorEClass = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModifiedOclOptimizerPackageImpl() {
		super(eNS_URI, ModifiedOclOptimizerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModifiedOclOptimizerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModifiedOclOptimizerPackage init() {
		if (isInited) return (ModifiedOclOptimizerPackage)EPackage.Registry.INSTANCE.getEPackage(ModifiedOclOptimizerPackage.eNS_URI);

		// Obtain or create and register package
		ModifiedOclOptimizerPackageImpl theModifiedOclOptimizerPackage = (ModifiedOclOptimizerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModifiedOclOptimizerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModifiedOclOptimizerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();
		OclEvaluatorPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModifiedOclOptimizerPackage.createPackageContents();

		// Initialize created meta-data
		theModifiedOclOptimizerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModifiedOclOptimizerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModifiedOclOptimizerPackage.eNS_URI, theModifiedOclOptimizerPackage);
		return theModifiedOclOptimizerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiedOclOptimizer() {
		return modifiedOclOptimizerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmbedModifiedOclOptOperator() {
		return embedModifiedOclOptOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedOclOptimizerFactory getModifiedOclOptimizerFactory() {
		return (ModifiedOclOptimizerFactory)getEFactoryInstance();
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
		modifiedOclOptimizerEClass = createEClass(MODIFIED_OCL_OPTIMIZER);

		embedModifiedOclOptOperatorEClass = createEClass(EMBED_MODIFIED_OCL_OPT_OPERATOR);
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
		OclEvaluatorPackage theOclEvaluatorPackage = (OclEvaluatorPackage)EPackage.Registry.INSTANCE.getEPackage(OclEvaluatorPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		BenchframeworkPackage theBenchframeworkPackage = (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modifiedOclOptimizerEClass.getESuperTypes().add(theOclEvaluatorPackage.getOCLEvaluator());
		embedModifiedOclOptOperatorEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());

		// Initialize classes and features; add operations and parameters
		initEClass(modifiedOclOptimizerEClass, ModifiedOclOptimizer.class, "ModifiedOclOptimizer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(modifiedOclOptimizerEClass, null, "sendBenchmarkNotification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "communicationPartner", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "incoming", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(embedModifiedOclOptOperatorEClass, EmbedModifiedOclOptOperator.class, "EmbedModifiedOclOptOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ModifiedOclOptimizerPackageImpl
