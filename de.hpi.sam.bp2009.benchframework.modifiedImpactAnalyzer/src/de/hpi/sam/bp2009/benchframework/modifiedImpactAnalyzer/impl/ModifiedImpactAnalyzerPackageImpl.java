/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.EmbedModifiedIAOperator;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.IncomingEventNotification;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerFactory;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.OutgoingResultNotification;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifiedImpactAnalyzerPackageImpl extends EPackageImpl implements ModifiedImpactAnalyzerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiedImpactAnalyzerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incomingEventNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outgoingResultNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass embedModifiedIAOperatorEClass = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModifiedImpactAnalyzerPackageImpl() {
		super(eNS_URI, ModifiedImpactAnalyzerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModifiedImpactAnalyzerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModifiedImpactAnalyzerPackage init() {
		if (isInited) return (ModifiedImpactAnalyzerPackage)EPackage.Registry.INSTANCE.getEPackage(ModifiedImpactAnalyzerPackage.eNS_URI);

		// Obtain or create and register package
		ModifiedImpactAnalyzerPackageImpl theModifiedImpactAnalyzerPackage = (ModifiedImpactAnalyzerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModifiedImpactAnalyzerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModifiedImpactAnalyzerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();
		ImpactAnalyzerPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModifiedImpactAnalyzerPackage.createPackageContents();

		// Initialize created meta-data
		theModifiedImpactAnalyzerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModifiedImpactAnalyzerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModifiedImpactAnalyzerPackage.eNS_URI, theModifiedImpactAnalyzerPackage);
		return theModifiedImpactAnalyzerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiedImpactAnalyzer() {
		return modifiedImpactAnalyzerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncomingEventNotification() {
		return incomingEventNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutgoingResultNotification() {
		return outgoingResultNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmbedModifiedIAOperator() {
		return embedModifiedIAOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedImpactAnalyzerFactory getModifiedImpactAnalyzerFactory() {
		return (ModifiedImpactAnalyzerFactory)getEFactoryInstance();
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
		modifiedImpactAnalyzerEClass = createEClass(MODIFIED_IMPACT_ANALYZER);

		incomingEventNotificationEClass = createEClass(INCOMING_EVENT_NOTIFICATION);

		outgoingResultNotificationEClass = createEClass(OUTGOING_RESULT_NOTIFICATION);

		embedModifiedIAOperatorEClass = createEClass(EMBED_MODIFIED_IA_OPERATOR);
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
		ImpactAnalyzerPackage theImpactAnalyzerPackage = (ImpactAnalyzerPackage)EPackage.Registry.INSTANCE.getEPackage(ImpactAnalyzerPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		EventManagerPackage theEventManagerPackage = (EventManagerPackage)EPackage.Registry.INSTANCE.getEPackage(EventManagerPackage.eNS_URI);
		BenchframeworkPackage theBenchframeworkPackage = (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modifiedImpactAnalyzerEClass.getESuperTypes().add(theImpactAnalyzerPackage.getImpactAnalyzer());
		incomingEventNotificationEClass.getESuperTypes().add(theEventManagerPackage.getEventNotification());
		outgoingResultNotificationEClass.getESuperTypes().add(theEventManagerPackage.getEventNotification());
		embedModifiedIAOperatorEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());

		// Initialize classes and features; add operations and parameters
		initEClass(modifiedImpactAnalyzerEClass, ModifiedImpactAnalyzer.class, "ModifiedImpactAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(modifiedImpactAnalyzerEClass, null, "sendBenchmarkNotification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "communicationPartner", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "incoming", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(incomingEventNotificationEClass, IncomingEventNotification.class, "IncomingEventNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outgoingResultNotificationEClass, OutgoingResultNotification.class, "OutgoingResultNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(embedModifiedIAOperatorEClass, EmbedModifiedIAOperator.class, "EmbedModifiedIAOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ModifiedImpactAnalyzerPackageImpl
