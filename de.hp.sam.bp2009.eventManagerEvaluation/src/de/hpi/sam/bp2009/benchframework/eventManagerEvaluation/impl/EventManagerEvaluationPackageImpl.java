/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerEvaluationFactory;
import de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerEvaluationPackage;
import de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerOperator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventManagerEvaluationPackageImpl extends EPackageImpl implements EventManagerEvaluationPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventManagerOperatorEClass = null;

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
     * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerEvaluationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private EventManagerEvaluationPackageImpl() {
        super(eNS_URI, EventManagerEvaluationFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link EventManagerEvaluationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static EventManagerEvaluationPackage init() {
        if (isInited) return (EventManagerEvaluationPackage)EPackage.Registry.INSTANCE.getEPackage(EventManagerEvaluationPackage.eNS_URI);

        // Obtain or create and register package
        EventManagerEvaluationPackageImpl theEventManagerEvaluationPackage = (EventManagerEvaluationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventManagerEvaluationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventManagerEvaluationPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        BenchframeworkPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theEventManagerEvaluationPackage.createPackageContents();

        // Initialize created meta-data
        theEventManagerEvaluationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theEventManagerEvaluationPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(EventManagerEvaluationPackage.eNS_URI, theEventManagerEvaluationPackage);
        return theEventManagerEvaluationPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEventManagerOperator() {
        return eventManagerOperatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventManagerEvaluationFactory getEventManagerEvaluationFactory() {
        return (EventManagerEvaluationFactory)getEFactoryInstance();
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
        eventManagerOperatorEClass = createEClass(EVENT_MANAGER_OPERATOR);
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
        eventManagerOperatorEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());

        // Initialize classes and features; add operations and parameters
        initEClass(eventManagerOperatorEClass, EventManagerOperator.class, "EventManagerOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //EventManagerEvaluationPackageImpl
