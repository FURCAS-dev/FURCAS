/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet.impl;

import de.hpi.sam.petriNet.Arc;
import de.hpi.sam.petriNet.Element;
import de.hpi.sam.petriNet.Node;
import de.hpi.sam.petriNet.PetriNet;
import de.hpi.sam.petriNet.PetriNetFactory;
import de.hpi.sam.petriNet.PetriNetPackage;
import de.hpi.sam.petriNet.Place;
import de.hpi.sam.petriNet.Transition;

import de.hpi.sam.petriNet.util.PetriNetValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PetriNetPackageImpl extends EPackageImpl implements PetriNetPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass petriNetEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass elementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass placeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass transitionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass arcEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass nodeEClass = null;

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
     * @see de.hpi.sam.petriNet.PetriNetPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private PetriNetPackageImpl() {
        super(eNS_URI, PetriNetFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link PetriNetPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static PetriNetPackage init() {
        if (isInited) return (PetriNetPackage)EPackage.Registry.INSTANCE.getEPackage(PetriNetPackage.eNS_URI);

        // Obtain or create and register package
        PetriNetPackageImpl thePetriNetPackage = (PetriNetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PetriNetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PetriNetPackageImpl());

        isInited = true;

        // Create package meta-data objects
        thePetriNetPackage.createPackageContents();

        // Initialize created meta-data
        thePetriNetPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (thePetriNetPackage, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return PetriNetValidator.INSTANCE;
                 }
             });

        // Mark meta-data to indicate it can't be changed
        thePetriNetPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PetriNetPackage.eNS_URI, thePetriNetPackage);
        return thePetriNetPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPetriNet() {
        return petriNetEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPetriNet_Elements() {
        return (EReference)petriNetEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPetriNet_DiagramName() {
        return (EAttribute)petriNetEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getElement() {
        return elementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getElement_Diagram() {
        return (EReference)elementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPlace() {
        return placeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPlace_NoTokens() {
        return (EAttribute)placeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPlace_TestHiddenOpposite() {
        return (EReference)placeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTransition() {
        return transitionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getArc() {
        return arcEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getArc_Source() {
        return (EReference)arcEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getArc_Target() {
        return (EReference)arcEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNode() {
        return nodeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNode_OutgoingArcs() {
        return (EReference)nodeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNode_IncomingArcs() {
        return (EReference)nodeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PetriNetFactory getPetriNetFactory() {
        return (PetriNetFactory)getEFactoryInstance();
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
        petriNetEClass = createEClass(PETRI_NET);
        createEReference(petriNetEClass, PETRI_NET__ELEMENTS);
        createEAttribute(petriNetEClass, PETRI_NET__DIAGRAM_NAME);

        elementEClass = createEClass(ELEMENT);
        createEReference(elementEClass, ELEMENT__DIAGRAM);

        placeEClass = createEClass(PLACE);
        createEAttribute(placeEClass, PLACE__NO_TOKENS);
        createEReference(placeEClass, PLACE__TEST_HIDDEN_OPPOSITE);

        transitionEClass = createEClass(TRANSITION);

        arcEClass = createEClass(ARC);
        createEReference(arcEClass, ARC__SOURCE);
        createEReference(arcEClass, ARC__TARGET);

        nodeEClass = createEClass(NODE);
        createEReference(nodeEClass, NODE__OUTGOING_ARCS);
        createEReference(nodeEClass, NODE__INCOMING_ARCS);
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
        placeEClass.getESuperTypes().add(this.getNode());
        transitionEClass.getESuperTypes().add(this.getNode());
        arcEClass.getESuperTypes().add(this.getElement());
        nodeEClass.getESuperTypes().add(this.getElement());

        // Initialize classes and features; add operations and parameters
        initEClass(petriNetEClass, PetriNet.class, "PetriNet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPetriNet_Elements(), this.getElement(), this.getElement_Diagram(), "elements", null, 10, -1, PetriNet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPetriNet_DiagramName(), ecorePackage.getEString(), "diagramName", "Petri Net 1.0", 0, 1, PetriNet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getElement_Diagram(), this.getPetriNet(), this.getPetriNet_Elements(), "diagram", null, 1, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(placeEClass, Place.class, "Place", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPlace_NoTokens(), ecorePackage.getEInt(), "noTokens", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPlace_TestHiddenOpposite(), this.getNode(), null, "testHiddenOpposite", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(arcEClass, Arc.class, "Arc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getArc_Source(), this.getNode(), this.getNode_OutgoingArcs(), "source", null, 1, 1, Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getArc_Target(), this.getNode(), this.getNode_IncomingArcs(), "target", null, 1, 1, Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNode_OutgoingArcs(), this.getArc(), this.getArc_Source(), "outgoingArcs", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNode_IncomingArcs(), this.getArc(), this.getArc_Target(), "incomingArcs", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // http://de.hpi.sam.bp2009.OCL
        createDeAnnotations();
        // http://schema.omg.org/spec/MOF/2.0/emof.xml
        createEmofAnnotations();
    }

	/**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";		
        addAnnotation
          (this, 
           source, 
           new String[] {
             "validationDelegates", "http://de.hpi.sam.bp2009.OCL",
             "invocationDelegates", "http://de.hpi.sam.bp2009.OCL"
           });		
        addAnnotation
          (petriNetEClass, 
           source, 
           new String[] {
             "constraints", "modelName"
           });			
        addAnnotation
          (placeEClass, 
           source, 
           new String[] {
             "constraints", "numberOfTokens number"
           });		
    }

	/**
     * Initializes the annotations for <b>http://de.hpi.sam.bp2009.OCL</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createDeAnnotations() {
        String source = "http://de.hpi.sam.bp2009.OCL";				
        addAnnotation
          (petriNetEClass, 
           source, 
           new String[] {
             "modelName", "self.elements->notEmpty()"
           });			
        addAnnotation
          (placeEClass, 
           source, 
           new String[] {
             "numberOfTokens", "self.noTokens > 3",
             "number", "self.noTokens > 34"
           });	
    }

    /**
     * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEmofAnnotations() {
        String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml";							
        addAnnotation
          (getPlace_TestHiddenOpposite(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "hiddenOpposite"
           });
    }

} //PetriNetPackageImpl
