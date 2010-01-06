/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.events.impl;

import de.hpi.sam.bp2009.solution.events.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.events.ElementChangeEvent;
import de.hpi.sam.bp2009.solution.events.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.events.ElementDeleteEvent;
import de.hpi.sam.bp2009.solution.events.ElementLifeCycleEvent;
import de.hpi.sam.bp2009.solution.events.EventsFactory;
import de.hpi.sam.bp2009.solution.events.EventsPackage;
import de.hpi.sam.bp2009.solution.events.LinkCreateEvent;
import de.hpi.sam.bp2009.solution.events.LinkDeleteEvent;
import de.hpi.sam.bp2009.solution.events.LinkLifeCycleEvent;
import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

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
public class EventsPackageImpl extends EPackageImpl implements EventsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelChangeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementChangeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueChangeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementLifeCycleEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkLifeCycleEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementCreateEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementDeleteEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkCreateEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkDeleteEventEClass = null;

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
	 * @see de.hpi.sam.bp2009.solution.events.EventsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventsPackageImpl() {
		super(eNS_URI, EventsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EventsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EventsPackage init() {
		if (isInited) return (EventsPackage)EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);

		// Obtain or create and register package
		EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEventsPackage.createPackageContents();

		// Initialize created meta-data
		theEventsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventsPackage.eNS_URI, theEventsPackage);
		return theEventsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelChangeEvent() {
		return modelChangeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelChangeEvent_SourceResourceSet() {
		return (EAttribute)modelChangeEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementChangeEvent() {
		return elementChangeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueChangeEvent() {
		return attributeValueChangeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementLifeCycleEvent() {
		return elementLifeCycleEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkLifeCycleEvent() {
		return linkLifeCycleEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementCreateEvent() {
		return elementCreateEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementDeleteEvent() {
		return elementDeleteEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkCreateEvent() {
		return linkCreateEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkDeleteEvent() {
		return linkDeleteEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactory getEventsFactory() {
		return (EventsFactory)getEFactoryInstance();
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
		modelChangeEventEClass = createEClass(MODEL_CHANGE_EVENT);
		createEAttribute(modelChangeEventEClass, MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET);

		elementChangeEventEClass = createEClass(ELEMENT_CHANGE_EVENT);

		attributeValueChangeEventEClass = createEClass(ATTRIBUTE_VALUE_CHANGE_EVENT);

		elementLifeCycleEventEClass = createEClass(ELEMENT_LIFE_CYCLE_EVENT);

		linkLifeCycleEventEClass = createEClass(LINK_LIFE_CYCLE_EVENT);

		elementCreateEventEClass = createEClass(ELEMENT_CREATE_EVENT);

		elementDeleteEventEClass = createEClass(ELEMENT_DELETE_EVENT);

		linkCreateEventEClass = createEClass(LINK_CREATE_EVENT);

		linkDeleteEventEClass = createEClass(LINK_DELETE_EVENT);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		elementChangeEventEClass.getESuperTypes().add(this.getModelChangeEvent());
		attributeValueChangeEventEClass.getESuperTypes().add(this.getElementChangeEvent());
		elementLifeCycleEventEClass.getESuperTypes().add(this.getLinkLifeCycleEvent());
		linkLifeCycleEventEClass.getESuperTypes().add(this.getModelChangeEvent());
		elementCreateEventEClass.getESuperTypes().add(this.getElementLifeCycleEvent());
		elementDeleteEventEClass.getESuperTypes().add(this.getElementLifeCycleEvent());
		linkCreateEventEClass.getESuperTypes().add(this.getLinkLifeCycleEvent());
		linkDeleteEventEClass.getESuperTypes().add(this.getLinkLifeCycleEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(modelChangeEventEClass, ModelChangeEvent.class, "ModelChangeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelChangeEvent_SourceResourceSet(), ecorePackage.getEResourceSet(), "sourceResourceSet", null, 0, 1, ModelChangeEvent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementChangeEventEClass, ElementChangeEvent.class, "ElementChangeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueChangeEventEClass, AttributeValueChangeEvent.class, "AttributeValueChangeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementLifeCycleEventEClass, ElementLifeCycleEvent.class, "ElementLifeCycleEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkLifeCycleEventEClass, LinkLifeCycleEvent.class, "LinkLifeCycleEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementCreateEventEClass, ElementCreateEvent.class, "ElementCreateEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementDeleteEventEClass, ElementDeleteEvent.class, "ElementDeleteEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkCreateEventEClass, LinkCreateEvent.class, "LinkCreateEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkDeleteEventEClass, LinkDeleteEvent.class, "LinkDeleteEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EventsPackageImpl
