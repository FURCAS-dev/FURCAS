/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.EcorePackage;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImpactAnalyzerPackageImpl extends EPackageImpl implements ImpactAnalyzerPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impactAnalyzerEClass = null;
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
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImpactAnalyzerPackageImpl() {
		super(eNS_URI, ImpactAnalyzerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ImpactAnalyzerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImpactAnalyzerPackage init() {
		if (isInited) return (ImpactAnalyzerPackage)EPackage.Registry.INSTANCE.getEPackage(ImpactAnalyzerPackage.eNS_URI);

		// Obtain or create and register package
		ImpactAnalyzerPackageImpl theImpactAnalyzerPackage = (ImpactAnalyzerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ImpactAnalyzerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ImpactAnalyzerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EventManagerPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImpactAnalyzerPackage.createPackageContents();

		// Initialize created meta-data
		theImpactAnalyzerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImpactAnalyzerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImpactAnalyzerPackage.eNS_URI, theImpactAnalyzerPackage);
		return theImpactAnalyzerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpactAnalyzer() {
		return impactAnalyzerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactAnalyzerFactory getImpactAnalyzerFactory() {
		return (ImpactAnalyzerFactory)getEFactoryInstance();
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
		impactAnalyzerEClass = createEClass(IMPACT_ANALYZER);
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
		EventManagerPackage theEventManagerPackage = (EventManagerPackage)EPackage.Registry.INSTANCE.getEPackage(EventManagerPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(impactAnalyzerEClass, ImpactAnalyzer.class, "ImpactAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(impactAnalyzerEClass, theEventManagerPackage.getEventFilter(), "createFilterForQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getOCLExpression(), "query", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(impactAnalyzerEClass, theEcorePackage.getOCLExpression(), "getContextObjects", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEventManagerPackage.getEventNotification(), "event", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getOCLExpression(), "query", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
	

} //ImpactAnalyzerPackageImpl
