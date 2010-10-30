/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hpi.sam.petriNet.PetriNetFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface PetriNetPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "petriNet";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://petriNet/1.0";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "petriNet";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	PetriNetPackage eINSTANCE = de.hpi.sam.petriNet.impl.PetriNetPackageImpl.init();

	/**
     * The meta object id for the '{@link de.hpi.sam.petriNet.impl.PetriNetImpl <em>Petri Net</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hpi.sam.petriNet.impl.PetriNetImpl
     * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getPetriNet()
     * @generated
     */
	int PETRI_NET = 0;

	/**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PETRI_NET__ELEMENTS = 0;

	/**
     * The feature id for the '<em><b>Diagram Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PETRI_NET__DIAGRAM_NAME = 1;

	/**
     * The number of structural features of the '<em>Petri Net</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PETRI_NET_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link de.hpi.sam.petriNet.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hpi.sam.petriNet.impl.ElementImpl
     * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getElement()
     * @generated
     */
	int ELEMENT = 1;

	/**
     * The feature id for the '<em><b>Diagram</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT__DIAGRAM = 0;

	/**
     * The number of structural features of the '<em>Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link de.hpi.sam.petriNet.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hpi.sam.petriNet.impl.NodeImpl
     * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getNode()
     * @generated
     */
	int NODE = 5;

	/**
     * The feature id for the '<em><b>Diagram</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__DIAGRAM = ELEMENT__DIAGRAM;

	/**
     * The feature id for the '<em><b>Outgoing Arcs</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__OUTGOING_ARCS = ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Incoming Arcs</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__INCOMING_ARCS = ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link de.hpi.sam.petriNet.impl.PlaceImpl <em>Place</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hpi.sam.petriNet.impl.PlaceImpl
     * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getPlace()
     * @generated
     */
	int PLACE = 2;

	/**
     * The feature id for the '<em><b>Diagram</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLACE__DIAGRAM = NODE__DIAGRAM;

	/**
     * The feature id for the '<em><b>Outgoing Arcs</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLACE__OUTGOING_ARCS = NODE__OUTGOING_ARCS;

	/**
     * The feature id for the '<em><b>Incoming Arcs</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLACE__INCOMING_ARCS = NODE__INCOMING_ARCS;

	/**
     * The feature id for the '<em><b>No Tokens</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLACE__NO_TOKENS = NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Hidden Opposite</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE__HIDDEN_OPPOSITE = NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Place</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLACE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link de.hpi.sam.petriNet.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hpi.sam.petriNet.impl.TransitionImpl
     * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getTransition()
     * @generated
     */
	int TRANSITION = 3;

	/**
     * The feature id for the '<em><b>Diagram</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION__DIAGRAM = NODE__DIAGRAM;

	/**
     * The feature id for the '<em><b>Outgoing Arcs</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION__OUTGOING_ARCS = NODE__OUTGOING_ARCS;

	/**
     * The feature id for the '<em><b>Incoming Arcs</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION__INCOMING_ARCS = NODE__INCOMING_ARCS;

	/**
     * The number of structural features of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link de.hpi.sam.petriNet.impl.ArcImpl <em>Arc</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hpi.sam.petriNet.impl.ArcImpl
     * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getArc()
     * @generated
     */
	int ARC = 4;

	/**
     * The feature id for the '<em><b>Diagram</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ARC__DIAGRAM = ELEMENT__DIAGRAM;

	/**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ARC__SOURCE = ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ARC__TARGET = ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Arc</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ARC_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;


	/**
     * Returns the meta object for class '{@link de.hpi.sam.petriNet.PetriNet <em>Petri Net</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Petri Net</em>'.
     * @see de.hpi.sam.petriNet.PetriNet
     * @generated
     */
	EClass getPetriNet();

	/**
     * Returns the meta object for the containment reference list '{@link de.hpi.sam.petriNet.PetriNet#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see de.hpi.sam.petriNet.PetriNet#getElements()
     * @see #getPetriNet()
     * @generated
     */
	EReference getPetriNet_Elements();

	/**
     * Returns the meta object for the attribute '{@link de.hpi.sam.petriNet.PetriNet#getDiagramName <em>Diagram Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Diagram Name</em>'.
     * @see de.hpi.sam.petriNet.PetriNet#getDiagramName()
     * @see #getPetriNet()
     * @generated
     */
	EAttribute getPetriNet_DiagramName();

	/**
     * Returns the meta object for class '{@link de.hpi.sam.petriNet.Element <em>Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element</em>'.
     * @see de.hpi.sam.petriNet.Element
     * @generated
     */
	EClass getElement();

	/**
     * Returns the meta object for the container reference '{@link de.hpi.sam.petriNet.Element#getDiagram <em>Diagram</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Diagram</em>'.
     * @see de.hpi.sam.petriNet.Element#getDiagram()
     * @see #getElement()
     * @generated
     */
	EReference getElement_Diagram();

	/**
     * Returns the meta object for class '{@link de.hpi.sam.petriNet.Place <em>Place</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Place</em>'.
     * @see de.hpi.sam.petriNet.Place
     * @generated
     */
	EClass getPlace();

	/**
     * Returns the meta object for the attribute '{@link de.hpi.sam.petriNet.Place#getNoTokens <em>No Tokens</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>No Tokens</em>'.
     * @see de.hpi.sam.petriNet.Place#getNoTokens()
     * @see #getPlace()
     * @generated
     */
	EAttribute getPlace_NoTokens();

	/**
     * Returns the meta object for the reference '{@link de.hpi.sam.petriNet.Place#getHiddenOpposite <em>Hidden Opposite</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Hidden Opposite</em>'.
     * @see de.hpi.sam.petriNet.Place#getHiddenOpposite()
     * @see #getPlace()
     * @generated
     */
    EReference getPlace_HiddenOpposite();

    /**
     * Returns the meta object for class '{@link de.hpi.sam.petriNet.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition</em>'.
     * @see de.hpi.sam.petriNet.Transition
     * @generated
     */
	EClass getTransition();

	/**
     * Returns the meta object for class '{@link de.hpi.sam.petriNet.Arc <em>Arc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Arc</em>'.
     * @see de.hpi.sam.petriNet.Arc
     * @generated
     */
	EClass getArc();

	/**
     * Returns the meta object for the reference '{@link de.hpi.sam.petriNet.Arc#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see de.hpi.sam.petriNet.Arc#getSource()
     * @see #getArc()
     * @generated
     */
	EReference getArc_Source();

	/**
     * Returns the meta object for the reference '{@link de.hpi.sam.petriNet.Arc#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see de.hpi.sam.petriNet.Arc#getTarget()
     * @see #getArc()
     * @generated
     */
	EReference getArc_Target();

	/**
     * Returns the meta object for class '{@link de.hpi.sam.petriNet.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node</em>'.
     * @see de.hpi.sam.petriNet.Node
     * @generated
     */
	EClass getNode();

	/**
     * Returns the meta object for the reference '{@link de.hpi.sam.petriNet.Node#getOutgoingArcs <em>Outgoing Arcs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Outgoing Arcs</em>'.
     * @see de.hpi.sam.petriNet.Node#getOutgoingArcs()
     * @see #getNode()
     * @generated
     */
	EReference getNode_OutgoingArcs();

	/**
     * Returns the meta object for the reference '{@link de.hpi.sam.petriNet.Node#getIncomingArcs <em>Incoming Arcs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Incoming Arcs</em>'.
     * @see de.hpi.sam.petriNet.Node#getIncomingArcs()
     * @see #getNode()
     * @generated
     */
	EReference getNode_IncomingArcs();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	PetriNetFactory getPetriNetFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link de.hpi.sam.petriNet.impl.PetriNetImpl <em>Petri Net</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hpi.sam.petriNet.impl.PetriNetImpl
         * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getPetriNet()
         * @generated
         */
		EClass PETRI_NET = eINSTANCE.getPetriNet();

		/**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PETRI_NET__ELEMENTS = eINSTANCE.getPetriNet_Elements();

		/**
         * The meta object literal for the '<em><b>Diagram Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PETRI_NET__DIAGRAM_NAME = eINSTANCE.getPetriNet_DiagramName();

		/**
         * The meta object literal for the '{@link de.hpi.sam.petriNet.impl.ElementImpl <em>Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hpi.sam.petriNet.impl.ElementImpl
         * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getElement()
         * @generated
         */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
         * The meta object literal for the '<em><b>Diagram</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ELEMENT__DIAGRAM = eINSTANCE.getElement_Diagram();

		/**
         * The meta object literal for the '{@link de.hpi.sam.petriNet.impl.PlaceImpl <em>Place</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hpi.sam.petriNet.impl.PlaceImpl
         * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getPlace()
         * @generated
         */
		EClass PLACE = eINSTANCE.getPlace();

		/**
         * The meta object literal for the '<em><b>No Tokens</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PLACE__NO_TOKENS = eINSTANCE.getPlace_NoTokens();

		/**
         * The meta object literal for the '<em><b>Hidden Opposite</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PLACE__HIDDEN_OPPOSITE = eINSTANCE.getPlace_HiddenOpposite();

        /**
         * The meta object literal for the '{@link de.hpi.sam.petriNet.impl.TransitionImpl <em>Transition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hpi.sam.petriNet.impl.TransitionImpl
         * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getTransition()
         * @generated
         */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
         * The meta object literal for the '{@link de.hpi.sam.petriNet.impl.ArcImpl <em>Arc</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hpi.sam.petriNet.impl.ArcImpl
         * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getArc()
         * @generated
         */
		EClass ARC = eINSTANCE.getArc();

		/**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ARC__SOURCE = eINSTANCE.getArc_Source();

		/**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ARC__TARGET = eINSTANCE.getArc_Target();

		/**
         * The meta object literal for the '{@link de.hpi.sam.petriNet.impl.NodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hpi.sam.petriNet.impl.NodeImpl
         * @see de.hpi.sam.petriNet.impl.PetriNetPackageImpl#getNode()
         * @generated
         */
		EClass NODE = eINSTANCE.getNode();

		/**
         * The meta object literal for the '<em><b>Outgoing Arcs</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NODE__OUTGOING_ARCS = eINSTANCE.getNode_OutgoingArcs();

		/**
         * The meta object literal for the '<em><b>Incoming Arcs</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NODE__INCOMING_ARCS = eINSTANCE.getNode_IncomingArcs();

	}

} //PetriNetPackage
