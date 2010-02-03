/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl;

import de.hpi.sam.bp2009.benchframework.modifiedEventManager.IncomingEventNotification;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerFactory;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.OutgoingEventNotification;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifiedEventManagerPackageImpl extends EPackageImpl implements ModifiedEventManagerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiedEventManagerEClass = null;

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
	private EClass outgoingEventNotificationEClass = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModifiedEventManagerPackageImpl() {
		super(eNS_URI, ModifiedEventManagerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModifiedEventManagerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModifiedEventManagerPackage init() {
		if (isInited) return (ModifiedEventManagerPackage)EPackage.Registry.INSTANCE.getEPackage(ModifiedEventManagerPackage.eNS_URI);

		// Obtain or create and register package
		ModifiedEventManagerPackageImpl theModifiedEventManagerPackage = (ModifiedEventManagerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModifiedEventManagerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModifiedEventManagerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EventManagerPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModifiedEventManagerPackage.createPackageContents();

		// Initialize created meta-data
		theModifiedEventManagerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModifiedEventManagerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModifiedEventManagerPackage.eNS_URI, theModifiedEventManagerPackage);
		return theModifiedEventManagerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiedEventManager() {
		return modifiedEventManagerEClass;
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
	public EClass getOutgoingEventNotification() {
		return outgoingEventNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedEventManagerFactory getModifiedEventManagerFactory() {
		return (ModifiedEventManagerFactory)getEFactoryInstance();
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
		modifiedEventManagerEClass = createEClass(MODIFIED_EVENT_MANAGER);

		incomingEventNotificationEClass = createEClass(INCOMING_EVENT_NOTIFICATION);

		outgoingEventNotificationEClass = createEClass(OUTGOING_EVENT_NOTIFICATION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modifiedEventManagerEClass.getESuperTypes().add(theEventManagerPackage.getEventManager());

		// Initialize classes and features; add operations and parameters
		initEClass(modifiedEventManagerEClass, ModifiedEventManager.class, "ModifiedEventManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(incomingEventNotificationEClass, IncomingEventNotification.class, "IncomingEventNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outgoingEventNotificationEClass, OutgoingEventNotification.class, "OutgoingEventNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ModifiedEventManagerPackageImpl
