/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package usecase;

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
 * @see usecase.UsecaseFactory
 * @model kind="package"
 * @generated
 */
public interface UsecasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "usecase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://usecase/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "usecase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsecasePackage eINSTANCE = usecase.impl.UsecasePackageImpl.init();

	/**
	 * The meta object id for the '{@link usecase.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.ElementImpl
	 * @see usecase.impl.UsecasePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 4;

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
	 * The meta object id for the '{@link usecase.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.ActorImpl
	 * @see usecase.impl.UsecasePackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DIAGRAM = ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__OUTGOING = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link usecase.impl.UsecaseImpl <em>Usecase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.UsecaseImpl
	 * @see usecase.impl.UsecasePackageImpl#getUsecase()
	 * @generated
	 */
	int USECASE = 1;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__DIAGRAM = ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__INCOMING = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__EXTEND = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__INCLUDE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__ID = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Usecase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link usecase.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.AssociationImpl
	 * @see usecase.impl.UsecasePackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 2;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DIAGRAM = ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ACTORS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usecase</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__USECASE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link usecase.impl.UsecaseDiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.UsecaseDiagramImpl
	 * @see usecase.impl.UsecasePackageImpl#getUsecaseDiagram()
	 * @generated
	 */
	int USECASE_DIAGRAM = 3;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE_DIAGRAM__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE_DIAGRAM_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link usecase.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see usecase.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link usecase.Actor#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see usecase.Actor#getOutgoing()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Outgoing();

	/**
	 * Returns the meta object for class '{@link usecase.Usecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usecase</em>'.
	 * @see usecase.Usecase
	 * @generated
	 */
	EClass getUsecase();

	/**
	 * Returns the meta object for the reference '{@link usecase.Usecase#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see usecase.Usecase#getIncoming()
	 * @see #getUsecase()
	 * @generated
	 */
	EReference getUsecase_Incoming();

	/**
	 * Returns the meta object for the reference '{@link usecase.Usecase#getExtend <em>Extend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extend</em>'.
	 * @see usecase.Usecase#getExtend()
	 * @see #getUsecase()
	 * @generated
	 */
	EReference getUsecase_Extend();

	/**
	 * Returns the meta object for the reference '{@link usecase.Usecase#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Include</em>'.
	 * @see usecase.Usecase#getInclude()
	 * @see #getUsecase()
	 * @generated
	 */
	EReference getUsecase_Include();

	/**
	 * Returns the meta object for the attribute '{@link usecase.Usecase#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see usecase.Usecase#getID()
	 * @see #getUsecase()
	 * @generated
	 */
	EAttribute getUsecase_ID();

	/**
	 * Returns the meta object for class '{@link usecase.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see usecase.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference list '{@link usecase.Association#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see usecase.Association#getActors()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Actors();

	/**
	 * Returns the meta object for the reference list '{@link usecase.Association#getUsecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Usecase</em>'.
	 * @see usecase.Association#getUsecase()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Usecase();

	/**
	 * Returns the meta object for class '{@link usecase.UsecaseDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see usecase.UsecaseDiagram
	 * @generated
	 */
	EClass getUsecaseDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link usecase.UsecaseDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see usecase.UsecaseDiagram#getElements()
	 * @see #getUsecaseDiagram()
	 * @generated
	 */
	EReference getUsecaseDiagram_Elements();

	/**
	 * Returns the meta object for class '{@link usecase.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see usecase.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the container reference '{@link usecase.Element#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Diagram</em>'.
	 * @see usecase.Element#getDiagram()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Diagram();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsecaseFactory getUsecaseFactory();

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
		 * The meta object literal for the '{@link usecase.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.ActorImpl
		 * @see usecase.impl.UsecasePackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__OUTGOING = eINSTANCE.getActor_Outgoing();

		/**
		 * The meta object literal for the '{@link usecase.impl.UsecaseImpl <em>Usecase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.UsecaseImpl
		 * @see usecase.impl.UsecasePackageImpl#getUsecase()
		 * @generated
		 */
		EClass USECASE = eINSTANCE.getUsecase();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USECASE__INCOMING = eINSTANCE.getUsecase_Incoming();

		/**
		 * The meta object literal for the '<em><b>Extend</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USECASE__EXTEND = eINSTANCE.getUsecase_Extend();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USECASE__INCLUDE = eINSTANCE.getUsecase_Include();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USECASE__ID = eINSTANCE.getUsecase_ID();

		/**
		 * The meta object literal for the '{@link usecase.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.AssociationImpl
		 * @see usecase.impl.UsecasePackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__ACTORS = eINSTANCE.getAssociation_Actors();

		/**
		 * The meta object literal for the '<em><b>Usecase</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__USECASE = eINSTANCE.getAssociation_Usecase();

		/**
		 * The meta object literal for the '{@link usecase.impl.UsecaseDiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.UsecaseDiagramImpl
		 * @see usecase.impl.UsecasePackageImpl#getUsecaseDiagram()
		 * @generated
		 */
		EClass USECASE_DIAGRAM = eINSTANCE.getUsecaseDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USECASE_DIAGRAM__ELEMENTS = eINSTANCE.getUsecaseDiagram_Elements();

		/**
		 * The meta object literal for the '{@link usecase.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.ElementImpl
		 * @see usecase.impl.UsecasePackageImpl#getElement()
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

	}

} //UsecasePackage
