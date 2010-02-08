/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.EcorePackage;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryReevaluateNotificationEClass = null;

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
		OclEvaluatorPackage.eINSTANCE.eClass();

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
	public EReference getImpactAnalyzer_OclEvaluator() {
		return (EReference)impactAnalyzerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalyzer_EventManager() {
		return (EReference)impactAnalyzerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpactAnalyzer_Queries() {
		return (EAttribute)impactAnalyzerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryReevaluateNotification() {
		return queryReevaluateNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryReevaluateNotification_ReevaluatedQueries() {
		return (EAttribute)queryReevaluateNotificationEClass.getEStructuralFeatures().get(0);
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
		createEReference(impactAnalyzerEClass, IMPACT_ANALYZER__OCL_EVALUATOR);
		createEReference(impactAnalyzerEClass, IMPACT_ANALYZER__EVENT_MANAGER);
		createEAttribute(impactAnalyzerEClass, IMPACT_ANALYZER__QUERIES);

		queryReevaluateNotificationEClass = createEClass(QUERY_REEVALUATE_NOTIFICATION);
		createEAttribute(queryReevaluateNotificationEClass, QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES);
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
		EventManagerPackage theEventManagerPackage = (EventManagerPackage)EPackage.Registry.INSTANCE.getEPackage(EventManagerPackage.eNS_URI);
		org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		queryReevaluateNotificationEClass.getESuperTypes().add(theEventManagerPackage.getEventNotification());

		// Initialize classes and features; add operations and parameters
		initEClass(impactAnalyzerEClass, ImpactAnalyzer.class, "ImpactAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpactAnalyzer_OclEvaluator(), theOclEvaluatorPackage.getOCLEvaluator(), null, "oclEvaluator", null, 0, 1, ImpactAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalyzer_EventManager(), theEventManagerPackage.getEventManager(), null, "eventManager", null, 0, 1, ImpactAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(theOclEvaluatorPackage.getOclQuery());
		g1.getETypeArguments().add(g2);
		initEAttribute(getImpactAnalyzer_Queries(), g1, "queries", null, 0, 1, ImpactAnalyzer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(impactAnalyzerEClass, null, "handleInternalEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage_1.getEEList());
		g2 = createEGenericType(theOclEvaluatorPackage.getOclQuery());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "queries", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEventManagerPackage.getEventNotification(), "eventNotification", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(impactAnalyzerEClass, null, "notifyApplication", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEventManagerPackage.getAdapter(), "application", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getQueryReevaluateNotification(), "msg", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(impactAnalyzerEClass, null, "register", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEventManagerPackage.getNotifier(), "root", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEventManagerPackage.getAdapter(), "receiver", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(theOclEvaluatorPackage.getOclQuery());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "oclQueries", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(queryReevaluateNotificationEClass, QueryReevaluateNotification.class, "QueryReevaluateNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theEcorePackage_1.getEEList());
		g2 = createEGenericType(theOclEvaluatorPackage.getOclQuery());
		g1.getETypeArguments().add(g2);
		initEAttribute(getQueryReevaluateNotification_ReevaluatedQueries(), g1, "reevaluatedQueries", null, 0, 1, QueryReevaluateNotification.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
	

} //ImpactAnalyzerPackageImpl
