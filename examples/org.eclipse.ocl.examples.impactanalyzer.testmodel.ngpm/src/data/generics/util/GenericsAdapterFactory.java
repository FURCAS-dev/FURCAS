/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsAdapterFactory.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.generics.util;

import behavioral.events.EventProducer;

import data.classes.SapClass;
import data.classes.SignatureOwner;

import data.generics.*;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see data.generics.GenericsPackage
 * @generated
 */
public class GenericsAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static GenericsPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GenericsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = GenericsPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected GenericsSwitch<Adapter> modelSwitch =
		new GenericsSwitch<Adapter>() {
            @Override
            public Adapter caseFormalTypeParameter(FormalTypeParameter object) {
                return createFormalTypeParameterAdapter();
            }
            @Override
            public Adapter caseParameterizedClassInstantiation(ParameterizedClassInstantiation object) {
                return createParameterizedClassInstantiationAdapter();
            }
            @Override
            public Adapter caseClassParameterization(ClassParameterization object) {
                return createClassParameterizationAdapter();
            }
            @Override
            public Adapter caseActualTypeParameter(ActualTypeParameter object) {
                return createActualTypeParameterAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseSignatureOwner(SignatureOwner object) {
                return createSignatureOwnerAdapter();
            }
            @Override
            public Adapter caseEventProducer(EventProducer object) {
                return createEventProducerAdapter();
            }
            @Override
            public Adapter caseSapClass(SapClass object) {
                return createSapClassAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link data.generics.FormalTypeParameter <em>Formal Type Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.generics.FormalTypeParameter
     * @generated
     */
	public Adapter createFormalTypeParameterAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.generics.ParameterizedClassInstantiation <em>Parameterized Class Instantiation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.generics.ParameterizedClassInstantiation
     * @generated
     */
	public Adapter createParameterizedClassInstantiationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.generics.ClassParameterization <em>Class Parameterization</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.generics.ClassParameterization
     * @generated
     */
	public Adapter createClassParameterizationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.generics.ActualTypeParameter <em>Actual Type Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.generics.ActualTypeParameter
     * @generated
     */
	public Adapter createActualTypeParameterAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link modelmanagement.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see modelmanagement.NamedElement
     * @generated
     */
	public Adapter createNamedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.SignatureOwner <em>Signature Owner</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.SignatureOwner
     * @generated
     */
	public Adapter createSignatureOwnerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.events.EventProducer <em>Event Producer</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.events.EventProducer
     * @generated
     */
	public Adapter createEventProducerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.SapClass <em>Sap Class</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.SapClass
     * @generated
     */
	public Adapter createSapClassAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //GenericsAdapterFactory
