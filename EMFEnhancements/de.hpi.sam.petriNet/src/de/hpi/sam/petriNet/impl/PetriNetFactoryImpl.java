/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet.impl;

import de.hpi.sam.petriNet.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PetriNetFactoryImpl extends EFactoryImpl implements PetriNetFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PetriNetFactory init() {
        try {
            PetriNetFactory thePetriNetFactory = (PetriNetFactory)EPackage.Registry.INSTANCE.getEFactory("http://petriNet/1.0"); 
            if (thePetriNetFactory != null) {
                return thePetriNetFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PetriNetFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PetriNetFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case PetriNetPackage.PETRI_NET: return createPetriNet();
            case PetriNetPackage.PLACE: return createPlace();
            case PetriNetPackage.TRANSITION: return createTransition();
            case PetriNetPackage.ARC: return createArc();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PetriNet createPetriNet() {
        PetriNetImpl petriNet = new PetriNetImpl();
        return petriNet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Place createPlace() {
        PlaceImpl place = new PlaceImpl();
        return place;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Transition createTransition() {
        TransitionImpl transition = new TransitionImpl();
        return transition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Arc createArc() {
        ArcImpl arc = new ArcImpl();
        return arc;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PetriNetPackage getPetriNetPackage() {
        return (PetriNetPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static PetriNetPackage getPackage() {
        return PetriNetPackage.eINSTANCE;
    }

} //PetriNetFactoryImpl
