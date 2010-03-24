/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessor;
import de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessorFactory;
import de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessorPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CsvResultProcessorPackageImpl extends EPackageImpl implements CsvResultProcessorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass csvResultProcessorEClass = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CsvResultProcessorPackageImpl() {
		super(eNS_URI, CsvResultProcessorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CsvResultProcessorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CsvResultProcessorPackage init() {
		if (isInited) return (CsvResultProcessorPackage)EPackage.Registry.INSTANCE.getEPackage(CsvResultProcessorPackage.eNS_URI);

		// Obtain or create and register package
		CsvResultProcessorPackageImpl theCsvResultProcessorPackage = (CsvResultProcessorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CsvResultProcessorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CsvResultProcessorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCsvResultProcessorPackage.createPackageContents();

		// Initialize created meta-data
		theCsvResultProcessorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCsvResultProcessorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CsvResultProcessorPackage.eNS_URI, theCsvResultProcessorPackage);
		return theCsvResultProcessorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCsvResultProcessor() {
		return csvResultProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsvResultProcessorFactory getCsvResultProcessorFactory() {
		return (CsvResultProcessorFactory)getEFactoryInstance();
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
		csvResultProcessorEClass = createEClass(CSV_RESULT_PROCESSOR);
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
		csvResultProcessorEClass.getESuperTypes().add(theBenchframeworkPackage.getResultProcessor());

		// Initialize classes and features; add operations and parameters
		initEClass(csvResultProcessorEClass, CsvResultProcessor.class, "CsvResultProcessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CsvResultProcessorPackageImpl
